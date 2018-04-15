/**
 * 
 */
var changePage = function(event) {
	switch (event.id) {
	case "goFieldPage":
		$('#comparisonTime').hide();
		$('#caseTime').hide();
		$('#fieldPage').show();
		loadPoliceman();
		break;
	case "goCasePage":
		$('#fieldPage').hide();
		$('#comparisonTime').hide();
		$('#caseTime').show();
		loadCase();
		break;
	}
}