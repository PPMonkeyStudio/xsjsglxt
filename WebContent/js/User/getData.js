var xmlHttp;

window.onload = function() {
	getXmlHttp();
	xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
	var formData = new FormData();
	formData.append("currPage", "1");
	formData.append("queryString", "");
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = loadUserBack;
}

function cleanInput()
{
	$("#addUserForm input").val("");
}

function addUser() {
	for(var i=0;i<document.addUserForm.elements.length-1;i++)
    {
     if(document.addUserForm.elements[i].value=="")
     {
       toastr.error("当前表单不能有空项");
       document.form1.elements[i].focus();
       return false;
     }
    }
	$("#addContent").addClass("hideDiv");
	$("#addLoadingDiv").removeClass("hideDiv");
	xmlHttp.open("POST", "/xsjsglxt/user/User_addUser", true);
	var formData = new FormData(document.getElementById("addUserForm"));
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = addUserBack;
}

function reLoadUser() {
	$("#addContent input").val("");
	$("#addContent input[name='user_username']").focus();
	document.getElementById("userTable").innerHTML = "<tr style='background-color: #696969; color: white;'><td>账号</td><td>姓名</td><td>代码</td><td>单位</td><td>操作</td></tr>";
	$("#loadingDiv").removeClass("hideDiv");
	$("#tableDiv").addClass("hideDiv");
	getXmlHttp();
	xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
	var formData = new FormData();
	formData.append("currPage", "1");
	formData.append("queryString", "");
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = loadUserBack;
}

function updateUser(event) {
	$("#updateLoadingDiv").removeClass("hideDiv");
	$("#updateContent").addClass("hideDiv");
	getXmlHttp();
	xmlHttp.open("POST", "/xsjsglxt/user/User_updateUser", true);
	var formData = new FormData(updateUserForm);
	formData.append("user_id", event.value);
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = updateUserBack;
}
function updateUserBack() {
	if (isBack()) {
		toastr.success("修改成功！");
		$("#user_password_update").val("");
		$("#updateLoadingDiv").addClass("hideDiv");
		$("#updateContent").removeClass("hideDiv");
	}
}

function getUserById(event) {
	$("#updateContent").addClass("hideDiv");
	$("#updateLoadingDiv").removeClass("hideDiv");
	getXmlHttp();
	xmlHttp.open("POST", "/xsjsglxt/user/User_getUserById", true);
	var formData = new FormData();
	formData.append("user_id", event.value);
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = getUserByIdBack;
}

function getUserByIdBack() {
	if (isBack()) {
		var result = xmlHttp.responseText;
		result = JSON.parse(result);
		$("#user_username_update").val(result.user_username);
		$("#user_name_update").val(result.user_name);
		$("#user_number_update").val(result.user_number);
		$("#user_units_update").val(result.user_units);
		$("#user_case_technology_power_update").val(
				result.user_case_technology_power);
		$("#user_case_query_power_update").val(result.user_case_query_power);
		$("#user_check_power_update").val(result.user_check_power);
		$("#user_army_manager_power_update")
				.val(result.user_army_manager_power);
		$("#user_technology_manager_power_update").val(
				result.user_technology_manager_power);
		$("#user_statistics_power_update").val(result.user_statistics_power);
		$("#user_user_manager_power_update")
				.val(result.user_user_manager_power);
		$("#updateBtn").val(result.user_id);
		$("#updateLoadingDiv").addClass("hideDiv");
		$("#updateContent").removeClass("hideDiv");
	}
}

function addUserBack() {
	if (isBack()) {
		var result = xmlHttp.responseText;
		if (result == "用户名已经存在") {
			toastr.error("用户名已经存在请重新填写用户名！");
			$("#addLoadingDiv").addClass("hideDiv");
			$("#addContent").removeClass("hideDiv");
		} else {
			toastr.success("上传成功！");
			$("#addLoadingDiv").addClass("hideDiv");
			$("#addContent").removeClass("hideDiv");
			$("#addContent input").val("");
			$("#addContent input[name='user_username']").focus();
		}

	}
}

function loadUserBack() {
	if (isBack()) {
		var result = xmlHttp.responseText;
		result = JSON.parse(result);
		var userTable = document.getElementById("userTable");
		var hideQueryString = document.getElementById("hideQueryString");
		var hideCurrPage = document.getElementById("hideCurrPage");
		var queryString = document.getElementById("queryString");
		var currPage = document.getElementById("currPage");
		var totalPage = document.getElementById("totalPage");
		var skipPage = document.getElementById("skipPage");
		for (var i = 0; i < result.list.length; i++) {
			userTable.innerHTML = userTable.innerHTML
					+ "<tr class='trHover'><td>"
					+ result.list[i].user_username
					+ "</td>"
					+ "<td>"
					+ result.list[i].user_name
					+ "</td>"
					+ "<td>"
					+ result.list[i].user_number
					+ "</td>"
					+ "<td>"
					+ result.list[i].user_units
					+ "</td>"
					+ "<td>"
					+ "<button onclick='deleteUser(this)' value='"
					+ result.list[i].user_id
					+ "' class='btn btn-danger managerPower'>删除</button>"
					+ "<button onclick='getUserById(this)' value='"
					+ result.list[i].user_id
					+ "' data-toggle='modal' data-target='#updateUser' style='margin-left: 5px;' class='btn btn-primary managerPower'>修改</button>"
					+ "</td></tr>";
		}
		hideQueryString.value = result.queryString;
		hideCurrPage.value = result.currPage;
		queryString.value = result.queryString;
		currPage.innerHTML = result.currPage;
		totalPage.innerHTML = result.totalPage;
		skipPage.value = result.currPage;
		$("#loadingDiv").addClass("hideDiv");
		$("#tableDiv").removeClass("hideDiv");
		deleteByPower('user_user_manager_power','userRole','managerRole');
	}
}

function queryUser() {
	$("#loadingDiv").removeClass("hideDiv");
	$("#tableDiv").addClass("hideDiv");
	document.getElementById("userTable").innerHTML = "<tr style='background-color: #696969; color: white;'><td>账号</td><td>姓名</td><td>代码</td><td>单位</td><td>操作</td></tr>";
	var queryString = document.getElementById("queryString").value;
	getXmlHttp();
	xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
	var formData = new FormData();
	formData.append("currPage", "1");
	formData.append("queryString", queryString);
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = loadUserBack;
}

function skipToIndexPage() {
	var currPage = document.getElementById("hideCurrPage").value;
	var totalPage = document.getElementById("totalPage").innerHTML;
	var queryString = document.getElementById("hideQueryString").value;
	if (currPage == "1") {
		toastr.error("已经是第一页");
	} else {
		$("#loadingDiv").removeClass("hideDiv");
		$("#tableDiv").addClass("hideDiv");
		document.getElementById("userTable").innerHTML = "<tr style='background-color: #696969; color: white;'><td>账号</td><td>姓名</td><td>代码</td><td>单位</td><td>操作</td></tr>";
		var queryString = document.getElementById("queryString").value;
		getXmlHttp();
		xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
		var formData = new FormData();
		formData.append("currPage", "1");
		formData.append("queryString", queryString);
		xmlHttp.send(formData);
		xmlHttp.onreadystatechange = loadUserBack;
	}
}

function deleteUser(event) {
	getXmlHttp();
	xmlHttp.open("POST", "/xsjsglxt/user/User_deleteUser", true);
	var formData = new FormData();
	formData.append("user_id", event.value);
	xmlHttp.send(formData);
	xmlHttp.onreadystatechange = deleteUserBack;
}

function deleteUserBack() {
	if (isBack()) {
		toastr.success("删除成功");
		reLoadUser();
	}
}

function skipToNextPage() {
	var currPage = document.getElementById("hideCurrPage").value;
	var totalPage = document.getElementById("totalPage").innerHTML;
	var queryString = document.getElementById("hideQueryString").value;
	if (currPage == totalPage) {
		toastr.error("已经是最后一页");
	} else {

		$("#loadingDiv").removeClass("hideDiv");
		$("#tableDiv").addClass("hideDiv");
		document.getElementById("userTable").innerHTML = "<tr style='background-color: #696969; color: white;'><td>账号</td><td>姓名</td><td>代码</td><td>单位</td><td>操作</td></tr>";
		var queryString = document.getElementById("queryString").value;
		getXmlHttp();
		xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
		var formData = new FormData();
		formData.append("currPage", ++currPage);
		formData.append("queryString", queryString);
		xmlHttp.send(formData);
		xmlHttp.onreadystatechange = loadUserBack;
	}
}

function skipToPrimaryPage() {
	var currPage = document.getElementById("hideCurrPage").value;
	var totalPage = document.getElementById("totalPage").innerHTML;
	var queryString = document.getElementById("hideQueryString").value;
	if (currPage == "1") {
		toastr.error("已经是第一页");
	} else {
		$("#loadingDiv").removeClass("hideDiv");
		$("#tableDiv").addClass("hideDiv");
		document.getElementById("userTable").innerHTML = "<tr style='background-color: #696969; color: white;'><td>账号</td><td>姓名</td><td>代码</td><td>单位</td><td>操作</td></tr>";
		var queryString = document.getElementById("queryString").value;
		getXmlHttp();
		xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
		var formData = new FormData();
		formData.append("currPage", --currPage);
		formData.append("queryString", queryString);
		xmlHttp.send(formData);
		xmlHttp.onreadystatechange = loadUserBack;
	}
}
function skipToLastPage() {
	var currPage = document.getElementById("hideCurrPage").value;
	var totalPage = document.getElementById("totalPage").innerHTML;
	var queryString = document.getElementById("hideQueryString").value;
	if (currPage == totalPage) {
		toastr.error("已经是最后一页");
	} else {
		$("#loadingDiv").removeClass("hideDiv");
		$("#tableDiv").addClass("hideDiv");
		document.getElementById("userTable").innerHTML = "<tr style='background-color: #696969; color: white;'><td>账号</td><td>姓名</td><td>代码</td><td>单位</td><td>操作</td></tr>";
		var queryString = document.getElementById("queryString").value;
		getXmlHttp();
		xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
		var formData = new FormData();
		formData.append("currPage", totalPage);
		formData.append("queryString", queryString);
		xmlHttp.send(formData);
		xmlHttp.onreadystatechange = loadUserBack;
	}
}
function skipToArbitrarilyPage() {
	var currPage = document.getElementById("skipPage").value;
	var totalPage = document.getElementById("totalPage").innerHTML;
	var queryString = document.getElementById("hideQueryString").value;
	if (currPage <= 0 || currPage > totalPage) {
		toastr.error("不存在此页");
	} else {
		$("#loadingDiv").removeClass("hideDiv");
		$("#tableDiv").addClass("hideDiv");
		document.getElementById("userTable").innerHTML = "<tr style='background-color: #696969; color: white;'><td>账号</td><td>姓名</td><td>代码</td><td>单位</td><td>操作</td></tr>";
		var queryString = document.getElementById("queryString").value;
		getXmlHttp();
		xmlHttp.open("POST", "/xsjsglxt/user/User_getUser", true);
		var formData = new FormData();
		formData.append("currPage", currPage);
		formData.append("queryString", queryString);
		xmlHttp.send(formData);
		xmlHttp.onreadystatechange = loadUserBack;
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
