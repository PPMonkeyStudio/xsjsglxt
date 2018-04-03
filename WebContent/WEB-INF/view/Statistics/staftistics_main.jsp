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
<title>统计模块</title>
<script type="text/javascript"
	src="<%=basePath%>js/Statistics/policemanOutTimes.js"></script>
</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<jsp:include page="/technologyManager.jsp" flush="true"></jsp:include>
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div style="float: left; width: 100%;">
		<div class="panel"
			style="width: 95%; margin: 20px auto; padding-left: 20px; padding-right: 20px;">
			<div class="statisticsNavbar" style="margin-top: 10px;">
				<button class="btn btn-default" onclick="" style="">现场统计</button>
				<button class="btn btn-default" onclick=""
					style="margin-left: 30px;">比对指纹统计</button>
				<button class="btn btn-default" onclick=""
					style="margin-left: 30px;">辖区案件统计</button>
			</div>
			<div class="statisticsContent" id="statisticsContent"
				style="margin-top: 10px;">
				<input id="queryPolicemanName" type="text" class="form-control"
					style="margin-bottom: 10px; width: 250px; float: right;"
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