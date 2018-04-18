function Preview_Damage_InspectionRecord(obj) {
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
				title : '法医学人体损伤检验记录',
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
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检查人：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_inspection_man
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td style="width:200px;">尸表检验图：</td>'
							+ '<td colspan="5">'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDamagePicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture1
							+ '" onclick="()" style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDamagePicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture2
							+ '" onclick="()" style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '<p>'
							+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDamagePicture?imgName='
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id
							+ '_'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.damage_inspection_record_picture3
							+ '" onclick="()" style="width:300px; margin:20px auto;"  />'
							+ '</p>'
							+ '</td>'
							+ '</tr>'
							+ '</tbody>'
							+ '</table>' + '<hr>' + '</div>';
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
							window.location = '/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_exportDamageInspectionRecord?damageInspectionRecord.xsjsglxt_damage_inspection_record_id='
									+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_damage_inspection_record.xsjsglxt_damage_inspection_record_id;
							return false;
						}
					},
					'修改' : {
						btnClass : 'btn-orange user_check_power',
						action : function() {
							Update_Damage_InspectionRecord(obj);
						}
					},
					'返回' : function() {
					}
				}
			});
}