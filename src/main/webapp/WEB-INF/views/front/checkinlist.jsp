<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" >
<title>체크인 객실 조회</title>

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
<link href="<c:url value="/css/checkinlist_content.css" />" rel="stylesheet" type="text/css">

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../backHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id = "contents">

	<div id = "cheIn">
	<div id = "title">
	<h2>User Room Information</h2>
	</div>
	<table class="table table-hover">
	<tr>
	<th>수속 번호</th>
	<th>고객 성/이름</th>
	<th>고객 전화번호</th>
	<th>객실 번호</th>
	<th>객실명</th>
	<th>숙박 인원</th>
	<th>체크인 날짜</th>
	<th>체크아웃 예정일</th>
	<th>석식 성인/어린이 인원</th>
	<th></th>
	</tr>
	
	<c:if test="${!empty list }">
	
	
	<c:forEach items="${list }" var = "roomlist">
<form:form>
	<tr>
	<td>${roomlist.checkIn.cheNo }</td>
	<td>${roomlist.checkIn.customer.cosLName } ${roomlist.checkIn.customer.cosFName }</td>
	<td>${roomlist.checkIn.customer.cosTelno }</td>
	<td><a href = "rooms/detail?grNo=${roomlist.grNo }">${roomlist.grNo }</a>호</td>
	<td>${roomlist.checkIn.room.roomName }</td>
	<td>${roomlist.grStaySum } 명</td>
	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${roomlist.checkIn.cheInTime }"/></td>
	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${roomlist.checkIn.cheOutDate }"/></td>
	<td>석식성인${roomlist.grDiAdult }명/석식어린이${roomlist.grDiChild }명</td>
	<td><a href = "./rooms/checkout?cheNo=${roomlist.checkIn.cheNo }"><span class = "danger">체크아웃</span></a></td>
	</tr>
	</form:form>
	</c:forEach>
	
	</c:if>

	
	</table>
	
		<c:if test="${empty list }">
	<div id = "noninfo">사용중인 객실이 없습니다. </div>
	</c:if>
	<div id = "paging">
		<c:set var="page" value="${paging.page}"/>
			<c:if test="${paging.prev}"><a href="?page=1">[맨앞으로]</a><a href="?page=${paging.startPage-1}">[이전]</a></c:if>
			<c:forEach step="1" begin="${paging.startPage}" end="${paging.endPage}" var="i">
				<c:if test="${i == page}">
				<a style = "font-weight : bold">${i}</a>
				</c:if>
				<c:if test="${i != page}">
				<a href="?page=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<c:if test="${paging.next}"><a href="?page=${paging.endPage+1}">[다음]</a><a href="?page=${paging.maxPage}">[맨뒤로]</a></c:if>
		</div>
	<div id = "btn">
	<input type = "button" id = "mainBtn" onclick="location.href='../front'" class = "btn btn-primary btn" value = "메인으로">
	</div>
	</div>
	</div>
	<jsp:include page="../backFooter.jsp" />
</body>
</html>