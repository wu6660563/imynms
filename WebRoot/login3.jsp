<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
                    + request.getServerName() + ":"
                    + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>广东省水利厅综合监控手机版</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="广东省水利厅综合监控手机版">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>
        
        <link href="<%=path%>/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="<%=path%>/resource/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="<%=path%>/resource/css/global/global.css">

    </head>
    <body style="margin: 0px;">
        <div id="page" style="">
            <img style="position:absolute;z-index: -1; left:0px;top:0px;width:100%;height: 100%" src="<%=path%>/resource/image/login/bg.jpg" />
            <form method="POST" action="<%=path%>/login/login.do" class="form-horizontal">
                <div style="position:absolute;margin: 10% 10%; width: 80%;top: 30%">
                    <div class="control-group">
                        <label class="control-label" for="userName" style="font-size: 30px;font-weight: bold;"><font color="white">用户名：</font></label>
                        <input type="text" id="userName" name="userName" placeholder="用户名" style="border-radius : 12px;width: 80%;height: 40px">
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="password" style="font-size: 30px;font-weight: bold;"><font color="white">密&nbsp;&nbsp;&nbsp;&nbsp;码：</font></label>
                        <input id="password" type="password" name="password" placeholder="密码" style="border-radius : 12px;width: 80%;height: 40px">
                    </div>
                    <div class="control-group">
                        <input value="登    陆" type="submit" class="btn btn-primary" style="font-size: 30px;font-weight: bold;border-radius : 12px;width: 30%;height: 40px">
                        <input value="重    置" type="reset" class="btn btn-inverse" style="font-size: 30px;font-weight: bold;border-radius : 12px;width: 30%;height: 40px">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
