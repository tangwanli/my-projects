/*
  js
 */
  window.onload = function() {
    validateUser();
   
   document.querySelector('.login a').onclick = function() {
    loginJump();
   };

   document.querySelector('.shopping').onclick = function() {
    window.location.href = 'order.html';
   }


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

    // 显示菜品
    let allLi = document.querySelectorAll('.nav-block li');
    for (let i=1;i<allLi.length;i++) {
      let index = i;
      allLi[index].onclick = function() {
        let type = allLi[index].innerText;
        disFood.showAll(type);
        console.log(allLi[index].innerText);
      }
    }

    	reqAllFood.init();
    console.log('这个是怎么回事');



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
/*  _intrP : document.getElementsByClassName("people-intr")[0].getElementsByTagName("p"),*/



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
        /*  this._intrP[this._state].style.display = "inline";*/
          this._intrLi[this._state].style.opacity = 1;
          // 兼容ie8
          this._intrLi[this._state].style.filter = "alpha(opacity=100)";    
        } else {
          this._intrLi[i].style.width = 179 + "px";
          this._intrLi[i].style.height = 151 + "px";
          this._intrLi[i].style.paddingTop = 17 + "px";
          this._intrImg[i].style.width = 179 + "px";
          this._intrImg[i].style.height = 151 + "px";
    /*      this._intrP[i].style.display = "none";*/
          this._intrLi[i].style.opacity = 0.4;
          // 兼容ie8
          this._intrLi[i].style.filter = "alpha(opacity=40)";
        }    
    }
  }
  };

  // 显示菜品

  let disFood = {
    foodList: {},
    elRoot: document.getElementsByClassName('food-list'),
    init(foodList) {
      this.foodList = foodList;
      console.log(this.foodList);
      this.showAll();
    },
    // 这里这个为普通菜的showAll，需要点击nav的时候调用这个showAll方法，传入type
    showAll(type = '川菜') {
      $(this.elRoot[1]).find('li').remove();
    	console.log(type,this.foodList[type]);
      let foodData = this.foodList[type],
          count = foodData.length, // li个数
          i = 0;
      for (; i<count; i++) {
          this.showFood(foodData[i],1);
      }
    },
    showFood({foodId,foodtypeId,foodName,foodPrice,foodImage,foodOrdertimes},pos) {
      let food = `<li class='food-det'>
         <img class='aimg' src=${foodImage} width="180px" height="150px">
         <div class="food-name">${foodName}</div>
         <div class="praise"><span>赞 </span><span class='praise-num'>${foodOrdertimes}</span></div>
         <div class="food-pri"><span>$ </span><span class='money-pri'>${foodPrice}</span></div>
          <div data-id='${foodId}' class="add-btn">+</div>
          <span class="food-num">0</span>
        </li>`;
        $(this.elRoot[pos]).append(food);
    }
  };
 /* disFood.showFood({foodName:'dsa',foodId:1,foodImage:'images/food.png'},0);*/

  // 请求菜品
  let reqAllFood = {
    init() {
      let url = 'getAllfoodWithType';
          this.reqAllFood(url);
      let url2 = 'gethotfood';
      this.reqHotFood(url2);
    },
    reqAllFood(url){
    	console.log('这里是请求的回掉之前');
      $.ajax({
        url: url,
        type: 'post',
        async: true,
        dataType: 'json',
        success(myData,state,xhr) {
          let jsonData = myData,
              foodList = jsonData.data.FoodsWithType;
              disFood.init(foodList);
              console.log('这里是请求的回掉');
              // 点餐,必须在数据全部获取完后才能点，所以这里必须放在数据返回之后的回掉函数里面
              localStorage.setItem('addNum','');
              localStorage.setItem('aimg','');
              localStorage.setItem('foodName','');
              localStorage.setItem('foodId','');
              localStorage.setItem('praiseNum','');
              localStorage.setItem('moneyPri','');
              let addBtn = document.getElementsByClassName('add-btn');
              for (let i=0;i<addBtn.length;i++) {
                let index = i;
                console.log('这里是加号这里',addBtn.length);
                addBtn[index].onclick = function() {
                  orderFood.storageInfo(index);
                }
              }
        }
      });
    },
    reqHotFood(url){
      $.ajax({
        url: url,
        type: 'post',
        async: true,
        dataType: 'json',
        success(myData,state,xhr) {
          let jsonData = myData,
              foodList = jsonData.data.HotFoods,
              i = 0;
              for (;i<foodList.length;i++) {
                disFood.showFood(foodList[i],0);
              }
        }
      });
    }
  };

  // 点菜
  let orderFood = {
    count : 0,
    strShopcartNum: document.getElementsByClassName('shopcart-num')[0],
    storageInfo(index) {
      let elaimg = document.getElementsByClassName('aimg')[index],
          elfoodName = document.getElementsByClassName('food-name')[index],
          elpraiseNum = document.getElementsByClassName('praise-num')[index],
          elmoneyPri = document.getElementsByClassName('money-pri')[index],
          elfoodId = document.getElementsByClassName('add-btn')[index],
          elli = document.getElementsByClassName('food-det')[index],
          addNum = localStorage.getItem('addNum'),
          aimg = localStorage.getItem('aimg'),
          foodId = localStorage.getItem('foodId'),
          foodName = localStorage.getItem('foodName'),
          praiseNum = localStorage.getItem('praiseNum'),
          moneyPri = localStorage.getItem('moneyPri');

        if (addNum === '') {
          addNum = index + '';
        } else {
          addNum = addNum + ',' + index;
        }
        localStorage.setItem('addNum',addNum);

        if (aimg === '') {
          aimg = elaimg.getAttribute('src') + '';
        } else {
          aimg = aimg + ',' + elaimg.getAttribute('src');
        }
        localStorage.setItem('aimg',aimg);
        
        if (foodId === '') {
        	foodId = elfoodId.dataset.id + '';
          } else {
        	  foodId = foodId + ',' + elfoodId.dataset.id;
          }
          localStorage.setItem('foodId',foodId);

        if (foodName === '') {
          foodName = elfoodName.innerText + '';
        } else {
          foodName = foodName + ',' + elfoodName.innerText;
        }
        localStorage.setItem('foodName',foodName);

        if (praiseNum === '') {
          praiseNum = elpraiseNum.innerText + '';
        } else {
          praiseNum = praiseNum + ',' + elpraiseNum.innerText;
        }
        localStorage.setItem('praiseNum',praiseNum);

        if (moneyPri === '') {
          moneyPri = elmoneyPri.innerText + '';
        } else {
          moneyPri = moneyPri + ',' + elmoneyPri.innerText;
        }
        localStorage.setItem('moneyPri',moneyPri);


        this.changeShopcartNum();
        this.changeFoodNum(index);
        console.log(localStorage.getItem('addNum'));
    },
    changeShopcartNum() {
      let num = parseInt(this.strShopcartNum.innerText);
      this.strShopcartNum.innerText = ++num;
    },
    changeFoodNum(index) {
console.log(document.querySelectorAll('.food-num'));
      let num = parseInt(document.querySelectorAll('.food-num')[index].innerText);
      document.querySelectorAll('.food-num')[index].innerText = ++num;

    }
  };


  // 验证用户

  function validateUser() {
    let userName = localStorage.getItem('userName');
    if (userName) {
      $('.login a').text(userName);
    }
  }

  // login按钮，值为登录的时候就跳转到登录页面
  function loginJump() {
	  
    let state = document.querySelector('.login a').innerText;
    if (state === '登录') {
      window.location.href = 'login1.html';
    }
  }