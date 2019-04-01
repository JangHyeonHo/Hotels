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
<title><spring:message code="payment" /></title>

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
<link href="<c:url value="/css/Payment_content.css" />" rel="stylesheet" type="text/css">

	<script>
		function cardPopUp(tableNum){
			var pay = $("#pay").text();
			console.log(pay);
			window.open("./payment/card?pay="+pay,"카드 결제", "height=300px, width=500px, resizable=no, scrollbars=no",true)
		}
		function cashPopUp(tableNum){
			var pay = $("#pay").text();
			console.log(pay);
			window.open("./payment/cash?pay="+pay,"현금 결제", "height=300px, width=500px, resizable=no, scrollbars=no",true)
		}
		function paymentEnded(payno){
			var tn = $("#tableNum").text();
			$.ajax({
			url : "./payment",
			method : "post",
			data : "table=" + tn + "&pay=" + payno,
			dataType:'html',
			success:function(data){
				alert("성공적으로 결제 완료했습니다.")
				location.href="../table";
			},
			error:function(data){
				alert("결제 실패했습니다! 다시 시도해 주세요.")
			}
		})
		}
	
	</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../../backHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<div id = "con">	
	<div id = "title">
		<div id = "mainBox"><span id ="tableNum">${list[0].orders.ordTableNum }</span>번 테이블<spring:message code="payment"/></div>
	</div>	
	<div id = "con">	
			<table class = "table">
				<tr>
					<th><spring:message code="number"/></th>
					<th><spring:message code="food.name"/></th>
					<th><spring:message code="food.price"/></th>
					<th><spring:message code="order.count"/></th>
				</tr>
			<c:forEach items="${list }" var="li" varStatus="i">
				<c:if test="${li.olCount ne 0 }">
				<tr>
					<td>${i.count }</td>
					<td>${li.foodName }</td>
					<td>${li.food.foodPrice }</td>
					<td>${li.olCount }</td>
				</tr>
				</c:if>
			</c:forEach>
			</table>
	</div>
	</div>
			<div id = "amount">
				<spring:message code="payment.allsum"/> : <span id = "pay">${amount }</span>
			</div>
		<input type = "button" class="btn btn-danger btn-a" value = "<spring:message code="payment.card"/>" onclick="cardPopUp(${list[0].orders.ordTableNum })">
		<input type = "button" class="btn btn-danger btn-a" value = "<spring:message code="payment.cash"/>" onclick="cashPopUp(${list[0].orders.ordTableNum })">
		<input type = "button" class = "btn btn-primary btn-md btn-a" value="<spring:message code="back" />" onclick="javascript:history.back()">
	</div>
	<jsp:include page="../../backFooter.jsp" />
</body>
</html>