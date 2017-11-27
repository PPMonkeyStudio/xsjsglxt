/*
 * 拒绝受理委托书
 */
function Refuse_EntrustmentBook() {
	var js = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-ban',
				title : '不受理委托鉴定',
				content : '<hr>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 不予受理理由：</td><td><textarea class="form-control" style="resize: none;height:100px;" id="">根据《公安机关鉴定规则》第XX条XX款之规定，因XXXX，故不予受理。</textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 填表人：</td>'
						+ '<td><input  class="form-control" id="" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 批准人：</td>'
						+ '<td><input  class="form-control" id="" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 批准时间：</td>'
						+ '<td><input  class="form-control" id="" /></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<h4>确认不受理后，将自动生成《不受理委托鉴定告知书（存根）》以及《萍乡市安源区公安司法鉴定中心不受理委托鉴定告知书》。</h4>',
				type : 'orange',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
				},
				buttons : {
					'确认' : {
						btnClass : 'btn-orange',
						action : function() {
							SureRefuse();
						}
					},
					'放弃' : function() {
					}
				}
			});
}
function SureRefuse() {

}