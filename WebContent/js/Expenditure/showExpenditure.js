/**
 * 
 */

var queryTemp = {
	'searchStartTime' : '',
	'searchEndTime' : '',
	'searchDetachment' : '',
	'searchType' : '',
	'searchName' : '',
	'searchSort' : 'desc',
	'currPage' : '1',
}

var expenditureVue;

$(function() {
	$('input').val("");
	expenditureVue = new Vue({
		el : '#allInformation',
		data : {
			showData : '',
		}
	});
	loadData();
})

function loadData() {
	$('#hideBody').hide();
	$('#loadingLayer').show();
	var queryData = {
		'expenditureVO.searchStartTime' : queryTemp.searchStartTime,
		'expenditureVO.searchEndTime' : queryTemp.searchEndTime,
		'expenditureVO.searchDetachment' : queryTemp.searchDetachment,
		'expenditureVO.searchType' : queryTemp.searchType,
		'expenditureVO.searchName' : queryTemp.searchName,
		'expenditureVO.searchSort' : queryTemp.searchSort,
		'expenditureVO.currPage' : queryTemp.currPage,
	}
	$.ajax({
		url : '/xsjsglxt/statistics/Expenditure_searchExpenditureByPage',
		type : 'POST',
		data : queryData,
		success : function(data) {
			var returnData = JSON.parse(data);
			expenditureVue.showData = returnData;
			$('#loadingLayer').hide();
			$('#hideBody').show();
		}
	})
}

function changeSearch(event) {
	queryTemp.searchStartTime = $('#timeStart').val();
	queryTemp.searchEndTime = $('#timeEnd').val();
	queryTemp.searchDetachment = $('#_detachment').val();
	queryTemp.searchSort = $('#_sort').val();
	queryTemp.searchName = $('#_name').val();
	queryTemp.searchType = $('#_type').val();
	loadData();
}

function skipToIndexPage() {
	queryTemp.currPage = 1;
	loadData();
}
function skipToPrimaryPage() {
	if (queryTemp.currPage == 1) {
		toastr.error("已经没有上一页了");
	} else {
		queryTemp.currPage = queryTemp.currPage - 1;
		loadData();
	}
}
function skipToNextPage() {
	if (queryTemp.currPage == expenditureVue.showData.totalPage) {
		toastr.error("已经没有下一页了");
	} else {
		queryTemp.currPage = queryTemp.currPage + 1;
		loadData();
	}
}
function skipToLastPage() {
	queryTemp.currPage = expenditureVue.showData.totalPage;
	loadData();
}
function skipToArbitrarilyPage() {
	if ($('#skipPage').val() > expenditureVue.showData.totalPage
		|| $('#skipPage').val() < 1) {
		toastr.error("不存在此页");
	} else {
		queryTemp.currPage = $('#skipPage').val();
		loadData();
	}
}
