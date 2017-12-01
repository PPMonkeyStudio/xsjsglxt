var DNA_VO = null;
function List_DNA_By_PageAndSearch(pageIndex) {

	var input_DNASearchText = document.getElementById("input_DNASearchText").value;
	var formData = new FormData();

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;

		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
/*console.debug(xhr.responseText);*/

				DNA_VO = JSON.parse(xhr.responseText);
/*DNA_VO = xhr.responseText;*/
				/*
				 * 
				 */

				var new_tr = null;
				var new_td = null;
				var table_DNA = document.getElementById("table_DNA");

				/*
				 * 移出除标题以外的所有行
				 */

				var old_tr = document.getElementsByClassName("new_tr");
/*console.debug(old_tr.length);*/
				var long = old_tr.length;
				for (var i = 0; i < long; i++) {
					old_tr[0].parentNode.removeChild(old_tr[0]);
					// table_DNA.firstElementChild.removeChild(old_tr[0]);
				}

				/*
				 * 将数据库的数据取出来放到表格里
				 */
				for (var num = 0; num < DNA_VO.list_xsjsglxt_dna.length; num++) {
					new_tr = document.createElement("tr");
					new_tr.className = "new_tr";
					new_tr.appendChild(document.createTextNode(''));
					table_DNA.firstElementChild.appendChild(new_tr);
					/*
					 * 
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.style.display = "none";
					new_td.className = "tr_dna_id";
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].xsjsglxt_dna_id;
/*console.debug(new_td.innerHTML);*/
					/*
					 *1. DNA编号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].dna_num;
					/*
					 *2. 姓名
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].dna_name;
					/*
					 *3. 性别
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].dna_sex;
					/*
					 *4. 出生日期
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].dna_birthday;
					/*
					 *5. 身份证号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].dna_identity;
					/*
					 *6. 地址
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].dna_address;
					/*
					 *7. 违法事实
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = DNA_VO.list_xsjsglxt_dna[num].dna_illegal_fact;
					/*
					 *8. 操作
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<i  id="'+DNA_VO.list_xsjsglxt_dna[num].xsjsglxt_dna_id+'" onClick=DNADetails(this) class="fa fa-pencil-square-o" aria-hidden="true"></i>';
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
				document.getElementById("span_pageIndex").innerHTML = DNA_VO.pageIndex;
				document.getElementById("span_totalPages").innerHTML = DNA_VO.totalPages;
				document.getElementById("span_totalRecords").innerHTML = DNA_VO.totalRecords;
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	formData.append("dnaVO.pageIndex", pageIndex);
	formData.append("dnaVO.search", input_DNASearchText);
	xhr.open("POST", "/xsjsglxt/DNA/DNAManagement_ListDNAByPageAndSearch");
	xhr.send(formData);

}

/*
 * 判断页数
 */
function flip(flipPage) {
	switch (flipPage) {
	/*首页*/
	case 1: {
		List_DNA_By_PageAndSearch(1)
		break;
	}
	/*上一页*/
	case 2: {
		if (DNA_VO.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			List_DNA_By_PageAndSearch(DNA_VO.pageIndex - 1);
		}
		break;
	}
	/*下一页*/
	case 3: {
		if (DNA_VO.pageIndex == DNA_VO.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			List_DNA_By_PageAndSearch(DNA_VO.pageIndex + 1);
		}
		break;
	}
	/*尾页*/
	case 4: {
		List_DNA_By_PageAndSearch(DNA_VO.totalPages);

		break;
	}

	}
}
