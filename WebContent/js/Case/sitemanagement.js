var query_data = {
	"page_list_senceInformation.pageIndex" : "1",
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
	$('.to_quert').click(function() {
		var arr = $('#query_infomantion_inmodal').serializeArray();
		$.each(arr, function(key, value) {
			//key为arr里对象的索引，value为索引为key的对象。对象以{name: 'firstname', value: 'Hello'}形式存储, 以obj.name和obj.value形式遍历 
			query_data[value.name] = value.value;
		});
		$('.query_prompting_info').text('接警时间从' + $('input[name="page_list_senceInformation.start_time"]').val() + '到' + $('input[name="page_list_senceInformation.stop_time"]').val());
		get_ListSneceInformationByPageAndSearch(query_data);
	});
	$('.empty_quert').click(function() {
		for (var i in query_data) {
			query_data[i] = "";
		}
		//选择框清除内容
		$('.Query_table select').val("");
		//输入框清除内容
		$('.Query_table input').val("");
		/*//影藏模态框
		$('#newQuery').modal('hide');*/
		//成功提示
		toastr.success('清除查询信息成功');
	});
	get_ListSneceInformationByPageAndSearch(query_data);
})

function get_ListSneceInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Case_ListSneceInformationByPageAndSearch', data, function(xhr) {
		$('.case_table_info tbody').empty();
		var str = '';
		for (var len = 0; len < xhr.SenceInformationDTOList.length; len++) {
			var data_list = xhr.SenceInformationDTOList[len];
			str += '<tr>';
			str += '<td><input type="checkbox" class="check_del" style="margin:10px;"/></td>';
			str += '<td>' + (len + 1) + '</td>';
			str += '<td><a href="/xsjsglxt/case/Case_page_CaseDetails?id=' + data_list.case1.xsjsglxt_case_id + '">' + data_list.sence.snece_inquestId + '</a></td>';
			str += '<td>' + data_list.case1.case_receivingAlarmDate + '</td>';
			str += '<td>' + data_list.case1.case_address + '</td>';
			str += '<td>' + data_list.case1.case_sonCategory + '</td>';
			str += '<td>' + data_list.case1.case_reporterName + '</td>';
			str += '<td>' + data_list.sence.snece_inquestPerson + '</td>';
			str += '</tr>';
		}
		$('.case_table_info tbody').append(str);
		//分页信息存入page_infomantion中
		page_infomantion.pageIndex = xhr.pageIndex; //当前页数
		page_infomantion.totalRecords = xhr.totalRecords; //总页数
		page_infomantion.pageSize = xhr.pageSize; //每页记录数
		page_infomantion.totalPages = xhr.totalPages; //总记录数
		page_infomantion.HavePrePage = xhr.HavePrePage; //是否有上一页
		page_infomantion.HaveNextPage = xhr.HaveNextPage; //是否有下一页

		//分页下的记录信息
		var opt = '<option value=""></option>';
		for (var index = xhr.pageIndex + 1; index <= xhr.totalPages; index++) {
			opt += '<option>' + index + '</option>';
		}
		$('.info').html('共 ' + xhr.totalRecords + '条信息 当前' + xhr.pageIndex + '/' + xhr.totalPages + '页 ' + xhr.pageSize + '条信息/页&nbsp&nbsp转到第'
			+ '<select onchange="toPage(this)">' + opt + '</select> 页');

		//影藏模态框
		$('#newQuery').modal('hide')
	}, 'json')
}

//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = 1;
	get_ListSneceInformationByPageAndSearch(query_data);
}
//上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListSneceInformationByPageAndSearch(query_data);
}
//下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListSneceInformationByPageAndSearch(query_data);
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.totalPages;
	get_ListSneceInformationByPageAndSearch(query_data);
}
//跳转到n页
function toPage(object) {
	query_data['page_list_senceInformation.pageIndex'] = $(object).val();
	get_ListSneceInformationByPageAndSearch(query_data);
}