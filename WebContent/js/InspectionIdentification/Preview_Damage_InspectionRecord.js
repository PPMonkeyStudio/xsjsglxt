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

					var con = '<hr>' + '<div style="text-align: left;">'
							+ '<h4 style="text-align: center;">尸体检验记录</h4>'
							+ '<p></p>' + '</div>';
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