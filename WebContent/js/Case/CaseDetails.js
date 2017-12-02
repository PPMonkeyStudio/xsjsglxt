$(function() {
	$.post('/xsjsglxt/case/Case_SecneInformationOne', {
		"case1.xsjsglxt_case_id" : $('#case1_id').val(),
	}, function(xhr_data) {
		var case1 = xhr_data.case1;
		$.each(case1, function(k, v) {
			if (k == "case_register") {
				if ($('input[type="radio"]').eq(0).val() == v) {
					$('input[type="radio"]').eq(0).attr("checked", "checked");
				} else {
					$('input[type="radio"]').eq(1).attr("checked", "checked");
				}
			} else
				$('input[name="case1.' + k + '"]').val(v);
		});
		var sence = xhr_data.sence;
		$.each(sence, function(k, v) {
			var obj = $('input[name="sence.' + k + '"]');
			if (obj.attr("type") == "checkbox") {
				if (v == 1) {
					obj.attr("checked", "checked");
				}
			} else
				obj.val(v);

		});
	}, 'json');

	//添加丢失物品(物品，手机，电脑)
	$('.add_goods').click(function() {
		if ($('#LossOfGoods table tbody:visible').find('input,textarea').val() == "") {
			toastr.error('请添加完整信息！');
			return;
		}
		var data = $('#Lost_Goods').serialize() + '&case1.xsjsglxt_case_id=' + $('#case1_id').val();
		var url = '';
		switch ($('#LossOfGoods table tbody:visible').attr('class')) {
		case 'lost_goods':			url = '/xsjsglxt/case/Lost_saveLost';
			break;
		case 'lost_mobilephone':			url = '/xsjsglxt/case/LostMobilephone_saveLostMobilephone';
			break;
		case 'lost_computer':			url = '/xsjsglxt/case/LostComputer_saveLostComputer';
			break;
		default:
			url = '';
			break;
		}
		$.post(url, data, function(xhr_data) {
			if (xhr_data == 'success') {
				toastr.success('添加成功！');
				$('#Lost_Goods table tbody').find('input,textarea').val("");
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});
	//添加物证信息
	$('.add_evidence').click(function() {
		$.post('/xsjsglxt/case/Resevidence_saveResevidence', $('#lost_evidence').serialize() + '&case1.xsjsglxt_case_id=' + $('#case1_id').val(), function(xhr_data) {
			if (xhr_data == 'success') {
				toastr.success('添加成功！');
				$('#Lost_Goods table tbody').find('input,textarea').val("");
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});
})





function ChangeItemType(option_obj) {
	$('#LossOfGoods table tbody').each(function() {
		if ($(this).attr("class") == $(option_obj).val()) {
			$(this).show();
		} else $(this).hide();
	});
}