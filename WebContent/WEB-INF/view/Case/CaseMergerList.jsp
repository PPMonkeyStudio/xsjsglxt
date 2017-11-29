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
<!---------------------------------------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------->
<title>首页</title>
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
				<h3 class="panel-title">串并案件列表</h3>
			</div>
			<div class="operation" style="margin-bottom: 6px;">
				<button style="margin-left: 15px;" type="button"
					class="btn btn-default" onclick="javascript:location.href=''">
					<i class="fa fa-plus-square"></i> 新建案件串并
				</button>
			</div>
			<div class="panel-body">
				<table style="width: 100%;">
					<thead>
						<tr>
							<th>物证查询</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>串并时间</td>
							<td><input></td>
							<td>至</td>
							<td><input></td>
							<td>串并时间</td>
							<td><input></td>
							<td>串并人</td>
							<td><input></td>
							<td><input value="搜索"></td>
						</tr>
					</tbody>
				</table>
				<table style="width: 100%;">
					<thead>
						<tr>
							<th>串并号</th>
							<th>串并名称</th>
							<th>串并时间</th>
							<th>串并人</th>
							<th>破案情况</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>公安刑串</td>
							<td>23123</td>
							<td>2017/11/14</td>
							<td>冯俊</td>
							<td>否</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 新建查询-模态框（Modal） -->
	<div class="modal fade" id="newQuery" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">案件查询</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary to_quert">查询</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
<script>
	
</script>
</html>