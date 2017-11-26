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
<title>首页</title>
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
		<div class="panel" style="width: 960px; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">创建DNA记录</h3>
			</div>
			<!--  -->
			<div class="panel-body">
				<table class="table table-hover " style="text-align: center;">
					<tbody>
						<tr>
							<th>姓名：</th>
							<td><input type="text" class="form-control" /></td>

						</tr>
						<tr>
							<th>性别：</th>
							<td><select class="form-control" style="width: auto;">
									<option value="男">男</option>
									<option value="女">女</option>
							</select></td>
						</tr>
						<tr>
							<th>出生日期：</th>
							<td><input type="text" class="form-control" /></td>

						</tr>
						<tr>
							<th>身份证号：</th>
							<td><input type="text" class="form-control" /></td>
						</tr>
						<tr>
							<th>地址：</th>
							<td><input type="text" class="form-control" /></td>

						</tr>
						<tr>
							<th>违法事实：</th>
							<td><input type="text" class="form-control" /></td>
						</tr>
						<tr>
							<th>建档单位：</th>
							<td><input type="text" class="form-control" /></td>

						</tr>
						<tr>
							<th>建档人：</th>
							<td><input type="text" class="form-control" /></td>
						</tr>
						<tr>
							<th>建档时间：</th>
							<td><input type="text" class="form-control" /></td>

						</tr>
						<tr>
							<th>交档时间：</th>
							<td><input type="text" class="form-control" /></td>
						</tr>
						<tr>
							<th>备注：</th>
							<td><textarea class="form-control" rows="5" style="resize:none;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<div style="height: 34px; margin: 30px 0;">
					<button class="btn btn-default" onclick=""
						style="float: right; margin: 0 10px;">
						<i class="fa  fa-check "></i> 确认创建
					</button>
					<button class="btn btn-default" onclick="window.location=''"
						style="float: right; margin: 0 10px;">
						<i class="fa  fa-close "></i> 返回
					</button>
				</div>
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