  /* index.js */

  $(function() {

    // 登录验证,还会返回用户名，用于
    //validate();
    


    // 设置页面的时间
    setPageDate();



    // 列表显示和隐藏
    // 这里的选择器里面必须要把两个都分别选上，不然会出问题
    $(".listheader").next().css("display","none");
    $(".listheader:eq(0),.listheader:eq(1)").click(function() {
      $(this).next().toggle(600);
    })



    // 原生JS获取index,如果用jq的index方法，只能获取每个li相对于
    // 他的上一个包含块的index，如果还有其他包含块的index，则不能获取
    getLiIndex();

    

    // 获取input，然后根据input将它上面的文本框的内容传上去
    getInputIndex();
    
    initFile();
    // 删除
    $(".dsub").click(function() {
      deleteBook();
    })
    
    // 查找
    $(".qsub").click(function() {
      queryBook();
    })



  })



  function validate() {
    $.post("ValidateServlet", {}, function(data) {
      if(data.username == "false") {
        window.location.href = "login.html"
      } else {
        $(".username").text(data.username);
      }   
    },"json");
  }



  function setPageDate() {
    var time = $(".time");
    
    var timer = setInterval(function() {
      var date = new Date();
      var strTime = date.getFullYear()+"年"+(date.getMonth()+1)+"月"+
      +date.getDay()+"日 "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
      time.text(strTime);
    },1000);
clearInterval(timer);

  }



  function getLiIndex() {
    var leftNav = document.getElementsByClassName("left-nav")[0];
    var allLi = leftNav.getElementsByTagName("li");
    for(var i=0; i<allLi.length; i++) {
      allLi[i].index = i;
      allLi[i].onclick = function() {
        changeOpe(this.index)
    }
    }
  }



  function changeOpe(index) {


    // 显示和隐藏ope
    if(index == 5 || index == 2) {
      $(".elsereturn").empty();
      $(".return").empty();
    }
    $(".operate li").css("display","none");

    // 直接后面用[index]会把jq对象变为dom对象
    var actionLi = $(".operate li")[index + 1];
    $(actionLi).css("display","list-item");

    // 显示和隐藏小标签,改变字体颜色
    // 先把小标签和字体的颜色都清空
    $(".add-tag").text("");
    $(".left-nav li").css("color","#fff");
    var littleTag = $($(".left-nav li")[index]);
    littleTag.css("color","#edef65");
    var tagText = littleTag.text().split(" ")[0];
    $(".add-tag").text(tagText);
  }



  function getInputIndex() {
    var allInput = $("input");
    for(var i=0; i<allInput.length; i++) {
      allInput[i].index = i;
      allInput[i].onclick = function() {
        console.log("第："+ this.index);
        sendMsg(this.index);
      }
    }
  }



  // 初始化读取xml文件中的message个数
  function initFile() {
    var defaultNum = 0;
    var atimer = setInterval(function() {
      returnFile(defaultNum);
    },5000);
  }
  
  function returnFile(defaultNum) {
    $.post("OperateServlet",{
        method: "returnFile"
      }, function(xml) {
         var nowNum = $(xml).find("message").length;
         if(nowNum != defaultNum) {
          defaultNum = nowNum;
          var lastMessage = $(xml).find("message").slice(-1);
          addContent(lastMessage)
         }
      }, "xml");
  }


  
  function addContent(lastMessage) {
    console.log("传入addContent函数的lastMessage："+lastMessage);
    var username = $(".username").text();
    var target = $(".add-tag").text();
    var from = lastMessage.find("from").text();
    var to = lastMessage.find("to").text();
    var content = lastMessage.find("content").text();

    console.log("username:"+username);
    console.log("target:"+target);
    console.log("from:"+from);
    console.log("to:"+to);
    console.log("content:"+content);
    if(username == from && target == to) {
      var index = getNowIndex(to);
       $($("textarea")[index]).val("");
       var aimChat = $(".chattext").get(index);
       var addElement = "<span>"+from+": "+content+"</span>";
       console.log("添加的元素为："+addElement);
       $(aimChat).append();
       $(aimChat).append("<br>");
    } else {
      if(target == from && username == to) {
       var index = getNowIndex(from);
       $($("textarea")[index]).val("");
       var aimChat = $(".chattext").get(index);
       var addElement = "<span>"+from+": "+content+"</span>";
       $(aimChat).append();
       $(aimChat).append("<br>");
      }
    }
  }

  // 获取现在是和哪个人聊天,这个函数返回和读取的xml文件中符合的index
  function getNowIndex(to) {
    var allLi = $(".left-nav li");
    for(var i=0; i<allLi.length; i++) {
      var people = $(allLi[i]).text().split(" ")[0];
      if(people == to)
      {
        return i;
      }
    }
  }
  
  // 这个函数只是发消息给servlet，不进行其他操作
  function sendMsg(index) {

    // 这个username读取的是当前的用户
    var username = $(".username").text();
 // 这个目标即当时正在和谁进行聊天
    var target = $(".add-tag").text();
    var text = $($("textarea")[index]).val();
    
    console.log("发送的全部消息"+username+" :"+target+" :"+text);
console.log("第"+index+"个")
    if(text == "") {
      return false;
    } else {
      $.post("OperateServlet", {
        username: username,
        text: text,
        target: target,
        method: "setNode"
      });
    }
  }




    
  

  
