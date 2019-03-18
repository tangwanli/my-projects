<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统登录</title>

<style type="text/css">
*{  margin:0;
   padding:0;}
    body{
    color:#FEF;
    } 
    h1{
    height:120px;}
   .context{
  background-image:url("img/xxx.jpg");
   position:absolute;
   left:0;
   top:0;
   width:100%;
   height:100%;
   overflow:hidden;
  /* padding:10px ;*/
   }
   .container{
   background:transparent;
   max-width:600px;
   height:400px;
   padding:100px 0;
   text-align:center;
   margin:0 auto;
   
   }
    .container input{
   display: block;
     opacity:0.8; 
    width: 250px;
    height: 50px;
    margin:0 auto;
     border: 1px solid #CC9C56;
    padding: 0px 0px 0px 60px;
     font-size: 16px;
     margin-bottom: 10px;
   border-radius: 15px;
   outline:none;
   
   } 
    .container button{
     background-color: #CC9C56;
    opacity:1; 
    color:#ddd; 
    width: 315px;
    height:50px;
    border: 1px;
    padding: 1px;
    font-size:150%;
    cursor: pointer;
    border-radius: 15px;
    }
  .container  button:hover {
    background-color: white;
    color: #466BAF;
    border: 1px solid #466BAF;
}
.container span error{
display: block;
}

</style>
</head>
<body>
 <div class="context">
 <div class="container">
 <h1>Welcome to BookSystem</h1>
 <form action="login" method="post">
<input  name="userName"  value="${userName}" placeholder="请输入用户名">
<input type="password" name="userPassword" value="${userPassword}" placeholder="请输入密码">
  <button type="submit">登录</button>
  <div>
   <font color="red">${msg}</font>
  </div>

 </form>
 </div>
 </div>
</body>
</html>