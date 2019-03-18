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
	<form action="orderList" method="post">
		<!-- <h1 align="center">订单信息</h1> -->
		  <ul>
              <li><a href="userInform.jsp">| 用户信息 |</a></li>
              <li><a href="orderList.jsp">| 订单信息 |</a></li>
              <li><a href="menuInform.jsp">| 菜单信息 |</a></li>
         </ul>
             <h1 align="center">订单信息</h1>
        <div id="allOrder">
		<!--<table width="1900px">
			<tbody>
				<tr>
				    <th>订单ID</th>
					<th>用户ID</th>
					<th>订单内容</th>
					<th>订单金额</th>
					<th>下单时间</th>
					<th>完成时间</th>
					<th>订单状态</th>
					<th>操作</th>
				</tr>
				<tr>
					<td>01</td>
					<td>余春娇</td>
					<td>土豆丝</td>
					<td>100.86</td>
					<td>17:25</td>
					<td>18:50</td>
					<td>
					<select>
				<option value='完成'>完成</option>
				<option value='未完成'>未完成</option>
                    </select>
					</td>
					<td>
					<button>修改</button>
					<button>删除</button>
                    </td>
				</tr>

		</table>
		-->
		</div>
		  <div>
		  <button style="margin-left:850px;margin-right:50px;">提  交</button>
		  <button>返  回</button>
		  </div>
	</form>
	
	

	
<!-- 	<div id="getOrderDetailDiv" style="display:none;">
		<table width="300" border="0">
		<tr>
			<td height="20" colspan="2"></td>
		</tr>
		<tr>
			<td height="30" align="left" class="textBold-Title"><dd>订单详情</dd></td>
		</tr>
		<tr>
			<td height="30"></td>
		</tr>
		<tr>
			<td width="200" id="userName" class="normalText"><dd></dd><dd>用户姓名：</dd></td>
		</tr>
		<tr>
			<td height="15"></td>
		</tr>
		<tr>
			<td id="userPhone" class="normalText"><dd>联系方式：</dd></td>
		</tr>
		<tr>
			<td height="15"></td>
		</tr>
		<tr>
			<td id="foodDetail" class="normalText"><dd>菜品清单：</dd></td>
		</tr>
		<tr>
			<td height="150"></td>
		</tr>
		<tr>
			<td id="foodPrice" class="textBold"><dd><strong>总计:</strong></dd></td>
		</tr>
		</table>
	</div> -->
	
	
	<script type = "text/javascript" src = "js/getAllOrder.js">
	</script>
	<script type = "text/javascript" src = "js/jquery.min.js">
	</script>
	<script type = "text/javascript" src = "js/changeOrderStatus.js">
	</script>
	
	
</body>
	

</html>
