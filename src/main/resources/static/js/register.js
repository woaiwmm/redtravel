$(document).ready(function () {
    var bgSize = function () {
        var screenWidth = $(window).width();
        var screenHeight = $(window).height();
        $("#content").css({ "height": screenHeight, "width": screenWidth });
    }
    bgSize();
    var judge = function () {
        if ($(".txtUserName").val() == "") {
            $(".errorTxt").html("用户名为空！");
            return;
        }
        if ($(".txtPassWord").val() == "") {
            $(".errorTxt").html("密码为空！");
            return;
        }
        if ($(".txtPassWordAgain").val() == "") {
            $(".errorTxt").html("确定密码为空！");
            return;
        }
        if ($(".txtUserName").val().length < 8 || $(".txtPassWord").val().length > 16) {
            $(".errorTxt").html("用户名长度为8-16位！");
            return;
        }
        if ($(".txtPassWord").val().length < 8 || $(".txtPassWord").val().length > 16) {
            $(".errorTxt").html("密码长度为8-16位！");
            return;
        }
        var regularName=/^[a-zA-Z]([a-zA-Z0-9_]){7,15}$/;
        if(new RegExp(regularName).test($(".txtUserName").val())==false){
            $(".errorTxt").html("用户名必须由字母开头，可带数字、字母和下划线，长度在8-16之间");
            return;
        }
        var regularPassWord=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,16}$/;
        if(new RegExp(regularPassWord).test($(".txtPassWord").val())==false){
            $(".errorTxt").html("密码必须包含大小写字母和数字的组合，不使用特殊字符，长度在8-16之间");
            return;
        }
        if ($(".txtPassWordAgain").val() != $(".txtPassWord").val()) {
            $(".errorTxt").html("密码不一致！请再次确定您的密码");
            return;
        }

    }
    var submitXML;
    function submitXML(){
        var fileInput = $('#reportXML').get(0).files[0];
        console.info(fileInput);
        if(fileInput){
            $("#reportXMLform").submit();
        }else{
            alert("请先选择上传文件，然后点击提交！");
        }
    }

    $(".saveUser").click(function () {
        $(".errorTxt").html("");
        judge();
        submitXML();
        return false;
    })
    $(window).resize(function () {
        bgSize();
    })
})