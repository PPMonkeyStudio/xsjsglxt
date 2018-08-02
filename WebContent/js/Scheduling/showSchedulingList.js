/**
 * 
 */
var schedulingVue = "";
var queryConditionTemp = {
	'currPage' : 1,
	'pageSize' : 10,
	'totalPage' : '',
	'totalCount' : '',
	'query_name' : '',
	'queryTimeStart' : '',
	'queryTimeEnd' : ''
}
window.onload = function() {
	$('input').val("");
	$('input[type="checkbox"]').attr("checked", false);
	var currDate = new Date();
	var currMonth = currDate.getMonth() + 1;
	if (currMonth <= 10) {
		currMonth = '0' + currMonth;
	}
	queryConditionTemp.queryTimeStart = currDate.getFullYear() + '-'
		+ currMonth + '-01';
	queryConditionTemp.queryTimeEnd = currDate.getFullYear() + '-' + currMonth
		+ '-31';
	$('#timeStart').val(currDate.getFullYear() + '-' + currMonth + '-01');
	$('#timeEnd').val(currDate.getFullYear() + '-' + currMonth + '-31');
	schedulingVue = new Vue({
		el : '#tableContent',
		data : {
			vo : '',
			nowDate : getNowFormatDate()
		}
	});
	loadScheduling();
}
var changeSort = function() {
	queryConditionTemp.query_name = $('#searchInput').val();
	queryConditionTemp.queryTimeStart = $('#timeStart').val();
	queryConditionTemp.queryTimeEnd = $('#timeEnd').val();
	loadScheduling();
}
var skipToArbitrarilyPage = function() {
	if ($('#skipPage').val() >= 1
		&& $('#skipPage').val() <= schedulingVue.vo.totalPage) {
		queryConditionTemp.currPage = $('#skipPage').val();
		loadScheduling();
	} else {
		toastr.error("没有这一页");
	}
}
var skipToIndexPage = function() {
	if (schedulingVue.vo.currPage <= 1) {
		toastr.error("已经是第一页");
	} else {
		queryConditionTemp.currPage = 1
		loadScheduling();
	}
}
var skipToPrimaryPage = function() {
	if (schedulingVue.vo.currPage <= 1) {
		toastr.error("没有上一页了哦");
	} else {
		queryConditionTemp.currPage = --schedulingVue.vo.currPage;
		loadScheduling();
	}
}
var skipToNextPage = function() {
	if (schedulingVue.vo.currPage >= schedulingVue.vo.totalPage) {
		toastr.error("没有下一页了哦");
	} else {
		queryConditionTemp.currPage = ++schedulingVue.vo.currPage;
		loadScheduling();
	}
}
var skipToLastPage = function() {
	if (schedulingVue.vo.currPage >= schedulingVue.vo.totalPage) {
		toastr.error("已经是最后一页");
	} else {
		queryConditionTemp.currPage = schedulingVue.vo.totalPage;
		loadScheduling();
	}
}
var loadScheduling = function() {
	$('#tableContent').hide();
	$('#loadingLayer').show();
	$('input[type="checkbox"]').prop("checked", false);
	var queryCondition = {
		'schedulingListVO.currPage' : queryConditionTemp.currPage,
		'schedulingListVO.pageSize' : queryConditionTemp.pageSize,
		'schedulingListVO.totalPage' : queryConditionTemp.totalPage,
		'schedulingListVO.totalCount' : queryConditionTemp.totalCount,
		'schedulingListVO.query_name' : queryConditionTemp.query_name,
		'schedulingListVO.queryTimeStart' : queryConditionTemp.queryTimeStart,
		'schedulingListVO.queryTimeEnd' : queryConditionTemp.queryTimeEnd
	}
	$.ajax({
		url : '/xsjsglxt/scheduling/Scheduling_schedulingList',
		type : 'POST',
		data : queryCondition,
		success : function(data) {
			schedulingVue.vo = JSON.parse(data);
			$('#loadingLayer').hide();
			$('#tableContent').show();
		}
	});
}



//Util

//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator1 + month + seperator1 + strDate;
	return currentdate;
}