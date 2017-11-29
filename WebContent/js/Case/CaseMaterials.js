function material(object) {
	var material_type = $(object).val();
	if (material_type == "物证") {
		$.post('', '', '', function() {
			$('.panel-body').html();
		}, 'json');
	} else if (material_type == "光碟(照片)") {
		$.post('', '', '', function() {
			$('.panel-body').html();
		}, 'json');
	} else if (material_type == "遗失物品") {
		$.post('', '', '', function() {
			$('.panel-body').html();
		}, 'json');
	}
}