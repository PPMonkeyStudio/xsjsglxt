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

<title>My JSP 'HandleList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="tdis is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<style type="text/css">
.Handle_table_info table thead tr td {
	text-align: center;
}

#Handle_input table {
	font-size: 13px;
}

#Handle_input table tbody tr td {
	text-align: right;
}
</style>

<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 80px 0 0 0; float: left; widtd: 100%;">
		<div class="panel" style="widtd: 95%; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">办案管理</h3>
			</div>
			<div class="panel-body">
				<div class="operation" style="margin-bottom: 6px;">
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default" data-toggle="modal"
						data-target="#newQuery">
						<i class="fa fa-plus-square"></i> 刑事破案查询
					</button>
					<button data-toggle="modal" data-target="#Handle_input"
						style="margin-left: 15px;" type="button" class="btn btn-default">
						<i class="fa fa-plus-square"></i> 添加办案
					</button>
					<button data-toggle="modal" data-target="#Handle_delete"
						style="margin-left: 15px;" type="button" class="btn btn-default">
						<i class="fa fa-plus-square"></i> 删除办案
					</button>
				</div>
				<div class="col-md-12">
					<!-- TABLE HOVER -->
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">破案列表</h3>
							<p class="text-primary query_prompting_info">notding to
								query.</p>
						</div>
						<div class="panel-body">
							<table
								class="table table-hover table-condensed Handle_table_info">
								<thead>
									<tr>
										<td rowspan="2"><span>序号</span></td>
										<td rowspan="2">行政案件名称</td>
										<td rowspan="2">违法嫌疑人姓名</td>
										<td colspan="6">处理方式</td>
										<td colspan="4">涉案财物</td>
										<td colspan="2">案件承办人员</td>
									</tr>
									<tr>
										<td>行政拘留</td>
										<td>逮捕</td>
										<td>起诉</td>
										<td>退查</td>
										<td>取保候审</td>
										<td>监视居住</td>
										<td>财物名称</td>
										<td>上交时间</td>
										<td>处理时间</td>
										<td>处理方式</td>
										<td>中队长</td>
										<td>办案民警</td>
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
	<!------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- -模态框（Modal） -->
	<div class="modal fade" id="Handle_input" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="modal-title">办案添加</h4>
				</div>
				<div class="modal-body">
					<form action="">
						<div style="width: 100%;margin: auto;" class="panel-body">
							<table class="table table-condensed" width="100%">
								<tbody>
									<tr>
										<td>序号</td>
										<td><input class="form-control"
											name="handle.handle_orderNumber" type="text" value="4"></td>
										<td>行政案件名称</td>
										<td><input class="form-control"
											name="handle.handle_administrativeCase" type="text"></td>
										<td>违法嫌疑人姓名</td>
										<td><input class="form-control"
											name="handle.handle_suspectName" type="text"></td>
									</tr>
									<tr>
										<td style="text-align: center;" colspan="6">处理方式</td>
									</tr>
									<tr>
										<td>行政拘留</td>
										<td><label style="float: left;" class="fancy-radio">
												<input name="register" onclick="chose(this)" type="radio"
												value="是"> <span><i></i>是</span>
										</label><label style="float: left; margin-left: 10px;"
											class="fancy-radio"> <input name="register"
												onclick="chose(this)" type="radio" value="否"> <span><i></i>否</span>
										</label> <input type="hidden"
											name="handle.handle_administrativeAttachment"></td>
										<td>拘留起始时间</td>
										<td><input class="form-control"
											name="handle.handle_StartTimeaOfDetention" type="text" /></td>
										<td>拘留天数</td>
										<td><select class="form-control"
											name="handle.handle_detentionDay">
												<option value="3">3天</option>
												<option value="7">7天</option>
												<option value="20">20天</option>
										</select></td>
									</tr>
									<tr>
										<td>逮捕</td>
										<td><label style="float: left;" class="fancy-radio">
												<input name="administrativeAttachment" onclick="chose(this)"
												type="radio" value="是"> <span><i></i>是</span>
										</label><label style="float: left; margin-left: 10px;"
											class="fancy-radio"> <input
												name="administrativeAttachment" onclick="chose(this)"
												type="radio" value="否"> <span><i></i>否</span>
										</label> <input type="hidden"
											name="handle.handle_administrativeAttachment"></td>
										<td>逮捕时间</td>
										<td><input class="form-control"
											name="handle.handle_arrestTime" type="text" /></td>
									</tr>
									<tr>
										<td>起诉</td>
										<td><label style="float: left;" class="fancy-radio">
												<input name="handle_prosecute" onclick="chose(this)"
												type="radio" value="是"> <span><i></i>是</span>
										</label><label style="float: left; margin-left: 10px;"
											class="fancy-radio"> <input name="handle_prosecute"
												onclick="chose(this)" type="radio" value="否"> <span><i></i>否</span>
										</label> <input type="hidden" name="handle.handle_prosecute"></td>
										<td>起诉时间</td>
										<td><input class="form-control"
											name="handle.handle_prosecuteTime" type="text" /></td>
									</tr>
									<tr>
										<td>退查</td>
										<td><label style="float: left;" class="fancy-radio">
												<input name="handle_checkback" onclick="chose(this)"
												type="radio" value="是"> <span><i></i>是</span>
										</label><label style="float: left; margin-left: 10px;"
											class="fancy-radio"> <input name="handle_checkback"
												onclick="chose(this)" type="radio" value="否"> <span><i></i>否</span>
										</label> <input type="hidden" name="handle.handle_checkback"></td>
										<td>退查时间</td>
										<td><input class="form-control"
											name="handle.handle_checkbackTime" type="text" /></td>
									</tr>
									<tr>
										<td>取保候审</td>
										<td><label style="float: left;" class="fancy-radio">
												<input name="handle_pbat" onclick="chose(this)" type="radio"
												value="是"> <span><i></i>是</span>
										</label><label style="float: left; margin-left: 10px;"
											class="fancy-radio"> <input name="handle_pbat"
												onclick="chose(this)" type="radio" value="否"> <span><i></i>否</span>
										</label> <input type="hidden" name="handle.handle_pbat"></td>
										<td>取保候审时间</td>
										<td><input class="form-control"
											name="handle.handle_pbatTime" type="text" /></td>
									</tr>
									<tr>
										<td>监视居住</td>
										<td><label style="float: left;" class="fancy-radio">
												<input name="handle_lhus" onclick="chose(this)" type="radio"
												value="是"> <span><i></i>是</span>
										</label><label style="float: left; margin-left: 10px;"
											class="fancy-radio"> <input name="handle_lhus"
												onclick="chose(this)" type="radio" value="否"> <span><i></i>否</span>
										</label> <input type="hidden" name="handle.handle_lhus"></td>
										<td>监视居住时间</td>
										<td><input class="form-control"
											name="handle.handle_lhusTime" type="text" /></td>
									</tr>
									<tr>
										<td style="text-align: center;" colspan="6">涉案财物</td>
									</tr>
									<tr>
										<td>财物名称</td>
										<td><input class="form-control"
											name="handle.handle_FinancialName" type="text" /></td>
										<td>上交时间</td>
										<td><input class="form-control"
											name="handle.handle_handTime" type="text" /></td>
										<td>处理时间</td>
										<td><input class="form-control"
											name="handle.handle_handleTime" type="text" /></td>
									</tr>
									<tr>
										<td>处理方式</td>
										<td><input class="form-control"
											name="handle.handle_processMode" type="text" /></td>
									</tr>
									<tr>
										<td style="text-align: center;" colspan="6">案件承办人员</td>
									</tr>
									<tr>
										<td>中队长</td>
										<td colspan="2"><select
											name="handle.handle_squadronleader"
											class="form-control selectpicker"></select></td>
										<td>办案民警</td>
										<td colspan="2"><select
											name="handle.handle_PoliceInHandlingCases"
											class="form-control selectpicker"></select></td>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary input">添加</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script type="text/javascript" src="<%=basePath%>js/Case/HandleList.js"></script>
</body>
</html>