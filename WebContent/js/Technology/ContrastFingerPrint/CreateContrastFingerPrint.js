function CreateContrastFingerPrint() {
	var jc = $
			.confirm({
				columnClass : 'col-md-9 col-md-offset-1',
				title : '比中指纹录入',
				content : '<table class="table table-hover table-bordered"><tbody>'
						+ '<tr><th>比中时间：</th><td><input type="text" id="input_contrast_fingerprint_time" class="form-control" /></td>'
						+ '<th><span style="color:red;">*&nbsp;</span>案件级别：</th><td><label style="margin:0 10px;" >'
						+ '<select class="form-control" id="select_contrast_fingerprint_level"><option value="A级" checked="checked">A级</option><option value="B级">B级</option><option value="C级">C级</option></select>'
						+ '</label></td>'
						+ '<th><span style="color:red;">*&nbsp;</span>对比方式：</th><td><label style="margin:0 10px;">'
						+ '<select class="form-control" id="select_contrast_fingerprint_way"><option value="正查">正查</option><option value="倒查">倒查</option><option value="人工">人工</option></select>'
						+ '</label></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>案件类型：</th><td><input type="text" id="input_case_type" class="form-control" /></td>'
						+ '<th>案件属地：</th>'
						+ '<td colspan="3"><label style="margin:0 10px;">'
						+ '<input type="radio" name="input_case_territorial"  checked="checked" value="本地">'
						+ '本地'
						+ '</label> '
						+ ' <label style="margin:0 10px;" >'
						+ '<input type="radio" name="input_case_territorial" value="外地">'
						+ '外地'
						+ '</label> '
						+ ' <label style="margin:0 10px;" >'
						+ '<input type="radio" name="input_case_territorial" value="公安部协查">'
						+ '公安部协查'
						+ '</label></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>现场指纹编号：</th><td><input type="text" id="input_locale_fingerprint_number" class="form-control" /></td>'
						+ '<th>按印指纹编号：</th><td colspan="3"><input type="text" id="input_press_fingerprint_number" class="form-control" /></td></tr>'
						+ '<th><span style="color:red;">*&nbsp;</span>简要案情：</th><td colspan="5"><textarea class="form-control" id="textarea_case_note" rows="5" style="resize:none;"></textarea></td></tr>'
						+ '<tr><th>嫌疑人姓名：</th><td><input type="text" id="input_suspecter_name" class="form-control" /></td>'
						+ '<th>性别：</th>'
						+ '<td><label style="margin:0 10px;">'
						+ '<input type="radio" name="input_suspecter_sex"  checked="checked" value="男">'
						+ '男'
						+ '</label> '
						+ ' <label style="margin:0 10px;" >'
						+ '<input type="radio" name="input_suspecter_sex" value="女">'
						+ '女'
						+ '</label></td>'
						+ '<th>是否抓获：</th><td><label style="margin:0 10px;">'
						+ '<select class="form-control" id="select_suspecter_arrested"><option value="是">是</option><option value="否">否</option></select>'
						+ '</label></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>身份证号码：</th><td><input type="text" id="input_suspecter_identity" class="form-control"  maxlength="18" onblur="ContrastFingerPrintGetBirth()"/></td>'
						+ '<th>出生日期：</th><td  colspan="3"><input type="text" id="input_suspecter_birthday" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>户籍地：</th><td><input type="text" id="input_suspecter_domicile" class="form-control" /></td>'
						+ '<th><span style="color:red;">*&nbsp;</span>现住址：</th><td colspan="3"><input type="text" id="input_present_address" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>按印部门：</th><td><input type="text" id="input_press_department" class="form-control" /></td>'
						+ '<th>提取部门：</th><td colspan="3"><input type="text" id="input_extract_department" class="form-control" /></td></tr>'
						+ '<tr><th>按印人：</th><td><input type="text" id="input_fingerprint_presser" class="form-control" /></td>'
						+ '<th>提取人：</th><td colspan="3"><input type="text" id="input_fingerprint_extracter" class="form-control" /></td></tr>'
						+ '<tr><th>按印时间：</th><td><input type="text" id="input_press_time" class="form-control" /></td>'
						+ '<th>指位：</th><td colspan="3"><input type="text" id="input_fingerprint_fingerposition" class="form-control" /></td></tr>'
						+ '<tr><th>对比单位：</th><td><input type="text" id="input_contrast_organization" class="form-control" /></td>'
						+ '<th>对比人：</th><td colspan="3"><input type="text" id="input_fingerprint_contraster" class="form-control" /></td></tr>'
						+ '<tr><th>复核人：</th><td><input type="text" id="input_fingerprint_reviewer" class="form-control" /></td>'
						+ '<th>抓获单位：</th><td colspan="3"><input type="text" id="input_arrested_organization" class="form-control" /></td></tr>'
						+ '<tr><th>抓获时间：</th><td><input type="text" id="input_arrested_time" class="form-control" /></td>'
						+ '<th>联系电话：</th><td colspan="3"><input type="text" id="input_contract_number" class="form-control" /></td></tr>'
						+ '<tr><th>备注：</th><td colspan="5"><textarea class="form-control" id="textarea_fingerprint_remark" rows="5" style="resize:none;"></textarea></td></tr>'
						+ '</tbody></table>',
				buttons : {
					创建 : function() {
						/*
						 * 对比方式（下拉）、现场指纹编号、案件类型、案件级别（下拉）、简要案情不为空 户籍地、现住址不为空
						 * 按印部门不为空
						 */
						// 比中时间
						var input_contrast_fingerprint_time = document
								.getElementById("input_contrast_fingerprint_time").value;
						// 对比方式(下拉)

						// 按印指纹编号
						var input_press_fingerprint_number = document
								.getElementById("input_press_fingerprint_number").value;
						// 案件属地（单选框）
						// 案件级别(下拉)

						// 案件类型
						var input_case_type = document
								.getElementById("input_case_type").value;
						if (input_case_type == "") {
							toastr.error("案件类型不能为空！");
							return false;
						}
						// 现场指纹编号
						var input_locale_fingerprint_number = document
								.getElementById("input_locale_fingerprint_number").value;
						if (input_locale_fingerprint_number == "") {
							toastr.error("现场指纹编号不能为空！");
							return false;
						}
						// 简要案情
						var textarea_case_note = document
								.getElementById("textarea_case_note").value;
						if (textarea_case_note == "") {
							toastr.error("简要案情不能为空！");
							return false;
						}
						// 嫌疑人姓名
						var input_suspecter_name = document
								.getElementById("input_suspecter_name").value;
						// 性别（单选框）
						// 出生日期
						var input_suspecter_birthday = document
								.getElementById("input_suspecter_birthday").value;
						// 身份证号码
						var input_suspecter_identity = document
								.getElementById("input_suspecter_identity").value;
						if (input_suspecter_identity.value== "") {
							toastr.error("身份证号不能为空！");
							return false;
						}else{
							//判断身份证号并获取出生日期
							var result=ContrastFingerPrintGetBirth();
							if(result==false){
								return false;
							}
						}
						// 是否抓获（下拉）
						// 户籍地
						var input_suspecter_domicile = document
								.getElementById("input_suspecter_domicile").value;
						if (input_suspecter_domicile == "") {
							toastr.error("户籍地不能为空！");
							return false;
						}
						// 现住址
						var input_present_address = document
								.getElementById("input_present_address").value;
						if (input_present_address == "") {
							toastr.error("现住址不能为空！");
							return false;
						}
						// 按印部门
						var input_press_department = document
								.getElementById("input_press_department").value;
						if (input_press_department == "") {
							toastr.error("按印部门不能为空！");
							return false;
						}
						// 提取部门
						var input_extract_department = document
								.getElementById("input_extract_department").value;
						// 按印人
						var input_fingerprint_presser = document
								.getElementById("input_fingerprint_presser").value;
						// 按印时间
						var input_press_time = document
								.getElementById("input_press_time").value;
						// 提取人
						var input_fingerprint_extracter = document
								.getElementById("input_fingerprint_extracter").value;
						// 指位
						var input_fingerprint_fingerposition = document
								.getElementById("input_fingerprint_fingerposition").value;
						// 对比单位
						var input_contrast_organization = document
								.getElementById("input_contrast_organization").value;
						// 对比人
						var input_fingerprint_contraster = document
								.getElementById("input_fingerprint_contraster").value;
						// 复核人
						var input_fingerprint_reviewer = document
								.getElementById("input_fingerprint_reviewer").value;
						// 抓获单位
						var input_arrested_organization = document
								.getElementById("input_arrested_organization").value;
						// 抓获时间
						var input_arrested_time = document
								.getElementById("input_arrested_time").value;
						// 联系电话
						var input_contract_number = document
								.getElementById("input_contract_number").value;
						// 备注
						var textarea_fingerprint_remark = document
								.getElementById("textarea_fingerprint_remark").value;

						var formData = new FormData();
						var xhr = false;
						xhr = new XMLHttpRequest();

						xhr.onreadystatechange = function() {
							if (xhr.readyState == 4) {
								if (xhr.status == 200) {
									/*
									 * responseText的值为1代表创建成功 2代表创建失败
									 */
									if (xhr.responseText == "1") {
										// jc.close();
										toastr.success("比中指纹录入成功！");
										List_ContrastFingerPrint_By_PageAndSearch(1);
									}
								} else {
									toastr.error(xhr.status);
								}
							}
						}
						// 比中时间
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_time",
										input_contrast_fingerprint_time);
						// 案件级别（下拉）
						var select_contrast_fingerprint_level = document
								.getElementById("select_contrast_fingerprint_level");
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_level",
										select_contrast_fingerprint_level.value);

						// 对比方式（下拉）
						var select_contrast_fingerprint_way = document
								.getElementById("select_contrast_fingerprint_way");
						formData.append(
								"contrastFingerPrint.contrast_fingerprint_way",
								select_contrast_fingerprint_way.value);

						// 案件类型
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_case_type",
										input_case_type);
						// 案件属地（单选框）

						var input_case_territorial = document
								.getElementsByName("input_case_territorial");
						for (var num = 0; num < 3; num++) {
							if (input_case_territorial[num].checked) {
								formData
										.append(
												"contrastFingerPrint.contrast_fingerprint_case_territorial",
												input_case_territorial[num].value);
							}
						}
						// 现场指纹编号
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_locale_fingerprint_number",
										input_locale_fingerprint_number);
						// 按印指纹编号
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_press_fingerprint_number",
										input_press_fingerprint_number);
						// 简要案情
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_case_note",
										textarea_case_note);
						// 嫌疑人姓名
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_suspecter_name",
										input_suspecter_name);
						// 性别（单选框）

						var input_suspecter_sex = document
								.getElementsByName("input_suspecter_sex");
						for (var num = 0; num < 2; num++) {
							if (input_suspecter_sex[num].checked) {
								formData
										.append(
												"contrastFingerPrint.contrast_fingerprint_suspecter_sex",
												input_suspecter_sex[num].value);
							}
						}

						// 是否抓获（下拉）
						var select_suspecter_arrested = document
								.getElementById("select_suspecter_arrested");

						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_suspecter_arrested",
										select_suspecter_arrested.value);

						// 出生日期
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_suspecter_birthday",
										input_suspecter_birthday);
						// 身份证号
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_suspecter_identity",
										input_suspecter_identity);
						// 户籍地
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_suspecter_domicile",
										input_suspecter_domicile);
						// 现住址
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_present_address",
										input_present_address);
						// 按印部门
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_press_department",
										input_press_department);
						// 提取部门
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_extract_department",
										input_extract_department);
						// 按印人
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_presser",
										input_fingerprint_presser);
						// 提取人
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_extracter",
										input_fingerprint_extracter);
						// 按印时间
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_press_time",
										input_press_time);
						// 指位
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_fingerposition",
										input_fingerprint_fingerposition);
						// 对比单位
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_contrast_organization",
										input_contrast_organization);
						// 对比人
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_contraster",
										input_fingerprint_contraster);
						// 复核人
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_reviewer",
										input_fingerprint_reviewer);
						// 抓获单位
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_arrested_organization",
										input_arrested_organization);
						// 抓获时间
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_arrested_time",
										input_arrested_time);
						// 联系电话
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_contract_number",
										input_contract_number);
						// 备注
						formData
								.append(
										"contrastFingerPrint.contrast_fingerprint_remark",
										textarea_fingerprint_remark);
						console.debug("formData:" + formData);
						xhr
								.open("POST",
										"/xsjsglxt/ContrastFingerPrint/ContrastFingerPrintManagement_CreateContrast");
						xhr.send(formData);
					},
					取消 : function() {
					}
				},
				onContentReady : function() {
					// 执行一个laydate实例
					
					laydate.render({
						elem : '#input_contrast_fingerprint_time',// 指定元素比中时间
						value : new Date()
					});
					laydate.render({
						elem : '#input_press_time',// 指定元素按印时间
						value : new Date()
					});
					laydate.render({
						elem : '#input_arrested_time',// 指定元素抓获时间
						value : new Date()
					});
				}
			});

}