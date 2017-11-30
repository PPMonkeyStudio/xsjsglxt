function DeleteDNA() {

	$.confirm({
		title : '警告！删除比中指纹',
		content : '此操作将删除所有所选的比中指纹',
		type : 'red',
		autoClose : '取消|5000',// 自动关闭
		buttons : {
			删除 : {
				btnClass : 'btn-red',
				action : function() {
					var xhr = false;
					xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						var message;

						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								if (xhr.responseText == "1") {
									toastr.success("删除成功");
									List_ContrastFingerPrint_By_PageAndSearch(1);
								}
							} else {
								toastr.error(xhr.status);
							}
						}
					}
					var checkbox_select = document
							.getElementsByClassName("checkbox_select");
					var tr_contrastFingerPrint_id = document
							.getElementsByClassName("tr_contrastFingerPrint_id");
					var formData = new FormData();
					for (var num = 0; num < checkbox_select.length; num++) {
						if (checkbox_select[num].checked) {
							formData.append("listDeleteDNAID",
									tr_contrastFingerPrint_id[num].innerHTML);

						}
					}
					xhr.open("POST",
							"/xsjsglxt/ContrastFingerPrint/ContrastFingerPrintManagement_deleteListContrast");
					xhr.send(formData);
				}
			},
			取消 : function() {
			}
		}
	});

}