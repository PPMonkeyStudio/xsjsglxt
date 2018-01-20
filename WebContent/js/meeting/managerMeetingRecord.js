/**
 * 
 */

var deleteMeetingRecords = function(dom)
{
	var jc = $.confirm({
		title:"<i class='fa fa-exclamation-triangle' style='color:red;' aria-hidden='true'></i>是否确定删除",
		type:"red",
		content:"",
		autoClose:"close|10000",
		buttons:{
			sure:{
				text:"确定",
				btnClass:"btn-blue",
				action:function()
				{
					$.ajax({
						url:"/xsjsglxt/user/Meeting_deleteMeetingRecord",
						type:"POST",
						data:{"meeting_id":dom.id},
						success:function(data)
						{
							if(data=="deleteSuccess")
								{
									toastr.success("删除成功");
								}
							else
								{
									toastr.error("删除失败");
								}
							meetVO.currPage=1;
							var meetVOPostTemp={
									"meetVO.queryTitle":meetVO.queryTitle,
									"meetVO.startTimeSort":meetVO.startTimeSort,
									"meetVO.query_start_time_start":meetVO.query_start_time_start,
									"meetVO.query_start_time_end":meetVO.query_start_time_end,
									"meetVO.pageCount":meetVO.pageCount,
									"meetVO.currPage":meetVO.currPage,
									"meetVO.pageSize":meetVO.pageSize,
									"meetVO.totalCount":meetVO.totalCount
							}
							$.ajax({
								url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
								type:"POST",		
								data: meetVOPostTemp,
								success:function(data){
									var jsonData = JSON.parse(data);
									ajaxSetTable(jsonData);
								}
							});
						}
					});
				}
			},
			close:{
				text:"取消",
				btnClass:"btn-red"
				
			}
		}
		
	});
}