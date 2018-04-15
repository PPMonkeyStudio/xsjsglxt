function Preview_NotAcceptanceEntrustmentInform(obj) {
	var json_list = EntrustmentBook_json;
	for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
		if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
			break;
		}
	}
	var jc = $
			.confirm({
				title : '',
				content : '',
				type : 'red',
				columnClass : 'col-md-8 col-md-offset-2',
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
					var con = '<div style="margin:0 20px 0 0;">'
							+ '<hr>'
							+ '<h3  style="text-align: center;">不受理委托鉴定告知书（存根）</h3>'
							+ '<h4  style="text-align: right;">['
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(0, 4)
							+ ']第'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(4)
							+ '号</h4>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td style="width:100px;">委托单位：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>送检人：</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_name
							+ '、'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_name
							+ '</td>'
							+ '<td  style="width:100px;">证件名称及号码：</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_jobcard_number
							+ '、'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_jobcard_number
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>案（事）件名称：</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_name
							+ '</td>'
							+ '<td>案件编号：</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_num
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>不予受理理由：</td><td colspan="5">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_reason
							+ '故不予受理</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>填表人：</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_inputhuman_name
							+ '</td>'
							+ '<td style="width:100px;">批准人：</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approvalhuman_name
							+ '</td>'
							+ '<td style="width:100px;">批准时间：</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(8, 10)
							+ '日'
							+ '</td>'
							+ '</tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<h4  style="text-align: center;">---------------------------------------骑缝章---------------------------------------</h4>'
							+ '<h3  style="text-align: center;">萍乡市安源区公安司法鉴定中心<br>不受理委托鉴定告知书</h3>'
							+ '<h4  style="text-align: right;">['
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(0, 4)
							+ ']第'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(4)
							+ '号</h4>'
							+ '<h4 style="text-align: left;text-indent:2em;">'
							+ '<p>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_reason
							+ '现决定对你单位有关<b>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_name
							+ '</b>的鉴定委托不予受理。</p><p>特此告知。</p>'
							+ '</h4>'
							+ '<h4 style="text-align: right;">（鉴定单位公章）<br>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(8, 11) + '日</h4>' + '<hr></div>';
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
						btnClass : 'btn-red',
						action : function() {
							window.location = '/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_exportNotAcceptanceIdentifieder?notAcceptanceEntrustmentInform.xsjsglxt_not_acceptance_entrustment_inform_id='
									+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.xsjsglxt_not_acceptance_entrustment_inform_id;
							return false;
						}
					},
					'修改' : {
						btnClass : 'btn-orange user_check_power',
						action : function() {
							jc.close();
							Update_NotAcceptanceEntrustmentInform(obj);
						}
					},
					'返回' : function() {
					}
				}
			});
}