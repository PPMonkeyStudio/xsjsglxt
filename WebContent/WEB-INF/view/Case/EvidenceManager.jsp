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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>物证管理</title>
<style type="text/css">
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
	height: 42px;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}

table tr td {
	border: 1px solid black;
	height: 42px;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}

.tdWidth {
	width: 100px;
}
</style>
<script type="text/javascript"
	src="<%=basePath%>js/Case/caseDetails_table.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Case/EvidenceCheck.js"></script>
</head>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />

	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel"
			style="width: 95%; margin: 20px auto; padding-top: 30px;">
			<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
				<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
			</div>
			<div id="tableContent" class="panel-body" style="display: none;">
				<table style="width: 1200px; margin: 0 auto;">
					<tr>
						<td colspan="5" style="text-align: left;">{{
							caseInfor.case_name }}的案件信息</td>
					</tr>
					<tr>
						<td>接警时间</td>
						<td>案发地点</td>
						<td>案件性质</td>
						<td>案件类别</td>
						<td>发案辖区</td>
					</tr>
					<tr>
						<td>{{ caseInfor.case_receivingAlarmDate }}</td>
						<td>{{ caseInfor.case_address }}</td>
						<td>{{ caseInfor.case_classify }}</td>
						<td>{{ caseInfor.case_totalCategory }}</td>
						<td>{{ caseInfor.case_jurisdiction }}</td>
					</tr>
				</table>
				<table style="width: 1200px; margin: 0 auto; margin-top: 30px;">
					<tr>
						<td colspan="6" style="text-align: left;">物证信息</td>
					</tr>
					<tr>
						<td colspan="1" style="width: 200px;">物证名称</td>
						<td style="text-align: center; width: 200px;">提取日期</td>
						<td style="width: 200px; text-align: center;">流转状态</td>
						<td style="text-align: center; width: 200px;">检验状态</td>
						<td style="text-align: center; width: 200px;" colspan="2">操作</td>
					</tr>
					<template v-for="re in resevidence">
					<tr>
						<td colspan="1" style="width: 200px;">{{ re.resevidence_name
							}}</td>
						<td style="width: 200px;">{{ re.resevidence_extractTime }}</td>
						<td style="width: 200px;">{{ re.resevidence_circulation }}</td>
						<td style="width: 200px;">{{ re.resevidence_teststate }}|{{
							re.resevidence_sendstate }}</td>
						<td style="width: 200px;" colspan="2"><template
								v-if="re.resevidence_sendstate == '未送检'">
							<button class="btn btn-default"
								:value="caseInfor.xsjsglxt_case_id"
								:id="re.xsjsglxt_resevidence_id" onclick="sendCheck(this)">送检</button>
							</template> <template v-if="re.resevidence_teststate == '未检验'">
							<button class="btn btn-default" :id="re.xsjsglxt_resevidence_id"
								:value="caseInfor.xsjsglxt_case_id" onclick="checkSelf(this)">检验</button>
							</template>
							<button class="btn btn-default"
								:value="re.xsjsglxt_resevidence_id"
								:id="caseInfor.xsjsglxt_case_id">流转</button>
						<button class="btn btn-default"
							:value="re.xsjsglxt_resevidence_id"
							:id="caseInfor.xsjsglxt_case_id">流转过程</button>
						</td>
					</tr>
					</template>
					<tr>
						<td colspan="1" style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td style="width: 200px;" colspan="2"></td>
					</tr>
				</table>

				<table style="width: 1200px; margin: 0 auto; margin-top: 30px;">
					<tr>
						<td colspan="6" style="text-align: left;">物证检验情况</td>
					</tr>
					<tr>
						<td style="width: 200px;">物证名称</td>
						<td style="width: 200px;">检验时间</td>
						<td style="width: 200px;">检验方法</td>
						<td  style="width: 200px;">检验地点</td>
						<td colspan="2" style="width: 200px;">检验结果</td>
					</tr>
					<tr>
						<td style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td colspan="2" style="width: 200px;"></td>
					</tr>
				</table>

				<table style="width: 1200px; margin: 0 auto; margin-top: 30px;">
					<tr>
						<td colspan="6" style="text-align: left;">物证委托书情况</td>
					</tr>
					<tr>
						<td style="width: 200px;">物证名称</td>
						<td style="width: 200px;">委托编号</td>
						<td style="width: 200px;">鉴定委托单位</td>
						<td colspan="2" style="width: 200px;">鉴定机构名称</td>
						<td style="width: 200px;">委托时间</td>
					</tr>
					<tr>
						<td style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td style="width: 200px;"></td>
						<td style="width: 200px;" colspan="2"></td>
						<td style="width: 200px;"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>