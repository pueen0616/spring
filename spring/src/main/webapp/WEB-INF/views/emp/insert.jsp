<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- c��ũ ����Ҷ� -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- ������ form�±� ����Ҷ� -->
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
<h1>������</h1>
<form:form action="empInsert" method="post" modelAttribute="emp">
	<c:if test="${not empty emp.employeeId}">
	<form:input path="employeeId" readonly="true"/><br>
	</c:if>
	<spring:message code="emp.firstName"/>
	<form:input path="firstName" placeholder="firstName"/><br>
	<form:errors path="firstName" cssClass="error" htmlEscape="false"/><br> <!-- �����޽��� -->
	
	<spring:message code="emp.lastName"/>
	<form:input path="lastName" placeholder="lastName"/><br>
	<form:errors path="lastName" cssClass="error" htmlEscape="false"/><br> <!-- �����޽��� -->
	
	<spring:message code="emp.email"/>
	<form:input path="email" placeholder="email"/><br>
	<form:errors path="email" cssClass="error" htmlEscape="false"/><br> <!-- �����޽��� -->
	<form:input path="hireDate" placeholder="hireDate"/><br>
<!-- 	����Ʈ -->
	<form:select path="jobId">
		<form:option value="">job ����</form:option> ÷�� ����
		<form:options items="${jobs}"
  					  itemLabel="jobTitle"
   					  itemValue="jobId"/>
   	</form:select><br>

	<form:errors path="jobId" cssClass="error" htmlEscape="false"/><br> <!-- �����޽��� -->
<!-- 	üũ�ڽ� -->
	<form:checkboxes path="departmentId"
					  items="${depts }"
					  itemLabel="departmentName"
					  itemValue="departmentId" cssClass="springfromcheck"/><br><br>
<!-- 	���� -->
<%-- 	<form:radiobuttons items="${jobs }" path="jobId"/><br><br>				   --%>
	
<%-- 	<form:select path="departmentId" items="${depts}" --%>
<%-- 							  itemLabel="departmentName"  --%>
<%-- 							  itemValue="departmentId"/> <!-- job_id���� ���� --><br> --%>
	<button>���</button>
</form:form>
</body>
</html>