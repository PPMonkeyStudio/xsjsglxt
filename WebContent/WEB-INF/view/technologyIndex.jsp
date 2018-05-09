<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>技术管理首页</title>
<script type="text/javascript">
	window.onload = function() {
		/* $('#hideLayer').hide(); */
		getCurrentTime();
		setInterval(getCurrentTime, 1000);
		console.log("执行查询查班");
		$
				.ajax({
					url : '/xsjsglxt/scheduling/Scheduling_getSchedulingByDate',
					type : 'GET',
					success : function(data) {
						if (data == "noScheduling") {
							document.getElementById("schedulingH3").innerHTML = "今日未安排值班";
						} else {
							String
							result = JSON.parse(data);
							document.getElementById("leader").innerHTML = result.scheduling_leader;
							document.getElementById("main").innerHTML = result.scheduling_main;
							document.getElementById("mainTech").innerHTML = result.scheduling_main_technology;
							document.getElementById("assistant").innerHTML = result.scheduling_assistant;
							if(result.scheduling_patrol!=null)
							document.getElementById("patrol").innerHTML = result.scheduling_patrol;
							if (result.scheduling_out_help != null)
								document.getElementById("outHelp").innerHTML = result.scheduling_out_help;
							if (result.scheduling_overtime != null)
								document.getElementById("overtime").innerHTML = result.scheduling_overtime;
						}
					}
				});
	}
	function getCurrentTime() {
		var now = new Date();

		var year = now.getFullYear(); //年
		var month = now.getMonth() + 1; //月
		var day = now.getDate(); //日

		var hh = now.getHours(); //时
		var mm = now.getMinutes(); //分

		var clock = year + "-";

		if (month < 10)
			clock += "0";

		clock += month + "-";

		if (day < 10)
			clock += "0";

		clock += day + " ";

		if (hh < 10)
			clock += "0";

		clock += hh + ":";
		if (mm < 10)
			clock += '0';
		clock += mm;
		console.log(clock);
		document.getElementById("current_time").innerHTML = clock;
	}
</script>
<style type="text/css">
.nav li {
	cursor: pointer;
}
</style>
</head>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<jsp:include page="/technologyManager.jsp" flush="true"></jsp:include>
			<div class="wrapper" id="wrapper">
			<div class="main" style="margin-left: 40px;">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h2 class="panel-title">欢迎进入安源刑侦信息管理系统</h2>
							<br>
							<h3 class="panel-title" id="schedulingH3">
								今日值班 带班领导：<span id="leader"></span> 侦查民警：<span id="main"></span>
								技术民警：<span id="mainTech"></span> 辅警：<span id="assistant"></span>
								 今日巡逻：<span id="patrol"></span><br><br>
								今日加班：<span id="overtime"></span>
								今日外协：<span id="outHelp"></span>
							</h3>
							<p class="panel-subtitle" style="margin-top: 20px;">
								当前时间是：<span id="current_time"></span>
							</p>

						</div>
						<div class="panel-body"></div>
					</div>
					<!-- END OVERVIEW -->

				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	</div>
</body>
</html>