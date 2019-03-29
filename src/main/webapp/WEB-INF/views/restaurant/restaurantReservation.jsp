<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<title>레스토랑 예약</title>

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
<!-- 사용자 임의 JS, CSS설정 위치는 알아서 조정 -->
<script type="text/javascript">
	$(function() {

		$("#rrTime")
				.on(
						"change",
						function() {
							var rn = $("#rrn").val();
							var date = $("#rrDate").val();
							var time = $("#rrTime").val();

							var dateTime = date + " " + time

							console.log(rn);
							$
									.ajax({
										url : "table",
										method : 'get',
										data : "resname=" + rn + "&datetime="
												+ dateTime,
										dataType : 'html',
										success : function(data) {
											$("#tablecount").html(data);
											
										}
									})
						})
		$("#subBtn")
				.on(
						"click",
						function() {
							var date = $("#rrDate").val();
							var time = $("#rrTime").val();
							console.log(date + time);
							var hiddenText = "<input type = 'hidden' name ='rrDate' value = '"+date+" "+time+"'>"
							$("#hb").html(hiddenText);
							alert("예약이 완료되었습니다.")
						})

	});
</script>
</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<!-- 실제 작성 구간 -->
	<div id="contents">
		<div id="maincontents">
			<h1>STEP 2 .레스토랑 예약</h1>
			<form:form>

				<ul>
					<li>레스토랑 명 <br><select name="restaurant.resName" id="rrn" class="inputs">
							<c:forEach items="${resinfo }" var="rlist">
								<option value="${rlist.resName }">${rlist.resName }</option>

							</c:forEach>
					</select></li>
					<li>성인 수<br>
					<input type="text" name="rrAdult" class="inputs"></li>
					<li>어린이 수<br>
					<input type="text" name="rrChild" class="inputs"></li>
					<li>예약날짜선택<br>
					<input type="date" id="rrDate" class="inputs"></li>
					<li>방문시간선택<br>
					<select id="rrTime" class="inputs">
							<option value="11:00">11:00</option>
							<option value="13:00">13:00</option>
							<option value="17:00">17:00</option>
							<option value="19:00">19:00</option>
					</select></li>
					<li>남은 테이블<br>
						<div id="tablecount"></div></li>
					<li><div id="hb"></div></li>
				</ul>

				<div id="btnbox"><input type="submit" value="예약" id="subBtn" class="btn btn-secondary"></div>
				<br>
			</form:form>
		</div>
	</div>
	<footer></footer>
</body>
</html>