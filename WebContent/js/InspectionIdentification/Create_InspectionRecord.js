/*
 * 记录检验记录
 */
function Create_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
		if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
			break;
		}
	}
	switch (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request) {
	case '死因鉴定': {
		Create_Death_InspectionRecord(obj);
		return;
		break;
	}
	case '损伤鉴定': {
		Create_Damage_InspectionRecord(obj);
		return;
		break;
	}
	default: {
		break;
	}

	}

	var jc = $
			.confirm({
				icon : 'fa fa-pencil-square-o',
				title : '记录检验过程',
				content : '<form id="form_InspectionRecord"><input value="'
						+ obj.id
						+ '"  class="form-control" name="inspectionRecord." id="create_inspection_belong_entrustment_book" style="display:none;"/>'
						+ '<hr>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td>检验人：</td>'
						+ '<td><input  class="form-control" name="inspectionRecord." id="create_inspection_people" /></td>'
						+ '<td>检验开始时间：</td>'
						+ '<td><input  class="form-control mydate" name="inspectionRecord." id="create_inspection_start_time" /></td>'
						+ '<td>检验结束时间：</td>'
						+ '<td><input  class="form-control mydate" name="inspectionRecord." id="create_inspection_stop_time" /></td></tr>'
						+ '<tr><td colspan="2">检验地点：</td>'
						+ '<td colspan="2"><input  class="form-control" name="inspectionRecord." id="create_inspection_location" /></td>'
						+ '<td>检验设备：</td>'
						+ '<td><select class="form-control" name="inspectionRecord." id="create_inspection_equipment">'
						+ '<option value="放大镜">放大镜</option>'
						+ '<option value="比例尺">比例尺</option>'
						+ '<option value="尸体解剖检验箱">尸体解剖检验箱</option>'
						+ '<option value="钢直尺">钢直尺</option>'
						+ '<option value="医用双联观片灯">医用双联观片灯</option>'
						+ '<option value="国际视力表">国际视力表</option>'
						+ '<option value="502熏显柜">502熏显柜</option>'
						+ '<option value="WBY-5比对显微镜">WBY-5比对显微镜</option>'
						+ '<option value="其他">其他</option>'
						+ '</select><input  class="form-control" name="inspectionRecord." id="create_inspection_equipment_qt" style="margin:10px 0 0 0;"/></td></tr>'
						+ '<tr><td>检材情况：</td>'
						+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord." id="create_inspection_check_material_situation"></textarea></td></tr>'
						+ '<tr><td>样本情况：</td>'
						+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord." id="create_inspection_sample_situation"></textarea></td></tr>'
						+ '<tr><td>检验方法：</td>'
						+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord." id="create_inspection_method"></textarea></td></tr>'
						+ '<tr><td>检验过程：</td>'
						+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:200px;" name="inspectionRecord." id="create_inspection_process"></textarea></td></tr>'
						+ '<tr><td>检验意见：</td>'
						+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord." id="create_inspection_option"></textarea></td></tr>'
						+ '<tr><td>备注：</td>'
						+ '<td colspan="5"><textarea class="form-control" style="resize: none;height:100px;" name="inspectionRecord." id="create_inspection_mark"></textarea></td></tr>'
						+ '</tbody>' + '</table></form>' + '<hr>',
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
					switch (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request) {
					case "指纹检验鉴定": {
						//
						document
								.getElementById("create_inspection_check_material_situation").value = '检材是现场XXX提取的指纹一枚';
						//
						document
								.getElementById("create_inspection_sample_situation").value = '样本是犯罪嫌疑人XXX的十指纹一份';
						//
						document.getElementById("create_inspection_method").value = 'IFSC 07-02-01-2006（指纹鉴定法）';
						//
						document.getElementById("create_inspection_process").value = '      现场XXX提取的指纹，用照相法加以固定，类型是XXX纹。指纹纹线较清晰，特征稳定，有鉴定价值。经细致寻找，发现稳定的细节特征XX个，构成同一认定的条件。'
								+ '\n      送检犯罪嫌疑人XXX的十指指纹捺印样本是油墨捺印，用照相法加以固定，指印纹线清晰，特征稳定，可供同一认定。'
								+ '\n      将现场指纹与XXX的捺印十指纹进行逐一比对检验，发现XXX的XX指指纹所出现的XX个细节特征与现场指纹的XX个细节特征相吻合，因而构成了同一认定的依据。';
						//
						document.getElementById("create_inspection_option").value = '现场XXXX提取的指纹是犯罪嫌疑人XXX所留。';
						break;
					}
					case "足迹检验鉴定": {
						//
						document
								.getElementById("create_inspection_check_material_situation").value = '检材是现场提取的鞋印一枚';
						//
						document
								.getElementById("create_inspection_sample_situation").value = '样本是犯罪嫌疑人XXXX穿鞋行走的灰尘鞋印样本左右脚各一枚';
						//
						document.getElementById("create_inspection_method").value = 'IFSC06-01-03-2006（足迹鉴定法）';
						//
						document.getElementById("create_inspection_process").value = '1、对现场鞋印的检验：'
								+ '\n      现场鞋印系遗留在现场XXX灰尘减层鞋印,无明显变形，为X脚所留。通过观察鞋印大小及花纹种类、鞋印边缘虚实部位及长短、边缘磨损块痕清晰，能够客观地反映出鞋印形象特征和特定磨损情况的稳定特征，具有鉴定价值。经检验，现场鞋印全长XX厘米，前掌宽XX厘米，后跟宽XX厘米。鞋印前掌为XX形花纹，后跟为XX纹。进一步检验发现，在现场鞋印前掌及后跟部位发现细节特征XX处。'
								+ '\n2、对样本鞋印的检验：'
								+ '\n      样本为XXX所穿自用鞋行走的灰尘鞋印，拍照提取。鞋底花纹清晰完整，可供比对。初步检验鞋印全长XX厘米，前掌宽XX厘米，后跟宽XX厘米，鞋印前掌为XX形花纹，后跟为XX花纹。进一步检验发现，在现场鞋印前掌及后跟部位发现XX处细节特征。'
								+ '\n3、比对检验：'
								+ '\n      比较检验检材与样本，发现检材鞋印与样本鞋印大小及花纹种类相同，细节特征处反映清晰。在鞋印特征标注处，反映出鞋底具有同样的损伤特征系同一鞋所留。';
						//
						document.getElementById("create_inspection_option").value = '送检的的现场鞋印是XX右脚鞋所留。';
						break;
					}
					case "整体分离检验鉴定": {
						//
						document
								.getElementById("create_inspection_check_material_situation").value = '检材是XXXX';
						//
						document
								.getElementById("create_inspection_sample_situation").value = '样本是XXXX';
						//
						document.getElementById("create_inspection_method").value = 'IFSC 06-05-01-2006（整体分离鉴定法）';
						//
						document.getElementById("create_inspection_process").value = '      比较检验检材与样本发现两者颜色、质地、新旧程度及灰尘附着情形相同。将检材与样本的分离缘进行拼接，分离缘凹凸互补，一一对应，分离线相互吻合'
								+ '\n      检材与样本的颜色、质地和新旧程度相同，分离缘吻合完好，具有排它性，两者原属于同一整体。';
						//
						document.getElementById("create_inspection_option").value = '送检的XXXXX与XXXXX是同一整体。';
						break;
					}
					case "车辆痕迹检验鉴定": {
						//
						document
								.getElementById("create_inspection_check_material_situation").value = '检材是现场提取的鞋印一枚';
						//
						document
								.getElementById("create_inspection_sample_situation").value = '样本是犯罪嫌疑人XXXX穿鞋行走的灰尘鞋印样本左右脚各一枚';
						//
						document.getElementById("create_inspection_method").value = 'IFSC 06-02-02-2006（车体痕迹鉴定法）';
						//
						document.getElementById("create_inspection_process").value = '      （一）XXXXX是一辆XXXXX车，长X、宽X、高X、重X、发动机号X，对XX车的检验发现：'
								+ '\n      （二）XXXXX是一辆XXXXX车，长X、宽X、高X、重X、发动机号X，对XX车的检验发现：';
						//
						document.getElementById("create_inspection_option").value = '送检的的现场鞋印是XX右脚鞋所留。';
						break;
					}
					case "死因鉴定": {
						//
						document
								.getElementById("create_inspection_check_material_situation").value = '检材是现场提取的鞋印一枚';
						//
						document
								.getElementById("create_inspection_sample_situation").value = '样本是犯罪嫌疑人XXXX穿鞋行走的灰尘鞋印样本左右脚各一枚';
						//
						document.getElementById("create_inspection_method").value = 'IFSC06-01-03-2006（足迹鉴定法）';
						//
						document.getElementById("create_inspection_process").value = '1、对现场鞋印的检验：'
								+ '\n      现场鞋印系遗留在现场XXX灰尘减层鞋印,无明显变形，为X脚所留。通过观察鞋印大小及花纹种类、鞋印边缘虚实部位及长短、边缘磨损块痕清晰，能够客观地反映出鞋印形象特征和特定磨损情况的稳定特征，具有鉴定价值。经检验，现场鞋印全长XX厘米，前掌宽XX厘米，后跟宽XX厘米。鞋印前掌为XX形花纹，后跟为XX纹。进一步检验发现，在现场鞋印前掌及后跟部位发现细节特征XX处。'
								+ '\n2、对样本鞋印的检验：'
								+ '\n      样本为XXX所穿自用鞋行走的灰尘鞋印，拍照提取。鞋底花纹清晰完整，可供比对。初步检验鞋印全长XX厘米，前掌宽XX厘米，后跟宽XX厘米，鞋印前掌为XX形花纹，后跟为XX花纹。进一步检验发现，在现场鞋印前掌及后跟部位发现XX处细节特征。'
								+ '\n3、比对检验：'
								+ '\n      比较检验检材与样本，发现检材鞋印与样本鞋印大小及花纹种类相同，细节特征处反映清晰。在鞋印特征标注处，反映出鞋底具有同样的损伤特征系同一鞋所留。';
						//
						document.getElementById("create_inspection_option").value = '送检的的现场鞋印是XX右脚鞋所留。';
						break;
					}
					case "损伤鉴定": {
						//
						document
								.getElementById("create_inspection_check_material_situation").value = '检材是现场提取的鞋印一枚';
						//
						document
								.getElementById("create_inspection_sample_situation").value = '样本是犯罪嫌疑人XXXX穿鞋行走的灰尘鞋印样本左右脚各一枚';
						//
						document.getElementById("create_inspection_method").value = 'IFSC06-01-03-2006（足迹鉴定法）';
						//
						document.getElementById("create_inspection_process").value = '1、对现场鞋印的检验：'
								+ '\n      现场鞋印系遗留在现场XXX灰尘减层鞋印,无明显变形，为X脚所留。通过观察鞋印大小及花纹种类、鞋印边缘虚实部位及长短、边缘磨损块痕清晰，能够客观地反映出鞋印形象特征和特定磨损情况的稳定特征，具有鉴定价值。经检验，现场鞋印全长XX厘米，前掌宽XX厘米，后跟宽XX厘米。鞋印前掌为XX形花纹，后跟为XX纹。进一步检验发现，在现场鞋印前掌及后跟部位发现细节特征XX处。'
								+ '\n2、对样本鞋印的检验：'
								+ '\n      样本为XXX所穿自用鞋行走的灰尘鞋印，拍照提取。鞋底花纹清晰完整，可供比对。初步检验鞋印全长XX厘米，前掌宽XX厘米，后跟宽XX厘米，鞋印前掌为XX形花纹，后跟为XX花纹。进一步检验发现，在现场鞋印前掌及后跟部位发现XX处细节特征。'
								+ '\n3、比对检验：'
								+ '\n      比较检验检材与样本，发现检材鞋印与样本鞋印大小及花纹种类相同，细节特征处反映清晰。在鞋印特征标注处，反映出鞋底具有同样的损伤特征系同一鞋所留。';
						//
						document.getElementById("create_inspection_option").value = '送检的的现场鞋印是XX右脚鞋所留。';
						break;
					}
					default: {
						break;
					}

					}

					/*
					 * 
					 */
					var date = new Date();
					document.getElementById("create_inspection_start_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
					document.getElementById("create_inspection_stop_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
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

				},
				buttons : {
					'记录' : {
						btnClass : 'btn-blue',
						action : function() {
							addInspectionRecord(jc);
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function addInspectionRecord(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("记录成功");
					jc.close();
					List_EntrustmentBook(1);
				} else {
					toastr.error("填写格式错误");
				}
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	/*
	 * 
	 */
	var formData = new FormData(document.getElementById(""));

	/*
	 * 检验设备
	 */
	var create_inspection_equipment = document
			.getElementById("create_inspection_equipment");
	if (create_inspection_equipment.value == "其他") {
		var create_inspection_equipment_qt = document
				.getElementById("create_inspection_equipment_qt");
		formData.append("inspectionRecord.inspection_equipment",
				create_inspection_equipment_qt.value);
	} else {
		formData.append("inspectionRecord.inspection_equipment",
				create_inspection_equipment.value);
	}

	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addInspectionRecord");
	xhr.send(formData);
}
