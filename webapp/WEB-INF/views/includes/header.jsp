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
	<div id="header" class="clearfix">
		<h1>
			<a href="/mysite4/main">ETUDE HOUSE</a>
		</h1>

		<c:choose>
			<c:when test="${sessionScope.authUser != null}">

				<!-- 로그인 성공했을 때 -->
				<ul>
					<li>김수빈 님 안녕하세요^^</li>
					<li><a href="/mysite4/user/logout" class="btn_s">로그아웃</a></li>
					<li><a href="/mysite4/user/modifyForm?no=${authUser.no}" class="btn_s">회원정보수정</a></li>
				</ul>
			</c:when>
			<c:otherwise>

				<!-- 로그인 실패 전 -->
				<ul>
					<li><a href="/mysite4/user/loginForm" class="btn_s">로그인</a></li>
					<li><a href="/mysite4/user/joinForm" class="btn_s">회원가입</a></li>
				</ul>
			</c:otherwise>
		</c:choose>

	</div>

</body>
</html>