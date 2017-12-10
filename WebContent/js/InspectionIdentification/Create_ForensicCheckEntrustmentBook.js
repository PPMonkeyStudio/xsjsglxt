document.getElementById("button_Create_ForensicCheckEntrustmentBook").onclick = function() {
	Create_ForensicCheckEntrustmentBook();
}

function Create_ForensicCheckEntrustmentBook() {
	var jc = $
			.confirm({
				title : '法医检验鉴定委托书',
				content : '<hr>'
						+ '<h3>委托人声明</h3>'
						+ '<h4>本人忠于事实真相，送检的检材/样本/材料真实。如有虚假，愿意承担相关法律责任.</h4>'
						+ '<hr style="margin:30px 0;">'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr>'
						+ '<td><span style="color:#D9534F;">*</span> 负责人：</td><td><input   class="form-control" id="create_check_entrustment_book_responsible_person" /></td>'
						+ '<td><span style="color:#D9534F;">*</span> 委托单位：</td><td><input   class="form-control" id="create_check_entrustment_book_entrustment_unit" /></td>'
						+ '<td><span style="color:#D9534F;">*</span> 委托时间：</td><td><input class="form-control mydate" id="create_check_entrustment_book_inspect_time" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td>送检人</td><td><span style="color:#D9534F;">*</span> 姓名</td><td><span style="color:#D9534F;">*</span> 职务</td><td><span style="color:#D9534F;">*</span> 证件名称及号码</td></tr>'
						+ '<tr><td>送检人一：</td><td><input id="create_check_entrustment_book_inspectors1_name" class="form-control" /></td><td><input id="create_check_entrustment_book_inspectors1_duty"  class="form-control" /></td><td><input id="create_check_entrustment_book_inspectors1_jobcard_number"  class="form-control" /></td></tr>'
						+ '<tr><td>送检人二：</td><td><input id="create_check_entrustment_book_inspectors2_name"  class="form-control" /></td><td><input  id="create_check_entrustment_book_inspectors2_duty" class="form-control" /></td><td><input  id="create_check_entrustment_book_inspectors2_jobcard_number" class="form-control" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 通讯地址：</td><td><input class="form-control" id="create_check_entrustment_book_communication_address"/></td><td><span style="color:#D9534F;">*</span> 邮政编码：</td><td><input class="form-control" id="create_check_entrustment_book_zip_code"/></td></tr>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 联系电话：</td><td><input class="form-control" id="create_check_entrustment_book_phone"/></td><td><span style="color:#D9534F;">*</span> 传真号码：</td><td><input class="form-control" id="create_check_entrustment_book_fax_num"/></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<h4>被鉴定人的情况：</h4>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 姓名：</td><td><input class="form-control" id="create_check_entrustment_book_entrustmentor_name"/></td><td>性别：</td><td><select class="form-control" id="create_check_entrustment_book_entrustmentor_sex">'
						+ '<option value="男">男</option>'
						+ '<option value="女">女</option>'
						+ '</select></td></tr>'
						+ '<tr><td>单位：</td><td><input class="form-control" id="create_check_entrustment_book_entrustmentor_unit"/></td><td><span style="color:#D9534F;">*</span> 电话：</td><td><input class="form-control" id="create_check_entrustment_book_entrustmentor_phone"/></td></tr>'
						+ '<tr><td>住址：</td><td><input class="form-control" id="create_check_entrustment_book_entrustmentor_address"/></td><td>年龄：</td><td><input class="form-control" id="create_check_entrustment_book_entrustmentor_age"/></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 被委托鉴定机构名称：</td>'
						+ '<td><select class="form-control" id="create_check_entrustment_book_entrustment_unit_name">'
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
						+ '<td><input class="form-control" id="create_check_entrustment_book_case_name"/></td></tr>'
						+ '<tr><td>案件编号：</td>'
						+ '<td><input class="form-control" id="create_check_entrustment_book_case_num"/></td></tr>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 简要案情：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_check_entrustment_book_simple_case_situation"></textarea></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<h4>原鉴定情况：</h4>'
						+ '<textarea class="form-control" style="resize: none;height:100px;" id="create_check_entrustment_book_old_entrustment_situation"></textarea>'
						+ '<h4><span style="color:#D9534F;">*</span> 送检的检材和样本等情况（包括名称、数量、性状、包装，检材提取部位和方法等）：</h4>'
						+ '<textarea class="form-control" style="resize: none;height:100px;" id="create_check_entrustment_book_sample_situation"></textarea>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 鉴定要求</td>'
						+ '<td><select class="form-control" id="create_check_entrustment_book_entrustment_request">'
						+ '<option value="指纹检验鉴定">指纹检验鉴定</option>'
						+ '<option value="足迹检验鉴定">足迹检验鉴定</option>'
						+ '<option value="整体分离检验鉴定">整体分离检验鉴定</option>'
						+ '<option value="车辆痕迹检验鉴定">车辆痕迹检验鉴定</option>'
						+ '<option value="死因鉴定">死因鉴定</option>'
						+ '<option value="损伤鉴定">损伤鉴定</option>'
						+ '<option value="理化检验鉴定">理化检验鉴定</option>'
						+ '<option value="毒物检验鉴定">毒物检验鉴定</option>'
						+ '<option value="失踪人口查询">失踪人口查询</option>'
						+ '<option value="其他">其他</option>'
						+ '</select><input class="form-control" id="create_check_entrustment_book_entrustment_request_qt" style="margin:10px 0 0 0;"/></td></tr>'
						+ '</tbody>' + '</table>' + '<br>' + '<hr>',
				type : 'blue',
				theme : 'modern',
				columnClass : 'col-md-12',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					var date = new Date();
					document
							.getElementById("create_check_entrustment_book_inspect_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
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
					'确认委托' : {
						btnClass : 'btn-blue',
						action : function() {
							addForensicCheckBook(jc);
							return false;
						}
					},
					'放弃委托' : function() {
					}
				}
			});
}

function addForensicCheckBook(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("保存成功");
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
	 * 
	 */

	/*
	 * 被鉴定人
	 */
	var create_check_entrustment_book_entrustmentor_name = document
			.getElementById("create_check_entrustment_book_entrustmentor_name");
	var create_check_entrustment_book_entrustmentor_sex = document
			.getElementById("create_check_entrustment_book_entrustmentor_sex");
	var create_check_entrustment_book_entrustmentor_phone = document
			.getElementById("create_check_entrustment_book_entrustmentor_phone");
	var create_check_entrustment_book_entrustmentor_age = document
			.getElementById("create_check_entrustment_book_entrustmentor_age");
	var create_check_entrustment_book_entrustmentor_unit = document
			.getElementById("create_check_entrustment_book_entrustmentor_unit");
	var create_check_entrustment_book_entrustmentor_address = document
			.getElementById("create_check_entrustment_book_entrustmentor_address");
	//
	formData.append(
			"tranceCheckBook.check_entrustment_book_entrustmentor_name",
			create_check_entrustment_book_entrustmentor_name.value);

	formData.append("tranceCheckBook.check_entrustment_book_entrustmentor_sex",
			create_check_entrustment_book_entrustmentor_sex.value);

	formData.append(
			"tranceCheckBook.check_entrustment_book_entrustmentor_phone",
			create_check_entrustment_book_entrustmentor_phone.value);

	formData.append("tranceCheckBook.check_entrustment_book_entrustmentor_age",
			create_check_entrustment_book_entrustmentor_age.value);

	formData.append(
			"tranceCheckBook.check_entrustment_book_entrustmentor_unit",
			create_check_entrustment_book_entrustmentor_unit.value);

	formData.append(
			"tranceCheckBook.check_entrustment_book_entrustmentor_address",
			create_check_entrustment_book_entrustmentor_address.value);

	/*
	 * 负责人
	 */
	var create_check_entrustment_book_responsible_person = document
			.getElementById("create_check_entrustment_book_responsible_person");
	if (create_check_entrustment_book_responsible_person.value == '') {
		toastr.error("负责人不可为空");
		return;
	}
	formData.append(
			"tranceCheckBook.check_entrustment_book_responsible_person",
			create_check_entrustment_book_responsible_person.value);
	/*
	 * 委托单位
	 */
	var create_check_entrustment_book_entrustment_unit = document
			.getElementById("create_check_entrustment_book_entrustment_unit");
	if (create_check_entrustment_book_entrustment_unit.value == '') {
		toastr.error("委托单位不可为空");
		return;
	}
	formData.append("tranceCheckBook.check_entrustment_book_entrustment_unit",
			create_check_entrustment_book_entrustment_unit.value);
	/*
	 * 委托时间
	 */
	var create_check_entrustment_book_inspect_time = document
			.getElementById("create_check_entrustment_book_inspect_time");
	formData.append("tranceCheckBook.check_entrustment_book_inspect_time",
			create_check_entrustment_book_inspect_time.value);
	/*
	 * 送检人
	 */
	var create_check_entrustment_book_inspectors1_name = document
			.getElementById("create_check_entrustment_book_inspectors1_name");
	formData.append("tranceCheckBook.check_entrustment_book_inspectors1_name",
			create_check_entrustment_book_inspectors1_name.value);
	var create_check_entrustment_book_inspectors2_name = document
			.getElementById("create_check_entrustment_book_inspectors2_name");
	formData.append("tranceCheckBook.check_entrustment_book_inspectors2_name",
			create_check_entrustment_book_inspectors2_name.value);
	var create_check_entrustment_book_inspectors1_duty = document
			.getElementById("create_check_entrustment_book_inspectors1_duty");
	formData.append("tranceCheckBook.check_entrustment_book_inspectors1_duty",
			create_check_entrustment_book_inspectors1_duty.value);
	var create_check_entrustment_book_inspectors2_duty = document
			.getElementById("create_check_entrustment_book_inspectors2_duty");
	formData.append("tranceCheckBook.check_entrustment_book_inspectors2_duty",
			create_check_entrustment_book_inspectors2_duty.value);
	var create_check_entrustment_book_inspectors1_jobcard_number = document
			.getElementById("create_check_entrustment_book_inspectors1_jobcard_number");
	formData
			.append(
					"tranceCheckBook.check_entrustment_book_inspectors1_jobcard_number",
					create_check_entrustment_book_inspectors1_jobcard_number.value);
	var create_check_entrustment_book_inspectors2_jobcard_number = document
			.getElementById("create_check_entrustment_book_inspectors2_jobcard_number");
	formData
			.append(
					"tranceCheckBook.check_entrustment_book_inspectors2_jobcard_number",
					create_check_entrustment_book_inspectors2_jobcard_number.value);
	/*
	 * 通讯地址
	 */
	var create_check_entrustment_book_communication_address = document
			.getElementById("create_check_entrustment_book_communication_address");
	formData.append(
			"tranceCheckBook.check_entrustment_book_communication_address",
			create_check_entrustment_book_communication_address.value);
	/*
	 * 邮政编码
	 */
	var create_check_entrustment_book_zip_code = document
			.getElementById("create_check_entrustment_book_zip_code");
	formData.append("tranceCheckBook.check_entrustment_book_zip_code",
			create_check_entrustment_book_zip_code.value);
	/*
	 * 联系电话
	 */
	var create_check_entrustment_book_phone = document
			.getElementById("create_check_entrustment_book_phone");
	formData.append("tranceCheckBook.check_entrustment_book_phone",
			create_check_entrustment_book_phone.value);
	/*
	 * 传真号码
	 */
	var create_check_entrustment_book_fax_num = document
			.getElementById("create_check_entrustment_book_fax_num");
	formData.append("tranceCheckBook.check_entrustment_book_fax_num",
			create_check_entrustment_book_fax_num.value);
	/*
	 * 被委托鉴定机构名称
	 */
	var create_check_entrustment_book_entrustment_unit_name = document
			.getElementById("create_check_entrustment_book_entrustment_unit_name");
	formData.append(
			"tranceCheckBook.check_entrustment_book_entrustment_unit_name",
			create_check_entrustment_book_entrustment_unit_name.value);
	/*
	 * 案（事）件名称
	 */
	var create_check_entrustment_book_case_name = document
			.getElementById("create_check_entrustment_book_case_name");
	formData.append("tranceCheckBook.check_entrustment_book_case_name",
			create_check_entrustment_book_case_name.value);
	/*
	 * 案件编号
	 */
	var create_check_entrustment_book_case_num = document
			.getElementById("create_check_entrustment_book_case_num");
	formData.append("tranceCheckBook.check_entrustment_book_case_num",
			create_check_entrustment_book_case_num.value);
	/*
	 * 简要案情
	 */
	var create_check_entrustment_book_simple_case_situation = document
			.getElementById("create_check_entrustment_book_simple_case_situation");
	formData.append(
			"tranceCheckBook.check_entrustment_book_simple_case_situation",
			create_check_entrustment_book_simple_case_situation.value);
	/*
	 * 原鉴定情况
	 */
	var create_check_entrustment_book_old_entrustment_situation = document
			.getElementById("create_check_entrustment_book_old_entrustment_situation");
	formData.append(
			"tranceCheckBook.check_entrustment_book_old_entrustment_situation",
			create_check_entrustment_book_old_entrustment_situation.value);
	/*
	 * 送检的检材和样本等情况（包括名称、数量、性状、包装，检材提取部位和方法等）
	 */
	var create_check_entrustment_book_sample_situation = document
			.getElementById("create_check_entrustment_book_sample_situation");
	formData.append("tranceCheckBook.check_entrustment_book_sample_situation",
			create_check_entrustment_book_sample_situation.value);
	/*
	 * 鉴定要求
	 */
	var create_check_entrustment_book_entrustment_request = document
			.getElementById("create_check_entrustment_book_entrustment_request");
	if (create_check_entrustment_book_entrustment_request.value == '其他') {
		formData
				.append(
						"tranceCheckBook.check_entrustment_book_entrustment_request",
						document
								.getElementById("create_check_entrustment_book_entrustment_request_qt").value);
	} else {
		formData.append(
				"tranceCheckBook.check_entrustment_book_entrustment_request",
				create_check_entrustment_book_entrustment_request.value);
	}

	/*
	 * 
	 */
	formData.append("tranceCheckBook.check_entrustment_book_type", '法医');
	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addCheckBook");
	xhr.send(formData);
}