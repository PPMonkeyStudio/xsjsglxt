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
<body>
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
				<h3 class="panel-title">新建人员</h3>
			</div>
			<button onclick="javascript:history.go(-1)" type="button"
				class="btn btn-default button button_return ">
				<i class="fa fa-reply"></i> 返回列表
			</button>
			<button type="button" class="btn btn-default button button_change"
				onclick="staff_change()">
				<i class="fa fa-pencil"></i> 新建人员
			</button>
			<div class="panel-body staff_body">
				<form id="staffDetails"  enctype="multipart/form-data"  accept-charset="utf-8">
					<table>
						<tr>
							<td colspan="6" class="staff_info_title">基本信息</td>
						</tr>
						<tr style="height: 20px"></tr>
						<tr>
							<td><label  >姓名</label></td>
							<td><input name="staff.staff_name" class="form-control"
								type="text"></td>

							<td><label  >警号</label></td>
							<td><input name="staff.staff_alarm"
								class="form-control" type="text"></td>

							<td><label>照片</label></td>
							<td rowspan="4">
							   <a class="photo-show"></a>
							   <a class="a-upload" onclick="photo_click()">上传照片</a>
							   <input type="file"  class="photo-file" name="staff_photo" multiple="multiple" accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" />
							         
							 </td>
						</tr>
						<tr>
							<td><label  >身份证号</label></td>
							<td><input name="staff.staff_idNumber"
								class="form-control" type="text"></td>
							
                             <td><label  >年龄</label></td>
							<td><input style="font-size: 12px;"
								name="staff.staff_age" class="form-control" type="text"></td>
                           

						</tr>
						<tr>
							
							<td><label  >民族</label></td>
							<td><input name="staff.staff_nation"
								class="form-control" type="text"></td>
							<td><label  >籍贯</label></td>
							<td><input name="staff.staff_nativePlace"
								class="form-control" type="text"></td>
                            
						</tr>

						<tr>
							
							<td><label  >最高学历</label></td>
							<td>
								<select class="form-control"  name="staff.staff_MaxEducationalBackground">
									<option></option>
									<option>小学</option>
									<option>初中</option>
									<option>高中</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
							</select></td>
							<td><label  >政治面貌</label></td>
							<td><select class="form-control"  name="staff.staff_politicalStatus">
									<option></option>
									<option>群众</option>
									<option>入党积极分子</option>
									<option>预备党员</option>
									<option>党员</option>
							</select></td>
                            
						</tr>
						<tr>
							<td><label>入党时间</label></td>
							<td><input  name="staff.staff_joinPartyTime"
								class="form-control staff_joinPartyTime" type="text"></td>
							<td><label>工作时间</label></td>
							<td><input 
								name="staff.staff_joinWorkTime" class="form-control staff_joinWorkTime"
								type="text" placeholder="参加工作时间"></td>
                              <td><label>性别</label></td>
							<td>
							  <label style="float: left;" class="fancy-radio">
									<input name="sex_content" onclick=changeSex_man(this) type="radio"
									value="男">
									 <span>
									 <i></i>男
									 </span>
							  </label>
							   <label style="float: left; margin-left: 10px;"
								class="fancy-radio"> <input name="sex_content" onclick=changeSex_woman(this)
									 type="radio" value="女">
									<span><i></i>女</span>
							   </label> 
							    <input type="hidden" name="staff.staff_sex" id="sex">
							 </td>

						</tr>
						<tr>
							<td><label  >入警时间</label></td>
							<td><input name="staff.staff_thePoliceTime"
								class="form-control staff_thePoliceTime" type="text"></td>
								<td><label  >生日</label></td>
							<td><input style="font-size: 12px;"
								name="staff.staff_birthday" class="form-control staff_birthday" type="text"></td>
							<td><label  >是否正式</label></td>
							<td><label style="float: left;" class="fancy-radio">
									<input name="format_content" onclick="isFormat(this)" type="radio"
									value="是"> <span><i></i>是</span>
							</label> <label style="float: left; margin-left: 10px;"
								class="fancy-radio"> <input name="format_content" onclick="isNotFormat(this)"
									 type="radio" value="否">
									<span><i></i>否</span>
							</label>
							<input type="hidden" name="staff.staff_isItFormal" id="format"/></td>
							
						</tr>
						<tr style="height: 30px"></tr>
						<tr>
							<td colspan="6" class="staff_info_title">联系方法</td>
						</tr>
						<tr style="height:20px;"></tr>
						<tr>
							<td><label  >手机号</label></td>
							<td><input name="staff.staff_phone" class="form-control"
								style="margin-top: 6px;" type="text"></td>
							<td><label  >警务通号</label></td>
							<td><input name="staff.staff_throughThePolice"
								class="form-control" style="margin-top: 6px;"></td>
							<td><label  >家庭电话</label></td>
							<td><input name="staff.staff_homephone"
								class="form-control" style="margin-top: 6px;"></td>
						</tr>
						<tr>
							<td><label  >QQ号</label></td>
							<td><input name="staff.staff_QQ" class="form-control"
								style="margin-top: 6px;" type="text"></td>
							<td><label>微信</label></td>
							<td ><input name="staff.staff_weixin"
								class="form-control" style="margin-top: 6px;"></td>
							<td ><label>电子邮箱</label></td>
							<td><input  name="staff.staff_outEmail"
								class="form-control" style="margin-top: 6px;" placeholder="外网电子邮箱">
								<input name="staff.staff_inEmail"
								class="form-control" style="margin-top: 6px;" placeholder="内网电子邮箱"></td>
							
						</tr>
						<tr style="height:30px"></tr>
						<tr>
							<td colspan="6" class="staff_info_title">家庭信息</td>
							
						</tr>
						<tr style="height:20px;"></tr>
						<tr>
						<td><label class="staff_detail_label_long">职位</label></td>
							<td><input name="staff.staff_contactsPosition" type="text"
								class="form-control" style="margin-top: 6px;" placeholder="家庭联系人职位"></td>
							
							<td><label class="staff_detail_label_long">姓名</label></td>
							<td><input name="staff.staff_contactsName"
								class="form-control" style="margin-top: 6px;" type="text" placeholder="家庭联系人姓名"></td>
                            <td><label class="staff_detail_label_long">电话</label></td>
							<td><input name="staff.staff_contactsPhone" type="text"
								class="form-control" style="margin-top: 6px;" placeholder="家庭联系人电话"></td>
						</tr>
						<tr>
							<td><label class="staff_detail_label_long">微信号</label></td>
							<td><input name="staff.staff_contactsWeiXin"
								class="form-control" style="margin-top: 6px;" type="text" placeholder="家庭联系人微信号"></td>
							<td><label class="staff_detail_label_long">关系</label></td>
							<td><input name="staff.staff_contactsRelationship" type="text"
								class="form-control" style="margin-top: 6px;" placeholder="与家庭联系人的关系"></td>
						<td><label class="staff_detail_label_long">工作单位</label></td>
							<td><input name="staff.staff_contactsWorkSpace" type="text"
								class="form-control" style="margin-top: 6px;" placeholder="家庭联系人工作单位"></td>
						</tr>

						<tr>
							<td><label  >家庭住址</label></td>
							<td colspan="5"><input name="staff.staff_address"
								class="form-control" type="text"  style="width: 957px"></td>
							
							

						</tr>
						<tr style="height:140px;" >
							<td><label >备注</label></td>
							<td colspan="6">
							   <textarea id="staff_contactsRemark" style="border:1px solid #ccc; text-indent:30px;" name="staff.staff_contactsRemark" rows="3" cols="130"></textarea>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

<script type="text/javascript"
	src="<%=basePath%>js/Team/newStaff.js"></script>
<script type="text/javascript">
	$.datetimepicker.setLocale('ch');
	$('.staff_joinPartyTime').datetimepicker({
		yearStart : 1990, // 设置最小年份
		yearEnd : 2050, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : false, // 关闭时间选项
		format : 'Y-m-d', // 格式化日期年-月-日
		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
	$('.staff_joinWorkTime').datetimepicker({
		yearStart : 1990, // 设置最小年份
		yearEnd : 2050, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : true, // 关闭时间选项
		format : 'Y-m-d H:i', // 格式化日期年-月-日
		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
	$('.staff_thePoliceTime').datetimepicker({
		yearStart : 1990, // 设置最小年份
		yearEnd : 2050, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : true, // 关闭时间选项
		format : 'Y-m-d H:i', // 格式化日期年-月-日
		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
	$('.staff_birthday').datetimepicker({
		yearStart : 1990, // 设置最小年份
		yearEnd : 2050, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : true, // 关闭时间选项
		format : 'Y-m-d H:i', // 格式化日期年-月-日
		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
</script>

</body>

</html>