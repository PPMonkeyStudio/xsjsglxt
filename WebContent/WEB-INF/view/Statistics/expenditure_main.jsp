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
	.pageOperation{
		cursor: pointer;
	}
</style>
<title>经费管理</title>
</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!-----------------------------------------主体内容 -------------------------------------------------------->
	<div id="allPanel" style="margin: 80px 0 0 0; float: left; width: 100%; overflow: hidden;">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<div style="padding: 10px;">
				<button class="btn btn-default managerRole" onclick="saveExpenditure()">
					<i class="fa fa-plus-square"></i>增加报账
				</button>
				<div id="query" style="float: right;">
					<label>时间筛选</label> <input class="form-control startTime"
						onchange="changeSearch(this)" type="text" id="timeStart"
						style="width: 150px; display: inline-block;">至 <input
						class="form-control startTime" onchange="changeSearch(this)" type="text"
						style="width: 150px; display: inline-block;" id="timeEnd">
				</div>
			</div>
			<div id="loadingLayer"
				style="margin: 0 auto; width: 45px; display: none;">
				<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
			</div>
			<div id="allInformation" style="margin-top: 10px;">
				<table class="table table-hover table-condensed"
					style="text-align: center;">
					<thead>
						<tr>
							<td><input oninput="changeSearch(this)" class="form-control" placeholder="姓名" id="_name"></td>
							<td><select onchange="changeSearch(this)" class="form-control" id="_type">
									<option value="">经费种类</option>
									<option value="出差">出差</option>
									<option value="学习">学习</option>
									<option value="误餐">误餐</option>
									<option value="特情">特情</option>
									<option value="其他">其他</option>
							</select></td>
							<td><select onchange="changeSearch(this)" class="form-control" id="_sort">
									<option value="desc">报账时间（降序）</option>
									<option value="asc">报账时间（升序）</option>
							</select></td>
							<td><input oninput="changeSearch(this)" placeholder="所属中队" class="form-control" id="_detachment"></td>
							<td>金额（单位：元）</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<template v-for="expenditure in showData.expenditures">
						<tr>
							<td>{{ expenditure.expenditure_name }}</td>
							<td>{{ expenditure.expenditure_type }}</td>
							<td>{{ expenditure.expenditure_time }}</td>
							<td>{{ expenditure.expenditure_detachment }}</td>
							<td>{{ expenditure.expenditure_money }}</td>
							<td><button onclick="updateExpenditure(this)" :id="expenditure.expenditure_id" class="btn btn-default"><i class="fa fa-pencil-square-o"></i>修改</button>
								<button onclick="deleteExpenditure(this)" :id="expenditure.expenditure_id" class="btn btn-danger"><i class="fa fa-trash-o"></i>删除</button>
							</td>
						</tr>
						</template>
					</tbody>
				</table>
				<div id="bottomPage" style="padding: 20px;">
				<span>总计：{{ showData.totalMoney }}元</span>
					<span>当前页数:<span id="currPage"></span></span> <span>共:<span
						id="totalPage">{{ showData.totalPage }}</span>页
					</span><span>共:<span id="totalCount">{{ showData.totalCount }}</span>条记录数
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
</body>
<script type="text/javascript" src="<%=basePath %>js/Expenditure/showExpenditure.js"></script>
<script type="text/javascript" src="<%=basePath %>js/Expenditure/createExpenditure.js"></script>
<script type="text/javascript" src="<%=basePath %>js/Expenditure/managerExpenditure.js"></script>

<script type="text/javascript">
	$.datetimepicker.setLocale('ch');
	$('.startTime').datetimepicker({
		yearStart : 1900, // 设置最小年份
		yearEnd : 2100, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : false, // 关闭时间选项
		format : 'Y-m-d', // 格式化日期年-月-日
		minDate : '1900/01/01', // 设置最小日期
		maxDate : '2100/01/01', // 设置最大日期
	});
</script>
</html>