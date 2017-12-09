/*
 * 受理任务书
 */
function Acceptance_EntrustmentBook(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				/* theme : 'Modern', */
				icon : 'fa fa-map-o',
				title : '受理委托书',
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
					var con = '<input value="'
							+ obj.id
							+ '"  class="form-control" id="create_identifieder_case_confirm_book_belong_entrustment_book" style="display:none;"/>'
							+ '<h4>受理后，将自动生成《鉴定事项确认书》以及《受理鉴定回执》。</h4>'
							+ '<hr>'
							+ '<label style="margin:0 10px;">'
							+ '<input type="radio" name="123" value="1" checked="checked">'
							+ '有受理编号'
							+ '</label> '
							+ ' <label style="margin:0 10px;" >'
							+ '<input type="radio" name="123" value="2" >'
							+ '无受理编号'
							+ '</label>'
							+ '<br>'
							+ '<br>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr>'
							+ '<td style="width:200px;"  rowspan="3" >双方对鉴定时限以及送检检材样本等使用和取回的约定</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>送检人：</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_name
							+ '、'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_name
							+ '</td>'
							+ '<td><span style="color:#D9534F;">*</span> 受理人：</td><td><input class="form-control" id=""/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>送检日期：</td><td><input class="form-control mydate" id="create_identifieder_case_confirm_book_inspection_date"/></td>'
							+ '<td>受理日期：</td><td><input class="form-control mydate" id="create_identifieder_case_confirm_book_acceptance_date"/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td   rowspan="3" style="width:200px;">鉴定文书和相关检材等的领取情况</td>'
							+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>领取人：</td><td><input class="form-control" id=""/></td>'
							+ '<td>鉴定机构经办人：</td><td><input class="form-control" id=""/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td></td><td></td>'
							+ '<td>领取日期：</td><td><input class="form-control mydate" id=""/></td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td>备注：</td><td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" id="create_identifieder_case_confirm_book_mark"></textarea></td>'
							+ '</tr>' + '</tbody>' + '</table>' + '<hr>';
					jc.setContentAppend(con);
					/*
					 * 初始化日期
					 */
					var date = new Date();
					document
							.getElementById("create_identifieder_case_confirm_book_acceptance_date").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate() + '';
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
					/*
					 * 
					 */
					$('input').iCheck({
						checkboxClass : 'icheckbox_square-blue',
						radioClass : 'iradio_square-blue',
						increaseArea : '20%',
					});
				},
				buttons : {
					'确认受理' : {
						btnClass : 'btn-blue',
						action : function() {
							SureAcceptance(jc);
						}
					},
					'放弃受理' : function() {
					}
				}
			});
}

function SureAcceptance(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("受理成功");
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
	var create_identifieder_case_confirm_book_belong_entrustment_book = document
			.getElementById("create_identifieder_case_confirm_book_belong_entrustment_book");
	formData
			.append(
					"identifiederCaseConfirmBook.identifieder_case_confirm_book_belong_entrustment_book",
					create_identifieder_case_confirm_book_belong_entrustment_book.value);
	/*
	 * 备注
	 */
	var create_identifieder_case_confirm_book_mark = document
			.getElementById("create_identifieder_case_confirm_book_mark");
	formData.append(
			"identifiederCaseConfirmBook.identifieder_case_confirm_book_mark",
			create_identifieder_case_confirm_book_mark.value);
	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addConfirmBook");
	xhr.send(formData);
}