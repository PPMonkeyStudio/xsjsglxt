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
.pageOperation:HOVER {
	cursor: pointer;
}
</style>
<title>统计模块</title>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/policemanOutTimes.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/btnControl.js"></script>
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
			<div class="statisticsNavbar"
				style="margin-top: 10px; margin-left: 10px;">
				<button class="btn btn-default" id="goFieldPage"
					onclick="changePage(this)" style="">现场统计</button>
				<button class="btn btn-default" onclick="changePage(this)"
					style="margin-left: 30px;" id="goCasePage">现场案件统计</button>
			</div>
			<!-- --------------------------出警次数统计--------------------------------------------- -->
			<div id="fieldPage" id="fieldPage"
				style="margin-top: 10px; margin-left: 10px; margin-right: 10px;">
				<label>时间筛选：</label><input class="form-control startTime"
					onchange="loadPolicemanCondition()" type="text" id="timeStart"
					style="width: 150px; display: inline-block;"><label>至</label>
				<input class="form-control startTime" onchange="loadPolicemanCondition()"
					type="text" id="timeEnd"
					style="width: 150px; display: inline-block;"> <label>姓名筛选：</label>
				<input id="queryPolicemanName" type="text" class="form-control"
					style="margin-bottom: 10px; width: 250px; display: inline-block;"
					oninput="loadPolicemanCondition()" placeholder="请输入警员姓名">
				<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
					<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
				</div>
				<div id="fieldStatistics" style="display: none;">
					<table class="table table-bordered" style="text-align: center;">
						<thead>
							<tr>
								<td rowspan="2">警员姓名</td>
								<td rowspan="2">现场出勘数</td>
								<td colspan="6">痕迹物证提取数</td>
								<td rowspan="2">痕迹物证提取率</td>
								<td rowspan="2">破案数</td>
							</tr>
							<tr>
								<td>手印</td>
								<td>足迹</td>
								<td>工具</td>
								<td>生物</td>
								<td>理化</td>
								<td>其他</td>
							</tr>
						</thead>
						<tbody>
							<!-- 							<tr v-for="policeman in policemanList">
								<td>{{ policeman.policemanName }}</td>
								<td>{{ policeman.outTimes }}</td>
							</tr> -->
							<tr v-for="policeman in policemanOutVO.policemanOutDTOList">
								<td>{{ policeman.policemanName }}</td>
								<td>{{ policeman.outTimes }}</td>
								<td>{{ policeman.fingerprint }}</td>
								<td>{{ policeman.footprint }}</td>
								<td>{{ policeman.instrument }}</td>
								<td>{{ policeman.biology }}</td>
								<td>{{ policeman.physicochemical }}</td>
								<td>{{ policeman.other }}</td>
								<td>{{ policeman.extractionRadio }}</td>
								<td>{{ policeman.breakeNumber }}</td>
							</tr>
						</tbody>
					</table>
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">{{
								policemanOutVO.currPage }}</span></span> <span>共:<span id="totalPage">{{
								policemanOutVO.totalPage }}</span>页
						</span> <span onclick="skipToIndexPage()" id="indexPage"
							class="pageOperation">首页</span> <span
							onclick="skipToPrimaryPage()" id="previousPage"
							class="pageOperation">上一页</span> <span onclick="skipToNextPage()"
							id="nextPage" class="pageOperation">下一页</span> <span
							onclick="skipToLastPage()" id="lastPage" class="pageOperation">末页</span>
						<span> <input id="skipPage" type="text"
							style="text-align: center; width: 60px; height: 30px;"
							class="queryInput">
							<button onclick="skipToArbitrarilyPage()" class="btn btn-default"
								style="height: 30px; margin-bottom: 10px;">跳转</button>
						</span>
					</div>
				</div>
			</div>
			<!-- ----------------------------案件统计-------------------------------------- -->
			<div id="caseTime"
				style="margin-top: 10px; display: none; margin-left: 10px; margin-right: 10px;">
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
						<option value="非正常死亡">非正常死亡</option>
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
					<option value="安源派出所">安源派出所</option>
					<option value="城郊派出所">城郊派出所</option>
					<option value="凤凰派出所">凤凰派出所</option>
					<option value="后埠派出所">后埠派出所</option>
					<option value="东大派出所">东大派出所</option>
					<option value="高坑派出所">高坑派出所</option>
					<option value="青山派出所">青山派出所</option>	
					<option value="八一派出所">八一派出所</option>
					<option value="白源派出所">白源派出所</option>
					<option value="丹江派出所">丹江派出所</option>			
					<option value="李子园派出所">李子园派出所</option>
					<option value="五陂下派出所">五陂下派出所</option>
					<option value="其他">其他</option>
				</select>
				<div id="loadingLayerCase" style="margin: 0 auto; width: 45px;">
					<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
				</div>
				<div id="caseContent" style="margin-top: 10px; display: none;">
					<table class="table table-bordered"
						style="text-align: center;">
						<thead>
							<tr id="trHead">
								<td>案件类型</td>
								<td>安源</td>
								<td>城郊</td>
								<td>凤凰</td>
								<td>后埠</td>
								<td>东大</td>
								<td>高坑</td>
								<td>青山</td>
								<td>八一</td>
								<td>白源</td>		
								<td>丹江</td>		
								<td>李子园</td>
								<td>五陂下</td>
								<td>其他</td>
								<td>汇总</td>
							</tr>
						</thead>
						<tbody id="caseTBody">
							<tr name="caseTr" class="trCover" v-for="caseTime in caseList">
								<td>{{ caseTime.caseCategory }}</td>
								<td><span v-html="caseTime.anyuanTime"></span></td>
								<td><span v-html="caseTime.chengjiaoTime"></span></td>
								<td><span v-html="caseTime.fenghuangTime"></span></td>
								<td><span v-html="caseTime.houfuTime"></span></td>
								<td><span v-html="caseTime.dongDaTime"></span></td>
								<td><span v-html="caseTime.gaoKangTime"></span></td>
								<td><span v-html="caseTime.qingshanTime"></span></td>
								<td><span v-html="caseTime.bayiTime"></span></td>
								<td><span v-html="caseTime.baiyuanTime"></span></td>
								<td><span v-html="caseTime.danjiangTime"></span></td>
								<td><span v-html="caseTime.liziyuanTime"></span></td>
								<td><span v-html="caseTime.wupoxiaTime"></span></td>
								<td><span v-html="caseTime.qitaTime"></span></td>
								<td><span v-html="caseTime.anyuanTime+caseTime.chengjiaoTime+caseTime.fenghuangTime
								+caseTime.houfuTime+caseTime.gaoKangTime+caseTime.dongDaTime+caseTime.qingshanTime+caseTime.bayiTime+
								caseTime.baiyuanTime+caseTime.danjiangTime+caseTime.liziyuanTime+caseTime.wupoxiaTime+caseTime.qitaTime"></span></td>
							</tr>
							<tr name="caseTr">
								<td>汇总</td>
								<td><span v-html="count[0]"></span></td>
								<td><span v-html="count[1]"></span></td>
								<td><span v-html="count[2]"></span></td>
								<td><span v-html="count[3]"></span></td>
								<td><span v-html="count[4]"></span></td>
								<td><span v-html="count[5]"></span></td>
								<td><span v-html="count[6]"></span></td>
								<td><span v-html="count[7]"></span></td>
								<td><span v-html="count[8]"></span></td>
								<td><span v-html="count[9]"></span></td>
								<td><span v-html="count[10]"></span></td>
								<td><span v-html="count[11]"></span></td>
								<td><span v-html="count[12]"></span></td>
								<td><span v-html="count[0]+count[1]+count[2]+count[3]
								+count[4]+count[5]+count[6]+count[7]
								+count[8]+count[9]+count[10]+count[11]+count[12]"></span></td>
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
		var caseContent = document.getElementById("caseContent").style.width;
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