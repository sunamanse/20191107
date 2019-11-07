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
			<h2>${id } goodbye!</h2>
			
		</div>
		<div>
			<br>
			<button type="button" onclick="location.href='index.do'">H O
				M E</button>
		</div>
	</div>
</body>
</html>