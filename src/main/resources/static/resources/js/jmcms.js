/**
 * 嘉梦科技全局js工具类
 *
 * @author 嘉梦科技
 */
$(function () {
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
        warning: function (msg) {
            top.layer.msg(msg, {
                icon: 0
            });
        },
        /**
         * 成功弹窗
         * @param msg
         */
        success: function (msg) {
            top.layer.msg(msg, {
                icon: 1
            });
        },
        /**
         * 错误弹窗
         * @param msg
         */
        error: function (msg) {
            top.layer.msg(msg, {
                icon: 2
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
        }
    };
});