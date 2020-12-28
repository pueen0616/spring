<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="userInsert" method="post" encType="multipart/form-data"><!-- encType 이미지 등록시 필수 -->
		아이디<input type="text" name="id"><br /> 
		패스워드<input type="text" name="password"><br /> 
		이름<input type="text" name="name"><br />
		<input type="radio" name="role" value="Admin"><br />Admin
		<input type="radio" name="role" value="User"><br />User
		첨부파일<input type="file" name="uploadFile" /><br /> 
		<input type="submit" value="저장">
	</form>
</body>
</html>