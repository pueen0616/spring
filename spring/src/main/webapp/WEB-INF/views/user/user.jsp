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
<a href="filedown?uFile=${user.profile }">파일다운</a> <!-- 리퀘스트매핑 주소이름 -->
<img src="images/${user.profile }"><br>

</body>
</html>