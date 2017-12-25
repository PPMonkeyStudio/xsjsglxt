
//newStaff新建人员
function staff_change() {
	var url = "/xsjsglxt/team/Staff_saveStaff";
	$.confirm({
		title : '新建!',
		content : '确定新建么!',
		buttons : {

			取消 : function() {
				// here the button key 'hey' will be used as the text.
			},
			确定 : {
				action : function() {

					loadstaffDetail_staff_change(url);
				}
			}
		}
	});

}
function loadstaffDetail_staff_change(url) {
	console.log("b2");
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXOBject("Microsoft.XMLHTTP");
	}
	var staffDetails = document.getElementById("staffDetails");
	var formData = new FormData(staffDetails);

	xmlhttp.onreadystatechange = function() {
		console.log("c2");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			console.log(xmlhttp.responseText);
			var result = xmlhttp.responseText;
			if (result == 'success') {
				toastr.success('新建成功！');
			} else {
				toastr.error('新建失败！');
			}
		}
	};
	xmlhttp.open("post", url, true);
	//xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8"); 
	xmlhttp.send(formData);
}

//改变性别方法
function changeSex_man(even){
	var sex=document.getElementById("sex");
	sex.value=even.value;
	return sex.value;
}
function changeSex_woman(even){
	var sex=document.getElementById("sex");
	sex.value=even.value;
	return sex.value;
}

//改变是否正式
function isFormat(even){
	var format=document.getElementById("format");
	format.value=even.value;
	return fomat.value;
}
function isNotFormat(even){
	var format=document.getElementById("format");
	format.value=even.value;
	return fomat.value;
}
// 实现点击file
function photo_click(){
	var photo_file = document.querySelector(".photo-file");
	photo_file.click();
}
// 图片预览
function photo_preview() {

	var photo_file = document.querySelector(".photo-file");
	var photo_show = document.querySelector(".photo-show");
	var photo_files = photo_file.files;
	for (var i = 0; i < photo_files.length; i++) {
		photo_show.innerHTML += "<img class='image" + i + "'>";
		var image = document.querySelector(".image" + i);
		if (photo_file.files && photo_file.files[i]) {
			// 火狐直接获取src
			image.style.display = 'block';
			image.style.width = '120px';
			image.style.height = '150px';
			image.src = window.URL.createObjectURL(photo_file.files[i]);
		} else {
			// IE下，使用滤镜
			photo_file.select();
			var imgSrc = document.selection.createRange().text;
			// 必须设置初始大小
			photo_show.style.width = "120px";
			photo_show.style.height = "150px";
			// 图片异常的捕捉，防止用户修改后缀来伪造图片
			try {
				photo_show.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				photo_show.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
		}

	}/*
	// 获取上传的文件名
	var photo_fileValue = photo_file.value;
	var fileValue = photo_fileValue.split("\\");
	var fileName = fileValue[fileValue.length - 1];
	console.log(fileName);
	photo_file.value=fileName;*/
	return true;
}
if(window.File && window.FileList && window.FileReader && window.Blob) {
	document.querySelector(".photo-file").addEventListener('change', photo_preview, false);
} else {
	document.write('您的浏览器不支持File Api');
}
function stopPropagation(e) {
	if (e.stopPropagation)
		e.stopPropagation();
	else
		e.cancelBubble = true;
}

