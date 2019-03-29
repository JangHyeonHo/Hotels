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
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<title>식사여부</title>

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
<link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung|Stylish" rel="stylesheet">

<link href="<c:url value="/css/backHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/backFooter.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/breakfastDetail_content.css" />" rel="stylesheet" type="text/css">

</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../backHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id="contents">
	<h2>조식 상세정보</h2>
	
	<form:form>
	<fieldset>
	<legend>${bf.guestRoom.grNo }호 조식 등록</legend>>
	<div class = "infobox">수속 번호 : ${bf.guestRoom.checkIn.cheNo } </div>
	<div class = "infobox">고객 성/이름 : ${bf.guestRoom.checkIn.customer.cosLName} ${groom.checkIn.customer.cosFName} </div>
	<div class = "infobox">고객 번호: ${bf.guestRoom.checkIn.customer.cosTelno } </div>
	<div class = "infobox">객실 번호 : ${bf.guestRoom.grNo } </div>
	<div class = "infobox">숙박 인원 : <span class = "backg">　${bf.guestRoom.grStaySum }　</span></div>
 	<input type="hidden" name="guestRoom.grNo" value="${bf.guestRoom.grNo }">
 	<input type="hidden" name="guestRoom.checkIn.cheNo" value="${bf.guestRoom.checkIn.cheNo }">
	<div class = "infobox">조식 종류 : <input type = "text" name = "breakKind"></div>
	<div class = "infobox">성인 : <input type = "text" name = "breakAdult"></div>
	<div class = "infobox">어린이 : <input type = "text" name = "breakChild"></div>
	
	</fieldset>
	<input type="submit" value = "등록" class = "btn btn-outline-danger btn-b">
	<input type = "button" onclick="history.back(-1)" value = "뒤로가기" class = "btn btn-primary btn">
	
	
	</form:form>

	</div>
	<jsp:include page="../backFooter.jsp" />
</body>
</html>