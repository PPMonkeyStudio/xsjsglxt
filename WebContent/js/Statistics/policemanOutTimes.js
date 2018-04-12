/**
 * 
 */
var policemanOutTimesQueryTemp = {
	policemanName : "",
	outStartTime : '',
	outEndTime : '',
	currPage : 1,
	totalPage : '',
	totalCount : '',
	pageSize : '10'
};
var policemanOut;
var caseTime;
window.onload = function() {
	policemanOut = new Vue({
		el : "#fieldStatistics",
		data : {
			'policemanOutVO' : {}
		}
	});
	caseTime = new Vue({
		el : "#caseContent",
		data : {
			'caseList' : {}
		},
		updated : function() {
			highLightShow();
		} // 渲染完页面之后执行的代码
		,
		mounted : function() {
			// 第一次渲染页面执行的代码
		}

	});
	cleanInput();
	loadPoliceman();
}
var loadPolicemanCondition = function() {
	policemanOutTimesQueryTemp.currPage = 1;
	loadPoliceman();
}
var skipToIndexPage = function() {
	if (policemanOut.policemanOutVO.currPage <= 1) {
		toastr.error("已经是第一页");
	} else {
		policemanOutTimesQueryTemp.currPage = 1
		loadPoliceman();
	}
}
var skipToPrimaryPage = function() {
	if (policemanOut.policemanOutVO.currPage <= 1) {
		toastr.error("没有上一页了哦");
	} else {
		policemanOutTimesQueryTemp.currPage = --policemanOut.policemanOutVO.currPage;
		loadPoliceman();
	}
}
var skipToNextPage = function() {
	if (policemanOut.policemanOutVO.currPage >= policemanOut.policemanOutVO.totalPage) {
		toastr.error("没有下一页了哦");
	} else {
		policemanOutTimesQueryTemp.currPage = ++policemanOut.policemanOutVO.currPage;
		loadPoliceman();
	}
}
var skipToLastPage = function() {
	if (policemanOut.policemanOutVO.currPage >= policemanOut.policemanOutVO.totalPage) {
		toastr.error("已经是最后一页");
	} else {
		policemanOutTimesQueryTemp.currPage = policemanOut.policemanOutVO.totalPage;
		loadPoliceman();
	}
}
var skipToArbitrarilyPage = function() {
	console.log($('#skipPage').val());
	if ($('#skipPage').val() >= 1
			&& $('#skipPage').val() <= policemanOut.policemanOutVO.totalPage) {
		policemanOutTimesQueryTemp.currPage = $('#skipPage').val();
		loadPoliceman();
	} else {
		toastr.error("没有这一页");
	}
}

var loadPoliceman = function() {
	$('#fieldStatistics').hide();
	$('#loadingLayer').show();
	policemanOutTimesQueryTemp.policemanName = $('#queryPolicemanName').val();
	policemanOutTimesQueryTemp.outStartTime = $('#timeStart').val();
	policemanOutTimesQueryTemp.outEndTime = $('#timeEnd').val();
	var policemanOutTimesQuery = {
		"outTimeVO.timeStart" : policemanOutTimesQueryTemp.outStartTime,
		"outTimeVO.timeEnd" : policemanOutTimesQueryTemp.outEndTime,
		"outTimeVO.policemanName" : policemanOutTimesQueryTemp.policemanName,
		"outTimeVO.currPage" : policemanOutTimesQueryTemp.currPage,
		"outTimeVO.currPage" : policemanOutTimesQueryTemp.currPage,
		"outTimeVO.totalCount" : policemanOutTimesQueryTemp.totalCount,
		"outTimeVO.pageSize" : policemanOutTimesQueryTemp.pageSize
	}
	$.ajax({
		url : "/xsjsglxt/statistics/Statistics_policemanOutTime",
		type : "post",
		data : policemanOutTimesQuery,
		success : function(data) {
			if (data != "不存在此警员记录") {
				console.log(data);
				var result = JSON.parse(data);
				policemanOut.policemanOutVO = result;
			} else {
				policemanOut.policemanOutVO = {};
			}
			$('#loadingLayer').hide();
			$('#fieldStatistics').show();
		}
	});
}

var cleanInput = function() {
	$('input').val("");
	$('#firstCase').val("所有案件");
	$('#policeStation').val("");
}