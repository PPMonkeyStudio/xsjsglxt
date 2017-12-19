var person_management_data = {

	"page_list_staffInformation.pageIndex" : "1",
	"page_list_staffInformation.staff_name" : "",
	"page_list_staffInformation.staff_sex" : "",
	"page_list_staffInformation.staff_politicalStatus" : "",
	"page_list_staffInformation.start_time" : "",
	"page_list_staffInformation.stop_time" : "",
};
// 当前页面分页信息
var page_infomantion = {
	pageIndex : 1,
	totalRecords : 1,
	pageSize : 20,
	totalPages : 1,
	HavePrePage : false,
	HaveNextPage : false,
}
// 最先执行函数
window.onload = function() {
	console.log("a");
	document.getElementById("Check-btn").checked = false;
	get_staffPageListAndSearch();

}

function get_staffPageListAndSearch() {
	console.log("b");
	var url = "/xsjsglxt/team/Staff_ListStaffInformationByPageAndSearch";
	get_staffPageListAndSearch_Ajax(url);
}

function get_staffPageListAndSearch_Ajax(url) {
	console.log("c");
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {

		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log("d");
			// 显示staff信息列表
			var staff_table_info = document
					.querySelector(".staff_table_info>tbody");
			staff_table_info.innerHTML = "";
			// 得到后台的json集合
			var staff_list_object = xmlhttp.responseText;
			staff_list_page = JSON.parse(staff_list_object);
			staff_list_object = JSON.parse(staff_list_object).listStaff;
			var str = "";
			// 遍历json集合
			for (var i = 0; i < staff_list_object.length; i++) {
				// 创建tr
				// var staff_list_tr=document.createElement("tr");
				// staff_list_tr.innerHTML="";
				// 得到每条数据
				var object = staff_list_object[i];
				// 得到各条数据的某个信息
				str += "<tr>"
				// 遍历是把staff_id的值传给checkbox的value(为后期的批量删除)
				str += '<td style="text-align:center;"><input name="check" type="checkbox" style="margin-top:10px;" value="'
						+ object.xsjsglxt_staff_id + '"/></td>';
				// a链接是调用action的page_staffDetail方法把object.xsjsglxt_staff_id传入staff_id_transfer,在action里把staff_id_transfer存入staff_id，之后跳转到staffDetails.jsp后，该页面得到staff_id(跳转到各自id的Detail页)
				str += '<td style="text-align:center;"><a href="/xsjsglxt/team/Staff_page_staffDetail?staff_id_transfer='
						+ object.xsjsglxt_staff_id
						+ '">'
						+ object.xsjsglxt_staff_id + '</a></td>';
				str += '<td style="text-align:center;">' + object.staff_name
						+ '</td>';
				str += '<td style="text-align:center;">' + object.staff_sex
						+ '</td>';
				str += '<td style="text-align:center;">'
						+ object.staff_idNumber + '</td>';
				str += '<td style="text-align:center;">'
						+ object.staff_politicalStatus + '</td>';
				str += '<td style="text-align:center;">' + object.staff_alarm
						+ '</td>';
				str += '<td style="text-align:center;">'
						+ object.staff_gmt_modified + '</td>';
				str += "</tr>";
				// 把td加入tr
				// staff_list_tr.innerHTML=str;
				// 把tr加入tbody
				staff_table_info.innerHTML = str;
			}
			// 分页信息存入page_infomantion中
			page_infomantion.pageIndex = staff_list_page.pageIndex; // 当前页数
			console.log(page_infomantion.pageIndex);
			page_infomantion.totalRecords = staff_list_page.totalRecords; // 总记录数
			console.log(page_infomantion.totalRecords);
			page_infomantion.pageSize = staff_list_page.pageSize; // 每页记录数
			console.log(page_infomantion.pageSize );
			page_infomantion.totalPages = staff_list_page.totalPages; // 总页数
			console.log(page_infomantion.totalPages );
			page_infomantion.HavePrePage = staff_list_page.HavePrePage; // 是否有上一页
			console.log(page_infomantion.HavePrePage);
			page_infomantion.HaveNextPage = staff_list_page.HaveNextPage; // 是否有下一页
			console.log(page_infomantion.HaveNextPage);
			// 获取分页器的页面信息
			var page_info = document.querySelector(".page-infomation");
			page_info.innerHTML = "共" + page_infomantion.totalRecords
					+ "条记录&nbsp;&nbsp;当前" + page_infomantion.pageIndex + "/"
					+ staff_list_page.totalPages + "页";

		}
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send(formatParams(person_management_data));

}
// 格式化输到后台的数据放法
function formatParams(data) {
    console.log("aa");	
	var arr = new FormData();
	for ( var name in data) {
		arr.append(encodeURIComponent(name), encodeURIComponent(data[name]));
	}
	return arr;
}
// 查询
function iquery() {
	var iquery_form = document.getElementById("iquery_form");
	// 把查询的条件存入person_management_data
	for (var i = 0; i < iquery_form.length; i++) {
		 console.log(iquery_form[i].name);
		 console.log(iquery_form[i].value);
		person_management_data[iquery_form[i].name] = iquery_form[i].value;
	}
	get_staffPageListAndSearch();

}
//清空查询
function clear_iquery(){
	var iquery_form = document.getElementById("iquery_form");
	//删除查询条件
	for(var i=1;i< iquery_form.length;i++)
	{  
		person_management_data[iquery_form[i].name]="";
	}
	//清空填的查询条件
	var iquery_input=iquery_form.getElementsByTagName("input");
	var iquery_select=iquery_form.getElementsByTagName("select");
	for(var j=0;j<iquery_input.length;j++){
		iquery_input[j].value="";
		
	}
	for(var k=0;k<iquery_select.length;k++){
		iquery_select[k].value="";
	}
	get_staffPageListAndSearch(person_management_data);
	toastr.error("清除查询");
	
}
// 首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	person_management_data['page_list_staffInformation.pageIndex'] = 1;
	get_staffPageListAndSearch(person_management_data);
}

// 上一页
function prePage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	person_management_data['page_list_staffInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_staffPageListAndSearch(person_management_data);
}
// 下一页
function nextPage() {
	if (page_infomantion.pageIndex == staff_list_page.totalPages) {
		toastr.error('已经是最后一页了！');
		return;
	}
	person_management_data['page_list_staffInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_staffPageListAndSearch(person_management_data);
}
// 尾页
function lastPage() {
	if (page_infomantion.pageIndex == staff_list_page.toalPages) {
		toastr.error('已经是最后一页了');
	}
	person_management_data['page_list_staffInformation.pageIndex'] = staff_list_page.totalPages;
	get_staffPageListAndSearch(person_management_data);
}

// 全选
function allCheck() {
	console.log("lala");
	var flag = document.getElementById("Check-btn").checked;
	var allCheck = document.getElementsByName("check");
	for (var i = 0; i <= allCheck.length; i++) {
		allCheck[i].checked = flag;
	}
}
// 批量删除人员
// staffDetail.jsp中的删除人员
function staff_del() {
	/*
	 * //得到每条tr var
	 * staff_table_tr=document.querySelector("staff_table_info>tbody>tr");
	 */
	var url="/xsjsglxt/team/Staff_remove_StaffInformationList";
	// 弹出框
	$.confirm({
	    title: '删除!',
	    content: '确定删除么!',
		buttons : {
			
			取消 : function() {
				// here the button key 'hey' will be used as the text.
			},
			确定: {
				action : function() {
					loadstaffDetail_staff_del(url);
				}
			}
		}
	});
	console.log("del1");
}
function loadstaffDetail_staff_del(url) {
	console.log("del2");
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var staff_table_info = document.querySelector(".staff_table_info>tbody");
	var staff_check = staff_table_info.getElementsByTagName("input");
	var staff_ids = "";
	var staff_idsArr = new Array();
	var formData = new FormData();
	for (var i = 0; i < staff_check.length; i++) {
		if (staff_check[i].checked) {
			console.log(staff_check[i].value);
			staff_ids += staff_check[i].value + ",";
		}
	}
	// 把字符串最后个“，”删掉
	staff_ids = staff_ids.substring(0, staff_ids.length - 1);
	// 把字符串转化成数组
	staff_idsArr = staff_ids.split(",");
	formData.append("useStaffInformationNumList", staff_idsArr);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var result = xmlhttp.responseText;
			if (result == 'success') {
				toastr.success('删除成功！');
			} else {
				toastr.error('删除失败！');
			}
		}
	}
	xmlhttp.open("post", url, true);
	xmlhttp.send(formData);
}