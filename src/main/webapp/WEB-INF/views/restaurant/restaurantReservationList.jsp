<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<title>레스토랑 예약자 명단</title>
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro" rel="stylesheet">
<!-- 미 변경 목록(JQuery설정, BootStrap설정) -->
<!-- JQuery -->
<script src="http://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<!-- JQuery UI -->
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<!-- BootStrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- BootStrap -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- 사용자 임의 JS, CSS설정 위치는 알아서 조정 -->

<link href="<c:url value="/resources/css/backHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/backFooter.css" />" rel="stylesheet" type="text/css">
<style>
#contents {
	width: 1080px;
	min-height:700px;
	margin:0 auto;
	

}

#maincontent {
	width: 1080px;
	min-height: 400px;
	float: left;
	
	
}


</style>
<script type="text/javascript">
$(function(){
	$(".ltep").hover(function(){
		$(".frontmenu").css("display","block");
	});
	$(".ltep").mouseleave(function(){
		$(".frontmenu").css("display","none");
	});
	
});

</script>
<style>

td, th{
text-align:center;
}

</style>

</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../backHeader.jsp"/>
	<!-- 실제 작성 구간 -->
	<div id="contents">
		<div id="maincontent">
			<h1 style="text-align:center">레스토랑 예약자 명단</h1>
			<table class="table thead-dark">
			<tr>
			<th>예약번호</th>
			<th>성명</th>
			<th>전화번호</th>
			<th>이메일</th>
			</tr>
			<c:forEach items="${list }" var="reslist">
			<tr>
			<td><a href=list/detail?rrno=${reslist.rrNo}>${reslist.rrNo }</a> </td>
			<td> ${reslist.customer. cosLName} ${reslist.customer. cosFName } </td>
			<td> ${reslist.customer. cosTelno } </td>
			<td> ${reslist.customer.cosEmail } </td>
			</tr>
			</c:forEach>
		
		</table>
	<br>
			
		
		</div>
	<div id="paging" style="text-align:center">
				<c:set var="page" value="${paging.page}" />
				<c:if test="${paging.prev}">
					<a href="?page=1">◀◀</a>
					<a href="?page=${paging.startPage-1}">◀</a>
				</c:if>
				<c:forEach step="1" begin="${paging.startPage}"
					end="${paging.endPage}" var="i">
					<c:if test="${i == page}">
						<a style="font-weight: bold">${i}</a>
					</c:if>
					<c:if test="${i != page}">
						<a href="?page=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${paging.next}">
					<a href="?page=${paging.endPage+1}">▶</a>
					<a href="?page=${paging.maxPage}">▶▶</a>
				</c:if>
			</div>
	</div>
	<jsp:include page="../backFooter.jsp"/>
</body>
</html>