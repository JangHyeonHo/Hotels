<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<title>레스토랑 예약 고객정보</title>

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
<script src="<c:url value="/js/cusPageHeader.js"></c:url>" ></script>
<script src="<c:url value="/js/restaurantReservation.js"></c:url>" ></script>
<link href="<c:url value="/css/cusPageHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/cusPageFooter.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/restaurantReservation.css" />" rel="stylesheet" type="text/css">





</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../cusPageHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id="contents">

		<div id="maincontens">
		<div id="reservationbox">
		
			<form:form id="frm">

			<h1>STEP 1 .예약자 정보 입력</h1>
				<ul>
					<li><span class="fontsizeclass">성</span><br> <input type="text" name="customer.cosLName"
						id="ln" class="inputs"></li>
					<li><span class="fontsizeclass">이름</span><br> <input type="text" name="customer.cosFName"
						id="nl" class="inputs"></li>
					<li><span class="fontsizeclass">전화번호</span><br> <input type="text" name="customer.cosTelno"
						id="ph" class="inputs"></li>
					<li><span class="fontsizeclass">이메일 주소</span><br> <input type="email"
						name="customer.cosEmail" id="em" class="inputs"></li>
					<li><span class="fontsizeclass">알러지 유무</span><br> <select name="Allergy" id="al"
						onclick="exist()">
							<option value="N">N</option>
							<option value="Y">Y</option>
					</select> <input type="text" name="customeral" id="albox" class="inputs"
						style="display: none;" placeholder="알러지 상세">
						<div id="hiddenBox"></div></li>
				</ul>
				
				<div id="btnbox">
					<button type="button" id="submitBtn" class="btn btn-secondary">다음</button>
				</div>
				
			</form:form>
			</div>
			<div id="infobox"><div id="infofont">레스토랑 예약</div></div>
		</div>
		
	</div>
	<jsp:include page="../cusPageFooter.jsp" />
</body>
</html>