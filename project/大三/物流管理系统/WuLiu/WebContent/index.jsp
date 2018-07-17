<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>科帮网物流管理系统</title>
<style>
    @keyframes snow {
      from {
        background-position: 0 0, 0 0;
      }
      to {
        background-position: 500px 500px, 1500px 500px;
      }
    }
    .snow {
      position: fixed;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      background: url("./image/snow1.png"),url("./image/snow1.png");
      animation: 10s snow linear infinite;
      pointer-events: none;
    }
    .wrap {width:206px;height:206px; margin:80px auto;position: absolute;left:50px;top:-50px;}
    .dial {width:200px;height: 200px;border: 2px solid gray;border-radius:50%;font-size:0px;}
    .dial span {display: inline-block;width: 2px;height: 6px;background: #666;position: absolute;top: 0;left:100px;-webkit-transform-origin:0 100px;-webkit-transform:rotate(0deg);}
    .dial span:nth-of-type(5n+1){height: 10px;background: #000;}

    .hand {width: 100px;height: 100px;position: absolute;top:95px;left: 95px;}
    .hand div {transform-origin:top}
    .hour {width: 6px;height: 50px;background: black;position: absolute;top: 2.5px;left: 1px;}
    .min {width: 4px;height: 70px;background: gray;position: absolute;top: 2.5px;left: 2px;}
    .sec {width: 2px;height: 85px;background: purple;position: absolute;top: 2.5px;left: 2.5px;}
    .centre {width: 10px;height: 10px;background: gray;border-radius: 50%;position: absolute;top: 0;left: 0;}
    </style>
    <script src='./js/jquery-1.9.1.js'></script>
<Script language="javascript">
function check1()
{
if(form_u.name.value=="")
{
alert("请添入姓名");
form_u.name.focus();
return false;
}
if(form_u.password.value=="")
{
alert("请添入密码");
form_u.password.focus();
return false;
}
}
</Script>
<%!
ResultSet rs1=null ,goodrs=null;
String sql,goodsql,placardsql,esql,login,username;
int code,gcode;
%>
</head>

<body  link="#669900" alink="#FFCC66" vlink="#FF3300">
<div class="snow"></div>
  <div class="wrap">
    <div class="dial">
    </div>
    <div class="hand">
      <div class="hour"></div>
      <div class="min"></div>
      <div class="sec"></div>
      <div class="centre"></div>
    </div>
  </div>
<jsp:include page="top.jsp"/>
<table width="786" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="202" height="255" valign="top" background="image/8.jpg">	
	
	<jsp:include page="left.jsp" flush="true" /></td>
    <td width="484" valign="top"><table width="100" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="image/13.jpg" width="370" height="39"></td>
      </tr>
    </table>
      <table width="370"  border="0" cellpadding="0" cellspacing="0" background="image/14.jpg">
        <tr>
          <td valign="top">
		  
		  <table width="370" border="0" cellpadding="0" cellspacing="0">
<%
goodsql="select ID,GoodsStyle,GoodsName,StartProvince,StartCity,EndProvince,EndCity,Style,UserName from tb_GoodsMeg order by IssueDate desc limit 0,8";
try{
rs1=connection.executeQuery(goodsql);
while(rs1.next()){
gcode=rs1.getInt("ID");
%>
            <tr>
              <td width="36" height="25">&nbsp;</td>
              <td width="334"><a href="goods_xiangxi.jsp?id=<%=gcode%>">
			<%=rs1.getString("GoodsStyle")%>--<%=rs1.getString("GoodsName")%>- -<%=rs1.getString("StartProvince")%>- -<%=rs1.getString("StartCity")%>- -<%=rs1.getString("EndProvince")%>- -<%=rs1.getString("EndCity")%> 
					</a></td>
            </tr>
<%
}
}catch(Exception e)
{e.printStackTrace();}
%>
			    <tr>
              <td width="36" height="25">&nbsp;</td>
              <td width="334" align="right"><a href="goods_select.jsp">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
            </tr>
          </table>		  		  </td>
        </tr>
      </table>
      <table width="100" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="image/16.jpg" width="370" height="23"></td>
        </tr>
      </table>
      <table width="370" border="0" cellpadding="0" cellspacing="0" background="image/17.jpg">
                <%
sql="select Code,TradeMark,Brand,Style,CarLoad,TranspotStyle,UserName from tb_CarMessage order by IssueDate desc limit 0,8";
 try
{
 rs1=connection.executeQuery(sql);
while(rs1.next())
{
code=rs1.getInt("Code");
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334"><a href="car_show.jsp?id=<%=code%>"><%=rs1.getString("TradeMark")%>- -<%=rs1.getString("Brand")%> - -<%=rs1.getString("Style")%>--<%=rs1.getString("CarLoad")%>吨- -<%=rs1.getString("TranspotStyle")%></td>
        </tr>
        <%
}
}catch(Exception e)
{e.printStackTrace();}
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334" align="right"><a href="car_select.jsp">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
        </tr>
      </table>
      <table width="100" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="image/18.jpg" width="370" height="29"></td>
        </tr>
      </table>
      <table width="370" border="0" cellpadding="0" cellspacing="0" background="image/19.jpg">
                  <%
sql="select ID,EnterpriseSort,EnterpriseName,Operation,WorkArea,Address,UserName from tb_Enterprise order by IssueDate desc limit 0,7";
 try
{
 rs1=connection.executeQuery(sql);
while(rs1.next())
{
code=rs1.getInt("ID");
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334"><a href="enterprise_show.jsp?id=<%=code%>"> <%=rs1.getString("EnterpriseSort")%>- -<%=rs1.getString("EnterpriseName")%>- -<%=rs1.getString("Operation")%>- -<%=rs1.getString("WorkArea")%>
					  </a>     </td>
        </tr>
        <%
}
}catch(Exception e)
{e.printStackTrace();}
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334" align="right"><a href="enterprise_select.jsp">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
        </tr>
      </table></td><!--存放中间的代码-->
    <td valign="top" width="215" background="image/12.jpg"><jsp:include page="right.jsp" flush="true" /></td>
  </tr>
</table><jsp:include page="down.jsp" flush="true" />
<script>
	let makeDial = {

	        init : function(el) {
	          var num = 60,
	              spanStr = "",
	              len = 0,
	              i = 0,
	              rotStr = "";

	          for ( ; num-- ; ) {
	            spanStr += "<span></span>";
	          }
	          el.append(spanStr);

	          var allSpan = el.find("span");
	          len = allSpan.length;

	          for ( ; i < len ; i++) {
	            rotStr = "rotate(" + 6*i + "deg)";
	            $(allSpan[i]).css("transform",rotStr);
	          }
	          setInterval(function() {
	            makeDial.getTime();
	          },1000);
	        },

	        getTime : function() {
	          var nDate = new Date(),
	              nSec=nDate.getSeconds(),
	              nMin=nDate.getMinutes()+nSec/60,
	              nHour=(nDate.getHours()%12)+nMin/60,
	              i = 0,
	              hand = $(".hand").find("div"),
	              hanStr = "";

	            hanStr = "rotate(" + (30*nHour + 180) + "deg)";
	            $(hand[0]).css("transform",hanStr);
	            hanStr = "rotate(" + (6*nMin + 180) + "deg)";
	            $(hand[1]).css("transform",hanStr);
	            hanStr = "rotate(" + (6*nSec + 180) + "deg)";
	            $(hand[2]).css("transform",hanStr);
	        }

	      };
	      makeDial.init($(".dial"));

</script>
</body>

</html>
