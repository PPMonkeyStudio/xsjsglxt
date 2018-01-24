/**
 * 
 */

var deleteMeetingRecords = function(dom)
{
	$.confirm({
		title:"<i class='fa fa-exclamation-triangle' style='color:red;' aria-hidden='true'></i>是否确定删除",
		type:"red",
		content:"",
		autoClose:"close|10000",
		buttons:{
			sure:{
				text:'确定',
				btnClass:'btn-blue',
				action:function()
				{
					$.ajax({
						url:'/xsjsglxt/user/Memorabilia_deleteMemorabilia',
						type:'POST',
						data:{
							memorabilia_id:dom.id
						},
						success:function(data){
							if(data=='deleteSuccess')
								{
									toastr.success("删除成功");
									memorabilia.currPage==1;
									loadData();
								}
							else
								{
									toastr.error("删除失败");
								}
						}
					});
				}
			},
			close:{
				text:'关闭',
				btnClass:'btn-red',
				action:function()
				{
					
				}
			}
		}
	});
	
	
}

var updateMeetingRecords = function(dom)
{
	$.ajax({
		url:'/xsjsglxt/user/Memorabilia_getMemorabiliaById',
		type:'POST',
		data:{
			memorabilia_id:dom.id
		},
		success:function(data)
		{
			var jsonData = JSON.parse(data);
			$.confirm({
				columnClass: "col-md-12",
				title:"<i class='fa fa-pencil-square-o'></i>修改大事记",
				type:'yellow',
				content:"<form id='UpdateMemorabiliaForm' name='UpdateMemorabiliaForm'><table class='table table-bordered' style='text-align: center;'>" +
				"<tr><td>大事记标题：</td><td><input name='memorabilia.memorabilia_title' value='"+jsonData.memorabilia_title+"' class='form-control' type='text'></td>" +
				"<td>时间：</td><td><input name='memorabilia.memorabilia_time' value='"+jsonData.memorabilia_time+"' class='form-control timeDate' type='text'></td></tr>" +
				"<tr><td>参与人员：</td><td colspan='3'><input name='memorabilia.memorabilia_join_human' value='"+jsonData.memorabilia_join_human+"' class='form-control' type='text'></td></tr>" +
				"<tr><td>大事记内容：</td><td colspan='3'><textarea rows='10' class='form-control' value='"+jsonData.memorabilia_content+"' name='memorabilia.memorabilia_content'></textarea></td><tr>" +
				"</table></form>",
				buttons:{
					update:{
						text:'<i class="fa fa-upload" aria-hidden="true"></i>保存',
						btnClass:"btn-blue",
						action:function()
						{
							
						}
					},
					close:{
						text:"<i class='fa fa-times' aria-hidden='true'></i>关闭",
						btnClass:"btn-red",
						action:function()
						{
							
						}
					}
				}
			});
		}
	});
}