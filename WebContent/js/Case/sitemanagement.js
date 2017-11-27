var query_data = {};


function get_ListSneceInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Case_ListSneceInformationByPageAndSearch', data, function(xhr) {}, 'json')
}

$('.to_quert').click(function() {
	var arr = $('#query_infomantion_inmodal').serializeArray();
	$.each(arr, function(key, value) {
		//key为arr里对象的索引，value为索引为key的对象。对象以{name: 'firstname', value: 'Hello'}形式存储, 以obj.name和obj.value形式遍历 
		query_data[value.name] = value.value;
	});
	$('.query_prompting_info').text('接警时间从' + $('input[name="page_list_senceInformation.start_time"]').val() + '到' + $('input[name="page_list_senceInformation.stop_time"]').val());
	/*get_ListSneceInformationByPageAndSearch(query_data);*/

});