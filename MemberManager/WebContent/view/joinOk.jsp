<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
<div>
	<br>
	<h3>☆${id }님 반가워~~~☆</h3>
	<div>
		<br>
		<h5>로그인해줘~~</h5>
		<button type="button" onclick="location.href='login.do'">login</button>
	</div>
</div>


</div>
</body>
</html>