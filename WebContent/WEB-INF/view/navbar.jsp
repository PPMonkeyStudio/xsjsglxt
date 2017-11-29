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
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<!--------------------------------------------------------------------------------->
<script src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script src="<%=basePath%>js/bootstrap-select.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/chartist-custom.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/main.css">
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css">
<link rel="stylesheet" href="<%=basePath%>css/table.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script src="<%=basePath%>js/toastr.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery-confirm.css" />
<script src="<%=basePath%>js/jquery-confirm.js"></script>
<!--------------------------------------------------------------------------------->
<script src="<%=basePath%>js/jquery.bootstrap.wizard.js"></script>
<script src="<%=basePath%>js/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>js/klorofil-common.js"></script>
<!--------------------------------------------------------------------------------->
<!---页面公用------------------------------------------------------------------------------>
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div
			style="width: auto; float: left; line-height: 78px; margin: 0 0 0 30px; font-size: 30px;">刑事技术管理系统</div>
		<div id="navbar-menu">
			<ul class="nav navbar-nav navbar-left" style="margin: 0 0 0 20px">
				<li class="dropdown" style="float: left;"><a
					href="<%=basePath%>loginLogout/LoginLogoutManagement_index"> <span>首页</span>
				</a></li>
				<!--  -->
				<li class="leader_control dropdown" style="float: left;"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown"> <span>案件</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">现场管理</a></li>
						<li><a href="#">案件串并</a></li>
						<li><a href="#">案件材料</a></li>
						<li><a href="#">办案管理</a></li>
						<li><a href="#">刑事破案</a></li>
					</ul></li>
				<!--  -->
				<li class="dropdown" style="float: left;"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span>检验鉴定</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">委托书管理</a></li>
						<li><a href="#">检验记录</a></li>
						<li><a href="#">检验结果</a></li>
					</ul></li>
				<!--  -->
				<li class="dropdown" style="float: left;"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span>队伍</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li class="teacher_control"><a href="#">值班管理</a></li>
						<li class="teacher_control"><a href="#">人员管理</a></li>
					</ul></li>
				<!--  -->
				<!--  -->
				<li class="dropdown" style="float: left;"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span>技术</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li class="teacher_control"><a
							href="<%=basePath%>DNA/DNAManagement_DNAManagementPage">DNA</a></li>
						<li class="teacher_control"><a
							href="<%=basePath%>FingerPrint/FingerPrintManagement_FingerPrintManagementPage">指纹</a></li>
						<li class="teacher_control"><a
							href="<%=basePath%>Equipment/EquipmentManagement_EquipmentManagementPage">器材装备</a></li>
						<li class="teacher_control"><a
							href="<%=basePath%>ContrastFingerPrint/ContrastFingerPrintManagement_ContrastFingerPrintManagementPage">比中指纹</a></li>
					</ul></li>
				<!--  -->
				<li class="dropdown" style="float: left;"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span>统计</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li class="teacher_control"><a href="#">办案统计</a></li>
						<li class="teacher_control"><a href="#">检验统计</a></li>
					</ul></li>
				<!--  -->
				<li class="dropdown" style="float: left;"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span>用户</span>
				</a></li>
				<!--  -->
			</ul>
			<!--  -->
			<ul class="nav navbar-nav navbar-right" style="margin: 0 0px 0 0">
				<!--  -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-user-circle"></i> <span
						id="USER_NAME">龙建平</span> <i
						class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<%-- <li>
							<a href="#">
								<i class="lnr lnr-user"></i>
								<span>我的信息</span>
							</a>
						</li> --%>
						<li><a href="#"> <i class="lnr lnr-lock"></i> <span>修改密码</span>
						</a></li>
						<li><a
							href="<%=basePath%>loginLogout/LoginLogoutManagement_logout">
								<i class="lnr lnr-exit"></i> <span>退出登录</span>
						</a></li>
					</ul></li>
				<!--  -->
			</ul>
		</div>
		</nav>
</body>
<script type="text/javascript">
	getUserSessionForAjax();
</script>
<style>
td {
	line-height: 33px !important;
}

td i {
	line-height: 33px !important;
}

td button i {
	line-height: 20px !important;
}

td .label {
	line-height: 33px !important;
}
</style>
<script>
	
</script>
</html>