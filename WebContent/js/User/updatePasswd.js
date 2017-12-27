var xmlHttp;
function updatePw() {
	$("#passwordContent").hide();
	$("#passwordLoadingDiv").show();
	var newPassword = $("#newPassword").val();
	var newPasswordAgain = $("#newPasswordAgain").val();
	if (newPassword != newPasswordAgain) {
		toastr.error("两次密码不一致");
		$("#passwordLoadingDiv").hide();
		$("#passwordContent").show();
	} else {
		getXmlHttp();
		var oldPassword = $("#oldPassword").val();
		xmlHttp.open("POST", "/xsjsglxt/user/User_updatePassword", true);
		var formData = new FormData();
		formData.append("oldPassword", oldPassword);
		formData.append("newPassword", newPassword);
		xmlHttp.send(formData);
		xmlHttp.onreadystatechange = function() {
			if (isBack()) {
				var result = xmlHttp.responseText;
				if (result == "oldPasswordError") {
					toastr.error("原始密码错误！");
					$("#passwordLoadingDiv").hide();
					$("#passwordContent").show();
				} else if (result == "updateFail") {
					toastr.error("修改失败请重新登陆！");
					$("#passwordLoadingDiv").hide();
					$("#passwordContent").show();
				} else {

					toastr.success("修改成功！");
					$("#oldPassword").val("");
					$("#newPassword").val("");
					$("#newPasswordAgain").val("");
					$("#passwordLoadingDiv").hide();
					$("#passwordContent").show();
				}

			}
		}
	}

}

function showPwContent() {
	$("#passwordLoadingDiv").hide();
	$("#passwordContent").show();

}

function getXmlHttp() {
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlHttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function isBack() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
		return true;
	} else {
		return false;
	}
}