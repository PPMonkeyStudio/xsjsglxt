var person_management_data={
		"page_list_staffInformation.pageIndex":"1",
		"staff.staff_name":"",
		"staff.staff_sex":"",
		"staff.staff_age":"",
		"staff.staff_nation":"",
		"staff.staff_nativePlace":"",
		"staff.staff_birthday":"",
		"staff.staff_idNumber":"",
		"staff.staff_address":"",
		"staff.staff_MaxEducationalBackground":"",
		"staff.staff_politicalStatus":"",
		"staff.staff_joinPartyTime":"",
		"staff.staff_joinWorkTime":"",
		"staff.staff_alarm":"",
		"staff.staff_thePoliceTime":"",
		"staff.staff_isItFormal":"",
		"staff.staff_phone":"",
		"staff.staff_throughThePolice":"",
		"staff.staff_homephone":"",
		"staff.staff_QQ":"",
		"staff.staff_weixin":"",
		"staff.staff_outEmail":"",
		"staff.staff_inEmail":"",
		"staff.staff_photo":"",
		"staff.staff_contactsName":"",
		"staff.staff_contactsPhone":"",
		"staff.staff_contactsRelationship":"",
		"staff.staff_contactsWeiXin":"",
		"staff.staff_contactsWorkSpace":"",
		"staff.staff_contactsPosition":"",
		"staff.staff_contactsRemark":"",
		"staff.staff_gmt_create":"",
		"staff.staff_gmt_modified":"",
};
//当前页面分页信息
var page_infomantion = {
	pageIndex : 1,
	totalRecords : 1,
	pageSize : 20,
	totalPages : 1,
	HavePrePage : false,
	HaveNextPage : false,
}
window.onload=function(){
	console.log("a");
	get_staffPageListAndSearch();

}
function formatParams(data) {
    var arr = new FormData();
    for (var name in data) {
    	arr.append(encodeURIComponent(name),encodeURIComponent(data[name]));
    }
    return arr;
}
function get_staffPageListAndSearch(){
	console.log("b");
	var url="/xsjsglxt/team/Staff_ListStaffInformationByPageAndSearch";
	get_staffPageListAndSearch_Ajax(url);
}

function get_staffPageListAndSearch_Ajax(url){
	console.log("c");
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		console.log("d");
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{   
			//显示staff信息列表
			var staff_table_info=document.querySelector(".staff_table_info>tbody");
			staff_table_info.innerHTML="";
			//得到后台的json集合
			var staff_list_object=xmlhttp.responseText;
			staff_list_page=JSON.parse(staff_list_object);
			staff_list_object=JSON.parse(staff_list_object).listStaff;
		 	var str="";
		 	//遍历json集合
		 	for(var i=0;i<staff_list_object.length;i++){
		 		//创建tr
		 		//var staff_list_tr=document.createElement("tr");
		 		//staff_list_tr.innerHTML="";
		 		//得到每条数据
		 		var object=staff_list_object[i];
		 		console.log(staff_list_object);
		 	    //得到各条数据的某个信息
		 		str+="<tr>"
		 		str+='<td style="text-align:center;"><input type="checkbox" style="margin-top: 10px;"/></td>';
		 		str+='<td style="text-align:center;">'+object.staff_name+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_sex+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_idNumber+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_politicalStatus+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_joinPartyTime+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_alarm+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_isItFormal+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_gmt_create+'</td>';
		 		str+='<td style="text-align:center;">'+object.staff_gmt_modified+'</td>';
		 		str+="</tr>";
		 		//把td加入tr
		 		//staff_list_tr.innerHTML=str;
		 		//把tr加入tbody
		 		staff_table_info.innerHTML=str;
		 	}
		 	//分页信息存入page_infomantion中
			page_infomantion.pageIndex = staff_list_page.pageIndex; //当前页数
			page_infomantion.totalRecords =staff_list_page.totalRecords; //总页数
			page_infomantion.pageSize = staff_list_page.pageSize; //每页记录数
			page_infomantion.totalPages = staff_list_page.totalPages; //总记录数
			page_infomantion.HavePrePage = staff_list_page.HavePrePage; //是否有上一页
			page_infomantion.HaveNextPage = staff_list_page.HaveNextPage; //是否有下一页
//		 	获取分页器的页面信息
		 	var page_info=document.querySelector(".page-infomation");
		 	page_info.innerHTML="共"+page_infomantion.totalPages+"条记录&nbsp;&nbsp;当前"+page_infomantion.pageIndex+"/"+page_infomantion.totalRecords+"页";
		 	
		}
	}
	xmlhttp.open("POST",url,true);
	xmlhttp.send(formatParams(person_management_data));
}






