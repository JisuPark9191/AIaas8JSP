<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored = "false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름검색 결과</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/addrSearch.css' />">
</head>
<body>
<div class="addrSearch-page">
	<form>
	    <h3>${count}개의 같은 이름을 가진 주소가 존재합니다</h3>
	<table>
		<tr id="head-table">
			<td>이름</td><td>전화번호</td><td>이메일</td><td>주소</td><td>그룹</td><td></td>
		</tr>
		<c:forEach var="list" items ="${list}">
			<tr>
				<td>${list.name}</td><td>${list.phone}</td><td>${list.email}</td>
				<td>${list.address}</td><td>${list.addrGroup}</td>
				<td><a href="<c:url value='/addr/${list.phone}?id=${list.id}'/>" id="viewButton">상세정보</a></td>
			</tr>
		</c:forEach>
	</table>
        <h4>원하는 주소를 선택해주세요</h4>
	</form>
</div>
</body>
</html>