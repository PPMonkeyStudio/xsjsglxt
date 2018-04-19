var query_data = {
	//光盘分页信息
	"page_list_imageInformation.pageIndex": "1",
}

//当前页面分页信息
var page_infomantion = {
	pageIndex: 1,
	totalRecords: 1,
	pageSize: 20,
	totalPages: 1,
	HavePrePage: false,
	HaveNextPage: false,
}
//设置分页信息
function setPageInfomation(data) {
	page_infomantion.pageIndex = data.pageIndex; //当前页数
	page_infomantion.totalRecords = data.totalRecords; //总页数
	page_infomantion.pageSize = data.pageSize; //每页记录数
	page_infomantion.totalPages = data.totalPages; //总记录数
	page_infomantion.HavePrePage = data.HavePrePage; //是否有上一页
	page_infomantion.HaveNextPage = data.HaveNextPage; //是否有下一页
}


//查看影像光盘详情事件
var image_Details = function () {
	var image_id = $(this).siblings('input').val();
	if ($(this).text().trim() == "修改") {
		$.post('/xsjsglxt/case/Image_ImageInformationOne', {
			"image.xsjsglxt_image_id": image_id
		}, function (xhr_data) {
			$('#image').find('input[name="image.image_number"]').val(xhr_data.image.image_number);
			$('#image').find('input[name="image.image_number"]').text(xhr_data.image.xsjsglxt_image_id);
			//显示模态框
			$('#image .add_image').hide();
			$('#image .modify_image').show();
			$('#image').modal('show');
			//模态框按钮设置点击事件
			$('#image .modify_image').unbind().click(function () {
				$.post('/xsjsglxt/case/Image_updateImage', $('#image form').serialize() + "&xsjsglxt_image_id=" + image_id, function (msg) {
					if (msg == "success") {
						$('#image').modal('hide');
						toastr.info("修改成功!");
						get_ListImageInformationByPageAndSearch(data)
					}
				}, 'json');
			});
		}, 'json');
	} else if ($(this).text().trim() == "删除") {
		var formData = new FormData();
		formData.append("useImageInformationNumList", image_id);
		$.post('/xsjsglxt/case/Image_remove_ImageInformationList', formData, function (msg) {
			if (msg == 'success') {
				toastr.info('删除成功');
				get_ListImageInformationByPageAndSearch(query_data);
			} else if (msg == 'error') {

			}
		}, 'text');
	}
}


/*
//修改确认
$.confirm({
	title: '确定修改?',
	smoothContent: false,
	content: false,
	autoClose: 'cancelAction|10000',
	buttons: {
		deleteUser: {
			btnClass: 'btn-danger',
			text: '确认',
			action: function () {
			}
		},
		cancelAction: {
			btnClass: 'btn-blue',
			text: '取消',
		}
	}
});
*/


$(function () {
	$('#image').on('hiden.bs.modal', function () {
		$('#image .add_image').show();
		$('#image .modify_image').show();
	})

	//confirm提示框的关闭图标
	jconfirm.defaults = {
		closeIcon: true,
		closeIconClass: 'fa fa-close',
	}

	//添加信息按钮点击事件
	$('.add_image').click(function () {
		if ($('#image').find('.must').val() != "") {
			$.post('/xsjsglxt/case/Image_saveCD', $('#image form').serialize(), function (msg) {
				if (msg.length > 22 && msg.length <= 36) {
					toastr.info('添加成功');
					get_ListImageInformationByPageAndSearch(query_data);
				}
			}, 'text');
		}
	});

	get_ListImageInformationByPageAndSearch(data);
})



function get_ListImageInformationByPageAndSearch(data) {
	$.post('/xsjsglxt/case/Image_getAllImageInformation', query_data, function (xhr_data) {
		var image_arr = xhr_data;
		var str = '';
		for (var i = 0; i < image_arr.length; i++) {
			str += '<tr>';
			str += '<tr>';
			str += '<td>' + (i + 1) + '</td>';
			str += '<td>' + image_arr[i].image_number + '</td>';
			str += '<td>' + image_arr[i].image_remarks + '</td>';
			str += '<td>'
				+ '<input type="hidden"  value="' + image_arr[i].xsjsglxt_image_id + '" />'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-primary btn-xs"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 修改</button>'
				+ '<button type="button" style="margin-left:6px;" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> 删除</button>'
				+ '</td>';
			str += '</tr>'
		}
		//str表格信息添加到表格中
		$('.image_table_info tbody').html(str);
		//按钮给与点击事件
		$('.btn-xs').click(image_Details);
		//设置分页信息
		setPageInfomation(xhr_data);
	}, 'json');
}


//分页方法-------=========---------==============-------==========------------=========-------=
// 首页
function firstPage() {
	if (page_infomantion.pageIndex == 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = 1;
	get_ListImageInformationByPageAndSearch(query_data);
}
// 上一页
function prePage() {
	if (page_infomantion.pageIndex - 1 <= 1) {
		toastr.error('已经是第一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = page_infomantion.pageIndex - 1;
	get_ListImageInformationByPageAndSearch(query_data);
}
// 下一页
function nextPage() {
	if (page_infomantion.pageIndex + 1 >= page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = page_infomantion.pageIndex + 1;
	get_ListImageInformationByPageAndSearch(query_data);
}
// 尾页
function lastPage() {
	if (page_infomantion.pageIndex == page_infomantion.totalPages) {
		toastr.error('已经是最后一页！');
		return;
	}
	query_data['page_list_parallelInformation.pageIndex'] = page_infomantion.totalPages;
	get_ListImageInformationByPageAndSearch(query_data);
}