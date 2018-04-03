//删除学习经历一条
function delete_study(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffStudent_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffStudent_deleteStudent?student.xsjsglxt_staffStudent_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除学习经历成功！');
				show_studyAjax(staff_id);
			},
		});
		
}

//删除学习经历一条
function delete_work(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffWork_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffWork_deleteWork?work.xsjsglxt_staffWork_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除工作经历成功！');
				show_workAjax(staff_id);
			},
		});
		
}
//删除工作经历一条
function delete_family(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffFamily_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffFamily_deleteFamilyByFamilyId?family.xsjsglxt_staffFamily_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除家庭成功！');
				show_familyAjax(staff_id);
			},
		});
		
}
//删除调动一条
function delete_move(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffMove_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffMove_deleteMove?move.xsjsglxt_staffMove_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除调动成功！');
				show_moveAjax(staff_id);
			},
		});
		
}
//删除受奖一条
function delete_reward(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffReward_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffReward_deleteReward?reward.xsjsglxt_staffReward_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除受奖成功！');
				show_rewardAjax(staff_id);
			},
		});
		
}
//删除违纪一条
function delete_against(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffPrinciple_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffPrinciple_deletePrinciple?principle.xsjsglxt_staffPrinciple_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除违纪成功！');
				show_againstAjax(staff_id);
			},
		});
		
}

//删除处分一条
function delete_punishment(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffPunishment_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffPunishment_deletePunishment?punishment.xsjsglxt_staffPunishment_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除处分成功！');
				show_punishmentAjax(staff_id);
			},
		});
		
}

//删除休假一条
function delete_furlough(delete_button) {
	//把td送页面上删
	  var this_trId=delete_button.parentNode.parentNode.querySelector(".xsjsglxt_staffFurlough_id").getAttribute("id");
	  console.log("本行的id"+this_trId);
		//把这行td的数据数据库中删除
		$.ajax({
			url : '/xsjsglxt/team/StaffFurlough_deleteFurloughByFurloughId?furlough.xsjsglxt_staffFurlough_id='+this_trId,
			type : 'POST',
			success:function(data){
				toastr.success('删除处分成功！');
				show_furloughAjax(staff_id)
			},
		});
		
}