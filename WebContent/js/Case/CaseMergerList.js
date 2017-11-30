var query_data = {
	"page_list_parallelInformation.pageIndex" : "1",
	"page_list_senceInformation.case_totalCategory" : "",
	"page_list_senceInformation.case_sonCategory" : "",
	"page_list_senceInformation.case_classify" : "",
	"page_list_senceInformation.case_makeTime" : "",
	"page_list_senceInformation.case_residence" : "",
	"page_list_senceInformation.case_concreteResidence" : "",
	"page_list_senceInformation.snece_inquestPerson" : "",
	"page_list_senceInformation.case_makeMeans" : "",
	"page_list_senceInformation.case_concreteMakeMeans" : "",
	"page_list_senceInformation.start_time" : "",
	"page_list_senceInformation.stop_time" : "",
};
//当前页面分页信息
var page_infomantion = {
	pageIndex : 1,
	totalRecords : 1,
	pageSize : 20,
	totalPages : 1,
	HavePrePage : false,
	HaveNextPage : false,
}

$(function() {
	get_ListParallelInformationByPageAndSearch(query_data);
})

function get_ListParallelInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Parallel_ListParallelInformationByPageAndSearch', data, function(xhr) {
		$('.case_table_info tbody').empty();
		var str = '';
		for (var len = 0; len < xhr.parallelList.length; len++) {
			var data_list = xhr.parallelList[len];
			str += '<tr>';
			str += '<td>' + (len + 1) + '</td>';
			str += '<td><a href="/xsjsglxt/case/Case_page_CaseDetails?id=' + data_list.sence.xsjsglxt_snece_id + '">' + data_list.sence.snece_inquestId + '</a></td>';
			str += '<td>' + data_list.case1.case_receivingAlarmDate + '</td>';
			str += '<td>' + data_list.case1.case_address + '</td>';
			str += '<td>' + data_list.case1.case_sonCategory + '</td>';
			str += '<td>' + data_list.case1.case_reporterName + '</td>';
			str += '<td>' + data_list.sence.snece_inquestPerson + '</td>';
			str += '</tr>';
		}
	});
}