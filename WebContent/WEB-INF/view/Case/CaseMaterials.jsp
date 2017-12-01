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

<title>My JSP 'EvidencLlist.jsp' starting page</title>
<!-- 物证列表 -->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<style type="text/css">
.table-condensed thead tr>th {
	text-align: left;
}

.table-condensed tbody>tr>td {
	font-size: 15px;
}
</style>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">案件材料</h3>
			</div>
			<div class="operation" style="margin-bottom: 6px; ">
				<select style="width:120px; margin-left:15px;" class="form-control"
					onchange="material(this)">
					<option value="">请选择</option>
					<option value="evidence_table_info">物证</option>
					<option value="picture_table_info">光碟(照片)</option>
					<option value="Goods_table_info">遗失物品</option>
				</select>
			</div>
			<div class="panel-body">
				<table style=""
					class="table table-hover table-condensed evidence_table_info">
					<thead style="">
						<tr>
							<td><strong>#</strong></td>
							<td><strong><input class="form-control"
									placeholder="物证名称"></strong></td>
							<td><strong>提取日期</strong></td>
							<td><strong><input class="form-control"
									placeholder="提取人"> </strong></td>
							<td><strong><select class="form-control">
										<option value="">全</option>
										<option value="">已检验</option>
										<option value="">正在委托检验</option>
										<option value="">送检不受理</option>
										<option value="">送检已受理</option>
										<option value="">已送检</option>
										<option value="">正在自检</option>
										<option value="">正在送检</option>
										<option value="">未检验</option>
								</select></strong></td>
							<td><strong>操作</strong></td>
							<td><strong>管理</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>
						</tr>
					</tbody>
				</table>
				<table style="display: none;"
					class="table table-hover table-condensed picture_table_info">
					<thead>
						<tr>
							<th>物证查询</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>提取日期</td>
							<td><input></td>
							<td>至</td>
							<td><input></td>
							<td>提取人</td>
							<td><input></td>
							<td><input value="搜索"></td>
						</tr>
					</tbody>
				</table>
				<table style="display: none;"
					class="table table-hover table-condensed Goods_table_info">
					<thead>
						<tr>
							<th>物证查询</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>提取日期</td>
							<td><input></td>
							<td>至</td>
							<td><input></td>
							<td>提取人</td>
							<td><input></td>
							<td><input value="搜索"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<script type="text/javascript"
		src="<%=basePath%>js/Case/CaseMaterials.js"></script>
</body>
</html>
