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
</style>
<title>会议记录</title>
<!-- -----------------模态框js文件引入--------------------------------  -->
<script type="text/javascript" src="<%=basePath %>js/meeting/writeMeetingRecord.js"></script>
<script type="text/javascript" src="<%=basePath %>js/meeting/showMeetRecods.js"></script>
</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<div class="headDiv" style="height: 60px; padding-top:10px;">
				<button class="btn btn-default" onclick="createConfirm()"><i class="fa fa-pencil-square-o"></i>填写会议记录表</button>
				<div style="display:inline-block; margin-right: 20px; float: right;">
				<label>时间筛选</label>
				<input class="form-control startTime"  type= "text" id="query_start_time_start" style="width: 150px; display: inline-block;">至
				<input class="form-control startTime"  type= "text" style="width: 150px; display: inline-block;" id="query_start_time_end">
				</div>
			</div>
		
			<div class="tableDiv">
				<table class="table table-bordered" style="text-align: center;"">
					<thead>
						<tr style="background-color: #696969; color: white;">
							<td><select class="form-control" id="queryTitle" onchange="changeQueryTitle(this)">
								<option value=" ">所有</option>
								<option value="大队例会">大队例会</option>
								<option value="支委会">支委会</option>
								<option value="党课">党课</option>
								<option value="党员大会">党员大会</option>
								<option value="党小组会">党小组会</option>
								<option value="专案会">专案会</option>
								<option value="工作总结会">工作总结会</option>
							</select></td>
							<td>会议地点</td>
							<td>会议主持人</td>
							<td><select class="form-control" id="querySort" onchange="changTimeSort()">
								<option value="desc">会议开始时间（降序）</option>
								<option value="asc">会议开始时间（升序）</option>
							</select> </td>
							<td>会议结束时间</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody id="showList">
					
					</tbody>
				</table>
			</div>
			
			<div id="bottomPage" style="padding: 20px;">
				<span>当前页数:<span id="currPage">1</span></span>
				<span>共:<span id="totalPage">2</span>页</span>
				<span  onclick="skipToIndexPage()" id="indexPage" class="pageOperation">首页</span>
				<span onclick="skipToPrimaryPage()" id="previousPage" class="pageOperation">上一页</span>
				<span onclick="skipToNextPage()" id="nextPage" class="pageOperation">下一页</span>
				<span onclick="skipToLastPage()" id="lastPage" class="pageOperation">末页</span>
				<span>
					<input  id="skipPage" class="form-control" type="text" style="display:inline-block; text-align: center; width: 60px; height: 30px;" class="queryInput">
					<button onclick="skipToArbitrarilyPage()" class="btn btn-default" style="height:30px;">跳转</button>
				</span>
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
		format : 'Y-m-d H:i', // 格式化日期年-月-日
		minDate : '1900/01/01 00:00', // 设置最小日期
		maxDate : '2030/01/01 00:00', // 设置最大日期
	});
	</script>
	
</body>
</html>