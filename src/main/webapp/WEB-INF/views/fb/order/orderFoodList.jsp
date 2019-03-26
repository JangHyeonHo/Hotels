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
				</tr>
			</c:forEach>
			</table>
			<div id = "amount">
				<spring:message code="payment.money"/> : ${allSum }
			</div>
			</c:if>
