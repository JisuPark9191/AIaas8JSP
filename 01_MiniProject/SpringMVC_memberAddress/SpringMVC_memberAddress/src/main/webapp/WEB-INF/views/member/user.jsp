<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저정보</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/modifyUser.css' />">
<script type="text/javascript" src="<c:url value='/javaScript/member.js'/>"></script>
</head>
<body>
    <div class="modifyUser-page">
    <div id="head">
    <h1>${user.name}</h1><h2>님의 정보</h2>
	</div>
	<br><br><br><br><br>
        <form name="modifyUserForm" action="member.js" id="modifyUserForm">
        <h5>비밀번호</h5><input type="search" name="pw">
        <h5>비밀번호 확인</h5><input type="search" name="pw_re">
        <h5>이름</h5><input type="search" name="name" value="${user.name}">
        <h5>전화번호</h5><input type="search" name="phone" value="${user.phone}">
        <h5>이메일</h5><input type="email" name="email" value="${user.email}">
        <h5>주소</h5><input type="search" name="address" value="${user.address}">

        <input type="button" value="수정" onclick="modifyUser()">
        <a href="<c:url value='/member/userDelete?id=${user.id}'/>" class="button">회원탈퇴</a>
	    <a href="<c:url value='/addr/list?id=${user.id}'/>" class="button">메인으로</a>
	    
	    <input type="hidden" value="${user.id}" name="id">
	    <input type="hidden" value="${user.memo}" name="memo">
	    <input type="hidden" value="${user.RDate}" name="rDate">
	</form>
    </div>
</body>
</html>