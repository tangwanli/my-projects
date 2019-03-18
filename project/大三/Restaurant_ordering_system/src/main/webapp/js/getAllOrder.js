var xmlhttp;


console.log("1");
getAllOrder();
function getAllOrder() {
	console.log("2");
	if (window.XMLHttpRequest)
 	{// code for IE7+, Firefox, Chrome, Opera, Safari
  		xmlhttp=new XMLHttpRequest();
  	}
	else
  	{// code for IE6, IE5
  		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  	}
	console.log("3");
	var orderURL =  "http://localhost:8080/Restaurant_ordering_system/getAllorder";

	xmlhttp.open("POST",orderURL,true);
	xmlhttp.send();
	console.log("4");
	xmlhttp.onreadystatechange=function()
  	{
  		if (xmlhttp.readyState==4 && xmlhttp.status==200)
    	{
  			console.log("5");
    		var msgJSON = xmlhttp.responseText;
    		var obj = JSON.parse(msgJSON);
    		if (obj.code == 200) {
    			alert("请求失败，请检查请求格式或更改请求内容后再试");
    		}
    		else {
    			var data = obj.data;
					let table = '<table width="1900px" cellspacing="0" cellpadding="0">';
					console.log(data.Orders);
					var orderStatus;


					table += '<tr>';
					table += '<td>订单ID</td>';
					table += '<td>用户ID</td>';
					table += '<td>订单详情</td>';
					table += '<td>订单金额</td>';
					table += '<td>下单时间</td>';
					table += '<td>完成时间</td>';
					table += '<td>当前订单状态</td>';
					table += '<td>修改订单状态</td>'
					table += '<td>操作</td>';
					table += '<tr>'
					for (var i = 0; i < data.Orders.length; i++) {
						table += '<tr>';
						table += '<td>' + data.Orders[i].orderId + '</td>';
						table += '<td id='+ i + '>' + data.Orders[i].userId + '</td>';
						table += '<td>' + data.Orders[i].orderFoodId + '</td>';
						table += '<td>' + data.Orders[i].orderFoodPrice + '</td>';
						table += '<td>' + new Date(data.Orders[i].orderTime).toLocaleDateString().replace(/\//g, "-") +
						" " + new Date(data.Orders[i].orderTime).toTimeString().substr(0, 8) + '</td>';
						if (data.Orders[i].orderStatus == 1) {
							orderStatus = "完成";
							table += '<td>' + new Date(data.Orders[i].oderFinishtime).toLocaleDateString().replace(/\//g, "-") +
							" " + new Date(data.Orders[i].oderFinishtime).toTimeString().substr(0, 8) + '</td>';
						}
						else
							{
								orderStatus = "未完成";
								table += '<td>(null)</td>';
							}

						table += '<td>' + orderStatus + '</td>';
						table += '<td><select><option value='+'完成'+'>完成</option><option value='+'未完成'+'>未完成</option></select></td>';
						table += '<td><a id=' +'"'+data.Orders[i].orderId+'"'+' href="#" onclick=input(this)>提交</a></td>';
						table += '</tr>';
					}

					table += '</table>';
					document.getElementById("allOrder").innerHTML = table;
    		}
    	}
    }}
