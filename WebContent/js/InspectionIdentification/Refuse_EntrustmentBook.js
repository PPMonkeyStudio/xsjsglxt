/*
 * 拒绝受理委托书
 */
function Refuse_EntrustmentBook(obj) {
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-ban',
				title : '不受理委托鉴定',
				content : '<input value="'
						+ obj.id
						+ '"  class="form-control" id="create_not_acceptance_entrustment_inform_belong_entrustment_book" style="display:none;"/>'
						+ '<hr>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 不予受理理由：</td>'
						+ '<td><textarea id="create_not_acceptance_entrustment_inform_reason" class="form-control" style="resize: none;height:100px;" >根据《公安机关鉴定规则》第XX条XX款之规定，因XXXX，</textarea>故不予受理。</td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 填表人：</td>'
						+ '<td><input  class="form-control" id="create_not_acceptance_entrustment_inform_inputhuman_name" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 批准人：</td>'
						+ '<td><input  class="form-control" id="create_not_acceptance_entrustment_inform_approvalhuman_name" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 批准时间：</td>'
						+ '<td><input  class="form-control" id="create_not_acceptance_entrustment_inform_approval_time" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<h4>确认不受理后，将自动生成《不受理委托鉴定告知书（存根）》以及《萍乡市安源区公安司法鉴定中心不受理委托鉴定告知书》。</h4>',
				type : 'orange',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					var date = new Date();
					document
							.getElementById("create_not_acceptance_entrustment_inform_approval_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
				},
				buttons : {
					'确认' : {
						btnClass : 'btn-orange',
						action : function() {
							SureRefuse(jc);
						}
					},
					'放弃' : function() {
					}
				}
			});
}
function SureRefuse(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("不受理成功");
					jc.close();
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
	 * 所属委托书
	 */
	var create_not_acceptance_entrustment_inform_belong_entrustment_book = document
			.getElementById("create_not_acceptance_entrustment_inform_belong_entrustment_book");
	formData
			.append(
					"notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_belong_entrustment_book",
					create_not_acceptance_entrustment_inform_belong_entrustment_book.value);
	/*
	 * 不予受理理由
	 */
	var create_not_acceptance_entrustment_inform_reason = document
			.getElementById("create_not_acceptance_entrustment_inform_reason");
	formData
			.append(
					"notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_reason",
					create_not_acceptance_entrustment_inform_reason.value);
	/*
	 * 填表人
	 */
	var create_not_acceptance_entrustment_inform_inputhuman_name = document
			.getElementById("create_not_acceptance_entrustment_inform_inputhuman_name");
	formData
			.append(
					"notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_inputhuman_name",
					create_not_acceptance_entrustment_inform_inputhuman_name.value);
	/*
	 * 批准人
	 */
	var create_not_acceptance_entrustment_inform_approvalhuman_name = document
			.getElementById("create_not_acceptance_entrustment_inform_approvalhuman_name");
	formData
			.append(
					"notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_approvalhuman_name",
					create_not_acceptance_entrustment_inform_approvalhuman_name.value);
	/*
	 * 批准时间
	 */
	var create_not_acceptance_entrustment_inform_approval_time = document
			.getElementById("create_not_acceptance_entrustment_inform_approval_time");
	formData
			.append(
					"notAcceptanceEntrustmentInform.not_acceptance_entrustment_inform_approval_time",
					create_not_acceptance_entrustment_inform_approval_time.value);
	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addNotAcceptance");
	xhr.send(formData);
}