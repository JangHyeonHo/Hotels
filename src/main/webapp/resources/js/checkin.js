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
	
	
/* 	var selectValue = "<select class = 'roomskind'>";
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
	
	$(".roomskind").html(selectValue); */
	
	
	var guestNo = "";
	for(var w = 1; w <= 1; w++){
		if(w != 0){
			guestNo += "객실번호 <input type='text' name='grNo'>";
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
	
	$("#roomscount").on("change",function(){
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

