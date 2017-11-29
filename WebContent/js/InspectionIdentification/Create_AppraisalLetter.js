function Create_AppraisalLetter(obj) {
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-pencil-square-o',
				title : '出具鉴定文书',
				content : '<input value="'
						+ obj.id
						+ '"  class="form-control" id="create_appraisal_letter_belong_entrustment_book" style="display:none;"/>'
						+ '<hr>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_appraisal_letter_inspection">本次检验采用XXXX鉴定法（公安部物证鉴定中心）\n（一）\n（二）</textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 论证：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_appraisal_letter_argumentation"></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 鉴定意见：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_appraisal_letter_expert_opinion"></textarea></td></tr>'
						+ '</tbody>' + '</table>' + '<br>' + '<hr>',
				type : 'blue',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
				},
				buttons : {
					'记录' : {
						btnClass : 'btn-blue',
						action : function() {
							addAppraisalLetter(jc);
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function addAppraisalLetter(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("已出具鉴定文书");
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
	var create_appraisal_letter_belong_entrustment_book = document
			.getElementById("create_appraisal_letter_belong_entrustment_book");
	formData.append("appraisalLetter.appraisal_letter_belong_entrustment_book",
			create_appraisal_letter_belong_entrustment_book.value);
	/*
	 * 检验
	 */
	var create_appraisal_letter_inspection = document
			.getElementById("create_appraisal_letter_inspection");
	formData.append("appraisalLetter.appraisal_letter_inspection",
			create_appraisal_letter_inspection.value);
	/*
	 * 论证
	 */
	var create_appraisal_letter_argumentation = document
			.getElementById("create_appraisal_letter_argumentation");
	formData.append("appraisalLetter.appraisal_letter_argumentation",
			create_appraisal_letter_argumentation.value);
	/*
	 * 鉴定意见
	 */
	var create_appraisal_letter_expert_opinion = document
			.getElementById("create_appraisal_letter_expert_opinion");
	formData.append("appraisalLetter.appraisal_letter_expert_opinion",
			create_appraisal_letter_expert_opinion.value);
	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addAppraisalLetter");
	xhr.send(formData);
}