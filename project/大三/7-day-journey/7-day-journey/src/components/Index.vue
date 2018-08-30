<template>
  <div class='all-block'>
    <canvas id=canvas></canvas>
    <div class="pic">
        <router-link to="LiePush" exact><img src="../../static/sport1.jpg" draggable="false" /></router-link>
        <router-link to="LiePush" exact><img src="../../static/sport2.jpg" draggable="false" /></router-link>
        <router-link to="LiePush" exact><img src="../../static/sport3.jpg" draggable="false" /></router-link>
        <router-link to="study" exact><img src="../../static/study1.jpg" draggable="false" /></router-link>
        <router-link to="study" exact><img src="../../static/study2.jpg" draggable="false" /></router-link>
        <router-link to="study" exact><img src="../../static/study3.jpg" draggable="false" /></router-link>
        <router-link to="road" exact><img src="../../static/road1.jpg" draggable="false" /></router-link>
        <router-link to="road" exact><img src="../../static/road2.jpg" draggable="false" /></router-link>
        <router-link to="road" exact><img src="../../static/road3.jpg" draggable="false" /></router-link>
        <p></p>
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
  mounted() {
    function showLight() {
    var ctx = canvas.getContext("2d");
    var body = [];
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    var mouse_pos_x = canvas.width/2;
    var mouse_pos_y = canvas.height/2;
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

    canvas.addEventListener('mouseleave', mouse_leave);

    canvas.addEventListener('mousemove', mouse_track);

    function mouse_leave(){
    animate = true;
    }


    function mouse_track(event) {
    animate = false;
    if((Math.abs(mouse_pos_x - event.clientX) > delta) || (Math.abs(mouse_pos_y - event.clientY) > delta)){
    mouse_pos_x = event.clientX;
    mouse_pos_y = event.clientY;
    }
    }


    //Colours from:
    //https://krazydad.com/tutorials/makecolors.php

    var red = [];
    var grn = [];
    var blu = [];

    var center = 128;
    var width = 127;
    var frequency1 = 0.3;
    var frequency2 = 0.3;
    var frequency3 = 0.3;

    var phase1 = 0;
    var phase2 = 2;
    var phase3 = 4;

    for (let s = 0; s < bodyLength; s++) {
    red[s] = Math.round(Math.sin(frequency1*s + phase1) * width + center);
    grn[s] = Math.round(Math.sin(frequency2*s + phase2) * width + center);
    blu[s] = Math.round(Math.sin(frequency3*s + phase3) * width + center);
    }

    var size = Math.min(canvas.width, canvas.height)/50;
    //See below
    var startX = canvas.width/2 + size * (16 * Math.sin(0) * Math.sin(0) * Math.sin(0));
    var startY = canvas.height - (canvas.height/2 + ( size *( 13 * Math.cos(0)  - 5 * Math.cos(0) - 2 * Math.cos(0) - Math.cos(0))));

    for (let i = 0; i < bodyLength; i++) {
    var b = {
    x: startX,
    y: startY
    };
    body.push(b);
    }

    //****** DRAW ******//

    function draw() {

    t += 0.08;
    t = t % TWO_PI;

    if(line <= lineMin){
    op = 1;
    line = lineMin+1;
    }
    if(line >= lineMax){
    op = -1;
    line = lineMax-1;
    }
    loop++;
    if(loop == 5){
    step++;
    step = step % bodyLength;
    loop = 0;
    }

    line = op + line;

    if(animate){
    size = Math.min(canvas.width, canvas.height)/50;
    //Heart curve from:
    mouse_pos_x = canvas.width/2 + size * (16 * Math.sin(t) * Math.sin(t) * Math.sin(t));
    mouse_pos_y = canvas.height - (canvas.height/2 + ( size * ( 13 * Math.cos(t)  - 5 * Math.cos(2*t) - 2 * Math.cos(3*t) - Math.cos(4*t))));
    }

    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    for (let i = (body.length-1); i > 0; i--) {
    body[i].x = body[i-1].x;
    body[i].y = body[i-1].y;
    } 
    body[0].x = mouse_pos_x;
    body[0].y = mouse_pos_y;

    ctx.lineWidth = line; 
    ctx.strokeStyle = "rgb("+red[step]+","+grn[step]+","+blu[step]+")";
    ctx.fillStyle = "rgb("+red[step]+","+grn[step]+","+blu[step]+")";

    //Draw leading circle
    ctx.beginPath();
    ctx.arc((body[0].x), (body[0].y), line/2, 0, TWO_PI);
    ctx.fill();

    //Draw line
    ctx.beginPath();
    ctx.moveTo(body[0].x, body[0].y);

    for(let s = 0; s < body.length - 2; s++){

    //Bezier curve along points taken from: 

    var xc = (body[s].x + body[s+1].x) / 2;
    var yc = (body[s].y + body[s+1].y) / 2;
    ctx.quadraticCurveTo(body[s].x, body[s].y, xc, yc);
    }
    ctx.stroke();

    //Draw trailing circle
    ctx.beginPath();
    ctx.arc(xc, yc, line/2, 0, TWO_PI);
    ctx.fill();

    window.requestAnimationFrame(draw);
    }
    window.requestAnimationFrame(draw);
    }
$(function (){
var imgl = $("div.pic img").size();
var deg = 360/imgl;
var roY = 0;
var rox = -10;
var xn = 0, yn = 0;
var play = null;

$("div.pic img").each(function (i) {
    $(this).css({
        "transform": "rotateY("+i*deg+ "deg) translateZ(350px)"
    });
    $(this).attr('ondragstart', 'return false');
});
$(document).mousedown(function (ev) {

    var x_ = ev.clientX;
    var y_ = ev.clientY;
    clearInterval(play);
    $(this).bind("mousemove", function (ev) {
    
        var x = ev.clientX;
        var y = ev.clientY;

        xn = x - x_;
        yn = y - y_;
        var varyn = y-y_;
        roY += xn * 0.2;
        rox -= yn * 0.1;
      
        $('div.pic').css({
            transform: 'perspective(800px) rotateX('+rox+'deg) rotateY(' + roY + 'deg)'
        })

        x_ = ev.clientX;
        y_ = ev.clientY;
    });
}).mouseup(function () {
    $(this).unbind("mousemove");
  var play=setInterval(function () {
       xn *= 0.95;
       yn *= 0.95;
       if (Math.abs(xn) < 1 && Math.abs(yn)<1) clearInterval(play);

       roY += xn * 0.2;
       rox -= yn * 0.1;
       $('div.pic').css({
           transform: 'perspective(800px) rotateX(' + rox + 'deg) rotateY(' + roY + 'deg)'
       })
    },30)
});
});
showLight();
/* effect.init(document.querySelector('canvas'));*/
let img = document.querySelectorAll('.pic img');
for (let i=0; i<img.length; i++) {
img[i].onclick = function() {
let box2 = document.querySelector('.box2');
box2.classList.add('enterPic');
}
}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.all-block {
    position: absolute;
    width: 100%;
    height: 100%;
}
.pic {
margin:100px auto 0px;
/*border:1px solid #ff0000;*/
width:120px;
height:180px;
position:relative;
transform-style:preserve-3d;
transform:perspective(800px) rotateX(-10deg) rotateY(0deg);

}
div.pic img {
cursor:pointer;
position:absolute;
width:100%;
height:100%;
border-radius:5px;
}
p{
width:1200px;
height:1200px;

position:absolute;
left:50%;top:100%;
margin-top:-600px;
margin-left:-600px;
transform:rotateX(90deg);
border-radius:600px;
}
#canvas {
position: absolute;
z-index: -1;
}
.box2 {
position: absolute;
bottom: 50%;
left: 50%;
animation: 5s enterMotion linear 1;
/* animation: 5s enterPic linear 1;*/
}
.enterPic {
animation: 3s enterPic linear 1;
}
/* 进场动画 */
@-webkit-keyframes enterMotion {
0% {
bottom: 50%;
left: 10%;
opacity: 0;
transform: scale(0.5);
}
50% {
bottom: 20%;
left: 20%;
}
100% {
left: 50%;
bottom: 50%;
opacity: 0.9;
transform: scale(1);
}
}
@-webkit-keyframes enterPic {
0% {
bottom: 50%;
left: 50%;
opacity: 0.9;
transform: scale(1);
}
100% {
left: 40%;
bottom: 80%;
opacity: 0;
transform: scale(0.1);
}
}
</style>
