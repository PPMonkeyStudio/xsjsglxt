<<<<<<< HEAD
var query_data = {
	"page_list_BreakecaseInformation.pageIndex" : "1",
	"page_list_BreakecaseInformation.snece_inquestId" : "",
	"page_list_BreakecaseInformation.case_name" : "",
	"page_list_BreakecaseInformation.case_totalCategory" : "",
	"page_list_BreakecaseInformation.case_sonCategory" : "",
	"page_list_BreakecaseInformation.breakecase_suspectName" : "",
	"page_list_BreakecaseInformation.breakecase_captureUnit" : "",
	"page_list_BreakecaseInformation.start_time" : "",
	"page_list_BreakecaseInformation.stop_time" : "",
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
		$('.query_prompting_info').text('接警时间从' + $('input[name="page_list_BreakecaseInformation.start_time"]').val() + '到' + $('input[name="page_list_BreakecaseInformation.stop_time"]').val());
		get_ListBreakecaseInformationByPageAndSearch(query_data);
	});
	$('.empty_quert').click(function() {
		for (var i in query_data) {
			query_data[i] = "";
		}
		//选择框清除内容
		$('#newQuery select').val("");
		//输入框清除内容
		$('$newQuery input').val("");
		/*//影藏模态框
		$('#newQuery').modal('hide');*/
		//成功提示
		toastr.success('清除查询信息成功');
	});
	get_ListBreakecaseInformationByPageAndSearch(query_data);
})

function get_ListBreakecaseInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/BreakCase_ListBreakecaseInformationByPageAndSearch', data, function(xhr) {
		var data_list = xhr.BreakecaseInformationDTOList;
		var str = '';
		for (var len = 0; len < data_list.length; len++) {
			str += '<tr>';
			str += '<td>' + (len + 1) + '</td>';
			str += '<td><a href="/xsjsglxt/case/Case_page_CaseDetails?id=' + data_list[len].case1.xsjsglxt_case_id + '">' + data_list[len].sence.snece_inquestId + '</a></td>';
			str += '<td>' + data_list[len].breakecase.breakecase_type + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_according + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_capture + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_captureUnit + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_waitbreakecase + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_suspectName + '</td>';
			str += '<td>'
				+ '<input type="hidden"  value="' + data_list[len].case1.xsjsglxt_case_id + '" />'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
				+ '</td>';
			str += '</tr>';
		}
		//加载到表格中
		$('.breakcase_table_info tbody').html(str); //操作点击事件
		//设置点击事件
		$('.btn-xs').click(modifi_delete);
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


var modifi_delete = function() {
	var type = $(this).text().trim();
	var id = $(this).siblings('input').val();
	console.log(type, id);
	if (type == "修改") {
		$.post('/xsjsglxt/case/BreakCase_BreakecaseInformationOne', {
			"case1.xsjsglxt_case_id" : id
		}, function(xhr_data) {
			var str = '';
			str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
			str += '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind"></td><td colspan="3">';
			str += '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="breakecase.breakecase_case">';
			str += '</select></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>案件类型</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakecase.breakecase_type">';
			str += '<option ' + (xhr_data.breakecase.breakecase_type == "新添案件" ? "selected" : "") + '>新添案件</option>';
			str += '<option ' + (xhr_data.breakecase.breakecase_type == "已有案件" ? "selected" : "") + '>已有案件</option>';
			str += '</select></td>';
			str += '<td>嫌疑人姓名</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectName" type="text" value="' + xhr_data.breakecase.breakecase_suspectName + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>性别</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectSex" type="text" value="' + xhr_data.breakecase.breakecase_suspectSex + '"  /></td>';
			str += '<td>出生日期</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectBirthday" type="text" value="' + xhr_data.breakecase.breakecase_suspectBirthday + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>身份证号码</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectIDnum" type="text" value="' + xhr_data.breakecase.breakecase_suspectIDnum + '"  /></td>';
			str += '<td>住址</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectAddress" type="text" value="' + xhr_data.breakecase.breakecase_suspectAddress + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>破案依据</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_according" type="text" value="' + xhr_data.breakecase.breakecase_according + '"  /></td>';
			str += '<td>是否抓获</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_capture" type="text" value="' + xhr_data.breakecase.breakecase_capture + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>抓获单位</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_captureUnit" type="text" value="' + xhr_data.breakecase.breakecase_captureUnit + '"  /></td>';
			str += '<td>带破案件</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_waitbreakecase" type="text" value="' + xhr_data.breakecase.breakecase_waitbreakecase + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>备注</td><td  colspan="3"><textarea style="witdh:70%;" class="form-control" name="breakecase.breakecase_remarks">' + xhr_data.breakecase.breakecase_remarks + '</textarea>';
			//添加存丢失物的id隐藏域(上一兄元素为备注文本域)
			str += '<input name="breakecase.xsjsglxt_breakecase_id" type="hidden" value="' + xhr_data.breakecase.xsjsglxt_breakecase_id + '" />';
			str += '</td>';
			str += '</tr></tbody></table>';
			//str加载到模态框中
			$('#breakCaseinput .panel-body').html(str);
			//模态框显示
			$('#breakCaseinput').modal('show');
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
				$('.selectpicker').html(option).selectpicker('refresh');
				//除去加载提示
				$('.load_remind').remove();
			}, 'json');
			//确认按钮添加事件
			$('.breakCase_operation').click(breakecase_modification);
		}, 'json');


	} else if (type == "删除") {
		var formData = new FormData();
		formData.append('useBreakecaseInformationNumList', id);
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
							url : '/xsjsglxt/case/BreakCase_remove_BreakecaseInformationList',
							type : 'post',
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'json',
							success : function(data) {
								if (data == "success") {
									toastr.success("删除成功！");
									//获取对应option中的value值
									get_ListBreakecaseInformationByPageAndSearch(query_data);
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


//确认修改
var breakecase_modification = function() {
	$.confirm({
		title : '确定修改?',
		smoothContent : false,
		content : false,
		autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-danger',
				text : '确认',
				action : function() {
					$.ajax({
						url : '/xsjsglxt/case/BreakCase_updateBreakcase',
						type : 'post',
						data : $('#breakCaseinput form').serialize(),
						processData : false,
						contentType : false,
						dataType : 'json',
						success : function(data) {
							if (data == "success") {
								toastr.success("修改成功！");
								//获取对应option中的value值
								get_ListBreakecaseInformationByPageAndSearch(query_data);
							} else {
								toastr.error("修改失败！");
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




//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.totalPages;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//跳转到n页
function toPage(object) {
	query_data['page_list_senceInformation.pageIndex'] = $(object).val();
	get_ListBreakecaseInformationByPageAndSearch(query_data);

var query_data = {
	"page_list_BreakecaseInformation.pageIndex" : "1",
	"page_list_BreakecaseInformation.snece_inquestId" : "",
	"page_list_BreakecaseInformation.case_name" : "",
	"page_list_BreakecaseInformation.case_totalCategory" : "",
	"page_list_BreakecaseInformation.case_sonCategory" : "",
	"page_list_BreakecaseInformation.breakecase_suspectName" : "",
	"page_list_BreakecaseInformation.breakecase_captureUnit" : "",
	"page_list_BreakecaseInformation.start_time" : "",
	"page_list_BreakecaseInformation.stop_time" : "",
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
=======
var query_data = {
	"page_list_BreakecaseInformation.pageIndex" : "1",
	"page_list_BreakecaseInformation.snece_inquestId" : "",
	"page_list_BreakecaseInformation.case_name" : "",
	"page_list_BreakecaseInformation.case_totalCategory" : "",
	"page_list_BreakecaseInformation.case_sonCategory" : "",
	"page_list_BreakecaseInformation.breakecase_suspectName" : "",
	"page_list_BreakecaseInformation.breakecase_captureUnit" : "",
	"page_list_BreakecaseInformation.start_time" : "",
	"page_list_BreakecaseInformation.stop_time" : "",
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

	get_ListBreakecaseInformationByPageAndSearch(query_data);
<<<<<<< HEAD
	
=======

>>>>>>> origin/HY
	$('.to_quert').click(function() {
		var arr = $('#query_infomantion_inmodal').serializeArray();
		$.each(arr, function(key, value) {
			//key为arr里对象的索引，value为索引为key的对象。对象以{name: 'firstname', value: 'Hello'}形式存储, 以obj.name和obj.value形式遍历 
			query_data[value.name] = value.value;
		});
		$('.query_prompting_info').text('接警时间从' + $('input[name="page_list_BreakecaseInformation.start_time"]').val() + '到' + $('input[name="page_list_BreakecaseInformation.stop_time"]').val());
		get_ListBreakecaseInformationByPageAndSearch(query_data);
	});
	$('.empty_quert').click(function() {
		for (var i in query_data) {
			query_data[i] = "";
		}
		//选择框清除内容
		$('#newQuery select').val("");
		//输入框清除内容
		$('$newQuery input').val("");
		/*//影藏模态框
		$('#newQuery').modal('hide');*/
		//成功提示
		toastr.success('清除查询信息成功');
	});

	//添加模态框出现时执行查询所有案件并添加进模态框中
	$('#breakCase_input').on('show.bs.modal', function() {
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			var option = '';
			for (var len = 0; len < Case_data.length; len++) {
				option += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('#breakCase_input .selectpicker').html(option).selectpicker('refresh');
			//除去加载提示
			$('#breakCase_input .load_remind').remove();
		}, 'json');
	})
	//添加模态框影藏时清除内的数值
	$('#breakCase_input').on('hide.bs.modal', function() {
		$(this).find('input,textarea').val('');
	})
	//破案确认添加按钮事件
	$('.input_sure').click(function() {
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
						$.post('/xsjsglxt/case/BreakCase_saveBreakecase', $('#breakCase_input form').serialize(), function(xhr_data, text, xhr) {
							console.log(text + "------------------" + xhr_data + "---------");
							console.log(xhr);
							if (xhr_data == "success") {
								//影藏模态框
								$('#breakCase_input').modal('hide');
								toastr.success("添加成功！");
								//获取对应option中的value值
								get_ListBreakecaseInformationByPageAndSearch(query_data);
							} else {
								toastr.error("添加失败！");
							}
						}, 'text');
					}
				},
				cancelAction : {
					btnClass : 'btn-blue',
					text : '取消',
				}
			}
		});
	});
})

function get_ListBreakecaseInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/BreakCase_ListBreakecaseInformationByPageAndSearch', data, function(xhr) {
		var data_list = xhr.BreakecaseInformationDTOList;
		var str = '';
		for (var len = 0; len < data_list.length; len++) {
			str += '<tr>';
			str += '<td>' + (len + 1) + '</td>';
			str += '<td><a href="/xsjsglxt/case/Case_page_CaseDetails?id=' + data_list[len].case1.xsjsglxt_case_id + '">' + data_list[len].sence.snece_inquestId + '</a></td>';
			str += '<td>' + data_list[len].breakecase.breakecase_type + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_according + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_capture + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_captureUnit + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_waitbreakecase + '</td>';
			str += '<td>' + data_list[len].breakecase.breakecase_suspectName + '</td>';
			str += '<td>'
				+ '<input type="hidden"  value="' + data_list[len].breakecase.xsjsglxt_breakecase_id + '" />'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
				+ '</td>';
			str += '</tr>';
		}
		//加载到表格中
		$('.breakcase_table_info tbody').html(str); //操作点击事件
		//设置点击事件
		$('.btn-xs').click(modifi_delete);
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


var modifi_delete = function() {
	var type = $(this).text().trim();
	var id = $(this).siblings('input').val();
	if (type == "修改") {
		$.post('/xsjsglxt/case/BreakCase_BreakecaseInformationOne', {
			"breakecase.xsjsglxt_breakecase_id" : id
		}, function(xhr_data) {
			var str = '';
			str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
			str += '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind"></td><td colspan="3">';
			str += '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="breakecase.breakecase_case">';
			str += '</select></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>案件类型</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakecase.breakecase_type">';
			str += '<option ' + (xhr_data.breakecase.breakecase_type == "新添案件" ? "selected" : "") + '>新添案件</option>';
			str += '<option ' + (xhr_data.breakecase.breakecase_type == "已有案件" ? "selected" : "") + '>已有案件</option>';
			str += '</select></td>';
			str += '<td>嫌疑人姓名</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectName" type="text" value="' + xhr_data.breakecase.breakecase_suspectName + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>性别</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectSex" type="text" value="' + xhr_data.breakecase.breakecase_suspectSex + '"  /></td>';
			str += '<td>出生日期</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectBirthday" type="text" value="' + xhr_data.breakecase.breakecase_suspectBirthday + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>身份证号码</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectIDnum" type="text" value="' + xhr_data.breakecase.breakecase_suspectIDnum + '"  /></td>';
			str += '<td>住址</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_suspectAddress" type="text" value="' + xhr_data.breakecase.breakecase_suspectAddress + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>破案依据</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_according" type="text" value="' + xhr_data.breakecase.breakecase_according + '"  /></td>';
			str += '<td>是否抓获</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_capture" type="text" value="' + xhr_data.breakecase.breakecase_capture + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>抓获单位</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_captureUnit" type="text" value="' + xhr_data.breakecase.breakecase_captureUnit + '"  /></td>';
			str += '<td>带破案件</td><td><input style="witdh:70%;" class="form-control" name="breakecase.breakecase_waitbreakecase" type="text" value="' + xhr_data.breakecase.breakecase_waitbreakecase + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>备注</td><td  colspan="3"><textarea placeholder="请填写" style="witdh:70%;" class="form-control" name="breakecase.breakecase_remarks">' + xhr_data.breakecase.breakecase_remarks + '</textarea>';
			//添加存丢失物的id隐藏域(上一兄元素为备注文本域)
			str += '<input name="breakecase.xsjsglxt_breakecase_id" type="hidden" value="' + xhr_data.breakecase.xsjsglxt_breakecase_id + '" />';
			str += '</td>';
			str += '</tr></tbody></table>';
			//str加载到模态框中
			$('#breakCase_modification .panel-body').html(str);
			//模态框显示
			$('#breakCase_modification').modal('show');
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
		formData.append("useBreakecaseInformationNumList", id);
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
							url : '/xsjsglxt/case/BreakCase_remove_BreakecaseInformationList',
							type : 'post',
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'text',
							success : function(data, text) {
								if (data == "success") {
									toastr.success("删除成功！");
									//获取对应option中的value值
									get_ListBreakecaseInformationByPageAndSearch(query_data);
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


//确认修改
var breakecase_modification = function() {
	$.confirm({
		title : '确定修改?',
		smoothContent : false,
		content : false,
		autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-danger',
				text : '确认',
				action : function() {
					$.post('/xsjsglxt/case/BreakCase_updateBreakcase', $('#breakCase_modification form').serialize(), function(xhr_data, text) {
						if (text == "success") {
							toastr.success("修改成功！");
							//获取对应option中的value值
							get_ListBreakecaseInformationByPageAndSearch(query_data);
						} else {
							toastr.error("修改失败！");
						}
					}, 'text');
				}
			},
			cancelAction : {
				btnClass : 'btn-blue',
				text : '取消',
			}
		}
	});
}




//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_senceInformation.pageIndex'] = page_infomantion.totalPages;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//跳转到n页
function toPage(object) {
	query_data['page_list_senceInformation.pageIndex'] = $(object).val();
	get_ListBreakecaseInformationByPageAndSearch(query_data);
>>>>>>> LWK
}