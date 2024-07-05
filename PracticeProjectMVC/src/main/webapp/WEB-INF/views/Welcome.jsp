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
=============================<p>
관리자 ID: admin PW: 0000 <p>
주소록테스트 ID: test PW: 0000<p>
=============================<p>
ClientDB 생성 SQL문 = <p>
CREATE TABLE client (<p>
id VARCHAR2(20) PRIMARY KEY,<p>
pw VARCHAR2(20),<p>
name VARCHAR2(20),<p>
phone VARCHAR2(20),<p>
eMail VARCHAR2(20),<p>
address VARCHAR2(50),<p>
rDate date,<p>
memo VARCHAR2(100));<p>
==============================<p>
AddressDB 생성 SQL문 = <p>
CREATE TABLE address (<p>
id VARCHAR2(20),<p>
name VARCHAR2(20),<p>
phone VARCHAR2(20) PRIMARY KEY,<p>
email VARCHAR2(30),<p>
address VARCHAR2(50),<p>
addrGroup VARCHAR2(20),<p>
CONSTRAINT ClientId_fk FOREIGN KEY(id) REFERENCES client(id)<p>
ON DELETE CASCADE);<p>
=============================<p>
<a href="<c:url value='client/login'/>" id="loginButton">로그인화면으로 이동</a>
</body>
</html>
