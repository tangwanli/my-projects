<template>
  
    <div class="wrapper"><!-- 容器 -->
        <div class="littleH"><!-- 小黄人 -->
            <div class="top-canvas"><canvas></canvas></div>
            <div class="bodyH"><!-- 身体 -->
            </div>
            <div class="hair"><!-- 头发 -->
                <div class="left_hair_one"><div></div></div>
                <div class="left_hair_two"><div></div></div>
            </div>
            <div class="eyes"><!-- 眼睛 -->
                <div class="leftEye"><!-- 左眼 -->
                    <div class="left_blackEye">
                        <div class="left_white"></div>
                    </div>
                </div>
                <div class="rightEye"><!-- 右眼 -->
                    <div class="right_blackEye">
                        <div class="right_white"></div>
                    </div>
                </div>
            </div>
            <div class="mouse"><!-- 嘴巴 -->
                <div class="mouse_shape"></div>
            </div>
            <div class="hands"><!-- 双手 -->
                <div class="leftHand"><div></div></div>
                <div class="rightHand"><div></div></div>
            </div>
            <div class="feet"><!-- 双脚 -->
                <div class="left_foot"></div>
                <div class="right_foot"></div>
            </div>
            <div class="groundShadow"></div><!-- 脚底阴影 -->
        </div>
    </div>
</template>

<script>
export default {
  name: 'GreenOne',
  mounted() {
    let effect = {
  init(canvas){
var ctx = canvas.getContext("2d");
var body = [];

/*var mouse_pos_x = canvas.width/2;
var mouse_pos_y = canvas.height/2;*/
var mouse_pos_x = canvas.width;
var mouse_pos_y = canvas.height;
var delta = 1;
var step = 0;
var loop = 0;
var line = 0;
var lineMax = 20;
var lineMin = 5;
var TWO_PI = 2 * Math.PI;
var t = 0;
var animate = true;
var op = 1;

var bodyLength = 20;

var red = [];
var grn = [];
var blu = [];

center = 128;
width = 127;
frequency1 = 0.3;
frequency2 = 0.3;
frequency3 = 0.3;

phase1 = 0;
phase2 = 2;
phase3 = 4;

for (s = 0; s < bodyLength; s++) {
  red[s] = Math.round(Math.sin(frequency1*s + phase1) * width + center);
  grn[s] = Math.round(Math.sin(frequency2*s + phase2) * width + center);
  blu[s] = Math.round(Math.sin(frequency3*s + phase3) * width + center);
}

size = Math.min(canvas.width, canvas.height)/50;
//See below
var startX = canvas.width/2 + size * (16 * Math.sin(0) * Math.sin(0) * Math.sin(0));
var startY = canvas.height - (canvas.height/2 + ( size *( 13 * Math.cos(0)  - 5 * Math.cos(0) - 2 * Math.cos(0) - Math.cos(0))));

for (i = 0; i < bodyLength; i++) {
  var b = {
    x: startX,
    y: startY
  };
  body.push(b);
}

/*window.requestAnimationFrame(draw);*/
  }
}
effect.init(document.querySelector('canvas'));
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.wrapper{
  width: 300px;
  margin:100px auto;
}
.litteH{
  position: relative;
}
.bodyH{
  position: absolute;
  width: 240px;
  height: 380px;
  border-radius: 115px;
  background: -webkit-linear-gradient(top,#8AB924,#DEE681);
  overflow: hidden;
  z-index: 2;
}
.bodyH .condoleBelt{
  position: absolute;
}
.bodyH .condoleBelt .left,
.bodyH .condoleBelt .right{
  width: 100px;
  height: 16px;
  border:5px solid #000;
  background: rgb(32,116,160);
  position: absolute;
  top:-90px;
  left:-35px;
  z-index: 2;
  -webkit-transform:rotate(45deg);
}
.bodyH .condoleBelt .left{
  top:-88px;
  left:165px;
  -webkit-transform:rotate(-45deg);
}
.bodyH .condoleBelt .left:after,
.bodyH .condoleBelt .right:after{
  content: '';
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: #000;
  position: absolute;
  top:4px;
  left:88px;
}

.bodyH .condoleBelt .left:after{
  left:5px;
}
.bodyH .trousers{
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 100px;
  border-top: 6px solid #000;
  background: rgb(32,116,160);
}
.trousers_top{
  width: 160px;
  height: 60px;
  border:6px solid #000;
  border-bottom: none;
  border-radius: 0 0 5px 5px;
  background: rgb(32,116,160);
  position: absolute;
  bottom: 100px;
  left:34px;
}
.pocket{
  width: 60px;
  height: 45px;
  border:6px solid #000;
  border-radius: 0px 0px 25px 25px;
  position: absolute;
  bottom:65px;
  left:84px;
}
.line_right{
  width: 30px;
  height: 30px;
  border-bottom-left-radius: 100px;
  border-bottom:6px solid #000;
  border-left:6px solid #000;
  position: absolute;
  left: 0;
  bottom:60px;
  -webkit-transform:rotate(-75deg);
}
.line_left{
  width: 30px;
  height: 30px;
  border-bottom-right-radius: 100px;
  border-bottom:6px solid #000;
  border-right:6px solid #000;
  position: absolute;
  right: 0;
  bottom:63px;
  -webkit-transform:rotate(75deg);
}
.line_bottom{
  height: 40px;
  border:3px solid #000;
  border-radius: 3px;
  position: absolute;
  left:118px;
  bottom: 0px;
}
.box2 .hair{
  position: relative;
}
.left_hair_one{
  width: 10px;
  height: 50px;
  background: -webkit-linear-gradient(top,#8AB924,#DEE681);
  position: absolute;
  left:53px;
  top:-30px;
  transform-origin: center bottom;
  -webkit-animation: lefthair 2s ease-in-out infinite;
}
.left_hair_one div,.left_hair_two div {
  position: absolute;
  top: -10px;
  left: -5px;
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background: -webkit-linear-gradient(top,#8AB924,#DEE681);;
}
@-webkit-keyframes lefthair{
  0%,25%,31%,100%{
  }
  30%{
    -webkit-transform: rotate(31deg) translate3d(-3px,-1px,0);
  }
}
.left_hair_two{
  width: 10px;
  height: 50px;
  background: -webkit-linear-gradient(top,#8AB924,#DEE681);
  position: absolute;
  left:180px;
  top:-30px;
  transform-origin: center bottom;
  -webkit-animation: lefthair 2s ease-in-out infinite;
}
.eyes{
  position: relative;
  z-index: 3;
  transform: scale(0.9);
}
.eyes .leftEye,.eyes .rightEye{
  width: 85px;
  height: 85px;
  border-radius: 50%;
  background: #fff;
  position: absolute;
  top:90px;
  left: 20px;
}
.eyes .leftEye{
  left: 130px;
}
.eyes .leftEye .left_blackEye,
.eyes .rightEye .right_blackEye{
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background: #000;
  position: absolute;
  top:24px;
  left:22px;
  -webkit-animation: blackeye 5s ease-in infinite;
}
@-webkit-keyframes blackeye{
  0%,20%,50%,70%,100%{
    -webkit-transform: translateX(0px);
  }
  30%,40%{
    -webkit-transform: translateX(15px);
  }
  80%,90%{
    -webkit-transform: translateX(-15px);
  }
}
.eyes .leftEye .left_blackEye .left_white,
.eyes .rightEye .right_blackEye .right_white{
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background: #fff;
  position: absolute;
  top:7px;
  left:17px;
  -webkit-animation: whiteeye 5s ease-in-out infinite;
}
@-webkit-keyframes whiteeye{
  0%,20%,50%,70%,100%{
    -webkit-transform: translateX(0px);
  }
  30%,40%{
    -webkit-transform: translate3d(3px,4px,0);
  }
  80%,90%{
    -webkit-transform: translate3d(-15px,4px,0);
  }
}
.eyes .leftEye .left_blackEye .left_white{
  top:4px;
  left:17px;
}
.eyes .leftEye:after{
  left:89px;
  top:37px;
  -webkit-transform:skewX(-20deg) rotate(-7deg);
}
.mouse{
  position: relative;
}
.mouse .mouse_shape{
  width: 55px;
  height: 35px;
  border-bottom-left-radius: 30px;
  border-top-right-radius: 30px;
  background: -webkit-linear-gradient(top,#4C9F3E 0%, #9CCE6F 100%);
  position: absolute;
  top:175px;
  left:98px;
  z-index: 3;
  -webkit-transform:rotate(-35deg);
  -webkit-animation: mouse 5s ease-in-out infinite;
}
@-webkit-keyframes mouse{
  40%,43%{
    width: 45px;
      height: 25px;
      top:180px;
  }
  0%,35%,48%,100%{
    width: 55px;
      height: 35px;
      top:175px;
    -webkit-transform:rotate(-35deg);
  }
}
.mouse .mouse_shape:after{
  content: '';
  width: 70px;
  height: 32px;
  border-radius:35px 26px 5px 5px;
  background: #B3CF50;
  position: absolute;
  top:-16px;
  left:3px;
  -webkit-transform:rotate(34deg);
  -webkit-animation: mouse_mask 5s ease-in-out infinite;
}
@-webkit-keyframes mouse_mask{
  40%,43%{
    width: 60.5px;
    top:-19.3px;
    left:1.5px;
  }
  0%,35%,48%,100%{
    width: 70px;
    top:-16px;
    left:3px;
    -webkit-transform:rotate(33deg);
  }
}
.hands{
  position: relative;
}
.hands .leftHand,
.hands .rightHand{
  width: 70px;
  height: 40px;
  border-radius: 25px;
  background: rgb(249,217,70);
  background: -webkit-linear-gradient(top,#8AB924,#DEE681);
  position: absolute;
  transform-origin: right center;
  transform: rotate(-10deg);
  animation: 2s shakeRHand linear infinite;
  top:200px;
  left:-50px;
}
.hands .leftHand{
  /*left:182px;*/
  left:225px;
  top:200px;
  transform-origin: left center;
  transform: rotate(10deg);
  animation: 2s shakeLHand linear infinite;
}
.rightHand div, .leftHand div {
  position: absolute;
  left: -25px;
  top: -6px;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background: -webkit-linear-gradient(top,#8AB924,#DEE681);
}
.leftHand div {
  left: 50px;
}
@-webkit-keyframes shakeLHand {
  0%{
    transform: rotate(10deg);
  }
  50%{
    transform: rotate(30deg);
  }
  100%{
    transform: rotate(10deg);
  }
}
@-webkit-keyframes shakeRHand {
  0%{
    transform: rotate(-10deg);
  }
  50%{
    transform: rotate(-30deg);
  }
  100%{
    transform: rotate(-10deg);
  }
}

.feet{
  position: relative;
}
.feet .left_foot,
.feet .right_foot{
  width: 45px;
  height: 80px;
  border-bottom-right-radius: 9px;
  border-bottom-left-radius: 9px;
  background: -webkit-linear-gradient(top,#DEE681,#8AB924);
  position: absolute;
  left:142px;
  -webkit-transform-origin: right top;
  -webkit-animation: rightfoot .8s ease-in-out infinite;
}
.feet .left_foot{
  border-bottom-right-radius: 9px;
  border-bottom-left-radius: 9px;
  left:62px;
  -webkit-transform-origin: left top;
  -webkit-animation: leftfoot .8s ease-in-out infinite;
}
@-webkit-keyframes rightfoot{
  0%{
    top: 350px;
  }
  50%{
    top: 340px;
  }
  100%{
    top: 350px;
  }
}
@-webkit-keyframes leftfoot{
  0%{
    top: 340px;
  }
  50%{
    top: 350px;
  }
  100%{
    top: 340px;
  }
}

.groundShadow{
  width: 200px;
  height: 2px;
  border-radius: 50%;
  background: rgba(0,0,0,0.3);
  box-shadow: 0 0 2px 4px rgba(0,0,0,0.3);
  position: relative;
  top: 435px;
  left:25px;
}
.wrapper {
  transform: scale(0.3);
}
.top-canvas {
  position: absolute;
  top: -71px;
  left: 87px;
  z-index: 10;
  width: 90px;
  height: 62px;
}
canvas {
  width: 100%;
  height: 100%;
  transform: scale(1.8);
}
</style>
