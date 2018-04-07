/**
 * 
 */
var policemanOutTimesQueryTemp = {
	policemanName : "",
	outStartTime : '',
	outEndTime : ''
};
var policemanOut;
var caseTime;
window.onload = function() {
	policemanOut = new Vue({
		el : "#fieldStatistics",
		data : {
			'policemanList' : {}
		}
	});
	comparisonTime = new Vue({
		el : "#comparisonContent",
		data : {
			'comparisonList' : {}
		}
	});
	caseTime = new Vue({
		el : "#caseContent",
		data : {
			'caseList' : {}
		}
	});
	loadPoliceman();
}

var loadPoliceman = function() {
	cleanInput();
	$('#fieldStatistics').hide();
	$('#loadingLayer').show();
	policemanOutTimesQueryTemp.policemanName = $('#queryPolicemanName').val();
	policemanOutTimesQueryTemp.outStartTime = $('#timeStart').val();
	policemanOutTimesQueryTemp.outEndTime = $('#timeEnd').val();
	var policemanOutTimesQuery = {
		"outTimeVO.timeStart" : policemanOutTimesQueryTemp.outStartTime,
		"outTimeVO.timeEnd" : policemanOutTimesQueryTemp.outEndTime,
		"outTimeVO.policemanName" : policemanOutTimesQueryTemp.policemanName
	}
	$.ajax({
		url : "/xsjsglxt/statistics/Statistics_policemanOutTime",
		type : "post",
		data : policemanOutTimesQuery,
		success : function(data) {
			if (data != "不存在此警员记录") {
				console.log(data);
				var result = JSON.parse(data);
				policemanOut.policemanList = result;
			} else {
				policemanOut.policemanList = {};
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