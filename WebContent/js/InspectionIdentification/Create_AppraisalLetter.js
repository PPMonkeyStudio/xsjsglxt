function Create_AppraisalLetter(obj) {
	var json_list = EntrustmentBook_json;
	var jc = $
			.confirm({
				icon : 'fa fa-pencil-square-o',
				title : '',
				content : '<form id="form_AppraisalLetter"><input value="'
						+ obj.id
						+ '"  class="form-control" name="appraisalLetter.appraisal_letter_belong_entrustment_book"  style="display:none;"/>'
						+ '<hr>'
						+ '<table  class="table table-bordered" style="text-align: center;"><tbody>'
						+ '<tr>'
						+ '<td>案件情况摘要：</td>'
						+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_simple_case_situation" ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td id="td_appraisal_letter_sample_situation">检材和样本：</td>'
						+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_sample_situation" ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>检验：</td>'
						+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:300px;" name="appraisalLetter.appraisal_letter_inspection" ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>论证：</td>'
						+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:200px;" name="appraisalLetter.appraisal_letter_argumentation" ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>鉴定意见：</td>'
						+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_expert_opinion" ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>备注：</td>'
						+ '<td colspan="4"><textarea class="form-control" style="resize: none;height:100px;" name="appraisalLetter.appraisal_letter_expert_opinion" ></textarea></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td rowspan="2">鉴定人：</td><td>姓名：</td><td><input class="form-control" name="appraisalLetter."/></td><td>职务：</td><td><input class="form-control" name="appraisalLetter."/></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td>姓名：</td><td><input class="form-control" name="appraisalLetter."/></td><td>职务：</td><td><input class="form-control" name="appraisalLetter."/></td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td >授权签字人：</td><td>姓名：</td><td><input class="form-control" name="appraisalLetter."/></td><td>职务：</td><td><input class="form-control" name="appraisalLetter."/></td>'
						+ '</tr>' + '</tbody></table></form>' + '<hr>',
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
					document
							.getElementsByName("appraisalLetter.appraisal_letter_simple_case_situation")[0].value = json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_simple_case_situation;
					switch (json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustment_request) {
					case "损伤鉴定": {
						jc.setTitle("<p>萍乡市安源区公安司法鉴定中心</p><p>法医学人体损伤程度鉴定书</p>");
						document
								.getElementById("td_appraisal_letter_sample_situation").innerHTML = '检验对象';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_sample_situation")[0].value = '姓名：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_name
								+ '，性别：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_sex
								+ '，年龄：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_age
								+ '，家庭住址：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_address
								+ '。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_inspection")[0].value = '      （一）萍乡市中医院病历摘要（2017006297）：颜鑫，男，30岁，因刺伤致腹部疼痛1小时入院，查体：左下腹部见一大小约2×3cm伤口，深约6cm，进入腹腔，活动性出血，压痛。伤者于2017年4月22日01时50分在全麻下行剖腹探查+左下大网膜、腹膜、腹直肌修补+左下腹创扩创清创术，术中见：左下腹直肌断裂，左下腹腹膜挫裂，大小约4×5cm，大网膜挫伤，大小约2×2cm，并见活动性出血。术后诊断：腹部刺伤：左腹直肌断裂、腹膜挫裂、大网膜挫伤。'
								+ '\n      （二）检验所见：神清，问答切题，卧于病床。左下腹见一10.5CM纵行手术扩创口，创口已缝合。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_argumentation")[0].value = '      伤者因锐器伤致腹壁穿透伤、左腹直肌断裂、腹膜挫裂、大网膜挫伤，并行手术治疗，手术扩创口长度长达10.5cm。根据赣高法[2013]226号《人体损伤程度鉴定标准》第5.7.4i)、5.11.3b)之规定，已构成轻伤二级。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_expert_opinion")[0].value = '      '
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_name
								+ '的损伤程度已构成轻伤二级。';
						break;
					}
					case "死因鉴定": {
						jc.setTitle("<p>萍乡市安源区公安司法鉴定中心</p><p>法医学尸体检验报告书</p>");
						document
								.getElementById("td_appraisal_letter_sample_situation").innerHTML = '检材和样本';

						document
								.getElementsByName("appraisalLetter.appraisal_letter_sample_situation")[0].value = '姓名：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_name
								+ '，性别：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_sex
								+ '，年龄：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_age
								+ '，家庭住址：'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_address
								+ '。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_inspection")[0].value = '      本鉴定检验方法按照中华人民共和国公共行业标准《法医学尸体解剖》（GA/T147－1996）、《法医学尸表检验》（GA/T149－1996）、《机械性损伤尸体检验》（GA/T168-1997） 、《机械性窒息尸体检验》（GA/T 150-1996）、《猝死尸体的检验》（GA/T170-1997）、《中毒案件检材包装、贮存、运送及送检规则》（GA/T194-1998）、《法医病理学检材的提取、保存与送检》（GA/T148-1996）、《中毒尸体检验规范》（GA/T167-1997）'
								+ '\n      1、衣着检验：死者上着黄色T恤，黄色运动短裤，赤足。运动短裤口袋空虚。'
								+ '\n      2、尸体检验：'
								+ '\n            （１）尸表检验:男性尸体，尸长175cm，发育正常，营养良好。尸斑暗红色存在于项、背、腰未受压部，指压稍褪色。尸僵强度存在于四肢各关节。头生黑发，发长3cm。右头顶见一2×2cm头皮红肿。双眼角膜轻度浑浊，双侧瞳孔等大等圆直径0.6cm，双眼睑球结膜未见出血点。左右外耳道通畅无异常。鼻腔无损伤，口唇及口腔未见异常。右胸部见一6×0.1cm表皮剥脱。腹部未见损伤。背臀部未见损伤。左手背见四处分别为2×0.2cm、0.3×0.3cm、0.2×0.2cm、0.5×0.1cm表皮剥脱。左拇指背侧指间关节处见两处分别为0.6×0.6cm、0.2×0.2cm表皮剥脱。左膝部见3×3cm皮肤青紫。左下肢内踝部见2×2cm皮肤青紫。会阴部无损伤，生殖器无损伤，肛门无损伤。'
								+ '\n            （２）解剖检验:沿两耳后冠状切开分离头皮，见右颞、顶部6×5cm头皮下出血，右颞肌出血。打开颅腔，颅盖骨及颅底未见骨折，硬脑膜外、硬脑膜下、蛛网膜下腔未见出血。脑回无增宽，脑沟无变浅。沿颈、胸、腹切开皮肤打开胸腹腔。颈部皮肤、皮下组织、肌群未见出血，舌骨、甲状软骨未见骨折。打开胸腹腔，胸骨、肋骨未见骨折，胸腔内未见积血、积液，心、肺表面光滑，未见出血点。腹腔各脏器位置正常，未见破裂损伤，未见积血、积液。胃内见150克乳糜状内容物，胃粘膜未见出血及溃疡。打开阴囊，皮下组织及双侧睾丸未见出血。沿躯体背部中线自项部致双腿背侧打开皮肤，未见皮下组织、肌肉出血。'
								+ '\n            （３）提取检材及处理:提取全脑、全心、肝脏、两肺、两肾及肾上腺、脾、胰腺脏器组织经福尔马林液固定后进行病理检验。提取胃内容物及心血进行毒物检验。'
								+ '\n      3、病理组织学检验：㈠、心脏：心脏重390克，表面光滑，各瓣膜未见异常，左心室壁厚1.6cm，右心室壁厚0.4cm，右冠状动脉管壁增厚，管腔轻度狭窄，左冠状动脉前降支、左旋支4级狭窄。镜检见心肌细胞变性纤维化，冠状动脉内壁增厚，管腔狭窄。㈡、脑：全脑重1325克，大脑、小脑、脑干切面未见挫伤及出血灶，各脑室未见出血，脑底动脉局部硬化，镜检见血管扩张充血。㈢、肺脏：左、右肺各重690克和790克，表面光滑，切面淤血状，触之质地实，镜检见血管扩张充血。㈣、肾：左右肾均重120克，表面光滑，包膜紧张，切面呈淤血貌，镜检见：间质血管扩张充血。㈤、肝：肝脏重1250克，形态正常，表面光滑，表面及切面未见异常，镜检见：肝细胞变性。㈥、脾脏重150克，表面光滑，包膜紧张，切面呈淤血貌。镜检见血管扩张充血。㈦、胰腺：大体上未见异常，镜检见胰腺细胞自溶。㈧、肾上腺表面及实质内未见异常，镜检未见异常。'
								+ '\n      4、毒物学检验：死者胃内容物及心血未检出常见有机磷农药、安眠镇静类药物、鼠药、氢化物、一氧化氮、酒精成分。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_argumentation")[0].value = '      1、尸检见死者头皮下出血，右胸部见表皮剥脱，肢体见多处表皮剥脱及小面积软组织挫伤，颅脑、胸腹腔脏器及阴囊未见损伤及出血，未检见致命性外伤。'
								+ '\n      2、死者胃内容物及心血未检出常见有机磷农药、安眠镇静类药物、鼠药、氢化物、一氧化氮、酒精成分。可排除常见毒物中毒。'
								+ '\n      3、病理学检验见左冠状动脉前降支、左旋支4级狭窄。镜检见心肌变性纤维化，冠状动脉内壁增厚，管腔狭窄，结合尸检未检见致命性外伤及排除常见毒物中毒，分析符合冠心病猝死，情绪激动及较轻外伤可以诱发冠心病猝死。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_expert_opinion")[0].value = '      死者'
								+ json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_entrustmentor_name
								+ '符合冠心病猝死。';
						break;
					}
					case "指纹检验鉴定": {
						jc.setTitle("<p>萍乡市安源区公安司法鉴定中心</p><p>法医学尸体检验报告书</p>");
						document
								.getElementById("td_appraisal_letter_sample_situation").innerHTML = '检材和样本';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_sample_situation")[0].value = json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_sample_situation;
						// 检验
						document
								.getElementsByName("appraisalLetter.appraisal_letter_inspection")[0].value = '      本次检验采用IFSC 07-02-01-2006指纹鉴定法（公安部物证鉴定中心）'
								+ '\n      现场玻璃门上提取的指纹，用照相法加以固定，类型是斗型纹。指纹纹线较清晰，特征稳定，有鉴定价值。经细致寻找，发现稳定的细节特征10个，构成同一认定的条件。'
								+ '\n      送检犯罪嫌疑人沈裕的十指指纹捺印样本是油墨捺印，用照相法加以固定，指印纹线清晰，特征稳定，可供同一认定。'
								+ '\n      将现场指纹与沈裕的捺印十指纹进行逐一比对检验，发现丁招龙的左手中指指纹所出现的10个细节特征与现场指纹的10个细节特征相吻合，因而构成了同一认定的依据。（见照片二）';
						// 论证
						document
								.getElementsByName("appraisalLetter.appraisal_letter_argumentation")[0].value = '      '
								+ '\n      经过比对检验，现场提取的指纹和沈裕的左手中指指纹二者类型、纹线流向以及各个细节特征的大小、长短距离、位置关系均相一致，构成同一认定的客观依据。';
						// 结论
						document
								.getElementsByName("appraisalLetter.appraisal_letter_expert_opinion")[0].value = '      现场玻璃门上提取的指纹是犯罪嫌疑人沈裕所留。';
						break;
					}
					case "足迹检验鉴定": {
						jc.setTitle("<p>萍乡市安源区公安司法鉴定中心</p><p>法医学尸体检验报告书</p>");
						document
								.getElementById("td_appraisal_letter_sample_situation").innerHTML = '检材和样本';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_sample_situation")[0].value = json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_sample_situation;
						document
								.getElementsByName("appraisalLetter.appraisal_letter_inspection")[0].value = '      本次检验采用IFSC 06-01-03-2006足迹鉴定法（公安部物证鉴定中心）'
								+ '\n      1、对现场鞋印的检验：'
								+ '\n      现场鞋印系遗留在现场厨房灶台瓷砖表面的灰尘减层鞋印,无明显变形，为右脚所留。通过观察鞋印大小及花纹种类、鞋印边缘虚实部位及长短、边缘磨损块痕清晰，能够客观地反映出鞋印形象特征和特定磨损情况的稳定特征，具有鉴定价值。经检验，现场鞋印全长28.9厘米，前掌宽10.8厘米，后跟宽8.7厘米。鞋印前掌为条状波浪形花纹，后跟为波浪小花纹。进一步检验发现，在现场鞋印前掌及后跟部位发现细节特征10处（详见附件一现场照片）。'
								+ '\n      2、对样本鞋印的检验：'
								+ '\n      样本为马海小者所穿自用鞋行走的灰尘鞋印，拍照提取。鞋底花纹清晰完整，可供比对。初步检验鞋印全长28.9厘米，前掌宽10.8厘米，后跟宽8.7厘米，鞋印前掌为条状波浪形花纹，后跟为波浪小花纹。进一步检验发现，在现场鞋印前掌及后跟部位发现10处细节特征（详见附件二捺印照片）。'
								+ '\n      3、比对检验：'
								+ '\n      比较检验检材与样本，发现检材鞋印与样本鞋印大小及花纹种类相同，细节特征处反映清晰。在鞋印特征标注处，反映出鞋底具有同样的损伤特征系同一鞋所留。（详见附件三特征比对照片）。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_argumentation")[0].value = '      现场鞋印和样本鞋印，均为右脚鞋印，鞋印尺寸大小一致，鞋底花纹相同、种类同一，可供检验的特定特征系穿用形成，稳定可靠。对应位置上出现的10处特定特征形态、位置、角度、大小以及相互之间的距离均相吻合，这些特征的总合反映了两者之间具有本质上的同一，是其他鞋所不能重复出现，完全构成了同一认定的客观依据（详见附件三特征比对照片）。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_expert_opinion")[0].value = '      送检的的现场鞋印是马海小者右脚鞋所留。';
						break;
					}
					case "整体分离检验鉴定": {
						jc.setTitle("<p>萍乡市安源区公安司法鉴定中心</p><p>法医学尸体检验报告书</p>");
						document
								.getElementById("td_appraisal_letter_sample_situation").innerHTML = '检材和样本';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_sample_situation")[0].value = json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_sample_situation;
						document
								.getElementsByName("appraisalLetter.appraisal_letter_inspection")[0].value = '      本次检验采用JXPX-06-3004-2010整体分离鉴定法（公安物证鉴定中心）'
								+ '\n      检材是事故现场提取的一块长6.8cm的不规则黑色塑料残片，正面呈平面状，背面呈凹状，有陈旧的灰尘附着痕迹（详见检验照片一）。'
								+ '\n      样本是赣J34199客车车头上提取的一块长3.1cm的不规则黑色色塑料残片，正面平面状，背面呈凹状，有陈旧的灰尘附着痕迹（详见检验照片一）。'
								+ '\n      比较检验检材与样本发现两者颜色、质地、新旧程度及灰尘附着情形相同。'
								+ '\n      将检材与样本的分离缘进行拼接，分离缘凹凸互补，一一对应，分离线相互吻合（详见检验照片二）。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_argumentation")[0].value = '      检材与样本的颜色、质地和新旧程度相同，分离缘吻合完好，具有排它性，两者原属于同一整体。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_expert_opinion")[0].value = '      送检的赣J34199客车上提取的一块塑料残片与事故现场提取的一块塑料残片两者原属于是同一整体。';
						break;
					}
					case "车辆痕迹检验鉴定": {
						jc.setTitle("<p>萍乡市安源区公安司法鉴定中心</p><p>法医学尸体检验报告书</p>");
						document
								.getElementById("td_appraisal_letter_sample_situation").innerHTML = '检材和样本';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_sample_situation")[0].value = json_list.listEntrustmentBookManagementDTO[num].xsjsglxt_check_entrustment_book.check_entrustment_book_sample_situation;
						document
								.getElementsByName("appraisalLetter.appraisal_letter_inspection")[0].value = '      本次检验采用IFSC 06-02-02-2006车体痕迹鉴定法（公安部物证鉴定中心）'
								+ '\n      （一）赣J93Q97是一辆银灰色豪爵铃木踏板车，长1900mm、宽620mm、高1250mm、重120KG,对豪爵铃木踏板车的检验发现：'
								+ '\n            前轮：三根轮辐断裂。'
								+ '\n            踏板车左侧：前端保险杠见擦划痕，后端保险杠上见擦划痕，车身尾部上见擦划痕，后视镜与车分离，发动机上见擦划痕。'
								+ '\n            踏板车右侧：前轮轴杆上距地22.5cm处见擦划痕，前端保险杠上距地61cm处见长20cm擦划痕，踏脚板处保险杠上距地40cm处见“8×2.5cm”向内凹陷痕，中边条距地33cm处见17cm断裂痕，距地33cm处见长24cm擦划痕。'
								+ '\n      （二）赣J9J210是一辆银灰色五羊本田踏板车，长2000mm、宽640mm、高1300mm、重116KG,对五羊本田踏板车的检验发现：'
								+ '\n            踏板车左侧：发动机上距地高22cm处见“3×0.3cm”向内凹陷痕；后端保险杠上见擦划痕迹；前端保险杠上见擦划痕迹，左转向灯处见擦划痕迹，启动杆向外侧发生严重形变，距地高23.5cm处见“0.1×0.1cm”。'
								+ '\n            踏板车右侧：未见新鲜痕迹。'
								+ '\n            踏板车尾部：车牌上见“11×5cm”擦划痕。'
								+ '\n      （三）赣K69935是一辆黄色江淮格尔发K3X后八轮工程车，长10545mm、宽2495mm、高3500mm、重15900KG,对江淮格尔发K3X后八轮工程车的检验发现：'
								+ '\n            后八轮工程车未见擦划、碰撞痕迹。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_argumentation")[0].value = '      赣J93Q97二轮踏板摩托车右侧前轮轴杆上的痕迹、右侧前端保险杠上的痕迹、右侧踏脚板处保险杠上的痕迹、右侧中边条上的痕迹、前轮三根轮辐断裂痕迹与赣J9J210二轮踏板摩托左侧车尾部发动机、左侧启动杆、尾部牌照处痕迹，位置、高度相当。分析系赣J93Q97二轮踏板摩托车与赣J9J210二轮踏板摩托车追尾形成。'
								+ '\n      赣J93Q97二轮踏板摩托车左侧前端保险杠上痕迹，左侧后端保险杠上痕迹，左侧车身尾部上痕迹，左侧发动机上痕迹，左侧后视镜与车分离和赣J9J210二轮踏板摩托车左侧后端保险杠上痕迹，左侧前端保险杠上痕迹，左转向灯处痕迹，分析系倒地形成。'
								+ '\n      赣K69935后八轮工程车上未见明显撞击痕迹，分析赣J93Q97二轮踏板摩托车与赣K69935后八轮工程车未发生接触性碰撞。';
						document
								.getElementsByName("appraisalLetter.appraisal_letter_expert_opinion")[0].value = '      1、赣J93Q97二轮踏板摩托车与赣J9J210二轮踏板摩托车发生追尾碰撞。'
								+ '\n      2、赣J93Q97二轮踏板摩托车与赣K69935后八轮工程车未发生接触性碰撞。';
						break;
					}
					default: {
						jc.setTitle("<p>萍乡市安源区公安司法鉴定中心</p><p>鉴定书</p>");
						break;
					}
					}
				},
				buttons : {
					'记录' : {
						btnClass : 'btn-blue',
						action : function() {
							/*
							 * 
							 */
							jc.showLoading(false);
							/*
							 * 
							 */
							addAppraisalLetter(jc);
						}
					},
					'放弃' : function() {
					}
				}
			});
}

function addAppraisalLetter(jc) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				console.debug(xhr.responseText);
				if (xhr.responseText == 1) {
					toastr.success("已出具鉴定文书");
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
	var formData = new FormData(document.getElementById("form_AppraisalLetter"));
	/*
	 * 
	 */
	xhr
			.open("POST",
					"/xsjsglxt/inspectionIdentific/EntrustmentBookManagement_addAppraisalLetter");
	xhr.send(formData);
}