<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<title><spring:message code="food.regist" /></title>

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
<script>
	$(function() {
		$("#matRegBtn").on("click", function() {
			window.open("http://localhost/peregrine/comp/fb/restaurant/food/searchMaterial","음식 등록", "height=400px, width=300px, resizable=no, scrollbars=no",true)
		})
	})
</script>

</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id="contents">
		<h1>
			<spring:message code="food.regist" />
		</h1>
		<form:form enctype="multipart/form-data">
			<spring:message code="food.name" />
			<input type="text" name = "food.foodName">
			<br>
			<spring:message code="food.price" />
			<input type="number" name = "food.foodPrice">
			<br>
			<spring:message code="food.recipe" />
			<textarea name = "food.foodRecipe"></textarea>
			<br>
			<spring:message code="food.kind" />
			<select name = "food.foodKind">
				<c:forEach begin="1" end="7" step="1" var="i">
				<option value="<spring:message code="food.ki${i }"/>"><spring:message
						code="food.ki${i }" /></option>
				</c:forEach>
			</select>
			<br>
			<spring:message code="food.image" /> 등록
			<input type="file" name = "foodImage">
			<br>
			<input type="button" value="<spring:message code="food.material"/>"
				id="matRegBtn"><br>
			<div id = "resultBox"></div>	
			
			<input type="submit" value="<spring:message code="regist"/>">
			<input type="button" value="<spring:message code="back"/>" onclick="location.href='../food'">
		</form:form>
	</div>
	<footer></footer>
</body>
</html>