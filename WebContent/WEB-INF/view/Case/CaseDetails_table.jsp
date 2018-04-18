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
<style type="text/css">
i {
	cursor: pointer;
}

table tr th {
	border: 1px solid #eee5e5;
	height: 42px;
}

table tr td {
	border: 1px solid #eee5e5;
	height: 42px;
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
				<h3 class="panel-title" style="display: inline-block;">案件详情信息</h3>
				<input value="返回列表" class="btn btn-default"
					onclick="javascript:history.go(-1)" type="button"> <input
					value="修改案件" class="btn btn-default" type="button"
					onclick="case_change()"> <input value="删除案件"
					class="btn btn-default" type="button" onclick="case_del()">
			</div>
			<div class="panel-body">
				<!-- 				<div class="operation" style="margin-bottom: 6px;">
					<button onclick="javascript:history.go(-1)" type="button"
						class="btn btn-default button button_return">
						<i class="fa fa-reply"></i> 返回列表
					</button>
					<button type="button" class="btn btn-default button button_change"
						onclick="case_change()">
						<i class="fa fa-pencil"></i> 修改案件
					</button>
					<button type="button" class="btn btn-default button button_del"
						onclick="case_del()">
						<i class="fa fa-times"></i> 删除案件
					</button>
				</div> -->
				<table style="text-align: center; width: 1000px;">
					<tr>
						<td colspan="6">案件信息</td>
					</tr>
					<tr>
						<td>案件名称</td>
						<td colspan="5"></td>
					</tr>
					<tr>
						<td>勘验编号</td>
						<td></td>
						<td>勘验系统编号</td>
						<td></td>
						<td>案件分类</td>
						<td></td>
					</tr>
					<tr>
						<td>接警时间</td>
						<td></td>
						<td>危害程度</td>
						<td></td>
						<td>是否立案</td>
						<td></td>
					</tr>
					<tr>
						<td>天气情况</td>
						<td></td>
						<td>温度</td>
						<td></td>
						<td>作案时段</td>
						<td></td>
					</tr>
					<tr>
						<td>发案辖区</td>
						<td></td>
						<td>作案手段</td>
						<td></td>
						<td>具体手段</td>
						<td></td>
					</tr>
					<tr>
						<td>作案处所</td>
						<td></td>
						<td>具体处所</td>
						<td></td>
						<td>进出口</td>
						<td></td>
					</tr>
					<tr>
						<td>是否拍照</td>
						<td></td>
						<td>是否录入</td>
						<td></td>
						<td>是否制作</td>
						<td></td>
					</tr>
					<tr>
						<td>是否分析</td>
						<td></td>
						<td>是否存档</td>
						<td></td>
						<td>是否认定</td>
						<td></td>
					</tr>
					<tr>
						<td>案发地点</td>
						<td colspan="2"></td>
						<td>案件类别</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>勘验人员</td>
						<td colspan="5"></td>
					</tr>
					<tr>
						<td>简要案情</td>
						<td colspan="5"></td>
					</tr>
					<tr>
						<td>作案过程</td>
						<td colspan="5"></td>
					</tr>
					<tr>
						<td colspan="6">报案人信息</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td></td>
						<td>年龄</td>
						<td></td>
						<td>工作单位</td>
						<td></td>
					</tr>
					<tr>
						<td>联系电话</td>
						<td></td>
						<td>家庭地址</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="6">物证信息</td>
					</tr>
					<tr>
						<td colspan="2">物证名称</td>
						<td>提取日期</td>
						<td colspan="2">提取人</td>
						<td>流转状态</td>
					</tr>
					<tr>
						<td colspan="2"></td>
						<td></td>
						<td colspan="2"></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="6">丢失物品信息</td>
					</tr>
					<tr>
						<td colspan="3">丢失物品名称</td>
						<td colspan="3">备注</td>
					</tr>
					<tr>
						<td colspan="3"></td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="6">丢失电脑信息</td>
					</tr>
					<tr>
						<td>电脑品牌</td>
						<td>上网账号</td>
						<td colspan="2">MAC地址</td>
						<td colspan="2">备注</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td colspan="2"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="6">丢失手机信息</td>
					</tr>
					<tr>
						<td>手机号码</td>
						<td>手机串号</td>
						<td colspan="2">手机特征</td>
						<td colspan="2">备注</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td colspan="2"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="6">照片信息</td>
					</tr>
					<tr>
						<td colspan="2">所属光盘编号</td>
						<td colspan="2">照片编号</td>
						<td colspan="2">备注</td>
					</tr>
					<tr>
						<td colspan="2"></td>
						<td colspan="2"></td>
						<td colspan="2"></td>
					</tr>
				</table>
</body>
<script type="text/javascript"
	src="<%=basePath%>js/Case/CaseDetails_js.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Case/SneceInput.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Case/CaseDetails.js"></script>
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