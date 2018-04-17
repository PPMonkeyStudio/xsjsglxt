$(function () {
	var makeMeans = document.getElementsByName('case1.case_makeMeans')[0];
	makeMeans.addEventListener("change", setSectionmMethod(makeMeans.selectedIndex), false);
	var residence = document.getElementsByName('case1.case_residence')[0];
	residence.addEventListener("change", setSectionmAddress(residence.selectedIndex), false);
	var totalCategory = document.getElementsByName('case1.case_totalCategory')[0];
	totalCategory.addEventListener("change", setSectionCase(totalCategory.selectedIndex), false);

	var sence_id = "";
	$.post('/xsjsglxt/case/Case_SecneInformationOne', {
		"case1.xsjsglxt_case_id": $('#case1_id').val(),
	}, function (xhr_data) {
		sence_id = xhr_data.sence.xsjsglxt_snece_id;
		$('#caseDetails').find('select, input,textarea').each(function () {
			var name = $(this).attr('name');
			if (name == "register") {
				return true
			}
			var key1 = name.split('.')[0];
			var key2 = name.split('.')[1];
			if ($(this).attr("type") == "checkbox") {
				if (xhr_data[key1][key2] == 1) {
					$(this).attr("checked", "checked");
				}
			} else
				$(this).val(xhr_data[key1][key2]);
		});

		//物证列表
		var resevidence = xhr_data["resevidence"];
		$('#evidence-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < resevidence.length; index++) {
				tr_str = `<tr id="${resevidence[index]["xsjsglxt_resevidence_id"]}">
							  <td>${resevidence[index]["resevidence_name"]}</td>
							  <td>${resevidence[index]["resevidence_extractTime"]}</td>
							  <td>${resevidence[index]["resevidence_extractPerson"]}</td>
							  <td>${resevidence[index]["resevidence_type"]}</td>
							  <td><i class="fa fa fa-random"></i>&nbsp&nbsp<i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//丢失电脑列表
		var lose_computer = xhr_data["lost_computer"];
		$('#loseComputer-info table tbody').on('click', function (e) {
			var o = e.target;
			if (o.tagName == "I") {
				var ID = $(o).parents('tr').attr('id');
			}
		}).html(function () {
			var tr_str = '';
			for (let index = 0; index < lose_computer.length; index++) {
				tr_str = `<tr id="${lose_computer[index]["xsjsglxt_lost_computer_id"]}">
							  <td>${lose_computer[index]["lost_computer_brand"]}</td>
							  <td>${lose_computer[index]["lost_computer_internetAccount"]}</td>
							  <td>${lose_computer[index]["lost_computer_MAC"]}</td>
							  <td>${lose_computer[index]["lost_computer_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//丢失物列表
		var loseGoods_info = xhr_data["lose"];
		$('#loseGoods-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < loseGoods_info.length; index++) {
				tr_str = `<tr id="${loseGoods_info[index]["xsjsglxt_lost_id"]}">
							  <td>${loseGoods_info[index]["lost_name"]}</td>
							  <td>${loseGoods_info[index]["lost_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//丢失手机列表
		var LostMobilephone_info = xhr_data["lost_mobilephone"];
		$('#LostMobilephone-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < LostMobilephone_info.length; index++) {
				tr_str = `<tr id="${LostMobilephone_info[index]["xsjsglxt_lost_mobilephone_id"]}">
							  <td>${LostMobilephone_info[index]["lost_mobilephone_phone"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_IMEI"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_feature"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//照片列表
		var picture_info = xhr_data["picture"];
		$('#picture-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < picture_info.length; index++) {
				tr_str = `<tr id="${picture_info[index]["xsjsglxt_picture_id"]}">
							  <td>${picture_info[index]["picture_image"]}</td>
							  <td>${picture_info[index]["picture_identifier"]}</td>
							  <td>${picture_info[index]["picture_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		var persons = xhr_data["sence"]["snece_inquestPerson"].split(',');
		$('select[name="sence.snece_inquestPerson"]').selectpicker("val", persons);
		//物证提取人设定
		$('select[name="resevidence.resevidence_extractPerson"]').html(function () {
			var option_str = '';
			for (const key in persons) {
				option_str += '<option value="' + persons[key] + '">' + persons[key] + '</option>';
			}
			return option_str;
		}).selectpicker('refresh');
	}, 'json');

	//修改基站
	$('.modify_station').click(function () {
		if ($('#station input').val() == "") {
			toastr.info('请添加完整信息！');
			return false;
		}
		var station_data = $('#station form').serialize() + '&case1.xsjsglxt_case_id=' + $('#case1_id').val() + '&sence.xsjsglxt_snece_id=' + sence_id;
		$.post('/xsjsglxt/case/Case_updateSenceInformation', station_data, function (xhr_data) {
			if (xhr_data == 'success') {
				toastr.success('修改成功！');
				window.location.reload();
			} else {
				toastr.error('修改失败！');
			}
		}, 'text');
	});

	//序列化为对象
	$.fn.extend({
		serializeObject: function () {
			if (this.length > 1) {
				return false;
			}
			var arr = this.serializeArray();
			var obj = new Object;
			$.each(arr, function (k, v) {
				obj[v.name] = v.value;
			});
			return obj;
		}
	});

	//添加丢失物品(物品，手机，电脑)
	$('.add_goods').click(function () {
		if ($('#LossOfGoods table tbody:visible').find('input,textarea').val() == "") {
			toastr.info('请添加完整信息！');
			return;
		}
		var data = $('#Lost_Goods').serialize() + '&case1.xsjsglxt_case_id=' + $('#case1_id').val();
		var url = '';
		switch ($('#LossOfGoods table tbody:visible').attr('class')) {
			case 'lost_goods':
				url = '/xsjsglxt/case/Lost_saveLost';
				break;
			case 'lost_mobilephone':
				url = '/xsjsglxt/case/LostMobilephone_saveLostMobilephone';
				break;
			case 'lost_computer':
				url = '/xsjsglxt/case/LostComputer_saveLostComputer';
				break;
			default:
				url = '';
				break;
		}
		$.post(url, data, function (xhr_data) {
			if (xhr_data == 'success') {
				toastr.success('添加成功！');
				$('#Lost_Goods table tbody').find('input,textarea').val("");
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});

	//添加物证信息
	$('.add_evidence').click(function () {
		var evidence_data = $.extend({}, $('#lost_evidence').serializeObject(), { "case1.xsjsglxt_case_id": $('#case1_id').val() });
		$.post('/xsjsglxt/case/Resevidence_saveResevidence', evidence_data, function (xhr_data) {
			if (xhr_data.length > 22 && xhr_data.length <= 36) {
				toastr.success('添加成功！');
				var tr_str = `<tr id="${xhr_data}">
							  <td>${evidence_data["resevidence.resevidence_name"]}</td>
							  <td>${evidence_data["resevidence.resevidence_extractPerson"]}</td>
							  <td>${evidence_data["resevidence.resevidence_type"]}</td>
							  <td>${evidence_data["resevidence.resevidence_extractTime"]}</td>
							  <td><i class="fa fa fa-random"></i>&nbsp&nbsp<i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
				$('#lost_evidence table tbody').find('input,textarea').val("");
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});



	//添加照片信息
	$('.add_picture').click(function () {
		var picture_data = $.extend({}, $('#picture').serializeObject(), { "case1.xsjsglxt_case_id": $('#case1_id').val() });
		$.post('/xsjsglxt/case/Image_updatePicture', picture_data, function (xhr_data) {
			if (xhr_data.length > 22 && xhr_data.length <= 36) {
				toastr.success('添加成功！');
				tr_str = `<tr id="${xhr_data}">
							  <td>${picture_info[index]["picture_image"]}</td>
							  <td>${picture_info[index]["picture_identifier"]}</td>
							  <td>${picture_info[index]["picture_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
				$('#add_picture table tbody').find('input,textarea').val("");

			} else {
				toastr.error('添加失败！');
			}
		}, 'json');
	});
	$('#picture').on('show.bs.modal', function () {
		$.post('/xsjsglxt/case/Case_AllCase', function (Case_data) {
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

//物品中的详情信息
var UsePost = {
	data: {},
	init: function (tansmittedData, type, action, item, parent) {
		this.data.tansmittedData = tansmittedData;
		this.data.type = type;//类型
		this.data.action = action;//修改或是删除
		this.data.item = item;//当前元素
		this.data.parent = parent;//父div
	},
	sendPost: function () {
		var that = this;
		$.post(that.url, that.tansmittedData, that.getCallback(msg), 'json');
	},
	callback: function () {

	},
	getCallback: function (msg) {
		var that = this;
		var fun;
		if (this.data.action == "modify") {
			switch (this.data.type) {
				case "resevidence":
					that.data.url = '/xsjsglxt/case/Resevidence_updateResevidenceInformation';
					fun = function (msg) {
						var tr_str = '';
						for (let index = 0; index < resevidence.length; index++) {
							tr_str = `<tr id="${resevidence[index]["xsjsglxt_resevidence_id"]}">
							  <td>${resevidence[index]["resevidence_name"]}</td>
							  <td>${resevidence[index]["resevidence_extractPerson"]}</td>
							  <td>${resevidence[index]["resevidence_type"]}</td>
							  <td>${resevidence[index]["resevidence_extractTime"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
						}
					}
					break;
				case "loseGoods_info":
					that.data.url = '/xsjsglxt/case/Lost_updateLost';
					var tr_str = '';
					for (let index = 0; index < loseGoods_info.length; index++) {
						tr_str = `<tr id="${loseGoods_info[index]["xsjsglxt_lost_id"]}">
							  <td>${loseGoods_info[index]["lost_name"]}</td>
							  <td>${loseGoods_info[index]["lost_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
					}
					return tr_str;
					break;
				case "LostMobilephone_info":
					that.data.url = '/xsjsglxt/case/LostMobilephone_updateLostMobilephone';
					var tr_str = '';
					for (let index = 0; index < LostMobilephone_info.length; index++) {
						tr_str = `<tr id="${LostMobilephone_info[index]["xsjsglxt_lost_mobilephone_id"]}">
							  <td>${LostMobilephone_info[index]["lost_mobilephone_phone"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_IMEI"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_feature"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
					}
					return tr_str;
					break;
				case "lose_computer":
					that.data.url = '/xsjsglxt/case/LostComputer_updateLostComputer';
					var tr_str = '';
					for (let index = 0; index < lose_computer.length; index++) {
						tr_str = `<tr id="${lose_computer[index]["xsjsglxt_lost_computer_id"]}">
							  <td>${lose_computer[index]["lost_computer_brand"]}</td>
							  <td>${lose_computer[index]["lost_computer_internetAccount"]}</td>
							  <td>${lose_computer[index]["lost_computer_MAC"]}</td>
							  <td>${lose_computer[index]["lost_computer_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
					}
					return tr_str;
					break;
				case "picture_info":
					that.data.url = '/xsjsglxt/case/Image_updatePicture';
					var tr_str = '';
					for (let index = 0; index < picture_info.length; index++) {
						tr_str = `<tr id="${picture_info[index]["xsjsglxt_picture_id"]}">
							  <td>${picture_info[index]["picture_image"]}</td>
							  <td>${picture_info[index]["picture_identifier"]}</td>
							  <td>${picture_info[index]["picture_remarks"]}</td>
							  <td><i class="fa fa-info-circle"></i>&nbsp&nbsp<i class="fa fa-trash-o"></i></td></tr>`;
					}
					return tr_str;
					break;
				default:
					break;
			}
		}
		else if (this.data.action == "delete") {
			switch (this.data.type) {
				case "resevidence":
					that.data.url = '/xsjsglxt/case/Resevidence_remove_ResevidenceInformationList';
					break;
				case "loseGoods_info":
					that.data.url = '/xsjsglxt/case/Lost_remove_LostInformationList';
					break;
				case "LostMobilephone_info":
					that.data.url = '/xsjsglxt/case/LostMobilephone_remove_Lost_mobilephoneInformationList';
					break;
				case "lose_computer":
					that.data.url = '/xsjsglxt/case/LostComputer_remove_Lost_computerInformationList';
					break;
				case "picture_info":
					that.data.url = '/xsjsglxt/case/Image_remove_PictureInformationList';
					break;
				default:
					break;
			}
		}
		return fun;
	},
}

function UsePost(url, ID, type, action) {
	UsePost.prototype.modify = function (params) {

	}
	if (action == "modify") {

	} else if (action == "delete") {

	}
}


function sence_checkbox(checkbox) {
	var box = $(checkbox);
	if (box.val() == "1") {
		box.val('0');
	} else {
		box.val('1');
	}
}

function ChangeItemType(option_obj) {
	$('#LossOfGoods table tbody').each(function () {
		if ($(this).attr("class") == $(option_obj).val()) {
			$(this).show();
		} else $(this).hide();
	});
}

function chose_labe(params) {
	if ($(params).val() == 1) {
		$('input[name="register"][value="1"]').attr("checked", "checked");
	} else {
		$('input[name="register"][value="2"]').attr("checked", "checked");
	}
}

//CaseDetail.jsp中的修改案件
function case_change() {
	var url = "/xsjsglxt/case/Case_updateSenceInformation";
	var case1_id = document.getElementById("case1_id").value;
	console.log(case1_id);
	$.confirm({
		title: '确定修改?',
		smoothContent: false,
		content: false,
		autoClose: 'cancelAction|10000',
		buttons: {
			deleteUser: {
				btnClass: 'btn-blue',
				text: '确认',
				action: function () {
					loadCaseDetail_case_change(url, case1_id);
				}
			},
			cancelAction: {
				btnClass: 'btn-danger',
				text: '取消',
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

	/*// 版本二（箭头语法）
	var convert_FormData_to_json2 = function(formData) {
		var objData = {};

		formData.forEach((value, key) => objData[key] = value);

		return JSON.stringify(objData);
	};*/
	xmlhttp.onreadystatechange = function () {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var result = xmlhttp.responseText;

			if (result == '"success"') {
				toastr.success('修改成功！');
			} else {
				toastr.error('修改失败！');
			}
		}
	};
	xmlhttp.open("post", url, true);
	xmlhttp.send(formData);
}
//---------------------------------------------------------