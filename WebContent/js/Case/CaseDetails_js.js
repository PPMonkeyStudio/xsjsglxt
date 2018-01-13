//CaseDetail.jsp中的删除案件
function case_del() {
	var url = "/xsjsglxt/case/Case_remove_SenceInformationList";
	var case1_id = document.getElementById("case1_id").value;
	loadCaseDetail_case_del(url, case1_id);
}
function loadCaseDetail_case_del(url, case1_id) {
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var formData = new FormData();
	formData.append("useSenceInformationNumList", case1_id);

	xmlhttp.onreadystatechange = httpbackCase_del;
	xmlhttp.open("pose", url, true);
	xmlhttp.send(formData);
}
function httpbackCase_del() {
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		console.log(xmlhttp.responseText);
		var result = xmlhttp.responseText;

		if (result == 'success') {
			toastr.success('删除成功！');
		} else {
			toastr.error('删除失败！');
		}
	}
}
//CaseDetail.jsp中的修改案件
function case_change() {
	var url = "/xsjsglxt/case/Case_updateSenceInformation";
	var case1_id = document.getElementById("case1_id").value;
	console.log(case1_id);
	loadCaseDetail_case_change(url, case1_id);
}
function loadCaseDetail_case_change(url, case1_id) {
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var lost_evidence = document.getElementById("caseDetails");
	var formData = new FormData(lost_evidence);
	formData.append("case1.xsjsglxt_case_id", case1_id);

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var result = xmlhttp.responseText;

			if (result == '"success"') {
				toastr.success('添加成功！');
			} else {
				toastr.error('添加失败！');
			}
		}
	};
	xmlhttp.open("post", url, true);
	xmlhttp.send(formData);
}