<template>
  <div class='road' @click="leave">
    <div class="container">
        <!-- 山 -->
        <div class="mountain">
            <div class="part_one"></div>
            <div class="part_two"></div>
            <div class="part_three"></div>
            <div class="part_four"></div>
        </div>
        <!-- 道路 -->
        <div class="load"></div>
        <!-- 石头 -->
        <div class="stone"></div>
        <!-- 太阳 -->
        <div class="sun">
            <div class="sunshine"></div>
            <div class="center_sun"></div>
        </div>
        <!-- 云朵 -->
        <div class="cloud"></div>
        <!-- 房子 -->
        <div class="house">
            
            <!-- 墙面 -->
            <div class="wall"></div>
            <!-- 房顶 -->
            <div class="roof"></div>
            <!-- 二楼 -->
            <div class="secondFloor">
                <!-- 窗户 -->
                <div class="window w1">
                    <!-- 窗户帐篷 -->
                    <div class="window_tent"></div>
                    <!-- 窗体 -->
                    <div class="window_body"></div>
                </div>
                <div class="window w2">
                    <!-- 窗户帐篷 -->
                    <div class="window_tent"></div>
                    <!-- 窗体 -->
                    <div class="window_body"></div>
                </div>
                <div class="window w3">
                    <!-- 窗户帐篷 -->
                    <div class="window_tent"></div>
                    <!-- 窗体 -->
                    <div class="window_body"></div>
                </div>
                <div class="window w4">
                    <!-- 窗户帐篷 -->
                    <div class="window_tent"></div>
                    <!-- 窗体 -->
                    <div class="window_body"></div>
                </div>
            </div>
            <div class="firstFloor">
                <!-- 窗户 -->
                <div class="window f-w1">
                    <!-- 窗户帐篷 -->
                    <div class="window_tent"></div>
                    <!-- 窗体 -->
                    <div class="window_body"></div>
                </div>
                <div class="window f-w2">
                    <!-- 窗户帐篷 -->
                    <div class="window_tent"></div>
                    <!-- 窗体 -->
                    <div class="window_body"></div>
                </div>
                <!-- 门 -->
                <div class="door">
                    <!-- 门梁 -->
                    <div class="door_over"></div>
                    <!-- 门主体 -->
                    <div class="door_body">
                        <div class="leftDoor"></div>
                        <div class="rightDoor"></div>
                    </div>
                </div>
                <div class="window f-w3">
                    <!-- 窗户帐篷 -->
                    <div class="window_tent"></div>
                    <!-- 窗体 -->
                    <div class="window_body"></div>
                </div>
            </div>
        </div>
        <!-- 树 -->
        <div class="trees">
            <div class="leftTree"><span></span></div>
            <div class="leftTree l2"><span></span></div>
            <div class="rightTree"><span></span></div>
            <div class="rightTree r2"><span></span></div>
        </div>
        <!-- 第一辆汽车 -->
        <div class="car">
            <div class="car_body">
                <div class="car_top1"></div>
                <div class="car_top2"></div>
                <div class="car_win1"></div>
                <div class="car_win2"></div>
                <div class="car_bottom1"></div>
                <div class="car_bottom2"></div>
            </div>
            <div class="frontWheel"></div>
            <div class="endWheel"></div>
            <div class="exhaust"></div>
        </div>
        <!-- 第二辆车（浅绿色） -->
        <div class="car2">
            <div class="car2_top"></div>
            <div class="car2_win"></div>
            <div class="car2_bottom">
                <div class="car2_light1"></div>
                <div class="car2_light2"></div>
                <div class="car2_light3"></div>
            </div>
            <div class="car2_frontWheel"></div>
            <div class="car2_endWheel"></div>
        </div>
    </div>
    <div class="box2">
        <router-view></router-view>
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
        this.$router.push('/');
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.road {
    margin: 0;
    position: relative;
}
h1{
    text-align: center;
    color:#666;
}
.container{
    width: 100%;
    height: 600px;
    position: relative;
    background: rgb(187,235,255);
    border:1px solid #ddd;
    box-shadow:1px 1px 1px 1px rgba(0,0,0,0.1);
    overflow: hidden;
}
.mountain{
    position: relative;
}
.mountain .part_one{
    width:300px;
    height: 300px;
    background: rgb(106,207,255);
    position: absolute;
    -webkit-transform:rotate(30deg) skew(-20deg) translate3d(120px,200px,0);
    -moz-transform:rotate(30deg) skew(-20deg) translate3d(120px,200px,0);
    -o-transform:rotate(30deg) skew(-20deg) translate3d(120px,200px,0);
    -ms-transform:rotate(30deg) skew(-20deg) translate3d(120px,200px,0);
    transform:rotate(30deg) skew(-20deg) translate3d(120px,200px,0);
}
.mountain .part_two{
    width:200px;
    height: 200px;
    background: rgb(105,198,242);
    position: absolute;
    left:330px;
    -webkit-transform:rotate(30deg) skew(-25deg) translate3d(270px,90px,0);
    -moz-transform:rotate(30deg) skew(-25deg) translate3d(270px,90px,0);
    -o-transform:rotate(30deg) skew(-25deg) translate3d(270px,90px,0);
    -ms-transform:rotate(30deg) skew(-25deg) translate3d(270px,90px,0);
    transform:rotate(30deg) skew(-25deg) translate3d(270px,90px,0);
}
.mountain .part_three{
    width:300px;
    height: 300px;
    background: rgb(106,207,255);
    position: absolute;
    left:330px;
    -webkit-transform:rotate(45deg) skew(10deg) translate3d(120px,150px,0);
    -moz-transform:rotate(45deg) skew(10deg) translate3d(120px,150px,0);
    -o-transform:rotate(45deg) skew(10deg) translate3d(120px,150px,0);
    -ms-transform:rotate(45deg) skew(10deg) translate3d(120px,150px,0);
    transform:rotate(45deg) skew(10deg) translate3d(120px,150px,0);
}
.mountain .part_four{
    width:200px;
    height: 200px;
    background: rgb(106,207,255);
    position: absolute;
    left:430px;
    -webkit-transform:rotate(34deg) skew(-40deg) translate3d(300px,95px,0);
    -moz-transform:rotate(34deg) skew(-40deg) translate3d(300px,95px,0);
    -o-transform:rotate(34deg) skew(-40deg) translate3d(300px,95px,0);
    -ms-transform:rotate(34deg) skew(-40deg) translate3d(300px,95px,0);
    transform:rotate(34deg) skew(-40deg) translate3d(300px,95px,0);
}
.load{
    position: relative;
    top:290px;
    background: rgb(27,121,160);
    height: 160px;
}
.sun{
    position: relative;
}
.sun .center_sun{
    width:40px;
    height:40px;
    background: rgb(255,255,123);
    border-radius: 50%;
    position: absolute;
    top:-120px;
    right:160px;
}
.sun .sunshine{
    width:60px;
    height:60px;
    background: #f67e28; /* Old browsers */
    background: -moz-radial-gradient(center, ellipse cover, #f67e28 0%, #f67e28 50%, #f4bf9a 60%, #f4bf9a 100%); /* FF3.6+ */
    background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%,#f67e28), color-stop(50%,#f67e28), color-stop(60%,#f4bf9a), color-stop(100%,#f4bf9a)); /* Chrome,Safari4+ */
    background: -webkit-radial-gradient(center, ellipse cover, #f67e28 0%,#f67e28 50%,#f4bf9a 60%,#f4bf9a 100%); /* Chrome10+,Safari5.1+ */
    background: -o-radial-gradient(center, ellipse cover, #f67e28 0%,#f67e28 50%,#f4bf9a 60%,#f4bf9a 100%); /* Opera 12+ */
    background: -ms-radial-gradient(center, ellipse cover, #f67e28 0%,#f67e28 50%,#f4bf9a 60%,#f4bf9a 100%); /* IE10+ */
    background: radial-gradient(ellipse at center, #f67e28 0%,#f67e28 50%,#f4bf9a 60%,#f4bf9a 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f67e28', endColorstr='#f4bf9a',GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
    position: absolute;
    top:-130px;
    right:150px;
    border-radius:50%;
    box-shadow: 0 0 2px 4px rgba(246,126,40,0.3);
    -webkit-animation:sun_shining 3s ease infinite alternate;
    -moz-animation:sun_shining 3s ease infinite alternate;
    -o-animation:sun_shining 3s ease infinite alternate;
    -ms-animation:sun_shining 3s ease infinite alternate;
    animation:sun_shining 3s ease infinite alternate;
}
@-webkit-keyframes sun_shining{
    0%{
        -webkit-transform:scale(0.8);
    }
    100%{
        -webkit-transform:scale(1);
    }
}
@-moz-keyframes sun_shining{
    0%{
        -moz-transform:scale(0.8);
    }
    100%{
        -moz-transform:scale(1);
    }
}
@-o-keyframes sun_shining{
    0%{
        -o-transform:scale(0.8);
    }
    100%{
        -o-transform:scale(1);
    }
}
@-ms-keyframes sun_shining{
    0%{
        -ms-transform:scale(0.8);
    }
    100%{
        -ms-transform:scale(1);
    }
}
@keyframes sun_shining{
    0%{
        transform:scale(0.8);
    }
    100%{
        transform:scale(1);
    }
}
.house{
    position: relative;
}
.house .flag_whole{
    position: absolute;
}
.flag_whole .pole{
    height: 60px;
    border:2px solid rgb(197,151,63);
    position: absolute;
    top:-125px;
    left:297px;
}
.pole:after{
    content: '';
    display: inline-block;
    width:10px;
    height: 10px;
    background: rgb(231,183,91);
    border-radius: 50%;
    position: absolute;
    top:-5px;
    left:-5px;
}
.flag_whole .flag{
    width:45px;
    height: 28px;
    background: rgb(215,33,33);
    position: absolute;
    top:-118px;
    left:301px;
    -webkit-animation:flag_shake 0.6s ease-in-out infinite alternate;
    -moz-animation:flag_shake 0.6s ease-in-out infinite alternate;
    -o-animation:flag_shake 0.6s ease-in-out infinite alternate;
    -ms-animation:flag_shake 0.6s ease-in-out infinite alternate;
    animation:flag_shake 0.6s ease-in-out infinite alternate;
}
@-webkit-keyframes flag_shake{
    0%{

    }
    100%{
        -webkit-transform:skewY(5deg) translateY(3px);
    }
}
@-moz-keyframes flag_shake{
    0%{

    }
    100%{
        -moz-transform:skewY(5deg) translateY(3px);
    }
}
@-o-keyframes flag_shake{
    0%{

    }
    100%{
        -o-transform:skewY(5deg) translateY(3px);
    }
}
@-ms-keyframes flag_shake{
    0%{

    }
    100%{
        -ms-transform:skewY(5deg) translateY(3px);
    }
}
@keyframes flag_shake{
    0%{

    }
    100%{
        transform:skewY(5deg) translateY(3px);
    }
}
/*大星星*/
.star,.star:before,.star:after{
    display: inline-block;
    width: 0;
    height: 0;
    border-top:8px solid transparent;
    border-bottom: 8px solid transparent;
    border-left: 5px solid rgb(255,202,0);
    position: absolute;
    left:7.5px;
    top:6px;
    -webkit-transform: rotate(18deg);
    -moz-transform: rotate(18deg);
    -o-transform: rotate(18deg);
    -ms-transform: rotate(18deg);
    transform: rotate(18deg);
}
.star:before{
    content: '';
    top:-8.2px;
    left:-4.4px;
    -webkit-transform: rotate(72deg);
    -moz-transform: rotate(72deg);
    -o-transform: rotate(72deg);
    -ms-transform: rotate(72deg);
    transform: rotate(72deg);
}
.star:after{
    content: '';
    top:-7.7px;
    left:-5.3px;
    -webkit-transform: rotate(147deg);
    -moz-transform: rotate(147deg);
    -o-transform: rotate(147deg);
    -ms-transform: rotate(147deg);
    transform: rotate(147deg);
}
/*小星星*/
.littlestar,.littlestar:before,.littlestar:after{
    display: inline-block;
    width: 0;
    height: 0;
    border-top:3px solid transparent;
    border-bottom: 3px solid transparent;
    border-left: 2px solid rgb(255,202,0);
    position: absolute;
    left:18.5px;
    top:5px;
    -webkit-transform: rotate(18deg);
    -moz-transform: rotate(18deg);
    -o-transform: rotate(18deg);
    -ms-transform: rotate(18deg);
    transform: rotate(18deg);
}
.littlestar:before{
    content: '';
    top:-3.5px;
    left:-2px;
    -webkit-transform: rotate(72deg);
    -moz-transform: rotate(72deg);
    -o-transform: rotate(72deg);
    -ms-transform: rotate(72deg);
    transform: rotate(72deg);
}
.littlestar:after{
    content: '';
    top:-3.2px;
    left:-2px;
    -webkit-transform: rotate(147deg);
    -moz-transform: rotate(147deg);
    -o-transform: rotate(147deg);
    -ms-transform: rotate(147deg);
    transform: rotate(147deg);
}
.house .wall{
    width:260px;
    height:200px;
    background: rgb(112,151,194);
    position: absolute;
    left:140px;
    top:-38px;
    z-index: 2;
}
.star1{
    left:18px;
    top:2px;
}
.star2{
    left:24px;
    top:7px;
}
.star3{
    left:24px;
    top:15px;
}
.star4{
    left:18px;
    top:21px;
}
.house .roof{
    width:45px;
    height:45px;
    background: rgb(120,145,199);
    border:5px solid rgb(157,189,224);
    border-radius: 3px;
    position: absolute;
    top:-67px;
    left:270px;
    z-index:1;
    -webkit-transform:rotate(36deg) skew(-15deg);
    -moz-transform:rotate(36deg) skew(-15deg);
    -o-transform:rotate(36deg) skew(-15deg);
    -ms-transform:rotate(36deg) skew(-15deg);
    transform:rotate(36deg) skew(-15deg);
}
.house .secondFloor{
    width:280px;
    height: 94px;
    border-top:8px solid rgb(157,189,224);
    border-bottom:8px solid rgb(157,189,224);
    position: absolute;
    left:130px;
    top:-42px;
    z-index:3;
}
.house .firstFloor{
    width:280px;
    height: 94px;
    position: absolute;
    left:130px;
    top:68px;
    z-index:3;
}
.house .window{
    position: absolute;
}
.house .window .window_tent{
    width:48px;
    height:20px;
    background: rgb(192,0,27);
    position: absolute;
    top:0;
    left:-2px;
    z-index:2;
}
.window_tent:before,.window_tent:after{
    content: '';
    display: inline-block;
    width:7.5px;
    height: 20px;
    border-left:6.5px solid #fff;
    border-right:6.5px solid #fff;
    position: absolute;
    top:0;
    left:0;
}
.window_tent:after{
    left:28.5px;
}
.house .window .window_body{
    width:36px;
    height:50px;
    background: rgb(49,89,148);
    border:4px solid rgb(169,196,222);
    border-radius: 3px;
    position: absolute;
}
.window_body:before{
    content: '';
    display: inline-block;
    width:36px;
    border:2px solid rgba(169,196,222,0.5);
    position: absolute;
    top:38px;
}
.window_body:after{
    content: '';
    display: inline-block;
    height:50px;
    border:2px solid rgba(169,196,222,0.5);
    position: absolute;
    left:50%;
    margin-left:-2px;
}
.w1{
    top:20px;
    left:24px;
}
.w2{
    top:20px;
    left:86px;
}
.w3{
    top:20px;
    left:147.5px;
}
.w4{
    top:20px;
    left:210px;
}
.f-w1{
    top:20px;
    left:18px;
}
.f-w2{
    top:20px;
    left:74px;
}
.f-w3{
    top:20px;
    left:218px;
}
.house .door{
    position: absolute;
}
.door .door_over{
    width:86px;
    border:4px solid rgb(212,78,69);
    position: absolute;
    top:-8px;
    left:121px;
}
.door .door_body{
    width:76px;
    height:94px;
    background:#eee;
    position: absolute;
    left:130px;
}
.door_body:before{
    content: '360';
    display: inline-block;
    width: 76px;
    color:green;
    font-size:24px;
    font-weight: bolder;
    position: absolute;
    text-align: center;
    top:2px;
}
.leftDoor,.rightDoor{
    width:26px;
    height: 58px;
    background: rgb(49,89,148);
    position: absolute;
    top:34px;
    left:9px;
    border-top:2px solid rgb(112,151,194);
}
.leftDoor{
    border-right:2px solid rgb(112,151,194);
    animation: 20s doorMotion linear 1;
}
@-webkit-keyframes doorMotion {
    0% {
        width:26px;
    }
    70% {
        width: 26px;
    }
    85% {
        width: 5px;
    }
    100% {
        width:26px;
    }
}
.rightDoor{
    border-left:2px solid rgb(112,151,194);
    left:40px;
}
.trees{
    position: relative;
}
.trees .leftTree,.trees .rightTree{
    width:40px;
    height: 40px;
    background: rgb(144,193,56);
    border-radius: 50%;
    position: absolute;
    left:105px;
    top:87px;
    z-index: 4;
}
.trees .rightTree{
    left:396px;
}
.trees .r2{
    left:450px;
}
.trees .l2{
    left:50px;
}
.leftTree span,.rightTree span{
    display: inline-block;
    width:14px;
    height:4px;
    border-top:3px solid rgba(255,255,255,0.5);
    border-bottom:3px solid rgba(255,255,255,0.5);
    position: absolute;
    left:24px;
    top:10px;
    -webkit-transform:rotate(-30deg);
    -moz-transform:rotate(-30deg);
    -o-transform:rotate(-30deg);
    -ms-transform:rotate(-30deg);
    transform:rotate(-30deg);
}
.leftTree:after,.rightTree:after{
    content: '';
    display: inline-block;
    height: 33px;
    border:2px solid rgb(235,97,0);
    position: absolute;
    top:40px;
    left:18px;
}
.stone{
    width:30px;
    height: 16px;
    background: #333;
    border-radius: 16px 16px 5px 5px;
    position: absolute;
    top:410px;
    left:550px;
    box-shadow: 1px 1px 1px #333;
}
.car{
    position: absolute;
    left:900px;
    top:340px;
    z-index:7;
    -webkit-animation:car_drive 5s ease-in infinite;
    -moz-animation:car_drive 5s ease-in infinite;
    -o-animation:car_drive 5s ease-in infinite;
    -ms-animation:car_drive 5s ease-in infinite;
    animation:car_drive 5s ease-in infinite;
}
@-webkit-keyframes car_drive{
    0%{
        left:880px;
    }
    11%{
        left:615px;
        top:340px;
        -webkit-transform:rotate(0deg);
    }
    12%{
        left:580px;
        top:320px;
        -webkit-transform:rotate(-10deg);
    }
    13%{
        left:550px;
        top:325px;
        -webkit-transform:rotate(-8deg);
    }
    15%,20%{
        left:470px;
        top:340px;
        -webkit-transform:rotate(0deg);
    }
    50%{
        left:400px;
    }
    100%{
        left:-100px;
    }
}
@-moz-keyframes car_drive{
    0%{
        left:880px;
    }
    11%{
        left:615px;
        top:340px;
        -moz-transform:rotate(0deg);
    }
    12%{
        left:580px;
        top:320px;
        -moz-transform:rotate(-10deg);
    }
    13%{
        left:550px;
        top:325px;
        -moz-transform:rotate(-8deg);
    }
    15%,20%{
        left:470px;
        top:340px;
        -moz-transform:rotate(0deg);
    }
    50%{
        left:400px;
    }
    100%{
        left:-100px;
    }
}
@-o-keyframes car_drive{
    0%{
        left:880px;
    }
    11%{
        left:615px;
        top:340px;
        -o-transform:rotate(0deg);
    }
    12%{
        left:580px;
        top:320px;
        -o-transform:rotate(-10deg);
    }
    13%{
        left:550px;
        top:325px;
        -o-transform:rotate(-8deg);
    }
    15%,20%{
        left:470px;
        top:340px;
        -o-transform:rotate(0deg);
    }
    50%{
        left:400px;
    }
    100%{
        left:-100px;
    }
}
@-ms-keyframes car_drive{
    0%{
        left:880px;
    }
    11%{
        left:615px;
        top:340px;
        -ms-transform:rotate(0deg);
    }
    12%{
        left:580px;
        top:320px;
        -ms-transform:rotate(-10deg);
    }
    13%{
        left:550px;
        top:325px;
        -ms-transform:rotate(-8deg);
    }
    15%,20%{
        left:470px;
        top:340px;
        -ms-transform:rotate(0deg);
    }
    50%{
        left:400px;
    }
    100%{
        left:-100px;
    }
}
@keyframes car_drive{
    0%{
        left:880px;
    }
    11%{
        left:615px;
        top:340px;
        transform:rotate(0deg);
    }
    12%{
        left:580px;
        top:320px;
        transform:rotate(-10deg);
    }
    13%{
        left:550px;
        top:325px;
        transform:rotate(-8deg);
    }
    15%,20%{
        left:470px;
        top:340px;
        transform:rotate(0deg);
    }
    50%{
        left:400px;
    }
    100%{
        left:-100px;
    }
}
.car .car_body{
    position: absolute;
    -webkit-animation:carBody_shake 5s ease-in infinite;
    -moz-animation:carBody_shake 5s ease-in infinite;
    -o-animation:carBody_shake 5s ease-in infinite;
    -ms-animation:carBody_shake 5s ease-in infinite;
    animation:carBody_shake 5s ease-in infinite;
}
@-webkit-keyframes carBody_shake{
    0%,16%,18.3%,100%{
        top:0;
    }
    17.4%{
        top:8px;
    }
}
@-moz-keyframes carBody_shake{
    0%,16%,18.3%,100%{
        top:0;
    }
    17.4%{
        top:8px;
    }
}
@-o-keyframes carBody_shake{
    0%,16%,18.3%,100%{
        top:0;
    }
    17.4%{
        top:8px;
    }
}
@-ms-keyframes carBody_shake{
    0%,16%,18.3%,100%{
        top:0;
    }
    17.4%{
        top:8px;
    }
}
@keyframes carBody_shake{
    0%,16%,18.3%,100%{
        top:0;
    }
    17.4%{
        top:8px;
    }
}
.car .car_top1,.car .car_top2{
    width:45px;
    height: 35px;
    border-top-left-radius:10px;
    border-top-right-radius:10px;
    background: rgb(246,126,40);
    position: absolute;
    left:0;
    top:0;
    -webkit-transform:skew(24deg);
    -moz-transform:skew(24deg);
    -o-transform:skew(24deg);
    -ms-transform:skew(24deg);
    transform:skew(24deg);
}
.car .car_top1{
    left:-29px;
    top:0px;
    -webkit-transform:skew(-24deg);
    -moz-transform:skew(-24deg);
    -o-transform:skew(-24deg);
    -ms-transform:skew(-24deg);
    transform:skew(-24deg);
}
.car .car_win1,.car .car_win2{
    width:24px;
    height:24px;
    background: #fff;
    border-top-left-radius:10px;
    position: absolute;
    left:13px;
    top:6px;
    -webkit-transform:rotate(80deg) skew(-10deg);
    -moz-transform:rotate(80deg) skew(-10deg);
    -o-transform:rotate(80deg) skew(-10deg);
    -ms-transform:rotate(80deg) skew(-10deg);
    transform:rotate(80deg) skew(-10deg);
}
.car .car_win1{
    left:-22px;
    -webkit-transform:rotate(0deg) skew(-10deg);
    -moz-transform:rotate(0deg) skew(-10deg);
    -o-transform:rotate(0deg) skew(-10deg);
    -ms-transform:rotate(0deg) skew(-10deg);
    transform:rotate(0deg) skew(-10deg);
}
.car .car_win1:after,.car .car_win2:after{
    content:'';
    display:inline-block;
    width:10px;
    height: 24px;
    background: #fff;
    position: absolute;
    left:16px;
    top:0;
    -webkit-transform:skew(10deg);
    -moz-transform:skew(10deg);
    -o-transform:skew(10deg);
    -ms-transform:skew(10deg);
    transform:skew(10deg);
}
.car .car_win2:after{
    top:9px;
    left:7px;
    -webkit-transform:rotate(-90deg) skew(-10deg);
    -moz-transform:rotate(-90deg) skew(-10deg);
    -o-transform:rotate(-90deg) skew(-10deg);
    -ms-transform:rotate(-90deg) skew(-10deg);
    transform:rotate(-90deg) skew(-10deg);
}
.car .car_bottom1,.car .car_bottom2{
    width:74px;
    height:33px;
    background: rgb(246,126,40);
    border-top-left-radius: 24px 20px;
    border-bottom-left-radius: 3px;
    border-bottom:8px solid rgb(186,188,187);
    position: absolute;
    top:34px;
    left:-66px;
    -webkit-transform:skew(-4deg);
    -moz-transform:skew(-4deg);
    -o-transform:skew(-4deg);
    -ms-transform:skew(-4deg);
    transform:skew(-4deg);
}
.car .car_bottom2:before{
    content: 'JR';
    font-size:12px;
    font-weight: bolder;
    color:#fff;
    position: absolute;
    top:5px;left:45px;
}
.car .car_bottom1:after{
    content: '';
    display: inline-block;
    background: rgb(247,244,111);
    width:10px;
    height: 16px;
    border-radius: 6px/8px;
    position: absolute;
    top:11px;
    left:6px;
}
.car .car_bottom2{
    height: 36px;
    border-top-left-radius: 0;
    border-top-right-radius: 13px 17px;
    border-bottom-right-radius: 3px;
    left:0px;
    top:31px;
    -webkit-transform:skew(8deg);
    -moz-transform:skew(8deg);
    -o-transform:skew(8deg);
    -ms-transform:skew(8deg);
    transform:skew(8deg);
}
.car .frontWheel,.car .endWheel{
    width:34px;
    height:34px;
    border-radius: 50%;
    background:#333;
    position: absolute;
    top:55px;
    left:-40px;
}
.car .endWheel{
    left:20px;
}
.car .frontWheel:after,.car .endWheel:after{
    content: '';
    display: inline-block;
    width:14px;
    height: 14px;
    background: #fff;
    border-radius: 50%;
    position: absolute;
    top:50%;
    left:50%;
    margin-top: -7px;
    margin-left: -7px;
}
.car .exhaust{
    width:18px;
    height:18px;
    background: rgba(0,0,0,0.3);
    border-radius: 8px 8px 8px 1px;
    position: absolute;
    left:80px;
    top:55px;
    opacity: 0;
    -webkit-animation:exhaust_move 5s ease-in infinite;
    -moz-animation:exhaust_move 5s ease-in infinite;
    -o-animation:exhaust_move 5s ease-in infinite;
    -ms-animation:exhaust_move 5s ease-in infinite;
    animation:exhaust_move 5s ease-in infinite;
}
@-webkit-keyframes exhaust_move{
    0%,20%{
        opacity: 0;
    }
    25%{
        left:75px;
        opacity:1;
    }
    30%{
        opacity: 0;
        left:87px;
        top:50px;
    }
    100%{
        opacity: 0;
    }
}
@-moz-keyframes exhaust_move{
    0%,20%{
        opacity: 0;
    }
    25%{
        left:75px;
        opacity:1;
    }
    30%{
        opacity: 0;
        left:87px;
        top:50px;
    }
    100%{
        opacity: 0;
    }
}
@-o-keyframes exhaust_move{
    0%,20%{
        opacity: 0;
    }
    25%{
        left:75px;
        opacity:1;
    }
    30%{
        opacity: 0;
        left:87px;
        top:50px;
    }
    100%{
        opacity: 0;
    }
}
@-ms-keyframes exhaust_move{
    0%,20%{
        opacity: 0;
    }
    25%{
        left:75px;
        opacity:1;
    }
    30%{
        opacity: 0;
        left:87px;
        top:50px;
    }
    100%{
        opacity: 0;
    }
}
@keyframes exhaust_move{
    0%,20%{
        opacity: 0;
    }
    25%{
        left:75px;
        opacity:1;
    }
    30%{
        opacity: 0;
        left:87px;
        top:50px;
    }
    100%{
        opacity: 0;
    }
}
.cloud{
    display: inline-block;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    background: #fff;
    position: absolute;
    left:-60px;
    top:20px;
    -webkit-animation:cloud_move 8s linear infinite;
    -moz-animation:cloud_move 8s linear infinite;
    -o-animation:cloud_move 8s linear infinite;
    -ms-animation:cloud_move 8s linear infinite;
    animation:cloud_move 8s linear infinite;
}
.cloud:before{
    content: '';
    display: inline-block;
    width: 40px;
    height: 16px;
    border-radius: 16px 0 0 16px;
    background: #fff;
    position: absolute;
    bottom:0;
    left:-12px;
}
.cloud:after{
    content: '';
    display: inline-block;
    width: 40px;
    height: 28px;
    border-radius: 0 28px 28px 0;
    background: #fff;
    position: absolute;
    bottom:0;
    right:-16px;
}
@-webkit-keyframes cloud_move{
    0%{
        left:-60px;
        opacity: 1;
    }
    80%{
        opacity: 1;
    }
    100%{
        left:500px;
        opacity: 0;
    }
}
@-moz-keyframes cloud_move{
    0%{
        left:-60px;
        opacity: 1;
    }
    80%{
        opacity: 1;
    }
    100%{
        left:500px;
        opacity: 0;
    }
}
@-o-keyframes cloud_move{
    0%{
        left:-60px;
        opacity: 1;
    }
    80%{
        opacity: 1;
    }
    100%{
        left:500px;
        opacity: 0;
    }
}
@-ms-keyframes cloud_move{
    0%{
        left:-60px;
        opacity: 1;
    }
    80%{
        opacity: 1;
    }
    100%{
        left:500px;
        opacity: 0;
    }
}
@keyframes cloud_move{
    0%{
        left:-60px;
        opacity: 1;
    }
    80%{
        opacity: 1;
    }
    100%{
        left:500px;
        opacity: 0;
    }
}

.car2{
    position: absolute;
    /*left:900px;*/
    left:-230px;
    top:250px;
    z-index:5;
    animation: 20s car2_drive linear 1;
}
@-webkit-keyframes car2_drive{
    0% {
        opacity: 0;
        left:900px;
    }
    20% {
        opacity: 1;
        left:900px;
    }
    60% {
        left: 230px;
    }
    100%{
        left:-230px;
    }
}
.car2 .car2_top{
    width:55px;
    height: 40px;
    border-top-left-radius:15px;
    border-top-right-radius:10px;
    /*background: rgb(117,191,135);*/
    background: red;
    position: absolute;
    left:-29px;
    top:0px;
    -webkit-transform:skew(-20deg);
    -moz-transform:skew(-20deg);
    -o-transform:skew(-20deg);
    -ms-transform:skew(-20deg);
    transform:skew(-20deg);
}
.car2_top:after{
    content: '';
    display: inline-block;
    width:12px;
    height: 40px;
    /*background: rgb(117,191,135);*/
    background: red;
    -webkit-transform:skew(20deg);
    -moz-transform:skew(20deg);
    -o-transform:skew(20deg);
    -ms-transform:skew(20deg);
    transform:skew(20deg);
    position: absolute;
    left:48px;
}
.car2 .car2_win{
    width:42px;
    height:30px;
    background: #fff;
    border-top-left-radius:10px;
    position: absolute;
    top:5px;
    left:-22px;
    -webkit-transform:rotate(0deg) skew(-20deg);
    -moz-transform:rotate(0deg) skew(-20deg);
    -o-transform:rotate(0deg) skew(-20deg);
    -ms-transform:rotate(0deg) skew(-20deg);
    transform:rotate(0deg) skew(-20deg);
}
.car2_win:after{
    content: '';
    display: inline-block;
    width:12px;
    height: 30px;
    background: #fff;
    -webkit-transform:skew(20deg);
    -moz-transform:skew(20deg);
    -o-transform:skew(20deg);
    -ms-transform:skew(20deg);
    transform:skew(20deg);
    position: absolute;
    left:36px;
}
.car2 .car2_bottom{
    width: 180px;
    height: 56px;
    /*background: rgb(117,191,135);*/
    background: red;
    border-top-left-radius: 50px;
    border-bottom-left-radius: 50px;
    position: absolute;
    top:39px;
    left:-60px;
}
.car2 .car2_bottom .car2_light1{
    width:14px;
    height: 20px;
    background: rgb(229,230,88);
    border-radius: 20px/30px;
    position: absolute;
    left:-3px;
    top:18px;
}
.car2 .car2_bottom .car2_light2,.car2 .car2_bottom .car2_light3{
    width:12px;
    height: 12px;
    background: rgb(229,230,88);
    border-radius: 50%;
    position: absolute;
    right:-8px;
    top:12px;
}
.car2 .car2_bottom .car2_light3{
    top:36px;
}
.car2 .car2_frontWheel,.car2 .car2_endWheel{
    width:40px;
    height:40px;
    background: #333;
    border-radius: 50%;
    position: absolute;
    top:75px;
    left:-30px;
}
.car2 .car2_endWheel{
    left:60px;
}
.car2 .car2_frontWheel:after,.car2 .car2_endWheel:after{
    content: '';
    display: inline-block;
    width:20px;
    height: 20px;
    background: rgb(216,107,82);
    border-radius: 50%;
    position: absolute;
    top:50%;
    left:50%;
    margin-left: -10px;
    margin-top: -10px;
}
    .box2 {
        position: absolute;
/*      right:-114px;
        top:47px;*/
        right:70%;
        top:186px;
        opacity: 0;
        z-index: 4;
        animation: 20s enterCar linear 1;
        /*animation: 3s enterPic linear 1;*/
    }
    /* 进场动画 */
@-webkit-keyframes enterCar {
    0% {
        right:-114px;
        top:47px;
        transform: scale(0.5);
        opacity: 0;
    }
    20% {
        right:398px;
        top:130px;
        opacity: 1;
        transform: scale(0.35);
    }
    60% {
        right:70%;
        top:130px;
    }
    65% {
        top:186px;
        right:70%;
        opacity: 1;
        transform: scale(0.35);
    }
    70% {
        top:186px;
        right:70%;
        opacity: 1;
        transform: scale(0.35);
    }
    100%{
        opacity: 0;
        transform: scale(0.01);
        top:180px;
        right:70%;
    }
}
</style>
