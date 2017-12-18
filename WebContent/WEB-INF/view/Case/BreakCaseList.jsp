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

<title>My JSP 'BreakCase.jsp' starting page</title>

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
}
</style>
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
				<h3 class="panel-title">刑事破案</h3>
			</div>
			<div class="panel-body">
				<div class="operation" style="margin-bottom: 6px;">
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default" data-toggle="modal"
						data-target="#newQuery">
						<i class="fa fa-plus-square"></i> 刑事破案查询
					</button>
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default"
						onclick="javascript:location.href='/xsjsglxt/case/BreakCase_page_BreakCaseinput'">
						<i class="fa fa-plus-square"></i> 添加刑事破案
					</button>
				</div>
				<div class="col-md-12">
					<!-- TABLE HOVER -->
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">破案列表</h3>
							<p class="text-primary query_prompting_info">nothing to
								query.</p>
						</div>
						<div class="panel-body">
							<table
								class="table table-hover table-condensed breakcase_table_info">
								<thead>
									<tr>
										<th>序号</th>
										<th>所属案件</th>
										<th>案件类型</th>
										<th>破案依据</th>
										<th>是否抓获</th>
										<th>抓获单位</th>
										<th>带破案件</th>
										<th>嫌疑人姓名</th>
										<th>操作</th>
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
									<td>勘验编号</td>
									<td><input
										name="page_list_BreakecaseInformation.snece_inquestId"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>案件名</td>
									<td><input
										name="page_list_BreakecaseInformation.snece_inquestId"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>案件类别</td>
									<td><select
										name="page_list_BreakecaseInformation.case_totalCategory"
										onchange="setSectionCase(this.selectedIndex)"
										class="main_case form-control"><option
												selected="selected" value="">请选择案件总类别</option>
											<option value="盗窃案">盗窃案</option>
											<option value="抢劫案">抢劫案</option>
											<option value="抢夺案">抢夺案</option>
											<option value="强奸案">强奸案</option>
											<option value="绑架案">绑架案</option>
											<option value="杀人案">杀人案</option>
											<option value="故意伤害案">故意伤害案</option>
											<option value="爆炸案">爆炸案</option>
											<option value="放火案">放火案</option>
											<option value="非法拘禁案">非法拘禁案</option>
											<option value="非正常死亡">非正常死亡</option>
											<option value="故意损坏公私财物">故意损坏公私财物</option>
											<option value="其它">其它</option></select> <select
										name="page_list_BreakecaseInformation.case_sonCategory"
										class="other_case form-control">
											<option selected value="">请选择案件子类别</option>
									</select></td>
								</tr>
								<tr>
									<td>嫌疑人姓名</td>
									<td><input
										name="page_list_BreakecaseInformation.breakecase_suspectName"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>抓获单位</td>
									<td><input
										name="page_list_BreakecaseInformation.breakecase_captureUnit"
										class="form-control" type="text"></td>
								</tr>
								<tr>
									<td>接警时间</td>
									<td><input
										name="page_list_BreakecaseInformation.start_time"
										style="float: left;" type="text" class="form-control"
										placeholder="起始日期"><input
										name="page_list_BreakecaseInformation.stop_time"
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
	<!-- 破案信息-模态框（Modal） -->
	<div class="modal fade" id="breakCaseinput" tabindex="-1" role="dialog"
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
					<button type="button" class="btn btn-primary breakCase_operation">确认修改</button>
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
</body>
</html>

