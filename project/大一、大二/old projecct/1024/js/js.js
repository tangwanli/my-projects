
  // 创建一个构造函数
    var newMethod = {
      // 创建一个二维数组，用来储存所有的数据
      all_num : [],
      // 初始化速度
      iSpeed : 1.1,
      // 存记分板
      out_score : document.getElementsByClassName("out-score")[0],
      // 存按钮
      buttom_sta : document.getElementsByClassName("buttom-sta")[0],
      buttom_up : document.getElementsByClassName("buttom-up")[0],
      buttom_down : document.getElementsByClassName("buttom-down")[0],
      buttom_left : document.getElementsByClassName("buttom-left")[0],
      buttom_right : document.getElementsByClassName("buttom-right")[0],
      a_ul : document.getElementsByClassName("a-ul")[0],
      // 存侧边栏元素
      side_menu : document.getElementsByClassName("side-menu")[0],
      shoot_menu : document.getElementsByClassName("shoot-menu")[0],
    
  // 开始
  buttomSta : function() {
    // 先将所有的都清空,必须初始化数组,把每个位置全部设置为""
    this.all_num = [
      ["","","",""],
      ["","","",""],
      ["","","",""],
      ["","","",""]
      ];
    for(var li_row=0; li_row<4; li_row++) {
      for(var li_col=0; li_col<4; li_col++) {
        // 遍历所有的li元素
        var li_list = document.getElementsByClassName("a"+li_row+li_col)[0];
        li_list.innerHTML = "";
      }
    }
    this.createNew();
    this.createNew();
    this.createNew();
  },

  displayNum :function() {
    // 用两个for遍历行列两个方向的所有
    for(var li_row=0; li_row<4; li_row++) {
      for(var li_col=0; li_col<4; li_col++) {
        // 遍历所有的li元素
        var li_list = document.getElementsByClassName("a"+li_row+li_col)[0];
        li_list.innerHTML = this.all_num[li_row][li_col];
      }
    }
  },

  // 游戏分数
  gameGrade : function() {
    var temp = 0;
    for(var li_row=0; li_row<4; li_row++) {
      for(var li_col=0; li_col<4; li_col++) {
      if(this.all_num[li_row][li_col] != "") {
        temp += this.all_num[li_row][li_col];
      }
    }
  }
    // 赋值
    this.out_score.placeholder = temp;
    this.displayNum();
  },

  // 用于判断是不是所有位置都有元素，还有位置返回true，没有位置返回false 和if语句连用
  judgeAll : function() {
    for(var li_row=0; li_row<4; li_row++) {
      for(var li_col=0; li_col<4; li_col++) {
        if(this.all_num[li_row][li_col] == "") {
          return true; 
        }
      }
    }
    return false;
  },

  // 翻面
  createNew : function() {
    // 用于判断状态
    var judge = 0;
    // 判断是否还有位置
    if(this.judgeAll()) {
      do {
          // 产生随机值
          var li_row = parseInt(Math.random()*4);
          var li_col = parseInt(Math.random()*4);
          // 判断产生的随机值是否为空
          }while(this.all_num[li_row][li_col] !== "");
          this.all_num[li_row][li_col] = 2;
          
    } 
    else { 
      // 由于要判断是否有元素相等，所以这里用li_row<3  li_col<3
      for(var li_row=0; li_row<3; li_row++) {
        for(var li_col=0; li_col<3; li_col++) {
          if(this.all_num[li_row][li_col] == this.all_num[li_row+1][li_col] ||
            this.all_num[li_row][li_col] == this.all_num[li_row][li_col+1]) {
            var judge = 1;
          }
        }
      }
      // 失败条件
      if(judge != 1) {
         alert("GAMEOVER");
      }
    }
    this.gameGrade();
  },
  
  // 左上移
  moveLeftUp : function(state) {
    // 用于判断状态
    var judge_st = 0;

    for(var li_row=0; li_row<4; li_row++) {
        for(var li_col=0; li_col<4; li_col++) {
           // 确定状态
           if(state == 0 || state == 1) {
              judge_st = li_col;
            }  
            if(state == 2 || state == 3) {
                judge_st = li_row;
              }
          // 判断确定行或列之后元素是否有空元素
          for(var temp3= judge_st+1; temp3<4; temp3++) {
              // 确定状态
              var temp_row;
              var temp_col;
              if(state == 0 || state == 1) {
                temp_row = li_row;
                temp_col = temp3;
              } 
              if(state == 2 || state == 3) {
                  temp_row = temp3;
                  temp_col = li_col;
                }
            // 如果之后的元素有非空的
            if(this.all_num[temp_row][temp_col] != "") {
              // 如果当前位置是空
              if(this.all_num[li_row][li_col] == "") {
                this.all_num[li_row][li_col] = this.all_num[temp_row][temp_col];
                this.all_num[temp_row][temp_col] = "";
              } else {
                // 如果当前元素不为空，且后面元素和当前元素相等,则相加
                if(this.all_num[li_row][li_col] == this.all_num[temp_row][temp_col]) {
                  this.all_num[li_row][li_col] *= 2;
                  this.all_num[temp_row][temp_col] = "";
                }
              }
            }
          }
        }
      }
      if (state == 0 || state == 2) {
        this.createNew();
      } 
      else {
        this.changeArray(state);
        this.createNew();
      }
      
    
  },

  // 右下移
  moveRightDown : function(state) {
    
    this.changeArray(state);
    this.moveLeftUp(state);
  },

  // 交换函数,分为横方向交换和纵方向交换
  changeArray : function(state) {
    if (state == 1) {
    for(var li_row=0; li_row<4; li_row++) {
        var temp00 = this.all_num[li_row][0];
        var temp01 = this.all_num[li_row][1];
          this.all_num[li_row][0] = this.all_num[li_row][3];
          this.all_num[li_row][1] = this.all_num[li_row][2];
          this.all_num[li_row][2] = temp01;
          this.all_num[li_row][3] = temp00;
        
      }
    } else {
      for(var li_col=0; li_col<4; li_col++) {
        var temp00 = this.all_num[0][li_col];
        var temp10 = this.all_num[1][li_col];
          this.all_num[0][li_col] = this.all_num[3][li_col];
          this.all_num[1][li_col] = this.all_num[2][li_col];
          this.all_num[2][li_col] = temp10;
          this.all_num[3][li_col] = temp00;
        
      }
    }
  },

  // 侧边栏，弹出菜单事件
  shootMenu : function() {
    if(this.iSpeed<1 && this.iSpeed>-1){
      clearTimeout(timer);
      this.side_menu.style.left = 0;
    } else {
    // 弹性运动
    // 括号里面前面那个数值，即为运动之后距离左边的px
    this.iSpeed += (0 - this.side_menu.offsetLeft)/5;
    this.iSpeed *= 0.7;

    this.side_menu.style.left = this.side_menu.offsetLeft + this.iSpeed + "px";
    var timer = setTimeout("newMethod.shootMenu()",30);
  }
  },

  // 收回菜单
  backMenu : function() {
    if(this.side_menu.offsetLeft == -200){
      clearTimeout(timer);
    } else {
    this.iSpeed = -20;
    this.side_menu.style.left = this.side_menu.offsetLeft + this.iSpeed + "px";
    var timer = setTimeout("newMethod.backMenu()",30);
  }
}

}


   // 函数包
  window.onload = function() {

    var left = 0;
    var right = 1;
    var up = 2;
    var down = 3;

    newMethod.buttom_sta.onclick = function() {
        newMethod.buttomSta();
  };

    // 拖动方式操作游戏
    newMethod.a_ul.onmousedown = function(ev) {
      // 储存鼠标点下的时候的坐标
      var mou_sx = ev.clientX;
      var mou_sy = ev.clientY;
        newMethod.a_ul.onmouseup = function(ev) {
          // 储存拖拽结束之后的坐标
          var mou_ex = ev.clientX;
          var mou_ey = ev.clientY;
          if(parseInt(mou_ex) > parseInt(mou_sx)) {
            if(parseInt(mou_ey) < parseInt(mou_sy)) {
              if((parseInt(mou_sy) - parseInt(mou_ey)) > (parseInt(mou_ex) - parseInt(mou_sx))) {
                newMethod.moveLeftUp(up);
              } else {
                newMethod.moveRightDown(right);
              }

            } else {
              if((parseInt(mou_ex) - parseInt(mou_sx)) > (parseInt(mou_ey) - parseInt(mou_sy))) {
                newMethod.moveRightDown(right);

              } else {
                newMethod.moveRightDown(down);
              }
            } } else {
              if(parseInt(mou_ey) < parseInt(mou_sy)) {
                if((parseInt(mou_sx) - parseInt(mou_ex)) > (parseInt(mou_sy) - parseInt(mou_ey))) {
                  newMethod.moveLeftUp(left);

                } else {
                  newMethod.moveLeftUp(up);
                }

              } else {
                if((parseInt(mou_sx) - parseInt(mou_ex)) > (parseInt(mou_ey) - parseInt(mou_sy))) {
                  newMethod.moveLeftUp(left);

                } else {
                  newMethod.moveRightDown(down);
                }
              }
            }

          
        }
      };

    // 点击方式操作游戏
    newMethod.buttom_up.onclick = function() {
        newMethod.moveLeftUp(up);
       
    };

    newMethod.buttom_down.onclick = function() {
        newMethod.moveRightDown(down);
        
    };

    newMethod.buttom_left.onclick = function() {
        newMethod.moveLeftUp(left);
       
    };

    newMethod.buttom_right.onclick = function() {
        newMethod.moveRightDown(right);
      };

    // 键盘方式操作游戏 keyCode = 37.38..39.40分别对应← ↑ → ↓
    document.onkeydown = function() {
      // 获取键盘事件对象
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e.keyCode == 37){
                newMethod.moveLeftUp(left);
      }
      if(e.keyCode == 38){
                newMethod.moveLeftUp(up);
      }
      if(e.keyCode == 39){
                newMethod.moveRightDown(right);
      }
      if(e.keyCode == 40){
                newMethod.moveRightDown(down);
      }
    };
        
    //  弹出侧边栏事件
    newMethod.shoot_menu.onclick = function() {
      var temp = newMethod.side_menu.offsetLeft;
      if(temp != 0) {
            newMethod.shootMenu();
      } else {
        newMethod.backMenu();
      }

    };
}
     













  


  
  