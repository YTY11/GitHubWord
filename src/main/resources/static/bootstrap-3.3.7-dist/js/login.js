
// 登陆校验
function login(){
    var userName = $("#userName").val();
    var password = $("#password").val();
    if(userName == null || userName.length <= 0){
        alert("请输入用户名");
    }else if(password == null || password.length <= 0){
        alert("请输入密码");
    }
    else{
        $.ajax({
            url:"userLogin",
            data:{
                "userName": userName,
                "password":password,
            },
            type:"post",
            success:function (msg){
                if ("false" != msg) {
                    // 用户名或密码错误
                    alert("用户名或密码错误");
                }else{
                    //登陆成功
                    alert("登陆成功")
                    $(window).attr("location","indexS");
                }
            }
        });
    }
};

// 注册弹框
function register(){
    $('#myModal').modal('toggle');
}

//注册用户名唯一性校验
function registerUserName(){
    var registerName = $("#registerName").val();
    $.ajax({
        url:"registerName",
        data:{
            "registerName": registerName
        },
        type:"post",
        success:function (msg){
            if ("false" == msg) {
                alert("用户名已存在!!!");
            }
        }
    });
}

// 注册
function userRegister(){
    var userName = $("#registerName").val();
    var password = $("#registerPassword").val();
    var post = $("#post").val();
    if(userName == null || userName.length <= 0){
        alert("请输入用户名");
        return false;
    }else if(password == null || password.length <= 0){
        alert("请输入密码");
        return false;
    }
    else{
        $.ajax({
            url:"userRegister",
            type:"post",
            data:{
                "userName": userName,
                "password":password,
                "post":post
            },
            success:function (msg){
                    //注册成功
                    if(msg == "true"){
                        alert("注册成功!!!");
                        $(window).attr("location","login");
                    }

                }


        });
    }
};