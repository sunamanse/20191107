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
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<br>
			<c:choose>
				<c:when test="${id !=null }">
					<h1>${id }님이미등록회원</h1>
				</c:when>
				<c:otherwise>
					<h1>J O I N</h1>
					<div>
					
						<form action="joinOk.do" id="frm" name="frm" method="post" onsubmit="return memberformCheck()" >
							<div>
								<table border="1">
									<tr>
										<th>I D</th>
										<td><input type="text" id="id" name="id">
											<button type="button" id="idck" name="idck" onclick="idCheck()"	value="unCheck">Check</button>
									</tr>
									<tr>
										<td align="center"><b>N A M E </b></td> 
										<td><input type="text" id="name" name="name">
									</tr>
									<tr>
										<td align="center"><b>PASSWORD </b></td>
										<td><input type="password" id="pw" name="pw">
									</tr>
									<tr>
										<td align="center"><b>PASSWORD check </b></td>
										<td><input type="password" id="pwck" name="pwck">
									</tr>
									<tr>
										<td align="center"><b>A D D R </b></td>
										<td><input type="text" id="addr" name="addr">
									</tr>
									<tr>
										<td align="center"><b>T E L </b></td>
										<td><input type="text" id="tel" name="tel">
									</tr>

								</table>
							</div>
							<div>
								<br> <input type="submit" value="Join"> 
								<input type="reset" value="Reset">
							</div>
						</form>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>