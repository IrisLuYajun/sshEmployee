<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script language="javascript" type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>



<s:form action="employee_update.action" method="post" id="saveForm" theme="simple">
<s:hidden name="eid" value="%{model.eid}"/>
<table border='0' cellpadding="0"  cellspacing="10">
<tr>
	<td>姓名：</td>
	<td><s:textfield name = "ename" value="%{model.ename}"/></td>   <!-- %{model.ename}回显数据 -->
	<td>性别：</td>
	<td><s:radio name = "sex" list="{'男','女'}"  value="%{model.sex}"/></td>
</tr>
<tr>
	<td>用户名：</td>
	<td><s:textfield name = "username"  value="%{model.username}"/></td>
	<td>密码：</td>
	<td><s:password name = "password"  value="%{model.password}" showPassword="true"/></td>
</tr>
<tr>
	<td>出生日期：</td>
	<td><input type="text"  id="d11" name = "birthday"  value="<s:date name="model.birthday" format="yyyy-MM-dd"/>"/>
	<img onclick="WdatePicker({el:'d11'})" src="<%=basePath %>My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
	</td>
	<td>入职时间：</td>
	<td><input type="text" id="d12" name = "joinDate"  value="<s:date name="model.joinDate" format="yyyy-MM-dd"/>"/>
	<img onclick="WdatePicker({el:'d12'})" src="<%=basePath %>My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
	</td>
</tr>

<tr>
	<td>所属部门：</td>
	<td><s:select name="department.did" list = "list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"  value="%{model.department.did}"/></select></td>
	<td>编号：</td>
	<td><s:textfield name = "eno"  value="%{model.eno}"/></td>
	
</tr>
</table>
</s:form>

</body>
</html>