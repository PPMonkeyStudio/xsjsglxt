var fingerprintVO = null;
function List_FingerPrint_By_PageAndSearch(pageIndex) {
	var input_FingerPrintSearchText = document
			.getElementById("input_FingerPrintSearchText").value;
	var formData = new FormData();

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;

		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				fingerprintVO = JSON.parse(xhr.responseText);

				/*
				 * 
				 */

				var new_tr = null;
				var new_td = null;
				var table_fingerPrint = document
						.getElementById("table_fingerPrint");

				/*
				 * 移出除标题以外的所有行
				 */

				var old_tr = document.getElementsByClassName("new_tr");
				console.debug(old_tr.length);
				for (var i = 0; i < old_tr.length; i++) {
					table_fingerPrint.firstElementChild.removeChild(old_tr[0]);
				}

				/*
				 * 将数据库的数据取出来放到表格里
				 */
				for (var num = 0; num < fingerprintVO.list_xsjsglxt_dna.length; num++) {
					new_tr = document.createElement("tr");
					new_tr.className = "new_tr";
					new_tr.appendChild(document.createTextNode(''));
					table_fingerPrint.firstElementChild.appendChild(new_tr);
					/*
					 * 1
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_num;
					/*
					 * 2
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_name;
					/*
					 * 3
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_sex;
					/*
					 * 4
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_birthday;
					/*
					 * 5
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_identity;
					/*
					 * 6
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_address;
					/*
					 * 7
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_illegal_fact;
					/*
					 * 8
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_record_organization;
					/*
					 * 9
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_organizer;
					/*
					 * 10
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_record_time;
					/*
					 * 11
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = fingerprintVO.list_fingerprint[num].dna_submit_time;
					/*
					 * 
					 */
					new_td = document.createElement("td");
					new_td.appendChild(document.createTextNode(''));
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<label class="fancy-checkbox" >'
							+ '<input  id="" type="checkbox" class="checkbox_select">'
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
				document.getElementById("span_pageIndex").innerHTML = fingerprintVO.pageIndex;
				document.getElementById("span_totalPages").innerHTML = fingerprintVO.totalPages;
				document.getElementById("span_totalRecords").innerHTML = fingerprintVO.totalRecords;
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
	xhr
			.open("POST",
					"/xsjsglxt/FingerPrint/FingerPrintManagement_list_xsjsglxt_fingerprint");
	xhr.send(formData);

}

/*
 * 判断页数
 */
function flip(flipPage) {
	switch (flipPage) {
	case 1: {
		List_Topic_By_PageAndSearch(1)
		break;
	}
	case 2: {
		if (topic_json.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			List_Topic_By_PageAndSearch(topic_json.pageIndex - 1);
		}
		break;
	}
	case 3: {
		if (topic_json.pageIndex == topic_json.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			List_Topic_By_PageAndSearch(topic_json.pageIndex + 1);
		}
		break;
	}
	case 4: {
		List_Topic_By_PageAndSearch(topic_json.totalPages);

		break;
	}

	}
}
