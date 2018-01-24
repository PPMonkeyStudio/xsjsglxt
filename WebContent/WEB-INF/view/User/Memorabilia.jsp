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
<title>大事记</title>
<!-- -----------------模态框js文件引入--------------------------------  -->
<script type="text/javascript" src="<%=basePath %>js/memorabilia/createMemorabilia.js"></script>
<script type="text/javascript" src="<%=basePath %>js/memorabilia/showMemorabilia.js"></script> 
<script type="text/javascript" src="<%=basePath %>js/memorabilia/managerMemorabilia.js"></script> 
</head>
<body>
	<!-----------------------------------------引入导航条 ------------------------------------------------------>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!-----------------------------------------主面板---------------------------------------------------------  -->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto; padding-left:20px; padding-right:20px;">
			<div class="headDiv" style="padding-top: 10px;">
				<button class="btn btn-default" onclick="createConfirm()"><i class="fa fa-pencil-square-o"></i>填写大事记</button>
				<div id="query" style="float: right;">
				<label>时间筛选</label>
				<input class="form-control startTime" onchange="changeTime(this)" type= "text" id="timeStart" style="width: 150px; display: inline-block;">至
				<input class="form-control startTime" onchange="changeTime(this)" type= "text" style="width: 150px; display: inline-block;" id="timeEnd">
				<label>查询</label>
				<input type="text" id="searchInput" class="form-control" style="width: 250px; display: inline-block;" oninput="changeSearchContent(this)" placeholder="请输入搜索内容">
				</div>
			</div>
			<div id="loadingLayer"  style="margin: 0 auto; width: 45px;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></div>
			<div id="allInformation" class="hideDiv" style="margin-top: 10px;">
				<table class="table table-bordered" style="text-align: center;">
					<thead>
						<tr style="background-color: #696969; color: white;">
							<td>大事记名称</td>
							<td>大事记参与人员</td>
							<td><select class="form-control" onclick="changeSort(this)">
								<option value="desc">大事记发生时间（降序）</option>
								<option value="asc">大事记发生时间（升序）</option>
							</select> </td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<tr v-for="memorabilia in memorabiliaList">
							<td><span v-html="memorabilia.memorabilia_title"></span></td>
							<td><span v-html="memorabilia.memorabilia_join_human"></span></td>
							<td>{{ memorabilia.memorabilia_time }}</td>
							<td><div class='dropdown'><i class='dropdown-toggle fa fa-angle-double-down pageOperation'  data-toggle='dropdown' aria-hidden='true' aria-haspopup=true' aria-expanded='false'></i>
								<ul class='dropdown-menu' aria-labelledby='dLabe' style='text-align:center; min-width: 100px;'>
								<li :id='memorabilia.memorabilia_id' class='pageOperation'><a>导出</a></li>
								<li :id='memorabilia.memorabilia_id'  onclick='updateMeetingRecords(this)' class='pageOperation'><a>修改</a></li>
								<li :id='memorabilia.memorabilia_id' onclick='deleteMeetingRecords(this)'  class='pageOperation'><a>删除</a></li>
								</ul></div>	
							</td>
						</tr>
					</tbody>
				</table>
				<div id="bottomPage" style="padding: 20px;">
					<span>当前页数:<span id="currPage">{{ currPage }}</span></span>
					<span>共:<span id="totalPage">{{ pageCount }}</span>页</span>
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