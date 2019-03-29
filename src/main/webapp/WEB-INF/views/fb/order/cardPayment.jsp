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
<title><spring:message code="payment.card"/></title>

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
	<script>
	function payment(){
		var cpCname = $("#cpCname").val();
		var cpCnum = $("#cpCnum").val();
		var cpInsDate = $("#cpInsMonth").val();
		var cpMonth = $("#cpMonth").val();
		var cpYear = $("#cpYear").val();
		var paySum = $("#paySum").val();
		
		$.ajax({
			url : "./card",
			method : "post",
			data : "cpCname=" + cpCname + "&cpCnum=" + cpCnum + "&cpInsMonth=" + cpInsDate
			+ "&cpMonth=" + cpMonth + "&cpYear=" + cpYear + "&payment.paySum=" + paySum,
			dataType:'text',
			success:function(text){
				self.close();
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
	</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
		<form:form>
		<spring:message code="payment.card"/><br>
		<spring:message code="pay.cardBankName"/> : 
		<select name = "cpCname" id="cpCname">
			<c:forEach begin="1" end="21" step="1" var="name">
				<c:if test="${name eq 1 }">
				<optgroup label="카드">
				</c:if>
				<c:if test="${name eq 9 }">
				<optgroup label="은행">
				</c:if>
				<option value ="<spring:message code="card.bank${name }"/>"><spring:message code="card.bank${name }"/></option>
				<c:if test="${name eq 8 || name eq 21 }">
				</optgroup>
				</c:if>
			</c:forEach>
		</select>
		<br>
		<spring:message code="pay.cardNum"/> : <input type = "text" id="cpCnum" name = "cpCnum" maxlength="19"><br>
		<spring:message code="pay.cardMonth"/> <input type = "text" id="cpMonth" name = "cpMonth" maxlength="2">
		<spring:message code="pay.cardYear"/> <input type = "text" id="cpYear" name = "cpYear" maxlength="2"><br>
		<spring:message code="pay.cardInsDate"/> <input type = "text" id="cpInsMonth" name = "cpInsMonth" maxlength="2">년<br>
		<spring:message code="payment.money"/> ${pay }<input type = "hidden" value="${pay }" name = "payment.paySum" id = "paySum"><br>
		<input type ="button" value="<spring:message code="payment"/>" onclick="payment()">
		<input type ="button" value="<spring:message code="close"/>" onclick="isClose()">
		</form:form>
	</div>
	<footer></footer>
</body>
</html>