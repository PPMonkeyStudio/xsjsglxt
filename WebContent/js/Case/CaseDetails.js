$(function() {
	$.post('/xsjsglxt/case/Case_SecneInformationOne', {
		"sence.xsjsglxt_snece_id" : $('#sence_id').val(),
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
	$('.add_goods').click(function() {
		var data = $('#LossOfGoods table tbody:visible').serialize();
		var url = '';
		switch ($('#LossOfGoods table tbody:visible').attr('class')) {
		case 'lost_goods':			url = '/xsjsglxt/case/Lost_saveLost';
			break;
		case 'lost_mobilephone':			url = '/xsjsglxt/case/LostComputer_saveLostComputer';
			break;
		case 'lost_computer':			url = '/xsjsglxt/case/LostMobilephone_saveLostMobilephone';
			break;
		default:
			url = '';
			break;
		}
		$.post(url, data, function() {});
	});
})



function ChangeItemType(option_obj) {
	$('#LossOfGoods table tbody').each(function() {
		if ($(this).attr("class") == $(option_obj).val()) {
			$(this).show();
		} else $(this).hide();
	});
}