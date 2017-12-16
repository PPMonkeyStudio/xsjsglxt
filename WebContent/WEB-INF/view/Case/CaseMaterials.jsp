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
	text-align: center;
}

.table-condensed tbody tr>td {
	text-align: center;
}

.table-condensed tbody tr>td>div {
	width: 100% !important;
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
				<select style="width:120px; margin-left:15px; float: left; "
					class="form-control" onchange="material(this)">
					<option selected="selected" value="">请选择</option>
					<option value="evidence_table_info">物证</option>
					<option value="picture_table_info">照片</option>
					<option value="image_table_info">影像光盘</option>
					<option value="Goods_table_info">遗失物品</option>
				</select> <select id="goods_chose"
					style="width: 120px; margin-left:6px; display:none;"
					class="form-control" onchange="lost_chose(this)">
					<option value="">请选择</option>
					<option value="Lost">物品</option>
					<option value="LostComputer">电脑</option>
					<option value="LostMobiephone">手机</option>
				</select>
			</div>
			<div class="panel-body">
				<table style="display: none;"
					class="table table-hover table-condensed evidence_table_info">
					<thead style="">
						<tr>
							<td>序号</td>
							<td><input class="form-control" placeholder="物证名称"></td>
							<td>提取日期</td>
							<td><input class="form-control Search_extractPerson"
								placeholder="提取人"></td>
							<td><select class="form-control">
									<option value="">全</option>
									<option>已检验</option>
									<option>正在委托检验</option>
									<option>送检不受理</option>
									<option>送检已受理</option>
									<option>已送检</option>
									<option>正在自检</option>
									<option>正在送检</option>
									<option>未检验</option>
							</select></td>
							<td>操作</td>
							<%-- <td><strong>管理</strong></td> --%>
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
							<td>序号</td>
							<td>所属影像光盘</td>
							<td>所属案件</td>
							<td>照片编号</td>
							<td>备注</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<table style="display: none;"
					class="table table-hover table-condensed image_table_info">
					<thead>
						<tr>
							<td>序号</td>
							<td>备注</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<table style="display: none;"
					class="table table-hover table-condensed Goods_table_info">
					<!-- <thead id="select">
						<tr>
							<td></td>
						</tr>
					</thead> -->
					<thead id="Lost" style="display: none;">
						<tr>
							<th>序号</th>
							<th>名称</th>
							<th>所属案件</th>
							<th>备注</th>
							<th style="witdh:auto;!important">操作</th>
						</tr>
					</thead>
					<thead id="LostMobiephone" style="display: none;">
						<tr>
							<th>序号</th>
							<th>所属案件</th>
							<th>手机号码</th>
							<th>手机串号</th>
							<th>手机特征</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<thead id="LostComputer" style="display: none;">
						<tr>
							<th>序号</th>
							<th>所属案件</th>
							<th>电脑品牌</th>
							<th>上网账号</th>
							<th>MAC地址</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 丢失信息-模态框（Modal） -->
	<div class="modal fade" id="lost" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title"></h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div class="panel-body"></div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn_operation">确认修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 物证信息-模态框（Modal） -->
	<div class="modal fade" id="evidence" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">物证信息修改</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%;margin: auto;" class="panel-body"></div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary evidence_operation">确认修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/Case/CaseMaterials.js"></script>
</body>
</html>
