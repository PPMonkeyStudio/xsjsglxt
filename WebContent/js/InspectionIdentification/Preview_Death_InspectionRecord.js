function Preview_Death_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $.confirm({
		theme : 'Modern',
		icon : 'fa fa-file-text-o',
		title : '法医学尸体检验记录',
		content : '',
		type : 'green',
		columnClass : 'col-md-10 col-md-offset-2',
		theme : 'modern',
		onOpenBefore : function() {
		},
		onContentReady : function() {
			for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
				if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
					break;
				}
			}
			var con = '<hr>' + '<div style="text-align: left;">' + '<h4 style="text-align: center;">尸体检验记录</h4>' + '<p>委托单位：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit
					+ '</p>'
					+ '<p>承办人员：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_undertake_personnel
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_phone
					+ '</p>'
					+ '<p>委托时间：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time.substring(0, 4)
					+ '年'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time.substring(5, 7)
					+ '月'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time.substring(8, 10)
					+ '日'
					+ '</p>'
					+ '<p>死者姓名：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_name
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_sex
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出生日期：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_birth_date.substring(0, 4)
					+ '年'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_birth_date.substring(5, 7)
					+ '月'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_birth_date.substring(8, 10)
					+ '日'
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民族（或国籍）：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_private_capital
					+ '</p>'
					+ '<p>服务处所：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_unit_service
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住址：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_address
					+ '</p>'
					+ '<p>检验人：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspector
					+ '</p>'
					+ '<p>检验时间：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(0, 4)
					+ '年'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(5, 7)
					+ '月'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(8, 10)
					+ '日'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(11, 13)
					+ '时'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(14, 16)
					+ '分'
					+ '&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(0, 4)
					+ '年'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(5, 7)
					+ '月'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(8, 10)
					+ '日'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(11, 13)
					+ '时'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_time.substring(14, 16)
					+ '分'
					+ '</p>'
					+ '<p>检验地点：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_place
					+ '</p>'
					+ '<p>检验环境温度：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_inspect_ambient_temperature
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检验环境湿度：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_ambient_humidity
					+ '</p>'
					+ '<p>案情摘要：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation
					+ '</p>'
					+ '<p>现场尸体与血迹概况（尸体所处地点、位置、姿势及与周围环境相互关系等）：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_site_profile
					+ '</p>'
					+ '<p>尸体衣着、饰物、随身物品性状与数量及其它物品：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_death_clothing
					+ '</p>'
					+ '<p>随身物品移交情况：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_handover_of_goods
					+ '</p>'
					+ '<p>接收物品人员：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_receiver_goods
					+ '</p>'
					+ '<p>备注：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_mark
					+ '</p>'
					+ '<h4 style="text-align: center;">尸表检验</h4>'
					+ '<p>'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test.replace(/\n/g, "<br>")
							.replace(/ /g, "&nbsp;")
					+ '</p>'
					+ '<p>尸表检验记录人：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test_recorder
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;尸表检验记录时间：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_surface_table_test_recorder_time
					+ '</p>'
					+ '<h4 style="text-align: center;">解剖检验</h4>'
					+ '<p>'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_test.replace(/\n/g, "<br>").replace(/ /g,
							"&nbsp;") + '</p>' + '<table  class="table table-bordered" style="text-align: center;">' + '<tbody>' + '<tr>' + '<td style="width:200px;">尸表检验图：</td>'
					+ '<td>' + '<p>' + '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id + '_'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture1
					+ '" onclick="()" style="width:300px; margin:20px auto;"  />' + '</p>' + '<p>'
					+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id + '_'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture2
					+ '" onclick="()" style="width:300px; margin:20px auto;"  />' + '</p>' + '<p>'
					+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id + '_'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_picture3
					+ '" onclick="()" style="width:300px; margin:20px auto;"  />' + '</p>' + '</td>' + '</tr>' + '<tr>' + '<td>解剖检验图：</td>' + '<td>' + '<p>'
					+ '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id + '_'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture1
					+ '"  style="width:300px; margin:20px auto;" />' + '</p>' + '<p>' + '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id + '_'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture2
					+ '"  style="width:300px; margin:20px auto;"  />' + '</p>' + '<p>' + '<img id="img1" src="/xsjsglxt/inspectionIdentific/img_getDeathPicture?imgName='
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.xsjsglxt_death_inspection_record_id + '_'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomy_picture3
					+ '"  style="width:300px; margin:20px auto;"  />' + '</p>' + '</td>' + '</tr>' + '<p>解剖时间：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time.substring(0, 4) + '年'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time.substring(5, 7) + '月'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time.substring(8, 10) + '日'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time.substring(11, 13) + '时'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_time.substring(14, 16) + '分'
					+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;解剖地点：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_anatomic_place + '</p>' + '<p>尸体检验拍照人：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_photographer + '</p>'
					+ '<p>尸体检验录像人：' + json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_video + '</p>'
					+ '<p>尸体检验记录人：' + json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder + '</p>'
					+ '<p>尸体检验记录时间：'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder_time.substring(0, 4)
					+ '年'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder_time.substring(5, 7)
					+ '月'
					+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_death_inspection_record.death_inspection_record_autopsy_table_test_recorder_time.substring(8, 11)
					+ '日' + '</p>' + '</div>';
			jc.setContentAppend(con);
			/*
			 * 
			 */
			/*
			 * 
			 */
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
					Update_Death_InspectionRecord(obj);
				}
			},
			'返回' : function() {
			}
		}
	});
}