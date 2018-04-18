function Preview_InspectionRecord(obj) {

	var json_list = EntrustmentBook_json;
	for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
		if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
			break;
		}
	}
	switch (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request) {
	case '死因鉴定': {
		Preview_Death_InspectionRecord(obj);
		return;
		break;
	}
	case '损伤鉴定': {
		Preview_Damage_InspectionRecord(obj);
		return;
		break;
	}
	default: {
		break;
	}
	}

	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-file-text-o',
				title : '检验记录',
				content : '',
				type : 'green',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
					/*
					 * 删除按钮
					 */
					if (userPowerDTO.user_check_power_modified == true) {

					} else {
						var userCheckPowers = document
								.getElementsByClassName("user_check_power");
						var userCheckPowers_Length = userCheckPowers.length;
						for (var userCheckPowersNum = 0; userCheckPowersNum < userCheckPowers_Length; userCheckPowersNum++) {
							userCheckPowers[0].parentNode
									.removeChild(userCheckPowers[0]);
						}
					}
					/*
					 * 
					 */
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}
					var con = '<div style="margin:0 20px 0 0;"><hr>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td style="width:200px;">案（事）件简要情况</td><td  style="text-align: left !important;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td >检材情况</td><td style="text-align: left !important;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_check_material_situation
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>样本情况</td><td style="text-align: left !important;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_sample_situation
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>鉴定要求</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>检验设备</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_equipment
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>检验方法</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_method
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>检验时间</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_start_time
							+ ' 至 '
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_stop_time
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>检验地点</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_location
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>检验人</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_people
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>检验过程</td><td style="text-align: left !important;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_process
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</td>'

							+ '</tr>'
							+ '<tr><td>检验意见</td><td style="text-align: left !important;>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_option
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</td>'
							+ '</tr>'
							+ '<tr><td>备注</td><td style="text-align: left !important;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_mark
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</td>'
							+ '</tr>'
							+ '</tbody>' + '</table>' + '<hr></div>';
					jc.setContentAppend(con);
					/*
					 * 
					 */
					/*
					 * 
					 */
				},
				buttons : {
					'导出' : {
						btnClass : 'btn-green',
						action : function() {
							window.location = '/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_exportInspectionRecord?inspectionRecord.xsjsglxt_inspection_record_id='
									+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.xsjsglxt_inspection_record_id;
							return false;
						}
					},
					'修改' : {
						btnClass : 'btn-orange managerPower user_check_power',
						action : function() {
							jc.close();
							Update_InspectionRecord(obj);
						}
					},
					'返回' : function() {
					}
				}
			});
}