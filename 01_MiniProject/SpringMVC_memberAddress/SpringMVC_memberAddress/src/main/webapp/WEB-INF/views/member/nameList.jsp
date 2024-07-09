<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored = "false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름검색 결과</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/clientSearch.css' />">
</head>
<body>
<div class="clientSearch-page">
    <h3>${count}명의 같은 이름을 가진 회원이 존재합니다</h3>
    <hr>
	<table>
		<tr id="head-table">
			<td>아이디</td><td>이름</td><td>전화번호</td>
			<td>이메일</td><td>주소</td><td>가입일</td>
		</tr>
		<c:forEach var="list" items ="${list}">
		<tr>
			<td>${list.id}</td><td>${list.name}</td><td>${list.phone}</td>
			<td>${list.email}</td><td>${list.address}</td><td>${list.RDate}</td>
			<td><a href="<c:url value='/member/${list.id}'/>" id="viewButton">상세정보</a></td>
		</tr>
		</c:forEach>
	</table>
        <h4>조회할 회원을 선택해주세요</h4>
</div>
</body>
</html>