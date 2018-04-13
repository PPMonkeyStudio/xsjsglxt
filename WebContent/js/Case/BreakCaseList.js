var query_data = {
	"page_list_BreakecaseInformation.pageIndex": "1",
	"page_list_BreakecaseInformation.snece_inquestId": "",
	"page_list_BreakecaseInformation.case_name": "",
	"page_list_BreakecaseInformation.case_totalCategory": "",
	"page_list_BreakecaseInformation.case_sonCategory": "",
	"page_list_BreakecaseInformation.breakecase_suspectName": "",
	"page_list_BreakecaseInformation.breakecase_captureUnit": "",
	"page_list_BreakecaseInformation.start_time": "",
	"page_list_BreakecaseInformation.stop_time": "",
};
//当前页面分页信息
var page_infomantion = {
	pageIndex: 1,
	totalRecords: 1,
	pageSize: 20,
	totalPages: 1,
	HavePrePage: false,
	HaveNextPage: false,
}

var braekeCaseData = `<form action="">
<div style="width: 100%;margin: auto;" class="panel-body">
<table class="table table-hover table-condensed" align="center">
<tbody><tr>
<td>所属案件<i class="fa fa-spinner fa-pulse load_remind"></i></td>
<td colspan="3"><select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="breakeCase.breakecase_case" title="Choose one of the following..."></select></td>
</tr>
<tr>
<td>案件类型</td>
<td><input class="form-control" name="breakeCase.breakecase_type" type="text"></td>
<td>破案方式</td>
<td><input class="form-control" name="breakeCase.breakecase_according" type="text"></td>
</tr>
<tr>
<td>破案时间</td>
<td><input class="form-control mydate" name="breakeCase.breakecase_caseTime" type="text"></td>
<td>破案人</td>
<td><input class="form-control" name="breakeCase.breakecase_person" type="text"></td>
</tr>
<tr>
<td>带破案件</td>
<td colspan="3"><select class="form-control selectpicker" multiple data-live-search="true" name="breakeCase.breakecase_waitbreakecase"></select></td>
</tr>
<tr>
<td>备注</td>
<td colspan="3"><textarea placeholder="请填写" class="form-control"name="breakeCase.breakecase_remarks"></textarea></td>
</tr>
<tr>
<table class="table table-hover suspect-info">
<thead>
	<tr>
	<td>姓名</td>
	<td>身份证号</td>
	<td>性别</td>
	<td>生日</td>
	<td>住址</td>
	<td>抓获</td>
	<td>抓获单位</td>
	<td>抓获时间</td>
	<td>操作</td>
	</tr>
</thead>
	<tbody>
	</tbody>
</table>
</tr>
</tbody>
</table>
</div>
</form>`;

var SuspectData = `<table class="table">
<tbody>
<tr><td>姓名</th><td><input class="form-control must" name="breakecaseSuspect_name" type="text" value="1"></td>
    <td>身份证号</th><td><input class="form-control must su-IDnum" name="breakecaseSuspect_IDnum" type="text" value="36073319931116591X"></td></tr>
<tr><td>性别</th><td><input class="form-control must su-sex" name="breakecaseSuspect_sex" type="text" value="1"></td>
    <td>生日</th><td><input class="form-control must su-birthday" name="breakecaseSuspect_birthday" type="text" value="1"></td></tr>
<tr><td>住址</th><td><input class="form-control must" name="breakecaseSuspect_addrress" type="text" value="1"></td>
	<td>是否抓获</th><td><input class="form-control must" name="breakecaseSuspect_capture" type="text"></td></tr>
<tr><td>抓获单位</th><td><input class="form-control must" name="breakecaseSuspect_captureUnit" type="text" value="1"></td>
	<td>抓获时间</th><td><input class="form-control mydate must" name="breakecaseSuspect_captureTime" type="text" value="1"></td></tr>
</tbody>
</table>`;

//保存嫌疑人信息
var suspect = [];

$(function () {
	//刑事破案添加模态框事件
	$('#breakCase_input').on('show.bs.modal', function () {
		var this_modal = $(this);

	})
	$('.to_quert').click(function () {
		var arr = $('#query_infomantion_inmodal').serializeArray();
		$.each(arr, function (key, value) {
			//key为arr里对象的索引，value为索引为key的对象。对象以{name: 'firstname', value: 'Hello'}形式存储, 以obj.name和obj.value形式遍历 
			query_data[value.name] = value.value;
		});
		$('.query_prompting_info').text('接警时间从' + $('input[name="page_list_BreakecaseInformation.start_time"]').val() + '到' + $('input[name="page_list_BreakecaseInformation.stop_time"]').val());
		get_ListBreakecaseInformationByPageAndSearch(query_data);
	});
	$('.empty_quert').click(function () {
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
	$('.input_sure').click(function () {
		$.post('/xsjsglxt/case/BreakCase_saveBreakecase', $('#breakCase_input form').serialize(), function (xhr) {
			if (xhr == 'success') {
				toastr.success('添加成功!');
				get_ListBreakecaseInformationByPageAndSearch(query_data);
				$('#breakCase_input').find('input,select,textarea').val('');
			}
		}, 'text')
	});

	$('#breakCase_input').click(function () {
		var addBreakeCase = $.confirm({
			closeIcon: true,
			boxWidth: '80%',
			useBootstrap: false,
			smoothContent: false,
			title: '破案信息添加',
			content: braekeCaseData,
			onContentReady: function () {
				//日期，身份证识别
				Init();
				//嫌疑人表中的修改，删除事件
				Suspect_mo_del(addBreakeCase);
				//查询所有案件并添加
				$.post('/xsjsglxt/case/Case_AllCase', function (Case_data) {
					//所有案件循环
					var option = '';
					var option2 = '';
					for (var len = 0; len < Case_data.length; len++) {
						option += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
						option2 += '<option value="' + Case_data[len].case_name + '">' + Case_data[len].case_name + '</option>';
					}
					addBreakeCase.$content.find('select[name="breakeCase.breakecase_case"]').html(option).selectpicker('refresh');
					addBreakeCase.$content.find('select[name="breakeCase.breakecase_waitbreakecase"]').html(option).selectpicker('refresh');
					//除去加载提示
					addBreakeCase.$content.find('.load_remind').hide();
				}, 'json');
			},
			buttons: {
				addProson: {
					text: '添加嫌疑人',
					btnClass: 'btn-info',
					action: function () {
						var Suspect = $.confirm({
							closeIcon: true,
							boxWidth: '50%',
							useBootstrap: false,
							smoothContent: false,
							title: '嫌疑人添加',
							content: SuspectData,
							onContentReady: function () {
								Init();
							},
							buttons: {
								sureAddProson: {
									text: "确认添加",
									btnClass: 'btn-info',
									action: function () {
										var must = Suspect.$content.find('.must');
										for (let index = 0; index < must.length; index++) {
											if (must.eq(index).val() == "") {
												toastr.info('信息未填写完整，请检查空项信息!');
												return false;
											}
										}
										suspect.unshift(createSuspect(Suspect.$content));
										var suspectStr = '<tr>';
										for (const key in suspect[0]) {
											suspectStr += `<td>${suspect[0][key]}</td>`;
										}
										suspectStr += '<td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>'
										addBreakeCase.$content.find('.suspect-info tbody').append(suspectStr);
									}
								},
								close: {
									text: "取消"
								}
							}
						});
						return false;
					}
				},
				sureAdd: {
					text: '确认添加',
					btnClass: 'btn-info',
					action: function () {
						addBreakeCase.$content.find('form').serializeObject();
						var suspects = {};
						for (let index = 0; index < suspect.length; index++) {
							for (const key in suspect[index]) {
								suspects['suspectList[' + index + '].' + key] = suspect[index][key];
							}
						}
						var data = $.extend({}, suspects, addBreakeCase.$content.find('form').serializeObject());
						$.post('/xsjsglxt/case/BreakeCase_saveBreakeCase', data, function (xhr) {
							console.log(xhr);
							suspect = [];
						}, 'json');
					}
				},
				close: {
					text: '取消',
					action: function () { }
				},
			}
		});
	});

	get_ListBreakecaseInformationByPageAndSearch(query_data);
})

function get_ListBreakecaseInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/BreakCase_ListBreakecaseInformationByPageAndSearch', data, function (xhr) {
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
			str += '<td>' +
				'<input type="hidden"  value="' + data_list[len].case1.xsjsglxt_case_id + '" />' +
				'<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>' +
				'<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>' +
				'</td>';
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
		$('.info').html('共 ' + xhr.totalRecords + '条信息 当前' + xhr.pageIndex + '/' + xhr.totalPages + '页 ' + xhr.pageSize + '条信息/页&nbsp&nbsp转到第' +
			'<select onchange="toPage(this)">' + opt + '</select> 页');
		//影藏模态框
		$('#newQuery').modal('hide')
	}, 'json')
}


var modifi_delete = function () {
	var type = $(this).text().trim();
	var id = $(this).siblings('input').val();
	console.log(type, id);
	if (type == "修改") {
		$.post('/xsjsglxt/case/BreakCase_BreakecaseInformationOne', {
			"breakecase.xsjsglxt_breakecase_id": id
		}, function (xhr_data) {
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
			$('#breakCase_modification .panel-body').html(str);
			//模态框显示
			$('#breakCase_modification').modal('show');
			$.post('/xsjsglxt/case/Case_AllCase', function (Case_data) {
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
				$('.load_remind').hide();
			}, 'json');
			//确认按钮添加事件
			$('.breakCase_operation').click(breakecase_modification);
		}, 'json');

	} else if (type == "删除") {
		var formData = new FormData();
		formData.append('useBreakecaseInformationNumList', id);
		$.confirm({
			title: '确定删除?',
			smoothContent: false,
			content: false,
			autoClose: 'cancelAction|10000',
			buttons: {
				deleteUser: {
					btnClass: 'btn-danger',
					text: '确认',
					action: function () {
						$.ajax({
							url: '/xsjsglxt/case/BreakCase_remove_BreakecaseInformationList',
							type: 'post',
							data: formData,
							processData: false,
							contentType: false,
							dataType: 'text',
							success: function (data) {
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
				cancelAction: {
					btnClass: 'btn-blue',
					text: '取消',
				}
			}
		});
	}
}


//确认修改
var breakecase_modification = function () {
	$.confirm({
		title: '确定修改?',
		smoothContent: false,
		content: false,
		autoClose: 'cancelAction|10000',
		buttons: {
			deleteUser: {
				btnClass: 'btn-danger',
				text: '确认',
				action: function () {
					$.post('/xsjsglxt/case/BreakCase_updateBreakcase', $('#breakCase_modification form').serialize(), function (data) {
						if (data == "success") {
							toastr.success("修改成功！");
							//获取对应option中的value值
							get_ListBreakecaseInformationByPageAndSearch(query_data);
						} else {
							toastr.error("修改失败！");
						}
					}, 'json')

					/*$.ajax({
						url : '/xsjsglxt/case/BreakCase_updateBreakcase',
						type : 'post',
						data : $('#breakCase_modification form').serialize(),
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
					});*/
				}
			},
			cancelAction: {
				btnClass: 'btn-blue',
				text: '取消',
			}
		}
	});
}


//创建一个嫌疑人对象
function createSuspect(confirm_content) {
	var newSuspect = {};
	var name = '';
	var val = '';
	$.each(confirm_content.find('input'), function () {
		name = $(this).attr("name");
		val = $(this).val();
		newSuspect[name] = val;
	});
	return newSuspect;
}

//初始化操作---日期，身份证中生日男女的自动识别，
function Init() {
	$('.mydate').datetimepicker({
		yearStart: 1900, // 设置最小年份
		yearEnd: 2100, // 设置最大年份
		yearOffset: 0, // 年偏差
		timepicker: false, // 关闭时间选项
		format: 'Y-m-d', // 格式化日期年-月-日
		minDate: '1900/01/01', // 设置最小日期
		maxDate: '2100/01/01', // 设置最大日期
	});
	$('.su-IDnum').on('keyup', function () {
		var IDlen = $(this).val();
		if (IDlen.length == 18) {
			if (!/^\d{17}(\d|x|X)$/i.test(IDlen)) {
				toastr.info("输入的身份证格式有误！请检查格式");
			} else {
				$('.su-sex').val(IDlen.substr(16, 1) % 2 ? "男" : "女");
				$('.su-birthday').val(IDlen.substr(6, 4) + "." + Number(IDlen.substr(10, 2)) + "." + Number(IDlen.substr(12, 2)));
			}
		}
	});
}

function Suspect_mo_del(addBreakeCase) {
	addBreakeCase.$content.find('.suspect-info').on('click', function (e) {
		if (e.target.tagName == 'I') {
			var i = e.target;
			var tr = $(i).parents('tr');
			var index = tr.index();
			var all_td = tr.find('td');
			if (i.className == "fa fa-info-circle") { //修改
				var mo_SuspectData = `<table class="table">
								<tbody>
								<tr><td>姓名</th><td><input class="form-control must" name="breakecaseSuspect_name" type="text" value="${all_td.eq(0).text()}"></td>
									<td>身份证号</th><td><input class="form-control must" name="breakecaseSuspect_IDnum" type="text" value="${all_td.eq(1).text()}"></td></tr>
								<tr><td>性别</th><td><input class="form-control must" name="breakecaseSuspect_sex" type="text" value="${all_td.eq(2).text()}"></td>
									<td>生日</th><td><input class="form-control must" name="breakecaseSuspect_birthday" type="text" value="${all_td.eq(3).text()}"></td></tr>
								<tr><td>住址</th><td><input class="form-control must" name="breakecaseSuspect_addrress" type="text" value="${all_td.eq(4).text()}"></td>
									<td>是否抓获</th><td><input class="form-control must" name="breakecaseSuspect_capture" type="text" value="${all_td.eq(5).text()}"></td></tr>
								<tr><td>抓获单位</th><td><input class="form-control must" name="breakecaseSuspect_captureUnit" type="text" value="${all_td.eq(6).text()}"></td>
									<td>抓获时间</th><td><input class="form-control mydate must" name="breakecaseSuspect_captureTime" type="text" value="${all_td.eq(7).text()}"></td></tr>
								</tbody>
								</table>`;
				var modifi = $.confirm({
					closeIcon: true,
					boxWidth: '50%',
					useBootstrap: false,
					smoothContent: false,
					title: '嫌疑人信息修改',
					content: mo_SuspectData,
					onContentReady: function () {
						Init();
					},
					buttons: {
						sureAdd: {
							text: '确认修改',
							btnClass: 'btn-info',
							action: function () {
								var len = suspect.length;
								modifi.$content.find('input').each(function () {
									var name = $(this).attr('name');
									var value = $(this).val();
									suspect[len - index - 1][name] = value;
								});
								tr.html(function () {
									var str = '';
									for (const key in suspect[len - index - 1]) {
										str += `<td>${suspect[len - index - 1][key]}</td>`;
									}
									str += '<td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>'
									return str;
								});
							}
						},
						close: {
							text: '取消',
							action: function () { }
						},
					}
				});
			} else if (i.className == "fa fa-trash-o") { //删除
				tr.remove();
			}
		}
	});
}

$.fn.extend({
	serializeObject: function () {
		if (this.length > 1) {
			return false;
		}
		var arr = this.serializeArray();
		var obj = new Object;
		$.each(arr, function (k, v) {
			obj[v.name] = v.value;
		});
		return obj;
	}
});

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
}