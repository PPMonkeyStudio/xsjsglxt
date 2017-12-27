function all_select() {

	var checkbox_all_select = document.getElementById("checkbox_all_select");

	var checkbox_select = document.getElementsByClassName("checkbox_select");

	if (checkbox_all_select.checked) {
		for (var num = 0; num < checkbox_select.length; num++) {
			checkbox_select[num].checked = true;
		}
	} else {
		for (var num = 0; num < checkbox_select.length; num++) {
			checkbox_select[num].checked = false;
		}
	}
}

function class_select(all_select, myClass) {
	var checkbox_all_select = document.getElementById(all_select);

	var checkbox_select = document.getElementsByClassName(myClass);

	if (checkbox_all_select.checked) {
		for (var num = 0; num < checkbox_select.length; num++) {
			checkbox_select[num].checked = true;
		}
	} else {
		for (var num = 0; num < checkbox_select.length; num++) {
			checkbox_select[num].checked = false;
		}
	}
}