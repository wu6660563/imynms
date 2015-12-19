<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.mynms.topology.model.TopologyMap"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.awt.image.BufferedImage"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    TopologyMap topologyMap = (TopologyMap) request.getAttribute("topologyMap");
    BufferedImage sourceImg = (BufferedImage) request.getAttribute("sourceImg");
    int imgWidth = 0;
    int imgHeight = 0;
    if(sourceImg != null) {
    	imgWidth = sourceImg.getWidth();
    	imgHeight = sourceImg.getHeight();
    }
    
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <base href="<%=basePath%>">

        <title>拓扑图</title>
		
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="description" content="拓扑图">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" type="text/css" href="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.css" />
        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>
        <script src="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <!--
    	<link rel="stylesheet" type="text/css" href="styles.css">
    	-->
        <script src="<%=path%>/resource/js/topology/topologyMap/topology.js"></script>
    </head>

    <body>
        <form name="mainForm" method="post" id="mainForm">
            <input type="hidden" id="xmlName" name="xmlName">
            <input type="hidden" id="topologyMap" name="topologyMap" value="<%=path%>/topologyMap/showSubMap.do">
            <input type="hidden" id="nodeId" name="nodeId">
            <input type="hidden" id="nodeType" name="nodeType">
            <div id="page" data-role="page" style="height: 100%; overflow: hidden;">
                <div style="padding: 15px;overflow: hidden;" data-role="content">
                    <div id="show" style="width: 100%; height: 100%;position:absolute;top:0px;left:0px;">
                    </div>
                    <!-- background-image: url('<//%=path%>/resource/image/topo/bg/<//%=topologyMap.getTopologyBg()%>'); -->
                    <div id="content" style="width: 100%; height: 100%; position:absolute;top:0px;left:0px;"></div>
                    <div id="info_div" data-role="controlgroup" style="visibility:hidden;">
                        <a id="performanceNetInfo" onclick="changePage('<%=path%>/performanceNetInfo/list.do')" data-role="button">性能信息</a>
                        <a id="alarmInfo" onclick="changePage('<%=path%>/alarmInfo/list.do')" data-role="button">告警信息</a>
                    </div>
                </div>
            </div>
        </form>
    </body>
    <script type="text/javascript" charset="utf-8">
        var topologyMapBg = new TopologyMapBg();
        topologyMapBg.src = "<%=path%>/resource/image/topo/bg/<%=topologyMap.getTopologyBg()%>";
        topologyMapBg.height = <%=imgHeight%>;
        topologyMapBg.width = <%=imgWidth%>;
        
        $("#content").show("<%=path%>/resource/xml/<%=topologyMap.getXmlName()%>", topologyMapBg);
        
        function changePage(url) {
            $("#info_div").css({ visibility: "hidden"});
            var mainForm = document.getElementById("mainForm");
            mainForm.action = url;
            mainForm.submit();
        }
    </script>
</html>
