function Update_Death_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-ban',
				title : '尸体检验记录',
				content : '',
				type : 'blue',
				columnClass : 'col-md-12',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}
					var con = '<form id="form_Death_InspectionRecord" >'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '"  class="form-control" name="deathInspectionRecord.xsjsglxt_death_inspection_record_id"  style="display:none;"/>'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_belong_entrustment_book
							+ '"  class="form-control" name="deathInspectionRecord.death_inspection_record_belong_entrustment_book"  style="display:none;"/>'
							+ '<hr>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td style="width:150px;">承办人员：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_undertake_personnel"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_undertake_personnel
							+ '"/></td>'
							+ '<td style="width:150px;">联系电话：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_phone"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_phone
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>死者姓名：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_death_name"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_name
							+ '"/></td>'
							+ '<td>性别：</td>'
							+ '<td><select class="form-control" name="deathInspectionRecord.death_inspection_record_death_sex" >'
							+ (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_sex == '男' ? '<option value="男" selected="selected">男</option><option value="女">女</option>'
									: '<option value="男">男</option><option value="女" selected="selected">女</option>')
							+ '</select></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>出生日期：</td>'
							+ '<td><input  class="form-control mydate" name="deathInspectionRecord.death_inspection_record_death_birth_date" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_birth_date
							+ '" /></td>'
							+ '<td>民族：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_private_capital" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_private_capital
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>服务处所：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_unit_service"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_unit_service
							+ '"/></td>'
							+ '<td>住址：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_address" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_address
							+ '" /></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检验人：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_inspector"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspector
							+ '"/></td>'
							+ '<td>检验地点：</td>'
							+ '<td><input  class="form-control " name="deathInspectionRecord.death_inspection_record_inspect_place"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_place
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检验开始时间：</td>'
							+ '<td ><input  class="form-control mydate_minute" name="deathInspectionRecord.death_inspection_record_inspect_time"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time
							+ '" /></td>'
							+ '<td>检验结束时间：</td>'
							+ '<td ><input  class="form-control mydate_minute" name="deathInspectionRecord.death_inspection_record_inspect_stop_time"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_stop_time
							+ '" /></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检验环境温度：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_inspect_ambient_temperature"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_ambient_temperature
							+ '" /></td>'
							+ '<td>检验环境湿度：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_ambient_humidity"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_ambient_humidity
							+ '" /></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>现场尸体与血迹概况（尸体所处地点、位置、姿势及与周围环境相互关系等）：</td>'
							+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control" name="deathInspectionRecord.death_inspection_record_site_profile"    >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_site_profile
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>尸体衣着、饰物、随身物品性状与数量及其它物品：</td>'
							+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control" name="deathInspectionRecord.death_inspection_record_death_clothing"    >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_clothing
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>随身物品移交情况：</td>'
							+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control"  name="deathInspectionRecord.death_inspection_record_handover_of_goods"   >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_handover_of_goods
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>接收物品人员：</td>'
							+ '<td colspan="3"><input  class="form-control" name="deathInspectionRecord.death_inspection_record_receiver_goods"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_receiver_goods
							+ '" /></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>备注：</td>'
							+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control" name="deathInspectionRecord.death_inspection_record_mark"    >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_mark
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>尸表检验：</td>'
							+ '<td colspan="3"><textarea style="resize: none;height:500px;" class="form-control" name="deathInspectionRecord.death_inspection_record_autopsy_surface_table_test"    >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>尸表记录人：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_autopsy_surface_table_test_recorder"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test_recorder
							+ '"/></td>'
							+ '<td>尸表记录时间：</td>'
							+ '<td><input  class="form-control mydate" name="deathInspectionRecord.death_inspection_record_autopsy_surface_table_test_recorder_time"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test_recorder_time
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>解剖检验：</td>'
							+ '<td colspan="3"><textarea style="resize: none;height:500px;" class="form-control" name="deathInspectionRecord.death_inspection_record_anatomic_test"    >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_test
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>解剖时间：</td>'
							+ '<td><input  class="form-control mydate_minute" name="deathInspectionRecord.death_inspection_record_anatomic_time"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time
							+ '" /></td>'
							+ '<td>解剖地点：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_anatomic_place"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_place
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>尸体检验拍照人：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_autopsy_table_test_photographer"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_photographer
							+ '"/></td>'
							+ '<td>尸体检验录像人：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_autopsy_table_test_video"   value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_video
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>尸体检验记录人：</td>'
							+ '<td><input  class="form-control" name="deathInspectionRecord.death_inspection_record_autopsy_table_test_recorder"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder
							+ '" /></td>'
							+ '<td>尸体检验记录时间：</td>'
							+ '<td><input  class="form-control mydate" name="deathInspectionRecord.death_inspection_record_autopsy_table_test_recorder_time"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder_time
							+ '" /></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>尸表检验图：</td>'
							+ '<td>'
							+ '<p><img style="width:150px;margin:10px auto;border:4px dashed  #EAEAEE;"  src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture1
							+ '" onclick="()"  /></p>'
							+ '<p><img style="width:150px;margin:10px auto;border:4px dashed  #EAEAEE;" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture2
							+ '" onclick="()" /></p>'
							+ '<p><img style="width:150px;margin:10px auto;border:4px dashed  #EAEAEE;" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture3
							+ '" onclick="()"  /></p>'
							+ '<input type="file" id="create_death_inspection_record_autopsy_table_test_picture1" />'
							+ '<input type="file" id="create_death_inspection_record_autopsy_table_test_picture2" />'
							+ '<input type="file" id="create_death_inspection_record_autopsy_table_test_picture3"  />'
							+ '</td>'
							// + '</tr>'
							// + '<tr>'
							+ '<td>解剖检验图：</td>'
							+ '<td>'
							+ '<p><img style="width:150px;margin:10px auto;border:4px dashed  #EAEAEE;"  src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture1
							+ '" onclick="()"  /></p>'
							+ '<p><img style="width:150px;margin:10px auto;border:4px dashed  #EAEAEE;" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture2
							+ '" onclick="()" /></p>'
							+ '<p><img style="width:150px;margin:10px auto;border:4px dashed  #EAEAEE;" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture3
							+ '" onclick="()"  /></p>'
							+ '<input type="file" id="create_death_inspection_record_anatomy_picture1" value=""/>'
							+ '<input type="file" id="create_death_inspection_record_anatomy_picture2" value=""/>'
							+ '<input type="file" id="create_death_inspection_record_anatomy_picture3" value=""/>'
							+ '</td>'
							+ '</tr>'
							+ '</tbody>'
							+ '</table>'
							+ '</form>' + '<hr>';
					jc.setContentAppend(con);
					/*
					 * 
					 */
					$.datetimepicker.setLocale('ch');
					$('.mydate').datetimepicker({
						yearStart : 1990, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : false, // 关闭时间选项
						format : 'Y-m-d', // 格式化日期年-月-日
						minDate : '1990/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});
					$('.mydate_minute').datetimepicker({
						yearStart : 1990, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : true, // 关闭时间选项
						format : 'Y-m-d H:i', // 格式化日期年-月-日
						minDate : '1990/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});
					/*
					 * 
					 */
				},
				buttons : {
					'确认修改' : {
						btnClass : 'btn-blue',
						action : function() {
							jc.showLoading(false);
							var xhr = false;
							xhr = new XMLHttpRequest();
							xhr.onreadystatechange = function() {
								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										console.debug(xhr.responseText);
										if (xhr.responseText == 1) {
											toastr.success("修改成功");
											jc.close();
											List_EntrustmentBook(EntrustmentBook_json.pageIndex);
											Preview_Death_InspectionRecord(obj);
										} else {
											toastr.error("填写格式错误");
											jc.hideLoading(true);
										}
									} else {
										toastr.error(xhr.status);
										jc.hideLoading(true);
									}
								}
							}
							/*
							 * 
							 */
							var formData = new FormData(
									document
											.getElementById("form_Death_InspectionRecord"));
							/*
							 * 图片
							 */
							var create_death_inspection_record_autopsy_table_test_picture1 = document
									.getElementById("create_death_inspection_record_autopsy_table_test_picture1");
							var create_death_inspection_record_autopsy_table_test_picture2 = document
									.getElementById("create_death_inspection_record_autopsy_table_test_picture2");
							var create_death_inspection_record_autopsy_table_test_picture3 = document
									.getElementById("create_death_inspection_record_autopsy_table_test_picture3");
							var create_death_inspection_record_anatomy_picture1 = document
									.getElementById("create_death_inspection_record_anatomy_picture1");
							var create_death_inspection_record_anatomy_picture2 = document
									.getElementById("create_death_inspection_record_anatomy_picture2");
							var create_death_inspection_record_anatomy_picture3 = document
									.getElementById("create_death_inspection_record_anatomy_picture3");
							/*
							 * 
							 */

							/*
							 * 
							 */
							if (create_death_inspection_record_autopsy_table_test_picture1.files[0] == null
									&& create_death_inspection_record_autopsy_table_test_picture2.files[0] == null
									&& create_death_inspection_record_autopsy_table_test_picture3.files[0] == null
									&& create_death_inspection_record_anatomy_picture1.files[0] == null
									&& create_death_inspection_record_anatomy_picture2.files[0] == null
									&& create_death_inspection_record_anatomy_picture3.files[0] == null) {
								formData.append("positionFile", "2");
								formData.append("positionFile", "2");
								formData.append("positionFile", "2");
								formData.append("positionFile", "2");
								formData.append("positionFile", "2");
								formData.append("positionFile", "2");
							} else {
								if (create_death_inspection_record_autopsy_table_test_picture1.files[0] != null) {
									formData
											.append(
													"death",
													create_death_inspection_record_autopsy_table_test_picture1.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
								//
								if (create_death_inspection_record_autopsy_table_test_picture2.files[0] != null) {
									formData
											.append(
													"death",
													create_death_inspection_record_autopsy_table_test_picture2.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
								//
								if (create_death_inspection_record_autopsy_table_test_picture3.files[0] != null) {
									formData
											.append(
													"death",
													create_death_inspection_record_autopsy_table_test_picture3.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}

								/*
								 * 
								 */
								if (create_death_inspection_record_anatomy_picture1.files[0] != null) {
									formData
											.append(
													"death",
													create_death_inspection_record_anatomy_picture1.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
								//
								if (create_death_inspection_record_anatomy_picture2.files[0] != null) {
									formData
											.append(
													"death",
													create_death_inspection_record_anatomy_picture2.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
								//
								if (create_death_inspection_record_anatomy_picture3.files[0] != null) {
									formData
											.append(
													"death",
													create_death_inspection_record_anatomy_picture3.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
							}
							xhr
									.open(
											"POST",
											"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateDeathInspectionRecord");
							xhr.send(formData);
							return false;
						}
					},
					'返回' : function() {
						Preview_Death_InspectionRecord(obj);
					}
				}
			});
}