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
        }
    });
    jmcms = {
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
        success: function (msg, icon) {
            top.layer.msg(msg, {
                icon: icon == null ? 1 : icon
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
        }
    };
});