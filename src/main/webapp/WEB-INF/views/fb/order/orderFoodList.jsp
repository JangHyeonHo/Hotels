<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<table class = "table con">
				<tr>
					<th><spring:message code="number"/></th>
					<th><spring:message code="food.name"/></th>
					<th><spring:message code="food.price"/></th>
					<th><spring:message code="order.count"/></th>
					<th><spring:message code="plus"/></th>
					<th><spring:message code="minus"/></th>
				</tr>
			<c:forEach items="${sessionOrderList }" var="lists" varStatus="i">
				<c:if test="${lists.olCount ne 0 }">
				<tr>
					<td>${i.count }</td>
					<td>${lists.foodName }</td>
					<td>${lists.food.foodPrice }</td>
					<td>${lists.olCount }</td>
					<td><input type = "button" class = "btn btn-primary btn-sm btn-a" value ="<spring:message code="plus"/>" onclick="plus(${i.count })"></td>
					<td><input type = "button" class = "btn btn-primary btn-sm btn-a" value ="<spring:message code="minus"/>" onclick="minus(${i.count })"></td>
				</tr>
				</c:if>
			</c:forEach>
			</table>
			<c:if test="${empty sessionOrderList[0].food.foodName }">
				<div id = "orderBox"><spring:message code="order.nothing"/></div>
			</c:if>
			<div id = "amount">
				<spring:message code="payment.money"/> : ${amount }
			</div>
			<input type = "button" class = "customBtn btn btn-outline-danger" onclick = "order()" value="<spring:message code="order.regist"/>">
			<input type = "button" class = "btn btn-primary btn-md btn-a" onclick = "location.href='./table'" value="전체<spring:message code="order.table"/>">
			<input type = "button" class="btn btn-danger btn-a" value="<spring:message code="payment" /> 하기" onclick = "location.href='./table/payment?table=${orderList[0].orders.ordTableNum }'">
			<input type = "button" id = "submitBtn3" onclick="history.back(-1)" value = "뒤로가기" class = "customBtn btn btn-primary btn">
			