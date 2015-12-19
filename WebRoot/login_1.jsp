<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form name="mainForm" action="<%=path%>/login/login" method="post">
        <label>用户名：</label><input type="text" name="userName">
        <label>密  码：</label><input type="password" name="password">
        <input type="submit" name="登  录"><input type="reset" name="重置">
        <input type="button" name="注  册" onclick="alert('注册用户')">
    </form>
  </body>
</html>
