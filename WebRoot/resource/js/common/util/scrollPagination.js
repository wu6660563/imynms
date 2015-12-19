/**
 * ClassName: scrollPagination.js
 * <p>
 * 滚动分页
 * 
 * @author      聂林
 * @version     v1.01
 * @since       v1.01
 * @Date        2012-6-25 上午09:48:17
 */
ScrollPagination = function(options) {
    var opt = $.extend(this, options);
    scrollPagination = this;
    return this.init(this);
};

ScrollPagination.prototype = {
    
    pageSize : null,

    totalCount : null,

    totalPage : null,

    firstIndex : null,

    currentPage : null,

    hasPrePage : null,

    hasNextPage : null,

    enable : false,

    url : null,

    contentData : null,

    beforeLoad : null,

    afterLoad : null,

    scrollTarget : $(window),

    heightOffset : 10,

    loadingDIV : null,
    
    init : function(options) {
        this.setEnable(true);
        $(this.scrollTarget).scroll(function(event) {
            scrollPagination.scroll(event);
        });
    },
    
    scroll : function(event) {
        if (this.getEnable()) {
            this.loadContent();
        }
    },

    loadContent : function() {
        var documentHeight = $(document).height();
        if (documentHeight < document.body.scrollHeight) {
            documentHeight = document.body.scrollHeight;
        }
        var mayLoadContent = $(this.scrollTarget).scrollTop()
            + this.heightOffset >= documentHeight
            - $(this.scrollTarget).height();
        if (mayLoadContent && this.hasNextPage) {
            this.currentPage = this.currentPage + 1;
            if (this.beforeLoad) {
                this.beforeLoad();
            }
            this.showLoadingDIV(true);
            this.setEnable(false);
            var data = "currentPage=" + this.currentPage
            + "&pageSize=" + this.pageSize;
            if (this.contentData) {
                data = data + "&" + this.contentData;
            }
            $.ajax({
                type : 'POST',
                url : this.url,
                cache : false,
                data : data,
                success : function(data) {
                    scrollPagination.success(data);
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("加载数据失败！");
                }
            });
        }
    },

    showLoadingDIV : function(enable) {
        if (!this.loadingDIV) {
            $("<div>", {
                id : "loadingDIV",
                text: "正在加载数据，请稍后!",
                'class' : 'loading'
              }).appendTo("body");
            this.loadingDIV = $("#loadingDIV");
        }
        if (enable) {
            this.loadingDIV.fadeIn();
        } else {
            this.loadingDIV.fadeOut();
        }
        
    },

    success : function (data) {
        this.setEnable(true);
        this.showLoadingDIV(false);
        this.afterLoad(data);
    },

    setEnable : function (enable) {
        this.enable = enable;
    },
    
    getEnable : function () {
        return this.enable;
    }
};
