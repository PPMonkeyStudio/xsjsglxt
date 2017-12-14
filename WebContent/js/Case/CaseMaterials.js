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
	$('.Goods_table_info tbody').empty();
	query_data["page_list_Casematerial.pageIndex"] = "1";
	//控制显示信息
	$('.Goods_table_info thead').each(function() {
		if ($(this).attr("id") == $(opt_obj).val()) {
			$(this).show();
		} else $(this).hide();
	});
	var str = "";
	if ($(opt_obj).val() == "lost_information") {
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
					+ '<button type="button" id="lost_modification" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" id="lost_delete" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//将str加入到表格中
			$('.Goods_table_info tbody').append(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
		}, 'json');

	} else if ($(opt_obj).val() == "lost_computer") {
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
					+ '<button type="button" id="lost_computer_modification" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" id="lost_computer_delete" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//将str加入到表格中
			$('.Goods_table_info tbody').append(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
		}, 'json');

	} else if ($(opt_obj).val() == "lost_mobilephone") {
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
					+ '<button type="button" id="lost_mobilephone_modification" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" id="lost_mobilephone_delete" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
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
	var str = '';
	var but_obj = $(this);
	switch ($(this).attr('id')) {
	//--------丢失物品
	case 'lost_view':
		$('#lost').modal('show');
		break;
	case 'lost_modification':
		$('#modal-title').text('修改丢失物品');
		console.log(but_obj.siblings().val());
		$.post('/xsjsglxt/case/Lost_LostInformationOne', {
			"lost.xsjsglxt_lost_id" : but_obj.siblings().val()
		}, function(xhr_data) {
			str += '<table align="center" class="table table-hover"><tbody><tr>';
			str += '<td>所属案件</td><td><input style="witdh:70%;" class="form-control" name="" type="text" value="' + xhr_data.case1.case_name + '" /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>名称</td><td><input style="witdh:70%;" class="form-control" name="" type="text" value="' + xhr_data.lost.lost_name + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>备注</td><td><input style="witdh:70%;" class="form-control" name="" type="text" value="' + xhr_data.lost.lost_remarks + '"  /></td>';
			str += '</tr></tbody></table>';
			$('#lost .panel-body').append(str);
			$('.btn-operation').text('确认修改').click(modification('/xsjsglxt/case/Lost_updateLost', $('form').serialize()));

			$('#lost').modal('show');
		}, 'json');

		break;
	case 'lost_delete':
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
						loadCaseDetail_case_change(url, case1_id);
					}
				},
				cancelAction : {
					btnClass : 'btn-blue',
					text : '取消',
				}
			}
		});
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

//修改信息
function modification(url, data) {
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
					$.post(url, data, function(xhr_data) {
						if (xhr_data == "success") {
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