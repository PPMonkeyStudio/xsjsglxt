/**
 * 
 */

var createConfirm = function()
{
	var jc = $.confirm({
		columnClass: "col-md-12",
		title:'<i class="fa fa-pencil-square-o"></i>填写大事记',
		type:'green',
		content:"<form id='memorabiliaForm' name='memorabiliaForm'><table class='table table-bordered' style='text-align: center;'>" +
				"<tr><td>大事记标题：</td><td><input name='memorabilia.memorabilia_title' class='form-control' type='text'></td>" +
				"<td>时间：</td><td><input name='memorabilia.memorabilia_time' class='form-control timeDate' type='text'></td></tr>" +
				"<tr><td>参与人员：</td><td colspan='3'><input name='memorabilia.memorabilia_join_human' class='form-control' type='text'></td></tr>" +
				"<tr><td>大事记内容：</td><td colspan='3'><textarea rows='10' class='form-control' name='memorabilia.memorabilia_content'></textarea></td><tr>" +
				"</table></form>",
		buttons:{
			save:{
				text:'<i class="fa fa-upload" aria-hidden="true"></i>保存',
				btnClass:'btn-blue',
				action:function()
				{
					for(var i=0;i<document.memorabiliaForm.elements.length-1;i++)
				    {
				     if(document.memorabiliaForm.elements[i].value=="")
				     {
				       toastr.error("当前表单不能有空项");
				       document.memorabiliaForm.elements[i].focus();
				       return false;
				     }
				    }
					var formData = new FormData(document.getElementById("memorabiliaForm"));
					$.ajax({
						url:"/xsjsglxt/user/Memorabilia_saveMemorabilia",
						 type: "POST",
						 data: formData,
						 processData: false,
						 contentType: false,
						 success:function(data){
							 if(data=="saveSuccess")
								 {
								 toastr.success("保存成功！");
								 }
							 else
								 {
								 toastr.error("保存失败！");
								 }
							
						 }
					});
					loadData();
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
		onContentReady:function(){
			$.datetimepicker.setLocale('ch');
			$('.timeDate').datetimepicker({
				yearStart : 1990, // 设置最小年份
				yearEnd : 2050, // 设置最大年份
				yearOffset : 0, // 年偏差
				timepicker : false, // 关闭时间选项
				format : 'Y-m-d', // 格式化日期年-月-日
				minDate : '1900/01/01', // 设置最小日期
				maxDate : '2030/01/01', // 设置最大日期
			});
		}
		
	});
}