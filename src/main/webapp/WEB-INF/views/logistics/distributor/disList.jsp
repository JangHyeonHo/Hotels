<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" >
<title>유통업체 리스트</title>

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
<link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung|Stylish" rel="stylesheet">
<script src="<c:url value="/js/backHeader.js"></c:url>" ></script>
<link href="<c:url value="/css/backHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/backFooter.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/disList_content.css" />" rel="stylesheet" type="text/css">
<script>
	$(function(){
		$("#contBtn").on("click",function(){
			var no = $("input:radio[name = 'disNo']:checked").val();
			console.log(no);
			if(no == null){
				alert("계약할 유통업체를 선택하여 주십시오")
				return false;
			} else{
				location.href="./contract/regist?disNo="+no;
			}
		})
	})

</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../../backHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id = "contents">

	<div id = "con">
		<div id = "title">
	<h2>유통업체 리스트</h2>
	</div>
	
	<c:if test="${!empty distributorList}">
		<table class = "table table-hover">
			<tr>
				<th class = "no"><spring:message code="dis.no" /></th>
				<th class = "name"><spring:message code="dis.name" /></th>
				<th class = "phone"><spring:message code="dis.phone" /></th>
				<th class = "zipcode"><spring:message code="dis.zipcode" /></th>
				<th class = "address"><spring:message code="dis.address" /></th>
				<th class = "regdate"><spring:message code="dis.regdate" /></th>
				<th class = "checkbox"><spring:message code="radio" /></th>
			</tr>
			<c:forEach items="${distributorList }" var="dis">
				<tr>
					<td class = "no">${dis.disNo}</td>
					<td class = "name">${dis.disName}</td>
					<td class = "phone">${dis.disPhone}</td>
					<td class = "zipcode">${dis.disZipCode}/${dis.disNZipCode}</td>
					<td class = "address">${dis.disAddr}<br>${dis.disNAddr}</td>
					<td class = "regdate"><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${dis.disRegDate}"/></td>
					<td class = "checkbox"><input type = "radio" name = "disNo" value = "${dis.disNo}"></td>
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
		<input type = "button" class="btn btn-danger btn-a" value = "<spring:message code="dist.oneRegist" />" id ="oneRegBtn">
		<input type = "button" class="btn btn-danger btn-a" value = "<spring:message code="cont.regist" />" id = "contBtn">
		<input type = "button" class = "btn btn-primary btn btn-a" value = "<spring:message code="cont.list" />" onclick = "location.href = './contract'">
	</c:if>
	<c:if test="${empty distributorList}">
		<spring:message code="dis.nothing" /><br>
		<input type = "button" class="btn btn-danger btn-a" value = "<spring:message code="dist.regist" />" onclick = "location.href = './distributor/regist'">
	</c:if>
	<input type = "button" class = "btn btn-primary btn btn-a" value="<spring:message code="back" />" onclick = "location.href = '../logistics'"/>
	</div>
	</div>
	<jsp:include page="../../backFooter.jsp" />
</body>
</html>