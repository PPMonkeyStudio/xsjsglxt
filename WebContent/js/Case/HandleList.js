var query_data = {
	"page_list_HandleInformation.pageIndex" : "1",
	//行政案件名称
	"page_list_HandleInformation.handle_administrativeCase" : "",
	//中队长
	"page_list_HandleInformation.handle_squadronleader" : "",
	//办案民警
	"page_list_HandleInformation.handle_PoliceInHandlingCases" : "",
};
//当前页面分页信息
var page_infomantion = {
	pageIndex : 1,
	totalRecords : 1,
	pageSize : 20,
	totalPages : 1,
	HavePrePage : false,
	HaveNextPage : false,
}

// 选择全部
var selectAll = function(event) {
	if (event.checked) {
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = true;
		}
	} else {
		var che = document.getElementsByName("chooseCheckBox");
		for (var int = 0; int < che.length; int++) {
			che[int].checked = false;
		}
	}
}

var Handle_delete = function() {
	var formData = new FormData();
	$('.Handle_table_info tbody input:checked').each(function() {
		formData.append("useHandleInformationNumList", $(this).attr('id'));
	});
	$.confirm({
		title : '确定删除?',
		smoothContent : false,
		content : false,
		autoClose : 'cancelAction|10000',
		buttons : {
			deleteUser : {
				btnClass : 'btn-danger',
				text : '确认',
				action : function() {
					$.ajax({
						url : '/xsjsglxt/case/Handle_remove_HandleInformationList',
						type : 'post',
						data : formData,
						processData : false,
						contentType : false,
						dataType : 'text',
						success : function(data, text) {
							if (text == "success") {
								toastr.success("删除成功！");
								//获取对应option中的value值
								get_ListHandleInformationByPageAndSearch(query_data);
							} else {
								toastr.error("删除失败！");
							}
						}
					});
				}
			},
			cancelAction : {
				btnClass : 'btn-blue',
				text : '取消',
			}
		}
	});
}


//办案查询
var handle_query = function() {
	$.each($('#Handle_query form').serializeArray(), function(k, v) {
		query_data[v.name] = v.value;
	});
	$("#Handle_query").modal('hide');
	get_ListHandleInformationByPageAndSearch(query_data);
	toastr.success('查询成功!');
}

$(function() {
	get_ListHandleInformationByPageAndSearch(query_data);

	//Handle_delete删除办案管理事件
	$('.Handle_delete').click(Handle_delete);

	//办案添加
	$('#Handle_input').on('show.bs.modal', function() {
		if (!$('input[name="handle.handle_orderNumber"]').val()) {
			/*$.post('/xsjsglxt/case/Handle_xuhao', function(json_data, text_data) {
				$('input[name="handle.handle_orderNumber"]').val(json_data);
			}, 'json');*/
		}
	})
	//清除内容
	$(".modal").on('hidden.bs.modal', function() {
		$(this).find('input[type!="radio"][type!="hidden"]').val('');
		$(this).find('select').find('option:first-child').attr("selected", "selected");
		$('#Handle_input').find('.handle_modify').hide();
		$('#Handle_input').find('.handle_input').show();
	})
	//中对长和办案民警
	$("#Handle_input").on('show.bs.modal', function() {
		/*$.post('/xsjsglxt/case/Case_AllCase', {}, function(Case_data) {
			//所有案件循环
			var option = '';
			for (var len = 0; len < Case_data.length; len++) {
				option += '<option value="' + Case_data[len].xsjsglxt_case_id + '">' + Case_data[len].case_name + '</option>';
			}
			$('select[name="handle.handle_Case"]').html(option).selectpicker('refresh');
		}, 'json');*/
		$.post('/xsjsglxt/team/Staff_getHandleCenter', {}, function(msg) {
			$('select[name="handle.handle_squadronleader"]').html(function() {
				var option = "";
				for (const key in msg) {
					option += `<option value="${msg[key]["xsjsglxt_name"]}">${msg[key]["xsjsglxt_name"]}</option>`;
				}
				return option;
			}).selectpicker('refresh');
		}, 'json');
		$.post('/xsjsglxt/team/Staff_getHandleCheck', {}, function(msg) {
			$('select[name="handle.handle_PoliceInHandlingCases"]').html(function() {
				var option = "";
				for (const key in msg) {
					option += `<option value="${msg[key]["xsjsglxt_name"]}">${msg[key]["xsjsglxt_name"]}</option>`;
				}
				return option;
			}).selectpicker('refresh');
		}, 'json');
	})

	$('.handle_modify').click(function() {
		var handl_data = $('#Handle_input form').serialize();
		var dta = $('input[name="handle.handle_StartTimeaOfDetention"]').val();
		var day = $('select[name="handle.handle_detentionDay"]').val();
		var time_end = '&handle.handle_EndTimeaOfDetention=' + addDate(dta, day);
		var id = $('.handle_modify').attr('id');
		//handl_data += '&handle.handle_administrativeCase=' + $('select[name="handle.handle_Case"] option:selected').text();
		handl_data += time_end;
		handl_data += '&handle.xsjsglxt_handle_id=' + id;
		$.post('/xsjsglxt/case/Handle_updateHandleInformation', handl_data, function(xhr) {
			$('#Handle_input').modal('hide');
			if (xhr == "success") {
				toastr.success("修改成功！");
				get_ListHandleInformationByPageAndSearch(query_data);
			} else {
				toastr.error("添加失败！");
			}
		}, 'text');
	});

	//办案查询
	$('.handle_query').click(handle_query);
	//清空查询
	$('.handle_empty').click(function() {
		$('#Handle_query input,select').val("");
	});

	//tr事件委托
	$('.Handle_table_infossssssssss tbody').on('click', function(e) {
		var target = e.target;
		var na = e.target.tagName;
		if (na == 'INPUT') {
			e.stopPropagation();
		} else if (na == 'TD') {
			var ID = $(target).parents('tr').attr('id');
			$.post('/xsjsglxt/case/Handle_HandleInformationOne', {
				'handle.xsjsglxt_handle_id' : ID
			}, function(msg) {
				//input非单选框
				$('#Handle_input form').find('input').each(function() {
					if (this.name) {
						var ele_name = this.name;
						var key = ele_name.split('.')[1];
						if (msg[key] == '是') {
							$(this).val(msg[key]);
							$(this).siblings('label').find('input[type="radio"][value="是"]').attr('checked', 'true');
						} else if (msg[key] == '否') {
							$(this).val(msg[key]);
							$(this).siblings('label').find('input[type="radio"][value="否"]').attr('checked', 'true');
						} else {
							$(this).val(msg[key]);
						}
					}

				});
				$('#Handle_input form').find('select').each(function() {
					if (this.name) {
						var ele_name = this.name;
						var key = ele_name.split('.')[1];
						$(this).selectpicker('val', msg[key]);
					}
				});
				$('.handle_modify').attr('id', msg['xsjsglxt_handle_id']);
				$('#Handle_input').find('.handle_modify').show();
				$('#Handle_input').find('.handle_input').hide();
				$('#Handle_input').modal('show');
			}, 'json');
		}
	});

})

function get_ListHandleInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Handle_ListHandleInformationByPageAndSearch', data, function(xhr_data) {
		var Handle = xhr_data.listSuspectDTO;
		var str = '';
		for (var len = 0; len < Handle.length; len++) {
			str += '<tr class="tr_select" id="' + Handle[len].xsjsglxtHandle.xsjsglxtHandleId + '">';
			str += '<td rowspan="' + Handle[len].listSuspect.length + '" style="padding-left: 5px;"><input name="chooseCheckBox" id="' + Handle[len].xsjsglxtHandle.xsjsglxtHandleId + '" type="checkbox"></td>'
			//str += '<td style="padding-left: 5px;">' + Handle[len].handle_orderNumber + '</td>';
			str += '<td rowspan="' + Handle[len].listSuspect.length + '"><a onclick="viewHandle(this)">' + (Handle[len].xsjsglxtHandle.handleAdministrativeCase).replace('萍乡市安源区', '') + '</a></td>';

			for (var j = 0; j < Handle[len].listSuspect.length; j++) {
				str += '<td><a Hanid="' + Handle[len].xsjsglxtHandle.xsjsglxtHandleId + '" Susid="' + Handle[len].listSuspect[j].xsjsglxiHandleSuspectId + '" onclick="suspUpdate(this)">' + Handle[len].listSuspect[j].handleSuspectName + '</a></td>';
				str += '<td>' + Handle[len].listSuspect[j].handleSuspectSex + '</td>';
				str += '<td>' + Handle[len].listSuspect[j].handleSuspectHandling + '</td>';
				str += '<td>' + Handle[len].listSuspect[j].handleSuspectTime + '</td>';
				str += '<td>' + Handle[len].listSuspect[j].handleSuspectGoods + '</td>';
				break;
			}
			str += '<td rowspan="' + Handle[len].listSuspect.length + '">' + (Handle[len].xsjsglxtHandle.handleSponsoredPolice) + '</td>';
			str += '</tr>';
			for (var k = 1; k < Handle[len].listSuspect.length; k++) {
				str += '<tr>';
				str += '<td style="padding-left: 0px;"><a Hanid="' + Handle[len].xsjsglxtHandle.xsjsglxtHandleId + '" Susid="' + Handle[len].listSuspect[k].xsjsglxiHandleSuspectId + '" onclick="suspUpdate(this)">' + Handle[len].listSuspect[k].handleSuspectName + '</a></td>';
				str += '<td>' + Handle[len].listSuspect[k].handleSuspectSex + '</td>';
				str += '<td>' + Handle[len].listSuspect[k].handleSuspectHandling + '</td>';
				str += '<td>' + Handle[len].listSuspect[k].handleSuspectTime + '</td>';
				str += '<td style="padding-left: 0px;">' + Handle[len].listSuspect[k].handleSuspectGoods + '</td>';
				str += '</tr>';
			}
		}
		$('.Handle_table_info tbody').html(str);
		//当前页数:1 共:1页
		$('.info').html('当前页数:' + xhr_data.pageIndex + ' 共:' + xhr_data.totalPages);
		// 分页信息存入page_infomantion中
		page_infomantion.pageIndex = xhr_data.pageIndex; // 当前页数
		page_infomantion.totalRecords = xhr_data.totalRecords; // 总页数
		page_infomantion.pageSize = xhr_data.pageSize; // 每页记录数
		page_infomantion.totalPages = xhr_data.totalPages; // 总记录数
		page_infomantion.HavePrePage = xhr_data.HavePrePage; // 是否有上一页
		page_infomantion.HaveNextPage = xhr_data.HaveNextPage; // 是否有下一页
	}, 'json')
}

//添加办案
function handleInput() {
	let falg = true;
	//初始办案信息
	var params = {
		"handle.handleAdministrativeCase" : $('#handle_administrativeCase').val(),
		"handle.handleAdministrativeType" : $('#caseCategory').val(),
		"handle.handleSponsoredPolice" : $('#handleSponsoredPolice').val(),
		"handle.handleAssistingPolice" : $('#handleAssistingPolice').val(),
		"handle.handleSquadronLeader" : $('#handleSquadronLeader').val()
	};
	for (let key in params) {
		if (!params[key]) {
			falg = false;
			toastr.error('不能有空项');
		}
	}
	if (falg) {
		$.post('/xsjsglxt/case/Handle_saveHandle', params, function(xhr) {
			$('#Handle_input').modal('hide');
			if (xhr == "success") {
				toastr.success("添加成功！");
				//获取对应option中的value值
				get_ListHandleInformationByPageAndSearch(query_data);
			} else {
				toastr.error("添加失败！");
			}
		}, 'text');
	}
}


//查看办案
function viewHandle(a) {
	let id = $(a).parents('tr').attr('id');
	let hendObj = {};
	let viewHandleConfirm = $.confirm({
		smoothContent : false, //关闭动画
		closeIcon : true, //关闭图标
		closeIconClass : 'fa fa-close', //图标样式
		type : 'dark', //弹出框类型
		boxWidth : '60%', //设置宽度
		useBootstrap : false, //设置是否使用bootstropt样式
		title : '查看办案',
		content : `
			<table class="table" width="100%">
				 <tbody>
					 <tr>
						 <td width="90px">案件名称</td>
						 <td colspan="3"><input class="form-control" id="Case"></td>
					 </tr>
					 <tr>
						 <td width="90px">主办民警</td>
						 <td><input class="form-control" id="SponsoredPolice" type="text"></td>
						 <td width="90px">协办民警</td>
						 <td><input class="form-control" id="AssistingPolice" type="text"></td>
					 </tr>
					 <tr>
						 <td width="90px">侦查所长</td>
						 <td><input class="form-control" id="SquadronLeader" type="text"></td>
						 <td>案件类别</td>
						 <td><select v-model="caseCategory" class="form-control" id="Category">
								 <option value="刑事案件">刑事案件</option>
								 <option value="行政案件">行政案件</option>
							 </select>
						 </td>
					 </tr>
				 </tbody>
			 </table>
		`,
		onContentReady : function() {
			$.post('/xsjsglxt/case/Handle_HandleInformationOne', {
				"handle.xsjsglxtHandleId" : id
			}, response => {
				hendObj = response;
				viewHandleConfirm.$content.find('#Case').val(response.handleAdministrativeCase);
				viewHandleConfirm.$content.find('#SponsoredPolice').val(response.handleSponsoredPolice);
				viewHandleConfirm.$content.find('#AssistingPolice').val(response.handleAssistingPolice);
				viewHandleConfirm.$content.find('#SquadronLeader').val(response.handleSquadronLeader);
				viewHandleConfirm.$content.find('#Category').val(response.handleAdministrativeType);
			}, 'json');
		},
		buttons : {
			sus : {
				text : '添加嫌疑人',
				btnClass : 'btn-blue',
				action : function() {
					suspInput(hendObj);
					return false;
				}
			},
			confirm : {
				text : '修改',
				btnClass : 'btn-info',
				action : function() {
					let hanInfo = {
						"handle.xsjsglxtHandleId" : id,
						"handle.handleAdministrativeCase" : viewHandleConfirm.$content.find('#Case').val(),
						"handle.handleAdministrativeType" : viewHandleConfirm.$content.find('#SponsoredPolice').val(),
						"handle.handleSponsoredPolice" : viewHandleConfirm.$content.find('#AssistingPolice').val(),
						"handle.handleAssistingPolice" : viewHandleConfirm.$content.find('#AssistingPolice').val(),
						"handle.handleSquadronLeader" : viewHandleConfirm.$content.find('#SquadronLeader').val(),
						"handle.handleAdministrativeType" : viewHandleConfirm.$content.find('#Category').val(),
						"handle.handleGntCreate" : hendObj["handleGntCreate"],
					}
					for (let item in hanInfo) {
						if (!hanInfo[item]) {
							toastr.error('不能有空项');
							return false;
						}
					}
					$.post('/xsjsglxt/case/Handle_updateHandleInformation', hanInfo, response => {
						if (response == "success") {
							toastr.success('修改成功');
							//获取对应option中的value值
							get_ListHandleInformationByPageAndSearch(query_data);
						} else {
							toastr.error('修改失败');
						}
					}, 'text');
				}
			},
			cancel : {
				text : '取消',
				btnClass : 'btn-blue',
				keys : [ 'esc' ],
				action : function() {}
			}
		},
	});
}

//嫌疑人添加
function suspInput(hendObj) {
	let suspInputConfirm = $.confirm({
		smoothContent : false, //关闭动画
		closeIcon : true, //关闭图标
		closeIconClass : 'fa fa-close', //图标样式
		type : 'dark', //弹出框类型
		boxWidth : '1000px', //设置宽度
		useBootstrap : false, //设置是否使用bootstropt样式
		title : '添加嫌疑人',
		content : `<div id="suspInputConfirm">
			<table class="table table-condensed" width="97%">
				 <tbody>
				 	 <tr>
				 	 	<td colspan="8">嫌疑人基本情况</td>
				 	 </tr>
					 <tr>
						<td width="90px">姓名</td>
						<td><input class="form-control" id="Name"></td>
						<td width="90px">身份证号码</td>
						<td width="120px;"><input class="form-control" id="Card"></td>
						<td width="90px">性别</td>
						<td><input class="form-control" id="Sex"></td>
						<td width="90px">抓获时间</td>
						<td><input class="form-control mydate" id="CatchTime"></td>
					</tr>
					<tr>
						<td width="90px">涉嫌罪名</td>
						<td><input class="form-control" id="Recipient"></td>
					 </tr>
					 <tr>
					 	<td colspan="8">随身物品情况情况</td>
					 </tr>
					 <tr>
						<td width="90px">物品名称</td>
						<td><input class="form-control" id="GoodName" type="text"></td>
						<td width="90px">移交时间</td>
						<td><input class="form-control mydate" id="HandTime" type="text"></td>
						<td width="90px">移交人</td>
						<td><input class="form-control" id="HandPeople" type="text"></td>
						<td width="90px">接收人</td>
						<td><input class="form-control" id="ReceivePeople" type="text"></td>
					</tr>
					<tr>
						<td width="90px">处理方式</td>
						<td><input class="form-control" id="Handling" type="text"></td>
						<td width="90px">处理时间</td>
						<td><input class="form-control mydate" id="HandlingTime" type="text"></td>
						<td width="90px">照片</td>
						<td><a>上传</a></td>
					 </tr>
					 <tr>
					 	<td colspan="8">处理情况</td>
					 </tr>
					 <tr>
						 <td width="90px">处理类型</td>
						 <td>
						 	<select class="form-control" id="CategoryType" v-model="showDay">
								<template v-if="type=='刑事案件'">
									<option value="">请选择</option>
									<option value="拘留">拘留</option>
									<option value="逮捕">逮捕</option>
									<option value="起诉">起诉</option>
									<option value="退查">退查</option>
									<option value="监视居住">监视居住</option>
									<option value="取保候审">取保候审</option>
									<option value="释放">释放</option>
								</template>
								<template v-if="type=='行政案件'">
									<option value="">请选择</option>
									<option value="拘留">拘留</option>
									<option value="起诉">起诉</option>
								</template>
							</select>
						 </td>
						 <td><input class="form-control" id="Time" type="text"></td>
						 <td>
						 	<select v-if="showDay=='拘留'&&type=='刑事案件'" class="form-control" id="Day">
						 		<option value="">请选择天数</option>
						 		<option value="3">3天</option>
						 		<option value="7">7天</option>
						 		<option value="30">30天</option>
						 	</select>
						 </td>
					 </tr>
				 </tbody>
			 </table><div>
		`,
		onContentReady : function() {
			new Vue({
				el : '#suspInputConfirm',
				data : {
					type : hendObj.handleAdministrativeType,
					showDay : ''
				}
			})
			$.datetimepicker.setLocale('ch');
			$('.mydate').datetimepicker({
				yearStart : 1990, // 设置最小年份
				yearEnd : 2050, // 设置最大年份
				yearOffset : 0, // 年偏差
				timepicker : false, // 关闭时间选项
				format : 'Y-m-d', // 格式化日期年-月-日
				minDate : '1990/01/01', // 设置最小日期
				maxDate : '2030/01/01', // 设置最大日期
			});
		},
		buttons : {
			confirm : {
				text : '添加',
				btnClass : 'btn-info',
				action : function() {
					let suspectInfo = {
						"suspect.xsjsglxtHandleId" : hendObj.xsjsglxtHandleId,
						"suspect.handleSuspectName" : suspInputConfirm.$content.find('#Name').val(),
						"suspect.handleSuspectSex" : suspInputConfirm.$content.find('#Sex').val(),
						"suspect.handleSuspectCard" : suspInputConfirm.$content.find('#Card').val(),
						"suspect.handleSuspectRecipient" : suspInputConfirm.$content.find('#Recipient').val(),
						"suspect.handleSuspectCatch" : suspInputConfirm.$content.find('#CatchTime').val(),
						"suspect.handleSuspectGoods" : suspInputConfirm.$content.find('#GoodName').val(),
						"suspect.handleSuspectHand" : suspInputConfirm.$content.find('#HandTime').val(),
						"suspect.handleSuspectPeople" : suspInputConfirm.$content.find('#HandPeople').val(),
						"suspect.handleSuspectReceive" : suspInputConfirm.$content.find('#ReceivePeople').val(),
						"suspect.handleSuspectHandling" : suspInputConfirm.$content.find('#Handling').val(),
						"suspect.handleSuspectTime" : suspInputConfirm.$content.find('#HandlingTime').val(),
						"suspect.handleSuspectPicture" : suspInputConfirm.$content.find('#Category').val(),
						"suspect.handleSuspectProcessing" : suspInputConfirm.$content.find('#CategoryType').val(),
						"suspect.handleSuspectProcessingTime" : suspInputConfirm.$content.find('#Time').val(),
						"suspect.handleSuspectDetentionDay" : suspInputConfirm.$content.find('#Day').val(),
					}
					for (let item in suspectInfo) {
						if (!suspectInfo[item] && item != "suspect.handleSuspectPicture") {
							if (item == "suspect.handleSuspectDetentionDay") {
								if (suspectInfo["suspect.handleSuspectProcessing"] == "拘留" && hendObj.handleAdministrativeType == "刑事案件") {
									toastr.error('不能有空项');
									console.log(item);
									return false;
								}
							} else {
								toastr.error('不能有空项');
								console.log(item);
								return false;
							}
						}
					}
					if (suspInputConfirm.$content.find('#CategoryType').val() == "拘留" && hendObj.handleAdministrativeType == "刑事案件") {
						suspectInfo["suspect.handleEndTimeaOfDetention"] = addDate(suspInputConfirm.$content.find('#Time').val(), suspInputConfirm.$content.find('#Day').val());
					}
					$.post('/xsjsglxt/case/Handle_saveSuspect', suspectInfo, response => {
						if (response == "success") {
							toastr.success('添加成功');
							//获取对应option中的value值
							get_ListHandleInformationByPageAndSearch(query_data);
						} else {
							toastr.error('添加失败');
						}
					}, 'text');
				}
			},
			cancel : {
				text : '取消',
				btnClass : 'btn-blue',
				keys : [ 'esc' ],
				action : function() {}
			}
		},
	});
}


//嫌疑人修改
function suspUpdate(AEvent) {
	let Han = {};
	let Sus = {};
	let vm = {};
	let suspInputConfirm = $.confirm({
		smoothContent : false, //关闭动画
		closeIcon : true, //关闭图标
		closeIconClass : 'fa fa-close', //图标样式
		type : 'dark', //弹出框类型
		boxWidth : '1000px', //设置宽度
		useBootstrap : false, //设置是否使用bootstropt样式
		title : '添加嫌疑人',
		content : `<div id="suspUpdateConfirm">
			<table class="table table-condensed" width="97%">
				 <tbody>
				 	 <tr>
				 	 	<td colspan="8">嫌疑人基本情况</td>
				 	 </tr>
					 <tr>
						<td width="90px">姓名</td>
						<td><input class="form-control" id="Name" :value="suspect.handleSuspectName"></td>
						<td width="90px">身份证号码</td>
						<td width="120px;"><input class="form-control" id="Card" :value="suspect.handleSuspectCard"></td>
						<td width="90px">性别</td>
						<td><input class="form-control" id="Sex" :value="suspect.handleSuspectSex"></td>
						<td width="90px">抓获时间</td>
						<td><input class="form-control mydate" id="CatchTime" :value="suspect.handleSuspectCatch"></td>
					</tr>
					<tr>
						<td width="90px">涉嫌罪名</td>
						<td><input class="form-control" id="Recipient" :value="suspect.handleSuspectRecipient"></td>
					 </tr>
					 <tr>
					 	<td colspan="8">随身物品情况情况</td>
					 </tr>
					 <tr>
						<td width="90px">物品名称</td>
						<td><input class="form-control" id="GoodName" type="text" :value="suspect.handleSuspectGoods"></td>
						<td width="90px">移交时间</td>
						<td><input class="form-control mydate" id="HandTime" type="text" :value="suspect.handleSuspectHand"></td>
						<td width="90px">移交人</td>
						<td><input class="form-control" id="HandPeople" type="text" :value="suspect.handleSuspectPeople"></td>
						<td width="90px">接收人</td>
						<td><input class="form-control" id="ReceivePeople" type="text" :value="suspect.handleSuspectReceive"></td>
					</tr>
					<tr>
						<td width="90px">处理方式</td>
						<td><input class="form-control" id="Handling" type="text" :value="suspect.handleSuspectHandling"></td>
						<td width="90px">处理时间</td>
						<td><input class="form-control mydate" id="HandlingTime" type="text" :value="suspect.handleSuspectTime"></td>
						<td width="90px">照片</td>
						<td><a>上传</a></td>
					 </tr>
					 <tr>
					 	<td colspan="8">处理情况</td>
					 </tr>
					 <tr>
						 <td width="90px">处理类型</td>
						 <td>
						 	<select class="form-control" id="CategoryType" v-model="showDay" :value="suspect.handleSuspectProcessing">
								<template v-if="type=='刑事案件'">
									<option value="">请选择</option>
									<option value="拘留">拘留</option>
									<option value="逮捕">逮捕</option>
									<option value="起诉">起诉</option>
									<option value="退查">退查</option>
									<option value="监视居住">监视居住</option>
									<option value="取保候审">取保候审</option>
									<option value="释放">释放</option>
								</template>
								<template v-if="type=='行政案件'">
									<option value="">请选择</option>
									<option value="拘留">拘留</option>
									<option value="起诉">起诉</option>
								</template>
							</select>
						 </td>
						 <td><input class="form-control" id="Time" type="text" :value="suspect.handleSuspectProcessingTime"></td>
						 <td>
						 	<select v-if="showDay=='拘留'&&type=='刑事案件'" class="form-control" id="Day" :value="suspect.handleSuspectDetentionDay">
						 		<option value="">请选择天数</option>
						 		<option value="3">3天</option>
						 		<option value="7">7天</option>
						 		<option value="30">30天</option>
						 	</select>
						 </td>
					 </tr>
				 </tbody>
			 </table><div>
		`,
		onContentReady : function() {
			$.post('/xsjsglxt/case/Handle_SuspectInformation', {
				"handle.xsjsglxtHandleId" : $(AEvent).attr('Hanid'),
				"suspect.xsjsglxiHandleSuspectId" : $(AEvent).attr('Susid')
			}, response => {
				Han = response[0].xsjsglxtHandle;
				Sus = response[0].listSuspect[0];
				vm = new Vue({
					el : '#suspUpdateConfirm',
					data : {
						type : Han.handleAdministrativeType,
						suspect : Sus,
						showDay : Sus.handleSuspectProcessing
					}
				})

				$.datetimepicker.setLocale('ch');
				$('.mydate').datetimepicker({
					yearStart : 1990, // 设置最小年份
					yearEnd : 2050, // 设置最大年份
					yearOffset : 0, // 年偏差
					timepicker : false, // 关闭时间选项
					format : 'Y-m-d', // 格式化日期年-月-日
					minDate : '1990/01/01', // 设置最小日期
					maxDate : '2030/01/01', // 设置最大日期
				});
			}, 'json');
		},
		buttons : {
			confirm : {
				text : '修改',
				btnClass : 'btn-info',
				action : function() {
					let suspectInfo = {
						"suspect.handleSuspectName" : suspInputConfirm.$content.find('#Name').val(),
						"suspect.handleSuspectSex" : suspInputConfirm.$content.find('#Sex').val(),
						"suspect.handleSuspectCard" : suspInputConfirm.$content.find('#Card').val(),
						"suspect.handleSuspectRecipient" : suspInputConfirm.$content.find('#Recipient').val(),
						"suspect.handleSuspectCatch" : suspInputConfirm.$content.find('#CatchTime').val(),
						"suspect.handleSuspectGoods" : suspInputConfirm.$content.find('#GoodName').val(),
						"suspect.handleSuspectHand" : suspInputConfirm.$content.find('#HandTime').val(),
						"suspect.handleSuspectPeople" : suspInputConfirm.$content.find('#HandPeople').val(),
						"suspect.handleSuspectReceive" : suspInputConfirm.$content.find('#ReceivePeople').val(),
						"suspect.handleSuspectHandling" : suspInputConfirm.$content.find('#Handling').val(),
						"suspect.handleSuspectTime" : suspInputConfirm.$content.find('#HandlingTime').val(),
						"suspect.handleSuspectPicture" : suspInputConfirm.$content.find('#Category').val(),
						"suspect.handleSuspectProcessing" : suspInputConfirm.$content.find('#CategoryType').val(),
						"suspect.handleSuspectProcessingTime" : suspInputConfirm.$content.find('#Time').val(),
						"suspect.handleSuspectDetentionDay" : suspInputConfirm.$content.find('#Day').val(),

						"suspect.xsjsglxtHandleId" : Han.xsjsglxtHandleId,
						"suspect.xsjsglxiHandleSuspectId" : Sus["xsjsglxiHandleSuspectId"],
						"suspect.handleGmtCreate" : Sus["handleGmtCreate"]
					}
					for (let item in suspectInfo) {
						if (!suspectInfo[item] && item != "suspect.handleSuspectPicture") {
							if (item == "suspect.handleSuspectDetentionDay") {
								if (suspectInfo["suspect.handleSuspectProcessing"] == "拘留" && Han.handleAdministrativeType == "刑事案件") {
									toastr.error('不能有空项');
									console.log(item);
									return false;
								}
							} else {
								toastr.error('不能有空项');
								console.log(item);
								return false;
							}
						}
					}
					if (suspInputConfirm.$content.find('#CategoryType').val() == "拘留" && hendObj.handleAdministrativeType == "刑事案件") {
						suspectInfo["suspect.handleEndTimeaOfDetention"] = addDate(suspInputConfirm.$content.find('#Time').val(), suspInputConfirm.$content.find('#Day').val());
					}
					$.post('/xsjsglxt/case/Handle_updateSuspect', suspectInfo, response => {
						if (response == "success") {
							toastr.success('修改成功');
							//获取对应option中的value值
							get_ListHandleInformationByPageAndSearch(query_data);
						} else {
							toastr.error('修改失败');
						}
					}, 'text');
				}
			},
			del : {
				text : '删除',
				btnClass : 'btn-danger',
				keys : [ 'esc' ],
				action : function() {
					$.confirm({
						smoothContent : false, //关闭动画
						closeIcon : true, //关闭图标
						closeIconClass : 'fa fa-close', //图标样式
						type : 'dark', //弹出框类型
						boxWidth : '60%', //设置宽度
						useBootstrap : false, //设置是否使用bootstropt样式
						title : '删除办案',
						content : ``,
						buttons : {
							delet : {
								text : '删除',
								btnClass : 'btn-danger',
								action : function() {
									$.post('/xsjsglxt/case/Handle_removeSuspect', {
										"suspect.xsjsglxiHandleSuspectId" : Sus.xsjsglxiHandleSuspectId
									}, response => {
										if (response == "success") {
											toastr.success('删除成功');
											//获取对应option中的value值
											get_ListHandleInformationByPageAndSearch(query_data);
										} else {
											toastr.error('删除失败');
										}
									}, 'text');
								}
							},
							cancel : {
								text : '取消',
							}
						}
					});
				}
			},
			cancel : {
				text : '取消',
				btnClass : 'btn-blue',
				keys : [ 'esc' ],
				action : function() {}
			}
		},
	});
}


//日期加减
function addDate(date, days) {
	var d = new Date(date);
	d.setDate(d.getDate() + parseInt(days));
	var m_ = d.getMonth() + 1;
	var day_ = d.getDate();
	if (day_ < 10) {
		day_ = '0' + day_;
	}
	if (m_ < 10) {
		m_ = '0' + m_;
	}
	return d.getFullYear() + '-' + m_ + '-' + day_;
}

//radio
function chose(obj) {
	$(obj).parent().siblings('input').val($(obj).val());
}

//首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = 1;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//上一页
function prePage() {
	if (!page_infomantion.HavePrePage) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//下一页
function nextPage() {
	if (!page_infomantion.HaveNextPage) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = page_infomantion.totalPages;
	get_ListHandleInformationByPageAndSearch(query_data);
}
//跳转到n页
function toPage() {
	var topage = $('#skipPage').val();
	if (topage > page_infomantion.totalPages || topage < 0) {
		toastr.info('页码有误，请重新输入');
		return;
	}
	query_data['page_list_HandleInformation.pageIndex'] = topage;
	get_ListHandleInformationByPageAndSearch(query_data);
}