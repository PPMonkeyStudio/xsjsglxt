var xmlHttp;
document.onkeydown = function keyLogin(event) {
	if (event.keyCode == 13) {
		login();
	}
}
function login() {
	getXmlHttp();
	var user_username = document.getElementById("login_username").value;
	var user_password = document.getElementById("login_password").value;
	xmlHttp.open("POST", "/xsjsglxt/user/User_login", true);
	var formData = new FormData();
	formData.append("user_username", user_username);
	formData.append("user_password", user_password);
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = function() {
		if (isBack()) {
			var result = xmlHttp.responseText;
			switch (result) {
			case "UserNoExist":
				toastr.error("用户名不存在！");
				break;
			case "passwordError":
				toastr.error("密码错误！若忘记密码请联系管理员更改");
				break;
			case "loginSuccess":
				window.location = "/xsjsglxt/user/User_index";
			}
		}
	}
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