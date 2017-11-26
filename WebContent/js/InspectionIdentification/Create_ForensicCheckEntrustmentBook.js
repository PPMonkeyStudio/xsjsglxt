document.getElementById("button_Create_ForensicCheckEntrustmentBook").onclick = function() {
	Create_ForensicCheckEntrustmentBook();
}

function Create_ForensicCheckEntrustmentBook() {
	var js = $
			.confirm({
				title : '法医检验鉴定委托书',
				content : '<hr>'
						+ '<h3>委托人声明</h3>'
						+ '<h4>本人忠于事实真相，送检的检材/样本/材料真实。如有虚假，愿意承担相关法律责任.</h4>'
						+ '<hr style="margin:30px 0;">'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 负责人：</td><td><input   class="form-control" id="" /></td>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 委托单位：</td><td><input   class="form-control" id="input_trance_check_entrustment_book_entrustment_unit" /></td>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 委托时间：</td><td><input class="form-control" id="input_trance_check_entrustment_book_inspect_time" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<br>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td>送检人</td><td><i class="fa fa-warning" style="color:#D9534F;"></i> 姓名</td><td><i class="fa fa-warning" style="color:#D9534F;"></i> 职务</td><td><i class="fa fa-warning" style="color:#D9534F;"></i> 证件名称及号码</td></tr>'
						+ '<tr><td>送检人一：</td><td><input   class="form-control" /></td><td><input   class="form-control" /></td><td><input   class="form-control" /></td></tr>'
						+ '<tr><td>送检人二：</td><td><input   class="form-control" /></td><td><input   class="form-control" /></td><td><input   class="form-control" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td>通讯地址：</td><td><input class="form-control" /></td><td>邮政编码：</td><td><input class="form-control" /></td></tr>'
						+ '<tr><td>联系电话：</td><td><input class="form-control" /></td><td>传真号码：</td><td><input class="form-control" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<br>'
						+ '<br>'
						+ '<h4>被鉴定人的情况：</h4>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 姓名：</td><td><input class="form-control" /></td><td>性别：</td><td><select class="form-control">'
						+ '<option value="男">男</option>'
						+ '<option value="女">女</option>'
						+ '</select></td></tr>'
						+ '<tr><td>单位：</td><td><input class="form-control" /></td><td><i class="fa fa-warning" style="color:#D9534F;"></i> 电话：</td><td><input class="form-control" /></td></tr>'
						+ '<tr><td>住址：</td><td><input class="form-control" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<br>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 案（事）件名称：</td>'
						+ '<td><input class="form-control" /></td></tr>'
						+ '<tr><td>案件编号：</td>'
						+ '<td><input class="form-control" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 简要案情：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;"></textarea></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<br>'
						+ '<br>'
						+ '<h4>原鉴定情况：</h4>'
						+ '<textarea class="form-control" style="resize: none;height:100px;"></textarea>'
						+ '<br>'
						+ '<br>'
						+ '<h4><i class="fa fa-warning" style="color:#D9534F;"></i> 送检的检材和样本等情况（包括名称、数量、性状、包装，检材提取部位和方法等）：</h4>'
						+ '<textarea class="form-control" style="resize: none;height:100px;"></textarea>'
						+ '<br>'
						+ '<br>'
						+ '<h4><i class="fa fa-warning" style="color:#D9534F;"></i> 鉴定要求</h4>'
						+ '<textarea class="form-control" style="resize: none;height:100px;"></textarea>',
				type : 'blue',
				theme : 'modern',
				draggable : false,
				columnClass : 'col-md-12',
				escapeKey : true,
				onOpenBefore : function() {
				},
				onContentReady : function() {
					var date = new Date();
					document
							.getElementById("input_trance_check_entrustment_book_inspect_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
				},
				buttons : {
					'确认委托' : {
						btnClass : 'btn-blue',
						action : function() {
							addForensicCheckBook();
							return false;
						}
					},
					'放弃委托' : function() {
					}
				}
			});
}
function addForensicCheckBook() {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	/*
	 * 
	 */
	var formData = new FormData();
	/*
	 * 
	 */

	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/TranceCheckEntrustmentBook_addTranceCheckBook");
	xhr.send(formData);
}