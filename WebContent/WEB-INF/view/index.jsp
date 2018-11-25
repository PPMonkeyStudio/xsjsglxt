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
		console.log("执行查询查班");
		$
				.ajax({
					url : '/xsjsglxt/scheduling/Scheduling_getSchedulingByDate',
					type : 'GET',
					success : function(data) {
						if (data == "noScheduling") {
							document.getElementById("schedulingH3").innerHTML = "今日未安排值班";
						} else {
							String
							result = JSON.parse(data);
							document.getElementById("leader").innerHTML = result.scheduling_leader;
							document.getElementById("main").innerHTML = result.scheduling_main;
							document.getElementById("mainTech").innerHTML = result.scheduling_main_technology;
							document.getElementById("assistant").innerHTML = result.scheduling_assistant_tech
									+ "、" + result.scheduling_assistant_spy;
							if (result.scheduling_patrol != null)
								document.getElementById("patrol").innerHTML = result.scheduling_patrol;
						}
					}
				});
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
<style type="text/css">
.nav li {
	cursor: pointer;
}

.message {
	padding: 0;
	margin: 0;
}

.message li {
	list-style-type: none;
	color: black;
	font-size: 18px;
	padding: 5px;
}

.message li:nth-child(even) {
	background-color: #baefff;
}

.message li:nth-child(odd) {
	background-color: #9ae7fe;
}

.mesaageDIV {
	overflow-y: auto;
}
</style>
</head>
<body>
	<div id="wrapper">
		<s:action name="User_navbar" namespace="/user" executeResult="true" />
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar"
			style="width: 200px; height: 100% !important; background-color: #13599d;">
			<div class="sidebar-scroll" style="height: 100% !important;">
				<nav>
				<ul class="nav">
					<li><a class=""><i class="lnr lnr-file-add"></i> <span>案件信息</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<template v-if="user_case_technology_power">
							<li><a href="<%=basePath%>case/Case_page_SiteManagement"><span>现场录入</span></a></li>
							</template>
							<template v-if="user_case_technology_power">
							<li><a href="<%=basePath%>case/Case_page_CaseMergerList"><span>案件串并</span></a></li>
							</template>
							<template v-if="user_case_technology_power">
							<li><a
								href="<%=basePath%>case/BreakeCase_page_BreakCaseList"><span>刑事破案</span></a></li>
							</template>
						</ul>
					<li><a class=""><i class="lnr lnr-users"></i> <span>队伍信息</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<template v-if="user_army_manager_power">
							<li><a href="<%=basePath%>team/Staff_page_staffList"><span>人员管理</span></a></li>
							</template>
							<template v-if="user_army_manager_power">
							<li><a href="<%=basePath%>scheduling/Scheduling_page_list"><span>值班管理</span></a></li>
							</template>
							<template v-if="user_army_manager_power">
							<li><a href="<%=basePath%>user/Meeting_skipToMeetRecords"><span>会议记录</span></a></li>
							</template>
							<template v-if="user_army_manager_power">
							<li><a
								href="<%=basePath%>Equipment/EquipmentManagement_EquipmentManagementPage"><span>器材装备</span></a></li>
							</template>
							<template v-if="user_army_manager_power">
							<li><a
								href="<%=basePath%>user/Memorabilia_skipToMemorabilia"><span>大事记</span></a></li>
							</template>


						</ul></li>
					<li><a class=""><i class="lnr lnr-license"></i> <span>技术信息</span></a>
						<ul class="nav" style="background-color: #13599d;">
							<template v-if="user_technology_manager_power">
							<li><a
								href="<%=basePath%>DNA/DNAManagement_DNAManagementPage"><span>DNA录入</span></a></li>
							</template>
						</ul></li>
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
							<h2 class="panel-title">欢迎进入安源刑侦信息管理系统</h2>
							<br>
							<h3 class="panel-title" id="schedulingH3">
								今日值班 带班领导：<span id="leader"></span> 侦查民警：<span id="main"></span>
								技术民警：<span id="mainTech"></span> 辅警：<span id="assistant"></span>
								今日巡逻：<span id="patrol"></span><br> <br>
								<%-- 								今日加班：<span id="overtime"></span>
								今日外协：<span id="outHelp"></span> --%>
							</h3>
							<p class="panel-subtitle" style="margin-top: 20px;">
								当前时间是：<span id="current_time"></span>
							</p>
						</div>
						<div class="panel panel-default" id="messagePanel">
							<div class="panel-body">
								<h3>通知：</h3>
								<br>
								<template v-if="messageList === 'no'"> 暂无通知 </template>
								<template v-else> <template
									v-for="message in messageList"> 【{{ message.name
								}}】嫌疑人的<template v-if="message.type == 0">【拘留】</template>
								<template v-if="message.type == 1">【逮捕】</template>
								<template v-if="message.type == 2">【起诉】</template>
								<template v-if="message.type==3">【退查】</template>
								<template v-if="message.type == 4">【监视居住】</template>
								<template v-if="message.type==5">【取保候审】</template>
								<template v-if="message.type == 6">【释放】</template>时间快到期，请办案民警【{{
								message.policeName }}】尽快处理
								<hr>
								</template> </template>
							</div>
						</div>
					</div>
					<!-- END OVERVIEW -->
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END WRAPPER -->
	<script type="text/javascript">
		var messageVue = new Vue({
			el : '#messagePanel',
			data : {
				messageList : ''
			}
		});
		var sliderVue = new Vue({
			el : '#sidebar-nav',
			data : userPowerDTO
		});
		$.ajax({
			url : '/xsjsglxt/case/DealCase_getMessage',
			type : 'GET',
			success : function(data) {
				var d = JSON.parse(data);
				if(d.length == 0){
					messageVue.messageList = 'no';
				}else{
					messageVue.messageList = d;
				}
		
			}
		})
	</script>
</body>
<script type="text/javascript">
	$(function() {
		$('.slimScrollDiv')
				.attr("style",
						"position: relative; overflow: hidden; width: auto; height: 100%;");
	});
</script>
<%-- <script src="<%=basePath%>js/index/message_detention.js"></script> --%>
</html>