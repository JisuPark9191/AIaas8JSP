<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/modifyClient.css' />">
</head>
<body>
	<div class="modifyClient-page">
	<div id="head">
	<h1>${clnt.name}</h1><h2>님의 정보 수정</h2>
	</div>
	<br><br><br><br><br>
	<form action="<c:url value = '/client/update' />" method="post" id="modifyClient-form">
	<h5>이름</h5> <input type="search"  name="name" value="${clnt.name}">
	<h5>전화번호</h5> <input type="search"  name="phone" value="${clnt.phone}">
	<h5>이메일</h5> <input type="email"  name="email" value="${clnt.email}">
	<h5>주소</h5> <input type="search"  name="address" value="${clnt.address}">
	
	<fieldset id="memo">
		<legend>메모</legend>
		<textarea name="memo" >${clnt.memo}</textarea>
	</fieldset>
	
	<input type="submit" value="수정 완료">
	<a href="<c:url value='/client/list'/>" class="button">메인으로</a>
	</form>
	</div>
</body>
</html>