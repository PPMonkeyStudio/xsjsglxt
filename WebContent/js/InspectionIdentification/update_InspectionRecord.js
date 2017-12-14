function update_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-ban',
				title : '不受理委托鉴定',
				content : '',
				type : 'red',
				columnClass : 'col-md-12',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}
					var con = '<form id="form_InspectionRecord">' + ''
							+ '</form>';
					jc.setContentAppend(con);
					/*
					 * 
					 */
					$.datetimepicker.setLocale('ch');
					$('.mydate').datetimepicker({
						yearStart : 1990, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : false, // 关闭时间选项
						format : 'Y-m-d', // 格式化日期年-月-日
						minDate : '1990/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});
				},
				buttons : {
					'确认修改' : {
						btnClass : 'btn-red',
						action : function() {
							jc.showLoading(false);
							updateInspectionRecord(jc, obj);
							return false;
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function updateInspectionRecord(jc, obj) {
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
					List_EntrustmentBook(EntrustmentBook_json.pageIndex);
					Preview_NotAcceptanceEntrustmentInform(obj);
				} else {
					toastr.error("填写格式错误");
					jc.hideLoading(true);
				}
			} else {
				toastr.error(xhr.status);
				jc.hideLoading(true);
			}
		}
	}
	/*
	 * 
	 */
	var formData = new FormData(document
			.getElementById("form_InspectionRecord"));

	/*
	 * 
	 */
	xhr
			.open(
					"POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateInspectionRecord");
	xhr.send(formData);

}