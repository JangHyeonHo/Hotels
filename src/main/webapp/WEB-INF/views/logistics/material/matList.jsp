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
<title><spring:message code="material.list"/></title>

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
<link href="<c:url value="/css/matList_content.css" />" rel="stylesheet" type="text/css">
<script>
	$(function(){
		$("#delBtn").on("click",function(){
			var no = $("input:radio[name = 'matNo']:checked").val();
			console.log(no);
			if(no == null){
				alert("삭제할 자재를 선택하여 주십시오.")
				return false;
			} else{
				if(!confirm("정말로 자재를 등록을 삭제하시겠습니까?\n삭제하면 해당 자재의 재고는 초기화됩니다. ")){
					return false;
				}
				location.href="./material/delete?matNo="+no;
			}
		})
		
		$("#inboundBtn").on("click",function(){
			var no = $("input:radio[name = 'matNo']:checked").val();
			console.log(no);
			if(no == null){
				alert("입고할 자재를 선택하여 주십시오..")
				return false;
			} else{
				location.href="./material/inbound?matNo="+no;
			}
		})
		$("#outboundBtn").on("click",function(){
			var no = $("input:radio[name = 'matNo']:checked").val();
			console.log(no);
			if(no == null){
				alert("출고할 자재를 선택하여 주십시오..")
				return false;
			} else{
				location.href="./material/outbound?matNo="+no;
			}
		})
	})

</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../../backHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<div id = "con">
		<div id = "title">
		<h2><spring:message code="material.list"/></h2>
		</div>
		
		<table class = "table table-hover">
			<tr>
				<th><spring:message code="mat.no" /></th>
				<th><spring:message code="mat.name" /></th>
				<th><spring:message code="mat.kind" /></th>
				<th><spring:message code="dis.name" /></th>
				<th><spring:message code="mat.val" /></th>
				<th><spring:message code="regist" /></th>
			</tr>
			<c:forEach items="${materialList}" var="mat">
			<tr>
				<td>${mat.matNo}</td>
				<td>${mat.matName}</td>
				<td>${mat.matKind}</td>
				<td>${mat.contract.distributor.disName}</td>
				<td>${mat.counting}</td>
				<td><input type="radio" name="matNo" value="${mat.matNo}"></td>
			</tr>
			</c:forEach>
			
		</table>
		<div id = "paging">
		<c:set var="page" value="${paging.page}"/>
			<c:if test="${paging.prev}"><a href="?page=1">◀◀</a><a href="?page=${paging.startPage-1}">◀</a></c:if>
			<c:forEach step="1" begin="${paging.startPage}" end="${paging.endPage}" var="i">
				<c:if test="${i == page}">
				<a style = "font-weight : bold">${i}</a>
				</c:if>
				<c:if test="${i != page}">
				<a href="?page=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<c:if test="${paging.next}"><a href="?page=${paging.endPage+1}">▶</a><a href="?page=${paging.maxPage}">▶▶</a></c:if>
		</div>
		
	
	<c:if test="${empty materialList}">
		<spring:message code="material.nothing" /><br>
	</c:if>
	<input type = "button" class="btn btn-danger btn-a" value = "<spring:message code="material.regist" />" onclick = "location.href = './contract'">
	<input type = "button" class="btn btn-danger btn-a" value = "<spring:message code="material.delete" />" id = "delBtn">
	<input type = "button" class="btn btn-danger btn-a" value = "해당 <spring:message code="mat.in" />" id = "inboundBtn">
	<input type = "button" class="btn btn-danger btn-a" value = "해당 <spring:message code="mat.out" />" id = "outboundBtn">
	<input type = "button" class = "btn btn-primary btn btn-a" value = "전체 <spring:message code="in.out" />" onclick = "location.href = './material/list'">
	<input type = "button" class = "btn btn-primary btn btn-a" value = "해당 <spring:message code="in.out" />" id = "inOutBtn">
	<input type = "button" class = "btn btn-primary btn btn-a" value="<spring:message code="back" />" onclick = "location.href = '../logistics'"/>
	</div>
	</div>
	
	<jsp:include page="../../backFooter.jsp" />
</body>
</html>