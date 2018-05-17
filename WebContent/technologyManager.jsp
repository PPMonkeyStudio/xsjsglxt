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
<title>Insert title here</title>
<style type="text/css">
li {
	list-style-type: none;
}

li a {
	color: black;
}
</style>
<script src="<%=basePath%>js/technologyMargin.js"></script>
</head>
<body>
	<div id="sidebar-nav" class="sidebar"
		style="width: 160px; background-color: #13599d;">

		<div class="sidebar-scroll">
			<nav>
			<ul class="nav" id="technology">
				<li><a href="<%=basePath%>user/User_index"><i
						class="fa fa-telegram"></i>首页</a></li>
				<template v-if="user_case_technology_power">
				<li><a href="<%=basePath%>case/Case_page_CaseMergerList"><i
						class="fa fa-exchange"></i>案件串并</a></li>
				</template>
				<template v-if="user_case_technology_power">
				<li><a href="<%=basePath%>case/Case_page_CaseMaterials"><i
						class="fa fa-file"></i>影像光盘</a></li>
				</template>
				<template v-if="user_case_technology_power">
				<li><a href="<%=basePath%>case/BreakeCase_page_BreakCaseList"><i
						class="fa fa-sun-o"></i>刑事破案</a></li>
				</template>
				<template v-if="user_technology_manager_power">
				<li><a href="<%=basePath%>DNA/DNAManagement_DNAManagementPage"><i
						class="fa fa-map-o"></i>DNA</a></li>
				</template>
				<template v-if="user_technology_manager_power">
				<li><a
					href="<%=basePath%>FingerPrint/FingerPrintManagement_FingerPrintManagementPage"><i
						class="fa fa-id-card-o"></i>指纹</a></li>
				</template>
				<template v-if="user_technology_manager_power">
				<li><a
					href="<%=basePath%>statistics/Expenditure_intoMain"><i
						class="fa fa-cny"></i>经费管理</a></li>
				</template>
				<%-- 				<template v-if="user_technology_manager_power">
				<li><a
					href="<%=basePath%>Equipment/EquipmentManagement_EquipmentManagementPage"><i class="fa fa-bank"></i>器材装备</a></li>
				</template> --%>
				<template v-if="false">
				<li><a
					href="<%=basePath%>ContrastFingerPrint/ContrastFingerPrintManagement_ContrastFingerPrintManagementPage">比对指纹</a></li>
				</template>
				<template v-if="user_statistics_power">
				<li><a href="<%=basePath%>statistics/Statistics_intoMain"><i
						class="fa fa-bar-chart"></i>统计</a></li>
				</template>
			</ul>
			</nav>
		</div>
	</div>
	<script type="text/javascript">
		var d = document.getElementById("navbar").offsetHeight;
		/* 		console.log(d);
		 document.getElementById("technology").setAttribute(
		 "style",
		 "margin: " + d
		 + "px 0 0 0; float: left; width: 100%; color: black;"); */
		var technologyMangerVue = new Vue({
			el : '#technology',
			data : userPowerDTO
		});
	</script>
</body>
</html>