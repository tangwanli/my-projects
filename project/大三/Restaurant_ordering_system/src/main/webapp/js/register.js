  /* register.js */

  $(function() {

    $(".register").click(function(ev) {
      ev.preventDefault();
        register();
    });

    $(".username").blur(function() {
        userValidate();
    });

    $(".reset").click(function(ev) {
        ev.preventDefault();
        reset();
    });

  })


  // 验证用户名
  function userValidate() {

    var inputUsername = $(".username");

    // 不管执行成什么样子，失去焦点之后，都要将提示字符显示出来
    $(".firstPoint").fadeTo(600,0.8);
    
    if((inputUsername.val() == null) == false) {
             // 关于这个ajax的回调函数有一个问题，不是发了请求之后回调函数就会执行，而是加入一个队列。所以，他会先执行回调函数后面的代码，最后再执行回调函数中的东西
        $.post("checkUsername", {
            userName: inputUsername.val()
        }, function(myData) {
            if(myData.code == 100) {
                $(".firstPoint").css("color","green").text("*用户名不可用");
            } else {
                // 这里需要加一个else，避免输入了正确用户名之后，再把用户名删除了，还是现实绿色的提示
                $(".firstPoint").css("color","red").text("*用户名可用");
            }
        },"json");
    }  
  }

  function register() {

        $.post("register", {
            userName: $(".username").val(),
            userPassword: $(".password").val(),
            userEmail: $(".email").val(),
            userPhone: $(".phone").val()
        }, function(data) {
            if (data.code === 100) {
            	alert('注册成功，请牢记用户名和密码');
                window.location.href = "login1.html";
            }
        }, "json")
  }

function reset() {
$(".username").val('');
$(".password").val('');
$(".email").val('');
$(".phone").val('');
}