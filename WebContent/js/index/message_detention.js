/**
 * 
 */

$(function() {
	$.ajax({
		url : '/xsjsglxt/case/Handle_getHandleExceedTime',
		type : 'GET',
		success : function(data) {
			var result = JSON.parse(data);
			var str = '';
			for (var int = 0; int < result.length; int++) {
				str = str + '<li>【' + result[int] + '】办理时间已过25天,请及时办理。</li>'
			}
			$("#handleExceed").html(str);
		}
	})
});