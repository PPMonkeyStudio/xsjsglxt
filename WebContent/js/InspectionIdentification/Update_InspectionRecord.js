function Update_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-ban',
<<<<<<< HEAD
				title : '修改检验记录',
=======
				title : '检验记录（修改）',
>>>>>>> origin/ZB
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
					var con = '<form id="form_InspectionRecord">'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.xsjsglxt_inspection_record_id
							+ '"  class="form-control" name="inspectionRecord.xsjsglxt_inspection_record_id" style="display:none;"/>'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_belong_entrustment_book
							+ '"  class="form-control" name="inspectionRecord.inspection_belong_entrustment_book" style="display:none;"/>'
							+ '<hr>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td>检验人：</td>'
							+ '<td><input  class="form-control" name="inspectionRecord.inspection_people"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_people
							+ '"/></td>'
							+ '<td>检验开始时间：</td>'
							+ '<td><input  class="form-control mydate" name="inspectionRecord.inspection_start_time"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_start_time
							+ '"/></td>'
							+ '<td>检验结束时间：</td>'
							+ '<td><input  class="form-control mydate" name="inspectionRecord.inspection_stop_time"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_stop_time
							+ '"/></td></tr>'
							+ '<tr><td colspan="2">检验地点：</td>'
							+ '<td colspan="2"><input  class="form-control" name="inspectionRecord.inspection_location"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_location
							+ '"/></td>'
							+ '<td>检验设备：</td>'
							+ '<td><select class="form-control"  id="create_inspection_equipment">'
							+ '<option value="放大镜">放大镜</option>'
							+ '<option value="比例尺">比例尺</option>'
							+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
							+ '<option value="钢直尺">钢直尺</option>'
							+ '<option value="医用双联观片灯">医用双联观片灯</option>'
							+ '<option value="国际视力表">国际视力表</option>'
							+ '<option value="502熏显柜">502熏显柜</option>'
							+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
							+ '<option value="其他">其他</option>'
							+ '</select><input  class="form-control"  id="create_inspection_equipment_qt" style="margin:10px 0 0 0;" /></td></tr>'
							+ '<tr><td>检材情况：</td>'
							+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord.inspection_check_material_situation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_check_material_situation
							+ '</textarea></td></tr>'
							+ '<tr><td>样本情况：</td>'
							+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord.inspection_sample_situation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_sample_situation
							+ '</textarea></td></tr>'
							+ '<tr><td>检验方法：</td>'
							+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord.inspection_method" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_method
							+ '</textarea></td></tr>'
							+ '<tr><td>检验过程：</td>'
							+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:200px;" name="inspectionRecord.inspection_process" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_process
							+ '</textarea></td></tr>'
							+ '<tr><td>检验意见：</td>'
							+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord.inspection_option" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_option
							+ '</textarea></td></tr>'
							+ '<tr><td>备注：</td>'
							+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord.inspection_mark" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_mark
							+ '</textarea></td></tr>'
							+ '</tbody>'
							+ '</table></form>' + '<hr>';
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
					/*
					 * 
					 */
					var create_inspection_equipment = document
							.getElementById("create_inspection_equipment");
					switch (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_equipment) {
					case '放大镜': {
						create_inspection_equipment.innerHTML = '<option value="放大镜" selected="selected">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					case '比例尺': {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺" selected="selected">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					case '尸体解剖检验箱': {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱" selected="selected">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					case '钢直尺': {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺" selected="selected">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					case '医用双联观片灯': {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯" selected="selected">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					case '国际视力表': {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表" selected="selected">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					case '502熏显柜': {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜" selected="selected">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					case 'WBY-5比对显微镜': {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜" selected="selected">WBY-5比对显微镜</option>'
								+ '<option value="其他">其他</option>';
						break;
					}
					default: {
						create_inspection_equipment.innerHTML = '<option value="放大镜">放大镜</option>'
								+ '<option value="比例尺">比例尺</option>'
								+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
								+ '<option value="钢直尺">钢直尺</option>'
								+ '<option value="医用双联观片灯">医用双联观片灯</option>'
								+ '<option value="国际视力表">国际视力表</option>'
								+ '<option value="502熏显柜">502熏显柜</option>'
								+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
								+ '<option value="其他" selected="selected">其他</option>';
						document
								.getElementById("create_inspection_equipment_qt").value = json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_equipment;
						break;
					}
					}
				},
				buttons : {
					'确认修改' : {
						btnClass : 'btn-red',
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
											Preview_InspectionRecord(obj);
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
							var formData = new FormData(document
									.getElementById("form_InspectionRecord"));
							/*
							 * 
							 */
							if (document
									.getElementById("create_inspection_equipment").value == '其他') {
								formData
										.append(
												"inspectionRecord.inspection_equipment",
												document
														.getElementById("create_inspection_equipment_qt").value);
							} else {
								formData
										.append(
												"inspectionRecord.inspection_equipment",
												document
														.getElementById("create_inspection_equipment").value);
							}
							/*
							 * 
							 */
							xhr
									.open(
											"POST",
											"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateInspectionRecord");
							xhr.send(formData);
							return false;
						}
					},
					'返回' : function() {
						Preview_InspectionRecord(obj);
					}
				}
			});
}
