<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!---------------------------------------------------------------------------------------------------->

<!---------------------------------------------------------------------------------------------------->
<title>检验鉴定</title>
<style type="text/css">
	#bottomPage{
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
		<!--  -->
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title useClass">委托书管理</h3>
			</div>
			<!--  -->
			<div class="panel-body">
				<div style="height: 34px; margin: 0 0 20px 0;">

					<input id="select_stop_time" class="form-control mydate"
						style="width: 150px; float: right; margin: 0 0 0 20px; text-align: center;"
						type="text">
					<%--  --%>
					<span style="float: right; margin: 0 0 0 20px; line-height: 34px;">至</span>
					<!--  -->
					<input id="select_start_time" class="form-control mydate"
						style="width: 150px; float: right; text-align: center;"
						type="text">
					<%--  --%>
					<span style="float: right; margin: 0 0 0 20px; line-height: 34px;">按日期筛选：</span>
				</div>
				<div style="height: 34px;">
					<div style="width: 500px; float: left;">
						<button class="btn btn-default"
							id="button_Create_TranceCheckEntrustmentBook">
							<i class="fa fa-pencil-square-o"></i> 检验鉴定委托书（通用）
						</button>
						<button class="btn btn-default "
							id="button_Create_ForensicCheckEntrustmentBook">
							<i class="fa fa-pencil-square-o"></i> 法医检验委托鉴定
						</button>
					</div>
					<!-- 检索 -->
					<div class="input-group" style="width: 300px; float: right;">
						<input id="input_search" class="form-control"
							oninput="List_EntrustmentBook(1)" type="text"> <span
							class="input-group-addon" onclick="List_EntrustmentBook(1)">
							<i class="fa fa-search"></i>
						</span>
					</div>
				</div>
				<table id="table_EntrustmentBook" class="table table-hover "
					style="text-align: center; margin: 20px 0;">
					<tbody>
						<tr>
							<th>委托编号</th>
							<th>案（事）件名称</th>
							<th><select class="form-control"
								id="select_entrustmentRequire" style="width: auto;"
								onchange="List_EntrustmentBook(1)">
									<option value="-1">鉴定要求（全部）</option>
									<option value="DNA检验">DNA检验</option>
									<option value="指纹检验鉴定">指纹检验鉴定</option>
									<option value="足迹检验鉴定">足迹检验鉴定</option>
									<option value="整体分离检验鉴定">整体分离检验鉴定</option>
									<option value="车辆痕迹检验鉴定">车辆痕迹检验鉴定</option>
									<option value="死因鉴定">死因鉴定</option>
									<option value="损伤鉴定">损伤鉴定</option>
									<option value="理化检验鉴定">理化检验鉴定</option>
									<option value="毒物检验鉴定">毒物检验鉴定</option>
									<option value="失踪人口查询">失踪人口查询</option>
									<option value="2">其他鉴定要求</option>
							</select></th>
							<th><select class="form-control" id="select_entrustmentUnit"
								style="width: auto;" onchange="List_EntrustmentBook(1)">
									<option value="-1">委托单位（全部）</option>
									<option value="安源公安分局刑警大队">安源公安分局刑警大队</option>
									<option value="安源派出所">安源派出所</option>
									<option value="城郊派出所">城郊派出所</option>
									<option value="凤凰派出所">凤凰派出所</option>
									<option value="后埠派出所">后埠派出所</option>
									<option value="八一派出所">八一派出所</option>
									<option value="东大派出所">东大派出所</option>
									<option value="青山派出所">青山派出所</option>
									<option value="丹江派出所">丹江派出所</option>
									<option value="白源派出所">白源派出所</option>
									<option value="高坑派出所">高坑派出所</option>
									<option value="五陂下派出所">五陂下派出所</option>
									<option value="李子园派出所">李子园派出所</option>
									<option value="其他">其他</option>
							</select></th>
							<th>委托日期</th>
							<th><select class="form-control" id="select_type"
								style="width: auto;" onchange="List_EntrustmentBook(1)">
									<option value="-1">类别（全部）</option>
									<option value="痕迹">通用</option>
									<option value="法医">法医</option>
							</select></th>
							<th><select class="form-control" id="select_state"
								style="width: auto;" onchange="List_EntrustmentBook(1)">
									<option value="-1">状态（全部）</option>
									<option value="正在申请">正在申请</option>
									<option value="申请已受理">申请已受理</option>
									<option value="申请被拒绝">申请被拒绝</option>
									<option value="已记录">已记录</option>
									<option value="已鉴定">已鉴定</option>
							</select></th>
							<th>操作</th>
							<th style="width: 100px;"><label class="fancy-checkbox">
									<input id="checkbox_all_select" type="checkbox"
									onclick="all_select()"> <span>全选</span>
							</label></th>
						</tr>
					</tbody>
				</table>
				<div id="i_pulse" style="text-align: center;">
					<i class="fa fa-spinner fa-pulse fa-3x"></i>
				</div>

				<div style="height: 34px; margin: 0 0 20px 0;">
					<button class="btn btn-danger user_check_power"
						onclick="Remove_EntrustmentBook()"
						style="float: right; margin: 0 10px;">
						<i class="fa fa-trash-o"></i> 删除委托
					</button>
				</div>

				<div id="bottomPage" style="padding: 20px;">
					<span>当前页数:<span id="span_pageIndex">1</span></span> <span>共:<span
						id="span_totalPages">2</span>页
					</span> 共 <span id="span_totalRecords">0</span> 条记录 <span
						onclick="flip(1)" id="indexPage" class="pageOperation">首页</span> <span
						onclick="flip(2)" id="previousPage" class="pageOperation">上一页</span>
					<span onclick="flip(3)" id="nextPage" class="pageOperation">下一页</span>
					<span onclick="flip(4)" id="lastPage" class="pageOperation">末页</span>
				</div>
<%-- 				<div style="margin: 0 auto; width: 400px; text-align: center;">
					<button id="button_HomePage" class="btn btn-default"
						onclick="flip(1)">首页</button>
					<button id="button_PrePage" class="btn btn-default"
						onclick="flip(2)">上一页</button>
					<button id="button_NextPage" class="btn btn-default"
						onclick="flip(3)">下一页</button>
					<button id="button_EndPage" class="btn btn-default"
						onclick="flip(4)">尾页</button>
				</div>
				<div
					style="margin: 20px auto 20px; width: 200px; text-align: center;">
					第 <span id="span_pageIndex">1</span> 页 <br> 共 <span
						id="span_totalPages">1</span> 页 <br>
				</div> --%>
			</div>
			<!--  -->

		</div>
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
	</div>
	<!---------------------------------------------------------------------------------------------------->


</body>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/List_EntrustmentBook.js"></script>
<script>
	List_EntrustmentBook(1);
</script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Create_EntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Remove_EntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Acceptance_EntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Refuse_EntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Create_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Create_Damage_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Create_Death_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Create_AppraisalLetter.js"></script>
<!---------------------------------------------------------------------------------------->
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_EntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_ConfirmBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_AcceptanceEntrustmentInform.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_NotAcceptanceEntrustmentInform.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_Death_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_Damage_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Preview_AppraisalLetter.js"></script>
<!---------------------------------------------------------------------------------------->
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Update_EntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Update_ConfirmBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Update_NotAcceptanceEntrustmentInform.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Update_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Update_Death_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Update_Damage_InspectionRecord.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Update_AppraisalLetter.js"></script>
<!---------------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/square/blue.css" />
<script type="text/javascript" src="<%=basePath%>js/icheck.js"></script>
<!---------------------------------------------------------------------------------------->
<style>
li a {
	cursor: pointer;
}
</style>
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
</html>