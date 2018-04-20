$.fn.extend({
	serializeObject: function () {
		if (this.length > 1) {
			return false;
		}
		var arr = this.serializeArray();
		var obj = new Object;
		$.each(arr, function (k, v) {
			obj[v.name] = v.value;
		});
		return obj;
	}
});

function transferOperation(params) {
	var case_id = $(params).attr('id');
	var resevidence_id = $(params).attr('value');
	var transfer = $.confirm({
		closeIcon: true,
		type: 'blue',
		useBootstrap: true,
		columnClass: 'col-md-12',
		smoothContent: false,
		title: '流转记录添加',
		content: `<form>
				  <table style="width: 100%;" class="table">
				  <tbody>
				  <tr>
				  <td>物证名称:</td>
				  <td colspan="3"><input
				  name="resevidence.resevidence_name"
				  class="form-control disabled" type="text"></td>
				  </tr>
				  <tr>
				  <td style="width: 20%;">提取方法:</td>
				  <td style="width: 30%;"><input 
				  name="resevidence.resevidence_extractMethod" 
				  class="form-control disabled" type="text"></td>
				  <td style="width: 20%;">提取数量:</td>
				  <td style="width: 30%;"><input
				  name="resevidence.resevidence_extractNumber" 
				  class="form-control disabled" type="text"></td>
				  </tr>
				  <tr>
				  <td>提取单位:</td>
				  <td><input name="resevidence.resevidence_extractUnit" 
				  type="text" refresh="fixed" class="form-control disabled"
				  value="安源分局刑事科学技术室"></td>
				  <td>提取人:</td>
				  <td><input name="resevidence.resevidence_extractPerson" 
				  class="form-control disabled" type="text"></td>
				  </tr>
				  <tr>
				  <td>提取日期:</td>
				  <td><input name="resevidence.resevidence_extractTime" 
				  class="form-control disabled" type="text"></td>
				  </tr>
				  <tr>
				  <td>流转情况</td>
				  <td><select name="circulation.circulation_situation"
				  class="form-control">
				  <option value=""></option>
				  <option value="入库保存">入库保存</option>
				  <option value="出库送检">出库送检</option>
				  <option value="出库移交">出库移交</option>
				  </select></td>
				  <td style="display:none;">存放位置</td>
				  <td style="display:none;"><input name="circulation.circulation_position"
				  class="form-control" value="" type="text"></td>
				  </tr>
				  <tr>
				  <td>流转日期</td>
				  <td><input name="circulation.circulation_date"
				  class="form-control mydate" type="text"></td>
				  </tr>
				  <tr>
				  <td><span style='color: #ff5063;'>*</span>移交人</td>
				  <td><input name="circulation.circulation_transferperson"
				  class="form-control must" type="text"></td>
				  <td><span style='color: #ff5063;'>*</span>接收人</td>
				  <td><input name="circulation.circulation_recipient"
				  class="form-control must" type="text"></td>
				  </tr>
				  </tbody>
				  </table>
				  </form>`,
		onContentReady: function () {
			$.post('/xsjsglxt/case/Resevidence_ResevidenceInformationOne', { "resevidence.xsjsglxt_resevidence_id": resevidence_id }, function (msg) {
				transfer.$content.find('form input').each(function () {
					var name = $(this).attr('name');
					var key = name.split('.')[1];
					$(this).val(msg["resevidence"][key]);
				});
			}, 'json');
			$('.mydate').datetimepicker({
				yearStart: 1990, // 设置最小年份
				yearEnd: 2050, // 设置最大年份
				yearOffset: 0, // 年偏差
				timepicker: false, // 关闭时间选项
				format: 'Y-m-d', // 格式化日期年-月-日
				minDate: '1990/01/01', // 设置最小日期
				maxDate: '2030/01/01', // 设置最大日期
			});
			transfer.$content.find('select[name="circulation.circulation_situation"]').change(function () {
				if ($(this).val() == "入库保存") {
					$(this).parent().nextAll().show();
				} else {
					$(this).parent().nextAll().hide();
				}
			});
		},
		buttons: {
			sureAddProson: {
				text: "确认添加",
				btnClass: 'btn-info',
				action: function () {
					var must = transfer.$content.find('.must');
					for (let index = 0; index < must.length; index++) {
						if (must.eq(index).val() == "") {
							toastr.info('信息未填写完整，请检查空项信息!');
							return false;
						}
					}
					var data_ = $.extend({}, transfer.$content.find('form').serializeObject(), { "resevidence.xsjsglxt_resevidence_id": resevidence_id });
					$.post('/xsjsglxt/case/Resevidence_saveCirculation', data_, function (msg) {
						if (msg == "success") {
							toastr.info('修改成功');
						}
					}, 'text');
				}
			},
			close: {
				text: "取消"
			}
		}
	});
}



function transferProcess(params) {
	var case_id = $(params).attr('id');
	var resevidence_id = $(params).attr('value');
	var transfer = $.confirm({
		closeIcon: true,
		type: 'blue',
		useBootstrap: true,
		columnClass: 'col-md-12',
		smoothContent: false,
		title: '流转记录汇总',
		content: `<table style="width: 100%;" class="table">
				  <thead>
				  <tr>
				  <th>流转状态</th>
				  <th>存放位置</th>
				  <th>流转日期</th>
				  <th>交移人</th>
				  <th>接收人</th>
				  </tr>
				  </thead>	  
				  <tbody>
				  </tbody>
				  </table>`,
		onContentReady: function () {
			$.post('/xsjsglxt/case/Resevidence_getCirculationList', { "resevidence.xsjsglxt_resevidence_id": resevidence_id }, function (msg) {
				var tr = '';
				$.each(msg, function (i, josnobj) {
					tr += `<tr><th>${josnobj.circulation_situation}</th>
							   <th>${josnobj.circulation_position == undefined ? "无" : josnobj.circulation_position}</th>
							   <th>${josnobj.circulation_date}</th>
							   <th>${josnobj.circulation_transferperson}</th>
							   <th>${josnobj.circulation_recipient}</th></tr>`;
				});
				transfer.$content.find('table tbody').html(tr);
			}, 'json');
		},
		buttons: {
			close: {
				text: "确认"
			}
		}
	});
}