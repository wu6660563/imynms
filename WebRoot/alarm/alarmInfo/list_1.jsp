<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.mynms.alarm.model.AlarmInfo"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <base href="<%=basePath%>">
    
        <title>告警信息</title>
        
    	<meta http-equiv="pragma" content="no-cache">
    	<meta http-equiv="cache-control" content="no-cache">
    	<meta http-equiv="expires" content="0">    
    	<meta http-equiv="description" content="告警信息">
        
        <link rel="stylesheet" href="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.css" />
        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>
        <script src="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <script src="<%=path%>/resource/js/alarm/alarmInfo/list.js"></script>
        <script src="<%=path%>/resource/js/common/util/scrollPagination.js"></script>
    	<!--
    	<link rel="stylesheet" type="text/css" href="styles.css">
    	-->
        <style type="text/css">
            .title {
                font-size: 20px;;
                font-weight: bold;
                border-top: 1px solid #fff;
                border-right: 1px solid #b9bec4;
                border-bottom: 1pt solid #b9bec4;
                height: 50px;
                vertical-align: middle;
                background-color: #f1f1f1;
                text-align:center;
                color: #404040;
            }
            .list {
                border-top: none black;
                border-bottom: 1pt solid #e8e9e9;
                height:85px;
                padding-left: 4px;
                padding-bottom: 2px;
                padding-right: 2px;
                padding-top: 2px;
            }
        </style>
    </head>
  
    <body>
        <form id="mainForm" name="mainForm" method="post">
            <div id="content">
                <table style="border-bottom: 1pt solid #e8e9e9;background-color: #D1DDE9;">
                <tr >
                    <td class="title">告  警  信  息</td>
                </tr>
                    <tr>
                        <td class="list">
                            <table width="100%">
                            </table>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
