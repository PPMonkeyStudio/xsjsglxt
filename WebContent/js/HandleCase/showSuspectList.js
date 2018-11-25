/**
 * judgeNull(suspect.suspect_captured_time)
 */

var suspectManager;
var suspectVue;
var currCase;
function suspectPanel(event) {
	currCase = event.id;
	suspectManager = $
			.confirm({
				title : '嫌疑人管理',
				type : 'purple',
				columnClass : 'col-md-12',
				content : '<button class="btn btn-default" onclick="createSuspect()"><i class="fa fa-pencil-square-o"></i>增加嫌疑人</button>'
						+ '<table id="suspectListTable" class="table table-hover table-condensed" style="text-align: center;">'
						+ '<thead><tr><td>姓名</td><td>性别</td><td>抓获时间</td><td>身份证号码</td><td>处理类型</td><td>随身物品</td><td>状态记录</td><td>操作</td></tr></thead>'
						+ '<tbody><template v-for="suspect in suspectList">'
						+ '<tr><td>{{ suspect.suspect_name }}</td>'
						+ '<td><template v-if="suspect.suspect_sex == 0">男</template><template v-else>女</template></td>'
						+ '<td><template v-if="suspect.suspect_captured_time.length==0">未抓获</template><template v-else>{{ suspect.suspect_name }}</template></td>'
						+ '<td>{{ suspect.suspect_identification }}</td>'
						+ '<td><template v-if="suspect.suspect_process_type == 0">拘留</template>'
						+ '<template v-if="suspect.suspect_process_type == 1">逮捕</template>'
						+ '<template v-if="suspect.suspect_process_type == 2">起诉</template>'
						+ '<template v-if="suspect.suspect_process_type == 3">退查</template>'
						+ '<template v-if="suspect.suspect_process_type == 4">监视居住</template>'
						+ '<template v-if="suspect.suspect_process_type == 5">取保候审</template>'
						+ '<template v-if="suspect.suspect_process_type == 6">释放</template></td>'
						+ '<td><i onclick="takeGoodsPanel(this)" :id="suspect.suspect_id" class="fa fa-arrow-right pageOperation"></i></td>'
						+ '<td><i onclick="stateRecord(this)" :id="suspect.suspect_id" class="fa fa-hand-o-right pageOperation"></i></td>'
						+ '<td><a onclick="updateSuspect(this)" class="pageOperation" :id="suspect.suspect_id">修改</a>|<a onclick="deleteSuspect(this)" class="pageOperation" :id="suspect.suspect_id">删除</a></td>'
						+ '</tr></template></tbody>' + '</table>',
				buttons : {
					cancel : {
						text : '关闭',
						btnClass : 'btn-blue',
						action : function() {

						}
					}
				},
				onContentReady : function() {
					suspectVue = new Vue({
						el : '#suspectListTable',
						data : {
							suspectList : ''
						},
						methods : {
							judgeNull : function(data) {
								if (data == "") {
									return true;
								} else {
									return false
								}
							}
						}
					})
					$.ajax({
						url : '/xsjsglxt/case/DealCase_getSuspectByCaseId',
						type : 'POST',
						data : {
							'handleCase_id' : currCase
						},
						success : function(data) {
							suspectVue.suspectList = JSON.parse(data);
						}
					})
				}
			})
}
function createSuspect() {
	suspectManager.close();
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
							formData.append("suspectInfor.suspect_case",
									currCase);
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
									} else {
										toastr.error("保存失败！");
									}
								}
							});
							suspectManager.open();
						}
					},
					cancel : {
						text : '关闭',
						btnClass : 'btn-red',
						action : function() {
							suspectManager.open();
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

function deleteSuspect(event) {
	suspectManager.close();
	$
			.confirm({
				title : '<i class="fa fa-exclamation-triangle" style="color:red;" aria-hidden="true"></i>删除此嫌疑人',
				type : 'red',
				content : '',
				autoClose : "close|10000",
				buttons : {
					sure : {
						text : "确定",
						btnClass : "btn-blue",
						action : function() {
							$.ajax({
								url : "/xsjsglxt/case/DealCase_deleteSuspect",
								type : "POST",
								data : {
									"suspectInfor.suspect_id" : event.id
								},
								success : function(data) {
									if (data == "deleteSuccess") {
										toastr.success("删除成功");
										suspectManager.open();
										loadData();
									} else {
										toastr.error("删除失败");
										takeGoodsManager.open();
									}
								}
							});
						}
					},
					close : {
						text : "取消",
						btnClass : "btn-red",
						action : function() {
							suspectManager.open();
						}

					}
				}
			});
}

function updateSuspect(event) {
	suspectManager.close();
	var suspect;
	$
			.confirm({
				title : '修改嫌疑人',
				type : 'blue',
				columnClass : 'col-md-12',
				content : '<form id="HandleCaseInfor"><table class="table table-bordered" style="text-align: center;">'
						+ '<tr><td>姓名：</td><td><input id="suspectName" name="suspectInfor.suspect_name" type="text" class="form-control"></td>'
						+ '<td>身份证号码：</td><td><input id="suspectNumber" name="suspectInfor.suspect_identification" oninput="judgeSex(this)" type="text" class="form-control"></td>'
						+ '<td>性别：</td><td><select id="suspectSex" name="suspectInfor.suspect_sex" id="suspectSexSelect" class="form-control"><option value=""></option><option value="0">男</option><option value="1">女</option></select></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>抓获时间：</td><td><input id="capturedTime" name="suspectInfor.suspect_captured_time" type="text" class="form-control mydate"></td>'
						+ '<td>涉嫌罪名：</td><td colspan="3"><input id="crimeName" name="suspectInfor.suspect_crime_name" type="text" class="form-control"></td>'
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
								console.log(date.getMonth());
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
							var isChangeType = 0;
							if (suspect.suspect_process_type != $('#dealType')
									.val()) {
								isChangeType = 1;
							}
							if (suspect.suspect_start_time != $('#startTime')
									.val()) {
								isChangeType = 1;
							}
							if (suspect.suspect_process_long != $(
									'#processLong').val()) {
								isChangeType = 1;
							}
							var formData = new FormData(document
									.getElementById("HandleCaseInfor"));
							formData
									.append("suspectInfor.suspect_id", event.id);
							formData.append("suspectInfor.suspect_case",
									currCase);
							formData.append("suspectInfor.suspect_warn_time",
									warnTime);
							formData.append("suspectInfor.suspect_end_time",
									endTime);
							formData.append("isChangeType", isChangeType);
							if ($('#dealType').val() != 0) {
								formData.append(
										"suspectInfor.suspect_process_long", 0);
							}
							$.ajax({
								url : '/xsjsglxt/case/DealCase_updateSuspect',
								type : 'POST',
								data : formData,
								processData : false,
								contentType : false,
								success : function(data) {
									if (data == "updateSuccess") {
										toastr.success("保存成功！");
									} else {
										toastr.error("保存失败！");
									}
								}
							});
							suspectManager.open();
						}
					},
					cancel : {
						text : '关闭',
						btnClass : 'btn-red',
						action : function() {
							suspectManager.open();
						}
					}
				},
				onContentReady : function() {

					$.ajax({
						url : '/xsjsglxt/case/DealCase_getSuspectById',
						type : 'POST',
						data : {
							'suspectInfor.suspect_id' : event.id
						},
						success : function(data) {
							suspect = JSON.parse(data);
							$('#suspectName').val(suspect.suspect_name);
							$('#suspectNumber').val(
									suspect.suspect_identification);
							$('#suspectSex').val(suspect.suspect_sex);
							$('#capturedTime').val(
									suspect.suspect_captured_time);
							$('#crimeName').val(suspect.suspect_crime_name);
							$('#dealType').val(suspect.suspect_process_type);
							$('#startTime').val(suspect.suspect_start_time);
							if (suspect.suspect_process_type == 0) {
								$('.detentionDays').show();
								$('#processLong').val(
										suspect.suspect_process_long);
							}
						}
					});
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

function judgeDealType(event) {
	if (event.value == 0) {
		$('.detentionDays').show();
	} else {
		$('.detentionDays').hide();
	}
}
function judgeSex(event) {
	var idNumber = event.value;
	if (idNumber.length == 18) {
		var sexNumber = idNumber.substring(16, 17);
		if (sexNumber % 2 == 1) {
			$("#suspectSexSelect").val('0');
		} else {
			$('#suspectSexSelect').val('1');
		}
	}
}

function stateRecord(event) {
	suspectManager.close();
	var stateRecordVue;
	$
			.confirm({
				title : '嫌疑人管理',
				type : 'dark',
				columnClass : 'col-md-4 col-md-offset-4',
				content : '<table id="stateTable" class="table table-hover table-condensed" style="text-align: center;">'
						+ '<thead><tr><td>嫌疑人状态</td><td>开始时间</td><td>结束时间</td></tr></thead>'
						+ '<tbody><template v-for="suspectState in states"><tr>'
						+ '<td><template v-if="suspectState.state_type == 0">拘留</template>'
						+ '<template v-if="suspectState.state_type == 1">逮捕</template>'
						+ '<template v-if="suspectState.state_type == 2">起诉</template>'
						+ '<template v-if="suspectState.state_type == 3">退查</template>'
						+ '<template v-if="suspectState.state_type == 4">监视居住</template>'
						+ '<template v-if="suspectState.state_type == 5">取保候审</template>'
						+ '<template v-if="suspectState.state_type == 6">释放</template></td>'
						+ '<td>{{ suspectState.state_start }}</td>'
						+ '<td>{{ suspectState.state_end }}</td>'
						+ '</tr><template></tbody>' + '</table>',
				buttons : {
					cancel : {
						text : '返回',
						btnClass : 'btn-blue',
						action : function() {
							suspectManager.open();
						}
					}
				},
				onContentReady : function() {
					stateRecordVue = new Vue({
						el : '#stateTable',
						data : {
							states : ''
						}
					});
					$.ajax({
						url : '/xsjsglxt/case/DealCase_suspectStates',
						type : 'POST',
						data : {
							'suspectInfor.suspect_id' : event.id
						},
						success : function(data) {
							stateRecordVue.states = JSON.parse(data);
						}

					})
				}

			})
}

var formDate = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? ('0' + m) : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;
	return y + '-' + m + '-' + d;
}
