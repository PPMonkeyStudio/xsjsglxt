/**
 * 
 */

var postData = {
	'leader' : '',
	'main' : '',
	'mainTech' : '',
	'mainDoctor' : '',
	'assistantSpy' : '',
	'assistantTech' : '',
	'indexDays' : '',
	'scheduling_days' : '',
	'mainTechType' : ''
}

var chooseStaff = function(inputId) {
	$
			.confirm({
				cloumnClass : '400px',
				useBootstrap : false,
				title : '挑选人员',
				type : 'red',
				content : '<select onchange="changeDuty(this)" class="form-control" style="float:top; width: 200px; margin-bottom: 10px;">'
						+ '<option value="">请选择职位</option>'
						+ '<option value="局长">局长</option>'
						+ '<option value="政委">政委</option>'
						+ '<option value="副局长">副局长</option><option value="大队长">大队长</option><option value="教导员">教导员</option><option value="副大队长">副大队长</option><option value="副教导员">副教导员</option><option value="中队长">中队长</option><option value="副中队长">副中队长</option><option value="室主任">室主任</option><option value="指导员">指导员</option><option value="侦查民警">侦查民警</option><option value="技术民警">技术民警</option><option value="法医民警">法医民警</option><option value="内勤民警">内勤民警</option><option value="侦查辅警">侦查辅警</option><option value="技术辅警">技术辅警</option></select>'
						+ '<table style="margin:0 auto;"><tr>'
						+ '<td><div style="display:inline-block; border:1px solid black; width:200px; height:300px; overflow:auto;">'
						+ '<ul id="no_choose"></ul>'
						+ '</div></td>'
						+ '<td><div style="display:inline-block;  margin:0 auto;"><button class="btn btn-default" style="display:inline-block;" onclick="intoAll()"><i class="fa fa-arrow-right"></i>全进</button><br><br>'
						+ '<button onclick="outAll()" class="btn btn-default" style="display:inline-block;"><i class="fa fa-arrow-left"></i>全出</button></div><td>'
						+ '<td><div style="display:inline-block; border:1px solid black; width:200px; height:300px; overflow:auto;">'
						+ '<ul id="choose_"></ul>' + '</div></td></tr></table>',
				buttons : {
					ok : {
						text : '添加',
						btnClass : 'btn-blue',
						action : function() {
							var staffList = document
									.getElementsByName("chooseStaffList");
							var str = "";
							var staffData = [];
							for (var int = 0; int < staffList.length; int++) {
								staffData[int] = staffList[int].innerHTML;
							}
							if (staffData.length > 0)
								document.getElementById(inputId).value = staffData
										.join('、');
							else {
								document.getElementById(inputId).value = "";
							}
							switch (inputId) {
							case "leader":
								postData.leader = staffData;
								break;
							case "main":
								postData.main = staffData;
								break;
							case "mainTech":
								postData.mainTech = staffData;
								break;
							case "mainDoctor":
								postData.mainDoctor = staffData;
								break;
							case "assistantSpy":
								postData.assistantSpy = staffData;
								break;
							case "assistantTech":
								postData.assistantTech = staffData;
								break;
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
					var inputGet = document.getElementById(inputId).value;
					if (inputGet != '') {
						if (inputGet.indexOf('、') > -1) {
							var sta = inputGet.split('、');
							var str = "";
							for (var int = 0; int < sta.length; int++) {
								str = str
										+ '<li onclick="outoChoose(this)" name="chooseStaffList">'
										+ sta[int] + '</li>';
							}
							document.getElementById("choose_").innerHTML = str;
						} else {
							var str = "";
							str = str
									+ '<li onclick="outoChoose(this)" name="chooseStaffList">'
									+ inputGet + '</li>';
							document.getElementById("choose_").innerHTML = str;
						}
					}
					$
							.ajax({
								type : 'GET',
								url : '/xsjsglxt/team/Staff_getAllStaff',
								success : function(data) {
									var jsonData = JSON.parse(data);
									var str = '';
									for (var int = 0; int < jsonData.length; int++) {
										var flag = 0;
										var allStaff = document
												.getElementsByName("chooseStaffList");
										for (var i = 0; i < allStaff.length; i++) {
											if (jsonData[int].xsjsglxt_name != allStaff[i].innerHTML) {

											} else {
												flag = 1;
												break;
											}
										}
										if (flag == 0)
											str = str
													+ '<li onclick="intoChoose(this)" name="staffList">'
													+ jsonData[int].xsjsglxt_name
													+ '</li>'
									}
									$('#no_choose').html(str);
								}
							});
				}
			})
}
var intoChoose = function(event) {
	var allStaff = document.getElementsByName("staffList");
	var index_ = $(event).index();
	document.getElementById("choose_").innerHTML = document
			.getElementById("choose_").innerHTML
			+ '<li name="chooseStaffList" onclick="outoChoose(this)">'
			+ allStaff[index_].innerHTML + '</li>'
	$(allStaff[index_]).remove();
}

var outoChoose = function(event) {
	var allStaff = document.getElementsByName("chooseStaffList");
	var index_ = $(event).index();
	document.getElementById("no_choose").innerHTML = document
			.getElementById("no_choose").innerHTML
			+ '<li name="staffList" onclick="intoChoose(this)">'
			+ allStaff[index_].innerHTML + '</li>'
	$(allStaff[index_]).remove();
}

var intoAll = function() {
	document.getElementById("choose_").innerHTML = document
			.getElementById("choose_").innerHTML
			+ document.getElementById("no_choose").innerHTML;
	document.getElementById("choose_").innerHTML = document
			.getElementById("choose_").innerHTML.replace(/intoChoose/g,
			'outoChoose');
	document.getElementById("choose_").innerHTML = document
			.getElementById("choose_").innerHTML.replace(/staffList/g,
			'chooseStaffList');
	document.getElementById("no_choose").innerHTML = "";
}
var outAll = function() {
	document.getElementById("no_choose").innerHTML = document
			.getElementById("no_choose").innerHTML
			+ document.getElementById("choose_").innerHTML;
	document.getElementById("no_choose").innerHTML = document
			.getElementById("no_choose").innerHTML.replace(/outoChoose/g,
			'intoChoose');
	document.getElementById("no_choose").innerHTML = document
			.getElementById("no_choose").innerHTML.replace(/chooseStaffList/g,
			'staffList');
	document.getElementById("choose_").innerHTML = "";
}

var changeDuty = function(event) {
	$
			.ajax({
				type : 'GET',
				url : '/xsjsglxt/team/Staff_getAllStaff?query_duty='
						+ event.value,
				success : function(data) {
					var jsonData = JSON.parse(data);
					var str = '';
					for (var int = 0; int < jsonData.length; int++) {
						var flag = 0;
						var allStaff = document
								.getElementsByName("chooseStaffList");
						for (var i = 0; i < allStaff.length; i++) {
							if (jsonData[int].xsjsglxt_name != allStaff[i].innerHTML) {

							} else {
								flag = 1;
								break;
							}
						}
						if (flag == 0)
							str = str
									+ '<li onclick="intoChoose(this)" name="staffList">'
									+ jsonData[int].xsjsglxt_name + '</li>'
					}
					$('#no_choose').html("");
					$('#no_choose').html(str);
				}
			})
}
var createScheduling = function() {
	$
			.confirm({
				cloumnClass : '500px',
				useBootstrap : false,
				title : '<i class="fa fa-pencil-square-o"></i>新增排班',
				type : 'green',
				content : '<table class="table bordered-table" style="text-align:center;"><tr><td><button onclick="chooseStaff(\'leader\')" class="btn btn-default">带班领导</button></td><td colspan="2"  class="contentName"><input id="leader" style="width: 250px;" class="form-control" readonly="true"></td></tr>'
						+ '<tr><td><button onclick="chooseStaff(\'main\')" class="btn btn-default">侦查民警</button></td><td colspan="2" class="contentName"><input id="main" style="width: 250px;" class="form-control" readonly="true"></td></tr>'
						+ '<tr><td><button onclick="chooseStaff(\'mainTech\')" class="btn btn-default">技术民警</button></td><td class="contentName"><input id="mainTech" style="width: 250px;" class="form-control" readonly="true"></td><td><select class="form-control" id="personNumber"><option value="1">单人</option><option value="2">双人</option></select></td></tr>'
						+ '<tr><td><button onclick="chooseStaff(\'mainDoctor\')" class="btn btn-default">法医民警</button></td><td colspan="2" class="contentName"><input id="mainDoctor" style="width: 250px;" class="form-control" readonly="true"></td></tr>'
						+ '<tr><td><button onclick="chooseStaff(\'assistantSpy\')" class="btn btn-default">侦查辅警</button></td><td colspan="2" class="contentName"><input id="assistantSpy" style="width: 250px;" class="form-control" readonly="true"></td></tr>'
						+ '<tr><td><button onclick="chooseStaff(\'assistantTech\')" class="btn btn-default">技术辅警</button></td><td colspan="2" class="contentName"><input id="assistantTech" style="width: 250px;" class="form-control" readonly="true"></td></tr>'
						+ '<tr><td>值班首日：</td><td colspan="2"><input id="scheTime" style="width:250px" class="form-control timeDate"></td></tr>'
						+ '<tr><td>安排天数：</td><td colspan="2"><input id="dayTime" style="width:250px" class="form-control" placeholder="请输入数字"></td></tr></table>',
				buttons : {
					save : {
						text : '<i class="fa fa-upload" aria-hidden="true"></i>保存',
						btnClass : 'btn-blue',
						action : function() {
							if ($('#leader').val() != ''
									&& $('#main').val() != ''
									&& $('#assistantSpy').val() != ''
									&& $('#assistantTech').val() != ''
									&& $('#mainDoctor').val() != ''
									&& $('#scheTime').val() != ''
									&& $('#mainTech').val() != '') {
								postData.indexDays = $('#scheTime').val();
								postData.scheduling_days = $('#dayTime').val();
								postData.mainTechType = $('#personNumber')
										.val();
								var formData = new FormData();
								for (var int = 0; int < postData.leader.length; int++) {
									formData.append("leader",
											postData.leader[int]);
								}
								for (var int = 0; int < postData.main.length; int++) {
									formData.append("main", postData.main[int]);
								}
								for (var int = 0; int < postData.assistantSpy.length; int++) {
									formData.append("assistantSpy",
											postData.assistantSpy[int]);
								}
								for (var int = 0; int < postData.assistantTech.length; int++) {
									formData.append("assistantTech",
											postData.assistantTech[int]);
								}
								for (var int = 0; int < postData.mainDoctor.length; int++) {
									formData.append("mainDoctor",
											postData.mainDoctor[int]);
								}
								for (var int = 0; int < postData.mainTech.length; int++) {
									formData.append("mainTech",
											postData.mainTech[int]);
								}
								formData.append("scheduling_days",
										postData.scheduling_days);
								formData
										.append("indexDays", postData.indexDays);
								formData.append("mainTechType",
										postData.mainTechType);
								$
										.ajax({
											url : '/xsjsglxt/scheduling/Scheduling_saveScheduling',
											type : 'POST',
											data : formData,
											contentType : false, // 注意这里应设为false
											processData : false,
											success : function(data) {
												if (data == "saveSuccess") {
													toastr.success("保存成功！");
													queryConditionTemp.currPage = 1;
													loadScheduling();
													// 在次数重新加载列表
												} else
													toastr.error("该日已经排班");
											}
										});
							} else {
								toastr.error("不能有空项");
								return false;
							}
							$('#tableContent').hide();
							$('#loadingLayer').show();
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