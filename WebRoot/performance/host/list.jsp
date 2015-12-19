<%@page import="com.mynms.performance.model.PerformanceHostInfo"%>
<%@page import="com.mynms.common.util.page.Page"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<PerformanceHostInfo> list = (List<PerformanceHostInfo>) request.getAttribute("list");
    String ipAddress = (String) request.getAttribute("ipAddress");
    Page jpage = (Page) request.getAttribute("page");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <base href="<%=basePath%>">
    
        <title>服务器性能信息</title>
        
    	<meta http-equiv="pragma" content="no-cache">
    	<meta http-equiv="cache-control" content="no-cache">
    	<meta http-equiv="expires" content="0">    
    	<meta http-equiv="description" content="服务器性能信息">
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
                <div style="padding: 5px 15px;" data-role="content">
                    <ul id="listview" data-role="listview" data-inset="true">
                        <li data-role="list-divider" class="list-divider">服务器性能信息</li>
                        <li style="padding: 0px 2px;margin: 0px 0px;">
                            <table style="width: 100%;text-align: left;">
                                <tr style="width: 100%;text-align: left;">
                                     <td align="left" width="70%">
                                        <input type="search" name="ipAddress" id="ipAddress" value="<%=ipAddress%>" style="height: 35px;margin: 0px 0px;"/>
                                    </td>
                                    <td align="left" width="30%">
                                        <a href="javascript:search();" data-role="button" id="submit" style="height: 35px;margin: 0px 0px;">搜索</a>
                                    </td>
                                </tr>
                            </table>
                        </li>
                        <%
                        if (list != null && list.size() > 0) {
                        	for (PerformanceHostInfo info : list) {
                        		String subtype = info.getSubtype();
                        		if(subtype == null){
                        			subtype = "";
                        		}
                        %>
                        <li title="content">
                            <table style="width: 100%;text-align: left;">
                                <tr>
                                    <td width="40%" align="left">名称：&nbsp;&nbsp;</td><td width="60%"><%=info.getName()%></td>
                                </tr>
                                <tr>
                                    <td width="40%" align="left">IP地址：&nbsp;&nbsp;</td><td width="60%"><%=info.getIpAddress()%></td>
                                </tr>
                                <tr>
                                    <td width="40%" align="left">类型：&nbsp;&nbsp;</td><td width="60%"><%=subtype%></td>
                                </tr>
                                <tr>
                                    <td width="40%" align="left">连通率：</td><td width="60%"><%=info.getPing()%>%</td>
                                </tr>
                                <tr>
                                    <td width="40%" align="left">CPU利用率：</td><td width="60%"><%=info.getCpu()%>%</td>
                                </tr>
                                <tr>
                                    <td width="40%" align="left">内存利用率：</td><td width="60%"><%=info.getMemory()%>%</td>
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
            if (ipAddress != null) {
                %>
                contentData = "ipAddress=" + "<%=ipAddress%>";
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
            'url' : '<%=path%>' + '/performanceHostInfo/list.do',
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
        	var oldVal = $("#ipAddress").val();
			$("#ipAddress").css({"color":"#888"}).focus(function(){
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
        	//检查登录ip限制
    		var limitedip=$("#ipAddress").val();
    		if(limitedip!=''){
       			var arr=limitedip.split("\n");  
       			var regip= /^(([0-1]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}([0-1]?\d{1,2}|2[0-4]\d|25[0-5])$/;
        		for (var i=0;i<arr.length ;i++ ){ 
          			flag_ip=regip.test(arr[i]);
           			if(!flag_ip){
             			alert("请输入正确的IP地址");
             			return;
           			}
       			} 
    		}
        	
            var mainForm = document.getElementById("mainForm");
            mainForm.action = "<%=path%>/performanceHostInfo/list.do";
            mainForm.submit();
        }
    </script>
</html>
