/**
 * 
 */

function saveExpenditure() {
	$
			.confirm({
				title : '添加报账',
				cloumnClass : '600px',
				useBootstrap : false,
				content : '<table class="table bordered-table" style="margin:0 auto;">'
						+ '<tr><td>报账人：</td><td><select id="human_" class="form-control selectpicker" multiple '
						+ ' data-live-search="true" title="请选择报账人"></select></td></tr>'
						+ '<tr><td>报账种类：</td><td><select id="type_" class="form-control">'
						+ '<option value="出差">出差</option>'
						+ '<option value="学习">学习</option>'
						+ '<option value="误餐">误餐</option>'
						+ '<option value="特情">特情</option>'
						+ '<option value="其他">其他</option>'
						+ '</select></td></tr>'
						+ '<tr><td>报账时间：</td><td><input id="time_" type="text" class="form-control startTime"></td></tr>'
						+ '<tr><td>所属中队：</td><td><input id="detachment_" type="text" class="form-control"></td></tr>'
						+ '<tr><td>金额（元）：</td><td><input id="money_" type="text" class="form-control"></td></tr>'
						+ '</table>',
				type : 'blue',
				buttons : {
					submit : {
						text : '添加',
						btnClass : 'btn-blue',
						action : function() {
							var reg = new RegExp("^[0-9]*$");
							if (!reg
									.test(document.getElementById("money_").value)) {
								toastr.error("请输入数字");
								return false;
							} else {
								var human = $(".selectpicker").selectpicker(
										'val');
								var humanString = human.join("、");
								$
										.ajax({
											url : '/xsjsglxt/statistics/Expenditure_saveExpenditure',
											type : 'POST',
											data : {
												'expenditure.expenditure_name' : humanString,
												'expenditure.expenditure_type' : $(
														'#type_').val(),
												'expenditure.expenditure_time' : $(
														'#time_').val(),
												'expenditure.expenditure_detachment' : $(
														'#detachment_').val(),
												'expenditure.expenditure_money' : $(
														'#money_').val(),
											},
											success : function(data) {
												if (data == "saveSuccess") {
													toastr.success("保存成功");
													queryTemp.currPage = 1;
													loadData();
												} else {
													toastr.error("保存失败");
												}
											}
										})
							}
						}
					},
					cancel : {
						text : "关闭",
						btnClass : "btn-red",
						action : function() {

						}
					}
				},
				onContentReady : function() {
					$.datetimepicker.setLocale('ch');
					$('.startTime').datetimepicker({
						yearStart : 1900, // 设置最小年份
						yearEnd : 2100, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : false, // 关闭时间选项
						format : 'Y-m-d', // 格式化日期年-月-日
						minDate : '1900/01/01', // 设置最小日期
						maxDate : '2100/01/01', // 设置最大日期
					});

					$.ajax({
						url : '/xsjsglxt/team/Staff_getAllStaff',
						type : 'GET',
						success : function(data) {
							var returnData = JSON.parse(data);
							for (var int = 0; int < returnData.length; int++) {
								$('#human_').html(
										$('#human_').html() + "<option value='"
												+ returnData[int].xsjsglxt_name
												+ "'>"
												+ returnData[int].xsjsglxt_name
												+ "</option>");
							}
							$(".selectpicker").selectpicker('refresh');
							$(".selectpicker").selectpicker('render');
						}
					})

				}
			})
}