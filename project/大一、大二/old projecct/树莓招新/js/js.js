/*
  js
 */

//解决IE8不支持getElementsByClassName
   if (!document.getElementsByClassName) {
    document.getElementsByClassName = function (className, element) {
        var children = (element || document).getElementsByTagName('*');
        var elements = new Array();
        for (var i = 0; i < children.length; i++) {
            var child = children[i];
            var classNames = child.className.split(' ');
            for (var j = 0; j < classNames.length; j++) {
                if (classNames[j] == className) {
                    elements.push(child);
                    break;
                }
            }
        }
        return elements;
    };
}



  window.onload = function() {
    // 实验室状态切换事件
      stateSwitch.initial();
    

    
    // 主图片轮播图
    addCarousel.initial();
    addCarousel.moveLeft();
    // 当鼠标移入的时候，将所有的定时器都清空
    addCarousel._pic_move.onmouseover = function() {
      clearTimeout(addCarousel._timerLeft);
    };

    // 当鼠标移出的时候,持续以前状态
    addCarousel._pic_move.onmouseout = function() {
          addCarousel.moveLeft();
    };



    // 合作商轮播图
    carouselFigure.initial();
    carouselFigure._buttonRight.onclick = function() {
      carouselFigure.SPEED = -80;
      // 点击的时候探测现在在第几个点
      carouselFigure.changeDot();
      carouselFigure._state2 = 1;
      carouselFigure.changeState();
            carouselFigure.moveLeft();
    };

    carouselFigure._buttonLeft.onclick = function() {
      carouselFigure.SPEED = 80;
      // 点击的时候探测现在在第几个点
    //  carouselFigure.changeDot();
    carouselFigure.changeDot();
      carouselFigure._state2 = -1;
      carouselFigure.changeState();
            carouselFigure.moveRight();
    };

    carouselFigure._changeagain1.onclick = function() {
      carouselFigure.temp3 = 0;
      carouselFigure.changeDotAgain();
    };

    carouselFigure._changeagain2.onclick = function() {
      carouselFigure.temp3 = 1;
      carouselFigure.changeDotAgain();
    };

    carouselFigure._changeagain3.onclick = function() {
      carouselFigure.temp3 = 2;
      carouselFigure.changeDotAgain();
    };



    // 设计团队
    designTeam._buttonLeft.onclick = function() {
      designTeam.SPEED = -30;
      designTeam.changeState();
      designTeam.moveLeft();

    };

    designTeam._buttonRight.onclick = function() {
      designTeam.SPEED = 30;
      // designTeam.changeState();
      designTeam.moveRight();

    };



    // input获得和失去焦点事件
    aboutInput.initial();



  };



  // 实验室介绍状态切换
  var stateSwitch = {
    // 情况变量
    _state : 0,
    _li : document.getElementsByClassName("lab-bag")[0].getElementsByTagName("li"),
    _p : document.getElementsByClassName("labthing"),
    _desita : document.getElementsByClassName("desita"),
    _li2 : document.getElementsByClassName("area-list")[0].getElementsByTagName("li"),

    initial : function() {
      
    for(var i=0; i<stateSwitch._li.length; i++) {
        // 获取li的index
        stateSwitch._li[i].index=i;
        // 鼠标移入
        stateSwitch._li[i].onmouseover = function() {
          stateSwitch._state = 1;
            stateSwitch.stateChange(this.index);
        }
        // 鼠标移出
        stateSwitch._li[i].onmouseout = function() {
          stateSwitch._state = 0;
            stateSwitch.stateChange(this.index);
        }
    }

    for(var i=0; i<stateSwitch._li2.length; i++) {
        if(i != 4){
        // 给他添加一个index属性，并且把i的值赋值给它
        stateSwitch._li2[i].index=i;
        // 鼠标移入
        stateSwitch._li2[i].onmouseover = function() {
          stateSwitch._state = 2;
          // 这里访问的时候用的this.index即为i的值，this指的是stateSwitch._li2[i]
            stateSwitch.stateChange(this.index);
        }
        // 鼠标移出
        stateSwitch._li2[i].onmouseout = function() {
          stateSwitch._state = 3;
            stateSwitch.stateChange(this.index);
        }
      }
    }
  },

    // 状态切换
    stateChange : function(i) {

      switch(this._state){
        case 1: this._p[i].style.marginTop = "0.1px";
                this._p[i].style.paddingLeft = "20px";
                this._p[i].style.lineHeight = "173px";
                this._p[i].style.textIndent = "-20px";break;
        case 0: this._p[i].style.marginTop = "122px";
                this._p[i].style.paddingLeft = "10px";
                this._p[i].style.lineHeight = "47px";
                this._p[i].style.textIndent = "0px";break;
        case 2: this._desita[i].style.marginTop = "0.1px";
                this._desita[i].style.lineHeight = "199px";break;
        case 3: this._desita[i].style.marginTop = "161px";
                this._desita[i].style.lineHeight = "38px";break;

      }
    }
  };



  // 合作商轮播图
  var carouselFigure = {
  // 声明两个定时器变量
  _timerLeft : 0,
  // 主要的判断变量有0 1 2 3个值
  _state : 0,
  // 用于区分是点击了左按钮还是右按钮
  _state2 : 1,
  SPEED : 30,
  temp3 : 0,
  // 读取ul，为了之后使ul翻倍
  _picMove : document.getElementsByClassName("pic-move")[0],
  _picMove2 : document.getElementsByClassName("pic-move")[1],
  _buttonRight : document.getElementsByClassName("buttonright")[0],
  _buttonLeft : document.getElementsByClassName("buttonleft")[0],
  _picLi : document.getElementsByClassName("pic-move")[0].getElementsByTagName("li"),
  _picLi2 : document.getElementsByClassName("pic-move")[1].getElementsByTagName("li"),
  // 读取下面的三个点
  _changeDotLi : document.getElementsByClassName("change-dot")[0].getElementsByTagName("li"),
  _changeagain1 : document.getElementsByClassName("changeagain1")[0],
  _changeagain2 : document.getElementsByClassName("changeagain2")[0],
  _changeagain3 : document.getElementsByClassName("changeagain3")[0],
  


  // 初始化函数
  initial : function() {
    // 动态初始化ul的宽度
    this._picMove.style.width = this._picLi[0].offsetWidth * this._picLi.length +"px";
    this._picMove2.style.width = this._picLi2[0].offsetWidth * this._picLi2.length +"px";
  },



  moveLeft : function() {
    // 对于state=3的时候，需要将它--
    if(this._state == 3 ) {
      this._state--;
    }
      if(this._picMove.offsetLeft < parseInt("-" + 1140*this._state)) {
        clearTimeout(this._timerLeft);
        this._picMove.style.left = parseInt("-" + 1140*this._state) + "px";
        this._picMove2.style.left = parseInt("-" + 1140*this._state) + "px";
        carouselFigure.changeDot();
      } else {
        this._picMove.style.left = this._picMove.offsetLeft + this.SPEED + "px";
        this._picMove2.style.left = this._picMove2.offsetLeft + this.SPEED + "px";
        this._timerLeft = setTimeout("carouselFigure.moveLeft()",30);
      }
  },



  moveRight : function() { 
    if(this._state == -1) {
      this._state = 0;
    }
      if(this._picMove.offsetLeft > parseInt("-" + 1140*this._state)) {
        clearTimeout(this._timerRight);
        this._picMove.style.left = parseInt("-" + 1140*this._state) + "px";
        this._picMove2.style.left = parseInt("-" + 1140*this._state) + "px";
        carouselFigure.changeDot();
      } else { 
        this._picMove.style.left = this._picMove.offsetLeft + this.SPEED + "px";
        this._picMove2.style.left = this._picMove.offsetLeft + this.SPEED + "px";

        this._timerRight = setTimeout("carouselFigure.moveRight()",30);
      }
      
  }, 



  // 改变3种状态,
  changeDot : function() {
    
    // ul的3种位置，代表点的3种情况
    switch(this._picMove.offsetLeft) {
      case 0 : this._state = 0;break;
      case -1140 : this._state = 1;break;
      case -2280 : this._state = 2;break;
    }
    
    // 先将所有样式清空,将当前情况的点设置背景,
    for(var i=0; i<this._changeDotLi.length; i++) {
      // 如果当前i等于this._state则将当前背景设置为#12b681，不然，将当前i设置默认
        if(i == this._state) {
          this._changeDotLi[this._state].style.background = "#12b681";
        } else {
          this._changeDotLi[i].style.background = "#bfbfbf";
        }    
    }
  },



  // 改变点的样式
  changeState : function() {
    if(this._state == 0 || this._state == 1 || this._state == 2) {
      this._state += carouselFigure._state2;
    }
  },



  // 小点点击的状态改变
  changeDotAgain : function() {
    switch(this._picMove.offsetLeft) {
      case 0 : this._state = 0;break;
      case -1140 : this._state = 1;break;
      case -2280 : this._state = 2;break;
    }
    var temp4 = this.temp3 - this._state;
    switch(temp4) {
      case -2 : this.leftLittle();
                this.leftLittle();break;
      case -1 : this.leftLittle();break;
      case 0 : break;
      case 1 : this.rightLittle();break;
      case 2 : this.rightLittle();
               this.rightLittle();break;
    }
  },



    // 小点点击右移动
    rightLittle : function() {
      carouselFigure.SPEED = -80;
      // 点击的时候探测现在在第几个点
      carouselFigure.changeDot();
      carouselFigure._state2 = 1;
      carouselFigure.changeState();
            carouselFigure.moveLeft();
    },


// 小点点击左移动
    leftLittle : function() {
      carouselFigure.SPEED = 80;
      // 点击的时候探测现在在第几个点
    //  carouselFigure.changeDot();
    carouselFigure.changeDot();
      carouselFigure._state2 = -1;
      carouselFigure.changeState();
            carouselFigure.moveRight();
    }

};



  // 设计团队
  var designTeam = {
  // 声明两个定时器变量
  _timerLeft : 0,
  _timerRight : 0,
  SPEED : 80,
  _state : 2,

  _buttonRight : document.getElementsByClassName("-buttonright")[0],
  _buttonLeft : document.getElementsByClassName("-buttonleft")[0],
  _peopleIntr : document.getElementsByClassName("people-intr")[0],
  _intrLi : document.getElementsByClassName("people-intr")[0].getElementsByTagName("li"),
  _intrImg : document.getElementsByClassName("people-intr")[0].getElementsByTagName("img"),
  _intrP : document.getElementsByClassName("people-intr")[0].getElementsByTagName("p"),



  moveLeft : function() {
    if(this._state < 4) {
      // 用parseInt取this._state的值再-1，避免将this._state的值改变
      // 由于向左移动元素的下标是0 1 2 3 4，所以分别代表的停顿点只需要 this._state - 1
      if(this._peopleIntr.offsetLeft < parseInt(-57 - 260*(parseInt(this._state)-1))) {
        clearTimeout(this._timerLeft);
        this._peopleIntr.style.left = parseInt(-57 - 260*(parseInt(this._state)-1)) + "px";
        designTeam.changeState();
      } else {
        this._peopleIntr.style.left = this._peopleIntr.offsetLeft + this.SPEED + "px";

        this._timerLeft = setTimeout("designTeam.moveLeft()",30);
      }
      }
    },



    moveRight : function() {
    if(this._state > 0) {
      // 用parseInt取this._state的值再-1，避免将this._state的值改变
      // 由于方向要改变，所以每次的停顿点为this._state - 3
      if(this._peopleIntr.offsetLeft > parseInt(-57 - 260*(parseInt(this._state)-3))) {
        clearTimeout(this._timerRight);
        this._peopleIntr.style.left = parseInt(-57 - 260*(parseInt(this._state)-3)) + "px";
        designTeam.changeState();
      } else {
        this._peopleIntr.style.left = this._peopleIntr.offsetLeft + this.SPEED + "px";

        this._timerRight = setTimeout("designTeam.moveRight()",30);
      }
      }
    },



  // 状态切换,返回的this._state值为当前大图的li下标
  changeState : function() {
    // 以中间的大图状态为主要的状态，必须要有中间大图才能移动
    switch(this._peopleIntr.offsetLeft) {
      case -57 : this._state = 2;break;
      case -317 : this._state = 3;break;
      case -577 : this._state = 4;break;
      case 203 : this._state = 1;break;
      case 463 : this._state = 0;break;
    }
    
    // 先将所有样式清空,将当前情况的img li 和p改变
    for(var i=0; i<this._intrLi.length; i++) {
        if(i == this._state) {
          this._intrLi[this._state].style.width = 220 + "px";
          this._intrLi[this._state].style.height = 185 + "px";
          this._intrLi[this._state].style.paddingTop = 0;          
          this._intrImg[this._state].style.width = 220 + "px";
          this._intrImg[this._state].style.height = 185 + "px";
          this._intrP[this._state].style.display = "inline";
          this._intrLi[this._state].style.opacity = 1;
          // 兼容ie8
          this._intrLi[this._state].style.filter = "alpha(opacity=100)";    
        } else {
          this._intrLi[i].style.width = 179 + "px";
          this._intrLi[i].style.height = 151 + "px";
          this._intrLi[i].style.paddingTop = 17 + "px";
          this._intrImg[i].style.width = 179 + "px";
          this._intrImg[i].style.height = 151 + "px";
          this._intrP[i].style.display = "none";
          this._intrLi[i].style.opacity = 0.4;
          // 兼容ie8
          this._intrLi[i].style.filter = "alpha(opacity=40)";
        }    
    }
  }


  };


 
 // 主图片轮播图
 var addCarousel = {
  // 声明定时器变量
  _timerLeft : 0,
  SPEED : -10,
  // 读取ul，为了之后使ul翻倍
  _pic_move : document.getElementsByClassName("-pic-move")[0],
  // 读取li，为了之后用li.length，动态初始化ul的宽度
   pic_li : document.getElementsByClassName("-pic-move")[0].getElementsByTagName("li"),

  initial : function() {
    // 使ul翻倍,为了右移
    this._pic_move.innerHTML += this._pic_move.innerHTML;
    // 动态初始化ul的宽度
    this._pic_move.style.width = this.pic_li[0].offsetWidth * this.pic_li.length +"px";
  },

  // 移动函数
  moveLeft : function() {
    // 初始位置为0，当运动到超过总长度一半的时候，将位置移到初始位置
    if(-this._pic_move.offsetLeft >= this._pic_move.offsetWidth/2 ) {
        this._pic_move.style.left = 0;
    }
    else {
    this._pic_move.style.left = this._pic_move.offsetLeft + this.SPEED + "px";
  }
    // 由于需要一直移动，所以要把这个定时器放在外面
    this._timerLeft = setTimeout("addCarousel.moveLeft()",30);
  }

};



  // input获得和失去焦点事件
  var aboutInput = {
    _input : document.getElementsByClassName("your-info")[0].getElementsByTagName("input"),
    _textarea : document.getElementsByClassName("bigtext")[0],
    // 定义一个数组，用来存放所有的信息
    _allInfo : [],

    // 初始化函数，储存初始的信息
    initial : function() {
      // 将所有的信息存在数组中
      for(var i=0; i<this._input.length-1; i++) {
          this._allInfo[i] = this._input[i].value;
      }

      // 获得焦点时清空
      for(var i=0; i<aboutInput._input.length-1; i++) {
        aboutInput._input[i].index=i;
        aboutInput._input[i].onfocus = function() {
           aboutInput._input[this.index].value = "";
        }
      }

      //失去焦点时，若文本没有改变则还原
      for(var i=0; i<this._input.length-1; i++) {
        this._input[i].index=i;
        this._input[i].onblur = function() {
          if(aboutInput._input[this.index].value == "") {
          aboutInput._input[this.index].value = aboutInput._allInfo[this.index];
        }
        }
      }

      aboutInput._textarea.onfocus = function() {
           aboutInput._textarea.innerHTML = "";
        }

      aboutInput._textarea.onblur = function() {
          if(aboutInput._textarea.innerHTML == "") {
          aboutInput._textarea.innerHTML = "详情需求描述：";
        }
        }
    }

  };
