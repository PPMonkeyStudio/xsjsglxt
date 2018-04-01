
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
/*--------------------------------------------------------*/
//判断身份证号是否正确，以及从身份证号中取出出生日期
function BreakCaseListGetBirth(){
	var breakcase_suspecter_identity=document.getElementById("breakcase_suspecter_identity");
	var breakcase_suspecter_identityValue=breakcase_suspecter_identity.value.trim();
	var breakcase_suspecter_birthday=document.getElementById("breakcase_suspecter_birthday");
	var strRegExp=/(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(strRegExp.test(breakcase_suspecter_identityValue)==true){
			breakcase_suspecter_birthday.value=breakcase_suspecter_identityValue.substr(6,4)+"-"+breakcase_suspecter_identityValue.substr(10,2)+"-"+breakcase_suspecter_identityValue.substr(12,2);
		} 
		else{
			toastr.error("身份证号输入不合法！");
			return false;
		} 
	
}
$(function() {

	/*--------------------------------------------------------*/	
	//刑事破案添加模态框事件
	$('#breakCase_input').on('show.bs.modal', function() {
		var this_modal = $(this);
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			//所有案件循环
			var option = '';
			for (var len = 0; len < Case_data.length; len++) {
				option += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			this_modal.find('.selectpicker').html(option).selectpicker('refresh');
			//除去加载提示
			this_modal.find('.load_remind').remove();
		}, 'json');

	})
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
/*--------------------------------------------------------*/
//添加刑事破案
	$('.input_sure').click(function() {
		$.post('/xsjsglxt/case/BreakCase_saveBreakecase', $('#breakCase_input form').serialize(), function(xhr) {
			if (xhr == 'success') {
				toastr.success('添加成功!');
				get_ListBreakecaseInformationByPageAndSearch(query_data);
				$('#breakCase_input').find('input,select,textarea').val('');
			}
		}, 'text')
	});
//执行列表查询
	get_ListBreakecaseInformationByPageAndSearch(query_data);
})
/*--------------------------------------------------------*/
//列表查询
function get_ListBreakecaseInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/BreakCase_ListBreakCaseInformationByPageAndSearch', data, function(xhr) {
		var data_list = xhr.BreakecaseInformationDTOList;
		var str = '';
		for (var len = 0; len < data_list.length; len++) {
			str += '<tr>';
			str += '<td>' + (len + 1) + '</td>';//序号
			//所属案件
			str += '<td><a href="/xsjsglxt/case/Case_page_CaseDetails?id=' + data_list[len].case1.xsjsglxt_case_id + '">' + data_list[len].sence.snece_inquestId + '</a></td>';
			str += '<td>' + data_list[len].breakCase.breakcase_type + '</td>';//案件类型
			str += '<td>' + data_list[len].breakCase.breakcase_according + '</td>';//破案依据
			str += '<td>' + data_list[len].breakCase.breakcase_arrested + '</td>';//是否抓获
			str += '<td>' + data_list[len].breakCase.breakcase_arrested_department + '</td>';//抓获单位
			str += '<td>' + data_list[len].breakCase.breakcase_waitbreakcase + '</td>';//带破案件
			str += '<td>' + data_list[len].breakCase.breakcase_suspecter_name + '</td>';//嫌疑人姓名
			str += '<td>' + data_list[len].breakCase.breakcase_contrast_locale_fingerprint_number + '</td>';//现场指纹编号
			
			str += '<td>'
				+ '<input type="hidden" value="' + data_list[len].breakCase.xsjsglxt_breakcase_id + '" />'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#breakCase_modification"><i class="fa fa-pencil-square-o" aria-hidden="true" ></i> 修改</button>'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
				+ '</td>';
			str += '</tr>';
		}
//		console.log('0000:'+str);
		//加载到表格中
		$('.breakcase_table_info tbody').html(str); //操作点击事件
		
//		-----------------------------------------------------
		//设置点击事件
		$('.btn-xs').click(modifi_delete);
//		-----------------------------------------------------
		
		
		
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
		$.post('/xsjsglxt/case/BreakCase_getBreakCaseInfo', {
			"breakCase.xsjsglxt_breakcase_id" : id
		}, function(xhr_data) {
			var str = '';
			str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
			str += '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind"></td><td colspan="3">';
			str += '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="breakCase.breakcase_case">';
			str += '</select></td>';
			str += '</tr>';
			
			str += '<tr>';
			str += '<td>案件类型</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_type" type="text" value="' + xhr_data.breakCase.breakcase_type + '"  /></td>';
			/*str += '<td>案件类型</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakCase.breakcase_type">';
			str += '<option ' + (xhr_data.breakcase_type == "新添案件" ? "selected" : "") + '>新添案件</option>';
			str += '<option ' + (xhr_data.breakcase_type == "已有案件" ? "selected" : "") + '>已有案件</option>';
			str += '</select></td>';*/
			str += '<td>嫌疑人姓名</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_suspecter_name" type="text" value="' + xhr_data.breakcase_suspecter_name + '"  /></td>';
			str += '</tr>';
			

			str += '<tr>';
			str += '<td>案件级别</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakCase.breakcase_case_level">';
			str += '<option ' + (xhr_data.breakcase_case_level == "A级" ? "selected" : "") + '>A级</option>';
			str += '<option ' + (xhr_data.breakcase_case_level == "B级" ? "selected" : "") + '>B级</option>';
			str += '<option ' + (xhr_data.breakcase_case_level == "C级" ? "selected" : "") + '>C级</option>';
			str += '</select></td>';
			str += '<td>性别</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakCase.breakcase_suspecter_sex">';
			str += '<option ' + (xhr_data.breakcase_suspecter_sex == "男" ? "selected" : "") + '>男</option>';
			str += '<option ' + (xhr_data.breakcase_suspecter_sex == "女" ? "selected" : "") + '>女</option>';
			str += '</select></td>';
			
			
			str += '<tr>';
			str += '<td>案件属地</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakCase.breakcase_case_territorial">';
			str += '<option ' + (xhr_data.breakcase_case_territorial== "本地" ? "selected" : "") + '>本地</option>';
			str += '<option ' + (xhr_data.breakcase_case_territorial == "外地" ? "selected" : "") + '>外地</option>';
			str += '<option ' + (xhr_data.breakcase_case_territorial == "公安部协查" ? "selected" : "") + '>公安部协查</option>';
			str += '</select></td>';
			str += '<td>身份证号码</td><td><input style="witdh: 70%;" class="form-control" name="breakCase.breakcase_suspecter_identity" id="breakcase_suspecter_identity" type="text" onblur="BreakCaseListGetBirth()" maxlength="18" value="' + xhr_data.breakcase_suspecter_identity + '"  /></td>';
			str += '</tr>';
			
			
			
			
			str += '<tr>';
			str += '<td>破案依据</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_according" type="text" value="' + xhr_data.breakcase_according + '"  /></td>';
			str += '<td>出生日期</td><td><input style="witdh:70%;" class="form-control mydate" name="breakCase.breakcase_suspecter_birthday" type="text" value="' + xhr_data.breakcase_suspecter_birthday + '"  /></td>';
			str += '</tr>';
			
			
			str += '<tr>';
			str += '<td>是否抓获</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakCase.breakcase_arrested">';
			str += '<option ' + (xhr_data.breakcase_arrested== "是" ? "selected" : "") + '>是</option>';
			str += '<option ' + (xhr_data.breakcase_arrested == "否" ? "selected" : "") + '>否</option>';
			str += '</select></td>';
			str += '<td>户籍地</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_suspecter_domicile" type="text" value="' + xhr_data.breakcase_suspecter_domicile + '"  /></td>';
			str += '</tr>';
			
			
			str += '<tr>';
			str += '<td>抓获单位</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_arrested_department" type="text" value="' + xhr_data.breakcase_arrested_department + '"  /></td>';
			str += '<td>现住址</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_present_address" type="text" value="' + xhr_data.breakcase_present_address + '"  /></td>';
			str += '</tr>';
			
			
			
			str += '<tr>';
			str += '<td>带破案件</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_waitbreakcase" type="text" value="' + xhr_data.breakcase_waitbreakcase + '"  /></td>';
			str += '<td>联系电话</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_phone" type="text" value="' + xhr_data.breakcase_phone + '"  /></td>';
			str += '</tr>';
			
			
			/*str += '<tr>';
			str += '<td>简要案情</td><td colspan="3"><textarea  style="witdh:70%;display:none;" class="form-control" name="briefDetails.xsjsglxt_briefdetails_id"  >' + xhr_data.breakcase_case_note+ '</textarea>';
			str +='<textarea style="witdh:70%;" class="form-control" name="briefDetails.briefdetails_details"></textarea>';
			str += '</td>';
			str += '</tr>';*/
			
			str += '<tr>';
			str += '<td>现场指纹编号</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_locale_fingerprint_number" type="text" value="' + xhr_data.breakcase_contrast_locale_fingerprint_number + '"  /></td>';
			str += '<td>按印指纹编号</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_press_fingerprint_number" type="text" value="' + xhr_data.breakcase_contrast_press_fingerprint_number + '"  /></td>';
			str += '</tr>';
			
			
			str += '<tr>';
			str += '<td>比对时间</td><td><input style="witdh:70%;" class="form-control mydate" name="breakCase.breakcase_contrast_time" type="text" value="' + xhr_data.breakcase_contrast_time + '"  /></td>';
			str += '<td>比对方式</td><td>';
			str += '<select style="witdh:100%;" class="form-control" data-live-search="true" name="breakCase.breakcase_contrast_way">';
			str += '<option ' + (xhr_data.breakcase_contrast_way== "正查" ? "selected" : "") + '>正查</option>';
			str += '<option ' + (xhr_data.breakcase_contrast_way == "倒查" ? "selected" : "") + '>倒查</option>';
			str += '<option ' + (xhr_data.breakcase_contrast_way == "人工" ? "selected" : "") + '>人工</option>';
			str += '</select></td>';
			str += '</tr>';
			
			
			
			str += '<tr>';
			str += '<td>比对单位</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_department" type="text" value="' + xhr_data.breakcase_contrast_department + '"  /></td>';
			str += '<td>比对人</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_contraster" type="text" value="' + xhr_data.breakcase_contrast_contraster + '"  /></td>';
			str += '</tr>';
			
			str += '<tr>';
			str += '<td>按印部门</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_press_department" type="text" value="' + xhr_data.breakcase_contrast_press_department + '"  /></td>';
			str += '<td>提取部门</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_extract_department" type="text" value="' + xhr_data.breakcase_contrast_extract_department + '"  /></td>';
			str += '</tr>';
			
			str += '<tr>';
			str += '<td>按印人</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_presser" type="text" value="' + xhr_data.breakcase_contrast_presser + '"  /></td>';
			str += '<td>提取人</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_extracter" type="text" value="' + xhr_data.breakcase_contrast_extracter + '"  /></td>';
			str += '</tr>';
			
			str += '<tr>';
			str += '<td>按印时间</td><td><input style="witdh:70%;" class="form-control mydate" name="breakCase.breakcase_contrast_press_time" type="text" value="' + xhr_data.breakcase_contrast_press_time + '"  /></td>';
			str += '<td>指位</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_fingerposition" type="text" value="' + xhr_data.breakcase_contrast_fingerposition + '"  /></td>';
			str += '</tr>';
			
			str += '<tr>';
			str += '<td>复核人</td><td><input style="witdh:70%;" class="form-control" name="breakCase.breakcase_contrast_reviewer" type="text" value="' + xhr_data.breakcase_contrast_reviewer + '"  /></td>';
			str += '<td>抓获时间</td><td><input style="witdh:70%;" class="form-control mydate" name="breakCase.breakcase_arrested_time" type="text" value="' + xhr_data.breakcase_arrested_time + '"  /></td>';
			str += '</tr>';
			
			str += '<tr>';
			str += '<td>备注</td><td  colspan="3"><textarea style="witdh:70%;" class="form-control" name="breakCase.breakcase_remark">' + xhr_data.breakcase_remarks + '</textarea>';
			//添加存丢失物的id隐藏域(上一兄元素为备注文本域)
			str += '<input name="breakCase.xsjsglxt_breakcase_id" type="hidden" value="' + xhr_data.xsjsglxt_breakcase_id + '" />';
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
					if (xhr_data.breakcase_case == Case_data[len].case_name) {
						option += 'selected';
					}
					option += ' value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
				}
				$('.selectpicker').html(option).selectpicker('refresh');
				//除去加载提示
				$('.load_remind').remove();
			}, 'json');
			//确认按钮添加事件
			$('.breakCase_operation').unbind().click(breakecase_modification);
		}, 'json');


	} else if (type == "删除") {
		var formData = new FormData();
		formData.append('breakCaseInIdList', id);
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
							url : '/xsjsglxt/case/BreakCase_removeBreakCaseInfo',
							type : 'post',
							data : formData,
							processData : false,
							contentType : false,
							dataType : 'text',
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
					$.post('/xsjsglxt/case/BreakCase_updateBreakcase', $('#breakCase_modification form').serialize(), function(data) {
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
			cancelAction : {
				btnClass : 'btn-blue',
				text : '取消',
			}
		}
	});
}

/*$("#breakcase_type").change(function (){
	if($("#breakcase_type").val()=="已有案件"){
		$("#breakcase_case").prop('disabled', false).selectpicker('refresh');
	}else{
		$("#breakcase_case").prop('disabled', true).selectpicker('refresh');
	}
	});
*/

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