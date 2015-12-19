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
        
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->

        <link rel="stylesheet" href="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.css" />
        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>
        <script src="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <script src="<%=path%>/resource/js/common/util/scrollPagination.js"></script>

        <link rel="stylesheet" type="text/css" href="<%=path%>/resource/css/global/global.css">

    </head>
    <body style="margin: 0px;">
        <div id="page" data-role="page" style="height:100%;width:100%;">
            <div data-role="content" style="height: 100%">
                <img style="position:absolute;left:0px;top:0px;width:100%;height: 100%" src="<%=path%>/resource/image/login/bg.jpg" />
                <form id="mainForm" method="POST" style="height: 100%">
                    <div style="text-align: center;font-size: 100px;font-weight: bold;">登录</div>
                    <div data-role="fieldcontain" style="height: 100%;top:50px;margin: 10% 5%;">
                        <fieldset data-role="controlgroup">
                            <label for="textinput1" style="font-size: 30px;font-weight: bold;"><font color="white">用户名：</font></label>
                            <input id="userName" type="text" name="userName">
                        </fieldset>
                        <fieldset data-role="controlgroup">
                            <label for="textinput2" style="font-size: 30px;font-weight: bold;"><font color="white">密&nbsp;&nbsp;&nbsp;&nbsp;码：</font></label>
                            <input id="password" type="password" name="password">
                        </fieldset>
                        <div class="ui-grid-a">
                            <div class="ui-block-a"><input value="登    陆" type="button" data-theme="b" onclick="login()" style="font-size: 30px;font-weight: bold;"></div>
                            <div class="ui-block-b"><input value="重    置" type="reset" style="font-size: 30px;font-weight: bold;"></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        function login() {
            var mainForm = document.getElementById("mainForm");
            mainForm.action="<%=path%>/login/login.do";
            mainForm.submit();
        }
    </script>
</html>
