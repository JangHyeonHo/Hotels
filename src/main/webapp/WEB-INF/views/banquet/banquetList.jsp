<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" >
<title>예약자 명단</title>

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


</head>
<body>



<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header> <h1>예약자 명단</h1></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<c:forEach items="${list }" var="blist">
	
	예약 번호 <a href="list/detail?brNo=${blist.brNo }"> ${blist.brNo } </a>,
	연회장명 ${blist.banquet.banName } ,
	고객수 ${blist.brConsumer } ,
	이용 목적 ${blist.brPurpose } ,
	조식 여부 ${blist.brEating } ,
	이용할 시간 ${blist.brRantalTime },
	이용 날짜  <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${blist.brUseTime }"/> ,
	이용 요금 ${blist.brPrice },
	예약 등록일 <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${blist.brRegDate}"/>	
	<br>
	
	</c:forEach>
		<button onclick="location.href='reservation'">예약 등록</button>
	
	
	</div>
			<div id="paging">
				<c:set var="page" value="${paging.page}" />
				<c:if test="${paging.prev}">
					<a href="?page=1">◀◀</a>
					<a href="?page=${paging.startPage-1}">◀</a>
				</c:if>
				<c:forEach step="1" begin="${paging.startPage}"
					end="${paging.endPage}" var="i">
					<c:if test="${i == page}">
						<a style="font-weight: bold">${i}</a>
					</c:if>
					<c:if test="${i != page}">
						<a href="?page=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${paging.next}">
					<a href="?page=${paging.endPage+1}">▶</a>
					<a href="?page=${paging.maxPage}">▶▶</a>
				</c:if>
			</div>
	<footer></footer>
</body>
</html>