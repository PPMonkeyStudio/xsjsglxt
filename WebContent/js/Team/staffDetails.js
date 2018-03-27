//显示数据
window.onload = function() {
	var url = window.location.href;
	var staff_id = url.substring(url.indexOf("=") + 1);
	console.log(staff_id);
	get_staffDetails(staff_id);
}
function get_staffDetails(staff_id) {
	console.log("b1");
	var url = "/xsjsglxt/team/Staff_getPolicemanByStaffId?policeman.xsjsglxt_staff_id="
			+ staff_id;
	get_staffDetails_Ajax(url, staff_id);
}
function get_staffDetails_Ajax(url, staff_id) {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var staff_info = xmlhttp.responseText;
			staff_info = JSON.parse(staff_info);
			console.log(staff_info);
			// 获取单选框元素
			// 性别
			var staff_sex = document.getElementsByName("sex_content");
			var sex_man = staff_sex[0];
			var sex_woman = staff_sex[1];
			// 是否正式
			var staff_format = document.getElementsByName("format_content");
			var isFormat = staff_format[0];
			var isNotFormat = staff_format[1];

			// 遍历并插入input的value
			$.each(staff_info, function(key, value) {
				// 如果是性别
				if (key == "xsjsglxt_sex") {
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
				}
				$('input[name="policeman.' + key + '"]').val(value);
			});
			$('#staff_duty').val(staff_info.staff_duty);
			$('#staff_MaxEducationalBackground').val(
					staff_info.staff_MaxEducationalBackground);
			$('#staff_politicalStatus').val(staff_info.staff_politicalStatus);
			document.getElementById("photo-show").innerHTML="<img src='/xsjsglxt/team/Staff_downloadPhoto?staff_imageFileName="+staff_info.staff_photo+"' />";
			
			show_studyAjax(staff_id);
			show_workAjax(staff_id);
			show_familyAjax(staff_id);
			show_moveAjax(staff_id);
			show_rewardAjax(staff_id);
			show_againstAjax(staff_id);
			show_punishmentAjax(staff_id);
			show_furloughAjax(staff_id);
		}
	}

	xmlhttp.open("post", url, true);
	xmlhttp.send();
}
// 显示学习经历
function show_studyAjax(staff_id) {
	console.log("study");
	var xmlhttp_study;
	if (window.XMLHttpRequest) {
		xmlhttp_study = new XMLHttpRequest();
	} else {
		xmlhttp_study = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_study.onreadystatechange = function() {
		if (xmlhttp_study.readyState == 4 && xmlhttp_study.status == 200) {
			var staff_study = xmlhttp_study.responseText;
			console.log("staff_study" + staff_study);
			staff_study = JSON.parse(staff_study);
			console.log(staff_study.length);

			var str1 = '';
			for (var len = 0; len < staff_study.length; len++) {
				str1 += '<tr>';
				str1 += '<td>' + staff_study[len].staffStudent_address
						+ '</td>';
				str1 += '<td>' + staff_study[len].staffStudent_startTime
						+ '</td>';
				str1 += '<td>' + staff_study[len].staffStudent_startTime
						+ '</td>';
				str1 += '<td>' + staff_study[len].staffStudent_stopTime
						+ '</td>';
				str1 += '<td> <button class="btn btn-default btn-xs delete_button"  type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str1 += '</tr>';

			}
			$('#studyExperience_table tbody tr').after(str1);

		}
	}
	xmlhttp_study.open("POST",
			"/xsjsglxt/team/StaffStudent_getStudentByStaffId?student.staffStudent_staff="
					+ staff_id, true);
	xmlhttp_study.send();
}
// 显示工作经历
function show_workAjax(staff_id) {
	var xmlhttp_work;
	if (window.XMLHttpRequest) {
		xmlhttp_work = new XMLHttpRequest();
	} else {
		xmlhttp_work = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_work.onreadystatechange = function() {
		if (xmlhttp_work.readyState == 4 && xmlhttp_work.status == 200) {
			var staff_work = xmlhttp_work.responseText;
			console.log(staff_work);
			staff_work = JSON.parse(staff_work);
			console.log(staff_work);

			var str2 = '';
			for (var len = 0; len < staff_work.length; len++) {
				str2 += '<tr>';
				str2 += '<td>' + staff_work[len].staffWork_address + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_address + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_startTime + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_stopTime + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_remarks + '</td>';
				str2 += '<td> <button class="btn btn-default btn-xs" type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str2 += '</tr>';
			}
			$('#wordExperience_table tbody tr').after(str2);

		}
	}
	xmlhttp_work.open("POST",
			"/xsjsglxt/team/StaffWork_getWorkByStaffId?work.staffWork_staff="
					+ staff_id, true);
	xmlhttp_work.send();
}
// 显示家庭关系
function show_familyAjax(staff_id) {
	var xmlhttp_family;
	if (window.XMLHttpRequest) {
		xmlhttp_family = new XMLHttpRequest();
	} else {
		xmlhttp_family = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_family.onreadystatechange = function() {
		if (xmlhttp_family.readyState == 4 && xmlhttp_family.status == 200) {
			var staff_family = xmlhttp_family.responseText;
			console.log(staff_family);
			staff_family = JSON.parse(staff_family);
			console.log(staff_family);

			var str3 = '';
			for (var len = 0; len < staff_family.length; len++) {
				str3 += '<tr>';
				str3 += '<td>'
						+ staff_family[len].staffFamily_contactsRelationship
						+ '</td>';
				str3 += '<td>' + staff_family[len].staffFamily_name + '</td>';
				str3 += '<td>' + staff_family[len].staffFamily_IDcard + '</td>';
				str3 += '<td>' + staff_family[len].staffFamily_birthday
						+ '</td>';
				str3 += '<td>' + staff_family[len].staffFamily_tel + '</td>';
				str3 += '<td>' + staff_family[len].staffFamily_WeiXin + '</td>';
				str3 += '<td>' + staff_family[len].staffFamily_workSpace
						+ '</td>';
				str3 += '<td>' + staff_family[len].staffFamily_duty + '</td>';
				str3 += '<td colspan="2">'
						+ staff_family[len].staffFamily_remarks + '</td>';
				str3 += '<td> <button class="btn btn-default btn-xs" type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str3 += '</tr>';
			}
			$('#family_table tbody tr').after(str3);

		}
	}
	xmlhttp_family.open("POST",
			"/xsjsglxt/team/StaffFamily_getFamilyByStaffId?family.staffFamily_staff="
					+ staff_id, true);
	xmlhttp_family.send();
}

// 显示刑警大队调动情况
function show_moveAjax(staff_id) {
	var xmlhttp_move;
	if (window.XMLHttpRequest) {
		xmlhttp_move = new XMLHttpRequest();
	} else {
		xmlhttp_move = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_move.onreadystatechange = function() {
		if (xmlhttp_move.readyState == 4 && xmlhttp_move.status == 200) {
			var staff_move = xmlhttp_move.responseText;
			console.log("staff_move" + staff_move);
			staff_move = JSON.parse(staff_move);
			console.log(staff_move.length);

			var str4 = '';
			for (var len = 0; len < staff_move.length; len++) {
				str4 += '<tr>';
				str4 += '<td>' + staff_move[len].staffMove_inTime + '</td>';
				str4 += '<td>' + staff_move[len].staffMove_outTime + '</td>';
				str4 += '<td>' + staff_move[len].staffMove_guard + '</td>';
				str4 += '<td>' + staff_move[len].staffMove_remarks + '</td>';
				str4 += '<td> <button class="btn btn-default btn-xs" type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str4 += '</tr>';
			}
			$('#policeChange_table tbody tr').after(str4);

		}
	}
	xmlhttp_move.open("POST",
			"/xsjsglxt/team/StaffMove_getMoveByStaffId?move.staffMove_staff="
					+ staff_id, true);
	xmlhttp_move.send();
}
// 显示立功受奖情况
function show_rewardAjax(staff_id) {
	var xmlhttp_reward;
	if (window.XMLHttpRequest) {
		xmlhttp_reward = new XMLHttpRequest();
	} else {
		xmlhttp_reward = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_reward.onreadystatechange = function() {
		if (xmlhttp_reward.readyState == 4 && xmlhttp_reward.status == 200) {
			var staff_reward = xmlhttp_reward.responseText;
			console.log(staff_reward);
			staff_reward = JSON.parse(staff_reward);
			console.log(staff_reward);

			var str5 = '';
			for (var len = 0; len < staff_reward.length; len++) {
				str5 += '<tr>';
				str5 += '<td>' + staff_reward[len].staffReward_situation
						+ '</td>';
				str5 += '<td>' + staff_reward[len].staffReward_Time + '</td>';
				str5 += '<td>' + staff_reward[len].staffReward_remarks
						+ '</td>';
				str5 += '<td> <button class="btn btn-default btn-xs" type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str5 += '</tr>';
			}
			$('#prized_table tbody tr').after(str5);

		}
	}
	xmlhttp_reward.open("POST",
			"/xsjsglxt/team/StaffReward_getRewardByStaffId?reward.staffReward_staff="
					+ staff_id, true);
	xmlhttp_reward.send();
}
// 显示违纪情况
function show_againstAjax(staff_id) {
	var xmlhttp_against;
	if (window.XMLHttpRequest) {
		xmlhttp_against = new XMLHttpRequest();
	} else {
		xmlhttp_against = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_against.onreadystatechange = function() {
		if (xmlhttp_against.readyState == 4 && xmlhttp_against.status == 200) {
			var staff_against = xmlhttp_against.responseText;
			console.log(staff_against);
			staff_against = JSON.parse(staff_against);
			console.log(staff_against);

			var str6 = '';
			for (var len = 0; len < staff_against.length; len++) {
				str6 += '<tr>';
				str6 += '<td>' + staff_against[len].staffPrinciple_situation
						+ '</td>';
				str6 += '<td>' + staff_against[len].staffPrinciple_Time
						+ '</td>';
				str6 += '<td>' + staff_against[len].staffPrinciple_remarks
						+ '</td>';
				str6 += '<td> <button class="btn btn-default btn-xs" type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str6 += '</tr>';
			}
			$('#againstPrinciple_table tbody tr').after(str6);

		}
	}
	xmlhttp_against
			.open(
					"POST",
					"/xsjsglxt/team/StaffPrinciple_getPrincipleByStaffId?principle.staffPrinciple_staff="
							+ staff_id, true);
	xmlhttp_against.send();
}
// 显示处分情况
function show_punishmentAjax(staff_id) {
	var xmlhttp_punishment;
	if (window.XMLHttpRequest) {
		xmlhttp_punishment = new XMLHttpRequest();
	} else {
		xmlhttp_punishment = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_punishment.onreadystatechange = function() {
		if (xmlhttp_punishment.readyState == 4
				&& xmlhttp_punishment.status == 200) {
			var staff_punishment = xmlhttp_punishment.responseText;
			console.log(staff_punishment);
			staff_punishment = JSON.parse(staff_punishment);
			console.log(staff_punishment);

			var str7 = '';
			for (var len = 0; len < staff_punishment.length; len++) {
				str7 += '<tr>';
				str7 += '<td>'
						+ staff_punishment[len].staffPunishment_situation
						+ '</td>';
				str7 += '<td>' + staff_punishment[len].staffPunishment_Time
						+ '</td>';
				str7 += '<td>' + staff_punishment[len].staffPunishment_remarks
						+ '</td>';
				str7 += '<td> <button class="btn btn-default btn-xs" type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str7 += '</tr>';
			}
			$('#punish_table tbody tr').after(str7);

		}
	}
	xmlhttp_punishment
			.open(
					"POST",
					"/xsjsglxt/team/StaffPunishment_getPunishmentByStaffId?punishment.staffPunishment_staff="
							+ staff_id, true);
	xmlhttp_punishment.send();
}
// 显示休假情况
function show_furloughAjax(staff_id) {
	var xmlhttp_furlough;
	if (window.XMLHttpRequest) {
		xmlhttp_furlough = new XMLHttpRequest();
	} else {
		xmlhttp_furlough = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_furlough.onreadystatechange = function() {
		if (xmlhttp_furlough.readyState == 4 && xmlhttp_furlough.status == 200) {
			var staff_furlough = xmlhttp_furlough.responseText;
			staff_furlough = JSON.parse(staff_furlough);

			var str8 = '';
			for (var len = 0; len < staff_furlough.length; len++) {
				str8 += '<tr>';
				str8 += '<td>' + staff_furlough[len].staffFurlough_mainContent
						+ '</td>';
				str8 += '<td>' + staff_furlough[len].staffFurlough_startTime
						+ '</td>';
				str8 += '<td>' + staff_furlough[len].staffFurlough_days
						+ '</td>';
				str8 += '<td>' + staff_furlough[len].staffFurlough_whetherStop
						+ '</td>';
				str8 += '<td>' + staff_furlough[len].staffFurlough_stopTime
						+ '</td>';
				str8 += '<td>' + staff_furlough[len].staffFurlough_remarks
						+ '</td>';
				str8 += '<td> <button class="btn btn-default btn-xs" type="button" style="margin-left: 10px;"><i class="fa fa-plus-square"></i></button></td>';
				str8 += '</tr>';
			}
			$('#vocation_table tbody tr').after(str8);

		}
	}
	xmlhttp_furlough
			.open(
					"POST",
					"/xsjsglxt/team/StaffFurlough_getFurloughByStaffId?furlough.staffFurlough_staff="
							+ staff_id, true);
	xmlhttp_furlough.send();
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

					/*
					 * // 判断基本信息表单是否为空 var staff_details =
					 * document.querySeletor(".staff_body").staffDetails; for
					 * (var i =0; i < staff_details.elements.length - 1; i++) {
					 * if(staff_details.elements[i].value == "") {
					 * toastr.success('基本信息不能有空项哦！');
					 * staff_details.elements[i].focus(); return false; } } //
					 * 判断八个长表格表单是否为空 var staff_details =
					 * document.querySeletorAll(".longBoxs"); for (var i = 0; i
					 * <staff_details.length; i++) { var
					 * long_formElement=staff_details[i].elements; for (var j
					 * =0; j < long_formElement.length - 1; j++) {
					 * if(long_formElement.value == "") {
					 * toastr.success('基本信息不能有空项哦！');
					 * staff_details.elements[j].focus(); return false; } } }
					 */

					var staff_id = document.getElementById("staff_id").value;
					loadstaffDetail_staff_change(url, staff_id);
				}
			}
		}
	});
}
// 修改按钮
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
// 长表格学习经历添加
var relive_study = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
}
// 长表格工作经历添加
var relive_work = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
}
// 长表格家庭添加
var relive_family = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
}
// 长表格刑警调动弄个添加
var relive_move = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
}
// 长表格立功添加
var relive_reward = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
}
// 长表格违纪
var relive_against = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		type : "POST",
		url : "test.json",
		data : {
			staffStudent_address : $(".staffStudent_address").val(),
			staffStudent_startTime : $(".staffStudent_startTime").val(),
			staffStudent_stopTime : $(".staffStudent_stopTime").val(),
			staffStudent_remarks : $(".staffStudent_remarks").val(),
		},
		dataType : "json",
		success : function(data) {
			$('#resText').empty(); // 清空resText里面的所有内容
			var html = '';
			$.each(data, function(commentIndex, comment) {
				html += '<div class="comment"><h6>' + comment['username']
				+ ':</h6><p class="para"' + comment['content']
				+ '</p></div>';
			});
			$('#resText').html(html);
		}
	});

}
// 长表格处分添加
var relive_punishment = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
}
// 长表格休假添加
var relive_furlough = function(event) {
	// 此处调用九个接口
	// 删除警员基本信息
	$.ajax({
		url : '/xsjsglxt/team/Staff_deletePoliceman',
		type : 'POST',
		data : {
			'policeman.xsjsglxt_staff_id' : event.id
		}
	});
}