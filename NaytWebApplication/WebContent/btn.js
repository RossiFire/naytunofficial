$(function () {
    $("#btnLogo").click(function () {
        if ($("#btnLogo").hasClass("avanti")) {
            $("#btnLogo").removeClass("avanti");
            $("#btnLogo").addClass("indietro");
        } else {
            $("#btnLogo").removeClass("indietro");
            $("#btnLogo").addClass("avanti");
        }
    });
});