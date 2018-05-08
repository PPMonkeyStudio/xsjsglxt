<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="http://localhost:8080/xsjsglxt/case/Case_uploadFile" enctype="multipart/form-data">
		<input name="case1.xsjsglxt_case_id" type="text">
		<input name="filePosition" type="text">
		<input name="writeText" type="file">
		<input type="submit" value="上传">
	</form>
</body>
</html>