<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/myJavaScript.js"></script>
</head>
<body>
	<div id="memu" align="center">
		<nav id="topMenu">
			<ul>
				<li class="topMenuLi"><a class="menuLink" href="index.do">
						홈 </a></li>
				<li>|</li>
				<c:if test="${id !=null }">
					<li class="topMenuLi"><a class="menuLink" href="noticelist.do">공지사항</a> 
					<c:if test="${grant == 's' }">
							<ul class="submenu">
								<li><a href="#" class="submenuLink">글 등록</a></li>
								<li><a href="#" class="submenuLink">글 수정</a></li>
								<li><a href="#" class="submenuLink">글 삭제</a></li>
							</ul>
						</c:if></li>
					<li>|</li>
				</c:if>
				<li class="topMenuLi"><a class="menuLink" href="#">회원가입</a>
					<ul class="submenu">
						<c:choose>
							<c:when test="${grant =='s' }">
								<li><a href="memberlist.do" class="submenuLink">회원목록</a></li>
							</c:when>
							<c:when test="${grant == 'U' }">
								<li><a href="memberinfo.do" class="submenuLink">내정보 보기</a></li>
								<li><a href="memberUpdate.do" class="submenuLink">정보 수정</a></li>
								<li><a href="#" class="submenuLink">회원 탈퇴</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="joinForm.do" class="submenuLink">회원가입</a></li>
							</c:otherwise>
						</c:choose>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">자유게시판</a></li>
				<li>|</li>
				<c:choose>
					<c:when test="${id !=null }">
						<li class="topMenuLi"><a class="menuLink" href="logout.do">logout</a></li>
					</c:when>
					<c:otherwise>
						<li class="topMenuLi"><a class="menuLink" href="login.do">login</a></li>
					</c:otherwise>
				</c:choose>


			</ul>
		</nav>
	</div>
</body>
</html>