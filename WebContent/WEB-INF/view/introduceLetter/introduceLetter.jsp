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
<style type="text/css">
.pageOperation {
	cursor: pointer;
}

.hideDiv {
	display: none;
}

table {
	text-align: center;
}

table tr th {
	border-bottom: 1px solid #DCDCDC;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}

table tr td {
	border-bottom: 1px solid #DCDCDC;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}

table tr:hover {
	background-color: #DCDCDC;
	cursor: pointer;
}
</style>
<title>介绍信</title>
<script type="text/javascript"
	src="<%=basePath%>js/introduceLetter/createLetter.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/introduceLetter/showLetterList.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/introduceLetter/managerLetter.js"></script>
<!-- -----------------模态框js文件引入--------------------------------  -->
</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel"
			style="width: 95%; margin: 20px auto; padding-left: 20px; padding-right: 20px;">
			<div class="headDiv" style="padding-top: 10px;">
				<button class="btn btn-default managerRole" onclick="createLetter()">
					<i class="fa fa-pencil-square-o"></i>新建介绍信
				</button>
				<button class="btn btn-danger managerRole letter_admin"
					onclick="deleteLetter()">
					<i class="fa fa-trash-o"></i>删除介绍信
				</button>
				<div id="query" style="float: right;">
					<label>时间筛选</label> <input class="form-control startTime"
						onchange="changeQuerySort()" type="text" id="timeStart"
						style="width: 150px; display: inline-block;">至 <input
						class="form-control startTime" onchange="changeQuerySort()"
						type="text" style="width: 150px; display: inline-block;"
						id="timeEnd"> <label>查询</label> <input type="text"
						id="searchInput" class="form-control"
						style="width: 250px; display: inline-block;"
						oninput="changeQuerySort()" placeholder="请输入搜索内容">
				</div>
			</div>
			<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
				<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
			</div>
			<div id="allInformation" class="hideDiv"
				style="margin-top: 10px; display: none;">
				<table class="table table-hover table-condensed case_table_info">
					<tr>
						<td><label> <input onclick="selectAll(this)"
								type="checkbox"><span style=""> 全选 </span>
						</label></td>
						<td>编号</td>
						<td>目的单位</td>
						<td>前往人员</td>
						<td>前往人员数量</td>
						<td><select class="form-control" id="timeSort"
							onchange="changeQuerySort()">
								<option value="desc">前往时间（降序）</option>
								<option value="asc">前往时间（升序）</option>
						</select></td>
						<td>操作</td>
					</tr>
					<template v-for="letter in allData.letterList">
					<tr>
						<td><label><input type="checkbox"
								name="chooseCheckBox"
								:value="letter.xsjsglxt_introduce_letter_id"><span></span></label></td>
						<td :id="letter.xsjsglxt_introduce_letter_id"
							onclick="previewLetter(this)" style="color:blue;">{{
							letter.introduce_letter_serial_number }}</td>
						<td>{{ letter.introduce_letter_tounit }}</td>
						<td>{{ letter.introduce_letter_introduceMan }}</td>
						<td>{{ letter.introduce_letter_number }}</td>
						<td>{{ letter.introduce_time }}</td>
						<td>
							<button :id='letter.xsjsglxt_introduce_letter_id'
								onclick='exportLetter(this)' class="btn btn-info">
								<i class='fa fa-print'></i>导出
							</button> <template v-if="letter_admin_power">
							<button class="btn btn-default"
								:id='letter.xsjsglxt_introduce_letter_id'
								onclick='updateLetter(this)'>
								<i class='fa fa-pencil-square-o'></i>修改
							</button>
							</template> <template
								v-if="letter.introduce_approve_status=='未审批' && letter_admin_power">
							<button class="btn btn-primary"
								:id='letter.xsjsglxt_introduce_letter_id'
								onclick='approveLetter(this)'>
								<i class="fa fa-dot-circle-o"></i>审批
							</button>
							</template> <template
								v-if="letter.introduce_approve_status=='已审批' && letter_admin_power">
							<button class="btn btn-primary"
								:id='letter.xsjsglxt_introduce_letter_id'
								onclick='showApproveStup(this)'>
								<i class="fa fa-table"></i>存根
							</button>
							</template>
						</td>
					</tr>
					</template>
				</table>
				<div id="bottomPage" style="padding: 20px;">
					<span>当前页数:<span id="currPage">{{ allData.currPage }}</span></span>
					<span>共:<span id="totalPage">{{ allData.totalPage }}</span>页</span>
						<span>共:<span id="totalCount">{{allData.totalCount}}</span>条数据
					</span> <span onclick="skipToIndexPage()" id="indexPage"
						class="pageOperation">首页</span> <span
						onclick="skipToPrimaryPage()" id="previousPage"
						class="pageOperation">上一页</span> <span onclick="skipToNextPage()"
						id="nextPage" class="pageOperation">下一页</span> <span
						onclick="skipToLastPage()" id="lastPage" class="pageOperation">末页</span>
						<span> <input id="skipPage" class="form-control"
							type="text"
							style="display: inline-block; text-align: center; width: 60px; height: 30px;"
							class="queryInput">
							<button onclick="skipToArbitrarilyPage()" class="btn btn-default"
								style="height: 30px;">跳转</button>
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
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
	if (!userPowerDTO.user_letter_power) {
		$('.letter_admin').hide();
	}
</script>
</html>