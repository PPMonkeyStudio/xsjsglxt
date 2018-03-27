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
			} else if (k == "case_process") {
				$('textarea[name="case1.' + k + '"]').val(v);
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
		var briefdetails = xhr_data.briefdetails;
		$.each(briefdetails, function(k, v) {
			var obj = $('textarea[name="sence.' + k + '"]');
			if (k == "briefdetails_details") {
				$('textarea[name="briefdetails.' + k + '"]').val(v);
			}
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
				$('#lost_evidence table tbody').find('input,textarea').val("");
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});


	//添加照片信息
	$('.add_picture').click(function() {
		$.post('/xsjsglxt/case/Image_updatePicture', $('#add_picture').serialize() + '&case1.xsjsglxt_case_id=' + $('#case1_id').val(), function(xhr_data) {
			if (xhr_data == 'success') {
				toastr.success('添加成功！');
				$('#add_picture table tbody').find('input,textarea').val("");
			} else {
				toastr.error('添加失败！');
			}
		}, 'json');
	});
	$('#picture').on('show.bs.modal', function() {
		$.post('/xsjsglxt/case/Case_AllCase', function(Case_data) {
			//所有案件循环
			var option = '';
			for (var len = 0; len < Case_data.length; len++) {
				option += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('#picture').find('select[name="case1.xsjsglxt_case_id"]').html(option).selectpicker('refresh');
		//除去加载提示
		//$('.load_remind').remove();
		}, 'json');
	})

})

function ChangeItemType(option_obj) {
	$('#LossOfGoods table tbody').each(function() {
		if ($(this).attr("class") == $(option_obj).val()) {
			$(this).show();
		} else $(this).hide();
	});
}

//CaseDetail.jsp中的修改案件
function case_change() {
	var url = "/xsjsglxt/case/Case_updateSenceInformation";
	var case1_id = document.getElementById("case1_id").value;
	console.log(case1_id);
	$.confirm({
		title : '确定修改?',
		smoothContent : false,
		content : false,
		autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-blue',
				text : '确认',
				action : function() {
					loadCaseDetail_case_change(url, case1_id);
				}
			},
			cancelAction : {
				btnClass : 'btn-danger',
				text : '取消',
			}
		}
	});
}
function loadCaseDetail_case_change(url, case1_id) {
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var lost_evidence = document.getElementById("caseDetails");
	var formData = new FormData(lost_evidence);
	formData.append("case1.xsjsglxt_case_id", case1_id);

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var result = xmlhttp.responseText;

			if (result == '"success"') {
				toastr.success('添加成功！');
			} else {
				toastr.error('添加失败！');
			}
		}
	};
	xmlhttp.open("post", url, true);
	xmlhttp.send(formData);
}
//---------------------------------------------------------