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
<link rel="stylesheet" href="<%=basePath%>css/User/UserIndex.css">
<script type="text/javascript" src="<%=basePath %>js/User/getData.js"></script>
<title>�û�����</title>
</head>
<body>
	<!----------------------------------------------- ������Ϣ��ʼ --------------------------------------------------->
	<input id="hideQueryString" type="text" class="hideDiv">
	<input id="hideCurrPage" type="text" class="hideDiv">
	
	
	<!----------------------------------------------- ������Ϣ���� ------------------------------------------------->
	<!-----------------------------------------���뵼���� ------------------------------------------------------>
		<s:action name="User_navbar" namespace="/user" executeResult="true" />
	
	<!----------------------------------------�������� -------------------------------------------------------- -->
			
		<div style="margin: 80px 0 0 0; float: left; width: 100%;">
			<!---------------------------------------------------------------------------------------------------->
			<!---------------------------------------------------------------------------------------------------->
			<div class="panel" style="width: 95%; margin: 20px auto;">
				<div id="" style="height: 80px; padding: 20px;">
					<div style="float:right; margin-left: 10px;">
    				  <button data-toggle="modal" data-target="#addUser" class="btn btn-success"><span style="width" class="glyphicon glyphicon-plus"></span>�����û�</button>
    				</div>  
					<div class="input-group" style="float:right; width: 300px;">
					      <input id="queryString" type="text" class="form-control" placeholder="��������������">
					      <span class="input-group-btn">
					        <button onclick="queryUser()" class="btn btn-default" type="button">����</button>
					      </span>
    				</div>
				</div>
				<div id="loadingDiv" style="width: 319px; margin: 0 auto;">
					<img alt="" src="<%=basePath %>img/loading.gif">
				</div>
				<div id="tableDiv" class="hideDiv"  >
					<table class="table table-bordered" style="text-align: center;">
						<tbody id="userTable">
							<tr style="background-color: #696969; color: white;">
								<td>�˺�</td>
								<td>����</td>
								<td>����</td>
								<td>��λ</td>
								<td>����</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div id="bottomPage" style="padding: 20px;">
					<span>��ǰҳ��:<span id="currPage">1</span></span>
					<span>��:<span id="totalPage">2</span>ҳ</span>
					<span  onclick="skipToIndexPage()" id="indexPage" class="pageOperation">��ҳ</span>
					<span onclick="skipToPrimaryPage()" id="previousPage" class="pageOperation">��һҳ</span>
					<span onclick="skipToNextPage()" id="nextPage" class="pageOperation">��һҳ</span>
					<span onclick="skipToLastPage()" id="lastPage" class="pageOperation">ĩҳ</span>
					<span>
						<input  id="skipPage" type="text" style="text-align: center; width: 60px; height: 30px;" class="queryInput">
						<button onclick="skipToArbitrarilyPage()" class="btn btn-default" style="height:30px; margin-bottom: 10px;">��ת</button>
					</span>
				</div>
			</div>
			<!---------------------------------------------------------------------------------------------------->
			<!---------------------------------------------------------------------------------------------------->
		</div>
		<!-----------------------------------------------------------------����ģ̬��---------------------------------------------------  -->
			<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">�����û�</h4>
			      </div>
			      <div class="modal-body">
			      	<div id="addLoadingDiv" class="hideDiv" style="width: 319px; margin: 0 auto;">
						<img alt="" src="<%=basePath %>img/loading.gif">
					</div>
			      	 <div id="addContent">	
			      		<form id="addUserForm" name="addUserForm">
				      		<label>�˺ţ�</label>
				      		<input name="user_username" type="text" class="form-control" placeholder="�������˺�">
				      		<label>���룺</label>
				      		<input name="user_password" type="password" class="form-control" placeholder="����������">
				      		<label>������</label>
				      		<input name="user_name" type="text" class="form-control" placeholder="�������û�����">
				      		<label>���룺</label>
				      		<input name="user_number" type="text" class="form-control" placeholder="�������û�����">
				      		<label>��λ��</label>
				      		<input name="user_units" type="text" class="form-control" placeholder="�������û���λ">
				      		<label>��������Ȩ�ޣ�</label>
				      		<select name="user_case_technology_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�������Ȩ�ޣ�</label>
				      		<select name="user_case_query_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�������Ȩ�ޣ�</label>
				      		<select name="user_check_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�������Ȩ�ޣ�</label>
				      		<select name="user_army_manager_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>��������Ȩ�ޣ�</label>
				      		<select name="user_technology_manager_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>ͳ��Ȩ�ޣ�</label>
				      		<select name="user_statistics_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�û�����Ȩ�ޣ�</label>
				      		<select name="user_user_manager_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
			      		</form>
			      	</div>
			      </div>
			      <div class="modal-footer">
			        <button onclick="reLoadUser()" type="button" class="btn btn-default" data-dismiss="modal">�ر�</button>
			        <button onclick="addUser()" type="button" class="btn btn-primary">�ϴ�</button>
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div>

		<!-----------------------------------------------------------------�޸�ģ̬��----------------------------------------------------  -->
			<div class="modal fade" id="updateUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">�޸��û�</h4>
			      </div>
			      <div class="modal-body">
			      	<div id="updateLoadingDiv" class="hideDiv" style="width: 319px; margin: 0 auto;">
						<img alt="" src="<%=basePath %>img/loading.gif">
					</div>
			      	 <div id="updateContent">	
			      		<form id="updateUserForm">
				      		<label>�˺ţ�</label>
				      		<input id="user_username_update" name="user_username" type="text" class="form-control" placeholder="�������˺�">
				      		<label>���룺</label>
				      		<input id="user_password_update" name="user_password" type="password" class="form-control" placeholder="����������">
				      		<label>������</label>
				      		<input id="user_name_update" name="user_name" type="text" class="form-control" placeholder="�������û�����">
				      		<label>���룺</label>
				      		<input id="user_number_update" name="user_number" type="text" class="form-control" placeholder="�������û�����">
				      		<label>��λ��</label>
				      		<input id="user_units_update" name="user_units" type="text" class="form-control" placeholder="�������û���λ">
				      		<label>��������Ȩ�ޣ�</label>
				      		<select id="user_case_technology_power_update" name="user_case_technology_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�������Ȩ�ޣ�</label>
				      		<select id="user_case_query_power_update" name="user_case_query_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�������Ȩ�ޣ�</label>
				      		<select id="user_check_power_update" name="user_check_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�������Ȩ�ޣ�</label>
				      		<select id="user_army_manager_power_update" name="user_army_manager_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>��������Ȩ�ޣ�</label>
				      		<select id="user_technology_manager_power_update" name="user_technology_manager_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>ͳ��Ȩ�ޣ�</label>
				      		<select id="user_statistics_power_update" name="user_statistics_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
				      		<label>�û�����Ȩ�ޣ�</label>
				      		<select id="user_user_manager_power_update" name="user_user_manager_power" class="form-control">
				      			<option value="jurisdiction_none">��Ȩ��</option>
				      			<option value="jurisdiction_use">ʹ��Ȩ��</option>
				      			<option value="jurisdiction_admin">����Ȩ��</option>	
				      		</select>
			      		</form>
			      	</div>
			      </div>
			      <div class="modal-footer">
			        <button onclick="reLoadUser()" type="button" class="btn btn-default" data-dismiss="modal">�ر�</button>
			        <button id="updateBtn" onclick="updateUser(this)" type="button" class="btn btn-primary">�޸�</button>
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div>

</body>
</html>