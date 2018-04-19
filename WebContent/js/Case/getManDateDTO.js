/**
 * 
 */

var getManDate = function() {
	var url = window.location.href;
	var case_id = url.substring(url.indexOf("=") + 1);
	$
			.ajax({
				url : '/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_getListEntrustmentByCaseId?tranceCheckBook.checkCaseId='
						+ case_id,
				type : 'GET',
				success : function(data) {
					caseVue.MandataDTOS = JSON.parse(data);
				}

			});
}

var getCheckDate = function() {
	var url = window.location.href;
	var case_id = url.substring(url.indexOf("=") + 1);
	$
			.ajax({
				url : '/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_getListInspectionRecordByCaseId?inspectionRecord.inspectionCaseId='
						+ case_id,
				type : 'GET',
				success : function(data) {
					caseVue.CaseCheckDTOS = JSON.parse(data);
				}

			});
}