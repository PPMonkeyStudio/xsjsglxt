/*
 * 死因鉴定
 */
function Create_Death_InspectionRecord(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-pencil-square-o',
				title : '尸体检验记录',
				content : '<input value="'
						+ obj.id
						+ '"  class="form-control" id="create_death_inspection_record_belong_entrustment_book" style="display:none;"/>'
						+ '<hr>'
						+ '<table  class="table table-bordered" style="text-align: center;">'
						+ '<tbody>'
						+ '<tr>'
						+ '<td style="width:200px;">承办人员：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_undertake_personnel" /></td>'
						+ '<td style="width:200px;">联系电话：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_phone" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>死者姓名：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_death_name" /></td>'
						+ '<td>性别：</td>'
						+ '<td><select class="form-control" id="create_death_inspection_record_death_sex">'
						+ '<option value="男">男</option>'
						+ '<option value="女">女</option>'
						+ '</select></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>出生日期：</td>'
						+ '<td><input  class="form-control mydate" id="create_death_inspection_record_death_birth_date" /></td>'
						+ '<td>民族：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_private_capital" value="汉"/></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>服务处所：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_unit_service" /></td>'
						+ '<td>住址：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_address" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>检验人：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_inspector" /></td>'
						+ '<td>检验地点：</td>'
						+ '<td><input  class="form-control " id="create_death_inspection_record_inspect_place" value="萍乡市公安局安源分局解剖室"/></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>检验开始时间：</td>'
						+ '<td ><input  class="form-control mydate_minute" id="create_death_inspection_record_inspect_time"  /></td>'
						+ '<td>检验结束时间：</td>'
						+ '<td ><input  class="form-control mydate_minute" id="create_death_inspection_record_inspect_stop_time"  /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>检验环境温度：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_inspect_ambient_temperature" value="23摄氏度" /></td>'
						+ '<td>检验环境湿度：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_ambient_humidity" value="30％RH" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>现场尸体与血迹概况（尸体所处地点、位置、姿势及与周围环境相互关系等）：</td>'
						+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control" id="create_death_inspection_record_site_profile"  >死者平躺于萍乡市公安局安源分局解剖室解剖台</textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>尸体衣着、饰物、随身物品性状与数量及其它物品：</td>'
						+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control" id="create_death_inspection_record_death_clothing"  >死者上着黄色T恤 ，黄色运动短裤，赤足。运动短裤口袋空虚。</textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>随身物品移交情况：</td>'
						+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control" id="create_death_inspection_record_handover_of_goods"  ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>接收物品人员：</td>'
						+ '<td colspan="3"><input  class="form-control" id="create_death_inspection_record_receiver_goods" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>备注：</td>'
						+ '<td colspan="3"><textarea style="resize: none;height:100px;" class="form-control" id="create_death_inspection_record_mark"  ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>尸表检验：</td>'
						+ '<td colspan="3"><textarea style="resize: none;height:500px;" class="form-control" id="create_death_inspection_record_autopsy_surface_table_test"  >'
						+ '尸长：175 厘米；肤色：黄；发育：正常；营养：中等；'
						+ '\n尸斑：暗红色，位于：位于项、背、腰部未受压处；指压：稍褪色；'
						+ '\n尸僵：颌形成；颈形成；上肢形成；下肢形成；强度：强 ；'
						+ '\n尸温：第1次8时30分27℃；第2次9时30分26.4℃；'
						+ '\n尸体检验环境温度：23℃；尸体检验环境相对湿度：50％RH；'
						+ '\n腐败征象：无；'
						+ '\n'
						+ '\n头面部：'
						+ '\n      头发：黑色；发型：平头；顶部发长：3厘米；'
						+ '\n      面部：黄褐色；角膜：轻度浑浊；瞳孔：左0.6 厘米，右0.6 厘米；'
						+ '\n      双眼闭合：是；球睑结合膜：左无出血点，右无出血点；'
						+ '\n      耳廓：无损伤；外耳道：左通畅，无异物，右通畅，无异物；'
						+ '\n      外鼻：无损伤。'
						+ '\n      鼻腔：无损伤'
						+ '\n      口唇：无损伤'
						+ '\n      口腔：无损伤'
						+ '\n      舌：无损伤'
						+ '\n      牙齿：无损伤'
						+ '\n      齿龈：无损伤'
						+ '\n      其他：右头顶部见2×2cm头皮红肿。'
						+ '\n'
						+ '\n颈项部：无损伤。'
						+ '\n'
						+ '\n胸部：右胸部见一6×0.1cm表皮剥脱。'
						+ '\n'
						+ '\n腹部：未见损伤。'
						+ '\n'
						+ '\n背臀部：未见损伤。'
						+ '\n'
						+ '\n四肢：'
						+ '\n      左手背见四处分别为2*0.2cm、0.3*0.3cm、0.2*0.2cm、0.5×0.1cm表皮剥脱。'
						+ '\n      左拇指背侧指间关节处见两处分别为0.6×0.6cm、0.2×0.2cm表皮剥脱。'
						+ '\n      左膝部见3×3cm皮肤青紫。'
						+ '\n      左下肢内踝部见2×2cm皮肤青紫。'
						+ '\n'
						+ '\n会阴部：无损伤。'
						+ '\n'
						+ '\n生殖器：无损伤。'
						+ '\n'
						+ '\n肛门：无损伤。'
						+ '\n'
						+ '\n其他尸表所见特征与标记、附着物、法医昆虫学等内容：无'
						+ '</textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>尸表记录人：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_autopsy_surface_table_test_recorder" /></td>'
						+ '<td>尸表记录时间：</td>'
						+ '<td><input  class="form-control mydate" id="create_death_inspection_record_autopsy_surface_table_test_recorder_time" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>解剖检验：</td>'
						+ '<td colspan="3"><textarea style="resize: none;height:500px;" class="form-control" id="create_death_inspection_record_anatomic_test"  >'
						+ '\n头皮：右颞、顶部见6×5cm头皮下出血。'
						+ '\n颞肌：左：无出血，右：5×5cm出血。'
						+ '\n帽状腱膜：无出血。'
						+ '\n颅盖：无骨折。'
						+ '\n颅底：无骨折。'
						+ '\n面颅：无骨折。'
						+ '\n硬膜外：无出血。'
						+ '\n硬脑膜：无破损。'
						+ '\n硬膜下：无异常。'
						+ '\n蛛网膜下腔：无异常。'
						+ '\n全脑重1325克'
						+ '\n脑沟回：无异常。'
						+ '\n脑血管：无异常。'
						+ '\n各脑室：正常。'
						+ '\n大脑：无异常 。'
						+ '\n小脑：无异常 。'
						+ '\n脑干：无异常 。'
						+ '\n脑垂体：无异常 。'
						+ '\n颈部皮下组织：无出血。'
						+ '\n颈部肌肉：无出血。'
						+ '\n颈部大血管：无异常 。'
						+ '\n甲状腺：无异常 。'
						+ '\n颌下腺：无异常 。'
						+ '\n舌骨：无骨折。'
						+ '\n甲状软骨：无骨折 。'
						+ '\n环状软骨：无异常 。'
						+ '\n会厌：无异常 。'
						+ '\n咽喉粘膜：无充血。'
						+ '\n喉头：  无异常 。'
						+ '\n扁桃体：无异常 。'
						+ '\n椎前筋膜：无异常 。'
						+ '\n颈椎：无异常 。'
						+ '\n胸壁：无异常 。'
						+ '\n胸骨：无骨折 。'
						+ '\n肋骨：无骨折 。'
						+ '\n胸膜：无异常 。'
						+ '\n胸腔：左无异常 。右无异常 。'
						+ '\n胸腺：已萎缩，重克'
						+ '\n心包：无异常 。心包腔：无异常 。'
						+ '\n心脏：重390 克，外观无异常 。'
						+ '\n      外膜：无异常 。内膜：无异常 。'
						+ '\n      左心室厚 1.6厘米；右心室厚  0.4 厘米；室间隔厚0.2厘米。'
						+ '\n      心肌：'
						+ '\n      心腔：'
						+ '\n      三 尖 瓣：周径，正常；瓣膜情，况无异常 。'
						+ '\n      肺动脉瓣：周径，正常；瓣膜情况，无异常 。'
						+ '\n      二 尖 瓣：周径，正常；瓣膜情况，无异常 。'
						+ '\n      主动脉瓣：周径，正常；瓣膜情况，无异常 。'
						+ '\n      大 血 管：正常'
						+ '\n      冠状动脉口：左，正常；右，轻度狭窄。'
						+ '\n      冠状动脉：右冠状动脉管壁增厚、管腔轻度狭窄，左冠状动脉前降支、左旋支4级狭窄。'
						+ '\n气管：正常。'
						+ '\n支气管（左）：无异常；（右）：无异常。'
						+ '\n左肺：重690克，表面：光滑，质地：实，切面：淤血状。'
						+ '\n右肺：重790 克，表面：光滑， 质地：实，切面：淤血状。'
						+ '\n'
						+ '\n腹壁：无异常'
						+ '\n腹腔：无异常'
						+ '\n腹膜：无异常'
						+ '\n网膜：无异常'
						+ '\n器官位置：无异常'
						+ '\n食道：无异常'
						+ '\n胃内容物： '
						+ '\n      性状： 乳糜状'
						+ '\n      量：150克'
						+ '\n      成份：不可分辨。'
						+ '\n胃粘膜：无异常'
						+ '\n肠管：无异常'
						+ '\n肠系膜：无异常'
						+ '\n胰腺：重1250克；颜色：正常；切面：无异常'
						+ '\n肝脏：重1250克；表面：光滑；切面：无异常；胆囊：无异常'
						+ '\n脾脏：重量150克；被膜：包膜紧张；表面：光滑；切面：淤血貌。'
						+ '\n左肾：重量120克；被膜：无异常；表面：光滑；切面：皮髓质界限尚清，无异常。'
						+ '\n右肾：重量120克；被膜：无异常；表面：光滑；切面：皮髓质界限尚清，无异常。'
						+ '\n输尿管：无异常。'
						+ '\n肾上腺：'
						+ '\n      左，无异常。'
						+ '\n      右，无异常。'
						+ '\n膀胱：尿量50毫升；颜色：黄；浊度：清亮。'
						+ '\n子宫：'
						+ '\n宫颈：'
						+ '\n宫腔：'
						+ '\n内膜：'
						+ '\n输卵管及卵巢：'
						+ '\n睾丸及附睾：无异常。'
						+ '\n'
						+ '\n脊柱、脊髓、四肢等局部解剖：无异常。'
						+ '\n'
						+ '\n其他特殊尸体检验：无。'
						+ '</textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>解剖时间：</td>'
						+ '<td><input  class="form-control mydate_minute" id="create_death_inspection_record_anatomic_time" /></td>'
						+ '<td>解剖地点：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_anatomic_place" value="萍乡市公安局安源分局解剖室"/></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>尸体检验拍照人：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_autopsy_table_test_photographer" /></td>'
						+ '<td>尸体检验录像人：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_autopsy_table_test_video" /></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>尸体检验记录人：</td>'
						+ '<td><input  class="form-control" id="create_death_inspection_record_autopsy_table_test_recorder" /></td>'
						+ '<td>尸体检验记录时间：</td>'
						+ '<td><input  class="form-control mydate" id="create_death_inspection_record_autopsy_table_test_recorder_time" /></td>'
						+ '</tr>' + '</tbody>' + '</table>' + '<hr>',
				type : 'blue',
				columnClass : 'col-md-12',
				onOpenBefore : function() {
				},
				onContentReady : function() {
					for (var num = 0; num < json_list.listEntrustmentBookManagementDTO.length; num++) {
						if (obj.id == json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.xsjsglxt_check_entrustment_book_id) {
							break;
						}
					}

					/*
					 * 
					 */
					var date = new Date();
					document
							.getElementById("create_death_inspection_record_inspect_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate()
							+ ' '
							+ (date.getHours() < 10 ? '0' + date.getHours()
									: date.getHours())
							+ ':'
							+ (date.getMinutes() < 10 ? '0' + date.getMinutes()
									: date.getMinutes());
					document
							.getElementById("create_death_inspection_record_inspect_stop_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate()
							+ ' '
							+ (date.getHours() < 10 ? '0' + date.getHours()
									: date.getHours())
							+ ':'
							+ (date.getMinutes() < 10 ? '0' + date.getMinutes()
									: date.getMinutes());
					document
							.getElementById("create_death_inspection_record_autopsy_surface_table_test_recorder_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
					document
							.getElementById("create_death_inspection_record_anatomic_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate()
							+ ' '
							+ (date.getHours() < 10 ? '0' + date.getHours()
									: date.getHours())
							+ ':'
							+ (date.getMinutes() < 10 ? '0' + date.getMinutes()
									: date.getMinutes());
					document
							.getElementById("create_death_inspection_record_autopsy_table_test_recorder_time").value = date
							.getFullYear()
							+ '-'
							+ (parseInt(date.getMonth()) + 1)
							+ '-'
							+ date.getDate();
					/*
					 * 
					 */
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
					$('.mydate_minute').datetimepicker({
						yearStart : 1990, // 设置最小年份
						yearEnd : 2050, // 设置最大年份
						yearOffset : 0, // 年偏差
						timepicker : true, // 关闭时间选项
						format : 'Y-m-d H:i', // 格式化日期年-月-日
						minDate : '1990/01/01', // 设置最小日期
						maxDate : '2030/01/01', // 设置最大日期
					});

					/*
					 * 
					 */

				},
				buttons : {
					'记录' : {
						btnClass : 'btn-blue',
						action : function() {
							addDeathInspectionRecord(jc);
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function addDeathInspectionRecord(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("记录成功");
					jc.close();
					List_EntrustmentBook(1);
				} else {
					toastr.error("填写格式错误");
				}
			} else {
				toastr.error(xhr.status);
			}
		}
	}
	/*
	 * 
	 */
	var formData = new FormData();
	/*
	 * 所属委托书
	 */
	var create_death_inspection_record_belong_entrustment_book = document
			.getElementById("create_death_inspection_record_belong_entrustment_book");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_belong_entrustment_book",
					create_death_inspection_record_belong_entrustment_book.value);
	/*
	 * 承办人员
	 */
	var create_death_inspection_record_undertake_personnel = document
			.getElementById("create_death_inspection_record_undertake_personnel");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_undertake_personnel",
					create_death_inspection_record_undertake_personnel.value);
	/*
	 * 联系电话
	 */
	var create_death_inspection_record_phone = document
			.getElementById("create_death_inspection_record_phone");
	formData.append("deathInspectionRecord.death_inspection_record_phone",
			create_death_inspection_record_phone.value);
	/*
	 * 死者姓名
	 */
	var create_death_inspection_record_death_name = document
			.getElementById("create_death_inspection_record_death_name");
	formData.append("deathInspectionRecord.death_inspection_record_death_name",
			create_death_inspection_record_death_name.value);
	/*
	 * 性别
	 */
	var create_death_inspection_record_death_sex = document
			.getElementById("create_death_inspection_record_death_sex");
	formData.append("deathInspectionRecord.death_inspection_record_death_sex",
			create_death_inspection_record_death_sex.value);
	/*
	 * 出生日期
	 */
	var create_death_inspection_record_death_birth_date = document
			.getElementById("create_death_inspection_record_death_birth_date");
	formData.append(
			"deathInspectionRecord.death_inspection_record_death_birth_date",
			create_death_inspection_record_death_birth_date.value);
	/*
	 * 民族
	 */
	var create_death_inspection_record_private_capital = document
			.getElementById("create_death_inspection_record_private_capital");
	formData.append(
			"deathInspectionRecord.death_inspection_record_private_capital",
			create_death_inspection_record_private_capital.value);
	/*
	 * 服务处所
	 */
	var create_death_inspection_record_unit_service = document
			.getElementById("create_death_inspection_record_unit_service");
	formData.append(
			"deathInspectionRecord.death_inspection_record_unit_service",
			create_death_inspection_record_unit_service.value);
	/*
	 * 住址
	 */
	var create_death_inspection_record_address = document
			.getElementById("create_death_inspection_record_address");
	formData.append("deathInspectionRecord.death_inspection_record_address",
			create_death_inspection_record_address.value);
	/*
	 * 检验人
	 */
	var create_death_inspection_record_inspector = document
			.getElementById("create_death_inspection_record_inspector");
	formData.append("deathInspectionRecord.death_inspection_record_inspector",
			create_death_inspection_record_inspector.value);
	/*
	 * 检验开始时间
	 */
	var create_death_inspection_record_inspect_time = document
			.getElementById("create_death_inspection_record_inspect_time");
	formData.append(
			"deathInspectionRecord.death_inspection_record_inspect_time",
			create_death_inspection_record_inspect_time.value);
	/*
	 * 检验结束时间
	 */
	var create_death_inspection_record_inspect_stop_time = document
			.getElementById("create_death_inspection_record_inspect_stop_time");
	formData.append(
			"deathInspectionRecord.death_inspection_record_inspect_stop_time",
			create_death_inspection_record_inspect_stop_time.value);
	/*
	 * 检验地点
	 */
	var create_death_inspection_record_inspect_place = document
			.getElementById("create_death_inspection_record_inspect_place");
	formData.append(
			"deathInspectionRecord.death_inspection_record_inspect_place",
			create_death_inspection_record_inspect_place.value);
	/*
	 * 检验环境温度
	 */
	var create_death_inspection_record_inspect_ambient_temperature = document
			.getElementById("create_death_inspection_record_inspect_ambient_temperature");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_inspect_ambient_temperature",
					create_death_inspection_record_inspect_ambient_temperature.value);
	/*
	 * 检验环境湿度
	 */
	var create_death_inspection_record_ambient_humidity = document
			.getElementById("create_death_inspection_record_ambient_humidity");
	formData.append(
			"deathInspectionRecord.death_inspection_record_ambient_humidity",
			create_death_inspection_record_ambient_humidity.value);
	/*
	 * 现场尸体与血迹概况（尸体所处地点、位置、姿势及与周围环境相互关系等）
	 */
	var create_death_inspection_record_site_profile = document
			.getElementById("create_death_inspection_record_site_profile");
	formData.append(
			"deathInspectionRecord.death_inspection_record_site_profile",
			create_death_inspection_record_site_profile.value);
	/*
	 * 尸体衣着、饰物、随身物品性状与数量及其它物品
	 */
	var create_death_inspection_record_death_clothing = document
			.getElementById("create_death_inspection_record_death_clothing");
	formData.append(
			"deathInspectionRecord.death_inspection_record_death_clothing",
			create_death_inspection_record_death_clothing.value);
	/*
	 * 随身物品移交情况
	 */
	var create_death_inspection_record_handover_of_goods = document
			.getElementById("create_death_inspection_record_handover_of_goods");
	formData.append(
			"deathInspectionRecord.death_inspection_record_handover_of_goods",
			create_death_inspection_record_handover_of_goods.value);
	/*
	 * 接收物品人员
	 */
	var create_death_inspection_record_receiver_goods = document
			.getElementById("create_death_inspection_record_receiver_goods");
	formData.append(
			"deathInspectionRecord.death_inspection_record_receiver_goods",
			create_death_inspection_record_receiver_goods.value);
	/*
	 * 备注
	 */
	var create_death_inspection_record_mark = document
			.getElementById("create_death_inspection_record_mark");
	formData.append("deathInspectionRecord.death_inspection_record_mark",
			create_death_inspection_record_mark.value);
	/*
	 * 尸表检验
	 */
	var create_death_inspection_record_autopsy_surface_table_test = document
			.getElementById("create_death_inspection_record_autopsy_surface_table_test");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_surface_table_test",
					create_death_inspection_record_autopsy_surface_table_test.value);
	/*
	 * 尸表检验记录人
	 */
	var create_death_inspection_record_autopsy_surface_table_test_recorder = document
			.getElementById("create_death_inspection_record_autopsy_surface_table_test_recorder");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_surface_table_test_recorder",
					create_death_inspection_record_autopsy_surface_table_test_recorder.value);
	/*
	 * 尸表检验记录时间
	 */
	var create_death_inspection_record_autopsy_surface_table_test_recorder_time = document
			.getElementById("create_death_inspection_record_autopsy_surface_table_test_recorder_time");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_surface_table_test_recorder_time",
					create_death_inspection_record_autopsy_surface_table_test_recorder_time.value);

	/*
	 * 尸表检验图
	 */
	var create_death_inspection_record_autopsy_table_test_picture1 = document
			.getElementById("create_death_inspection_record_autopsy_table_test_picture1");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_table_test_picture1",
					"");
	var create_death_inspection_record_autopsy_table_test_picture2 = document
			.getElementById("create_death_inspection_record_autopsy_table_test_picture2");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_table_test_picture2",
					"");
	var create_death_inspection_record_autopsy_table_test_picture3 = document
			.getElementById("create_death_inspection_record_autopsy_table_test_picture3");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_table_test_picture3",
					"");
	/*
	 * 解剖检验
	 */
	var create_death_inspection_record_anatomic_test = document
			.getElementById("create_death_inspection_record_anatomic_test");
	formData.append(
			"deathInspectionRecord.death_inspection_record_anatomic_test",
			create_death_inspection_record_anatomic_test.value);
	/*
	 * 解剖时间
	 */
	var create_death_inspection_record_anatomic_time = document
			.getElementById("create_death_inspection_record_anatomic_time");
	formData.append(
			"deathInspectionRecord.death_inspection_record_anatomic_time",
			create_death_inspection_record_anatomic_time.value);
	/*
	 * 解剖地点
	 */
	var create_death_inspection_record_anatomic_place = document
			.getElementById("create_death_inspection_record_anatomic_place");
	formData.append(
			"deathInspectionRecord.death_inspection_record_anatomic_place",
			create_death_inspection_record_anatomic_place.value);
	/*
	 * 尸体检验拍照人
	 */
	var create_death_inspection_record_autopsy_table_test_photographer = document
			.getElementById("create_death_inspection_record_autopsy_table_test_photographer");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_table_test_photographer",
					create_death_inspection_record_autopsy_table_test_photographer.value);
	/*
	 * 尸体检验录像人
	 */
	var create_death_inspection_record_autopsy_table_test_video = document
			.getElementById("create_death_inspection_record_autopsy_table_test_video");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_table_test_video",
					create_death_inspection_record_autopsy_table_test_video.value);
	/*
	 * 尸体检验记录人
	 */
	var create_death_inspection_record_autopsy_table_test_recorder = document
			.getElementById("create_death_inspection_record_autopsy_table_test_recorder");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_table_test_recorder",
					create_death_inspection_record_autopsy_table_test_recorder.value);
	/*
	 * 尸体检验记录时间
	 */
	var create_death_inspection_record_autopsy_table_test_recorder_time = document
			.getElementById("create_death_inspection_record_autopsy_table_test_recorder_time");
	formData
			.append(
					"deathInspectionRecord.death_inspection_record_autopsy_table_test_recorder_time",
					create_death_inspection_record_autopsy_table_test_recorder_time.value);
	/*
	 * 解剖检验图
	 */
	var create_death_inspection_record_anatomy_picture1 = document
			.getElementById("create_death_inspection_record_anatomy_picture1");
	formData.append(
			"deathInspectionRecord.death_inspection_record_anatomy_picture1",
			"");
	var create_death_inspection_record_anatomy_picture2 = document
			.getElementById("create_death_inspection_record_anatomy_picture2");
	formData.append(
			"deathInspectionRecord.death_inspection_record_anatomy_picture2",
			"");
	var create_death_inspection_record_anatomy_picture3 = document
			.getElementById("create_death_inspection_record_anatomy_picture3");
	formData.append(
			"deathInspectionRecord.death_inspection_record_anatomy_picture3",
			"");
	/*
	 * 
	 */
	xhr
			.open(
					"POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addDeathInspectionRecord");
	xhr.send(formData);
}