<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!---------------------------------------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------->
<title>首页</title>
</head>
<style type="text/css">
.table-condensed thead tr>th {
	text-align: left;
}

.table-condensed tbody>tr>td {
	font-size: 15px;
}
</style>
<body>
	<s:action name="User_navbar" namespace="/user" executeResult="true" />
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<div style="margin: 80px 0 0 0; float: left; width: 100%;">
		<div class="panel" style="width: 95%; margin: 20px auto;">
			<!--  -->
			<div class="panel-heading">
				<h3 class="panel-title">串并案件</h3>
			</div>
			<div class="operation" style="margin-bottom: 6px;">
				<button style="margin-left: 15px;" type="button"
					class="btn btn-default" data-toggle="modal"
					data-target="#newCaseMergerQuery">
					<i class="fa fa-plus-square"></i> 新建串并案件查询
				</button>
				<button style="margin-left: 15px;" type="button"
					class="btn btn-default" data-toggle="modal"
					data-target="#newCaseMerger">
					<i class="fa fa-plus-square"></i> 确定案件串并
				</button>
			</div>
			<div class="panel-body">
				<table class="table table-hover table-condensed table_main">
					<thead>
						<tr>
							<thh>
							<th>勘验编号</th>
							<th>接警时间</th>
							<th>案发地点</th>
							<th>案件类别</th>
							<th>报案人基本情况</th>
							<th>物证编号</th>
							<th>主勘人员</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox"></td>
							<td>2017110002</td>
							<td>2017/11/12</td>
							<td>萍乡市</td>
							<td>其它盗窃</td>
							<td>李显明 13979987657</td>
							<td>W2017110001</td>
							<td>杨立宇 吴昊晟</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="8" style="font-size: 12px;"><a><i
									class="fa fa-angle-double-left">首页</i> </a>&nbsp&nbsp<a><i
									class="fa fa-angle-left"></i>上一页 </a>&nbsp&nbsp<a>下一页<i
									class="fa fa-angle-right"></i>
							</a>&nbsp&nbsp <a>尾页<i class="fa fa-angle-double-right"></i>
							</a> &nbsp&nbsp转到第<select></select> 页 <br />共 1317条信息 当前1/95页
								14条信息/页</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 新建查询-模态框（Modal） -->
	<div class="modal fade" id="newCaseMergerQuery" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">案件查询</h4>
				</div>
				<div class="modal-body">
					<table cellpadding="6">
						<tbody>
							<tr>
								<td><strong>案件串并信息查询</strong></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tbody>
							<tr>
								<td>串并时间</td>
								<td><div align="left">
										<input class="form-control" value="2017-1-1" type="text">
									</div></td>
								<td>至</td>
								<td><div align="left">
										<input class="form-control" value="2017/11/29" size="12"
											type="text">
									</div></td>
								<td>串并名称</td>
								<td><div align="left">
										<input class="form-control" name="cbmc" id="cbmc" value=""
											size="30" type="text">
									</div></td>
								<td>串并人</td>
								<td><div align="left">
										<input class="form-control" value="" size="10" type="text">
									</div></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary to_quert">完成</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------------------------------------------------------->
	<!-- 确定案件串并-模态框（Modal） -->
	<div class="modal fade" id="newCaseMerger" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">案件串并</h4>
				</div>
				<div class="modal-body">
					<table width="60%" cellspacing="0" cellpadding="2" align="center">
						<tbody>
							<tr>
								<td><div align="center">串并名称:</div></td>
								<td><input style="margin-top: 6px;" class="form-control"
									maxlength="50" type="text"></td>
							</tr>
							<tr>
								<td><div align="center">串并人:</div></td>
								<td><input style="margin-top: 6px;" class="form-control"
									maxlength="10" type="text"></td>
							</tr>
							<tr>
								<td><div align="center">破案情况:</div></td>
								<td><label style="float: left;" class="fancy-radio">
										<input name="register" onclick="buildCase_chose(this)"
										type="radio" value="1"> <span><i></i>是</span>
								</label><label style="float: left; margin-left: 10px;"
									class="fancy-radio"> <input name="register"
										onclick="buildCase_chose(this)" type="radio" value="2">
										<span><i></i>否</span>
								</label> <input type="hidden" name=""></td>
							</tr>
							<tr>
								<td><div align="center">选择处所:</div></td>
								<td><select style="margin-top: 6px;" class="form-control">
										<option value="" selected></option>
										<option value="居民住宅">居民住宅</option>
										<option value="出租屋">出租屋</option>
										<option value="农宅">农宅</option>
										<option value="公司单位">公司单位</option>
										<option value="厂矿企业">厂矿企业</option>
										<option value="商铺">商铺</option>
										<option value="娱乐场所">娱乐场所</option>
										<option value="酒店宾馆">酒店宾馆</option>
										<option value="办公场所">办公场所</option>
										<option value="通讯基站">通讯基站</option>
										<option value="路边野外">路边野外</option>
										<option value="山上">山上</option>
										<option value="街巷广场">街巷广场</option>
										<option value="医院诊所">医院诊所</option>
										<option value="工地">工地</option>
										<option value="小区住宅">小区住宅</option>
										<option value="网吧">网吧</option>
										<option value="池塘河内">池塘河内</option>
										<option value="学校">学校</option>
										<option value="游泳池">游泳池</option>
										<option value="仓库">仓库</option>
										<option value="党政机关">党政机关</option>
										<option value="停车场">停车场</option>
										<option value="别墅">别墅</option>
										<option value="其他">其他</option>
										<option value="无">无</option>
								</select></td>

							</tr>
							<tr>
								<td><div align="center">作案手段:</div></td>

								<td><select style="margin-top: 6px;" class="form-control">
										<option value="" selected></option>
										<option value="撬防盗门">撬防盗门</option>
										<option value="爬窗爬阳台">爬窗爬阳台</option>
										<option value="破坏窗栅">破坏窗栅</option>
										<option value="撬保险箱">撬保险箱</option>
										<option value="破坏卷帘门">破坏卷帘门</option>
										<option value="技术开锁">技术开锁</option>
										<option value="撞踹木门">撞踹木门</option>
										<option value="盗车内财物">盗车内财物</option>
										<option value="溜门">溜门</option>
										<option value="撬木门">撬木门</option>
										<option value="门缝钻入">门缝钻入</option>
										<option value="破门玻璃">破门玻璃</option>
										<option value="窗口钻入">窗口钻入</option>
										<option value="破窗玻璃">破窗玻璃</option>
										<option value="钻洞入室">钻洞入室</option>
										<option value="墙上挖洞">墙上挖洞</option>
										<option value="持械作案">持械作案</option>
										<option value="强力破锁">强力破锁</option>
										<option value="插片开锁">插片开锁</option>
										<option value="钻孔开锁">钻孔开锁</option>
										<option value="填充物开锁">填充物开锁</option>
										<option value="钳断锁梁">钳断锁梁</option>
										<option value="中毒死亡">中毒死亡</option>
										<option value="电击死亡">电击死亡</option>
										<option value="破车门窗">破车门窗</option>
										<option value="掘墓盗物">掘墓盗物</option>
										<option value="顺手牵羊">顺手牵羊</option>
										<option value="乘隙盗窃">乘隙盗窃</option>
										<option value="钓鱼">钓鱼</option>
										<option value="其他">其他</option>
										<option value="无">无</option>
								</select></td>
							</tr>
							<tr>
								<td align="right"><div align="center">作案目标:</div></td>
								<td><select style="margin-top: 6px;" class="form-control">
										<option value="" selected=""></option>
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
								</select></td>
							</tr>
							<tr>
								<td align="right"><div align="center">选择时段:</div></td>
								<td><select style="margin-top: 6px;" class="form-control">
										<option value="" selected></option>
										<option value="昼">昼</option>
										<option value="夜">夜</option>
										<option value="上午">上午</option>
										<option value="中午">中午</option>
										<option value="下午">下午</option>
										<option value="晚上">晚上</option>
										<option value="深夜">深夜</option>
										<option value="凌晨">凌晨</option>
										<option value="其他">其他</option>
								</select><input name="lists" id="lists" value="2017110002,2017110001"
									type="hidden"></td>
							</tr>
							<tr>
								<td align="right"><div align="center">技术并案:</div></td>
								<td><select style="margin-top: 6px;" class="form-control">
										<option value="" selected></option>
										<option value="指纹">指纹</option>
										<option value="足迹">足迹</option>
										<option value="工具">工具</option>
										<option value="DNA">DNA</option>
										<option value="枪弹">枪弹</option>
										<option value="其他">其他</option>
								</select></td>
							</tr>
							<tr>
								<td align="right"><div align="center">其他特点手段:</div></td>
								<td><textarea style="margin-top: 6px;" class="form-control"
										name="qttd" rows="2"></textarea></td>
							</tr>
							<tr>
								<td nowrap="nowrap" align="right"><div align="center">串并时间:</div></td>
								<td><input style="margin-top: 6px;" class="form-control"
									value="2017/11/29" type="text"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary finish_merger">串并</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
<script type="text/javascript">
</script>
</html>