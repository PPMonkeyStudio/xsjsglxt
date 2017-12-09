/*
 * 损伤鉴定
 */
function Create_Damage_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-pencil-square-o',
				title : '记录损伤检验过程',
				content : '<input value="'
						+ obj.id
						+ '"  class="form-control" id="create_inspection_belong_entrustment_book" style="display:none;"/>'
						+ '<hr>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr>'
						+ '<td>姓名：</td>'
						+ '<td><input  class="form-control" id="create_" /></td>'
						+ '<td>性别：</td>'
						+ '<td><select class="form-control" id="create_">'
						+ '<option value="男">男</option>'
						+ '<option value="女">女</option>'
						+ '</select></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>出生日期：</td>'
						+ '<td><input  class="form-control mydate" id="create_" /></td>'
						+ '<td>职业：</td>'
						+ '<td><input  class="form-control" id="create_" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>服务处所：</td>'
						+ '<td><input  class="form-control" id="create_" /></td>'
						+ '<td>身份证号码：</td>'
						+ '<td><input  class="form-control" id="create_" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>受伤时间：</td>'
						+ '<td><input  class="form-control mydate" id="create_damage_damage_time" /></td>'
						+ '<td>检验时间：</td>'
						+ '<td><input  class="form-control mydate" id="create_damage_inspection_record_time" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>住址：</td>'
						+ '<td><input  class="form-control" id="create_" /></td>'
						+ '<td>联系方式：</td>'
						+ '<td><input  class="form-control" id="create_" /></td>'
						+ '</tr>'
						+ '<tr><td>检验所见：</td>'
						+ '<td colspan="3"><textarea class="form-control" style="resize: none;height:100px;" id="create_"></textarea></td>'
						+ '</tr>' + '</tr>' + '</tbody>' + '</table>' + '<hr>',
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

					/*
					 * 
					 */
					var date = new Date();
					document.getElementById("create_damage_damage_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
					document
							.getElementById("create_damage_inspection_record_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
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
						minDate : '1900/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});
					/*
					 * 
					 */

				},
				buttons : {
					'记录' : {
						btnClass : 'btn-blue',
						action : function() {
							addDamageInspectionRecord(jc);
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function addDamageInspectionRecord(jc) {
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
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addInspectionRecord");
	xhr.send(formData);
}