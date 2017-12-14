function Update_NotAcceptanceEntrustmentInform(obj) {
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
					var con = '<form id="form_Refuse_EntrustmentBook">'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.xsjsglxt_not_acceptance_entrustment_inform_id
							+ '"  class="form-control" name="notAcceptanceEntrustmentInform.xsjsglxt_not_acceptance_entrustment_inform_id" style="display:none;"/>'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_belong_entrustment_book
							+ '"  class="form-control" name="notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_belong_entrustment_book" style="display:none;"/>'
							+ '<h4>确认不受理后，将自动生成《不受理委托鉴定告知书（存根）》以及《萍乡市安源区公安司法鉴定中心不受理委托鉴定告知书》。</h4>'
							+ '<hr>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td style="width:200px;">不予受理理由：</td>'
							+ '<td><textarea name="notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_reason"  class="form-control" style="resize: none;height:100px;" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_reason
							+ '</textarea>故不予受理。</td></tr>'
							+ '<tr><td>填表人：</td>'
							+ '<td><input  class="form-control" name="notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_inputhuman_name"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_inputhuman_name
							+ '"/></td></tr>'
							+ '<tr><td>批准人：</td>'
							+ '<td><input  class="form-control" name="notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_approvalhuman_name"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approvalhuman_name
							+ '"/></td></tr>'
							+ '<tr><td>批准时间：</td>'
							+ '<td><input  class="form-control mydate" name="notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_approval_time"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_not_acceptance_entrustment_inform.not_acceptance_entrustment_inform_approval_time
							+ '"/></td></tr>'
							+ '</tbody>'
							+ '</table>'
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
							updateNotAcceptanceInform(jc, obj);
							return false;
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function updateNotAcceptanceInform(jc, obj) {
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
			.getElementById("form_Refuse_EntrustmentBook"));

	/*
	 * 
	 */
	xhr
			.open(
					"POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateNotAcceptanceInform");
	xhr.send(formData);
}