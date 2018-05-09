var Case_Snece_lost = {
	evidencelist : [],
	picturelist : [],
	computerlist : [],
	mobilephonelist : [],
	lostlist : [],
};

//序列化为对象======----自定义方法
$.fn.extend({
	serializeObject : function() {
		if (this.length > 1) {
			return false;
		}
		var arr = this.serializeArray();
		var obj = new Object;
		$.each(arr, function(k, v) {
			obj[v.name] = v.value;
		});
		return obj;
	}
});

$(function() {
	$('.form_time').val(new Date().toLocaleDateString());

	$.post('/xsjsglxt/case/Case_getSenceInquestId', function(xhr) {
		$('input[name="sence.snece_inquestId"]').val(xhr);
		// 接警时间改变时勘验编号相应改变
		$('input[name="case1.case_receivingAlarmDate"]').blur(function() {
			var time = new Date($(this).val());
			// toastr.danger("请输入正确的时间");
			if (time == "Invalid Date") {
				toastr.error("请输入正确的时间");
				return;
			}
			var tear = time.getUTCFullYear();
			var month = time.getMonth() + 1;
			if (month > 0 && month < 10) {
				month = "0" + month;
			}
			$('input[name="sence.snece_inquestId"]').val(xhr.substring(0, 10) + tear + month + xhr.substring(16, xhr.length));
		});
	}, 'json')

	$('.sneceInformation_finish').click(function() {
		var isValue = true;
		$('#sneceInformation').find('.must').each(function() {
			if ($(this).val() == "") {
				toastr.error("信息不能为空");
				isValue = false;
				return false;
			}
		});
		if (isValue) {
			var sence_data = $('#sneceInformation').serializeObject();
			if ($('input[name="case1.case_register"]').val() == 1) {
				//sence_data += '&case1.case_registerTime=' + new Date().Format('yyyy-MM-dd');
				sence_data["case1.case_registerTime"] = new Date().Format('yyyy-MM-dd');
			}
			var otherData = {};
			for (var key_0 in Case_Snece_lost) {
				for (var int = 0; int < Case_Snece_lost[key_0].length; int++) {
					var obj = Case_Snece_lost[key_0][int];
					for (var key in obj) {
						var arry = key.split('.');
						var key_9 = arry[0] + 'list[' + int + ']' + "." + arry[1];
						otherData[key_9] = obj[key];
					}
				}
			}
			console.log(otherData);
			var newData = $.extend({}, sence_data, otherData)
			console.log(newData);
			$.ajax({
				url : "/xsjsglxt/case/Case_saveSenceInformation",
				type : "post",
				timeout : 3000,
				data : newData,
				dataType : "json",
				success : function(xhr_data) {
					var reg = /^[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}$/;
					var r = xhr_data.match(reg);
					if (r == null) {
						toastr.error("录入失败！");
					} else {
						toastr.success("录入成功！");
						location.href = '/xsjsglxt/case/Case_page_CaseDetails?id=' + xhr_data;
					}
				}
			});
		}
	});

	$.post('/xsjsglxt/team/Staff_getInquestPerson', {}, function(params) {
		var leader = params.leader;
		var human = params.human;
		var suspectStr = '';
		for (let index = 0; index < leader.length; index++) {
			suspectStr += '<option value="' + leader[index]["xsjsglxt_name"] + '">' + leader[index]["xsjsglxt_name"] + '</option>';
		}
		for (let index = 0; index < human.length; index++) {
			suspectStr += '<option value="' + human[index]["xsjsglxt_name"] + '">' + human[index]["xsjsglxt_name"] + '</option>';
		}
		$('select[name="sence.snece_inquestPerson"]').html(suspectStr).selectpicker('refresh');
	}, 'json');

})

// -----------------------------------------------------------案件
var sectionCase0 = new Array();
sectionCase0[0] = [ "请选择案件子类别" ]

var sectionCase1 = new Array();
sectionCase1[0] = [ "请选择案件子类别" ]
sectionCase1[1] = [ "入室盗窃案" ]
sectionCase1[2] = [ "盗窃汽车案" ]
sectionCase1[3] = [ "盗窃车内物品案" ]
sectionCase1[4] = [ "电缆盗窃案" ]
sectionCase1[5] = [ "单位盗窃案" ]
sectionCase1[6] = [ "其它盗窃案" ]

var sectionCase2 = new Array();
sectionCase2[0] = [ "请选择案件子类别" ]
sectionCase2[1] = [ "入户抢劫案" ]
sectionCase2[2] = [ "拦路抢劫案" ]
sectionCase2[3] = [ "麻醉抢劫案" ]
sectionCase2[4] = [ "其它抢劫案" ]

var sectionCase3 = new Array();
sectionCase3[0] = [ "请选择案件子类别" ]
sectionCase3[1] = [ "尾随抢夺案" ]
sectionCase3[2] = [ "飞车抢夺案" ]
sectionCase3[3] = [ "其它抢夺案" ]

var chapterCaseArr = new Array();
chapterCaseArr[0] = [ "请选择案件总类别", "", sectionCase0 ];
chapterCaseArr[1] = [ "盗窃案", "盗窃案", sectionCase1 ];
chapterCaseArr[2] = [ "抢劫案", "抢劫案", sectionCase2 ];
chapterCaseArr[3] = [ "抢夺案", "抢夺案", sectionCase3 ];
chapterCaseArr[4] = [ "强奸案", "强奸案", ];
chapterCaseArr[5] = [ "绑架案", "绑架案", ];
chapterCaseArr[6] = [ "杀人案", "杀人案", ];
chapterCaseArr[7] = [ "故意伤害案", "故意伤害案", ];
chapterCaseArr[8] = [ "爆炸案", "爆炸案", ];
chapterCaseArr[9] = [ "放火案", "放火案", ];
chapterCaseArr[10] = [ "非法拘禁案", "非法拘禁案", ];
chapterCaseArr[11] = [ "非正常死亡", "非正常死亡", ];
chapterCaseArr[12] = [ "故意损坏公私财物", "故意损坏公私财物", ];
chapterCaseArr[13] = [ "其它", "其它", ];


function setSectionCase(chapter) {
	if (chapter > 3 && chapter != 13) {
		$('.other_case').hide();
	} else if (chapter == 13) {
		// 清空other_case的select元素，改为input元素
		$('.main_case').next().remove();
		$('#other_case_td').html('<input type="text" name="case1.case_sonCategory" style="margin-top: 6px; width: 160px;" class="other_case form-control must">');
	} else {
		$('.other_case').empty().show();
		var length = chapterCaseArr[chapter][2].length;
		if ($('select[class="other_case form-control"]').length == 0) {
			$('input[class="other_case form-control"]').remove();
			$('#other_case_td').html('<select name="case1.case_sonCategory" style="margin-top: 6px; width: 160px;" class="other_case form-control must"><option selected value="">请选择案件子类别</option></select>');
		}
		for (var i = 0; i < length; i++) {
			$('.other_case').append("<option value='" + chapterCaseArr[chapter][2][i] + "'>" + chapterCaseArr[chapter][2][i] + "</option>");
		}
	}

	var receivingAlarmDate = new Date($('input[name="case1.case_receivingAlarmDate"]').val()).Format("yyyy.MM.dd");
	$('.case_name').val('"' + receivingAlarmDate + '"' + $('.case_place').val() + $('.main_case').val());

	$('.other_case').unbind().change(function() {
		$('.case_name').val('"' + receivingAlarmDate + '"' + $('.case_place').val() + $('.other_case').val());
	})
}

function setCase_name() {
	var receivingAlarmDate = new Date($('input[name="case1.case_receivingAlarmDate"]').val()).Format("yyyy.MM.dd");
	if ($('.other_case').val()) {
		$('.case_name').val('"' + receivingAlarmDate + '"' + $('.case_place').val() + $('.other_case').val());
	} else if ($('.main_case').val()) {
		$('.case_name').val('"' + receivingAlarmDate + '"' + $('.case_place').val() + $('.main_case').val());
	} else {
		$('.case_name').val('"' + receivingAlarmDate + '"' + $('.case_place').val());
	}

}
// -----------------------------------------------------------作案手段
var sectionMethod0 = new Array();
sectionMethod0[0] = [ "具体手段" ]

var sectionMethod1 = new Array();
sectionMethod1[0] = [ "具体手段" ]
sectionMethod1[1] = [ "撬防盗门" ]
sectionMethod1[2] = [ "撬木门" ]
sectionMethod1[3] = [ "撞踹木门" ]
sectionMethod1[4] = [ "破玻璃门" ]
sectionMethod1[5] = [ "破门把手" ]
sectionMethod1[6] = [ "溜门" ]
sectionMethod1[7] = [ "门缝钻入" ]
sectionMethod1[8] = [ "门上挖洞" ]
sectionMethod1[9] = [ "强力破锁" ]
sectionMethod1[10] = [ "插片开锁" ]
sectionMethod1[11] = [ "钻孔开锁" ]
sectionMethod1[12] = [ "填充物开锁" ]
sectionMethod1[13] = [ "钳断锁梁" ]
sectionMethod1[14] = [ "撬扭挂锁" ]
sectionMethod1[15] = [ "破锁搭扣" ]
sectionMethod1[16] = [ "解密开锁" ]
sectionMethod1[17] = [ "卸锁体" ]
sectionMethod1[18] = [ "钥匙开锁" ]
sectionMethod1[19] = [ "破车门锁" ]
sectionMethod1[20] = [ "撬卷闸门" ]
sectionMethod1[21] = [ "其它" ]

var sectionMethod2 = new Array();
sectionMethod2[0] = [ "具体手段" ]
sectionMethod2[1] = [ "破坏窗栅" ]
sectionMethod2[2] = [ "破防盗网" ]
sectionMethod2[3] = [ "窗口钻入" ]
sectionMethod2[4] = [ "破窗玻璃" ]
sectionMethod2[5] = [ "破窗插销" ]
sectionMethod2[6] = [ "攀爬防盗网" ]
sectionMethod2[7] = [ "窗口勾物" ]
sectionMethod2[8] = [ "砸车玻璃" ]
sectionMethod2[9] = [ "其它" ]

var sectionMethod3 = new Array();
sectionMethod3[0] = [ "具体手段" ]
sectionMethod3[1] = [ "借物攀爬" ]
sectionMethod3[2] = [ "攀爬水管" ]
sectionMethod3[3] = [ "攀爬阳台" ]
sectionMethod3[4] = [ "攀爬空调架" ]
sectionMethod3[5] = [ "攀爬阳台" ]
sectionMethod3[6] = [ "攀爬围墙" ]
sectionMethod3[7] = [ "楼梯间攀爬" ]
sectionMethod3[8] = [ "其它" ]

var sectionMethod4 = new Array();
sectionMethod4[0] = [ "具体手段" ]
sectionMethod4[1] = [ "钻洞入室" ]
sectionMethod4[2] = [ "墙上挖洞" ]
sectionMethod4[3] = [ "钻排风口" ]
sectionMethod4[4] = [ "其它" ]

var sectionMethod5 = new Array();
sectionMethod5[0] = [ "具体手段" ]
sectionMethod5[1] = [ "中毒死亡" ]
sectionMethod5[2] = [ "缢死" ]
sectionMethod5[3] = [ "自杀死亡" ]
sectionMethod5[4] = [ "高坠死亡" ]
sectionMethod5[5] = [ "溺水死亡" ]
sectionMethod5[6] = [ "意外死亡" ]
sectionMethod5[7] = [ "病理死亡" ]
sectionMethod5[8] = [ "窒息死亡" ]
sectionMethod5[9] = [ "暴力死亡" ]
sectionMethod5[10] = [ "失血死亡" ]
sectionMethod5[11] = [ "弃婴" ]
sectionMethod5[12] = [ "乘隙盗窃" ]
sectionMethod5[13] = [ "顺手牵羊" ]
sectionMethod5[14] = [ "掘墓盗物" ]
sectionMethod5[15] = [ "持戒作案" ]
sectionMethod5[16] = [ "暴力胁迫" ]
sectionMethod5[17] = [ "搭线发车" ]
sectionMethod5[18] = [ "欺诈" ]
sectionMethod5[19] = [ "监守自盗" ]
sectionMethod5[20] = [ "其它" ]

var chapterMethodArr = new Array();
chapterMethodArr[0] = [ "作案手段", "", sectionMethod0 ];
chapterMethodArr[1] = [ "从门侵入", "从门侵入", sectionMethod1 ];
chapterMethodArr[2] = [ "从窗侵入", "从窗侵入", sectionMethod2 ];
chapterMethodArr[3] = [ "攀爬侵入", "攀爬侵入", sectionMethod3 ];
chapterMethodArr[4] = [ "洞口侵入", "洞口侵入", sectionMethod4 ];
chapterMethodArr[5] = [ "其它", "其它", sectionMethod5 ];


function setSectionmMethod(chapter) {
	$('.specific_means').empty();
	var length = chapterMethodArr[chapter][2].length;
	for (var i = 0; i < length; i++) {
		$('.specific_means').append("<option value='" + chapterMethodArr[chapter][2][i] + "'>" + chapterMethodArr[chapter][2][i] + "</option>");
	}
}

// -----------------------------------------------------------处所
var sectionAddress0 = new Array();
sectionAddress0[0] = [ "具体处所" ]
var sectionAddress1 = new Array();
sectionAddress1[0] = [ "具体处所" ]
sectionAddress1[1] = [ "小区住宅" ]
sectionAddress1[2] = [ "普通住宅" ]
sectionAddress1[3] = [ "出租屋" ]
sectionAddress1[4] = [ "农宅" ]
sectionAddress1[5] = [ "公寓" ]
sectionAddress1[6] = [ "别墅" ]
sectionAddress1[7] = [ "其他" ]

var sectionAddress2 = new Array();
sectionAddress2[0] = [ "具体处所" ]
sectionAddress2[1] = [ "公司" ]
sectionAddress2[2] = [ "厂矿企业" ]
sectionAddress2[3] = [ "事业单位" ]
sectionAddress2[4] = [ "党政机关" ]
sectionAddress2[5] = [ "办公场所" ]
sectionAddress2[6] = [ "其他" ]
var sectionAddress3 = new Array();
sectionAddress3[0] = [ "具体处所" ]
sectionAddress3[1] = [ "商铺" ]
sectionAddress3[2] = [ "店面" ]
sectionAddress3[3] = [ "娱乐场所" ]
sectionAddress3[4] = [ "酒店宾馆" ]
sectionAddress3[5] = [ "网吧" ]
sectionAddress3[6] = [ "餐馆" ]
sectionAddress3[7] = [ "市场" ]
sectionAddress3[8] = [ "医院" ]
sectionAddress3[9] = [ "其他" ]

var sectionAddress4 = new Array();
sectionAddress4[0] = [ "具体处所" ]
sectionAddress4[1] = [ "仓库" ]
sectionAddress4[2] = [ "路边" ]
sectionAddress4[3] = [ "山上" ]
sectionAddress4[4] = [ "工地" ]
sectionAddress4[5] = [ "池塘河内" ]
sectionAddress4[6] = [ "其他" ]

var chapterAddressArr = new Array();
chapterAddressArr[0] = [ "选择处所", "", sectionAddress0 ];
chapterAddressArr[1] = [ "居民住宅", "居民住宅", sectionAddress1 ];
chapterAddressArr[2] = [ "单位场所", "单位场所", sectionAddress2 ];
chapterAddressArr[3] = [ "服务行业", "服务行业", sectionAddress3 ];
chapterAddressArr[4] = [ "其它处所", "其它处所", sectionAddress4 ];

function setSectionmAddress(chapter) {
	$('.specific_space').empty();
	var length = chapterAddressArr[chapter][2].length;
	for (var i = 0; i < length; i++) {
		$('.specific_space').append("<option value='" + chapterAddressArr[chapter][2][i] + "'>" + chapterAddressArr[chapter][2][i] + "</option>");
	}
}

// -------------------------------------------------立案与否
function buildCase_chose(obj) {
	$('input[name="case1.case_register"]').val($(obj).val());
}

//日期扩展
Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, //月份 
		"d+" : this.getDate(), //日 
		"h+" : this.getHours(), //小时 
		"m+" : this.getMinutes(), //分 
		"s+" : this.getSeconds(), //秒 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
		"S" : this.getMilliseconds() //毫秒 
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}