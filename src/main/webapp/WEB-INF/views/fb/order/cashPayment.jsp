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
<title><spring:message code="payment.cash"/></title>

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
<!-- 폰트 -->
<link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro" rel="stylesheet">
<!-- 사용자 임의 JS, CSS설정 위치는 알아서 조정 -->
<link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung|Stylish" rel="stylesheet">
<script src="<c:url value="/js/backHeader.js"></c:url>" ></script>

<link href="<c:url value="/css/backHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/backFooter.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/Pay_content.css" />" rel="stylesheet" type="text/css">

	<script>
	function payment(){
		var cash = $("#cash").val();
		var cashReceipt = $("#cashReceipt").val();
		var cashCeoReceipt = $("#cashCeoReceipt").val();
		var paySum = $("#paySum").val();
		if(cash-paySum<0){
			alert("지불하신 금액이 주문하신 금액보다 적습니다.");
			return false;
		}
		$.ajax({
			url : "./cash",
			method : "post",
			data : "cashReceipt=" + cashReceipt + "&cashCeoReceipt=" + cashCeoReceipt
			+"&payment.paySum=" + paySum,
			dataType:'text',
			success:function(text){
				self.close();
				opener.alert("거스름돈은 " + (cash-paySum) + "입니다.");
				opener.paymentEnded(text);
			},
			error:function(data){
				alert("결제 실패했습니다! 다시 시도해 주세요.")
			}
		})
	}
	function isClose(){
		if(confirm('결제가 진행되지 않았지만 창을 닫으시겠습니까?')){
			self.close();
		}
	}
	$(function(){
		$("#reciSelectBox").on("change",function(){
			var boxing = $(this).val();
			var numberBox = "";
			if(boxing!="nothing"){
				numberBox += "번호를 입력해 주세요.  <input type = 'text' class = 'form-control boxx'  id= '"+boxing+"' name ='" + boxing + "'>"
			}
			$("#cashReci").html(numberBox);
		})
	})
	</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<div id = "con">
	<div id = "title">현금 결제 </div>
		<div class="form-inline boxx">
		<spring:message code="pay.cashPay"/> :<input type = "text" class="form-control" id = "cash"><br>
		</div>
		<select id = "reciSelectBox" class="form-control">
			<option value="nothing"><spring:message code="pay.cashReceipt"/> 선택</option>
			<option value="cashReceipt"><spring:message code="pay.cashReceipt"/></option>
			<option value="cashCeoReceipt"><spring:message code="pay.cashCeo"/></option>
		</select><br>
		<div id = "cashReci"></div>
		
		
		<spring:message code="payment.money"/> ${pay }<input type = "hidden" value="${pay }" name = "payment.paySum" id = "paySum"><br>
		<input type ="button" class = "customBtn btn btn-outline-danger btn-a" value="<spring:message code="payment"/>" onclick="payment()">
		<input type ="button" class = "btn btn-primary btn-md btn-a" value="<spring:message code="close"/>" onclick="isClose()">
	</div>
	</div>
	<footer></footer>
</body>
</html>