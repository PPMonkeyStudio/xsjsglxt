function Issue_AppraisalLetter() {
	var js = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-pencil-square-o',
				title : '出具鉴定文书',
				content : '<hr>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id="">本次检验采用XXXX鉴定法（公安部物证鉴定中心）\n（一）\n（二）</textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 论证：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 鉴定意见：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '<tr><td>备注：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '</tbody>' + '</table>' + '<br>' + '<hr>',
				type : 'blue',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
				},
				buttons : {
					'记录' : {
						btnClass : 'btn-blue',
						action : function() {
							SureRefuse();
						}
					},
					'放弃' : function() {
					}
				}
			});
}