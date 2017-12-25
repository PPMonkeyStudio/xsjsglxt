function CreateDNA() {
	var jc = $
			.confirm({
				columnClass : 'col-md-6 col-md-offset-3',
				title : 'DNA信息录入',
				content : '<table class="table table-hover"><tbody>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>姓名：</th><td><input type="text" id="input_name" class="form-control" /></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>性别：</th>'
						+ '<td><label style="margin:0 10px;">'
						+ '<input type="radio" name="input_sex"  checked="checked" value="男">'
						+ '男'
						+ '</label> '
						+ ' <label style="margin:0 10px;" >'
						+ '<input type="radio" name="input_sex" value="女">'
						+ '女'
						+ '</label></td></tr>'
						+ '<tr><th><span style="color:red;">*&nbsp;</span>身份证号：</th><td><input type="text" id="input_IDCard" class="form-control" maxlength="18" onblur="DNAGetBirth()" /></td></tr>'
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
					创建 : function() {

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
							var result=DNAGetBirth();
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
										toastr.success("DNA信息录入成功！");
										List_DNA_By_PageAndSearch(1);
									}
								} else {
									toastr.error(xhr.status);
								}
							}
						}

						formData.append("dna.dna_name", input_name.value);
						var input_sex = document.getElementsByName("input_sex");
						for (var num = 0; num < 2; num++) {
							if (input_sex[num].checked) {
								formData.append("dna.dna_sex",
										input_sex[num].value);
							}
						}
						formData.append("dna.dna_birthday", input_birth.value);
						formData.append("dna.dna_identity", input_IDCard.value);
						formData.append("dna.dna_address", input_address.value);
						formData.append("dna.dna_illegal_fact",
								input_illegalFact.value);
						formData.append("dna.dna_record_organization",
								input_inputtingUnit.value);
						formData.append("dna.dna_organizer",
								input_inputtingPerson.value);
						formData.append("dna.dna_record_time",
								input_inputtingTime.value);
						formData.append("dna.dna_submit_time",
								input_makingTime.value);
						formData
								.append("dna.dna_remark", textarea_remark.value);

						xhr.open("POST",
								"/xsjsglxt/DNA/DNAManagement_CreateDNA");
						xhr.send(formData);

					},
					取消 : function() {

					}
				},
				onContentReady : function() {
					// 执行一个laydate实例
					laydate.render({
						elem : '#input_inputtingTime' ,// 指定元素建档时间
							value : new Date()
					});
					laydate.render({
						elem : '#input_makingTime' ,// 指定元素交档时间
							value : new Date()
					});
				}
			});

}