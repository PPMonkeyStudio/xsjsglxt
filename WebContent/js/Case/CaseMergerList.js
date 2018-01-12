var query_data = {
	"page_list_parallelInformation.pageIndex" : "1",
	"page_list_parallelInformation.start_time" : "",
	"page_list_parallelInformation.stop_time" : "",
	"page_list_parallelInformation.parallel_casename" : "",
	"page_list_parallelInformation.parallel_person" : "",
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


	$('.to_quert').click(function() {
		$('#newCaseMergerQuery form input').each(function() {
			query_data[$(this).attr('name')] = $(this).val();
		});
		$('#newCaseMergerQuery').modal('hide');
		get_ListParallelInformationByPageAndSearch(query_data);
		toastr.success("查询成功！");
	});

	$('.empty_quert').click(function() {
		$('#newCaseMergerQuery form input').each(function() {
			$(this).val('');
		});
	});

})

function get_ListParallelInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Parallel_ListParallelInformationByPageAndSearch', data, function(xhr_data) {
		xhr_data = JSON.parse(xhr_data)
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
			str += '<td width="240px">'
				+ '<input type="hidden"  value="' + data_list.xsjsglxt_parallel_id + '" />'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
				+ '</td>';
			str += '</tr>';
		}
		$('.case_table_info tbody').html(str);
		$('.btn-xs').click(modifi_delete);
	});
}

var modifi_delete = function() {
	var type = $(this).text().trim();
	var id = $(this).siblings('input').val();
	if (type == "修改") {
		$.post('/xsjsglxt/case/Parallel_ParallelInformationOne', {
			"parallel.xsjsglxt_parallel_id" : id
		}, function(xhr_data) {
			//模态框显示
			$('#CaseMerger_modification').modal('show');
			$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
				//所有案件循环
				var option = '';
				for (var len = 0; len < Case_data.length; len++) {
					option += '<option ';
					if (xhr_data.case1.case_name == Case_data[len].case_name) {
						option += 'selected';
					}
					option += ' value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
				}
				$('#breakCase_modification .selectpicker').html(option).selectpicker('refresh');
				//除去加载提示
				$('#breakCase_modification .load_remind').remove();
			}, 'json');
			//确认修改按钮添加事件
			$('.breakCase_operation').click(breakecase_modification);
		}, 'json');
	} else if (type == "删除") {
		var formData = new FormData();
		formData.append("useParallelInformationNumList", id);
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
							url : '/xsjsglxt/case/Parallel_remove_ParallelInformationList',
							type : 'post',
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'text',
							success : function(data, text) {
								if (text == "success") {
									toastr.success("删除成功！");
									//获取对应option中的value值
									get_ListParallelInformationByPageAndSearch(query_data);
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
}