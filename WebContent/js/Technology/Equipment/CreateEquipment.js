function CreateEquipment() {
	var jc = $
			.confirm({
				columnClass : 'col-md-6 col-md-offset-3',
				title : '器材装备录入',
				content : '<table class="table table-hover"><tbody>'
						+ '<tr><th>装备序号：</th><td><input type="text" id="input_serial_number" class="form-control" /></td></tr>'
						+ '<tr><th>装备名称：</th><td><input type="text" id="input_name" class="form-control" /></td></tr>'
						+ '<tr><th>装备类型：</th><td><input type="text" id="input_type" class="form-control" /></td></tr>'
						+ '<tr><th>装备特征：</th>'
						+ '<td><label style="margin:0 10px 0 0;">'
						+ '<select id="select_feature"><option value="不限">不限</option><option value="痕迹">痕迹</option ><option value="法医">法医</option ><option value="影像">影像</option><option value="技管">技管</option><option value="其他">其他</option></select>'
						+ '</label> '
						+ ' <label style="margin:0 10px;">'
						+ '<input type="text" id="input_feature" class="form-control" />'
						+ '</label></td></tr>'
						+ '<tr><th>数量：</th><td><input type="text" id="input_number" class="form-control" /></td></tr>'
						+ '<tr><th>金额：</th><td><input type="text" id="input_money" class="form-control" /></td></tr>'
						+ '<tr><th>启用日期：</th><td><input type="text" id="input_enablement_time" class="form-control" /></td></tr>'
						+ '<tr><th>使用情況：</th>'
						+ '<td><label style="margin:0 10px;">'
						+ '<input type="radio" name="input_use_note"  checked="checked" value="正常">'
						+ '正常'
						+ '</label> '
						+ ' <label style="margin:0 10px;" >'
						+ '<input type="radio" name="input_use_note" value="报废">'
						+ '报废'
						+ '</label></td></tr>'
						+ '<tr><th>备注：</th><td><textarea class="form-control" id="textarea_remark" rows="5" style="resize:none;"></textarea></td></tr>'
						+ '</tbody></table>',
				buttons : {
					创建 : function() {

						var input_serial_number = document
								.getElementById("input_serial_number");
						var input_name = document.getElementById("input_name");
						var input_type = document.getElementById("input_type");
						var select_feature = document
								.getElementById("select_feature");
						var input_feature = document
								.getElementById("input_feature");
						var input_number = document
								.getElementById("input_number");
						var input_money = document
								.getElementById("input_money");
						var input_enablement_time = document
								.getElementById("input_enablement_time");
						var textarea_remark = document
								.getElementById("textarea_remark");
						/*
						 * 装备序号、装备名称、装备类型、金额、使用情况不能为空
						 */
						if (input_serial_number.value == "") {
							toastr.error("装备序号不能为空！");
							return false;
						}
						if (input_name.value == "") {
							toastr.error("装备名称不能为空！");
							return false;
						}

						if (input_type.value == "") {
							toastr.error("装备类型不能为空！");
							return false;
						}
						if (input_money.value == "") {
							toastr.error("金额不能为空！");
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
										toastr.success("器材装备录入成功！");
										List_Equipment_By_PageAndSearch(1);
									}
								} else {
									toastr.error(xhr.status);
								}
							}
						}
						formData.append("equipment.equipment_serial_number",
								input_serial_number.value);
						formData.append("equipment.equipment_name",
								input_name.value);
						formData.append("equipment.equipment_type",
								input_type.value);
						var select_feature = document
								.getElementById("select_feature");
						if(select_feature.value=="其他"){
							formData.append("equipment.equipment_feature",
									input_feature.value);
						}
						else{
							formData.append("equipment.equipment_feature",
									select_feature.value);
						}
						
						formData.append("equipment.equipment_number",
								input_number.value);
						formData.append("equipment.equipment_money",
								input_money.value);

						formData.append("equipment.equipment_enablement_time",
								input_enablement_time.value);
						var input_use_note = document
								.getElementsByName("input_use_note");
						for (var num = 0; num < 2; num++) {
							if (input_use_note[num].checked) {
								formData.append("equipment.equipment_use_note",
										input_use_note[num].value);
							}
						}
						formData.append("equipment.equipment_remark",
								textarea_remark.value);

						xhr
								.open("POST",
										"/xsjsglxt/Equipment/EquipmentManagement_CreateEquipment");
						xhr.send(formData);

					},
					取消 : function() {

					}
				}
			});

}