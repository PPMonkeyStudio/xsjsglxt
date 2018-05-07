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
<link rel="stylesheet" href="<%=basePath%>css/square/blue.css" />
<script type="text/javascript"
	src="<%=basePath%>js/Technology/DNA/DNAGetBirth.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Technology/DNA/CreateDNA.js"></script>

<script type="text/javascript"
	src="<%=basePath%>js/Technology/DNA/DNADetails.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Technology/DNA/DeleteDNA.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Technology/DNA/List_DNA_By_PageAndSearch.js"></script>
<!---------------------------------------------------------------------------------------------------->
<title>技术管理 > DNA信息</title>
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
				<h3 class="panel-title">DNA信息管理</h3>
			</div>
			<!--  -->
			<div class="panel-body">
				<div style="height: 34px;">
					<div style="width: 150px; float: left; margin: 0 20px 0 0">
						<button class="btn btn-default" onclick="CreateDNA()">
							<i class="fa fa-plus-square"></i> 新增DNA记录
						</button>
					</div>
					<div style="float: left; display: none;">
						<input type="file" class="form-control" id="input_excel"
							style="float: left;" />
					</div>
					<!-- 检索 -->
					<div class="input-group" style="width: 300px; float: right;">
						<input id="input_DNASearchText" class="form-control"
							oninput="List_DNA_By_PageAndSearch(1)" type="text"> <span
							class="input-group-addon"> <i class="fa fa-search"></i>
						</span>
					</div>
				</div>
				<table id="table_DNA" class="table table-hover table-bordered"
					style="text-align: center; margin: 20px 0;">
					<tbody>
						<tr>
							<th>DNA编号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>出生日期</th>
							<th>身份证号</th>
							<th>住址</th>
							<th>违法事实</th>
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

					<button class="btn btn-danger" onclick="DeleteDNA()"
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

<script type="text/javascript" src="<%=basePath%>js/icheck.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Input_Select.js"></script>
<script type="text/javascript" src="<%=basePath%>js/laydate/laydate.js"></script>
<script src="/laydate/laydate.js"></script>
<script type="text/javascript">
	List_DNA_By_PageAndSearch(1);
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