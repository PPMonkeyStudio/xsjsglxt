/*
 * 记录检验记录
 */
function Create_InspectionRecord(obj) {
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-pencil-square-o',
				title : '记录检验过程',
				content : '<input value="'
						+ obj.id
						+ '"  class="form-control" id="create_inspection_belong_entrustment_book" style="display:none;"/>'
						+ '<hr>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验人：</td>'
						+ '<td><input  class="form-control" id="create_inspection_people" /></td>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验时间：</td>'
						+ '<td><input  class="form-control" id="create_inspection_time" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验地点：</td>'
						+ '<td><input  class="form-control" id="create_inspection_location" /></td>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验设备：</td>'
						+ '<td><select class="form-control" id="create_inspection_equipment">'
						+ '<option value="LED光源">LED光源</option>'
						+ '<option value="立体显微镜">立体显微镜</option>'
						+ '<option value="扫描仪">扫描仪</option>'
						+ '<option value="比例尺">比例尺</option>'
						+ '<option value="其他">其他</option>'
						+ '</select><input  class="form-control" id="create_inspection_equipment_qt" style="margin:10px 0 0 0;"/></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td>检材情况：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_inspection_check_material_situation"></textarea></td></tr>'
						+ '<tr><td>样本情况：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_inspection_sample_situation"></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验方法：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_inspection_method"></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验过程：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_inspection_process"></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验意见：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_inspection_option"></textarea></td></tr>'
						+ '<tr><td>备注：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="create_inspection_mark"></textarea></td></tr>'
						+ '</tbody>' + '</table>' + '<br>' + '<hr>',
				type : 'blue',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					var date = new Date();
					document.getElementById("create_inspection_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate()
							+ ' 至 '
							+ date.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
				},
				buttons : {
					'记录' : {
						btnClass : 'btn-blue',
						action : function() {
							addInspectionRecord(jc);
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function addInspectionRecord(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("记录成功");
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
	var create_inspection_belong_entrustment_book = document
			.getElementById("create_inspection_belong_entrustment_book");
	formData.append("inspectionRecord.inspection_belong_entrustment_book",
			create_inspection_belong_entrustment_book.value);
	/*
	 * 检验人
	 */
	var create_inspection_people = document
			.getElementById("create_inspection_people");
	formData.append("inspectionRecord.inspection_people",
			create_inspection_people.value);
	/*
	 * 检验时间
	 */
	var create_inspection_time = document
			.getElementById("create_inspection_time");
	formData.append("inspectionRecord.inspection_time",
			create_inspection_time.value);
	/*
	 * 检验地点
	 */
	var create_inspection_location = document
			.getElementById("create_inspection_location");
	formData.append("inspectionRecord.inspection_location",
			create_inspection_location.value);
	/*
	 * 检验设备
	 */
	var create_inspection_equipment = document
			.getElementById("create_inspection_equipment");
	if (create_inspection_equipment.value == "其他") {
		var create_inspection_equipment_qt = document
				.getElementById("create_inspection_equipment_qt");
		formData.append("inspectionRecord.inspection_equipment",
				create_inspection_equipment_qt.value);
	} else {
		formData.append("inspectionRecord.inspection_equipment",
				create_inspection_equipment.value);
	}

	/*
	 * 检材情况
	 */
	var create_inspection_check_material_situation = document
			.getElementById("create_inspection_check_material_situation");
	formData.append("inspectionRecord.inspection_check_material_situation",
			create_inspection_check_material_situation.value);
	/*
	 * 样本情况
	 */
	var create_inspection_sample_situation = document
			.getElementById("create_inspection_sample_situation");
	formData.append("inspectionRecord.inspection_sample_situation",
			create_inspection_sample_situation.value);
	/*
	 * 检验方法
	 */
	var create_inspection_method = document
			.getElementById("create_inspection_method");
	formData.append("inspectionRecord.inspection_method",
			create_inspection_method.value);
	/*
	 * 检验过程
	 */
	var create_inspection_process = document
			.getElementById("create_inspection_process");
	formData.append("inspectionRecord.inspection_process",
			create_inspection_process.value);
	/*
	 * 检验意见
	 */
	var create_inspection_option = document
			.getElementById("create_inspection_option");
	formData.append("inspectionRecord.inspection_option",
			create_inspection_option.value);
	/*
	 * 备注
	 */
	var create_inspection_mark = document
			.getElementById("create_inspection_mark");
	formData.append("inspectionRecord.inspection_mark",
			create_inspection_mark.value);
	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addInspectionRecord");
	xhr.send(formData);
}