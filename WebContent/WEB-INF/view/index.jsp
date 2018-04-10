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
<script type="text/javascript">
	window.onload = function() {
		/* $('#hideLayer').hide(); */
		getCurrentTime();
		setInterval(getCurrentTime, 1000);
	}
	function getCurrentTime() {
		var now = new Date();

		var year = now.getFullYear(); //年
		var month = now.getMonth() + 1; //月
		var day = now.getDate(); //日

		var hh = now.getHours(); //时
		var mm = now.getMinutes(); //分

		var clock = year + "-";

		if (month < 10)
			clock += "0";

		clock += month + "-";

		if (day < 10)
			clock += "0";

		clock += day + " ";

		if (hh < 10)
			clock += "0";

		clock += hh + ":";
		if (mm < 10)
			clock += '0';
		clock += mm;
		console.log(clock);
		document.getElementById("current_time").innerHTML = clock;
	}
</script>
</head>
<body>
	<div id="wrapper">
		<s:action name="User_navbar" namespace="/user" executeResult="true" />
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar" style="width: 240px;">
			<div class="sidebar-scroll">
				<nav>
				<ul class="nav">
					<template v-if="user_army_manager_power">
					<li><a href="/xsjsglxt/team/Staff_page_newStaff" class=""><i
							class="lnr lnr-users"></i> <span>新增人员</span></a></li>
					</template>
					<template v-if="user_case_technology_power">
					<li><a href="/xsjsglxt/case/Case_page_Sneceinput" class=""><i
							class="lnr lnr-file-add"></i> <span>案件录入</span></a></li>
					</template>
					<template v-if="user_case_technology_power">
					<li><a href="/xsjsglxt/case/Case_page_CaseMaterials" class=""><i
							class="lnr lnr-pushpin"></i> <span>物证录入</span></a></li>
					</template>
					<template v-if="user_case_technology_power">
					<li><a href="/xsjsglxt/case/Case_page_CaseMerger" class=""><i
							class="lnr lnr-database"></i> <span>案件串并</span></a></li>
					</template>
					<template v-if="user_technology_manager_power">
					<li><a href="/xsjsglxt/DNA/DNAManagement_DNAManagementPage"
						class=""><i class="lnr lnr-license"></i> <span>DNA信息</span></a></li>
					</template>
					<template v-if="user_technology_manager_power">
					<li><a
						href="/xsjsglxt/FingerPrint/FingerPrintManagement_FingerPrintManagementPage"
						class=""><i class="lnr lnr-thumbs-up"></i> <span>指纹信息</span></a></li>
					</template>
					<template v-if="user_technology_manager_power">
					<li><a
						href="/xsjsglxt/Equipment/EquipmentManagement_EquipmentManagementPage"
						class=""><i class="lnr lnr-cog"></i> <span>器材装备</span></a></li>
					</template>
					<template v-if="user_case_technology_power">
					<li><a href="/xsjsglxt/case/Case_page_CaseMaterials" class=""><i
							class="lnr lnr-film-play"></i> <span>影像光盘</span></a></li>
					</template>
					<template v-if="user_check_power">
					<li><a
						href="/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_EntrustmentBookManagement"
						class=""><i class="lnr lnr-home"></i> <span>痕迹检验委托</span></a></li>
					</template>
					<template v-if="user_check_power">
					<li><a
						href="/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_EntrustmentBookManagement"
						class=""><i class="lnr lnr-apartment"></i> <span>法医检验委托</span></a></li>
					</template>
				</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">欢迎进入安源刑侦工作信息管理系统</h3>
							<p class="panel-subtitle" style="margin-top: 20px;">
								当前时间是：<span id="current_time"></span>
							</p>
						</div>
						<div class="panel-body"></div>
					</div>
					<!-- END OVERVIEW -->

				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN -->
	</div>
	<!-- END WRAPPER -->
	<script type="text/javascript">
		var sliderVue = new Vue({
			el : '#sidebar-nav',
			data : userPowerDTO
		})
	</script>
</body>
</html>