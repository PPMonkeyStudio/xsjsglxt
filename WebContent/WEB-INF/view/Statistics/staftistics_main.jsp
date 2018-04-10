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
<style>
tr.trCover:HOVER {
	background-color: #F5F5F5;
}

td {
	white-space: nowrap;
	overflow: hidden;
	word-break: keep-all;
}
</style>
<title>统计模块</title>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/policemanOutTimes.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/btnControl.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/comparisonTimes.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/case-select.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/caseTime.js"></script>
</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<jsp:include page="/technologyManager.jsp" flush="true"></jsp:include>
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div id="allContent">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<div class="statisticsNavbar" style="margin-top: 10px;">
				<button class="btn btn-default" id="goFieldPage"
					onclick="changePage(this)" style="">现场统计</button>
				<button class="btn btn-default" onclick="changePage(this)"
					style="margin-left: 30px;" id="goComparisonPage">比对指纹统计</button>
				<button class="btn btn-default" onclick="changePage(this)"
					style="margin-left: 30px;" id="goCasePage">辖区案件统计</button>
			</div>
			<!-- --------------------------出警次数统计--------------------------------------------- -->
			<div id="fieldPage" id="fieldPage" style="margin-top: 10px;">
				<label>接警时间筛选：</label><input class="form-control startTime"
					onchange="loadPoliceman()" type="text" id="timeStart"
					style="width: 150px; display: inline-block;"><label>至</label>
				<input class="form-control startTime" onchange="loadPoliceman()"
					type="text" id="timeEnd"
					style="width: 150px; display: inline-block;"> <label>姓名筛选：</label>
				<input id="queryPolicemanName" type="text" class="form-control"
					style="margin-bottom: 10px; width: 250px; display: inline-block;"
					oninput="loadPoliceman()" placeholder="请输入警员姓名">
				<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
					<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
				</div>
				<div id="fieldStatistics" style="display: none;">
					<table class="table table-bordered" style="text-align: center;">
						<thead>
							<tr>
								<td>警员姓名</td>
								<td>出警次数</td>
							</tr>
						</thead>
						<tbody>
							<tr v-for="policeman in policemanList">
								<td>{{ policeman.policemanName }}</td>
								<td>{{ policeman.outTimes }}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- ----------------------------比对指纹统计-------------------------------------- -->
			<div id="comparisonTime" style="margin-top: 10px; display: none;">
				<label>比对时间筛选：</label><input class="form-control startTime"
					onchange="loadComparison()" type="text" id="timeStartComparison"
					style="width: 150px; display: inline-block;"><label>至</label>
				<input class="form-control startTime" onchange="loadComparison()"
					type="text" id="timeEndComparison"
					style="width: 150px; display: inline-block;"> <label>姓名筛选：</label>
				<input id="queryPolicemanNameComparison" type="text"
					class="form-control"
					style="margin-bottom: 10px; width: 250px; display: inline-block;"
					oninput="loadComparison()" placeholder="请输入警员姓名">
				<div id="loadingLayerComparison"
					style="margin: 0 auto; width: 45px;">
					<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
				</div>
				<div id="comparisonContent" style="display: none;">
					<table class="table table-bordered" style="text-align: center;">
						<thead>
							<tr>
								<td>警员姓名</td>
								<td>比对指纹次数</td>
							</tr>
						</thead>
						<tbody>
							<tr v-for="comparison in comparisonList">
								<td>{{ comparison.policemanname }}</td>
								<td>{{ comparison.comparisonTime }}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- ----------------------------案件统计-------------------------------------- -->
			<div id="caseTime" style="margin-top: 10px; display: none;">
				<div id="caseSelect" style="display: inline-block;">
					<select id='firstCase' class="form-control"
						style="width: 200px; display: inline-block;"
						onchange="changeSecondSelect(this)">
						<option value="所有案件">请选择案件总类别</option>
						<option value="盗窃案">盗窃案</option>
						<option value="抢劫案">抢劫案</option>
						<option value="抢夺案">抢夺案</option>
						<option value="强奸案">强奸案</option>
						<option value="绑架案">绑架案</option>
						<option value="杀人案">杀人案</option>
						<option value="故意伤害案">故意伤害案</option>
						<option value="爆炸案">爆炸案</option>
						<option value="放火案">放火案</option>
						<option value="非法拘禁案">非法拘禁案</option>
						<option value="非正常死亡案">非正常死亡</option>
						<option value="故意损坏公私财物案">故意损坏公私财物</option>
						<option value="其他">其他</option>
					</select>
				</div>
				<label>接警时间筛选：</label><input class="form-control startTime"
					onchange="loadCase()" type="text" id="timeStartCase"
					style="width: 150px; display: inline-block;"><label>至</label>
				<input class="form-control startTime" onchange="loadCase()"
					type="text" id="timeEndCase"
					style="width: 150px; display: inline-block;"> <label>高亮显示：</label>
				<select id='policeStation' class="form-control"
					style="width: 200px; display: inline-block;"
					onchange="highLightShow(this)">
					<option value="">请选择案发辖区</option>
					<option value="东大派出所">东大派出所</option>
					<option value="高坑派出所">高坑派出所</option>
					<option value="青山派出所">青山派出所</option>
					<option value="安源派出所">安源派出所</option>
					<option value="八一派出所">八一派出所</option>
					<option value="白源派出所">白源派出所</option>
					<option value="城郊派出所">城郊派出所</option>
					<option value="丹江派出所">丹江派出所</option>
					<option value="凤凰派出所">凤凰派出所</option>
					<option value="后埠派出所">后埠派出所</option>
					<option value="李子园派出所">李子园派出所</option>
					<option value="五陂下派出所">五陂下派出所</option>
					<option value="其他">其他</option>
				</select>
				<div id="loadingLayerCase" style="margin: 0 auto; width: 45px;">
					<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
				</div>
				<div id="caseContent" style="margin-top: 10px; display: none;">
					<table class="table table-bordered"
						style="text-align: center; font-size: 10px; font-weight: bold">
						<thead>
							<tr id="trHead">
								<td>案件类型</td>
								<td>东大派出所</td>
								<td>高坑派出所</td>
								<td>青山派出所</td>
								<td>安源派出所</td>
								<td>八一派出所</td>
								<td>白源派出所</td>
								<td>城郊派出所</td>
								<td>丹江派出所</td>
								<td>凤凰派出所</td>
								<td>后埠派出所</td>
								<td>李子园派出所</td>
								<td>五陂下派出所</td>
								<td>其他</td>
							</tr>
						</thead>
						<tbody id="caseTBody">
							<tr name="caseTr" class="trCover" v-for="caseTime in caseList">
								<td>{{ caseTime.caseCategory }}</td>
								<td><span v-html="caseTime.dongDaTime"></span></td>
								<td><span v-html="caseTime.gaoKangTime"></span></td>
								<td><span v-html="caseTime.qingshanTime"></span></td>
								<td><span v-html="caseTime.anyuanTime"></span></td>
								<td><span v-html="caseTime.bayiTime"></span></td>
								<td><span v-html="caseTime.baiyuanTime"></span></td>
								<td><span v-html="caseTime.chengjiaoTime"></span></td>
								<td><span v-html="caseTime.danjiangTime"></span></td>
								<td><span v-html="caseTime.fenghuangTime"></span></td>
								<td><span v-html="caseTime.houfuTime"></span></td>
								<td><span v-html="caseTime.liziyuanTime"></span></td>
								<td><span v-html="caseTime.wupoxiaTime"></span></td>
								<td><span v-html="caseTime.qitaTime"></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$.datetimepicker.setLocale('ch');
		$('.startTime').datetimepicker({
			yearStart : 1900, // 设置最小年份
			yearEnd : 2100, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2100/01/01', // 设置最大日期
		});
	</script>
	<script type="text/javascript">
		var documentWidth = document.body.clientWidth;
		var panelWidth = documentWidth - 160;
		var navbarHeight = document.getElementById("navbar").offsetHeight;
		var panelMargin = navbarHeight + 20;
		document.getElementById("allContent").setAttribute(
				"style",
				"width:" + panelWidth + "px; float:right; margin-top:"
						+ panelMargin + "px;");
		window.onresize = function() {
			var documentWidth = document.body.clientWidth;
			var panelWidth = documentWidth - 160;
			var navbarHeight = document.getElementById("navbar").offsetHeight;
			var panelMargin = navbarHeight + 20;
			document.getElementById("allContent").setAttribute(
					"style",
					"width:" + panelWidth + "px; float:right; margin-top:"
							+ panelMargin + "px;");
		}
	</script>
</body>
</html>