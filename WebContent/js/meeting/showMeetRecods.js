/**
 * 
 */

var queryObject={
		"queryTitle":"",
		"startTimeSort":"desc",
		"query_start_time_start":"",
		"query_start_time_end":"",
		"pageCount":0,
		"currPage":0,
		"pageSize":0,
		"totalCount":0
}

window.onload=function(){
	var formData = new FormData();
	formData.append("meetVO.currPage","1");
	formData.append("meetVO.pageSize","10");
	formData.append("meetVO.startTimeSort","desc");
	$.ajax({
		url:"/xsjsglxt/user/Meeting_showMeetingByPageAndList",
		type:"POST",		
		data: formData,
		processData: false,
		contentType: false,
		success:function(data){
			var jsonData = JSON.parse(data);
			$("#currPage").html(jsonData.currPage);
			$("#totalPage").html(jsonData.pageCount);
			alert(jsonData.meetDTO.length);
			var tableContent="";
			for(var i=0;i<jsonData.meetDTO.length;i++)
				{
				tableContent=tableContent+"<tr>" +
						"<td>"+jsonData.meetDTO[i].meeting_title+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_place+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_compere+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_start_time+"</td>" +
						"<td>"+jsonData.meetDTO[i].meeting_end_time+"</td>" +
						"<td><button class='btn btn-primary' value='"+jsonData.meetDTO[i].meeting_id+"'>修改</button>" +
						"<button class='btn btn-danger' value='"+jsonData.meetDTO[i].meeting_id+"'>删除</button></td>" +
						"</tr>"
				}
			$("#showList").html(tableContent);
		}
	});
}
