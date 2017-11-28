/*
 * 记录检验记录
 */
function Record_InspectionRecord() {
	var js = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-pencil-square-o',
				title : '记录检验过程',
				content : '<hr>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验人：</td>'
						+ '<td><input  class="form-control" id="" /></td>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验时间：</td>'
						+ '<td><input  class="form-control" id="" /></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验地点：</td>'
						+ '<td><input  class="form-control" id="" /></td>'
						+ '<td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验设备：</td>'
						+ '<td><select class="form-control" id="">'
						+ '<option value="LED光源">LED光源</option>'
						+ '<option value="立体显微镜">立体显微镜</option>'
						+ '<option value="扫描仪">扫描仪</option>'
						+ '<option value="比例尺">比例尺</option>'
						+ '<option value="其他">其他</option>'
						+ '</select><input  class="form-control" id="" style="margin:10px 0 0 0;"/></td></tr>'
						+ '</tbody>'
						+ '</table>'
						+ '<br>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr><td>检材情况：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '<tr><td>样本情况：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验方法：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验过程：</td>'
						+ '<td><textarea class="form-control" style="resize: none;height:100px;" id=""></textarea></td></tr>'
						+ '<tr><td><i class="fa fa-warning" style="color:#D9534F;"></i> 检验意见：</td>'
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