/**
 * 
 */

function isAddSuspect(caseId) {
	console.log("收到请求");
	$.confirm({
		title : '是否继续添加嫌疑人',
		type : 'blue',
		content : '',
		buttons : {
			sure : {
				text : "继续",
				btnClass : "btn-blue",
				action : function() {
					addSuspect(caseId);
				}
			},
			close : {
				text : "取消",
				btnClass : "btn-red",
				action : function() {

				}

			}
		}
	});
}

function createHandleCase() {
	$
			.confirm({
				title : '添加案件',
				columnClass : "col-md-12",
				content : '<form id="HandleCaseInfor"><table class="table table-bordered" style="text-align: center;"><tr>'
						+ '<td>案件名称：</td><td colspan="3"><input name="handleCase.handle_case_name" type="text" class="form-control"></td>'
						+ '<td>案件状态</td><td><select name="handleCase.handle_case_state" class="form-control">'
						+ '<option value="0">在侦</option>'
						+ '<option value="1">已破</option>'
						+ '</select></td>'
						+ '</tr>'
						+ '<tr><td>主办民警：</td><td><input name="handleCase.handle_main_police" type="text" class="form-control"></td>'
						+ '<td>协办民警：</td><td><input name="handleCase.handle_assistant_police" type="text" class="form-control"></td></td>'
						+ '<td>中队长：</td><td><input name="handleCase.handle_middle_captain" type="text" class="form-control"></td></td></tr>'
						+ '</table></form>',
				type : 'green',
				buttons : {
					save : {
						text : '保存',
						btnClass : 'btn-blue',
						action : function() {
							var formData = new FormData(document
									.getElementById("HandleCaseInfor"));
							$.ajax({
								url : '/xsjsglxt/case/DealCase_saveHandleCase',
								type : "POST",
								data : formData,
								processData : false,
								contentType : false,
								success : function(data) {
									if (data == "saveError") {
										toastr.error("保存失败！");
									} else {
										toastr.success("保存成功！");
										isAddSuspect(data);
										loadData();
									}
								}
							})
						}
					},
					cancel : {
						btnClass : 'btn-red',
						text : '关闭',
						action : function() {

						}
					}
				}
			});
}

function addSuspect(caseId) {
	$
			.confirm({
				title : '增加嫌疑人',
				type : 'green',
				columnClass : 'col-md-12',
				content : '<form id="HandleCaseInfor"><table class="table table-bordered" style="text-align: center;">'
						+ '<tr><td>姓名：</td><td><input name="suspectInfor.suspect_name" type="text" class="form-control"></td>'
						+ '<td>身份证号码：</td><td><input name="suspectInfor.suspect_identification" oninput="judgeSex(this)" type="text" class="form-control"></td>'
						+ '<td>性别：</td><td><select name="suspectInfor.suspect_sex" id="suspectSexSelect" class="form-control"><option value=""></option><option value="0">男</option><option value="1">女</option></select></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>抓获时间：</td><td><input name="suspectInfor.suspect_captured_time" type="text" class="form-control mydate"></td>'
						+ '<td>涉嫌罪名：</td><td colspan="3"><input name="suspectInfor.suspect_crime_name" type="text" class="form-control"></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>处理类型：</td><td><select id="dealType" name="suspectInfor.suspect_process_type" onchange="judgeDealType(this)" class="form-control">'
						+ '<option value=""></option>'
						+ '<option value="0">拘留</option>'
						+ '<option value="1">逮捕</option>'
						+ '<option value="2">起诉</option>'
						+ '<option value="3">退查</option>'
						+ '<option value="4">监视居住</option>'
						+ '<option value="5">取保候审</option>'
						+ '<option value="6">释放</option>'
						+ '</select></td>'
						+ '<td>起始时间：</td><td><input id="startTime" name="suspectInfor.suspect_start_time" type="text" class="form-control mydate"></td>'
						+ '<td class="detentionDays">拘留天数</td>'
						+ '<td class="detentionDays"><select id="processLong" name="suspectInfor.suspect_process_long" class="form-control">'
						+ '<option value="0"></option>'
						+ '<option value="3">3天</option>'
						+ '<option value="7">7天</option>'
						+ '<option value="30">30天</option>'
						+ '</select></td>'
						+ '</tr>' + '</table></form>',
				buttons : {
					save : {
						text : '保存',
						btnClass : 'btn-blue',
						action : function() {
							var dealType = $('#dealType').val();
							var startTime = $('#startTime').val();
							startTime = startTime.replace(/-/g, "/");
							var date = new Date(startTime);
							var endTime;
							var warnTime;
							switch (dealType) {
							case '0':
								var processLong = $('#processLong').val();
								switch (processLong) {
								case '3':
									warnTime = 2;
									date.setDate(date.getDate() + 2);
									endTime = formDate(date);
									break;
								case '7':
									warnTime = 5;
									date.setDate(date.getDate() + 7);
									endTime = formDate(date);
									break;
								case '30':
									warnTime = 20;
									date.setDate(date.getDate() + 30);
									endTime = formDate(date);
									break;
								}
								break;
							case '1':
								warnTime = 15;
								date.setMonth(date.getMonth() + 2);
								endTime = formDate(date);
								break;
							case '2':
								warnTime = 0;
								break;
							case '3':
								warnTime = 15;
								date.setMonth(date.getMonth() + 1);
								endTime = formDate(date);
								break;
							case '4':
								warnTime = 10;
								date.setMonth(date.getMonth() + 6);
								endTime = formDate(date);
								break;
							case '5':
								warnTime = 10;
								date.setMonth(date.getMonth() + 12);
								endTime = formDate(date);
								break;
							case '6':
								warnTime = 0;
								break;
							}

							var formData = new FormData(document
									.getElementById("HandleCaseInfor"));
							formData
									.append("suspectInfor.suspect_case", caseId);
							formData.append("suspectInfor.suspect_warn_time",
									warnTime);
							formData.append("suspectInfor.suspect_end_time",
									endTime);
							$.ajax({
								url : '/xsjsglxt/case/DealCase_saveSuspect',
								type : 'POST',
								data : formData,
								processData : false,
								contentType : false,
								success : function(data) {
									if (data == "saveSuccess") {
										toastr.success("保存成功！");
										isAddSuspect(caseId);
									} else {
										toastr.error("保存失败！");
									}
								}
							});

						}
					},
					cancel : {
						text : '关闭',
						btnClass : 'btn-red',
						action : function() {
						}
					}
				},
				onContentReady : function() {
					$.datetimepicker.setLocale('ch');
					$('.mydate').datetimepicker({
						yearStart : 1950, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : false, // 关闭时间选项
						format : 'Y-m-d', // 格式化日期年-月-日
						minDate : '1950/01/01', // 设置最小日期
						maxDate : '2050/01/01', // 设置最大日期
					});
				}
			})
}