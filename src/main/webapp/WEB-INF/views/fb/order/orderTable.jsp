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
<title><spring:message code="order.table" /></title>

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
<style>
	#contents{
		min-width: 960px;
	}
	.tableBox{
		width : 20%;
		height : 180px;
		border: 1px solid black;
		float:left;
	}
</style>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<h3><spring:message code="order.table" /></h3>
	<c:forEach begin="1" end="44" step="1" var="i">
	<div class="tableBox">
		<div class = "tableNo"><spring:message code="number" /> : ${i }</div>
		<div class = "tableChairs"><spring:message code="table.chairNum" /> : 
		<c:if test="${i<6 }">6</c:if>
		<c:if test="${i>5 and i<33 }">4</c:if>
		<c:if test="${i>32 and i<45 }">2</c:if>
		</div>
		<div class = "money"><spring:message code="money" /> : 
		<c:if test="${empty list}">0</c:if>
		<c:set var="loop_done" value="false" />
		<c:forEach items="${list}" var="li" varStatus="cnt">
			<c:if test="${not loop_done }">
				<c:if test="${li.ordTableNum eq i }">
					${li.ordSumPrice}
					<c:set var="loop_done" value="true" />
				</c:if>
				<c:if test="${li.ordTableNum ne i }">
					<c:if test="${cnt.last}">
						0
						<c:set var="loop_done" value="true" />
					</c:if>
				</c:if>
			</c:if>
		</c:forEach>
		</div>
		<div class = "tableOrderCall"><input type = "button" value="<spring:message code="order" />" onclick = "location.href='./regist?table=${i }'"></div>
		<div class = "tableOrderList"><input type = "button" value="<spring:message code="order.list" /> 보기" onclick = "location.href='./list?table=${i }'"></div>
		<div class = "tablePayMent"><input type = "button" value="<spring:message code="payment" /> 하기" onclick = "location.href='./table/payment?table=${i }'"></div>
	</div>
	</c:forEach>
	<div><input type = "button" value="<spring:message code="back" />" onclick="location.href='../order'"></div>
	</div>
	<footer></footer>
</body>
</html>