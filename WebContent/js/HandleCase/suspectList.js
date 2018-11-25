/**
 * 
 */
var queryTemp = {
	currPage : 1,
	pageSize : 10,
	searchCaseName : '',
	searchName : '',
	searchType : ''
}
var suspectListVue;
$(function() {
	suspectListVue = new Vue({
		el : '#contentDiv',
		data : {
			suspectVO : ''
		}
	});
	loadData();
})

function loadData() {
	$('#contentDiv').hide();
	$('#loadingLayer').show();
	var queryData = {
		'suspectVO.currPage' : queryTemp.currPage,
		'suspectVO.pageSize' : queryTemp.pageSize,
		'suspectVO.searchCaseName' : queryTemp.searchCaseName,
		'suspectVO.searchName' : queryTemp.searchName,
		'suspectVO.searchType' : queryTemp.searchType
	};
	$.ajax({
		url : '/xsjsglxt/case/DealCase_suspectList',
		type : 'POST',
		data : queryData,
		success : function(data) {
			suspectListVue.suspectVO = JSON.parse(data);
			$('#loadingLayer').hide();
			$('#contentDiv').show();
		}
	});
}
var skipToIndexPage = function() {
	if (queryTemp.currPage == 1) {
		toastr.error("已经是最后一页");
	} else {
		queryTemp.currPage = 1;
		loadData();
	}

}
var skipToNextPage = function() {
	if (queryTemp.currPage == suspectListVue.suspectVO.totalPage) {
		toastr.error("已经没有下一页");
	} else {
		queryTemp.currPage = queryTemp.currPage + 1;
		loadData();
	}

}
var skipToPrimaryPage = function() {
	if (queryTemp.currPage == 1) {
		toastr.error("已经没有上一页");
	} else {
		queryTemp.currPage = queryTemp.currPage - 1;
		loadData();
	}

}
var skipToLastPage = function() {
	if (queryTemp.currPage == suspectListVue.suspectVO.totalPage) {
		toastr.error("已经是最后一页");
	} else {
		queryTemp.currPage = suspectListVue.suspectVO.totalPage;
		loadData();
	}

}

var skipToArbitrarilyPage = function() {
	if ($('#skipPage').val() > suspectListVue.suspectVO.totalPage
			|| $('#skipPage').val() < 1) {
		toastr.error("不存在此页");
	} else {
		queryTemp.currPage = $('#skipPage').val();
		loadData();
	}
}

function changeSort() {
	queryTemp.searchCaseName = $('#caseName').val();
	queryTemp.searchName = $('#suspectName').val();
	queryTemp.searchType = $('#processType').val();
	loadData();
}
function goHandleList() {
	window.location.href = "/xsjsglxt/case/Case_page_Handle";
}

function stateRecord(event) {
	var stateRecordVue;
	$
			.confirm({
				title : '嫌疑人管理',
				type : 'dark',
				columnClass : 'col-md-4 col-md-offset-4',
				content : '<table id="stateTable" class="table table-hover table-condensed" style="text-align: center;">'
						+ '<thead><tr><td>嫌疑人状态</td><td>开始时间</td><td>结束时间</td></tr></thead>'
						+ '<tbody><template v-for="suspectState in states"><tr>'
						+ '<td><template v-if="suspectState.state_type == 0">拘留</template>'
						+ '<template v-if="suspectState.state_type == 1">逮捕</template>'
						+ '<template v-if="suspectState.state_type == 2">起诉</template>'
						+ '<template v-if="suspectState.state_type == 3">退查</template>'
						+ '<template v-if="suspectState.state_type == 4">监视居住</template>'
						+ '<template v-if="suspectState.state_type == 5">取保候审</template>'
						+ '<template v-if="suspectState.state_type == 6">释放</template></td>'
						+ '<td>{{ suspectState.state_start }}</td>'
						+ '<td>{{ suspectState.state_end }}</td>'
						+ '</tr><template></tbody>' + '</table>',
				buttons : {
					cancel : {
						text : '关闭',
						btnClass : 'btn-blue',
						action : function() {

						}
					}
				},
				onContentReady : function() {
					stateRecordVue = new Vue({
						el : '#stateTable',
						data : {
							states : ''
						}
					});
					$.ajax({
						url : '/xsjsglxt/case/DealCase_suspectStates',
						type : 'POST',
						data : {
							'suspectInfor.suspect_id' : event.id
						},
						success : function(data) {
							stateRecordVue.states = JSON.parse(data);
						}

					})
				}

			})
}