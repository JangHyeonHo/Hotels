<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" >
<title>예약</title>

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
<script src="../js/reservation.js"></script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	    <div id = "firstname">고객 성</div> <input type="text" id = "fname" name = "fname">
    <div id = "lastname">고객 이름</div> <input type="text" id = "lname" name = "lname">
    <div id = "phone">고객 전화번호</div> <input type="text" id = "phone" name = "phone">
    <div id = "email">이메일</div> <input type="text" id = "email" name = "email">
    <div id = "y_or_n">알레르기 유무</div>
    <input type = "radio" id = "allergy1" name="allergy" value="있음">있음
    <input type = "radio" id = "allergy2" name="allergy" value="없음" checked = "checked">없음
    <div id = "allergyinfo"  style = "display:none;">
    <div id = "allergykind">알레르기 종류</div> <input type="text" id = "allergykind" name = "allergykind">
    </div>
    <div id = "roomnum">객실수
     <select id = "roomscount">
    <option value = "1">1개</option>
    <option value = "2">2개</option>
    <option value = "3">3개</option>
    <option value = "4">4개</option>
    <option value = "5">5개</option>
    </select>
    </div>
    
    <select id = "stay_num">
    <option value = "0">객실 숙박인원</option>
    <option value = "1">1명</option>
    <option value = "2">2명</option>
    <option value = "3">3명</option>
    <option value = "4">4명</option>
    <option value = "5">5명</option>
    <option value = "6">6명</option>
    <option value = "7">7명</option>
    <option value = "8">8명</option>
    <option value = "9">9명</option>
    <option value = "10">10명</option>
    </select>
    <div id = "che_pre">객실 선호사항</div> <input type="text" id = "che_pre" name = "che_pre">
    <div id = "che_meal">
    <select class = "che_pre" name = "che_mor_adult">
    <option value = "0">조식 성인 인원</option>
    <option value = "1">조식 성인 1명</option>
    <option value = "2">조식 성인 2명</option>
    <option value = "3">조식 성인 3명</option>
    <option value = "4">조식 성인 4명</option>
    <option value = "5">조식 성인 5명</option>
    <option value = "6">조식 성인 6명</option>
    <option value = "7">조식 성인 7명</option>
    <option value = "8">조식 성인 8명</option>
    <option value = "9">조식 성인 9명</option>
    <option value = "10">조식 성인 10명</option>
    </select>
    
    <select class = "che_pre" name = "che_mor_child">
    <option value = "0">조식 어린이 인원</option>
    <option value = "1">조식 어린이 1명</option>
    <option value = "2">조식 어린이 2명</option>
    <option value = "3">조식 어린이 3명</option>
    <option value = "4">조식 어린이 4명</option>
    <option value = "5">조식 어린이 5명</option>
    <option value = "6">조식 어린이 6명</option>
    <option value = "7">조식 어린이 7명</option>
    <option value = "8">조식 어린이 8명</option>
    <option value = "9">조식 어린이 9명</option>
    <option value = "10">조식 어린이 10명</option>
    </select>
    
    <select class = "che_pre" name = "che_din_adult">
    <option value = "0">석식 성인 인원</option>
    <option value = "1">석식 성인 1명</option>
    <option value = "2">석식 성인 2명</option>
    <option value = "3">석식 성인 3명</option>
    <option value = "4">석식 성인 4명</option>
    <option value = "5">석식 성인 5명</option>
    <option value = "6">석식 성인 6명</option>
    <option value = "7">석식 성인 7명</option>
    <option value = "8">석식 성인 8명</option>
    <option value = "9">석식 성인 9명</option>
    <option value = "10">석식 성인 10명</option>
    </select>
    
    <select class = "che_pre" name = "che_din_child">
    <option value = "0">석식 어린이 인원</option>
    <option value = "1">석식 어린이 1명</option>
    <option value = "2">석식 어린이 2명</option>
    <option value = "3">석식 어린이 3명</option>
    <option value = "4">석식 어린이 4명</option>
    <option value = "5">석식 어린이 5명</option>
    <option value = "6">석식 어린이 6명</option>
    <option value = "7">석식 어린이 7명</option>
    <option value = "8">석식 어린이 8명</option>
    <option value = "9">석식 어린이 9명</option>
    <option value = "10">석식 어린이 10명</option>
    </select>
    </div>

    <input type = "submit" value = "체크인">
    <input type = "reset" value = "재작성">
	</div>
	<footer></footer>
</body>
</html>