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



<s:form action="employee_save.action" method="post" id="saveForm" theme="simple">
<table border='0' cellpadding="0"  cellspacing="10">
<tr>
	<td>姓名：</td>
	<td><s:textfield name = "ename"/></td>
	<td>性别：</td>
	<td><s:radio name = "sex" list="{'男','女'}"/></td>
</tr>
<tr>
	<td>用户名：</td>
	<td><s:textfield name = "username"/></td>
	<td>密码：</td>
	<td><s:password name = "password"/></td>
</tr>
<tr>
	<td>出生日期：</td>
	<td><s:textfield name = "birthday" id="d1" />
	<img onclick="WdatePicker({el:'d1'})" src="<%=basePath %>My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
	</td>
	<td>入职时间：</td>
	<td><s:textfield name = "joinDate" id="d2"/>
	<img onclick="WdatePicker({el:'d2'})" src="<%=basePath %>My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
	</td>
	
</tr>

<tr>
	<td>所属部门：</td>
	<td><s:select name="depart" list = "list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"/></select></td>
	<td>编号：</td>
	<td><s:textfield name = "eno"/></td>
	
</tr>
</table>
</s:form>

</body>
</html>