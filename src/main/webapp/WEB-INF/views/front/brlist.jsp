<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
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
<script type="text/javascript">


</script>

</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id="contents">
	<h2>조식 여부</h2>

<table class = "table table-hover">
	<tr>
	<th>수속 번호</th>
	<th>고객 성/이름</th>
	<th>고객 전화번호</th>
	<th>객실 번호</th>
	<th>숙박 인원</th>
	<th>쿠폰 번호</th>
	<th>조식 종류</th>
	<th>성인 인원/어린이 인원</th>
	<th>알러지 유무</th>
	<th></th>
	</tr>
	
	<c:forEach items="${list }" var = "brlist">
	<c:forEach items="${brlist.guestRooms }" var = "brlist2" >
		<tr>
	<td>${brlist2.checkIn.cheNo }</td>
	<td>${brlist2.checkIn.customer.cosLName } ${brlist2.checkIn.customer.cosFName }</td>
	<td>${brlist2.checkIn.customer.cosTelno }</td>
	<td><a href = "breakfast/detail?grNo=${brlist2.grNo }">${brlist2.grNo }</a></td>
	<td>${brlist2.grStaySum } 명</td>
	<td>${brlist.breakCoupon }</td>
	<td>${brlist.breakKind }</td>
	<td>성인${brlist.breakAdult }명/어린이${brlist.breakChild }명</td>
	<td>${brlist.guestRoom.checkIn.customer.cosAllergy }</td>
	<td><a href = "breakfast/delete?breakCoupon=${brlist.breakCoupon }">삭제</a></td>
	</tr>
	</c:forEach>	
	</c:forEach>
</table>
<input type = "button" onclick="location.href='../front'" value = "메인으로" class = "btn btn-primary btn">
	</div>
	<footer></footer>
</body>
</html>