//显示当前学习经历在模态框中
function show_study(relive_button) {
	var this_tr=relive_button.parentNode.parentNode;
	 this_trId=this_tr.querySelector(".xsjsglxt_staffStudent_id").getAttribute("id");
	 document.querySelector(".staffStudent_addressRelive").value=this_tr.children[1].innerHTML;
	 document.querySelector(".staffStudent_startTimeRelive").value=this_tr.children[2].innerHTML;
	 document.querySelector(".staffStudent_stopTimeRelive").value=this_tr.children[3].innerHTML;
	 document.querySelector(".staffStudent_remarksRelive").value=this_tr.children[4].innerHTML;
}
//修改学习经历
function relive_study(){
	console.log("学习经历修改");
	// 修改一条数据
	var staffStudent_address_val=$(".staffStudent_addressRelive").val();
	var staffStudent_startTime_val=$(".staffStudent_startTimeRelive").val();
	var staffStudent_stopTime_val=$(".staffStudent_stopTimeRelive").val();
	var staffStudent_remarks_val=$(".staffStudent_remarksRelive").val();
	$.ajax({
				type : "POST",
				url : '/xsjsglxt/team/StaffStudent_updateStudent?student.xsjsglxt_staffStudent_id='+this_trId,
				data :{
					"student.staffStudent_address":staffStudent_address_val,
					"student.staffStudent_startTime":staffStudent_startTime_val,
					"student.staffStudent_stopTime":staffStudent_stopTime_val,
					"student.staffStudent_remarks":staffStudent_remarks_val,
				},
				dataType : "json",
				success : function(data) {
					toastr.success('修改学习成功！');
				}
			});
}


//显示当前工作经历在模态框中
function show_work(relive_button) {
	var this_tr=relive_button.parentNode.parentNode;
	 this_trId=this_tr.querySelector(".xsjsglxt_staffWork_id").getAttribute("id");
	 document.querySelector(".staffWork_addressRelive").value=this_tr.children[1].innerHTML;
	 document.querySelector(".staffWork_dutyRelive").value=this_tr.children[2].innerHTML;
	 document.querySelector(".staffWork_startTimeRelive").value=this_tr.children[3].innerHTML;
	 document.querySelector(".staffWork_stopTimeRelive").value=this_tr.children[4].innerHTML;
	 document.querySelector(".staffWork_remarkRelives").value=this_tr.children[5].innerHTML;
}
//修改工作经历
function relive_work(){
	console.log("工作经历修改");
	// 修改一条数据
	var staffWork_address_val=$(".staffWork_addressRelive").val();
	var staffWork_duty_val=$(".staffWork_dutyRelive").val();
	var staffWork_startTime_val=$(".staffWork_startTimeRelive").val();
	var staffWork_stopTime_val=$(".staffWork_stopTimeRelive").val();
	var staffWork_remarks_val=$(".staffWork_remarksRelive").val();
	$.ajax({
				type : "POST",
				url : '/xsjsglxt/team/StaffWork_updateRewardWork?work.xsjsglxt_staffWork_id='+this_trId,
				data :{
					"work.staffWork_address":staffWork_address_val,
					"work.staffWork_duty":staffWork_duty_val,
					"work.staffWork_startTime":staffWork_startTime_val,
					"work.staffWork_stopTime":staffWork_stopTime_val,
					"work.staffWork_remarks":staffWork_remarks_val,
				},
				dataType : "json",
				success : function(data) {
					console.log("修改完成");
				}
			});
}

//显示当前家庭在模态框中
function show_family(relive_button) {
	var this_tr=relive_button.parentNode.parentNode;
	 this_trId=this_tr.querySelector(".xsjsglxt_staffFamily_id").getAttribute("id");
	 console.log(this_tr.children[1].innerHTML);
	 document.querySelector(".staffFamily_contactsRelationshipRelive").value=this_tr.children[1].innerHTML;
	 document.querySelector(".staffFamily_nameRelive").value=this_tr.children[2].innerHTML;
	 document.querySelector(".staffFamily_birthdayRelive").value=this_tr.children[3].innerHTML;
	 document.querySelector(".staffFamily_IDcardRelive").value=this_tr.children[4].innerHTML;
	 document.querySelector(".staffFamily_telRelive").value=this_tr.children[5].innerHTML;
	 document.querySelector(".staffFamily_WeiXinRelive").value=this_tr.children[6].innerHTML;
	 document.querySelector(".staffFamily_workSpaceRelive").value=this_tr.children[7].innerHTML;
	 document.querySelector(".staffFamily_dutyRelive").value=this_tr.children[8].innerHTML;
	 document.querySelector(".staffFamily_remarksRelive").value=this_tr.children[9].innerHTML;
}
//修改家庭
function relive_family(){
	console.log("家庭修改");
	// 修改一条数据
	var staffFamily_contactsRelationship_val=$(".staffFamily_contactsRelationshipRelive").val();
	var staffFamily_name_val=$(".staffFamily_nameRelive").val();
	var staffFamily_birthday_val=$(".staffFamily_birthdayRelive").val();
	var staffFamily_IDcard_val=$(".staffFamily_IDcardRelive").val();
	var staffFamily_tel_val=$(".staffFamily_telRelive").val();
	var staffFamily_WeiXin_val=$(".staffFamily_WeiXinRelive").val();
	var staffFamily_workSpace_val=$(".staffFamily_workSpaceRelive").val();
	var staffFamily_duty_val=$(".staffFamily_dutyRelive").val();
	var staffFamily_remarks_val=$(".staffFamily_remarksRelive").val();
	$.ajax({
				type : "POST",
				url : '/xsjsglxt/team/StaffFamily_updateFamily?family.xsjsglxt_staffFamily_id='+this_trId,
				data :{
					"family.staffFamily_contactsRelationship":staffFamily_contactsRelationship_val,
					"family.staffFamily_name":staffFamily_name_val,
					"family.staffFamily_birthday":staffFamily_birthday_val,
					"family.staffFamily_IDcard":staffFamily_IDcard_val,
					"family.staffFamily_tel":staffFamily_tel_val,
					"family.staffFamily_WeiXin":staffFamily_WeiXin_val,
					"family.staffFamily_workSpace":staffFamily_workSpace_val,
					"family.staffFamily_duty":staffFamily_duty_val,
					"family.staffFamily_remarks":staffFamily_remarks_val,
				},
				dataType : "json",
				success : function(data) {
					console.log("修改完成");
				}
			});
}

//显示当前调动在模态框中
function show_move(relive_button) {
	var this_tr=relive_button.parentNode.parentNode;
	 this_trId=this_tr.querySelector(".xsjsglxt_staffMove_id").getAttribute("id");
	 console.log(this_tr.children[1].innerHTML);
	 document.querySelector(".staffMove_inTimeRelive").value=this_tr.children[1].innerHTML;
	 document.querySelector(".staffMove_outTimeRelive").value=this_tr.children[2].innerHTML;
	 document.querySelector(".staffMove_guardRelive").value=this_tr.children[3].innerHTML;
	 document.querySelector(".staffMove_remarksRelive").value=this_tr.children[4].innerHTML;
}
//修改调动
function relive_move(){
	console.log("调动修改");
	// 修改一条数据
	var staffMove_inTime_val=$(".staffMove_inTimeRelive").val();
	var staffMove_outTime_val=$(".staffMove_outTimeRelive").val();
	var staffMove_guard_val=$(".staffMove_guardRelive").val();
	var staffMove_remarks_val=$(".staffMove_remarksRelive").val();
	$.ajax({
				type : "POST",
				url : '/xsjsglxt/team/StaffMove_updateMove?move.xsjsglxt_staffMove_id='+this_trId,
				data :{
					"move.staffMove_inTime":staffMove_inTime_val,
					"move.staffMove_outTime":staffMove_outTime_val,
					"move.staffMove_guard":staffMove_guard_val,
					"move.staffMove_remarks":staffMove_remarks_val,
				},
				dataType : "json",
				success : function(data) {
					console.log("修改完成");
				}
			});
}

//显示当前受奖在模态框中
function show_reward(relive_button) {
	var this_tr=relive_button.parentNode.parentNode;
	 this_trId=this_tr.querySelector(".xsjsglxt_staffReward_id").getAttribute("id");
	 console.log(this_tr.children[1].innerHTML);
	 document.querySelector(".staffReward_situationRelive").value=this_tr.children[1].innerHTML;
	 document.querySelector(".staffReward_TimeRelive").value=this_tr.children[2].innerHTML;
	 document.querySelector(".staffReward_remarksRelive").value=this_tr.children[3].innerHTML;
}
//修改受奖
function relive_reward(){
	console.log("受奖修改");
	// 修改一条数据
	var staffReward_situation_val=$(".staffReward_situationRelive").val();
	var staffReward_Time_val=$(".staffReward_TimeRelive").val();
	var staffReward_remarks_val=$(".staffReward_remarksRelive").val();
	$.ajax({
				type : "POST",
				url : '/xsjsglxt/team/StaffReward_updateReward?reward.xsjsglxt_staffReward_id='+this_trId,
				data :{
					"reward.staffReward_situation":staffReward_situation_val,
					"reward.staffReward_Time":staffReward_Time_val,
					"reward.staffReward_remarks":staffReward_remarks_val,
				},
				dataType : "json",
				success : function(data) {
					console.log("修改完成");
				}
			});
}
//显示当前违规在模态框中
function show_against(relive_button) {
	 var this_tr=relive_button.parentNode.parentNode;
	 this_trId=this_tr.querySelector(".xsjsglxt_staffPrinciple_id").getAttribute("id");
	 console.log(this_tr.children[1].innerHTML);
	 document.querySelector(".staffPrinciple_situationRelive").value=this_tr.children[1].innerHTML;
	 document.querySelector(".staffPrinciple_TimeRelive").value=this_tr.children[2].innerHTML;
	 document.querySelector(".staffPrinciple_remarksRelive").value=this_tr.children[3].innerHTML;
}
//修改违规
function relive_against(){
	console.log("违规修改");
	// 修改一条数据
	var staffPrinciple_situation_val=$(".staffPrinciple_situationRelive").val();
	var staffPrinciple_Time_val=$(".staffPrinciple_TimeRelive").val();
	var staffPrinciple_remarks_val=$(".staffPrinciple_remarksRelive").val();
	$.ajax({
				type : "POST",
				url : '/xsjsglxt/team/StaffPrinciple_updatePrinciple?principle.xsjsglxt_staffPrinciple_id='+this_trId,
				data :{
					"principle.staffPrinciple_situation":staffPrinciple_situation_val,
					"principle.staffPrinciple_Time":staffPrinciple_Time_val,
					"principle.staffPrinciple_remarks":staffPrinciple_remarks_val,
				},
				dataType : "json",
				success : function(data) {
					console.log("违规完成");
				}
			});
}
//显示当前处分在模态框中
function show_furlough(relive_button) {
	 var this_tr=relive_button.parentNode.parentNode;
	 this_trId=this_tr.querySelector(".xsjsglxt_staffFurlough_id").getAttribute("id");
	 document.querySelector(".staffFurlough_mainContentRelive").value=this_tr.children[1].innerHTML;
	 document.querySelector(".staffFurlough_startTimeRelive").value=this_tr.children[2].innerHTML;
	 document.querySelector(".staffFurlough_daysRelive").value=this_tr.children[3].innerHTML;
	 document.querySelector(".staffFurlough_whetherStopRelive").value=this_tr.children[4].innerHTML;
	 document.querySelector(".staffFurlough_stopTimeRelive").value=this_tr.children[5].innerHTML;
	 document.querySelector(".staffFurlough_remarksRelive").value=this_tr.children[6].innerHTML;
}

//修改休假
function relive_furlough(){
	console.log("修改休假");
	// 修改一条数据
	var staffFurlough_mainContent_val=$(".staffFurlough_mainContentRelive").val();
	var staffFurlough_startTime_val=$(".staffFurlough_startTimeRelive").val();
	var staffFurlough_days_val=$(".staffFurlough_daysRelive").val();
	var staffFurlough_whetherStop_val=$(".staffFurlough_whetherStopRelive").val();
	var staffFurlough_stopTime_val=$(".staffFurlough_stopTimeRelive").val();
	var staffFurlough_remarks_val=$(".staffFurlough_remarksRelive").val();
	$.ajax({
				type : "POST",
				url : '/xsjsglxt/team/StaffFurlough_updateFurlough?furlough.xsjsglxt_staffFurlough_id='+this_trId,
				data :{
					"furlough.staffFurlough_mainContent":staffFurlough_mainContent_val,
					"furlough.staffFurlough_startTime":staffFurlough_startTime_val,
					"furlough.staffFurlough_days":staffFurlough_days_val,
					"furlough.staffFurlough_whetherStop":staffFurlough_whetherStop_val,
					"furlough.staffFurlough_stopTime":staffFurlough_stopTime_val,
					"furlough.staffFurlough_remarks":staffFurlough_remarks_val,
				},
				dataType : "json",
				success : function(data) {
					console.log("处分处分");
				}
			});
}