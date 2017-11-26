var EntrustmentBook_json = null;

function List_EntrustmentBook(pageIndex) {

	document.getElementById("i_pulse").style.display = "block";

	/*
	 * 
	 */
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				EntrustmentBook_json = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document.getElementsByClassName("new_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}
				/*
				 * 
				 * 
				 */
				var table_EntrustmentBook = document
						.getElementById("table_EntrustmentBook");
				var new_tr = null;
				var new_td = null;
				for (var num = 0; num < EntrustmentBook_json.listCheckEntrustmentBook.length; num++) {

					new_tr = document.createElement("tr");
					table_EntrustmentBook.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					/*
					 * 委托编号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_num;
					/*
					 * 案（事）件名称
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_case_name;
					/*
					 * 被委托鉴定机构名称
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_entrustment_unit_name;
					/*
					 * 委托日期
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_inspect_time;
					/*
					 * 类型
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_type;
					/*
					 * 状态
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_state;
					/*
					 * 操作
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '';
					/*
					 * 
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<label class="fancy-checkbox">'
							+ '<input type="checkbox" class="checkbox_select">'
							+ '<span></span></label>';

				}

				/*
				 * 设置页数
				 */
				document.getElementById("span_pageIndex").innerHTML = EntrustmentBook_json.pageIndex;
				document.getElementById("span_totalPages").innerHTML = EntrustmentBook_json.totalPages;
				document.getElementById("span_totalRecords").innerHTML = EntrustmentBook_json.totalRecords;
				// 让加载图标消失
				document.getElementById("i_pulse").style.display = "none";
				// 让全选框取消选择
				document.getElementById("checkbox_all_select").checked = false;
				/*
				 * 角色控制
				 */
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr
			.open(
					"POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_getListCheckEntrustmentBookByPage");

	var formData = new FormData();
	/*
	 * 
	 */
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	/*
	 * 
	 */
	var search = document.getElementById("input_search").value;
	if (search == undefined || search == null || search == "") {
	} else {
		formData.append("entrustmentBookManagementVO.search", search);
	}
	/*
	 * 
	 */

	/*
	 * 
	 */
	formData.append("entrustmentBookManagementVO.pageIndex", pageIndex);

	xhr.send(formData);

}
function flip(flipPage) {
	switch (flipPage) {
	case 1: {
		List_EntrustmentBook_By_PageAndSearch(1)
		break;
	}
	case 2: {
		if (EntrustmentBook_json.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			List_EntrustmentBook_By_PageAndSearch(EntrustmentBook_json.pageIndex - 1);
		}
		break;
	}
	case 3: {
		if (EntrustmentBook_json.pageIndex == EntrustmentBook_json.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			List_EntrustmentBook_By_PageAndSearch(EntrustmentBook_json.pageIndex + 1);
		}
		break;
	}
	case 4: {
		List_EntrustmentBook_By_PageAndSearch(EntrustmentBook_json.totalPages);

		break;
	}

	}
}