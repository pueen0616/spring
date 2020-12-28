<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- c태크 사용할라꼬 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="empinsertForm">사원등록</a><br>
<c:forEach items="${list }" var="emp">
	<a href="empUpdateForm?employeeId=${emp.employeeId}">
	${emp.employeeId}</a>
	${emp.firstName}
	${emp.lastName}<br>
</c:forEach>
</body>
</html>