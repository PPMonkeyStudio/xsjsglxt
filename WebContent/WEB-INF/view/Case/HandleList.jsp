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
<title>办案管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="tdis is my page">
</head>
<style type="text/css">
.Handle_table_info thead tr td {
	text-align: center;
}

.Handle_table_info thead tr td span {
	font-size: 14px;
}

.Handle_table_info tbody tr td {
	text-align: center;
	font-size: 14px;
	cursor: pointer;
}

#Handle_input table {
	font-size: 13px;
}

#Handle_input table tbody tr td {
	text-align: right;
}

.tr_back {
	background-color: silver;
}

.page_info span {
	cursor: pointer;
}
</style>

<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<div id="vue-main">
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<div style="margin: 80px 0 0 0; float: left; width: 100%;">
			<!---------------------------------------------------------------------------------------------------->
			<!---------------------------------------------------------------------------------------------------->
			<div class="panel" style="width: 95%; margin: 20px auto;">
				<!--  -->
				<div class="panel-heading">
					<h3 class="panel-title">办案管理</h3>
				</div>
				<div class="panel-body">
					<div class="operation" style="margin-bottom: 6px;">
						<button style="margin-left: 15px;" type="button"
							class="btn btn-default" data-toggle="modal"
							data-target="#Handle_query">
							<i class="fa fa-plus-square"></i> 办案查询
						</button>
						<button data-toggle="modal" data-target="#Handle_input"
							style="margin-left: 15px;" type="button" class="btn btn-default">
							<i class="fa fa-plus-square"></i> 添加办案
						</button>
						<button style="margin-left: 15px;" type="button"
							class="btn btn-default Handle_delete">
							<i class="fa fa-plus-square"></i> 删除办案
						</button>
					</div>
					<div class="col-md-12">
						<!-- TABLE HOVER -->
						<div class="panel">
							<div class="panel-heading">
								<h3 class="panel-title">办案列表</h3>
							</div>
							<div class="panel-body">
								<table
									class="table table-condensed table-bordered Handle_table_info">
									<thead>
										<tr>
											<td style="padding-left: 5px;" rowspan="2"><input
												type="checkbox" onclick="selectAll(this)"><br>全选</td>
											<td><span>案件名称</span></td>
											<td><span>嫌疑人</span></td>
											<td><span>性别</span></td>
											<td><span>处理方式</span></td>
											<td><span>处理时间</span></td>
											<td><span>随身财务</span></td>
											<td><span>主办民警</span></td>
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
		<!------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<!-- -模态框（Modal） -->
		<div class="modal fade" id="Handle_input" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 700px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="modal-title">办案添加</h4>
					</div>
					<div class="modal-body">
						<form action="">
							<div style="width: 100%; margin: auto;" class="panel-body">
								<table class="table" width="100%">
									<tbody>
										<tr>
											<td width="70px">案件名称</td>
											<td colspan="3"><input class="form-control"
												id="handle_administrativeCase"></td>
										</tr>
										<tr>
											<td width="70px">主办民警</td>
											<td><input class="form-control"
												id="handleSponsoredPolice" type="text"></td>
											<td width="70px">协办民警</td>
											<td><input class="form-control"
												id="handleAssistingPolice" type="text"></td>
										</tr>
										<tr>
											<td width="70px">侦查所长</td>
											<td><input class="form-control"
												id="handleSquadronLeader" type="text"></td>
											<td>案件类别</td>
											<td><select v-model="caseCategory" class="form-control"
												id="caseCategory">
													<option value="刑事案件">刑事案件</option>
													<option value="行政案件">行政案件</option>
											</select></td>
										</tr>
									</tbody>
								</table>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button id="" style="display: none;" type="button"
							class="btn btn-primary handle_modify">修改</button>
						<button type="button" class="btn btn-primary"
							onclick="handleInput()">添加</button>
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
		<!-- -模态框（Modal） -->
		<div class="modal fade" id="Handle_query" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="modal-title">办案查询</h4>
					</div>
					<div class="modal-body">
						<form action="">
							<div style="width: 100%; margin: auto;" class="panel-body">
								<table class="table table-condensed" width="100%">
									<tbody>
										<tr>
											<td>拘留起始时间</td>
											<td><input class="form-control mydate"
												placeholder="起始时间"
												name="page_list_HandleInformation.handle_StartTimeaOfDetention_start_time"
												type="text"></td>
											<td><input class="form-control mydate"
												placeholder="结束时间"
												name="page_list_HandleInformation.handle_StartTimeaOfDetention_stop_time"
												type="text"></td>
										</tr>
										<tr>
											<td>逮捕时间</td>
											<td><input class="form-control mydate"
												placeholder="起始时间"
												name="page_list_HandleInformation.handle_arrestTime_start_time"
												type="text"></td>
											<td><input class="form-control mydate"
												placeholder="结束时间"
												name="page_list_HandleInformation.handle_arrestTime_stop_time"
												type="text"></td>
										</tr>
										<tr>
											<td>起诉时间</td>
											<td><input class="form-control mydate"
												placeholder="起始时间"
												name="page_list_HandleInformation.handle_prosecuteTime_start_time"
												type="text"></td>
											<td><input class="form-control mydate"
												placeholder="结束时间"
												name="page_list_HandleInformation.handle_prosecuteTime_stop_time"
												type="text"></td>
										</tr>
										<tr>
											<td>退查时间</td>
											<td><input class="form-control mydate"
												placeholder="起始时间"
												name="page_list_HandleInformation.handle_checkbackTime_start_time"
												type="text"></td>
											<td><input class="form-control mydate"
												placeholder="结束时间"
												name="page_list_HandleInformation.handle_checkbackTime_stop_time"
												type="text"></td>
										</tr>
										<tr>
											<td>取保候审时间</td>
											<td><input class="form-control mydate"
												placeholder="起始时间"
												name="page_list_HandleInformation.handle_pbatTime_start_time"
												type="text"></td>
											<td><input class="form-control mydate"
												placeholder="结束时间"
												name="page_list_HandleInformation.handle_pbatTime_stop_time"
												type="text"></td>
										</tr>
										<tr>
											<td>监视居住时间</td>
											<td><input class="form-control mydate"
												placeholder="起始时间"
												name="page_list_HandleInformation.handle_lhusTime_start_time"
												type="text"></td>
											<td><input class="form-control mydate"
												placeholder="结束时间"
												name="page_list_HandleInformation.handle_lhusTime_stop_time"
												type="text"></td>
										</tr>
										<tr>
											<td>拘留天数</td>
											<td><select class="form-control"
												name="page_list_HandleInformation.handle_detentionDay">
													<option value="">不做查询</option>
													<option value="3">3天</option>
													<option value="7">7天</option>
													<option value="20">20天</option>
											</select></td>
										</tr>
										<tr>
											<td>案件名称</td>
											<td><input class="form-control"
												name="page_list_HandleInformation.handle_administrativeCase"
												type="text"></td>
										</tr>
										<tr>
											<td>中队长</td>
											<td><input class="form-control"
												name="page_list_HandleInformation.handle_squadronleader"
												type="text"></td>
										</tr>
										<tr>
											<td>办案民警</td>
											<td><input class="form-control"
												name="page_list_HandleInformation.handle_PoliceInHandlingCases"
												type="text"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary handle_query">查询</button>
						<button type="button" class="btn btn-danger handle_empty">清空查询</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/Case/HandleList.js"></script>
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
</body>
</html>