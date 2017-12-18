function Remove_EntrustmentBook() {
	var js = $
			.confirm({
				theme : 'Modern',
				icon : 'fa fa-exclamation-triangle',
				title : '警告！删除委托书',
				content : '此操作将删除所选的所有委托书数据，并且将对应的其他检验数据一并删除',
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
											List_EntrustmentBook(EntrustmentBook_json.pageIndex);
										}
									} else {
										toastr.error(xhr.status);
									}
								}
							}
							var checkbox_select = document
									.getElementsByClassName("checkbox_select");
							var ListDeleteStudentNum = null;
							var formData = new FormData();
							for (var num = 0; num < checkbox_select.length; num++) {
								if (checkbox_select[num].checked) {
									formData.append(
											"listCheckEntrustmentBookId",
											checkbox_select[num].id);
								}
							}
							xhr
									.open(
											"POST",
											"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_deleteListCheckEntrustmentBook");
							xhr.send(null);
						}
					},
					取消 : function() {
					}
				}
			});
}