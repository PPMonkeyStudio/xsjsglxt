var staffVue;
window.onload = function() {
	staffVue = new Vue({
		el:'.panel',
		data:{
			returnData:'',
			studys:'',
			works:"",
			familys:"",
		    moves:"",
		    rewards:"",
		    punishments:"",
		    furloughs:""
			
		}
	})
	var url = window.location.href;
	staff_id = url.substring(url.indexOf("=") + 1);
	console.log(staff_id);
	get_staffDetails(staff_id);
}
//条状打印详细页面
function staff_print(){
	window.open("/xsjsglxt/team/Staff_intoPrintPage?id="
			+ staff_id);
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
			staffVue.returnData  = staff_info;
			console.log(staff_info);
			document.getElementById("photo-show").innerHTML = "<img src='/xsjsglxt/team/Staff_downloadPhoto?staff_imageFileName="
				+ staff_info.staff_photo + "'/>";
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
				$('#studyExperience_table tbody ').html("<tr><th>类别</th><th>地点</th><th>起始时间</th><th>结束时间</th></tr><tr><td></td><td></td><td></td><td></td></tr>");
			}else{
			console.log("staff_study" + staff_study);
			staff_study = JSON.parse(staff_study);
			staffVue.studys = staff_study;
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
				$('#wordExperience_table tbody').html("<tr><th>工作地点</th><th>职务</th><th>起始时间</th><th>起始时间</th></tr><tr><td></td><td></td><td></td><td></td></tr>");
			}else{
			console.log(staff_work);
			staff_work = JSON.parse(staff_work);
			staffVue.works=staff_work;
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
				$('#family_table tbody').html("<tr><th>关系</th><th>职务</th><th>姓名</th><th>身份证号</th><th>手机号</th><th>工作单位</th><th>职位</th></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
			}else{
			console.log(staff_family);
			staff_family = JSON.parse(staff_family);
			staffVue.familys=staff_family;

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
				$('#policeChange_table tbody').html("<tr><th>调入时间</th><th>调出时间</th><th>是否在岗</th></tr><tr><td></td><td></td><td></td></tr>");
			}else{
			console.log("staff_move" + staff_move);
			staff_move = JSON.parse(staff_move);
			staffVue.moves=staff_move;

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
				$('#prized_table tbody').html("<tr><th>表彰情况</th><th>表彰时间</th></tr><tr><td></td><td></td></tr>");
			}else{
			console.log(staff_reward);
			staff_reward = JSON.parse(staff_reward);
            staffVue.rewards=staff_reward;

			}
		}
	}
	xmlhttp_reward.open("POST",
			"/xsjsglxt/team/StaffReward_getRewardByStaffId?reward.staffReward_staff="
					+ staff_id, true);
	xmlhttp_reward.send();
}
//显示违纪情况
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
				$('#againstPrinciple_table tbody').html("<tr><th>违纪情况</th><th>违纪时间</th></tr><tr><td></td><td></td></tr>");
			}else{
			staff_against = JSON.parse(staff_against);
			staffVue.punishments=staff_against;

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
				$('#vocation_table tbody').html("<tr><th>起始时间</th><th>销假时间</th><th>是否销假</th><th>请休假事由</th><th>天数</th></tr><tr><td></td><td></td><td></td><td></td><td></td></tr>");
			}else{
			staff_furlough = JSON.parse(staff_furlough);
            staffVue.furloughs=staff_furlough;
		
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