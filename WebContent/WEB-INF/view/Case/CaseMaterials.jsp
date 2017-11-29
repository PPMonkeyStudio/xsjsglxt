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
			<select class="form-control" onchange="material(this)">
				<option value="">请选择</option>
				<option>物证</option>
				<option>光碟(照片)</option>
				<option>遗失物品</option>
			</select>
			<div class="panel-body">
				<table style="width: 100%;">
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
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<script type="text/javascript"
		src="<%=basePath%>js/Case/CaseMaterials.js"></script>
</body>
</html>
