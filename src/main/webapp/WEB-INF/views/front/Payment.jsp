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
	<script>
		function cardPopUp(tableNum){
			var pay = $("#pay").text();
			console.log(pay);
			window.open("./checkout/card?pay="+pay,"카드 결제", "height=300px, width=500px, resizable=no, scrollbars=no",true)
		}
		function cashPopUp(tableNum){
			var pay = $("#pay").text();
			console.log(pay);
			window.open("./checkout/cash?pay="+pay,"현금 결제", "height=300px, width=500px, resizable=no, scrollbars=no",true)
		}
		function paymentEnded(payno){
			var tn = $("#cheNo").val();
			$.ajax({
			url : "./checkout",
			method : "post",
			data : "cheNo=" + tn + "&pay=" + payno,
			dataType:'html',
			success:function(data){
				alert("성공적으로 결제 완료했습니다.")
				location.href="../rooms";
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
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
		<div id = "mainBox"></div>
			<input type = "hidden" value = "${totalPrice.cheNo }" id = "cheNo">
			ㅁㅁ <spring:message code="customer.pay"/><br>
			<spring:message code="rooms.pay"/> : ${totalPrice.roomPrice }<br>
			<spring:message code="dinner.pay"/> : ${totalPrice.diAdult + totalPrice.diChild }<br>
			<spring:message code="di.adult"/> : ${totalPrice.diAdult }<br>
			<spring:message code="di.child"/> : ${totalPrice.diChild }<br>
			<spring:message code="breakfast.pay"/> : ${totalPrice.breakAdult + totalPrice.breakChild }<br>
			<spring:message code="bre.adult"/> : ${totalPrice.breakAdult }<br>
			<spring:message code="bre.child"/> : ${totalPrice.breakChild }<br>
			<div id = "amount">
				<spring:message code="payment.allsum"/> : <span id = "pay">${totalPrice.totalPrice }</span>
			</div>
		<input type = "button" value = "<spring:message code="payment.card"/>" onclick="cardPopUp(${totalPrice.cheNo })">
		<input type = "button" value = "<spring:message code="payment.cash"/>" onclick="cashPopUp(${totalPrice.cheNo })">
		<input type = "button" value="<spring:message code="back" />" onclick="javascript:history.back()">
	</div>
	<footer></footer>
</body>
</html>