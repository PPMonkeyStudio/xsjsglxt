var query_data = {
	"page_list_ResevidenceInformation.pageIndex" : "1",
}

function material(object) {
	var material_type = $(object).val();
	if (material_type == "evidence_table_info") {
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function() {
			//$('.panel-body evidence_table_info tbody').html();
		}, 'json');
	} else if (material_type == "picture_table_info") {
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function() {
			$('.panel-body').html();
		}, 'json');
	} else if (material_type == "Goods_table_info") {
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function() {
			$('.panel-body').html();
		}, 'json');
	}
}