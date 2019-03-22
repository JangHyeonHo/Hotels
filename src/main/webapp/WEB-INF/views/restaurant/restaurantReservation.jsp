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
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" >
<title>레스토랑 예약</title>

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
</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header><h1>레스토랑 예약</h1></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<form:form>
	
	<input type="hidden" name ="customer.cosLName" value="${ses.customer.cosLName }">
	<input type="hidden" name ="customer.cosFName" value="${ses.customer.cosFName }">
	<input type="hidden" name ="customer.cosTelno" value="${ses.customer.cosTelno }">
	<input type="hidden" name ="customer.cosEmail" value="${ses.customer.cosEmail }">
	<input type="hidden" name ="customer.cosAllergy" value="${ses.customer.cosAllergy }">
<%-- 	<input type="hidden" name="customer.cosNo" value="${cosone.customer.cosNo }"> --%>
	${ses.customer.cosLName }
	${ses.customer.cosFName }<br>
	레스토랑 명 :<select name="restaurant.resName">
	<c:forEach items="${resinfo }" var="rlist">
	<option value="${rlist.restaurant.resName }">${rlist.restaurant.resName }</option>
	
	</c:forEach>
	</select><br>
	남은 좌석:
	
	<c:forEach items="${resinfo }" var="rlist">

	<input type="hidden" name="restaurant.resChair" value="${rlist.restaurant.resChair }"> ${rlist.restaurant.resChair }

	</c:forEach><br>
	
	성인 수:<input type="text" name="rrAdult"><br>
	어린이 수:<input type="text" name="rrChild"><br>
	<input type="submit" value="예약"><br>
	</form:form>
	</div>
	<footer></footer>
</body>
</html>