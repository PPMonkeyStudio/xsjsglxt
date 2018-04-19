window.onload = function() {
	var url = window.location.href;
	staff_id = url.substring(url.indexOf("=") + 1);
	console.log(staff_id);
	get_staffDetails(staff_id);
	
}
//更新年龄的ajax
function get_ageAjax(){
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var staffDetails = document.getElementById("staffDetails");
	var formData = new FormData(staffDetails);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var result = xmlhttp.responseText;
			if (result == 'updateSuccess') {
				console.log('更新年龄成功！');
			} else {
				console.log('更新年龄成功！');
			}
		}
	};
	xmlhttp.open("post",
			"/xsjsglxt/team/Staff_updatePoliceman?policeman.xsjsglxt_staff_id="
					+ staff_id, true);
	xmlhttp.send(formData);
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
				else if(key=="staff_politicalStatus"){
					if(value=="预备党员"||value=="入党积极分子"){
						document.querySelector(".staff_appliactionFormTime_label").style.display="";
						document.querySelector(".staff_appliactionFormTime").style.display="";
						document.querySelector(".staff_delevopObjectTime_label").style.display="";
						document.querySelector(".staff_delevopObjectTime").style.display="";
						$('input[name="policeman.' + key + '"]').val(value);
					}else if(value=="党员"){
						document.querySelector(".staff_joinPartyTime_label").style.display="";
						document.querySelector(".staff_joinPartyTime").style.display="";
						$('input[name="policeman.' + key + '"]').val(value);
					}
				}
				$('input[name="policeman.' + key + '"]').val(value);
			});
			$('#staff_duty').val(staff_info.staff_duty);
			$('#staff_type').val(staff_info.staff_type);
			$('#staff_degree').val(staff_info.staff_degree);
			$('#staff_politicalStatus').val(staff_info.staff_politicalStatus);
			$('#staff_MaxEducationalBackground').val(
					staff_info.staff_MaxEducationalBackground);
			$('#staff_politicalStatus').val(staff_info.staff_politicalStatus);
			document.getElementById("photo-show").innerHTML = "<img src='/xsjsglxt/team/Staff_downloadPhoto?staff_imageFileName="
					+ staff_info.staff_photo + "' />";
			
			//进入页面自动更新年龄,提交到后台
			relive_getAge();
			get_ageAjax();
			
			show_studyAjax(staff_id);
			show_workAjax(staff_id);
			show_familyAjax(staff_id);
			show_moveAjax(staff_id);
			show_rewardAjax(staff_id);
			show_againstAjax(staff_id);
			show_furloughAjax(staff_id);

		}
	}

	xmlhttp.open("post", url, true);
	xmlhttp.send();
}
// 显示学习经历
function show_studyAjax(staff_id) {
	console.log("study发生发生地方");
	var xmlhttp_study;
	if (window.XMLHttpRequest) {
		xmlhttp_study = new XMLHttpRequest();
	} else {
		xmlhttp_study = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp_study.onreadystatechange = function() {
		if (xmlhttp_study.readyState == 4 && xmlhttp_study.status == 200) {
			var staff_study = xmlhttp_study.responseText;
			if(staff_study=="studentIsNull"){
				$('#studyExperience_table tbody').html("");
			}else{
			console.log("staff_study" + staff_study);
			staff_study = JSON.parse(staff_study);
			console.log(staff_study.length);
			var table_elements=$("#studyExperience_table tbody");
			for(var i=1;i<table_elements.length;i++){
				table_elements.removeChild(table_elements.element[i]);
			}
			var str1 = '';
			for (var len = 0; len < staff_study.length; len++) {
				var xsjsglxt_staffStudent_id = staff_study[len].xsjsglxt_staffStudent_id;
				str1 += '<tr>';
				str1 += '<input type="hidden" class="xsjsglxt_staffStudent_id" id="'
						+ xsjsglxt_staffStudent_id + '">';
				str1 += '<td>' + staff_study[len].staffStudent_address
						+ '</td>';
				str1 += '<td>' + staff_study[len].staffStudent_startTime
						+ '</td>';
				str1 += '<td>' + staff_study[len].staffStudent_startTime
						+ '</td>';
				str1 += '<td>' + staff_study[len].staffStudent_remarks
						+ '</td>';
				str1 += '<td> <button class="btn btn-default btn-xs" data-toggle="modal" data-target="#reliveStudy_Modal" onclick="show_study(this)" type="button" ><i class="fa fa-pencil"></i></button><button class="btn btn-default btn-xs" onclick="delete_study(this)" type="button" ><i class="fa fa-trash"></i></button></td>';

				str1 += '</tr>';
			}
			$('#studyExperience_table tbody').html(str1);
			}
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
			if(staff_work=="worksIsNull"){
				$('#wordExperience_table tbody').html("");
			}else{
			console.log(staff_work);
			staff_work = JSON.parse(staff_work);
			console.log(staff_work);

			var str2 = '';
			for (var len = 0; len < staff_work.length; len++) {
				var xsjsglxt_staffWork_id = staff_work[len].xsjsglxt_staffWork_id;
				str2 += '<tr>';
				str2 += '<input type="hidden" class="xsjsglxt_staffWork_id" id="'
						+ xsjsglxt_staffWork_id + '">';
				str2 += '<td>' + staff_work[len].staffWork_address + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_duty + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_startTime + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_stopTime + '</td>';
				str2 += '<td>' + staff_work[len].staffWork_remarks + '</td>';
				str2 += '<td> <button class="btn btn-default btn-xs" data-toggle="modal" data-target="#reliveWork_Modal" onclick="show_work(this)" type="button" ><i class="fa fa-pencil"></i></button><button class="btn btn-default btn-xs" onclick="delete_work(this)" type="button" ><i class="fa fa-trash"></i></button></td>';
				str2 += '</tr>';

			}
			$('#wordExperience_table tbody').html(str2);
			}
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
			if(staff_family=="familyIsNull"){
				$('#family_table tbody').html("");
			}else{
			console.log(staff_family);
			staff_family = JSON.parse(staff_family);
			console.log(staff_family);

			var str3 = '';
			for (var len = 0; len < staff_family.length; len++) {
				var xsjsglxt_staffFamily_id = staff_family[len].xsjsglxt_staffFamily_id;

				str3 += '<tr>';
				str3 += '<input type="hidden" class="xsjsglxt_staffFamily_id" id="'
						+ xsjsglxt_staffFamily_id + '">';
				str3 += '<td >'
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
				str3 += '<td>'
						+ staff_family[len].staffFamily_remarks + '</td>';
				str3 += '<td> <button class="btn btn-default btn-xs" data-toggle="modal" data-target="#reliveFamily_Modal" onclick="show_family(this)" type="button" ><i class="fa fa-pencil"></i></button><button class="btn btn-default btn-xs" onclick="delete_family(this)" type="button" ><i class="fa fa-trash"></i></button></td>';
				str3 += '</tr>';
			}
			$('#family_table tbody').html(str3);
			}
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
			if(staff_move=="moveIsNull"){
				$('#policeChange_table tbody').html("");
			}else{
			console.log("staff_move" + staff_move);
			staff_move = JSON.parse(staff_move);
			console.log(staff_move.length);

			var str4 = '';
			for (var len = 0; len < staff_move.length; len++) {
				var xsjsglxt_staffMove_id = staff_move[len].xsjsglxt_staffMove_id;
				
				str4 += '<tr>';
				str4 += '<input type="hidden" class="xsjsglxt_staffMove_id" id="'
						+ xsjsglxt_staffMove_id + '">';
				str4 += '<td>' + staff_move[len].staffMove_inTime + '</td>';
				str4 += '<td>' + staff_move[len].staffMove_outTime + '</td>';
				str4 += '<td>' + staff_move[len].staffMove_guard + '</td>';
				str4 += '<td>' + staff_move[len].staffMove_remarks + '</td>';
				str4 += '<td> <button class="btn btn-default btn-xs" data-toggle="modal" data-target="#reliveMove_Modal" onclick="show_move(this)" type="button" ><i class="fa fa-pencil"></i></button><button class="btn btn-default btn-xs" onclick="delete_move(this)" type="button" ><i class="fa fa-trash"></i></button></td>';
				str4 += '</tr>';
			}
			$('#policeChange_table tbody').html(str4);
			}
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
			if(staff_reward=="rewardsIsNull"){
				$('#prized_table tbody').html("");
			}else{
			console.log(staff_reward);
			staff_reward = JSON.parse(staff_reward);
			console.log(staff_reward);

			var str5 = '';
			for (var len = 0; len < staff_reward.length; len++) {
				var xsjsglxt_staffReward_id = staff_reward[len].xsjsglxt_staffReward_id;
				
				str5 += '<tr>';
				str5 += '<input type="hidden" class="xsjsglxt_staffReward_id" id="'
						+ xsjsglxt_staffReward_id + '">';
				str5 += '<td>' + staff_reward[len].staffReward_situation
						+ '</td>';
				str5 += '<td>' + staff_reward[len].staffReward_Time + '</td>';
				str5 += '<td>' + staff_reward[len].staffReward_remarks
						+ '</td>';
				str5 += '<td> <button class="btn btn-default btn-xs" data-toggle="modal" data-target="#reliveReward_Modal" onclick="show_reward(this)" type="button" ><i class="fa fa-pencil"></i></button><button class="btn btn-default btn-xs" onclick="delete_reward(this)" type="button" ><i class="fa fa-trash"></i></button></td>';
				str5 += '</tr>';
			}
			$('#prized_table tbody').html(str5);
			}
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
			if(staff_against=="principleIsNull"){
				$('#againstPrinciple_table tbody').html("");
			}else{
			staff_against = JSON.parse(staff_against);
			console.log(staff_against);

			var str6 = '';
			for (var len = 0; len < staff_against.length; len++) {
				var xsjsglxt_staffPrinciple_id = staff_against[len].xsjsglxt_staffPrinciple_id;
				
				str6 += '<tr>';
				str6 += '<input type="hidden" class="xsjsglxt_staffPrinciple_id" id="'
						+ xsjsglxt_staffPrinciple_id + '">';

				str6 += '<td>' + staff_against[len].staffPrinciple_situation
						+ '</td>';
				str6 += '<td>' + staff_against[len].staffPrinciple_Time
						+ '</td>';
				str6 += '<td>' + staff_against[len].staffPrinciple_remarks
						+ '</td>';
				str6 += '<td> <button class="btn btn-default btn-xs" data-toggle="modal" data-target="#reliveAgainst_Modal" onclick="show_against(this)" type="button" ><i class="fa fa-pencil"></i></button><button class="btn btn-default btn-xs" onclick="delete_against(this)" type="button" ><i class="fa fa-trash"></i></button></td>';
				str6 += '</tr>';
			}
			$('#againstPrinciple_table tbody').html(str6);
			}
		}
	}
	xmlhttp_against
			.open(
					"POST",
					"/xsjsglxt/team/StaffPrinciple_getPrincipleByStaffId?principle.staffPrinciple_staff="
							+ staff_id, true);
	xmlhttp_against.send();
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
			if(staff_furlough=="furloughIsNull"){
				$('#vocation_table tbody').html("");
			}else{
			staff_furlough = JSON.parse(staff_furlough);

			var str8 = '';
			for (var len = 0; len < staff_furlough.length; len++) {
				var xsjsglxt_staffFurlough_id = staff_furlough[len].xsjsglxt_staffFurlough_id;
				
				str8 += '<tr>';
				str8 += '<input type="hidden" class="xsjsglxt_staffFurlough_id" id="'
						+ xsjsglxt_staffFurlough_id + '">';

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
				str8 += '<td> <button class="btn btn-default btn-xs" data-toggle="modal" data-target="#reliveFurlough_Modal" onclick="show_furlough(this)" type="button" ><i class="fa fa-pencil"></i></button><button class="btn btn-default btn-xs" onclick="delete_furlough(this)" type="button" ><i class="fa fa-trash"></i></button></td>';
				str8 += '</tr>';
			}
			$('#vocation_table tbody').html(str8);
			}
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
function staff_relive() {
	$
			.confirm({
				title : '修改!',
				content : '确定修改么!',
				buttons : {

					取消 : function() {
					},
					确定 : {
						action : function() {
							loadstaffDetail_staff_relive();
						}
					}
				}
			});
}
// 修改按钮执行事件
function loadstaffDetail_staff_relive() {
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
			var result = xmlhttp.responseText;
			if (result == 'updateSuccess') {
				toastr.success('编辑成功！');
			} else {
				toastr.error('编辑失败！');
			}
			//刷新页面
			//get_staffDetails();
		}
	};
	xmlhttp.open("post",
			"/xsjsglxt/team/Staff_updatePoliceman?policeman.xsjsglxt_staff_id="
					+ staff_id, true);
	xmlhttp.send(formData);
}
//从身份证自动获取年龄  和判断身份证 格式
function relive_getAge(){
	var ID=document.getElementsByName("policeman.staff_idNumber")[0].value;
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
	if(reg.test(ID)==false){
		toastr.error('身份证格式错误,请输入有效身份证！');
		var idNumber=document.getElementById("idNumber");
		idNumber.value="";
		idNumber.focus();
	}
	var myDate = new Date(); 
	var month = myDate.getMonth() + 1; 
	var day = myDate.getDate(); 
	var age = myDate.getFullYear()-ID.substring(6, 10) - 1; 
	if (ID.substring(10,12)<month||ID.substring(10,12)==month&&ID.substring(12,14)<=day) 
	{ 
	age++; 
	}	
    var xsjsglxt_age=document.getElementsByName("policeman.xsjsglxt_age")[0];
	xsjsglxt_age.value=age;
	console.log("年龄更新"+age);
	return age;
}