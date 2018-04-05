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
	case "goComparisonPage":
		$('#caseTime').hide();
		$('#fieldPage').hide();
		$('#comparisonTime').show();
		loadComparison();
		break;
	case "goCasePage":
		$('#fieldPage').hide();
		$('#comparisonTime').hide();
		$('#caseTime').show();
		bread;
	}
}