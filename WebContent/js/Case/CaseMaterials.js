
//物证修改信息
var Evidence_modification = function() {
	var Evidence_id = $(this).siblings('input').val();
	if ($(this).text().trim() == "修改") {
		$.post('/xsjsglxt/case/Resevidence_ResevidenceInformationOne', {
			"resevidence.xsjsglxt_resevidence_id" : Evidence_id
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
				$('.evidence_operation').click(evidence_modification);
				$('#evidence').modal('show');
			}, 'json');
		}, 'json');
	} else if ($(this).text().trim() == "删除") {
		var formData = new FormData();
		formData.append("useResevidenceInformationNumList", Evidence_id);
		deleteData('/xsjsglxt/case/Resevidence_remove_ResevidenceInformationList', 'evidence_table_info', formData);
	}

/*var url = $(this).val();
*/
}
//物证修改确定
var evidence_modification = function() {
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

//查看照片详情事件
var picture_Details = function() {
	var picture_id = $(this).siblings('input').val();
	if ($(this).text().trim() == "修改") {
		$.post('/xsjsglxt/case/Image_ImageInformationOne', {
			"picture.xsjsglxt_picture_id" : picture_id
		}, function(xhr_data) {
			var str = '';
			str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
			$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {

				str += '<td>所属影像光盘</td><td>';
				str += '<select style="witdh:100%;" class="selectpicker" data-live-search="true" name="picture.picture_image">';
				//所有影像光盘循环
				for (var len = 0; len < xhr_data.iamgeList.length; len++) {
					str += '<option ';
					if (xhr_data.image.xsjsglxt_image_id == xhr_data.iamgeList[len].xsjsglxt_image_id) {
						str += 'selected ';
					}
					str += ' value="' + xhr_data.iamgeList[len].xsjsglxt_image_id + '">' + xhr_data.iamgeList[len].image_number + '</option>';
				}
				str += '</select></td>';
				//str += '<td>所属影像光盘</td><td>' + xhr_data.image.image_number + '</td>';
				str += '</tr>';
				str += '<tr>';
				str += '<td>所属案件</td><td>';
				str += '<select style="witdh:100%;" class="selectpicker" data-live-search="true" name="picture.picture_case">';
				//所有案件循环
				for (var len = 0; len < Case_data.length; len++) {
					str += '<option ';
					if (xhr_data.case1.case_name == Case_data[len].case_name) {
						str += 'selected ';
					}
					str += ' value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
				}
				str += '</select></td>';
				str += '</tr>';
				str += '<tr>';
				str += '<td>照片编号</td><td><input style="witdh:70%;" class="form-control" name="picture.picture_identifier" type="text" value="' + xhr_data.picture.picture_identifier + '"  /></td>';
				str += '</tr>';
				str += '<tr>';
				str += '<td>备注</td><td><textarea style="witdh:70%;" class="form-control" name="picture.picture_remarks">' + xhr_data.picture.picture_remarks + '</textarea>'
				str += '<input name="picture.xsjsglxt_picture_id" type="hidden" value="' + xhr_data.picture.xsjsglxt_picture_id + '" />';
				str += '</td>';
				str += '</tr></tbody></table>';
				//信息添加到模态框
				$('#image .panel-body').html(str);
				//刷新select选择框
				$('.selectpicker').selectpicker('refresh');
				//显示模态框
				$('#image').modal('show');
				//模态框按钮设置点击事件
				$('.image_operation').click(picture_modification);
			}, 'json');
		}, 'json');
	} else if ($(this).text().trim() == "删除") {
		var formData = new FormData();
		formData.append("usePictureInformationNumList", picture_id);
		deleteData('/xsjsglxt/case/Image_remove_PictureInformationList', 'picture_table_info', formData);
	}

}

//照片的修改确认事件
var picture_modification = function() {
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
					$.post('/xsjsglxt/case/Image_updatePicture', $('#image form').serialize(), function(xhr_data) {
						if (xhr_data == "success") {
							$('#image').modal('hide');
							//修改后进行一次查询
							material($('option[value="picture_table_info"]'));
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



//查看影像光盘详情事件
var image_Details = function() {
	var image_id = $(this).siblings('input').val();
	if ($(this).text().trim() == "修改") {
		$.post('/xsjsglxt/case/Image_ImageInformationOne', {
			"image.xsjsglxt_image_id" : image_id
		}, function(xhr_data) {
			var str = '';
			str += '<table align="center" class="table table-hover table-condensed"><tbody><tr>';
			str += '<td>影像光盘编号</td><td><input disabled="disabled" style="witdh:70%;" class="form-control" name="image.image_number" type="text" value="' + xhr_data.image.image_number + '"  /></td>';
			str += '</tr>';
			str += '<tr>';
			str += '<td>备注</td><td><textarea style="witdh:70%;" class="form-control" name="image.image_remarks">' + xhr_data.image.image_remarks + '</textarea>'
			str += '<input name="image.xsjsglxt_image_id" type="hidden" value="' + xhr_data.image.xsjsglxt_image_id + '" />';
			str += '</td>';
			str += '</tr></tbody></table>';
			//信息添加到模态框
			$('#image .panel-body').html(str);
			//刷新select选择框
			$('.selectpicker').selectpicker('refresh');
			//显示模态框
			$('#image').modal('show');
			//模态框按钮设置点击事件
			$('.image_operation').click(image_modification);
		}, 'json');
	} else if ($(this).text().trim() == "删除") {
		var formData = new FormData();
		formData.append("useImageInformationNumList", image_id);
		deleteData('/xsjsglxt/case/Image_remove_ImageInformationList', 'image_table_info', formData);
	}
}

//影像光盘的修改确认事件
var image_modification = function() {
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
					$.post('/xsjsglxt/case/Image_updateImage', $('#image form').serialize(), function(xhr_data) {
						if (xhr_data == "success") {
							$('#image').modal('hide');
							//修改后进行一次查询
							material($('option[value="image_table_info"]'));
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

//丢失物品(物品,电脑,手机)确定==修改==信息
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
					$.post('/xsjsglxt/case/Lost' + url, $('#lost form').serialize(), function(xhr_data) {
						if (xhr_data == "success") {
							$('#lost').modal('hide');
							//获取对应option中的value值
							var value = url.substr(url.indexOf('Lost'));
							//修改后进行一次查询
							console.log(value);
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

var ViewSingleMessage = function() {
	var but_obj = $(this);
	var lost_id = but_obj.siblings('input').val();
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
			Lost_Mobilephone_Details(xhr_data);
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



//添加信息
var add_info = function() {
	var but_val = $(this).val().trim();
	switch (but_val) {
	case "evidence_table_info":
		var str = '<form>'
			+ '<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind"></i></td><td>'
			//+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="resevidence.resevidence_case">'
			+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="case1.xsjsglxt_case_id">'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>物证名称:</td>'
			+ '<td><input name="resevidence.resevidence_name" class="form-control" type="text"></td>'
			+ '<td>检验状态</td>'
			+ '<td><select name="resevidence.resevidence_teststate" class="form-control">'
			+ '<option value="" selected="">请选择检验状态</option>'
			+ '<option>未检验</option>'
			+ '<option>正在委托检验</option>'
			+ '<option>送检不受理</option>'
			+ '<option>送检已受理</option>'
			+ '<option>已送检</option>'
			+ '<option>正在自检</option>'
			+ '<option>正在送检</option>'
			+ '<option>未检验</option>'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>提取部位:</td>'
			+ '<td><input name="resevidence.resevidence_extractPart" class="form-control" type="text"></td>'
			+ '<td>提取方法:</td>'
			+ '<td><select name="resevidence.resevidence_extractMethod" class="form-control">'
			+ '<option value="" selected="">请输入提取方法</option>'
			+ '<option value="粉末显现">粉末显现</option>'
			+ '<option value="茚三酮熏显">茚三酮熏显</option>'
			+ '<option value="502熏显">502熏显</option>'
			+ '<option value="实物提取">实物提取</option>'
			+ '<option value="照相提取">照相提取</option>'
			+ '<option value="静电吸附">静电吸附</option>'
			+ '<option value="纱布转移">纱布转移</option>'
			+ '<option value="其他">其他</option>'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>提取数量:</td>'
			+ '<td><input name="resevidence.resevidence_extractNumber" class="form-control" type="text" placeholder="请输入数字"></td>'
			+ '<td>提取人:</td>'
			+ '<td><input name="resevidence.resevidence_extractPerson" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>物证类型：</td>'
			+ '<td><select name="resevidence.resevidence_type" class="form-control">'
			+ '<option value="" selected>请选择物证类型</option>'
			+ '<option value="手印痕迹">手印痕迹</option>'
			+ '<option value="足迹痕迹">足迹痕迹</option>'
			+ '<option value="工具痕迹">工具痕迹</option>'
			+ '<option value="生物物证">生物物证</option>'
			+ '<option value="理化物证">理化物证</option>'
			+ '<option value="其他">其他</option>'
			+ '</select></td>'
			+ '<td>提取日期:</td>'
			+ '<td><input name="resevidence.resevidence_extractTime" class="form-control mydate" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>提取单位:</td>'
			+ '<td colspan="3"><input name="resevidence.resevidence_extractUnit" class="form-control" value="安源分局刑事科学技术室" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>备注:</td>'
			+ '<td colspan="3"><textarea name="resevidence.resevidence_remarks" class="form-control" placeholder="请填写" rows="2"></textarea></td>'
			+ '</tr>'
			+ '</tbody>'
			+ '</table>'
			+ '</form>';
		add_default_confirm('物证信息添加', str, '/xsjsglxt/case/Resevidence_saveResevidence', 'evidence_table_info');

		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			var sel = '';
			for (var len = 0; len < Case_data.length; len++) {
				sel += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('.selectpicker').html(sel);
			//刷新选择框
			$('.selectpicker').selectpicker('refresh');
			$('input[name="resevidence.resevidence_extractNumber"]').keyup(function() {
				$(this).val($(this).val().replace(/[^\d]/g, ''));
			});

			$('.mydate').datetimepicker({
				yearStart : 1990, // 设置最小年份
				yearEnd : 2050, // 设置最大年份
				yearOffset : 0, // 年偏差
				timepicker : false, // 关闭时间选项
				format : 'Y-m-d', // 格式化日期年-月-日
				minDate : '1990/01/01', // 设置最小日期
				maxDate : '2030/01/01', // 设置最大日期
			});

			//移除加载提示
			$('.load_remind').remove();
		}, 'json')
		break;
	case 'picture_table_info':
		var str = '<form>'
			+ '<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>所属影像光盘<i class="fa fa-spinner fa-pulse fa-fw load_remind1"></i></td><td>'
			+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="image.xsjsglxt_image_id">'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind2"></i></td><td>'
			//+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="picture.picture_case">'
			+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="case1.xsjsglxt_case_id">'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>照片编号</td>'
			+ '<td><input name="picture.picture_identifier" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>备注:</td>'
			+ '<td colspan="3"><textarea name="picture.picture_remarks" class="form-control" placeholder="请填写"></textarea></td>'
			+ '</tr>'
			+ '</tbody>'
			+ '</table>'
			+ '</form>';
		add_default_confirm('照片信息添加', str, '/xsjsglxt/case/Image_savePicture', 'picture_table_info');

		$.post('/xsjsglxt/case/Image_getAllImageInformation', {
			/*"picture.xsjsglxt_picture_id" : "1",*/
		}, function(image_data) {
			var sel2 = '';
			for (var len = 0; len < image_data.length; len++) {
				sel2 += '<option value="' + image_data[len].xsjsglxt_image_id + '">' + image_data[len].image_number + '</option>';
			}
			$('select[name="image.xsjsglxt_image_id"]').html(sel2);
			//刷新选择框
			$('.selectpicker').selectpicker('refresh');
			//移除加载提示
			$('.load_remind1').remove();
		}, 'json')
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			var sel = '';
			for (var len = 0; len < Case_data.length; len++) {
				sel += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('select[name="case1.xsjsglxt_case_id"]').html(sel);
			//刷新选择框
			$('.selectpicker').selectpicker('refresh');
			//移除加载提示
			$('.load_remind2').remove();
		}, 'json')
		break;
	case 'image_table_info':
		var str = '<form>'
			+ '<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>影像光盘编号</td>'
			+ '<td><input name="image.image_number" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>备注:</td>'
			+ '<td colspan="3"><textarea name="image.image_remarks" class="form-control" placeholder="请填写"></textarea></td>'
			+ '</tr>'
			+ '</tbody>'
			+ '</table>'
			+ '</form>';
		add_default_confirm('影像光盘信息添加', str, '/xsjsglxt/case/Image_saveCD', 'image_table_info');
		break;
	case 'Lost':
		var str = '<form>'
			+ '<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind"></i></td><td>'
			//+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="lost.lost_case">'
			+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="case1.xsjsglxt_case_id">'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>名称</td>'
			+ '<td colspan="3"><input name="lost.lost_name" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>备注:</td>'
			+ '<td colspan="3"><textarea name="lost.lost_remarks" class="form-control" placeholder="请填写" rows="2"></textarea></td>'
			+ '</tr>'
			+ '</tbody>'
			+ '</table>'
			+ '</form>';
		add_default_confirm('丢失物品信息添加', str, '/xsjsglxt/case/Lost_saveLost', 'Lost');
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			var sel = '';
			for (var len = 0; len < Case_data.length; len++) {
				sel += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('.selectpicker').html(sel);
			//刷新选择框
			$('.selectpicker').selectpicker('refresh');
			//移除加载提示
			$('.load_remind').remove();
		}, 'json')
		break;
	case 'LostComputer':
		var str = '<form>'
			+ '<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind"></i></td><td>'
			//+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="lost_computer.lost_computer_case">'
			+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="case1.xsjsglxt_case_id">'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>电脑品牌</td>'
			+ '<td><input name="lost_computer.lost_computer_brand" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>上网账号</td>'
			+ '<td><input name="lost_computer.lost_computer_internetAccount" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>MAC地址</td>'
			+ '<td><input name="lost_computer.lost_computer_MAC" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>备注:</td>'
			+ '<td colspan="3"><textarea name="lost_computer.lost_computer_remarks" class="form-control" placeholder="请填写"></textarea></td>'
			+ '</tr>'
			+ '</tbody>'
			+ '</table>'
			+ '</form>';
		add_default_confirm('丢失电脑信息添加', str, '/xsjsglxt/case/LostComputer_saveLostComputer', 'LostComputer');
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			var sel = '';
			for (var len = 0; len < Case_data.length; len++) {
				sel += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('.selectpicker').html(sel);
			//刷新选择框
			$('.selectpicker').selectpicker('refresh');
			//移除加载提示
			$('.load_remind').remove();
		}, 'json')
		break;
	case 'LostMobilephone':
		var str = '<form>'
			+ '<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>所属案件<i class="fa fa-spinner fa-pulse fa-fw load_remind"></i></td><td>'
			//+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="lost_mobilephone.lost_mobilephone_case">'
			+ '<select style="witdh:100%;" class="form-control selectpicker" data-live-search="true" name="case1.xsjsglxt_case_id">'
			+ '</select></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>手机号码</td>'
			+ '<td><input name="lost_mobilephone.lost_mobilephone_phone" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>手机串号</td>'
			+ '<td><input name="lost_mobilephone.lost_mobilephone_IMEI" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>手机特征</td>'
			+ '<td><input name="lost_mobilephone.lost_mobilephone_feature" class="form-control" type="text"></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>备注:</td>'
			+ '<td colspan="3"><textarea name="lost_mobilephone.lost_mobilephone_remarks" class="form-control" placeholder="请填写"></textarea></td>'
			+ '</tr>'
			+ '</tbody>'
			+ '</table>'
			+ '</form>';
		add_default_confirm('丢失手机信息添加', str, '/xsjsglxt/case/LostMobilephone_saveLostMobilephone', 'LostMobilephone');
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			var sel = '';
			for (var len = 0; len < Case_data.length; len++) {
				sel += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('.selectpicker').html(sel);
			//刷新选择框
			$('.selectpicker').selectpicker('refresh');
			//移除加载提示
			$('.load_remind').remove();
		}, 'json')
		break;
	default:
		break;
	}
}


/*===============================================================================以上为方法声明=====*/

var query_data = {
	//物证分页信息
	"page_list_ResevidenceInformation.pageIndex" : "1",
	//照片。光盘分页信息
	"page_list_imageInformation.pageIndex" : "1",
	//丢失物品分页信息
	"page_list_Casematerial.pageIndex" : "1",
	"page_list_ResevidenceInformation.resevidence_extractPerson" : "",
}

//当前页面分页信息
var page_infomantion = {
	pageIndex : 1,
	totalRecords : 1,
	pageSize : 20,
	totalPages : 1,
	HavePrePage : false,
	HaveNextPage : false,
}
//设置分页信息
function setPageInfomation(data) {
	page_infomantion.pageIndex = data.pageIndex; //当前页数
	page_infomantion.totalRecords = data.totalRecords; //总页数
	page_infomantion.pageSize = data.pageSize; //每页记录数
	page_infomantion.totalPages = data.totalPages; //总记录数
	page_infomantion.HavePrePage = data.HavePrePage; //是否有上一页
	page_infomantion.HaveNextPage = data.HaveNextPage; //是否有下一页
}

$(function() {
	$('.modal').on('hide.bs.modal', function() {
		var this_modal = $(this);
		setTimeout(function() {
			this_modal.find('.panel-body').empty();
		//$('#lost .panel-body').empty();
		}, 200)
	})

	//confirm提示框的关闭图标
	jconfirm.defaults = {
		closeIcon : true,
		closeIconClass : 'fa fa-close',
	}

	//添加信息按钮点击事件
	$('.add_info').click(add_info);

	/*$('#evidence').on('hide.bs.modal', function() {
		setTimeout(function() {
			$('#evidence .panel-body').empty();
		}, 200)
	})*/
	$('.modal').on('hidden.bs.modal', function() {
		$(this).find('.modal-footer').children('button[class!="btn btn-default"]').unbind();
	})


	//物证的搜索框keyup(鼠标按键释放时触发)事件
	$('.Search_extractPerson').keyup(function() {
		query_data["page_list_ResevidenceInformation.resevidence_extractPerson"] = $(this).val();
		material($('option[value="evidence_table_info"]'));
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
			//添加按钮设置id属性值
			$('.add_info').show().val("evidence_table_info");
			//设置分页信息
			setPageInfomation(xhr_data);
		//$('.panel-body evidence_table_info tbody').html();
		}, 'json');
	} else if (material_type == "picture_table_info") {
		$.post('/xsjsglxt/case/Image_ListImageInformationByPageAndSearch', query_data, function(xhr_data) {
			var picture_arr = xhr_data.ImageInformationDTOList;
			var str = '';
			for (var i = 0; i < picture_arr.length; i++) {
				str += '<tr>';
				str += '<tr>';
				str += '<td>' + (i + 1) + '</td>';
				str += '<td>' + picture_arr[i].image.image_number + '</td>';
				str += '<td>' + picture_arr[i].case1.case_name + '</td>';
				str += '<td>' + picture_arr[i].picture.picture_identifier + '</td>';
				str += '<td>' + picture_arr[i].picture.picture_remarks + '</td>';
				str += '<td>'
					+ '<input type="hidden"  value="' + picture_arr[i].picture.xsjsglxt_picture_id + '" />'
					+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//str表格信息添加到表格中
			$('.picture_table_info tbody').html(str);
			//按钮给与点击事件
			$('.btn-xs').click(picture_Details);
			//添加按钮设置id属性值
			$('.add_info').show().val("picture_table_info");
			//设置分页信息
			setPageInfomation(xhr_data);
		//$('.panel-body evidence_table_info tbody').html();
		}, 'json');
	} else if (material_type == "image_table_info") {
		$.post('/xsjsglxt/case/Image_getAllImageInformation', query_data, function(xhr_data) {
			var image_arr = xhr_data;
			var str = '';
			for (var i = 0; i < image_arr.length; i++) {
				str += '<tr>';
				str += '<tr>';
				str += '<td>' + (i + 1) + '</td>';
				str += '<td>' + image_arr[i].image_number + '</td>';
				str += '<td>' + image_arr[i].image_remarks + '</td>';
				str += '<td>'
					+ '<input type="hidden"  value="' + image_arr[i].xsjsglxt_image_id + '" />'
					+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
					+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
					+ '</td>';
				str += '</tr>'
			}
			//str表格信息添加到表格中
			$('.image_table_info tbody').html(str);
			//按钮给与点击事件
			$('.btn-xs').click(image_Details);
			//添加按钮设置id属性值
			$('.add_info').show().val("image_table_info");
			//设置分页信息
			setPageInfomation(xhr_data);
		//按钮给与点击事件
		//$('.btn-xs').click(Evidence_modification);
		}, 'json');
	} else if (material_type == "Goods_table_info") {
		$('#goods_chose').show();
		$('.add_info').hide();
	} else {
		$('#goods_chose').hide();
		$('.add_info').hide();
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
			$('.Goods_table_info tbody').html(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
			//添加按钮设置id属性值
			$('.add_info').show().val("Lost");
			//设置分页信息
			setPageInfomation(xhr_data);
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
			$('.Goods_table_info tbody').html(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
			//添加按钮设置id属性值
			$('.add_info').show().val("LostComputer");
			//设置分页信息
			setPageInfomation(xhr_data);
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
			$('.Goods_table_info tbody').html(str);
			//赋予button点击事件
			$('button.btn-xs').click(ViewSingleMessage);
			//添加按钮设置id属性值
			$('.add_info').show().val("LostMobilephone");
			//设置分页信息
			setPageInfomation(xhr_data);
		}, 'json');
	} else {
		$('.add_info').hide();
		return;
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
		$('#lost .panel-body').html(str);
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
		str += '<td>手机号码</td><td><input style="witdh:70%;" class="form-control" name="lost_mobilephone.lost_mobilephone_phone" type="text" value="' + xhr_data.lost_mobilephone.lost_mobilephone_phone + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>手机串号</td><td><input style="witdh:70%;" class="form-control" name="lost_mobilephone.lost_mobilephone_IMEI" type="text" value="' + xhr_data.lost_mobilephone.lost_mobilephone_IMEI + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>手机特征</td><td><input style="witdh:70%;" class="form-control" name="lost_mobilephone.lost_mobilephone_feature" type="text" value="' + xhr_data.lost_mobilephone.lost_mobilephone_feature + '"  /></td>';
		str += '</tr>';
		str += '<tr>';
		str += '<td>备注</td><td><textarea style="witdh:70%;" class="form-control" name="lost_mobilephone.lost_mobilephone_remarks">' + xhr_data.lost_mobilephone.lost_mobilephone_remarks + '</textarea>';
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
		$('.btn_operation').val('Mobilephone_updateLostMobilephone').unbind().click(Lost_modification);
	}, 'json');
}


//丢失物品==删除==信息
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
								if (value == 'evidence_table_info' || value == 'picture_table_info' || value == 'image_table_info') {
									material($('option[value="' + value + '"]'));
								} else {
									lost_chose($('option[value="' + value + '"]'));
								}
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



function add_default_confirm(title, content, url, value) {
	var jc = $.confirm({
		title : title,
		smoothContent : false,
		content : content,
		columnClass : 'col-xs-offset-2 col-sm-8',
		//autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-info',
				text : '确认添加',
				action : function() {
					$.post(url, $('.jconfirm-content form').serialize(), function(xhr_data) {
						if (xhr_data == "success") {
							toastr.success("添加成功！");
							//获取对应option中的value值
							if (value.indexOf('Lost') > -1) {
								lost_chose($('option[value="' + value + '"]'));
							} else {
								material($('option[value="' + value + '"]'));
							}
						} else {
							toastr.error("添加失败！");
						}
					}, 'text');
				}
			},
			cancelAction : {
				btnClass : 'btn-default',
				text : '取消',
			}
		}
	});
}


//分页方法-------=========---------==============-------==========------------=========-------=
//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页!');
		return;
	}
	switch ($('#type_chose').val()) {
	case "evidence_table_info":
		query_data["page_list_ResevidenceInformation.pageIndex"] = 1;
		material($('option[value="evidence_table_info"]'));
		break;
	case "picture_table_info":
		query_data["page_list_imageInformation.pageIndex"] = 1;
		material($('option[value="picture_table_info"]'));
		break;
	case "image_table_info":
		query_data["page_list_imageInformation.pageIndex"] = 1;
		material($('option[value="image_table_info"]'));
		break;
	case "Goods_table_info":
		switch ($('#goods_chose').val) {
		case 'Lost':
			query_data["page_list_Casematerial.pageIndex"] = 1;
			lost_chose($('option[value="Lost"]'))
			break;
		case 'LostComputer':
			query_data["page_list_Casematerial.pageIndex"] = 1;
			lost_chose($('option[value="LostComputer"]'))
			break;
		case 'LostMobilephone':
			query_data["page_list_Casematerial.pageIndex"] = 1;
			lost_chose($('option[value="LostComputer"]'))
			break;
		default:
			break;
		}
		break;
	default:
		break;
	}
}
//上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页!');
		return;
	}
	switch ($('#type_chose').val()) {
	case "evidence_table_info":
		query_data["page_list_ResevidenceInformation.pageIndex"] = page_infomantion.pageIndex - 1;
		material($('option[value="evidence_table_info"]'));
		break;
	case "picture_table_info":
		query_data["page_list_imageInformation.pageIndex"] = page_infomantion.pageIndex - 1;
		material($('option[value="picture_table_info"]'));
		break;
	case "image_table_info":
		query_data["page_list_imageInformation.pageIndex"] = page_infomantion.pageIndex - 1;
		material($('option[value="image_table_info"]'));
		break;
	case "Goods_table_info":
		switch ($('#goods_chose').val) {
		case 'Lost':
			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.pageIndex - 1;
			lost_chose($('option[value="Lost"]'))
			break;
		case 'LostComputer':
			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.pageIndex - 1;
			lost_chose($('option[value="LostComputer"]'))
			break;
		case 'LostMobilephone':
			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.pageIndex - 1;
			lost_chose($('option[value="LostComputer"]'))
			break;
		default:
			break;
		}
		break;
	default:
		break;
	}
}
//下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页!');
		return;
	}
	switch ($('#type_chose').val()) {
	case "evidence_table_info":
		query_data["page_list_ResevidenceInformation.pageIndex"] = page_infomantion.pageIndex + 1;
		material($('option[value="evidence_table_info"]'));
		break;
	case "picture_table_info":
		query_data["page_list_imageInformation.pageIndex"] = page_infomantion.pageIndex + 1;
		material($('option[value="picture_table_info"]'));
		break;
	case "image_table_info":
		query_data["page_list_imageInformation.pageIndex"] = page_infomantion.pageIndex + 1;
		material($('option[value="image_table_info"]'));
		break;
	case "Goods_table_info":
		switch ($('#goods_chose').val) {
		case 'Lost':
			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.pageIndex + 1;
			lost_chose($('option[value="Lost"]'))
			break;
		case 'LostComputer':
			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.pageIndex + 1;
			lost_chose($('option[value="LostComputer"]'))
			break;
		case 'LostMobilephone':
			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.pageIndex + 1;
			lost_chose($('option[value="LostComputer"]'))
			break;
		default:
			break;
		}
		break;
	default:
		break;
	}
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页!');
		return;
	}
	switch ($('#type_chose').val()) {
	case "evidence_table_info":
		query_data["page_list_ResevidenceInformation.pageIndex"] = page_infomantion.totalPages;
		material($('option[value="evidence_table_info"]'));
		break;
	case "picture_table_info":
		query_data["page_list_imageInformation.pageIndex"] = page_infomantion.totalPages;
		material($('option[value="picture_table_info"]'));
		break;
	case "image_table_info":
		query_data["page_list_imageInformation.pageIndex"] = page_infomantion.totalPages;
		material($('option[value="image_table_info"]'));
		break;
	case "Goods_table_info":
		switch ($('#goods_chose').val) {
		case 'Lost':			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.totalPages;
			lost_chose($('option[value="Lost"]'))
			break;
		case 'LostComputer':			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.totalPages;
			lost_chose($('option[value="LostComputer"]'))
			break;
		case 'LostMobilephone':			query_data["page_list_Casematerial.pageIndex"] = page_infomantion.totalPages;
			lost_chose($('option[value="LostComputer"]'))
			break;
		default:
			break;
		}
		break;
	default:
		break;
	}
}