<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<title><spring:message code="cont.list" /></title>

<!-- 미 변경 목록(JQuery설정, BootStrap설정) -->
<!-- JQuery -->
<script src="http://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<!-- JQuery UI -->
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<!-- BootStrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- BootStrap -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- 사용자 임의 JS, CSS설정 위치는 알아서 조정 -->
<script>
	$(function() {
		$("#disListBtn").on("click", function() {
			location.href = "./distributor"
		})
		$("#contDelBtn").on("click",function(){
			var no = $("input:radio[name = 'contNo']:checked").val();
			console.log(no);
			if(no == null){
				alert("계약을 취소할 유통업체를 선택하여 주십시오")
				return false;
			} else{
				if(!confirm("정말로 해당 유통업체와의 계약을 해지하시겠습니까?\n해지하면 다시 되돌릴 수 없습니다.")){
					return false;
				}
				location.href="./contract/delete?contNo="+no;
			}
			$("#disBtn").on("click", function() {
				location.href = "./distributor"
			})
		})
	});
</script>

</head>
<body>
	<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id="contents">
		<c:if test="${!empty ContractList}">
			<h3>
				<spring:message code="cont.list" />
			</h3>
			<table>
				<tr>
					<th><spring:message code="cont.no" /></th>
					<th><spring:message code="dis.name" /></th>
					<th><spring:message code="cont.kind" /></th>
					<th><spring:message code="cont.regdate" /></th>
					<th><spring:message code="radio" /></th>
				</tr>
				<c:forEach items="${ContractList }" var="con">
					<tr>
						<td>${con.contNo}</td>
						<td>${con.distributor.disName}</td>
						<td>${con.contMatKind}</td>
						<td><fmt:formatDate pattern="yyyy년 MM월 dd일" value="${con.contRegDate}"/></td>
						<td><input type="radio" name="contNo" value="${con.contNo}"></td>
					</tr>
				</c:forEach>
			</table>
			<input type = "button" value="<spring:message code="cont.delete" />" id="contDelBtn"/>
		</c:if>
		<c:if test="${empty ContractList}">
			<spring:message code="cont.nothing" />
			<br>
			<input type="button" value="<spring:message code="dist.list" />로"
				id="disListBtn">
		</c:if>
		<input type = "button" value="<spring:message code="back" />" id="backBtn"/>
		<input type = "button" value="<spring:message code="dist.list" /> 보기" id="disBtn"/>
	</div>
	<footer></footer>
</body>
</html>