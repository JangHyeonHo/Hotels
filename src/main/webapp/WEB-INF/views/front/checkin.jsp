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
	var nextDay = "";
	//현재 날로부터 +1년씩 증가해서 <option>을 만듬
	for(var i = 0; i < 12; i++){
		nextYears += "<option value="+ (thisYears+i) +">" + (thisYears+i) + "</option>"
	}
	//1월부터 12월까지 1일씩 올려서  <option>날짜를 만듬
	for(var i = 1; i <= 12; i++){
		nextMonth += "<option value="+ i +">" + i + "</option>"
	}
	//1일부터 31일까지 1씩 올려서 <option>날짜를 만듬
	for(var i = 1; i <= 31; i++){
		nextDay += "<option value="+ i +">" + i + "</option>"
	}
	
	//year박스와 mouth와 day박스에 넣어줌
	$(".year").html(nextYears);
	$(".month").html(nextMonth);
	$(".day").html(nextDay);

	//month를 change->바꿨을 때 즉 month박스의 값을 바꿨을 때 실행함
	$(".month").on("change",function(){
		var monthval = $(this).val();
		var daysStack;
		var nextDays = "";
		
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
	
	$(".stay_num").html(innerHtmlValue);
	
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
	
	$(".roomskind").html(selectValue);
	
	
	var guestNo = "";
	for(var w = 1; w <= 1; w++){
		if(w != 0){
			guestNo += "객실번호<input type='text'>";
		}
		
	}
	
	$(".grNo").html(guestNo);
	
	$("#roomscount").on("change",function(){
		var value = $(this).val();
		var AllRooms = "";
		for(var i = 0; i < value ; i++){
			AllRooms += selectValue;
			AllRooms += innerHtmlValue;
			AllRooms += guestNo;
			AllRooms += "<br>"
		}
		
		
		console.log(AllRooms);
		
	})

	
	
	
	$("#submitBtn").on("click",function(e){
		var checkInDate = $("#cheInyear").val() + "-" + $("#cheInmonth").val() +"-"+ $("#cheInday").val() 
		console.log(checkInDate);
		 e.preventDefault();
		 this.form.submit();
		$("#cheInDate").html(checkInDate);
	})
	$("#submitBtn").on("click",function(e){
	var checkOutDate = $("#cheOutyear").val() + "-" + $("#cheOutmonth").val() +"-"+ $("#cheOutday").val() 
	console.log(checkOutDate);
		e.preventDefault();
		this.form.submit();
		$("#cheOutDate").html(checkOutDate);
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
	<div class = "infobox">고객 성</div> <input type="text" id = "fname" name = "customer.cosLName">
    <div class = "infobox">고객 이름</div> <input type="text" id = "lname" name = "customer.cosFName">
    <div class = "infobox">고객 전화번호</div> <input type="text" id = "phone" name = "customer.cosTelno">
    <div class = "infobox">이메일</div> <input type="text" id = "email" name = "customer.cosEmail">
    <div class = "infobox">알레르기 유무</div>
    <input type = "radio" class = "allergy1" name = "allergy" value="있음">있음
    <input type = "radio" class = "allergy1" name = "allergy" value="없음" checked="checked">없음
    <div id = "allergyinfo"  style = "display:none;">
    <div class = "infobox">알레르기 종류</div> <input type="text" id = "allergykind" name = "customer.cosAllergy">
    </div>
    
     <input type="hidden" id = "cheInDate" name = "cheInDate">
    <div class = "infobox">입실 예정일</div>
				<select id="cheInyear" class="year">
				</select>년
				<select id = "cheInmonth" class = "month">
				</select>월
				<select id="cheInday" class="day">
				</select>일
				
	<input type="hidden" id = "cheOutDate" name = "cheOutDate">
	 <div class = "infobox">퇴실 예정일</div>
				<select id="cheOutyear" class="year">
				</select>년
				<select id="cheOutmonth" class = "month">
				</select>월
				<select id="cheOutday" class="day">
				</select>일			
		
	
    
    <div id = "roomnum">객실수
     <select id = "roomscount" name = "roomCount">
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
    
    <select class = "roomskind" name = "roomName">
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
        객실번호<input type="text" class = "grNo" name = "">      
     
    </div>
    
    <div id = "che_pre">객실 선호사항</div> <input type="text" id = "che_pre" name = "cheDetail">

   <input type="hidden" id = "cosNo" name = "customer.cosNo" value = "${customer.cosNo }">
    
	<div id = "sub">
    <input type = "submit" value = "체크인" id = "submitBtn">
    <input type = "reset" value = "재작성">
    <input type = "button" onclick="location.href='../front'" value = "메인으로">
    </div>
    </form:form>
	</div>
	<footer></footer>
</body>
</html>