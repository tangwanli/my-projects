  /* register.js */

  $(function() {

    $(".register").click(function() {
        register();
        window.location.href = "login.html";
    });

    $(".username").blur(function() {
        userValidate();
    });

    $(".second-p").blur(function() {
        ensurePassword();
    });

  })


    function userValidate() {

    var inputUsername = $(".username");
    
    if((inputUsername.val() == null || inputUsername.val() == "") == false) {
        
        $.post("LoginServlet", {
            username: inputUsername.val(),
            password: ""
        }, function(data) {
            console.log("验证用户名服务器返回的值为" + data.isReturn + " 类型为" +typeof(data.isReturn));
            // 服务器返回true代表数据库中有这个用户名了，false代表没有
            if(data.isReturn == "false") {
                $(".firstPoint").fadeTo(600,0.8).css("color","green").text("*用户名可用");
            } else {
                $(".firstPoint").fadeTo(600,0.8).css("color","red").text("*用户名已存在");
            }
        },"json");
    }  

  }

  function ensurePassword() {

    var firstP = $(".first-p").val();
    var secondP = $(".second-p").val();

    if(firstP != null && firstP != "" && firstP == secondP) {
        $(".secondPoint").fadeTo(600,0).css("color","green").text("*输入正确");
    } else {
        $(".secondPoint").fadeTo(600,0.8).css("color","red").text("*请再次确认密码");
    }
  }

  function register() {

    if($(".firstPoint").text() == "*用户名可用" && $(".secondPoint").text() == "*输入正确") {

        $.post("RegisterServlet", {
            username: $(".username").val(),
            password: $(".second-p").val()
        }, function(data) {
            console.log("成功注册");
        }, "json")
    } else {
        return false;
    }
  }

