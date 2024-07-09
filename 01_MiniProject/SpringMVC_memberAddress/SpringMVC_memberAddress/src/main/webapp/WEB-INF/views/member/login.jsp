<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored = "false"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
<script src="<c:url value='/javaScript/member.js'/>"></script>
</head>
	<body>
		<div class="loginPage">
		<h2>로그인</h2>
		<form id="loginForm" name ="loginForm" action="member.js">
			<input type="text" name="id" placeholder="id" value="${id}">
			<hr>
			<input type="password" name="pw" placeholder="password">
			<hr>
			<input type="button" value="로그인" onclick="loginCheck()">
			<a href="<c:url value='/member/signup'/>"  class="button">회원가입</a>
		</form>
		</div>
	</body>
</html>