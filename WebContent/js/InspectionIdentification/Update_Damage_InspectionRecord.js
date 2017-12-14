function Update_Damage_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-ban',
				title : '修改损伤检验记录',
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
					var con = '<form id="form_Damage_InspectionRecord">' + '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id
							+ '"  class="form-control" name="damageInspectionRecord.xsjsglxt_damage_inspection_record_id"  style="display:none;"/>'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_belong_entrustment_book
							+ '"  class="form-control" name="damageInspectionRecord.damage_inspection_record_belong_entrustment_book"  style="display:none;"/>'
							+ '<hr>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td>姓名：</td>'
							+ '<td><input  class="form-control"  name="damageInspectionRecord.damage_inspection_record_name" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_name
							+ '"/></td>'
							+ '<td>性别：</td>'
							+ '<td><select class="form-control" name="damageInspectionRecord.damage_inspection_record_sex">'
							+ (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_sex == '男' ? '<option value="男" selected="selected">男</option><option value="女">女</option>'
									: '<option value="男">男</option><option value="女" selected="selected">女</option>')
							+ '</select></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>出生日期：</td>'
							+ '<td><input  class="form-control mydate" name="damageInspectionRecord.damage_inspection_record_birth_date"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_birth_date
							+ '"//></td>'
							+ '<td>职业：</td>'
							+ '<td><input  class="form-control" name="damageInspectionRecord.damage_inspection_record_occupation" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_occupation
							+ '"//></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>服务处所：</td>'
							+ '<td><input  class="form-control" name="damageInspectionRecord.damage_inspection_record_unit_service" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_unit_service
							+ '"/></td>'
							+ '<td>身份证号码：</td>'
							+ '<td><input  class="form-control" name="damageInspectionRecord.damage_inspection_record_idcard" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_idcard
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>受伤时间：</td>'
							+ '<td><input  class="form-control mydate" name="damageInspectionRecord.damage_inspection_record_damage_time" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_damage_time
							+ '"/></td>'
							+ '<td>检验时间：</td>'
							+ '<td><input  class="form-control mydate" name="damageInspectionRecord.damage_inspection_record_time" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_time
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>住址：</td>'
							+ '<td><input  class="form-control" name="damageInspectionRecord.damage_inspection_record_adress" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_adress
							+ '"/></td>'
							+ '<td>联系方式：</td>'
							+ '<td><input  class="form-control" name="damageInspectionRecord.damage_inspection_record_phone" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_phone
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检验所见：</td>'
							+ '<td colspan="3"><textarea class="form-control" style="resize: none;height:100px;" name="damageInspectionRecord.damage_inspection_record_inspection" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_inspection + '</textarea></td>' + '</tr>'
							+ '<tr>' + '<td>检查人：</td>' + '<td ><input class="form-control"  name="damageInspectionRecord.damage_inspection_record_inspection_man" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_inspection_man + '"//></td>' + '</tr>'
							+ '<tr>' + '<td>损伤检验图：</td>' + '<td>'
							+ '<p><img style="width:150px;margin:10px auto;"  src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id + '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture1 + '" onclick="()"  /></p>'
							+ '<p><img style="width:150px;margin:10px auto;" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id + '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture2 + '" onclick="()" /></p>'
							+ '<p><img style="width:150px;margin:10px auto;" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id + '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture3 + '" onclick="()"  /></p>'
							+ '<input type="file"   id="create_damage_inspection_record_picture1"   />' + '<input type="file"   id="create_damage_inspection_record_picture2"   />'
							+ '<input type="file"   id="create_damage_inspection_record_picture3"   />' + '</td>' + '</tr>' + '</tbody>' + '</table></form>' + '<hr>';
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
							var formData = new FormData(document.getElementById("form_Damage_InspectionRecord"));
							/*
							 * 图片
							 */
							var create_damage_inspection_record_picture1 = document.getElementById("create_damage_inspection_record_picture1");
							var create_damage_inspection_record_picture2 = document.getElementById("create_damage_inspection_record_picture2");
							var create_damage_inspection_record_picture3 = document.getElementById("create_damage_inspection_record_picture3");

							/*
							 * 
							 */
							if (create_damage_inspection_record_picture1.files[0] == null && create_damage_inspection_record_picture2.files[0] == null
									&& create_damage_inspection_record_picture3.files[0] == null) {
								formData.append("positionFile", "2");
								formData.append("positionFile", "2");
								formData.append("positionFile", "2");
							} else {
								if (create_damage_inspection_record_picture1.files[0] != null) {
									formData.append("death", create_damage_inspection_record_picture1.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
								//
								if (create_damage_inspection_record_picture2.files[0] != null) {
									formData.append("death", create_damage_inspection_record_picture2.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
								//
								if (create_damage_inspection_record_picture3.files[0] != null) {
									formData.append("death", create_damage_inspection_record_picture3.files[0]);
									formData.append("positionFile", "1");
								} else {
									formData.append("death", null);
									formData.append("positionFile", "2");
								}
							}
							xhr.open("POST", "/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateDamageInspectionRecord");
							xhr.send(formData);
							return false;
						}
					},
					'返回' : function() {
						Preview_Damage_InspectionRecord(obj);
					}
				}
			});
}