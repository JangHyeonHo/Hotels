<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" >
<title><spring:message code="food.list"/></title>

<!-- 미 변경 목록(JQuery설정, BootStrap설정) -->
<!-- JQuery -->
<script
  src="http://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<!-- JQuery UI -->
<script
  src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"
  integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
  crossorigin="anonymous"></script>
<!-- BootStrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- BootStrap -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!-- 사용자 임의 JS, CSS설정 위치는 알아서 조정 -->

<script>
	function MenuChange(no){
		var foodNo = no;
		var thisEle = $(this);
		var foodName = $("#name"+no).text();
		$.ajax({
			url:"http://localhost/peregrine/comp/fb/restaurant/food/change",
			method:'get',
			data:"foodNo=" + foodNo,
			dataType:'text',
			success:function(data){
				$("#reg"+no).html(data);
				if(data == "등록중"){
					alert('음식 '+ foodName +'이 메뉴에 등록되었습니다.');
				} else{
					alert('음식 '+ foodName +'이 메뉴 등록이 취소되었습니다.')
				}
				
			}
		})
		
		
	}
	function deleteFood(no){
		var foodName = $("#name"+no).text();
		if(!confirm("삭제하시면 다시 되돌릴 수 없습니다\n정말로 "+foodName+"을 삭제하시겠습니까?")){
			return false;
		}
		location.href='./food/delete?foodNo='+ no
	}
</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
		<h3><spring:message code="food.list"/></h3>
		<c:if test="${!empty foodList }">
		<table>
			<tr>
				<th><spring:message code="food.no" /></th>
				<th><spring:message code="food.image" /></th>
				<th><spring:message code="food.name" /></th>
				<th><spring:message code="food.price" /></th>
				<th><spring:message code="food.kind" /></th>
				<th><spring:message code="food.regist" /></th>
				<th colspan="2"><spring:message code="button" /></th>
			</tr>
			<c:forEach items="${foodList}" var="food">
			<tr>
				<td>${food.foodNo}</td>
				<td>
				<c:if test="${!empty food.foodStoreFileName }">
				<img alt="${food.foodOriFileName}" src='<c:url value="${directory}${food.foodStoreFileName}" />'>
				</c:if>
				<c:if test="${empty food.foodStoreFileName }">
				<p class="nothingPicture"><spring:message code="image.nothing" /></p>
				</c:if>
				</td>
				<td id ="name${food.foodNo}">${food.foodName}</td>
				<td>${food.foodPrice}</td>
				<td>${food.foodKind}</td>
				<td id ="reg${food.foodNo}">${food.foodRegist}</td>
				<td><input type="button" id="foodNo" value="<spring:message code="regist" />" onclick="MenuChange(${food.foodNo})"></td>
				<td><input type="button" value="<spring:message code="delete" />" onclick="deleteFood(${food.foodNo})"></td>
			</tr>
			</c:forEach>
		</table>
		<div id = "paging">
		<c:set var="page" value="${paging.page}"/>
			<c:if test="${paging.prev}"><a href="?page=1">◀◀</a><a href="?page=${paging.startPage-1}">◀</a></c:if>
			<c:forEach step="1" begin="${paging.startPage}" end="${paging.endPage}" var="i">
				<c:if test="${i == page}">
				<a style = "font-weight : bold">${i}</a>
				</c:if>
				<c:if test="${i != page}">
				<a href="?page=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<c:if test="${paging.next}"><a href="?page=${paging.endPage+1}">▶</a><a href="?page=${paging.maxPage}">▶▶</a></c:if>
		</div>
		</c:if>
		<c:if test="${empty foodList }"><spring:message code="food.nothing" /></c:if>
			<input type="button" value="<spring:message code="food.regist" />" onclick="location.href='./food/regist'">
	</div>
	<footer></footer>
</body>
</html>