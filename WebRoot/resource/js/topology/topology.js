// info ��Ϣ����ʽ
var infoBgColor     = "#F5F5F5";
var infoBgImg       = "";           // path to background image;
var infoBorder      = "solid black 1px";
var infoBorderColor = "#003399";
var infoBorderWidth = 1;
var infoDelay       = 500;          // time span until tooltip shows up
									// [milliseconds]
var infoFontColor   = "#000000";
var infoFontFace    = "����,arial,helvetica,sans-serif";
var infoFontSize    = "12px";
var infoFontWeight  = "normal";     // alternative: "bold";
var infoPadding     = 3;            // spacing between border and content
var infoShadowColor = "";
var infoShadowWidth = 0;   
var infoTextAlign   = "left";
var infoTitleColor  = "#ffffff";    // color of caption text
var infoWidth       = 180;

// �Ҽ��˵����� �Ժ����ֱ���� divMenuElement
var clickObj = null;
// �Ҽ��˵����� �Ժ����ֱ���� divMenuElement
var clickLineObj = null;
// ����ѡ�е�ͼԪ����
var objMoveAry = new Array();
// �����¼��Ŀؼ�����
var obj = null;
// �����¼��Ŀؼ�����,���ڸı�ѡ��ͼƬ����ʽ��		
var objStyle = null;
// �������ַ���
var strSearch = null;
// yangjun addCtrl��ѡ�е�ͼԪ
var objEntityAry = new Array();
// ��ŵ�ǰ�¼��ؼ����������
var line_ids = new Array();
// �ж�ѡ��
var selectStatus = false;
// FIXME: �ñ���δ����
var movedObjFlag = false;
// �ж�ctrl
var ctrlStatus = false;

var isRemoved = false;

var lineMoveAry = new Array();
// ������·�������yangjun add
var assLineMoveAry = new Array();
// ʾ����·������� yangjun add
var demoLineMoveAry = new Array();
// ����޸Ĺ��Ķ���id������
var tempArray = new Array();

window.document.onselectstart = selectStart;

var topologyMapObject = null;

Array.prototype.contains = function()
{ 
	for (var i = 0; i < this.length; i++)
	{
		if (arguments[0] == this[i])
		{
			return true;
		}
	}
	return false;
};

var nodeobj = function(id,image,category,xmlname){
	this.id = id;
    this.category = category;
    this.image = image;
    this.xmlname = xmlname;
}
var linkobj = function(id,lineid,color,xmlname,type){
	this.id = id;
    this.color = color;
    this.lineid = lineid;
    this.xmlname = xmlname;
    this.type = type;
}

function TopologyMapNode() {

	// id
	this.id = null;

	// ����
	this.nodeType = null;

	// ͼƬ
	this.imgValue = null;

	// X λ��
	this.x = 0;

	// Y λ��
	this.y = 0;

	// IP
	this.ip = null;

	// ����
	this.alias = null;

	// �豸��Ϣ
	this.info = null;

	// �豸�Ҽ��˵�
	this.menu = null;

	// �豸������ͼ
	this.relationMap = null;
	
	// �豸ͼƬ����
	this.imageElement = null;
	
	// �豸�ı�����
	this.divTextElement = null;

	// �豸��Ϣ����
	this.divInfoElement = null;

	// �豸�������¿հ�
	this.aliasHSpace = 0;
	
	// �豸�������ҿհ�
	this.aliasVSpace = 0;
	
	// �Ƿ�ѡ��
	this.isSelected = false;
	
	// �豸�ƶ�֮ǰ�� X λ��
	this.beforeMoveX = 0;

	// �豸�ƶ�֮ǰ�� Y λ��
	this.beforeMoveY = 0;
	
	// �豸����갴ס״̬
	this.mouseDownStatus = false;
};


function TopologyMapLine() {
	
	// XML��· id
	this.lineid = null;

	// ��· a
	this.a = null;
	
	// ��· b
	this.b = null;
	
	// ��·��ɫ
	this.color = null;
	
	// ��·
	this.dash = null;
	
	// ��·���
	this.lineWidth = null;
	
	// ��·��Ϣ
	this.lineInfo = null;
	
	// ��·�˵�
	this.lineMenu = null;

	// ��·id
	this.id = null;
	
	// ��·����
	this.lineElement = null;
};

function TopologyMapOperation() {

	// ɾ���豸
	this.deleteTopolgyMapNode = false;

	// ɾ��ʾ���豸
	this.deleteTopolgyMapHinNode = false;
	
	// ɾ����·
	this.deleteTopolgyMapLine = false;

	// ɾ��ʾ����·
	this.deleteTopolgyMapHinLine = false;
	
	// �޸���·
	this.updateTopolgyMapLine = false;

	// �޸�ʾ����·
	this.updateTopolgyMapHinLine = false;
};

function TopologyMapObject() {
	
	// TopologyMapObject �౾�� �ñ���Ϊ�����ȫ�ֱ������ڻص���תʱʹ��
	ObjectSelf = this;

	// ����ͼ�� XML �ļ�
	this.xmlName = null;

	// ����ͼ�� XML ����
	this.xmldoc = null;
	
	// ����ͼ�����
	this.maxWidth = 0;
	
	// ����ͼ���߶�
	this.maxHeight = 0;
	
	// ����ͼ��С�߶�
	this.minWidth = 0;
	
	// ����ͼ��С�߶�
	this.minHeight = 0;
	
	// ����ͼ XML �豸�ڵ�����
	this.nodes = null;
	
	// ����ͼ XML �豸��·����
	this.lines = null;
	
	// ����ͼ XML �豸˫��·����
	this.assistantlines = null;
	
	// ����ͼ XML �豸ʾ������
	this.demoLines = null;
	
	// ����ͼ�豸�ڵ��������
	this.topologyMapNodes = new Array();
	
	// ����ͼ�豸��·��������
	this.topologyMapLines = new Array();

	// ����ͼ˫��·��������
	this.topologyMapAssistantLines = new Array();
	
	// ����ͼʾ����·��������
	this.topologyMapDemoLines = new Array();
	
	// ����ͼ�豸�ڵ��������ڸ���
	this.nodeobjArray = new Array();
	
	// ����ͼ��·�ڵ��������ڸ���
	this.linkobjArray = new Array();
	
	// �豸��Ϣ����
	this.divInfoElement = null;
	
	// �豸�˵�����
	this.divMenuElement = null;
	
	// ѡ�е��豸������
	this.selectedTopologyMapNodes = new Array();
	
	// ����ʼλ�� X ���ڼ����ƶ�
	this.mouseOriX = null;
	
	// ����ʼλ�� Y ���ڼ����ƶ�
	this.mouseOriY = null;
	
	// ����ѡ��ʱ���õ����������ĸ�����
	this.imgTop = document.getElementById("imgTop");

	// ����ѡ��ʱ���õ����������ĸ�����
	this.imgLeft = document.getElementById("imgLeft");

	// ����ѡ��ʱ���õ����������ĸ�����
	this.imgBottom = document.getElementById("imgBottom");

	// ����ѡ��ʱ���õ����������ĸ�����
	this.imgRight = document.getElementById("imgRight");

	// ����ͼչ�ֵ� DIV
	this.divLayer = document.getElementById("divLayer");

	// ����ͼ����Ȩ��
	this.topologyMapOperation = new TopologyMapOperation();
}

TopologyMapObject.prototype = {
	
	// ʹ��  id , �Լ� tagName ������һ��element
	createElement: function (id , tagName){
		var element = document.createElement(tagName);
		element.id = id;
		return element;
	},
	
	// ���� XML ����
	loadXML:function(url) {
		this.initXML(url);
		this.parseData();
	},
	
	initXML: function(url) {
		var http = new ActiveXObject("Microsoft.XMLHTTP");
		this.xmldoc = new ActiveXObject("Microsoft.XMLDOM");
		http.open("POST", url, false);
		http.send();
		this.xmldoc.async = false;
		this.xmldoc.loadXML(http.responseText);
	},
	
	parseData: function() {
		// ����nodes�ڵ�
		this.nodes = this.xmldoc.getElementsByTagName("node");
		var nodeNum = this.nodes.length;
		var i = 0;
		while (i < nodeNum) {
			var node = this.nodes[i];
			var topologyMapNode = this.createTopologyMapNode(node);
			this.topologyMapNodes.push(topologyMapNode);
			this.addTopologyMapNode(topologyMapNode);
			this.nodeobjArray.push(new nodeobj(topologyMapNode.imageElement.id,topologyMapNode.imageElement.src,topologyMapNode.nodeType,fatherXML));
			i++;
		}
		// ����lines�ڵ�
		this.lines = this.xmldoc.getElementsByTagName("line");
		var lineNum = this.lines.length;
		var j = 0;
		while (j < lineNum) {
			var lineObj = this.lines[j];
			var topologyMapLine = this.createTopologyMapLine(lineObj);
			this.topologyMapLines.push(topologyMapLine);
			this.addTopologyMapLine(topologyMapLine);
			this.linkobjArray.push(new linkobj(topologyMapLine.id,topologyMapLine.lineid,topologyMapLine.color,fatherXML,"line"));
			j++;
		}
		
		// ����Assistantlines�ڵ�
		this.assistantlines = this.xmldoc.getElementsByTagName("assistant_line");
		var assistantlineNum = this.assistantlines.length;
		var k = 0;
		while (k < assistantlineNum) {
			var line = this.assistantlines[k];
			var topologyMapAssistantLine = this.createTopologyMapAssistantLine(line);
			this.topologyMapAssistantLines.push(topologyMapAssistantLine);
			this.addTopologyMapAssistantLine(topologyMapAssistantLine);
			this.linkobjArray.push(new linkobj(topologyMapAssistantLine.id,topologyMapAssistantLine.lineid,topologyMapAssistantLine.color,fatherXML,"assistant"));
			k++;
		}
		
		// ����demoLines�ڵ�
		this.demoLines = this.xmldoc.getElementsByTagName("demoLine");
		var demolineNum = this.demoLines.length;
		var m = 0;
		while (m < demolineNum) {
			var line = this.demoLines[m];
			var topologyMapDemoLine = this.createTopologyMapDemoLine(line);
			this.topologyMapDemoLines.push(topologyMapDemoLine);
			this.addTopologyMapDemoLine(topologyMapDemoLine);
			this.linkobjArray.push(new linkobj(topologyMapDemoLine.id,topologyMapDemoLine.lineid,topologyMapDemoLine.color,fatherXML,"demo"));
			m++;
		}
		// zoomProcDlg("out");// �ر�����
	},
	
	createTopologyMapNode: function(node) {
		var topologyMapNode = new TopologyMapNode();
		topologyMapNode.id = node.getElementsByTagName("id")[0].text;
		topologyMapNode.nodeType = node.getElementsByTagName("id")[0].getAttribute("category");
		topologyMapNode.imgValue = "../../resource/"+node.getElementsByTagName("img")[0].text;
		topologyMapNode.x = node.getElementsByTagName("x")[0].text;
		topologyMapNode.y = node.getElementsByTagName("y")[0].text;
		topologyMapNode.ip = node.getElementsByTagName("ip")[0].text;
		topologyMapNode.alias = node.getElementsByTagName("alias")[0].text;
		topologyMapNode.info = "���ڻ�ȡ����";//node.getElementsByTagName("info")[0].text;
		//topologyMapNode.menu = node.getElementsByTagName("menu")[0].text;
		this.getTopologyMapNodeMenuData(topologyMapNode);
		topologyMapNode.relationMap = node.getElementsByTagName("relationMap")[0].text;
		
		return topologyMapNode
	},
	
	createTopologyMapLine: function(lineObj) {
		var topologyMapLine = new TopologyMapLine();
		topologyMapLine.lineid = lineObj.getAttribute("id");
		topologyMapLine.a = lineObj.getElementsByTagName("a")[0].text;
		topologyMapLine.b = lineObj.getElementsByTagName("b")[0].text;
		topologyMapLine.color = "green";
		topologyMapLine.dash = lineObj.getElementsByTagName("dash")[0].text;
		topologyMapLine.lineWidth = lineObj.getElementsByTagName("lineWidth")[0].text;
		topologyMapLine.lineInfo = "";//lineObj.getElementsByTagName("lineInfo")[0].text;
		this.getTopologyMapLineMenuData(topologyMapLine);
		topologyMapLine.id = "line_" + topologyMapLine.a + "_"+ topologyMapLine.b;
		return topologyMapLine;
	},

	createTopologyMapAssistantLine: function(lineObj) {
		var topologyMapLine = new TopologyMapLine();
		topologyMapLine.lineid = lineObj.getAttribute("id");
		topologyMapLine.a = lineObj.getElementsByTagName("a")[0].text;
		topologyMapLine.b = lineObj.getElementsByTagName("b")[0].text;
		topologyMapLine.color = "blue";
		topologyMapLine.dash = lineObj.getElementsByTagName("dash")[0].text;
		topologyMapLine.lineWidth = lineObj.getElementsByTagName("lineWidth")[0].text;
		topologyMapLine.lineInfo = "���ڻ�ȡ����";//lineObj.getElementsByTagName("lineInfo")[0].text;
		this.getTopologyMapLineMenuData(topologyMapLine);
		topologyMapLine.id = "line_" + topologyMapLine.a + "_"+ topologyMapLine.b + "#assistant";
		return topologyMapLine;
	},
	
	createTopologyMapDemoLine: function(lineObj) {
		var topologyMapLine = new TopologyMapLine();
		topologyMapLine.lineid = lineObj.getAttribute("id");
		topologyMapLine.a = lineObj.getElementsByTagName("a")[0].text;
		topologyMapLine.b = lineObj.getElementsByTagName("b")[0].text;
		topologyMapLine.color = lineObj.getElementsByTagName("color")[0].text;
		topologyMapLine.dash = lineObj.getElementsByTagName("dash")[0].text;
		topologyMapLine.lineWidth = lineObj.getElementsByTagName("lineWidth")[0].text;
		topologyMapLine.lineInfo = "";//lineObj.getElementsByTagName("lineInfo")[0].text;
		this.getTopologyMapLineMenuData(topologyMapLine);
		topologyMapLine.id = "line_" + topologyMapLine.a + "_"+ topologyMapLine.b + "#demoline";
		return topologyMapLine;
	},
	
	// ��������ͼ�ڵ�ͼƬ����
	createTopologyMapNodeImg: function (topologyMapNode){
		var id = topologyMapNode.id;
		var nodeType = topologyMapNode.nodeType;
		var imgValue = topologyMapNode.imgValue;
		var x = topologyMapNode.x;
		var y = topologyMapNode.y;
		var info = topologyMapNode.info;
		var relationMap = topologyMapNode.relationMap;
		
		// ����ͼƬ����
		var imageElement = this.createElement("node_" + id, "v:image");
		if(info == "ʾ���豸") { // yangjun add ����ʾ���豸
			imageElement.name = relationMap + ",1";// �ڵ��������ͼ�ļ�����ʾ���豸�жϱ��
		} else {
		    imageElement.name = relationMap + ",0";;// �ڵ��������ͼ�ļ�����ʾ���豸�жϱ��
		}
		imageElement.style.position = "absolute";
		imageElement.style.cursor = "hand";
		imageElement.style.left = x;
		imageElement.style.top = y;
		imageElement.src = imgValue;
		
		imageElement = this.setTopologyMapNodeSize(topologyMapNode, imageElement);
		return imageElement;
	},

	// �����豸��ʾ�Ĵ�С
	setTopologyMapNodeSize: function(topologyMapNode, imageElement) {
		var nodeType = topologyMapNode.nodeType;
		var aliasHSpace = 0;
		var	aliasVSpace = 0;
		if(nodeType == "net_server") {
			imageElement.style.width = 65;
			imageElement.style.height = 26;
			aliasHSpace = 10;
			aliasVSpace = 26;			
		} else if(nodeType == "����") {
			imageElement.style.width = 95;
			imageElement.style.height = 371;
			aliasHSpace = 10;
			aliasVSpace = 371;
		} else if(nodeType == "����") {
			imageElement.style.width = 10;
			imageElement.style.height = 10;
			aliasHSpace = 5;
			aliasVSpace = 5
		} else if(nodeType == "������") {
			imageElement.style.width = 65;
			imageElement.style.height = 26;
			aliasHSpace = 5;
			aliasVSpace = 20
		} else if(nodeType == "ups") {
			imageElement.style.width = 68;
			imageElement.style.height = 76;
			aliasHSpace = 10;
			aliasVSpace = 70
		} else if(nodeType == "weblogic") {
			imageElement.style.width = 32;
			imageElement.style.height = 21;
			aliasHSpace = 20;
			aliasVSpace = 22
		} else if(nodeType == "ftp") {
			imageElement.style.width = 32;
			imageElement.style.height = 32;
			aliasHSpace = 20;
			aliasVSpace = 33
		} else if(nodeType == "web") {
			imageElement.style.width = 32;
			imageElement.style.height = 32;
			aliasHSpace = 20;
			aliasVSpace = 34
		} else if(nodeType == "iis") {
			imageElement.style.width = 30;
			imageElement.style.height = 14;
			aliasHSpace = 30;
			aliasVSpace = 16
		} else if(nodeType == "mail") {
			imageElement.style.width = 30;
			imageElement.style.height = 20;
			aliasHSpace = 15;
			aliasVSpace = 21
		} else if(nodeType == "����") {
			imageElement.style.width = 95;
			imageElement.style.height = 371;
			aliasHSpace = 10;
			aliasVSpace = 371;
		} else if(nodeType == "����") {
			imageElement.style.width = 10;
			imageElement.style.height = 10;
			aliasHSpace = 5;
			aliasVSpace = 5
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
	
	// ��ʾ�豸��Ϣ
	showTopologyMapNodeInfo: function(topologyMapNode) {
		var id = topologyMapNode.id;
		var nodeType = topologyMapNode.nodeType;
		var divInfoElement = this.createTopologyMapNodeInfo(topologyMapNode);
		this.divInfoElement = divInfoElement;
		TopoRemoteService.getShowMessage(id, nodeType, fatherXML, {
			callback:function(data){
				if(data){
				    ObjectSelf.divInfoElement.innerHTML = data;
				}
			}
		});
		this.divInfoElement.style.visibility = "visible"; 
	},
	
	// �����豸��Ϣ
	hideTopologyMapNodeInfo: function(topologyMapNode) {
		this.divInfoElement.style.visibility = "hidden"; 
	},

	// ��ʾ�豸��ϸ��Ϣ����ת��������ͼ
	showTopologyMapNodeDetail: function(topologyMapNode) {
		var id = topologyMapNode.id;
		var imageElement = topologyMapNode.imageElement;
		if(imageElement.name.substring(0, imageElement.name.lastIndexOf(",")) !="" ){
         	 if(imageElement.name.substring(0, imageElement.name.lastIndexOf(","))=="network.jsp"){
         	     window.parent.parent.location = "../network/index.jsp";
         	 }else{
         	     window.parent.parent.location = "../submap/index.jsp?submapXml=" + imageElement.name.substring(0, imageElement.name.lastIndexOf(","));
         	 }
         }else{
             showalert(id);
             window.parent.parent.opener.focus();
         }
	},

	// ��������ͼ�豸�ı�����
	createTopologyMapNodeText: function(topologyMapNode) {
		var id = topologyMapNode.id;
		var x = topologyMapNode.x;
		var y = topologyMapNode.y;
		var ip = topologyMapNode.ip;
		var alias = topologyMapNode.alias;
		var aliasHSpace = topologyMapNode.aliasHSpace;
		var aliasVSpace = topologyMapNode.aliasVSpace;
		
		// ��ʾ�豸�ı�
		var divTextElement = this.createElement("text_" + id, "div");
		
		divTextElement.style.position = "absolute";
		divTextElement.style.width = "80";
		divTextElement.style.height = "20";
		divTextElement.style.left = parseInt(x, 10) - aliasHSpace;
		divTextElement.style.top = parseInt(y, 10) + aliasVSpace;
		divTextElement.style.fontSize = "12px";
		divTextElement.align = "center";
		if (g_viewFlag == 0) {
			divTextElement.innerHTML = alias;// ��ʾ�豸����
		} else {
			divTextElement.innerHTML = ip;// ��ʾ�豸IP
		}
		return divTextElement;
	},
	
	// ��������ͼ�豸��Ϣ����
	createTopologyMapNodeInfo: function(topologyMapNode) {
		var id = topologyMapNode.id;
		var x = topologyMapNode.imageElement.style.left;
		var y = topologyMapNode.imageElement.style.top;
		var info = topologyMapNode.info;
		// ���������ʾ�豸��Ϣ
		if (this.divInfoElement == null) {
			this.divInfoElement = this.createElement("info_" + id, "div");
			this.divInfoElement.style.visibility = "hidden";
			this.divLayer.appendChild(this.divInfoElement);
		}
		var divInfoElement = this.divInfoElement;

		divInfoElement.name = id;// alias+"("+ip+")";//yangjun add
		divInfoElement.style.position = "absolute";
		divInfoElement.style.border = infoBorder;
		divInfoElement.style.width = infoWidth;
		divInfoElement.style.height = "auto";
		divInfoElement.style.color = infoFontColor;
		divInfoElement.style.padding = infoPadding;
		divInfoElement.style.lineHeight = "120%";
		divInfoElement.style.zIndex = 2;
		divInfoElement.style.backgroundColor = infoBgColor;
		divInfoElement.style.left = parseInt(x, 10) + 32;
		divInfoElement.style.top = parseInt(y, 10);
		divInfoElement.style.visibility = "hidden";
		divInfoElement.style.fontSize = "12px";
		divInfoElement.innerHTML = info;
		
		//#########���ӡ��豸��Ϣ��ʾ��ʱ��Խ�紦���������߽������Զ���ʾ�����ӷ�Χ֮��   HONGLI ADD ########
		if(divInfoElement.clientHeight != 0){
			if(parseInt(x, 10) > document.body.clientWidth - infoWidth){
				divInfoElement.style.left =parseInt(x, 10) - infoWidth;
			} 
			if(parseInt(y, 10) > document.body.clientHeight-divInfoElement.clientHeight){
				divInfoElement.style.top = parseInt(y, 10)-divInfoElement.clientHeight;  
		    }
		}
	    //#############HONG ADD END##########
		return divInfoElement;
	},

	// ��������ͼ�豸�˵�����
	showTopologyMapNodeMenu: function(topologyMapNode) {
		var divMenuElement = this.createTopologyMapNodeMenu(topologyMapNode);
		this.divMenuElement = divMenuElement;
		if(clickObj != null) {
			this.divMenuElement.style.visibility = "hidden";
			clickObj = null;
		}	
		if(objStyle != null) {
		  	unSelectImg(objStyle);
		    objStyle = null;
		}
		clickObj = this.divMenuElement;
		objStyle = topologyMapNode.imageElement;
		selectImg(objStyle);
		if (this.divInfoElement != null) {
			this.divInfoElement.style.visibility = "hidden";
		}
		this.divMenuElement.style.visibility = "visible";
	},

	// ��������ͼ�豸�˵�����
	createTopologyMapNodeMenu: function(topologyMapNode) {
		var id = topologyMapNode.id;
		var x = topologyMapNode.imageElement.style.left;
		var y = topologyMapNode.imageElement.style.top;
		var menu = topologyMapNode.menu;
		// ����ͼ�豸�Ҽ��˵�����
		if (this.divMenuElement == null) {
			this.divMenuElement = this.createElement("menu_" + id, "div");
			this.divMenuElement.style.visibility = "hidden";
			this.divMenuElement.onclick = (function () {
				return function() {
					ObjectSelf.divMenuElement.style.visibility = "hidden"; };
			})();
			this.divLayer.appendChild(this.divMenuElement);
		}
		var divMenuElement = this.divMenuElement;

		divMenuElement.style.position = "absolute";
		divMenuElement.style.width = 120;
		divMenuElement.style.height = "auto";
		divMenuElement.style.zIndex = 2;
		divMenuElement.style.left = parseInt(x, 10) + 28;
		divMenuElement.style.top = parseInt(y, 10);
		divMenuElement.style.visibility = "hidden";
		divMenuElement.style.border = "solid #000066 1px";
		divMenuElement.style.backgroundColor = "#F5F5F5";
		divMenuElement.style.padding = "1px";
		divMenuElement.style.lineHeight = "100%";
		divMenuElement.style.fontSize = "12px";
		divMenuElement.innerHTML = menu;
		return divMenuElement;
	},

	// ��������ͼ�豸�˵�����
	hideTopologyMapNodeMenu: function() {
		if (this.divMenuElement) {
			this.divMenuElement.style.visibility = "hidden";
		}
	},

	// �������ͼ�豸�ڵ�
	addTopologyMapNode: function(topologyMapNode) {
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

		//getConfine(x, y);		// ��ȡ���߽磬�� maxWidth��maxHeight ��ֵ
		
		// ����ͼƬ����
		var imageElement = this.createTopologyMapNodeImg(topologyMapNode);
		topologyMapNode.imageElement = imageElement;
		
		this.divLayer.appendChild(imageElement);
	
		// nodeobjArray[nodeobjArray.length] = new nodeobj(img.id,img.src,nodeType,fatherXML);
		// �����ı�����
		var divTextElement = this.createTopologyMapNodeText(topologyMapNode);
		topologyMapNode.divTextElement = divTextElement;

		this.divLayer.appendChild(divTextElement);
		
		// ������Ϣ����
		// ע��ԭ�򣺲���Ϊÿ���豸����Info��Ϣ ���Ǹĳ�ֻ����һ����ÿ�λ�ȡInfo��Ϣ�������Ϣ�޸�
//		var divInfoElement = this.createTopologyMapNodeInfo(topologyMapNode);
//		topologyMapNode.divInfoElement = divInfoElement;
//		
//		document.all.divLayer.appendChild(divInfoElement);
		
		// ����"�豸��Ϣ��ʾ"�¼�
		topologyMapNode.imageElement.onmouseover = (function(topologyMapNode) {
			return function () {
				ObjectSelf.showTopologyMapNodeInfo(topologyMapNode);
			};
		})(topologyMapNode);
		
		// ����"�豸��Ϣ����"�¼�
		topologyMapNode.imageElement.onmouseout = (function(topologyMapNode) { 
			return function () {
				ObjectSelf.hideTopologyMapNodeInfo(topologyMapNode);
			};
		})(topologyMapNode);

		// ˫��ͼԪ�¼�yangjun
		topologyMapNode.imageElement.ondblclick = (function(topologyMapNode) {
			return function () {
				ObjectSelf.showTopologyMapNodeDetail(topologyMapNode);
			};
		})(topologyMapNode);
		
		// ���Ӳ˵��Ĵ����¼�
		topologyMapNode.imageElement.oncontextmenu = (function(topologyMapNode) {
			return function () {
				ObjectSelf.showTopologyMapNodeMenu(topologyMapNode);
			};
		})(topologyMapNode);
		
		// ����"�϶�"�¼�
		topologyMapNode.imageElement.onmousedown = (function(topologyMapNode) {
			return function () {
				ObjectSelf.nodeDown(event, topologyMapNode);
			};
		})(topologyMapNode);
		document.onmousemove = null;
		topologyMapNode.imageElement.onmouseup = (function(topologyMapNode) {
			return function () {
				ObjectSelf.nodeUp(event, topologyMapNode);
			};
		})(topologyMapNode);
	},
	
	// ��ʾ����ͼ��·��Ϣ����
	showTopologyMapLineInfo: function(e, topologyMapLine) {
		var lineid = topologyMapLine.lineid;
		var divInfoElement = this.createTopologyMapLineInfo(topologyMapLine);
		this.divInfoElement = divInfoElement;
	   	LinkRemoteService.getShowMessage(lineid, {
			callback:function(data){
				if(data){
				    ObjectSelf.divInfoElement.innerHTML = data;
				}
			}
		});
		
		var getCoordInDocument = function(e) {// ��ȡ��굱ǰλ��
             e = e || window.event; 
             var x = e.pageX || (e.clientX + (document.documentElement.scrollLeft|| document.body.scrollLeft)); 
             var y= e.pageY || (e.clientY + (document.documentElement.scrollTop || document.body.scrollTop));   
             return {'x':x,'y':y}; 
        }
        
       	var pos = getCoordInDocument();
       	window.event.srcElement.style.cursor = "hand";
       	this.divInfoElement.style.left = parseInt(pos['x'])-parseInt(this.divLayer.style.left.replace("px",""));
       	this.divInfoElement.style.top = parseInt(pos['y'])-parseInt(this.divLayer.style.top.replace("px",""));
       	this.divInfoElement.style.visibility = "visible";
	},

	// ��������ͼ��·��Ϣ����
	hideTopologyMapLineInfo: function(topologyMapLine) {
		window.event.srcElement.style.cursor = "default"; 
		this.divInfoElement.style.visibility = "hidden";
	},

	// ��������ͼ��·��Ϣ����
	createTopologyMapLineInfo: function(topologyMapLine) {
		var id = topologyMapLine.id;
		var x = topologyMapLine.x;
		var y = topologyMapLine.y;
		var info = topologyMapLine.info;
		// ���������ʾ�豸��Ϣ
		if (this.divInfoElement == null) {
			this.divInfoElement = this.createElement("info_" + id, "div");
			this.divInfoElement.style.visibility = "hidden";
			this.divLayer.appendChild(this.divInfoElement);
		}
		var divInfoElement = this.divInfoElement;

		divInfoElement.id = id
		divInfoElement.style.position = "absolute";
		divInfoElement.style.border = infoBorder;
		divInfoElement.style.width = 220;
		divInfoElement.style.height = "auto";
		divInfoElement.style.color = infoFontColor;
		divInfoElement.style.padding = infoPadding;
		divInfoElement.style.display = "block";
		divInfoElement.style.lineHeight = "120%";
		divInfoElement.style.zIndex = 2;
		divInfoElement.style.backgroundColor = infoBgColor;
		divInfoElement.style.visibility = "hidden";
		divInfoElement.style.fontSize = "12px";
		divInfoElement.innerHTML = info;
		
		//#########���ӡ��豸��Ϣ��ʾ��ʱ��Խ�紦���������߽������Զ���ʾ�����ӷ�Χ֮��   HONGLI ADD ########
		if(divInfoElement.clientHeight != 0){
			if(parseInt(x, 10) > document.body.clientWidth - infoWidth){
				divInfoElement.style.left =parseInt(x, 10) - infoWidth;
			} 
			if(parseInt(y, 10) > document.body.clientHeight-divInfoElement.clientHeight){
				divInfoElement.style.top = parseInt(y, 10)-divInfoElement.clientHeight;  
		    }
		}
	    //#############HONG ADD END##########
		return divInfoElement;
	},

	// ��ʾ����ͼ�豸�˵�����
	showTopologyMapLineMenu: function(e, topologyMapLine) {
		var divMenuElement = this.createTopologyMapLineMenu(topologyMapLine);
		this.divMenuElement = divMenuElement;
		var getCoordInDocument = function(e) {// ��ȡ��굱ǰλ��
             e = e || window.event; 
             var x = e.pageX || (e.clientX + (document.documentElement.scrollLeft|| document.body.scrollLeft)); 
             var y= e.pageY || (e.clientY + (document.documentElement.scrollTop || document.body.scrollTop));   
             return {'x':x,'y':y}; 
        }
		var pos = getCoordInDocument();
		this.divMenuElement.style.left = parseInt(pos['x'])-parseInt(this.divLayer.style.left.replace("px",""));
	    this.divMenuElement.style.top = parseInt(pos['y'])-parseInt(this.divLayer.style.top.replace("px",""));
		if(clickLineObj != null)
		{
			this.divMenuElement.style.visibility = "hidden";
			clickLineObj = null;
		}
		clickLineObj = this.divMenuElement;
		this.divInfoElement.style.visibility = "hidden";
		this.divMenuElement.style.visibility = "visible";
	},
	
	// ��������ͼ��·�˵�����
	createTopologyMapLineMenu: function(topologyMapLine) {
		var a = topologyMapLine.a;
		var b = topologyMapLine.b;
		var color = topologyMapLine.color;
		var dash = topologyMapLine.dash;
		var lineWidth = topologyMapLine.lineWidth;
		var lineInfo = topologyMapLine.lineInfo;
		var lineMenu = topologyMapLine.lineMenu;
		var id = topologyMapLine.id;
		
		// ����ͼ�豸�Ҽ��˵�����
		if (this.divMenuElement == null) {
			this.divMenuElement = this.createElement("menu_" + id, "div");
			this.divMenuElement.style.visibility = "hidden";
			this.divMenuElement.onclick = (function () {
				return function() { ObjectSelf.divMenuElement.style.visibility = "hidden"; };
			})();
			this.divLayer.appendChild(this.divMenuElement);
		}
		var divMenuElement = this.divMenuElement;

		divMenuElement.style.position = "absolute";
		divMenuElement.style.width = 120;
		divMenuElement.style.height = "auto";
		divMenuElement.style.zIndex = 2;
		divMenuElement.style.visibility = "hidden";
		divMenuElement.style.border = "solid #000066 1px";
		divMenuElement.style.backgroundColor = "#F5F5F5";
		divMenuElement.style.padding = "1px";
		divMenuElement.style.lineHeight = "100%";
		divMenuElement.style.fontSize = "12px";
		divMenuElement.innerHTML = lineMenu;

		return divMenuElement;
	},

	// �������ͼ��·�ڵ�
	addTopologyMapLine: function(topologyMapLine) {
		var a = topologyMapLine.a;
		var b = topologyMapLine.b;
		var color = topologyMapLine.color;
		var dash = topologyMapLine.dash;
		var lineWidth = topologyMapLine.lineWidth;
		var lineInfo = topologyMapLine.lineInfo;
		var lineMenu = topologyMapLine.lineMenu;
		var id = topologyMapLine.id;
         
		var lineElement = document.createElement("v:line");
		lineElement.id = id;
		lineElement.style.position = "absolute";
		lineElement.style.zIndex = -1;
		lineElement.from = (parseInt(document.all("node_" + a).style.left) + parseInt(document.all("node_" + a).style.width)/2) + "," + (parseInt(document.all("node_" + a).style.top) + parseInt(document.all("node_" + a).style.height)/2);
		lineElement.to = (parseInt(document.all("node_" + b).style.left) + parseInt(document.all("node_" + b).style.width)/2) + "," + (parseInt(document.all("node_" + b).style.top) + parseInt(document.all("node_" + b).style.height)/2);
		lineElement.strokecolor = color;
		lineElement.strokeweight = lineWidth;// 1;
		
		topologyMapLine.lineElement = lineElement;
		// ��ʾ��·��Ϣ
		topologyMapLine.lineElement.onmousemove = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.showTopologyMapLineInfo(e, topologyMapLine);
       			}; 
		})(topologyMapLine);
		topologyMapLine.lineElement.onmouseout = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.hideTopologyMapLineInfo(topologyMapLine);
       			}; 
		})(topologyMapLine);

		this.divLayer.appendChild(topologyMapLine.lineElement);
		
		document.all("node_" + a).lines += '&' + lineElement.id;
		document.all("node_" + b).lines += '&' + lineElement.id;
		
		// ������·�˵��Ĵ����¼�
		topologyMapLine.lineElement.oncontextmenu = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.showTopologyMapLineMenu(e, topologyMapLine);
       			};
		})(topologyMapLine);
		
		// ���� stroke ��ǩ
		// window.event.srcElement.stroke.dashstyle = "Solid";
		var stroke = document.createElement("v:stroke");
		stroke.dashstyle = dash;
		topologyMapLine.lineElement.appendChild(stroke);
	},
	
	/**
	 * ========================= ˫��· ===========================================
	 */
	
	// ��ʾ����ͼ��·��Ϣ����
	showTopologyMapAssistantLineInfo: function(e, topologyMapLine) {
		var lineid = topologyMapLine.lineid;
		var divInfoElement = this.createTopologyMapLineInfo(topologyMapLine);
		this.divInfoElement = divInfoElement;
	   	LinkRemoteService.getShowMessage(lineid, {
			callback:function(data){
				if(data){
				    divInfoElement.innerHTML = data;
				}
			}
		});
		
		var getCoordInDocument = function(e) {// ��ȡ��굱ǰλ��
             e = e || window.event; 
             var x = e.pageX || (e.clientX + (document.documentElement.scrollLeft|| document.body.scrollLeft)); 
             var y= e.pageY || (e.clientY + (document.documentElement.scrollTop || document.body.scrollTop));   
             return {'x':x,'y':y}; 
        }
        
       	var pos = getCoordInDocument();
       	window.event.srcElement.style.cursor = "hand";
       	this.divInfoElement.style.left = parseInt(pos['x'])-parseInt(document.all.divLayer.style.left.replace("px",""));
       	this.divInfoElement.style.top = parseInt(pos['y'])-parseInt(document.all.divLayer.style.top.replace("px",""));
       	this.divInfoElement.style.visibility = "visible";
	},

	// ��������ͼ��·��Ϣ����
	hideTopologyMapAssistantLineInfo: function(topologyMapLine) {
		window.event.srcElement.style.cursor = "default"; 
		this.divInfoElement.style.visibility = "hidden";
	},

	// ��������ͼ��·��Ϣ����
	createTopologyMapAssistantLineInfo: function(topologyMapLine) {
		var id = topologyMapLine.id;
		var x = topologyMapLine.x;
		var y = topologyMapLine.y;
		var info = topologyMapLine.info;
		// ���������ʾ�豸��Ϣ
		if (this.divInfoElement == null) {
			this.divInfoElement = this.createElement("info_" + id, "div");
			this.divInfoElement.style.visibility = "hidden";
			document.all.divLayer.appendChild(this.divInfoElement);
		}
		var divInfoElement = this.divInfoElement;

		divInfoElement.style.position = "absolute";
		divInfoElement.style.border = infoBorder;
		divInfoElement.style.width = 200;
		divInfoElement.style.height = "auto";
		divInfoElement.style.color = infoFontColor;
		divInfoElement.style.padding = infoPadding;
		divInfoElement.style.display = "block";
		divInfoElement.style.lineHeight = "120%";
		divInfoElement.style.zIndex = 2;
		divInfoElement.style.backgroundColor = infoBgColor;
		divInfoElement.style.visibility = "hidden";
		divInfoElement.style.fontSize = "12px";
		divInfoElement.innerHTML = lineInfo;
		
		//#########���ӡ��豸��Ϣ��ʾ��ʱ��Խ�紦���������߽������Զ���ʾ�����ӷ�Χ֮��   HONGLI ADD ########
		if(divInfoElement.clientHeight != 0){
			if(parseInt(x, 10) > document.body.clientWidth - infoWidth){
				divInfoElement.style.left =parseInt(x, 10) - infoWidth;
			} 
			if(parseInt(y, 10) > document.body.clientHeight-divInfoElement.clientHeight){
				divInfoElement.style.top = parseInt(y, 10)-divInfoElement.clientHeight;  
		    }
		}
	    //#############HONG ADD END##########
		return divInfoElement;
	},
	
	// �������ͼ��·�ڵ�
	addTopologyMapAssistantLine: function(topologyMapLine) {
		//linkobjArray[linkobjArray.length] = new linkobj(line.id,line.lineid,color,fatherXML,"assistant");
		// ///////////////yangjun add begin
		var a = topologyMapLine.a;
		var b = topologyMapLine.b;
		var color = topologyMapLine.color;
		var dash = topologyMapLine.dash;
		var lineWidth = topologyMapLine.lineWidth;
		var lineInfo = topologyMapLine.lineInfo;
		var lineMenu = topologyMapLine.lineMenu;
		var id = topologyMapLine.id;
         
		var lineElement = document.createElement("v:line");
		lineElement.id = id;
		lineElement.style.position = "absolute";
		lineElement.style.zIndex = -1;
		//line.from = (parseInt(document.all("node_" + a).style.left) + 20) + "," + (parseInt(document.all("node_" + a).style.top) + 10);
		//line.to = (parseInt(document.all("node_" + b).style.left) + 20) + "," + (parseInt(document.all("node_" + b).style.top) + 10);
		lineElement.from = (parseInt(document.all("node_" + a).style.left) + parseInt(document.all("node_" + a).style.width)/2 + 3) + "," + (parseInt(document.all("node_" + a).style.top) + parseInt(document.all("node_" + a).style.height)/2 + 3);
		lineElement.to = (parseInt(document.all("node_" + b).style.left) + parseInt(document.all("node_" + b).style.width)/2 + 3) + "," + (parseInt(document.all("node_" + b).style.top) + parseInt(document.all("node_" + b).style.height)/2 + 3);
		lineElement.strokecolor = color;
		lineElement.strokeweight = lineWidth;
		
		topologyMapLine.lineElement = lineElement;
		
		// ��ʾ��·��Ϣ
		topologyMapLine.lineElement.onmousemove = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.showTopologyMapLineInfo(e, topologyMapLine);
       			}; 
		})(topologyMapLine);
		topologyMapLine.lineElement.onmouseout = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.hideTopologyMapLineInfo(topologyMapLine);
       			}; 
		})(topologyMapLine);

		document.all.divLayer.appendChild(topologyMapLine.lineElement);
		
		document.all("node_" + a).lines += '&' + lineElement.id;
		document.all("node_" + b).lines += '&' + lineElement.id;
		
		// ������·�˵��Ĵ����¼�
		topologyMapLine.lineElement.oncontextmenu = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.showTopologyMapLineMenu(e, topologyMapLine);
       			};
		})(topologyMapLine);
		
		// ���� stroke ��ǩ
		// window.event.srcElement.stroke.dashstyle = "Solid";
		var stroke = document.createElement("v:stroke");
		stroke.dashstyle = dash;
		topologyMapLine.lineElement.appendChild(stroke);
	},
	
	
	/**
	 * ========================= ʾ����· ===========================================
	 */
	
	// �������ͼʾ����·�ڵ�
	addTopologyMapDemoLine: function(topologyMapLine) {
		//linkobjArray[linkobjArray.length] = new linkobj(line.id,line.lineid,color,fatherXML,"assistant");
		// ///////////////yangjun add begin
		var a = topologyMapLine.a;
		var b = topologyMapLine.b;
		var color = topologyMapLine.color;
		var dash = topologyMapLine.dash;
		var lineWidth = topologyMapLine.lineWidth;
		var lineInfo = topologyMapLine.lineInfo;
		var lineMenu = topologyMapLine.lineMenu;
		var id = topologyMapLine.id;
         
		var lineElement = document.createElement("v:line");
		lineElement.id = id;
		lineElement.style.position = "absolute";
		lineElement.style.zIndex = -1;
		lineElement.from = (parseInt(document.all("node_" + a).style.left) + parseInt(document.all("node_" + a).style.width)/2 - 3) + "," + (parseInt(document.all("node_" + a).style.top) + parseInt(document.all("node_" + a).style.height)/2 - 3);
		lineElement.to = (parseInt(document.all("node_" + b).style.left) + parseInt(document.all("node_" + b).style.width)/2 - 3) + "," + (parseInt(document.all("node_" + b).style.top) + parseInt(document.all("node_" + b).style.height)/2 - 3);
		lineElement.strokecolor = color;
		lineElement.strokeweight = lineWidth;
		
		topologyMapLine.lineElement = lineElement;
		
		// ��ʾ��·��Ϣ
		topologyMapLine.lineElement.onmousemove = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.showTopologyMapLineInfo(e, topologyMapLine);
       			}; 
		})(topologyMapLine);
		topologyMapLine.lineElement.onmouseout = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.hideTopologyMapLineInfo(topologyMapLine);
       			}; 
		})(topologyMapLine);

		document.all.divLayer.appendChild(topologyMapLine.lineElement);
		
		document.all("node_" + a).lines += '&' + lineElement.id;
		document.all("node_" + b).lines += '&' + lineElement.id;
		
		// ������·�˵��Ĵ����¼�
		topologyMapLine.lineElement.oncontextmenu = (function(topologyMapLine){
				return function(e) {
					ObjectSelf.showTopologyMapLineMenu(e, topologyMapLine);
       			};
		})(topologyMapLine);
		
		// ���� stroke ��ǩ
		// window.event.srcElement.stroke.dashstyle = "Solid";
		var stroke = document.createElement("v:stroke");
		stroke.dashstyle = dash;
		topologyMapLine.lineElement.appendChild(stroke);
	},
	
	//yangjun add ����id�����豸�ڵ�
	getNodeId: function(id) {
		var nodeNum = this.topologyMapNodes.length;
		var i = 0;
		while (i < nodeNum) {
			var topologyMapNode = this.topologyMapNodes[i];
			if (topologyMapNode.id == id) {
				var coor = new Array();
				coor[0] = topologyMapNode.imageElement.style.left;
				coor[1] = topologyMapNode.imageElement.style.top;
				return coor;
			}
			i = i + 1;
		}
		return null;
	},
	
	//yangjun add ����ip�����豸�ڵ�
	getNodeIP: function(ip) {
		var nodeNum = this.topologyMapNodes.length;
		var i = 0;
		while (i < nodeNum) {
			var topologyMapNode = this.topologyMapNodes[i];
			if (topologyMapNode.ip == ip) {
				var coor = new Array();
				coor[0] = topologyMapNode.imageElement.style.left;
				coor[1] = topologyMapNode.imageElement.style.top;
				return coor;
			}
			i = i + 1;
		}
		return null;
	},

	addNode: function (nodeid, url) {
		this.initXML(url);
		this.nodes = this.xmldoc.getElementsByTagName("node");
		var nodeNum = this.nodes.length;
		var i = 0;
		while (i < nodeNum) {
			var node = this.nodes[i];
			var id = node.getElementsByTagName("id")[0].text;
			if (id == nodeid) {
				var topologyMapNode = this.createTopologyMapNode(node);
				this.topologyMapNodes.push(topologyMapNode);
				this.addTopologyMapNode(topologyMapNode);
				this.nodeobjArray.push(new nodeobj(topologyMapNode.imageElement.id,topologyMapNode.imageElement.src,topologyMapNode.nodeType,fatherXML));
			}
			i = i + 1;
		}
	},
	
	addlink: function (lineid, url) {
		this.initXML(url);
		this.lines = this.xmldoc.getElementsByTagName("line");
		var lineNum = this.lines.length;
		var i = 0;
		while (i < lineNum) {
			var line = this.lines[i];
			var line_id = line.getAttribute("id");
			if (lineid == line_id) {
				var topologyMapLine = this.createTopologyMapLine(line);
				this.topologyMapLines.push(topologyMapLine);
				this.addTopologyMapLine(topologyMapLine);
				this.linkobjArray.push(new linkobj(topologyMapLine.id,topologyMapLine.lineid,topologyMapLine.color,fatherXML,"line"));
			}
			i = i + 1;
		}
	},

	addAssLink: function (lineid, url) {
		this.initXML(url);
		this.assistantlines = this.xmldoc.getElementsByTagName("assistant_line");
		var lineNum = this.assistantlines.length;
		var i = 0;
		while (i < lineNum) {
			var assistantline = this.assistantlines[i];
			var line_id = assistantline.getAttribute("id");
			if (lineid == line_id) {
				var topologyMapAssistantLine = this.createTopologyMapAssistantLine(assistantline);
				this.topologyMapAssistantLines.push(topologyMapAssistantLine);
				this.addTopologyMapAssistantLine(topologyMapAssistantLine);
				this.linkobjArray.push(new linkobj(topologyMapAssistantLine.id,topologyMapAssistantLine.lineid,topologyMapAssistantLine.color,fatherXML,"assistant"));
			}
			i = i + 1;
		}
	},
	
	addLine: function (lineid, url) {
		this.initXML(url);
		this.demoLines = this.xmldoc.getElementsByTagName("demoLine");
		var lineNum = this.demoLines.length;
		var i = 0;
		while (i < lineNum) {
			var demoLine = this.demoLines[i];
			var line_id = demoLine.getAttribute("id");
			if (lineid == line_id) {
				var topologyMapDemoLine = this.createTopologyMapDemoLine(demoLine);
				this.topologyMapDemoLines.push(topologyMapDemoLine);
				this.addTopologyMapDemoLine(topologyMapDemoLine);
				this.linkobjArray.push(new linkobj(topologyMapDemoLine.id,topologyMapDemoLine.lineid,topologyMapDemoLine.color,fatherXML,"demo"));
			}
			i = i + 1;
		}
	},
	
	save: function() {
		if(document.all("containImgDiv")) {
			rmvContainedImg();
		}
		var nodes = this.xmldoc.getElementsByTagName("node");
		for (var i = 0; i < this.topologyMapNodes.length; i += 1)
		{
			for (var j = 0; j < nodes.length; j += 1)
			{
				var node = nodes[j];
				var id = "node_" + node.getElementsByTagName("id")[0].text;
				if (this.topologyMapNodes[i].imageElement.id == id)
				{
					node.getElementsByTagName("x")[0].text = this.topologyMapNodes[i].imageElement.style.left;
					node.getElementsByTagName("y")[0].text = this.topologyMapNodes[i].imageElement.style.top;
				}
			}
		}
		document.all("hidXml").value = this.xmldoc.xml;
		document.frmMap.submit();
	},
	
	replaceNodeobj: function(data){
	    if(data!=null&&data.length>0){
	    	for(var i = 0; i < data.length; i++){
	    		for(var j = 0; j < this.topologyMapNodes.length; j++) {
	    			if (data[i].id == this.topologyMapNodes[j].imageElement.id) {
	    				this.topologyMapNodes[j].imageElement.src = "../../resource/"+data[i].image;
	    			}
	    		}
	    	}
	    }
	},

	replaceLinkobj: function(data){
	    if(data!=null){
	    	for(var i = 0; i < data.length; i++){
	    		for(var j = 0; j < this.topologyMapLines.length; j++) {
	    			if (data[i].id == this.topologyMapLines[j].lineElement.id) {
	    				this.topologyMapLines[j].lineElement.strokecolor = data[i].color;
	    			}
	    		}
	    		for(var j = 0; j < this.topologyMapAssistantLines.length; j++) {
	    			if (data[i].id == this.topologyMapAssistantLines[j].lineElement.id) {
	    				this.topologyMapAssistantLines[j].lineElement.strokecolor = data[i].color;
	    			}
	    		}
	    		for(var j = 0; j < this.topologyMapDemoLines.length; j++) {
	    			if (data[i].id == this.topologyMapDemoLines[j].lineElement.id) {
	    				this.topologyMapDemoLines[j].lineElement.strokecolor = data[i].color;
	    			}
	    		}
	    	}
	    }
	},
	
	// handle node onmousedown event, �����豸��ס����¼�
	nodeDown: function(evnet, topologyMapNode) {
		if (event.button != 1) {
			// �����Ҽ��϶�
			return false;
		}
		if (this.divMenuElement) {
			this.divMenuElement.style.visibility = "hidden";
		}
		
		if (!this.selectedTopologyMapNodes) {
			this.selectedTopologyMapNodes = new Array();
		}
		var isSelected = topologyMapNode.isSelected;
		if (!isSelected && !event.ctrlKey) {
			this.cancelAllSelectedNode();
		}
		this.addSelectedNode(topologyMapNode);
		topologyMapNode.mouseDownStatus = true;
		this.mouseOriX = event.x;
		this.mouseOriY = event.y;
		
		// �ƶ��豸֮ǰ�����������ƶ�֮ǰ�� X Y λ��
		var isSelectedNum = this.selectedTopologyMapNodes.length;
		var i = 0;
		while (i < isSelectedNum) {
			var isSelectedTopologyMapNode = this.selectedTopologyMapNodes[i];
			var beforeMoveX = isSelectedTopologyMapNode.imageElement.offsetLeft;
			var beforeMoveY = isSelectedTopologyMapNode.imageElement.offsetTop;
			isSelectedTopologyMapNode.beforeMoveX = beforeMoveX;
			isSelectedTopologyMapNode.beforeMoveY = beforeMoveY;
			i++;
		}
		// ������·�˵��Ĵ����¼�
		document.onmousemove = (function(){
				return function(e) {
					var isSelectedNum = ObjectSelf.selectedTopologyMapNodes.length;
					var j = 0;
					while (j < isSelectedNum) {
						var isSelectedTopologyMapNode = ObjectSelf.selectedTopologyMapNodes[j];
						ObjectSelf.nodeMove(e, isSelectedTopologyMapNode);
						j++;
					}
       			};
		})();
	},

	// handle node onmousemove event, �����豸��ס����ƶ��¼�
	nodeMove: function(event, topologyMapNode) {
		var eventX = window.event.x;
		var eventY = window.event.y;
		if (eventX > 0 & eventY > 0 & eventX < window.screen.width & eventY < window.screen.height) {
			var imageStyle = topologyMapNode.imageElement.style;
			var textStyle = topologyMapNode.divTextElement.style;
			var beforeMoveX = topologyMapNode.beforeMoveX;
			var beforeMoveY = topologyMapNode.beforeMoveY;
			var tempX = eventX - this.mouseOriX + beforeMoveX;
			var tempY = eventY - this.mouseOriY + beforeMoveY;
			imageStyle.left = tempX ;
			imageStyle.top = tempY ;
			textStyle.left = tempX - 24;
			textStyle.top = tempY + 28;
			// #########������ק�豸ʱ���豸��Ϣ��ʾ����Խ�紦���������߽������Զ���ʾ�����ӷ�Χ֮��   HONGLI ADD #########
			if (this.divInfoElement == null) {
				this.divInfoElement = this.createElement("info_" + topologyMapNode.id, "div");
				this.divInfoElement.style.visibility = "hidden";
				this.divLayer.appendChild(this.divInfoElement);
			}
			if (topologyMapNode.mouseDownStatus) {
				var divInfo = this.divInfoElement;
				divInfo.style.left = tempX + 32;
				divInfo.style.top = tempY;
				if(parseInt(tempX, 10) > document.body.clientWidth - infoWidth - 24) {
					divInfo.style.left = parseInt(tempX, 10)- infoWidth;
				}
				if(parseInt(tempY, 10) > document.body.clientHeight - divInfo.clientHeight) {  
					divInfo.style.top = parseInt(tempY, 10)- divInfo.clientHeight;  
			    }
			}
			
	   		// #############HONG ADD END##########
	   		// ############# ������·λ�� ########
	   		var iLeft = parseInt(imageStyle.left) + 15;
			var iTop = parseInt(imageStyle.top) + 8;
			var lineNum = this.topologyMapLines.length;
			var i = 0;
			while (i < lineNum) {
				var topologyMapLine = this.topologyMapLines[i];
				if (topologyMapLine.a == topologyMapNode.id) {
					topologyMapLine.lineElement.from = iLeft + "," + iTop;
				}
				if (topologyMapLine.b == topologyMapNode.id) {
					topologyMapLine.lineElement.to = iLeft + "," + iTop;
				}
				i = i + 1;
			}
			
			var assistantlineNum = this.topologyMapAssistantLines.length;
			var j = 0;
			while (j < assistantlineNum) {
				var topologyMapAssistantLine = this.topologyMapAssistantLines[j];
				if (topologyMapAssistantLine.a == topologyMapNode.id) {
					topologyMapAssistantLine.lineElement.from = (parseInt(iLeft)+5) + "," + iTop;
				}
				if (topologyMapAssistantLine.b == topologyMapNode.id) {
					topologyMapAssistantLine.lineElement.to = (parseInt(iLeft)+5) + "," + iTop;
				}
				j = j + 1;
			}
			
			var demoLineNum = this.topologyMapDemoLines.length;
			var k = 0;
			while (k < demoLineNum) {
				var topologyMapDemoLine = this.topologyMapDemoLines[k];
				if (topologyMapDemoLine.a == topologyMapNode.id) {
					topologyMapDemoLine.lineElement.from = (parseInt(iLeft)+8) + "," + iTop;
				}
				if (topologyMapDemoLine.b == topologyMapNode.id) {
					topologyMapDemoLine.lineElement.to = (parseInt(iLeft)+8) + "," + iTop;
				}
				k = k + 1;
			}
		}
	},
	
	// handle node onmouseup event, �����豸�ſ�����¼�
	nodeUp: function(event, topologyMapNode) {
		topologyMapNode.mouseDownStatus = false;
		topologyMapNode.imageElement.onmousemove = null;
		this.handleOnMouseUp();
		this.hideTopologyMapNodeMenu();
		return false;
	},
	
	// handle body onmousedown event, ����ҳ�水ס����¼�
	bodyDown: function () {
		if (window.event.srcElement.id == "divLayer") {
			this.cancelAllSelectedNode();
			this.hideTopologyMapNodeMenu();
		}
	},
	
	// handle body onmousedown event, ����ҳ�水ס����¼�
	divLayerDown: function () {
		if (window.event.srcElement.tagName == "BODY") {
			this.cancelAllSelectedNode();
			this.hideTopologyMapNodeMenu();
		}
	},
	
	// ����ѡ��
	selectStart: function() {
		if (window.event.srcElement.id == "divLayer" || 
			window.event.srcElement.tagName == "BODY") {
			this.hideTopologyMapNodeMenu();
			// ����ѡ��ʱ���õ����������ĸ�����
			var imgTop = this.imgTop;
			var imgLeft = this.imgLeft;
			var imgBottom = this.imgBottom;
			var imgRight = this.imgRight;
			
			imgTop.style.height = imgTop.style.width = imgLeft.style.height = imgLeft.style.width = imgBottom.style.height = imgBottom.style.width = imgRight.style.height = imgRight.style.width = 1;
			imgTop.style.visibility = imgLeft.style.visibility = imgBottom.style.visibility = imgRight.style.visibility = "visible";
			imgTop.style.zIndex = imgLeft.style.zIndex = imgBottom.style.zIndex = imgRight.style.zIndex = 9999;
			this.beforeMoveX = event.x;
			this.beforeMoveY = event.y;
			document.onmousemove = (function () {
				return function(e){
					ObjectSelf.selectMove(e);
				};
			})();
			document.onmouseup = (function () {
				return function(e){
					ObjectSelf.selectUp(e);
				};
			})();
		}
	},
	
	// ����ѡ���ƶ��¼�
	selectMove: function(event) {
		// ����ѡ��ʱ���õ����������ĸ�����
		var imgTop = this.imgTop;
		var imgLeft = this.imgLeft;
		var imgBottom = this.imgBottom;
		var imgRight = this.imgRight;
		var tmpx = window.event.x;
		var tmpy = window.event.y;
		var beginx = this.beforeMoveX;
		var beginy = this.beforeMoveY;
		imgTop.style.left = Math.min(beginx,tmpx);
		imgTop.style.top = Math.min(beginy,tmpy);
		imgTop.style.width = Math.abs(beginx - tmpx);
		imgLeft.style.left = Math.min(beginx,tmpx);
		imgLeft.style.top = Math.min(beginy,tmpy);
		imgLeft.style.height = Math.abs(beginy - tmpy);
		imgBottom.style.left = Math.min(beginx,tmpx);
		imgBottom.style.top = Math.max(beginy,tmpy);
		imgBottom.style.width = Math.abs(beginx - tmpx);
		imgRight.style.left = Math.max(beginx,tmpx);
		imgRight.style.top = Math.min(beginy,tmpy);
		imgRight.style.height = Math.abs(beginy - tmpy);
	},
	
	selectUp: function(event) {
		this.cancelAllSelectedNode();
		var nodeNum = this.topologyMapNodes.length;
		var i = 0;
		while (i < nodeNum) {
			var topologyMapNode = this.topologyMapNodes[i];
			var isInSelect = this.checkNodeIsInSelect(topologyMapNode);
			if (isInSelect) {
				this.addSelectedNode(topologyMapNode);
			}
			i++;
		}
		var imgTop = this.imgTop;
		var imgLeft = this.imgLeft;
		var imgBottom = this.imgBottom;
		var imgRight = this.imgRight;
		imgTop.style.visibility = "hidden";
		imgLeft.style.visibility = "hidden";
		imgBottom.style.visibility = "hidden";
		imgRight.style.visibility = "hidden";
		this.handleOnMouseUp();
	},
	
	// handle onmouseup event ����ſ�����¼�
	handleOnMouseUp: function() {
		document.onmouseup = null;
		document.onmousemove = null;
	},
	
	// �ж��豸�Ƿ���ѡ��֮��
	checkNodeIsInSelect: function(topologyMapNode) {
		var divLayStyleLeft = this.divLayer.style.left;
		var divLayStyleTop = this.divLayer.style.top;
		var nodeStyleLeft = topologyMapNode.imageElement.style.left;
		var nodeStyleTop = topologyMapNode.imageElement.style.top;
		var nodeStyleWith = topologyMapNode.imageElement.style.width;
		var nodeStyleHeight = topologyMapNode.imageElement.style.height;
		// ����ѡ��ʱ���õ����������ĸ�����
		var imgTop = this.imgTop;
		var imgLeft = this.imgLeft;
		var imgBottom = this.imgBottom;
		var imgRight = this.imgRight;
		imgTopX = parseInt(imgTop.style.left);
		imgTopY = parseInt(imgTop.style.top);
		imgBottomX = parseInt(imgTop.style.left) + parseInt(imgTop.style.width);
		imgBottomY = parseInt(imgTop.style.top) + parseInt(imgLeft.style.height);
		
		var result = parseInt(nodeStyleLeft) + parseInt(divLayStyleLeft) >= imgTopX;
		var result = result && (parseInt(nodeStyleLeft) + parseInt(divLayStyleLeft) <= imgBottomX);
		var result = result && (parseInt(nodeStyleTop) + parseInt(divLayStyleTop) >= imgTopY);
		var result = result && (parseInt(nodeStyleTop) + parseInt(divLayStyleTop) <= imgBottomY);
		var result = result && (parseInt(nodeStyleLeft) + parseInt(nodeStyleWith) + parseInt(divLayStyleLeft) <= imgBottomX);
		var result = result && (parseInt(nodeStyleTop) + parseInt(nodeStyleHeight) + parseInt(divLayStyleTop) <= imgBottomY);
		return result;
	},

	getAllSelectedNodes: function() {
		return this.selectedTopologyMapNodes;
	},
	
	// ���ѡ����豸
	addSelectedNode: function (topologyMapNode) {
		var isSelected = topologyMapNode.isSelected;
		if (isSelected) {
			return false;
		}
		this.setSelectedNodeStyle(topologyMapNode);
		topologyMapNode.isSelected = true;
		this.setSelectedNodeStyle(topologyMapNode);
		this.selectedTopologyMapNodes.push(topologyMapNode);
		return true;
	},

	// ȡ������ѡ����豸
	cancelAllSelectedNode: function () {
		while (this.selectedTopologyMapNodes.length > 0) {
			var isSelectedTopologyMapNode = this.selectedTopologyMapNodes.pop();
			isSelectedTopologyMapNode.isSelected = false;
			this.setUnSelectedNodeStyle(isSelectedTopologyMapNode);
		}
	},

	// ����ѡ�нڵ�����ʽ
	setSelectedNodeStyle: function (topologyMapNode) {
		topologyMapNode.imageElement.style.background = "#9BFFAC";
		topologyMapNode.imageElement.style.border="1px solid #007314";
		topologyMapNode.imageElement.style.filter="Alpha(Opacity=60);";
	},

	// ȡ��ѡ�нڵ����ʽ
	setUnSelectedNodeStyle: function (topologyMapNode) {
		topologyMapNode.imageElement.style.background = "";
		topologyMapNode.imageElement.style.border = "0px solid #007314";
		topologyMapNode.imageElement.style.color = "#000000";
		topologyMapNode.imageElement.style.filter= "";
	},
	
	getTopologyMapNodeMenuData: function (topologyMapNode) {
		topologyMapNode.menu = "";
		if (topologyMapNode.id.indexOf("hin") < 0) {
			topologyMapNode.menu = '<a class="ping_menu_out" onmouseover="pingMenuOver();" onmouseout="pingMenuOut();" onclick="javascript:resetProcDlg();window.showModelessDialog(\'/afunms/tool/ping.jsp?ipaddress=' + topologyMapNode.ip + '\', window, \'dialogHeight:500px;dialogWidth:500px;status:0;help:0;edge:sunken;center:yes;scroll:0\');timingCloseProDlg(8000);" title="ping ' + topologyMapNode.ip + '">&nbsp;&nbsp;&nbsp;&nbsp;Ping </a><br/>';
			topologyMapNode.menu +='<a class="download_menu_out" onmouseover="downloadMenuOver();" onmouseout="downloadMenuOut();" onclick="javascript:window.open(\'/afunms/topology/network/download.jsp?flag=0&xml=' + this.xmlName + '\',\'window\', \'toolbar=no,height=620,width=820,scrollbars=yes,center=yes,screenY=0\')">&nbsp;&nbsp;&nbsp;&nbsp;���ɱ�������ͼ </a><br/>';
			topologyMapNode.menu +='<a class="download_menu_out" onmouseover="downloadMenuOver();" onmouseout="downloadMenuOut();" onclick="javascript:window.open(\'/afunms/topology/network/download.jsp?flag=1&xml=' + this.xmlName + '\',\'window\', \'toolbar=no,height=620,width=820,scrollbars=yes,center=yes,screenY=0\')">&nbsp;&nbsp;&nbsp;&nbsp;����IP����ͼ </a><br/>';
			// topologyMapNode.menu +='<a class="property_menu_out" onmouseover="propertyMenuOver();" onmouseout="propertyMenuOut();" onclick="javascript:window.showModalDialog(\'/afunms/submap.do?action=equipProperty&type=net_router&nodeId=' + topologyMapNode.id + '\', window, \'dialogwidth:500px; dialogheight:300px; status:no; help:no;resizable:0\');">&nbsp;&nbsp;&nbsp;&nbsp;ͼԪ���� </a><br/>';
			if (this.topologyMapOperation.deleteTopolgyMapNode) {
				topologyMapNode.menu +='<a class="deleteEquip_menu_out" onmouseover="deleteEquipMenuOver();" onmouseout="deleteEquipMenuOut();" onclick="removeEquip(\'' + topologyMapNode.id + '\')">&nbsp;&nbsp;&nbsp;&nbsp;����ͼɾ���豸 </a><br/>';
			}
		} else if (this.topologyMapOperation.deleteTopolgyMapHinNode) {
			topologyMapNode.menu +='<a class="deleteEquip_menu_out" onmouseover="deleteEquipMenuOver();" onmouseout="deleteEquipMenuOut();" onclick="removeEquip(\'' + topologyMapNode.id + '\')">&nbsp;&nbsp;&nbsp;&nbsp;����ͼɾ���豸 </a><br/>';
		}
		
	},

	getTopologyMapLineMenuData: function (topologyMapLine) {
		topologyMapLine.lineMenu = "";
		if (topologyMapLine.lineid.indexOf("hl") < 0) {
			var propertyLineMenu = '<a class="property_menu_out" onmouseover="propertyMenuOver();" onmouseout="propertyMenuOut();" onclick="javascript:window.showModalDialog(\'/afunms/submap.do?action=linkProperty&lineId=' + topologyMapLine.lineid + '\', window, \'dialogwidth:350px; dialogheight:250px; status:no; help:no;resizable:0\');">&nbsp;&nbsp;&nbsp;&nbsp;��·���� </a><br/>';
			var updateLineMenu = '<a class="editline_menu_out" onmouseover="editLineMenuOver();" onmouseout="editLineMenuOut();" onclick="editLink(' + topologyMapLine.lineid + ')">&nbsp;&nbsp;&nbsp;&nbsp;�޸���· </a><br/>';
			var deleteLineMenu = '<a class="deleteline_menu_out" onmouseover="deleteLineMenuOver();" onmouseout="deleteLineMenuOut();" onclick="deleteLink(\'' + topologyMapLine.lineid + '\')">&nbsp;&nbsp;&nbsp;&nbsp;ɾ����· </a><br/>';
			if (this.topologyMapOperation.updateTopolgyMapLine) {
				topologyMapLine.lineMenu += propertyLineMenu;
				topologyMapLine.lineMenu += updateLineMenu;
			}
			if (this.topologyMapOperation.deleteTopolgyMapLine) {
				topologyMapLine.lineMenu += deleteLineMenu;
			}
		} else {
			var deleteLineMenu = '<a class="deleteline_menu_out" onmouseover="deleteLineMenuOver();" onmouseout="deleteLineMenuOut();" onclick="deleteLine(\'' + topologyMapLine.lineid + '\')">&nbsp;&nbsp;&nbsp;&nbsp;ɾ����· </a><br/>';
			var updateDemoLineMenu = '<a class="property_menu_out" onmouseover="propertyMenuOver();" onmouseout="propertyMenuOut();" onclick="javascript:window.showModalDialog(\'/afunms/link.do?action=readyEditLine&lineid=' + topologyMapLine.lineid + '&xml=' + this.xmlName + '\', window, \'dialogwidth:500px; dialogheight:300px; status:no; help:no;resizable:0\');">&nbsp;&nbsp;&nbsp;&nbsp;��·���� </a><br/>';
			if (this.topologyMapOperation.updateTopolgyMapHinLine) {
				topologyMapLine.lineMenu += updateDemoLineMenu;
			}
			if (this.topologyMapOperation.deleteTopolgyMapHinLine) {
				topologyMapLine.lineMenu += deleteLineMenu;
			}
		}
	}
}

function getAllSelectedNodes() {
	return topologyMapObject.getAllSelectedNodes();
}


	/**
	 * =========================== ����ڵ�ѡ�е���ʽ ==========================
	 */

// ѡ�нڵ�����ʽ
function selectImg(objSty)
{	
	document.all(objSty.id).style.background = "#9BFFAC";
	document.all(objSty.id).style.border="1px solid #007314";
	document.all(objSty.id).style.filter="Alpha(Opacity=60);";
	
// document.all(objSty.id.replace("node_","text_")).style.background =
// "#9BFFAC";
// document.all(objSty.id.replace("node_","text_")).style.border="1px solid
// #007314";
// document.all(objSty.id.replace("node_","text_")).style.filter="Alpha(Opacity=60);";
	// document.all(objSty.id.replace("node_","text_")).style.color = "#FFFFFF";
	// document.all(objSty.id.replace("node_","text_")).style.height = "12px";
}

// ȡ��ѡ�нڵ����ʽ
function unSelectImg(objSty)
{
	document.all(objSty.id).style.background = "";
	document.all(objSty.id).style.border="0px solid #007314";
	document.all(objSty.id).style.color = "#000000";
	document.all(objSty.id).style.filter="";
	
// document.all(objSty.id.replace("node_","text_")).style.background = "";
// document.all(objSty.id.replace("node_","text_")).style.border="0px solid
// #007314";
// document.all(objSty.id.replace("node_","text_")).style.color = "#000000";
}

//// ����ѡ��
//function selectStart()
//{
//	if (window.event.srcElement.id == "divLayer" || 
//		window.event.srcElement.tagName == "BODY")
//	{
//		obj = null;
//		selectStatus = true;
//		imgTop.style.height = imgTop.style.width = imgLeft.style.height = imgLeft.style.width = imgBottom.style.height = imgBottom.style.width = imgRight.style.height = imgRight.style.width = 1;
//		imgTop.style.visibility = imgLeft.style.visibility = imgBottom.style.visibility = imgRight.style.visibility = "visible";
//		imgTop.style.zIndex = imgLeft.style.zIndex = imgBottom.style.zIndex = imgRight.style.zIndex = 9999;
//		beginx = event.x;
//		beginy = event.y;
//		document.onmousemove = move;
//		document.onmouseup = up;
//	}
//}


/** ** ������� -- ��ʼ *** */
// ����Ҫ��һ�������ƶ�����---��μ����ƶ��ķ���ʹ�С

var anchorPos = new Array();
anchorPos[0] = (viewWidth - 88) / 2;
anchorPos[1] = 200;
var flashTimer;
var closeAncTimer;

// var mappingIP = window.parent.bottomFrame.getMappingIP();

document.write("<div id=\"postLayer\" style=\"position:absolute;left:"+ anchorPos[0] +"px;top:"+ anchorPos[1] +"px;visibility:hidden;z-index:993;width:88px;height:60px;\">");
document.write("<table width=\"100%\" height=\"60\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr>");
document.write("<td style=\"border:#FF0000 2px dotted\">&nbsp;</td>");
document.write("</tr></table>");
document.write("</div>");


function getNodeCoor(ip)
{
	return topologyMapObject.getNodeIP(ip);
}
//yangjun add ����id�����豸�ڵ�
function getNodeId(id)
{
	return topologyMapObject.getNodeId(id);
}
function setMainLayerPos(x, y)
{
	document.all.divLayer.style.left = x;
	document.all.divLayer.style.top = y;
}

function showAnchor()
{
	clearInterval(flashTimer);
	clearTimeout(closeAncTimer);
	document.all.postLayer.style.visibility = "visible";
	flashTimer = setInterval("flashAnchor()", 500);
	closeAncTimer = setTimeout("closeAnchor()", 30*1000);
}

function flashAnchor()
{
	var visi = document.all.postLayer.style.visibility;
	if (visi == "visible")
	{
		document.all.postLayer.style.visibility = "hidden";
	}
	else
	{
		document.all.postLayer.style.visibility = "visible";
	}
}

function closeAnchor()
{
	clearInterval(flashTimer);
	clearTimeout(closeAncTimer);
	document.all.postLayer.style.visibility = "hidden";
}

// ���ݽڵ�������ƶ�����
// ������������ϵ�һ���ڵ����꣬�ƶ�֮��ʹ�ڵ�λ�� Anchor ��
function moveMainLayer(coor)
{
	var x = y = 0;
	coor[0] = parseInt(coor[0]);
	coor[1] = parseInt(coor[1]);
	if (coor[0] > 0)
	{
		x = coor[0] - anchorPos[0];
		x = 0 - x;
	}
	else
	{
		x = anchorPos[0] - coor[0];
	}
	
	if (coor[1] > 0)
	{
		y = coor[1] - anchorPos[1];
		y = 0 - y;
	}
	else
	{
		y = anchorPos[1] - coor[1];
	}

	setMainLayerPos(x+23, y+10);
	
	showAnchor();
}
/** ** ������� -- ���� *** */


// ͨ�����̵ġ��������ҡ������������ͼλ��
function document.onkeydown()
{
// -----�Ȳ���--------��3-------
/*
 * try { if (document.all.blind.style.visibility == "visible") return; } catch
 * (exception) { }
 */
// ----------------------
	var left = divLayer.style.left;
	var top = divLayer.style.top;
	
	// left = left.substring(0, left.length - 2);
	// top = top.substring(0, top.length - 2);

	left = parseInt(left);
	top = parseInt(top);
	switch (event.keyCode)
	{
		/*
		 * case 81: // Q �����л���ͼ if (g_viewFlag == 0) { g_viewFlag = 1; var
		 * target = "showMap.jsp?filename=" + filename + "&viewflag=1";
		 * parent.mainFrame.location = target; } else if (g_viewFlag == 1) {
		 * g_viewFlag = 0; var target = "showMap.jsp?filename=" + filename +
		 * "&viewflag=0"; parent.mainFrame.location = target; } break;
		 */
		case 35:		// End
		case 82:		// R
			moveAction();
			break;
		case 37:
		case 65:		// A
			moveAction('left');
			break;
		case 38:
		case 87:		// W
			moveAction('up');
			break;
		case 39:
		case 68:		// D
			moveAction('right');
			break;
		case 40:
		case 83:		// S
			moveAction('down');
			break;
			
		case 90:		// Z
			zoomAll('out');
			break;
		case 88:		// X
			zoomAll();
			break;
		case 67:		// C
			zoomAll('in');
			break;
			
		case 69:		// E ����/��ʾ�������
			// showController(!controllerState);
			break;

		default:
			break;
	}

}


/** ** �����ƶ�������ĸ���ť�¼������Ű�ť�¼� -- ��ʼ *** */

var distance = 80;
var speed = 12;
var position;
var left;
var top;
var timer;

var zoom = 1.0;
var scale = 0.1;

var controllerState = true;

function moveAction(dir)
{

// /-----------------��4----
	closeAnchor();	// �ر�׼��
// hideLineTip(); // ������·��ʾ
// ------------------------

	clearTimer();
	updatePosition();
	
	if (dir == "left")
	{
		position = left + distance;
		timer = setInterval("moveLeft()", speed);
	}
	else if (dir == "up") 
	{
		position = top + distance;
		timer = setInterval("moveUp()", speed);
	}
	else if (dir == "right") 
	{
		position = left - distance;
		timer = setInterval("moveRight()", speed);
	}
	else if (dir == "down") 
	{
		position = top - distance;
		timer = setInterval("moveDown()", speed);
	}
	else
	{
		moveOrigin();
	}
}

function clearTimer()
{
	clearInterval(timer);
}

function moveLeft() 
{
	updatePosition();
	if (left >= position) 
	{
		clearTimer();
		return;
	}
	divLayer.style.left = (left + speed);
}

function moveUp() 
{
	updatePosition();
	if (top >= position)
	{
		clearTimer();
		return;
	}
	divLayer.style.top = (top + speed);
}

function moveRight()
{
	updatePosition();
	if (left <= position) 
	{
		clearTimer();
		return;
	}
	divLayer.style.left = (left - speed);
}

function moveDown() 
{
	updatePosition();
	if (top <= position) 
	{
		clearTimer();
		return;
	}
	divLayer.style.top = (top - speed);
}

function moveOrigin() 
{
	divLayer.style.left = 0;// parseInt(mainX);--���Ǹĺ�ģ����ڻָ�ԭ����λ��-----��5--
	divLayer.style.top = 0;// parseInt(mainY);
}

function updatePosition() 
{
	var divLeft = parseInt(divLayer.style.left);
	var divTop = parseInt(divLayer.style.top);
	
	// divLeft = divLeft.substring(0, divLeft.length - 2);
	// divTop = divTop.substring(0, divTop.length - 2);

	left = parseInt(divLeft);
	top = parseInt(divTop);
}

function zoomAll(state) 
{
	closeAnchor();// ---------�ĺ�������-
	if (divLayer.style.zoom == "") 
	{
		divLayer.style.zoom = 1.0;
	}
	
	if (state == "out") 
	{
		// ��С
		if (divLayer.style.zoom != "") 
		{
			zoom = parseFloat(zoom) - scale;
			if (zoom <= 0) 
			{
				zoom = 0.9;
			}
			else if (zoom > 0 && zoom < 0.5) 
			{
				zoom = 0.5;
				return;
			}
			divLayer.style.zoom = parseFloat(zoom);
		}
	}
	else if (state == "in") 
	{
		// �Ŵ�
		if (divLayer.style.zoom != "") 
		{
			zoom = parseFloat(zoom) + scale;
			if (zoom > 2.0) 
			{
				zoom = 2.0;
				return;
			}
			else if (zoom == 0.2) 
			{
				zoom = 1.1;
			}
			divLayer.style.zoom = parseFloat(zoom);
		}
	}
	else {
		// ��ԭ
		if (divLayer.style.zoom != "") 
		{
			divLayer.style.zoom = 1.0;
			zoom = 1.0;
		}
	}
}

function showController(show) 
{
	if (show) 
	{
		document.all.moveController.style.visibility = "visible";
		document.all.sizeController.style.visibility = "visible";
		controllerState = true;
	}
	else 
	{
		document.all.moveController.style.visibility = "hidden";
		document.all.sizeController.style.visibility = "hidden";
		// controllerState = false;
		controllerState = true;
	}
	return true;
}

// ------ ͼƬ����Ч������ - ��ʼ ------

function swapImage(imageID, imageSrc) 
{
	document.all(imageID).src = imgPath+imageSrc;
}

// ------ ͼƬ����Ч������ - ���� ------

function loadMoveController() 
{
	document.write('<div id="moveController" style="position:absolute;top:5px;left:5px;z-index:999;background-image:url(image/controller_bg.gif);">');
	document.write('<table width="66" border="0" cellspacing="0" cellpadding="0" style="font-size:9pt;"><tr><td height="19" width="19"></td><td width="28">');
	document.write('<img src="'+imgPath+'image/topo/arrow_up.gif" onmouseout="javascript:swapImage(\'image_up\', \'image/topo/arrow_up.gif\');" onmouseover="javascript:swapImage(\'image_up\', \'image/topo/arrow_up_over.gif\');" alt="�����ƶ� | W" width="28" height="19" onclick="javascript:moveAction(\'up\');" style="cursor:hand;" name="image_up" id="image_up" />');
	document.write('</td><td height="19" width="19"></td></tr><tr><td>');
	document.write('<img src="'+imgPath+'image/topo/arrow_left.gif" onmouseout="javascript:swapImage(\'image_left\', \'image/topo/arrow_left.gif\');" onmouseover="javascript:swapImage(\'image_left\', \'image/topo/arrow_left_over.gif\');" alt="�����ƶ� | A" width="19" height="28" onclick="javascript:moveAction(\'left\');" style="cursor:hand;" name="image_left" id="image_left" />');
	document.write('</td><td align="center" valign="middle" style="text-align:center;">');
	document.write('<img src="'+imgPath+'image/topo/arrow_center.gif" onmouseout="javascript:swapImage(\'image_center\', \'image/topo/arrow_center.gif\');" onmouseover="javascript:swapImage(\'image_center\', \'image/topo/arrow_center_over.gif\');" alt="��λ | R" width="19" height="19" onclick="javascript:moveAction(\'origin\');" style="cursor:hand;" name="image_center" id="image_center" />');
	document.write('</td><td>');
	document.write('<img src="'+imgPath+'image/topo/arrow_right.gif" onmouseout="javascript:swapImage(\'image_right\', \'image/topo/arrow_right.gif\');" onmouseover="javascript:swapImage(\'image_right\', \'image/topo/arrow_right_over.gif\');" alt="�����ƶ� | D" width="19" height="28" onclick="javascript:moveAction(\'right\');" style="cursor:hand;" name="image_right" id="image_right" />');
	document.write('</td></tr><tr><td></td><td>');
	document.write('<img src="'+imgPath+'image/topo/arrow_down.gif" onmouseout="javascript:swapImage(\'image_down\', \'image/topo/arrow_down.gif\');" onmouseover="javascript:swapImage(\'image_down\', \'image/topo/arrow_down_over.gif\');" alt="�����ƶ� | S" width="28" height="19" onclick="javascript:moveAction(\'down\');" style="cursor:hand;" name="image_down" id="image_down" />');
	document.write('</td><td></td></tr></table></div>');
}

function loadSizeController() 
{
	document.write('<div id="sizeController" style="position:absolute;top:80px;left:8px;z-index:998;background-image:url(image/controller_bg2.gif);width:60px;">');
	document.write('<table width="58" height="20" border="0" cellspacing="0" cellpadding="0"><tr><td width="18" height="20" style="padding-left:2px;">');
	document.write('<img src="'+imgPath+'image/topo/zoom_out.gif" onmouseout="javascript:swapImage(\'image_out\', \'image/topo/zoom_out.gif\');" onmouseover="javascript:swapImage(\'image_out\', \'image/topo/zoom_out_over.gif\');" alt="��С��ͼ | Z" width="18" height="16" onclick="javascript:zoomAll(\'out\');" style="cursor:hand;" name="image_out" id="image_out" />');
	document.write('</td><td align="center" style="text-align:center;">');
	document.write('<img src="'+imgPath+'image/topo/zoom_reset.gif" onmouseout="javascript:swapImage(\'image_reset\', \'image/topo/zoom_reset.gif\');" onmouseover="javascript:swapImage(\'image_reset\', \'image/topo/zoom_reset_over.gif\');" alt="��ԭ | X" width="18" height="16" onclick="javascript:zoomAll();" style="cursor:hand;" name="image_reset" id="image_reset" />');
	document.write('</td><td width="18" height="20">');
	document.write('<img src="'+imgPath+'image/topo/zoom_in.gif" onmouseout="javascript:swapImage(\'image_in\', \'image/topo/zoom_in.gif\');" onmouseover="javascript:swapImage(\'image_in\', \'image/topo/zoom_in_over.gif\');" alt="�Ŵ���ͼ | C" width="18" height="16" onclick="javascript:zoomAll(\'in\');" style="cursor:hand;" name="image_in" id="image_in" />');
	document.write('</td></tr></table></div>');
}
loadMoveController();		// �����ƶ�������
loadSizeController();		// ���ش�С������
showController(false);
/** ** �����ƶ�������ĸ���ť�¼������Ű�ť�¼� -- ���� *** */

		/**
		 * =============================== �������� ============================================
		 */
// ����ѡ��
function selectStart()
{
	topologyMapObject.selectStart();
}


function bodyDown()
{
	topologyMapObject.bodyDown();
}

// ����divLayer�հ״�ʱ
function divLayerDown()
{
	topologyMapObject.bodyDown();
}
