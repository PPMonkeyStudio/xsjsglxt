/**
 * 
 */

var queryConditionTemp = {
	'currPage' : 1,
	'pageSize' : '',
	'totalPage' : '',
	'totalCount' : '',
	'queryContent' : '',
	'query_time_start' : '',
	'query_time_end' : '',
	'query_time_sort' : 'desc'
}
var letterVue;
window.onload = function() {
	$('#searchInput').val("");
	$('#timeStart').val("");
	$('#timeEnd').val("");
	$('#timeSort').val("");
	letterVue = new Vue({
		el : '#allInformation',
		data : {
			allData : {},
			letter_admin_power : ''
		}
	});
	loadData();
}

var skipToIndexPage = function() {
	if (queryConditionTemp.currPage == 1) {
		toastr.error("已经是最后一页");
	} else {
		queryConditionTemp.currPage = 1;
		loadData();
	}

}
var skipToNextPage = function() {
	if (queryConditionTemp.currPage == queryConditionTemp.totalPage) {
		toastr.error("已经没有下一页了");
	} else {
		queryConditionTemp.currPage = queryConditionTemp.currPage + 1;
		loadData();
	}

}
var skipToPrimaryPage = function() {
	if (queryConditionTemp.currPage == 1) {
		toastr.error("已经没有上一页了");
	} else {
		queryConditionTemp.currPage = queryConditionTemp.currPage - 1;
		loadData();
	}

}
var skipToLastPage = function() {
	if (queryConditionTemp.currPage == queryConditionTemp.totalPage) {
		toastr.error("已经是最后一页了");
	} else {
		queryConditionTemp.currPage = queryConditionTemp.totalPage
		loadData();
	}

}

var skipToArbitrarilyPage = function() {
	if ($('#skipPage').val() > queryConditionTemp.totalPage
		|| $('#skipPage').val() < 1) {
		toastr.error("不存在此页");
	} else {
		queryConditionTemp.currPage = $('#skipPage').val();
		loadData();
	}

}

var changeQuerySort = function() {
	queryConditionTemp.queryContent = $('#searchInput').val();
	queryConditionTemp.query_time_start = $('#timeStart').val();
	queryConditionTemp.query_time_end = $('#timeEnd').val();
	queryConditionTemp.query_time_sort = $('#timeSort').val();
	loadData();
}

var loadData = function() {
	$('#allInformation').hide();
	$('#loadingLayer').show();
	$('input[type="checkbox"]').prop("checked", false);
	var queryData = {
		'letterVO.currPage' : queryConditionTemp.currPage,
		'letterVO.pageSize' : queryConditionTemp.pageSize,
		'letterVO.totalPage' : queryConditionTemp.totalPage,
		'letterVO.totalCount' : queryConditionTemp.totalCount,
		'letterVO.queryContent' : queryConditionTemp.queryContent,
		'letterVO.query_time_start' : queryConditionTemp.query_time_start,
		'letterVO.query_time_end' : queryConditionTemp.query_time_end,
		'letterVO.query_time_sort' : queryConditionTemp.query_time_sort,
	}
	$.ajax({
		url : '/xsjsglxt/case/Handle_getLetterByPage',
		type : 'POST',
		data : queryData,
		success : function(data) {
			letterVue.allData = JSON.parse(data);
			queryConditionTemp.currPage = letterVue.allData.currPage;
			queryConditionTemp.pageSize = letterVue.allData.pageSize;
			queryConditionTemp.totalPage = letterVue.allData.totalPage;
			queryConditionTemp.totalCount = letterVue.allData.totalCount;
			letterVue.letter_admin_power = userPowerDTO.user_letter_power;
			$('#loadingLayer').hide();
			$('#allInformation').show();

		}
	});
}
var selectAll = function(event) {
	if (event.checked) {
		console.log("选中了");
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = true;
		}
	} else {
		console.log("没选中");
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = false;
		}
	}
}