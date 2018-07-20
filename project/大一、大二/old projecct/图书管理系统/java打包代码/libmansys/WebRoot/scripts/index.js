  /* index.js */

  $(function() {

    // 登录验证,还会返回用户名，用于借书
    validate();



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
    
    
    
    // 多图片上传操作
    $("#change").change(function() {
      displayPic();
    });

    // 确定上传
    $(".determine").click(function() {
      upload();
    });

    
    
    // 增加
    $(".asub").click(function() {
      addBook();
    })
    
    // 删除
    $(".dsub").click(function() {
      deleteBook();
    })
    
    // 查找
    $(".qsub").click(function() {
      queryBook();
    })
    // 查找全部
    $(".allsub").click(function() {
      queryAllBook();
    })
    
    // 修改
    $(".msub").click(function() {
      alterBook();
    })

    // 借阅
    $(".bsub").click(function() {
      borrowBook();
    })

    // 归还
    $(".rsub").click(function() {
      returnBook();
    })

    // 显示借的书
    $(".dissub").click(function() {
      disBorBook();
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

    console.log("点的是第"+index+"个");
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
    var tagText = littleTag.text();
    $(".add-tag").text(tagText);
  }



  function displayPic() {
    // 这里只能用js原生方法来获取所有的input,不能用jq来获取，具体为什么还不清楚
    // 这里获取的为FileList对象,结构上类似于数组
    // 这个FileList对象中可以包含很多的元素，就是为选中的图片
    // 每一个file元素有5个属性，name：文件名；size：文件大小；type：文件类型。其中两个为文件的的修改时间，
    var fileList = document.getElementById("change").files;
     console.log(fileList[0]); 

    for(var i=0; i<fileList.length; i++) {
      var fileName = fileList[i].name;
      console.log("图片的名字"+fileName);
      var picLocation = $(".pic-location");
      var pic = "<img src='images/" + fileName + "'>";
      picLocation.append(pic);
    }
    $(".determine").css("display","block");

  }


  function upload() {
    var fileList = document.getElementById("change").files;
    var formData = new FormData();

    for(var i=0; i<fileList.length; i++) {
      // new一个FileReader对象，用于读取文件
      var reader = new FileReader();
      // 将文件读取为一段以data：开头的字符串，这段字符串的实质就是Data URL
      reader.readAsDataURL(fileList[i]);
      // FormData的append()方法用于向 FormData 对象中添加键值对：
      formData.append(i,fileList[i]);

      $.ajax({
        type: "post",
        url: "upload.jsp",
        data: formData,
        contentType: false,
        processData: false,
        dataType: "json"
      });
      
      // 清空所有的img
      $(".pic-location").empty();
      $(".determine").css("display","none");
    }
  }



  function addBook() {
    var allInput = $(".main-form:eq(0) input");
    $.post("OperateServlet", {
      bookname: allInput.get(0).value,
      autor: allInput.get(1).value,
      price: allInput.get(2).value,
      method: "1"
    }, function() {
      alert("添加成功");
    });

    clearContent(allInput.filter("[type!=button]"));
  }
  
  function deleteBook() {
    var allInput = $(".main-form:eq(1) input");
    $.post("OperateServlet", {
      id: allInput.get(0).value,
      bookname: allInput.get(1).value,
      autor: allInput.get(2).value,
      price: allInput.get(3).value,
      method: "2"
    }, function() {
      alert("删除成功");
    });

    clearContent(allInput.filter("[type!=button]"));
  }
  

  function queryBook() {
    var allInput = $(".main-form:eq(2) input");
    $.post("OperateServlet", {
      id: allInput.get(0).value,
      bookname: allInput.get(1).value,
      autor: allInput.get(2).value,
      price: allInput.get(3).value,
      method: "3"
    }, function(data) {
      addContent(data.msg);
    },"json");

    clearContent(allInput.filter("[type!=button]"));
  }

  function queryAllBook() {
    $.post("OperateServlet", {
      method: 5
    }, function(data) {
      addContent(data.msg);
    },"json");
  }

  // 将查询出来的东西添加到页面上
  function addContent(msg) {
     $(".return").empty();
      var countSplit = msg.split("@");
      var count = parseInt(countSplit[0]);
      var bookData = countSplit[1].split(";");

      for(var i=0; i<count; i++) {
        var book = bookData[i].split(",");
        $(".return").append("<p></p>");
        var id = "<span>" + book[0] + "</span>";
        var bookname = "<span>" + book[1] + "</span>";
        var autor = "<span>" + book[2] + "</span>";
        var price = "<span>" + book[3] + "</span>";
        var borrow = "<span>" + book[4] + "</span>";
        $(".return p").slice(-1).append(id+bookname+autor+price+borrow);
      }
  }
  

  function alterBook() {
    var allInput = $(".main-form:eq(3) input");
    $.post("OperateServlet", {
      befid: allInput.get(0).value,
      befbookname: allInput.get(1).value,
      befautor: allInput.get(2).value,
      befprice: allInput.get(3).value,
      id: allInput.get(4).value,
      bookname: allInput.get(5).value,
      autor: allInput.get(6).value,
      price: allInput.get(7).value,
      method: "4"
    }, function() {
      alert("修改成功");
    });

    clearContent(allInput.filter("[type!=button]"));
  }


  function borrowBook() {
    var allInput = $(".main-form:eq(4) input");
    var username = $(".username").text();
    
    $.post("OperateServlet", {
      id: allInput.get(0).value,
      username: username,
      method: "6"
    }, function(data) {
      if(data.state === "true") {
        alert("成功借阅");
      } else {
        alert("抱歉已经有人借走了这本书");
      }
    },"json");

    clearContent(allInput.filter("[type!=button]"));
  }


  function returnBook() {
    var allInput = $(".main-form:eq(5) input");    
    $.post("OperateServlet", {
      id: allInput.get(0).value,
      method: "7"
    }, function() {
        alert("成功归还");
    });

    clearContent(allInput.filter("[type!=button]"));
  }

  // 显示借的书
  function disBorBook() {
    var username = $(".username").text();
    console.log("借书这个函数是可以进来的吧");
    $.post("OperateServlet", {
      username: username,
      method: "8"
    }, function(data) {
    	console.log("那里出问题了");
    	addElseContent(data.msg);
    },"json");
  }
  
  function addElseContent(msg) {
	  console.log("msg是什么"+msg);
	     $(".elsereturn").empty();
	      var countSplit = msg.split("@");
	      var count = parseInt(countSplit[0]);
	      var bookData = countSplit[1].split(";");

	      for(var i=0; i<count; i++) {
	        var book = bookData[i].split(",");
	        $(".elsereturn").append("<p></p>");
	        var id = "<span>" + book[0] + "</span>";
	        var bookname = "<span>" + book[1] + "</span>";
	        var autor = "<span>" + book[2] + "</span>";
	        var price = "<span>" + book[3] + "</span>";
	        var borrow = "<span>" + book[4] + "</span>";
	        $(".elsereturn p").slice(-1).append(id+bookname+autor+price+borrow);
	      }
	  }

  // 清除input中的内容
  function clearContent(allInput) {

    allInput.each(function(index,element) {
      $(element).val("");
    })
  }





    
  

  
