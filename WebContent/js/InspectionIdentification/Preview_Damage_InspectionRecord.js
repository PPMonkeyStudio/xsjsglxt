function Preview_Damage_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-file-text-o',
				title : '法医学人体损伤检验记录',
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

					var con = '<hr>'
							+ '<div style="text-align: left;">'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td style="width:200px;">姓名：</td><td style="width:150px;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_name
							+ '</td><td style="width:200px;">性别：</td><td style="width:150px;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_sex
							+ '</td><td style="width:150px;">出生日期：</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_birth_date
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>职业：</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_occupation
							+ '</td><td>服务处所：</td><td  colspan="3">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_unit_service
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>身份证号码：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_idcard
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>住址：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_adress
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>受伤时间：</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_damage_time
							+ '</td><td style="width:150px;">检验时间：</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_time
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>联系方式：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_phone
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检验所见：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_inspection
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检查人：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_inspection_man
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>损伤检验图 ：</td><td colspan="5">'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture1
							+ '"  style="width:100%; margin:20px 0;" />'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture2
							+ '"  style="width:100%; margin:20px 0;" />'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture3
							+ '"  style="width:100%; margin:20px 0;" />'
							+ '</td>'
							+ '</tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<hr>' + '</div>';
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