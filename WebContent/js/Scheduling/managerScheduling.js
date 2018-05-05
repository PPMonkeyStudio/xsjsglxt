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
				content : '<table class="table bordered-table">'
						+ '<tr><td>今日巡逻：</td><td class="loadingLay" style="text-align:center;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td><td class="contentName" style="display:none;"><select data-selected-text-format="count > 8" id="patrol" style="width: 250px;" data-dropup-auto="false" multiple class="form-control selectpicker" data-live-search="true" title="请选择巡逻人员"></select></td></tr>'
						+ '<tr><td>今日加班：</td><td class="loadingLay"  style="text-align:center;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td><td class="contentName" style="display:none;"><select data-selected-text-format="count > 8" id="overtime" style="width: 250px;" data-dropup-auto="false" multiple class="form-control selectpicker" data-live-search="true" title="请选择加班人员"></select></td></tr>'
						+ '<tr><td>今日外协：</td><td class="loadingLay"  style="text-align:center;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td><td class="contentName" style="display:none;"><select data-selected-text-format="count > 8" id="outHelp" style="width: 250px;" data-dropup-auto="false" multiple class="form-control selectpicker" data-live-search="true" title="请选择外协人员"></select></td></tr>'
						+ '<tr><td>今日出差：</td><td class="loadingLay"  style="text-align:center;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td><td class="contentName" style="display:none;"><select data-selected-text-format="count > 8" id="evection" style="width: 250px;" data-dropup-auto="false" multiple class="form-control selectpicker" data-live-search="true" title="请选择出差人员"></select></td></tr>'
						+ '<tr><td>带班领导：</td><td style="text-align:center;" class="loadingLay"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td><td class="contentName" style="display:none;"><select data-selected-text-format="count > 8" id="leader" style="width: 250px;" class="form-control selectpicker" data-live-search="true" title="请选择主班领导"></select></td></tr>'
						+ '<tr><td>侦查民警：</td><td class="loadingLay" style="text-align:center;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td></td><td class="contentName" style="display:none;"><select data-selected-text-format="count > 8" id="main" style="width: 250px;" class="form-control selectpicker" data-live-search="true" title="请选择侦查民警"></select></td></tr>'
						+ '<tr><td>技术民警：</td><td class="loadingLay" style="text-align:center;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td></td><td class="contentName" style="display:none;"><select data-selected-text-format="count > 8" id="mainTech" style="width: 250px;" class="form-control selectpicker" data-live-search="true" title="请选择技术民警"></select></td></tr>'
						+ '<tr><td>辅警：</td><td class="loadingLay" style="text-align:center;"><i class="fa fa-spinner fa-spin fa-3x fa-fw"></i></td><td class="contentName" style="display:none;"><select id="assistant" multiple style="width: 250px;" class="form-control selectpicker" data-live-search="true" title="请选择辅警"></select></td></tr>'
						+ '<tr><td>值班时间：</td><td><input id="scheTime" style="250px" class="form-control timeDate"></td></tr></table>',

				buttons : {
					save : {
						text : '<i class="fa fa-upload" aria-hidden="true"></i>修改',
						btnClass : 'btn-blue',
						action : function() {
							if ($('#leader').val() != ''
									&& $('#main').val() != ''
									&& $('#assistant').val() != ''
									&& $('#scheTime').val() != '') {
								var postData = {
									'scheduling.scheduling_leader' : $(
											'#leader').val(),
									'scheduling.scheduling_main' : $('#main')
											.val(),
									'scheduling.scheduling_assistant' : $(
											'#assistant').selectpicker('val')
											.join('、'),
									'scheduling.scheduling_time' : $(
											'#scheTime').val(),
									'scheduling.xsjsglxt_scheduling_id' : event.id,
									'scheduling.scheduling_patrol' : $(
											'#patrol').selectpicker('val')
											.join(','),
									'scheduling.scheduling_overtime' : $(
											'#overtime').selectpicker('val')
											.join(','),
									'scheduling.scheduling_out_help' : $(
											'#outHelp').selectpicker('val')
											.join(','),
									'scheduling.scheduling_evection' : $(
											'#evection').selectpicker('val')
											.join(','),
									'scheduling.scheduling_main_technology' : $(
											'#mainTech').val()
								}
								$
										.ajax({
											url : '/xsjsglxt/scheduling/Scheduling_updateScheduling',
											type : 'POST',
											data : postData,
											success : function(data) {
												if (data == "updateSuccess") {
													toastr.success("修改成功");
													loadScheduling();
												} else {
													toastr.error("您修改的日期已经被占用");
													return false;
												}
											}
										});
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
					// 为下拉列表添加姓名
					$
							.ajax({
								url : '/xsjsglxt/team/Staff_getSchedulingStaff',
								type : 'GET',
								success : function(data) {
									var result = JSON.parse(data);
									for (var i = 0; i < result.staffLeader.length; i++) {
										$('#leader')
												.append(
														"<option value='"
																+ result.staffLeader[i].xsjsglxt_name
																+ "'>"
																+ result.staffLeader[i].xsjsglxt_name
																+ "</option>");
									}
									for (var i = 0; i < result.staffMain.length; i++) {
										$('#main')
												.append(
														"<option value='"
																+ result.staffMain[i].xsjsglxt_name
																+ "'>"
																+ result.staffMain[i].xsjsglxt_name
																+ "</option>");
									}
									for (var i = 0; i < result.staffMainTech.length; i++) {
										$('#mainTech')
												.append(
														"<option value='"
																+ result.staffMainTech[i].xsjsglxt_name
																+ "'>"
																+ result.staffMainTech[i].xsjsglxt_name
																+ "</option>");
									}
									for (var i = 0; i < result.staffAssitant.length; i++) {
										$('#assistant')
												.append(
														"<option value='"
																+ result.staffAssitant[i].xsjsglxt_name
																+ "'>"
																+ result.staffAssitant[i].xsjsglxt_name
																+ "</option>");
									}
									$
											.ajax({
												url : '/xsjsglxt/team/Staff_getAllPolicemans',
												type : 'GET',
												success : function(data) {
													var results = JSON
															.parse(data);
													for (var i = 0; i < results.length; i++) {
														$('#patrol')
																.append(
																		"<option value='"
																				+ results[i].xsjsglxt_name
																				+ "'>"
																				+ results[i].xsjsglxt_name
																				+ "</option>");
														for (var i = 0; i < results.length; i++) {
															$('#overtime')
																	.append(
																			"<option value='"
																					+ results[i].xsjsglxt_name
																					+ "'>"
																					+ results[i].xsjsglxt_name
																					+ "</option>");
														}
														for (var i = 0; i < results.length; i++) {
															$('#outHelp')
																	.append(
																			"<option value='"
																					+ results[i].xsjsglxt_name
																					+ "'>"
																					+ results[i].xsjsglxt_name
																					+ "</option>");
														}
														for (var i = 0; i < results.length; i++) {
															$('#evection')
																	.append(
																			"<option value='"
																					+ results[i].xsjsglxt_name
																					+ "'>"
																					+ results[i].xsjsglxt_name
																					+ "</option>");
														}
													}
													var d = {
														'scheduling.xsjsglxt_scheduling_id' : event.id
													};
													$
															.ajax({
																url : '/xsjsglxt/scheduling/Scheduling_getSchedulingById',
																type : 'POST',
																data : d,
																success : function(
																		data) {
																	var result = JSON
																			.parse(data);
																	$('#leader')
																			.selectpicker(
																					'val',
																					result.scheduling_leader);
																	$('#main')
																			.selectpicker(
																					'val',
																					result.scheduling_main);
																	$(
																			'#mainTech')
																			.selectpicker(
																					'val',
																					result.scheduling_main_technology);
																	$(
																			'#assistant')
																			.selectpicker(
																					'val',
																					result.scheduling_assistant
																							.split("、"));
																	if (result.scheduling_patrol != null
																			&& result.scheduling_patrol
																					.indexOf(',') > 0) {
																		$(
																				'#patrol')
																				.selectpicker(
																						'val',
																						result.scheduling_patrol
																								.split(','));
																	} else {
																		$(
																				'#patrol')
																				.selectpicker(
																						'val',
																						result.scheduling_patrol);
																	}
																	if (result.scheduling_overtime != null
																			&& result.scheduling_overtime
																					.indexOf(',') > 0) {
																		$(
																				'#overtime')
																				.selectpicker(
																						'val',
																						result.scheduling_overtime
																								.split(','));
																	} else {
																		$(
																				'#overtime')
																				.selectpicker(
																						'val',
																						result.scheduling_overtime);
																	}
																	if (result.scheduling_out_help != null
																			&& result.scheduling_out_help
																					.indexOf(',') > 0) {
																		$(
																				'#outHelp')
																				.selectpicker(
																						'val',
																						result.scheduling_out_help
																								.split(','));
																	} else {
																		$(
																				'#outHelp')
																				.selectpicker(
																						'val',
																						result.scheduling_out_help);
																	}
																	if (result.scheduling_evection != null
																			&& result.scheduling_evection
																					.indexOf(',') > 0) {
																		$(
																				'#evection')
																				.selectpicker(
																						'val',
																						result.scheduling_evection
																								.split(','));
																	} else {
																		$(
																				'#evection')
																				.selectpicker(
																						'val',
																						result.scheduling_evection);
																	}
																	$(
																			'#scheTime')
																			.val(
																					result.scheduling_time);

																	$(
																			".selectpicker")
																			.selectpicker(
																					'refresh');
																	$(
																			".loadingLay")
																			.hide();
																	$(
																			".contentName")
																			.show();
																}

															});
												}
											});

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