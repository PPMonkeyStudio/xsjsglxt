function Preview_AppraisalLetter(obj) {
	var json_list = EntrustmentBook_json;
	for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
		if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
			break;
		}
	}
	var jc = $
			.confirm({
				icon : 'fa fa-file-text-o',
				title : '鉴定书',
				content : '',
				type : 'green',
				columnClass : 'col-md-12',
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

					var con = '<div style="margin:0 20px 0 0;"><hr>'
							+ '<h3  style="text-align: right;">编号：【'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_num
									.substring(0, 4)
							+ '】第'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_num
									.substring(4)
							+ '号</h3>'
							+ '<h3  style="text-align: left;">'
							+ '<p>一、绪论</p>'
							+ '<p>（一）委托单位：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit
							+ '</p>'
							+ '<p>（二）送检人：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_name
							+ '、'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_name
							+ '</p>'
							+ '<p>（三）受理日期：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.identifieder_case_confirm_book_gmt_create
							+ '</p>'
							+ '<p>（四）案件情况摘要：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation
							+ '</p>'
							+ '<p>（五）检材和样本：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_sample_situation
							+ '</p>'
							+ '<p>（六）鉴定要求：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request
							+ '</p>'
							+ '<p>（七）检验开始日期：	</p>'
							+ (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request == '损伤鉴定' ? ''
									: (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request == '死因鉴定' ? '<p>（八）检验地点：'
											+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_place
											+ '</p>'
											: '<p>（八）检验地点：'
													+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_inspection_record.inspection_location
													+ '</p>'))
							+ '</h3>'
							+ '<br>'
							+ '<h3  style="text-align: left;">'
							+ '<p>二、检验</p><p>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_inspection
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</p>'
							+ '</h3>'
							+ '<br>'
							+ '<h3  style="text-align: left;">'
							+ '<p>三、论证</p><p>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_argumentation
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</p>'
							+ '</h3>'
							+ '<br>'
							+ '<h3  style="text-align: left;">'
							+ '<p>四、鉴定意见</p><p>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_expert_opinion
									.replace(/\n/g, "<br>").replace(/ /g,
											"&nbsp;")
							+ '</p>'
							+ '</h3>'
							+ '<br>'
							+ '<h3  style="text-align: right;">'
							+ '<p>鉴定人：法医师 龙建平</p>'
							+ '<p>法医师 龙建平</p>'
							+ '<p>授权签字人 ：副主任法医师 刘蓉</p>'
							+ '<p>2017年05月21日</p>'
							+ '</h3>' + '<hr></div>';
					jc.setContentAppend(con);
				},
				buttons : {
					'导出' : {
						btnClass : 'btn-green',
						action : function() {
							window.location = '/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_exportAppraisalLetter?appraisalLetter.xsjsglxt_appraisal_letter_id='
									+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.xsjsglxt_appraisal_letter_id;
							return false;
						}
					},
					'修改' : {
						btnClass : 'btn-orange user_check_power',
						action : function() {
							Update_AppraisalLetter(obj);
						}
					},
					'返回' : function() {
					}
				}
			});
}
