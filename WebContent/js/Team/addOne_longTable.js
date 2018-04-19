//长表格学习经历添加一条
function add_oneStudy() {
	console.log("学习经历添加");
	console.log(staff_id);
	// 添加一条数据
	var staffStudent_evection_val = $(".staffStudent_evection").val();
	var staffStudent_address_val = $(".staffStudent_address").val();
	var staffStudent_startTime_val = $(".staffStudent_startTime").val();
	var staffStudent_stopTime_val = $(".staffStudent_stopTime").val();
	var staffStudent_remarks_val = $(".staffStudent_remarks").val();
	$
			.ajax({
				type : "POST",
				url : "/xsjsglxt/team/StaffStudent_saveStudents?students.staffStudent_staff="
						+ staff_id,
				data : {
					"students[0].staffStudent_evection" : staffStudent_evection_val,
					"students[0].staffStudent_address" : staffStudent_address_val,
					"students[0].staffStudent_startTime" : staffStudent_startTime_val,
					"students[0].staffStudent_stopTime" : staffStudent_stopTime_val,
					"students[0].staffStudent_remarks" : staffStudent_remarks_val,
				},
				success : function(data) {
					toastr.success('添加学习成功！');
					show_studyAjax(staff_id);
				}
			});
}

// 长表格工作经历添加一条
function add_oneWork() {
	console.log("工作经历添加");
	console.log(staff_id);
	// 添加一条数据
	var staffWork_address_val = $(".staffWork_address").val();
	var staffWork_duty_val = $(".staffWork_duty").val();
	var staffWork_startTime_val = $(".staffWork_startTime").val();
	var staffWork_stopTime_val = $(".staffWork_stopTime").val();
	var staffWork_remarks_val = $(".staffWork_remarks").val();
	
	$.ajax({
		type : "POST",
		url : "/xsjsglxt/team/StaffWork_saveWorks?works.staffWork_staff="
				+ staff_id,
		data : {
			"works[0].staffWork_address" : staffWork_address_val,
			"works[0].staffWork_duty" : staffWork_duty_val,
			"works[0].staffWork_startTime" : staffWork_startTime_val,
			"works[0].staffWork_stopTime" : staffWork_stopTime_val,
			"works[0].staffWork_remarks" : staffWork_remarks_val,
		},
		success : function(data) {
			toastr.success('添加工作成功！');
			show_workAjax(staff_id);
		}
	});
}

// 长表格家庭添加一条
function add_oneFamily() {
	console.log("家庭添加");
	console.log(staff_id);
	// 添加一条数据
	var staffFamily_contactsRelationship_val = $(
			".staffFamily_contactsRelationship").val();
	var staffFamily_name_val = $(".staffFamily_name").val();
	var staffFamily_birthday_val = $(".staffFamily_birthday").val();
	var staffFamily_IDcard_val = $(".staffFamily_IDcard").val();
	var staffFamily_tel_val = $(".staffFamily_tel").val();
	var staffFamily_WeiXin_val = $(".staffFamily_WeiXin").val();
	var staffFamily_workSpace_val = $(".staffFamily_workSpace").val();
	var staffFamily_duty_val = $(".staffFamily_duty").val();
	var staffFamily_remarks_val = $(".staffFamily_remarks").val();
	$
			.ajax({
				type : "POST",
				url : "/xsjsglxt/team/StaffFamily_saveFamilys?familys.staffFamily_staff="
						+ staff_id,
				data : {
					"familys[0].staffFamily_contactsRelationship" : staffFamily_contactsRelationship_val,
					"familys[0].staffFamily_name" : staffFamily_name_val,
					"familys[0].staffFamily_birthday" : staffFamily_birthday_val,
					"familys[0].staffFamily_IDcard" : staffFamily_IDcard_val,
					"familys[0].staffFamily_tel" : staffFamily_tel_val,
					"familys[0].staffFamily_WeiXin" : staffFamily_WeiXin_val,
					"familys[0].staffFamily_workSpace" : staffFamily_workSpace_val,
					"familys[0].staffFamily_duty" : staffFamily_duty_val,
					"familys[0].staffFamily_remarks" : staffFamily_remarks_val,
				},
				success : function(data) {
					toastr.success('添加家庭成功！');
					show_familyAjax(staff_id);
				}
			});
}
// 长表格调动添加一条
function add_oneMove() {
	console.log("调动添加");
	console.log(staff_id);
	// 添加一条数据
	var staffMove_inTime_val = $(".staffMove_inTime").val();
	var staffMove_outTime_val = $(".staffMove_outTime").val();
	var staffMove_guard_val = $(".staffMove_guard").val();
	var staffMove_remarks_val = $(".staffMove_remarks").val();
	$.ajax({
		type : "POST",
		url : "/xsjsglxt/team/StaffMove_saveMoves?moves.staffMove_staff="
				+ staff_id,
		data : {
			"moves[0].staffMove_inTime" : staffMove_inTime_val,
			"moves[0].staffMove_outTime" : staffMove_outTime_val,
			"moves[0].staffMove_guard" : staffMove_guard_val,
			"moves[0].staffMove_remarks" : staffMove_remarks_val,
		},
		success : function(data) {
			toastr.success('添加调动成功！');
			show_moveAjax(staff_id);
		}
	});
}

// 长表格受奖添加一条
function add_oneReward() {
	console.log("受奖添加");
	console.log(staff_id);
	// 添加一条数据
	var staffReward_situation_val = $(".staffReward_situation").val();
	var staffReward_Time_val = $(".staffReward_Time").val();
	var staffReward_remarks_val = $(".staffReward_remarks").val();
	$
			.ajax({
				type : "POST",
				url : "/xsjsglxt/team/StaffReward_saveRewards?rewards.staffReward_staff="
						+ staff_id,
				data : {
					"rewards[0].staffReward_situation" : staffReward_situation_val,
					"rewards[0].staffReward_Time" : staffReward_Time_val,
					"rewards[0].staffReward_remarks" : staffReward_remarks_val,
				},
				success : function(data) {
					toastr.success('添加受奖成功！');
					show_rewardAjax(staff_id);
				}
			});
}

// 长表格违规添加一条
function add_oneAgainst() {
	console.log("违规添加");
	console.log(staff_id);
	// 添加一条数据
	var staffPrinciple_situation_val = $(".staffPrinciple_situation").val();
	var staffPrinciple_Time_val = $(".staffPrinciple_Time").val();
	var staffPrinciple_remarks_val = $(".staffPrinciple_remarks").val();
	$
			.ajax({
				type : "POST",
				url : "/xsjsglxt/team/StaffPrinciple_savePrinciples?principles.staffPrinciple_staff="
						+ staff_id,
				data : {
					"principles[0].staffPrinciple_situation" : staffPrinciple_situation_val,
					"principles[0].staffPrinciple_Time" : staffPrinciple_Time_val,
					"principles[0].staffPrinciple_remarks" : staffPrinciple_remarks_val,
				},
				success : function(data) {
					toastr.success('添加违规成功！');
					show_againstAjax(staff_id);
				}
			});
}
// 长表格处分添加一条
function add_onePunishment() {
	console.log("处分添加");
	console.log(staff_id);
	// 添加一条数据
	var staffPunishment_situation_val = $(".staffPunishment_situation").val();
	var staffPunishment_Time_val = $(".staffPunishment_Time").val();
	var staffPunishment_remarks_val = $(".staffPunishment_remarks").val();
	$
			.ajax({
				type : "POST",
				url : "/xsjsglxt/team/StaffPunishment_savePunishments?punishments.staffPunishment_staff="
						+ staff_id,
				data : {
					"punishments[0].staffPunishment_situation" : staffPunishment_situation_val,
					"punishments[0].staffPunishment_Time" : staffPunishment_Time_val,
					"punishments[0].staffPunishment_remarks" : staffPunishment_remarks_val,
				},
				success : function(data) {
					toastr.success('添加处分成功！');
					show_punishmentAjax(staff_id);
				}
			});
}
// 长表格休假添加一条
function add_oneFurlough() {
	console.log("休假添加");
	console.log(staff_id);
	// 添加一条数据
	var staffFurlough_mainContent_val = $(".staffFurlough_mainContent").val();
	var staffFurlough_startTime_val = $(".staffFurlough_startTime").val();
	var staffFurlough_days_val = $(".staffFurlough_days").val();
	var staffFurlough_whetherStop_val = $(".staffFurlough_whetherStop").val();
	var staffFurlough_stopTime_val = $(".staffFurlough_stopTime").val();
	var staffFurlough_remarks_val = $(".staffFurlough_remarks").val();
	$
			.ajax({
				type : "POST",
				url : "/xsjsglxt/team/StaffFurlough_saveFurloughs?furloughs.staffFurlough_staff="
						+ staff_id,
				data : {
					"furloughs[0].staffFurlough_mainContent" : staffFurlough_mainContent_val,
					"furloughs[0].staffFurlough_startTime" : staffFurlough_startTime_val,
					"furloughs[0].staffFurlough_days" : staffFurlough_days_val,
					"furloughs[0].staffFurlough_whetherStop" : staffFurlough_whetherStop_val,
					"furloughs[0].staffFurlough_stopTime" : staffFurlough_stopTime_val,
					"furloughs[0].staffFurlough_remarks" : staffFurlough_remarks_val,
				},
				success : function(data) {
					toastr.success('添加休假成功！');
					show_furloughAjax(staff_id);
				}
			});
}