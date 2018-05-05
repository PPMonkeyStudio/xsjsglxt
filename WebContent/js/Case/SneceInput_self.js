var Case_Snece_lost = {
	evidencelist : [],
	picturelist : [],
	computerlist : [],
	mobilephonelist : [],
	lostlist : [],
};
$(function() {
	//信息添加按钮事件绑定
	addSneceInfo();
	//模态框
	modalFun();
})

/*============================================================================模态框刷新事件*/
function modalFun() {
	$('#lostMO').change(function() {
		var modalID = $(this).find('option:selected').val();
		$(modalID).modal('show');
	});
	$.each([ '#evidence', '#lost', '#lost_mobilephone', '#lost_computer', '#picture' ], function(index, value) {
		//alert(i + "..." + value);
		$(value).on('hidden.bs.modal', function() {
			$(value).find('button[id^="add"]').show();
			$(value).find('button[id^="modify"]').hide();
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
	});
	//物证提取人信息
	$('#evidence').on('show.bs.modal', function() {
		var op = $('select[name="sence.snece_inquestPerson"]').selectpicker('val').filter(item => item);
		$(this).find('select[name="resevidence.resevidence_extractPerson"]').html(function() {
			var option = '';
			for (var int = 0; int < op.length; int++) {
				option += `<option value="${op[int]}">${op[int]}<option>`;
			}
			console.log(option);
			return option;
		}).selectpicker('refresh');
	});
	//照片中的光盘信息
	$.post('/xsjsglxt/case/Image_ListAllImageInformation', function(Image_data) {
		//所有光盘遍历
		var option = '';
		for (var len = 0; len < Image_data.length; len++) {
			option += '<option value="' + Image_data[len].image_number + '">' + Image_data[len].image_number + '</option>';
		}
		$('#picture').find('select[name="image.xsjsglxt_image_id"]').html(option).selectpicker('refresh');
	}, 'json');
}
/*============================================================================添加信息事件*/
function addSneceInfo() {
	//添加物证信息
	$('.add_evidence').click(function() {
		var falg = true;
		$('#evidence table tbody').find('input,textarea,select').each(function() {
			if (!$(this).val()) {
				toastr.info('请添加完整信息！');
				falg = false;
				return false;
			}
		});
		if (falg) {
			var evidence_data = $.extend({}, $('#evidence form').serializeObject(), {
				//"case1.xsjsglxt_case_id" : case1_id,
				"resevidence.resevidence_teststate" : "未检验",
				"resevidence.resevidence_sendstate" : "未送检"
			});
			$('#evidence').modal('hide');
			Case_Snece_lost.evidencelist.push(evidence_data);
			toastr.info('已有' + Case_Snece_lost.evidencelist.length + '物证信息记录');
		}

	/*$.post('/xsjsglxt/case/Resevidence_saveResevidence', evidence_data, function(xhr_data) {
		if (xhr_data.length > 22 && xhr_data.length <= 36) {
			toastr.success('添加成功！');
			//控制模态框隐藏
			$('#evidence').modal('hide');
		} else {
			toastr.error('添加失败！');
		}
	}, 'text');*/
	});

	//添加丢失物品
	$('.add_lost').click(function() {
		var falg = true;
		$('#lost table tbody').find('input,textarea,select').each(function() {
			if (!$(this).val()) {
				toastr.info('请添加完整信息！');
				falg = false;
				return false;
			}
		});
		if (falg) {
			var Lost_data = $.extend({}, $('#lost form').serializeObject(), {
				//"case1.xsjsglxt_case_id" : case1_id
			});
			$('#lost').modal('hide');
			Case_Snece_lost.lostlist.push(Lost_data);
			toastr.info('已有' + Case_Snece_lost.lostlist.length + '被盗物品信息记录');
		}
	/*$.post('/xsjsglxt/case/Lost_saveLost', Lost_data, function(xhr_data) {
	if (xhr_data.length > 22 && xhr_data.length <= 36) {
		toastr.info('添加成功！');
		//控制模态框隐藏
		$('#lost').modal('hide');
	} else {
		toastr.error('添加失败！');
	}
	}, 'text');*/
	});

	//添加丢失手机
	$('.add_mobilephone').click(function() {
		var falg = true;
		$('#lost_mobilephone table tbody').find('input,textarea,select').each(function() {
			if (!$(this).val()) {
				toastr.info('请添加完整信息！');
				falg = false;
				return false;
			}
		});
		if (falg) {
			var Lost_data = $.extend({}, $('#lost_mobilephone form').serializeObject(), {
				//"case1.xsjsglxt_case_id" : case1_id
			});
			$('#lost_mobilephone').modal('hide');
			Case_Snece_lost.mobilephonelist.push(Lost_data);
			toastr.info('已有' + Case_Snece_lost.mobilephonelist.length + '被盗手机信息记录');
		}
	/*$.post('/xsjsglxt/case/LostMobilephone_saveLostMobilephone', Lost_data, function(xhr_data) {
		if (xhr_data.length > 22 && xhr_data.length <= 36) {
			toastr.info('添加成功！');
			//控制模态框隐藏
			$('#lost_mobilephone').modal('hide');
		} else {
			toastr.error('添加失败！');
		}
	}, 'text');*/
	});

	//添加丢失电脑
	$('#add_computer').click(function() {
		var falg = true;
		$('#lost_computer table tbody').find('input,textarea,select').each(function() {
			if (!$(this).val()) {
				toastr.info('请添加完整信息！');
				falg = false;
				return false;
			}
		});
		if (falg) {
			var Lost_data = $.extend({}, $('#lost_computer form').serializeObject(), {
				//"case1.xsjsglxt_case_id" : case1_id
			});
			$('#lost_computer').modal('hide');
			Case_Snece_lost.computerlist.push(Lost_data);
			toastr.info('已有' + Case_Snece_lost.computerlist.length + '被盗电脑信息记录');
		}
	/*$.post('/xsjsglxt/case/LostMobilephone_saveLostMobilephone', Lost_data, function(xhr_data) {
		if (xhr_data.length > 22 && xhr_data.length <= 36) {
			toastr.info('添加成功！');
			//控制模态框隐藏
			$('#lost_computer').modal('hide');
		} else {
			toastr.error('添加失败！');
		}
	}, 'text');*/
	});

	//添加照片信息
	$('.add_picture').click(function() {
		var falg = true;
		$('#picture table tbody').find('input,textarea,select').each(function() {
			if (!$(this).val()) {
				toastr.info('请添加完整信息！');
				falg = false;
				return false;
			}
		});
		if (falg) {
			var picture_data = $.extend({}, $('#picture form').serializeObject(), {
				//"case1.xsjsglxt_case_id" : case1_id
			});
			$('#picture').modal('hide');
			Case_Snece_lost.picturelist.push(picture_data);
			toastr.info('已有' + Case_Snece_lost.picturelist.length + '被盗照片信息记录');
		}
	/*$.post('/xsjsglxt/case/Image_savePicture', picture_data, function(xhr_data) {
		if (xhr_data.length > 22 && xhr_data.length <= 36) {
			toastr.success('添加成功！');
			//控制模态框隐藏
			$('#picture').modal('hide');
		} else {
			toastr.error('添加失败！');
		}
	}, 'json');*/
	})
}