<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:forEach begin="1" end="7" var="i" step="1">
	<c:if test="${kind eq i}">
		<div  id = "selectedBox" class="foodKind" style="background-color: skyblue;"
			onclick="kinds('<spring:message code="food.ki${i }"/>')">
			<spring:message code="food.ki${i }" />
		</div>
	</c:if>
	<c:if test="${kind ne i}">
		<div class="foodKind"
			onclick="kinds('<spring:message code="food.ki${i }"/>')">
			<spring:message code="food.ki${i }" />
		</div>
	</c:if>
</c:forEach>
<c:forEach items="${foodList }" var="food">
	<div class="foodList" onclick="orders(${food.foodNo })">
		<div class="foodLabel">
			<spring:message code="food.name" />
		</div>
		<div class="foodName foodMain">${food.foodName }</div>
		<div class="foodImage">
			<img width="100%" height="150px" alt="${food.foodOriFileName}"
				src='<c:url value="/img/fb/food/${food.foodStoreFileName}" />'>
		</div>
		<div class="foodLabel">
			<spring:message code="food.price" />
			￦
		</div>
		<div class="foodPrice foodMain">${food.foodPrice }</div>
	</div>
</c:forEach>
<div id="paging">
	<c:set var="page" value="${paging.page}" />
	<c:if test="${paging.prev}">
		<div onclick="prev(${paging.startPage-1})">◀</div>
	</c:if>
	<c:if test="${paging.next}">
		<div onclick="next(${paging.endPage+1})">▶</div>
	</c:if>
</div>
</html>