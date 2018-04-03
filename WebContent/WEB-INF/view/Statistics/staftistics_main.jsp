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
<style type="text/css">
	.pageOperation{
		cursor: pointer;
	}
	.hideDiv{
		display: none;
	}
</style>
<title>统计模块</title>
</head>
<body>
<%-- 	<div id="hideLayer" style="margin: 0 auto; background-color: white; position: fixed; width: 100%; height: 2000px; z-index: 99999999999999999999999999999999999999999;">
		<div style="width: 80px;height: 79px; margin: 0 auto; margin-top: 200px;"><img alt="" src="<%=basePath %>img/hui.png">
			<span style="color: black;">权限加载中</span>
		</div>
	</div> --%>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<jsp:include page="/technologyManager.jsp" flush="true"></jsp:include>	
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div style="float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto; padding-left:20px; padding-right:20px;">
			<div class="statisticsNavbar" style="margin-top: 10px;">
				<button class="btn btn-default" onclick="" style="">现场统计</button>
				<button class="btn btn-default" onclick="" style="margin-left: 30px;">比对指纹统计</button>
				<button class="btn btn-default" onclick="" style="margin-left: 30px;">辖区案件统计</button>
			</div>
			<div class="statisticsContent" id="statisticsContent" style="margin-top: 10px; font-style: 宋体;">
				<div id="fieldStatistics">
					<input type="text" class="form-control" style="margin-bottom:10px; width: 250px; float: right;" oninput="" placeholder="请输入警员姓名">
					<table class="table table-bordered" style="text-align: center;">
						<thead>
							<tr>
								<td>警员姓名</td>
								<td>出警次数</td>
							</tr>
						</thead>
						<tbody>
							<tr v-for="">
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</tabe>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$.datetimepicker.setLocale('ch');
		$('.startTime').datetimepicker({
			yearStart : 1990, // 设置最小年份
			yearEnd : 2050, // 设置最大年份
			yearOffset : 0, // 年偏差
			timepicker : false, // 关闭时间选项
			format : 'Y-m-d', // 格式化日期年-月-日
			minDate : '1900/01/01', // 设置最小日期
			maxDate : '2030/01/01', // 设置最大日期
		});
	</script>
</body>
</html>