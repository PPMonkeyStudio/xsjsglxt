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
	policemanOutTimesQuery.policemanName = $('#queryPolicemanName').value;
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
		}
	});
}