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

<title>影像光盘</title>
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

.page_info a {
	cursor: pointer;
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
				<h3 class="panel-title">影像光盘</h3>
			</div>
			<div class="operation" style="margin-bottom: 6px; ">
				<button style="margin-left: 15px;" type="button"
					class="btn btn-default" data-toggle="modal" data-target="#image">
					<i class="fa fa-plus-square"></i> 添加信息
				</button>
				<!-- <input class="form-control" type="text" placeholder="串并人查询"
					style="float: right; width: 140px; margin-right: 15px;"
					onkeyup="input_query(this)" name=""
					query_name="page_list_parallelInformation.parallel_person"> -->
			</div>
			<div class="panel-body">
				<table style=""
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
					<tfoot>
						<tr>
							<td colspan="8" style="font-size: 12px;" class="page_info"><a
								onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i>
							</a>&nbsp&nbsp<a onclick="prePage()"><i class="fa fa-angle-left"></i>上一页
							</a>&nbsp&nbsp<a onclick="nextPage()">下一页<i
									class="fa fa-angle-right"></i>
							</a>&nbsp&nbsp <a onclick="lastPage()">尾页<i
									class="fa fa-angle-double-right"></i>
							</a> <br />
								<p class='info'></p></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 影像光盘信息-模态框（Modal） -->
	<div class="modal fade" id="image" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">影像光盘信息</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<table class="table" align="center">
							<tbody>
								<tr>
									<td>影像光盘编号</td>
									<td><input name="image.image_number"
										class="form-control must" type="text" value=""></td>
								</tr>
								<tr>
									<td>备注:</td>
									<td><textarea name="image.image_remarks"
											class="form-control" placeholder="请填写"></textarea></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" style="display: none;"
						class="btn btn-primary modify_image">修改</button>
					<button type="button" class="btn btn-primary add_image">提交</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/Case/CaseMaterials_image.js"></script>
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
