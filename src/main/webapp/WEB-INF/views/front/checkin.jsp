<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL사용 필요한것 알아서 짤라서 사용 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 타이틀명 수정하기(필수) -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" >
<title>체크인</title>

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

<!-- <script src=""></script> -->

<style type="text/css">
#contents{
min-width : 1000px;
}


.textput{
  width: 240px;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 2px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
select{
  display: inline-block;
  border: 2px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

#cheInyear{
  width: 80px;
  padding: 6px 0 6px 10px;
  margin: 10px 0;

}
#cheInmonth{
  width: 60px;
  padding: 6px 0 6px 10px;
  margin: 10px 0;
}
#cheInday{
  width: 60px;
  padding: 6px 0 6px 10px;
  margin: 10px 0;
}
#cheOutyear{
  width: 80px;
  padding: 6px 0 6px 10px;
  margin: 10px 0;
}
#cheOutmonth{
  width: 60px;
  padding: 6px 0 6px 10px;
  margin: 10px 0;
}
#cheOutday{
  width: 60px;
  padding: 6px 0 6px 10px;
  margin: 10px 0;
}
#rk{
  width: 150px;
  padding: 6px 0 6px 10px;
  margin: 10px 0;
}
#roomscount{
  width: 80px;
  padding: 4px 0 4px 10px;
  margin: 10px 0;
}
.stay_num{
  width: 150px;
  padding: 4px 0 4px 10px;
  margin: 10px 10px;
}
.guestNo{
  width: 120px;
  padding: 6px 0 6px 10px;
  margin: 10px 10px;
}
.che_pre3{
  width: 150px;
  padding: 4px 0 4px 4px;
  margin: 10px 10px;
}


</style>
<script type="text/javascript">
$(function(){
	
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
		$(".inmonth").html(nextMonth);
		$(".outmonth").html(nextMonth);
		$(".day").html(nextDay);

		//month를 change->바꿨을 때 즉 month박스의 값을 바꿨을 때 실행함
		$("#cheInmonth").on("change",function(){
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
			$("#cheInday").html(nextDays);
		})
		
		
			$("#cheOutmonth").on("change",function(){
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
			$("#cheOutday").html(nextDays);
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
		
		//객실 숙박인원을 1부터 10까지 받음
	 	var innerHtmlValue = "<select class = 'stay_num' name = 'grStaySum'>";
		for(var i = 0; i <= 10 ; i++){
			if(i == 0){
				innerHtmlValue += "<option value = '"+i+"'>객실 숙박인원</option>"
			} else{
				innerHtmlValue += "<option value = '"+i+"'>숙박인원 : "+i+"명</option>"
			}
		}
		innerHtmlValue += "</select>";	 
		
		

		
		
		var guestNo = "";
		for(var w = 1; w <= 1; w++){
			if(w != 0){
				guestNo += "객실번호 <input type='text' name='grNo' class = 'guestNo'>";
			}
			
		}
		
		
		

		
		
		var dinAdult = "<select class = 'che_pre3' name = 'DinAdult'>";
		//식사 인원수 1부터 20까지 증가시킴
		for(var i = 0; i <= 10; i++){
			if(i == 0 ){
				dinAdult += "<option value="+ i +">석식 성인 인원</option>";
			}else{
				dinAdult += "<option value="+ i +">석식성인 : " + i + "명</option>";
				}
		}
		dinAdult += "</select>";
		//che_pre에 넣어줌
		
		var dinChild = "<select class = 'che_pre3' name = 'DinChild'>";
		//식사 인원수 1부터 20까지 증가시킴
		for(var i = 0; i <= 10; i++){
			if(i == 0 ){
				dinChild += "<option value="+ i +">석식 어린이 인원</option>";
			}else{
			dinChild += "<option value="+ i +">석식 어린이 : " + i + "명</option>";
			}
		}
		dinChild += "</select>";
		//che_pre에 넣어줌

		
		var firstBoxing = innerHtmlValue + guestNo + dinAdult + dinChild + "<br>";
		$("#stayhidden").html(firstBoxing)
		
		$(document).on("change","#roomscount",function(){
			var value = $(this).val();
			var AllRooms = "";
			for(var i = 0; i < value ; i++){
				/* AllRooms += selectValue; */
				AllRooms += innerHtmlValue;
				AllRooms += guestNo;
				AllRooms += dinAdult;
				AllRooms += dinChild;
			
				AllRooms += "<br>"
			}
			$("#stayhidden").html(AllRooms)
			
			console.log(AllRooms);
			
		})

		
		var inputHidden = "<input type = 'hidden' name="
		
		$("#submitBtn").on("click",function(e){
			var checkInDate = $("#cheInyear").val() + "-" + $("#cheInmonth").val() +"-"+ $("#cheInday").val() 
			var checkInHiddenHtml = inputHidden + "'cheInDate' value='"+ checkInDate +"'>"
			var checkOutDate = $("#cheOutyear").val() + "-" + $("#cheOutmonth").val() +"-"+ $("#cheOutday").val() 
			var checkOutHiddenHtml = inputHidden + "'cheOutDate' value='"+ checkOutDate +"'>"
			var innerHtmlValue = checkInHiddenHtml + checkOutHiddenHtml
			$("#hiddenBox").html(innerHtmlValue);
			 /* e.preventDefault(); */
			 this.form.submit();
			 
		})
		
	});



	
	  $("#rk").on("change",function(){
		 var rk = $(this).val();
		 var cheInDate = $("#cheInyear").val() + "-" + $("#cheInmonth").val() +"-"+ $("#cheInday").val();
		var cheOutDate = $("#cheOutyear").val() + "-" + $("#cheOutmonth").val() +"-"+ $("#cheOutday").val();
		 console.log(rk);
 		$.ajax({
			url:"http://localhost/peregrine/comp/front/checkin/roomscount",
			method:'GET',
			data: "roomsname=" + rk+"&cheIn="+cheInDate+"&cheOut="+cheOutDate,
			dataType:'html',
			success:function(data){
				$("#roomnum").html(data);
			}
		}) 
	})  
	
});


	
	
	


</script>
</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
<h2>체크인</h2>
<h4>-고객정보</h4>

	<form:form>
	<div class = "infobox">고객 성</div> <input type="text" id = "fname" name = "customer.cosLName" class = "textput">
    <div class = "infobox">고객 이름</div> <input type="text" id = "lname" name = "customer.cosFName" class = "textput">
    <div class = "infobox">고객 전화번호</div> <input type="text" id = "phone" name = "customer.cosTelno" class = "textput">
    <div class = "infobox">이메일</div> <input type="text" id = "email" name = "customer.cosEmail" class = "textput">
    <div class = "infobox">알레르기 유무</div>
    <input type = "radio" class = "allergy1" name = "allergy" value="있음">있음
    <input type = "radio" class = "allergy1" name = "allergy" value="없음" checked="checked">없음
    <div id = "allergyinfo"  style = "display:none;">
    <div class = "infobox">알레르기 종류</div> <input type="text" id = "allergykind" name = "customer.cosAllergy">
    </div>
    
<h4>-수속정보</h4>
    <div class = "infobox">입실 예정일</div>
				<select id="cheInyear" class="year">
				</select>년
				<select id = "cheInmonth" class = "inmonth">
				</select>월
				<select id="cheInday" class="day">
				</select>일
				
	
	 <div class = "infobox">퇴실 예정일</div>
				<select id="cheOutyear" class="year">
				</select>년
				<select id="cheOutmonth" class = "outmonth">
				</select>월
				<select id="cheOutday" class="day">
				</select>일			
				
<h4>-객실정보</h4>	

		
	<div id = "roomname">			
    <select class = "roomskind" name = "room.roomName" id="rk">
    <c:forEach items="${list }" var="rlist">
    <option value="${rlist.roomName }">${rlist.roomName }</option>
    </c:forEach>
    </select>				
	</div>	
	
      
     <div id = "roomnum">객실수
    
     
    </div>
    
    <div id = "stayhidden">
			
    </div>
    
    <div id = "che_pre">객실 선호사항</div> <input type="text" id = "che_pre" name = "cheDetail" class = "textput">
	<div id = "hiddenBox">
	
	</div>
    
	<div id = "sub">
    <input type = "submit" value = "체크인" id = "submitBtn" class = "btn btn-primary btn-sm">
    <input type = "reset" value = "재작성" class = "btn btn-primary btn-sm">
    <input type = "button" onclick="location.href='../front'" value = "메인으로" class = "btn btn-primary btn-sm">
    </div>
    </form:form>
	</div>
	<footer></footer>
</body>
</html>