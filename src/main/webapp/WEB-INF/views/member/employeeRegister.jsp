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
<title>직원 등록</title>

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


</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<header></header>
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<h1>직원등록</h1>
	<form:form>
	직원 성명 <input type="text" name="empName"> <br>
	이메일 <input type="email" name="empEmail"> <br>
	전화 번호 <input type="text" name="empPhone"> <br>
	생년월일 <input type="date" name="empBDate"> <br>
	성별  남 <input type="radio" name="empGender" value="M"> 
	       여<input type="radio" name="empGender" value="F"> <br>
	급여 <input type="text" name="empSalary"> <br>
	주소 <input type="text" name="empAddr"> <br>
	통장 계좌번호 <input type="text" name="empAccNum"> <br> 
	통장 은행명 <input type="text" name="empAccBank"> <br>
	상의 사이즈 <input type="text" name="empTopSize"> <br>
	하의 사이즈 <input type="text" name="empBotSize"> <br>
	부서명 <input type="text" name="empDepartName"> <br>
	직급명 <input type="text" name="empManageName"> <br>
	<input type="submit" value="등록">
	</form:form>
	</div>
	<footer></footer>
</body>
</html>