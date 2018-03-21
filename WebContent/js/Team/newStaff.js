var newStudyExp = {
//	"study_startTime" : "",
//	"study_endTime" : "",
//	"study_indication" : "",
//	"study_supperment" : "",
//	"staffWork_address" : "",
//	"staffWork_duty" : "",
//	"staffWork_startTime" : "",
//	"staffWork_stopTime" : "",
//	"staffWork_remarks" : "",
//	"staffFamily_contactsRelationship":"",
//	"staffFamily_name":"",
//	"staffFamily_IDcard":"",
//	"staffFamily_birthday":"",
//	"staffFamily_tel":"",
//	"staffFamily_WeiXin":"",
//	"staffFamily_workSpace":"",
//	"staffFamily_duty":"",
//	"staffFamily_remarks":"",
//	"staffMove_inTime":"",
//	"staffMove_outTime":"",
//	"staffMove_guard":"",
//	"staffMove_remarks":"",
//    "staffReward_situation":"",
//    "staffReward_Time":"",
//    "staffReward_remarks":"",
    
};
// newStaff新建人员
function staff_change() {
	var url = "/xsjsglxt/team/Staff_saveStaff";
	$.confirm({
		title : '新建!',
		content : '确定新建么!',
		buttons : {

			取消 : function() {
				// here the button key 'hey' will be used as the text.
			},
			确定 : {
				action : function() {

					loadstaffDetail_staff_change(url);
				}
			}
		}
	});

}
function loadstaffDetail_staff_change(url) {
	console.log("b2");
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var staffDetails = document.getElementById("staffDetails");
	var formData = new FormData(staffDetails);

	xmlhttp.onreadystatechange = function() {
		console.log("c2");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var id = xmlhttp.responseText;
			// 得到
			family_ajax(id);
		}
	};
	xmlhttp.open("post", url, true);
	// xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	xmlhttp.send(formData);
}

function family_ajax(id) {
	console.log("b3");
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var formdata = new FormData();
	var family = document.getElementById("family_table");
	var familyTr = family.getElementsByTagName("tr");
	for (var i = 1; i < familyTr.length; i++) {
		formdata.append("students.study_startTime",familyTr.getElementById("students.study_startTime").innerHTML);
		formdata.append("students.study_endTime",familyTr.getElementById("students.study_endTime").innerHTML);
		formData.append("staffFamily_staff", id);
	}
	formData.append("staffFamily_staff", id);
	xmlhttp.onreadystatechange = function() {
		console.log("c3");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log("family"+xmlhttp.responseText);
			studyExp_ajax(id);
		}

	};
	xmlhttp.open("post", url, true);
	// xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	xmlhttp.send(formData);
}
function studyExp_ajax(id){
	console.log("b4");
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var police_move = document.getElementById("police_move");
	var formData = new FormData(family);
	formData.append("staffFamily_staff", id);
	xmlhttp.onreadystatechange = function() {
		console.log("c4");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log("police_move"+xmlhttp.responseText);
			studyExp_ajax(id);
		}

	};
	xmlhttp.open("post", url, true);
	// xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	xmlhttp.send(formData);
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
// 实现点击file
function photo_click() {
	var photo_file = document.querySelector(".photo-file");
	photo_file.click();
}
// 图片预览
function photo_preview() {

	var photo_file = document.querySelector(".photo-file");
	var photo_show = document.querySelector(".photo-show");
	var photo_files = photo_file.files;
	for (var i = 0; i < photo_files.length; i++) {
		photo_show.innerHTML += "<img class='image" + i + "'>";
		var image = document.querySelector(".image" + i);
		if (photo_file.files && photo_file.files[i]) {
			// 火狐直接获取src
			image.style.display = 'block';
			image.style.width = '120px';
			image.style.height = '150px';
			image.src = window.URL.createObjectURL(photo_file.files[i]);
		} else {
			// IE下，使用滤镜
			photo_file.select();
			var imgSrc = document.selection.createRange().text;
			// 必须设置初始大小
			photo_show.style.width = "120px";
			photo_show.style.height = "150px";
			// 图片异常的捕捉，防止用户修改后缀来伪造图片
			try {
				photo_show.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				photo_show.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
		}

	}/*
		 * // 获取上传的文件名 var photo_fileValue = photo_file.value; var fileValue =
		 * photo_fileValue.split("\\"); var fileName =
		 * fileValue[fileValue.length - 1]; console.log(fileName);
		 * photo_file.value=fileName;
		 */
	return true;
}
// 添加学习经历
function add_studyExperience() {
	console.log("add_studyExperience start");
	// 把表格的数据存到json中
	var study_startTime = document.querySelector(".study_startTime").value;
	var study_endTime = document.querySelector(".study_endTime").value;
	var study_indication = document.querySelector(".study_indication").value;
	var study_supperment = document.querySelector(".study_supperment").value;
	newStudyExp['study_startTime'] = study_startTime;
	newStudyExp['study_endTime'] = study_endTime;
	newStudyExp['study_indication'] = study_indication;
	newStudyExp['study_supperment'] = study_supperment;
	console.log(newStudyExp['study_startTime']);
	// 动态创建表格
	var studyExperience_table = document
			.getElementById("studyExperience_table");
	studyExperience_table.setAttribute("class", "long_table");

	var study_tr = document.createElement("tr");
	var study_startTime = document.createElement("td");
	study_startTime.innerHTML = newStudyExp['study_startTime'];
	study_startTime.setAttribute("name","students.study_startTime");
	console.log(study_startTime.innerHTML);
	var study_endTime = document.createElement("td");
	study_endTime.innerHTML = newStudyExp['study_endTime'];
	study_endTime.setAttribute("name","students.study_endTime");
	
	var study_indication = document.createElement("td");
	study_indication.innerHTML = newStudyExp['study_indication'];
	study_indication.setAttribute("name","students.study_indication");
	
	var study_supperment = document.createElement("td");
	study_supperment.innerHTML = newStudyExp['study_supperment'];
	study_supperment.setAttribute("name","students.study_supperment");
	
	study_tr.appendChild(study_startTime);
	study_tr.appendChild(study_endTime);
	study_tr.appendChild(study_indication);
	study_tr.appendChild(study_supperment);
	studyExperience_table.append(study_tr);
}
function add_workExperience() {
	console.log("add_workExperience start");
	// 把表格的数据存到json中
	var staffWork_address = document.querySelector(".staffWork_address").value;
	var staffWork_duty = document.querySelector(".staffWork_duty").value;
	var staffWork_startTime = document.querySelector(".staffWork_startTime").value;
	var staffWork_stopTime = document.querySelector(".staffWork_stopTime").value;
	var staffWork_remarks = document.querySelector(".staffWork_remarks").value;
    
	console.log(staffWork_address);
	newStudyExp['staffWork_address'] = staffWork_address;
	newStudyExp['staffWork_duty'] = staffWork_duty;
	newStudyExp['staffWork_startTime'] = staffWork_startTime;
	newStudyExp['staffWork_stopTime'] = staffWork_stopTime;
	newStudyExp['staffWork_remarks'] = staffWork_remarks;
	console.log(newStudyExp['staffWork_address']);
	// 动态创建表格
	var wordExperience_table = document
			.getElementById("wordExperience_table");
	wordExperience_table.setAttribute("class", "long_table");

	var work_tr = document.createElement("tr");
	
	var staffWork_address = document.createElement("td");
	staffWork_address.innerHTML = newStudyExp['staffWork_address'];
	staffWork_address.setAttribute("name","works.staffWork_address");
	console.log(staffWork_address.innerHTML);
	
	var staffWork_duty = document.createElement("td");
	staffWork_duty.innerHTML = newStudyExp['staffWork_duty'];
	staffWork_duty.setAttribute("name","works.staffWork_duty");
	console.log(staffWork_duty.innerHTML);
	
	var staffWork_startTime = document.createElement("td");
	staffWork_startTime.innerHTML = newStudyExp['staffWork_startTime'];
	staffWork_startTime.setAttribute("name","works.staffWork_startTime");
	
	var staffWork_stopTime = document.createElement("td");
	staffWork_stopTime.innerHTML = newStudyExp['staffWork_stopTime'];
	staffWork_stopTime.setAttribute("name","works.staffWork_stopTime");
	
	var staffWork_remarks = document.createElement("td");
	staffWork_remarks.innerHTML = newStudyExp['staffWork_remarks'];
	staffWork_remarks.setAttribute("name","works.staffWork_remarks");
	
	work_tr.appendChild(staffWork_address);
	work_tr.appendChild(staffWork_duty);
	work_tr.appendChild(staffWork_startTime);
	work_tr.appendChild(staffWork_stopTime);
	work_tr.appendChild(staffWork_remarks);
	wordExperience_table.append(work_tr);
}
function add_family() {
	console.log("add_family start");
	// 把表格的数据存到json中
	var staffFamily_contactsRelationship = document.querySelector(".staffFamily_contactsRelationship").value;
	var staffFamily_name = document.querySelector(".staffFamily_name").value;
	var staffFamily_IDcard = document.querySelector(".staffFamily_IDcard").value;
	var staffFamily_birthday = document.querySelector(".staffFamily_birthday").value;
	var staffFamily_tel = document.querySelector(".staffFamily_tel").value;
	var staffFamily_WeiXin = document.querySelector(".staffFamily_WeiXin").value;
	var staffFamily_workSpace = document.querySelector(".staffFamily_workSpace").value;
	var staffFamily_duty = document.querySelector(".staffFamily_duty").value;
	var staffFamily_remarks = document.querySelector(".staffFamily_remarks").value;
	
	newStudyExp['staffFamily_contactsRelationship'] = staffFamily_contactsRelationship;
	newStudyExp['staffFamily_name'] = staffFamily_name;
	newStudyExp['staffFamily_IDcard'] = staffFamily_IDcard;
	newStudyExp['staffFamily_birthday'] = staffFamily_birthday;
	newStudyExp['staffFamily_tel'] = staffFamily_tel;
	newStudyExp['staffFamily_WeiXin'] = staffFamily_WeiXin;
	newStudyExp['staffFamily_workSpace'] = staffFamily_workSpace;
	newStudyExp['staffFamily_duty'] = staffFamily_duty;
	newStudyExp['staffFamily_remarks'] = staffFamily_remarks;
	console.log(newStudyExp['study_startTime']);
	// 动态创建表格
	var family_table = document
			.getElementById("family_table");
	family_table.setAttribute("class", "long_table");

	var family_tr = document.createElement("tr");
	var staffFamily_contactsRelationship = document.createElement("td");
	staffFamily_contactsRelationship.innerHTML = newStudyExp['staffFamily_contactsRelationship'];
	staffFamily_contactsRelationship.setAttribute("name","students.staffFamily_contactsRelationship");
	console.log(staffFamily_contactsRelationship.innerHTML);
	
	var staffFamily_name = document.createElement("td");
	staffFamily_name.innerHTML = newStudyExp['staffFamily_name'];
	staffFamily_name.setAttribute("name","familys.staffFamily_name");
	
	var staffFamily_IDcard = document.createElement("td");
	staffFamily_IDcard.innerHTML = newStudyExp['staffFamily_IDcard'];
	staffFamily_IDcard.setAttribute("name","familys.staffFamily_IDcard");
	
	var staffFamily_birthday = document.createElement("td");
	staffFamily_birthday.innerHTML = newStudyExp['staffFamily_birthday'];
	staffFamily_birthday.setAttribute("name","familys.staffFamily_birthday");
	
	var staffFamily_tel = document.createElement("td");
	staffFamily_tel.innerHTML = newStudyExp['staffFamily_tel'];
	staffFamily_tel.setAttribute("name","familys.staffFamily_tel");
	
	var staffFamily_WeiXin = document.createElement("td");
	staffFamily_WeiXin.innerHTML = newStudyExp['staffFamily_WeiXin'];
	staffFamily_WeiXin.setAttribute("name","familys.staffFamily_WeiXin");
	
	var staffFamily_workSpace = document.createElement("td");
	staffFamily_workSpace.innerHTML = newStudyExp['staffFamily_workSpace'];
	staffFamily_workSpace.setAttribute("name","familys.staffFamily_workSpace");
	
	var staffFamily_duty = document.createElement("td");
	staffFamily_duty.innerHTML = newStudyExp['staffFamily_duty'];
	staffFamily_duty.setAttribute("name","familys.staffFamily_duty");
	
	var staffFamily_remarks = document.createElement("td");
	staffFamily_remarks.innerHTML = newStudyExp['staffFamily_remarks'];
	staffFamily_remarks.setAttribute("name","familys.staffFamily_remarks");
	
	family_tr.appendChild(staffFamily_contactsRelationship);
	family_tr.appendChild(staffFamily_name);
	family_tr.appendChild(staffFamily_IDcard);
	family_tr.appendChild(staffFamily_birthday);
	family_tr.appendChild(staffFamily_tel);
	family_tr.appendChild(staffFamily_WeiXin);
	family_tr.appendChild(staffFamily_workSpace);
	family_tr.appendChild(staffFamily_duty);
	family_tr.appendChild(staffFamily_remarks);
	family_table.append(family_tr);
}
function add_policeChange() {
	console.log("add_policeChange start");
	// 把表格的数据存到json中
	var staffMove_inTime = document.querySelector(".staffMove_inTime").value;
	var staffMove_outTime = document.querySelector(".staffMove_outTime").value;
	var staffMove_guard = document.querySelector(".staffMove_guard").value;
	var staffMove_remarks = document.querySelector(".staffMove_remarks").value;
	newStudyExp['staffMove_inTime'] = staffMove_inTime;
	newStudyExp['staffMove_outTime'] = staffMove_outTime;
	newStudyExp['staffMove_guard'] = staffMove_guard;
	newStudyExp['staffMove_remarks'] = staffMove_remarks;
	console.log(newStudyExp['staffMove_inTime']);
	// 动态创建表格
	var policeChange_table = document
			.getElementById("policeChange_table");
	policeChange_table.setAttribute("class", "long_table");

	var policemanChange_tr = document.createElement("tr");
	var staffMove_inTime = document.createElement("td");
	staffMove_inTime.innerHTML = newStudyExp['staffMove_inTime'];
	staffMove_inTime.setAttribute("name","moves.staffMove_inTime");
	console.log(staffMove_inTime.innerHTML);
	
	var staffMove_outTime = document.createElement("td");
	staffMove_outTime.innerHTML = newStudyExp['staffMove_outTime'];
	staffMove_outTime.setAttribute("name","moves.staffMove_outTime");
	
	var staffMove_guard = document.createElement("td");
	staffMove_guard.innerHTML = newStudyExp['staffMove_guard'];
	staffMove_guard.setAttribute("name","moves.staffMove_guard");
	
	var staffMove_remarks = document.createElement("td");
	staffMove_remarks.innerHTML = newStudyExp['staffMove_remarks'];
	staffMove_remarks.setAttribute("name","moves.staffMove_remarks");
	
	policemanChange_tr.appendChild(staffMove_inTime);
	policemanChange_tr.appendChild(staffMove_outTime);
	policemanChange_tr.appendChild(staffMove_guard);
	policemanChange_tr.appendChild(staffMove_remarks);
	policeChange_table.append(policemanChange_tr);
}
function add_prized() {
	console.log("add_prized start");
	// 把表格的数据存到json中
	var staffReward_situation = document.querySelector(".staffReward_situation").value;
	var staffReward_Time = document.querySelector(".staffReward_Time").value;
	var staffReward_remarks = document.querySelector(".staffReward_remarks").value;
	
	newStudyExp['staffReward_situation'] = staffReward_situation;
	newStudyExp['staffReward_Time'] = staffReward_Time;
	newStudyExp['staffReward_remarks'] = staffReward_remarks;
	console.log(newStudyExp['staffReward_remarks']);
	// 动态创建表格
	var prized_table = document
			.getElementById("prized_table");
	prized_table.setAttribute("class", "long_table");

	var prized_tr = document.createElement("tr");
	
	var staffReward_situation = document.createElement("td");
	staffReward_situation.innerHTML = newStudyExp['staffReward_situation'];
	staffReward_situation.setAttribute("name","rewards.staffReward_situation");
	console.log(staffReward_situation.innerHTML);
	
	var staffReward_Time = document.createElement("td");
	staffReward_Time.innerHTML = newStudyExp['staffReward_Time'];
	staffReward_Time.setAttribute("name","rewards.staffReward_Time");
	
	var staffReward_remarks = document.createElement("td");
	staffReward_remarks.innerHTML = newStudyExp['staffReward_remarks'];
	staffReward_remarks.setAttribute("name","rewards.staffReward_remarks");
	
	prized_tr.appendChild(staffReward_situation);
	prized_tr.appendChild(staffReward_Time);
	prized_tr.appendChild(staffReward_remarks);
	prized_table.append(prized_tr);
}
function add_AgainstPrinciple() {
	console.log("add_AgainstPrinciple start");
	// 把表格的数据存到json中
	var staffPrinciple_situation = document.querySelector(".staffPrinciple_situation").value;
	var staffPrinciple_Time = document.querySelector(".staffPrinciple_Time").value;
	var staffPrinciple_remarks = document.querySelector(".staffPrinciple_remarks").value;
	
	newStudyExp['staffPrinciple_situation'] = staffPrinciple_situation;
	newStudyExp['staffPrinciple_Time'] = staffPrinciple_Time;
	newStudyExp['staffPrinciple_remarks'] = staffPrinciple_remarks;
	console.log(newStudyExp['staffPrinciple_remarks']);
	// 动态创建表格
	var againstPrinciple_table = document
			.getElementById("againstPrinciple_table");
	againstPrinciple_table.setAttribute("class", "long_table");

	var againstPrinciple_tr = document.createElement("tr");
	var staffPrinciple_situation = document.createElement("td");
	staffPrinciple_situation.innerHTML = newStudyExp['staffPrinciple_situation'];
	staffPrinciple_situation.setAttribute("name","principles.staffPrinciple_situation");
	console.log(staffPrinciple_situation.innerHTML);
	
	var staffPrinciple_Time = document.createElement("td");
	staffPrinciple_Time.innerHTML = newStudyExp['staffPrinciple_Time'];
	staffPrinciple_Time.setAttribute("name","principles.staffPrinciple_Time");
	
	var staffPrinciple_remarks = document.createElement("td");
	staffPrinciple_remarks.innerHTML = newStudyExp['staffPrinciple_remarks'];
	staffPrinciple_remarks.setAttribute("name","principles.staffPrinciple_remarks");

	
	againstPrinciple_tr.appendChild(staffPrinciple_situation);
	againstPrinciple_tr.appendChild(staffPrinciple_Time);
	againstPrinciple_tr.appendChild(staffPrinciple_remarks);
	againstPrinciple_table.append(againstPrinciple_tr);
}
function add_Punish() {
	console.log("add_Punish start");
	// 把表格的数据存到json中
	var staffPunishment_situation = document.querySelector(".staffPunishment_situation").value;
	var staffPunishment_Time = document.querySelector(".staffPunishment_Time").value;
	var staffPunishment_remarks = document.querySelector(".staffPunishment_remarks").value;
	
	newStudyExp['staffPunishment_situation'] = staffPunishment_situation;
	newStudyExp['staffPunishment_Time'] = staffPunishment_Time;
	newStudyExp['staffPunishment_remarks'] = staffPunishment_remarks;
	console.log(newStudyExp['staffPunishment_remarks']);
	// 动态创建表格
	var punish_table = document
			.getElementById("punish_table");
	punish_table.setAttribute("class", "long_table");

	var punishment_tr = document.createElement("tr");
	var staffPunishment_situation = document.createElement("td");
	staffPunishment_situation.innerHTML = newStudyExp['staffPunishment_situation'];
	staffPunishment_situation.setAttribute("name","punishments.staffPunishment_situation");
	console.log(staffPunishment_situation.innerHTML);
	
	var staffPunishment_Time = document.createElement("td");
	staffPunishment_Time.innerHTML = newStudyExp['staffPunishment_Time'];
	staffPunishment_Time.setAttribute("name","punishments.staffPunishment_Time");

	
	var staffPunishment_remarks = document.createElement("td");
	staffPunishment_remarks.innerHTML = newStudyExp['staffPunishment_remarks'];
	staffPunishment_remarks.setAttribute("name","punishments.staffPunishment_remarks");

	
	punishment_tr.appendChild(staffPunishment_situation);
	punishment_tr.appendChild(staffPunishment_Time);
	punishment_tr.appendChild(staffPunishment_Time);
	punish_table.append(punishment_tr);
}
function add_Vocation() {
	console.log("add_Vocation start");
	// 把表格的数据存到json中
	var staffFurlough_mainContent = document.querySelector(".staffFurlough_mainContent").value;
	var staffFurlough_startTime = document.querySelector(".staffFurlough_startTime").value;
	var staffFurlough_days = document.querySelector(".staffFurlough_days").value;
	var staffFurlough_whetherStop = document.querySelector(".staffFurlough_whetherStop").value;
	var staffFurlough_stopTime = document.querySelector(".staffFurlough_stopTime").value;
	var staffFurlough_remarks = document.querySelector(".staffFurlough_remarks").value;
	newStudyExp['staffFurlough_mainContent'] = staffFurlough_mainContent;
	newStudyExp['staffFurlough_startTime'] = staffFurlough_startTime;
	newStudyExp['staffFurlough_days'] = staffFurlough_days;
	newStudyExp['staffFurlough_whetherStop'] = staffFurlough_whetherStop;
	newStudyExp['staffFurlough_stopTime'] = staffFurlough_stopTime;
	newStudyExp['staffFurlough_remarks'] = staffFurlough_remarks;
	console.log(newStudyExp['staffFurlough_remarks']);
	// 动态创建表格
	var vocation_table = document
			.getElementById("vocation_table");
	vocation_table.setAttribute("class", "long_table");

	var vocation_tr = document.createElement("tr");
	var staffFurlough_mainContent = document.createElement("td");
	staffFurlough_mainContent.innerHTML = newStudyExp['staffFurlough_mainContent'];
	staffFurlough_mainContent.setAttribute("name","furloughs.staffFurlough_mainContent");
	console.log(staffFurlough_mainContent.innerHTML);
	
	var staffFurlough_startTime = document.createElement("td");
	staffFurlough_startTime.innerHTML = newStudyExp['staffFurlough_startTime'];
	staffFurlough_startTime.setAttribute("name","furloughs.staffFurlough_startTime");

	
	var staffFurlough_days = document.createElement("td");
	staffFurlough_days.innerHTML = newStudyExp['staffFurlough_days'];
	staffFurlough_days.setAttribute("name","furloughs.staffFurlough_days");

	
	var staffFurlough_whetherStop = document.createElement("td");
	staffFurlough_whetherStop.innerHTML = newStudyExp['staffFurlough_whetherStop'];
	staffFurlough_whetherStop.setAttribute("name","furloughs.staffFurlough_whetherStop");

	
	var staffFurlough_stopTime = document.createElement("td");
	staffFurlough_stopTime.innerHTML = newStudyExp['staffFurlough_stopTime'];
	staffFurlough_stopTime.setAttribute("name","furloughs.staffFurlough_stopTime");

	
	var staffFurlough_remarks = document.createElement("td");
	staffFurlough_remarks.innerHTML = newStudyExp['staffFurlough_remarks'];
	staffFurlough_remarks.setAttribute("name","furloughs.staffFurlough_remarks");

	
	vocation_tr.appendChild(staffFurlough_mainContent);
	vocation_tr.appendChild(staffFurlough_startTime);
	vocation_tr.appendChild(staffFurlough_days);
	vocation_tr.appendChild(staffFurlough_whetherStop);
	vocation_tr.appendChild(staffFurlough_stopTime);
	vocation_tr.appendChild(staffFurlough_remarks);
	vocation_table.append(vocation_tr);
}
if (window.File && window.FileList && window.FileReader && window.Blob) {
	document.querySelector(".photo-file").addEventListener('change',
			photo_preview, false);
} else {
	document.write('您的浏览器不支持File Api');
}
function stopPropagation(e) {
	if (e.stopPropagation)
		e.stopPropagation();
	else
		e.cancelBubble = true;
}
