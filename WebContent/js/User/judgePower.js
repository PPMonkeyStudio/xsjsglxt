var xmlHttpss;

document
		.write('<div id="hideLayer" style="margin: 0 auto; background-color: white; position: fixed; width: 100%; height: 2000px; z-index: 9999999999999999999999999999999999999999;"><div style="width: 80px;height:79px; margin: 0 auto; margin-top: 200px;"><img alt=""src="/xsjsglxt/img/hui.png"><span style="color:black;">权限加载中</span></div></div>');

// userBlock 模块
// useClassName 使用权限类名
// managerClassName 管理权限类名

function deleteByPower(userBlock, useClassName, managerClassName) {

	getXmlHttps();
	xmlHttps.open("POST", "/xsjsglxt/user/User_judgePower", true);
	var formData = new FormData();
	formData.append("userBlock", userBlock);
	xmlHttps.send(formData);
	xmlHttps.onreadystatechange = function() {
		if (isBacks()) {
			var resul = xmlHttps.responseText;
			switch (resul) {
			case "jurisdiction_none":
				$("." + useClassName).remove();
				$("." + managerClassName).remove();
				break;

			case "jurisdiction_use":
				$("." + managerClassName).remove();
				break;

			case "jurisdiction_admin":

				break;
			case "exception":
				$.confirm({
					title : "请重新登录",
					content : "登录验证不通过，可能是未操作时间太久或者为登录造成",
					buttons : {
						reLogin : {
							text : "重新登录",
							btnClass : "btn-blue",
							action : function() {
								window.location = "/xsjsglxt/login.jsp";
							}
						}
					}
				});
				break;
			}
			// $("#hideLayer").hide();
		}
	}
}

function getXmlHttps() {
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlHttps = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlHttps = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function isBacks() {
	if (xmlHttps.readyState == 4 && xmlHttps.status == 200) {
		return true;
	} else {
		return false;
	}
}