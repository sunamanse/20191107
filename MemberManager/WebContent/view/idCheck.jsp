<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/myJavaScript.js"></script>
</head>
<body>
	<div align="center">
		<div>
			<br>
			<c:choose>
				<c:when test="${idckeck == true }">
					<h1>${id }쓸수있서 쓸래?</h1>
					<div>
						<br>
						<button type="button" onclick="openFormClose(1)">확인</button>
					</div>
				</c:when>
				<c:otherwise>
					<h1>${id }있지렁~~~~~</h1>
					<div>
						<br>
						<button type="button" onclick="openFormClose(2)">다시</button>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>