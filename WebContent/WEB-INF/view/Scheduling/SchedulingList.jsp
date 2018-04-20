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
<title>排班管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<%=basePath%>js/Scheduling/createScheduling.js"></script>
<script src="<%=basePath%>js/Scheduling/showSchedulingList.js"></script>
<script src="<%=basePath%>js/Scheduling/selectCheckBox.js"></script>
<script src="<%=basePath%>js/Scheduling/managerScheduling.js"></script>
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

table tbody tr td {
	padding-left: 10px;
	width: 300px;
	color: black;
}

table tbody tr td {
	text-align: center;
}

table tr th {
	border: 1px solid black;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}

table tr td {
	border: 1px solid black;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}


.tdWidth {
	width: 100px;
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
					onclick="createScheduling()">
					<i class="fa fa-pencil-square-o"></i>增加值班
				</button>
				<button class="btn btn-default managerRole"
					onclick="printCurrPage()">
					<i class="fa fa-print"></i>打印值班表
				</button>
				<button class="btn btn-danger managerRole"
					onclick="deleteScheduling()">
					<i class="fa fa-trash-o"></i>删除值班
				</button>
				<div id="query" style="float: right;">
					<label>时间筛选</label> <input class="form-control startTime"
						onchange="changeSort()" type="text" id="timeStart"
						style="width: 150px; display: inline-block;">至 <input
						class="form-control startTime" onchange="changeSort()" type="text"
						style="width: 150px; display: inline-block;" id="timeEnd">
					<label>查询</label> <input type="text" id="searchInput"
						class="form-control" style="width: 250px; display: inline-block;"
						oninput="changeSort()" placeholder="请输入搜索内容">
				</div>
			</div>
			<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
				<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
			</div>
			<div id="tableContent" style="margin-top: 10px; display: none;">
				<table style="text-align: center; margin:0 auto; width: 1200px; color: black;">
					<thead>
						<tr style="height:30;">
							<td rowspan="2"><label class="fancy-checkbox"> <input
									onclick="selectAll(this)" type="checkbox" ><span style="">
										全选 </span>
							</label></td>
							<td rowspan="2">日期</td>
							<td rowspan="2">带班领导</td>
							<td colspan="3">值班人员</td>
							<td rowspan="2">今日巡逻</td>		
						</tr>
						<tr style="height:30;"><td>侦查民警</td><td>技术民警</td><td>辅警</td></tr>
						
					</thead>
					<tbody>
						<template v-for="schedulingDTO in vo.schedulingDTOList">
						<tr style="height:30;">
							<td><label class="fancy-checkbox"><input
									type="checkbox" name="chooseCheckBox"
									:value="schedulingDTO.xsjsglxt_scheduling_id"><span></span></label></td>
							<td><a onclick="updateScheduling(this)" :id="schedulingDTO.xsjsglxt_scheduling_id">{{ schedulingDTO.scheduling_time }}</a></td>
							<td>{{ schedulingDTO.scheduling_leader }}</td>
							<td>{{ schedulingDTO.scheduling_main }}</td>
							<td>{{ schedulingDTO.scheduling_mainTec }}</td>
							<td>{{ schedulingDTO.scheduling_assistant }}</td>
							<td>{{ schedulingDTO.scheduling_patrol }}</td>
						</tr>
						</template>
					</tbody>
				</table>
				<div id="bottomPage" style="padding: 20px;">
					<span>当前页数:<span id="currPage">{{ vo.currPage }}</span></span> <span>共:<span
						id="totalPage">{{ vo.totalPage }}</span>页
					</span> <span onclick="skipToIndexPage()" id="indexPage"
						class="pageOperation">首页</span> <span
						onclick="skipToPrimaryPage()" id="previousPage"
						class="pageOperation">上一页</span> <span onclick="skipToNextPage()"
						id="nextPage" class="pageOperation">下一页</span> <span
						onclick="skipToLastPage()" id="lastPage" class="pageOperation">末页</span>
					<span> <input id="skipPage" class="form-control" type="text"
						style="display: inline-block; text-align: center; width: 60px; height: 30px;"
						class="queryInput">
						<button onclick="skipToArbitrarilyPage()" class="btn btn-default"
							style="height: 30px;">跳转</button>
					</span>
				</div>
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
		$(function(){
			$("tr").css("height","30px");
		})
	</script>
</body>
</html>