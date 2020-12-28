<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- c태크 사용할라꼬 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- 스프링 form태그 사용할라꼬 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.error {
	color:red;
}
</style>
</head>
<body>
<h1>사원등록</h1>
<form:form action="empInsert" method="post" modelAttribute="emp">
	<c:if test="${not empty emp.employeeId}">
	<form:input path="employeeId" readonly="true"/><br>
	</c:if>
	<spring:message code="emp.firstName"/>
	<form:input path="firstName" placeholder="firstName"/><br>
	<form:errors path="firstName" cssClass="error" htmlEscape="false"/><br> <!-- 에러메시지 -->
	
	<spring:message code="emp.lastName"/>
	<form:input path="lastName" placeholder="lastName"/><br>
	<form:errors path="lastName" cssClass="error" htmlEscape="false"/><br> <!-- 에러메시지 -->
	
	<spring:message code="emp.email"/>
	<form:input path="email" placeholder="email"/><br>
	<form:errors path="email" cssClass="error" htmlEscape="false"/><br> <!-- 에러메시지 -->
	<form:input path="hireDate" placeholder="hireDate"/><br>
<!-- 	셀렉트 -->
	<form:select path="jobId">
		<form:option value="">job 선택</form:option> 첨에 선택
		<form:options items="${jobs}"
  					  itemLabel="jobTitle"
   					  itemValue="jobId"/>
   	</form:select><br>

	<form:errors path="jobId" cssClass="error" htmlEscape="false"/><br> <!-- 에러메시지 -->
<!-- 	체크박스 -->
	<form:checkboxes path="departmentId"
					  items="${depts }"
					  itemLabel="departmentName"
					  itemValue="departmentId" cssClass="springfromcheck"/><br><br>
<!-- 	라디오 -->
<%-- 	<form:radiobuttons items="${jobs }" path="jobId"/><br><br>				   --%>
	
<%-- 	<form:select path="departmentId" items="${depts}" --%>
<%-- 							  itemLabel="departmentName"  --%>
<%-- 							  itemValue="departmentId"/> <!-- job_id별로 볼라꼬 --><br> --%>
	<button>등록</button>
</form:form>
</body>
</html>