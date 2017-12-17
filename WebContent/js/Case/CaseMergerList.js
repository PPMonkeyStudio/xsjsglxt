var query_data = {
	"page_list_parallelInformation.pageIndex" : "1",
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
	$.post('/xsjsglxt/case/Parallel_ListParallelInformationByPageAndSearch', data, function(xhr_data) {
		xhr_data = JSON.parse(xhr_data)
		$('.case_table_info tbody').empty();
		var str = '';
		for (var len = 0; len < xhr_data.parallelList.length; len++) {
			var data_list = xhr_data.parallelList[len];
			str += '<tr>';
			str += '<td>' + (len + 1) + '</td>';
			str += '<td><a href="/xsjsglxt/case/?id=' + data_list.parallel_num + '">' + data_list.parallel_num + '</a></td>';
			/*str += '<td>' + data_list.parallel_num + '</td>';*/
			str += '<td>' + data_list.parallel_casename + '</td>';
			str += '<td>' + data_list.parallel_date + '</td>';
			str += '<td>' + data_list.parallel_person + '</td>';
			str += '<td>' + (data_list.parallel_breakecaseSituation == "1" ? "是" : "否") + '</td>';
			str += '</tr>';
		}
		$('.case_table_info tbody').append(str);
	});
}