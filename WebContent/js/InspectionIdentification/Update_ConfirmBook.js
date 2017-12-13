function Update_ConfirmBook(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-map-o',
				title : '鉴定事项确认书（修改）',
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
					var con = '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.xsjsglxt_identifieder_case_confirm_book_id
							+ '"  class="form-control" id="update_xsjsglxt_identifieder_case_confirm_book_id" style="display:none;"/>'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.identifieder_case_confirm_book_belong_entrustment_book
							+ '"  class="form-control" id="update_identifieder_case_confirm_book_belong_entrustment_book" style="display:none;"/>'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.identifieder_case_confirm_book_acceptance_num
							+ '"  class="form-control" id="update_identifieder_case_confirm_book_acceptance_num" style="display:none;"/>'
							+ '<hr>'
							+ '<br>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 受理人：</td>'
							+ '<td><input  class="form-control" id="update_identifieder_case_confirm_book_acceptance_human_name" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.identifieder_case_confirm_book_acceptance_human_name
							+ '"/></td></tr>'
							+ '<tr><td>备注：</td>'
							+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="update_identifieder_case_confirm_book_mark" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_identifieder_case_confirm_book.identifieder_case_confirm_book_mark
							+ '</textarea></td></tr>' + '</tbody>' + '</table>'
							+ '<h4>受理后，将自动生成《鉴定事项确认书》以及《受理鉴定回执》。</h4>' + '<br>'
							+ '<hr>';
					jc.setContentAppend(con);
					/*
					 * 
					 */
					/*
					 * 
					 */
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
	/*
	 * ID
	 */
	formData
			.append(
					"identifiederCaseConfirmBook.xsjsglxt_identifieder_case_confirm_book_id",
					document
							.getElementById("update_xsjsglxt_identifieder_case_confirm_book_id").value);

	/*
	 * 所属委托书
	 */
	formData
			.append(
					"identifiederCaseConfirmBook.identifieder_case_confirm_book_belong_entrustment_book",
					document
							.getElementById("update_identifieder_case_confirm_book_belong_entrustment_book").value);
	/*
	 * 编号
	 */
	formData
			.append(
					"identifiederCaseConfirmBook.identifieder_case_confirm_book_acceptance_num",
					document
							.getElementById("update_identifieder_case_confirm_book_acceptance_num").value);
	/*
	 * 受理人
	 */
	var update_identifieder_case_confirm_book_acceptance_human_name = document
			.getElementById("update_identifieder_case_confirm_book_acceptance_human_name");
	formData
			.append(
					"identifiederCaseConfirmBook.identifieder_case_confirm_book_acceptance_human_name",
					update_identifieder_case_confirm_book_acceptance_human_name.value);

	/*
	 * 备注
	 */
	var update_identifieder_case_confirm_book_mark = document
			.getElementById("update_identifieder_case_confirm_book_mark");
	formData.append(
			"identifiederCaseConfirmBook.identifieder_case_confirm_book_mark",
			update_identifieder_case_confirm_book_mark.value);
	/*
	 * 
	 */
	xhr
			.open(
					"POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateIdentifiederCaseConfirmBook");
	xhr.send(formData);
}