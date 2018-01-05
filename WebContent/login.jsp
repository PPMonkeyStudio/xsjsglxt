<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--------------------------------------------------------------------------------->
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script type="text/javascript" src="<%=basePath%>js/bootstrap-select.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/chartist-custom.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/main.css">
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css">
<link rel="stylesheet" href="<%=basePath%>css/table.css">
<link rel="stylesheet" href="<%=basePath%>css/login.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script type="text/javascript" src="<%=basePath%>js/toastr.js"></script>
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<script type="text/javascript" src="<%=basePath%>js/User/login.js"></script>
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<title>刑事技术管理系统</title>
</head>
<body>
	<%-- <input type="email" class="form-control" id="login_username"
		style="width: 298px; height: 46px; margin-left: 936px; margin-top: 362px;">
	<input type="password" class="form-control" id="login_password"  
		style="width: 298px; height: 46px; margin-left: 936px; margin-top: 18px;"> 
	<button id="button_login"
		style="border: 0px; background-color: #0B1D29; margin-left: 928px; margin-top: 31px;"
		onclick="login()"> 
		<img src="<%=basePath%>img/login_button.png"> 
	</button> --%>
	
	<div class="bg">
			<div class="bg_center">
				<p>刑事技术管理系统</p>
				<div class="input_box"><label>帐户</label><input type="text" id="login_username"/></div>
				<div class="input_box"><label>密码</label><input type="password" id="login_password"/></div>
				<div class="button_box">
					<div>重置信息</div>
					<div onclick="login()">确认登录</div>
				</div>
			</div>
		</div>
	
	<%-- <div class="panel" style="width: 550px; margin: 100px auto;">
		<div class="panel-heading">
			<div>
				<img src="<%=basePath%>img/logo.jpg" height="40px">
			</div>
			<h2 style="text-align: center;">刑事技术管理系统</h2>
		</div>
		<div class="panel-body" style="margin: 0 0 20px 0;">
			<div class="form-group">
				<input type="email" class="form-control" id="login_username" placeholder="用户名">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" id="login_password" placeholder="密码">
			</div>
			<br>
			<button id="button_login" class="btn btn-primary  btn-block" onclick="login()">登录</button>
		</div>
	</div> --%>
</body>
</html>