<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="test">
	<select name="testRadio">
		<option value="1">男</option>
		<option value="2">女</option>
	</select>
		<button onclick="get()">我是孙毅</button>
	</form>
	<script type="text/javascript">
		var get=function(){
				var formData=  new FormData(document.getElementById("test"));
				console.log(formData.get("testRadio"));
			}
	</script>
</body>
</html>