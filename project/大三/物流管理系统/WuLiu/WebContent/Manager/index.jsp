<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../CSS/style.css">
<title>
�ư�����������ϵͳ
</title>
<style>
@-webkit-keyframes spin {
  0% {
  transform-origin: 50px 50px;
    transform: rotate(0);
  }
  50% {
  transform-origin: 50px 50px;
    transform: rotate(90deg);
  }
  100% {
  transform-origin: 50px 50px;
    transform: rotate(0deg);
  }
}
html {
position: relative;
}
#warning {
position: absolute;
  margin-left: 100px;
  width: 200px;
  height: 200px;
  transition: 1s;
  animation: 1s spin ease infinite;
}
.wrap {
  position: absolute;
  width: 200px;
  height: 200px;
  transform-origin: 100px 86.6px;
  border-radius: 50%;
  overflow: hidden;
}
.sector {
  width: 0;
  height: 0;
  overflow: hidden;
  border-top: 86.6px solid yellow;
  border-bottom: 86.6px solid transparent;
  border-left: 50px solid transparent;
  border-right: 50px solid transparent;
  transform: translateX(50px);
}
.wrap:nth-of-type(2) {
  transform: rotate(60deg);
}
.wrap:nth-of-type(3) {
  transform: rotate(120deg);
}
.wrap:nth-of-type(4) {
  transform: rotate(180deg);
}
.wrap:nth-of-type(5) {
  transform: rotate(240deg);
}
.wrap:nth-of-type(6) {
  transform: rotate(300deg);
}
.wrap:nth-of-type(2) .sector, .wrap:nth-of-type(4) .sector, .wrap:nth-of-type(6) .sector {
  border-top-color: black;
}
.warning2 {
right: 10px;
}
  /* �ֲ�ͼ */
  #carousel-figure { 
    position: absolute;
    top: 55px;
    left: -150px;
    height: 300px;
    transform: scale(1.12);
  }

  .ul-bag {
    position: relative;
    left: 500px;
    top: 50px;
    width: 680px;
    height: 200px;
    overflow: hidden;
  }

  /* ���ﲻΪul���ÿ�ȣ���js�������ã����Ա�֤�����ж��ٸ�li�����㹻�Ŀ���ų�һ�� */
  .pic-move {
    position: absolute; 
    top: 0;
    left: 0;       
  }

  .pic-move li {    
    float: left;
    width: 200px;
    height: 200px;
    margin-right: 20px;
    cursor: pointer;
  }

  .buttom-left, .buttom-right {
    position: absolute;
    width: 40px;
    height: 50px;
    margin-top: 60px;
    background: #4d4dc8;
    text-indent: 5px;
    font-size: 40px;
    cursor: pointer;
  }

  .buttom-left {
  display: none;
    top: 190px;
    left: 700px;
  }

  .buttom-right {
  display: none;
    top: 190px;
    left: 900px;
  }
  .bg {
  margin-top: 200px;
  }
</style>
<script src='../js/jquery-1.9.1.js'></script>
</head>
<body bgcolor="#ffffff">
<jsp:include page="mtop.jsp" flush="true"></jsp:include>
<div id="warning">
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
</div>
<div id="warning" class='warning2'>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
    <div class="wrap">
      <div class="sector"></div>
    </div>
</div>
<table class='bg' width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="../image/bg-8.jpg" >
  <tr>
    <td><div align="center"><img src="../image/bg-7.jpg" width="793" height="493"></div></td>
  </tr>
</table>
    <div id="carousel-figure">
        
        <div class="ul-bag">
        <ul class="pic-move">
            
            <li><a href="#"><img src="../image/skybirds.png" alt="1"></a></li>
            <li><a href="#"><img src="../image/skyhouse.png" alt="1"></a></li>
            <li><a href="#"><img src="../image/skyoasis.png" alt="1"></a></li>
            <li><a href="#"><img src="../image/skytree.png" alt="1"></a></li>
            
        </ul>
        </div>
        <span class="buttom-left"> < </span>
        <span class="buttom-right"> > </span>
        
    </div>
<script>
console.log('??????');
// ����onload�¼�
function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != "function") {
      window.onload = func;
  }
  else {
      window.onload = function() {
          oldonload();
          func();
      }
  }
}

addLoadEvent(carouselFigure);
// ��ʼ����Ĭ��ҳ����ص�ʱ�򣬷�������ƶ�
addLoadEvent(moveLeft);



// �ֲ�ͼ
// ������������ʱ������
var timer_left;
var timer_right;
// ����һ������������onmouseout�������leftʱi=1�����rightʱi=0
var i = 1;
// ��ȡul��Ϊ��֮��ʹul����
var pic_move = document.getElementsByClassName("pic-move")[0];
function carouselFigure() {

  var buttom_left = document.getElementsByClassName("buttom-left")[0];
  var buttom_right = document.getElementsByClassName("buttom-right")[0];

  // ��ȡli��Ϊ��֮����li.length����̬��ʼ��ul�Ŀ��
  var pic_li = pic_move.getElementsByTagName("li");
  
  // ʹul����
  pic_move.innerHTML += pic_move.innerHTML;

  // ��̬��ʼ��ul�Ŀ��
  pic_move.style.width = pic_li[0].offsetWidth * pic_li.length +"px";
  

  buttom_left.onclick = function() {
    // �����������ƶ�����ֹʹ�ٶȵ��ӣ�����ο�����ʱ��
    clearTimeout(timer_left);
    // ���������Ķ�ʱ��
    clearTimeout(timer_right);
    moveLeft();
    i=1;
  }

  buttom_right.onclick = function() {
    clearTimeout(timer_right);
    clearTimeout(timer_left);
    moveRight();
    i=0;
  }

  pic_move.onmouseover = function() {
    clearTimeout(timer_right);
    clearTimeout(timer_left);
  }

  pic_move.onmouseout = function() {
      if(i == 1) {
        moveLeft();
      }
      else {
        moveRight();
      }
  }
}

function moveLeft() {
  var speed = 10;     
  // ���˶��������ܳ���һ���ʱ�򣬽�λ���Ƶ���ʼλ��
  if(-pic_move.offsetLeft >= pic_move.offsetWidth/2 ) {
  pic_move.style.left = 0;
  }
    else {   
  pic_move.style.left = pic_move.offsetLeft - speed + "px";
  }

  timer_left = setTimeout("moveLeft()",100);

}

function moveRight() {
  var speed = 10;     
  
  if(pic_move.offsetLeft >= 0 ) {
  pic_move.style.left = -pic_move.offsetWidth/2 + "px";
  }
    else {   
  pic_move.style.left = pic_move.offsetLeft + speed + "px";
  }

  timer_right = setTimeout("moveRight()",100);
}
</script>
</body>
</html>
