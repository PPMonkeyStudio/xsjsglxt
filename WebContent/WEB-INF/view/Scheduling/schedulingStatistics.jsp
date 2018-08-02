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
<title>值班统计</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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

</style>
</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel"
			style="width: 95%; margin: 20px auto; padding-left: 20px; padding-right: 20px;">
			<div id="queryCondition"
				style="margin-left: 10px; margin-right: 10px; margin-top: 10px;">
				<button class="btn btn-default managerRole"
					onclick="intoScheduling()">
					<i class="fa fa-arrow-circle-left"></i>返回排班管理
				</button>
				<div id="query" style="float: right;">
					<label>时间筛选</label> <input class="form-control startTime"
						onchange="queryData()" type="text" id="timeStart"
						style="width: 150px; display: inline-block;">至 <input
						class="form-control startTime" onchange="queryData()" type="text"
						style="width: 150px; display: inline-block;" id="timeEnd">
					<label>查询</label> <input type="text" id="searchInput"
						class="form-control" style="width: 250px; display: inline-block;"
						oninput="queryData()" placeholder="请输入搜索内容">
				</div>
			</div>
			<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
				<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
			</div>
			<div id="tableContent" style="margin-top: 10px; display: none;">
				<table class="table table-hover table-condensed" style="text-align: center;">
					<thead>
						<tr style="height:30; color: black;">
							<td>姓名</td>
							<td>值班天数</td>
							<td>巡逻天数</td>
							<td>加班次数</td>
							<td>外协次数</td>
							<td>出差次数</td>	
						</tr>
					</thead>
					<tbody>
					<template v-for="timeDTO in timeDTOList">
						<tr>
							<td>{{ timeDTO.policemanName }}</td>
							<td>{{ timeDTO.schedulingTime }}</td>
							<td>{{ timeDTO.patrolTime }}</td>
							<td>{{ timeDTO.overTime }}</td>
							<td>{{ timeDTO.outTime }}</td>
							<td>{{ timeDTO.evectionTime }}</td>
						</tr>
					</template>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<script type="text/javascript">
		$.datetimepicker.setLocale('ch');
		$('.startTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2030/01/01', // 设置最大日期
		});
	</script>
<script src="<%=basePath%>js/Scheduling/showStastics.js"></script>
</body>
</html>