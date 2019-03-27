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
<script src="../../js/checkin.js"></script>
<style type="text/css">



</style>
<script type="text/javascript">
$(function(){

	
	  $("#rk").on("change",function(){
		 var rk = $(this).val();
		 console.log(rk);
 		$.ajax({
			url:"http://localhost:4444/peregrine/comp/front/checkin/roomscount",
			method:'GET',
			data: "roomsname=" + rk,
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
				
				
	<div id = "roomname">			
    <select class = "roomskind" name = "room.roomName" id="rk">
    <c:forEach items="${list }" var="rlist">
    <option value="${rlist.roomName }">${rlist.roomName }</option>
    </c:forEach>
    </select>				
	</div>	
	
<h4>-객실정보</h4>
      
     <div id = "roomnum">객실수
    
     
    </div>
    
    <div id = "stayhidden">
			
    </div>
    
    <div id = "che_pre">객실 선호사항</div> <input type="text" id = "che_pre" name = "cheDetail">
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