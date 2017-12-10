//CaseDetail.jsp中的删除案件
function case_del(){
	var url="";
	loadCaseDetail_case_del(url);
}
function loadCaseDetail_case_del(url){
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else {
		xmlhttp=new ActiveXOBject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=httpbackCase_del;
	xmlhttp.open("pose",url,true);
	xmlhttp.send();
}
function httpbackCase_del(){
	if(xmlhttp.readyState==4&&xmlhttp.status==200){
		var case1_id=document.getElementById("case1_id");
	}
}
//CaseDetail.jsp中的修改案件
function case_change(){
	var url="";
	loadCaseDetail_case_change(url);
}
function loadCaseDetail_case_change(url){
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else {
		xmlhttp=new ActiveXOBject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=httpbackCase_change;
	xmlhttp.open("pose",url,true);
	xmlhttp.send();
}
function httpbackCase_change(){
	if(xmlhttp.readyState==4&&xmlhttp.state==200){
		var lost_evidence=$('#lost_evidence').serialize();
	}
}