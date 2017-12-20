var query_data = {
	"page_list_HandleInformation.pageIndex" : "1",
	//拘留起始时间
	"page_list_HandleInformation.handle_StartTimeaOfDetention_start_time" : "",
	"page_list_HandleInformation.handle_StartTimeaOfDetention_stop_time" : "",
	//逮捕时间
	"page_list_HandleInformation.handle_arrestTime_start_time" : "",
	"page_list_HandleInformation.handle_arrestTime_stop_time" : "",
	//起诉时间
	"page_list_HandleInformation.handle_prosecuteTime_start_time" : "",
	"page_list_HandleInformation.handle_prosecuteTime_stop_time" : "",
	//退查时间
	"page_list_HandleInformation.handle_checkbackTime_start_time" : "",
	"page_list_HandleInformation.handle_checkbackTime_stop_time" : "",
	//取保候审时间
	"page_list_HandleInformation.handle_pbatTime_start_time" : "",
	"page_list_HandleInformation.handle_pbatTime_stop_time" : "",
	//监视居住时间
	"page_list_HandleInformation.handle_lhusTime_start_time" : "",
	"page_list_HandleInformation.handle_lhusTime_stop_time" : "",
	//拘留天数
	"page_list_HandleInformation.handle_detentionDay" : "",
	//行政案件名称
	"page_list_HandleInformation.handle_administrativeCase" : "",
	//中队长
	"page_list_HandleInformation.handle_squadronleader" : "",
	//办案民警
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

	//Handle_delete删除办案管理事件
	$('.Handle_delete').click(Handle_delete);

	//办案添加
	$('#Handle_input').on('show.bs.modal', function() {
		$.post('/xsjsglxt/case/Handle_xuhao', function(json_data, text_data) {
			$('input[name="handle.handle_orderNumber"]').val(json_data);
		}, 'json');
	})
	$('.handle_input').click(handle_input);

	//办案查询
	$('.handle_query').click(handle_query);
	//清空查询
	$('.handle_empty').click(function() {
		$('#Handle_query input,select').val("");
	});
})

function get_ListHandleInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Handle_ListHandleInformationByPageAndSearch', data, function(xhr_data) {
		var Handle = xhr_data.listHandle;
		var str = '';
		for (var len = 0; len < Handle.length; len++) {
			str += '<tr class="tr_select">';
			str += '<td style="padding-left: 5px;"><input class="form-control" id="' + Handle[len].xsjsglxt_handle_id + '" type="checkbox"></td>'
			str += '<td style="padding-left: 5px;">' + Handle[len].handle_orderNumber + '</td>';
			str += '<td>' + Handle[len].handle_administrativeCase + '</td>';
			str += '<td>' + Handle[len].handle_suspectName + '</td>';
			str += '<td>' + Handle[len].handle_administrativeAttachment + '</td>';
			str += '<td>' + Handle[len].handle_arrest + '</td>';
			str += '<td>' + Handle[len].handle_prosecute + '</td>';
			str += '<td>' + Handle[len].handle_checkback + '</td>';
			str += '<td>' + Handle[len].handle_pbat + '</td>';
			str += '<td>' + Handle[len].handle_lhus + '</td>';
			str += '<td>' + Handle[len].handle_FinancialName + '</td>';
			str += '<td>' + Handle[len].handle_handTime + '</td>';
			str += '<td>' + Handle[len].handle_handleTime + '</td>';
			str += '<td>' + Handle[len].handle_processMode + '</td>';
			str += '<td>' + Handle[len].handle_squadronleader + '</td>';
			str += '<td  style="padding-left: 5px;">' + Handle[len].handle_PoliceInHandlingCases + '</td>';
			str += '</tr>';
		}
		$('.Handle_table_info tbody').html(str);
		//tr绑定click事件
		$('.tr_select').click(tr_select);
	}, 'json')
}

//radio
function chose(obj) {
	$(obj).parent().siblings('input').val($(obj).val());
}
//tr_select
var tr_select = function() {
	var input = $(this).find('input[type="checkbox"]');
	if (input.is(':checked')) {
		input.removeAttr('checked');
	} else {
		input.attr('checked', 'checked');
	}
}
var Handle_delete = function() {
	var formData = new FormData();
	$('.Handle_table_info tbody input:checked').each(function() {
		formData.append("useHandleInformationNumList", $(this).attr('id'));
	});
	$.confirm({
		title : '确定删除?',
		smoothContent : false,
		content : false,
		autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-danger',
				text : '确认',
				action : function() {
					$.ajax({
						url : '/xsjsglxt/case/Handle_remove_HandleInformationList',
						type : 'post',
						data : formData,
						processData : false,
						contentType : false,
						dataType : 'text',
						success : function(data, text) {
							if (text == "success") {
								toastr.success("删除成功！");
								//获取对应option中的value值
								get_ListHandleInformationByPageAndSearch(query_data);
							} else {
								toastr.error("删除失败！");
							}
						}
					});
				}
			},
			cancelAction : {
				btnClass : 'btn-blue',
				text : '取消',
			}
		}
	});
}


var handle_input = function() {
	$.confirm({
		title : '确定添加?',
		smoothContent : false,
		content : false,
		autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-danger',
				text : '确认',
				action : function() {
					$.post('/xsjsglxt/case/Handle_saveHandle', $('#Handle_input form').serialize(), function(json_data, text_data) {
						$('#Handle_input').modal('hide');
						if (text_data == "success") {
							toastr.success("删除成功！");
							//获取对应option中的value值
							get_ListHandleInformationByPageAndSearch(query_data);
						} else {
							toastr.error("删除失败！");
						}
					}, 'json');
				}
			},
			cancelAction : {
				btnClass : 'btn-blue',
				text : '取消',
			}
		}
	});
}

//办案查询
var handle_query = function() {
	$.each($('#Handle_query form').serializeArray(), function(k, v) {
		query_data[v.name] = v.value;
	});
	$("#Handle_query").modal('hide');
	get_ListHandleInformationByPageAndSearch(query_data);
	toastr.success('查询成功!');
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