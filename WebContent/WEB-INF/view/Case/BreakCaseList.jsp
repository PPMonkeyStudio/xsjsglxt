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

<title>刑事破案</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>Case.css" />
<style type="text/css">
#newQuery table tbody tr td input {
	margin-top: 6px;
	width: 100% !important;
}

#newQuery table tbody tr td select {
	margin-top: 6px;
	width: 100% !important;
}

.breakcase_table_info tbody tr {
	text-align: center;
	cursor: pointer;
}

i {
	cursor: pointer;
}
</style>
</head>

<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />

	<jsp:include page="/technologyManager.jsp" flush="true"></jsp:include>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div id="allPanel">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<!-- 破案时间，抓获时间 -->
			<div class="panel-heading">
				<h3 class="panel-title">刑事破案</h3>
			</div>
			<div class="panel-body">
				<div class="operation" style="margin-bottom: 6px;">
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default" data-toggle="modal"
						data-target="#newQuery">
						<i class="fa fa-plus-square"></i> 刑事破案高级查询
					</button>
					<!--  data-toggle="modal" -->
					<button id="breakCase_input" data-target="#breakCase_input"
						style="margin-left: 15px;" type="button" class="btn btn-default">
						<i class="fa fa-plus-square"></i> 添加刑事破案
					</button>
					<!--  DELETE -->
					<button id="delete-breakeCase" style="margin-left: 15px;"
						type="button" class="btn btn-default">
						<i class="fa fa-trash-o"></i> 删除所选破案
					</button>
				</div>
				<div class="col-md-12">
					<!-- TABLE HOVER -->
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">破案列表</h3>
						</div>
						<div class="panel-body">
							<table
								class="table table-hover table-condensed breakcase_table_info">
								<thead>
									<tr>
										<th style="padding-left:5px;width: 70px;">全选<input
											type="checkbox" onclick="selectAll(this)"></th>
										<th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="breakeCaseListVO.query_case_name"
											placeholder="案件名称"></th>
										<th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="breakeCaseListVO.query_sence_inquestId"
											placeholder="勘验编号"></th>
										<!-- <th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="breakeCaseListVO.breakecase_type"
											placeholder="案件类型"></th> -->
										<th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="breakeCaseListVO.query_breake_person"
											placeholder="破案人"></th>
										<th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="breakeCaseListVO.query_breake_according"
											placeholder="破案方式"></th>
										<th style="padding-left:5px;"><select
											onchange="dynamic_query(this)" class="form-control"
											query_name="breakeCaseListVO.query_breake_time_sort">
												<option selected="selected" value="desc">破案时间(降序)</option>
												<option value="asc">破案时间(升序)</option>
										</select></th>
									</tr>
								</thead>
								<tbody>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="8" style="" class="page_info"><span
											class='info'></span> <span onclick="firstPage()">首页</span> <span
											onclick="prePage()">上一页 </span><span onclick="nextPage()">下一页
										</span><span onclick="lastPage()">末页 </span> <input id="skipPage"
											style="display: inline-block; text-align: center; width: 60px; height: 30px;">
											<button onclick="toPage()" class="btn btn-default"
												style="height: 30px; vertical-align:initial;">跳转</button></td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
					<!-- END TABLE HOVER -->
				</div>

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
					<h4 class="modal-title" id="myModalLabel">刑事破案修改查询</h4>
				</div>
				<div class="modal-body">
					<form id="query_infomantion_inmodal" action="">
						<table style="width: 50%; margin: auto;" class="Query_table">
							<tbody>
								<tr>
									<td>勘验编号:</td>
									<td><input name="breakeCaseListVO.query_sence_inquestId"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>案件名称:</td>
									<td><input name="breakeCaseListVO.query_case_name"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>破案人:</td>
									<td><input name="breakeCaseListVO.query_breake_person"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>破案方式:</td>
									<td><select name="breakeCaseListVO.query_breake_according"
										class="form-control">
											<option value=""></option>
											<option>指纹</option>
											<option>视屏</option>
											<option>NDA</option>
											<option>其他</option>
									</select></td>
								</tr>
								<tr>
									<td>破案时间:</td>
									<td><input name="breakeCaseListVO.query_breake_time_start"
										style="float: left;" type="text" class="form-control mydate"
										placeholder="起始日期"><input
										name="breakeCaseListVO.query_breake_time_end"
										style=" float: right;" type="text" class="form-control"
										placeholder="结束日期"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary to_quert">确认查询</button>
					<button type="button" class="btn btn-danger empty_quert">清空查询</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- SneceInput.js仅作为在查询模态框中（案件类别，选择处所，作案手段）的自动匹配子项使用 -->
	<script type="text/javascript" src="<%=basePath%>js/Case/SneceInput.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Case/defaults-zh_CN.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Case/BreakCaseList.js"></script>
	<script type="text/javascript">
		$.datetimepicker.setLocale('ch');
		$('.mydate').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		/* $('.mydate_minute').datetimepicker({
			yearStart : 1990, // 设置最小年份
			yearEnd : 2050, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d H:i', // 格式化日期年-月-日
			minDate : '1990/01/01', // 设置最小日期
			maxDate : '2030/01/01', // 设置最大日期
		}); */
	</script>
	<script type="text/javascript">
		var documentWidth = document.body.clientWidth;
		var panelWidth = documentWidth - 160;
		var navbarHeight = document.getElementById("navbar").offsetHeight;
		var panelMargin = navbarHeight + 20;
		document.getElementById("allPanel").setAttribute("style", "width:" + panelWidth + "px; float:right; margin-top:" + panelMargin + "px;");
		window.onresize = function() {
			var documentWidth = document.body.clientWidth;
			var panelWidth = documentWidth - 160;
			var navbarHeight = document.getElementById("navbar").offsetHeight;
			var panelMargin = navbarHeight + 20;
			document.getElementById("allPanel").setAttribute("style", "width:" + panelWidth + "px; float:right; margin-top:" + panelMargin + "px;");
		}
	</script>
</body>
</html>