/*
 * 受理任务书
 */
function Acceptance_EntrustmentBook(obj) {
	var js = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-map-o',
				title : '受理委托书',
				content : '<input value="'
						+ obj.id
						+ '"  class="form-control" id="create_xsjsglxt_check_entrustment_book_id" style="display:none;"/>'
						+ '<hr>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 受理人：</td>'
						+ '<td><input  class="form-control" id="create_identifieder_case_confirm_book_acceptance_human_name" /></td></tr>'
						+ '<tr><td>备注：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_identifieder_case_confirm_book_mark"></textarea></td></tr>'
						+ '</tbody>' + '</table>'
						+ '<h4>受理后，将自动生成《鉴定事项确认书》以及《受理鉴定回执》。</h4>' + '<br>'
						+ '<hr>',
				type : 'green',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
				},
				buttons : {
					'确认受理' : {
						btnClass : 'btn-green',
						action : function() {
							SureAcceptance(js);
						}
					},
					'放弃受理' : function() {
					}
				}
			});
}

function SureAcceptance(js) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("保存成功");
					js.close();
					List_EntrustmentBook(1);
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
	formData.append(
			"identifiederCaseConfirmBook.xsjsglxt_check_entrustment_book_id",
			create_xsjsglxt_check_entrustment_book_id.value);
	/*
	 * 负责人
	 */
	var create_identifieder_case_confirm_book_acceptance_human_name = document
			.getElementById("create_identifieder_case_confirm_book_acceptance_human_name");
	if (create_identifieder_case_confirm_book_acceptance_human_name.value == '') {
		toastr.error("受理人不可为空");
		return;
	}
	formData
			.append(
					"identifiederCaseConfirmBook.identifieder_case_confirm_book_acceptance_human_name",
					create_identifieder_case_confirm_book_acceptance_human_name.value);
	/*
	 * 备注
	 */
	var create_identifieder_case_confirm_book_mark = document
			.getElementById("create_identifieder_case_confirm_book_mark");
	formData.append(
			"identifiederCaseConfirmBook.identifieder_case_confirm_book_mark",
			create_identifieder_case_confirm_book_mark.value);
	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addConfirmBook");
	xhr.send(formData);
}