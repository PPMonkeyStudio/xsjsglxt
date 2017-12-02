var query_data = {
	"page_list_ResevidenceInformation.pageIndex" : "1",
	"page_list_Casematerial.pageIndex" : "1",
}

function material(object) {
	$('#goods_chose').hide();
	var material_type = $(object).val();
	//控制显示信息
	$('.panel-body table').each(function() {
		if ($(this).hasClass(material_type)) {
			$(this).show();
		} else $(this).hide();
	});
	if (material_type == "evidence_table_info") {
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function() {
			//$('.panel-body evidence_table_info tbody').html();
		}, 'json');
	} else if (material_type == "picture_table_info") {
		$.post('/xsjsglxt/case/Resevidence_ListResevidenceInformationByPageAndSearch', query_data, function() {}, 'json');
	} else if (material_type == "Goods_table_info") {
		$('#goods_chose').show();
	}
}

function lost_chose(opt_obj) {
	query_data["page_list_Casematerial.pageIndex"] = "1";
	//控制显示信息
	$('.Goods_table_info thead').each(function() {
		if ($(this).attr("id") == $(opt_obj).val()) {
			$(this).show();
		} else $(this).hide();
	});
	if ($(opt_obj).val() == "lost") {
		$.post('/xsjsglxt/case/Lost_ListLostInformationByPageAndSearch', query_data, function() {
			
		}, 'json');

	} else if ($(opt_obj).val() == "lost_computer") {
		$.post('/xsjsglxt/case/LostComputer_ListLostComputerInformationByPageAndSearch', query_data, function() {}, 'json');

	} else if ($(opt_obj).val() == "lost_mobilephone") {
		$.post('/xsjsglxt/case/LostMobilephone_ListLostMobilephoneInformationByPageAndSearch', query_data, function() {}, 'json');

	} else {
		return;
	}
}