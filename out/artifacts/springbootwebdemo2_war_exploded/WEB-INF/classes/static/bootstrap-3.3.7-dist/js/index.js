//添加用户名唯一性校验
function userNameVerify() {
    var addUserName = $("#addUserName").val();
    $.ajax({
        url: "/addName",
        data: {
            "userName": addUserName
        },
        type: "post",
        success: function (msg) {
            if ("false" == msg) {
                alert("用户名已存在!!!");
                $("#addUserName").innerHTML="";
            }
        }
    });
}

// 添加
function addUserData() {
    var userName = $("#addUserName").val();
    var name = $("#addName").val();
    var password = $("#addUserPassword").val();
    var post = $("#post").val();
    var email = $("#addUserEmail").val();
    var number = $("#addUserNumber").val();
    var floor = $("#addUserFloor").val();
    if (userName == null || userName.length <= 0) {
        alert("请输入用户名");
        return false;
    } else if (password == null || password.length <= 0) {
        alert("请输入密码");
        return false;
    } else {
        $.ajax({
            url: "/addUser",
            type: "post",
            data: {
                "userName": userName,
                "name": name,
                "password": password,
                "post": post,
                "email": email,
                "numberId": number,
                "floor": floor
            },
            success: function (msg) {
                //添加成功
                if (msg == "true") {
                    alert("添加成功!!!");
                    $(window).attr("location", "/indexS");
                }
            }
        });
    }
};

// 更新
function updateUserData() {
    var userName = $("#updateUserName").val();
    var name = $("#updateName").val();
    var password = $("#updateUserPassword").val();
    var post = $("#updatePost").val();
    var email = $("#updateUserEmail").val();
    var number = $("#updateUserNumber").val();
    var floor = $("#updateUserFloor").val();
    if (password == null || password.length <= 0) {
        alert("请输入密码");
        return false;
    } else {
        $.ajax({
            url: "/updateUser",
            type: "post",
            data: {
                "userName": userName,
                "name": name,
                "password": password,
                "post": post,
                "email": email,
                "numberId": number,
                "floor": floor
            },
            success: function (msg) {
                //更新成功
                if (msg == "true") {
                    alert("更新成功!!!");
                    $(window).attr("location", "/indexS");
                }
            }
        });
    }
};

//将数据在模态框中显示
function updateUserModel(obj) {
    //点击更新按钮后展示模态框
    $('#updateUser').modal('show');
    //获取当前行的所有列
    var tds = $(obj).parent().parent().find('td');
    //(".userName"):通过class属性获取当前需要填写数据的输入框
    //$(tds.eq(0)).text():通过下标取得对应列中的值
    $(".userName").val($(tds.eq(0)).text());
    $(".name").val($(tds.eq(1)).text());
    $(".password").val($(tds.eq(2)).text());
    $(".post").val($(tds.eq(3)).text());
    $(".email").val($(tds.eq(4)).text());
    $(".number").val($(tds.eq(5)).text());
    $(".floor").val($(tds.eq(7)).text());
}


//按姓名模糊查询
function onSearch(obj) {//js函数开始
    setTimeout(function () {//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取

        var storeId = document.getElementById('allData');//获取table的id标识
        var rowsLength = storeId.rows.length;//表格总共有多少行
        var key = obj.value;//获取输入框的值
        var searchCol = 1;//要搜索的哪一列，这里是第二列（姓名），从1开始数起
        for (var i = 1; i < rowsLength - 2; i++) {//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
            var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值
            if (searchText.match(key)) {//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
                storeId.rows[i].style.display = '';//显示行操作，
            } else {
                storeId.rows[i].style.display = 'none';//隐藏行操作
            }
        }
    }, 200);//200为延时时间
}


// 添加email校验
function validateEmail(){
    var x = $("#addUserEmail").val();
    var atpos=x.indexOf("@");
    var dotpos=x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
        alert("不是一个有效的 e-mail 地址");
        return false;
    }
}

//更新email校验
function validateEmail1(){
    var x = $("#updateUserEmail").val();
    var atpos=x.indexOf("@");
    var dotpos=x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
        alert("不是一个有效的 e-mail 地址");
        return false;
    }
}

function onSearch(){
    var name = $("#key").val();
    $.ajax({
       type:"post",
       data:{
           "name":name
       },
       url:"/indexS",
        success:function(msg){
            $(window).attr("location", "/index");
        }
    });
}
