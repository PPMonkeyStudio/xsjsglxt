/**
 * 
 */
var caseVue;
window.onload = function() {
	caseVue = new Vue({
		el : '#tableContent',
		data : {
			'caseInfor' : {},
			'senceInfor' : {},
			'briefdetails' : {},
			'resevidence' : {},
			'lost_computer' : {},
			'lost_mobilephone' : {},
			'lost' : {},
			'picture' : {}
		}
	});
	var url = window.location.href;
	var case_id = url.substring(url.indexOf("=") + 1);
	$.ajax({
		url : '/xsjsglxt/case/Case_SecneInformationOne',
		data : {
			'case1.xsjsglxt_case_id' : case_id
		},
		success : function(data) {
			var returnData = JSON.parse(data);
			caseVue.caseInfor = returnData.case1;
			caseVue.senceInfor = returnData.sence;
			caseVue.briefdetails = returnData.briefdetails;
			caseVue.resevidence = returnData.resevidence;
			caseVue.lost_computer = returnData.lost_computer;
			caseVue.lost_mobilephone = returnData.lost_mobilephone;
			caseVue.lost = returnData.lost;
			caseVue.picture = returnData.picture;
		}
	})
};

var case_change = function() {
	var url = window.location.href;
	var case_id = url.substring(url.indexOf("=") + 1);
	window.location.href = "/xsjsglxt/case/Case_ page_CaseDetails?id="
			+ case_id;
}
var print_Page = function() {
	var url = window.location.href;
	var case_id = url.substring(url.indexOf("=") + 1);
	window.open("/xsjsglxt/case/Case_ page_printPage?id=" + case_id);
}
