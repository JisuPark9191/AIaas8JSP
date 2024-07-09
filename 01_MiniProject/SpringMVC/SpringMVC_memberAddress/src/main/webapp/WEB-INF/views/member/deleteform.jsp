<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/clientDeleteForm.css' />">
</head>
<body class="client-delete">
	<h1>회원 삭제</h1>
	ID : ${mem.id}/PW: ${mem.pw}  ${mem.name}님의 회원정보를 삭제합니다.<p>
	확인을 위해 비밀번호(PW)를 입력해주세요<p>
	<form action="<c:url value = '/member/delete'/>" method="post" id="deleteClient">
	확인:<input type="text" name="pw">
	<input type="hidden" name="id" value="${mem.id}">
	<input type="submit" value="삭제">
	<a href="<c:url value='/member/list'/>" class="button">메인으로</a>
	</form>
</body>
</html>