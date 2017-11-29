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
					data-target="#newCaseMerger">
					<i class="fa fa-plus-square"></i> 新建串并案件查询
				</button>
				<button style="margin-left: 15px;" type="button"
					class="btn btn-default">
					<i class="fa fa-plus-square"></i> 确定案件串并
				</button>
			</div>
			<div class="panel-body">
				<table class="table table-hover table-condensed table_main">
					<thead>
						<tr>
							<th>#</th>
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
	<div class="modal fade" id="newCaseMerger" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
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
</body>
<script type="text/javascript">
</script>
</html>