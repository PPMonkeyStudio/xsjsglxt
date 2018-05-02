/**
 * 
 */
var meetVO = {
	"queryTitle" : " ",
	"startTimeSort" : "desc",
	"query_start_time_start" : "",
	"query_start_time_end" : "",
	"queryMeetingContent" : "",
	"pageCount" : 0,
	"currPage" : 1,
	"pageSize" : 10,
	"totalCount" : 0
}

var setPage = function(pageCount, currPage, pageSize, totalCount) {
	meetVO.pageCount = pageCount;
	meetVO.currPage = currPage;
	meetVO.pageSize = pageSize;
	meetVO.totalCount = totalCount;
}

var setQuery = function(queryTitle, startTimeSort, query_start_time_start,
		query_start_time_end) {
	meetVO.queryTitle = queryTitle;
	meetVO.startTimeSort = startTimeSort;
	meetVO.query_start_time_start = query_start_time_start;
	meetVO.query_start_time_end = query_start_time_end;
}

window.onload = function() {
	loadData();
}

var loadData = function() {

	$("#query_start_time_start").val("");
	$("#query_start_time_end").val("");
	var meetVOPostTemp = {
		"meetVO.queryTitle" : meetVO.queryTitle,
		"meetVO.startTimeSort" : meetVO.startTimeSort,
		"meetVO.query_start_time_start" : meetVO.query_start_time_start,
		"meetVO.query_start_time_end" : meetVO.query_start_time_end,
		"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
		"meetVO.pageCount" : meetVO.pageCount,
		"meetVO.currPage" : meetVO.currPage,
		"meetVO.pageSize" : meetVO.pageSize,
		"meetVO.totalCount" : meetVO.totalCount
	}
	$.ajax({
		url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type : "POST",
		data : meetVOPostTemp,
		success : function(data) {
			var jsonData = JSON.parse(data);
			ajaxSetTable(jsonData);
		}
	});
}

var ajaxSetTable = function(jsonData) {

	setPage(jsonData.pageCount, jsonData.currPage, jsonData.pageSize,
			jsonData.totalCount);
	$("#currPage").html(jsonData.currPage);
	$("#totalPage").html(jsonData.pageCount);
	var tableContent = "";
	for (var i = 0; i < jsonData.meetDTO.length; i++) {
		tableContent = tableContent
				+ "<tr id='"
				+ jsonData.meetDTO[i].meeting_id
				+ "'  onclick='updateMeetingRecords(this)'>"
				+ "<td>"
				+ jsonData.meetDTO[i].meeting_start_time
				+ "</td>"
				+ "<td>"
				+ jsonData.meetDTO[i].meeting_title
				+ "</td>"
				+ "<td>"
				+ jsonData.meetDTO[i].meeting_theme
				+ "</td>"
				+ "<td>"
				+ jsonData.meetDTO[i].meeting_compere
				+ "</td>"
				+ "<td>"
				+ jsonData.meetDTO[i].meeting_end_time
				+ "</td>"
				+ "<td><div class='dropdown'><i class='dropdown-toggle fa fa-angle-double-down pageOperation'  data-toggle='dropdown' aria-hidden='true' aria-haspopup=true' aria-expanded='false'></i>"
				+ "<ul class='dropdown-menu' aria-labelledby='dLabe' style='text-align:center; min-width: 100px;'>"
				+ "<li id='"
				+ jsonData.meetDTO[i].meeting_id
				+ "' onclick='exportMeetingRecord(this)' class='pageOperation'><a>导出</a></li>"
				+ "<li id='"
				+ jsonData.meetDTO[i].meeting_id
				+ "'  onclick='updateMeetingRecords(this)' class='pageOperation'><a>修改</a></li>"
				+ "<li id='"
				+ jsonData.meetDTO[i].meeting_id
				+ "' onclick='deleteMeetingRecords(this)'  class='pageOperation'><a>删除</a></li>"
				+ "</ul></div></td>" + "</tr>"
	}
	$("#showList").html(tableContent);
	hideLoading();
}

var showLoading = function() {
	$("#contentDiv").hide();
	$("#loadingLayer").show();
}
var hideLoading = function() {
	$("#loadingLayer").hide();
	$("#contentDiv").show();
}
var skipToIndexPage = function() {
	if (meetVO.currPage == 1) {
		toastr.error("当前已经是首页");
	} else {
		showLoading();
		meetVO.currPage = 1;
		var meetVOPostTemp = {
			"meetVO.queryTitle" : meetVO.queryTitle,
			"meetVO.startTimeSort" : meetVO.startTimeSort,
			"meetVO.query_start_time_start" : meetVO.query_start_time_start,
			"meetVO.query_start_time_end" : meetVO.query_start_time_end,
			"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
			"meetVO.pageCount" : meetVO.pageCount,
			"meetVO.currPage" : meetVO.currPage,
			"meetVO.pageSize" : meetVO.pageSize,
			"meetVO.totalCount" : meetVO.totalCount
		}
		$.ajax({
			url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
			type : "POST",
			data : meetVOPostTemp,
			success : function(data) {
				var jsonData = JSON.parse(data);
				ajaxSetTable(jsonData);
			}
		});
	}
}

var skipToPrimaryPage = function() {
	if (meetVO.currPage == 1) {
		toastr.error("已经是第一页");
	} else {
		showLoading();
		meetVO.currPage = ++meetVO.currPage;
		var meetVOPostTemp = {
			"meetVO.queryTitle" : meetVO.queryTitle,
			"meetVO.startTimeSort" : meetVO.startTimeSort,
			"meetVO.query_start_time_start" : meetVO.query_start_time_start,
			"meetVO.query_start_time_end" : meetVO.query_start_time_end,
			"meetVO.pageCount" : meetVO.pageCount,
			"meetVO.currPage" : meetVO.currPage,
			"meetVO.pageSize" : meetVO.pageSize,
			"meetVO.totalCount" : meetVO.totalCount
		}
		$.ajax({
			url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
			type : "POST",
			data : meetVOPostTemp,
			success : function(data) {
				var jsonData = JSON.parse(data);
				ajaxSetTable(jsonData);
			}
		});
	}
}

var skipToNextPage = function() {
	if (meetVO.currPage == meetVO.pageCount) {
		toastr.error("已经是最后一页");
	} else {
		showLoading();
		meetVO.currPage = --meetVO.currPage;
		var meetVOPostTemp = {
			"meetVO.queryTitle" : meetVO.queryTitle,
			"meetVO.startTimeSort" : meetVO.startTimeSort,
			"meetVO.query_start_time_start" : meetVO.query_start_time_start,
			"meetVO.query_start_time_end" : meetVO.query_start_time_end,
			"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
			"meetVO.pageCount" : meetVO.pageCount,
			"meetVO.currPage" : meetVO.currPage,
			"meetVO.pageSize" : meetVO.pageSize,
			"meetVO.totalCount" : meetVO.totalCount
		}
		$.ajax({
			url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
			type : "POST",
			data : meetVOPostTemp,
			success : function(data) {
				var jsonData = JSON.parse(data);
				ajaxSetTable(data);
			}
		});
	}
}
var skipToLastPage = function() {
	if (meetVO.currPage == meetVO.pageCount) {
		toastr.error("已经是最后一页");
	} else {
		showLoading();
		meetVO.currPage = meetVO.pageCount;
		var meetVOPostTemp = {
			"meetVO.queryTitle" : meetVO.queryTitle,
			"meetVO.startTimeSort" : meetVO.startTimeSort,
			"meetVO.query_start_time_start" : meetVO.query_start_time_start,
			"meetVO.query_start_time_end" : meetVO.query_start_time_end,
			"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
			"meetVO.pageCount" : meetVO.pageCount,
			"meetVO.currPage" : meetVO.currPage,
			"meetVO.pageSize" : meetVO.pageSize,
			"meetVO.totalCount" : meetVO.totalCount
		}
		$.ajax({
			url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
			type : "POST",
			data : meetVOPostTemp,
			success : function(data) {
				var jsonData = JSON.parse(data);
				ajaxSetTable(jsonData);
			}
		});
	}
}

var skipToArbitrarilyPage = function() {
	if ($("#skipPage").val() <= 0 || $("#skipPage").val() > meetVO.pageCount) {
		toastr.error("不存在此页");
	} else {
		showLoading();
		meetVO.currPage = $("#skipPage").val();
		var meetVOPostTemp = {
			"meetVO.queryTitle" : meetVO.queryTitle,
			"meetVO.startTimeSort" : meetVO.startTimeSort,
			"meetVO.query_start_time_start" : meetVO.query_start_time_start,
			"meetVO.query_start_time_end" : meetVO.query_start_time_end,
			"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
			"meetVO.pageCount" : meetVO.pageCount,
			"meetVO.currPage" : meetVO.currPage,
			"meetVO.pageSize" : meetVO.pageSize,
			"meetVO.totalCount" : meetVO.totalCount
		}
		$.ajax({
			url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
			type : "POST",
			data : meetVOPostTemp,
			success : function(data) {
				var jsonData = JSON.parse(data);
				ajaxSetTable(jsonData);
			}
		});
	}
}
var changeQueryTitle = function(dom) {
	showLoading();
	meetVO.queryTitle = $("#queryTitle").val();
	meetVO.currPage = 1;
	var meetVOPostTemp = {
		"meetVO.queryTitle" : meetVO.queryTitle,
		"meetVO.startTimeSort" : meetVO.startTimeSort,
		"meetVO.query_start_time_start" : meetVO.query_start_time_start,
		"meetVO.query_start_time_end" : meetVO.query_start_time_end,
		"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
		"meetVO.pageCount" : meetVO.pageCount,
		"meetVO.currPage" : meetVO.currPage,
		"meetVO.pageSize" : meetVO.pageSize,
		"meetVO.totalCount" : meetVO.totalCount
	}
	$.ajax({
		url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type : "POST",
		data : meetVOPostTemp,
		success : function(data) {
			var jsonData = JSON.parse(data);
			ajaxSetTable(jsonData);
		}
	});
}

var changTimeSort = function() {
	showLoading();
	meetVO.startTimeSort = $("#querySort").val();
	meetVO.currPage = 1;
	var meetVOPostTemp = {
		"meetVO.queryTitle" : meetVO.queryTitle,
		"meetVO.startTimeSort" : meetVO.startTimeSort,
		"meetVO.query_start_time_start" : meetVO.query_start_time_start,
		"meetVO.query_start_time_end" : meetVO.query_start_time_end,
		"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
		"meetVO.pageCount" : meetVO.pageCount,
		"meetVO.currPage" : meetVO.currPage,
		"meetVO.pageSize" : meetVO.pageSize,
		"meetVO.totalCount" : meetVO.totalCount
	}
	$.ajax({
		url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type : "POST",
		data : meetVOPostTemp,
		success : function(data) {
			var jsonData = JSON.parse(data);
			ajaxSetTable(jsonData);
		}
	});
}
var changeContent = function(event) {
	showLoading();
	meetVO.queryMeetingContent = event.value;
	meetVO.currPage = 1;
	var meetVOPostTemp = {
		"meetVO.queryTitle" : meetVO.queryTitle,
		"meetVO.startTimeSort" : meetVO.startTimeSort,
		"meetVO.query_start_time_start" : meetVO.query_start_time_start,
		"meetVO.query_start_time_end" : meetVO.query_start_time_end,
		"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
		"meetVO.pageCount" : meetVO.pageCount,
		"meetVO.currPage" : meetVO.currPage,
		"meetVO.pageSize" : meetVO.pageSize,
		"meetVO.totalCount" : meetVO.totalCount
	}
	$.ajax({
		url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type : "POST",
		data : meetVOPostTemp,
		success : function(data) {
			var jsonData = JSON.parse(data);
			ajaxSetTable(jsonData);
		}
	});
}

var changeStartTime = function(dom) {
	showLoading();
	if (dom.id == "query_start_time_start") {
		meetVO.query_start_time_start = dom.value;
	} else {
		meetVO.query_start_time_end = dom.value;
	}
	meetVO.currPage = 1;
	var meetVOPostTemp = {
		"meetVO.queryTitle" : meetVO.queryTitle,
		"meetVO.startTimeSort" : meetVO.startTimeSort,
		"meetVO.query_start_time_start" : meetVO.query_start_time_start,
		"meetVO.query_start_time_end" : meetVO.query_start_time_end,
		"meetVO.queryMeetingContent" : meetVO.queryMeetingContent,
		"meetVO.pageCount" : meetVO.pageCount,
		"meetVO.currPage" : meetVO.currPage,
		"meetVO.pageSize" : meetVO.pageSize,
		"meetVO.totalCount" : meetVO.totalCount
	}
	$.ajax({
		url : "/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type : "POST",
		data : meetVOPostTemp,
		success : function(data) {
			var jsonData = JSON.parse(data);
			ajaxSetTable(jsonData);
		}
	});
}
