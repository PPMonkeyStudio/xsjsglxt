/**
 * 
 */
var previewMeetingRecords = function(dom) {
	var jc = $
			.confirm({
				columnClass : "col-md-12",
				type : 'green',
				title : "<i class='fa fa-pencil-square-o'></i>预览会议记录书",
				content : "<div id='addLoadingLayer' class='hideDiv' style='margin: 0 auto; width: 45px;'><i class='fa fa-spinner fa-spin fa-3x fa-fw'></i></div>"
						+ "<div id='ConfirmTableDiv'><form id='UpdateMeetRecords' name='UpdateMeetRecords'><table class='table table-bordered' style='text-align: center;'>"
						+ "<tr><td style='width:200px;'>会议类型：</td><td style='width:400px;'>"
						+ "<span id='meeting_titleU'></span>"
						+ "</td><td style='width:200px;'>会议地点：</td><td style='width:400px;'><span id='meeting_placeU'></span></td></tr>"
						+ "<tr><td >会议开始时间：</td><td><span id='meeting_start_timeU'></span></td>"
						+ "<td>会议结束时间：</td><td><span id='meeting_end_timeU'></span></td></tr>"
						+ "<tr><td>主持人：</td><td><span id='meeting_compereU'></span></td>"
						+ "<td>记录人：</td><td><span id='meeting_record_humanU'></span></td></tr>"
						+ "<tr>"
						+ "<td>会议主题</td><td><span id='meeting_themeU'></span></td>"
						+ "<td>参与人员</td><td><span id='meeting_join_humanU'></span></td></tr>"
						+ "<tr><td>请假人员</td><td colspan='3'><span id='meeting_leave_humanU'></td></tr>"
						+ "<tr><td>会议内容</td><td colspan='3'><span id='meeting_contentU'></span></td></tr>"
						+ "<table></form></div>",
				buttons : {
					closeMeet : {
						text : "关闭",
						btnClass : "btn-red",
						action : function() {

						}
					},
				},
				onContentReady : function() {
					$.datetimepicker.setLocale('ch');
					$('.mydate').datetimepicker({
						yearStart : 1900, // 设置最小年份
						yearEnd : 2100, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : true, // 关闭时间选项
						format : 'Y-m-d H:i', // 格式化日期年-月-日
						minDate : '1900/01/01 00:00', // 设置最小日期
						maxDate : '2030/01/01 00:00', // 设置最大日期
					});
					$.ajax({
						url : "/xsjsglxt/user/Meeting_getMeetingById",
						type : "POST",
						data : {
							"meeting_id" : dom.id
						},
						success : function(datas) {
							var jsonData = JSON.parse(datas);
							$("#meeting_titleU").html(jsonData.meeting_title);
							$("#meeting_themeU").html(jsonData.meeting_theme);
							$("#meeting_placeU").html(jsonData.meeting_place);
							$("#meeting_start_timeU").html(
									jsonData.meeting_start_time);
							$("#meeting_end_timeU").html(
									jsonData.meeting_end_time);
							$("#meeting_compereU").html(
									jsonData.meeting_compere);
							$("#meeting_record_humanU").html(
									jsonData.meeting_record_human);
							$("#meeting_leave_humanU").html(
									jsonData.meeting_leave_human);
							$("#meeting_join_humanU").html(
									jsonData.meeting_join_human);
							$("#meeting_contentU").html(
									jsonData.meeting_content);
						}
					});
				}
			});
}