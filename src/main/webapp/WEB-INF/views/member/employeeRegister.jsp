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
<link href="https://fonts.googleapis.com/css?family=Source+Serif+Pro" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua|Song+Myung|Stylish" rel="stylesheet">
<script src="<c:url value="/js/backHeader.js"></c:url>" ></script>
<link href="<c:url value="/css/backHeader.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/backFooter.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/employeelist_content.css" />" rel="stylesheet" type="text/css">

</head>
<body>
<!-- 헤더 푸터 건들지 말것(필수는 아님) -->
	<jsp:include page="../backHeader.jsp" />
	<!-- 실제 작성 구간 -->
	<div id = "contents">
	<div id = "con">
		<div id = "title">
			<h2>직원등록</h2>
		</div>
	<form:form>
	<div id = "con2">
	<div class = "form-inline"><label>직원 성명 :</label> <input type="text" class="form-control" name="empName"></div> <br>
	<div class = "form-inline"><label>이메일 :</label> <input type="email" class="form-control" name="empEmail"></div> <br>
	<div class = "form-inline"><label>전화 번호 :</label> <input type="text" class="form-control" name="empPhone"></div> <br>
	<div class = "form-inline"><label>생년월일 :</label> <input type="date" class="form-control" name="empBDate"></div> <br>
	<div class = "form-inline"><label>성별 : 남</label><input type="radio" class="rado" name="empGender" value="M"> 
	     <label>여</label><input type="radio" class="rado" name="empGender" value="F"></div> <br>
	<div class = "form-inline"><label>급여 :</label> <input type="text" class="form-control" name="empSalary"></div> <br>
	<div class = "form-inline"><label>주소 :</label> <input type="text" class="form-control" name="empAddr"></div> <br>
	<div class = "form-inline"><label>통장 계좌번호 :</label> <input type="text" class="form-control" name="empAccNum"></div> <br> 
	<div class = "form-inline"><label>통장 은행명 :</label> <input type="text" class="form-control" name="empAccBank"></div> <br>
	<div class = "form-inline"><label>상의 사이즈 :</label> <input type="text" class="form-control" name="empTopSize"></div> <br>
	<div class = "form-inline"><label>하의 사이즈 :</label> <input type="text" class="form-control" name="empBotSize"></div> <br>
	<div class = "form-inline"><label>부서명 :</label> <input type="text" class="form-control" name="empDepartName"></div> <br>
	<div class = "form-inline"><label>직급명 :</label><input type="text" class="form-control" name="empManageName"></div> <br>
	
	</div>
	<input type="submit" class="btn btn-danger btn-a" value="등록">
	<input type = "button" id = "submitBtn3" onclick="history.back(-1)" value = "뒤로가기" class = "btn btn-primary btn btn-a">
	</form:form>
	</div>
	</div>
	<jsp:include page="../backFooter.jsp" />
</body>
</html>