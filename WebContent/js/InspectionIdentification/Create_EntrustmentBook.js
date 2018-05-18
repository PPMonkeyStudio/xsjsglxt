document.getElementById("button_Create_TranceCheckEntrustmentBook").onclick = function() {
	Create_EntrustmentBook("痕迹");
}
document.getElementById("button_Create_ForensicCheckEntrustmentBook").onclick = function() {
	Create_EntrustmentBook("法医");
}
/*
 * 创建检验委托书
 */
function Create_EntrustmentBook(type) {
	var jc = $
			.confirm({
				title : '',
				type : 'blue',
				theme : 'modern',
				columnClass : 'col-md-12',
				content : '<hr>'
						+ '<h3>委托人声明</h3>'
						+ '<h4>本人忠于事实真相，送检的检材/样本/材料真实。如有虚假，愿意承担相关法律责任.</h4>'
						+ '<hr style="margin:30px 0;">'
						+ '<form id="form_EntrustmentBook">'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr>'
						+ '<td><span style="color:#D9534F;">*</span> 负责人：</td><td><input  name="tranceCheckBook.check_entrustment_book_responsible_person" class="form-control"  /></td>'
						+ '<td><span style="color:#D9534F;">*</span> 委托单位：</td><td><select class="form-control" name="tranceCheckBook.check_entrustment_book_entrustment_unit">'
						+ '<option id="check_entrustment_book_entrustment_unit_aygafjxjdd" value="安源公安分局刑警大队">安源公安分局刑警大队</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_ay" value="安源派出所">安源派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_cj" value="城郊派出所">城郊派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_fh" value="凤凰派出所">凤凰派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_hf" value="后埠派出所">后埠派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_by" value="八一派出所">八一派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_dd" value="东大派出所">东大派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_qs" value="青山派出所">青山派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_dj" value="丹江派出所">丹江派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_by" value="白源派出所">白源派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_gk" value="高坑派出所">高坑派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_wpx" value="五陂下派出所">五陂下派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_lzy" value="李子园派出所">李子园派出所</option>'
						+ '<option id="check_entrustment_book_entrustment_unit_qt" value="其他">其他</option>'
						+ '</select></td>'
						+ '<td><span style="color:#D9534F;">*</span> 委托时间：</td><td><input name="tranceCheckBook.check_entrustment_book_inspect_time" class="form-control mydate"  /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td>送检人</td><td><span style="color:#D9534F;">*</span> 姓名</td><td><span style="color:#D9534F;">*</span> 职务</td><td><span style="color:#D9534F;">*</span> 证件名称及号码</td></tr>'
						+ '<tr><td>送检人一：</td><td><input name="tranceCheckBook.check_entrustment_book_inspectors1_name"  class="form-control" /></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors1_duty"   class="form-control" /></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors1_jobcard_number"   class="form-control" /></td></tr>'
						+ '<tr><td>送检人二：</td><td><input name="tranceCheckBook.check_entrustment_book_inspectors2_name"   class="form-control" /></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors2_duty"   class="form-control" /></td><td><input name="tranceCheckBook.check_entrustment_book_inspectors2_jobcard_number"   class="form-control" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 通讯地址：</td><td><input  class="form-control" name="tranceCheckBook.check_entrustment_book_communication_address" /></td><td><span style="color:#D9534F;">*</span> 邮政编码：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_zip_code" value="337000" /></td></tr>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 联系电话：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_phone" /></td><td><span style="color:#D9534F;">*</span> 传真号码：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_fax_num" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<div id="div_ForensicCheckEntrustmentBook">'
						+ '<h4>被鉴定人的情况：</h4>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 姓名：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_name" /></td><td>性别：</td><td><select class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_sex" >'
						+ '<option value="男">男</option>'
						+ '<option value="女">女</option>'
						+ '</select></td></tr>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 身份证：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_unit" /></td><td><span style="color:#D9534F;">*</span> 电话：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_phone" /></td></tr>'
						+ '<tr><td>住址：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_address" /></td><td>年龄：</td><td><input class="form-control" name="tranceCheckBook.check_entrustment_book_entrustmentor_age" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '</div>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 被委托鉴定机构名称：</td>'
						+ '<td><select class="form-control" name="tranceCheckBook.check_entrustment_book_entrustment_unit_name" >'
						+ '<option value="萍乡市安源区公安司法鉴定中心">萍乡市安源区公安司法鉴定中心</option>'
						+ '<option value="萍乡市司法鉴定中心">萍乡市司法鉴定中心</option>'
						+ '<option value="萍乡市公安司法鉴定中心">萍乡市公安司法鉴定中心</option>'
						+ '<option value="萍乡市公安局物证鉴定所">萍乡市公安局物证鉴定所</option>'
						+ '<option value="江西省公安厅物证鉴定中心">江西省公安厅物证鉴定中心</option>'
						+ '<option value="公安部物证鉴定中心">公安部物证鉴定中心</option>'
						+ '</select></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 案（事）件名称：</td>'
						+ '<td><input class="form-control" name="tranceCheckBook.check_entrustment_book_case_name" /></td></tr>'
						+ '<tr><td>案件编号：</td>'
						+ '<td><input class="form-control" name="tranceCheckBook.check_entrustment_book_case_num" /></td></tr>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 简要案情：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" name="tranceCheckBook.check_entrustment_book_simple_case_situation" ></textarea></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<h4>原鉴定情况：</h4>'
						+ '<textarea class="form-control" style="resize: none;height:100px;" name="tranceCheckBook.check_entrustment_book_old_entrustment_situation" ></textarea>'
						+ '<h4><span style="color:#D9534F;">*</span>'
						+ (type == '痕迹' ? '送检的检材和样本等情况（包括名称、数量、性状、包装，检材提取部位和方法等）'
								: '送检材料')
						+ '：</h4>'
						+ '<textarea class="form-control" style="resize: none;height:100px;" name="tranceCheckBook.check_entrustment_book_sample_situation" ></textarea>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><span style="color:#D9534F;">*</span> 鉴定要求</td>'
						+ '<td><select class="form-control" name="tranceCheckBook.check_entrustment_book_entrustment_request" >'
						+ '<option class="EntrustmentRequest_Trance" value="指纹检验鉴定">指纹检验鉴定</option>'
						+ '<option  class="EntrustmentRequest_Trance" value="足迹检验鉴定">足迹检验鉴定</option>'
						+ '<option  class="EntrustmentRequest_Trance" value="整体分离检验鉴定">整体分离检验鉴定</option>'
						+ '<option  class="EntrustmentRequest_Trance" value="车辆痕迹检验鉴定">车辆痕迹检验鉴定</option>'
						+ '<option class="EntrustmentRequest_Forensic"  value="损伤鉴定">损伤鉴定</option>'
						+ '<option class="EntrustmentRequest_Forensic"  value="死因鉴定">死因鉴定</option>'
						+ '<option  class="EntrustmentRequest_Trance" value="理化检验鉴定">理化检验鉴定</option>'
						+ '<option  class="EntrustmentRequest_Trance" value="毒物检验鉴定">毒物检验鉴定</option>'
						+ '<option  class="EntrustmentRequest_Trance" value="失踪人口查询">失踪人口查询</option>'
						+ '<option value="其他">其他</option>'
						+ '</select><input class="form-control" id="check_entrustment_book_entrustment_request_qt"  style="margin:10px 0 0 0;" placeholder="若选择 [其他] 则填写在此处" /></td></tr>'
						+ '</tbody>' + '</table>' + '</form>' + '<hr>',

				onOpenBefore : function() {
					if (type == '痕迹') {
						/*
						 * 
						 */
						var div_ForensicCheckEntrustmentBook = document
								.getElementById("div_ForensicCheckEntrustmentBook");
						div_ForensicCheckEntrustmentBook.parentNode
								.removeChild(div_ForensicCheckEntrustmentBook);
						jc.setTitle("检验鉴定委托书（通用）");
						/*
						 * 按照鉴定类型删除鉴定要求中不需要的option
						 */
						var EntrustmentRequest_Options = document
								.getElementsByClassName("EntrustmentRequest_Forensic");

						var EntrustmentRequest_Options_Length = EntrustmentRequest_Options.length;
						for (var num = 0; num < EntrustmentRequest_Options_Length; num++) {
							EntrustmentRequest_Options[0].parentNode
									.removeChild(EntrustmentRequest_Options[0]);
						}
						/*
						 * 
						 */
					} else {
						/*
						 * 
						 */
						jc.setTitle("法医检验鉴定委托书");
						/*
						 * 按照鉴定类型删除鉴定要求中不需要的option
						 */
						var EntrustmentRequest_Options = document
								.getElementsByClassName("EntrustmentRequest_Trance");

						var EntrustmentRequest_Options_Length = EntrustmentRequest_Options.length;
						for (var num = 0; num < EntrustmentRequest_Options_Length; num++) {
							EntrustmentRequest_Options[0].parentNode
									.removeChild(EntrustmentRequest_Options[0]);
						}
						/*
						 * 
						 */
					}

				},
				onContentReady : function() {
					/*
					 * 
					 * 
					 * 获取送检人信息
					 * 
					 * 
					 */
					var xhr = false;
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						var message;
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								var currUser = JSON.parse(xhr.responseText);
								/*
								 * 送检人
								 */
								if (currUser.user_name != null) {
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_inspectors1_name")[0].value = currUser.user_name;
								}
								if (currUser.user_duty != null) {
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_inspectors1_duty")[0].value = currUser.user_duty;
								}
								if (currUser.user_idCard != null) {
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_inspectors1_jobcard_number")[0].value = currUser.user_idCard;
								}
								/*
								 * 获取单位的通讯录信息
								 */
								switch (currUser.user_units) {
								case '安源公安分局刑警大队': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_aygafjxjdd").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6333683";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6333683";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区后埠街建设中路100号";

									break;
								}
								case '安源派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_ay").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6351007";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6351007";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区燎原中大道1号";
									break;
								}
								case '城郊派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_cj").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6852109";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6852109";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区城郊管理委员会旁";
									break;
								}
								case '凤凰派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_fh").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6832693";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6832693";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区萍水北路8号";
									break;
								}
								case '后埠派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_hf").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6333468";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6333468";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区后埠街山下路58号";
									break;
								}
								case '八一派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_by").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6832498";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6832498";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区八一街萍乡中学旁";
									break;
								}
								case '东大派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_dd").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6832591";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6832591";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区环城南路311号";
									break;
								}
								case '青山派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_qs").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6381110";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6381110";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区青山镇乌石青山路青山中心幼儿园对面";
									break;
								}
								case '丹江派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_dj").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6671596";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6671596";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区丹江街江矿社区居委会斜对面";
									break;
								}
								case '白源派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_by").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6651110";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6651110";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区白源街兴业南路附近";
									break;
								}
								case '高坑派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_gk").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6371348";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6371348";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区高坑镇车谷岭70号";
									break;
								}
								case '五陂下派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_wpx").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6311110";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6311110";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "安源区安源南大道与永镇路交叉口东北100米";
									break;
								}
								case '李子园派出所': {
									document
											.getElementById("check_entrustment_book_entrustment_unit_lzy").selected = "selected";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_phone")[0].value = "6833386";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_fax_num")[0].value = "6833386";
									document
											.getElementsByName("tranceCheckBook.check_entrustment_book_communication_address")[0].value = "无";
									break;
								}
								default: {
									document
											.getElementById("check_entrustment_book_entrustment_unit_qt").selected = "selected";
									break;
								}

								}
								/*
								 * 
								 */
							} else {
								toastr.error(xhr.status);
							}
						}
					}
					var formData = new FormData();
					xhr.open("POST", "/xsjsglxt/user/User_getCurrUser");
					xhr.send(formData);

					/*
					 * 
					 * 
					 * 获取日期
					 * 
					 * 
					 */
					var date = new Date();
					var month = (parseInt(date.getMonth()) + 1);
					if (month < 10)
						month = "0" + "" + month;
					var day = date.getDate();
					if (day < 10)
						day = "0" + "" + day;
					document
							.getElementsByName("tranceCheckBook.check_entrustment_book_inspect_time")[0].value = date
							.getFullYear()
							+ '-' + month + '-' + day;
					$.datetimepicker.setLocale('ch');
					$('.mydate').datetimepicker({
						yearStart : 1990, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : false, // 关闭时间选项
						format : 'Y-m-d', // 格式化日期年-月-日
						minDate : '1990/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});
					/*
					 * 
					 * 
					 * 
					 * 
					 * 
					 */
				},
				buttons : {
					'确认委托' : {
						btnClass : 'btn-blue',
						action : function() {
							/*
							 * 
							 */
							jc.showLoading(false);
							/*
							 * 
							 */
							var xhr = false;
							xhr = new XMLHttpRequest();
							xhr.onreadystatechange = function() {
								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										console.debug(xhr.responseText);
										if (xhr.responseText == 1) {
											toastr.success("保存成功");
											jc.close();
											List_EntrustmentBook(1);
										} else {
											toastr.error("填写格式错误");
											/*
											 * 
											 */
											jc.hideLoading(true);
											/*
											 * 
											 */
										}
									} else {
										toastr.error(xhr.status);
										/*
										 * 
										 */
										jc.hideLoading(true);
										/*
										 * 
										 */
									}
								}
							}
							/*
							 * 
							 */
							/*
							 * 
							 */
							var formData = new FormData(document
									.getElementById("form_EntrustmentBook"));
							/*
							 * 鉴定要求
							 */
							if (document
									.getElementsByName("tranceCheckBook.check_entrustment_book_entrustment_request")[0].value == '其他') {
								formData
										.set(
												"tranceCheckBook.check_entrustment_book_entrustment_request",
												document
														.getElementById("check_entrustment_book_entrustment_request_qt").value);
							}
							/*
							 * 
							 */
							if (type == '痕迹') {
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_type",
												'痕迹');
								/*
								 * 
								 */
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_entrustmentor_name",
												'/');
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_entrustmentor_sex",
												'/');
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_entrustmentor_phone",
												'/');
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_entrustmentor_age",
												'/');
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_entrustmentor_unit",
												'/');
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_entrustmentor_address",
												'/');
								/*
								 * 
								 */
							} else {
								formData
										.append(
												"tranceCheckBook.check_entrustment_book_type",
												'法医');
							}
							/*
							 * 
							 */
							xhr
									.open("POST",
											"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addCheckBook");
							xhr.send(formData);
							return false;
						}
					},
					'放弃委托' : function() {
					}
				}
			});
}