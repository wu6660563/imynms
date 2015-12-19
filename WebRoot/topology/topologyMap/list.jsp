<%@page import="com.mynms.common.util.page.Page"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.mynms.topology.model.TopologyMap"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<TopologyMap> list = (List<TopologyMap>) request.getAttribute("list");
    Page jpage = (Page) request.getAttribute("page");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <base href="<%=basePath%>">

        <title>拓扑图列表</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="description" content="告警信息">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" type="text/css" href="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.css" />
        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>
        <script src="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <script src="<%=path%>/resource/js/common/util/scrollPagination.js"></script>
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    </head>

    <body>
        <div id="page" data-role="page" style="height: 100%">
            <form name="mainForm" method="post" id="mainForm" >
            <!--  <input type="hidden" id="id" name="id">-->
                
                <div style="padding: 5px 15px;" data-role="content">
                    <ul id="topologyMap-UL" data-role="listview" data-inset="true">
                        <li data-role="list-divider" class="list-divider">拓扑图</li>
                        <%
                        for (TopologyMap topologyMap : list) {
                            String id = String.valueOf(topologyMap.getId());
                            String name = topologyMap.getName();
                        %>
                        <li >
                            <a id="<%=id%>" onclick="show(<%=id%>)"><%=name%></a>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </form>
        </div>
    </body>
    <script type="text/javascript">
        function show(id) {
            //var topologyMapId = document.getElementById("id");
            //topologyMapId.value = id;
            var mainForm = document.getElementById("mainForm");
            mainForm.action = "<%=path%>/topologyMap/show.do?id=" + id;
            mainForm.submit();
            
        };
    </script>
</html>
