var query_data = {
	"page_list_ResevidenceInformation.pageIndex" : "1",
	"page_list_Casematerial.pageIndex" : "1",
}


$(function() {
	$('#lost').on('hide.bs.modal', function() {
		setTimeout(function() {
			$('#lost .panel-body').empty();
		}, 200)
	})
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
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function() {
			//$('.panel-body evidence_table_info tbody').html();
		}, 'json');
	} else if (material_type == "picture_table_info") {
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function() {}, 'json');
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
	var lost_id = but_obj.siblings().val();
	console.log(lost_id);
	switch (but_obj.attr('name')) {
	//--------丢失物品
	case 'lost_modification':
		$('#modal-title').text('修改丢失物品');
		$.post('/xsjsglxt/case/Lost_LostInformationOne', {
			"lost.xsjsglxt_lost_id" : lost_id
		}, function(xhr_data) {
			getAllCase(xhr_data);
		}, 'json');
		break;
	case 'lost_delete':
		var formData = new FormData();
		formData.append("useLostInformationNumList", lost_id);
		deleteData('/xsjsglxt/case/Lost_remove_LostInformationList', 'Lost', formData);
		break;
	//=--------丢失电脑
	case 'lost_computer_modification':
		$('#lost').modal('show');
		break;
	case 'lost_computer_delete':
		$('#lost').modal('show');
		break;
	//丢失手机
	case 'lost_mobilephone_modification':
		$('#lost').modal('show');
		break;
	case 'lost_mobilephone_delete':
		$('#lost').modal('show');
		break;
	default:
		break;
	}
}


function getAllCase(xhr_data) {
	$.post('/xsjsglxt/case/Case_ListSneceInformationByPageAndSearch', {
		"page_list_senceInformation.pageIndex" : "1"
	}, function(Case_data) {
		//获得案件所有的名称和ID
		var case1_arr = Case_data.SenceInformationDTOList;
		var str = '';
		str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
		str += '<td>所属案件</td><td>';
		str += '<select style="witdh:100%;" class="selectpicker" data-live-search="true" name="lost.lost_case">';
		for (var len = 0; len < case1_arr.length; len++) {
			str += '<option ';
			if (xhr_data.case1.case_name == case1_arr[len].case1.case_name) {
				str += 'selected';
			}
			str += ' value="' + case1_arr[len].case1.xsjsglxt_case_id + '">' + case1_arr[len].case1.case_name + '</option>';
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
		$('.btn_operation').text('确认修改').val('_updateLost').unbind().click(modification);
	}, 'json');
}


//修改信息
var modification = function() {
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