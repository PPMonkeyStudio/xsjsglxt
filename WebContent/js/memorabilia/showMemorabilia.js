/**
 * 
 */

var memorabilia ={
		searchContent:"",
		create_time_start:"",
		create_time_end:"",
		querySort:'desc',
		pageSize:10,
		currPage:1,
		pageCount:"",
		totalCount:""
}
var allInformation =""; 

window.onload= function()
{
	 allInformation= new Vue({
		el:'#allInformation',
		data:{
			currPage:'',
			pageCount:'',
			memorabiliaList:''
		}
	});
	loadData();
}

var loadData = function()
{
	var memorabiliaVOTemp ={
			"memorabiliaVO.searchContent":memorabilia.searchContent,
			"memorabiliaVO.create_time_start":memorabilia.create_time_start,
			"memorabiliaVO.create_time_end":memorabilia.create_time_end,
			"memorabiliaVO.querySort":memorabilia.querySort,
			"memorabiliaVO.pageSize":memorabilia.pageSize,
			"memorabiliaVO.currPage":memorabilia.currPage,
			"memorabiliaVO.pageCount":memorabilia.pageCount,
			"memorabiliaVO.totalCount":memorabilia.totalCount
			
	};
	
	$.ajax({
		url:"/xsjsglxt/user/Memorabilia_getMemorabiliaList",
		type:"post",
		data:memorabiliaVOTemp,
		success:function(data)
		{
			var jsonData = JSON.parse(data);
			allInformation.currPage=jsonData.currPage;
			allInformation.pageCount=jsonData.pageCount;
			allInformation.memorabiliaList=jsonData.memorabiliaListDTO;
		}
	});
}