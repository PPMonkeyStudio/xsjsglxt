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
<script type="text/javascript"
	src="<%=basePath%>js/SkillManagement/CompareFingerPrintManagement/CreateDNA.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/SkillManagement/CompareFingerPrintManagement/List_DNA_By_PageAndSearch.js"></script>
<!---------------------------------------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------->
<title>技术管理 > 比中指纹</title>
</head>
<body>
	<s:action name="LoginLogoutManagement_navbar" namespace="/loginLogout"
		executeResult="true" />
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
				<h3 class="panel-title">比中指纹管理</h3>
			</div>
			<!--  -->
			<div class="panel-body">
				<div style="height: 34px;">

					<div style="width: 500px; float: left;">
						<button class="btn btn-default" onclick="CreateDNA()">
							<i class="fa fa-plus-square"></i> 新增比中指纹
						</button>

					</div>
					<!-- 检索 -->
					<div class="input-group" style="width: 300px; float: right;">
						<input id="input_DNASearchText" class="form-control" oninput="List_DNA_By_PageAndSearch(1)" type="text">
						<span class="input-group-addon"> <i class="fa fa-search"></i>
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
							<th>违法事实</th>
							<th>建档单位</th>
							<th>建档人</th>
							<th>建档时间</th>
							<th>交档时间</th>
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

					<button class="btn btn-danger" onclick="Delete_Student()"
						style="float: right; margin: 0 10px;">
						<i class="fa fa-trash-o"></i> 删除所选
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
	
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
<script>
	
</script>
</html>