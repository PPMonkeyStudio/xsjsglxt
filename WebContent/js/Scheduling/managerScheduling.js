/**
 * 
 */

var printCurrPage = function() {
	window.location.href = "/xsjsglxt/scheduling/Scheduling_exportScheduling?schedulingListVO.currPage="
			+ queryConditionTemp.currPage
			+ "&schedulingListVO.queryTimeStart="
			+ queryConditionTemp.queryTimeStart
			+ "&schedulingListVO.queryTimeEnd="
			+ queryConditionTemp.queryTimeEnd
			+ "&schedulingListVO.query_name="
			+ queryConditionTemp.query_name;
}
var intoStastics = function() {
	window.location.href = "/xsjsglxt/scheduling/Scheduling_intoStastics";
}
var deleteScheduling = function() {
	$
			.confirm({
				title : '确定要删除吗！',
				type : 'red',
				content : '',
				autoClose : "cancel|10000",
				buttons : {
					'delete' : {
						text : '确定',
						action : function() {
							var formData = new FormData();
							var che = document
									.getElementsByName("chooseCheckBox");
							for (var int = 0; int < che.length; int++) {
								if (che[int].checked) {
									formData.append("scheduling_id",
											che[int].value);
								}
							}
							$
									.ajax({
										url : '/xsjsglxt/scheduling/Scheduling_deleteScheduling',
										type : 'POST',
										data : formData,
										contentType : false,
										processData : false,
										success : function(data) {
											if (data == "deleteSuccess") {
												toastr.success("删除成功");
												queryConditionTemp.currPage = 1;
												loadScheduling();
											} else
												toastr.error("删除失败");
										}
									});
						}
					},
					'cancel' : {
						text : '取消',
						btnClass : 'btn-red'
					}
				}
			})
}
var updateScheduling = function(event) {
	$
			.confirm({
				boxWidth : '500px',
				useBootstrap : false,
				title : '<i class="fa fa-pencil-square-o"></i>修改排班',
				type : 'green',
				content : '<form id="update_"><table class="table bordered-table">'
						+ '<tr><td>今日巡逻：</td><td class="contentName"><input name="scheduling.scheduling_patrol" id="patrol" style="width: 250px;" class="form-control"  readonly="true"></td><td><button onclick="chooseStaff(\'patrol\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>今日加班：</td><td class="contentName"><input name="scheduling.scheduling_overtime" id="overtime" style="width: 250px;" class="form-control"  readonly="true"></td><td><button onclick="chooseStaff(\'overtime\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>今日外协：</td><td class="contentName"><input name="scheduling.scheduling_out_help" id="outHelp" style="width: 250px;" class="form-control"  readonly="true"></td><td><button onclick="chooseStaff(\'outHelp\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>今日出差：</td><td class="contentName"><input name="scheduling.scheduling_evection" id="evection" style="width: 250px;" class="form-control"  readonly="true"></td><td><button onclick="chooseStaff(\'evection\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>带班领导：</td><td class="contentName"><input name="scheduling.scheduling_leader" id="leader" style="width: 250px;" class="form-control"  readonly="true"></td><td><button onclick="chooseStaff(\'leader\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>侦查民警：</td><td class="contentName"><input name="scheduling.scheduling_main" id="main" style="width: 250px;" class="form-control"  readonly="true"></td><td><button onclick="chooseStaff(\'main\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>技术民警：</td><td class="contentName"><input name="scheduling.scheduling_main_technology" id="mainTech" style="width: 250px;" class="form-control"  readonly="true"></td><td><button onclick="chooseStaff(\'mainTech\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>法医民警：</td><td class="contentName"><input name="scheduling.scheduling_main_doctor" id="mainDoctor" style="width: 250px;" class="form-control" readonly="true"></td><td><button onclick="chooseStaff(\'mainDoctor\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>侦查辅警：</td><td class="contentName"><input name="scheduling.scheduling_assistant_tech" id="assistantSpy" style="width: 250px;" class="form-control" readonly="true"></td><td><button onclick="chooseStaff(\'assistantSpy\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>技术辅警：</td><td class="contentName"><input name="scheduling.scheduling_assistant_spy" id="assistantTech" style="width: 250px;" class="form-control" readonly="true"></td><td><button onclick="chooseStaff(\'assistantTech\');return false;" class="btn btn-default"><i class="fa fa-pencil-square-o"></i></button></td></tr>'
						+ '<tr><td>值班时间：</td><td><input name="scheduling.scheduling_time" id="scheTime" style="250px" class="form-control timeDate"></td></tr></table></form>',

				buttons : {
					save : {
						text : '<i class="fa fa-upload" aria-hidden="true"></i>修改',
						btnClass : 'btn-blue',
						action : function() {
							if ($('#leader').val() != ''
									&& $('#main').val() != ''
									&& $('#mainTech').val() != ''
									&& $('#mainDoctor').val() != ''
									&& $('#assistantTech').val() != ''
									&& $('#assistantSpy').val() != ''
									&& $('#scheTime').val() != '') {
								var formData = new FormData(document
										.getElementById("update_"));
								formData.append(
										"scheduling.xsjsglxt_scheduling_id",
										event.id);
								$
										.ajax({
											url : '/xsjsglxt/scheduling/Scheduling_updateScheduling',
											type : 'POST',
											data : formData,
											contentType : false, // 注意这里应设为false
											processData : false,
											success : function(data) {
												if (data == "updateSuccess") {
													toastr.success("修改成功");
													queryConditionTemp.currPage = 1;
													loadScheduling();
												} else {
													toastr.error("修改失败");
												}
											}
										})
							} else {
								toastr.error("不能有空项");
								return false;
							}
						}
					},
					close : {
						text : "<i class='fa fa-times' aria-hidden='true'></i>关闭",
						btnClass : "btn-red",
						action : function() {

						}
					}
				},
				onContentReady : function() {
					var d = {
						'scheduling.xsjsglxt_scheduling_id' : event.id
					};
					$
							.ajax({
								url : '/xsjsglxt/scheduling/Scheduling_getSchedulingById',
								type : 'POST',
								data : d,
								success : function(data) {
									var jsonData = JSON.parse(data);
									$('#leader')
											.val(jsonData.scheduling_leader);
									$('#main').val(jsonData.scheduling_main);
									$('#mainTech')
											.val(
													jsonData.scheduling_main_technology);
									$('#mainDoctor').val(
											jsonData.scheduling_main_doctor);
									$('#assistantTech').val(
											jsonData.scheduling_assistant_tech);
									$('#assistantSpy').val(
											jsonData.scheduling_assistant_spy);
									$('#patrol')
											.val(jsonData.scheduling_patrol);
									$('#overtime').val(
											jsonData.scheduling_overtime);
									$('#outHelp').val(
											jsonData.scheduling_out_help);
									$('#evection').val(
											jsonData.scheduling_evection);
									$('#scheTime')
											.val(jsonData.scheduling_time);
								}
							});
					$.datetimepicker.setLocale('ch');
					$('.timeDate').datetimepicker({
						yearStart : 1900, // 设置最小年份
						yearEnd : 2100, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : false, // 关闭时间选项
						format : 'Y-m-d', // 格式化日期年-月-日
						minDate : '1900/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});
				}
			});

}