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
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}
					var con = '<div style="margin:0 20px 0 0;"><hr>'
							+ '<br>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>' + '<tr><td>案（事）件简要情况</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation
							+ '</tr>'
							+ '<tr><td>检材情况</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_check_material_situation
							+ '</tr>'
							+ '<tr><td>样本情况</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_sample_situation
							+ '</tr>'
							+ '<tr><td>鉴定要求</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request
							+ '</tr>'
							+ '<tr><td>检验设备</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_equipment
							+ '</tr>'
							+ '<tr><td>检验方法</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_method
							+ '</tr>'
							+ '<tr><td>检验时间</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_time
							+ '</tr>'
							+ '<tr><td>检验地点</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_location
							+ '</tr>'
							+ '<tr><td>检验人</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_people
							+ '</tr>'
							+ '<tr><td>检验过程</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_process
							+ '</tr>'
							+ '<tr><td>检验意见</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_option
							+ '</tr>'
							+ '<tr><td>备注</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_mark
							+ '</tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<br>'
							+ '<hr></div>';
					jc.setContentAppend(con);
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
							return false;
						}
					},
					'返回' : function() {
					}
				}
			});
}