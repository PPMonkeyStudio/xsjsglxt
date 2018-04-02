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
}

tfoot tr td a:hover {
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
	<div style="float: left; width: 100%;">
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
					<button data-toggle="modal" data-target="#breakCase_input"
						style="margin-left: 15px;" type="button" class="btn btn-default">
						<i class="fa fa-plus-square"></i> 添加刑事破案
					</button>
				</div>
				<div class="col-md-12">
					<!-- TABLE HOVER -->
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">破案列表</h3>
							<!-- <p class="text-primary query_prompting_info">nothing to
								query.</p> -->
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
										<!-- <th>现场指纹编号</th> -->
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
										style="float: left;" type="text" class="form-control mydate"
										placeholder="起始日期"><input
										name="page_list_BreakecaseInformation.stop_time"
										style="float: right;" type="text" class="form-control"
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
	<!-- 破案信息-模态框（Modal）确认修改 -->
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
						<div style="width: 80%; margin: auto;" class="panel-body"></div>
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
	<!-- 破案信息-模态框（Modal）添加 -->
	<div class="modal fade" id="breakCase_input" tabindex="-1"
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
						<div style="width: 80%; margin: auto;" class="panel-body">
							<table class="table table-hover table-condensed" align="center">
								<tbody>
									<tr>
										<td>所属案件<i class="fa fa-spinner fa-pulse load_remind"></td>
										<td colspan="3"><select style="witdh: 100%;"
											class="form-control selectpicker" data-live-search="true"
											name="breakCase.breakcase_case" id="breakcase_case"
											title="请选择"></select></td>
									</tr>
									<tr>
										<td>案件类型</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_type" type="text"></td>
										<%-- <td><select style="witdh: 100%;" class="form-control"
											data-live-search="true" name="breakCase.breakcase_type" id="breakcase_type"><option>新添案件</option>
												<option>已有案件</option></select></td> --%>
										<td>嫌疑人姓名</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_suspecter_name" type="text"></td>
									</tr>
									<tr>
										<td>案件级别</td>
										<td><select style="witdh: 100%;" class="form-control"
											name="breakCase.breakcase_case_level">
												<option>A级</option>
												<option>B级</option>
												<option>C级</option>
										</select></td>

										<td>性别</td>
										<td><select style="witdh: 100%;" class="form-control"
											name="breakCase.breakcase_suspecter_sex"><option>男</option>
												<option>女</option></select></td>

									</tr>
									<tr>
										<td>案件属地</td>
										<td><select style="witdh: 100%;" class="form-control"
											name="breakCase.breakcase_case_territorial"><option>本地</option>
												<option>外地</option>
												<option>公安部协查</option></select></td>
										<td>身份证号码</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_suspecter_identity"
											id="breakcase_suspecter_identity" type="text"
											onblur="BreakCaseListGetBirth()" maxlength="18"></td>

									</tr>
									<tr>
										<td>破案依据</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_according" type="text"></td>

										<td>出生日期</td>
										<td><input style="witdh: 70%;"
											class="form-control mydate"
											name="breakCase.breakcase_suspecter_birthday"
											id="breakcase_suspecter_birthday" type="text"></td>



									</tr>
									<tr>
										<td>是否抓获</td>
										<td><select style="witdh: 100%;" class="form-control"
											data-live-search="true" name="breakCase.breakcase_arrested"><option>是</option>
												<option>否</option>
										</select></td>
										<td>户籍地</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_suspecter_domicile" type="text"></td>

									</tr>

									<tr>
										<td>抓获单位</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_arrested_department" type="text"></td>
										<td>现住址</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_present_address" type="text"></td>
									</tr>
									<tr>
										<td>带破案件</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_waitbreakcase" type="text"></td>
										<td>联系电话</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_phone" type="text"></td>
									</tr>
									<!-- <tr>
										<td>简要案情</td>
										<td colspan="3"><textarea style="witdh: 70%;"
												placeholder="请填写" class="form-control"
												name="briefDetails.briefdetails_details"></textarea></td>
									</tr> -->
									<!-- 合并比中指纹  -->
									<tr>
										<td>现场指纹编号</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_locale_fingerprint_number"
											type="text"></td>
										<td>按印指纹编号</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_press_fingerprint_number"
											type="text"></td>
									</tr>
									<tr>
										<td>比对时间</td>
										<td><input style="witdh: 70%;"
											class="form-control mydate"
											name="breakCase.breakcase_contrast_time" type="text"></td>
										<td>比对方式</td>
										<td><select style="witdh: 100%;" class="form-control"
											data-live-search="true"
											name="breakCase.breakcase_contrast_way"><option>正查</option>
												<option>倒查</option>
												<option>人工</option></select></td>
									</tr>
									<tr>
										<td>比对单位</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_department" type="text"></td>
										<td>比对人</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_contraster" type="text"></td>
									</tr>
									<tr>
										<td>按印部门</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_press_department"
											type="text"></td>
										<td>提取部门</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_extract_department"
											type="text"></td>
									</tr>
									<tr>
										<td>按印人</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_presser" type="text"></td>
										<td>提取人</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_extracter" type="text"></td>
									</tr>
									<tr>
										<td>按印时间</td>
										<td><input style="witdh: 70%;"
											class="form-control mydate"
											name="breakCase.breakcase_contrast_press_time" type="text"></td>
										<td>指位</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_fingerposition"
											type="text"></td>
									</tr>

									<tr>
										<td>复核人</td>
										<td><input style="witdh: 70%;" class="form-control"
											name="breakCase.breakcase_contrast_reviewer" type="text"></td>
										<td>抓获时间</td>
										<td><input style="witdh: 70%;"
											class="form-control mydate"
											name="breakCase.breakcase_arrested_time" type="text"></td>
									</tr>
									<tr>
									</tr>



									<tr>
										<td>备注</td>
										<td colspan="3"><textarea style="witdh: 70%;"
												placeholder="请填写" class="form-control"
												name="breakCase.breakcase_remark"></textarea></td>
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