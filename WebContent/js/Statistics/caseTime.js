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
	queryCaseTemp.firstCategory = "";
	queryCaseTemp.secondCategory = "";
	caseTime.count = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
	queryCaseTemp.firstCategory = $('#firstCase').val();
	if ($('#secondCase') != null) {
		if ($('#firstCase').val() == '盗窃案' || $('#firstCase').val() == '抢夺案'
				|| $('#firstCase').val() == '抢劫案')
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
	var paichusuo = [ 'anyuanTime', 'chengjiaoTime', 'fenghuangTime',
			'houfuTime', 'dongDaTime', 'gaoKangTime', 'qingshanTime',
			'bayiTime', 'baiyuanTime', 'danjiangTime', 'liziyuanTime',
			'wupoxiaTime', 'qitaTime' ];
	$.ajax({
		url : "/xsjsglxt/statistics/Statistics_caseTime",
		type : "POST",
		data : queryCase,
		success : function(data) {
			if (data != "没有案件记录") {
				caseTime.caseList = JSON.parse(data);
				for (var i = 0; i < 13; i++) {
					for (var j = 0; j < caseTime.caseList.length; j++) {
						caseTime.count[i] = caseTime.count[i]
								+ caseTime.caseList[j][paichusuo[i]];
					}
				}
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
