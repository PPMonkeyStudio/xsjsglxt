var query_data = {
	"page_list_ResevidenceInformation.pageIndex" : "1",
	"page_list_Casematerial.pageIndex" : "1",
	"page_list_imageInformation.pageIndex" : "1",
	"page_list_ResevidenceInformation.resevidence_extractPerson" : "",
}


$(function() {
	$('#lost').on('hide.bs.modal', function() {
		setTimeout(function() {
			$('#lost .panel-body').empty();
		}, 200)
	})
	$('#evidence').on('hide.bs.modal', function() {
		setTimeout(function() {
			$('#evidence tbody').empty();
		}, 200)
	})
	//搜索框change事件
	$('.Search_extractPerson').keyup(function() {
		query_data["page_list_ResevidenceInformation.resevidence_extractPerson"] = $(this).val();
		material($('option[value="evidence_table_info"]'));
		toastr.success("查询成功!");
	});
})

function material(object) {
	$('#goods_chose').hide();
	var material_type = $(object).val();
	//控制显示信息
	$('.panel-body table').each(function() {
		if ($(this).hasClass(material_type)) {
			$(this).show();
		} else $(this).hide();
	});
	if (material_type == "evidence_table_info") {
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function(xhr_data) {
			var Resevidence_arr = xhr_data.ResevidenceInformationDTOList;
			var str = '';
			for (var i = 0; i < Resevidence_arr.length; i++) {
				str += '<tr>';
				str += '<tr>';
				str += '<td>' + (i + 1) + '</td>';
				str += '<td>' + Resevidence_arr[i].resevidence.resevidence_name + '</td>';
				str += '<td>' + Resevidence_arr[i].resevidence.resevidence_extractTime + '</td>';
				str += '<td>' + Resevidence_arr[i].resevidence.resevidence_extractPerson + '</td>';
				str += '<td>' + Resevidence_arr[i].resevidence.resevidence_type + '</td>';
				str += '<td>'
					+ '<input type="hidden"  value="' + Resevidence_arr[i].resevidence.xsjsglxt_resevidence_id + '" />'
					+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//str表格信息添加到表格中
			$('.evidence_table_info tbody').html(str);
			//按钮给与点击事件
			$('.btn-xs').click(Evidence_modification);
		//$('.panel-body evidence_table_info tbody').html();
		}, 'json');
	} else if (material_type == "picture_table_info") {
		$.post('/xsjsglxt/case/Image_ListImageInformationByPageAndSearch', query_data, function() {}, 'json');

	} else if (material_type == "image_table_info") {
		$.post('/xsjsglxt/case/Image_ListImageInformationByPageAndSearch', query_data, function() {}, 'json');
	} else if (material_type == "Goods_table_info") {
		$('#goods_chose').show();
	}
}

function lost_chose(opt_obj) {
	//清空表格内信息
	$('.Goods_table_info tbody').empty();
	//存入信息1.页码信息2.本次点击的option对象
	query_data["page_list_Casematerial.pageIndex"] = "1";
	//query_data.option = $(opt_obj);
	//控制显示信息
	$('.Goods_table_info thead').each(function() {
		if ($(this).attr("id") == $(opt_obj).val()) {
			$(this).show();
		} else $(this).hide();
	});
	var str = "";
	if ($(opt_obj).val() == "Lost") {
		$.post('/xsjsglxt/case/Lost_ListLostInformationByPageAndSearch', query_data, function(xhr_data) {
			var lost_data = xhr_data.LostInformationDTOList;
			for (var i = 0; i < lost_data.length; i++) {
				str += '<tr>';
				str += '<td>' + (i + 1) + '</td>';
				str += '<td>' + lost_data[i].lost.lost_name + '</td>';
				str += '<td>' + lost_data[i].case1.case_name + '</td>';
				str += '<td>' + lost_data[i].lost.lost_remarks + '</td>';
				str += '<td>'
					+ '<input type="hidden"  value="' + lost_data[i].lost.xsjsglxt_lost_id + '" />'
					+ '<button type="button" name="lost_modification" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" name="lost_delete" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//将str加入到表格中
			$('.Goods_table_info tbody').append(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
		}, 'json');

	} else if ($(opt_obj).val() == "LostComputer") {
		$.post('/xsjsglxt/case/LostComputer_ListLostComputerInformationByPageAndSearch', query_data, function(xhr_data) {
			var lost_data = xhr_data.LostComputerInformationDTOList;
			for (var i = 0; i < lost_data.length; i++) {
				str += '<tr>';
				str += '<td>' + (i + 1) + '</td>';
				str += '<td>' + lost_data[i].case1.case_name + '</td>';
				str += '<td>' + lost_data[i].lost_computer.lost_computer_brand + '</td>';
				str += '<td>' + lost_data[i].lost_computer.lost_computer_internetAccount + '</td>';
				str += '<td>' + lost_data[i].lost_computer.lost_computer_MAC + '</td>';
				str += '<td>' + lost_data[i].lost_computer.lost_computer_remarks + '</td>';
				str += '<td>'
					+ '<input type="hidden"  value="' + lost_data[i].lost_computer.xsjsglxt_lost_computer_id + '" />'
					+ '<button type="button" name="lost_computer_modification" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" name="lost_computer_delete" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//将str加入到表格中
			$('.Goods_table_info tbody').append(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
		}, 'json');

	} else if ($(opt_obj).val() == "LostMobilephone") {
		$.post('/xsjsglxt/case/LostMobilephone_ListLostMobilephoneInformationByPageAndSearch', query_data, function(xhr_data) {
			var lost_data = xhr_data.LostMobilephoneInformationDTOList;
			for (var i = 0; i < lost_data.length; i++) {
				str += '<tr>';
				str += '<td>' + (i + 1) + '</td>';
				str += '<td>' + lost_data[i].case1.case_name + '</td>';
				str += '<td>' + lost_data[i].lost_mobilephone.lost_mobilephone_phone + '</td>';
				str += '<td>' + lost_data[i].lost_mobilephone.lost_mobilephone_IMEI + '</td>';
				str += '<td>' + lost_data[i].lost_mobilephone.lost_mobilephone_feature + '</td>';
				str += '<td>' + lost_data[i].lost_mobilephone.lost_mobilephone_remarks + '</td>';
				str += '<td>'
					+ '<input type="hidden"  value="' + lost_data[i].lost_mobilephone.xsjsglxt_lost_mobilephone_id + '" />'
					+ '<button type="button" name="lost_mobilephone_modification" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" name="lost_mobilephone_delete" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//将str加入到表格中
			$('.Goods_table_info tbody').append(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
		}, 'json');
	} else {
		return;
	}
}

var ViewSingleMessage = function() {
	var but_obj = $(this);
	var lost_id = but_obj.siblings('input').val();
	console.log(lost_id);
	switch (but_obj.attr('name')) {
	//--------丢失物品
	case 'lost_modification':
		$('#modal-title').text('修改丢失物品信息');
		$.post('/xsjsglxt/case/Lost_LostInformationOne', {
			"lost.xsjsglxt_lost_id" : lost_id
		}, function(xhr_data) {
			//执行添加丢失物品的信息
			Lost_Details(xhr_data);
		}, 'json');
		break;
	case 'lost_delete':
		var formData = new FormData();
		formData.append("useLostInformationNumList", lost_id);
		deleteData('/xsjsglxt/case/Lost_remove_LostInformationList', 'Lost', formData);
		break;
	//=--------丢失电脑
	case 'lost_computer_modification':
		$('#modal-title').text('修改丢失电脑信息');
		$.post('/xsjsglxt/case/LostComputer_LostComputerInformationOne', {
			"lost_computer.xsjsglxt_lost_computer_id" : lost_id
		}, function(xhr_data) {
			lost_Computer_Details(xhr_data);
		}, 'json');
		break;
	case 'lost_computer_delete':
		var formData = new FormData();
		formData.append("useLost_computerInformationNumList", lost_id);
		deleteData('/xsjsglxt/case/LostComputer_remove_Lost_computerInformationList', 'LostComputer', formData);
		break;
	//丢失手机
	case 'lost_mobilephone_modification':
		$('#modal-title').text('修改丢失手机信息');
		$.post('/xsjsglxt/case/LostMobilephone_LostMobiephoneInformationOne', {
			"lost_mobilephone.xsjsglxt_lost_mobilephone_id" : lost_id
		}, function(xhr_data) {
			lost_Computer_Details(xhr_data);
		}, 'json');
		break;
	case 'lost_mobilephone_delete':
		var formData = new FormData();
		formData.append("useLost_mobilephoneInformationNumList", lost_id);
		deleteData('/xsjsglxt/case/LostMobilephone_remove_Lost_mobilephoneInformationList', 'LostMobilephone', formData);
		break;
	default:
		break;
	}
}

//模态框添加丢失物品信息
function Lost_Details(xhr_data) {
	$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
		var str = '';
		str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
		str += '<td>所属案件</td><td>';
		str += '<select style="witdh:100%;" class="selectpicker" data-live-search="true" name="lost.lost_case">';
		//所有案件循环
		for (var len = 0; len < Case_data.length; len++) {
			str += '<option ';
			if (xhr_data.case1.case_name == Case_data[len].case_name) {
				str += 'selected';
			}
			str += ' value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
		}
		str += '</select></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>名称</td><td><input style="witdh:70%;" class="form-control" name="lost.lost_name" type="text" value="' + xhr_data.lost.lost_name + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>备注</td><td><textarea style="witdh:70%;" class="form-control" name="lost.lost_remarks">' + xhr_data.lost.lost_remarks + '</textarea>';
		//添加存丢失物的id隐藏域(上一兄元素为备注文本域)
		str += '<input name="lost.xsjsglxt_lost_id" type="hidden" value="' + xhr_data.lost.xsjsglxt_lost_id + '" />';
		str += '</td>';
		str += '</tr></tbody></table>';
		//将str加入到面板中
		$('#lost .panel-body').append(str);
		//刷新select选择框
		$('.selectpicker').selectpicker('refresh');
		$('#lost').modal('show');
		//点击时调用确定修改按钮
		$('.btn_operation').val('_updateLost').unbind().click(Lost_modification);
	}, 'json');
}


//模态框添加丢失电脑信息
function lost_Computer_Details(xhr_data) {
	$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
		var str = '';
		str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
		str += '<td>所属案件</td><td>';
		str += '<select style="witdh:100%;" class="selectpicker" data-live-search="true" name="lost_computer.lost_computer_case">';
		//所有案件循环
		for (var len = 0; len < Case_data.length; len++) {
			str += '<option ';
			if (xhr_data.case1.case_name == Case_data[len].case_name) {
				str += 'selected';
			}
			str += ' value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
		}
		str += '</select></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>电脑品牌</td><td><input style="witdh:70%;" class="form-control" name="lost_computer.lost_computer_brand" type="text" value="' + xhr_data.lost_computer.lost_computer_brand + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>上网帐号</td><td><input style="witdh:70%;" class="form-control" name="lost_computer.lost_computer_internetAccount" type="text" value="' + xhr_data.lost_computer.lost_computer_internetAccount + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>MAC地址</td><td><input style="witdh:70%;" class="form-control" name="lost_computer.lost_computer_MAC" type="text" value="' + xhr_data.lost_computer.lost_computer_MAC + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>备注</td><td><textarea style="witdh:70%;" class="form-control" name="lost_computer.lost_computer_remarks">' + xhr_data.lost_computer.lost_computer_remarks + '</textarea>';
		//添加存丢失物的id隐藏域(上一兄元素为备注文本域)
		str += '<input name="lost_computer.xsjsglxt_lost_computer_id" type="hidden" value="' + xhr_data.lost_computer.xsjsglxt_lost_computer_id + '" />';
		str += '</td>';
		str += '</tr></tbody></table>';
		//将str加入到面板中
		$('#lost .panel-body').append(str);
		//刷新select选择框
		$('.selectpicker').selectpicker('refresh');
		$('#lost').modal('show');
		//点击时调用确定修改按钮
		$('.btn_operation').val('Computer_updateLostComputer').unbind().click(Lost_modification);
	}, 'json');
}



//模态框添加丢失手机信息
function Lost_Mobilephone_Details(xhr_data) {
	$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
		var str = '';
		str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
		str += '<td>所属案件</td><td>';
		str += '<select style="witdh:100%;" class="selectpicker" data-live-search="true" name="lost_mobilephone.lost_mobilephone_case">';
		//所有案件循环
		for (var len = 0; len < Case_data.length; len++) {
			str += '<option ';
			if (xhr_data.case1.case_name == Case_data[len].case_name) {
				str += 'selected';
			}
			str += ' value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
		}
		str += '</select></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>手机号码</td><td><input style="witdh:70%;" class="form-control" name="lost.lost_name" type="text" value="' + xhr_data.lost_mobilephone.lost_mobilephone_phone + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>手机串号</td><td><input style="witdh:70%;" class="form-control" name="lost.lost_name" type="text" value="' + xhr_data.lost_mobilephone.lost_mobilephone_IMEI + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>手机特征</td><td><input style="witdh:70%;" class="form-control" name="lost.lost_name" type="text" value="' + xhr_data.lost_mobilephone.lost_mobilephone_feature + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>备注</td><td><textarea style="witdh:70%;" class="form-control" name="lost_mobilephone.lost_remarks">' + xhr_data.lost_mobilephone.lost_mobilephone_remarks + '</textarea>';
		//添加存丢失物的id隐藏域(上一兄元素为备注文本域)
		str += '<input name="lost_mobilephone.xsjsglxt_lost_mobilephone_id" type="hidden" value="' + xhr_data.lost_mobilephone.xsjsglxt_lost_mobilephone_id + '" />';
		str += '</td>';
		str += '</tr></tbody></table>';
		//将str加入到面板中
		$('#lost .panel-body').append(str);
		//刷新select选择框
		$('.selectpicker').selectpicker('refresh');
		$('#lost').modal('show');
		//点击时调用确定修改按钮
		$('.btn_operation').val('Mobilephone_updateLost').unbind().click(Lost_modification);
	}, 'json');
}

//丢失物品(物品,电脑,手机)确定修改信息
var Lost_modification = function() {
	var url = $(this).val();
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
					$.post('/xsjsglxt/case/Lost' + url, $('form').serialize(), function(xhr_data) {
						if (xhr_data == "success") {
							$('#lost').modal('hide');
							//获取对应option中的value值
							var value = url.substr(url.indexOf('Lost'));
							console.log(value);
							//修改后进行一次查询
							lost_chose($('option[value="' + value + '"]'));
							toastr.success("修改成功!");
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


//物证修改信息
var Evidence_modification = function() {
	$.post('/xsjsglxt/case/Resevidence_ResevidenceInformationOne', {
		"resevidence.xsjsglxt_resevidence_id" : $(this).siblings('input').val(),
	}, function(xhr_data) {
		var str = '';
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			str = '<table border="0px;" align="center" class="table table-hover table-condensed"><tbody><tr>';
			str += '<td>所属案件</td><td>';
			str += '<select style="witdh:100%;" class="selectpicker" data-live-search="true" name="resevidence.resevidence_case">';
			//所有案件循环
			for (var len = 0; len < Case_data.length; len++) {
				str += '<option ';
				if (xhr_data.case1.case_name == Case_data[len].case_name) {
					str += 'selected ';
				}
				str += ' value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			str += '</select></td>';
			//str += '</tr>';
			//str += '<tr>';
			str += '<td>物证名称</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_name" type="text" value="' + xhr_data.resevidence.resevidence_name + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>提取单位</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_extractUnit" type="text" value="' + xhr_data.resevidence.resevidence_extractUnit + '"  /></td>';
			//str += '</tr>';
			//str += '<tr>';
			str += '<td>物证类型</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_type" type="text" value="' + xhr_data.resevidence.resevidence_type + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>提取部位</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_extractPart" type="text" value="' + xhr_data.resevidence.resevidence_extractPart + '"  /></td>';
			//str += '</tr>';
			//str += '<tr>';
			str += '<td>提取方法</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_extractMethod" type="text" value="' + xhr_data.resevidence.resevidence_extractMethod + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>提取数量</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_extractNumber" type="text" value="' + xhr_data.resevidence.resevidence_extractNumber + '"  /></td>';
			//str += '</tr>';
			//str += '<tr>';
			str += '<td>提取人</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_extractPerson" type="text" value="' + xhr_data.resevidence.resevidence_extractPerson + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>提取日期</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_extractTime" type="text" value="' + xhr_data.resevidence.resevidence_extractTime + '"  /></td>';
			//str += '</tr>';
			//str += '<tr>';
			str += '<td>检验状态</td><td><input style="witdh:70%;" class="form-control" name="resevidence.resevidence_teststate" type="text" value="' + xhr_data.resevidence.resevidence_teststate + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>备注</td><td colspan="3"><textarea style="witdh:70%;" class="form-control" name="resevidence.resevidence_remarks">' + xhr_data.resevidence.resevidence_remarks + '</textarea>'
			str += '<input name="resevidence.xsjsglxt_resevidence_id" type="hidden" value="' + xhr_data.resevidence.xsjsglxt_resevidence_id + '" />';
			str += '</td>';
			str += '</tr></tbody></table>';
			$('#evidence .panel-body').html(str);
			//刷新select选择框
			$('.selectpicker').selectpicker('refresh');
			//确认修改添加点击事件
			$('.evidence_operation').click(evidence_modifi);
			$('#evidence').modal('show');
		}, 'json');
	}, 'json');
/*var url = $(this).val();
*/
}
//物证修改确定
var evidence_modifi = function() {
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
					$.post('/xsjsglxt/case/Resevidence_updateResevidenceInformation', $('#evidence form').serialize(), function(mo_data) {
						if (mo_data == "success") {
							//模态框隐藏
							$('#evidence').modal('hide');
							//修改后进行一次查询
							material($('option[value="evidence_table_info"]'));
							toastr.success("修改成功!");
						}
					}, 'json');
				}
			},
			cancelAction : {
				btnClass : 'btn-blue',
				text : '取消',
			}
		}
	})
}

//物证的修改确认事件
var evidence_sure = function() {
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
					$.post('/xsjsglxt/case/Lost' + url, $('form').serialize(), function(xhr_data) {
						if (xhr_data == "success") {
							$('#lost').modal('hide');
							//获取对应option中的value值
							var value = url.substr(url.indexOf('Lost'));
							console.log(value);
							//修改后进行一次查询
							lost_chose($('option[value="' + value + '"]'));
							toastr.success("修改成功!");
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


//删除信息
//URL为访问路径，value为确定option对象让丢失物中电脑，手机，物品中执行点击事件，做更改后的再次查询，FormData为传输数据
function deleteData(url, value, formData) {
	//'/xsjsglxt/case/Lost_remove_LostInformationList'
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
						url : url,
						type : 'post',
						data : formData,
						processData : false,
						contentType : false,
						dataType : 'text',
						success : function(data) {
							if (data == "success") {
								toastr.success("删除成功！");
								//获取对应option中的value值
								console.log($('option[value="' + value + '"]'));
								lost_chose($('option[value="' + value + '"]'));
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