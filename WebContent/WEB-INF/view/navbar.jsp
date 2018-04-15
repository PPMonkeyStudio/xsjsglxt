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
<script src="<%=basePath%>js/vue.js"></script>
<script src="<%=basePath%>js/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>js/klorofil-common.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery.datetimepicker.full.js"></script>
<!--------------------------------------------------------------------------------->
<script type="text/javascript"
	src="<%=basePath%>js/User/Input_Select.js"></script>
<!--------------------------------------------------------------------------------->
<script type="text/javascript"
	src="<%=basePath%>js/User/updatePasswd.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/User/judgePower.js"></script> --%>
<!--------------------------------------------------------------------------------->
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		document
				.write('<div id="hideLayer" style="margin: 0 auto; background-color: white; position: fixed; width: 100%; height: 2000px; z-index: 9999999999999999999999999999999999999999;"><div style="width: 80px;height:79px; margin: 0 auto; margin-top: 200px;"><img alt=""src="/xsjsglxt/img/hui.png"><span style="color:black;">权限加载中</span></div></div>');
	</script>
	<div id="wrapper">
		<nav id="navbar" class="navbar navbar-default navbar-fixed-top"
			style=" background-color: #13599d;">
		<div
			style="width: auto; float: left; line-height: 78px; margin: 0 0 0 30px; font-size: 30px; color: white;">
			<img alt="" src="<%=basePath%>img/hui.png">安源刑侦信息管理系统
		</div>
		<div id="navbar-menu">
			<ul style="margin: 0 0 0 20px;" class="nav navbar-nav navbar-left">
				<li class="dropdown" style="float: left;"><a
					href="<%=basePath%>user/User_index"><span>首页</span> </a></li>
				<!--  -->
				<!--  -->
				<!--  -->
				<template v-if="user_army_manager_power">
				<li class="dropdown" style="float: left;"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span>队伍管理</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li style="float: left;"><a
							href="<%=basePath%>team/Staff_page_staffList">人员管理</a></li>
						<li class="teacher_control"><a
							href="<%=basePath%>scheduling/Scheduling_page_list ">值班管理</a></li>
						<li class="teacher_control"><a
							href="<%=basePath%>user/Meeting_skipToMeetRecords">会议记录</a></li>
						<li class="teacher_control"><a
							href="<%=basePath%>user/Memorabilia_skipToMemorabilia">大事记</a></li>
					</ul></li>
				</template>
				<li class="leader_control dropdown" style="float: left;"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown"> <span>刑事技术管理</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<template v-if="user_case_technology_power">
						<li><a href="<%=basePath%>case/Case_page_SiteManagement">现场管理</a></li>
						</template>
						<template v-if="user_check_power">
						<li><a
							href="<%=basePath%>inspectionIdentific/EntrustmentBookManagement_EntrustmentBookManagement"><span>检验鉴定</span></a></li>
						</template>
						<li><a href="<%=basePath%>user/User_skipToTechnologyIndex">技术管理</a></li>
					</ul></li>
				<!--  -->
				<template v-if="user_case_query_power">
				<li class="dropdown" style="float: left;"><a
					href="<%=basePath%>case/Case_page_Handle"> <span>侦查业务管理</span>
				</a></li>
				</template>
				<!--  -->
				<!--  -->
				<template v-if="user_user_manager_power">
				<li class="dropdown" style="float: left;"><a
					href="<%=basePath%>user/User_skipToUser"> <span>用户</span>
				</a></li>
				</template>
				<!--  -->
			</ul>
			<!--  -->
			<ul class="nav navbar-nav navbar-right" style="margin: 0 0px 0 0">
				<!--  -->
				<!--  -->
				<!--  -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-user-circle"></i> <span
						id="USER_NAME"><%=request.getSession().getAttribute("user_name")%></span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li data-toggle="modal" data-target="#updatePassword"><a
							href="#"> <i class="lnr lnr-lock"></i> <span>修改密码</span>
						</a></li>
						<li><a href="<%=basePath%>user/User_logout"> <i
								class="lnr lnr-exit"></i> <span>退出登录</span>
						</a></li>
					</ul></li>
				<!--  -->
			</ul>
		</div>
		</nav>


		<!-------------------------------------------------修改密码---------------------------------------------------------------  -->
		<div class="modal fade" id="updatePassword" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">修改用户</h4>
					</div>
					<div class="modal-body">
						<div id="passwordLoadingDiv"
							style="width: 319px; margin: 0 auto; display: none;">
							<img alt="" src="<%=basePath%>img/loading.gif">
						</div>
						<div id="passwordContent">
							<label>原始密码：</label> <input id="oldPassword" type="password"
								class="form-control" placeholder="请输入旧密码"> <label>新密码：</label>
							<input id="newPassword" type="password" class="form-control"
								placeholder="请输入新密码"> <label>再次输入：</label> <input
								id="newPasswordAgain" type="password" class="form-control"
								placeholder="再次输入新密码">
						</div>
					</div>
					<div class="modal-footer">
						<button onclick="showPwContent()" type="button"
							class="btn btn-default" data-dismiss="modal">关闭</button>
						<button id="updatePwBtn" onclick="updatePw()" type="button"
							class="btn btn-primary">修改</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

		<!-- -------------------------------------------------修改密码成功--------------------------------------------------------------- -->
		<script type="text/javascript">
			var userPowerDTO = {
				'user_case_technology_power' : false, //案件技术
				'user_case_query_power' : false, //案件侦查
				'user_check_power' : false, //检验鉴定
				'user_army_manager_power' : false, //队伍
				'user_technology_manager_power' : false,//技术
				'user_statistics_power' : false, //统计
				'user_user_manager_power' : false,
				'user_check_power_modified': false
			}

			var powerNavVue = new Vue({
				el : '#navbar-menu',
				data : userPowerDTO
			});
			//jurisdiction_admin管理
			//jurisdiction_none无
			$
					.ajax({
						url : '/xsjsglxt/user/User_judgePower',
						type : 'POST',
						success : function(data) {
							if (data == 'exception') {
								$
										.confirm({
											title : "请重新登录",
											content : "登录验证不通过，可能是未操作时间太久或者为登录造成",
											buttons : {
												reLogin : {
													text : "重新登录",
													btnClass : "btn-blue",
													action : function() {
														window.location = "/xsjsglxt/login.jsp";
													}
												}
											}
										});
								$("#hideLayer").hide();
							} else {
								var result = JSON.parse(data);
								if (result.user_case_technology_power == 'jurisdiction_admin') {
									userPowerDTO.user_case_technology_power = true;
								} else {
									userPowerDTO.user_case_technology_power = false;
								}
								if (result.user_case_query_power == 'jurisdiction_admin') {
									userPowerDTO.user_case_query_power = true;
								} else {
									userPowerDTO.user_case_query_power = false;
								}
								if (result.user_check_power == 'jurisdiction_none') {
									userPowerDTO.user_check_power = false;
								} else {
									userPowerDTO.user_check_power = true;
								}
								if(result.user_check_power == 'jurisdiction_use'){
									userPowerDTO.user_check_power_modified = false;
								}
								else{
									userPowerDTO.user_check_power_modified = true;
								}
								if (result.user_army_manager_power == 'jurisdiction_admin') {
									userPowerDTO.user_army_manager_power = true;
								} else {
									userPowerDTO.user_army_manager_power = false;
								}
								if (result.user_statistics_power == 'jurisdiction_admin') {
									userPowerDTO.user_statistics_power = true;
								} else {
									userPowerDTO.user_statistics_power = false;
								}
								if (result.user_user_manager_power == 'jurisdiction_admin') {
									userPowerDTO.user_user_manager_power = true;
								} else {
									userPowerDTO.user_user_manager_power = false;
								}
								if (result.user_technology_manager_power == 'jurisdiction_admin') {
									userPowerDTO.user_technology_manager_power = true;
								} else {
									userPowerDTO.user_technology_manager_power = false;
								}
								$("#hideLayer").hide();
							}
						}
					});
			
			jconfirm.defaults = {
					smoothContent: false
			}
		</script>
</body>
<script type="text/javascript">
	//getUserSessionForAjax();
</script>
<style>
#wrapper nav>div>ul>li>a {
	color: white;
}

td {
	line-height: 33px !important;
	vertical-align: middle !important;
}

th {
	line-height: 34px !important;
	vertical-align: middle !important;
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

table select {
	text-align: center !important;
}

table select {
	margin: auto;
}
</style>
<script>
	
</script>
</html>