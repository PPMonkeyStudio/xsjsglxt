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
							showLoading();
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


var updateMeetingRecords=function(dom)
{
	var jc = $.confirm({
	    columnClass: "col-md-12",
	    type : 'green',
		title:"<i class='fa fa-pencil-square-o'></i>填写会议记录书", 
		content:"<div id='addLoadingLayer' class='hideDiv' style='margin: 0 auto; width: 45px;'><i class='fa fa-spinner fa-spin fa-3x fa-fw'></i></div>" +
				"<div id='ConfirmTableDiv'><form id='UpdateMeetRecords' name='UpdateMeetRecords'><table class='table table-bordered' style='text-align: center;'>" +
				"<tr><td>会议类型：</td><td>" +
				"<select class='form-control' id='meeting_titleU' name='meet.meeting_title'><option value='大队例会'>大队例会</option>" +
				"<option value='支委会'>支委会</option><option value='党课'>党课</option>" +
				"<option value='党员大会'>党员大会</option><option value='党小组会'>党小组会</option>" +
				"<option value='专案会'>专案会</option><option value='工作总结会'>工作总结会</option></select>" +
				"</td><td>会议地点：</td><td><input id='meeting_placeU' name='meet.meeting_place' type='text' class='form-control' placeholder='请输入会议地点'></td></tr>" +
				"<tr><td>会议开始时间：</td><td><input id='meeting_start_timeU' placeholder='时分按格式手动精确（10:30英文冒号）' name='meet.meeting_start_time' type='text' class='form-control  mydate'></td>" +
				"<td>会议结束时间：</td><td><input id='meeting_end_timeU' placeholder='时分按格式手动精确（10:30英文冒号）' name='meet.meeting_end_time' type='text' class='form-control  mydate'></td></tr>" +
				"<tr><td>主持人：</td><td><input id='meeting_compereU' name='meet.meeting_compere' type='text' class='form-control' placeholder='请输入会议主持人'></td>" +
				"<td>记录人：</td><td><input id='meeting_record_humanU' name='meet.meeting_record_human' type='text' class='form-control' placeholder='请输入会议记录人'></td></tr>" +
				"<tr><td>参与人员</td><td colspan='3'><input id='meeting_join_humanU' name='meet.meeting_join_human' type='text' class='form-control' placeholder='请输入会议参与人员'></td></tr>" +
				"<tr><td>请假人员</td><td colspan='3'><input id='meeting_leave_humanU' name='meet.meeting_leave_human' type='text' class='form-control' placeholder='请输入会议请假人员'></td></tr>" +
				"<tr><td>会议内容</td><td colspan='3'><textarea id='meeting_contentU' name='meet.meeting_content' rows='10' class='form-control' placeholder='请输入会议内容'></textarea></td></tr>" +
				"<table></form></div>",
		buttons:{
			updateMeet:{
				text:"修改",
				btnClass:"btn-blue",
				action:function()
					{					
					$("#ConfirmTableDiv").hide();
					$("#addLoadingLayer").show();
						var formData = new FormData(document.getElementById("UpdateMeetRecords"));
						formData.append("meet.meeting_id",dom.id);
						$.ajax({
							 url:"/xsjsglxt/user/Meeting_updateMeetingRecord",
							 type:"POST",
							 data: formData,
							 processData: false,
							 contentType: false,
							 success:function(data){
								 if(data=="updateSuccess")
									 {
									 	toastr.success("修改成功！");
										$("#addLoadingLayer").hide();
										$("#ConfirmTableDiv").show();
									 	showLoading();
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
								 else
									 {
									 toastr.error("修改失败！");
									 }
					
							 }
							});
						 return false;
					}
			},
			closeMeet:{
				text:"关闭",
				btnClass:"btn-red",
				action:function()
					{
							
					}
			},
		},
		onContentReady:function()
		{
			$.ajax({
				url:"/xsjsglxt/user/Meeting_getMeetingById",
				type:"POST",
				data:{
					"meeting_id":dom.id
				},
				success:function(data)
				{
					var jsonData = JSON.parse(data);
					$("#meeting_titleU").val(jsonData.meeting_title);
					$("#meeting_placeU").val(jsonData.meeting_place);
					$("#meeting_start_timeU").val(jsonData.meeting_start_time);
					$("#meeting_end_timeU").val(jsonData.meeting_end_time);
					$("#meeting_compereU").val(jsonData.meeting_compere);
					$("#meeting_record_humanU").val(jsonData.meeting_record_human);
					$("#meeting_leave_humanU").val(jsonData.meeting_leave_human);
					$("#meeting_join_humanU").val(jsonData.meeting_join_human);
					$("#meeting_contentU").val(jsonData.meeting_content);}
			});
		}
	});
}