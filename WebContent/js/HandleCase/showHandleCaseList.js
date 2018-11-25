/**
 * 
 */
var queryDataTemp = {
	currPage : 1,
	pageSize : 10,
	searchCaseName : '',
	searchMainPolice : '',
	searchAssistantPolice : '',
	searchMiddleCaptaion : '',
	searchCaseState : ''
}
var caseVue;
$(function() {
	caseVue = new Vue({
		el : '#contentDiv',
		data : {
			handleCaseVO : ''
		}
	});
	loadData();
})

function goSuspectList() {
	window.location.href = "/xsjsglxt/case/DealCase_intoSuspectList";
}

function loadData() {
	$('#bodyDiv').hide();
	$('#loadingLayer').show();
	var queryData = {
		'handleCaseListVO.currPage' : queryDataTemp.currPage,
		'handleCaseListVO.pageSize' : queryDataTemp.pageSize,
		'handleCaseListVO.searchCaseName' : queryDataTemp.searchCaseName,
		'handleCaseListVO.searchMainPolice' : queryDataTemp.searchMainPolice,
		'handleCaseListVO.searchAssistantPolice' : queryDataTemp.searchAssistantPolice,
		'handleCaseListVO.searchMiddleCaptaion' : queryDataTemp.searchMiddleCaptaion,
		'handleCaseListVO.searchCaseState' : queryDataTemp.searchCaseState
	}
	$.ajax({
		url : '/xsjsglxt/case/DealCase_pageList',
		type : 'POST',
		data : queryData,
		success : function(data) {
			caseVue.handleCaseVO = JSON.parse(data);
			$('#loadingLayer').hide();
			$('#bodyDiv').show();
		}
	});
}

var skipToIndexPage = function() {
	if (queryDataTemp.currPage == 1) {
		toastr.error("已经是最后一页");
	} else {
		queryDataTemp.currPage = 1;
		loadData();
	}

}
var skipToNextPage = function() {
	if (queryDataTemp.currPage == caseVue.handleCaseVO.totalPage) {
		toastr.error("已经没有下一页");
	} else {
		queryDataTemp.currPage = queryDataTemp.currPage + 1;
		loadData();
	}

}
var skipToPrimaryPage = function() {
	if (queryDataTemp.currPage == 1) {
		toastr.error("已经没有上一页");
	} else {
		queryDataTemp.currPage = queryDataTemp.currPage - 1;
		loadData();
	}

}
var skipToLastPage = function() {
	if (queryDataTemp.currPage == caseVue.handleCaseVO.totalPage) {
		toastr.error("已经是最后一页");
	} else {
		queryDataTemp.currPage = caseVue.handleCaseVO.totalPage;
		loadData();
	}

}

var skipToArbitrarilyPage = function() {
	if ($('#skipPage').val() > caseVue.handleCaseVO.totalPage
			|| $('#skipPage').val() < 1) {
		toastr.error("不存在此页");
	} else {
		queryDataTemp.currPage = $('#skipPage').val();
		loadData();
	}
}

function changeSort() {
	queryDataTemp.searchCaseName = $('#caseName').val();
	queryDataTemp.searchMainPolice = $('#mainPolice').val();
	queryDataTemp.searchAssistantPolice = $('#assistantPolice').val();
	queryDataTemp.searchMiddleCaptaion = $('#middleCaptain').val();
	queryDataTemp.searchCaseState = $('#caseState').val();
	loadData();
}
