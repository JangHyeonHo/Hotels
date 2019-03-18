<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<!-- <script src="../../js/checkin.js"></script> -->
<script type="text/javascript">

$(function(){

	//입실,퇴실 예정일
	//현재 날짜의 년을 받음
	var thisYears = new Date().getFullYear();
	console.log(thisYears);
	var nextYears = "";
	var nextMonth = "";
	//현재 날로부터 -1년씩 감소해서 <option>을 만듬
	for(var i = 0; i < 80; i++){
		nextYears += "<option value="+ (thisYears-i) +">" + (thisYears-i) + "</option>"
	}
	//1일부터 31일까지 1씩 올려서 <option>날짜를 만듬
	for(var i = 1; i <= 31; i++){
		nextMonth += "<option value="+ i +">" + i + "</option>"
	}
	console.log(nextYears);
	//year박스와 day박스에 넣어줌
	$(".year").html(nextYears);
	$(".day").html(nextMonth);

	//month를 change->바꿨을 때 즉 month박스의 값을 바꿨을 때 실행함
	$(".month").on("change",function(){
		var monthval = $(this).val();
		var daysStack;
		var nextDays = "";
		console.log(monthval);
		switch(monthval){
		case "1":
		case "3":
		case "5":
		case "7":
		case "8":
		case "10":
		case "12":
			daysStack = 31;
			break;
		case "2":
			daysStack = 29;
			break;
		default:
			daysStack = 30;
		break;
		}
		for(var i = 1; i <= daysStack; i++){
			nextDays += "<option value="+ i +">" + i + "</option>"
		}
		$(".day").html(nextDays);
	})

	$(".allergy1").on("click",function(){
		var value = $(this).val();
		console.log(value);
		if(value == "있음"){
			$("#allergyinfo").css("display","block");
		} else {
			$("#allergyinfo").css("display","none");
		}

	})
	
	var innerHtmlValue = "<select class = 'stay_num'>";
	for(var i = 0; i <= 10 ; i++){
		if(i == 0){
			innerHtmlValue += "<option value = '"+i+"'>객실 숙박인원</option>"
		} else{
			innerHtmlValue += "<option value = '"+i+"'>"+i+"명</option>"
		}
	}
	innerHtmlValue += "</select>";	 
	
	var selectValue = "<select class = 'roomskind'>";
	for(var k = 1; k <= 1 ; k++){
		if(k != 0){
			selectValue += "<option value = '"+i+"'>비즈니스 룸</option>"
			selectValue += "<option value = '"+i+"'>슈페리어 룸</option>"
			selectValue += "<option value = '"+i+"'>디럭스 룸</option>"
			selectValue += "<option value = '"+i+"'>스위트 룸</option>"
			selectValue += "<option value = '"+i+"'>코너 룸</option>"
		}
	}
	selectValue += "</select>";
	
	$("#roomscount").on("change",function(){
		var value = $(this).val();
		var AllRooms = "";
		for(var i = 0; i < value ; i++){
			AllRooms += selectValue;
			AllRooms += innerHtmlValue;
			AllRooms += "<br>"
		}
		$("#stayhidden").html(AllRooms);
		
		console.log(value);
		
	})
	
});


</script>

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	
	<form:form>
	<div class = "infobox">고객 성</div> <input type="text" id = "fname" name = "cosFName">
    <div class = "infobox">고객 이름</div> <input type="text" id = "lname" name = "cosLName">
    <div class = "infobox">고객 전화번호</div> <input type="text" id = "phone" name = "cosTelno">
    <div class = "infobox">이메일</div> <input type="text" id = "email" name = "cosEmail">
    <div class = "infobox">알레르기 유무</div>
    <input type = "radio" class = "allergy1" name="cosAllergy" value="있음">있음
    <input type = "radio" class = "allergy1" name="cosAllergy" value="없음" checked = "checked">없음
    <div id = "allergyinfo"  style = "display:none;">
    <div class = "infobox">알레르기 종류</div> <input type="text" id = "allergykind" name = "cosAllergy">
    </div>
    
    <div class = "infobox">입실 예정일</div>
				<select name="year" class="year">
				</select>년
				<select name="month" class = "month">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>월
				<select name="day" class="day">
				</select>일
				
	 <div class = "infobox">퇴실 예정일</div>
				<select name="year" class="year">
				</select>년
				<select name="month" class = "month">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>월
				<select name="day" class="day">
				</select>일			
		
	
    
    <div id = "roomnum">객실수
     <select id = "roomscount">
    <option class = "rcount" value = "1">1개</option>
    <option class = "rcount" value = "2">2개</option>
    <option class = "rcount" value = "3">3개</option>
    <option class = "rcount" value = "4">4개</option>
    <option class = "rcount" value = "5">5개</option>
    <option class = "rcount" value = "6">6개</option>
    <option class = "rcount" value = "7">7개</option>
    <option class = "rcount" value = "8">8개</option>
    </select>
    </div>
    

    
    <div id = "stayhidden">
    
    <select id = "roomskind">
    <option value = "1">비즈니스 룸</option>
    <option value = "2">슈페리어 룸</option>
    <option value = "3">디럭스 룸</option>
    <option value = "4">스위트 룸</option>
    <option value = "5">코너 룸</option>
    </select>
    
    <select class = "stay_num">
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
           
    </div>
    
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
    <option value = "11">조식 성인 11명</option>
    <option value = "12">조식 성인 12명</option>
    <option value = "13">조식 성인 13명</option>
    <option value = "14">조식 성인 14명</option>
    <option value = "15">조식 성인 15명</option>
    <option value = "16">조식 성인 16명</option>
    <option value = "17">조식 성인 17명</option>
    <option value = "18">조식 성인 18명</option>
    <option value = "19">조식 성인 19명</option>
    <option value = "20">조식 성인 20명</option>
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
    <option value = "11">석식 성인 11명</option>
    <option value = "12">석식 성인 12명</option>
    <option value = "13">석식 성인 13명</option>
    <option value = "14">석식 성인 14명</option>
    <option value = "15">석식 성인 15명</option>
    <option value = "16">석식 성인 16명</option>
    <option value = "17">석식 성인 17명</option>
    <option value = "18">석식 성인 18명</option>
    <option value = "19">석식 성인 19명</option>
    <option value = "20">석식 성인 20명</option>
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
    
  <%--  <input type="hidden" id = "cosNo" name = "customer.cosNo" value = "${customer.cosNo }"> --%>
    

    <input type = "submit" value = "체크인">
    <input type = "reset" value = "재작성">
    <input type = "button" onclick="location.href='../front'" value = "메인으로">
    
    </form:form>
	</div>
	<footer></footer>
</body>
</html>