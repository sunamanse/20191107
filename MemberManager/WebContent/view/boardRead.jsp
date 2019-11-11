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
			<h1>게시글 세부 조회</h1>
		</div>
		<div>	
				<div>
					<table border="1">
						<tr>
							<th width="30">No.</th>
							<td align="center" width="30" id="id"><input type="hidden"
								id="id" name="id" value="${dto.id }">${dto.id }</td>
							<th width="70">작성자</th>
							<td align="center" width="70">${dto.writer}</td>
							<th width="70">작성일자</th>
							<td align="center" width="70">${dto.wdate}</td>
							<th width="70">조회수</th>
							<td align="center" width="70">${dto.hit}</td>
						</tr>
						<tr>
							<th colspan="3">제목</th>
							<td colspan="5">${dto.title}</td>
						</tr>
						<tr>
							<th colspan="3">내용</th>
							<td colspan="5" height="70">${dto.content}</td>
						</tr>
					</table>
				</div>
				<div>
					<c:if test="${id == dto.userID}">
						<br>
						
						<button type="button" onclick="location.href='boardEdit.do'">수정</button>
						<button type="button" onclick="location.href='boardDelete.do'">삭제</button>
					</c:if>
					<button type="button" onclick="location.href='boardList.do'">목록</button>
				</div>
			
		</div>
	</div>
</body>
</html>