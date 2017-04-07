<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <body>
  <h2>您的个人信息为：</h2>
<h3>姓名：<s:property value="#session.existEmployee.ename"/></h3>
<h3>编号：<s:property value="#session.existEmployee.eid"/></h3>
<h3>性别：<s:property value="#session.existEmployee.sex"/></h3>
<h3>生日：<s:property value="#session.existEmployee.birthday"/></h3>
<h3>入职日期：<s:property value="#session.existEmployee.joinDate"/></h3>
<h3>员工编号：<s:property value="#session.existEmployee.eno"/></h3>
<h3>用户名：<s:property value="#session.existEmployee.username"/></h3>
<h3>密码：<s:property value="#session.existEmployee.password"/></h3>
  </body>
</html>
