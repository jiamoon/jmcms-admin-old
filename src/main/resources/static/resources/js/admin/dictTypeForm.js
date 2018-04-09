$(function () {
    $("#saveBtn").click(function () {
        $.ajax({
            url: "/admin/dict/save",
            data: $("#inputForm").serialize(),
            dataType: "json",
            success: function (data) {
                alert(data.msg);
            }
        });
    });
});