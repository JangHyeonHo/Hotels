<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*, com.hotels.peregrine.model.*"%>

<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<title>연회장 예약</title>

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
	<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<!-- 사용자 임의 JS, CSS설정 위치는 알아서 조정 -->
<script src="<c:url value="/js/backHeader.js"></c:url>" ></script>
<link href="<c:url value="/css/backHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/backFooter.css" />" rel="stylesheet" type="text/css">
<style>

#contents {
	width: 1080px;
	min-height: 700px;
	margin: 0 auto;
}

#maincontens {
	width: 1080px;
	min-height: 400px;
	float: left;
}

.fontsizeclass {
	font-size: 25px;
}

h1 {
	list-style: none;
	font-family: 'Noto Sans KR', sans-serif;
	color: #666;
	font-weight: 400;
}
.inputs {
	width: 150px;
	height: 30px;
	background-color: #f5f5f5;
	border: 1px solid #f5f5f5;
	border-radius: 10px;
}



</style>
</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../backHeader.jsp" />
	<!-- 실제 작성 구간 -->

	<div id="contents">
	<div id="maincontens">
		<form:form>
		<h1>연회장 예약</h1>
			<ul>
				<li><span class="fontsizeclass">연회장명</span><select name="banquet.banName" class="inputs">
						<c:forEach items="${name}" var="ban">
							<option value="${ban }">${ban }</option>
						</c:forEach>
				</select></br></li>
				<li><span class="fontsizeclass">이용 고객수</span><br> <input type="text" name="brConsumer" class="inputs"></li>
				<li><span class="fontsizeclass">이용 날짜</span><br> <input type="date" name="brUseTime" class="inputs"></li>
				<li><span class="fontsizeclass">이용 목적</span><br> <input type="text" name="brPurpose" class="inputs"></li>
				<li><span class="fontsizeclass">이용 금액</span><br> <input type="text" name="brPrice" class="inputs"></li>
				<li><span class="fontsizeclass">식사 여부</span><br> <select name="brEating">
						<option value="유">유</option>
						<option value="무">무</option>
				</select></br></li>
				<li>대여 시간 <input type="text" name="brRantalTime" class="inputs">시간</br></li>
			</ul>








			<input type="submit" value="등록">
			<button type="button" onclick="location.href='list'">리스트로</button>
		</form:form>
		</div>
		</div>
	</div>

	<jsp:include page="../backFooter.jsp" />
</body>
</html>