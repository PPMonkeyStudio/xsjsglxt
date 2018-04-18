$(function () {
	var makeMeans = document.getElementsByName('case1.case_makeMeans')[0];
	makeMeans.addEventListener("change", setSectionmMethod(makeMeans.selectedIndex), false);
	var residence = document.getElementsByName('case1.case_residence')[0];
	residence.addEventListener("change", setSectionmAddress(residence.selectedIndex), false);
	var totalCategory = document.getElementsByName('case1.case_totalCategory')[0];
	totalCategory.addEventListener("change", setSectionCase(totalCategory.selectedIndex), false);

	//序列化为对象======----自定义方法
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

	/*===================案件和现场id记录======================= */
	var case1_id = $('#case1_id').val();
	var sence_id = "";
	/*=======================页面数据初始化开始================== */
	$.post('/xsjsglxt/case/Case_SecneInformationOne', {
		"case1.xsjsglxt_case_id": case1_id,
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

		//物证列表数据显示
		var resevidence = xhr_data["resevidence"];
		$('#evidence-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < resevidence.length; index++) {
				tr_str += `<tr id="${resevidence[index]["xsjsglxt_resevidence_id"]}">
							  <td>${resevidence[index]["resevidence_name"]}</td>
							  <td>${resevidence[index]["resevidence_extractTime"]}</td>
							  <td>${resevidence[index]["resevidence_extractPerson"]}</td>
							  <td>${resevidence[index]["resevidence_type"]}</td>
							  <td><i id="circulation" class="fa fa fa-random"></i>&nbsp&nbsp<i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//丢失电脑列表数据显示
		var lose_computer = xhr_data["lost_computer"];
		$('#loseComputer-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < lose_computer.length; index++) {
				tr_str += `<tr id="${lose_computer[index]["xsjsglxt_lost_computer_id"]}">
							  <td>${lose_computer[index]["lost_computer_brand"]}</td>
							  <td>${lose_computer[index]["lost_computer_internetAccount"]}</td>
							  <td>${lose_computer[index]["lost_computer_MAC"]}</td>
							  <td>${lose_computer[index]["lost_computer_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//丢失物列表数据显示
		var lostGoods_info = xhr_data["lost"];
		$('#loseGoods-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < lostGoods_info.length; index++) {
				tr_str += `<tr id="${lostGoods_info[index]["xsjsglxt_lost_id"]}">
							  <td>${lostGoods_info[index]["lost_name"]}</td>
							  <td>${lostGoods_info[index]["lost_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//丢失手机列表数据显示
		var LostMobilephone_info = xhr_data["lost_mobilephone"];
		$('#LostMobilephone-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < LostMobilephone_info.length; index++) {
				tr_str += `<tr id="${LostMobilephone_info[index]["xsjsglxt_lost_mobilephone_id"]}">
							  <td>${LostMobilephone_info[index]["lost_mobilephone_phone"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_IMEI"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_feature"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//照片列表数据显示
		var picture_info = xhr_data["picture"];
		$('#picture-info table tbody').html(function () {
			var tr_str = '';
			for (let index = 0; index < picture_info.length; index++) {
				tr_str += `<tr id="${picture_info[index]["xsjsglxt_picture_id"]}">
							  <td>${picture_info[index]["picture_image"]}</td>
							  <td>${picture_info[index]["picture_identifier"]}</td>
							  <td>${picture_info[index]["picture_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		//物证提取人设定
		var persons = xhr_data["sence"]["snece_inquestPerson"].split(',');
		$('select[name="sence.snece_inquestPerson"]').selectpicker("val", persons);
		$('select[name="resevidence.resevidence_extractPerson"]').html(function () {
			var option_str = '';
			for (const key in persons) {
				option_str += '<option value="' + persons[key] + '">' + persons[key] + '</option>';
			}
			return option_str;
		}).selectpicker('refresh');
	}, 'json');

	/*============================================================================添加信息系列*/
	//添加物证信息
	$('.add_evidence').click(function () {
		var evidence_data = $.extend({}, $('#evidence form').serializeObject(), { "case1.xsjsglxt_case_id": case1_id });
		$.post('/xsjsglxt/case/Resevidence_saveResevidence', evidence_data, function (xhr_data) {
			if (xhr_data.length > 22 && xhr_data.length <= 36) {
				toastr.success('添加成功！');
				//控制模态框隐藏
				$('#evidence').modal('hide');
				//数据添加
				$('#evidence-info table tbody').append(`<tr id="${xhr_data}">
							  <td>${evidence_data["resevidence.resevidence_name"]}</td>
							  <td>${evidence_data["resevidence.resevidence_extractPerson"]}</td>
							  <td>${evidence_data["resevidence.resevidence_type"]}</td>
							  <td>${evidence_data["resevidence.resevidence_extractTime"]}</td>
							  <td><i id="modify" class="fa fa fa-random"></i>&nbsp&nbsp<i class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`);
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});

	//添加丢失物品
	$('.add_lost').click(function () {
		if ($('#lost table tbody').find('input,textarea').val() == "") {
			toastr.info('请添加完整信息！');
			return;
		}
		var Lost_data = $.extend({}, $('#lost form').serializeObject(), { "case1.xsjsglxt_case_id": case1_id });
		$.post('/xsjsglxt/case/Lost_saveLost', Lost_data, function (xhr_data) {
			if (xhr_data.length > 22 && xhr_data.length <= 36) {
				toastr.info('添加成功！');
				//控制模态框隐藏
				$('#lost').modal('hide');
				//数据添加
				$('#loseGoods-info table tbody').append(`<tr id="${xhr_data}">
											 <td>${Lost_data["lost.lost_name"]}</td>
											 <td>${Lost_data["lost.lost_remarks"]}</td>
											 <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`);
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});

	//添加丢失手机
	$('.add_mobilephone').click(function () {
		if ($('#lost_mobilephone table tbody').find('input,textarea,select').val() == "") {
			toastr.info('请添加完整信息！');
			return;
		}
		var Lost_data = $.extend({}, $('#lost_mobilephone form').serializeObject(), { "case1.xsjsglxt_case_id": case1_id });
		$.post('/xsjsglxt/case/LostMobilephone_saveLostMobilephone', Lost_data, function (xhr_data) {
			if (xhr_data.length > 22 && xhr_data.length <= 36) {
				toastr.info('添加成功！');
				//控制模态框隐藏
				$('#lost_mobilephone').modal('hide');
				//数据添加
				$('#LostMobilephone-info table tbody').append(`<tr id="${xhr_data}">
											 <td>${Lost_data["lost_mobilephone.lost_mobilephone_phone"]}</td>
											 <td>${Lost_data["lost_mobilephone.lost_mobilephone_IMEI"]}</td>
											 <td>${Lost_data["lost_mobilephone.lost_mobilephone_feature"]}</td>
											 <td>${Lost_data["lost_mobilephone.lost_mobilephone_remarks"]}</td>
											 <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`);
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});

	//添加丢失电脑
	$('#add_computer').click(function () {
		if ($('#lost_computer table tbody').find('input,textarea,select').val() == "") {
			toastr.info('请添加完整信息！');
			return;
		}
		var Lost_data = $.extend({}, $('#lost_computer form').serializeObject(), { "case1.xsjsglxt_case_id": case1_id });
		$.post('/xsjsglxt/case/LostMobilephone_saveLostMobilephone', Lost_data, function (xhr_data) {
			if (xhr_data.length > 22 && xhr_data.length <= 36) {
				toastr.info('添加成功！');
				//控制模态框隐藏
				$('#lost_computer').modal('hide');
				//数据添加
				$('#loseComputer-info table tbody').append(`<tr id="${xhr_data}">
												<td>${Lost_data["lost_computer.lost_computer_brand"]}</td>
												<td>${Lost_data["lost_computer.lost_computer_internetAccount"]}</td>
												<td>${Lost_data["lost_computer.lost_computer_MAC"]}</td>
												<td>${Lost_data["lost_computer.lost_computer_remarks"]}</td>
												<td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`);
			} else {
				toastr.error('添加失败！');
			}
		}, 'text');
	});

	//添加照片信息
	$('.add_picture').click(function () {
		var picture_data = $.extend({}, $('#picture form').serializeObject(), { "case1.xsjsglxt_case_id": case1_id });
		$.post('/xsjsglxt/case/Image_updatePicture', picture_data, function (xhr_data) {
			if (xhr_data.length > 22 && xhr_data.length <= 36) {
				toastr.success('添加成功！');
				//控制模态框隐藏
				$('#picture').modal('hide');
				//数据添加
				$('#picture-info table tbody').append(`<tr id="${xhr_data}">
							  <td>${picture_data["image.xsjsglxt_image_id"]}</td>
							  <td>${picture_data["picture.picture_identifier"]}</td>
							  <td>${picture_data["picture.picture_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`);
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

	/*============================================================================修改系列*/
	//修改物证
	$('#evidence-info table tbody').on('click', function (e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			console.log(operate);
			if (operate == "circulation") {
			}
			else if (operate == "modify") {
				$.post('/xsjsglxt/case/Resevidence_ResevidenceInformationOne', { "resevidence.xsjsglxt_resevidence_id": ID }, function (msg) {
					//模态框信息填充
					$('#evidence table tbody').find('input,select,textarea').each(function () {
						var name = $(this).attr('name');
						var key = name.split('.')[1];
						$(this).val(msg["resevidence"][key]);
					});
					var select_proson = msg["resevidence"]["resevidence_extractPerson"].split(',');
					$('select[name="resevidence.resevidence_extractPerson"]').selectpicker('val', select_proson);
					//模态框展示操作
					$('#evidence .add_evidence').hide();//添加按钮消失
					$('#evidence .modify_evidence').show();//修改按钮可见
					$('#evidence').modal('show');
				}, 'json');
				//给修改按钮绑定事件
				$('#evidence .modify_evidence').unbind().click(function () {
					var data_ = $.extend({}, $('#evidence form').serializeObject(), { "resevidence.xsjsglxt_resevidence_id": ID, "resevidence.resevidence_case": case1_id });
					$('#evidence').modal('hide');
					mdPost('/xsjsglxt/case/Resevidence_updateResevidenceInformation', data_, 'evidence');
				});
			}
			else if (operate == "delete") {
				var dle_data_ = { "useResevidenceInformationNumList": ID };
				mdPost('/xsjsglxt/case/Resevidence_remove_ResevidenceInformationList', dle_data_, 'evidence');
			}
		}
	})

	//修改丢失电脑
	$('#loseComputer-info table tbody').on('click', function (e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/LostComputer_LostComputerInformationOne', { "lost_computer.xsjsglxt_lost_computer_id": ID }, function (msg) {
					$('#lost_computer table tbody').find('input,select,textarea').each(function (i, element) {
						var name = $(this).attr('name');
						var key = name.split('.')[1];
						$(this).val(msg["lost_computer"][key]);
					});
					//模态框展示操作
					$('#lost_computer .add_computer').hide();//添加按钮消失
					$('#lost_computer .modify_computer').show();//修改按钮可见
					$('#lost_computer').modal('show');
				}, 'json');
				//给修改按钮绑定事件
				$('#lost_computer .modify_computer').unbind().click(function () {
					var data_ = $.extend({}, $('#lost_computer form').serializeObject(), { "lost_computer.xsjsglxt_lost_computer_id": ID, "lost_computer.lost_computer_case": case1_id });
					$('#lost_computer').modal('hide');
					mdPost('/xsjsglxt/case/LostComputer_updateLostComputer', data_, 'computer');
				});
			}
			else if (operate == "delete") {
				var dle_data_ = { "useLost_computerInformationNumList": ID };
				mdPost('/xsjsglxt/case/LostComputer_remove_Lost_computerInformationList', dle_data_, 'computer');
			}
		}
	})

	//修改丢失手机
	$('#LostMobilephone-info table tbody').on('click', function (e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/LostMobilephone_LostMobiephoneInformationOne', { "lost_mobilephone.xsjsglxt_lost_mobilephone_id": ID }, function (msg) {
					$('#lost_mobilephone table tbody').find('input,select,textarea').each(function (i, element) {
						var name = $(this).attr('name');
						var key = name.split('.')[1];
						$(this).val(msg["lost_mobilephone"][key]);
					});
					//模态框展示操作
					$('#lost_mobilephone .add_mobilephone').hide();//添加按钮消失
					$('#lost_mobilephone .modify_mobilephone').show();//修改按钮可见
					$('#lost_mobilephone').modal('show');
				}, 'json');
				//给修改按钮绑定事件
				$('#lost_mobilephone .modify_mobilephone').unbind().click(function () {
					var data_ = $.extend({}, $('#lost_computer form').serializeObject(), { "lost_mobilephone.xsjsglxt_lost_mobilephone_id": ID, "lost_mobilephone.lost_mobilephone_case": case1_id });
					$('#lost_mobilephone').modal('hide');
					mdPost('/xsjsglxt/case/LostMobilephone_updateLostMobilephone', data_, 'mobilephone');
				});
			}
			else if (operate == "delete") {
				var dle_data_ = { "useLost_mobilephoneInformationNumList": ID };
				mdPost('/xsjsglxt/case/LostMobilephone_remove_Lost_mobilephoneInformationList', dle_data_, 'mobilephone');
			}
		}
	})

	//修改丢失物品
	$('#loseGoods-info table tbody').on('click', function (e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/Lost_LostInformationOne', { "lost.xsjsglxt_lost_id": ID }, function (msg) {
					$('#lost table tbody').find('input,select,textarea').each(function (i, element) {
						var name = $(this).attr('name');
						var key = name.split('.')[1];
						$(this).val(msg["lost"][key]);
					});
					//模态框展示操作
					$('#lost .add_lost').hide();//添加按钮消失
					$('#lost .modify_lost').show();//修改按钮可见
					$('#lost').modal('show');
				}, 'json');
				//给修改按钮绑定事件
				$('#lost .modify_lost').unbind().click(function () {
					var data_ = $.extend({}, $('#lost form').serializeObject(), { "lost.xsjsglxt_lost_id": ID, "lost.lost_case": case1_id });
					$('#lost').modal('hide');
					mdPost('/xsjsglxt/case/Lost_updateLost', data_, 'lost');
				});
			}
			else if (operate == "delete") {
				var dle_data_ = { "useLostInformationNumList": ID };
				mdPost('/xsjsglxt/case/Lost_remove_LostInformationList', dle_data_, 'lost');
			}
		}
	})

	//修改丢失照片
	$('#picture-info table tbody').on('click', function (e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/Image_getPictureOne', { "picture.xsjsglxt_picture_id": ID }, function (msg) {
					$('#picture table tbody').find('input,select,textarea').each(function (i, element) {
						var name = $(this).attr('name');
						var key = name.split('.')[1];
						$(this).val(msg["resevidence"][key]);
					});
					//模态框展示操作
					$('#picture .add_picture').hide();//添加按钮消失
					$('#picture .modify_picture').show();//修改按钮可见
					$('#picture').modal('show');
				}, 'json');
				//给修改按钮绑定事件
				$('#picture .modify_picture').unbind().click(function () {
					var data_ = $.extend({}, $('#picture form').serializeObject(), { "picture.xsjsglxt_picture_id": ID, "picture.picture_case": case1_id });
					$('#picture').modal('hide');
					mdPost('/xsjsglxt/case/Image_updatePicture', data_, 'picture');
				});
			}
			else if (operate == "delete") {
				var dle_data_ = { "usePictureInformationNumList": ID };
				mdPost('/xsjsglxt/case/Image_remove_LostInformationList', dle_data_, 'picture');
			}
		}
	})

	/*============================================================================模态框按钮事件绑定系列*/
	$.each(['#evidence', '#lost', '#lost_mobilephone', '#lost_computer', '#picture'], function (index, value) {
		//alert(i + "..." + value);
		$(value).on('hidden.bs.modal', function () {
			$(value).find('button[id^="add"]').show();
			$(value).find('button[id^="modify"]').hide();
			var refresh = '';
			$(value).find('input,select,textarea').each(function () {
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
})



/*============================================================================定义事件系列，提供使用*/
//修改使用的post
function mdPost(URL, DATA, TYPE) {
	$.post(URL, DATA, function (msg) {
		console.log(msg);
		if (msg == 'success') {
			toastr.info("操作成功");
			//将案件信息找到并刷新一遍表格中的信息
			$.post('/xsjsglxt/case/Case_SecneInformationOne', {
				"case1.xsjsglxt_case_id": case1_id,
			}, function (xhr_data) {
				switch (TYPE) {
					case 'evidence':
						//物证列表数据显示
						var resevidence = xhr_data["resevidence"];
						$('#evidence-info table tbody').html(function () {
							var tr_str = '';
							for (let index = 0; index < resevidence.length; index++) {
								tr_str += `<tr id="${resevidence[index]["xsjsglxt_resevidence_id"]}">
											<td>${resevidence[index]["resevidence_name"]}</td>
											<td>${resevidence[index]["resevidence_extractTime"]}</td>
											<td>${resevidence[index]["resevidence_extractPerson"]}</td>
											<td>${resevidence[index]["resevidence_type"]}</td>
											<td><i id="circulation" class="fa fa fa-random"></i>&nbsp&nbsp<i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
							}
							return tr_str;
						});
						break;
					case 'computer':
						//丢失电脑列表数据显示
						var lose_computer = xhr_data["lost_computer"];
						$('#loseComputer-info table tbody').html(function () {
							var tr_str = '';
							for (let index = 0; index < lose_computer.length; index++) {
								tr_str += `<tr id="${lose_computer[index]["xsjsglxt_lost_computer_id"]}">
							  <td>${lose_computer[index]["lost_computer_brand"]}</td>
							  <td>${lose_computer[index]["lost_computer_internetAccount"]}</td>
							  <td>${lose_computer[index]["lost_computer_MAC"]}</td>
							  <td>${lose_computer[index]["lost_computer_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
							}
							return tr_str;
						});
						break;
					case 'mobilephone':
						//丢失手机列表数据显示
						var LostMobilephone_info = xhr_data["lost_mobilephone"];
						$('#LostMobilephone-info table tbody').html(function () {
							var tr_str = '';
							for (let index = 0; index < LostMobilephone_info.length; index++) {
								tr_str += `<tr id="${LostMobilephone_info[index]["xsjsglxt_lost_mobilephone_id"]}">
							  <td>${LostMobilephone_info[index]["lost_mobilephone_phone"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_IMEI"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_feature"]}</td>
							  <td>${LostMobilephone_info[index]["lost_mobilephone_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
							}
							return tr_str;
						});
						break;
					case 'lost':
						//丢失物列表数据显示
						var lostGoods_info = xhr_data["lost"];
						$('#loseGoods-info table tbody').html(function () {
							var tr_str = '';
							for (let index = 0; index < lostGoods_info.length; index++) {
								tr_str += `<tr id="${lostGoods_info[index]["xsjsglxt_lost_id"]}">
							  <td>${lostGoods_info[index]["lost_name"]}</td>
							  <td>${lostGoods_info[index]["lost_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
							}
							return tr_str;
						});
						break;
					case 'picture':
						//照片列表数据显示
						var picture_info = xhr_data["picture"];
						$('#picture-info table tbody').html(function () {
							var tr_str = '';
							for (let index = 0; index < picture_info.length; index++) {
								tr_str += `<tr id="${picture_info[index]["xsjsglxt_picture_id"]}">
							  <td>${picture_info[index]["picture_image"]}</td>
							  <td>${picture_info[index]["picture_identifier"]}</td>
							  <td>${picture_info[index]["picture_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
							}
							return tr_str;
						});
						break;
					default:
						break;
				}
			}, 'json');
		}
	}, 'text');
}

//修改基站
$('.modify_station').click(function () {
	if ($('#station input').val() == "") {
		toastr.info('请添加完整信息！');
		return false;
	}
	var station_data = $('#station form').serialize() + '&case1.xsjsglxt_case_id=' + case1_id + '&sence.xsjsglxt_snece_id=' + sence_id;
	$.post('/xsjsglxt/case/Case_updateSenceInformation', station_data, function (xhr_data) {
		if (xhr_data == 'success') {
			toastr.success('修改成功！');
			window.location.reload();
		} else {
			toastr.error('修改失败！');
		}
	}, 'text');
});

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