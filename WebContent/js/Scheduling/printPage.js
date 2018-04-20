/**
 * 
 */
var queryConditionTemp = {
	'currPage' : 1,
	'pageSize' : 10,
	'totalPage' : '',
	'totalCount' : '',
	'query_name' : '',
	'queryTimeStart' : '',
	'queryTimeEnd' : ''
}
window.onload = function() {
	var url = window.location.href;
	var parameterAll = url.substring(url.indexOf('?') + 1);
	var parameterArray = parameterAll.split('&');
	queryConditionTemp.currPage = parameterArray[0].split('=')[1];
	queryConditionTemp.queryTimeStart = parameterArray[1].split('=')[1];
	queryConditionTemp.queryTimeEnd = parameterArray[2].split('=')[1];
	queryConditionTemp.query_name = parameterArray[3].split('=')[1];
	schedulingVue = new Vue({
		el : '#tableContent',
		data : {
			vo : ''
		}
	});
	loadScheduling();
}
var loadScheduling = function() {
	var queryCondition = {
		'schedulingListVO.currPage' : queryConditionTemp.currPage,
		'schedulingListVO.pageSize' : queryConditionTemp.pageSize,
		'schedulingListVO.totalPage' : queryConditionTemp.totalPage,
		'schedulingListVO.totalCount' : queryConditionTemp.totalCount,
		'schedulingListVO.query_name' : queryConditionTemp.query_name,
		'schedulingListVO.queryTimeStart' : queryConditionTemp.queryTimeStart,
		'schedulingListVO.queryTimeEnd' : queryConditionTemp.queryTimeEnd
	}
	$.ajax({
		url : '/xsjsglxt/scheduling/Scheduling_schedulingList',
		type : 'POST',
		data : queryCondition,
		success : function(data) {
			schedulingVue.vo = JSON.parse(data);
			console.log(schedulingVue.currPage);
		}
	});
}