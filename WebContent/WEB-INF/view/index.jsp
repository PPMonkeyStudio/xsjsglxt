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
<!---------------------------------------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------->
<title>首页</title>
</head>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 120px 0 0 10%; width: 80%; float: left;">
		<!------------------------------------------------------------------------------------------>
		<div style="float: left; width: 100%;">
			<h3>案件</h3>
			<hr>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">案件录入</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-plus-circle fa-4x"></i>
						<h3>录入案件现场</h3>
					</div>
				</div>
			</div>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">物证录入</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-plus-circle fa-4x"></i>
						<h3>录入物证的信息</h3>
					</div>
				</div>
			</div> 
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">案件串并</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-random fa-4x"></i>
						<h3>合并多个案子</h3>
					</div>
				</div>
			</div>
		</div>
		<!------------------------------------------------------------------------------------------>
		<div style="float: left; width: 100%;">
			<h3>检验鉴定</h3>
			<hr>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">痕迹检验委托</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-pencil-square-o fa-4x"></i>
						<h3>填写痕迹检验委托书</h3>
					</div>
				</div>
			</div>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">法医检验委托</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-pencil-square-o fa-4x"></i>
						<h3>填写法医检验委托书</h3>
					</div>
				</div>
			</div>
		</div>
		<!------------------------------------------------------------------------------------------>
		<div style="float: left; width: 100%;">
			<h3>技术</h3>
			<hr>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">DNA</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-pencil fa-4x"></i>
						<h3>录入DNA记录</h3>
					</div>
				</div>
			</div>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">指纹</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-pencil fa-4x"></i>
						<h3>录入指纹记录</h3>
					</div>
				</div>
			</div>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">影像光盘</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-pencil fa-4x"></i>
						<h3>录入影像光盘记录</h3>
					</div>
				</div>
			</div>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">器材装备</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-pencil fa-4x"></i>
						<h3>录入器材装备记录</h3>
					</div>
				</div>
			</div>
			<!--  -->
		</div>
		<!------------------------------------------------------------------------------------------>
		<div style="float: left; width: 100%;">
			<h3>队伍和人员</h3>
			<hr>
			<!--  -->
			<div class="panel"
				style="width: 350px; float: left; margin-right: 40px;">
				<div class="panel-heading">
					<h3 class="panel-title">新增人员</h3>
				</div>
				<div class="panel-body no-padding bg-primary text-center">
					<div class="padding-top-30 padding-bottom-30">
						<i class="fa fa-users fa-4x"></i>
						<h3>新增一条人员信息</h3>
					</div>
				</div>
			</div>
		</div>

		<!------------------------------------------------------------------------------------------>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
<script>
	
</script>
</html>