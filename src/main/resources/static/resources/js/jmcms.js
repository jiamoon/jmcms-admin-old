/**
 * 嘉梦科技全局js工具类
 *
 * @author 嘉梦科技
 */
$(function () {
    /**
     * 全局ajax设置
     */
    $.ajaxSetup({
        async: false,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (XMLHttpRequest.status == 404) {
                jmcms.error("请求地址不存在！");
            }
            else if (XMLHttpRequest.status == 500) {
                jmcms.error("服务端发生异常，请联系管理员！");
            }
            else if (XMLHttpRequest.status == 403) {
                jmcms.error("您没有权限访问！");
            }
            else if (XMLHttpRequest.status == 401) {
                jmcms.error("您未登陆！");
            }
        }
    });
    jmcms = {
        adminPath: "/admin",
        ajax: function (options, success, complete) {
            options.success = function (data) {
                if (typeof data === "object" && data.code != 0) {
                    jmcms.error(data.msg);
                }
                else {
                    success(data);
                }
            };
            options.complete = function (XMLHttpRequest, textStatus) {
                setTimeout(function () {
                    complete(XMLHttpRequest, textStatus);
                }, 2000);
            };
            $.ajax(options);
        },
        /**
         * 普通信息弹窗
         * @param msg
         */
        msg: function (msg) {
            top.layer.msg(msg);
        },
        /**
         * 警告弹窗
         * @param msg
         */
        warning: function (msg, icon) {
            top.layer.msg(msg, {
                icon: icon == null ? 0 : icon
            });
        },
        /**
         * 成功弹窗
         * @param msg
         */
        success: function (msg, icon, callback) {
            if (typeof icon === "function"){
                callback = icon;
                icon = 1;
            }
            top.layer.msg(msg, {
                icon: icon == null ? 1 : icon
            }, function () {
                callback();
            });
        },
        /**
         * 错误弹窗
         * @param msg
         */
        error: function (msg, icon) {
            top.layer.msg(msg, {
                icon: icon == null ? 5 : icon
            });
        },
        /**
         * 关闭弹窗
         * @param index
         */
        close: function (index) {
            if (index) {
                top.layer.close(index);
            }
            else {
                top.layer.closeAll();
            }
        },
        /**
         * alert提示框
         * @param msg
         * @param btnAlign 按钮对齐(l、c、r)
         */
        alert: function (msg, btnAlign) {
            if (btnAlign) {
                top.layer.alert(msg, {
                    btnAlign: btnAlign
                });
            }
            else {
                top.layer.alert(msg, {
                    btnAlign: "c"
                });
            }
        },
        /**
         * Loading加载提示
         * @param msg
         * @param icon
         * @returns {*|void}
         */
        loading: function (msg, icon) {
            if (!msg) {
                msg = "正在提交，请稍等。。。";
            }
            var index = top.layer.msg(msg, {
                icon: icon == null ? 16 : icon,
                shade: 0.01,
                time: 999999999//设置超长时间
            });
            return index;
        },
        /**
         * 打开浏览对话框
         * @param title
         * @param url
         * @param width
         * @param height
         */
        openDialogView: function (title, url, width, height) {
            width = width || "70%";
            height = height || "80%";
            var auto = true;//是否使用响应式，使用百分比时，应设置为false
            if (width.indexOf("%") >= 0 || height.indexOf("%") >= 0) {
                auto = false;
            }
            top.layer.open({
                type: 2,
                area: [width, height],
                title: title,
                auto: auto,
                //maxmin: true, //开启最大化最小化按钮
                content: url,
                btn: ["关闭"],
                btnAlign: "c",
                cancel: function (index) {
                }
            });
        },
        /**
         * 打开编辑对话框
         * @param title
         * @param url
         * @param width
         * @param height
         */
        openDialogEdit: function (title, url, width, height, saveCallback) {
            width = width || "70%";
            height = height || "80%";
            var auto = true;//是否使用响应式，使用百分比时，应设置为false
            if (width.indexOf("%") >= 0 || height.indexOf("%") >= 0) {
                auto = false;
            }
            top.layer.open({
                type: 2,
                area: [width, height],
                title: title,
                auto: auto,
                //maxmin: true, //开启最大化最小化按钮
                content: url,
                btn: ["保存", "关闭"],
                btnAlign: "c",
                yes: function (index, layero) {
                    var iframeWindow = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                    if (iframeWindow.contentWindow.doSubmit != undefined) {
                        iframeWindow.contentWindow.doSubmit(index, saveCallback);
                    }
                    else {
                        top.layer.close(index);
                    }
                },
                cancel: function (index) {
                }
            });
        }
    };
});