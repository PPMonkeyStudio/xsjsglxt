/**
 * @author 何毅
 */
/* ===================案件和现场id记录======================= */
// 便以全局使用
var case1_id = $('#case1_id').val();
var sence_id = "";

$(function() {

	// 序列化为对象======----自定义方法
	$.fn.extend({
		serializeObject : function() {
			if (this.length > 1) {
				return false;
			}
			var arr = this.serializeArray();
			var obj = new Object;
			$.each(arr, function(k, v) {
				obj[v.name] = v.value;
			});
			return obj;
		}
	});
	// 只在本页面使用
	$.fn.extend({
		serializeCaseDetails : function() {
			if (this.length > 1) {
				return false;
			}
			var obj = new Object;
			this.find('input,select,textarea').each(function(i, e) {
				obj[e.name] = $(e).val();
			});
			obj["sence.snece_inquestPerson"] = obj["sence.snece_inquestPerson"].join();
			return obj;
		}
	});

	/* =======================页面数据初始化开始================== */
	$.post('/xsjsglxt/case/Case_SecneInformationOne', {
		"case1.xsjsglxt_case_id" : case1_id
	}, function(xhr_data) {
		// 保存现场ID
		sence_id = xhr_data.sence.xsjsglxt_snece_id;
		// 保存下载的文件ID
		downloadFile.case_imageFile = xhr_data.case1.case_imageFile;
		downloadFile.case_writeFile = xhr_data.case1.case_writeFile;
		downloadFile.case_senceImageFile = xhr_data.case1.case_senceImageFile;
		// 主信息
		$('#caseDetails').find('select, input,textarea').each(function() {
			if ($(this).attr('name')) {
				var name = $(this).attr('name');
				if (name == "register") {
					return true
				}
				var key1 = name.split('.')[0];
				var key2 = name.split('.')[1];
				$(this).val(xhr_data[key1][key2]);
			}
		});
		// redio信息
		$("input[type=radio][name=register][value=" + xhr_data["case1"]["case_register"] + "]").attr("checked", 'checked');
		// select信息
		$('select[name="case1.case_sonCategory"]').html(`<option selected value="${xhr_data["case1"]["case_sonCategory"]}">${xhr_data["case1"]["case_sonCategory"]}</option>`);
		$('select[name="case1.case_concreteMakeMeans"]').html(`<option selected value="${xhr_data["case1"]["case_concreteMakeMeans"]}">${xhr_data["case1"]["case_concreteMakeMeans"]}</option>`);
		$('select[name="case1.case_concreteResidence"]').html(`<option selected value="${xhr_data["case1"]["case_concreteResidence"]}">${xhr_data["case1"]["case_concreteResidence"]}</option>`);

		// 物证列表数据显示
		var resevidence = xhr_data["resevidence"];
		$('#evidence-info table tbody').html(function() {
			var tr_str = '';
			for (let index = 0; index < resevidence.length; index++) {
				tr_str += `<tr id="${resevidence[index]["xsjsglxt_resevidence_id"]}">
							  <td>${resevidence[index]["resevidence_name"]}</td>
							  <td>${resevidence[index]["resevidence_extractTime"]}</td>
							  <td>${resevidence[index]["resevidence_extractPerson"]}</td>
							  <td><span class="label label-info">${resevidence[index]["resevidence_circulation"] == undefined ? "未流转" : resevidence[index]["resevidence_circulation"]}</span></td>
							  <td><span class="label ${resevidence[index]["resevidence_sendstate"] == "已送检" ? "label-default" : "label-primary"}">${resevidence[index]["resevidence_sendstate"]}</span>|<span class="label ${resevidence[index]["resevidence_teststate"] == "已检验" ? "label-default" : "label-primary"}">${resevidence[index]["resevidence_teststate"]}</span></td>
							  <td><i title="上传物证照片" id="uploadimage" class="fa fa-upload"></i>&nbsp&nbsp<i title="修改" id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i title="删除" id="delete" class="fa fa-trash-o"></i></td></tr>`;
			}
			/* <i id="circulation" class="fa fa fa-random"></i>&nbsp&nbsp */
			return tr_str;
		});

		// 丢失电脑列表数据显示
		var lose_computer = xhr_data["lost_computer"];
		$('#loseComputer-info table tbody').html(function() {
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

		// 丢失物列表数据显示
		var lostGoods_info = xhr_data["lost"];
		$('#loseGoods-info table tbody').html(function() {
			var tr_str = '';
			for (let index = 0; index < lostGoods_info.length; index++) {
				tr_str += `<tr id="${lostGoods_info[index]["xsjsglxt_lost_id"]}">
							  <td>${lostGoods_info[index]["lost_name"]}</td>
							  <td>${lostGoods_info[index]["lost_model"]}</td>
							  <td>${lostGoods_info[index]["lost_number"]}</td>
							  <td>${lostGoods_info[index]["lost_price"]}</td>
							  <td>${lostGoods_info[index]["lost_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
			}
			return tr_str;
		});

		// 丢失手机列表数据显示
		var LostMobilephone_info = xhr_data["lost_mobilephone"];
		$('#LostMobilephone-info table tbody').html(function() {
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

		// 照片列表数据显示
		var picture_info = xhr_data["picture"];
		$('#picture-info table tbody').html(function() {
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
		// 照片中的光盘信息
		$.post('/xsjsglxt/case/Image_ListAllImageInformation', function(Image_data) {
			// 所有光盘遍历
			var option = '';
			for (var len = 0; len < Image_data.length; len++) {
				option += '<option value="' + Image_data[len].image_number + '">' + Image_data[len].image_number + '</option>';
			}
			$('#picture').find('select[name="image.xsjsglxt_image_id"]').html(option).selectpicker('refresh');
		}, 'json');



		// 获取案件的勘验人员
		var persons = xhr_data["sence"]["snece_inquestPerson"].split(',');
		console.log(persons);
		// 勘验人员查询，以便修改勘验人员
		$.post('/xsjsglxt/team/Staff_getInquestPerson', {}, function(params) {
			var leader = params.leader;
			var human = params.human;
			var suspectStr = '';
			for (let index = 0; index < leader.length; index++) {
				suspectStr += '<option value="' + leader[index]["xsjsglxt_name"] + '">' + leader[index]["xsjsglxt_name"] + '</option>';
			}
			for (let index = 0; index < human.length; index++) {
				suspectStr += '<option value="' + human[index]["xsjsglxt_name"] + '">' + human[index]["xsjsglxt_name"] + '</option>';
			}
			$('select[name="sence.snece_inquestPerson"]').html(suspectStr).selectpicker('refresh').selectpicker('val', persons);
		}, 'json');
		// 物证提取人设定
		$('select[name="resevidence.resevidence_extractPerson"]').html(function() {
			var option_str = '';
			for (const key in persons) {
				option_str += '<option value="' + persons[key] + '">' + persons[key] + '</option>';
			}
			return option_str;
		}).selectpicker('refresh');
	}, 'json');

	/* ============================================================================添加信息系列 */
	// 添加物证信息
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
				"case1.xsjsglxt_case_id" : case1_id,
				"resevidence.resevidence_teststate" : "未检验",
				"resevidence.resevidence_sendstate" : "未送检",
				"resevidence.resevidence_image" : "无",
			});
			// 手动更改提取人
			evidence_data["resevidence.resevidence_extractPerson"] = $('select[name="resevidence.resevidence_extractPerson"]').val().join();
			$.post('/xsjsglxt/case/Resevidence_saveResevidence', evidence_data, function(xhr_data) {
				if (xhr_data.length > 22 && xhr_data.length <= 36) {
					toastr.success('添加成功！');
					// 控制模态框隐藏
					$('#evidence').modal('hide');
					// 数据刷新
					$.post('/xsjsglxt/case/Case_SecneInformationOne', {
						"case1.xsjsglxt_case_id" : case1_id,
					}, function(xhr_data) {
						var resevidence = xhr_data["resevidence"];
						$('#evidence-info table tbody').html(function() {
							var tr_str = '';
							for (let index = 0; index < resevidence.length; index++) {
								tr_str += `<tr id="${resevidence[index]["xsjsglxt_resevidence_id"]}">
										   <td>${resevidence[index]["resevidence_name"]}</td>
										   <td>${resevidence[index]["resevidence_extractTime"]}</td>
										   <td>${resevidence[index]["resevidence_extractPerson"]}</td>
										   <td><span class="label label-info">${resevidence[index]["resevidence_circulation"] == undefined ? "未流转" : resevidence[index]["resevidence_circulation"]}</span></td>
										   <td><span class="label ${resevidence[index]["resevidence_sendstate"] == "已送检" ? "label-default" : "label-primary"}">${resevidence[index]["resevidence_sendstate"]}</span>|<span class="label ${resevidence[index]["resevidence_teststate"] == "已检验" ? "label-default" : "label-primary"}">${resevidence[index]["resevidence_teststate"]}</span></td>
										   <td><i title="上传物证照片" id="uploadimage" class="fa fa-upload">&nbsp&nbsp</i><i title="修改" id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i title="删除" id="delete" class="fa fa-trash-o"></i></td></tr>`;
							}
							return tr_str;
						});
					}, 'json');
				} else {
					toastr.error('添加失败！');
				}
			}, 'text');
		}
	});

	// 添加丢失物品
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
				"case1.xsjsglxt_case_id" : case1_id
			});
			console.log(Lost_data);
			$.post('/xsjsglxt/case/Lost_saveLost', Lost_data, function(xhr_data) {
				if (xhr_data.length > 22 && xhr_data.length <= 36) {
					toastr.info('添加成功！');
					// 控制模态框隐藏
					$('#lost').modal('hide');
					// 数据添加
					$('#loseGoods-info table tbody').append(`<tr id="${xhr_data}">
											 <td>${Lost_data["lost.lost_name"]}</td>
											 <td>${Lost_data["lost.lost_model"]}</td>
							 				 <td>${Lost_data["lost.lost_number"]}</td>
							  				 <td>${Lost_data["lost.lost_price"]}</td>
											 <td>${Lost_data["lost.lost_remarks"]}</td>
											 <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`);
				} else {
					toastr.error('添加失败！');
				}
			}, 'text');
		}
	});

	// 添加丢失手机
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
				"case1.xsjsglxt_case_id" : case1_id
			});
			$.post('/xsjsglxt/case/LostMobilephone_saveLostMobilephone', Lost_data, function(xhr_data) {
				if (xhr_data.length > 22 && xhr_data.length <= 36) {
					toastr.info('添加成功！');
					// 控制模态框隐藏
					$('#lost_mobilephone').modal('hide');
					// 数据添加
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
		}
	});

	// 添加丢失电脑
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
				"case1.xsjsglxt_case_id" : case1_id
			});
			$.post('/xsjsglxt/case/LostMobilephone_saveLostMobilephone', Lost_data, function(xhr_data) {
				if (xhr_data.length > 22 && xhr_data.length <= 36) {
					toastr.info('添加成功！');
					// 控制模态框隐藏
					$('#lost_computer').modal('hide');
					// 数据添加
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
		}
	});

	// 添加照片信息
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
				"case1.xsjsglxt_case_id" : case1_id
			});
			$.post('/xsjsglxt/case/Image_savePicture', picture_data, function(xhr_data) {
				if (xhr_data.length > 22 && xhr_data.length <= 36) {
					toastr.success('添加成功！');
					// 控制模态框隐藏
					$('#picture').modal('hide');
					// 数据添加
					$('#picture-info table tbody').append(`<tr id="${xhr_data}">
							  <td>${picture_data["image.xsjsglxt_image_id"]}</td>
							  <td>${picture_data["picture.picture_identifier"]}</td>
							  <td>${picture_data["picture.picture_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`);
				} else {
					toastr.error('添加失败！');
				}
			}, 'json');
		}
	})

	/* ============================================================================修改系列 */
	// 修改物证
	$('#evidence-info table tbody').on('click', function(e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "circulation") {
				$.post('/xsjsglxt/case/Resevidence_ResevidenceInformationOne', {
					"resevidence.xsjsglxt_resevidence_id" : ID
				}, function(msg) {
					$('#circulation-info form').find('input').each(function() {
						if ($(this).attr('name')) {
							var name = $(this).attr('name');
							var key = name.split('.')[1];
							$(this).val(msg["resevidence"][key]);
						}
					});
					// 给修改按钮绑定事件
					$('#circulation-info .save_circulation').unbind().click(function() {
						var resevidence_ = {};
						for (const key in msg["resevidence"]) {
							resevidence_['resevidence.' + key] = msg["resevidence"][key];
						}
						var data_ = $.extend({}, $('#circulation-info form').serializeObject(), resevidence_);
					});
					// 模态框出现
					$('#circulation-info').modal('show');
				}, 'json');
			} else if (operate == "modify") {
				$.post('/xsjsglxt/case/Resevidence_ResevidenceInformationOne', {
					"resevidence.xsjsglxt_resevidence_id" : ID
				}, function(msg) {
					// 模态框信息填充
					$('#evidence table tbody').find('input,select,textarea').each(function() {
						if ($(this).attr('name')) {
							var name = $(this).attr('name');
							var key = name.split('.')[1];
							$(this).val(msg["resevidence"][key]);
						}
					});
					// console.log("wwwwwww:" +
					// (msg["resevidence"]["resevidence_extractPerson"]).split(','));
					var select_proson = (msg["resevidence"]["resevidence_extractPerson"]).split(',');
					$('select[name="resevidence.resevidence_extractPerson"]').selectpicker('val', select_proson);
					// 模态框展示操作
					$('#evidence .add_evidence').hide(); // 添加按钮消失
					$('#evidence .modify_evidence').show(); // 修改按钮可见
					$('#evidence').modal('show');

					// 给修改按钮绑定事件
					$('#evidence .modify_evidence').unbind().click(function() {
						var data_ = $.extend({}, $('#evidence form').serializeObject(), {
							"resevidence.xsjsglxt_resevidence_id" : ID,
							"resevidence.resevidence_case" : case1_id,
							"resevidence.resevidence_image" : msg["resevidence"]["resevidence_image"],
							"resevidence.resevidence_teststate" : msg["resevidence"]["resevidence_teststate"],
							"resevidence.resevidence_sendstate" : msg["resevidence"]["resevidence_sendstate"],
						});
						$('#evidence').modal('hide');
						mdPost('/xsjsglxt/case/Resevidence_updateResevidenceInformation', data_, 'evidence');
					});
				}, 'json');
			} else if (operate == "delete") {
				var dle_data_ = {
					"useResevidenceInformationNumList" : ID
				};
				mdPost('/xsjsglxt/case/Resevidence_remove_ResevidenceInformationList', dle_data_, 'evidence');
			} else if (operate == "uploadimage") {
				var uploadimage = $.confirm({
					title : '物证图片上传',
					smoothContent : false,
					content : `	<table><tbody>
								<tr>
									<td><button type="button" style="float: left;" class="btn btn-primary">上传</button><span></span></td>
									<td><input style="display:none" type="file" id="up-file"></td>
								</tr>
								</tbody></table>`,
					onContentReady : function() {
						uploadimage.$content.find('#up-file').change(function() {
							uploadimage.$content.find('.btn-primary').next('span').html(this.value);
						});
						uploadimage.$content.find('.btn-primary').click(function() {
							uploadimage.$content.find('#up-file').click();
						});
					},
					buttons : {
						deleteUser : {
							btnClass : 'btn-blue',
							text : '确认',
							action : function() {
								var formData = new FormData();
								formData.append("resevidenceImage", uploadimage.$content.find('#up-file').get(0).files[0]);
								formData.append("resevidence.xsjsglxt_resevidence_id", ID);
								if (formData != null) {
									$.ajax({
										url : "/xsjsglxt/case/Resevidence_uploadResevidenceImage",
										type : "post",
										timeout : 3000,
										data : formData,
										contentType : false,
										processData : false,
										success : function(data) {
											$.alert('上传成功!')
										},
										error : function() {}
									});
								} else {
									$.alert('选择文件!')
								}
							}
						},
						cancelAction : {
							btnClass : 'btn-danger',
							text : '取消',
						}
					}
				});
			}
		}
	})

	// 修改丢失电脑
	$('#loseComputer-info table tbody').on('click', function(e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/LostComputer_LostComputerInformationOne', {
					"lost_computer.xsjsglxt_lost_computer_id" : ID
				}, function(msg) {
					$('#lost_computer table tbody').find('input,select,textarea').each(function(i, element) {
						if ($(this).attr('name')) {
							var name = $(this).attr('name');
							var key = name.split('.')[1];
							$(this).val(msg["lost_computer"][key]);
						}
					});
					// 模态框展示操作
					$('#lost_computer .add_computer').hide(); // 添加按钮消失
					$('#lost_computer .modify_computer').show(); // 修改按钮可见
					$('#lost_computer').modal('show');
				}, 'json');
				// 给修改按钮绑定事件
				$('#lost_computer .modify_computer').unbind().click(function() {
					var data_ = $.extend({}, $('#lost_computer form').serializeObject(), {
						"lost_computer.xsjsglxt_lost_computer_id" : ID,
						"lost_computer.lost_computer_case" : case1_id
					});
					$('#lost_computer').modal('hide');
					mdPost('/xsjsglxt/case/LostComputer_updateLostComputer', data_, 'computer');
				});
			} else if (operate == "delete") {
				var dle_data_ = {
					"useLost_computerInformationNumList" : ID
				};
				mdPost('/xsjsglxt/case/LostComputer_remove_Lost_computerInformationList', dle_data_, 'computer');
			}
		}
	})

	// 修改丢失手机
	$('#LostMobilephone-info table tbody').on('click', function(e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/LostMobilephone_LostMobiephoneInformationOne', {
					"lost_mobilephone.xsjsglxt_lost_mobilephone_id" : ID
				}, function(msg) {
					$('#lost_mobilephone table tbody').find('input,select,textarea').each(function(i, element) {
						if ($(this).attr('name')) {
							var name = $(this).attr('name');
							var key = name.split('.')[1];
							$(this).val(msg["lost_mobilephone"][key]);
						}
					});
					// 模态框展示操作
					$('#lost_mobilephone .add_mobilephone').hide(); // 添加按钮消失
					$('#lost_mobilephone .modify_mobilephone').show(); // 修改按钮可见
					$('#lost_mobilephone').modal('show');
				}, 'json');
				// 给修改按钮绑定事件
				$('#lost_mobilephone .modify_mobilephone').unbind().click(function() {
					var data_ = $.extend({}, $('#lost_computer form').serializeObject(), {
						"lost_mobilephone.xsjsglxt_lost_mobilephone_id" : ID,
						"lost_mobilephone.lost_mobilephone_case" : case1_id
					});
					$('#lost_mobilephone').modal('hide');
					mdPost('/xsjsglxt/case/LostMobilephone_updateLostMobilephone', data_, 'mobilephone');
				});
			} else if (operate == "delete") {
				var dle_data_ = {
					"useLost_mobilephoneInformationNumList" : ID
				};
				mdPost('/xsjsglxt/case/LostMobilephone_remove_Lost_mobilephoneInformationList', dle_data_, 'mobilephone');
			}
		}
	})

	// 修改丢失物品
	$('#loseGoods-info table tbody').on('click', function(e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/Lost_LostInformationOne', {
					"lost.xsjsglxt_lost_id" : ID
				}, function(msg) {
					$('#lost table tbody').find('input,select,textarea').each(function(i, element) {
						if ($(this).attr('name')) {
							var name = $(this).attr('name');
							var key = name.split('.')[1];
							$(this).val(msg["lost"][key]);
						}
					});
					// 模态框展示操作
					$('#lost .add_lost').hide(); // 添加按钮消失
					$('#lost .modify_lost').show(); // 修改按钮可见
					$('#lost').modal('show');
				}, 'json');
				// 给修改按钮绑定事件
				$('#lost .modify_lost').unbind().click(function() {
					var data_ = $.extend({}, $('#lost form').serializeObject(), {
						"lost.xsjsglxt_lost_id" : ID,
						"lost.lost_case" : case1_id
					});
					$('#lost').modal('hide');
					mdPost('/xsjsglxt/case/Lost_updateLost', data_, 'lost');
				});
			} else if (operate == "delete") {
				var dle_data_ = {
					"useLostInformationNumList" : ID
				};
				mdPost('/xsjsglxt/case/Lost_remove_LostInformationList', dle_data_, 'lost');
			}
		}
	})

	// 修改丢失照片
	$('#picture-info table tbody').on('click', function(e) {
		var o = e.target;
		if (o.tagName == "I") {
			var ID = $(o).parents('tr').attr('id');
			var operate = $(o).attr('id');
			if (operate == "modify") {
				$.post('/xsjsglxt/case/Image_getPictureOne', {
					"picture.xsjsglxt_picture_id" : ID
				}, function(msg) {
					$('#picture table tbody').find('input,select,textarea').each(function(i, element) {
						if ($(this).attr('name')) {
							var name = $(this).attr('name');
							var key = name.split('.')[1];
							$(this).val(msg["resevidence"][key]);
						}
					});
					// 模态框展示操作
					$('#picture .add_picture').hide(); // 添加按钮消失
					$('#picture .modify_picture').show(); // 修改按钮可见
					$('#picture').modal('show');
				}, 'json');
				// 给修改按钮绑定事件
				$('#picture .modify_picture').unbind().click(function() {
					var data_ = $.extend({}, $('#picture form').serializeObject(), {
						"picture.xsjsglxt_picture_id" : ID,
						"picture.picture_case" : case1_id
					});
					$('#picture').modal('hide');
					mdPost('/xsjsglxt/case/Image_updatePicture', data_, 'picture');
				});
			} else if (operate == "delete") {
				var dle_data_ = {
					"usePictureInformationNumList" : ID
				};
				mdPost('/xsjsglxt/case/Image_remove_LostInformationList', dle_data_, 'picture');
			}
		}
	})

	/* ============================================================================模态框按钮事件绑定系列 */
	$.each([ '#evidence', '#lost', '#lost_mobilephone', '#lost_computer', '#picture' ], function(index, value) {
		// alert(i + "..." + value);
		$(value).on('hidden.bs.modal', function() {
			$(value).find('button[id^="add"]').show();
			$(value).find('button[id^="modify"]').hide();
			var refresh = '';
			$(value).find('input,select,textarea').each(function() {
				refresh = $(this).attr("refresh");
				// 文本刷新
				if (refresh == "text") {
					$(this).val('');
				}
				// select插件刷新
				else if (refresh == "selectpicker") {
					$(this).selectpicker('deselectAll');
				} else {

				}
			});
		})
	});
})



/* ============================================================================定义事件系列，提供修改时候使用 */
// 修改使用的post
function mdPost(URL, DATA, TYPE) {
	$.post(URL, DATA, function(msg) {
		if (msg == 'success') {
			toastr.info("操作成功");
			// 将案件信息找到并刷新一遍表格中的信息
			$.post('/xsjsglxt/case/Case_SecneInformationOne', {
				"case1.xsjsglxt_case_id" : case1_id,
			}, function(xhr_data) {
				switch (TYPE) {
				case 'evidence':
					// 物证列表数据显示
					var resevidence = xhr_data["resevidence"];
					$('#evidence-info table tbody').html(function() {
						var tr_str = '';
						for (let index = 0; index < resevidence.length; index++) {
							tr_str += `<tr id="${resevidence[index]["xsjsglxt_resevidence_id"]}">
							  <td>${resevidence[index]["resevidence_name"]}</td>
							  <td>${resevidence[index]["resevidence_extractTime"]}</td>
							  <td>${resevidence[index]["resevidence_extractPerson"]}</td>
							  <td><span class="label label-info">${resevidence[index]["resevidence_circulation"] == undefined ? "未流转" : resevidence[index]["resevidence_circulation"]}</span></td>
							  <td><span class="label ${resevidence[index]["resevidence_sendstate"] == "已送检" ? "label-default" : "label-primary"}">${resevidence[index]["resevidence_sendstate"]}</span>|<span class="label ${resevidence[index]["resevidence_teststate"] == "已检验" ? "label-default" : "label-primary"}">${resevidence[index]["resevidence_teststate"]}</span></td>
							  <td><i title="上传物证照片" id="uploadimage" class="fa fa-upload"></i>&nbsp&nbsp<i title="修改" id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i title="删除" id="delete" class="fa fa-trash-o"></i></td></tr>`;
						}
						/* <i id="circulation" class="fa fa fa-random"></i>&nbsp&nbsp */
						return tr_str;
					});
					break;
				case 'computer':
					// 丢失电脑列表数据显示
					var lose_computer = xhr_data["lost_computer"];
					$('#loseComputer-info table tbody').html(function() {
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
					// 丢失手机列表数据显示
					var LostMobilephone_info = xhr_data["lost_mobilephone"];
					$('#LostMobilephone-info table tbody').html(function() {
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
					// 丢失物列表数据显示
					var lostGoods_info = xhr_data["lost"];
					$('#loseGoods-info table tbody').html(function() {
						var tr_str = '';
						for (let index = 0; index < lostGoods_info.length; index++) {
							tr_str += `<tr id="${lostGoods_info[index]["xsjsglxt_lost_id"]}">
							  <td>${lostGoods_info[index]["lost_name"]}</td>
							  <td>${lostGoods_info[index]["lost_model"]}</td>
							  <td>${lostGoods_info[index]["lost_number"]}</td>
							  <td>${lostGoods_info[index]["lost_price"]}</td>
							  <td>${lostGoods_info[index]["lost_remarks"]}</td>
							  <td><i id="modify" class="fa fa-info-circle"></i>&nbsp&nbsp<i id="delete" class="fa fa-trash-o"></i></td></tr>`;
						}
						return tr_str;
					});
					break;
				case 'picture':
					// 照片列表数据显示
					var picture_info = xhr_data["picture"];
					$('#picture-info table tbody').html(function() {
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

/* ============================================================================文件上传下载块 */
// 按钮事件
function upload(button_element) {
	$('#file_upload').trigger('click');
	upLoadFile.element = button_element;
}
// 文件上传
var upLoadFile = function() {
	var file_name = $('#file_upload').val();
	if (file_name != "") {
		var formData = new FormData();
		formData.append("case1.xsjsglxt_case_id", case1_id);
		var file = $("#file_upload")[0].files[0];
		var ele_type = upLoadFile.element;
		switch (ele_type.id) {
		case "evidence_photo": // 物证图
			formData.append("evidenceImage", file);
			formData.append("filePosition", "1");
			break;
		case "record_file": // 笔录文件
			formData.append("writeText", file);
			formData.append("filePosition", "2");
			break;
		case "scene_picture": // 现场图片
			formData.append("senceImage", file);
			formData.append("filePosition", "3");
			break;
		default:
			return;
			break;
		}
		// 进度条出现
		$('.progress-bar').attr('aria-valuenow', '0').text('0%').parents('tr').show();
		$.ajax({
			type : "post",
			async : true, // 这里要设置异步上传，才能成功调用myXhr.upload.addEventListener('progress',function(e){}),progress的回掉函数
			Accept : 'text/html;charset=UTF-8',
			data : formData,
			contentType : "multipart/form-data",
			url : "/xsjsglxt/case/Case_uploadFile",
			processData : false, // 告诉jQuery不要去处理发送的数据
			contentType : false, // 告诉jQuery不要去设置Content-Type请求头
			xhr : function() {
				myXhr = $.ajaxSettings.xhr();
				if (myXhr.upload) { // check if upload property exists
					myXhr.upload.addEventListener('progress', function(e) {
						var loaded = e.loaded; // 已经上传大小情况
						var total = e.total; // 附件总大小
						var percent = Math.floor(100 * loaded / total) + "%"; // 已经上传的百分比
						$('.progress-bar').attr('aria-valuenow', percent).text(percent);
						if (percent == "100%") {
							toastr.info('上传完成');
							setTimeout(function() {
								$('.progress-bar').attr('aria-valuenow', '0').text('0%').parents('tr').hide();
							}, 2000);
							$.post('/xsjsglxt/case/Case_SecneInformationOne', {
								"case1.xsjsglxt_case_id" : case1_id
							}, function(xhr_data) {
								// 保存下载的文件ID
								downloadFile.case_imageFile = xhr_data.case1.case_imageFile;
								downloadFile.case_writeFile = xhr_data.case1.case_writeFile;
								downloadFile.case_senceImageFile = xhr_data.case1.case_senceImageFile;
							}, 'json');
						}
					}, false); // for handling the progress of the upload
				}
				return myXhr;
			},
			success : function(data) {
				console.log("上传成功!!!!");
			},
			error : function() {
				alert("上传失败！");
			}
		});
	}
}
// 文件下载
var downloadFile = function(element) {
	var href_str = '?';
	switch (element.id) {
	case "evidence_photo": // 物证图
		if (downloadFile.case_imageFile == undefined) {
			toastr.info('该案件不包含有物证图,请上传!');
			return;
		}
		href_str += "downloadFileName=" + downloadFile.case_imageFile + "&filePosition=" + 1;
		break;
	case "record_file": // 笔录文件
		if (downloadFile.case_writeFile == undefined) {
			toastr.info('该案件不包含有笔录文件,请上传!');
			return;
		}
		href_str += "downloadFileName=" + downloadFile.case_writeFile + "&filePosition=" + 2;
		break;
	case "scene_picture": // 现场图片
		if (downloadFile.case_senceImageFile == undefined) {
			toastr.info('该案件不包含有现场图片,请上传!');
			return;
		}
		href_str += "downloadFileName=" + downloadFile.case_senceImageFile + "&filePosition=" + 3;
		break;
	default:
		return;
		break;
	}
	window.open("/xsjsglxt/case/Case_download" + href_str);
}


// =========================封装(物证，丢失物，照片)信息更新，当用到，增加，修改，删除时，触发信息更新
function updateSenceInformation(type, jsonData) {
}
/*
 * //修改基站 $('.modify_station').click(function () { if ($('#station input').val() ==
 * "") { toastr.info('请添加完整信息！'); return false; } var station_data = $('#station
 * form').serialize() + '&case1.xsjsglxt_case_id=' + case1_id +
 * '&sence.xsjsglxt_snece_id=' + sence_id;
 * $.post('/xsjsglxt/case/Case_updateSenceInformation', station_data, function
 * (xhr_data) { if (xhr_data == 'success') { toastr.success('修改成功！');
 * window.location.reload(); } else { toastr.error('修改失败！'); } }, 'text'); });
 */

// 流转情况选择框事件
function situation(element) {
	if ($(this).val() == '入库保存') {
		$(this).parent().nextAll().show();
	} else {
		$(this).parent().nextAll().hide();
	}
}

// 6个多选框使用
function sence_checkbox(checkbox) {
	var box = $(checkbox);
	if (box.val() == "1") {
		box.val('0');
	} else {
		box.val('1');
	}
}

// 返回list
function back() {
	location.href = '/xsjsglxt/case/Case_page_SiteManagement';
}

// 是否立案使用
function chose_labe(params) {
	if ($(params).val() == 1) {
		$('input[name="register"][value="1"]').attr("checked", "checked");
	} else {
		$('input[name="register"][value="0"]').attr("checked", "checked");
	}
}
function buildCase_chose(params) {
	if ($(params).val() == 1) {
		$('input[name="case1.case_register"]').val(1);
		// 修改立案时间
		$.post('/xsjsglxt/case/Case_updateCaseTime', {
			"case1.xsjsglxt_case_id" : case1_id
		}, function(msg) {}, 'text');
	} else {
		$('input[name="case1.case_register"]').val(0);
	}
}

// CaseDetail.jsp中的修改案件
function case_change() {
	var url = "/xsjsglxt/case/Case_updateSenceInformation";
	var case1_id = document.getElementById("case1_id").value;
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
	var formData = new FormData();
	formData.append("case1.xsjsglxt_case_id", case1_id);
	// 特殊的序列化
	var info = $('#caseDetails').serializeCaseDetails();
	for (const key in info) {
		formData.append(key, info[key]);
	}
	/*
	 * // 版本二（箭头语法） var convert_FormData_to_json2 = function(formData) { var
	 * objData = {}; formData.forEach((value, key) => objData[key] = value);
	 * return JSON.stringify(objData); };
	 */
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var result = xmlhttp.responseText;
			if (result == "success") {
				toastr.success('修改成功！');
			} else {
				toastr.error('修改失败！');
			}
		}
	};
	xmlhttp.open("post", url, true);
	xmlhttp.send(formData);
}
// ---------------------------------------------------------
