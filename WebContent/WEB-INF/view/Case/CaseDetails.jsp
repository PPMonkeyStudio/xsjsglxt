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
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">案件详情信息</h3>
			</div>
			<div class="panel-body">

				<table>
					<tr>
						<td>勘探编号</td>
						<td><input style="font-size: 12px;"
							name="sence.snece_inquestId" class="form-control" type="text"></td>
						<td style="padding-left:5px;">勘探系统编号</td>
						<td><input name="sence.snece_inquestSystemId"
							class="form-control" type="text"></td>
						<td>案件分类</td>
						<td><input name="Case.case_classify" class=" form-control">
					</tr>
					<tr>
						<td>接警时间</td>
						<td><input name="Case.case_receivingAlarmDate"
							class="form-control" style="margin-top: 6px;" type="text"></td>
						<td>危害程度</td>
						<td><input name="Case.case_extentOfInjury"
							class="form-control" style="margin-top: 6px;"></td>
						<td>是否立案</td>
						<td><label style="float: left;" class="fancy-radio">
								<input name="register" onclick="buildCase_chose(this)"
								type="radio" value="1"> <span><i></i>是</span>
						</label><label style="float: left; margin-left: 10px;" class="fancy-radio">
								<input name="register" onclick="buildCase_chose(this)"
								type="radio" value="2"> <span><i></i>否</span>
						</label> <input type="hidden" name="Csae.case_register"></td>
					</tr>
					<tr>
						<td>案发地点</td>
						<td colspan="3"><input name="Case.case_address"
							style="margin-top: 6px;" class="case_place form-control"
							type="text" value="萍乡市安源区"></td>

						<td rowspan="2">案件类别</td>
						<td rowspan="2"><input name="Case.case_totalCategory"
							name="case_class1" class="main_case form-control"> <input
							name="Case.case_sonCategory" style="margin-top: 6px;"
							class="other_case form-control"></td>
					</tr>
					<tr>
						<td>案发名称</td>
						<td colspan="3"><input name="Case.case_name"
							style="margin-top: 6px;" class="case_name form-control"
							type="text"></td>
					</tr>
				</table>
				<hr>
				<table>
					<tr>
						<td width="85">移动基站</td>
						<td><input name="sence.snece_mobileStation" placeholder="基站号"
							class="form-control" type="text"> <input
							name="sence.snece_mobileVillage" placeholder="小区号"
							style="margin-top: 6px;" class="form-control" type="text"></td>
						<td width="85">联通基站</td>
						<td><input name="sence.snece_unicomSwitchboard"
							placeholder="交换机" class="form-control" type="text"> <input
							name="sence.snece_unicomVillage" placeholder="小区号"
							style="margin-top: 6px;" class="form-control" type="text"></td>
						<td width="85">电信基站</td>
						<td><input name="sence.snece_telecomStation"
							placeholder="基站号" width="40%;" class="form-control" type="text"></td>
					</tr>
				</table>
				<hr>
				<table>
					<tr>
						<td style="height: 74;">报案人基本情况</td>
						<td colspan="5"><input style=" width: 24%;float:left; "
							name="Case.case_reporterName" class="form-control" type="text"
							placeholder="姓名"> <input
							style="width: 24%; float:left;margin-left: 6px;"
							name="Case.case_reporterSex" class="form-control" type="text"
							placeholder="年龄 "> <input
							style="width: 24%; float:left; margin-left: 6px;"
							name="Case.case_reporterJobUnit" class="form-control" type="text"
							placeholder="工作单位 "> <input
							style="width: 25%; margin-left: 6px; float: left;"
							name="Case.case_reporterPhone" class="form-control" type="text"
							placeholder="联系电话 "> <input
							style="margin-top: 6px;float: right;"
							name="Case.case_reporterAddress" class="form-control" type="text"
							placeholder="家庭住址 "></td>
					</tr>
					<tr>
						<td>简要案情</td>
						<td colspan="5"><textarea style="margin-top: 6px;"
								name="briefdetails.briefdetails_details" class="form-control"
								rows="4"></textarea></td>
					</tr>
					<tr>
						<td height="39px;">天气情况</td>
						<td><input name="sence.snece_weather"
							style="width:74px; float:left; margin-top: 6px;"
							class=" form-control" id="weather" name="weather">
							<p style="float:left; margin-top: 6px;">温度</p> <input
							name="sence.snece_weatherTemperature"
							style="width: 50px; float:left; margin-top: 6px;"
							class="form-control" type="text">°C</td>
						<td width="85">作案时段</td>
						<td><input name="Case.case_makeTime" class=" form-control">
						</td>
						<td>发案辖区</td>
						<td><input name="Case.case_jurisdiction"
							class=" form-control"></td>
					</tr>

					<tr style="margin-top: -6px;">
						<td height="78px;">作案手段</td>
						<td><input name="Case.case_makeMeans"
							class=" crime_means form-control"></td>
						<td>选择处所</td>
						<td><input name="Case.case_residence"
							onchange="setSectionmAddress(this.inputedIndex)"
							class=" widel_space form-control"> <input
							name="Case.case_concreteResidence" style="margin-top: 6px;"
							class=" specific_space form-control"></td>
						<td width="85">进出口</td>
						<td><input name="Case.case_exit" class=" form-control">
						</td>
					</tr>
					<tr>
						<!-- <td>物证编号</td>
							<td><input
								name="sneceInformation.snece_information_physicalEvidenceId"
								style="margin-top: 4px;" class="form-control" type="text"></td>
							<td>照片编号</td>
							<td><input name="" style="margin-top: 6px;"
								class="form-control" type="text"></td>
							<td>损失物品</td>
							<td><input
								name="sneceInformation.snece_information_lossArticle"
								class=" form-control" style="margin-top: 6px;">
									<option value="" inputed></option>
									<option value="各类财物">各类财物</option>
									<option value="现金">现金</option>
									<option value="手机">手机</option>
									<option value="首饰">首饰</option>
									<option value="电脑">电脑</option>
									<option value="电缆">电缆</option>
									<option value="工业原材料">工业原材料</option>
									<option value="变压器">变压器</option>
									<option value="男性">男性</option>
									<option value="女性">女性</option>
									<option value="其他">其他</option>
									<option value="无">无</option>
							</input></td> -->
					</tr>
				</table>
				<hr>
				<table>
					<tr>
						<td>作案过程</td>
						<td colspan="5"><textarea name="Case.case_process"
								class="form-control" rows="4"></textarea></td>
					</tr>
					<tr>
						<td colspan="6"><label style="margin-left: 30%;"
							class="fancy-checkbox"><input
								onclick="sence_checkbox(this)" name="sence.snece_photographed"
								type="checkbox"> <span>已拍照</span> </label> <label
							class="fancy-checkbox"><input
								onclick="sence_checkbox(this)" name="sence.snece_entered"
								type="checkbox"> <span>已录入</span> </label> <label
							class="fancy-checkbox"><input
								onclick="sence_checkbox(this)" name="sence.snece_areadymade"
								type="checkbox"> <span>已制作</span> </label> <label
							class="fancy-checkbox"><input
								onclick="sence_checkbox(this)" name="sence.snece_parsed"
								type="checkbox"> <span>已分析</span> </label> <label
							class="fancy-checkbox"><input
								onclick="sence_checkbox(this)" name="sence.snece_archived"
								type="checkbox"> <span>已存档</span> </label> <label
							class="fancy-checkbox"> <input
								onclick="sence_checkbox(this)" name="sence.snece_identified"
								type="checkbox"> <span>已认定</span>
						</label></td>
					</tr>
					<tr>
						<td>勘验人员</td>
						<td colspan="5"><input name="sence.snece_inquestPerson"
							id="exploration_personnel"
							class="inputpicker show-tick form-control dropup" multiple
							data-live-search="true" data-dropup-auto="false" title="请选择">
						</td>
					</tr>
					<tr>
						<td>填表人员</td>
						<td><input name="sence.snece_fillPerson"
							style="margin-top: 6px;" class="form-control" type="text"></td>
						<td>填表单位</td>
						<td><input name="sence.snece_fillUnit"
							style="margin-top: 6px;" class="form-control" type="text"></td>
						<td>填表时间</td>
						<td><input name="sence.snece_fillTime"
							style="margin-top: 6px;" class="form_time form-control"
							type="text"></td>
					</tr>
				</table>


			</div>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
</body>
<script>
	
</script>
</html>