  /* login.js */

  $(function() {
            localStorage.setItem('userId','');
            localStorage.setItem('userName','');
    // 点注册的时候跳转到注册页面
    $(".register").click(function() {
        window.location.href = "register1.html";
    });
    console.log("成功加载js");
    loginValidate();
    document.querySelector('.change-sta').onclick = function(){
      changeSta();
    };
  });



  // 登录验证
  function loginValidate() {
	  console.log('进入之前登录验证');
    // 失去焦点的时候判断用户名是否存在
    $(".username").blur(function() {
    	console.log('进入之前登录验证函数');
        userValidate();
    });

    $(".login").click(function() {
        passwordValidate();
    });

  }


  // 验证用户名
  function userValidate() {
	  console.log('进入登录验证');
    var inputUsername = $(".username");
    console.log('进入登录验证',inputUsername.val());
    // 不管执行成什么样子，失去焦点之后，都要将提示字符显示出来
    $(".firstPoint").fadeTo(600,0.8);
    
    if((inputUsername.val() == null) == false) {
             // 关于这个ajax的回调函数有一个问题，不是发了请求之后回调函数就会执行，而是加入一个队列。所以，他会先执行回调函数后面的代码，最后再执行回调函数中的东西
        $.post("checkUsername", {
            userName: inputUsername.val()
        }, function(myData) {
        	console.log('登录验证成功');
            if(myData.code == 100) {
                $(".firstPoint").css("color","green").text("*用户名正确");
            } else {
                // 这里需要加一个else，避免输入了正确用户名之后，再把用户名删除了，还是现实绿色的提示
                $(".firstPoint").css("color","red").text("*用户名错误");
            }
        },"json");
    }  
  }

  // 验证
  function passwordValidate() {
    
    var inputUsername = $(".username");
    var inputPassword = $(".password");

    $(".firstPoint").fadeTo(600,0.8);
    
    if((inputPassword.val() == null || inputPassword.val() == "") == false) {
        $.post("login", {
            userName: inputUsername.val(),
            userPassword: inputPassword.val()
        }, function(myData) {
            let userId = myData.data.userId,
                userRole = myData.data.userRole,
                userName = $(".username").val();
            localStorage.setItem('userId',userId);
            localStorage.setItem('userName',userName);
            if (myData.code === 100) {
                if (userRole === 0) {
                    window.location.href = "index.html";
                  } else {
                    // 这下面这个为管理员的主页
                    window.location.href = "userInform.jsp";
                  }
            } else {
            	alert('用户名密码错误，请再试一次');
            }

            
        },"json");
            
    }
            
  }

  function changeSta() {
    let state = document.querySelector('.change-sta');
    if (state.innerText === '用户登录') {
      state.innerText = '管理员登录';
    } else {
      state.innerText = '用户登录';
    }
  }