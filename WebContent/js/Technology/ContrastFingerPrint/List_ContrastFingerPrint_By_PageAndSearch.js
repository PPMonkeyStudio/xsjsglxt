var contrastFingerPrint_VO = null;
function List_ContrastFingerPrint_By_PageAndSearch(pageIndex) {

	var input_ContrastFingerPrintSearchText = document.getElementById("input_ContrastFingerPrintSearchText").value;
	var formData = new FormData();

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;

		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				contrastFingerPrint_VO = JSON.parse(xhr.responseText);

				/*
				 * 
				 */

				var new_tr = null;
				var new_td = null;
				var table_ContrastFingerPrint = document.getElementById("table_ContrastFingerPrint");

				/*
				 * 移出除标题以外的所有行
				 */

				var old_tr = document.getElementsByClassName("new_tr");
				var long = old_tr.length;
				for (var i = 0; i < long; i++) {
					old_tr[0].parentNode.removeChild(old_tr[0]);
					// table_DNA.firstElementChild.removeChild(old_tr[0]);
				}

				/*
				 * 将数据库的数据取出来放到表格里
				 */
				for (var num = 0; num < contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint.length; num++) {
					new_tr = document.createElement("tr");
					new_tr.className = "new_tr";
					new_tr.appendChild(document.createTextNode(''));
					table_ContrastFingerPrint.firstElementChild.appendChild(new_tr);
					/*
					 * 
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.style.display = "none";
					new_td.className = "tr_contrastFingerPrint_id";
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_id;
					/*
					 *1. 现场指印编号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_locale_fingerprint_number;
					/*
					 *2. 比中时间
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_time;
					/*
					 *3. 按印指印编号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_press_fingerprint_number;
					/*
					 *4. 嫌疑人姓名
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_suspecter_name;
					/*
					 *5. 比对单位
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_contrast_organization;
					/*
					 *6. 比对人
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_contraster;
					/*
					 *7. 是否抓获
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_suspecter_arrested;
					/*
					 *8. 操作
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i  id="'+contrastFingerPrint_VO.list_xsjsglxt_contrast_fingerprint[num].contrast_fingerprint_id+'" onClick=ContrastFingerPrintDetails(this) class="fa fa-pencil-square-o" aria-hidden="true"></i>';
					new_td.style.cursor="pointer";
					
					/*
					 *9. 复选框
					 */
					new_td = document.createElement("td");
					new_td.appendChild(document.createTextNode(''));
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<label class="fancy-checkbox" >'
							+ '<input  type="checkbox" class="checkbox_select">'
							+ '<span></span></label></div>';

				}
				/*
				 * 
				 */
				var i_pulse = document.getElementById("i_pulse");
				i_pulse.style.display = "none";

				/*
				 * * 设置页数 /
				 */
				document.getElementById("span_pageIndex").innerHTML = contrastFingerPrint_VO.pageIndex;
				document.getElementById("span_totalPages").innerHTML = contrastFingerPrint_VO.totalPages;
				document.getElementById("span_totalRecords").innerHTML = contrastFingerPrint_VO.totalRecords;
				document.getElementById("checkbox_all_select").checked=false; 
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	formData.append("contrastFingerPrintVO.pageIndex", pageIndex);
	formData.append("contrastFingerPrintVO.search", input_ContrastFingerPrintSearchText);
	xhr.open("POST", "/xsjsglxt/ContrastFingerPrint/ContrastFingerPrintManagement_ListContrastByPageAndSearch");
	xhr.send(formData);

}

/*
 * 判断页数
 */
function flip(flipPage) {
	switch (flipPage) {
	case 1: {
		List_ContrastFingerPrint_By_PageAndSearch(1)
		break;
	}
	case 2: {
		if (contrastFingerPrint_VO.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			List_ContrastFingerPrint_By_PageAndSearch(contrastFingerPrint_VO.pageIndex - 1);
		}
		break;
	}
	case 3: {
		if (contrastFingerPrint_VO.pageIndex == contrastFingerPrint_VO.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			List_ContrastFingerPrint_By_PageAndSearch(contrastFingerPrint_VO.pageIndex + 1);
		}
		break;
	}
	case 4: {
		List_ContrastFingerPrint_By_PageAndSearch(contrastFingerPrint_VO.totalPages);

		break;
	}

	}
}
