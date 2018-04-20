$(function () {
    $("input[type='radio']").iCheck({
        handle: "radio",
        checkboxClass: "icheckbox_square-blue",
        radioClass: "iradio_square-blue"
    });
});

/**
 * 提交表单
 * @param index
 * @param saveCallback
 */
function doSubmit(index, saveCallback) {
    if (saveCallback != undefined) {
        jmcms.close(index);
        saveCallback();
    }
}