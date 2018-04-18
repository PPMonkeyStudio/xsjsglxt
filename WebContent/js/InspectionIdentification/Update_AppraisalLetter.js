<<<<<<< HEAD
function Update_AppraisalLetter() {
=======
function Update_AppraisalLetter(obj) {
>>>>>>> origin/ZB
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-ban',
<<<<<<< HEAD
				title : '修改鉴定书',
=======
				title : '不受理委托鉴定',
>>>>>>> origin/ZB
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
					var con = '<form id="form_AppraisalLetter">'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.xsjsglxt_appraisal_letter_id
							+ '"  class="form-control" name="appraisalLetter.xsjsglxt_appraisal_letter_id"  style="display:none;"/>'
							+ '<input value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_belong_entrustment_book
							+ '"  class="form-control" name="appraisalLetter.appraisal_letter_belong_entrustment_book"  style="display:none;"/>'
							+ '<hr>'
							+ '<table  class="table table-bordered" style="text-align: center;"><tbody>'
							+ '<tr>'
							+ '<td>案件情况摘要：</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_simple_case_situation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_simple_case_situation
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td id="td_appraisal_letter_sample_situation">检材和样本：</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_sample_situation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_sample_situation
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>检验：</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:300px;" name="appraisalLetter.appraisal_letter_inspection" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_inspection
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>论证：</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:200px;" name="appraisalLetter.appraisal_letter_argumentation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_argumentation
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>鉴定意见：</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_expert_opinion" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_expert_opinion
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>备注：</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_expert_opinion" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_expert_opinion
							+ '</textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td rowspan="2">鉴定人：</td><td>姓名：</td><td><input class="form-control" name="appraisalLetter.appraisal_letter_man1_name" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_man1_name
							+ '"/></td><td>职务：</td><td><input class="form-control" name="appraisalLetter.appraisal_letter_man1_duty" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_man1_duty
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>姓名：</td><td><input class="form-control" name="appraisalLetter.appraisal_letter_man2_name" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_man2_name
							+ '"/></td><td>职务：</td><td><input class="form-control" name="appraisalLetter.appraisal_letter_man2_duty" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_man2_duty
							+ '"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td >授权签字人：</td><td>姓名：</td><td><input class="form-control" name="appraisalLetter.appraisal_letter_authorization_name" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_authorization_name
							+ '"/></td><td>职务：</td><td><input class="form-control" name="appraisalLetter.appraisal_letter_authorization_duty" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_appraisal_letter.appraisal_letter_authorization_duty
							+ '"/></td>'
							+ '</tr>'
							+ '</tbody></table></form>'
							+ '<hr>';
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
											Preview_AppraisalLetter(obj);
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
							var formData = new FormData(document
									.getElementById("form_AppraisalLetter"));
							xhr
									.open("POST",
											"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateAppraisalLetter");
							xhr.send(formData);

							return false;
						}
					},
					'返回' : function() {
<<<<<<< HEAD
						Preview_NotAcceptanceEntrustmentInform(obj);
=======
						Preview_AppraisalLetter(obj);
>>>>>>> origin/ZB
					}
				}
			});
}
