/**
 * ClassName: topology.js
 * <p>用于展现拓扑图
 * 
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-7-4 上午11:54:57
 */

// info 信息框样式
var infoBgColor     = "#F5F5F5";
var infoBgImg       = "";           // path to background image;
var infoBorder      = "solid black 1px";
var infoBorderColor = "#003399";
var infoBorderWidth = 1;
var infoDelay       = 500;          // time span until tooltip shows up
                                    // [milliseconds]
var infoFontColor   = "#000000";
var infoFontFace    = "宋体,arial,helvetica,sans-serif";
var infoFontSize    = "12px";
var infoFontWeight  = "normal";     // alternative: "bold";
var infoPadding     = 3;            // spacing between border and content
var infoShadowColor = "";
var infoShadowWidth = 0;   
var infoTextAlign   = "left";
var infoTitleColor  = "#ffffff";    // color of caption text
var infoWidth       = 180;


(function($) {
    $.fn.show = function(url, topologyMapBg) {
        var contentDIV = $(this);
        $.ajax({
            type : "POST",
            url : url,
            dataType : "xml",
            processData: false,
            contentType : "application/x-www-form-urlencoded;charset=utf-8",  
            success : function (data) {
                var topology = new Topology(data, contentDIV, topologyMapBg);
                topology.show();
            }
        });
    };
})(jQuery);

function TopologyMapNode() {

    // id
    this.id = null;

    // 类型
    this.nodeType = null;

    // 图片
    this.imgValue = null;

    // X 位置
    this.x = 0;

    // Y 位置
    this.y = 0;

    // IP
    this.ip = null;

    // 别名
    this.alias = null;

    // 设备信息
    this.info = null;

    // 设备右键菜单
    this.menu = null;

    // 设备关联子图
    this.relationMap = null;
    
    // 设备图片对象
    this.imageElement = null;
    
    // 设备文本对象
    this.divTextElement = null;

    // 设备信息对象
    this.divInfoElement = null;

    // 设备别名上下空白
    this.aliasHSpace = 0;
    
    // 设备别名左右空白
    this.aliasVSpace = 0;
    
    // 是否被选中
    this.isSelected = false;
    
    // 设备移动之前的 X 位置
    this.beforeMoveX = 0;

    // 设备移动之前的 Y 位置
    this.beforeMoveY = 0;
    
    // 设备被鼠标按住状态
    this.mouseDownStatus = false;
};


function TopologyMapLine() {
    
    // XML链路 id
    this.lineid = null;

    // 链路 a
    this.a = null;
    
    // 链路 b
    this.b = null;
    
    // 链路颜色
    this.color = null;
    
    // 链路
    this.dash = null;
    
    // 链路宽度
    this.lineWidth = null;
    
    // 链路信息
    this.lineInfo = null;
    
    // 链路菜单
    this.lineMenu = null;

    // 链路id
    this.id = null;
    
    // 链路对象
    this.lineElement = null;
};

function TopologyMapBg() {
    
    // XML链路 id
    this.src = null;

    // 链路 a
    this.width = null;
    
    // 链路 b
    this.height = null;

    // 链路id
    this.id = null;
    
    // 链路对象
    this.Element = null;
};

Topology = function(xmldoc, contentDIV, topologyMapBg) {
    return this.init(xmldoc, contentDIV, topologyMapBg);
};

Topology.prototype = {

    // 拓扑图的 XML 对象
    xmldoc : null,
    
    // 拓扑图展现的 DIV
    contentDIV : null,
    
    // 拓扑图背景图片
    bgImgElement : null,
    
    canvas : null,
    
    // 拓扑图 XML 设备节点数据
    nodes : null,
    
    // 拓扑图 XML 设备链路数据
    lines : null,
    
    // 拓扑图 XML 设备双链路数据
    assistantlines : null,
    
    // 拓扑图 XML 设备示意数据
    demoLines : null,
    
    // 拓扑图设备节点对象数组
    topologyMapNodes : new Array(),
    
    // 拓扑图设备链路对象数组
    topologyMapLines : new Array(),

    // 拓扑图双链路对象数组
    topologyMapAssistantLines : new Array(),
    
    // 拓扑图示意链路对象数组
    topologyMapDemoLines : new Array(),
    
    timer : null,
    
    mouseOriX : null,

    mouseOriY : null,
    
    contentDIVLeft : null,

    contentDIVTop : null,
    
    // 使用  id , 以及 tagName 来创建一个element
    createElement: function (id , tagName){
        var element = document.createElement(tagName);
        element.id = id;
        return element;
    },

    init : function(xmldoc, contentDIV, topologyMapBg) {
        this.xmldoc = $(xmldoc);
        this.contentDIV = contentDIV;
        this.canvas = this.createElement("canvas", "canvas");
        this.canvas.width = topologyMapBg.width;
        this.canvas.height = topologyMapBg.height;
        this.contentDIV.append(this.canvas);
        
        this.contentDIV.width(topologyMapBg.width);
        this.contentDIV.height(topologyMapBg.height);
        this.contentDIV.css("background-image", "url('" + topologyMapBg.src + "')");
        
        // window.document.onselectstart = this.selectStart;
        /*
        this.contentDIV.unbind("mousedown");
        this.contentDIV.unbind("touchstart");
        this.contentDIV.live("mousedown touchstart", (function (topology) {
            return function (e) {
                topology.selectStart(e);
            };
        })(this));
        $("#show").live("mousedown touchstart", (function (topology) {
            return function (e) {
                topology.selectStart(e);
            };
        })(this));
        $("#show").live("mouseup touchend", (function (topology) {
            return function (e) {
                $(document).unbind("mousemove");
                $(document).unbind("touchmove");
                $("#show").css("cursor","default");
                topology.contentDIV.css("cursor","default");
            };
        })(this));
        $(document).live("mouseup touchend", (function (topology) {
            return function (e) {
                $(document).unbind("mousemove");
                $(document).unbind("touchmove");
                topology.contentDIV.css("cursor","default");
                $("#show").css("cursor","default");
            };
        })(this));
        */
        this.contentDIV.live("mousedown touchstart", (function (topology) {
            return function (e) {
                topology.hideTopologyMapNodeInfo(e);
            };
        })(this));
    },
    
    // 处理选框
    selectStart: function(event) {
        if (event.target.id == this.contentDIV.attr("id") || event.target.id == $("#show").attr("id") ||
            event.target.tagName == "BODY" || event.target.id == "canvas") {
            this.contentDIV.css("cursor","move");
            $("#show").css("cursor","move");
            var offset = this.contentDIV.offset();          //DIV在页面的位置
            
            var x = 0;
            var y = 0;
            if (event.type == "touchstart") {
                event.preventDefault();
                var touch = event.originalEvent.touches[0] || event.originalEvent.changedTouches[0];

                x = touch.pageX - offset.left;                  //获得鼠标指针离DIV元素左边界的距离
                y = touch.pageY - offset.top;                   //获得鼠标指针离DIV元素上边界的距离
            } else {
                x = event.pageX - offset.left;                  //获得鼠标指针离DIV元素左边界的距离
                y = event.pageY - offset.top;                   //获得鼠标指针离DIV元素上边界的距离
            }
           $(document).live("mousemove touchmove", function(ev) {    //绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件
               $("#content").stop();//加上这个之后
               $("#show").stop();//加上这个之后

               var _x = 0;
               var _y = 0;
               if (ev.type == "touchmove") {
                   ev.preventDefault();
                   var touch = ev.originalEvent.touches[0] || ev.originalEvent.changedTouches[0];

                   _x = touch.pageX - x;//获得X轴方向移动的值
                   _y = touch.pageY - y;//获得Y轴方向移动的值
               } else {
                   _x = ev.pageX - x;//获得X轴方向移动的值
                   _y = ev.pageY - y;//获得Y轴方向移动的值
               }
                
               $("#content").animate({left:_x+"px",top:_y+"px"}, 15);
           });
        }
    },
    
    move : function(event) {
        var eventX = event.pageX;
        var eventY = event.pageY;
        
        var beforeMoveX = this.mouseOriX;
        var beforeMoveY = this.mouseOriY;
        
        this.contentDIV.offset().left = this.contentDIVLeft + eventX - beforeMoveX;
        this.contentDIV.offset().top = this.contentDIVTop + eventY - beforeMoveY;
    },
    
    clearTimer : function(timer) {
        if (timer) {
            window.clearInterval(timer);
        }
    },


    updatePosition : function () {
    },

    show : function () {
        this.parseData();
        //wupinlong add 使拓扑图整体往左边移动500px,往上面移动80px
        // $("#content").animate({left:-550+"px",top:-80+"px"}, 15);
    },

    /**
     * 解析数据
     */
    parseData : function() {
        this.nodes = this.xmldoc.find("nodes").children("node");
        this.nodes.each((function(topology){
            return function(i) {
                var topologyMapNode = topology.createTopologyMapNode($(this));
                topology.topologyMapNodes.push(topologyMapNode);
                topology.addTopologyMapNode(topologyMapNode);
            };
        })(this));
        this.lines = this.xmldoc.find("lines").children("line");
        this.lines.each((function(topology){
            return function(i) {
                var topologyMapLine = topology.createTopologyMapLine($(this));
                topology.topologyMapLines.push(topologyMapLine);
                topology.addTopologyMapLine(topologyMapLine);
            };
        })(this));
        
        //add for topology domeLines
        this.lines = this.xmldoc.find("demoLines").children("demoLine");
        this.lines.each((function(topology){
            return function(i) {
                var topologyMapLine = topology.createTopologyMapLine($(this));
                topology.topologyMapLines.push(topologyMapLine);
                topology.addTopologyMapLine(topologyMapLine);
            };
        })(this));
        
    },
    
    //========================= 以下用于创建拓扑图上的设备图元  ==============================

    /**
     * createTopologyMapNode:
     * <p>通过拓扑图XML文件上的节点创建一个拓扑图节点
     *
     * @param   node
     *          - 拓扑图XML文件上的节点
     * @return  {@link TopologyMapNode}
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     *
     * @since   v1.01
     */
    createTopologyMapNode : function(node) {
        var topologyMapNode = new TopologyMapNode();
        topologyMapNode.id = node.children("id").text();
        topologyMapNode.nodeType = node.children("id").attr("category");
        topologyMapNode.imgValue = node.children("img").text();
        topologyMapNode.x = node.children("x").text();
        topologyMapNode.y = node.children("y").text();
        topologyMapNode.ip = node.children("ip").text();
        topologyMapNode.alias = node.children("alias").text();
        topologyMapNode.info = "正在获取数据请稍后";
        topologyMapNode.menu = node.children("menu").text();
        topologyMapNode.relationMap = node.children("relationMap").text();
        return topologyMapNode;
    },

    /**
     * 
     * addTopologyMapNode:
     * <p>将拓扑图节点添加至拓扑图上显示
     *
     * @param   topologyMapNode
     *          {@link TopologyMapNode} 类型的拓扑图节点
     *
     * @since   v1.01
     */
    addTopologyMapNode : function(topologyMapNode) {
        var id = topologyMapNode.id;
        var nodeType = topologyMapNode.nodeType;
        var imgValue = topologyMapNode.imgValue;
        var x = topologyMapNode.x;
        var y = topologyMapNode.y;
        var ip = topologyMapNode.ip;
        var alias = topologyMapNode.alias;
        var info = topologyMapNode.info;
        var menu = topologyMapNode.menu;
        var relationMap = topologyMapNode.relationMap;

        //getConfine(x, y);     // 获取最大边界，给 maxWidth，maxHeight 赋值

        // 创建图片对象
        var imageElement = this.createTopologyMapNodeImg(topologyMapNode);
        topologyMapNode.imageElement = imageElement;
        
        this.contentDIV.append(imageElement);

        // 创建文本对象
        var divTextElement = this.createTopologyMapNodeText(topologyMapNode);
        topologyMapNode.divTextElement = divTextElement;
        
        this.contentDIV.append(divTextElement);
        
        // 双击图元事件yangjun
        topologyMapNode.imageElement.onclick = (function(topology, topologyMapNode_) {
            return function () {
                topology.showTopologyMapNodeInfo(topologyMapNode_);
            };
        })(this, topologyMapNode);

    },
    
    /**
     * createTopologyMapNodeImg:
     * <p>创建拓扑图节点的图片对象
     *
     * @param   topologyMapNode
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     * @return  imageElement
     *          - {@link Image} 类型的拓扑图节点的图片对象
     *
     * @since   v1.01
     */
    createTopologyMapNodeImg : function (topologyMapNode){
        var id = topologyMapNode.id;
        var nodeType = topologyMapNode.nodeType;
        var imgValue = topologyMapNode.imgValue;
        var x = topologyMapNode.x;
        var y = topologyMapNode.y;
        var info = topologyMapNode.info;
        var relationMap = topologyMapNode.relationMap;
        
        // 创建图片对象
        var imageElement = this.createElement("node_" + id, "img");
        
        if(info == "示意设备") { // yangjun add 区分示意设备
            imageElement.name = relationMap + ",1";// 节点关联的子图文件名和示意设备判断标记
        } else {
            imageElement.name = relationMap + ",0";;// 节点关联的子图文件名和示意设备判断标记
        }
        imageElement.style.position = "absolute";
        imageElement.style.cursor = "hand";
        imageElement.style.left = x;
        imageElement.style.top = y;
        imageElement.src = "/mynms/resource/" + imgValue;
        
        imageElement = this.setTopologyMapNodeSize(topologyMapNode, imageElement);
        return imageElement;
    },
    
    /**
     * setTopologyMapNodeSize:
     * <p>设置拓扑图节点的图片对象的大小
     *
     * @param   topologyMapNode
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     * @param   imageElement
     *          - {@link Image} 类型的拓扑图节点的图片对象
     * @return  imageElement
     *          - {@link Image} 类型的拓扑图节点的图片对象
     *
     * @since   v1.01
     */
    setTopologyMapNodeSize: function(topologyMapNode, imageElement) {
        var nodeType = topologyMapNode.nodeType;
        var aliasHSpace = 0;
        var aliasVSpace = 0;
        if(nodeType == "net_server") {
            imageElement.style.width = 65;
            imageElement.style.height = 26;
            aliasHSpace = 10;
            aliasVSpace = 26;           
        } else if(nodeType == "机柜") {
            imageElement.style.width = 95;
            imageElement.style.height = 371;
            aliasHSpace = 10;
            aliasVSpace = 371;
        } else if(nodeType == "标题") {
            imageElement.style.width = 10;
            imageElement.style.height = 10;
            aliasHSpace = 5;
            aliasVSpace = 5;
        } else if(nodeType == "服务器") {
            imageElement.style.width = 65;
            imageElement.style.height = 26;
            aliasHSpace = 5;
            aliasVSpace = 20;
        } else if(nodeType == "ups") {
            imageElement.style.width = 68;
            imageElement.style.height = 76;
            aliasHSpace = 10;
            aliasVSpace = 70;
        } else if(nodeType == "weblogic") {
            imageElement.style.width = 32;
            imageElement.style.height = 21;
            aliasHSpace = 20;
            aliasVSpace = 22;
        } else if(nodeType == "ftp") {
            imageElement.style.width = 32;
            imageElement.style.height = 32;
            aliasHSpace = 20;
            aliasVSpace = 33;
        } else if(nodeType == "web") {
            imageElement.style.width = 32;
            imageElement.style.height = 32;
            aliasHSpace = 20;
            aliasVSpace = 34;
        } else if(nodeType == "iis") {
            imageElement.style.width = 30;
            imageElement.style.height = 14;
            aliasHSpace = 30;
            aliasVSpace = 16;
        } else if(nodeType == "mail") {
            imageElement.style.width = 30;
            imageElement.style.height = 20;
            aliasHSpace = 15;
            aliasVSpace = 21;
        } else if(nodeType == "机柜") {
            imageElement.style.width = 95;
            imageElement.style.height = 371;
            aliasHSpace = 10;
            aliasVSpace = 371;
        } else if(nodeType == "标题") {
            imageElement.style.width = 10;
            imageElement.style.height = 10;
            aliasHSpace = 5;
            aliasVSpace = 5;
        } else {
            imageElement.style.width = 30;
            imageElement.style.height = 30;
            aliasHSpace = 24;
            aliasVSpace = 28;
        }
        topologyMapNode.aliasHSpace = aliasHSpace;
        topologyMapNode.aliasVSpace = aliasVSpace;
        return imageElement;
    },

    /**
     * createTopologyMapNodeText:
     * <p>创建拓扑图节点的文本对象
     *
     * @param   topologyMapNode
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     * @return  divTextElement
     *          - {@link Div} 类型的拓扑图节点的文本对象
     *
     * @since   v1.01
     */
    createTopologyMapNodeText: function(topologyMapNode) {
        var id = topologyMapNode.id;
        var x = topologyMapNode.x;
        var y = topologyMapNode.y;
        var ip = topologyMapNode.ip;
        var alias = topologyMapNode.alias;
        var aliasHSpace = topologyMapNode.aliasHSpace;
        var aliasVSpace = topologyMapNode.aliasVSpace;
        
        // 显示设备文本
        var divTextElement = this.createElement("text_" + id, "div");
        
        divTextElement.style.position = "absolute";
        divTextElement.style.width = "80";
        divTextElement.style.height = "20";
        divTextElement.style.left = parseInt(x, 10) - aliasHSpace;
        divTextElement.style.top = parseInt(y, 10) + aliasVSpace;
        divTextElement.style.fontSize = "12px";
        divTextElement.align = "center";
        divTextElement.innerHTML = alias;// 显示设备别名
        
        return divTextElement;
    },

    /**
     * createTopologyMapNodeInfo:
     * <p>创建拓扑图设备信息对象
     *
     * @param   topologyMapNode
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     *
     * @since   v1.01
     */
    createTopologyMapNodeInfo: function(topologyMapNode) {
        this.divInfoElement = $("#info_div");
        if (!this.divInfoElement) {
            this.divInfoElement.css({ visibility: "hidden"});
        }
        return this.divInfoElement;
    },

    /**
     * showTopologyMapNodeInfo:
     * <p>展示拓扑图设备信息对象
     *
     * @param   topologyMapNode
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     *
     * @since   v1.01
     */
    showTopologyMapNodeInfo: function(topologyMapNode) {
        var id = topologyMapNode.id;
        var nodeType = topologyMapNode.nodeType;
        var divInfoElement = this.createTopologyMapNodeInfo(topologyMapNode);
        this.divInfoElement = divInfoElement;
//        $("#performanceNetInfo").unbind("click tap");
//        $("#alarmInfo").unbind("click tap");
//        $("#performanceNetInfo").live("click tap", (function (topology, topologyMapNode) {
//            return function (e) {
//                var url = $("#performanceNetInfo").attr("url");
//                topology.changePage(url, topologyMapNode);
//            };
//        })(this, topologyMapNode));
//        $("#alarmInfo").live("click tap", (function (topology, topologyMapNode) {
//            return function (e) {
//                var url = $("#alarmInfo").attr("url");
//                topology.changePage(url, topologyMapNode);
//            };
//        })(this, topologyMapNode));
        if (topologyMapNode.relationMap) {
            $("#xmlName").val(topologyMapNode.relationMap);
            this.changePage($("#topologyMap").val() + "?xmlName=" + $("#xmlName").val(), topologyMapNode);
        } else {
            $("#nodeId").val(topologyMapNode.id.substring(3));
            $("#nodeType").val(topologyMapNode.id.substring(0, 3));
            this.divInfoElement.css({ visibility: "visible"});
            this.divInfoElement.css({left: 30 + parseInt(topologyMapNode.x.replace("px", "")), top: 30 + parseInt(topologyMapNode.y.replace("px", ""))});
        }
    },

/**
     * showTopologyMapNodeInfo:
     * <p>展示拓扑图设备信息对象
     *
     * @param   topologyMapNode
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     *
     * @since   v1.01
     */
    hideTopologyMapNodeInfo: function() {
        this.divInfoElement.css({ visibility: "hidden"});
    },

    /**
     * showTopologyMapNodePerformanceInfo:
     * <p>展示拓扑图设备性能信息
     *
     * @param   topologyMapNode
     *          - {@link TopologyMapNode} 类型的拓扑图节点
     *
     * @since   v1.01
     */
    changePage : function(url, topologyMapNode) {
        var mainForm = document.getElementById("mainForm");
        mainForm.action = url;
        mainForm.submit();
    },
    //========================= 以下用于创建拓扑图上的链路  ==============================

    /**
     * createTopologyMapLine:
     * <p>通过拓扑图XML文件上的<code>line<code>节点创建一个拓扑图链路
     *
     * @param   node
     *          - 拓扑图XML文件上的 line 节点
     * @return  {@link TopologyMapLine}
     *          - {@link TopologyMapLine} 拓扑图链路对象
     *
     * @since   v1.01
     */
    createTopologyMapLine: function(node) {
        var topologyMapLine = new TopologyMapLine();
        topologyMapLine.lineid = node.attr("id");
        topologyMapLine.a = node.children("a").text();
        topologyMapLine.b = node.children("b").text();
        topologyMapLine.color = "green";
        topologyMapLine.dash = node.children("dash").text();
        topologyMapLine.lineWidth = node.children("lineWidth").text();
        topologyMapLine.lineInfo = "正在获取数据请稍后";//node.children("lineInfo").text();
        // this.getTopologyMapLineMenuData(topologyMapLine);
        topologyMapLine.id = "line_" + topologyMapLine.a + "_"+ topologyMapLine.b;
        return topologyMapLine;
    },
    
    /**
     * addTopologyMapLine:
     * <p>将拓扑图链路添加至拓扑图上显示
     *
     * @param   topologyMapLine
     *          - {@link TopologyMapLine} 拓扑图链路对象
     *
     * @since   v1.01
     */
    addTopologyMapLine: function(topologyMapLine) {
        var a = topologyMapLine.a;
        var b = topologyMapLine.b;
        var color = topologyMapLine.color;
        var dash = topologyMapLine.dash;
        var lineWidth = topologyMapLine.lineWidth;
        var lineInfo = topologyMapLine.lineInfo;
        var lineMenu = topologyMapLine.lineMenu;
        var id = topologyMapLine.id;

        var context = this.canvas.getContext("2d");
        context.beginPath();
        context.moveTo(parseInt(document.all("node_" + a).style.left) + parseInt(document.all("node_" + a).style.width)/2, parseInt(document.all("node_" + a).style.top) + parseInt(document.all("node_" + a).style.height)/2);
        context.lineTo(parseInt(document.all("node_" + b).style.left) + parseInt(document.all("node_" + b).style.width)/2, parseInt(document.all("node_" + b).style.top) + parseInt(document.all("node_" + b).style.height)/2);
        context.strokeStyle = color;
        context.lineWidth = lineWidth;
        context.closePath();
        context.stroke();

    }
};