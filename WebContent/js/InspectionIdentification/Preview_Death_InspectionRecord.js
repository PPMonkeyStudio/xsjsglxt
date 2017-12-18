function Preview_Death_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
		if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
			break;
		}
	}

	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-file-text-o',
				title : '法医学尸体检验记录',
				content : '',
				type : 'green',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {

					var con = '<hr>' + '<div style="text-align: left;">'
							+ '<h4 style="text-align: center;">尸体检验记录</h4>'
							+ '<p>委托单位：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit
							+ '</p>'
							+ '<p>承办人员：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_undertake_personnel
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_phone
							+ '</p>'
							+ '<p>委托时间：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time
									.substring(8, 10)
							+ '日'
							+ '</p>'
							+ '<p>死者姓名：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_name
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_sex
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出生日期：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_birth_date
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_birth_date
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_birth_date
									.substring(8, 10)
							+ '日'
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民族（或国籍）：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_private_capital
							+ '</p>'
							+ '<p>服务处所：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_unit_service
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住址：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_address
							+ '</p>'
							+ '<p>检验人：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspector
							+ '</p>'
							+ '<p>检验时间：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(8, 10)
							+ '日'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(11, 13)
							+ '时'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(14, 16)
							+ '分'
							+ '&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(8, 10)
							+ '日'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(11, 13)
							+ '时'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
									.substring(14, 16)
							+ '分'
							+ '</p>'
							+ '<p>检验地点：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_place
							+ '</p>'
							+ '<p>检验环境温度：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_ambient_temperature
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检验环境湿度：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_ambient_humidity
							+ '</p>'
							+ '<p>案情摘要：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation
							+ '</p>'
							+ '<p>现场尸体与血迹概况（尸体所处地点、位置、姿势及与周围环境相互关系等）：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_site_profile
							+ '</p>'
							+ '<p>尸体衣着、饰物、随身物品性状与数量及其它物品：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_clothing
							+ '</p>'
							+ '<p>随身物品移交情况：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_handover_of_goods
							+ '</p>'
							+ '<p>接收物品人员：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_receiver_goods
							+ '</p>'
							+ '<p>备注：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_mark
							+ '</p>'
							+ '<h4 style="text-align: center;">尸表检验</h4>'
							+ '<p>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</p>'
							+ '<p>尸表检验记录人：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test_recorder
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尸表检验记录时间：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test_recorder_time
							+ '</p>'
							+ '<h4 style="text-align: center;">解剖检验</h4>'
							+ '<p>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_test
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</p>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td style="width:200px;">尸表检验图：</td>'
							+ '<td>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture1
							+ '" onclick="()" style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture2
							+ '" onclick="()" style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture3
							+ '" onclick="()" style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>解剖检验图：</td>'
							+ '<td>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture1
							+ '"  style="width:300px; margin:20px auto;" />'
							+ '</p>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture2
							+ '"  style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture3
							+ '"  style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '</td>'
							+ '</tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<p>解剖时间：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time
									.substring(8, 10)
							+ '日'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time
									.substring(11, 13)
							+ '时'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time
									.substring(14, 16)
							+ '分'
							+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;解剖地点：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_place
							+ '</p>'
							+ '<p>尸体检验拍照人：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_photographer
							+ '</p>'
							+ '<p>尸体检验录像人：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_video
							+ '</p>'
							+ '<p>尸体检验记录人：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder
							+ '</p>'
							+ '<p>尸体检验记录时间：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder_time
									.substring(8, 11)
							+ '日'
							+ '</p>'
							+ '</div>'
							+ '<br>'
							+ '<h4>'
							+ '检材提取及处置'
							+ '</h4>'
							+ '<table class="table table-bordered" style="text-align: center;" id="table_entrustment_sample">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td>编号</td>'
							+ '<td>检材名称</td>'
							+ '<td>提取部位</td>'
							+ '<td>提取方法</td>'
							+ '<td>数量</td>'
							+ '<td>包装</td>'
							+ '<td>用途</td>'
							+ '<td style="width: 100px;">'
							+ '<label class="fancy-checkbox"><input id="checkbox_all_selectEntrustmentSample" type="checkbox" onclick="class_select(\'checkbox_all_selectEntrustmentSample\',\'checkbox_selectEntrustmentSample\')"> <span>全选</span></label>'
							+ '</td>'
							+ '</tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<div style="height: 34px; margin: 0 0 20px 0;">'
							+ '<button id="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
							+ '" class="btn btn-danger" onclick="deleteEntrustmentSample(this)" style="float: right; margin: 0 10px;">'
							+ '<i class="fa fa-trash-o"></i> 删除检材'
							+ '</button>' + '</div>';
					jc.setContentAppend(con);
					/*
					 * 
					 */
					list_entrustment_sample(obj);
					/*
					 * 
					 */
				},
				buttons : {
					'导出' : {
						btnClass : 'btn-green',
						action : function() {
							return false;
						}
					},
					'修改' : {
						btnClass : 'btn-orange',
						action : function() {
							jc.close();
							Update_Death_InspectionRecord(obj);
							return false;
						}
					},
					'添加检材记录' : {
						btnClass : 'btn-green',
						action : function() {

							var jc2 = $
									.confirm({
										title : '添加检材记录',
										content : '<form id="form_entrustment_sample">'
												+ '<input value="'
												+ obj.id
												+ '"  class="form-control" name="entrustment_sample.entrustment_sample_belong_entrustment_book" style="display:none;"/>'
												+ '<hr>'
												+ '<table  class="table table-bordered" style="text-align: center;">'
												+ '<tbody>'
												+ '<tr><td>检材名称：</td>'
												+ '<td><input  class="form-control" name="entrustment_sample.entrustment_sample_name"  /></td></tr>'
												+ '<tr><td>提取部位：</td>'
												+ '<td><input  class="form-control" name="entrustment_sample.entrustment_sample_position"  /></td></tr>'
												+ '<tr><td>提取方法：</td>'
												+ '<td><input  class="form-control" name="entrustment_sample.entrustment_sample_way"  /></td></tr>'
												+ '<tr><td>数量：</td>'
												+ '<td><input  class="form-control" name="entrustment_sample.entrustment_sample_amount"  /></td></tr>'
												+ '<tr><td>包装：</td>'
												+ '<td><input  class="form-control" name="entrustment_sample.entrustment_sample_packaging"  /></td></tr>'
												+ '<tr><td>用途：</td>'
												+ '<td><input  class="form-control" name="entrustment_sample.entrustment_sample_use"  /></td></tr>'
												+ '</tbody>'
												+ '</table>'
												+ '</form>',
										columnClass : 'col-md-8 col-md-offset-2',
										onOpenBefore : function() {
										},
										onContentReady : function() {
										},
										buttons : {
											'确认' : {
												btnClass : 'btn-green',
												action : function() {

													var xhr = false;
													xhr = new XMLHttpRequest();
													xhr.onreadystatechange = function() {
														var message;
														if (xhr.readyState == 4) {
															if (xhr.status == 200) {
																if (xhr.responseText == 1) {
																	toastr
																			.success("操作成功");
																	List_EntrustmentBook(EntrustmentBook_json.pageIndex);
																	list_entrustment_sample(obj);
																} else {

																}
															} else {
																toastr
																		.error(xhr.status);
															}
														}
													}
													var formData = new FormData(
															document
																	.getElementById("form_entrustment_sample"));
													xhr
															.open("POST",
																	"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addEntrustmentSample");
													xhr.send(formData);
													/*
													 * 
													 */
												}
											},
											'放弃' : function() {
											}
										}
									});
							return false;
						}
					},
					'返回' : function() {
					}
				}
			});

}

function list_entrustment_sample(obj) {
	var json_list = EntrustmentBook_json;
	for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
		if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
			break;
		}
	}
	/*
	 * 
	 * 清空原表数据
	 * 
	 */
	var new_tr_list = document
			.getElementsByClassName("new_tr_entrustment_sample");
	var long = new_tr_list.length;
	for (var i = 0; i < long; i++) {
		new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
	}

	var table_entrustment_sample = document
			.getElementById("table_entrustment_sample");
	var new_tr = null;
	var new_td = null;
	if (json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample != null) {
		for (var num2 = 0; num2 < json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample.length; num2++) {
			new_tr = document.createElement("tr");
			table_entrustment_sample.firstElementChild.appendChild(new_tr);
			new_tr.className = "new_tr_entrustment_sample";
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].entrustment_sample_num;
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].entrustment_sample_name;
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].entrustment_sample_position;
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].entrustment_sample_way;
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].entrustment_sample_amount;
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].entrustment_sample_packaging;
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].entrustment_sample_use;
			/*
			 * 
			 */
			new_td = document.createElement("td");
			new_tr.appendChild(new_td);
			new_td.innerHTML = '<label class="fancy-checkbox">'
					+ '<input id="'
					+ json_list.listEntrustmentBookManagementDTO[num].listEntrustmentSample[num2].xsjsglxt_entrustment_sample_id
					+ '" type="checkbox" class="checkbox_selectEntrustmentSample">'
					+ '<span></span></label>';

		}
		document.getElementById("checkbox_all_selectEntrustmentSample").checked = false;
	}

}

function deleteEntrustmentSample(obj) {
	var js = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-exclamation-triangle',
				title : '警告！删除检材记录',
				content : '此操作将删除所选的所有检材记录数据',
				type : 'red',
				autoClose : '取消|5000',// 自动关闭
				buttons : {
					删除 : {
						btnClass : 'btn-red',
						action : function() {
							var xhr = false;
							xhr = new XMLHttpRequest();
							xhr.onreadystatechange = function() {
								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										if (xhr.responseText == "1") {
											toastr.success("删除成功");
											List_EntrustmentBook(EntrustmentBook_json.pageIndex);
											list_entrustment_sample(obj);
										}
									} else {
										toastr.error(xhr.status);
									}
								}
							}
							var checkbox_select = document
									.getElementsByClassName("checkbox_selectEntrustmentSample");
							var ListDeleteStudentNum = null;
							var formData = new FormData();
							for (var num = 0; num < checkbox_select.length; num++) {
								if (checkbox_select[num].checked) {
									formData.append("listEntrustmentSample",
											checkbox_select[num].id);
								}
							}
							xhr
									.open(
											"POST",
											"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_deleteEntrustmentSample");
							xhr.send(formData);
						}
					},
					取消 : function() {
					}
				}
			});
}