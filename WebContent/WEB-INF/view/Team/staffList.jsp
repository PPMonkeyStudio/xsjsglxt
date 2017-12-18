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
<title>人员管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>css/Team/Team.css">
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
				<h3 class="panel-title">人员管理</h3>
			</div>
			<div class="panel-body">
				<div class="operation" style="margin: 0 0 6px 50px;">
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default" data-toggle="modal"
						data-target="#iqueryModal">
						<i class="fa fa-plus-square"></i> 新建查询
					</button>
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default"
						onclick="javascript:location.href='/xsjsglxt/team/Staff_page_newStaff'">
						<i class="fa fa-plus-square"></i> 新建人员
					</button>
					<button style="margin-left: 15px;" type="button"
						class="btn btn-default button-del" onclick="staff_del()">
						<i class="fa fa-plus-square"></i>删除人员
					</button>

				</div>
				<div class="col-md-12">
					<!-- TABLE HOVER -->
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title staff_title">人员列表</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover table-condensed staff_table_info">
								<thead>
									<tr>
										<th><input type="checkbox" id="Check-btn"
											onclick="allCheck()" /></th>
										<th>id</th>
										<th>姓名</th>
										<th>性别</th>
										<th>身份证号</th>
										<th>政治面貌</th>
										<th>警号</th>
										<th>修改时间</th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
							<div class="page-footer">
								<p class='page-infomation'></p>
								<div class="page_info">&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="firstPage()"><i class="fa fa-angle-double-left">首页</i></a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="prePage()"><i class="fa fa-angle-left"></i>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="nextPage()">下一页<i class="fa fa-angle-right"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
									<a onclick="lastPage()">尾页<i
										class="fa fa-angle-double-right"></i></a>
							</div>
						</div>
					</div>
					<!-- END TABLE HOVER -->
				</div>

			</div>
		</div>
	</div>
	<!--新建查询模态框 start  -->
	<div class="modal fade" id="iqueryModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">查询条件</h4>
				</div>
				<div class="modal-body">
					<form action="" id="iquery_form">
						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">姓名</label> <input
										type="text" class="staff_info_input"
										name="page_list_staffInformation.staff_name" /></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">性别</label> <select
										name="page_list_staffInformation.staff_sex"
										class="staff_info_input">
											<option>男</option>
											<option>女</option>
									</select></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">政治面貌</label> <select
										name="page_list_staffInformation.staff_politicalStatus"
										class="staff_info_input">
											<option>党员</option>
											<option>团员</option>
											<option>群众</option>
									</select></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">入警时间</label> <input
										name="page_list_staffInformation.start_time" type="text"
										class="staff_info_input" />&nbsp;&nbsp;到 <input
										name="page_list_staffInformation.stop_time" type="text"
										class="staff_info_input" /></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary" onclick="iquery()"
						data-dismiss='modal'>查询</button>
				</div>
			</div>
		</div>
	</div>
	<!--新建查询模态框 end  -->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- SneceInput.js仅作为在查询模态框中（案件类别，选择处所，作案手段）的自动匹配子项使用 -->

	<script type="text/javascript" src="<%=basePath%>js/Team/staffList.js"></script>
</body>
</html>