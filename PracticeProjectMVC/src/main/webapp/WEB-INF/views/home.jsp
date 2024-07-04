<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
</head>
<body class="loginPage">
<h1>주소록,회원관리 프로그램</h1><p>
관리자 ID: admin PW: 0000 <p>
주소록테스트 ID: test PW: 0000<p>
<a href="<c:url value='client/login'/>" id="loginButton">로그인화면으로 이동</a>
</body>
</html>
