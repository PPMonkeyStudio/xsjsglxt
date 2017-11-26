function DeleteFingerPrint() {

	$.confirm({
		title : '警告！删除指纹卡信息',
		content : '此操作将删除所有所选的指纹卡信息',
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
								if (xhr.responseText == 1) {
									toastr.success("删除成功");
									List_DNA_By_PageAndSearch(1);
								}
							} else {
								toastr.error(xhr.status);
							}
						}
					}
					var checkbox_select = document
							.getElementsByClassName("checkbox_select");
					var tr_dna_id = document
							.getElementsByClassName("tr_dna_id");

					var formData = new FormData();
					for (var num = 0; num < checkbox_select.length; num++) {
						if (checkbox_select[num].checked) {
							formData.append("listDeleteDNAID",
									tr_dna_id[num].innerHTML);

						}
					}
					xhr.open("POST",
							"/xsjsglxt/DNA/DNAManagement_deleteListDNA");
					xhr.send(formData);
				}
			},
			取消 : function() {
			}
		}
	});

}