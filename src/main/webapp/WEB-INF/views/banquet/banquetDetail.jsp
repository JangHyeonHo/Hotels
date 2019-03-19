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
<title>연회장 예약 정보</title>

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

<script type="text/javascript">

function refreshOne(){
	
	location.href="detail/refreshone?brNo=${dto.brNo}";
	
}

function refreshTwo(){
	
	location.href="detail/refreshtwo?brNo=${dto.brNo}";

}
</script>


</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header><h1>연회장 예약 정보</h1></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	예약 번호 ${dto.brNo}<br>
	고객 번호 ${dto.customer.cosNo }<br>
 	결제 번호 ${dto.payment.payNo }<br>
 	연회장 명 ${dto.banquet.banName }<br>
 	이용 목적 ${dto.brPurpose}<br>
 	이용 시간 ${dto.brRantalTime}시간<br>
 	개최 시간 <fmt:formatDate pattern="HH시mm분" type="time" value="${dto.brOpen }"/> <button type=button onclick="refreshOne()"> 갱신 </button><br>
 	폐회 시간  <fmt:formatDate pattern="HH시mm분" type="time"  value="${dto.brClose }"/><button type=button onclick="refreshTwo()"> 갱신 </button><br>  
 	이용 고객수 ${dto.brConsumer }<br>
 	이용 날짜 <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${dto.brUseTime}"/><br>
 	이용 요금 ${dto.brPrice }<br>
 	식사 여부 ${dto.brEating }<br>
 	추가 요금 ${dto.brExPay }<br>
 	예약 등록일 <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${dto.brRegDate}"/><br>
 	
 	<button onclick="location.href='detail/delete?brNo=${dto.brNo}'"">삭제</button>
 	<button onclick="location.href='../list'">돌아가기</button>
 	
 	
	</div>
	<footer></footer>
</body>
</html>