/**
 * 
 */
var policemanOutTimesQuery = {
	policemanName : ""
};
window.onload = function() {
	loadPoliceman();
}

var policemanOut = new Vue({
	el : "#fieldStatistics",
	data : {
		'policemanList' : {}
	}
});
var loadPoliceman = function() {
	policemanOutTimesQuery.policemanName = $('#queryPolicemanName').value;
	$.ajax({
		url : "/xsjsglxt/statistics/Statistics_policemanOutTime",
		type : "post",
		data : policemanOutTimesQuery,
		success : function(data) {
			if (data != "不存在此警员记录") {
				var result = JSON.parse(data);
				policemanOut.policemanList = result;
			} else {
				policemanOut.policemanList = {};
			}
		}
	});
}