<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${user.id}<br>
${user.password}<br>
${user.name }<br>
${user.role }<br>
${user.profile }<br>
<a href="filedown?uFile=${user.profile }">���ϴٿ�</a> <!-- ������Ʈ���� �ּ��̸� -->
<img src="images/${user.profile }"><br>

</body>
</html>