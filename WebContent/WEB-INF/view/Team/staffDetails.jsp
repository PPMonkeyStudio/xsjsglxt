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
<link rel="stylesheet" href="<%=basePath%>css/Team/Team.css">
</head>
<body onload=get_staffDetails()>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div
		style="margin: 80px 0 0 0; float: left; width: 100%; overflow: hidden;">
		<div class="panel"
			style="width: 95%; margin: 20px auto; overflow: inherit; position: relative;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">人员详情信息</h3>
			</div>
			<button onclick="javascript:history.go(-1)" type="button"
				class="btn btn-default button button_return ">
				<i class="fa fa-reply"></i> 返回列表
			</button>
			<button type="button" class="btn btn-default button button_change"
				onclick="staff_change()">
				<i class="fa fa-pencil"></i> 编辑人员
			</button>
			<div class="panel-body staff_body">
				<form id="staffDetails">
					<table>
						<tr>
							<td colspan="6" class="staff_info_title">基本信息</td>
						</tr>
						<tr style="height: 20px"></tr>
						<tr>
							<td><label>姓名</label></td>
							<td><input name="staff.staff_name" class="form-control"
								type="text"></td>

							<td><label>警号</label></td>
							<td><input name="staff.staff_alarm" class="form-control"
								type="text"></td>

							<td><label>照片</label></td>
							<td rowspan="3"><div class="photo" name="staff.staff_photo"></div></td>
						</tr>
						<tr>
							<td><label>人员ID</label></td>
							<td><input style="font-size: 12px;" name="staff.staff_alarm"
								class="form-control" type="text"></td>
							<td><label>身份证号</label></td>
							<td><input name="staff.staff_idNumber" class="form-control"
								type="text"></td>

						</tr>
						<tr>
							<td><label>年龄</label></td>
							<td><input style="font-size: 12px;" name="staff.staff_age"
								class="form-control" type="text"></td>
							<td><label>民族</label></td>
							<td><input name="staff.staff_nation" class="form-control"
								type="text"></td>

						</tr>

						<tr>
							<td><label>生日</label></td>
							<td><input style="font-size: 12px;"
								name="staff.staff_birthday" class="form-control" type="text"></td>
							<td><label>最高学历</label></td>
							<td><input style="font-size: 12px;"
								name="staff.staff_MaxEducationalBackground" class="form-control"
								type="text"></td>
							<td><label>政治面貌</label></td>
							<td><input name="staff.staff_politicalStatus"
								class="form-control" type="text"></td>

						</tr>
						<tr>
							<td><label>入党时间</label></td>
							<td><input name="staff.staff_joinPartyTime"
								class="form-control" type="text"></td>
							<td><label c>工作时间</label></td>
							<td><input name="staff.staff_joinWorkTime"
								class="form-control" type="text" placeholder="参加工作时间"></td>
							<td><label>性别</label></td>
							<td><label style="float: left;" class="fancy-radio">
									<input name="sex_content" onclick=changeSex_man(this)
									type="radio" value="男"> <span> <i></i>男
								</span>
							</label> <label style="float: left; margin-left: 10px;"
								class="fancy-radio"> <input name="sex_content"
									onclick=changeSex_woman(this) type="radio" value="女"> <span><i></i>女</span>
							</label> <input type="hidden" name="staff.staff_sex" id="sex"></td>
						</tr>
						<tr>
							<td><label>入警时间</label></td>
							<td><input name="staff.staff_thePoliceTime"
								class="form-control" type="text"></td>
							<td>到</td>
							<td><input name="staff.staff_thePoliceTime"
								class="form-control" type="text"></td>
							<td><label>是否正式</label></td>
							<td><label style="float: left;" class="fancy-radio">
									<input name="format_content" onclick=isFormat(this)
									type="radio" value="1"> <span><i></i>是</span>
							</label> <label style="float: left; margin-left: 10px;"
								class="fancy-radio"> <input name="format_content"
									onclick=isNotFormat(this) type="radio" value="2"> <span><i></i>否</span>
							</label> <input type="hidden" name="staff.staff_isItFormal" id="format" /></td>
						</tr>
						<tr>
							<td><label>籍贯</label></td>
							<td><input name="staff.staff_nativePlace"
								class="form-control" type="text"></td>
						</tr>
						<tr style="height: 30px"></tr>
						<tr>
							<td colspan="6" class="staff_info_title">联系方法</td>
						</tr>
						<tr style="height: 20px;"></tr>
						<tr>
							<td><label>手机号</label></td>
							<td><input name="staff.staff_phone" class="form-control"
								style="margin-top: 6px;" type="text"></td>
							<td><label>警务通号</label></td>
							<td><input name="staff.staff_throughThePolice"
								class="form-control" style="margin-top: 6px;"></td>
							<td><label>家庭电话</label></td>
							<td><input name="staff.staff_homephone" class="form-control"
								style="margin-top: 6px;"></td>
						</tr>
						<tr>
							<td><label>QQ号</label></td>
							<td><input name="staff.staff_QQ" class="form-control"
								style="margin-top: 6px;" type="text"></td>
							<td><label>微信</label></td>
							<td><input name="staff.staff_weixin" class="form-control"
								style="margin-top: 6px;"></td>
							<td><label>电子邮箱</label></td>
							<td><input name="staff.staff_outEmail" class="form-control"
								style="margin-top: 6px;" placeholder="外网电子邮箱"> <input
								name="staff.staff_inEmail" class="form-control"
								style="margin-top: 6px;" placeholder="内网电子邮箱"></td>

						</tr>
						<tr style="height: 30px"></tr>
						<tr>
							<td colspan="6" class="staff_info_title">家庭信息</td>
						</tr>
						<tr style="height: 20px;"></tr>
						<tr>
							<td><label>家庭住址</label></td>
							<td><input name="staff.staff_address" class="form-control"
								type="text"></td>
							<td><label class="staff_detail_label_long">姓名</label></td>
							<td><input name="staff.staff_contactsName"
								class="form-control" style="margin-top: 6px;" type="text"
								placeholder="家庭联系人姓名"></td>

						</tr>
						<tr>
							<td><label class="staff_detail_label_long">电话</label></td>
							<td><input name="staff.staff_contactsPhone" type="text"
								class="form-control" style="margin-top: 6px;"
								placeholder="家庭联系人电话"></td>
							<td><label class="staff_detail_label_long">关系</label></td>
							<td><input name="staff.staff_contactsRelationship"
								type="text" class="form-control" style="margin-top: 6px;"
								placeholder="与家庭联系人的关系"></td>
						</tr>

						<tr>
							<td><label class="staff_detail_label_long">微信号</label></td>
							<td><input name="staff.staff_contactsWeiXin"
								class="form-control" style="margin-top: 6px;" type="text"
								placeholder="家庭联系人微信号"></td>
							<td><label class="staff_detail_label_long">工作单位</label></td>
							<td><input name="staff.staff_contactsWorkSpace" type="text"
								class="form-control" style="margin-top: 6px;"
								placeholder="家庭联系人工作单位"></td>


						</tr>
						<tr>
							<td><label class="staff_detail_label_long">职位</label></td>
							<td><input name="staff.staff_contactsPosition" type="text"
								class="form-control" style="margin-top: 6px;"
								placeholder="家庭联系人职位"></td>
							<td><label>创建时间</label></td>
							<td><input name="staff.staff_gmt_create"
								class="form-control " id="star-time" style="margin-top: 6px;"
								type="text"></i></td>
							<td><label>修改时间</label></td>
							<td><input name="staff.staff_gmt_modified" type="text"
								class="form-control " style="margin-top: 6px;"></td>

						</tr>
						<tr style="height: 140px;">
							<td><label>备注</label></td>
							<td colspan="6"><textarea id="staff_contactsRemark"
									style="border: 1px solid #ccc; text-indent: 30px;"
									name="staff.staff_contactsRemark" rows="3" cols="130"></textarea>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<input type="hidden" id="staff_id"
		value="<s:property value="staff_id"/>">
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

	<script type="text/javascript"
		src="<%=basePath%>js/Team/staffDetails.js"></script>
	<script>
	$('#star-time').datetimepicker({
		language: 'zh-CN', //显示中文
		format: 'yyyy-mm-dd', //显示格式
		minView: "month", //设置只显示到月份
		initialDate: new Date(), //初始化当前日期
		autoclose: true, //选中自动关闭
		todayBtn: true //显示今日按钮
	})
	</script>
</body>
</html>