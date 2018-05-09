/**
 * 
 */

var exportLetter = function(event) {
	window.location.href = "/xsjsglxt/case/Handle_exportLetter?letter.xsjsglxt_introduce_letter_id="
			+ event.id;
}

var deleteLetter = function() {
	$.confirm({
		title : '确定要删除吗！',
		type : 'red',
		content : '',
		autoClose : "cancel|10000",
		buttons : {
			'delete' : {
				text : '确定',
				action : function() {
					var formData = new FormData();
					var che = document.getElementsByName("chooseCheckBox");
					for (var int = 0; int < che.length; int++) {
						if (che[int].checked) {
							formData.append("letter_id", che[int].value);
						}
					}
					$.ajax({
						url : '/xsjsglxt/case/Handle_deleteIntroduceLetter',
						type : 'POST',
						data : formData,
						contentType : false,
						processData : false,
						success : function(data) {
							if (data == "deleteSuccess") {
								toastr.success("删除成功");
								queryConditionTemp.currPage = 1;
								loadData();
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
var updateLetter = function(event) {
	$
			.confirm({
				boxWidth : '500px',
				useBootstrap : false,
				title : '<i class="fa fa-pencil-square-o"></i>修改介绍信',
				type : 'blue',
				content : "<div id='addLoadingLayer' class='hideDiv' style='margin: 0 auto; width: 45px;'><i class='fa fa-spinner fa-spin fa-3x fa-fw'></i></div>"
						+ "<div id='confirmDiv'><form id='formDataIntroduce' name='formDataIntroduce'>"
						+ "<table class='table bordered-table'><tr><td>目的单位：</td><td><input type='text' placeholder='请输入目的单位' name='letter.introduce_letter_tounit' id='introduce_letter_tounit' class='form-control'></td></tr>"
						+ "<tr><td>前往人员：</td><td><input type='text' placeholder='请输入姓名用\",\"划分' name='letter.introduce_letter_introduceMan' id='introduce_letter_introduceMan' class='form-control'></td></tr>"
						+ "<tr><td>前往人员数量：</td><td><input type='text' placeholder='请输入前往人员数量' name='letter.introduce_letter_number' id='introduce_letter_number' class='form-control'></td></tr>"
						+ "<tr><td>前往事由：</td><td><input type='text' placeholder='请输入前往事由' name='letter.introduce_letter_reasons' id='introduce_letter_reasons' class='form-control'></td></tr>"
						+ "<tr><td>前往时间：</td><td><input type='text' placeholder='请输入前往时间' name='letter.introduce_time' id='introduce_time' class='form-control startTime'></td></tr>"
						+ "<tr><td>前往天数：</td><td><select class='form-control' name='letter.introduce_time_limit' id='introduce_time_limit'>"
						+ "<option value='3'>3</option>"
						+ "<option value='4'>4</option>"
						+ "<option value='5'>5</option>"
						+ "<option value='6'>6</option>"
						+ "<option value='7'>7</option>"
						+ "</select></td></tr>" + "</table></from></div>",
				buttons : {
					save : {
						text : '<i class="fa fa-upload" aria-hidden="true"></i>保存',
						btnClass : 'btn-blue',
						action : function() {
							for (var i = 0; i < document.formDataIntroduce.elements.length - 1; i++) {
								if (document.formDataIntroduce.elements[i].value == "") {
									toastr.error("当前表单不能有空项");
									document.formDataIntroduce.elements[i]
											.focus();
									return false;
								}
							}
							$("#confirmDiv").hide();
							$("#addLoadingLayer").show();
							var formData = new FormData(document
									.getElementById("formDataIntroduce"));
							formData.append(
									'letter.xsjsglxt_introduce_letter_id',
									event.id);
							$
									.ajax({
										url : '/xsjsglxt/case/Handle_updateIntroduceLetter',
										type : 'POST',
										data : formData,
										processData : false,
										contentType : false,
										success : function(data) {
											toastr.success('保存成功！');
											queryConditionTemp.currPage = 1;
											loadData();
										}
									})
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
					$.datetimepicker.setLocale('ch');
					$('.startTime').datetimepicker({
						yearStart : 1900, // 设置最小年份
						yearEnd : 2100, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : false, // 关闭时间选项
						format : 'Y-m-d', // 格式化日期年-月-日
						minDate : '1900/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});
					$
							.ajax({
								url : '/xsjsglxt/case/Handle_getIntroduceLetterById?letter.xsjsglxt_introduce_letter_id='
										+ event.id,
								type : 'GET',
								success : function(data) {
									var returnData = JSON.parse(data);
									$('#introduce_letter_tounit').val(
											returnData.introduce_letter_tounit);
									$('#introduce_letter_introduceMan')
											.val(
													returnData.introduce_letter_introduceMan);
									$('#introduce_letter_number').val(
											returnData.introduce_letter_number);
									$('#introduce_letter_reasons')
											.val(
													returnData.introduce_letter_reasons);
									$('#introduce_time').val(
											returnData.introduce_time);
									$('#introduce_time_limit').val(
											returnData.introduce_time_limit);
								}
							})
				}
			})
}

var previewLetter = function(event) {
	$
			.confirm({
				boxWidth : '700px',
				useBootstrap : false,
				title : '<i class="fa fa-pencil-square-o"></i>预览介绍信',
				type : 'blue',
				content : '<div style="color: black; border: 1px solid black; padding:10px;">'
						+ '<h4><span style="float: right;">萍安公（刑）介字第<span id="introduce_letter_serial_number"></span>号</span></h4>'
						+ '<br><h4><b><span id="introduce_letter_tounit" style="text-decoration:underline; fon"></span></b></h4>'
						+ '<br><h4 style="margin-left:40px;">兹介绍<b id="human"></b>同志前往你处<span id="introduce_letter_reasons"></span>请接洽并希予以协助为荷。</h4>'
						+ '<br><h4 style="margin-left:90px;"><b>此致</b></h4>'
						+ '<br><h4><b>敬礼<b></h4>'
						+ '<br><h4 style="float: right;"><span id="year_"></span>年<span id="month_"></span>月<span id="day_"></span>日</h4>'
						+ '<br><h4>（限<span id="month_limit"></span>月<span id="day_limit"></span>日以前有效）</h4>'
						+ '</div>',
				buttons : {
					close : {
						text : "<i class='fa fa-times' aria-hidden='true'></i>关闭",
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
						maxDate : '2030/01/01', // 设置最大日期
					});
					$
							.ajax({
								url : '/xsjsglxt/case/Handle_getIntroduceLetterById?letter.xsjsglxt_introduce_letter_id='
										+ event.id,
								type : 'GET',
								success : function(data) {
									var returnData = JSON.parse(data);
									$('#introduce_letter_serial_number')
											.html(
													returnData.introduce_letter_serial_number);
									$('#introduce_letter_tounit').html(
											returnData.introduce_letter_tounit
													+ "：");
									$('#human')
											.html(
													returnData.introduce_letter_introduceMan
															+ "等"
															+ returnData.introduce_letter_number
															+ "名");
									$('#introduce_letter_reasons')
											.html(
													returnData.introduce_letter_reasons);
									$('#year_').html(
											returnData.introduce_time
													.substring(0, 4));
									$('#month_').html(
											returnData.introduce_time
													.substring(5, 7));
									$('#day_').html(
											returnData.introduce_time
													.substring(8, 10));
									var date = new Date(
											returnData.introduce_time);
									date
											.setDate(date.getDate()
													+ parseInt(returnData.introduce_time_limit));
									$('#month_limit').html(date.getMonth() + 1);
									$('#day_limit').html(date.getDate());
								}
							})
				}
			})
}

var approveLetter = function(event) {
	$.confirm({
		title : '确定要审批吗！',
		type : 'orange',
		content : '',
		autoClose : "cancel|10000",
		buttons : {
			'delete' : {
				text : '确定',
				action : function() {
					$.ajax({
						url : '/xsjsglxt/case/Handle_updateApproveStatus',
						type : 'POST',
						data : {
							'letter.xsjsglxt_introduce_letter_id' : event.id,
							'letter.introduce_approve_status' : '已审批'
						},
						success : function(data) {
							toastr.success("审批成功！可查看存根");
							loadData();
						}
					})
				}
			},
			'cancel' : {
				text : '取消',
				btnClass : 'btn-red'
			}
		}
	})
}
var showApproveStup = function(event) {
	$
			.confirm({
				boxWidth : '500px',
				useBootstrap : false,
				title : '介绍信存根',
				type : 'purple',
				content : '<table style="text-align:center; width:450px; margin:0 auto;">'
						+ '<tr><td style="width:150px;border:1px solid #DCDCDC;word-break: break-all;">被介绍人：</td><td id="1" style="border:1px solid #DCDCDC; width:300px;"></td></tr>'
						+ '<tr><td style="width:150px;border:1px solid #DCDCDC;word-break: break-all;">前往单位：</td><td id="2" style="border:1px solid #DCDCDC; width:300px;"></td></tr>'
						+ '<tr><td style="width:150px;border:1px solid #DCDCDC;word-break: break-all;">事由：</td><td id="3" style="border:1px solid #DCDCDC; width:300px;"></td></tr>'
						+ '<tr><td style="width:150px;border:1px solid #DCDCDC;word-break: break-all;">审批人：</td><td id="4" style="border:1px solid #DCDCDC; width:300px;"></td></tr>'
						+ '<tr><td style="width:150px;border:1px solid #DCDCDC;word-break: break-all;">审批日期：</td><td id="5" style="border:1px solid #DCDCDC; width:300px;"></td></tr>'
						+ '</table>',
				buttons : {
					'cancel' : {
						text : '关闭',
					}
				},
				onContentReady : function() {
					$
							.ajax({
								url : '/xsjsglxt/case/Handle_getIntroduceLetterById?letter.xsjsglxt_introduce_letter_id='
										+ event.id,
								type : 'GET',
								success : function(data) {
									var returnData = JSON.parse(data);
									$('#1')
											.html(
													returnData.introduce_letter_introduceMan
															+ '等'
															+ returnData.introduce_letter_number
															+ '名');
									$('#2').html(
											returnData.introduce_letter_tounit);
									$('#3')
											.html(
													returnData.introduce_letter_reasons);
									$('#4').html(
											returnData.introduce_approve_man);
									$('#5').html(
											returnData.introduce_approve_time);
								}
							})
				}
			});
}