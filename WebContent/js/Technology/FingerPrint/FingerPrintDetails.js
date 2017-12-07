function FingerPrintDetails(button) {
	var jc = $
			.confirm({
				columnClass : 'col-md-6 col-md-offset-3',
				title : '指纹信息详情',
				content : '<table class="table table-hover"><tbody>'
						+ '<tr style="display:none;"><th>指纹id：</th><td><input   type="text" id="input_finger_id" class="form-control"/></td></tr>'
						+ '<tr><th>指纹编号：</th><td><input type="text" id="input_finger_number" class="form-control" disabled /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>姓名：</th><td><input type="text" id="input_name" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>性别：</th>'
						+ '<td><label style="margin:0 10px;">'
						+ '<input type="radio" name="input_sex" value="男">'
						+ '男'
						+ '</label> '
						+ ' <label style="margin:0 10px;" >'
						+ '<input type="radio" name="input_sex" value="女">'
						+ '女'
						+ '</label></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>身份证号：</th><td><input type="text" id="input_IDCard" class="form-control" maxlength="18" onblur="FingerPrintGetBirth()" /></td></tr>'
						+ '<tr><th>出生日期：</th><td><input type="text" id="input_birth" class="form-control" /></td></tr>'
						+ '<tr><th>住址：</th><td><input type="text" id="input_address" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>违法事实：</th><td><input type="text" id="input_illegalFact" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>建档单位：</th><td><input type="text" id="input_inputtingUnit" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>建档人：</th><td><input type="text" id="input_inputtingPerson" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>建档时间：</th><td><input type="text" id="input_inputtingTime" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>交档时间：</th><td><input type="text" id="input_makingTime"  class="form-control" /></td></tr>'
						+ '<tr><th>备注：</th><td><textarea class="form-control" id="textarea_remark" rows="5" style="resize:none;"></textarea></td></tr>'
						+ '</tbody></table>',
				buttons : {
					修改 : function() {
						var input_finger_id = document
								.getElementById("input_finger_id");
						var input_finger_number = document
								.getElementById("input_finger_number");
						var input_name = document.getElementById("input_name");
						var input_birth = document
								.getElementById("input_birth");
						var input_IDCard = document
								.getElementById("input_IDCard");
						var input_address = document
								.getElementById("input_address");
						var input_illegalFact = document
								.getElementById("input_illegalFact");
						var input_inputtingUnit = document
								.getElementById("input_inputtingUnit");
						var input_inputtingPerson = document
								.getElementById("input_inputtingPerson");
						var input_inputtingTime = document
								.getElementById("input_inputtingTime");
						var input_makingTime = document
								.getElementById("input_makingTime");
						var textarea_remark = document
								.getElementById("textarea_remark");
						/*
						 * 姓名、性别、身份证号、出生日期、违法事实、建档单位、建档人、建档时间、交档事件不为空
						 */
						if (input_name.value == "") {
							toastr.error("姓名不能为空！");
							return false;
						}
						if (input_IDCard.value == "") {
							toastr.error("身份证号不能为空！");
							return false;
						}else{
							//判断身份证号并获取出生日期
							var result=FingerPrintGetBirth();
							if(result==false){
								return false;
							}
						}
						/*if (input_birth.value == "") {
							toastr.error("出生日期不能为空！");
							return false;
						}*/
						if (input_illegalFact.value == "") {
							toastr.error("违法事实不能为空！");
							return false;
						}
						if (input_inputtingUnit.value == "") {
							toastr.error("建档单位不能为空！");
							return false;
						}
						if (input_inputtingPerson.value == "") {
							toastr.error("建档人不能为空！");
							return false;
						}
						if (input_inputtingTime.value == "") {
							toastr.error("建档时间不能为空！");
							return false;
						}
						if (input_makingTime.value == "") {
							toastr.error("交档时间不能为空！");
							return false;
						}
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
										toastr.success("指纹信息修改成功！");
										List_FingerPrint_By_PageAndSearch(1);
									}
								} else {
									toastr.error(xhr.status);
								}
							}
						}
						formData.append("fingerprint.xsjsglxt_fingerprint_id",
								input_finger_id.value);
						formData.append("fingerprint.fingerprint_num",
								input_finger_number.value);
						formData.append("fingerprint.fingerprint_name",
								input_name.value);
						var input_sex = document.getElementsByName("input_sex");
						for (var num = 0; num < 2; num++) {
							if (input_sex[num].checked) {
								formData.append("fingerprint.fingerprint_sex",
										input_sex[num].value);
							}
						}
						formData.append("fingerprint.fingerprint_birthday",
								input_birth.value);
						formData.append("fingerprint.fingerprint_identity",
								input_IDCard.value);
						formData.append("fingerprint.fingerprint_address",
								input_address.value);
						formData.append("fingerprint.fingerprint_illegal_fact",
								input_illegalFact.value);
						formData.append(
								"fingerprint.fingerprint_record_organization",
								input_inputtingUnit.value);
						formData.append("fingerprint.fingerprint_organizer",
								input_inputtingPerson.value);
						formData.append("fingerprint.fingerprint_record_time",
								input_inputtingTime.value);
						formData.append("fingerprint.fingerprint_submit_time",
								input_makingTime.value);
						formData.append("fingerprint.fingerprint_remark",
								textarea_remark.value);

						xhr
								.open("POST",
										"/xsjsglxt/FingerPrint/FingerPrintManagement_modifiedFingerPrint");
						xhr.send(formData);

					},
					取消 : function() {

					}
				},
				onContentReady : function() {
					var button_id = button.id;
					for (var num = 0; num < fingerPrint_VO.list_xsjsglxt_fingerprint.length; num++) {
						var xsjsglxt_fingerprint_id = fingerPrint_VO.list_xsjsglxt_fingerprint[num].xsjsglxt_fingerprint_id;

						if (xsjsglxt_fingerprint_id == button_id) {
							console
									.debug("xsjsglxt_fingerprint_id:"
											+ fingerPrint_VO.list_xsjsglxt_fingerprint[num].xsjsglxt_fingerprint_id);
							var input_finger_id = document
									.getElementById("input_finger_id");
							input_finger_id.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].xsjsglxt_fingerprint_id;
							var input_finger_number = document
									.getElementById("input_finger_number");
							input_finger_number.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_num;

							var input_name = document
									.getElementById("input_name");
							input_name.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_name;

							var input_sex = document
									.getElementsByName("input_sex");
							var sex_value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_sex;
							for (var i = 0; i < input_sex.length; i++) {
								if (sex_value == "男") {
									input_sex[0].checked = "checked";
								} else {
									input_sex[1].checked = "checked";
								}
							}

							var input_birth = document
									.getElementById("input_birth");
							input_birth.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_birthday;

							var input_IDCard = document
									.getElementById("input_IDCard");
							input_IDCard.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_identity;

							var input_address = document
									.getElementById("input_address");
							input_address.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_address;

							var input_illegalFact = document
									.getElementById("input_illegalFact");
							input_illegalFact.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_illegal_fact;

							var input_inputtingUnit = document
									.getElementById("input_inputtingUnit");
							input_inputtingUnit.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_record_organization;

							var input_inputtingPerson = document
									.getElementById("input_inputtingPerson");
							input_inputtingPerson.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_organizer;

							var input_inputtingTime = document
									.getElementById("input_inputtingTime");
							input_inputtingTime.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_record_time;

							var input_makingTime = document
									.getElementById("input_makingTime");
							input_makingTime.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_submit_time;

							var textarea_remark = document
									.getElementById("textarea_remark");
							textarea_remark.value = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_remark;
							if (textarea_remark.value == "undefined") {
								textarea_remark.value = "";
							}

						}
					} 
					// 执行一个laydate实例
					laydate.render({
						elem : '#input_inputtingTime' ,// 指定元素建档时间
					});
					laydate.render({
						elem : '#input_makingTime' ,// 指定元素交档时间
					});
				}
			});
}