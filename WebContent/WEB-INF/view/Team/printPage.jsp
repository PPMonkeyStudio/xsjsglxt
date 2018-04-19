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
<title>人员详情打印</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<!--------------------------------------------------------------------------------->
<script src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script src="<%=basePath%>js/bootstrap-select.js"></script>
<!--------------------------------------------------------------------------------->

<link rel="stylesheet" href="<%=basePath%>css/table.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery-confirm.css" />
<script src="<%=basePath%>js/jquery-confirm.js"></script>
<!--------------------------------------------------------------------------------->
<script src="<%=basePath%>js/jquery.bootstrap.wizard.js"></script>
<script src="<%=basePath%>js/vue.js"></script>
<script src="<%=basePath%>js/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>js/klorofil-common.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="<%=basePath%>js/jquery.datetimepicker.full.js"></script>
<!--------------------------------------------------------------------------------->
<script type="text/javascript"
	src="<%=basePath%>js/User/Input_Select.js"></script>
<!--------------------------------------------------------------------------------->
<script type="text/javascript"
	src="<%=basePath%>js/User/updatePasswd.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/Team/detail.css">
<style>
table{
    border:1px solid black;
}
table tr th{
    height: 35px;
    border:1px solid black;
}
table tr td{

    border:1px solid black;
}
.long_tableBox{
    margin:50px 0px;
     }
</style>
</head>
<body style="background-color:white;">
	
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div
		style="width: 100%; overflow: hidden;">
		<div class="panel"
			style="width: 1200px; margin: 20px auto; overflow: inherit; position: relative;">
			<div class="panel-body staff_body">
				<div style=" margin: 0 auto;">
					<form id="staffDetails" enctype="multipart/form-data"
						accept-charset="utf-8">
						<table style="width: 100%;">
							<tr>
								<td colspan="6" style="text-align: center;">基本信息</td>
							</tr>
							<tr>
								<td class="odd"><label class="staff_info_label">姓名</label></td>
								<td class="even">{{ returnData.xsjsglxt_name }}</td>

								<td class="odd"><label class="staff_info_label">警号</label></td>
								<td class="even">{{ returnData.staff_alarm }}</td>

								<td class="odd" rowspan="4" style="border-right: 0px"><a class="photo-show"
									id="photo-show"></a></td>
								<td class="even" rowspan="4" style="border-left: 0px"></td>
							</tr>
							<tr>
								<td class="odd"><label class="staff_info_label">身份证号</label></td>
								<td class="even">{{ returnData.staff_idNumber }}</td>

								<td class="odd"><label class="staff_info_label">年龄</label></td>
								<td class="even">{{ returnData.xsjsglxt_age }}</td>


							</tr>
							<tr>

								<td class="odd"><label class="staff_info_label">民族</label></td>
								<td class="even">{{ returnData.xsjsglxt_nation }}</td>
								<td class="odd"><label class="staff_info_label">籍贯</label></td>
								<td class="even">{{ returnData.xsjsglxt_nativePlace }}</td>

							</tr>

							<tr>

								<td class="odd"><label class="staff_info_label">最高学历</label></td>
								<td class="even">{{
									returnData.staff_MaxEducationalBackground }}</td>
								<td class="odd"><label class="staff_info_label">学位</label></td>
								<td class="even">{{ returnData.staff_degree }}</td>


							</tr>
							<tr>

								<td class="odd"><label class="staff_info_label">工作时间</label></td>
								<td class="even">{{ returnData.staff_joinWorkTime }}</td>
								<td class="odd"><label class="staff_info_label">生日</label></td>
								<td class="even">{{ returnData.staff_birthday }}</td>
								<td class="odd"><label class="staff_info_label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label></td>
								<td class="even">{{ returnData.xsjsglxt_sex }}</td>

							</tr>
							<tr>
								<td class="odd"><label class="staff_info_label">职务</label></td>
								<td class="even">{{ returnData.staff_duty }}</td>

								<td class="odd"><label class="staff_info_label">入警时间</label></td>
								<td class="even">{{ returnData.staff_thePoliceTime }}</td>

								<td class="odd"><label class="staff_info_label">是否&nbsp;&nbsp;正式</label></td>
								<td class="even">{{ returnData.staff_isItFormal }}</td>

							</tr>
							<tr>
								<td class="odd"><label class="staff_info_label">政治面貌</label></td>
								<td class="even">{{ returnData.staff_politicalStatus }}</td>
								<template v-if="returnData.staff_politicalStatus === '党员'">
								<td class="odd" class="staff_joinPartyTime_label"><label
									class="staff_info_label">入党时间</label></td>
								<td class="even" class="staff_joinPartyTime">{{
									returnData.staff_joinPartyTime }}</td>
								</template>
								<template v-if="returnData.staff_politicalStatus === '入党积极分子'">
								<td class="odd" class="staff_appliactionFormTime_label"><label
									class="staff_info_label">提交申请书</label></td>
								<td class="even" class="staff_appliactionFormTime ">{{
									returnData.staff_appliactionFormTime }}</td>

								<td class="odd" class="staff_delevopObjectTime_label"><label
									class="staff_info_label">发展对象</label></td>
								<td class="even" class="staff_delevopObjectTime">{{
									returnData.staff_delevopObjectTime }}</td>
								</template>
								<template v-if="returnData.staff_politicalStatus === '预备党员'">
								<td class="odd" class="staff_appliactionFormTime_label"><label
									class="staff_info_label">提交申请书</label></td>
								<td>{{ returnData.staff_appliactionFormTime }}</td>


								<td class="odd" class="staff_delevopObjectTime_label"><label
									class="staff_info_label">预备时间</label></td>
								<td class="even" class="staff_delevopObjectTime">{{
									returnData.staff_delevopObjectTime }}</td>
								</template>
							</tr>

							<tr style="height: 50px"></tr>
							<tr>
								<td colspan="6" style="text-align: center;">联系方法</td>
							</tr>
							<tr>
								<td class="odd"><label class="staff_info_label">手机号</label></td>
								<td class="even">{{ returnData.staff_phone }}</td>
								<td class="odd"><label class="staff_info_label">警务通号</label></td>
								<td class="even">{{ returnData.staff_throughThePolice }}</td>
								<td class="odd"><label class="staff_info_label">家庭电话</label></td>
								<td class="even">{{ returnData.staff_homephone }}</td>
							</tr>
							<tr>
								<td class="odd"><label class="staff_info_label">QQ号</label></td>
								<td class="even">{{ returnData.staff_QQ }}</td>
								<td class="odd"><label class="staff_info_label">微&nbsp;&nbsp;信&nbsp;&nbsp;号</label></td>
								<td class="even">{{ returnData.staff_weixin }}</td>
								<td class="odd"><label class="staff_info_label">内网邮箱</label></td>
								<td class="even">{{ returnData.staff_inEmail }}</td>

							</tr>
							<tr>
								<td class="odd"><label class="staff_info_label">外网邮箱</label></td>
								<td class="even">{{ returnData.staff_outEmail }}</td>
								<td class="odd"><label>家庭地址</label></td>
								<td class="even" colspan="3">{{ returnData.staff_address }}</td>
							</tr>
						</table>
					</form>
				</div>
				<div class="longBoxs">
					<div class="long_tableBox" style="text-align: center">
						<span class="staff_info_title">学习/出差经历</span>

						<form id="study_exp">
							<div class="long_tb11">

								<table id="studyExperience_table">
									<tbody>
										<tr class="long_table">
											<th>学习/出差地点</th>
											<th>起始时间</th>
											<th>结束时间</th>
										

										</tr>
										
										<template v-for="study in studys">
										<tr>
											<td>{{ study.staffStudent_address }}</td>
											<td>{{ study.staffStudent_startTime }}</td>
											<td>{{ study.staffStudent_stopTime }}</td>
											
										</tr>
										</template>
									</tbody>
								</table>

							</div>
						</form>
					</div>
					 
					<div class="long_tableBox" style="text-align: center">
						<span class="staff_info_title">工作经历</span>

						<form id="work_exp">
							<div class="long_tb11">

								<table id="wordExperience_table">
									<tbody>
										<tr class="long_table">
											<th>工作地点</th>
											<th>职务</th>
											<th>起始时间</th>
											<th>结束时间</th>
											

										</tr>
										<template v-for="work in works">
										<tr>
											<td>{{ work.staffWork_address }}</td>
											<td>{{ work.staffWork_duty }}</td>
											<td>{{ work.staffWork_startTime }}</td>
											<td>{{ work.staffWork_stopTime }}</td>
											
										</tr>
										</template>
									</tbody>
								</table>
							</div>
						</form>
					</div>
					 
					<div class="long_tableBox" style="text-align:center;">
						<span class="staff_info_title">家庭情况</span>

						<div class="long_tb1">

							<table id="family_table" >

								<tbody>
									<tr class="long_table">
										<th>关系</th>
										<th>姓名</th>
										<th>身份证号</th>
										
										<th>手机号</th>
										<th>工作单位</th>
										<th>职位</th>
										

									</tr>
									<template v-for="family in familys">
									<tr>
										<td>{{ family.staffFamily_contactsRelationship }}</td>
										<td>{{ family.staffFamily_name  }}</td>
										<td>{{ family.staffFamily_IDcard }}</td>
										
										<td>{{ family.staffFamily_tel }}</td>
										
										<td>{{ family.staffFamily_workSpace }}</td>
										<td>{{ family.staffFamily_duty }}</td>
										
									</tr>
									</template>
								</tbody>

							</table>
						</div>
					</div>
					 
					<div class="long_tableBox" style="text-align: center">
						<span class="staff_info_title">刑警大队调动情况</span>

						<form id="police_move">
							<div class="long_tb1">

								<table id="policeChange_table">
									<tbody>
										<tr class="long_table">
											<th>调入时间</th>
											<th>调出时间</th>
											<th>是否在岗</th>
											

										</tr>
										<template v-for="move in moves">
									<tr>
										<td>{{ move.staffMove_inTime }}</td>
										<td>{{ move.staffMove_outTime  }}</td>
										<td>{{ move.staffMove_guard }}</td>
										
									</tr>
									</template>
									</tbody>
								</table>
							</div>
						</form>
					</div>
					 
					<div class="long_tableBox" style="text-align: center">
						<span class="staff_info_title">立功受奖情况</span>

						<form id="staffReward">
							<div class="long_tb1">

								<table id="prized_table">
									<tbody>
										<tr class="long_table">
											<th>表彰情况</th>
											<th>表彰时间</th>
											

										</tr>
											<template v-for="reward in rewards">
									<tr>
			
										<td>{{ reward.staffReward_situation  }}</td>
										<td>{{ reward.staffReward_Time }}</td>
										
									</tr>
									</template>
									</tbody>
								</table>
							</div>
						</form>
					</div>
					 
					<div class="long_tableBox" style="text-align: center">
						<span class="staff_info_title">违纪情况</span>

						<form id="againstPrinciple">
							<div class="long_tb1">

								<table id="againstPrinciple_table">
									<tbody>
										<tr class="long_table">
											<th>违纪情况</th>
											<th>违纪时间</th>
											

										</tr>
									<template v-for="punishment in punishments">
									<tr>
			
										<td>{{ punishment.staffPrinciple_situation  }}</td>
										<td>{{ punishment.staffPrinciple_Time }}</td>
										
									</tr>
									</template>
									</tbody>
								</table>
							</div>
						</form>
					</div>
					 
					<div class="long_tableBox" style="text-align: center">
						<span class="staff_info_title">休假情况</span>

						<form id="Furlough">
							<div class="long_tb1">
								<table id="vocation_table">
									<tbody>
										<tr class="long_table">
											<th>休假事由</th>
											<th>起始时间时间</th>
											<th>天数</th>
											<th>是否销假</th>
											<th>销假时间</th>
											</tr>
											<template v-for="furlough in furloughs">
									<tr>
			
										<td>{{ furlough.staffFurlough_mainContent  }}</td>
										<td>{{ furlough.staffFurlough_startTime }}</td>
										<td>{{ furlough.staffFurlough_days }}</td>
										<td>{{ furlough.staffFurlough_whetherStop  }}</td>
										<td>{{ furlough.staffFurlough_stopTime }}</td>
										
									</tr>
									</template>
									</tbody>
								</table>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/Team/staffDetails.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Team/addOne_longTable.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Team/relive_longTable.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/Team/delete_longTable.js"></script>
	<script type="text/javascript">
		$('.time').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日

			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
	</script>


</body>
</html>