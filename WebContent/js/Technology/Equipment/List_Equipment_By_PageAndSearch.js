var equipment_VO = null;
function List_Equipment_By_PageAndSearch(pageIndex) {
	var input_EquipmentSearchText = document
			.getElementById("input_EquipmentSearchText").value;
	var formData = new FormData();
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				/* console.debug(xhr.responseText); */
				equipment_VO = JSON.parse(xhr.responseText);

				/*
				 * 
				 */

				var new_tr = null;
				var new_td = null;
				var table_Equipment = document
						.getElementById("table_Equipment");

				/*
				 * 移出除标题以外的所有行
				 */

				var old_tr = document.getElementsByClassName("new_tr");
				/* console.debug(old_tr.length); */
				var long = old_tr.length;
				for (var i = 0; i < long; i++) {
					old_tr[0].parentNode.removeChild(old_tr[0]);
					// table_DNA.firstElementChild.removeChild(old_tr[0]);
				}

				/*
				 * 将数据库的数据取出来放到表格里
				 */
				for (var num = 0; num < equipment_VO.list_xsjsglxt_equipment.length; num++) {
					new_tr = document.createElement("tr");
					new_tr.className = "new_tr";
					new_tr.appendChild(document.createTextNode(''));
					table_Equipment.firstElementChild.appendChild(new_tr);
					/*
					 * 0. 装备id
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.style.display = "none";
					new_td.className = "tr_equipment_id";
					new_td.innerHTML = equipment_VO.list_xsjsglxt_equipment[num].xsjsglxt_equipment_id;
					/* console.debug(new_td.innerHTML); */
					/*
					 * 1. 装备序号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = equipment_VO.list_xsjsglxt_equipment[num].equipment_serial_number;
					/*
					 * 2. 装备名称
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = equipment_VO.list_xsjsglxt_equipment[num].equipment_name;
					/*
					 * 3. 装备类型
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = equipment_VO.list_xsjsglxt_equipment[num].equipment_type;
					if (new_td.innerHTML == "undefined") {
						new_td.innerHTML = "";
					}
					/*
					 * 4. 数量
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = equipment_VO.list_xsjsglxt_equipment[num].equipment_number;
					if (new_td.innerHTML == "undefined") {
						new_td.innerHTML = "";
					}
					/*
					 * 5. 启用日期
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = equipment_VO.list_xsjsglxt_equipment[num].equipment_enablement_time;
					/*
					 * 6. 使用情况
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = equipment_VO.list_xsjsglxt_equipment[num].equipment_use_note;

					/*
					 * 7. 操作
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i  id="'
							+ equipment_VO.list_xsjsglxt_equipment[num].xsjsglxt_equipment_id
							+ '" onClick=EquipmentDetails(this) class="fa fa-pencil-square-o" aria-hidden="true"></i>';
					new_td.style.cursor = "pointer";

					/*
					 * 8. 复选框
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
				document.getElementById("span_pageIndex").innerHTML = equipment_VO.pageIndex;
				document.getElementById("span_totalPages").innerHTML = equipment_VO.totalPages;
				document.getElementById("span_totalRecords").innerHTML = equipment_VO.totalRecords;
				document.getElementById("checkbox_all_select").checked = false;
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	formData.append("equipmentVO.pageIndex", pageIndex);
	formData.append("equipmentVO.search", input_EquipmentSearchText);
	formData.append("equipmentVO.searchKind", $('#input_searchKind').val());
	xhr
			.open("POST",
					"/xsjsglxt/Equipment/EquipmentManagement_ListEquipmentByPageAndSearch");
	xhr.send(formData);

}

/*
 * 判断页数
 */
function flip(flipPage) {
	switch (flipPage) {
	case 1: {
		List_Equipment_By_PageAndSearch(1)
		break;
	}
	case 2: {
		if (equipment_VO.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			List_Equipment_By_PageAndSearch(equipment_VO.pageIndex - 1);
		}
		break;
	}
	case 3: {
		if (equipment_VO.pageIndex == equipment_VO.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			List_Equipment_By_PageAndSearch(equipment_VO.pageIndex + 1);
		}
		break;
	}
	case 4: {
		List_Equipment_By_PageAndSearch(equipment_VO.totalPages);

		break;
	}

	}
}
