function login() {

	var formData = new FormData();

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				window.location = '/xsjsglxt/user/User_index';
			} else {
				toastr.error(xhr.status);
			}
		}
	}

	xhr.open("POST", "/xsjsglxt/user/User_login");
	xhr.send(formData);

}