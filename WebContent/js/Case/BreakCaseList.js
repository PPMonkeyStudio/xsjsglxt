var query_data = {
	"breakeCaseListVO.currPage" : "1",
	"breakeCaseListVO.query_sence_inquestId" : "",
	"breakeCaseListVO.query_case_name" : "", //案件名称
	"breakeCaseListVO.query_breake_time_start" : "",
	"breakeCaseListVO.query_breake_time_end" : "",
	"breakeCaseListVO.query_breake_person" : "",
	"breakeCaseListVO.query_breake_according" : "",
	"breakeCaseListVO.query_breake_time_sort" : "desc",
};
//当前页面分页信息
var page_infomantion = {
	currPage : 1,
	totalPage : 1,
	totalCount : 10,
	pageSize : 1,
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

var braekeCaseData = `<form action="">
<div style="width: 100%;margin: auto;" class="panel-body"><table class="table table-hover table-condensed" align="center"><tbody>
<tr><td>所属案件<i class="fa fa-spinner fa-pulse load_remind"></i></td><td style="width:863px;" colspan="3">
<select class="form-control selectpicker" data-live-search="true" name="breakeCase.breakecase_case" title="请选择..."></select></td>
</tr><tr><td>案件类型</td><td>
<input class="form-control" name="breakeCase.breakecase_type" type="text">
</td><td>破案方式</td><td>
<select class="form-control" name="breakeCase.breakecase_according"><option value=""></option><option value="指纹">指纹</option><option value="视频">视频</option><option value="DNA">DNA</option></select>
</td></tr><tr><td>破案时间</td><td>
<input class="form-control mydate" name="breakeCase.breakecase_caseTime" type="text">
</td><td>破案人</td><td>
<select class="form-control" data-live-search="true" name="breakeCase.breakecase_person"></select>
</td></tr><tr><td>带破案件</td><td colspan="3">
<select class="form-control selectpicker" multiple data-selected-text-format="count > 3" data-live-search="true" name="breakeCase.breakecase_waitbreakecase" title="请选择..."></select>
</td></tr><tr><td>备注</td><td colspan="3">
<textarea placeholder="请填写" class="form-control"name="breakeCase.breakecase_remarks"></textarea>
</td></tr><tr>
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
</thead><tbody></tbody></table></tr></tbody></table></div></form>`;

var SuspectData = `<table class="table">
<tbody>
<tr><td>姓名</th><td><input class="form-control must" name="breakecaseSuspect_name" type="text" value=""></td>
    <td>身份证号</th><td><input class="form-control must su-IDnum" name="breakecaseSuspect_IDnum" type="text" value=""></td></tr>
<tr><td>性别</th><td><input class="form-control must su-sex" name="breakecaseSuspect_sex" type="text" value=""></td>
    <td>生日</th><td><input class="form-control must su-birthday" name="breakecaseSuspect_birthday" type="text" value=""></td></tr>
<tr><td>住址</th><td><input class="form-control must" name="breakecaseSuspect_addrress" type="text" value=""></td>
	<td>是否抓获</th><td><select class="form-control must" name="breakecaseSuspect_capture"><option>是</option><option>否</ption>
<option>其他</option></select></td></tr>
<tr><td>抓获单位</th><td><input class="form-control must" name="breakecaseSuspect_captureUnit" type="text" value=""></td>
	<td>抓获时间</th><td><input class="form-control mydate must" name="breakecaseSuspect_captureTime" type="text" value=""></td></tr>
</tbody>
</table>`;

//保存嫌疑人信息
var suspect = [];

$(function() {

	get_ListBreakecaseInformationByPageAndSearch(query_data);

	$('.to_quert').click(function() {
		var arr = $('#query_infomantion_inmodal').serializeArray();
		$.each(arr, function(key, value) {
			//key为arr里对象的索引，value为索引为key的对象。对象以{name: 'firstname', value: 'Hello'}形式存储, 以obj.name和obj.value形式遍历 
			query_data[value.name] = value.value;
		});
		get_ListBreakecaseInformationByPageAndSearch(query_data);
	});

	$('.empty_quert').click(function() {
		for (var i in query_data) {
			query_data[i] = "";
		}
		//页面重置为第一页
		query_data["breakeCaseListVO.currPage"] = 1;
		//选择框清除内容
		$('#newQuery').find('input,select').val('');
		;
		/*//影藏模态框
		$('#newQuery').modal('hide');*/
		//成功提示
		toastr.info('清除查询信息成功');
	});

	$('#delete-breakeCase').click(function() {
		var formData = new FormData;
		var falg = false;
		$('.breakcase_table_info').find('input[name="chooseCheckBox"]').each(function() {
			if ($(this).is(':checked')) {
				formData.append('breakeCaseId', $(this).attr('id'));
				falg = true;
			}
		});
		if (falg) {
			$.ajax({
				url : "/xsjsglxt/case/BreakeCase_deleteBreakeCase",
				type : "POST",
				contentType : false,
				processData : false,
				data : formData,
				dataType : 'text',
				success : function(msg) {
					if (msg == 'deleteSuccess') {
						toastr.info('删除成功');
						get_ListBreakecaseInformationByPageAndSearch(query_data);
					} else if (msg == 'deleteError') {
						toastr.error('删除失败');
					}
				}
			});
		} else {
			toastr.info('未选择数据');
		}
	});

	$('#breakCase_input').click(function() {
		var addBreakeCase = $.confirm({
			closeIcon : true,
			boxWidth : '80%',
			useBootstrap : false,
			smoothContent : false,
			title : '破案信息添加',
			content : braekeCaseData,
			onContentReady : function() {
				//日期，身份证识别
				Init();
				//嫌疑人表中的修改，删除事件
				Suspect_mo_del(addBreakeCase, "add");
				//查询所有案件并添加
				$.post('/xsjsglxt/case/Case_AllCase', {}, function(Case_data) {
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
				$.post('/xsjsglxt/team/Staff_getAllPolicemans', {}, function(params) {
					var suspectStr = '';
					for (let index = 0; index < params.length; index++) {
						suspectStr += '<option value="' + params[index]["xsjsglxt_name"] + '">' + params[index]["xsjsglxt_name"] + '</option>';
					}
					$('select[name="breakeCase.breakecase_person"]').html(suspectStr).selectpicker('refresh').addClass('col-lg-12');
				}, 'json');
			},
			buttons : {
				addProson : {
					text : '添加嫌疑人',
					btnClass : 'btn-info',
					action : function() {
						/*===================================================== 破案窗口中嫌疑人添加*/
						var Suspect = $.confirm({
							closeIcon : true,
							boxWidth : '50%',
							useBootstrap : false,
							smoothContent : false,
							title : '嫌疑人添加',
							content : SuspectData,
							onContentReady : function() {
								Init();
							},
							buttons : {
								sureAddProson : {
									text : "确认添加", /*===================================================== 确认嫌疑人添加*/
									btnClass : 'btn-info',
									action : function() {
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
								close : {
									text : "取消"
								}
							}
						});
						return false;
					}
				},
				sureAdd : {
					text : '确认添加', /*===================================================== 确认破案添加*/
					btnClass : 'btn-info',
					action : function() {
						addBreakeCase.$content.find('form').serializeObject();
						var suspects = {};
						for (let index = 0; index < suspect.length; index++) {
							for (const key in suspect[index]) {
								suspects['suspectList[' + index + '].' + key] = suspect[index][key];
							}
						}
						var data = $.extend({}, suspects, addBreakeCase.$content.find('form').serializeObject());
						var formData = new FormData();
						for (const key in data) {
							formData.append(key, data[key]);
						}
						var breakeCaseDetails = addBreakeCase.$content.find('select[name="breakeCase.breakecase_waitbreakecase"] option:selected');
						for (let index = 0; index < breakeCaseDetails.length; index++) {
							formData.append("takeBreakeCase", breakeCaseDetails[index].text);
						}
						$.ajax({
							url : '/xsjsglxt/case/BreakeCase_saveBreakeCase',
							type : 'POST',
							cache : false,
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'text',
							success : function(xhr) {
								if (xhr == 'caseIsBreake') {
									toastr.error('此案件已经包含破案情况！');
									return false;
								} else if (xhr == 'saveSuccess') {
									toastr.info('成功添加');
									get_ListBreakecaseInformationByPageAndSearch(query_data);
								} else if (xhr == 'saveError') {
									toastr.info('添加失败');
								}
								suspect = [];
							},
							error : function(msg) {}
						});
					/*$.post('/xsjsglxt/case/BreakeCase_saveBreakeCase', data, function (xhr) {
						if (xhr == 'caseIsBreake') {
							toastr.error('此案件已经包含破案情况！');
							return false;
						} else if (xhr == 'saveSuccess') {
							toastr.info('成功添加');
							get_ListBreakecaseInformationByPageAndSearch(query_data);
						} else if (xhr == 'saveError') {
							toastr.info('添加失败');
						}
						suspect = [];
					}, 'text');*/
					}
				},
				close : {
					text : '取消',
					action : function() {}
				},
			}
		});
	});



	//表格中I标签的操作绑定
	$('.breakcase_table_info tbody').click(function(e) {
		if (e.target.tagName == "TD") {
			var ID = $(e.target).parent().find('input[name="chooseCheckBox"]').attr('id');
			$.post('/xsjsglxt/case/BreakeCase_breakeCaseDetails', {
				"breakeCase.xsjsglxt_breakecase_id" : ID
			}, function(msg) {
				var breakeCaseID = msg.breakeCase.xsjsglxt_breakecase_id;
				var content = `<form action="">
			<div style="width: 100%;margin: auto;" class="panel-body"><table class="table table-hover table-condensed" align="center"><tbody>
			<tr><td style="witdh:20%;">所属案件<i class="fa fa-spinner fa-pulse load_remind"></i></td><td colspan="3">
			<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="breakeCase.breakecase_case" title="请选择..."></select></td>
			</tr><tr><td>案件类型</td><td>
			<input class="form-control" name="breakeCase.breakecase_type" type="text" value="${msg.breakeCase.breakecase_type}">
			</td><td>破案方式</td><td>
			<select class="form-control" name="breakeCase.breakecase_according"><option value=""></option><option value="指纹">指纹</option><option value="视屏">视屏</option><option value="NDA">NDA</option></select>
			</td></tr><tr><td>破案时间</td><td>
			<input class="form-control mydate" name="breakeCase.breakecase_caseTime" type="text" value="${msg.breakeCase.breakecase_caseTime}">
			</td><td>破案人</td><td>
			<select class="form-control" name="breakeCase.breakecase_person"></select>
			</td></tr><tr><td>带破案件<i id="${breakeCaseID}" onclick="breakeCaseDetails(this)" class="fa fa-book" aria-hidden="true"></i></td><td colspan="3">
			<select class="form-control selectpicker" multiple data-live-search="true" name="breakeCase.breakecase_waitbreakecase"></select>
			</td></tr><tr><td>备注</td><td colspan="3">
			<textarea placeholder="请填写" class="form-control"name="breakeCase.breakecase_remarks">${msg.breakeCase.breakecase_remarks}</textarea>
			</td></tr><tr>
			<table class="table table-hover suspect-info">
			<thead><tr><td>姓名</td><td>身份证号</td><td>性别</td><td>生日</td><td>住址</td><td>抓获</td><td>抓获单位</td><td>抓获时间</td><td>操作</td>
			</tr></thead><tbody></tbody></table></tr></tbody></table></div></form>`;
				var modifyBreakeCase = $.confirm({
					closeIcon : true,
					columnClass : 'col-md-12',
					boxWidth : '1000px',
					useBootstrap : true,
					smoothContent : false,
					title : '破案信息修改',
					content : content,
					onContentReady : function() {
						$('select[name="breakeCase.breakecase_according"]').val(msg.breakeCase.breakecase_according);
						$.post('/xsjsglxt/team/Staff_getAllPolicemans', {}, function(params) {
							var suspectStr = '';
							for (let index = 0; index < params.length; index++) {
								suspectStr += '<option value="' + params[index]["xsjsglxt_name"] + '">' + params[index]["xsjsglxt_name"] + '</option>';
							}
							$('select[name="breakeCase.breakecase_person"]').html(suspectStr).selectpicker('refresh').selectpicker('val', msg.breakeCase.breakecase_person);
						}, 'json');
						Init();
						for (let index = 0; index < msg.suspectList.length; index++) {
							var _suspect = msg.suspectList[index];
							var suspectStr = '<tr id="' + breakeCaseID + '">';
							for (const key in _suspect) {
								if (key == 'xsjsglxt_breakecaseSuspect_id' || key == 'breakecaseSuspect_breakecase' || key == 'breakecaseSuspect_gmt_create' || key == 'breakecaseSuspect_gmt_modified') {
									continue;
								}
								suspectStr += `<td>${_suspect[key]}</td>`;
							}
							suspectStr += '<td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>'
							modifyBreakeCase.$content.find('.suspect-info tbody').append(suspectStr);
						}
						//嫌疑人表中的修改，删除事件
						Suspect_mo_del(modifyBreakeCase, "modify");
						//查询所有案件并添加
						$.post('/xsjsglxt/case/Case_AllCase', {}, function(Case_data) {
							//所有案件循环
							var option = '';
							var option2 = '';
							for (var len = 0; len < Case_data.length; len++) {
								option += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
								option2 += '<option value="' + Case_data[len].case_name + '">' + Case_data[len].case_name + '</option>';
							}
							modifyBreakeCase.$content.find('select[name="breakeCase.breakecase_case"]').html(option).selectpicker('val', msg.breakeCase.breakecase_case).selectpicker('refresh');
							modifyBreakeCase.$content.find('select[name="breakeCase.breakecase_waitbreakecase"]').html(option).selectpicker('val', msg.breakeCase.breakecase_waitbreakecase).selectpicker('refresh');
							//除去加载提示
							modifyBreakeCase.$content.find('.load_remind').hide();
						}, 'json');
					},
					buttons : {
						addProson : {
							text : '嫌疑人添加',
							btnClass : 'btn-info',
							action : function() {
								var Suspectadd = $.confirm({
									closeIcon : true,
									boxWidth : '50%',
									useBootstrap : false,
									smoothContent : false,
									title : '嫌疑人添加',
									content : SuspectData,
									onContentReady : function() {
										Init();
									},
									buttons : {
										sureAddProson : {
											text : "确认添加",
											btnClass : 'btn-info',
											action : function() {
												var must = Suspectadd.$content.find('.must');
												for (let index = 0; index < must.length; index++) {
													if (must.eq(index).val() == "") {
														toastr.info('信息未填写完整，请检查空项信息!');
														return false;
													}
												}
												var suspect_add = {
													"suspect.breakecaseSuspect_breakecase" : breakeCaseID,
												};
												Suspectadd.$content.find('.must').each(function() {
													suspect_add["suspect." + $(this).attr('name')] = $(this).val();
												});
												$.post('/xsjsglxt/case/BreakeCase_addOneSuspect', suspect_add, function(msg_one) {
													if (msg_one.length > 20 && msg_one.length <= 36) {
														toastr.info('添加嫌疑人成功');
														var suspectStr = '<tr id="' + msg_one + '">';
														for (const key in suspect_add) {
															if (key == "suspect.breakecaseSuspect_breakecase") {
																continue;
															}
															suspectStr += `<td>${suspect_add[key]}</td>`;
														}
														suspectStr += '<td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>'
														modifyBreakeCase.$content.find('.suspect-info tbody').append(suspectStr);
													} else if (msg_one == 'saveError') {
														toastr.error('添加嫌疑人人失败');
													}
												}, 'text');
											}
										},
										close : {
											text : '取消',
											action : function() {}
										}
									}
								});
								return false;
							}
						},
						modifi : {
							text : '修改',
							btnClass : 'btn-info',
							action : function() {
								var BreakeCaseDATA = modifyBreakeCase.$content.find('form').serializeObject();
								BreakeCaseDATA["breakeCase.xsjsglxt_breakecase_id"] = ID;
								$.post('/xsjsglxt/case/BreakeCase_updateBreakeCase', BreakeCaseDATA, function(xhr) {
									if (xhr == 'updateSuccess') {
										toastr.info('息修改成功');
										get_ListBreakecaseInformationByPageAndSearch(query_data);
									} else if (xhr == 'updateError') {
										toastr.error('破案信息修改失败');
										return false;
									}
								}, 'text');
							}
						},
						close : {
							text : '取消',
							action : function() {}
						},
					}
				});
			}, 'json');
		}
	});

})

function get_ListBreakecaseInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/BreakeCase_breakeCaseByPage', data, function(xhr) {
		var data_list = xhr.breakeCaseDTOList;
		var str = '';
		for (var len = 0; len < data_list.length; len++) {
			str += '<tr>';
			str += '<td><input name="chooseCheckBox" id="' + data_list[len].xsjsglxt_breakecase_id + '" type="checkbox"></td>';
			//str += '<td><a href="/xsjsglxt/case/Case_page_CaseDetails?id=' + data_list[len].case1.xsjsglxt_case_id + '">' + data_list[len].sence.snece_inquestId + '</a></td>';
			str += '<td>' + (data_list[len].case_name).replace('萍乡市安源区', '') + '</td>';
			str += '<td>' + data_list[len].snece_inquestId + '</td>';
			//str += '<td>' + data_list[len].breakecase_type + '</td>';
			str += '<td>' + data_list[len].breakecase_person + '</td>';
			str += '<td>' + data_list[len].breakecase_according + '</td>';
			str += '<td>' + data_list[len].breakecase_caseTime + '</td>';
		}
		//加载到表格中
		$('.breakcase_table_info tbody').html(str);
		//分页信息存入page_infomantion中
		page_infomantion.pageIndex = xhr.currPage; //当前页数
		page_infomantion.totalRecords = xhr.totalPage; //总页数
		page_infomantion.pageSize = xhr.pageSize; //每页记录数
		page_infomantion.totalPages = xhr.totalCount; //总记录数
		//page_infomantion.HavePrePage = xhr.HavePrePage; //是否有上一页
		//page_infomantion.HaveNextPage = xhr.HaveNextPage; //是否有下一页

		$('.info').html('共 ' + xhr.totalCount + '条信息 当前' + xhr.currPage + '/' + xhr.totalPage + '页 ' + xhr.pageSize + '条信息/页');
		//影藏模态框
		$('#newQuery').modal('hide')
	}, 'json')
}


//创建一个嫌疑人对象
function createSuspect(confirm_content) {
	var newSuspect = {};
	var name = '';
	var val = '';
	$.each(confirm_content.find('.must'), function() {
		name = $(this).attr("name");
		val = $(this).val();
		newSuspect[name] = val;
	});
	return newSuspect;
}

//初始化操作---日期，身份证中生日男女的自动识别，
function Init() {
	$('.mydate').datetimepicker({
		yearStart : 1900, // 设置最小年份
		yearEnd : 2100, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : false, // 关闭时间选项
		format : 'Y-m-d', // 格式化日期年-月-日
		minDate : '1900/01/01', // 设置最小日期
		maxDate : '2100/01/01', // 设置最大日期
	});
	$('.su-IDnum').on('keyup', function() {
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

function Suspect_mo_del(TypeBreakeCase, type) {
	TypeBreakeCase.$content.find('.suspect-info').on('click', function(e) {
		if (e.target.tagName == 'I') {
			var i = e.target;
			var tr = $(i).parents('tr');
			var index = tr.index();
			var all_td = tr.find('td');
			if (i.className == "fa fa-info-circle") { //修改
				var mo_SuspectData = `<table class="table">
								<tbody>
								<tr><td>姓名</td><td><input class="form-control must" name="breakecaseSuspect_name" type="text" value="${all_td.eq(0).text()}"></td>
									<td>身份证号</td><td><input class="form-control must" name="breakecaseSuspect_IDnum" type="text" value="${all_td.eq(1).text()}"></td></tr>
								<tr><td>性别</td><td><input class="form-control must" name="breakecaseSuspect_sex" type="text" value="${all_td.eq(2).text()}"></td>
									<td>生日</td><td><input class="form-control must" name="breakecaseSuspect_birthday" type="text" value="${all_td.eq(3).text()}"></td></tr>
								<tr><td>住址</td><td><input class="form-control must" name="breakecaseSuspect_addrress" type="text" value="${all_td.eq(4).text()}"></td>
									<td>是否抓获</td><td><select class="form-control must" name="breakecaseSuspect_capture" type="text" value="${all_td.eq(5).text()}"><option>是</option><option>否</option></select></td></tr>
								<tr><td>抓获单位</td><td><input class="form-control must" name="breakecaseSuspect_captureUnit" type="text" value="${all_td.eq(6).text()}"></td>
									<td>抓获时间</td><td><input class="form-control mydate must" name="breakecaseSuspect_captureTime" type="text" value="${all_td.eq(7).text()}"></td></tr>
								</tbody>
								</table>`;
				var modifi = $.confirm({
					closeIcon : true,
					boxWidth : '50%',
					useBootstrap : false,
					smoothContent : false,
					title : '嫌疑人信息修改',
					content : mo_SuspectData,
					onContentReady : function() {
						Init();
					},
					buttons : {
						sureAdd : {
							text : '确认修改',
							btnClass : 'btn-info',
							action : function() {
								if (type == "modify") {
									var zj = {
										"suspect.xsjsglxt_breakecaseSuspect_id" : tr.attr('id'),
									};
									modifi.$content.find('.must').each(function() {
										zj['suspect.' + $(this).attr('name')] = $(this).val();
									});
									$.post('/xsjsglxt/case/BreakeCase_updateSuspect', zj, function(msg) {
										if (msg == 'updateSuccess') {
											toastr.info('修改嫌疑人成功');
											modifi.$content.find('.must').each(function(i, o) {
												all_td.eq(i).text($(this).val());
											});
										} else if (msg == 'updateError') {
											toastr.error('修改嫌疑人失败');
										}
									}, 'text');
								} else {
									var len = suspect.length;
									modifi.$content.find('.must').each(function() {
										var name = $(this).attr('name');
										var value = $(this).val();
										suspect[len - index - 1][name] = value;
									});
									tr.html(function() {
										var str = '';
										for (const key in suspect[len - index - 1]) {
											str += `<td>${suspect[len - index - 1][key]}</td>`;
										}
										str += '<td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>'
										return str;
									});
								}
							}
						},
						close : {
							text : '取消',
							action : function() {}
						},
					}
				});
			} else if (i.className == "fa fa-trash-o") { //删除
				if (type == "modify") {
					var zj = {
						"suspectId" : tr.attr('id'),
					};
					$.post('/xsjsglxt/case/BreakeCase_deleteSuspect', zj, function(msg) {
						if (msg == 'deleteSuccess') {
							toastr.info('删除嫌疑人成功');
							tr.remove();
						} else if (msg == 'deleteError') {
							toastr.error('删除嫌疑人失败');
							return false;
						}
					}, 'text');
				} else {
					tr.remove();
				}
			}
		}
	});
}

//序列化为对象
$.fn.extend({
	serializeObject : function() {
		if (this.length > 1) {
			return false;
		}
		var arr = this.serializeArray();
		var obj = new Object;
		$.each(arr, function(k, v) {
			obj[v.name] = v.value;
		});
		return obj;
	}
});

//带破案件列表
function breakeCaseDetails(params) {
	$.post('/xsjsglxt/case/BreakeCase_getTakeBreakeCaseByBreakeCaseId', {
		"breakeCase.xsjsglxt_breakecase_id" : params.id
	}, function(msg) {
		var tablein = `<table class="table"><tbody>`;
		for (const key in msg) {
			if (msg.hasOwnProperty(key)) {
				tablein += `<tr><td>${msg[key]["take_name"]}</td></tr>`;
			}
		}
		tablein += `</tbody ></table > `;
		var breakeCaseDetail = $.confirm({
			closeIcon : true,
			boxWidth : '50%',
			useBootstrap : false,
			smoothContent : false,
			title : '带破案件',
			content : tablein,
			onContentReady : function() {},
			buttons : {
				sureAdd : {
					text : '确认',
					btnClass : 'btn-info',
					action : function() {}
				}
			}
		});
	}, 'json');
}

//输入框查询事件
function dynamic_query(params) {
	query_data[$(params).attr('query_name')] = $(params).val();
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}

//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['breakeCaseListVO.currPage'] = 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['breakeCaseListVO.currPage'] = page_infomantion.pageIndex - 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['breakeCaseListVO.currPage'] = page_infomantion.pageIndex + 1;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['breakeCaseListVO.currPage'] = page_infomantion.totalPages;
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}
//跳转到n页
function toPage(object) {
	query_data['breakeCaseListVO.currPage'] = $(object).val();
	get_ListBreakecaseInformationByPageAndSearch(query_data);
}