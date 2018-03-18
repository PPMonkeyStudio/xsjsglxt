function DeleteFingerPrint() {

	$.confirm({
		title : '警告！删除指纹信息',
		content : '此操作将删除所有所选的指纹信息',
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
									List_FingerPrint_By_PageAndSearch(1);
								}
							} else {
								toastr.error(xhr.status);
							}
						}
					}
					var checkbox_select = document
							.getElementsByClassName("checkbox_select");
					var tr_fingerPrint_id = document
							.getElementsByClassName("tr_fingerPrint_id");

					var formData = new FormData();
					for (var num = 0; num < checkbox_select.length; num++) {
						if (checkbox_select[num].checked) {
							formData.append("listDeleteFingerPrintID",
									tr_fingerPrint_id[num].innerHTML);

						}
					}
					xhr.open("POST",
							"/xsjsglxt/FingerPrint/FingerPrintManagement_deleteListFingerPrint");
					xhr.send(formData);
				}
			},
			取消 : function() {
			}
		}
	});

}