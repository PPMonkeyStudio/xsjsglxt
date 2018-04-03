/**
 * 
 */
var policemanOutTimesQuery = {
	policemanName : ""
};
var policemanOut;
window.onload = function() {
	policemanOut = new Vue({
		el : "#fieldStatistics",
		data : {
			'policemanList' : {}
		}
	});
	loadPoliceman();
}

var loadPoliceman = function() {
	$('#fieldStatistics').hide();
	$('#loadingLayer').show();
	policemanOutTimesQuery.policemanName = $('#queryPolicemanName').val();
	$.ajax({
		url : "/xsjsglxt/statistics/Statistics_policemanOutTime",
		type : "post",
		data : policemanOutTimesQuery,
		success : function(data) {
			if (data != "不存在此警员记录") {
				console.log(data);
				var result = JSON.parse(data);
				policemanOut.policemanList = result;
				$('#queryPolicemanName').val(
						policemanOutTimesQuery.policemanName);
			} else {
				policemanOut.policemanList = {};
				$('#queryPolicemanName').val(
						policemanOutTimesQuery.policemanName);
			}
			$('#loadingLayer').hide();
			$('#fieldStatistics').show();
		}
	});
}