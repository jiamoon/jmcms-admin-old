$(function () {
    $("#addBtn").click(function () {
        jmcms.openDialogEdit("添加字典类型", adminPath + "/dict/type/form", null, null, saveCallback);
    });
});

function saveCallback() {
    jmcms.success("回调！");
}