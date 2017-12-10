function Preview_NotAcceptanceEntrustmentInform(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-file-text-o',
				title : '<p>萍乡市安源区公安司法鉴定中心</p><p>不受理委托告知书</p>',
				content : '',
				type : 'red',
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
					var con = '<div style="margin:0 20px 0 0;">'
							+ '<hr>'
							+ '<h3  style="text-align: right;">编号：['
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(0, 4)
							+ ']第'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(4)
							+ '号</h3>'
							+ '<h3 style="text-align: left;text-indent:2em;">'
							+ '<p>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_reason
							+ '现决定对你单位有关<b>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_name
							+ '</b>的鉴定委托不予受理。</p><p>特此告知。</p>'
							+ '</h3>'
							+ '<h3 style="text-align: right;">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(0, 4)
							+ '年'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(5, 7)
							+ '月'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
									.substring(8, 11) + '日</h3>' + '<hr></div>';
					jc.setContentAppend(con);
				},
				buttons : {
					'导出' : {
						btnClass : 'btn-red',
						action : function() {

							return false;
						}
					},
					'返回' : function() {
					}
				}
			});
}