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
			<h1>회원정보 수정</h1>
		</div>
		<div>
			<form action="updateOk.do" id="frm" name="frm" method="post" onsubmit="return updateFormCheck()">
				<div>
					<table border="1">
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>PASSWORD</th>
							<th>DATE</th>
							<th>ADDR</th>
							<th>TEL</th>
						</tr>
						<tr>
							<td>${dto.id }</td>
							<td><input type="text" id="name" name="name"></td>
							<td><input type="password" id="pw" name="pw"></td>
							<td>${dto.eDate }</td>
							<td><input type="text" id="addr" name="addr"></td>
							<td><input type="text" id="tel" name="tel"></td>
						</tr>
					</table>
				</div>
				<div>
					<input type="submit" value="submit"> <input type="reset"
						value="reset">
				</div>
			</form>
		</div>
	</div>
</body>
</html>