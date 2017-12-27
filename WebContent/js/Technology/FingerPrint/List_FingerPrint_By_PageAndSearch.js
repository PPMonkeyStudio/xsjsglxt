var fingerPrint_VO = null;
function List_FingerPrint_By_PageAndSearch(pageIndex) {

	var input_FingerPrintSearchText = document.getElementById("input_FingerPrintSearchText").value;
	var formData = new FormData();

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;

		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				fingerPrint_VO = JSON.parse(xhr.responseText);

				/*
				 * 
				 */

				var new_tr = null;
				var new_td = null;
				var table_fingerPrint = document.getElementById("table_fingerPrint");

				/*
				 * 移出除标题以外的所有行
				 */

				var old_tr = document.getElementsByClassName("new_tr");
				console.debug(old_tr.length);
				var long = old_tr.length;
				for (var i = 0; i < long; i++) {
					old_tr[0].parentNode.removeChild(old_tr[0]);
					
				}

				/*
				 * 将数据库的数据取出来放到表格里
				 */
				for (var num = 0; num < fingerPrint_VO.list_xsjsglxt_fingerprint.length; num++) {
					new_tr = document.createElement("tr");
					new_tr.className = "new_tr";
					new_tr.appendChild(document.createTextNode(''));
					table_fingerPrint.firstElementChild.appendChild(new_tr);
					/*
					 * 
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.style.display = "none";
					new_td.className = "tr_fingerPrint_id";
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].xsjsglxt_fingerprint_id;
					console.debug(new_td.innerHTML);
					/*
					 *1. DNA编号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_num;
					/*
					 *2. 姓名
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_name;
					/*
					 *3. 性别
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_sex;
					/*
					 *4. 出生日期
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_birthday;
					/*
					 *5. 身份证号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_identity;
					/*
					 *6. 地址
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_address;
					/*
					 *7. 违法事实
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerPrint_VO.list_xsjsglxt_fingerprint[num].fingerprint_illegal_fact;
					/*
					 *8. 操作
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i  id="'+fingerPrint_VO.list_xsjsglxt_fingerprint[num].xsjsglxt_fingerprint_id+'" onClick=FingerPrintDetails(this) class="fa fa-pencil-square-o" aria-hidden="true"></i>';
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
				document.getElementById("span_pageIndex").innerHTML = fingerPrint_VO.pageIndex;
				document.getElementById("span_totalPages").innerHTML = fingerPrint_VO.totalPages;
				document.getElementById("span_totalRecords").innerHTML = fingerPrint_VO.totalRecords;
				document.getElementById("checkbox_all_select").checked=false;
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	formData.append("fingerprintVO.pageIndex", pageIndex);
	formData.append("fingerprintVO.search", input_FingerPrintSearchText);
	xhr.open("POST", "/xsjsglxt/FingerPrint/FingerPrintManagement_list_xsjsglxt_fingerprint");
	xhr.send(formData);

}

/*
 * 判断页数
 */
function flip(flipPage) {
	switch (flipPage) {
	case 1: {
		List_FingerPrint_By_PageAndSearch(1);
		break;
	}
	case 2: {
		if (fingerPrint_VO.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			List_FingerPrint_By_PageAndSearch(fingerPrint_VO.pageIndex - 1);
		}
		break;
	}
	case 3: {
		if (fingerPrint_VO.pageIndex == fingerPrint_VO.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			List_FingerPrint_By_PageAndSearch(fingerPrint_VO.pageIndex + 1);
		}
		break;
	}
	case 4: {
		List_FingerPrint_By_PageAndSearch(fingerPrint_VO.totalPages);

		break;
	}

	}
}
