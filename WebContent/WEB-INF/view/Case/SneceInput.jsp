<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'SneceInput.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>css/Case/table.css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<!--  -->
		<!---------------------------------------------------------------------------------------------------->
		<!---------------------------------------------------------------------------------------------------->
		<div class="panel" style="width: 95% margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">现场录入</h3>
			</div>
			<button
				style="margin-top: 6px; margin-left:20px; float: left; position: absolute;"
				onclick="javascript:history.go(-1)" type="button"
				class="btn btn-default">
				<i class="fa fa-reply"></i> 返回列表
			</button>
			<!--  -->
			<div class="panel-body">
				<form id="sneceInformation" action="">
					<table>
						<tr>
							<td>勘探编号</td>
							<td><input style="font-size: 12px;"
								name="sence.snece_inquestId" class="form-control" type="text"></td>
							<td style="padding-left:5px;">勘探系统编号</td>
							<td><input name="sence.snece_inquestSystemId"
								class="form-control" type="text"></td>
							<td>案件分类</td>
							<td><select name="Case.case_classify" class=" form-control">
									<option value="" selected></option>
									<option value="非刑事案件">非刑事案件</option>
									<option value="刑事案件">刑事案件</option>
									<option value="非正常死亡">非正常死亡</option>
							</select></td>
						</tr>
						<tr>
							<td>接警时间</td>
							<td><input name="Case.case_receivingAlarmDate"
								class="form-control" style="margin-top: 6px;" type="text"></td>
							<td>危害程度</td>
							<td><select name="Case.case_extentOfInjury"
								class="form-control" style="margin-top: 6px;">
									<option selected></option>
									<option>一般</option>
									<option>重大</option>
									<option>特大</option>
									<option>特大</option>
							</select></td>
							<td>是否立案</td>
							<td><label style="float: left;" class="fancy-radio">
									<input name="register" onclick="buildCase_chose(this)"
									type="radio" value="1"> <span><i></i>是</span>
							</label><label style="float: left; margin-left: 10px;"
								class="fancy-radio"> <input name="register"
									onclick="buildCase_chose(this)" type="radio" value="2">
									<span><i></i>否</span>
							</label> <input type="hidden" name="Csae.case_register"></td>
						</tr>
						<tr>
							<td>案发地点</td>
							<td colspan="3"><input name="Case.case_address"
								style="margin-top: 6px;" class="case_place form-control"
								type="text" value="萍乡市安源区"></td>

							<td rowspan="2">案件类别</td>
							<td rowspan="2"><select name="Case.case_totalCategory"
								name="case_class1" onchange="setSectionCase(this.selectedIndex)"
								class="main_case form-control"><option
										selected="selected" value="">请选择案件总类别</option>
									<option value="盗窃案">盗窃案</option>
									<option value="抢劫案">抢劫案</option>
									<option value="抢夺案">抢夺案</option>
									<option value="强奸案">强奸案</option>
									<option value="绑架案">绑架案</option>
									<option value="杀人案">杀人案</option>
									<option value="故意伤害案">故意伤害案</option>
									<option value="爆炸案">爆炸案</option>
									<option value="放火案">放火案</option>
									<option value="非法拘禁案">非法拘禁案</option>
									<option value="非正常死亡">非正常死亡</option>
									<option value="故意损坏公私财物">故意损坏公私财物</option>
									<option value="其它">其它</option></select> <select
								name="Case.case_sonCategory" style="margin-top: 6px;"
								class="other_case form-control">
									<option selected value="">请选择案件子类别</option>
							</select></td>
						</tr>
						<tr>
							<td>案发名称</td>
							<td colspan="3"><input name="Case.case_name"
								style="margin-top: 6px;" class="case_name form-control"
								type="text"></td>
						</tr>
					</table>
					<hr>
					<table>
						<tr>
							<td width="85">移动基站</td>
							<td><input name="sence.snece_mobileStation"
								placeholder="基站号" class="form-control" type="text"> <input
								name="sence.snece_mobileVillage" placeholder="小区号"
								style="margin-top: 6px;" class="form-control" type="text"></td>
							<td width="85">联通基站</td>
							<td><input name="sence.snece_unicomSwitchboard"
								placeholder="交换机" class="form-control" type="text"> <input
								name="sence.snece_unicomVillage" placeholder="小区号"
								style="margin-top: 6px;" class="form-control" type="text"></td>
							<td width="85">电信基站</td>
							<td><input name="sence.snece_telecomStation"
								placeholder="基站号" width="40%;" class="form-control" type="text"></td>
						</tr>
					</table>
					<hr>
					<table>
						<tr>
							<td style="height: 74;">报案人基本情况</td>
							<td colspan="5"><input style=" width: 24%;float:left; "
								name="Case.case_reporterName" class="form-control" type="text"
								placeholder="姓名"> <input
								style="width: 24%; float:left;margin-left: 6px;"
								name="Case.case_reporterSex" class="form-control" type="text"
								placeholder="年龄 "> <input
								style="width: 24%; float:left; margin-left: 6px;"
								name="Case.case_reporterJobUnit" class="form-control"
								type="text" placeholder="工作单位 "> <input
								style="width: 25%; margin-left: 6px; float: left;"
								name="Case.case_reporterPhone" class="form-control" type="text"
								placeholder="联系电话 "> <input
								style="margin-top: 6px;float: right;"
								name="Case.case_reporterAddress" class="form-control"
								type="text" placeholder="家庭住址 "></td>
						</tr>
						<tr>
							<td>简要案情</td>
							<td colspan="5"><textarea style="margin-top: 6px;"
									name="briefdetails.briefdetails_details" class="form-control"
									rows="4"></textarea></td>
						</tr>
						<tr>
							<td height="39px;">天气情况</td>
							<td><select name="sence.snece_weather"
								style="width:74px; float:left; margin-top: 6px;"
								class=" form-control" id="weather" name="weather">
									<option selected value=""></option>
									<option value="晴">晴</option>
									<option value="阴">阴</option>
									<option value="雨">雨</option>
									<option value="雪">雪</option>
									<option value="雾">雾</option>
									<option value="其他">其他</option>
							</select>
								<p style="float:left; margin-top: 6px;">温度</p> <input
								name="sence.snece_weatherTemperature"
								style="width: 50px; float:left; margin-top: 6px;"
								class="form-control" type="text">°C</td>
							<td width="85">作案时段</td>
							<td><select name="Case.case_makeTime" class=" form-control">
									<option selected value=""></option>
									<option value="昼">昼</option>
									<option value="夜">夜</option>
									<option value="上午">上午</option>
									<option value="中午">中午</option>
									<option value="下午">下午</option>
									<option value="晚上">晚上</option>
									<option value="深夜">深夜</option>
									<option value="凌晨">凌晨</option>
									<option value="其他">其他</option>
							</select></td>
							<td>发案辖区</td>
							<td><select name="Case.case_jurisdiction"
								class=" form-control">
									<option value="" selected></option>
									<option value="东大派出所">东大派出所</option>
									<option value="高坑派出所">高坑派出所</option>
									<option value="青山派出所">青山派出所</option>
									<option value="安源派出所">安源派出所</option>
									<option value="八一派出所">八一派出所</option>
									<option value="白源派出所">白源派出所</option>
									<option value="城郊派出所">城郊派出所</option>
									<option value="丹江派出所">丹江派出所</option>
									<option value="凤凰派出所">凤凰派出所</option>
									<option value="后埠派出所">后埠派出所</option>
									<option value="李子园派出所">李子园派出所</option>
									<option value="五陂下派出所">五陂下派出所</option>
									<option value="其他">其他</option>
							</select></td>
						</tr>

						<tr style="margin-top: -6px;">
							<td height="78px;">作案手段</td>
							<td><select name="Case.case_makeMeans"
								onchange="setSectionmMethod(this.selectedIndex)"
								class=" crime_means form-control">
									<option selected value="作案手段">作案手段</option>
									<option value="从门侵入">从门侵入</option>
									<option value="从窗侵入">从窗侵入</option>
									<option value="攀爬侵入">攀爬侵入</option>
									<option value="洞口侵入">洞口侵入</option>
									<option value="其它">其它</option>
							</select> <select name="Case.case_concreteMakeMeans"
								style="margin-top: 6px;" class=" specific_means form-control">
									<option value="">具体手段</option>
							</select></td>
							<td>选择处所</td>
							<td><select name="Case.case_residence"
								onchange="setSectionmAddress(this.selectedIndex)"
								class=" widel_space form-control"><option selected
										value="">选择处所</option>
									<option value="居民住宅">居民住宅</option>
									<option value="单位场所">单位场所</option>
									<option value="服务行业">服务行业</option>
									<option value="其它处所">其它处所</option></select><select
								name="Case.case_concreteResidence" style="margin-top: 6px;"
								class=" specific_space form-control">
									<option value="">具体处所</option>
							</select></td>
							<td width="85">进出口</td>
							<td><select name="Case.case_exit" class=" form-control">
									<option value="" selected></option>
									<option value="窗进窗出">窗进窗出</option>
									<option value="窗进门出">窗进门出</option>
									<option value="门进门出">门进门出</option>
									<option value="门进窗出">门进窗出</option>
									<option value="洞进洞出">洞进洞出</option>
									<option value="洞进门出">洞进门出</option>
									<option value="其他">其他</option>
									<option value="无">无</option>
							</select></td>
						</tr>
						<tr>
							<!-- <td>物证编号</td>
							<td><input
								name="sneceInformation.snece_information_physicalEvidenceId"
								style="margin-top: 4px;" class="form-control" type="text"></td>
							<td>照片编号</td>
							<td><input name="" style="margin-top: 6px;"
								class="form-control" type="text"></td>
							<td>损失物品</td>
							<td><select
								name="sneceInformation.snece_information_lossArticle"
								class=" form-control" style="margin-top: 6px;">
									<option value="" selected></option>
									<option value="各类财物">各类财物</option>
									<option value="现金">现金</option>
									<option value="手机">手机</option>
									<option value="首饰">首饰</option>
									<option value="电脑">电脑</option>
									<option value="电缆">电缆</option>
									<option value="工业原材料">工业原材料</option>
									<option value="变压器">变压器</option>
									<option value="男性">男性</option>
									<option value="女性">女性</option>
									<option value="其他">其他</option>
									<option value="无">无</option>
							</select></td> -->
						</tr>
					</table>
					<hr>
					<table>
						<tr>
							<td>作案过程</td>
							<td colspan="5"><textarea name="Case.case_process"
									class="form-control" rows="4"></textarea></td>
						</tr>
						<tr>
							<td colspan="6"><label style="margin-left: 30%;"
								class="fancy-checkbox"><input
									onclick="sence_checkbox(this)" name="sence.snece_photographed"
									type="checkbox"> <span>已拍照</span> </label> <label
								class="fancy-checkbox"><input
									onclick="sence_checkbox(this)" name="sence.snece_entered"
									type="checkbox"> <span>已录入</span> </label> <label
								class="fancy-checkbox"><input
									onclick="sence_checkbox(this)" name="sence.snece_areadymade"
									type="checkbox"> <span>已制作</span> </label> <label
								class="fancy-checkbox"><input
									onclick="sence_checkbox(this)" name="sence.snece_parsed"
									type="checkbox"> <span>已分析</span> </label> <label
								class="fancy-checkbox"><input
									onclick="sence_checkbox(this)" name="sence.snece_archived"
									type="checkbox"> <span>已存档</span> </label> <label
								class="fancy-checkbox"> <input
									onclick="sence_checkbox(this)" name="sence.snece_identified"
									type="checkbox"> <span>已认定</span>
							</label></td>
						</tr>
						<tr>
							<td>勘验人员</td>
							<td colspan="5"><select name="sence.snece_inquestPerson"
								id="exploration_personnel"
								class="selectpicker show-tick form-control dropup" multiple
								data-live-search="true" data-dropup-auto="false" title="请选择">
									<option value="刘楚德">刘楚德</option>
									<option value="龙建平">龙建平</option>
									<option value="刘蓉">刘蓉</option>
									<option value="杨立宇">杨立宇</option>
									<option value="冯俊">冯俊</option>
									<option value="吴昊晟">吴昊晟</option>
									<option value="陈永明">陈永明</option>
									<option value="赖鑫">赖鑫</option>
									<option value="王树鹏">王树鹏</option>
									<option value="许倩">许倩</option>
									<option value="汤喜">汤喜</option>
									<option value="陈佐仁">陈佐仁</option>
									<option value="李希">李希</option>
									<option value="魏松林">魏松林</option>
							</select></td>
						</tr>
						<tr>
							<td>填表人员</td>
							<td><input name="sence.snece_fillPerson"
								style="margin-top: 6px;" class="form-control" type="text"></td>
							<td>填表单位</td>
							<td><input name="sence.snece_fillUnit"
								style="margin-top: 6px;" class="form-control" type="text"></td>
							<td>填表时间</td>
							<td><input name="sence.snece_fillTime"
								style="margin-top: 6px;" class="form_time form-control"
								type="text"></td>
						</tr>
					</table>
				</form>
				<table>
					<tr>
						<td align="right">
							<!-- 按钮触发模态框 -->
							<button style="margin-top: 6px;" type="button"
								class="btn btn-default" data-toggle="modal"
								data-target="#evidence">
								<i class="fa fa-plus-square"></i> 添加物证
							</button>
							<button style="margin-top: 6px; margin-right: 10px;"
								type="button" class="btn btn-default sneceInformation_finish">
								<i class="fa fa-check-circle"></i> 完成
							</button>
						</td>
					</tr>
				</table>




				<!-- 模态框（Modal） -->
				<div class="modal fade" id="evidence" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">痕迹物证单</h4>
							</div>
							<div class="modal-body">
								<div class="panel-body">
									<table>
										<tbody>
											<tr>
												<td>案发时间:</td>
												<td><input name="sneceInformation."
													class="form-control" value="1900-1-10" maxlength="19"
													type="text"></td>
												<td>物证名称:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>

											</tr>
											<tr>
												<td>案发地点:</td>
												<td><input name="sneceInformation."
													class="form-control" value="萍乡市安源区" size="30"
													maxlength="19" type="text"></td>
												<td>提取部位:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>

											</tr>
											<tr>
												<td>案件性质:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>
												<td>提取方法:</td>
												<td><select name="sneceInformation."
													class="form-control">
														<option value="" selected="">请输入提取方法</option>
														<option value="粉末显现">粉末显现</option>
														<option value="茚三酮熏显">茚三酮熏显</option>
														<option value="502熏显">502熏显</option>
														<option value="实物提取">实物提取</option>
														<option value="照相提取">照相提取</option>
														<option value="静电吸附">静电吸附</option>
														<option value="纱布转移">纱布转移</option>
														<option value="其他">其他</option>
												</select></td>
											</tr>
											<tr>
												<td>物证编号:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>

												<td>提取数量:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>

											</tr>
											<tr>
												<td>提取单位:</td>
												<td><input name="sneceInformation."
													class="form-control" value="安源分局刑事科学技术室" size="30"
													maxlength="19" type="text"></td>
												<td>提取人:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>

											</tr>
											<tr>
												<td>物证序号:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>

												<td>提取日期:</td>
												<td><input name="sneceInformation."
													class="form-control" value="" size="30" maxlength="19"
													type="text"></td>
											</tr>
											<tr>
												<td>物证类型：</td>
												<td><select name="sneceInformation."
													class="form-control">
														<option value="" selected="">请选择物证类型</option>
														<option value="手印痕迹">手印痕迹</option>
														<option value="足迹痕迹">足迹痕迹</option>
														<option value="工具痕迹">工具痕迹</option>
														<option value="生物物证">生物物证</option>
														<option value="理化物证">理化物证</option>
														<option value="其他">其他</option>
												</select></td>
											</tr>
											<tr>
												<td>备注:</td>
												<td colspan="3"><textarea class="form-control"
														placeholder="请填写" rows="2"></textarea></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">提交</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>

							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
				<!--  -->
			</div>
			<!---------------------------------------------------------------------------------------------------->
			<!---------------------------------------------------------------------------------------------------->
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/Case/SneceInput.js"></script>
</body>
</html>