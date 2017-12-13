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
<title>人员详情信息</title>
<link rel="stylesheet" href="<%=basePath%>css/Case/table.css">
<link rel="stylesheet" href="<%=basePath%>css/Case/Case.css">
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
				<h3 class="panel-title">人员详情信息</h3>
			</div>
			<button onclick="javascript:history.go(-1)" type="button"
				class="btn btn-default button button_return">
				<i class="fa fa-reply"></i> 返回列表
			</button>
			<button type="button" class="btn btn-default button button_change"
				onclick="case_change()">
				<i class="fa fa-pencil"></i> 编辑人员
			</button>
			<div class="panel-body">
				<form id="caseDetails">
					<table>
						<tr>
							<td>人员表ID</td>
							<td><input style="font-size: 12px;"
								name="sence.snece_inquestId" class="form-control" type="text"></td>
							<td><input style="font-size: 12px;"
								name="sence.snece_inquestId" class="form-control" type="text"></td>
							<td style="padding-left: 5px;">警号</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
							<td style="padding-left: 5px;">姓名</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
							<td style="padding-left: 5px;">照片</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><label style="float: left;" class="fancy-radio">
									<input name="register" onclick="buildCase_chose(this)"
									type="radio" value="1"> <span><i></i>男</span>
							</label><label style="float: left; margin-left: 10px;"
								class="fancy-radio"> <input name="register"
									onclick="buildCase_chose(this)" type="radio" value="2">
									<span><i></i>女</span>
							</label> <input type="hidden" name="Csae.case_register"></td>
							<td>年龄</td>
							<td><input style="font-size: 12px;"
								name="sence.snece_inquestId" class="form-control" type="text"></td>
							<td style="padding-left: 5px;">民族</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
							<td>籍贯</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>

						</tr>
						<tr>
							<td>生日</td>
							<td><input style="font-size: 12px;"
								name="sence.snece_inquestId" class="form-control" type="text"></td>
							<td style="padding-left: 5px;">身份证号</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
							<td>家庭住址</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>

						</tr>
						<tr>
							<td>最高学历</td>
							<td><input style="font-size: 12px;"
								name="sence.snece_inquestId" class="form-control" type="text"></td>
							<td style="padding-left: 5px;">政治面貌</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
							<td>入党时间</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
						</tr>
						<tr>
							<td>是否正式</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
							<td>参加工作时间</td>
							<td><input style="font-size: 12px;"
								name="sence.snece_inquestId" class="form-control" type="text"></td>
							<td style="padding-left: 5px;">入警时间</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>

						</tr>
						<tr>
						<tr>
							<td>手机号</td>
							<td><input name="case1.case_receivingAlarmDate"
								class="form-control" style="margin-top: 6px;" type="text"></td>
							<td>警务通号</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
							<td>家庭电话</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
						</tr>
						<tr>
							<td>QQ号</td>
							<td><input name="case1.case_receivingAlarmDate"
								class="form-control" style="margin-top: 6px;" type="text"></td>
							<td>微信</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
							<td>外网电子邮箱</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
							<td>内网电子邮箱</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
						</tr>
						<tr>
							<td>家庭联系人姓名</td>
							<td><input name="case1.case_receivingAlarmDate"
								class="form-control" style="margin-top: 6px;" type="text"></td>
							<td>家庭联系人电话</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
							<td>与家庭联系人的关系</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>

						</tr>

						<tr>
							<td>家庭联系人微信号</td>
							<td><input name="case1.case_receivingAlarmDate"
								class="form-control" style="margin-top: 6px;" type="text"></td>
							<td>家庭联系人工作单位</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
							<td>家庭联系人职位</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>

						</tr>
						<tr>
							<td>创建时间</td>
							<td><input name="case1.case_receivingAlarmDate"
								class="form-control" style="margin-top: 6px;" type="text"></td>
							<td>修改时间</td>
							<td><input name="case1.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;"></td>
						</tr>
						<tr>
							<td>备注</td>
							<td><input name="case1.case_receivingAlarmDate"
								class="form-control" style="margin-top: 6px;" type="text"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 添加物证-模态框（Modal） -->
	
	<!-- /.modal -->
	
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 添加丢失物品-模态框（Modal） -->
	
		<!-- /.modal -->
	
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 添加光盘照片-模态框（Modal） -->
	<!-- /.modal -->
	


</body>
<script type="text/javascript"
	src="<%=basePath%>js/Team/staffDetails.js"></script>
</html>