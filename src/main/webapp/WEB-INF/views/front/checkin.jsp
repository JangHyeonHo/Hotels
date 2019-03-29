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
<!-- 폰트설정 -->
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung|Stylish" rel="stylesheet">

<link href="<c:url value="/resources/css/backHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/backFooter.css" />" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/checkin_content.css" />">
<script src="<c:url value='/js/checkin.js'></c:url>"></script>

<style type="text/css">

</style>
<script type="text/javascript">

</script>
</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../backHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id = "contents">
<h2>체크인</h2>

	<form:form>
	<fieldset>
	<legend>고객정보</legend>
	<div class = "infobox">고객 성</div> <input type="text" id = "fname" name = "customer.cosLName" class = "textput">
    <div class = "infobox">고객 이름</div> <input type="text" id = "lname" name = "customer.cosFName" class = "textput">
    <div class = "infobox">고객 전화번호</div> <input type="text" id = "phone" name = "customer.cosTelno" class = "textput">
    <div class = "infobox">이메일</div> <input type="text" id = "email" name = "customer.cosEmail" class = "textput">
    <div class = "infobox">알레르기 유무</div>
    <div id = "allergyInfo">
    <input type = "radio" class = "allergy1" name = "allergy" value="있음">있음
    <input type = "radio" class = "allergy1" name = "allergy" value="없음" checked="checked">없음
    </div>
    <div id = "allergyinfo"  style = "display:none;">
    <div class = "infobox">알레르기 종류</div> <input type="text" id = "allergykind" name = "customer.cosAllergy">
    </div>
    </fieldset>
    <fieldset>
	<legend>수속정보</legend>
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
	</fieldset>			
	<fieldset>
	<legend>객실정보</legend>

		
	<div id = "roomname">			
    <select class = "form-control" name = "room.roomName" id="rk">
    <c:forEach items="${list }" var="rlist">
    <option value="${rlist.roomName }">${rlist.roomName }</option>
    </c:forEach>
    </select>				
	</div>	
	
      
     <div id = "roomnum">
    
     
    </div>
    
    <div id = "stayhidden">
			
    </div>
    
    <div id = "che_pre">객실 선호사항</div> <input type="text" id = "chePre" name = "cheDetail">
	<div id = "hiddenBox">
	
	</div>
    </fieldset>
	<div id = "sub">
    <input type = "submit" value = "체크인" id = "submitBtn1" class = "customBtn btn btn-outline-danger">
    <input type = "reset" value = "재작성" id = "submitBtn2" class = "customBtn btn btn-outline-secondary">
   <input type = "button" id = "submitBtn3" onclick="history.back(-1)" value = "뒤로가기" class = "customBtn btn btn-primary btn">
    </div>
    </form:form>
	</div>
	<!-- 푸터 -->
	<jsp:include page="../backFooter.jsp" />
</body>
</html>