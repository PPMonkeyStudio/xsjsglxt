/**
 * 
 */
function updateHandleCase(event) {
	$
			.confirm({
				title : '修改此案',
				columnClass : "col-md-12",
				type : 'blue',
				content : '<form id="HandleCaseInfor"><table class="table table-bordered" style="text-align: center;"><tr>'
						+ '<td>案件名称：</td><td colspan="3"><input id="updateName" name="handleCase.handle_case_name" type="text" class="form-control"></td>'
						+ '<td>案件状态</td><td><select id="updateState" name="handleCase.handle_case_state" class="form-control">'
						+ '<option value="0">在侦</option>'
						+ '<option value="1">已破</option>'
						+ '</select></td>'
						+ '</tr>'
						+ '<tr><td>主办民警：</td><td><input id="updateMain" name="handleCase.handle_main_police" type="text" class="form-control"></td>'
						+ '<td>协办民警：</td><td><input id="updateAssistant" name="handleCase.handle_assistant_police" type="text" class="form-control"></td></td>'
						+ '<td>中队长：</td><td><input id="updateMiddle" name="handleCase.handle_middle_captain" type="text" class="form-control"></td></td></tr>'
						+ '</table></form>',
				buttons : {
					save : {
						text : '保存',
						btnClass : 'btn-blue',
						action : function() {
							var formData = new FormData(document
									.getElementById("HandleCaseInfor"));
							formData.append("handleCase.handle_case_id",
									event.id);
							$
									.ajax({
										url : '/xsjsglxt/case/DealCase_updateHandleCase',
										type : "POST",
										data : formData,
										processData : false,
										contentType : false,
										success : function(data) {
											if (data == "updateSuccess") {
												toastr.success("修改成功！");
												loadData();
											} else {
												toastr.error("修改失败！");
											}
										}
									})
						}
					},
					cancel : {
						btnClass : 'btn-red',
						text : '关闭',
						action : function() {

						}
					}
				},
				onContentReady : function() {
					$
							.ajax({
								url : '/xsjsglxt/case/DealCase_gainHandleCaseById',
								type : 'POST',
								data : {
									'handleCase_id' : event.id
								},
								success : function(data) {
									var handleCase = JSON.parse(data);
									$('#updateName').val(
											handleCase.handle_case_name);
									$('#updateMain').val(
											handleCase.handle_main_police);
									$('#updateAssistant').val(
											handleCase.handle_assistant_police);
									$('#updateMiddle').val(
											handleCase.handle_middle_captain);
									$('#updateState').val(
											handleCase.handle_case_state);
								}
							})
				}
			})
}
function deleteHandleCase(event) {
	$
			.confirm({
				title : '<i class="fa fa-exclamation-triangle" style="color:red;" aria-hidden="true"></i>删除此案',
				type : 'red',
				content : '',
				autoClose : "close|10000",
				buttons : {
					sure : {
						text : "确定",
						btnClass : "btn-blue",
						action : function() {
							$
									.ajax({
										url : "/xsjsglxt/case/DealCase_deleteHandleCase",
										type : "POST",
										data : {
											"handleCase_id" : event.id
										},
										success : function(data) {
											if (data == "deleteSuccess") {
												toastr.success("删除成功");
												loadData();
											} else {
												toastr.error("删除失败");
											}
										}
									});
						}
					},
					close : {
						text : "取消",
						btnClass : "btn-red"

					}
				}
			});
}