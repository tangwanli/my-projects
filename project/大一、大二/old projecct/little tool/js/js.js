// js
  


  // cookie初始代码
  // 建立cookie
  function setCookie(name, value, iDay) {
    var oDate=new Date();
    oDate.setDate(oDate.getDate() + iDay);
    // 定义一个cookie后面用字符串连接的方式,方便之后用split()分解
    document.cookie=name+"="+value+";expires="+oDate;
  }

  // 从cookie里面取值
  function getCookie(name) {
    // 将建立的cookie字符串根据“；”分开，分别储存在arr数组里面
    var arr=document.cookie.split(";");
    var i=0;
    for(i=0;i<arr.length;i++) {
        // 将分开之后的cookie字符串，再进行分割
        var arr2=arr[i].split("=");
        // 判断输入进来的name是不是与设置的name一样
        if(arr2[0] == name) {
            // 输出value
            return arr2[1];
        }
        else {
            // 如果没找到就返回空值
            return "";
        }
    }
  }

  // 删除cookie
  function clearCookie(name) {
    // 将设置的时间设置为-，则直接就为过期
    setCookie(name,"1",-1);
  }



  // 共享onload事件
  function addLoadEvent(func) {
    var oldonload = window.onload;
    if (typeof window.onload != "function") {
        window.onload = func;
    }
    else {
        window.onload = function() {
            oldonload();
            func();
        }
    }
  }

  addLoadEvent(carouselFigure);
  // 初始化，默认页面加载的时候，方向左边移动
  addLoadEvent(moveLeft);
  addLoadEvent(saCk);



  // 轮播图
  // 声明明两个定时器变量
  var timer_left;
  var timer_right;
  // 声明一个变量，用于onmouseout，当点击left时i=1，点击right时i=0
  var i = 1;
  // 读取ul，为了之后使ul翻倍
  var pic_move = document.getElementsByClassName("pic-move")[0];
  function carouselFigure() {

    var buttom_left = document.getElementsByClassName("buttom-left")[0];
    var buttom_right = document.getElementsByClassName("buttom-right")[0];

    // 读取li，为了之后用li.length，动态初始化ul的宽度
    var pic_li = pic_move.getElementsByTagName("li");
    
    // 使ul翻倍
    pic_move.innerHTML += pic_move.innerHTML;

    // 动态初始化ul的宽度
    pic_move.style.width = pic_li[0].offsetWidth * pic_li.length +"px";
    

    buttom_left.onclick = function() {
      // 清除自身方向的移动，防止使速度叠加，即多次开启定时器
      clearTimeout(timer_left);
      // 清除反方向的定时器
      clearTimeout(timer_right);
      moveLeft();
      i=1;
    }

    buttom_right.onclick = function() {
      clearTimeout(timer_right);
      clearTimeout(timer_left);
      moveRight();
      i=0;
    }

    pic_move.onmouseover = function() {
      clearTimeout(timer_right);
      clearTimeout(timer_left);
    }

    pic_move.onmouseout = function() {
        if(i == 1) {
          moveLeft();
        }
        else {
          moveRight();
        }
    }
  }

  function moveLeft() {
    var speed = 10;     
    // 当运动到超过总长度一半的时候，将位置移到初始位置
    if(-pic_move.offsetLeft >= pic_move.offsetWidth/2 ) {
    pic_move.style.left = 0;
    }
      else {   
    pic_move.style.left = pic_move.offsetLeft - speed + "px";
    }

    timer_left = setTimeout("moveLeft()",100);

  }

  function moveRight() {
    var speed = 10;     
    
    if(pic_move.offsetLeft >= 0 ) {
    pic_move.style.left = -pic_move.offsetWidth/2 + "px";
    }
      else {   
    pic_move.style.left = pic_move.offsetLeft + speed + "px";
    }

    timer_right = setTimeout("moveRight()",100);
  }



  // cookie保存登陆信息
  function saCk() {
    var user_sa = document.getElementsByClassName("user-sa")[0];
    var sub_sa = document.getElementsByClassName("sub-sa")[0];
    var clear_ck = document.getElementsByClassName("clear-ck")[0];

    // 点击登陆的时候保存cookie
    sub_sa.onclick = function() {
      setCookie("user",user_sa.value,30);
      // 取出cookie中的值保存在value中
      user_sa.value = getCookie("user");
    }
    
    // 清除cookie，并且清除他现在的值
    clear_ck.onclick = function() {
      clearCookie("user");
      user_sa.value = "";
    }
  }