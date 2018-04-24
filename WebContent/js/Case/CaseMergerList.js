var query_data = {
	"page_list_parallelInformation.pageIndex" : "1",
	"page_list_parallelInformation.start_time" : "",
	"page_list_parallelInformation.stop_time" : "",
	"page_list_parallelInformation.parallel_casename" : "",

	"page_list_parallelInformation.parallel_person" : "",
	"page_list_parallelInformation.parallel_num" : "",
	"page_list_parallelInformation.parallel_casename" : "",
	"page_list_parallelInformation.parallel_date" : "",
	"page_list_parallelInformation.order" : "desc",
	"page_list_parallelInformation.parallel_breakecaseSituation" : "",
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

var selectAll = function(event) {
	if (event.checked) {
		console.log("选中了");
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = true;
		}
	} else {
		console.log("没选中");
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = false;
		}
	}
}

var modifi_delete = function() {
	var type = $(this).text().trim();
	var id = $(this).siblings('input').val();
	$.post('/xsjsglxt/case/Parallel_ParallelInformationOne', {
		"parallel.xsjsglxt_parallel_id" : id
	}, function(xhr_data) {
		$('#CaseMerger_modification table tbody').find('input,select,textarea').each(function() {
			if ($(this).attr('name')) {
				var name = $(this).attr('name');
				var key = name.split('.')[1];
				$(this).val(xhr_data["parallel"][key]);
			}
		});
		//模态框显示
		$('#CaseMerger_modification').modal('show');
		var caseID = [];
		for (let index = 0; index < xhr_data.caseList.length; index++) {
			caseID.push(xhr_data.caseList[index].xsjsglxt_case_id);
		}
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			//所有案件循环
			var option = '';
			for (var len = 0; len < Case_data.length; len++) {
				option += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('select[name="parallel.parallel_num"]').html(option).selectpicker('refresh').selectpicker('val', caseID);
			//除去加载提示
			$('#breakCase_modification .load_remind').remove();
		}, 'json');
		//确认修改按钮添加事件
		$('.modify_merger').unbind().click(function() {
			$.post('/xsjsglxt/case/Parallel_updateParallel', $('#CaseMerger_modification form').serialize(), function(msg) {
				if (msg == "success") {
					toastr.info('修改成功');
					$('#CaseMerger_modification').modal('hide');
					get_ListParallelInformationByPageAndSearch(query_data);
				}
			}, 'text');
		})
	}, 'json');
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

	$('#delete-parallel').click(function() {
		var formData = new FormData;
		var falg = false;
		$('.case_table_info').find('input[name="chooseCheckBox"]').each(function() {
			if ($(this).is(':checked')) {
				formData.append('useParallelInformationNumList', $(this).attr('id'));
				falg = true;
			}
		});
		if (falg) {
			$.ajax({
				url : "/xsjsglxt/case/Parallel_remove_ParallelInformationList",
				type : "POST",
				contentType : false,
				processData : false,
				data : formData,
				dataType : 'text',
				success : function(msg) {
					if (msg == 'success') {
						toastr.info('删除成功');
						get_ListParallelInformationByPageAndSearch(query_data);
					} else if (msg == 'error') {
						toastr.error('删除失败');
					}
				}
			});
		} else {
			toastr.info('未选择数据');
		}
	});

	//模态框清除数据
	$('#CaseMerger_modification').on('hidden.bs.modal', function() {
		var refresh = '';
		$(value).find('input,select,textarea').each(function() {
			refresh = $(this).attr("refresh");
			//文本刷新
			if (refresh == "text") {
				$(this).val('');
			}
			//select插件刷新
			else if (refresh == "selectpicker") {
				$(this).selectpicker('deselectAll');
			} else {

			}
		});
	})
})

function get_ListParallelInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Parallel_ListParallelInformationByPageAndSearch', data, function(xhr_data) {
		var str = '';
		for (var len = 0; len < xhr_data.parallelList.length; len++) {
			var data_list = xhr_data.parallelList[len];
			str += '<tr>';
			str += '<td><input name="chooseCheckBox" id="' + data_list.xsjsglxt_parallel_id + '" type="checkbox"></td>';
			str += '<td>' + data_list.parallel_num + '</td>';
			//str += '<td><a href="/xsjsglxt/case/?id=' + data_list.parallel_num + '">' + data_list.parallel_num + '</a></td>';
			/*str += '<td>' + data_list.parallel_num + '</td>';*/
			str += '<td>' + data_list.parallel_casename + '</td>';
			str += '<td>' + data_list.parallel_date + '</td>';
			str += '<td>' + data_list.parallel_person + '</td>';
			str += '<td>' + (data_list.parallel_breakecaseSituation == "1" ? "是" : "否") + '</td>';
			str += '<td style="padding-left:0px;">'
				+ '<input type="hidden"  value="' + data_list.xsjsglxt_parallel_id + '" />'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs modify_parallel"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
				+ '</td>';
			str += '</tr>';
		}
		$('.case_table_info tbody').html(str);
		$('.modify_parallel').click(modifi_delete);
	}, 'json');
}

//输入框查询事件
function dynamic_query(params) {
	query_data[$(params).attr('query_name')] = $(params).val();
	get_ListParallelInformationByPageAndSearch(query_data);
}

//单选框的点击事件
function buildCase_chose(params) {
	$('input[name="parallel.parallel_breakecaseSituation"]').val($(params).val());
}

// 首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = 1;
	get_ListParallelInformationByPageAndSearch(query_data);
}
// 上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListParallelInformationByPageAndSearch(query_data);
}
// 下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListParallelInformationByPageAndSearch(query_data);
}
// 尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = page_infomantion.totalPages;
	get_ListParallelInformationByPageAndSearch(query_data);
}