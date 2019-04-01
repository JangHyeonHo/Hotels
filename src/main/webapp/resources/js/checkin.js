$(function(){
	$('#cheInDatePicker').daterangepicker({
		"showDropdowns" : true,
		"minYear" : new Date().getFullYear(),
		"maxYear" : (new Date().getFullYear())+2,
		"timePicker": true,
		"timePicker24Hour": true,
		"timePickerIncrement": 60,
		"startDate" : moment().startOf('hour'),
		"endDate": moment().startOf('hour').add(24, 'hour'),
		"minDate" : new Date().toISOString().substring(0,10),
		"maxSpan": {
			"days": 30
		},
		"locale": {
			"format": "YYYY-MM-DD HH:mm",
			"separator": " / ",
			"applyLabel": "등록",
			"cancelLabel": "취소",
			"fromLabel": "체크 인",
			"toLabel": "체크 아웃",
			"customRangeLabel": "Custom",
			"weekLabel": "주",
			"daysOfWeek": [
				"일",
				"월",
				"화",
				"수",
				"목",
				"금",
				"토"
				],
				"monthNames": [
					"1월",
					"2월",
					"3월",
					"4월",
					"5월",
					"6월",
					"7월",
					"8월",
					"9월",
					"10월",
					"11월",
					"12월"
					],
					"firstDay": 1
		},
	});
	$("#cheInDatePicker").on("change",function(){
		var thisValue = $(this).val();
		var fromAndTo = thisValue.split(" / ")
//		console.log(fromAndTo[0]);
		if(fromAndTo[0].substring(0,10)==fromAndTo[1].substring(0,10)){
			alert("같은 날로 예약은 불가능 합니다.");
			$(this).val("");
			return false;
		}

	})

	/*//입실,퇴실 예정일
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
		})*/
	$("#email").on("focusout",function(){
			var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
			var regVal = $("#email").val();
			if($("#email").val().length!=0){
				if(regVal.match(emailReg) != null){
					
				}else{
					alert("이메일이 옳바르지 않습니다.");
					$("#email").val("");
				}
			}
			
		 })

	$(".allergy1").on("click",function(){
		var value = $(this).val();
//		console.log(value);
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
	
	var	guestNo = "객실번호 <input type='text' name='grNo' class = 'guestNo'>";

	var dinAdult = "<select class = 'form-control DinAdult'name = 'DinAdult'>";
	dinAdult += "<option id = 'AduTitle' value='0'>석식 성인 인원</option>";
	dinAdult += "</select>";
	var dinChild = "<select class = 'form-control DinChild' name = 'DinChild'>";
	dinChild += "<option id = 'ChiTitle' value='0'>석식 어린이 인원</option>";
	dinChild += "</select>";
	
	var firstBoxing = innerHtmlValue + guestNo + dinAdult + dinChild + "<br>";
//	$("#stayhidden").html(firstBoxing)
	
	$(document).on("change",".stay_num",function(){
		var stayVal = $(this).val();
//		console.log(stayVal+1);
		var aduDin = "<option id = 'AduTitle' value='0'>석식 성인 인원</option>";
		for(var i = 1; i <= stayVal; i++){
//			console.log(i);
			aduDin += "<option value='"+ i +"'>석식성인 : " + i + "명</option>";
		}
		var ain = $(this).next().next().html(aduDin);
	})
	
	$(document).on("change",".DinAdult",function(){
		var stayVal = $(this).prev().prev().val();
		var adlVal = $(this).val();
		var childVal = $(this).next().val();
		var chiDin = "<option id = 'ChiTitle' value='0'>석식 어린이 인원</option>";
		for(var i = 1; i <= stayVal-adlVal; i++){
			chiDin += "<option value="+ i +">석식어린이 : " + i + "명</option>";
		}
		var cin = $(this).next().html(chiDin);

	})
	
	$(document).on("change",".DinChild",function(){
		var stayVal = $(this).prev().prev().prev().val();
		var adlVal =  $(this).prev().val();
		var childVal = $(this).val();
		if(adlVal > stayVal-childVal){
			var aduDin = "<option id = 'AduTitle' value='0'>석식 성인 인원</option>";
			for(var i = 1; i <= stayVal-childVal; i++){
				aduDin += "<option value='"+ i +"'>석식성인 : " + i + "명</option>";
			}
			var ain = $(this).prev().html(aduDin);
		}
		
	})
	
	
		






//	var dinAdult = "<select class = 'form-control' name = 'DinAdult'>";
//	//식사 인원수 1부터 20까지 증가시킴
//	for(var i = 0; i <= 10; i++){
//		if(i == 0 ){
//			dinAdult += "<option value="+ i +">석식 성인 인원</option>";
//		}else{
//			dinAdult += "<option value="+ i +">석식성인 : " + i + "명</option>";
//		}
//	}
//	
//	//che_pre에 넣어줌
//
//	var dinChild = "<select class = 'form-control' name = 'DinChild'>";
//	//식사 인원수 1부터 20까지 증가시킴
//	for(var i = 0; i <= 10; i++){
//		if(i == 0 ){
//			dinChild += "<option value="+ i +">석식 어린이 인원</option>";
//		}else{
//			dinChild += "<option value="+ i +">석식 어린이 : " + i + "명</option>";
//		}
//	}
//	dinChild += "</select>";
//	//che_pre에 넣어줌


	

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

//		console.log(AllRooms);

	})
	
	


	var inputHidden = "<input type = 'hidden' name="

		$("#submitBtn").on("click",function(e){
			if($("#cheInDatePicker").val()==""){
				alert("날짜를 입력해주세요!")
				return false;
			}
			var gN = $(".guestNo");
			var gNLen = gN.length;
			for(var a = 0; a < gNLen-1 ; a++){
				for(var b = a+1; b < gNLen ; b++){
					if(gN.eq(a).val()==gN.eq(b).val()){
						alert("같은 방번호를 등록하실 수 없습니다!")
						return false;
					}
				}
			}

			var thisValue = $("#cheInDatePicker").val();
			var fromAndTo = thisValue.split(" / ")
			var checkInHiddenHtml = inputHidden + "'cheInDate' value='"+ fromAndTo[0] +"'>"
			var checkOutHiddenHtml = inputHidden + "'cheOutDate' value='"+ fromAndTo[1] +"'>"
			var innerHtmlValue = checkInHiddenHtml + checkOutHiddenHtml
			$("#hiddenBox").html(innerHtmlValue);
			
			 /*e.preventDefault(); */
			this.form.submit();

		})


		$("#rk").on("change",function(){
			$("#stayhidden").html("");
			var rk = $(this).val();
			var thisValue = $("#cheInDatePicker").val();
			var fromAndTo = thisValue.split(" / ");
//			console.log(fromAndTo[1])
			var cheInDate = fromAndTo[0].substring(0,10);
			var cheOutDate = fromAndTo[1].substring(0,10);
//			console.log(rk);
			$.ajax({
				url:"./checkin/roomscount",
				method:'GET',
				data: "roomsname=" + rk+"&cheIn="+cheInDate+"&cheOut="+cheOutDate,
				dataType:'html',
				success:function(data){
					$("#roomnum").html(data);
					$("#stayhidden").html(firstBoxing)
				}
			}) 
		})  


});





