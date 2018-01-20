/**
 * 
 */
var meetVO={
		"queryTitle":" ",
		"startTimeSort":"desc",
		"query_start_time_start":"",
		"query_start_time_end":"",
		"pageCount":0,
		"currPage":1,
		"pageSize":10,
		"totalCount":0
}

var  setPage = function(pageCount,currPage,pageSize,totalCount)
{
	meetVO.pageCount=pageCount;
	meetVO.currPage = currPage;
	meetVO.pageSize = pageSize;
	meetVO.totalCount = totalCount;
}

var setQuery = function (queryTitle,startTimeSort,query_start_time_start,query_start_time_end){
	meetVO.queryTitle=queryTitle;
	meetVO.startTimeSort = startTimeSort;
	meetVO.query_start_time_start = query_start_time_start;
	meetVO.query_start_time_end = query_start_time_end;
}

window.onload=function(){
		var meetVOPostTemp={
				"meetVO.queryTitle":meetVO.queryTitle,
				"meetVO.startTimeSort":meetVO.startTimeSort,
				"meetVO.query_start_time_start":meetVO.query_start_time_start,
				"meetVO.query_start_time_end":meetVO.query_start_time_end,
				"meetVO.pageCount":meetVO.pageCount,
				"meetVO.currPage":meetVO.currPage,
				"meetVO.pageSize":meetVO.pageSize,
				"meetVO.totalCount":meetVO.totalCount
		}
		$.ajax({
		url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type:"POST",		
		data: meetVOPostTemp,
		success:function(data){
			var jsonData = JSON.parse(data);
			setPage(jsonData.pageCount, jsonData.currPage, jsonData.pageSize, jsonData.totalCount);
			$("#currPage").html(jsonData.currPage);
			$("#totalPage").html(jsonData.pageCount);
			$("#query_start_time_start").val(meetVO.query_start_time_start);
			$("#query_start_time_end").val(meetVO.query_start_time_end);
			$("#queryTitle").val(meetVO.queryTitle);
			$("#querySort").val(meetVO.startTimeSort);
			var tableContent="";
			for(var i=0;i<jsonData.meetDTO.length;i++)
				{
				tableContent=tableContent+"<tr>" +
						"<td>"+jsonData.meetDTO[i].meeting_title+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_place+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_compere+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_start_time+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_end_time+"</td>" +
						"<td><button class='btn btn-primary' value='"+jsonData.meetDTO[i].meeting_id+"'>修改</button>" +
						"<button class='btn btn-danger' value='"+jsonData.meetDTO[i].meeting_id+"'>删除</button></td>" +
						"</tr>"
				}
			$("#showList").html(tableContent);
		}
	});
}

var ajaxSetTable = function(jsonData)
{
	setPage(jsonData.pageCount, jsonData.currPage, jsonData.pageSize, jsonData.totalCount);
	$("#currPage").html(jsonData.currPage);
	$("#totalPage").html(jsonData.pageCount);
	var tableContent="";
	for(var i=0;i<jsonData.meetDTO.length;i++)
		{
		tableContent=tableContent+"<tr>" +
				"<td>"+jsonData.meetDTO[i].meeting_title+"</td>" +
				"<td>"+jsonData.meetDTO[i].meeting_place+"</td>" +
				"<td>"+jsonData.meetDTO[i].meeting_compere+"</td>" +
				"<td>"+jsonData.meetDTO[i].meeting_start_time+"</td>" +
				"<td>"+jsonData.meetDTO[i].meeting_end_time+"</td>" +
				"<td><button class='btn btn-primary' value='"+jsonData.meetDTO[i].meeting_id+"'>修改</button>" +
				"<button class='btn btn-danger' value='"+jsonData.meetDTO[i].meeting_id+"'>删除</button></td>" +
				"</tr>"
		}
	$("#showList").html(tableContent);	
}

var skipToIndexPage  = function()
{
	if(meetVO.currPage ==1)
		{
			toastr.error("当前已经是首页");
		}
	else
		{
			meetVO.currPage=1;
			var meetVOPostTemp={
					"meetVO.queryTitle":meetVO.queryTitle,
					"meetVO.startTimeSort":meetVO.startTimeSort,
					"meetVO.query_start_time_start":meetVO.query_start_time_start,
					"meetVO.query_start_time_end":meetVO.query_start_time_end,
					"meetVO.pageCount":meetVO.pageCount,
					"meetVO.currPage":meetVO.currPage,
					"meetVO.pageSize":meetVO.pageSize,
					"meetVO.totalCount":meetVO.totalCount
			}
			$.ajax({
				url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
				type:"POST",		
				data: meetVOPostTemp,
				success:function(data){
					var jsonData = JSON.parse(data);
					ajaxSetTable(jsonData);
				}
			});
		}
}


var skipToPrimaryPage =function(){
	if(meetVO.currPage==1)
		{
			toastr.error("已经是第一页");
		}
	else
		{
			meetVO.currPage=++meetVO.currPage;
			var meetVOPostTemp={
					"meetVO.queryTitle":meetVO.queryTitle,
					"meetVO.startTimeSort":meetVO.startTimeSort,
					"meetVO.query_start_time_start":meetVO.query_start_time_start,
					"meetVO.query_start_time_end":meetVO.query_start_time_end,
					"meetVO.pageCount":meetVO.pageCount,
					"meetVO.currPage":meetVO.currPage,
					"meetVO.pageSize":meetVO.pageSize,
					"meetVO.totalCount":meetVO.totalCount
			}
			$.ajax({
				url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
				type:"POST",		
				data: meetVOPostTemp,
				success:function(data){
					var jsonData = JSON.parse(data);
					ajaxSetTable(jsonData);
				}
			});
		}
}

var skipToNextPage = function()
{
	if(meetVO.currPage==meetVO.pageCount)
		{
			toastr.error("已经是最后一页");
		}
	else
		{
			meetVO.currPage=--meetVO.currPage;
			var meetVOPostTemp={
					"meetVO.queryTitle":meetVO.queryTitle,
					"meetVO.startTimeSort":meetVO.startTimeSort,
					"meetVO.query_start_time_start":meetVO.query_start_time_start,
					"meetVO.query_start_time_end":meetVO.query_start_time_end,
					"meetVO.pageCount":meetVO.pageCount,
					"meetVO.currPage":meetVO.currPage,
					"meetVO.pageSize":meetVO.pageSize,
					"meetVO.totalCount":meetVO.totalCount
			}
			$.ajax({
				url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
				type:"POST",		
				data: meetVOPostTemp,
				success:function(data){
					var jsonData = JSON.parse(data);
					ajaxSetTable(data);
				}
			});
		}
}
var skipToLastPage = function()
{
	if(meetVO.currPage==meetVO.pageCount)
	{
		toastr.error("已经是最后一页");
	}
else
	{
		meetVO.currPage=meetVO.pageCount;
		var meetVOPostTemp={
				"meetVO.queryTitle":meetVO.queryTitle,
				"meetVO.startTimeSort":meetVO.startTimeSort,
				"meetVO.query_start_time_start":meetVO.query_start_time_start,
				"meetVO.query_start_time_end":meetVO.query_start_time_end,
				"meetVO.pageCount":meetVO.pageCount,
				"meetVO.currPage":meetVO.currPage,
				"meetVO.pageSize":meetVO.pageSize,
				"meetVO.totalCount":meetVO.totalCount
		}
		$.ajax({
			url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
			type:"POST",		
			data: meetVOPostTemp,
			success:function(data){
				var jsonData = JSON.parse(data);
				ajaxSetTable(jsonData);
			}
		});
	}
}

var skipToArbitrarilyPage = function()
{
	if ( $("#skipPage").val()<= 0 || $("#skipPage").val() > meetVO.pageCount) {
		toastr.error("不存在此页");
	} 
	else
		{
			meetVO.currPage=$("#skipPage").val();
			var meetVOPostTemp={
					"meetVO.queryTitle":meetVO.queryTitle,
					"meetVO.startTimeSort":meetVO.startTimeSort,
					"meetVO.query_start_time_start":meetVO.query_start_time_start,
					"meetVO.query_start_time_end":meetVO.query_start_time_end,
					"meetVO.pageCount":meetVO.pageCount,
					"meetVO.currPage":meetVO.currPage,
					"meetVO.pageSize":meetVO.pageSize,
					"meetVO.totalCount":meetVO.totalCount
			}
			$.ajax({
				url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
				type:"POST",		
				data: meetVOPostTemp,
				success:function(data){
					var jsonData = JSON.parse(data);
					ajaxSetTable(jsonData);
				}
			});
		}
}
var changeQueryTitle = function(dom)
{
	meetVO.queryTitle=$("#queryTitle").val();
	meetVO.currPage = 1;
	var meetVOPostTemp={
			"meetVO.queryTitle":meetVO.queryTitle,
			"meetVO.startTimeSort":meetVO.startTimeSort,
			"meetVO.query_start_time_start":meetVO.query_start_time_start,
			"meetVO.query_start_time_end":meetVO.query_start_time_end,
			"meetVO.pageCount":meetVO.pageCount,
			"meetVO.currPage":meetVO.currPage,
			"meetVO.pageSize":meetVO.pageSize,
			"meetVO.totalCount":meetVO.totalCount
	}
	$.ajax({
		url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type:"POST",		
		data: meetVOPostTemp,
		success:function(data){
			var jsonData = JSON.parse(data);
			ajaxSetTable(jsonData);
		}
	});
}

var changTimeSort = function()
{
	meetVO.startTimeSort = $("#querySort").val();
	meetVO.currPage = 1;
	var meetVOPostTemp={
			"meetVO.queryTitle":meetVO.queryTitle,
			"meetVO.startTimeSort":meetVO.startTimeSort,
			"meetVO.query_start_time_start":meetVO.query_start_time_start,
			"meetVO.query_start_time_end":meetVO.query_start_time_end,
			"meetVO.pageCount":meetVO.pageCount,
			"meetVO.currPage":meetVO.currPage,
			"meetVO.pageSize":meetVO.pageSize,
			"meetVO.totalCount":meetVO.totalCount
	}
	$.ajax({
		url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type:"POST",		
		data: meetVOPostTemp,
		success:function(data){
			var jsonData = JSON.parse(data);
			ajaxSetTable(jsonData);
		}
	});
}