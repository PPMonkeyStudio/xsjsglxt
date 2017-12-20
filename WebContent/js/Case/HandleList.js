var query_data = {
	"page_list_HandleInformation.pageIndex" : "1",
	"page_list_HandleInformation.handle_StartTimeaOfDetention_start_time" : "",
	"page_list_HandleInformation.handle_StartTimeaOfDetention_stop_time" : "",

	"page_list_HandleInformation.handle_arrestTime_start_time" : "",
	"page_list_HandleInformation.handle_arrestTime_stop_time" : "",

	"page_list_HandleInformation.handle_prosecuteTime_start_time" : "",
	"page_list_HandleInformation.handle_prosecuteTime_stop_time" : "",

	"page_list_HandleInformation.handle_checkbackTime_start_time" : "",
	"page_list_HandleInformation.handle_checkbackTime_stop_time" : "",



	"page_list_HandleInformation.handle_pbatTime_start_time" : "",
	"page_list_HandleInformation.handle_pbatTime_stop_time" : "",

	"page_list_HandleInformation.handle_lhusTime_start_time" : "",
	"page_list_HandleInformation.handle_lhusTime_stop_time" : "",

	"page_list_HandleInformation.handle_detentionDay" : "",
	"page_list_HandleInformation.handle_administrativeCase" : "",

	"page_list_HandleInformation.handle_squadronleader" : "",
	"page_list_HandleInformation.handle_PoliceInHandlingCases" : "",
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
	get_ListHandleInformationByPageAndSearch(query_data);
})

function get_ListHandleInformationByPageAndSearch(data) {
	//$.post('/xsjsglxt/case/Handle_ListHandleInformationByPageAndSearch', data, function(xhr_data) {
	var str = '';
	for (var len = 0; len < 7; len++) {
		//var data_list = xhr.SenceInformationDTOList[len];
		str += '<tr>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '<td>' + len + '</td>';
		str += '</tr>';
	}
	$('.Handle_table_info tbody').html(str);
//}, 'json')
}

//radio
function chose(obj) {
	$(obj).parent().siblings('input').val($(obj).val());
}




//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = 1;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = page_infomantion.totalPages;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//跳转到n页
function toPage(object) {
	query_data['page_list_HandleInformation.pageIndex'] = $(object).val();
	get_ListHandleInformationByPageAndSearch(query_data);
}