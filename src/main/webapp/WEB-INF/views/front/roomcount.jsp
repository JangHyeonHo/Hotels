<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
객실수 :
<select id = "roomscount">
<c:forEach begin="1" end="${result }" step="1" var="i" >
<option value="${i }">${i }개</option>
</c:forEach>
</select>

</html>