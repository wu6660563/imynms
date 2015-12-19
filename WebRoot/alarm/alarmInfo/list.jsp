<%@page import="com.mynms.common.util.page.Page"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.mynms.alarm.model.AlarmInfo"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<AlarmInfo> list = (List<AlarmInfo>) request.getAttribute("list");
    Page jpage = (Page) request.getAttribute("page");
    Integer nodeId = (Integer) request.getAttribute("nodeId");
    String nodeType = (String) request.getAttribute("nodeType");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(nodeId);
    System.out.println(nodeType);
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
        <meta name="viewport" content="user-scalable=no,width=device-width">

        <link rel="stylesheet" type="text/css" href="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.css" />
        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>
        <script src="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <script src="<%=path%>/resource/js/alarm/alarmInfo/list.js"></script>
        <script src="<%=path%>/resource/js/common/util/scrollPagination.js"></script>
    </head>
    <body>
        <form name="mainForm" method="post" id="mainForm">
            <div id="page" data-role="page" style="height: 100%">
                <div style="padding: 5px 15px; " data-role="content">
                    <ul id="listview" data-role="listview" data-inset="true">
                        <li data-role="list-divider" class="list-divider">告警信息</li>
                        <%
                        for (AlarmInfo alarmInfo : list) {
                            int level = alarmInfo.getLevel();
                            String levelStr = "普通告警";
                            String levelColor = "yellow";
                            if (level == 2) {
                                levelStr = "严重告警";
                                levelColor = "orange";
                            } else if (level == 3) {
                                levelStr = "紧急告警";
                                levelColor = "red";
                            } else if (level == 0) {
                            	levelStr = "告警恢复";
                                levelColor = "blue";
                            }
                        %>
                        <li >
                        <div class="list">
                            <div><%=simpleDateFormat.format(alarmInfo.getRecordTime())%></div>
                            <div><%=alarmInfo.getContent()%></div>
                            <div align="right"><div style="width: 25%;text-align: center;background-color: <%=levelColor%>;"><%=levelStr%></div></div>
                        </div>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </form>
    </body>
    <script type="text/javascript">
        var contentData = "";
        <%
            if (nodeId != null) {
                %>
                contentData = "nodeId=" + "<%=nodeId%>" + "&nodeType=" + "<%=nodeType%>";
                <%
            }
        %>
        
        var scrollPagination = new ScrollPagination({
            'pageSize' : <%=jpage.getPageSize()%>,
            'totalCount' : <%=jpage.getTotalCount()%>,
            'totalPage' : <%=jpage.getTotalPage()%>,
            'firstIndex' : <%=jpage.getFirstIndex()%>,
            'currentPage' : <%=jpage.getCurrentPage()%>,
            'hasPrePage' : <%=jpage.isHasPrePage()%>,
            'hasNextPage' : <%=jpage.isHasNextPage()%>,
            'url' : '<%=path%>' + '/alarmInfo/list.do',
            'scrollTarget' : $(window),
            'heightOffset' : 100,
            'contentData' : contentData,
            'beforeLoad' : function() {
                
            },
            'afterLoad' : function(data) {
                $(data).find("li[data-role!='list-divider']").appendTo($("#listview"));
                $("div[data-role=content] ul").listview('refresh'); 
            }
        });
        </script>
</html>
