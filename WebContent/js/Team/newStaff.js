
//newStaff新建人员
function staff_change(){
	var url="/xsjsglxt/team/Staff_updateStaffInformation";
	$.confirm({
	    title: '编辑!',
	    content: '确定编辑么!',
		buttons : {
			
			取消 : function() {
				// here the button key 'hey' will be used as the text.
			},
			确定: {
				action : function() {
					
					loadstaffDetail_staff_change(url);
				}
			}
		}
	});
	
}
function loadstaffDetail_staff_change(url){
	console.log("b2");
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else {
		xmlhttp=new ActiveXOBject("Microsoft.XMLHTTP"); 
	}
	var staffDetails=document.getElementById("staffDetails");
	var formData=new FormData(staffDetails);
	
	xmlhttp.onreadystatechange=function(){
		console.log("c2");
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			console.log(xmlhttp.responseText);
			var result = xmlhttp.responseText;
			if (result == 'success') {
				toastr.success('编辑成功！');
			} else {
				toastr.error('编辑失败！');
			}
		}
	};
	xmlhttp.open("post",url,true);
	xmlhttp.send(formData);
}
