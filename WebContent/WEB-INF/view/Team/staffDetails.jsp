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
				<h3 class="panel-title">人员详情</h3>
			</div>
			<button onclick="javascript:history.go(-1)" type="button"
				class="btn btn-default button button_return ">
				<i class="fa fa-reply"></i> 返回列表
			</button>
			<button type="button" class="btn btn-default button button_change"
				onclick="staff_relive()">
				<i class="fa fa-pencil"></i> 修改人员
			</button>
			<div class="panel-body staff_body">
				<form id="staffDetails" enctype="multipart/form-data"
					accept-charset="utf-8">
					<table style="width:90%;margin-left: 30px;">
						<tr>
							<td colspan="6" class="staff_info_title">基本信息</td>
						</tr>
						<tr style="height: 20px"></tr>
						<tr>
							<td><label>姓名</label></td>
							<td><input name="policeman.xsjsglxt_name"
								class="form-control" type="text"></td>

							<td><label>警号</label></td>
							<td><input name="policeman.staff_alarm" class="form-control"
								type="text"></td>

							<td><label>照片</label></td>
							<td rowspan="4"><a class="photo-show" id="photo-show"></a> <a
								class="a-upload" onclick="relivePhoto_click()">修改照片</a> <input
								type="file" class="photo-file" name="staff_image"
								multiple="multiple"
								accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" />

							</td>
						</tr>
						<tr>
							<td><label>身份证号</label></td>
							<td><input name="policeman.staff_idNumber"
								class="form-control" type="text" value=""  onblur="getAge()"></td>

							<td><label>年龄</label></td>
							<td><input style="font-size: 12px;"
								name="policeman.xsjsglxt_age" class="form-control" type="text"></td>
						</tr>
						<tr>

							<td><label>民族</label></td>
							<td><input name="policeman.xsjsglxt_nation"
								class="form-control" type="text"></td>
							<td><label>籍贯</label></td>
							<td><input name="policeman.xsjsglxt_nativePlace"
								class="form-control" type="text"></td>

						</tr>

						<tr>

							<td><label>最高学历</label></td>
							<td><select class="form-control"
								id="staff_MaxEducationalBackground"
								name="policeman.staff_MaxEducationalBackground">
									<option></option>
									<option>小学</option>
									<option>初中</option>
									<option>高中</option>
									<option>大学</option>
									<option>硕士</option>
									<option>博士</option>
							</select></td>
							<td><label>政治面貌</label></td>
							<td><select class="form-control" id="staff_politicalStatus"
								name="policeman.staff_politicalStatus">
									<option></option>
									<option>群众</option>
									<option>入党积极分子</option>
									<option>预备党员</option>
									<option>党员</option>
							</select></td>

						</tr>
						<tr>
							<td><label>入党时间</label></td>
							<td><input name="policeman.staff_joinPartyTime"
								class="form-control staff_joinPartyTime" type="text"></td>
							<td><label>工作时间</label></td>
							<td><input name="policeman.staff_joinWorkTime"
								class="form-control staff_joinWorkTime" type="text"
								placeholder="参加工作时间"></td>
							<td><label>性别</label></td>
							<td><label style="float: left; width: 50px;"
								class="fancy-radio person_radio"> <input
									name="sex_content" onclick=changeSex_man(this) type="radio"
									value="男"> <span> <i></i>男
								</span>
							</label> <label style="float: left; width: 50px; margin-left: 10px;"
								class="fancy-radio "> <input name="sex_content"
									onclick=changeSex_woman(this) type="radio" value="女"> <span><i></i>女</span>
							</label> <input type="hidden" name="policeman.xsjsglxt_sex" id="sex"></td>

						</tr>
						<tr>
							<td><label>入警时间</label></td>
							<td><input name="policeman.staff_thePoliceTime"
								class="form-control staff_thePoliceTime" type="text"></td>
							<td><label>生日</label></td>
							<td><input name="policeman.staff_birthday"
								class="form-control staff_birthday" type="text"></td>
							<td><label>是否正式</label></td>
							<td><label style="float: left; width: 50px;"
								class="fancy-radio "> <input name="format_content"
									onclick="isFormat(this)" type="radio" value="是"> <span><i></i>是</span>
							</label> <label style="float: left; margin-left: 10px; width: 50px;"
								class="fancy-radio "> <input name="format_content"
									onclick="isNotFormat(this)" type="radio" value="否"> <span><i></i>否</span>
							</label> <input type="hidden" name="policeman.staff_isItFormal"
								id="format" /></td>

						</tr>
						<tr>
							<td><label>职务</label></td>
							<td><select id="staff_duty" class="form-control"
								name="policeman.staff_duty">
									<option>大队长</option>
									<option>教导员</option>
									<option>副大队长</option>
									<option>副教导员</option>
									<option>中队长</option>
									<option>副中队长</option>
									<option>民警</option>
									<option>法医</option>
									<option>辅警</option>
									
							</select></td>
							<td><label>警种</label></td>
							<td><select id="staff_type" class="form-control"
								name="policeman.staff_type">
									<option>民警</option>
									<option>辅警</option>
									<option>文职</option>
							</select></td>
							<td><label>地址</label></td>
							<td><input name="policeman.staff_address"
								class="form-control" type="text"></td>
						</tr>
						
						<tr style="height: 30px"></tr>
						<tr>
							<td colspan="6" class="staff_info_title">联系方法</td>
						</tr>
						<tr style="height: 20px;"></tr>
						<tr>
							<td><label>手机号</label></td>
							<td><input name="policeman.staff_phone" class="form-control"
								style="margin-top: 6px;" type="text"></td>
							<td><label>警务通号</label></td>
							<td><input name="policeman.staff_throughThePolice"
								class="form-control" style="margin-top: 6px;"></td>
							<td><label>家庭电话</label></td>
							<td><input name="policeman.staff_homephone"
								class="form-control" style="margin-top: 6px;"></td>
						</tr>
						<tr>
							<td><label>QQ号</label></td>
							<td><input name="policeman.staff_QQ" class="form-control"
								style="margin-top: 6px;" type="text"></td>
							<td><label>微&nbsp;&nbsp;信&nbsp;&nbsp;号</label></td>
							<td><input name="policeman.staff_weixin"
								class="form-control" style="margin-top: 6px;"></td>
							<td><label>电子邮箱</label></td>
							<td><input name="policeman.staff_outEmail"
								class="form-control" style="margin-top: 6px;"
								placeholder="外网电子邮箱"> <input
								name="policeman.staff_inEmail" class="form-control"
								style="margin-top: 6px;" placeholder="内网电子邮箱"></td>

						</tr>

					</table>
				</form>
				<div class="longBoxs">
					<div class="long_tableBox">
						<span class="staff_info_title">学习经历</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal" data-target="#addStudy_Modal"
							onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>

						<form id="study_exp">
							<div class="long_tb">
								<table>
									<tbody>
										<tr class="long_table">
											<th>学习地点</th>
											<th>起始时间</th>
											<th>结束时间</th>
											<th>备注</th>
											<th>操作</th>
										</tr>

									</tbody>
								</table>
								<table id="studyExperience_table">
									<tbody>
									</tbody>
								</table>
								
							</div>
						</form>
					</div>
					<div style="background: #e7e6e6;width:1000px;height: 1px;"></div>
					<div class="long_tableBox">
						<span class="staff_info_title">工作经历</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal" data-target="#addWork_Modal"
							onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>
						<form id="work_exp">
							<div class="long_tb">
								<table>
									<tbody>
										<tr class="long_table">
											<th>工作地点</th>
											<th>职务</th>
											<th>起始时间</th>
											<th>结束时间</th>
											<th>备注</th>
											<th>操作</th>
										</tr>
									</tbody>
								</table>
								<table id="wordExperience_table">
									<tbody>
										
									</tbody>
								</table>
							</div>
						</form>
					</div>
					<div style="background: #e7e6e6;width:1000px;height: 1px;"></div>
					<div class="long_tableBox">
						<span class="staff_info_title">家庭情况</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal" data-target="#addFamily_Modal"
							onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>
						<div class="long_tb">
							<table style="width: 150%;">

								<tbody>
									<tr class="long_table">
										<th>关系</th>
										<th>姓名</th>
										<th>身份证号</th>
										<th>生日</th>
										<th>手机号</th>
										<th>微信号</th>
										<th>工作单位</th>
										<th>职位</th>
					 					<th>备注</th>
										<th>操作</th>
									</tr>
								</tbody>

							</table>
							<table id="family_table" style="width: 150%;">

								<tbody>
									
								</tbody>

							</table>
						</div>
					</div>
                    <div style="background: #e7e6e6;width:1000px;height: 1px;"></div>
					<div class="long_tableBox">
						<span class="staff_info_title">刑警大队调动情况</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal"
							data-target="#addPoliceChange_Modal" onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>
						<form id="police_move">
							<div class="long_tb">
								<table>
									<tbody>
										<tr class="long_table">
											<th>调入时间</th>
											<th>调出时间</th>
											<th>是否在岗</th>
											<th>备注</th>
											<th>操作</th>
										</tr>
									</tbody>
								</table>
								<table id="policeChange_table">
									<tbody>
										
									</tbody>
								</table>
							</div>
						</form>
					</div>
					<div style="background: #e7e6e6;width:1000px;height: 1px;"></div>
					<div class="long_tableBox">
						<span class="staff_info_title">立功受奖情况</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal" data-target="#addPrized_Modal"
							onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>
						<form id="staffReward">
							<div class="long_tb">
								<table>
									<tbody>
										<tr class="long_table">
											<th>表彰情况</th>
											<th>表彰时间</th>
											<th>备注</th>
											<th>操作</th>
										</tr>
									</tbody>
								</table>
								<table id="prized_table">
									<tbody>
										
									</tbody>
								</table>
							</div>
						</form>
					</div>
					<div style="background: #e7e6e6;width:1000px;height: 1px;"></div>
					<div class="long_tableBox">
						<span class="staff_info_title">违纪情况</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal"
							data-target="#addAgainstPrinciple_Modal" onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>
						<form id="againstPrinciple">
							<div class="long_tb">
								<table>
									<tbody>
										<tr class="long_table">
											<th>违纪情况</th>
											<th>违纪时间</th>
											<th>备注</th>
											<th>操作</th>
										</tr>
									</tbody>
									<table id="againstPrinciple_table">
									<tbody>
										
									</tbody>
									</table>
								</table>
							</div>
						</form>
					</div>
					<div style="background: #e7e6e6;width:1000px;height: 1px;"></div>
					<div class="long_tableBox">
						<span class="staff_info_title">处分情况</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal" data-target="#addPunish_Modal"
							onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>
						<form id="Punishment">
							<div class="long_tb">
								<table >
									<tbody>
										<tr class="long_table">
											<th>处分情况</th>
											<th>处分时间</th>
											<th>备注</th>
											<th>操作</th>
										</tr>
									</tbody>
								</table>
								<table id="punish_table">
									<tbody>
										 
									</tbody>
								</table>
							</div>
						</form>
					</div>
					<div style="background: #e7e6e6;width:1000px;height: 1px;"></div>
					<div class="long_tableBox">
						<span class="staff_info_title">休假情况</span>
						<button style="margin-left: 10px;" class="btn btn-default btn-xs"
							type="button" data-toggle="modal"
							data-target="#addVocation_Modal" onclick="">
							<i class="fa fa-plus-square"></i> 添加
						</button>
						<form id="Furlough">
							<div class="long_tb">
								<table >
									<tbody>
										<tr class="long_table">
											<th>休假事由</th>
											<th>起始时间时间</th>
											<th>天数</th>
											<th>是否销假</th>
											<th>销假时间</th>
											<th>备注</th>
											<th>操作</th>
										</tr>
									</tbody>
								</table>
								<table id="vocation_table">
									<tbody>
										 
									</tbody>
								</table>
							</div>
						</form>
					</div>
				</div>
				<button style="float: right; margin-right: 9%; margin-top: 30px;"
					type="button" class="btn btn-default button"
					onclick="staff_relive()">
					<i class="fa fa-pencil"></i> 修改人员
				</button>
			</div>

		</div>
	</div>
	<!--添加添加学习经历模态框 start  -->
	<div class="modal fade" id="addStudy_Modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加学习经历</h4>
				</div>
				<div class="modal-body">

					<form action="" id="studyExp_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">学习地点</label></td>
									<td><input style="font-size: 12px;"
										class="staffStudent_address" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">起始时间</label></td>
									<td><input style="font-size: 12px;"
										class=" staffStudent_startTime"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">结束时间</label></td>
									<td><input type="text" class="staffStudent_stopTime" /></td>
								</tr>

								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staffStudent_remarks"
											class="staffStudent_remarks"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_oneStudy()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>
	<!--添加添加学习经历模态框 end  -->

	<!--添加添加工作经历模态框 start  -->
	<div class="modal fade" id="addWork_Modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加工作经历</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addWork_form" accept-charset="utf-8">
						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">工作地点</label></td>
									<td><input style="font-size: 12px;"
										class="staffWork_address" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">职务</label></td>
									<td><input style="font-size: 12px;" class="staffWork_duty"
										type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">起始时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffWork_startTime"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">结束时间</label></td>
									<td><input type="text" class="staffWork_stopTime" /></td>
								</tr>

								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffWork_remarks"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_oneWork()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加添加工作经历模态框 end  -->
	<!--添加添加家庭情况模态框 start  -->
	<div class="modal fade" id="addFamily_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加家庭情况</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addFamily_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">关系</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_contactsRelationship" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">姓名</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_name" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">身份证号</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_IDcard" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">生日</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_birthday" class=" study_startTime"
										type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">手机号</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_tel" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">微信号</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_WeiXin" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">工作单位</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_workSpace" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">职位</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_duty" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											class="staffFamily_remarks" rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_oneFamily()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加添加家庭情况模态框 end  -->
	<!--添加添加刑警大队调动模态框 start  -->
	<div class="modal fade" id="addPoliceChange_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加刑警大队调动</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addPoliceChange_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">调入时间</label></td>
									<td><input style="font-size: 12px;"
										class=" staffMove_inTime" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">调出时间</label></td>
									<td><input style="font-size: 12px;"
										class=" staffMove_outTime" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">是否在岗</label></td>
									<td><select class="staffMove_guard">
											<option>是</option>
											<option>否</option>
									</select></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffMove_remarks"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_oneMove()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加添加刑警大队调动模态框 end  -->
	<!--添加添加立功受奖模态框 start  -->
	<div class="modal fade" id="addPrized_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加立功受奖</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addPrized_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">表彰情况</label></td>
									<td><input style="font-size: 12px;"
										class="staffReward_situation" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">表彰时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffReward_Time"></td>
								</tr>

								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffReward_remarks"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_oneReward()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加添加立功受奖模态框 end  -->
	<!--添加添加违纪模态框 start  -->
	<div class="modal fade" id="addAgainstPrinciple_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加违纪</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addAgainstPrinciple_form"
						accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">违纪情况</label></td>
									<td><input style="font-size: 12px;"
										class="staffPrinciple_situation" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">违纪时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffPrinciple_Time"></td>
								</tr>

								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffPrinciple_remarks"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_oneAgainst()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加添加违纪模态框 end  -->
	<!--添加添加处分模态框 start  -->
	<div class="modal fade" id="addPunish_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加处分</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addPunish_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">处分情况</label></td>
									<td><input style="font-size: 12px;"
										class="staffPunishment_situation" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">处分时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffPunishment_Time"></td>
								</tr>


								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffPunishment_remarks"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_onePunishment()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加添加处分模态框 end  -->
	<!--添加添加休假模态框 start  -->
	<div class="modal fade" id="addVocation_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加休假</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addVocation_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">休假事由</label></td>
									<td><input style="font-size: 12px;"
										class="staffFurlough_mainContent" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">起始时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffFurlough_startTime"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">天数</label></td>
									<td><input type="text" class="staffFurlough_days" /></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">是否销假</label></td>
									<td><select class="staffFurlough_whetherStop">
											<option>是</option>
											<option>否</option>
									</select></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">销假时间</label></td>
									<td><input type="text" class="staffFurlough_stopTime" /></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffFurlough_remarks"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="add_oneFurlough()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加添加休假模态框 end  -->
	<!--修改学习经历模态框 start  -->
	<div class="modal fade" id="reliveStudy_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改学习经历</h4>
				</div>
				<div class="modal-body">

					<form action="" id="studyExp_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">学习地点</label></td>
									<td><input style="font-size: 12px;"
										class="staffStudent_addressRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">起始时间</label></td>
									<td><input style="font-size: 12px;"
										class=" staffStudent_startTimeRelive"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">结束时间</label></td>
									<td><input type="text" class="staffStudent_stopTimeRelive" /></td>
								</tr>

								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staffStudent_remarks"
											class="staffStudent_remarksRelive"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_study()" data-dismiss='modal'>修改</button>
				</div>
			</div>
		</div>
	</div>
	<!--修改学习经历模态框 end  -->

	<!--修改工作经历模态框 start  -->
	<div class="modal fade" id="reliveWork_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改工作经历</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addWork_form" accept-charset="utf-8">
						<table>
							<tbody>
								<tr>
									<td><label>工作地点</label></td>
									<td><input style="font-size: 12px;"
										class="staffWork_addressRelive" type="text"></td>
								</tr>
								<tr>
									<td><label>职务</label></td>
									<td><input style="font-size: 12px;"
										class="staffWork_dutyRelive" type="text"></td>
								</tr>
								<tr>
									<td><label>起始时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffWork_startTimeRelive"></td>
								</tr>
								<tr>
									<td><label>结束时间</label></td>
									<td><input type="text" class="staffWork_stopTimeRelive" /></td>
								</tr>

								<tr>
									<td><label>备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffWork_remarkRelives"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_work()" data-dismiss='modal'>修改</button>
				</div>
			</div>
		</div>
	</div>

	<!--修改工作经历模态框 end  -->
	<!--修改家庭情况模态框 start  -->
	<div class="modal fade" id="reliveFamily_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改家庭情况</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addFamily_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">关系</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_contactsRelationshipRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">姓名</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_nameRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">身份证号</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_IDcardRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">生日</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_birthdayRelive" class=" study_startTime"
										type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">手机号</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_telRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">微信号</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_WeiXinRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">工作单位</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_workSpaceRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">职位</label></td>
									<td><input style="font-size: 12px;"
										class="staffFamily_dutyRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											class="staffFamily_remarksRelive" rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_family()" data-dismiss='modal'>修改</button>
				</div>
			</div>
		</div>
	</div>

	<!--修改家庭情况模态框 end  -->
	<!--修改刑警大队调动模态框 start  -->
	<div class="modal fade" id="reliveMove_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改刑警大队调动</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addPoliceChange_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">调入时间</label></td>
									<td><input style="font-size: 12px;"
										class=" staffMove_inTimeRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">调出时间</label></td>
									<td><input style="font-size: 12px;"
										class=" staffMove_outTimeRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">是否在岗</label></td>
									<td><select class="staffMove_guardRelive">
											<option>是</option>
											<option>否</option>
									</select></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffMove_remarksRelive"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_move()" data-dismiss='modal'>修改</button>
				</div>
			</div>
		</div>
	</div>

	<!--修改刑警大队调动模态框 end  -->
	<!--修改立功受奖模态框 start  -->
	<div class="modal fade" id="reliveReward_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改立功受奖</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addPrized_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">表彰情况</label></td>
									<td><input style="font-size: 12px;"
										class="staffReward_situationRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">表彰时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffReward_TimeRelive"></td>
								</tr>

								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffReward_remarksRelive"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_reward()" data-dismiss='modal'>修改</button>
				</div>
			</div>
		</div>
	</div>

	<!--修改立功受奖模态框 end  -->
	<!--修改违纪模态框 start  -->
	<div class="modal fade" id="reliveAgainst_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改违纪</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addAgainstPrinciple_form"
						accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">违纪情况</label></td>
									<td><input style="font-size: 12px;"
										class="staffPrinciple_situationRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">违纪时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffPrinciple_TimeRelive"></td>
								</tr>

								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffPrinciple_remarksRelive"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_against()" data-dismiss='modal'>修改</button>
				</div>
			</div>
		</div>
	</div>

	<!--修改违纪模态框 end  -->
	<!--修改处分模态框 start  -->
	<div class="modal fade" id="relivePunishment_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改处分</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addPunish_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">处分情况</label></td>
									<td><input style="font-size: 12px;"
										class="staffPunishment_situationRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">处分时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffPunishment_TimeRelive"></td>
								</tr>


								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffPunishment_remarksRelive"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_punishment()" data-dismiss='modal'>修改</button>
				</div>
			</div>
		</div>
	</div>

	<!--修改处分模态框 end  -->
	<!--修改休假模态框 start  -->
	<div class="modal fade" id="reliveFurlough_Modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加休假</h4>
				</div>
				<div class="modal-body">

					<form action="" id="addVocation_form" accept-charset="utf-8">

						<table>
							<tbody>
								<tr>
									<td><label class="staff_info_label">休假事由</label></td>
									<td><input style="font-size: 12px;"
										class="staffFurlough_mainContentRelive" type="text"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">起始时间</label></td>
									<td><input style="font-size: 12px;"
										class="staffFurlough_startTimeRelive"></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">天数</label></td>
									<td><input type="text" class="staffFurlough_daysRelive" /></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">是否销假</label></td>
									<td><select class="staffFurlough_whetherStopRelive">
											<option>是</option>
											<option>否</option>
									</select></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">销假时间</label></td>
									<td><input type="text"
										class="staffFurlough_stopTimeRelive" /></td>
								</tr>
								<tr>
									<td><label class="staff_info_label">备注</label></td>
									<td colspan="6"><textarea id="staff_contactsRemark"
											class="staffFurlough_remarksRelive"
											style="border: 1px solid #ccc; text-indent: 30px; margin-top: 10px;"
											rows="3" cols="62"></textarea></td>


								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default "
						onclick="clear_iquery()" data-dismiss="modal">清空</button>
					<button type="button" class="btn btn-primary"
						onclick="relive_furlough()" data-dismiss='modal'>添加</button>
				</div>
			</div>
		</div>
	</div>

	<!--修改休假模态框 end  -->
	<script type="text/javascript"
		src="<%=basePath%>js/Team/staffDetails.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/Team/newStaff.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Team/addOne_longTable.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Team/relive_longTable.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Team/delete_longTable.js"></script>
	<script type="text/javascript">
		$.datetimepicker.setLocale('ch');
		$('.staff_joinPartyTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期

			maxDate : '2100/01/01', // 设置最大日期

		});
		$('.staff_joinWorkTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staff_thePoliceTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staff_birthday').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffStudent_startTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffStudent_stopTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffFamily_birthday').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffWork_startTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffWork_stopTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffMove_inTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1990/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffMove_outTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffReward_Time').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffPrinciple_Time').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1990/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffPunishment_Time').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffFurlough_startTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
		$('.staffFurlough_stopTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : true, // 关闭时间选项
			format : 'Y-m-d ', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
	</script>

</body>
</html>