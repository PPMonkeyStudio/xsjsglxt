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

<title>案件管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/Case/Case.css" />
<style type="text/css">
i {
	cursor: pointer;
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
				<h3 class="panel-title">案件管理</h3>
			</div>
			<div class="panel-body">
				<div class="operation" style="margin-bottom: 6px;">
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default" data-toggle="modal"
						data-target="#newQuery">
						<i class="fa fa-plus-square"></i> 案件高级查询
					</button>
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default"
						onclick="javascript:location.href='/xsjsglxt/case/Case_page_Sneceinput'">
						<i class="fa fa-plus-square"></i> 新建案件
					</button>
					<button id="case_delete" style="margin-left: 15px;"
						class="btn btn-default" type="button">
						<i class="fa fa-trash-o"></i> 删除所选案件
					</button>
				</div>
				<div class="col-md-12">
					<!-- TABLE HOVER -->
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">案件列表</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-condensed case_table_info">
								<thead>
									<tr>
										<th style="padding-left:5px;width: 70px;">全选<input
											type="checkbox" onclick="selectAll(this)"></th>
										<th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="page_list_senceInformation.snece_inquestId"
											placeholder="勘验编号"></th>
										<th><select onchange="dynamic_query(this)"
											class="form-control"
											query_name="page_list_senceInformation.order">
												<option selected="selected" value="desc">接警时间(降序)</option>
												<option value="asc">接警时间(升序)</option>
										</select></th>
										<th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="page_list_senceInformation.case_totalCategory"
											placeholder="案件类别"></th>
										<th><input type="text" onkeyup="dynamic_query(this)"
											class="form-control"
											query_name="page_list_senceInformation.case_reporterName"
											placeholder="报案人"></th>
										<th style="padding-left:5px;"><input type="text"
											onkeyup="dynamic_query(this)" class="form-control"
											query_name="page_list_senceInformation.snece_inquestPerson"
											placeholder="主勘人员"></th>
										<th><h5>物证入口</h5></th>
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
					<h4 class="modal-title" id="myModalLabel">现场勘验信息高级查询</h4>
				</div>
				<div class="modal-body">
					<form id="query_infomantion_inmodal" action="">
						<table style="width: 100%;" class="Query_table">
							<tbody>
								<tr>
									<td width="10%">案件类别</td>
									<td width="30%"><select
										name="page_list_senceInformation.case_totalCategory"
										onchange="setSectionCase(this.selectedIndex)"
										class="main_case form-control"><option
												selected="selected" value="">案件总类别</option>
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
										name="page_list_senceInformation.case_sonCategory"
										class="other_case form-control">
											<option selected value="">案件子类别</option>
									</select></td>
									<td style="padding-left: 10px;width:10%;">勘验人员</td>
									<td colspan="3"><input
										name="page_list_senceInformation.snece_inquestPerson"
										id="exploration_personnel" placeholder="请输入"
										class="form-control" style="width: 100%;">
								</tr>
								<tr style="margin-top: 6px;">
									<td style="margin-top: 6px;">选择处所</td>
									<td><select
										name="page_list_senceInformation.case_residence"
										onchange="setSectionmAddress(this.selectedIndex)"
										class="widel_space form-control"><option selected
												value="">选择处所</option>
											<option value="居民住宅">居民住宅</option>
											<option value="单位场所">单位场所</option>
											<option value="服务行业">服务行业</option>
											<option value="其它处所">其它处所</option></select><select
										name="page_list_senceInformation.case_concreteResidence"
										class=" specific_space form-control">
											<option value="">具体处所</option>
									</select></td>
									<td style="padding-left: 10px;">案发地点</td>
									<td colspan="3"><input
										name="page_list_senceInformation.case_address"
										style="float: left; width: 100%;" type="text"
										class="form-control"></td>
									<%-- <select
										name="page_list_senceInformation.snece_inquestPerson"
										id="exploration_personnel"
										class="selectpicker show-tick form-control dropdn" multiple
										data-live-search="false" data-dropup-auto="false" title="请选择">
											<option value="刘楚德">刘楚德</option>
											<option value="龙建平">龙建平</option>
											<option value="刘蓉">刘蓉</option>
											<option value="杨立宇">杨立宇</option>
											<option value="冯俊">冯俊</option>
											<option value="吴昊晟">吴昊晟</option>
											<option value="陈永明">陈永明</option>
											<option value="赖鑫">赖鑫</option>
											<option value="王树鹏">王树鹏</option>
											<option value="许倩">许倩</option>
											<option value="汤喜">汤喜</option>
											<option value="陈佐仁">陈佐仁</option>
											<option value="李希">李希</option>
											<option value="魏松林">魏松林</option>
									</select> --%>
								</tr>
								<tr>
									<td>作案手段</td>
									<td style="margin-top: 6px;"><select
										name="page_list_senceInformation.case_makeMeans"
										onchange="setSectionmMethod(this.selectedIndex)"
										class=" crime_means form-control">
											<option selected value="">作案手段</option>
											<option value="从门侵入">从门侵入</option>
											<option value="从窗侵入">从窗侵入</option>
											<option value="攀爬侵入">攀爬侵入</option>
											<option value="洞口侵入">洞口侵入</option>
											<option value="其它">其它</option>
									</select> <select
										name="page_list_senceInformation.case_concreteMakeMeans"
										class=" specific_means form-control">
											<option value="">具体手段</option>
									</select></td>
									<td style="padding-left: 10px;">报案人</td>
									<td colspan="3"><input
										name="page_list_senceInformation.case_reporterName"
										style="float: left;width: 100%;" type="text"
										class="form-control"></td>

								</tr>
								<tr>
									<td>勘验时间</td>
									<td><input name="page_list_senceInformation.start_time"
										style="float: left;margin-top: 6px;" type="text"
										class="form-control mydate" placeholder="起始日期"><input
										name="page_list_senceInformation.stop_time"
										style=" float: right;margin-top: 6px;" type="text"
										class="form-control mydate" placeholder="结束日期"></td>
									<td style="padding-left: 10px;width: 10%;">作案时段</td>
									<td><select
										name="page_list_senceInformation.case_makeTime"
										class="form-control">
											<option selected value=""></option>
											<option value="昼">昼</option>
											<option value="夜">夜</option>
											<option value="上午">上午</option>
											<option value="中午">中午</option>
											<option value="下午">下午</option>
											<option value="晚上">晚上</option>
											<option value="深夜">深夜</option>
											<option value="凌晨">凌晨</option>
											<option value="其他">其他</option>
									</select></td>
									<td style="padding-left: 10px; width: 70px;">案件分类</td>
									<td><select
										name="page_list_senceInformation.case_classify"
										class=" form-control">
											<option value="" selected></option>
											<option value="非刑事案件">非刑事案件</option>
											<option value="刑事案件">刑事案件</option>
											<option value="非正常死亡">非正常死亡</option>
									</select></td>
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
	<!---------------------------------------------------------------------------------------------------->
	<!-- SneceInput.js仅作为在查询模态框中（案件类别，选择处所，作案手段）的自动匹配子项使用 -->
	<script type="text/javascript" src="<%=basePath%>js/Case/SneceInput.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Case/sitemanagement.js"></script>
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
