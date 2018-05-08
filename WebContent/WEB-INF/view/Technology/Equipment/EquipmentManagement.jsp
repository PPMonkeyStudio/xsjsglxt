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
<script type="text/javascript"
	src="<%=basePath%>js/Technology/Equipment/CreateEquipment.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Technology/Equipment/EquipmentSelectChange.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Technology/Equipment/EquipmentDetails.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Technology/Equipment/DeleteEquipment.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Technology/Equipment/List_Equipment_By_PageAndSearch.js"></script>
<!---------------------------------------------------------------------------------------------------->
<title>技术管理 > 器材装备</title>
<style type="text/css">
	#bottomPage{
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
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">器材装备管理</h3>
			</div>
			<!--  -->
			<div class="panel-body">
				<div style="height: 34px;">

					<div style="width: 500px; float: left;">
						<button class="btn btn-default" onclick="CreateEquipment()">
							<i class="fa fa-plus-square"></i> 新增器材装备
						</button>

					</div>
					<!-- 检索 -->
					<div class="input-group" style="width: 300px; float: right;">
						<input id="input_EquipmentSearchText" class="form-control"
							oninput="List_Equipment_By_PageAndSearch(1)" type="text">
						<span class="input-group-addon"> <i class="fa fa-search"></i>
						</span>
					</div>
				</div>
				<table id="table_Equipment" class="table table-hover table-bordered"
					style="text-align: center; margin: 20px 0;">
					<tbody>
						<tr>
							<th>装备序号</th>
							<th>装备名称</th>
							<th>装备类型</th>
							<th>数量</th>
							<th>启用日期</th>
							<th>使用情况</th>
							<th>操作</th>
							<th><label class="fancy-checkbox"> <input
									id="checkbox_all_select" type="checkbox" onclick="all_select()">
									<span></span>
							</label></th>
						</tr>
					</tbody>
				</table>


				<div id="i_pulse" style="text-align: center;">
					<i class="fa fa-spinner fa-pulse fa-3x"></i>
				</div>



				<div style="height: 34px; margin: 0 0 20px 0;">

					<button class="btn btn-danger" onclick="DeleteEquipment()"
						style="float: right; margin: 0 10px;">
						<i class="fa fa-trash-o"></i> 删除所选
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
			</div>
			<!--  -->

		</div>
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
	</div>

	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
<link rel="stylesheet" href="<%=basePath%>css/square/blue.css" />
<script type="text/javascript" src="<%=basePath%>js/icheck.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Input_Select.js"></script>
<script type="text/javascript" src="<%=basePath%>js/laydate/laydate.js"></script>

<script type="text/javascript">
	List_Equipment_By_PageAndSearch(1);
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
</html>