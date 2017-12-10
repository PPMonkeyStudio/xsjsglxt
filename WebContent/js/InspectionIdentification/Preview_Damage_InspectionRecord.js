function Preview_Damage_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $.confirm({
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