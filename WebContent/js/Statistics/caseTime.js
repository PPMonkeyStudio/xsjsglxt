/**
 * 
 */

var queryCaseTemp = {
	caseTimeStart : '',
	caseTimeEnd : '',
	firstCategory : '',
	secondCategory : ''
}

var loadCase = function() {
	$('#caseContent').hide();
	$('#loadingLayerCase').show();
	queryCaseTemp.firstCategory = $('#firstCase').val();
	if ($('#secondCase') != null) {
		queryCaseTemp.secondCategory = $('#secondCase').val();
	}
	queryCaseTemp.caseTimeStart = $('#timeStartCase').val();
	queryCaseTemp.caseTimeEnd = $('#timeEndCase').val();
	var queryCase = {
		'caseTimeVO.caseTimeStart' : queryCaseTemp.caseTimeStart,
		'caseTimeVO.caseTimeEnd' : queryCaseTemp.caseTimeEnd,
		'caseTimeVO.firstCategory' : queryCaseTemp.firstCategory,
		'caseTimeVO.secondCategory' : queryCaseTemp.secondCategory
	};
	$.ajax({
		url : "/xsjsglxt/statistics/Statistics_caseTime",
		type : "POST",
		data : queryCase,
		success : function(data) {
			if (data != "没有案件记录") {
				caseTime.caseList = JSON.parse(data);
				highLightShow();
			} else {
				caseTime.caseList = {};
				highLightShow();
			}
			$('#loadingLayerCase').hide();
			$('#caseContent').show();
		}
	});
}
