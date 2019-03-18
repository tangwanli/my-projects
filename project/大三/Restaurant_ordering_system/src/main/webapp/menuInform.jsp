
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd

">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单管理</title>
<style type="text/css">
/* .div-nvabar{position:relative;background:#70DBDB ; color:#000; border:1px solid #000; height:40px}
a:hover 
{
	color:red;
} */
input {
    
	text-align:center;
	font-family:"幼圆";
	font-size:15px;
	color:white;
	background-color : transparent;   
    border:none;
}
h1{
    letter-spacing: 15px;
    font-family: "幼圆";
	font-size: 50px;
	color: white;
}
ul
{
list-style-type:none;
margin:0;
padding:0;
overflow:hidden;
}
li
{
float:left;
}
a:link,a:visited
{
display:block;
width:120px;
font-weight:bold;
color:#FFFFFF;
background-color:none;
text-align:center;
padding:4px;
text-decoration:none;
text-transform:uppercase;
}
a:hover,a:active
{
background-color:#cc0000;
}

.context {
	background-image: url("images/bp2.jpg");
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}
.log_c{border:1px solid #d4d4d4;width:180px;height:22px}
span{font-size:15px}
</style>
<script type="text/javascript" language="javascript">
function openDiv(sHtml){
sHtml.replace('"','\'');//解析html
sAlert(sHtml);//获取的页面div内容添加到弹出层里面
}
function sAlert(str){
var msgw,msgh,bordercolor;
msgw=300;//弹出层的宽
msgh=155;//弹出层的高
titleheight=25 //title Height 弹出层的标题高度
bordercolor="#336699";//弹框的背景颜色
var sWidth,sHeight;
sWidth=document.body.offsetWidth;
sHeight=screen.height-140;
var bgObj=document.createElement("div");//创建div 锁屏用的
bgObj.setAttribute('id','bgDiv');//设置id为bgdiv
bgObj.style.position="absolute";//设置为绝对定位
bgObj.style.top="0";//距离上边的边距
bgObj.style.background="#777"; //fff白色 设置锁屏里面的背景颜色
bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
bgObj.style.opacity="0.6";
bgObj.style.left="0";//距离左边的边距
bgObj.style.width=sWidth + "px";
bgObj.style.height=sHeight + "px";
bgObj.style.zIndex = "10000";
document.body.appendChild(bgObj);
var msgObj=document.createElement("div")//创建弹出层
msgObj.setAttribute("id","msgDiv");//设置id为msgDiv
msgObj.setAttribute("align","center");//内容居中
msgObj.style.background="white";
msgObj.style.border="1px solid " + bordercolor; //边框颜色
msgObj.style.position = "absolute"; //设置为绝对定位
msgObj.style.left = "55%";
msgObj.style.top = "50%";
msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
msgObj.style.marginLeft = "-225px" ;
msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
msgObj.style.width = msgw + "px";
msgObj.style.height =msgh + "px";
msgObj.style.textAlign = "center";
msgObj.style.lineHeight ="25px";
msgObj.style.zIndex = "10001";
//设置关闭的文字 点击关闭 弹出层直接关闭 显示页面
var title=document.createElement("h4");
title.setAttribute("id","msgTitle");
title.setAttribute("align","right");
title.style.margin="0";
title.style.padding="3px";
title.style.background=bordercolor;
title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
title.style.opacity="0.75";
title.style.border="1px solid " + bordercolor;
title.style.height="18px";
title.style.font="15px Verdana, Geneva, Arial, Helvetica, sans-serif";
title.style.color="white";
title.style.cursor="pointer";
title.innerHTML="关闭";
//点击关闭的时候 删除弹出层
title.onclick=function(){
document.body.removeChild(bgObj);
document.getElementById("msgDiv").removeChild(title);
document.body.removeChild(msgObj);
}
document.body.appendChild(msgObj);
document.getElementById("msgDiv").appendChild(title);
var txt=document.createElement("p");
txt.style.margin="1em 0"
txt.setAttribute("id","msgTxt");
txt.innerHTML=str;
document.getElementById("msgDiv").appendChild(txt);
}
</script>

</head>
<body>

<%
   String[] li={"a","b","c","d","e","f","g"} ;
 %>
<body class="context">
	<form action="orderList" method="post">
		<!-- <h1 align="center">订单信息</h1> -->
		  <ul>
              <li><a href="userInform.jsp">| 用户信息 |</a></li>
              <li><a href="orderList.jsp">| 订单信息 |</a></li>
              <li><a href="menuInform.jsp">| 菜单信息 |</a></li>
         </ul>
             <h1 align="center">菜单信息</h1>
<!-- <div class="div-nvabar">
<span style="position: relative; top:0px; left:10px; color:red;">
<p><a href="     ">首页</a> <a href="Order.jsp">订单</a>
<span style="position: relative; top:0px; left:540px; color:red;">
<a href="Course.jsp">添加</a>
</span>
</p>
</span>
</div> -->

<div style="position:relative; ">


<c:forEach items="<%=li%>" var="no">
<span style="font-family:Microsoft YaHei; font-size:18px;">
<div style="position: relative; border:1px solid #C0C0C0;margin-top:10px;margin-left:10px; width: 170px; height: 190px;float :left;">  
<img src="images/1.JPG" alt="img" width="170px" height="155px" > 
<span style="position: absolute;top:0px; left: 10px;color:#990033;"><p>菜名</p>
</span>        
<span style="position: absolute;top:20px; left: 10px;color:#990033;"><p>价格</p><br></span>
<span style="position: absolute; top: 160px; left:115px; ">
<input type="button" value="删除"        ></span>
<span style="position: absolute; top: 160px; left:60px; ">
<input type="button" name="btn" id="btn" onclick="openDiv(document.getElementById('strHtml').innerHTML)" value="修改"/>
</span>
</div>
</span>

</c:forEach>
</div>

<div id="strHtml" style="display:none">
<table>
<tr>
<td><span style="margin-left:15px">菜名：</span></td>
<td><input type="text" class="log_c" id="txtName" value=""/></td>
</tr>
<tr>
<td><span style=" margin-left:15px">价格：</span></td>
<td><input type="text" class="log_c" id="txtPrice" value=""/></td>
</tr>
<tr>
<td colspan="2" >
<span style="position: absolute; top: 110px; left:120px; ">
<input type="button" style="color:black;border:1px solid black;" onclick="showDialog()" value="提 交">
	
	<script>
		function showDialog(){
			alert("修改成功！");
		}
	</script></span></td>
</tr>
</table>
</div>

<div style=" width: 40px; position: fixed;bottom: 40px;right: 50px;font-size: 50px;line-height: 0px;z-index: 100;">
<a href="Course.jsp" style="text-decoration:none;background-color:transparent;" title="添加">+</a>
</div>

</body>
<html>
