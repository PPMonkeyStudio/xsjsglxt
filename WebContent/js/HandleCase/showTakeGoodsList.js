/**
 * 
 */
var takeGoodsVue;
var currSuspect;
var takeGoodsManager;
function takeGoodsPanel(event) {
	currSuspect = event.id;
	suspectManager.close();
	takeGoodsManager = $
			.confirm({
				title : '随身物品管理',
				type : 'orange',
				columnClass : 'col-md-12',
				content : '<button class="btn btn-default" onclick="saveTakeGoods()"><i class="fa fa-pencil-square-o"></i>增加随带物品</button>'
						+ '<table id="goodsListTable" class="table table-hover table-condensed" style="text-align: center;"><thead>'
						+ '<tr><td>物品名称</td><td>移交时间</td><td>移交人</td><td>接收人</td><td>处理时间</td><td>处理方式</td><td>操作</td><td>图片预览</td></tr></thead>'
						+ '<tbody><template v-for=" goods in goodsList "><tr>'
						+ '<td>{{ goods.goods_name }}</td>'
						+ '<td>{{ goods.goods_time }}</td>'
						+ '<td>{{ goods.goods_send_man }}</td>'
						+ '<td>{{ goods.goods_receive_man }}</td>'
						+ '<td>{{ goods.goods_process_time }}</td>'
						+ '<td>{{ goods.goods_process_method }}</td>'
						+ '<td><a onclick="updateGoods(this)" :id="goods.goods_id" class="pageOperation">修改</a>|<a onclick="deleteGoods(this)" :id="goods.goods_id" class="pageOperation">删除</a></td>'
						+ '<td><i onclick="previewPhoto(this)" :id="goods.goods_photo_path" class="fa fa-eye pageOperation"></i></td>'
						+ '</tr></template></tbody></table>',
				buttons : {
					returnLast : {
						text : '返回',
						btnClass : 'btn-blue',
						action : function() {
							suspectManager.open();
						}
					}
				},
				onContentReady : function() {
					takeGoodsVue = new Vue({
						el : '#goodsListTable',
						data : {
							goodsList : ''
						}
					})
					$
							.ajax({
								url : '/xsjsglxt/case/DealCase_getTakeGoodsBySuspectId',
								type : 'POST',
								data : {
									'suspectInfor.suspect_id' : event.id
								},
								success : function(data) {
									takeGoodsVue.goodsList = JSON.parse(data);
								}
							})
				}
			})
}

function saveTakeGoods() {
	takeGoodsManager.close();
	$
			.confirm({
				title : '增加随身物品',
				type : 'green',
				columnClass : 'col-md-12',
				content : '<form id="takeGoodsInfor"><table class="table table-bordered" style="text-align: center; ">'
						+ '<tr><td>物品名称：</td><td><input name="takeGoods.goods_name" type="text" class="form-control"></td>'
						+ '<td>移交时间：</td><td><input name="takeGoods.goods_time" type="text" class="form-control mydate"></td>'
						+ '<td>移交人：</td><td><input name="takeGoods.goods_send_man" type="text" class="form-control"></td>'
						+ '</tr><tr>'
						+ '<td>接收人：</td><td><input name="takeGoods.goods_receive_man" type="text" class="form-control"></td>'
						+ '<td>处理方式：</td><td><input name="takeGoods.goods_process_method" type="text" class="form-control"></td>'
						+ '<td>处理时间：</td><td><input name="takeGoods.goods_process_time" type="text" class="form-control mydate"></td>'
						+ '</tr>'
						+ '<tr><td>照片：</td><td><input name="goodsPhoto" type="file" class="form-control"></td></tr>'
						+ '</form></table>',
				buttons : {
					save : {
						text : '保存',
						btnClass : 'btn-blue',
						action : function() {
							var formData = new FormData(document
									.getElementById("takeGoodsInfor"));
							formData.append("takeGoods.goods_suspect",
									currSuspect);
							$.ajax({
								url : '/xsjsglxt/case/DealCase_saveTakeGoods',
								type : 'POST',
								data : formData,
								processData : false,
								contentType : false,
								success : function(data) {
									if (data == "saveSuccess") {
										toastr.success("保存成功！");
										takeGoodsManager.open();
									} else {
										toastr.error("保存失败！");
										takeGoodsManager.open();
									}
								}
							})
						}
					},
					cancel : {
						text : '关闭',
						btnClass : 'btn-red',
						action : function() {
							takeGoodsManager.open();
						}
					}
				},
				onContentReady : function() {
					$.datetimepicker.setLocale('ch');
					$('.mydate').datetimepicker({
						yearStart : 1950, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : true, // 关闭时间选项
						format : 'Y-m-d H:i', // 格式化日期年-月-日 时分
						minDate : '1900/01/01 00:00', // 设置最小日期
						maxDate : '2030/01/01 00:00', // 设置最大日期
					});
				}
			})
}

function updateGoods(event) {
	takeGoodsManager.close();
	$
			.confirm({
				title : '修改随身物品',
				type : 'green',
				columnClass : 'col-md-12',
				content : '<form id="takeGoodsInfor"><table class="table table-bordered" style="text-align: center; ">'
						+ '<tr><td>物品名称：</td><td><input id="goodsName" name="takeGoods.goods_name" type="text" class="form-control"></td>'
						+ '<td>移交时间：</td><td><input id="sendTime" name="takeGoods.goods_time" type="text" class="form-control mydate"></td>'
						+ '<td>移交人：</td><td><input id="sendMan" name="takeGoods.goods_send_man" type="text" class="form-control"></td>'
						+ '</tr><tr>'
						+ '<td>接收人：</td><td><input id="receiveMan" name="takeGoods.goods_receive_man" type="text" class="form-control"></td>'
						+ '<td>处理方式：</td><td><input id="dealMethod" name="takeGoods.goods_process_method" type="text" class="form-control"></td>'
						+ '<td>处理时间：</td><td><input id="dealTime" name="takeGoods.goods_process_time" type="text" class="form-control mydate"></td>'
						+ '</tr>'
						+ '<tr><td>照片：</td><td><input name="goodsPhoto" type="file" class="form-control"></td></tr>'
						+ '</form></table>',
				buttons : {
					save : {
						text : '保存',
						btnClass : 'btn-blue',
						action : function() {
							var formData = new FormData(document
									.getElementById("takeGoodsInfor"));
							formData.append("takeGoods.goods_id", event.id);
							$
									.ajax({
										url : '/xsjsglxt/case/DealCase_updateTakeGoods',
										type : 'POST',
										data : formData,
										processData : false,
										contentType : false,
										success : function(data) {
											if (data == "updateSuccess") {
												toastr.success("保存成功！");
												takeGoodsManager.open();
											} else {
												toastr.error("保存失败！");
												takeGoodsManager.open();
											}
										}
									})
						}
					},
					cancel : {
						text : '关闭',
						btnClass : 'btn-red',
						action : function() {
							takeGoodsManager.open();
						}
					}
				},
				onContentReady : function() {
					$.ajax({
						url : '/xsjsglxt/case/DealCase_getTakeGoodsById',
						type : 'POST',
						data : {
							'takeGoods.goods_id' : event.id
						},
						success : function(data) {
							var goods = JSON.parse(data);
							$('#goodsName').val(goods.goods_name);
							$('#sendTime').val(goods.goods_time);
							$('#sendMan').val(goods.goods_send_man);
							$('#receiveMan').val(goods.goods_receive_man);
							$('#dealMethod').val(goods.goods_process_method);
							$('#dealTime').val(goods.goods_process_time);
						}
					})

					$.datetimepicker.setLocale('ch');
					$('.mydate').datetimepicker({
						yearStart : 1950, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : true, // 关闭时间选项
						format : 'Y-m-d H:i', // 格式化日期年-月-日 时分
						minDate : '1900/01/01 00:00', // 设置最小日期
						maxDate : '2030/01/01 00:00', // 设置最大日期
					});
				}
			})
}

function deleteGoods(event) {
	takeGoodsManager.close();
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
							$
									.ajax({
										url : "/xsjsglxt/case/DealCase_deleteTakeGoods",
										type : "POST",
										data : {
											"takeGoods.goods_id" : event.id
										},
										success : function(data) {
											if (data == "deleteSuccess") {
												toastr.success("删除成功");
												takeGoodsManager.open();
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
							takeGoodsManager.open();
						}

					}
				}
			});
}
function previewPhoto(event) {
	var filename = event.id;
	filename = filename.substring(filename.lastIndexOf("\\") + 1);
	console.log(filename);
	takeGoodsManager.close();
	$
			.confirm({
				title : '预览',
				boxWidth : '800px',
				useBootstrap : false,
				content : '<img alt="" src="/xsjsglxt/case/DealCase_downloadTakeGoods?downloadFileName='
						+ filename + '">',
				buttons : {
					close : {
						text : '关闭',
						action : function() {
							takeGoodsManager.open();
						}
					}
				}
			})
}