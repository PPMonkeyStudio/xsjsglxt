/**
 * 
 */
var createLetter = function() {
	$.confirm({
		boxWidth : '500px',
		useBootstrap : false,
		title : '<i class="fa fa-pencil-square-o"></i>填写介绍信',
		type : 'green',
		content : "<div id='addLoadingLayer' class='hideDiv' style='margin: 0 auto; width: 45px;'><i class='fa fa-spinner fa-spin fa-3x fa-fw'></i></div>"
			+ "<div id='confirmDiv'><form id='formDataIntroduce' name='formDataIntroduce'>"
			+ "<table class='table bordered-table'><tr><td>目的单位：</td><td><input type='text' placeholder='请输入目的单位' name='letter.introduce_letter_tounit' class='form-control'></td></tr>"
			+ "<tr><td>前往人员：</td><td><input type='text' placeholder='请输入姓名用\",\"划分' name='letter.introduce_letter_introduceMan' class='form-control'></td></tr>"
			+ "<tr><td>前往人员数量：</td><td><input type='text' placeholder='请输入前往人员数量' name='letter.introduce_letter_number' class='form-control'></td></tr>"
			+ "<tr><td>前往事由：</td><td><input type='text' placeholder='请输入前往事由' name='letter.introduce_letter_reasons' class='form-control'></td></tr>"
			+ "<tr><td>前往时间：</td><td><input type='text' placeholder='请输入前往时间' name='letter.introduce_time' class='form-control startTime'></td></tr>"
			+ "<tr><td>前往天数：</td><td><select class='form-control' name='letter.introduce_time_limit'>"
			+ "<option value='3'>3</option>"
			+ "<option value='4'>4</option>"
			+ "<option value='5'>5</option>"
			+ "<option value='6'>6</option>"
			+ "<option value='7'>7</option>"
			+ "</select></td></tr>" + "</table></from></div>",
		buttons : {
			save : {
				text : '<i class="fa fa-upload" aria-hidden="true"></i>保存',
				btnClass : 'btn-blue',
				action : function() {
					for (var i = 0; i < document.formDataIntroduce.elements.length - 1; i++) {
						if (document.formDataIntroduce.elements[i].value == "") {
							toastr.error("当前表单不能有空项");
							document.formDataIntroduce.elements[i]
								.focus();
							return false;
						}
					}
					$("#confirmDiv").hide();
					$("#addLoadingLayer").show();
					var formData = new FormData(document
						.getElementById("formDataIntroduce"));
					formData.append("letter.introduce_approve_status",
						"未审批");
					$
						.ajax({
							url : '/xsjsglxt/case/Handle_saveIntroduceLetter',
							type : 'POST',
							data : formData,
							processData : false,
							contentType : false,
							success : function(data) {
								toastr.success('保存成功！');
								queryConditionTemp.currPage = 1;
								loadData();
							}
						})
				}
			},
			close : {
				text : "<i class='fa fa-times' aria-hidden='true'></i>关闭",
				btnClass : "btn-red",
				action : function() {}
			}
		},
		onContentReady : function() {
			$.datetimepicker.setLocale('ch');
			$('.startTime').datetimepicker({
				yearStart : 1900, // 设置最小年份
				yearEnd : 2100, // 设置最大年份
				yearOffset : 0, // 年偏差
				timepicker : false, // 关闭时间选项
				format : 'Y-m-d', // 格式化日期年-月-日
				minDate : '1900/01/01', // 设置最小日期
				maxDate : '2030/01/01', // 设置最大日期
			});
		}
	});
}