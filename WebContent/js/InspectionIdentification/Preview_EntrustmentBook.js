function Preview_EntrustmentBook(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-file-text-o',
				title : '鉴定委托书',
				content : '',
				type : 'green',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}
					var con = '<div style="margin:0 20px 0 0;"><hr>' + '<br>'
							+ '<h5 style="text-align: right;">编号：【'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(0, 4)
							+ '】第'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
									.substring(4)
							+ '号</h5>'
							+ '<table  class="table table-bordered" style="text-align: center;">'
							+ '<tbody>'
							+ '<tr><td colspan="2">鉴定委托单位</td><td colspan="4">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit
							+ '</td><td colspan="2">委托时间</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time
							+ '</td></tr>'
							+ '<tr><td rowspan="4">送检人</td><td>姓名</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_name
							+ '</td><td>职务</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_duty
							+ '</td><td colspan="2">证件名称及号码</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors1_jobcard_number
							+ '</td></tr>'
							+ '<tr><td>姓名</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_name
							+ '</td><td>职务</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_duty
							+ '</td><td colspan="2">证件名称及号码</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspectors2_jobcard_number
							+ '</td></tr>'
							+ '<tr><td>通讯地址</td><td colspan="4">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_communication_address
							+ '</td><td  colspan="2">邮政编码</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_zip_code
							+ '</td></tr>'
							+ '<tr><td>联系电话</td><td colspan="4">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_phone
							+ '</td><td  colspan="2">传真号码</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_fax_num
							+ '</td></tr>'
							+ '<tr><td colspan="2">鉴定机构名称</td><td colspan="7">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit_name
							+ '</tr>'
							+ '<tr><td colspan="2">案（事）件名称</td><td colspan="3">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_name
							+ '<td colspan="2">案件编号</td><td colspan="2">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_num
							+ '</td></tr>'
							+ '<tr><td rowspan="2">被鉴定人的情况</td><td>姓名</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_name
							+ '</td><td>性别</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_sex
							+ '</td><td>年龄</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_sex
							+ '</td><td>电话</td><td>'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_phone
							+ '</td></tr>'
							+ '<tr><td>单位</td><td colspan="3">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_unit
							+ '</td><td>住址</td><td colspan="3">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_address
							+ '</td></tr>'
							+ '<tr><td colspan="1">案（事）件简要情况</td><td colspan="8">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation
							+ '</tr>'
							+ '<tr><td colspan="1">原鉴定情况</td><td colspan="8">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_old_entrustment_situation
							+ '</td></tr>'
							+ '<tr><td colspan="1">送检的检材和样本等情况（包括名称、数量、性状、包装，检材提取部位和方法等）</td><td colspan="8">'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_sample_situation
							+ '</td></tr>'
							+ '<tr><td colspan="1">委托鉴定单位的鉴定要求和诚信声明</td><td colspan="8" style="text-align: left;">鉴定要求：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request
							+ '<br><br>负责人签字：'
							+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_responsible_person
							+ '</td></tr>'
							+ '</tbody>'
							+ '</table>'
							+ '<br>'
							+ '<hr></div>';
					jc.setContentAppend(con);
				},
				buttons : {
					'导出' : {
						btnClass : 'btn-green',
						action : function() {
							return false;
						}
					},
					'修改' : {
						btnClass : 'btn-orange',
						action : function() {
							jc.close();
							Update_EntrustmentBook(obj);
						}
					},
					'放弃' : function() {
					}
				}
			});
}