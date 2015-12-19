<%@page import="com.mynms.performance.model.PerformanceEnvInfo"%>
<%@page import="com.mynms.common.util.page.Page"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<PerformanceEnvInfo> list = (List<PerformanceEnvInfo>) request.getAttribute("list");
    String name = (String) request.getAttribute("name");
    Page jpage = (Page) request.getAttribute("page");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <base href="<%=basePath%>">
    
        <title>机房动力环境信息</title>
        
    	<meta http-equiv="pragma" content="no-cache">
    	<meta http-equiv="cache-control" content="no-cache">
    	<meta http-equiv="expires" content="0">    
    	<meta http-equiv="description" content="机房动力环境信息">
        <meta name="viewport" content="user-scalable=no,width=device-width">

        <link rel="stylesheet" type="text/css" href="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.css" />
        <script src="<%=path%>/resource/js/jquery/jquery-1.7.2.min.js"></script>
        <script src="<%=path%>/resource/js/jquery/jquery.mobile-1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <script src="<%=path%>/resource/js/alarm/alarmInfo/list.js"></script>
        <script src="<%=path%>/resource/js/common/util/scrollPagination.js"></script>
    	<!--
    	<link rel="stylesheet" type="text/css" href="styles.css">
    	-->
    </head>
    <body>
        <form name="mainForm" method="post" id="mainForm">
            <div id="page" data-role="page" style="height: 100%">
                <div style="padding: 5px 15px; " data-role="content">
                    <ul id="listview" data-role="listview" data-inset="true">
                        <li data-role="list-divider" class="list-divider">机房动力环境信息</li>
                        <li style="padding: 0px 2px;margin: 0px 0px;">
                            <table style="width: 100%;text-align: left;">
                                <tr style="width: 100%;text-align: left;">
                                     <td align="left" width="70%">
                                        <input type="search" name="name" id="name" value="<%=name%>" style="height: 35px;margin: 0px 0px;"/>
                                    </td>
                                    <td align="left" width="30%">
                                        <a href="javascript:search();" data-role="button" id="submit" style="height: 35px;margin: 0px 0px;">搜索</a>
                                    </td>
                                </tr>
                            </table>
                        </li>
                        <%
                        if (list != null && list.size() > 0) {
                        	for (PerformanceEnvInfo info : list) {
                        %>
                        <li title="content">
                            <table style="width: 100%;text-align: left;">
                                <tr>
                                    <td width="40%">设备名称：</td><td width="60%"><%=info.getName()%></td>
                                </tr>
                                <tr>
                                    <td width="40%">指标名称：</td><td width="60%"><%=info.getIndicatorName()%></td>
                                </tr>
                                <tr>
                                    <td width="40%">指标值：</td><td width="60%"><%=info.getIndicatorValue()%></td>
                                </tr>
                            </table>
                        </li>
                        <%
                            }
                        }
                        %>
                    </ul>
                </div>
            </div>
        </form>
    </body>
    <script type="text/javascript">
    	var contentData = null;
        <%
            if (name != null) {
                %>
                contentData = "name=" + "<%=name%>";
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
            'contentData' : contentData,
            'url' : '<%=path%>' + '/performanceEnvInfo/list.do',
            'scrollTarget' : $(window),
            'heightOffset' : 10,
            'beforeLoad' : function() {
                
            },
            'afterLoad' : function(data) {
                $(data).find("li[title='content']").appendTo($("#listview"));
                $("div[data-role=content] ul").listview('refresh'); 
            }
        });
        
        //使输入框初始化变灰色，点击之后，清空
        function inputTipText(){
        	var oldVal = $("#name").val();
			$("#name").css({"color":"#888"}).focus(function(){
				   	if($(this).val()!=oldVal){
				   		$(this).css({"color":"#000"})
				   	}else{
				   		$(this).val("").css({"color":"#888"})
				   	}
				}).blur(function(){
			    	if($(this).val()==""){
			    		$(this).val(oldVal).css({"color":"#888"})
			    	}
				}).keydown(function(){
					$(this).css({"color":"#000"});
				})
		}
        $(function(){
			inputTipText();
		})
        
        function search() {
        	var name = $("#name").val();
        	if (name == '' || name == '请输入设备名称') {
        		alert('请输入查询条件');
        		return;
        	}
            var mainForm = document.getElementById("mainForm");
            mainForm.action = "<%=path%>/performanceEnvInfo/list.do";
            mainForm.submit();
        }
    </script>
</html>
