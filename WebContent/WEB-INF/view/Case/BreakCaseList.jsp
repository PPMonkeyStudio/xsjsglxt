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
						<i class="fa fa-plus-square"></i> 刑事破案查询
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
							<p class="text-primary query_prompting_info">nothing query.</p>
						</div>
						<div class="panel-body">
							<table
								class="table table-hover table-condensed breakcase_table_info">
								<thead>
									<tr>
										<th>全选<input type="checkbox" onclick="selectAll(this)"></th>
										<th>所属案件</th>
										<th>勘验编号</th>
										<th>案件类型</th>
										<th>破案人</th>
										<th>破案方式</th>
										<th>破案时间</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="8" style="font-size: 12px;" class="page_info"><a
											onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i>
										</a>&nbsp&nbsp<a onclick="prePage()"><i
												class="fa fa-angle-left"></i>上一页 </a>&nbsp&nbsp<a
											onclick="nextPage()">下一页<i class="fa fa-angle-right"></i>
										</a>&nbsp&nbsp <a onclick="lastPage()">尾页<i
												class="fa fa-angle-double-right"></i>
										</a> <br />
											<p class='info'></p></td>
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
									<td><select name="breakeCaseListVO." class="form-control">
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
	<!------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 破案信息修改-模态框（Modal） -->
	<div class="modal fade" id="breakCase_modification" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
					<button type="button" class="btn btn-primary breakCase_operation">确认修改</button>
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
	<!-- 破案信息增加-模态框（Modal） -->
	<div class="modal fade" id="bbreakCase_input" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title"></h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 80%;margin: auto;" class="panel-body">
							<table class="table table-hover table-condensed" align="center">
								<thead>
									<tr>
										<th>姓名</th>
										<th>性别</th>
										<th>生日</th>
										<th>身份证号</th>
										<th>住址</th>
										<th>抓获</th>
										<th>抓获单位</th>
										<th>抓获时间</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>所属案件<i class="fa fa-spinner fa-pulse load_remind"></i></td>
										<td colspan="3"><select style="witdh:100%;"
											class="form-control selectpicker" data-live-search="true"
											name="breakecase.breakecase_case"
											title="Choose one of the following..."></select></td>
									</tr>
									<tr>
										<td>案件类型</td>
										<td><select style="witdh:100%;" class="form-control"
											data-live-search="true" name="breakecase.breakecase_type">
												<option>新添案件</option>
												<option>已有案件</option>
										</select></td>
										<td>嫌疑人姓名</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_suspectName" type="text"></td>
									</tr>
									<tr>
										<td>破案时间</td>
										<td><input style="witdh:70%;" class="form-control mydate"
											name="breakecase.breakecase_suspectName" type="text"></td>
										<td>带破案件</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_waitbreakecase" type="text"></td>
									</tr>
									<tr>
										<td>性别</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_suspectSex" type="text"></td>
										<td>出生日期</td>
										<td><input style="witdh:70%;" class="form-control mydate"
											name="breakecase.breakecase_suspectBirthday" type="text"></td>
									</tr>
									<tr>
										<td>身份证号码</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_suspectIDnum" type="text"></td>
										<td>住址</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_suspectAddress" type="text"></td>
									</tr>
									<tr>
										<td>破案方式</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_according" type="text"></td>
										<td>是否抓获</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_capture" type="text"></td>
									</tr>
									<tr>
										<td>抓获单位</td>
										<td><input style="witdh:70%;" class="form-control"
											name="breakecase.breakecase_captureUnit" type="text"></td>
										<td>抓获时间</td>
										<td><input style="witdh:70%;" class="form-control mydate"
											name="breakecase.breakecase_captureUnit" type="text"></td>
									</tr>
									<tr>
										<td>备注</td>
										<td colspan="3"><textarea style="witdh:70%;"
												placeholder="请填写" class="form-control"
												name="breakecase.breakecase_remarks"></textarea></td>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary input_sure">添加</button>
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
	<!---------------------------------------------------------------------------------------------------->
	<!-- SneceInput.js仅作为在查询模态框中（案件类别，选择处所，作案手段）的自动匹配子项使用 -->
	<script type="text/javascript" src="<%=basePath%>js/Case/SneceInput.js"></script>
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