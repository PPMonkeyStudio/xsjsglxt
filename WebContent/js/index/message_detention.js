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
			if (result.length > 0) {
				for (var int = 0; int < result.length; int++) {
					str = str + '<li>【' + result[int]
							+ '】办理时间已过25天,请及时办理。</li>'
				}
			} else {
				str = str + '<li style="text-align:center;">暂无通知</li>'
			}
			$("#handleExceed").html(str);
		}
	})
});

$(function() {
	$
			.ajax({
				url : '/xsjsglxt/case/Handle_getOutTime',
				type : 'GET',
				success : function(data) {
					var result = JSON.parse(data);
					var str = '';
					var arrayLength;
					if (result.thirtyDays.length >= result.outTime.length) {
						arrayLength = result.thirtyDays.length;
					} else {
						arrayLength = result.outTime.length;
					}
					if (result.thirtyDays.length > 0
							|| result.outTime.length > 0) {
						for (var int = 0; int < arrayLength; int++) {
							if (result.thirtyDays.length - 1 >= int) {
								str = str
										+ '<li>【'
										+ result.thirtyDays[int].handle_administrativeCase
										+ '】中嫌疑人取保候审时限还剩30天，请及时办理解除取保候审。</li>';
							}
							if (result.outTime.length - 1 >= int) {
								str = str
										+ '<li>【'
										+ result.outTime[int].handle_administrativeCase
										+ '】中嫌疑人取保候审已过12个月，还未办理解除取保候审，请核查督办。</li>'
							}
						}
					} else {
						str = str + '<li style="text-align:center;">暂无通知</li>'
					}
					$('#pending').html(str);
				}
			})
})
$(function() {
	$
			.ajax({
				url : '/xsjsglxt/case/Handle_getDetention',
				type : 'GET',
				success : function(data) {
					var result = JSON.parse(data);
					var str = '';
					if (result.length > 0) {
						for (var int = 0; int < result.length; int++) {
							str = str
									+ '<li>【'
									+ result[int].handle_administrativeCase
									+ '】中嫌疑人刑事拘留明日将到期，请及时移送预审、经侦办理呈请逮捕手续，或在期限届满前依法变更强制措施或释放。</li>';
						}

					} else {
						str = str + '<li style="text-align:center;">暂无通知</li>'
					}
					$('#detention').html(str);
				}
			})
})