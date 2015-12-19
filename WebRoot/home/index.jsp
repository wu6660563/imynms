<%@page import="com.mynms.core.resource.SysResourceCenter"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>综合网络管理系统</title>
    	<meta http-equiv="pragma" content="no-cache">
    	<meta http-equiv="cache-control" content="no-cache">
        <meta name="viewport" content="user-scalable=no" width="device-width">
    </head>
    <body style="padding: 0px; left: 0px; top: 0px;margin: 0px; overflow: auto;" >
        <!-- 
        <div id="topDiv">
            <iframe id="topFrame" height="140px" width="100%" frameborder="0" src="<%=path%>/login/top.do" ></iframe>
        </div>
         -->
        <div id="homeDiv" height="100%" width="100%" style="margin: 0px;white-space: 0px; left: 0px; top: 0px;">
            <iframe id="mainFrame" height="100%" width="100%" frameborder="no" style="margin: 0px" src="<%=path%>/login/home.do" border="0" framespacing="0"></iframe>
        </div>
    </body>
</html>
