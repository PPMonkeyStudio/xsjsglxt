/**
 * 
 */
var stasticsVue;
var queryConditionTemp = {
	'queryName' : '',
	'queryTimeStart' : '',
	'queryTimeEnd' : ''
}
$(function() {
	$('#searchInput').val("");
	$('#timeStart').val("");
	$('#timeEnd').val("");
	stasticsVue = new Vue({
		el : '#tableContent',
		data : {
			timeDTOList : {}
		}
	});
	loadData();
})

var queryData = function() {
	queryConditionTemp.queryName = $('#searchInput').val();
	queryConditionTemp.queryTimeStart = $('#timeStart').val();
	queryConditionTemp.queryTimeEnd = $('#timeEnd').val();
	loadData();
}
var loadData = function() {
	$('#tableContent').hide();
	$('#loadingLayer').show();
	var queryCondition = {
		'schedulingTimeVO.queryName' : queryConditionTemp.queryName,
		'schedulingTimeVO.queryTimeStart' : queryConditionTemp.queryTimeStart,
		'schedulingTimeVO.queryTimeEnd' : queryConditionTemp.queryTimeEnd
	}
	$.ajax({
		type : 'POST',
		url : '/xsjsglxt/scheduling/Scheduling_schedulingStastics',
		data : queryCondition,
		success : function(returnData) {
			stasticsVue.timeDTOList = JSON.parse(returnData).timeDTOList;
			$('#loadingLayer').hide();
			$('#tableContent').show();
		}
	})
}
var intoScheduling = function() {
	window.location.href = "/xsjsglxt/scheduling/Scheduling_page_list";
}