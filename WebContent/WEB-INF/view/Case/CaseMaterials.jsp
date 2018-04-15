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

<title>案件材料</title>
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

.jconfirm-content div table tbody tr td>input {
	margin-top: 6px;
	margin-left: -20px;
}

.jconfirm-content div table tbody tr td select {
	margin-top: 6px;
	margin-left: -20px;
}

.jconfirm-content div table {
	width: 100%;
}

.jconfirm-content div table tbody tr td textarea {
	margin-top: 6px;
	margin-left: -20px;
}

.jconfirm-content div table tbody tr td select {
	
}

.jconfirm-content table tbody tr td>div {
	margin-left: -20px !important;
	margin-top: 6px;
}
</style>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	
	<jsp:include page="/technologyManager.jsp" flush="true"></jsp:include>	
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div id="allPanel">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">案件材料</h3>
			</div>
			<div class="operation" style="margin-bottom: 6px; ">
				<select id="type_chose"
					style="width:120px; margin-left:15px; float: left;"
					class="form-control" onchange="material(this)">
					<option selected="selected" value="">请选择</option>
					<option value="evidence_table_info">物证</option>
					<option value="picture_table_info">照片</option>
					<option value="image_table_info">影像光盘</option>
					<option value="Goods_table_info">遗失物品</option>
				</select> <select id="goods_chose"
					style="width: 120px; margin-left:6px; display:none; float: left;"
					class="form-control" onchange="lost_chose(this)">
					<option value="">请选择</option>
					<option value="Lost">物品</option>
					<option value="LostComputer">电脑</option>
					<option value="LostMobilephone">手机</option>
				</select>
				<button style="margin-left: 6px; display:none;" type="button"
					class="btn btn-default add_info">
					<i class="fa fa-plus-square"></i> 添加信息
				</button>
			</div>
			<div class="panel-body">
				<table style="display: none;"
					class="table table-hover table-condensed evidence_table_info">
					<thead style="">
						<tr>
							<th>序号</th>
							<th>
								<!-- <input class="form-control" placeholder="物证名称"> -->物证名称
							</th>
							<th>提取日期</th>
							<th><input class="form-control Search_extractPerson"
								placeholder="提取人"></th>
							<th><select class="form-control">
									<option value="">全</option>
									<option>已检验</option>
									<option>正在委托检验</option>
									<option>送检不受理</option>
									<option>送检已受理</option>
									<option>已送检</option>
									<option>正在自检</option>
									<option>正在送检</option>
									<option>未检验</option>
							</select></th>
							<th>操作</th>
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
							<th>序号</th>
							<th>所属影像光盘</th>
							<th>所属案件</th>
							<th>照片编号</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
				<table style="display: none;"
					class="table table-hover table-condensed image_table_info">
					<thead>
						<tr>
							<th>序号</th>
							<th>影像光盘编号</th>
							<th>备注</th>
							<th>操作</th>
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
					<thead id="LostMobilephone" style="display: none;">
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
	<!---------------------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 图片(影像光盘)信息-模态框（Modal） -->
	<div class="modal fade" id="image" tabindex="-1" role="dialog"
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
						<div style="width: 80%;margin: auto;" class="panel-body"></div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary image_operation">确认修改</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/Case/CaseMaterials.js"></script>
	<script type="text/javascript">
		$.datetimepicker.setLocale('ch');
		$('.mydate').datetimepicker({
			yearStart : 1990, // 设置最小年份
			yearEnd : 2050, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1990/01/01', // 设置最小日期
			maxDate : '2030/01/01', // 设置最大日期
		});
		$('.mydate_minute').datetimepicker({
			yearStart : 1990, // 设置最小年份
			yearEnd : 2050, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d H:i', // 格式化日期年-月-日
			minDate : '1990/01/01', // 设置最小日期
			maxDate : '2030/01/01', // 设置最大日期
		});
	</script>
	<script type="text/javascript">
		var documentWidth = document.body.clientWidth;
		var panelWidth = documentWidth - 160;
		var navbarHeight = document.getElementById("navbar").offsetHeight;
		var panelMargin = navbarHeight + 20;
		document.getElementById("allPanel").setAttribute(
				"style",
				"width:" + panelWidth + "px; float:right; margin-top:"
						+ panelMargin + "px;");
		window.onresize = function() {
			var documentWidth = document.body.clientWidth;
			var panelWidth = documentWidth - 160;
			var navbarHeight = document.getElementById("navbar").offsetHeight;
			var panelMargin = navbarHeight + 20;
			document.getElementById("allPanel").setAttribute(
					"style",
					"width:" + panelWidth + "px; float:right; margin-top:"
							+ panelMargin + "px;");
		}
	
		
	</script>
</body>
</html>
