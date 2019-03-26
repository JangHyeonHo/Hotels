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
<title><spring:message code="order.regist"/></title>

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
		min-width : 1080px;
	}
	#listBox{
		width : 30%;
		height : 900px;
		float : left;
	}
	#foodBox{
		width : 70%;
		height : 900px;
		float : left;
	}
	.foodList{
		width : 25%;
		border : 1px solid black;
		height : 200px;
		background-color : #f0f0f0;
		float : left;
	}
	.foodList:hover{
		background-color : #dddddd;
	}
	.foodKind{
		width : 14%;
		height : 50px;
		float : left;
	}
	.foodLabel{
		display : inline-block;
	}
	.foodMain{
		display : inline-block;
	}
	

</style>

<script>
	
		function orders(no){
			var tableNum = $("#tableNum").text();
			$.ajax({
				url:"http://localhost/peregrine/comp/fb/restaurant/order/regist/sesinput",
				method:'post',
				data:"foodNo=" + no + "&tableNo=" + tableNum,
				dataType:'html',
				success:function(data){
					$("#listBox").html(data);
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
		 
		<div id = "mainBox"><span id ="tableNum">${orderList[0].orders.ordTableNum }</span>번 <spring:message code="order.regist"/></div>
		<div id = "listBox">
			<c:if test="${empty orderList[0].food.foodName }">
				<div id = "orderBox"><spring:message code="order.nothing"/></div>
			</c:if>
			<c:if test="${!empty orderList[0].food.foodName }">
			<table>
				<tr>
					<th>
					<spring:message code="number"/>
					</th>
					<th>
					<spring:message code="food.name"/>
					</th>
					<th>
					<spring:message code="food.price"/>
					</th>
					<th>
					<spring:message code="order.count"/>
					</th>
				</tr>
			<c:forEach items="${orderList }" var="lists" varStatus="i">
				<tr>
					<td>
					${i.count }
					</td>
					<td>
					${lists.food.foodName }
					</td>
					<td>
					${lists.food.foodPrice }
					</td>
					<td>
					${lists.olCount }
					</td>
				</tr>
			</c:forEach>
			</table>
			<div id = "amount">
				<spring:message code="payment.money"/> : ${allSum }
			</div>
			</c:if>
			
		</div>
		<div id = "foodBox">
			<c:forEach	begin="1" end="7" var="i" step="1">
				<div class = "foodKind"><spring:message code="food.ki${i }"/></div>
			</c:forEach>
			<c:forEach items="${foodList }" var="food">
				<div class = "foodList" onclick="orders(${food.foodNo })">
					<div class="foodLabel"><spring:message code="food.name"/></div><div class="foodName foodMain">${food.foodName }</div>
					<div class="foodImage"><img width="100%" height="150px" alt="${food.foodOriFileName}" src='<c:url value="/food/${food.foodStoreFileName}" />'></div>
					<div class="foodLabel"><spring:message code="food.price"/> ￦</div><div class="foodPrice foodMain">${food.foodPrice }</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<footer></footer>
</body>
</html>