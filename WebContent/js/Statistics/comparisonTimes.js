/**
 * 
 */
var queryComparisonTemp = {
	'comparisonTimeStart' : '',
	'comparisonTimeEnd' : '',
	'comparisonPolicemanName' : ''
}
var comparisonTime;
var loadComparison = function() {
	$('#comparisonContent').hide();
	$('#loadingLayerComparison').show();
	queryComparisonTemp.comparisonTimeStart = $('#timeStartComparison').val();
	queryComparisonTemp.comparisonTimeEnd = $('#timeEndComparison').val();
	queryComparisonTemp.comparisonPolicemanName = $(
			'#queryPolicemanNameComparison').val();
	var queryComparison = {
		'comparisonTimeVO.comparisonTimeStart' : queryComparisonTemp.comparisonTimeStart,
		'comparisonTimeVO.comparisonTimeEnd' : queryComparisonTemp.comparisonTimeEnd,
		'comparisonTimeVO.comparisonPolicemanName' : queryComparisonTemp.comparisonPolicemanName
	}
	$.ajax({
		url : "/xsjsglxt/statistics/Statistics_policemanComparisonTime",
		type : "POST",
		data : queryComparison,
		success : function(data) {
			if (data != "不存在此警员记录") {
				console.log(data);
				var result = JSON.parse(data);
				comparisonTime.comparisonList = result;
			} else {
				comparisonTime.comparisonList = {};
			}
			$('#loadingLayerComparison').hide();
			$('#comparisonContent').show();
		}
	});
}