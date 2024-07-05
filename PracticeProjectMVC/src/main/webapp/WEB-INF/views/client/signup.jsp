<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/signup.css'/>">
<script src="<c:url value='/javaScript/Client.js'/>"></script>
</head>
<body>
	<div class="signUpPage">
    <h2>회원가입</h2>
    
	<form name="registerForm" action="Client.js">
	
			<div id="signUpForm">
			<h3>아이디</h3> <input type ="search" name ="id" placeholder="영문,특수문자조합 8자 이상">
	
			<h3>비밀번호</h3> <input type ="password" name ="pw">
	
			<h3>비밀번호 확인</h3> <input type ="password" name ="pw_re">

			<h3>이름</h3> <input type ="search" name ="name">
	
			<h3>전화번호</h3> <input type ="search" name ="phone" placeholder="'-'를 포함하여 입력해주세요">

			<h3>이메일</h3> <input type ="search" name ="email" placeholder="'@'를 포함하여 입력해주세요">

			<h3>주소</h3> <input type ="search" name ="address">
			
			<input type="hidden" value="아직 메모가 없어요" name="memo">
			</div>
			
			
			<input type="button" value="회원가입" onclick="signUp()" id="signUp">
			<input type="reset" value="다시 쓰기" id="signUp">
			<a href="<c:url value='/client/login'/>" class="button">로그인화면</a>
	</form>
	</div>
</body>
</html>
