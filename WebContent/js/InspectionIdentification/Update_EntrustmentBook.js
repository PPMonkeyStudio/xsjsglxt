function Update_EntrustmentBook(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				title : '检验鉴定委托书（通用）（修改）',
				content : '',
				type : 'blue',
				columnClass : 'col-md-12',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}
					var con = '<hr>'
							+ '<h3>委托人声明</h3>'
							+ '<h4>本人忠于事实真相，送检的检材/样本/材料真实。如有虚假，愿意承担相关法律责任.</h4>'
							+ '<hr style="margin:30px 0;">'
							+ '<form id="form_EntrustmentBook">'
							+ '<input name="tranceCheckBook.xsjsglxt_check_entrustment_book_id" class="form-control" style="display:none;" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
							+ '"/>'
							+ '<input name="tranceCheckBook.check_entrustment_book_physical_evidence" class="form-control" style="display:none;" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_physical_evidence
							+ '"/>'
							+ '<input name="tranceCheckBook.check_entrustment_book_entrustment_request" class="form-control" style="display:none;" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request
							+ '"/>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td><span style="color:#D9534F;">*</span> 负责人：</td><td><input  name="tranceCheckBook.check_entrustment_book_responsible_person" class="form-control" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_responsible_person
							+ '" /></td>'
							+ '<td><span style="color:#D9534F;">*</span> 委托单位：</td>'
							+ '<td><select class="form-control" name="tranceCheckBook.check_entrustment_book_entrustment_unit">'
							+ '<option value="后埠派出所">后埠派出所</option>'
							+ '<option value="凤凰派出所">凤凰派出所</option>'
							+ '<option value="安源派出所">安源派出所</option>'
							+ '<option value="城郊派出所">城郊派出所</option>'
							+ '<option value="八一派出所">八一派出所</option>'
							+ '<option value="东大派出所">东大派出所</option>'
							+ '<option value="青山派出所">青山派出所</option>'
							+ '<option value="丹江派出所">丹江派出所</option>'
							+ '<option value="白源派出所">白源派出所</option>'
							+ '<option value="高坑派出所">高坑派出所</option>'
							+ '<option value="五陂下派出所">五陂下派出所</option>'
							+ '<option value="其他">其他</option>'
							+ '</select></td></tr>'
							+ '<td><span style="color:#D9534F;">*</span> 委托时间：</td><td><input name="tranceCheckBook.check_entrustment_book_inspect_time" class="form-control mydate"  value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time
							+ '"/></td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td>送检人</td><td><span style="color:#D9534F;">*</span> 姓名</td><td><span style="color:#D9534F;">*</span> 职务</td><td><span style="color:#D9534F;">*</span> 证件名称及号码</td></tr>'
							+ '<tr><td>送检人一：</td><td><input name="tranceCheckBook.check_entrustment_book_inspectors1_name"  class="form-control" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_duty
							+ '"/></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors1_duty"   class="form-control" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_duty
							+ '"/></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors1_jobcard_number"   class="form-control" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_jobcard_number
							+ '"/></td></tr>'
							+ '<tr><td>送检人二：</td><td><input name="tranceCheckBook.check_entrustment_book_inspectors2_name"   class="form-control" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_name
							+ '"/></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors2_duty"   class="form-control" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_duty
							+ '"/></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors2_jobcard_number"   class="form-control" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_jobcard_number
							+ '"/></td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td><span style="color:#D9534F;">*</span> 通讯地址：</td><td><input  class="form-control" name="tranceCheckBook.check_entrustment_book_communication_address" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_communication_address
							+ '"/></td><td><span style="color:#D9534F;">*</span> 邮政编码：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_zip_code" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_zip_code
							+ '"/></td></tr>'
							+ '<tr><td><span style="color:#D9534F;">*</span> 联系电话：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_phone" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_phone
							+ '"/></td><td><span style="color:#D9534F;">*</span> 传真号码：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_fax_num" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_fax_num
							+ '"/></td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<div id="div_ForensicCheckEntrustmentBook">'
							+ '<h4>被鉴定人的情况：</h4>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td><span style="color:#D9534F;">*</span> 姓名：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_name" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_name
							+ '"/></td><td>性别：</td><td><select class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_sex" >'
							+ '<option value="男">男</option>'
							+ '<option value="女">女</option>'
							+ '</select></td></tr>'
							+ '<tr><td>单位：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_unit" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_unit
							+ '"/></td><td><span style="color:#D9534F;">*</span> 电话：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_phone" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_phone
							+ '"/></td></tr>'
							+ '<tr><td>住址：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_address" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_address
							+ '"/></td><td>年龄：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_age" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_age
							+ '"/></td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '</div>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td><span style="color:#D9534F;">*</span> 被委托鉴定机构名称：</td>'
							+ '<td><select class="form-control" name="tranceCheckBook.check_entrustment_book_entrustment_unit_name" >'
							+ '<option value="萍乡市公安司法鉴定中心">萍乡市公安司法鉴定中心</option>'
							+ '<option value="萍乡市公安局物证鉴定所">萍乡市公安局物证鉴定所</option>'
							+ '<option value="萍乡市安源区公安司法鉴定中心">萍乡市安源区公安司法鉴定中心</option>'
							+ '<option value="江西省公安厅物证鉴定中心">江西省公安厅物证鉴定中心</option>'
							+ '<option value="公安部物证鉴定中心">公安部物证鉴定中心</option>'
							+ '</select></td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td><span style="color:#D9534F;">*</span> 案（事）件名称：</td>'
							+ '<td><input class="form-control" name="tranceCheckBook.check_entrustment_book_case_name" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_name
							+ '"/></td></tr>'
							+ '<tr><td>案件编号：</td>'
							+ '<td><input class="form-control" name="tranceCheckBook.check_entrustment_book_case_num" value="'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_num
							+ '"/></td></tr>'
							+ '<tr><td><span style="color:#D9534F;">*</span> 简要案情：</td>'
							+ '<td><textarea class="form-control" style="resize: none;height:100px;" name="tranceCheckBook.check_entrustment_book_simple_case_situation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation
							+ '</textarea></td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<h4>原鉴定情况：</h4>'
							+ '<textarea class="form-control" style="resize: none;height:100px;" name="tranceCheckBook.check_entrustment_book_old_entrustment_situation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_old_entrustment_situation
							+ '</textarea>'
							+ '<h4><span style="color:#D9534F;">*</span> 送检的检材和样本等情况（包括名称、数量、性状、包装，检材提取部位和方法等）：</h4>'
							+ '<textarea class="form-control" style="resize: none;height:100px;" name="tranceCheckBook.check_entrustment_book_sample_situation" >'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_sample_situation
							+ '</textarea>'
							+ '<br>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td><span style="color:#D9534F;">*</span> 鉴定要求</td>'
							+ '<td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request
							+ '</td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '</form>' + '<br>' + '<hr>';
					jc.setContentAppend(con);
					/*
					 * 判断类别
					 */
					if (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_type == '痕迹') {
						var div_ForensicCheckEntrustmentBook = document
								.getElementById("div_ForensicCheckEntrustmentBook");
						div_ForensicCheckEntrustmentBook.parentNode
								.removeChild(div_ForensicCheckEntrustmentBook);
					} else {
						var check_entrustment_book_entrustmentor_sex = document
								.getElementsByName("tranceCheckBook.check_entrustment_book_entrustmentor_sex")[0];
						switch (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_sex) {
						case '男': {
							check_entrustment_book_entrustmentor_sex.innerHTML = '<option value="男" selected="selected">男</option>'
									+ '<option value="女">女</option>'
							break;
						}
						case '女': {
							check_entrustment_book_entrustmentor_sex.innerHTML = '<option value="男" >男</option>'
									+ '<option value="女" selected="selected">女</option>'
							break;
						}
						}
					}
					/*
					 * 
					 */

					/*
					 * 
					 */
					var check_entrustment_book_entrustment_unit_name = document
							.getElementsByName("tranceCheckBook.check_entrustment_book_entrustment_unit_name")[0];
					switch (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit_name) {
					case '萍乡市公安司法鉴定中心': {
						check_entrustment_book_entrustment_unit_name.innerHTML = '<option value="萍乡市公安司法鉴定中心" selected="selected">萍乡市公安司法鉴定中心</option>'
								+ '<option value="萍乡市公安局物证鉴定所">萍乡市公安局物证鉴定所</option>'
								+ '<option value="萍乡市安源区公安司法鉴定中心">萍乡市安源区公安司法鉴定中心</option>'
								+ '<option value="江西省公安厅物证鉴定中心">江西省公安厅物证鉴定中心</option>'
								+ '<option value="公安部物证鉴定中心">公安部物证鉴定中心</option>';
						break;
					}
					case '萍乡市公安局物证鉴定所': {
						check_entrustment_book_entrustment_unit_name.innerHTML = '<option value="萍乡市公安司法鉴定中心">萍乡市公安司法鉴定中心</option>'
								+ '<option value="萍乡市公安局物证鉴定所"  selected="selected">萍乡市公安局物证鉴定所</option>'
								+ '<option value="萍乡市安源区公安司法鉴定中心">萍乡市安源区公安司法鉴定中心</option>'
								+ '<option value="江西省公安厅物证鉴定中心">江西省公安厅物证鉴定中心</option>'
								+ '<option value="公安部物证鉴定中心">公安部物证鉴定中心</option>';
						break;
					}
					case '萍乡市安源区公安司法鉴定中心': {
						check_entrustment_book_entrustment_unit_name.innerHTML = '<option value="萍乡市公安司法鉴定中心">萍乡市公安司法鉴定中心</option>'
								+ '<option value="萍乡市公安局物证鉴定所">萍乡市公安局物证鉴定所</option>'
								+ '<option value="萍乡市安源区公安司法鉴定中心" selected="selected">萍乡市安源区公安司法鉴定中心</option>'
								+ '<option value="江西省公安厅物证鉴定中心">江西省公安厅物证鉴定中心</option>'
								+ '<option value="公安部物证鉴定中心">公安部物证鉴定中心</option>';
						break;
					}
					case '江西省公安厅物证鉴定中心': {
						check_entrustment_book_entrustment_unit_name.innerHTML = '<option value="萍乡市公安司法鉴定中心">萍乡市公安司法鉴定中心</option>'
								+ '<option value="萍乡市公安局物证鉴定所">萍乡市公安局物证鉴定所</option>'
								+ '<option value="萍乡市安源区公安司法鉴定中心">萍乡市安源区公安司法鉴定中心</option>'
								+ '<option value="江西省公安厅物证鉴定中心" selected="selected">江西省公安厅物证鉴定中心</option>'
								+ '<option value="公安部物证鉴定中心">公安部物证鉴定中心</option>';
						break;
					}
					case '公安部物证鉴定中心': {
						check_entrustment_book_entrustment_unit_name.innerHTML = '<option value="萍乡市公安司法鉴定中心">萍乡市公安司法鉴定中心</option>'
								+ '<option value="萍乡市公安局物证鉴定所">萍乡市公安局物证鉴定所</option>'
								+ '<option value="萍乡市安源区公安司法鉴定中心">萍乡市安源区公安司法鉴定中心</option>'
								+ '<option value="江西省公安厅物证鉴定中心">江西省公安厅物证鉴定中心</option>'
								+ '<option value="公安部物证鉴定中心"  selected="selected">公安部物证鉴定中心</option>';
						break;
					}

					}

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
					button_update : {
						text : '确认修改',
						btnClass : 'btn-blue',
						action : function() {
							/*
							 * 
							 */
							jc.showLoading(false);
							/*
							 * 
							 */
							updateTranceCheckBook(jc, obj);
							return false;
						},
					},
					'返回' : function() {
						Preview_EntrustmentBook(obj);
					}
				}
			});
}
function updateTranceCheckBook(jc, obj) {
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
					Preview_EntrustmentBook(obj);
				} else {
					toastr.error("填写格式错误");
					// jc.buttons.button_update.enable();
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
	var formData = new FormData(document.getElementById("form_EntrustmentBook"));

	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_updateTranceCheckBook");
	xhr.send(formData);
}