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
					switch (EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_state) {
					case '正在申请': {
						new_td.innerHTML = '<span class="label label-primary">正在申请</span>';
						break;
					}
					case '申请已受理': {
						new_td.innerHTML = '<span class="label label-success">申请已受理</span>';
						break;
					}
					case '申请被拒绝': {
						new_td.innerHTML = '<span class="label label-danger">申请被拒绝</span>';
						break;
					}
					case '已记录': {
						new_td.innerHTML = '<span class="label label-success">已记录</span>';
						break;
					}
					case '已鉴定': {
						new_td.innerHTML = '<span class="label label-default">已鉴定</span>';
						break;
					}
					}

					/*
					 * 操作
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					switch (EntrustmentBook_json.listCheckEntrustmentBook[num].check_entrustment_book_state) {
					case '正在申请': {
						new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-ellipsis-v fa-2x" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>'
								+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
								+ '<li><a onclick="Detail_EntrustmentBook("'
								+ EntrustmentBook_json.listCheckEntrustmentBook[num].xsjsglxt_check_entrustment_book_id
								+ '")"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
								+ '<li><a onclick="Acceptance_EntrustmentBook(this)"><i class="fa fa-legal"></i> 受理</a></li>'
								+ '<li><a onclick="Refuse_EntrustmentBook(this)"><i class="fa fa-recycle"></i> 不受理</a></li>'
								+ '</ul></div>';
						break;
					}
					case '申请已受理': {
						new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-ellipsis-v fa-2x" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>'
								+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
								+ '<li><a onclick="Issue_AppraisRecord_InspectionRecordalLetter(this)"><i class="fa fa-pencil-square-o"></i> 记录检验过程</a></li>'
								+ '</ul></div>';
						break;
					}
					case '申请被拒绝': {
						new_td.innerHTML = '<div class="dropdown"><i style="cursor: pointer;" class="fa fa-ellipsis-v fa-2x" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>'
								+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看不受理委托鉴定告知书</a></li>'
								+ '</ul></div>';
						break;
					}
					case '已记录': {
						new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-ellipsis-v fa-2x" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>'
								+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看检验记录</a></li>'
								+ '<li><a onclick="Issue_AppraisalLetter(this)"><i class="fa fa-pencil-square-o"></i> 出具鉴定文书</a></li>'
								+ '</ul></div>';
						break;
					}
					case '已鉴定': {
						new_td.innerHTML = '<div class="dropdown"><i style="cursor: pointer;" class="fa fa-ellipsis-v fa-2x" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>'
								+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看检验记录</a></li>'
								+ '<li><a><i class="fa fa-file-text-o"></i> 查看鉴定文书</a></li>'
								+ '</ul></div>';
						break;
					}
					}

					/*
					 * 
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<label class="fancy-checkbox">'
							+ '<input id="'
							+ EntrustmentBook_json.listCheckEntrustmentBook[num].xsjsglxt_check_entrustment_book_id
							+ '" type="checkbox" class="checkbox_select">'
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
	 * 筛选：被委托鉴定机构
	 */
	if (document.getElementById("select_unitName").value == "-1") {
	} else {
		formData.append("entrustmentBookManagementVO.unitName", document
				.getElementById("select_unitName").value);
	}
	/*
	 * 筛选：类型
	 */
	if (document.getElementById("select_type").value == "-1") {
	} else {
		formData.append("entrustmentBookManagementVO.type", document
				.getElementById("select_type").value);
	}
	/*
	 * 筛选：状态
	 */
	if (document.getElementById("select_state").value == "-1") {
	} else {
		formData.append("entrustmentBookManagementVO.state", document
				.getElementById("select_state").value);
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