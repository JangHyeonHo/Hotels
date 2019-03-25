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
<title><spring:message code="food.material" /></title>

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
	$(function(){
		$("#subBtn").on("click",function(){
			var query = $("#query").val()
			$.ajax({
				url:"http://localhost/peregrine/comp/fb/restaurant/food/searchMaterial",
				method:'post',
				data:"query=" + query,
				dataType:'html',
				success:function(data){
					$("#resultList").html(data);
				}
			})
		})
		
	})
	function regist(no){
		var baseHtml = $("#resultBox",parent.opener.document).html();
		var matName = $("#nameVal"+no).text();
		var regNo = $(".seaNo",parent.opener.document).last().attr('id');
		var errorCode = true;
		var regNameTest = $(".matName",parent.opener.document).each(function(){
			var thisText = $(this).text();
			if(thisText == matName){
				alert('이미 등록중인 식자재입니다!');
				errorCode = false;
			}
		});
		console.log(errorCode);
		if(!errorCode){
			return false;
		}
		if(regNo==null){
			regNo = 1;
		} else{
			regNo = regNo.substring(9);
			regNo++;
		}
		var innerHtml = "<div class = 'matList'><input type = 'hidden' name = 'materialNo' value='"+no+"'>"
		innerHtml+= "<div class = 'seaNo' id = 'matNameNo"+regNo+"'>"+regNo+"</div>"
		innerHtml+= "<div class = 'matName'>"+matName+"</div>"
		innerHtml+= "<div class = 'matCheck'><input type = 'button' value ='삭제' onclick='deleteMat("+no+")'></div></div>"
		baseHtml += innerHtml;
		$("#resultBox",parent.opener.document).html(baseHtml);
		self.close()
	}

</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
		<h4><spring:message code="food.mat.search" /></h4>
		<input type="text" name = "query" id="query">
		<input type="button" value="<spring:message code="search" />" id="subBtn">
		<div id ="resultList">
		<c:if test="${empty list }">
			<spring:message code="search.nothing" />
		</c:if>
		<c:if test="${!empty list }">
			<table>
				<tr>
					<th><spring:message code="mat.no" /></th>
					<th><spring:message code="mat.name" /></th>
					<th><spring:message code="regist" /></th>
				</tr>
				<c:forEach items="${list}" var="material">
				<tr>
					<td>${material.matNo }</td>
					<td id = "nameVal${material.matNo }">${material.matName }</td>
					<td><input type="button" onclick="regist(${material.matNo})" value="<spring:message code="regist"/>"></td>
				</tr>
				</c:forEach>
			</table>
		</c:if>
		</div>
	</div>
	<footer></footer>
</body>
</html>