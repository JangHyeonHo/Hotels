<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:if test="${empty sessionOrderList[0].food.foodName }">
				<div id = "orderBox"><spring:message code="order.nothing"/></div>
			</c:if>
			<c:if test="${!empty sessionOrderList[0].food.foodName }">
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
					<th>
					<spring:message code="plus"/>
					</th>
					<th>
					<spring:message code="minus"/>
					</th>
				</tr>
			<c:forEach items="${sessionOrderList }" var="lists" varStatus="i">
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
					<td>
					<input type = "button" value ="<spring:message code="plus"/>" onclick="plus()">
					</td>
					<td>
					<input type = "button" value ="<spring:message code="minus"/>" onclick="minus()">
					</td>
				</tr>
			</c:forEach>
			</table>
			<div id = "amount">
				<spring:message code="payment.money"/> : ${amount }
			</div>
			<input type = "button" onclick = "order()" value="<spring:message code="order.regist"/>">
			<input type = "button" onclick = "location.href='./table'" value="전체<spring:message code="order.table"/>">
			</c:if>
