
var xmlHttp;
// userBlock  模块
// useClassName 使用权限类名
// managerClassName 管理权限类名
function deleteByPower(userBlock,useClassName,managerClassName)
{
	getXmlHttp();
	xmlHttp.open("POST", "/xsjsglxt/user/User_judgePower",true);	
	var formData = new FormData();
	formData.append("userBlock",userBlock);
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = function()
	{
		if(isBack())
			{
				var result = xmlHttp.responseText;
				switch (result) {
				case "jurisdiction_none":
					$("."+useClassName).remove();
					$("."+managerClassName).remove();
					break;

				case "jurisdiction_use":
					$("."+useClassName).remove();
					break;
					
				case "jurisdiction_admin":
					
					break;
				case "exception":
					toastr.error("出现异常请重新登陆");
					break;
				}
			}
	}
}















function getXmlHttp(){
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlHttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function isBack()
{
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
		return true;
	}
	else
		{
		return false;
		}
}