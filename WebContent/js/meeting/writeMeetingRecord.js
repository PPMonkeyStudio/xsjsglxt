var createConfirm = function()
{
	var jc = $.confirm({
	    columnClass: "col-md-12",
	    type : 'green',
		title:"<i class='fa fa-pencil-square-o'></i>填写会议记录书", 
		content:"<div id='ConfirmTableDiv'><form id='meetRecords' name='meetRecords'><table class='table table-bordered' style='text-align: center;'>" +
				"<tr><td>会议类型：</td><td>" +
				"<select class='form-control' name='meet.meeting_title'><option value='大队例会'>大队例会</option>" +
				"<option value='支委会'>支委会</option><option value='党课'>党课</option>" +
				"<option value='党员大会'>党员大会</option><option value='党小组会'>党小组会</option>" +
				"<option value='专案会'>专案会</option><option value='工作总结会'>工作总结会</option></select>" +
				"</td><td>会议地点：</td><td><input name='meet.meeting_place' type='text' class='form-control' placeholder='请输入会议地点'></td></tr>" +
				"<tr><td>会议开始时间：</td><td><input placeholder='时分按格式手动精确（10:30英文冒号）' name='meet.meeting_start_time' type='text' class='form-control  mydate'></td>" +
				"<td>会议结束时间：</td><td><input placeholder='时分按格式手动精确（10:30英文冒号）' name='meet.meeting_end_time' type='text' class='form-control  mydate'></td></tr>" +
				"<tr><td>主持人：</td><td><input name='meet.meeting_compere' type='text' class='form-control' placeholder='请输入会议主持人'></td>" +
				"<td>记录人：</td><td><input name='meet.meeting_record_human' type='text' class='form-control' placeholder='请输入会议记录人'></td></tr>" +
				"<tr><td>参与人员</td><td colspan='3'><input name='meet.meeting_join_human' type='text' class='form-control' placeholder='请输入会议参与人员'></td></tr>" +
				"<tr><td>请假人员</td><td colspan='3'><input name='meet.meeting_leave_human' type='text' class='form-control' placeholder='请输入会议请假人员'></td></tr>" +
				"<tr><td>会议内容</td><td colspan='3'><textarea name='meet.meeting_content' rows='10' class='form-control' placeholder='请输入会议内容'></textarea></td></tr>" +
				"<table></form></div>",
		buttons:{
			save:{
				text:"<i class='fa fa-upload' aria-hidden='true'></i>保存",
				btnClass:"btn-blue",
				action:function()
				{
					var formData = new FormData(document.getElementById("meetRecords"));
					for(var i=0;i<document.meetRecords.elements.length-1;i++)
				    {
				     if(document.meetRecords.elements[i].value=="")
				     {
				       toastr.error("当前表单不能有空项");
				       document.meetRecords.elements[i].focus();
				       return false;
				     }
				    }
					$.ajax({
						url: "/xsjsglxt/user/Meeting_saveMeetRecord",
						 type: "POST",
						 data: formData,
						 processData: false,
						 contentType: false,
						 success:function(data){
							 toastr.success(data);
						 }
					});
				}
			},
			close:{
				text:"<i class='fa fa-times' aria-hidden='true'></i>关闭",
				btnClass:"btn-red",
				action:function()
				{
					
				}
			}
		},
		onContentReady: function(){
			$.datetimepicker.setLocale('ch');
			$('.mydate').datetimepicker({
				yearStart : 1990, // 设置最小年份
				yearEnd : 2050, // 设置最大年份
				yearOffset : 0, // 年偏差
				timepicker : false, // 关闭时间选项
				format : 'Y-m-d H:i', // 格式化日期年-月-日
				minDate : '1900/01/01 00:00', // 设置最小日期
				maxDate : '2030/01/01 00:00', // 设置最大日期
			});
	    },
	});
}