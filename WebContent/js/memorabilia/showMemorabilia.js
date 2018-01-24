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
	$('#timeStart').val("");
	$('#timeEnd').val("");
	$('#searchInput').val("");
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


var changeSort = function(dom)
{
	memorabilia.querySort = dom.value;
	loadData();
}

var changeSearchContent=function(dom)
{
	memorabilia.searchContent = dom.value;
	loadData();
}

var changeTime = function(dom)
{
	if(dom.id=="timeStart")
		{
			memorabilia.create_time_start =dom.value;
		}
	else
		{
		memorabilia.create_time_end = dom.value;
		}
	loadData();
		
}

var skipToIndexPage =function()
{
	if(memorabilia.currPage==1)
		{
			toastr.error("已经是首页");
		}
	else
		{
			memorabilia.currPage=1;
			loadData();
		}
}
var skipToPrimaryPage = function()
{
	if(memorabilia.currPage==1)
		{
			toastr.error('已经是第一页');
		}
	else
		{
			memorabilia.currPage--;
			loadData();
		}
}
var skipToNextPage = function()
{
	if(memorabilia.currPage==memorabilia.pageCount)
		{
			toastr.error('已经是最后一页');
		}
	else
		{
			memorabilia.currPage++;
			loadData();
		}
}
var skipToLastPage = function()
{
	if(memorabilia.currPage==memorabilia.pageCount)
		{
			toastr.error('已经是末页');
		}
	else
		{
			memorabilia.currPage = memorabilia.pageCount;
			loadData();
		}
}

var loadData = function()
{
	$("#allInformation").hide();
	$("#loadingLayer").show();
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
			memorabilia.currPage = jsonData.currPage;
			memorabilia.pageCount = jsonData.pageCount;
			memorabilia.pageSize = jsonData.pageSize;
			memorabilia.totalCount = jsonData.totalCount;
			$("#loadingLayer").hide();
			$("#allInformation").show();
		}
	});

}