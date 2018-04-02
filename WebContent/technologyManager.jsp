<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<style type="text/css">
li {list-style-type:none;
}
li a{
color: black;
}
</style>
</head>
<body>
	<div style="margin: 80px 0 0 0; float: left; width: 100%; color: black;">
		<div class="panel"  style="height: 40px; line-height:40px; width: 95%; margin: 20px auto;">
			<ul>
				<li style="float: left;"><a href="<%=basePath%>case/Case_page_CaseMergerList">案件串并</a></li>
				<li style="float: left; margin-left: 30px;"><a href="<%=basePath%>case/Case_page_CaseMaterials">案件材料</a></li>
				<li style="float: left; margin-left: 30px;"><a href="<%=basePath%>case/BreakCase_page_BreakCaseList">刑事破案</a></li>
				<li style="float: left; margin-left: 30px;"><a href="<%=basePath%>DNA/DNAManagement_DNAManagementPage">DNA</a></li>
				<li style="float: left; margin-left: 30px;"><a href="<%=basePath%>FingerPrint/FingerPrintManagement_FingerPrintManagementPage">指纹</a></li>
				<li style="float: left; margin-left: 30px;"><a href="<%=basePath%>Equipment/EquipmentManagement_EquipmentManagementPage">器材装备</a></li>
				<li style="float: left; margin-left: 30px;"><a>统计</a></li>
			</ul>
		</div>
	</div>
</body>
</html>