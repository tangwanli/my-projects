<template>
  <div class='lie-push' @click="leave">
  <div class="box">
<div class="bench">
  <div class="support">
    <div class="stand">
      <div class="grd1">
        <div class="dmbl1"></div>
        <div class="dmbl2"></div>
        <div class="dmbl3"></div>
        <div class="dmbl4"></div>
          <div class="dmbl5"></div>
        <div class="dmbl6"></div>
        <div class="dmbl7"></div>
        <div class="dmbl8"></div>
          <div class="dmbl9"></div>
        <div class="dmbl10"></div>
        <div class="dmbl11"></div>
        <div class="dmbl12"></div>

      </div>
    </div>
  </div>
  <div class="hanger">
    <div class="hook" ></div>
      <div class="grd2"></div>
    </div>
  <div class="leg1"><div class="shoe"></div></div>
  <div class="leg2"><div class="shoe1"></div></div>
  <div class="thy"></div>
  <div class="belt"></div>
  <div class="stomach"></div>
  <div class="stomach2"></div>
  <div class="chest"></div>
  <div class="chest2"></div>
  <div class="armpit"></div>
  <div class="hand">
  <div class="dumbell">
    <div class="circle1"></div>
    <div class="circle2"></div>
    <div class="circle3"></div>
    </div>
  
  </div>
  <div class="neck"></div>
  <div class="head">
    <div class="lip1"></div>
    <div class="lip2"></div>
  
  <div class="hair"></div>
  </div>
  </div>
</div>
    <div class="box2">
        <router-view></router-view>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    leave(ev) {
    console.log('?????????????????????');
        this.$router.push('/');
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.lie-push
{
height: 100%;
  background:#fff;
}
.box{
  height: 100%;
}
.bench
{
  position:absolute;
  
  top:50%;
  left:35%;
  width:330px;
  height:10px;
  background:#476098;
  border-radius:10px;
}
.support
{
  position:absolute;
  background:#222;
  top:100%;
  left:3%;
  width:310px;
  height:5px;
  border-radius:5px;
}
.hanger
{
  background:#333;
  position:absolute;
  left:90%;
  top:-1500%;
  width:15px;
  height:260px;
  
}
.hook
{
  position:absolute;
 background:#333; 
  top:10%;
  left:-100%;
  width:20px;
  height:3px;
  
}
.stand
{
   position:absolute;
 background:#333; 
  top:10%;
  left:10%;
  width:15px;
  height:102px;
  border-radius:1px
}
.grd1
{
  position:absolute;
  top:95%;
    left:-140%;
  width:55px;
  height:10px;
  background:#333;
  
}
.grd2
{
  position:absolute;
  top:99%;
    left:-160%;
  width:65px;
  height:10px;
  background:#333;
 
}
.dmbl1
{
  position:absolute;
  top:-300%;
    left:-400%;
  width:40px;
  height:40px;
  background:#444;
border-radius:100%;
}
.dmbl2
{
  position:absolute;
  top:-300%;
    left:-350%;
  width:40px;
  height:40px;
  background:#009688;
border-radius:100%;
}
.dmbl3
{
    position:absolute;
  top:-150%;
    left:-375%;
  width:15px;
  height:8px;
  background:#999;
border-radius:6px;
}
.dmbl4
{
    position:absolute;
  top:-150%;
    left:-322%;
  width:10px;
  height:10px;
  background:#111;
border-radius:10px;
}
.dmbl5
{
  position:absolute;
  top:-300%;
    left:150%;
  width:20px;
  height:40px;
  background:#444;
border-radius:5px;
}
.dmbl6
{
  position:absolute;
  top:-300%;
    left:250%;
  width:20px;
  height:40px;
  background:#444;
border-radius:5px;
}
.dmbl7
{
    position:absolute;
  top:-150%;
    left:170%;
  width:100%;
  height:6px;
  background:#444;
border-radius:10px;
}
.dmbl8
{
    position:absolute;
  top:-800%;
    left:380%;
  width:10px;
  height:90px;
  background:#666;
border-radius:2px;
}

.dmbl9
{
  position:absolute;
  top:-550%;
    left:360%;
  width:20px;
  height:40px;
  background:#666;
border-radius:5px;
}
.dmbl10
{
  position:absolute;
  top:-800%;
    left:660%;
  width:10px;
  height:90px;
  background:#666;
border-radius:2px;
}
.dmbl11
{
    position:absolute;
  top:-550%;
    left:660%;
  width:20px;
  height:40px;
  background:#666;
border-radius:5px;
}
.dmbl12
{
    position:absolute;
  top:-400%;
    left:340%;
  width:380%;
  height:8px;
  background:#666;
border-radius:10px;
}
.leg1
{
  position:absolute;
  background:#FDA76D;
  height:126px;
  width:15px;
  top:-210%;
  left:-9%;
  border-radius:7px;
  z-index:100;
    -ms-transform: rotate(-15deg); /* IE 9 */
    -webkit-transform: rotate(-15deg); /* Chrome, Safari, Opera */
    transform: rotate(-15deg);
   animation: movement 3s infinite linear;
  -moz-animation: movement 3s infinite linear;
}
.shoe{
  position:absolute;
  background:#333;
  height:20px;
  width:40px;
  top:95%;
  left:-150%;
border-radius:5px;
  z-index:100;
    
}
.leg2
{
  position:absolute;
  background:#FDA050;
  height:126px;
  width:15px;
  top:-210%;
  left:-7%;
  border-radius:7px;
  z-index:10;
  -ms-transform: rotate(-15deg); /* IE 9 */
    -webkit-transform: rotate(-15deg); /* Chrome, Safari, Opera */
    transform: rotate(-15deg);
   animation: movement 3s infinite linear;
   -moz-animation: movement 3s infinite linear;
}
.shoe1{
  position:absolute;
  background:#555;
  height:20px;
  width:40px;
  top:95%;
  left:-150%;
border-radius:5px;
  z-index:100;
    
}
.thy
{
   position:absolute;
  background:#61967B;
  width:156px;
  height:20px;
  top:-220%;
  left:-11%;
  border-radius:7px;
  z-index:90;
   animation: thym 3s infinite linear;
}
.belt
{
  position:absolute;
  background:#8BC34A;
  width:15px;
  height:45px;
  top:-450%;
  left:20%;
  border-radius:3px;
  z-index:100;
  
}
.stomach
{
   position:absolute;
  background:#cf4645;
  width:86px;
  height:35px;
  top:-350%;
  left:20%;
  border-radius:7px;
  z-index:90;
}
.stomach2
{
   position:absolute;
  background:#FF8A65;
  width:56px;
  height:30px;
  top:-470%;
  left:21%;
  border-radius:5px;
  z-index:10;
  opacity:1;
  -ms-transform: rotate(-15deg); /* IE 9 */
    -webkit-transform: rotate(-15deg); /* Chrome, Safari, Opera */
    transform: rotate(-15deg);
}
.chest
{
   position:absolute;
  background:#cf4645;
  width:86px;
  height:60px;
  top:-600%;
  left:35%;
  border-radius:40px;
  z-index:11;
  animation:inex 3s infinite linear
}
.chest2
{
   position:absolute;
  background:#FF8A65;
  width:103px;
  height:80px;
  top:-820%;
  left:30%;
  border-radius:60px;
  z-index:10;
  opacity:1;
  animation:inex 3s infinite linear
}
.armpit
{
   position:absolute;
  background:#f8a781;
  width:46px;
  height:26px;
  top:-250%;
  left:42%;
  border-radius:60px;
  z-index:90;
  
}
.hand
{
   position:absolute;
  background:#Fda76d;
  width:36px;
  height:136px;
  top:-100%;
  left:45%;
  border-radius:60px;
  z-index:90;
  transform:translateY(-60%);
  animation: lift 3s infinite linear;
}
.dumbell
{
  position:absolute;
  top:0%;
  left:-75%;
   background:#222;
  width:110px;
  height:110px;
   border-radius:100%;
  z-index:90;

  transform:translateY(-60%);

}
.circle1
{
  position:absolute;
   top:5%;
  left:5%;
  background:#0077B5;
  width:100px;
  height:100px;
   border-radius:100%;
  z-index:200;
}
.circle2
{
   position:absolute;
   top:15%;
  left:15%;
  background:#222;
  width:80px;
  height:80px;
   border-radius:100%;
  z-index:200;
}
.circle3
{
   position:absolute;
   top:42%;
  left:42%;
  background:#eee;
  width:20px;
  height:20px;
   border-radius:100%;
  z-index:200;
}
.neck
{
   position:absolute;
  background:#cf4645;
  width:25px;
  height:46px;
  top:-450%;
  left:54%;
  border-radius:10px;
  z-index:11;
}
.head
{
   position:absolute;
  background:#Fda76d;
  width:66px;
  height:40px;
  top:-400%;
  left:59%;
  border-radius:5px;
  z-index:10;
  animation:hm 3s infinite linear;
}
.box .hair
{
   position:absolute;
  background:#212121;
  width:16px;
  height:46px;
  top:-10%;
  left:90%;
  border-radius:2px;
  z-index:10;
}
.lip1
{
   position:absolute;
  background:#fda76d;
  width:5px;
  height:6px;
  top:-10%;
  left:50%;
  border-radius:5px;
  z-index:10;
  animation:exin 3s infinite linear;
}
.lip2
{
   position:absolute;
  background:#fda76d;
  width:5px;
  height:6px;
  top:-10%;
  left:55%;
  border-radius:5px;
  z-index:10;
   
}
.wall1
{
  position:absolute;
  top:20%;
  left:30%;
  width:40px;
  height:15px;
  background:#777;
  border-radius:2px;
}
.wall2
{
  position:absolute;
  top:25%;
  left:25%;
  width:40px;
  height:15px;
  background:#aaa;
  border-radius:2px;
}
.wall3
{
  position:absolute;
  top:10%;
  left:80%;
  width:40px;
  height:15px;
  background:#777;
  border-radius:2px;
}
.wall4
{
  position:absolute;
  top:13%;
  left:85%;
  width:40px;
  height:15px;
  background:#aaa;
  border-radius:2px;
}
.wall5
{
  position:absolute;
  top:25%;
  left:33%;
  width:40px;
  height:15px;
  background:#999;
  border-radius:2px;
}

@-webkit-keyframes "movement" {
    0% {
        transform:rotate(-10deg);
        }
  40% {
        transform:rotate(-10deg);
        }
    50% {
        transform:rotate(10deg);
    }
    65% {
        transform:rotate(10deg);
    }
  
    100% {
transform:rotate(-10deg);
    }
}


@-webkit-keyframes "thym" {
    0% {
    left:-11%;
        }
  40% {
            left:-11%;
        }
    50% {
    left:-6%;
    }
    65% {
        left:-6%;
    }
  
    100% {
    left:-11%;
    }
}
@-webkit-keyframes "lift" {
    0% {
    top:-100%;
        }
  40% {
            top:-100%;
        }
    50% {
    top:-670%;
    }
    65%
  {
    top:-670%;
  }
  
    100% {
    top:-100%;
    }
}
@-webkit-keyframes "inex" {
0%
  {
        transform:translateY(0%);
  }
 35%
  {
        transform:translateY(0%);
  }
    50% {
    transform:translateY(5%);
    }
 
  
    100% {
    transform:translateY(0%);
    }
}
@-webkit-keyframes "exin" {
    0% {
    left:35%;
    
        }
  45% {
            left:35%;
        }
    50% {
    left:45%;
    top:-10%;
    }
    65% {
        left:45%;
    }
  
    100% {
    left:35%;
    }
}
@-webkit-keyframes "hm" {
    0% {
        transform:rotate(0deg);
    
        }
  35% {
        transform:rotate(0deg);
    top:-400%
        }
  
    50% {
        transform:rotate(-15deg);
  top:-460%;
    }
    53% {
    top:-460%;  
        transform:rotate(-15deg);
      
    }
  56%
  {
    top:-400%;
    transform:rotate(0deg);
  }
  59%
  {
    top:-410%;
    transform:rotate(-4deg);
  }
    62%
  {
    top:-405%;
    transform:rotate(-2deg);
  }
  65%
  {
    top:-400%;
    transform:rotate(0deg);
  }
  
  
    100% {
transform:rotate(0deg);
    }
}

@-moz-keyframes movement {
    0% {
        -moz-transform:rotate(-10deg);
        }
  40% {
    -moz-transform:rotate(-10deg);
        }
    50% {
    -moz-transform:rotate(10deg);
    }
    65% {
        -moz-transform:rotate(10deg);
    }
  
    100% {
-moz-transform:rotate(-10deg);
    }
}


@-moz-keyframes thym {
    0% {
    left:-11%;
        }
  40% {
            left:-11%;
        }
    50% {
    left:-6%;
    }
    65% {
        left:-6%;
    }
  
    100% {
    left:-11%;
    }
}
@-moz-keyframes lift {
    0% {
    top:-100%;
        }
  40% {
            top:-100%;
        }
    50% {
    top:-670%;
    }
    65%
  {
    top:-670%;
  }
  
    100% {
    top:-100%;
    }
}
@-moz-keyframes inex {
0%
  {
        -moz-transform:translateY(0%);
  }
 35%
  {
        -moz-transform:translateY(0%);
  }
    50% {
    -moz-transform:translateY(5%);
    }
 
  
    100% {
    -moz-transform:translateY(0%);
    }
}
@-moz-keyframes exin {
    0% {
    left:35%;
    
        }
  45% {
            left:35%;
        }
    50% {
    left:45%;
    top:-10%;
    }
    65% {
        left:45%;
    }
  
    100% {
    left:35%;
    }
}
@-moz-keyframes hm {
    0% {
        -moz-transform:rotate(0deg);
    
        }
  35% {
        -moz-transform:rotate(0deg);
    top:-400%
        }
  
    50% {
        -moz-transform:rotate(-15deg);
  top:-460%;
    }
    53% {
    top:-460%;  
        -moz-transform:rotate(-15deg);
      
    }
  56%
  {
    top:-400%;
    -moz-transform:rotate(0deg);
  }
  59%
  {
    top:-410%;
    -moz-transform:rotate(-4deg);
  }
    62%
  {
    top:-405%;
    -moz-transform:rotate(-2deg);
  }
  65%
  {
    top:-400%;
    -moz-transform:rotate(0deg);
  }
  
  
    100% {
-moz-transform:rotate(0deg);
    }
}


    .box2 {
        position: absolute;
        bottom: 63px;
        left: 128px;
        transform: scale(0.7);
        animation: 3s enterMotion linear 1;
    }
    .leaveMotion { /* 点击的时候把这个类加到box2上 */
        bottom: 63px;
        left: 128px;
        transform: scale(0.7);
        animation: 3s leaveMotion linear 1;
    }
    /* 进场动画 */
@-webkit-keyframes enterMotion {
  0% {
    bottom: 293px;
    left: -208px;
    transform: scale(0.7);
  }
  80% {
    bottom: 63px;
    left: 128px;
    transform: scale(0.7);
  }
  90% {
    bottom: 83px;
    left: 128px;
    transform: scale(0.7);
  }
  100% {
    bottom: 63px;
    left: 128px;
    transform: scale(0.7);
  }
}
@-webkit-keyframes leaveMotion {
  0% {
      bottom: 63px;
      left: 128px;
      transform: scale(0.7);
  }
  20% {
      bottom: 148px;
      left: 328px;
      transform: scale(0.7);
  }
  40% {
      bottom: 63px;
      left: 528px;
      transform: scale(0.7);
  }
    60% {
      bottom: 148px;
      left: 728px;
      transform: scale(0.7);
  }
  80% {
      bottom: 63px;
      left: 928px;
      transform: scale(0.7);
  }
  100% {
      bottom: 148px;
      left: 1128px;
      transform: scale(0.7);
  }
}
</style>
