function Preview_AppraisalLetter(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-file-text-o',
				title : '鉴定书',
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
							+ '<h3  style="text-align: right;">编号：【'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.identifieder_case_confirm_book_acceptance_num
									.substring(0, 4)
							+ '】第'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.identifieder_case_confirm_book_acceptance_num
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
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit
							+ '</p>'
							+ '<p>（四）案件情况摘要：</p>'
							+ '<p>（五）检材和样本：</p>'
							+ '<p>（六）鉴定要求：</p>'
							+ '<p>（七）检验开始日期：</p>'
							+ '<p>（八）检验地点：</p>'
							+ '</h3>'
							+ '<h3  style="text-align: left;">'
							+ '<p>二、检验</p><p></p>'
							+ '</h3>'
							+ '<h3  style="text-align: left;">'
							+ '<p>三、论证</p><p></p>'
							+ '</h3>'
							+ '<h3  style="text-align: left;">'
							+ '<p>四、鉴定意见</p><p></p>' + '</h3>' + '<hr></div>';
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