/*
 * 受理任务书
 */
function Acceptance_EntrustmentBook() {
	var js = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-map-o',
				title : '受理委托书',
				content : '<hr>'
						+ '<h3>鉴定事项确认书</h3>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 受理人：</td>'
						+ '<td><input  class="form-control" id="" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 备注：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '</tbody>' + '</table>',
				type : 'green',
				columnClass : 'col-md-12',
				theme : 'modern',
				onOpenBefore : function() {
				},
				onContentReady : function() {
				},
				buttons : {
					'确认受理' : {
						btnClass : 'btn-green',
						action : function() {
						}
					},
					'放弃受理' : function() {
					}
				}
			});
}