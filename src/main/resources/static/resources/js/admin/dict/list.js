$(function () {
    $("#addBtn").click(function () {
        jmcms.openDialogEdit("添加字典类型", adminPath + "/dict/type/form", null, null, saveCallback);
    });
    $("#dataTable").bootstrapTable({
        method: "post",
        dataType: "json",
        // 是否显示行间隔色
        striped: true,
        // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        cache: false,
        // 是否显示分页（*）
        pagination: true,
        // 排序方式
        sortOrder: "asc",
        // 初始化加载第一页，默认第一页
        pageNumber: 1,
        // 每页的记录行数（*）
        pageSize: 10,
        // 可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100],
        queryParams: function (params) {
            var searchParam = {};
            searchParam.pageIndex = params.limit === undefined ? "1" : params.offset / params.limit + 1;
            searchParam.pageSize = params.limit === undefined ? -1 : params.limit;
            searchParam.orderBy = params.sort === undefined ? "" : params.sort + " " + params.order;
            return searchParam;
        },
        // 这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: adminPath + "/dict/data",
        // 分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        columns: [{
            checkbox: true
        }, {
            field: "id",
            title: "id",
            formatter: function (value, row, index) {
                return value;
            }
        }, {
            field: "typeName",
            title: "字典类型名称",
            formatter: function (value, row, index) {
                return value;
            }
        }, {
            field: "typeCode",
            title: "字典类型代码",
            formatter: function (value, row, index) {
                return value;
            }
        }, {
            field: "sort",
            align: "center",
            title: "排序",
            formatter: function (value, row, index) {
                return value;
            }
        }, {
            field: "status",
            align: "center",
            title: "状态",
            formatter: function (value, row, index) {
                return value;
            }
        }]
    });
});

function saveCallback() {
    jmcms.success("回调！");
    $("#dataTable").bootstrapTable("refresh");
}