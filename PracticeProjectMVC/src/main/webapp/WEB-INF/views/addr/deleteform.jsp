<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소삭제</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/addrDeleteForm.css' />">
</head>
<body class="addr-delete">
	<h1>연락처 삭제</h1>
	${addr.name}님의 ${addr.phone} 연락처를 삭제합니다.<hr>
	확인을 위해 Y를 입력해주세요<hr>
	<form action="<c:url value = '/addr/delete'/>" method="post" id="deleteAddr">
	확인:<input type="text" name="confirm">
	<input type="hidden" name="id" value="${addr.id}">
	<input type="hidden" name="phone" value="${addr.phone}">
	<input type="submit" value="삭제">
	<a href="<c:url value='/addr/list?id=${addr.id}'/>" class="button">메인으로</a>
	</form>
</body>
</html>