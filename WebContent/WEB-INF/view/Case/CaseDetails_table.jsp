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
<title>案件详情信息</title>
<link rel="stylesheet" href="<%=basePath%>css/Case/table.css">
<link rel="stylesheet" href="<%=basePath%>css/Case/Case.css">
<script type="text/javascript"
	src="<%=basePath%>js/Case/caseDetails_table.js"></script>
<style type="text/css">
i {
	cursor: pointer;
}

table tbody tr td {
	padding-left: 10px;
	width: 300px;
	color: black;
}

table tbody tr td:nth-child(odd) {
	text-align: center;
}

table tr th {
	border: 1px solid black;
	height: 42px;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}

table tr td {
	border: 1px solid black;
	height: 42px;
	word-break: break-all; /* 设置自动换行切不挤压其他td */
}

.tdWidth {
	width: 100px;
}
</style>
</head>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />

	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 1300px; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title" style="display: inline-block; color: black;">案件详情信息</h3>
				<input value="返回列表" class="btn btn-default"
					onclick="javascript:history.go(-1)" type="button"> <input
					value="修改案件" class="btn btn-default" type="button"
					onclick="case_change()"> <input value="打印"
					class="btn btn-default" type="button" onclick="print_Page()">
			</div>
			<div id="loadingLayer"  style="margin: 0 auto; width: 45px;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></div>
			<div id="tableContent" class="panel-body" style="display: none;">
				<table style="width: 1200px;">
					<tr>
						<td colspan="6"
							style="text-align: left; border-top: none; border-left: none; border-right: none;"><h3>案件信息</h3></td>
					</tr>
					<tr>
						<td class="tdWidth">勘验编号</td>
						<td>{{ senceInfor.snece_inquestId }}</td>
						<td class="tdWidth">勘验系统编号</td>
						<td>{{ senceInfor.snece_inquestSystemId }}</td>
						<td class="tdWidth">案件分类</td>
						<td>{{ caseInfor.case_classify }}</td>
					</tr>
					<tr>
						<td class="tdWidth">接警时间</td>
						<td>{{ caseInfor.case_receivingAlarmDate }}</td>
						<td class="tdWidth">危害程度</td>
						<td>{{ caseInfor.case_extentOfInjury }}</td>
						<td class="tdWidth">是否立案</td>
						<td v-if="caseInfor.case_register == '1'">是</td>
						<td v-if="caseInfor.case_register == '0'">否</td>
					</tr>
					<tr>
						<td class="tdWidth">案发地点</td>
						<td colspan="3">{{ caseInfor.case_address }}</td>
						<td class="tdWidth">案件类别</td>
						<td>{{ caseInfor.case_totalCategory }}-{{
							caseInfor.case_sonCategory }}</td>
					</tr>
					<tr>
						<td class="tdWidth">案件名称</td>
						<td colspan="5">{{ caseInfor.case_name }}</td>
					</tr>
					<tr>
						<td class="tdWidth">天气情况</td>
						<td>{{ senceInfor.snece_weather }}</td>
						<td class="tdWidth">温度</td>
						<td>{{ senceInfor.snece_weatherTemperature }}度</td>
						<td class="tdWidth">作案时段</td>
						<td>{{ caseInfor.case_makeTime }}</td>
					</tr>
					<tr>
						<td class="tdWidth">发案辖区</td>
						<td>{{ caseInfor.case_jurisdiction }}</td>
						<td class="tdWidth">作案手段</td>
						<td>{{ caseInfor.case_makeMeans }}</td>
						<td class="tdWidth">具体手段</td>
						<td>{{ caseInfor.case_concreteMakeMeans }}</td>
					</tr>
					<tr>
						<td class="tdWidth">作案处所</td>
						<td>{{ caseInfor.case_residence }}</td>
						<td class="tdWidth">具体处所</td>
						<td>{{ caseInfor.case_concreteResidence }}</td>
						<td class="tdWidth">进出口</td>
						<td>{{ caseInfor.case_exit }}</td>
					</tr>
					<tr>
						<td class="tdWidth">简要案情</td>
						<td colspan="5">{{ briefdetails.briefdetails_details }}</td>
					</tr>
					<tr>
						<td class="tdWidth">报案人姓名</td>
						<td>{{ caseInfor.case_reporterName }}</td>
						<td class="tdWidth">报案人年龄</td>
						<td>{{ caseInfor.case_reporterSex }}</td>
						<td class="tdWidth">报案人工作单位</td>
						<td>{{ caseInfor.case_reporterJobUnit }}</td>
					</tr>
					<tr>
						<td class="tdWidth">报案人联系电话</td>
						<td>{{ caseInfor.case_reporterPhone }}</td>
						<td class="tdWidth">报案人家庭地址</td>
						<td colspan="3">{{ caseInfor.case_reporterAddress }}</td>
					</tr>
					<tr>
						<td class="tdWidth">作案过程</td>
						<td colspan="5">{{ caseInfor.case_process }}</td>
					</tr>
					<tr>
						<td class="tdWidth">是否拍照</td>
						<td v-if="senceInfor.snece_photographed=='1'">是</td>
						<td v-if="senceInfor.snece_photographed=='0'">否</td>
						<td class="tdWidth">是否录入</td>
						<td v-if="senceInfor.snece_entered=='1'">是</td>
						<td v-if="senceInfor.snece_entered=='0'">否</td>
						<td class="tdWidth">是否制作</td>
						<td v-if="senceInfor.snece_areadymade=='1'">是</td>
						<td v-if="senceInfor.snece_areadymade=='0'">否</td>
					</tr>
					<tr>
						<td class="tdWidth">是否分析</td>
						<td v-if="senceInfor.snece_parsed=='1'">是</td>
						<td v-if="senceInfor.snece_parsed=='0'">否</td>
						<td class="tdWidth">是否存档</td>
						<td v-if="senceInfor.snece_archived=='1'">是</td>
						<td v-if="senceInfor.snece_archived=='0'">否</td>
						<td class="tdWidth">是否认定</td>
						<td v-if="senceInfor.snece_identified=='1'">是</td>
						<td v-if="senceInfor.snece_identified=='0'">否</td>
					</tr>
					<tr>
						<td class="tdWidth">移动基站号</td>
						<td>{{ senceInfor.snece_mobileStation }}</td>
						<td class="tdWidth">移动小区号</td>
						<td>{{ senceInfor.snece_mobileVillage }}</td>
						<td class="tdWidth">电信基站号</td>
						<td>{{ senceInfor.snece_telecomStation }}</td>
					</tr>
					<tr>
						<td class="tdWidth">联通基站号</td>
						<td colspan="3">{{ senceInfor.snece_unicomSwitchboard }}</td>
						<td class="tdWidth">联通小区号</td>
						<td>{{ senceInfor.snece_unicomVillage }}</td>
					</tr>
					<tr>
						<td class="tdWidth">勘验人员</td>
						<td colspan="5">{{ senceInfor.snece_inquestPerson }}</td>
					</tr>
					<tr>
						<td class="tdWidth">填表人员</td>
						<td>{{ senceInfor.snece_fillPerson }}</td>
						<td class="tdWidth">填表单位</td>
						<td>{{ senceInfor.snece_fillUnit }}</td>
						<td class="tdWidth">填表时间</td>
						<td>{{ senceInfor.snece_fillTime }}</td>
					</tr>
				</table>
				<hr style="margin-top:45px; border: solid 1px black;">
				<table style="width: 1200px; text-align: center;">
					<tr>
						<td colspan="6"
							style="text-align: left; border-top: none; border-left: none; border-right: none;"><h3>物证信息</h3></td>
					</tr>
					<tr>
						<td colspan="1">物证名称</td>
						<td style="text-align: center;">提取日期</td>
						<td>存放位置</td>
						<td>提取人</td>
						<td style="text-align: center;">流转状态</td>
						<td style="text-align: center;">检验状态</td>
					</tr>
					<template v-for="re in resevidence">
					<tr>
						<td colspan="1">{{ re.resevidence_name }}</td>
						<td>{{ re.resevidence_extractTime }}</td>
						<td>{{ re. }}</td>
						<td>{{ re.resevidence_extractPerson }}</td>
						<td>{{ re.resevidence_circulation }}</td>
						<td>{{ re.resevidence_teststate }}</td>
					</tr>
					</template>
					<tr>
						<td colspan="1"></td>
						<td></td>
						<td></td>
						<td colspan="1"></td>
						<td></td>
						<td></td>
					</tr>
				</table>
				<hr style="margin-top:45px; border: solid 1px black;">
				<table style="width: 1200px; text-align: center;">
					<tr>
						<td colspan="6"
							style="text-align: left; border-top: none; border-left: none; border-right: none;"><h3>被盗物品信息</h3></td>
					</tr>
					<!-- <tr>
						<td colspan="6"
							style="text-align: left; border-top: none; border-left: none; border-right: none;">丢失物品信息</td>
					</tr> -->
					<tr>
						<td colspan="3">丢失物品名称</td>
						<td colspan="3" style="text-align: center;">备注</td>
					</tr>
					<template v-for="lo in lost">
					<tr>
						<td colspan="3">{{ lo.lost_name }}</td>
						<td colspan="3">{{ lo.lost_remarks }}</td>
					</tr>
					</template>
					<tr>
						<td colspan="3"></td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="6"
							style="text-align: left; border-top: none; border-left: none; border-right: none;"></td>
					</tr>
					<tr>
						<td>电脑品牌</td>
						<td style="text-align: center;">上网账号</td>
						<td colspan="2">MAC地址</td>
						<td colspan="2" style="text-align: center;">备注</td>
					</tr>
					<template v-for="loc in lost_computer">
					<tr>
						<td>{{ loc.lost_computer_brand }}</td>
						<td>{{ loc.lost_computer_internetAccount }}</td>
						<td colspan="2">{{ loc.lost_computer_MAC }}</td>
						<td colspan="2">{{ loc.lost_computer_remarks }}</td>
					</tr>
					</template>
					<tr>
						<td></td>
						<td></td>
						<td colspan="2"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="6"
							style="text-align: left; border-top: none; border-left: none; border-right: none;"></td>
					</tr>
					<tr>
						<td>手机号码</td>
						<td style="text-align: center;">手机串号</td>
						<td colspan="2">手机特征</td>
						<td colspan="2" style="text-align: center;">备注</td>
					</tr>
					<template v-for="lom in lost_mobilephone">
					<tr>
						<td>{{ lom.lost_mobilephone_phone }}</td>
						<td>{{ lom.lost_mobilephone_IMEI }}</td>
						<td colspan="2">{{ lom.lost_mobilephone_feature }}</td>
						<td colspan="2">{{ lom.lost_mobilephone_remarks }}</td>
					</tr>
					</template>
					<tr>
						<td></td>
						<td></td>
						<td colspan="2"></td>
						<td colspan="2"></td>
					</tr>
				</table>
				<hr style="margin-top:45px; border: solid 1px black;">
				<table style="font-weight: bold; width: 1200px; text-align: center;">
					<tr>
						<td colspan="6"
							style="text-align: left; border-top: none; border-left: none; border-right: none;"><h3>照片信息</h3></td>
					</tr>
					<tr>
						<td colspan="2">所属光盘编号</td>
						<td colspan="2" style="text-align: center;">照片编号</td>
						<td colspan="2">备注</td>
					</tr>
					<template v-for="pic in picture">
					<tr>
						<td colspan="2">{{ pic.picture_image }}</td>
						<td colspan="2">{{ pic.picture_identifier }}</td>
						<td colspan="2">{{ pic.picture_remarks }}</td>
					</tr>
					</template>
					<tr>
						<td colspan="2"></td>
						<td colspan="2"></td>
						<td colspan="2"></td>
					</tr>
				</table>
</body>
<script type="text/javascript">
	$.datetimepicker.setLocale('ch');
	$('.mydate').datetimepicker({
		yearStart : 1990, // 设置最小年份
		yearEnd : 2050, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : false, // 关闭时间选项
		format : 'Y-m-d', // 格式化日期年-月-日
		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
	$('.mydate_minute').datetimepicker({
		yearStart : 1990, // 设置最小年份
		yearEnd : 2050, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : true, // 关闭时间选项
		format : 'Y-m-d H:i', // 格式化日期年-月-日
		minDate : '1990/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
</script>
</html>