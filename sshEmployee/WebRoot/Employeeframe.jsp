<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<frameset rows="80,*">
   <frame name="top" src="${pageContext.request.contextPath}/Employeeframe/top.jsp">
   <frameset cols="150,*" id="main">

      <frame src="<%=basePath %>Employeeframe/left.jsp">
   <frame name="right" src="<%=basePath %>Employeeframe/right.jsp"> 
    
   </frameset>
</frameset>

