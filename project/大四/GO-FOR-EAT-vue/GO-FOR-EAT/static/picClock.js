      // clock工具使用方法。直接调用clock.init(el);el为要生成图片的父元素。图片直接变换
      // 这个工具的具体实现就是，有两排li，上下排都是一个时间字符串，且对应图片，下排的是现在时间；把上下排做对比，找到改变了的，再把li向上移动
      var clock = {
        el : null, // 输入的元素
        num : 8, // img个数
        firstImg : null, // 第一排的img集合
        lastImg : null, // 第二排的img集合
        firstStr : "00:00:00", // 默认的时间，第一排的所有img
        elHeight : "0px", // 定义div即li的高度
        arr : [], // 定义一个空数组，用来存放相同字母的index
        
        // 初始化，将图片动态加入dom
        init : function(el) {
            console.log('进入图片时钟');
          this.el = el;
          el.append("<ul></ul>");
          var emptyImg = '<img src="./static/img/picClock/0.JPG">',
              num = this.num,
              ul = el.find("ul");
              
          // 下面两个为动态生成li和img
          console.log(ul);
          for ( ; num-- ; ) {
            ul.append("<li></li>");
            //el.append(emptyImg);
          }
          var li = ul.find("li"); // 找到ul下面所有的li
          li.append(emptyImg).append(emptyImg); // 在所有li下面都生成两个img


          this.firstImg = li.find("img:first-child"); // img为jq对象.找到所有li下面的第一个img
          this.lastImg = li.find("img:last-child"); // img为jq对象.找到所有li下面的第一个img
          console.log(this.firstImg);
          // 动态生成父元素和li的宽高(设置li宽高是为了让一个li中的两个img竖直排列)
          this.firstImg[0].onload = function() { // img[0]为dom对象
            var imgStyle = window.getComputedStyle(el.find("img:first")[0]),
                elWidth = parseFloat(imgStyle.width) * clock.num + 10 + "px", // 由于图片不是全部宽度一致，这里加了10px，防止出问题
                elHeight = parseFloat(imgStyle.height) * 1 + "px";
                clock.elHeight = elHeight;
                el.find("li").css("width",imgStyle.width);
            el.css({"width":elWidth, "height":elHeight});
          };

          this.time();
          clearInterval(timer);
          var timer = setInterval( function() {
            clock.time();
            // 下面这个为点的闪烁。在外层定时器的里面设置的定时器
            clock.firstImg[2].src = "./static/img/picClock/colon.JPG";
            clock.firstImg[5].src = "./static/img/picClock/colon.JPG";
            setTimeout( function() {
                clock.firstImg[2].src = "./static/img/picClock/colon1.JPG";
                clock.firstImg[5].src = "./static/img/picClock/colon1.JPG";
            }, 500 );
          }, 1000);

        },

        time : function() {
         var nowTime = new Date(),
              nowHour = nowTime.getHours(),
              nowMin = nowTime.getMinutes(),
              nowSec = nowTime.getSeconds(),
              firstImg = this.firstImg,
              lastImg = this.lastImg,
              // 将时间连接成字符串,上面一串，下面一串
              lastStr = this.toTwo(nowHour) + ":" + this.toTwo(nowMin) + ":" + this.toTwo(nowSec), // 不断更新的时间
              num = this.num,
              num2 = this.num,
              num3 = this.num,
              firstLetter = "", // 第一排str的字母
              lastLetter = ""; // 第二排str的字母

              // 给第二排li不断变换图片
              for ( ; num-- ; ) {
                lastLetter = lastStr.charAt(num);
                if ( lastLetter !== ":" ) {
                  lastImg[num].src = './static/img/picClock/' + lastLetter + '.JPG';
                }
              }
              
              // 找到第一排第二排li的不同元素的index，然后把第二排li的值赋给第一排li
              this.arr = [];
              for ( ; num2-- ; ) {
                firstLetter = this.firstStr.charAt(num2);
                if ( firstLetter !== lastStr.charAt(num2) ) {
                  this.arr.push(num2);
                }
              }
              
              this.move(this.arr);
              this.firstStr = lastStr;
              for ( ; num3-- ; ) {
                firstLetter = this.firstStr.charAt(num3);
                if ( firstLetter !== ":" ) {
                  firstImg[num3].src = './static/img/picClock/' + firstLetter + '.JPG';
                }
              }
              
        },

        // 因为，用上面的日期函数读取出来的数，如果不超过10，不会显示前面的那个0，所以需要用这个函数，来加上前面的那个0，把它变成2位数。
        toTwo : function(time) {
          return (time < 10) ? ("0" + time) : ("" + time);
        },
        
        // jq动画将下一排的li移动到上面去
        move : function(arr) {
          
          var len = arr.length,
              value = 0,
              str = "-" + this.elHeight,
              li = this.el.find("li");

          for ( ; len-- ; ) {
            value = arr[len];
            $(li[value]).stop().animate({"top":str}, 500, function() {
              $(this).css("top","0px");
            });
          }

        }

      };

      // clock.init($("div"));

