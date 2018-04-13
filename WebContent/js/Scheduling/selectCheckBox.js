/**
 * 
 */

var selectAll = function(event) {
	if (event.checked) {
		console.log("选中了");
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = true;
		}
	} else {
		console.log("没选中");
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = false;
		}
	}
}