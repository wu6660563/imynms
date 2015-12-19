<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.mynms.alarm.model.AlarmInfo"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<AlarmInfo> list = (List<AlarmInfo>) request.getAttribute("list");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <base href="<%=basePath%>">
    
        <title>告警信息列表</title>
        
    	<meta http-equiv="pragma" content="no-cache">
    	<meta http-equiv="cache-control" content="no-cache">
    	<meta http-equiv="expires" content="0">    
    	<meta http-equiv="description" content="告警信息列表">
    	<!--
    	<link rel="stylesheet" type="text/css" href="styles.css">
    	-->

        <style type="text/css">
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
            <table style="border-bottom: 1pt solid #e8e9e9;">
            <%
                for (AlarmInfo alarmInfo : list) {
                    String alarmInfoContent = alarmInfo.getContent();
                    if (alarmInfoContent == null || "null".equals(alarmInfoContent.trim())) {
                        alarmInfoContent = "";
                    }
                    if (alarmInfoContent.length() > 50) {
                        alarmInfoContent = alarmInfoContent.substring(0, 50) + "...";
                    }
                %>
                <tr>
                    <td class="list"></td>
                    <td class="list">
                        <table>
                            <tr>
                                <td><%=alarmInfo.getEventLocation()%></td>
                                <td><%=alarmInfo.getRecordTime()%></td>
                            </tr>
                            <tr>
                                <td colspan="2"><%=alarmInfoContent%></td>
                            </tr>
                        </table>
                    </td>
                </tr>                
                <%
                }
            %>
            </table>
        </form>
        
    </body>
</html>
