/**
 * 
 */
var changePage = function(event) {
	switch (event.id) {
	case "goFieldPage":
		$('#comparisonTime').fadeOut();
		$('#caseTime').fadeOut();
		$('#fieldPage').fadeIn();
		break;
	case "goComparisonPage":
		$('#caseTime').fadeOut();
		$('#fieldPage').fadeOut();
		$('#comparisonTime').fadeIn();
		break;
	case "goCasePage":
		$('#fieldPage').fadeOut();
		$('#comparisonTime').fadeOut();
		$('#caseTime').fadeIn();
		bread;
	}
}