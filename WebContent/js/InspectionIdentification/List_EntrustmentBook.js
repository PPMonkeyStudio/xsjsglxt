var EntrustmentBook_json = null;

function List_EntrustmentBook(pageIndex) {
	document.getElementById("i_pulse").style.display = "block";
	if (userPowerDTO.user_check_power_modified == true) {

	} else {
		var userCheckPowers = document
				.getElementsByClassName("user_check_power");
		var userCheckPowers_Length = userCheckPowers.length;
		for (var num = 0; num < userCheckPowers_Length; num++) {
			userCheckPowers[0].parentNode.removeChild(userCheckPowers[0]);
		}
	}
	/*
	 * 
	 */
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.log(xhr.responseText);
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
				for (var num = 0; num < EntrustmentBook_json.listEntrustmentBookManagementDTO.length; num++) {

					new_tr = document.createElement("tr");
					table_EntrustmentBook.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					/*
					 * 委托编号
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = '<a class="btn-link" onclick="Preview_EntrustmentBook(this)" id="'
							+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
							+ '">'
							+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_num
							+ '</a>';
					/*
					 * 案（事）件名称
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_case_name;
					/*
					 * 鉴定要求
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request;
					/*
					 * 委托单位
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit;
					/*
					 * 被委托鉴定机构名称
					 */
					// new_td = document.createElement("td");
					// new_tr.appendChild(new_td);
					// new_td.innerHTML =
					// EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_unit_name;
					/*
					 * 委托日期
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_inspect_time;
					/*
					 * 类型
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					if (EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_type == "痕迹") {
						new_td.innerHTML = "通用";
					} else {
						new_td.innerHTML = EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_type;
					}

					/*
					 * 状态
					 */
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					switch (EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_state) {
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
					switch (EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_state) {
					case '正在申请': {
						if (userPowerDTO.user_check_power_modified == true) {
							new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-angle-double-down" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
									+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
									+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
									+ '<li class="managerPower"><a onclick="Acceptance_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-legal"></i> 受理</a></li>'
									+ '<li class="managerPower"><a onclick="Refuse_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-recycle"></i> 不受理</a></li>'
									+ '</ul></div>';
						} else {
							new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-angle-double-down" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
									+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
									+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
									+ '</ul></div>';
						}

						break;
					}
					case '申请已受理': {

						if (userPowerDTO.user_check_power_modified == true) {
							new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-angle-double-down" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
									+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
									+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
									+ '<li><a onclick="Preview_ConfirmBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
									+ '<li><a onclick="Preview_AcceptanceEntrustmentInform(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
									+ '<li  class="managerPower"><a onclick="Create_InspectionRecord(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-pencil-square-o"></i> 记录检验过程</a></li>'
									+ '</ul></div>';
						} else {
							new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-angle-double-down" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
									+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
									+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
									+ '<li><a onclick="Preview_ConfirmBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
									+ '<li><a onclick="Preview_AcceptanceEntrustmentInform(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
									+ '</ul></div>';
						}

						break;
					}
					case '申请被拒绝': {
						new_td.innerHTML = '<div class="dropdown"><i style="cursor: pointer;" class="fa fa-angle-double-down" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
								+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
								+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
								+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
								+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
								+ '<li><a onclick="Preview_NotAcceptanceEntrustmentInform(this)" id="'
								+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
								+ '"><i class="fa fa-file-text-o"></i> 查看不受理委托鉴定告知书</a></li>'
								+ '</ul></div>';

						break;
					}
					case '已记录': {
						if (userPowerDTO.user_check_power_modified == true) {
							new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-angle-double-down" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
									+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
									+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
									+ '<li><a onclick="Preview_ConfirmBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
									+ '<li><a onclick="Preview_AcceptanceEntrustmentInform(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
									+ '<li><a onclick="Preview_InspectionRecord(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看检验记录</a></li>'
									+ '<li class="managerPower"><a onclick="Create_AppraisalLetter(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-pencil-square-o"></i> 出具鉴定文书</a></li>'
									+ '</ul></div>';
						} else {
							new_td.innerHTML = '<div class="dropdown" ><i  class="fa fa-angle-double-down" style="cursor: pointer;" id="dLabel" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
									+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
									+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
									+ '<li><a onclick="Preview_ConfirmBook(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
									+ '<li><a onclick="Preview_AcceptanceEntrustmentInform(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
									+ '<li><a onclick="Preview_InspectionRecord(this)" id="'
									+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
									+ '"><i class="fa fa-file-text-o"></i> 查看检验记录</a></li>'
									+ '</ul></div>';
						}

						break;
					}
					case '已鉴定': {
						new_td.innerHTML = '<div class="dropdown"><i style="cursor: pointer;" class="fa fa-angle-double-down" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup=true aria-expanded="false"></i>'
								+ '<ul class="dropdown-menu" aria-labelledby="dLabel">'
								+ '<li><a onclick="Preview_EntrustmentBook(this)" id="'
								+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
								+ '"><i class="fa fa-file-text-o"></i> 查看鉴定委托书</a></li>'
								+ '<li><a onclick="Preview_ConfirmBook(this)" id="'
								+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
								+ '"><i class="fa fa-file-text-o"></i> 查看鉴定事项确认书</a></li>'
								+ '<li><a onclick="Preview_AcceptanceEntrustmentInform(this)" id="'
								+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
								+ '"><i class="fa fa-file-text-o"></i> 查看受理鉴定回执</a></li>'
								+ '<li><a onclick="Preview_InspectionRecord(this)" id="'
								+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
								+ '"><i class="fa fa-file-text-o"></i> 查看检验记录</a></li>'
								+ '<li><a onclick="Preview_AppraisalLetter(this)" id="'
								+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
								+ '"><i class="fa fa-file-text-o"></i> 查看鉴定文书</a></li>'
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
							+ EntrustmentBook_json.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id
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
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr
			.open(
					"POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_getListCheckEntrustmentBookByPage",
					false);

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
	 * 筛选：鉴定要求
	 */
	if (document.getElementById("select_entrustmentRequire").value == "-1") {
	} else {
		formData.append("entrustmentBookManagementVO.entrustmentRequire",
				document.getElementById("select_entrustmentRequire").value);
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
	 * 筛选：委托单位
	 */
	if (userPowerDTO.user_check_power_modified == true) {
		if (document.getElementById("select_entrustmentUnit").value == "-1") {
			formData
					.append("entrustmentBookManagementVO.entrustmentUnit", "-1");
		} else {
			formData.append("entrustmentBookManagementVO.entrustmentUnit",
					document.getElementById("select_entrustmentUnit").value);
		}
	} else {
		/*
		 * 只能查看本单位
		 */
		var xhr_currUser = false;
		xhr_currUser = new XMLHttpRequest();
		xhr_currUser.onreadystatechange = function() {
			var message;
			if (xhr_currUser.readyState == 4) {
				if (xhr_currUser.status == 200) {
					var currUser = JSON.parse(xhr_currUser.responseText);
					/*
					 * 获取单位的通讯录信息
					 */
					switch (currUser.user_units) {
					case '安源公安分局刑警大队': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"安源公安分局刑警大队");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "安源公安分局刑警大队";
						/*
						 * 
						 */
						break;
					}
					case '安源派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"安源派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "安源派出所";
						/*
						 * 
						 */
						break;
					}
					case '城郊派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"城郊派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "城郊派出所";
						/*
						 * 
						 */
						break;
					}
					case '凤凰派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"凤凰派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "凤凰派出所";
						/*
						 * 
						 */
						break;
					}
					case '后埠派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"后埠派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "后埠派出所";
						/*
						 * 
						 */
						break;
					}
					case '八一派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"八一派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "八一派出所";
						/*
						 * 
						 */
						break;
					}
					case '东大派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"东大派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "东大派出所";
						/*
						 * 
						 */
						break;
					}
					case '青山派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"青山派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "青山派出所";
						/*
						 * 
						 */
						break;
					}
					case '丹江派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"丹江派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "丹江派出所";
						/*
						 * 
						 */
						break;
					}
					case '白源派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"白源派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "白源派出所";
						/*
						 * 
						 */
						break;
					}
					case '高坑派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"高坑派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "高坑派出所";
						/*
						 * 
						 */
						break;
					}
					case '五陂下派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"五陂下派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "五陂下派出所";
						/*
						 * 
						 */
						break;
					}
					case '李子园派出所': {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"李子园派出所");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "李子园派出所";
						/*
						 * 
						 */
						break;
					}
					default: {
						formData.append(
								"entrustmentBookManagementVO.entrustmentUnit",
								"其他");
						/*
						 * 
						 */
						var select_entrustmentUnit = document
								.getElementById("select_entrustmentUnit");
						select_entrustmentUnit.parentNode.innerHTML = "其他";
						/*
						 * 
						 */
						break;
					}
					}
					/*
					 * 
					 */
				} else {
					toastr.error(xhr_currUser.status);
				}
			}
		}
		var formData = new FormData();
		xhr_currUser.open("POST", "/xsjsglxt/user/User_getCurrUser", false);
		xhr_currUser.send(formData);
		/*
		 * 
		 */
	}
	/*
	 * 筛选：开始时间
	 */
	var start_time = document.getElementById("select_start_time").value;
	if (start_time == undefined || start_time == null || start_time == "") {
	} else {
		formData.append("entrustmentBookManagementVO.start_time", start_time);
	}
	var stop_time = document.getElementById("select_stop_time").value;
	if (stop_time == undefined || stop_time == null || stop_time == "") {
	} else {
		formData.append("entrustmentBookManagementVO.stop_time", stop_time);
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
		List_EntrustmentBook(1)
		break;
	}
	case 2: {
		if (EntrustmentBook_json.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			List_EntrustmentBook(EntrustmentBook_json.pageIndex - 1);
		}
		break;
	}
	case 3: {
		if (EntrustmentBook_json.pageIndex == EntrustmentBook_json.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			List_EntrustmentBook(EntrustmentBook_json.pageIndex + 1);
		}
		break;
	}
	case 4: {
		List_EntrustmentBook(EntrustmentBook_json.totalPages);

		break;
	}

	}
}