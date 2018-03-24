/**
 * 
 */
var allPageVue;
var queryConditionTemp = {
	"currPage" : "1",
	"totalPage" : "",
	"pageCount" : "10",
	"totalCount" : "",
	"inPoliceTimeSort" : "desc",
	"policemanName" : "",
	"policemanSex" : "",
	"politicalStatus" : ""
}
window.onload = function() {
	allPageVue = new Vue({
		el : '#allPage',
		data : {
			currPage : '1',
			totalPage : '',
			pageCount : '10',
			totalCount : '',
			policemans : ''
		}
	});
	loadData();
}

var changeSort = function(event) {
	queryConditionTemp.inPoliceTimeSort = event.value;
	loadData();
}

var changeStatus = function(event) {
	queryConditionTemp.politicalStatus = event.value;
	loadData();
}
var changeSex = function(event) {
	queryConditionTemp.policemanSex = event.value;
	loadData();
}
var changeName = function(event) {
	queryConditionTemp.policemanName = event.value;
	loadData();
}

var loadData = function() {
	$('#mainPanel').hide();
	$('#loadingLayer').show();
	var queryCondition = {
		"policemanVO.currPage" : queryConditionTemp.currPage,
		"policemanVO.totalPage" : queryConditionTemp.totalPage,
		"policemanVO.pageCount" : queryConditionTemp.pageCount,
		"policemanVO.totalCount" : queryConditionTemp.totalCount,
		"policemanVO.inPoliceTimeSort" : queryConditionTemp.inPoliceTimeSort,
		"policemanVO.policemanName" : queryConditionTemp.policemanName,
		"policemanVO.policemanSex" : queryConditionTemp.policemanSex,
		"policemanVO.politicalStatus" : queryConditionTemp.politicalStatus,
	}
	$.ajax({
		url : '/xsjsglxt/team/Staff_getPolicemansByPage',
		type : 'POST',
		data : queryCondition,
		success : function(data) {
			var result = JSON.parse(data);
			allPageVue.policemans = result.policemans;
			allPageVue.currPage = result.currPage;
			allPageVue.totalPage = result.totalPage;
			allPageVue.pageCount = result.pageCount;
			allPageVue.totalCount = result.totalCount;
			$('#loadingLayer').hide();
			$('#mainPanel').show();
		}
	});

}