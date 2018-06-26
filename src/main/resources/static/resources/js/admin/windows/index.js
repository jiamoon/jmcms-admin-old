$(function () {
    getDate();
    new Vue({
        el: "#taskBar",
        data: {
            showMenu: false
        },
        methods: {
            startBtnOnclick: function () {
                this.showMenu = !this.showMenu;
            }
        }
    });
});

function getWeek(dayOfWeek) {
    var day;
    switch (dayOfWeek) {
        case 0:
            day = "日";
            break;
        case 1:
            day = "一";
            break;
        case 2:
            day = "二";
            break;
        case 3:
            day = "三";
            break;
        case 4:
            day = "四";
            break;
        case 5:
            day = "五";
            break;
        case 6:
            day = "六";
            break;
    }
    return day;
}

function getDate() {
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    month = month < 10 ? "0" + month : month;
    var day = myDate.getDate() < 10 ? "0" + myDate.getDate() : myDate.getDate();
    var dayOfWeek = getWeek(myDate.getDay());
    var hour = myDate.getHours() < 10 ? "0" + myDate.getHours() : myDate.getHours();
    var minutes = myDate.getMinutes() < 10 ? "0" + myDate.getMinutes() : myDate.getMinutes();
    var second = myDate.getSeconds() < 10 ? "0" + myDate.getSeconds() : myDate.getSeconds();

    new Vue({
        el: "#showDate",
        data: {
            year: year,
            month: month,
            day: day,
            dayOfWeek: dayOfWeek,
            hour: hour,
            minutes: minutes,
            second: second
        },
        mounted: function () {
            this.$nextTick(function () {
                setInterval(this.timer, 1000);
            })
        },
        methods: {
            timer: function () {
                var myDate = new Date();
                this.year = myDate.getFullYear();
                var month = myDate.getMonth() + 1;
                this.month = month < 10 ? "0" + month : month;
                this.day = myDate.getDate() < 10 ? "0" + myDate.getDate() : myDate.getDate();
                this.dayOfWeek = getWeek(myDate.getDay());
                this.hour = myDate.getHours() < 10 ? "0" + myDate.getHours() : myDate.getHours();
                this.minutes = myDate.getMinutes() < 10 ? "0" + myDate.getMinutes() : myDate.getMinutes();
                this.second = myDate.getSeconds() < 10 ? "0" + myDate.getSeconds() : myDate.getSeconds();
            }
        }
    });
}