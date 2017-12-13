function Update_ConfirmBook(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-map-o',
				title : '鉴定事项确认书（修改）',
				content : '',
				type : 'green',
				columnClass : 'col-md-12',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}
					var con = '';
					jc.setContentAppend(con);
					/*
					 * 
					 */
				},
				buttons : {
					'确认修改' : {
						btnClass : 'btn-green',
						action : function() {
							updateIdentifiederCaseConfirmBook(jc, obj);
						}
					},
					'返回' : function() {
						Preview_ConfirmBook(obj);
					}
				}
			});
}

function updateIdentifiederCaseConfirmBook(jc, obj) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("修改成功");
					jc.close();
					List_EntrustmentBook(1);
					Preview_ConfirmBook(obj);
				} else {
					toastr.error("填写格式错误");
				}
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	/*
	 * 
	 */
	var formData = new FormData();

	xhr
			.open(
					"POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateIdentifiederCaseConfirmBook");
	xhr.send(formData);
}