//显示数据
function get_staffDetails() {
	console.log("b1");
	var staff_id = document.getElementById("staff_id").value;
	var url = "/xsjsglxt/team/Staff_StaffInformationOne?staff.xsjsglxt_staff_id="
			+ staff_id;
	get_staffDetails_Ajax(url);
}
function get_staffDetails_Ajax(url) {
	console.log("c1");
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		console.log("d1");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var staff_info = xmlhttp.responseText;
			staff_info = JSON.parse(staff_info);
			console.log(staff_info);
			// var
			// staffDetails_input=document.getElementById("staffDetails").getElementsByTagName("input");
			// for(var key in staff_info){
			// document.getElementsByTagName("input").name="listStaff."+key;
			//		    		
			// }

			// 获取单选框元素
			// 性别
			var staff_sex = document.getElementsByName("sex_content");
			var sex_man = staff_sex[0];
			var sex_woman = staff_sex[1];
			// 是否正式
			var staff_format = document.getElementsByName("format_content");
			var isFormat = staff_format[0];
			var isNotFormat = staff_format[1];
			// 获取textarea（备注）
			var staff_contactsRemark = document
					.getElementById("staff_contactsRemark");

			// 遍历并插入input的value
			$.each(staff_info, function(key, value) {
				// 如果是性别
				if (key == "staff_sex") {
					if (value == "男") {
						sex_man.checked = true;
					} else {
						sex_woman.checked = true;
					}
				}
				// 如果是是否正式
				else if (key == "staff_isItFormal") {
					if (value == "是") {
						isFormat.checked = true;
					} else {
						isNotFormat.checked = true;
					}
				} else if (key == "staff_contactsRemark") {
					staff_contactsRemark.innerHTML = value;

				}
				$('input[name="staff.' + key + '"]').val(value);
			});
		}
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();
}

// 改变性别方法
function changeSex_man(even) {
	var sex = document.getElementById("sex");
	sex.value = even.value;
	return sex.value;
}
function changeSex_woman(even) {
	var sex = document.getElementById("sex");
	sex.value = even.value;
	return sex.value;
}

// 改变是否正式
function isFormat(even) {
	var format = document.getElementById("format");
	format.value = even.value;
	return fomat.value;
}
function isNotFormat(even) {
	var format = document.getElementById("format");
	format.value = even.value;
	return fomat.value;
}

// staffDetail.jsp中的修改人员
function staff_change() {
	var url = "/xsjsglxt/team/Staff_updateStaffInformation";
	$.confirm({
		title : '修改!',
		content : '确定修改么!',
		buttons : {

			取消 : function() {
				// here the button key 'hey' will be used as the text.
			},
			确定 : {
				action : function() {
					var staff_id = document.getElementById("staff_id").value;
					loadstaffDetail_staff_change(url, staff_id);
				}
			}
		}
	});
}
function loadstaffDetail_staff_change(url, staff_id) {
	console.log("b2");
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var staffDetails = document.getElementById("staffDetails");
	var formData = new FormData(staffDetails);
	formData.append("staff.xsjsglxt_staff_id", staff_id);

	xmlhttp.onreadystatechange = function() {
		console.log("c2");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var result = xmlhttp.responseText;
			if (result == 'success') {
				toastr.success('编辑成功！');
			} else {
				toastr.error('编辑失败！');
			}
		}
	};
	xmlhttp.open("post", url, true);
	xmlhttp.send(formData);
}
