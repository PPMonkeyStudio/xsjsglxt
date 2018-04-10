<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>技术管理首页</title>
</head>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<jsp:include page="/technologyManager.jsp" flush="true"></jsp:include>
</body>
</html>