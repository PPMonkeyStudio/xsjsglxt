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
<title>痕迹检验委托管理</title>
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
				<h3 class="panel-title">委托书管理</h3>
			</div>
			<!--  -->
			<div class="panel-body">
				<div style="height: 34px;">
					<div style="width: 500px; float: left;">
						<button class="btn btn-default"
							id="button_Create_TranceCheckEntrustmentBook">
							<i class="fa fa-pencil-square-o"></i> 痕迹检验委托鉴定
						</button>
						<button class="btn btn-default"
							id="button_Create_ForensicCheckEntrustmentBook">
							<i class="fa fa-pencil-square-o"></i> 法医检验委托鉴定
						</button>
					</div>
					<!-- 检索 -->
					<div class="input-group" style="width: 300px; float: right;">
						<input id="input_search" class="form-control"
							oninput="List_EntrustmentBook(1)" type="text"> <span
							class="input-group-addon"> <i class="fa fa-search"></i>
						</span>
					</div>
				</div>
				<table id="table_EntrustmentBook"
					class="table table-hover table-bordered"
					style="text-align: center; margin: 20px 0;">
					<tbody>
						<tr>
							<th>委托编号</th>
							<th>案（事）件名称</th>
							<th><select class="form-control"
								id="select_check_entrustment_book_entrustment_unit_name"
								style="width: auto;" onchange="List_EntrustmentBook(1)">
									<option value="-1">被委托鉴定机构（全部）</option>
									<option value="萍乡市公安司法鉴定中心">萍乡市公安司法鉴定中心</option>
									<option value="萍乡市公安局物证鉴定所">萍乡市公安局物证鉴定所</option>
									<option value="萍乡市安源公安司法鉴定中心">萍乡市安源公安司法鉴定中心</option>
									<option value="江西省公安厅物证鉴定中心">江西省公安厅物证鉴定中心</option>
									<option value="公安部物证鉴定中心">公安部物证鉴定中心</option>
							</select></th>
							<th>委托日期</th>
							<th><select class="form-control"
								id="select_check_entrustment_book_entrustment_unit_name"
								style="width: auto;" onchange="List_EntrustmentBook(1)">
									<option value="-1">类别（全部）</option>
									<option value="痕迹">痕迹</option>
									<option value="法医">法医</option>
							</select></th>
							<th><select class="form-control"
								id="select_check_entrustment_book_entrustment_unit_name"
								style="width: auto;" onchange="List_EntrustmentBook(1)">
									<option value="-1">状态（全部）</option>
									<option value="正在申请">正在申请</option>
									<option value="申请已受理">申请已受理</option>
									<option value="申请被拒绝">申请被拒绝</option>
									<option value="已记录">已记录</option>
									<option value="已鉴定">已鉴定</option>
							</select></th>
							<th>操作</th>
							<th><label class="fancy-checkbox"> <input
									id="checkbox_all_select" type="checkbox" onclick="all_select()">
									<span>全选</span>
							</label></th>
						</tr>
					</tbody>
				</table>
				<div id="i_pulse" style="text-align: center;">
					<i class="fa fa-spinner fa-pulse fa-3x"></i>
				</div>

				<div style="height: 34px; margin: 0 0 20px 0;">
					<button class="btn btn-danger" onclick="Remove_EntrustmentBook()"
						style="float: right; margin: 0 10px;">
						<i class="fa fa-trash-o"></i> 删除委托
					</button>
				</div>
				<div style="margin: 0 auto; width: 400px; text-align: center;">
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
						id="span_totalPages">1</span> 页 <br> 共 <span
						id="span_totalRecords">0</span> 条记录
				</div>
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
	src="<%=basePath%>js/InspectionIdentification/Create_TranceCheckEntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Create_ForensicCheckEntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Remove_EntrustmentBook.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/InspectionIdentification/Acceptance_EntrustmentBook.js"></script>
</html>