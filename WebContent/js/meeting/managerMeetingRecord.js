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
					
				}
			},
			close:{
				text:"取消",
				btnClass:"btn-red"
				
			}
		}
		
	});
}