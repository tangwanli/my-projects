  /* login.js */

  $(function() {

    // 点注册的时候跳转到注册页面
    $(".register").click(function() {
        window.location.href = "register.html";
    });
    console.log("成功加载js");
    loginValidate();
  })



  // 登录验证
  function loginValidate() {

    // 失去焦点的时候判断用户名是否存在
    $(".username").blur(function() {
        userValidate();
    });


    // 失去焦点的时候判断密码是否输入正确
    $(".password").blur(function() {
        passwordValidate();
    });


    $(".login").click(function() {
        if($(".secondPoint").text() == "*密码输入正确")
        {
        	window.location.href = "index.html";
        } else {
        	console.log("登录失败");
        	return false;
        }
    });

  }


  // 验证用户名
  function userValidate() {

    var inputUsername = $(".username");

    // 不管执行成什么样子，失去焦点之后，都要将提示字符显示出来
    $(".firstPoint").fadeTo(600,0.8);
    
    if((inputUsername.val() == null || inputUsername.val() == "") == false) {
    	// 关于这个ajax的回调函数有一个问题，不是发了请求之后回调函数就会执行，而是加入一个队列。所以，他会先执行回调函数后面的代码，最后再执行回调函数中的东西
    	$.post("LoginServlet", {
            username: inputUsername.val(),
            password: ""
        }, function(data) {
            console.log("验证用户名服务器返回的值为" + data.isReturn + " 类型为" +typeof(data.isReturn));
            if(data.isReturn == "true") {
            	$(".firstPoint").css("color","green").text("*用户名输入正确");
            } else {
            	// 这里需要加一个else，避免输入了正确用户名之后，再把用户名删除了，还是现实绿色的提示
            	$(".firstPoint").css("color","red").text("*请填写正确的用户名");
            }
        },"json");
    }  

  }

  // 验证密码
  function passwordValidate() {
	
    var inputUsername = $(".username");
    var inputPassword = $(".password");

    $(".secondPoint").fadeTo(600,0.8);
    
    if((inputPassword.val() == null || inputPassword.val() == "") == false) {
    	$.post("LoginServlet", {
            username: inputUsername.val(),
            password: inputPassword.val()
        }, function(data) {
            console.log("验证用户名服务器返回的值为" + data.isReturn + " 类型为" +typeof(data.isReturn));
            if(data.isReturn == "true") {
            	$(".secondPoint").css("color","green").text("*密码输入正确");
            } else {
            	$(".secondPoint").css("color","red").text("*请填写正确的用户名或密码");
            }
        },"json");
            
    }
        	
  }