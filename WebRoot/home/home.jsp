<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>首页</title>
    	<meta http-equiv="pragma" content="no-cache">
    	<meta http-equiv="cache-control" content="no-cache">
    	<meta http-equiv="expires" content="0">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>

        <link rel="stylesheet" type="text/css" href="<%=path%>/resource/css/global/global.css">
        <script src="<%=path%>/resource/js/home/home.js"></script>
        
    </head>

    <body>
        <form id="mainForm" name="mainForm" method="post">
            <table style="width: 100%;text-align: center;font-weight: bold;">
                <tr>
                    <td>
                        <div style="margin: 15% 5%">
                            <div><img onclick="changePage('<%=path%>/topologyMap/list.do', null)" alt="" src="<%=path%>/resource/image/home/topology.png"></div>
                            <div>网络拓扑</div>
                        </div>
                    </td>
                    <td>
                        <div style="margin: 15% 5%">
                            <div><img onclick="changePage('<%=path%>/performanceNetInfo/list.do', null)" alt="" src="<%=path%>/resource/image/home/net.png"></div>
                            <div>网络性能</div>
                        </div>
                    </td>
                    <td>
                        <div style="margin: 15% 5%">
                            <div><img onclick="changePage('<%=path%>/performanceHostInfo/list.do', null)" alt="" src="<%=path%>/resource/image/home/host.png"></div>
                            <div>主机性能</div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="margin: 15% 5%">
                            <div><img onclick="changePage('<%=path%>/performanceDBInfo/list.do', null)" alt="" src="<%=path%>/resource/image/home/db.png"></div>
                            <div>数据库性能</div>
                        </div>
                    </td>
                    <td>
                        <div style="margin: 15% 5%">
                            <div><img onclick="changePage('<%=path%>/performanceEnvInfo/list.do', null)" alt="" src="<%=path%>/resource/image/home/env.png"></div>
                            <div>机房环境</div>
                        </div>
                    </td>
                    <td>
                        <div style="margin: 15% 5%">
                            <div><img onclick="changePage('<%=path%>/alarmInfo/list.do', null)" alt="" src="<%=path%>/resource/image/home/alarm.png"></div>
                            <div>告警信息</div>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </body>
    <script type="text/javascript">
        function changePage(url, data) {
            var mainForm = document.getElementById("mainForm");
            mainForm.action = url;
            mainForm.submit();
        }    
    </script>
</html>
