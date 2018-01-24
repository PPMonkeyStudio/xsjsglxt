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
	
	$.datetimepicker.setLocale('ch');
	$('.startTimeDate').datetimepicker({
		yearStart : 1990, // 设置最小年份
		yearEnd : 2050, // 设置最大年份
		yearOffset : 0, // 年偏差
		timepicker : false, // 关闭时间选项
		format : 'Y-m-d', // 格式化日期年-月-日
		minDate : '1900/01/01', // 设置最小日期
		maxDate : '2030/01/01', // 设置最大日期
	});
	
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