<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印值班表</title>
<script src="<%=basePath%>js/vue.js"></script>
<script src="<%=basePath%>js/Scheduling/printPage.js"></script>
<script src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<style type="text/css">
.pageOperation {
	cursor: pointer;
}

a {
	cursor: pointer;
}
i {
	cursor: pointer;
}
table{
border-collapse:collapse;}
table tbody tr td {
	color: black;
}

table tbody tr td {
	text-align: center;
}

table tr th {
	border: 1px solid black;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
	width:150px;
}

table tr td {
	border: 1px solid black;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
	width:150px;
}
</style>
</head>
<body>
	<table id="tableContent" style="text-align: center; margin:0 auto; width: 920px; color: black;">
						<tr>
							<td rowspan="2">日期</td>
							<td rowspan="2">带班领导</td>
							<td colspan="3">值班人员</td>
							<td rowspan="2">今日巡逻</td>		
						</tr>
						<tr><td>侦查民警</td><td>技术民警</td><td>辅警</td></tr>
						<template v-for="schedulingDTO in vo.schedulingDTOList">
						<tr>
							<td>{{ schedulingDTO.scheduling_time }}</td>
							<td>{{ schedulingDTO.scheduling_leader }}</td>
							<td>{{ schedulingDTO.scheduling_main }}</td>
							<td>{{ schedulingDTO.scheduling_mainTec }}</td>
							<td>{{ schedulingDTO.scheduling_assistant }}</td>
							<td>{{ schedulingDTO.scheduling_patrol }}</td>
						</tr>
						</template>
				</table>
</body>
</html>