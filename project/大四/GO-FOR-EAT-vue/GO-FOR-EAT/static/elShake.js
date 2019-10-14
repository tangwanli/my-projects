
      // elShake工具使用方法：先初始化，即elShake.init(el);el为抖动的jq元素。然后再elShake.shake(el, attr);attr为抖动的方向
      var elShake = {
        speed : 100,
        arr : [],
        num : 0,
        newObj : {},
        left : "",
        top : "",
 
        // 为元素初始化一个left和top值，防止位置改变
        init : function (obj) {
            this.left = obj.css("left");
            this.top = obj.css("top");
            console.log('初始化shake成功', this.left, this.top);
        },

        // 抖动函数，接收3个参数，obj：抖动元素；attr抖动开始方向；
        shake : function ( obj, attr) {
          console.log('再看看有没有进shake函数');
            // 下面这个判断语句为防止无限点击click
            if ( attr == "left"  ) {
              obj.css("left",this.left);
              console.log('判断1');
            } else {
              obj.css("top",this.top);
              console.log('判断2');
            }

            var speed = this.speed,
                pos = parseFloat(obj.css(attr));
            console.log('pos', pos);
            // 将arr和num设空，防止无限叠加
            this.arr = [];
            this.num = 0;  
            // 向arr中加元素
            for(; speed > 0; speed -= 10 ) {
                this.arr.push(-speed, speed);       
            }
            this.arr.push(0);
            console.log(this.arr);
              this.go(obj,attr,pos);
        },
        go: function(obj,attr,pos) {
          var timer = setInterval(function(attr, that) {
            if(that.num !== that.arr.length) {
              console.log('???????????');
              obj.css(attr, pos + that.arr[that.num] + 'px');
              that.num = that.num + 1;
            } else {
              clearInterval(timer);
            }
          }, 80, attr, this);
        }
        
      };
      
      /*elShake.init($("div"));
      $("div").click ( function () {
        var that = $(this);
        elShake.shake(that, "left");
      });*/
