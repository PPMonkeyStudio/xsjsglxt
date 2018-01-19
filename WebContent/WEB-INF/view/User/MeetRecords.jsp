<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<title>会议记录</title>
<!-- -----------------模态框js文件引入--------------------------------  -->
<script type="text/javascript" src="<%=basePath %>js/meeting/writeMeetingRecord.js"></script>

</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<div class="headDic">
				<button class="btn btn-default" onclick="createConfirm()"><i class="fa fa-pencil-square-o"></i>填写会议记录表</button>
			</div>
		
			<div class="tableDiv">
				<table class="table table-bordered" style="text-align: center;"">
					<thead>
						<tr style="background-color: #696969; color: white;">
							<td>会议标题</td>
							<td>会议地点</td>
							<td>会议主持人</td>
							<td><select class="form-control">
								<option value="desc">会议开始时间（降序）</option>
								<option value="asc">会议开始时间（升序）</option>
							</select> </td>
							<td>会议结束时间</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		
		</div>
	</div>
	
	
</body>
</html>