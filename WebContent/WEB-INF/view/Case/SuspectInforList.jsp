<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>嫌疑人列表</title>
<style type="text/css">
.pageOperation {
	cursor: pointer;
}
</style>
</head>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<div id="vue-main">
		<div style="margin: 80px 0 0 0; float: left; width: 100%;">
			<div class="panel" style="width: 95%; margin: 20px auto;">
				<div style="margin: 10px;">
					<div class="headDiv" style="height: 60px; padding-top: 10px;">
						<button class="btn btn-default" onclick="goHandleList()">
							<i class="fa fa-reply"></i>返回办案列表
						</button>
						<div style="display: inline-block; float: right;"></div>
					</div>
				</div>
				<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
					<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
				</div>
				<div class="tableDiv hideDiv" id="contentDiv">
					<table class="table table-hover table-condensed"
						style="text-align: center;">
						<thead>
							<tr>
								<td><input oninput="changeSort()" id="caseName" type="text"
									class="form-control" placeholder="案件名称"></td>
								<td><input oninput="changeSort()" id="suspectName"
									type="text" class="form-control" placeholder="姓名"></td>
								<td>性别</td>
								<td><select onchange="changeSort()" class="form-control"
									id="processType">
										<option value="">当前状态</option>
										<option value="0">拘留</option>
										<option value="1">逮捕</option>
										<option value="2">起诉</option>
										<option value="3">退查</option>
										<option value="4">监视居住</option>
										<option value="5">取保候审</option>
										<option value="6">释放</option>
								</select></td>
								<td>开始时间</td>
								<td>结束时间</td>
								<td>状态记录</td>
							</tr>
						</thead>
						<tbody>
							<template v-for="suspectInfor in suspectVO.suspectDTO">
							<tr>
								<td>{{ suspectInfor.case_name }}</td>
								<td>{{ suspectInfor.name }}</td>
								<td><template v-if="suspectInfor.sex == 0">男</template> <template
										v-else>女</template></td>
								<td><template v-if="suspectInfor.processType == 0">拘留</template>
									<template v-if="suspectInfor.processType == 1">逮捕</template> <template
										v-if="suspectInfor.processType == 2">起诉</template> <template
										v-if="suspectInfor.processType == 3">退查</template> <template
										v-if="suspectInfor.processType == 4">监视居住</template> <template
										v-if="suspectInfor.processType == 5">取保候审</template> <template
										v-if="suspectInfor.processType == 6">释放</template></td>
								</td>
								<td>{{ suspectInfor.start }}</td>
								<td>{{ suspectInfor.end }}</td>
								<td><i class="fa fa-eye pageOperation" onclick="stateRecord(this)" :id="suspectInfor.id"></i></td>
							</tr>
							</template>
						</tbody>
					</table>
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">{{ suspectVO.currPage
								}}</span></span> <span>共:<span id="totalPage">{{
								suspectVO.totalPage }}</span>页<span>共:<span id="totalCount">{{
									suspectVO.totalSize }}</span>条记录数
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
								<button onclick="skipToArbitrarilyPage()"
									class="btn btn-default" style="height: 30px;">跳转</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/HandleCase/suspectList.js"></script>
</body>
</html>