<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>办案管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="tdis is my page">
</head>
<style type="text/css">
.detentionDays {
	display: none;
}

.Handle_table_info thead tr td {
	text-align: center;
}

.Handle_table_info thead tr td span {
	font-size: 14px;
}

.Handle_table_info tbody tr td {
	text-align: center;
	font-size: 14px;
	cursor: pointer;
}

#Handle_input table {
	font-size: 13px;
}

#Handle_input table tbody tr td {
	text-align: right;
}

.tr_back {
	background-color: silver;
}

.page_info span {
	cursor: pointer;
}

.pageOperation {
	cursor: pointer;
}
</style>

<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<div id="vue-main">
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<div style="margin: 80px 0 0 0; float: left; width: 100%;">
			<!---------------------------------------------------------------------------------------------------->
			<!---------------------------------------------------------------------------------------------------->
			<div class="panel" style="width: 95%; margin: 20px auto;">
				<div style="margin: 10px;">
					<div class="headDiv" style="height: 60px; padding-top: 10px;">
						<button class="btn btn-default" onclick="createHandleCase()">
							<i class="fa fa-pencil-square-o"></i>添加案件
						</button>
						<button class="btn btn-default" onclick="goSuspectList()">
							<i class="fa fa-address-book-o"></i>嫌疑人列表
						</button>
						<div style="display: inline-block; float: right;"></div>
					</div>
					<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
						<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
					</div>
					<div class="tableDiv hideDiv" id="contentDiv">
						<table class="table table-hover table-condensed"
							style="text-align: center;">
							<thead>
								<tr>
									<td><input oninput="changeSort()" id="caseName"
										type="text" class="form-control" placeholder="案件名称"></td>
									<td><select onchange="changeSort()" class="form-control"
										id="caseState">
											<option value="">案件状态</option>
											<option value="0">在侦</option>
											<option value="1">已破</option>
									</select></td>
									<td><input oninput="changeSort()" id="mainPolice"
										type="text" class="form-control" placeholder="主办民警"></td>
									<td><input oninput="changeSort()" id="assistantPolice"
										type="text" class="form-control" placeholder="协办民警"></td>
									<td><input oninput="changeSort()" id="middleCaptain"
										type="text" class="form-control" placeholder="中队长"></td>
									<td>嫌疑人</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody id="bodyDiv" style="display: none;">
								<template v-for="handleCase in handleCaseVO.caseList">
								<tr>
									<td>{{ handleCase.handle_case_name }}</td>
									<td><template v-if=" handleCase.handle_case_state == 0">
										在侦 </template> <template v-else> 已破 </template></td>
									<td>{{ handleCase.handle_main_police }}</td>
									<td>{{ handleCase.handle_assistant_police }}</td>
									<td>{{ handleCase.handle_middle_captain }}</td>
									<td><i :id="handleCase.handle_case_id"
										onclick="suspectPanel(this)"
										class="fa fa-arrow-right pageOperation"></i></td>
									<td><a class="pageOperation"
										onclick="updateHandleCase(this)"
										:id="handleCase.handle_case_id">修改</a>| <a
										onclick="deleteHandleCase(this)" class="pageOperation"
										:id="handleCase.handle_case_id">删除</a></td>
								</tr>
								</template>
							</tbody>
						</table>
						<div id="bottomPage" style="padding: 20px;">
							<span>当前页数:<span id="currPage">{{
									handleCaseVO.currPage }}</span></span> <span>共:<span id="totalPage">{{
									handleCaseVO.totalPage }}</span>页<span>共:<span id="totalCount">{{
										handleCaseVO.totalSize }}</span>条记录数
							</span> <span onclick="skipToIndexPage()" id="indexPage"
								class="pageOperation">首页</span> <span
								onclick="skipToPrimaryPage()" id="previousPage"
								class="pageOperation">上一页</span> <span
								onclick="skipToNextPage()" id="nextPage" class="pageOperation">下一页</span>
								<span onclick="skipToLastPage()" id="lastPage"
								class="pageOperation">末页</span> <span> <input
									id="skipPage" class="form-control" type="text"
									style="display: inline-block; text-align: center; width: 60px; height: 30px;"
									class="queryInput">
									<button onclick="skipToArbitrarilyPage()"
										class="btn btn-default" style="height: 30px;">跳转</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript"
			src="<%=basePath%>js/HandleCase/createHandleCase.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/HandleCase/showHandleCaseList.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/HandleCase/managerHandleCase.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/HandleCase/showSuspectList.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/HandleCase/showTakeGoodsList.js"></script>
		<script type="text/javascript">
			$.datetimepicker.setLocale('ch');
			$('.mydate').datetimepicker({
				yearStart : 1950, // 设置最小年份
				yearEnd : 2050, // 设置最大年份
				yearOffset : 0, // 年偏差
				timepicker : false, // 关闭时间选项
				format : 'Y-m-d', // 格式化日期年-月-日
				minDate : '1950/01/01', // 设置最小日期
				maxDate : '2050/01/01', // 设置最大日期
			});
			$('.mydate_minute').datetimepicker({
				yearStart : 1950, // 设置最小年份
				yearEnd : 2050, // 设置最大年份
				yearOffset : 0, // 年偏差
				timepicker : true, // 关闭时间选项
				format : 'Y-m-d H:i', // 格式化日期年-月-日
				minDate : '1950/01/01', // 设置最小日期
				maxDate : '2050/01/01', // 设置最大日期
			});
		</script>
</body>
</html>