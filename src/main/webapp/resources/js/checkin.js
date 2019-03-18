
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

	//알러지 유무
	$("#allergy1").on("click",function(){
		var isclick = $("#allergy1").is(":checked");
		console.log(isclick);
		if(isclick){
			$("#allergyinfo").css("display","block");
		} else{
			$("#allergyinfo").css("display","none");
		}
	});

});