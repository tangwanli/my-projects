<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>
</head>
<style>
<style type ="text/css">body {
	width: 500px;
	height: 1000px;
}

table {
	margin-top:50px;
	border-collapse: collapse;
	text-align:center;
}

th, td {
	width: 100px;
	height: 40px;
	border: 1px solid gray;
	font-size: 25px;
	color:white;
	text-align: center;
}
h1{
    letter-spacing: 15px;
    font-family: "幼圆";
	font-size: 50px;
	color: white;
}
button {

	text-align:center;
	font-family:"幼圆";
	font-size:25px;
	color:white;
	background-color : transparent;
    text-decoration:underline;
    border:none;
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

.textBold-Title 
{
	font-size:20px;
	color: #000000;
	text-decoration: none;
	font-weight: bold;
	font-family:Microsoft YaHei;
}
.textBold
{
	font-size:16px;
	color: #000000;
	font-weight: bold;
	font-family:Microsoft YaHei;
}
.normalText
{
	font-size: 14px;
	color: #000000;
	font-weight: normal;
	font-family:Microsoft YaHei;
}

input{
text-align:center;
	font-family:"幼圆";
	font-size:25px;
	color:white;
	background-color : transparent;
    text-decoration:underline;
    border:none;
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
select{
    width: 85px;
    height: 40px;
    font-size: 25px;
    font-weight:bold;
    color: white;
    font-family:"幼圆";
    background-color : transparent;
}

</style>

<!--显示订单信息-->




<body class="context">
		<!-- <h1 align="center">订单信息</h1> -->
		  <ul>
              <li><a href="userInform.jsp">| 用户信息 |</a></li>
              <li><a href="orderList.jsp">| 订单信息 |</a></li>
              <li><a href="menuInform.jsp">| 菜单信息 |</a></li>
         </ul>
 <div id="allUsers">
 </div>  
 
 <script src="./js/jquery.min.js"></script>
<script type="text/javascript" src="js/getAllUsers.js">
</script>
<script type = "text/javascript" src = "js/getOrderDetailByUserId.js">
</script> 
         
</body>
</html>