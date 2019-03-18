
var currentUserId;

/*function input(btn) {
  	var currentButtonId = btn.getAttribute("id");
 	currentUserId = currentButtonId.substring(6);
  	var flt = document.getElementById("getOrderDetailDiv");
  	console.log(flt,'5555');
	btn.onclick = function(){
		//按钮点击后显示悬浮窗属性
		event.cancelBubble = true;
		var x = "120px";
		var y = "60px";
		flt.style.top = y;
		flt.style.left = x;
		flt.style.display = 'block';
		flt.style.position = "absolute";
		flt.style.width = "400";
		flt.style.height = "500";
		flt.style.bgColor = "#000000";
	}
	getOrderByUserId(currentUserId);


	document.onclick = function(){
	console.log(flt,'5555');
	flt.style.display = 'none';
	}
}
*/
/*btn.onclick = function(){
	  //currentButtonId = dom.getAttribute("id");
	  //currentUserId = currentButtonId.substring(7);
event.cancelBubble = true;
	var x = "120px";
	var y = "60px";
	flt.style.top = y;
	flt.style.left = x;
	flt.style.display = 'block';
	flt.style.position = "absolute";
	flt.style.width = "400";
	flt.style.height = "500";
	
}
*/

function input(btn) {
  	var currentButtonId = btn.getAttribute("id");
  	
 	currentUserId = currentButtonId.substring(6);

 	getOrderByUserId(currentUserId);
}

function getOrderByUserId(id) {

	if (window.XMLHttpRequest)
 	{// code for IE7+, Firefox, Chrome, Opera, Safari
  		xmlhttp=new XMLHttpRequest();
  	}
	

	//var orderURL = "http://localhost:8080/Restaurant_ordering_system/getorderByuserId";
   //var obj = {
    ///		id
    //};
 	//alert(obj);
	console.log('xiankankan',id);
 	console.log(id);
    $.ajax({
    	url: "http://localhost:8080/Restaurant_ordering_system/getorderByuserId",
    	method: 'post',
    	data: {
    		userId: id
    	},
    	dataType: 'json',
    	success(data1) {
    		var data = data1.data;
			let table = '<table width="1900px">';
			console.log(data.Orders);
			var orderStatus;


			table += '<tr>';
			table += '<td>订单ID</td>';
			table += '<td>用户ID</td>';
			table += '<td>订单详情</td>';
			table += '<td>订单金额</td>';
			table += '<td>下单时间</td>';
			table += '<td>完成时间</td>';
			table += '<td>订单状态</td>';
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
				table += '</tr>';
			}

			table += '</table>';
			document.getElementById("allUsers").innerHTML = table;
    	}
    });
	//xmlhttp.open("POST",orderURL,true);
	//xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	console.log('?????',id);
	//xmlhttp.send({"userId": id});
	//xmlhttp.onreadystatechange=function() {
  	//if (xmlhttp.readyState==4 && xmlhttp.status==200)
	//{
	//	var msgJSON = xmlhttp.responseText;
	//	var obj = JSON.parse(msgJSON);
	//	if (obj.code == 200) {
	//		alert("请求失败，请检查请求格式或更改请求内容后再试");
	//	}
	//	else {
		/*	var data = obj.data;
			let table = '<table>';
			console.log(data.Orders);
			var orderStatus;


			table += '<tr>';
			table += '<td>订单ID</td>';
			table += '<td>用户ID</td>';
			table += '<td>订单详情</td>';
			table += '<td>订单金额</td>';
			table += '<td>下单时间</td>';
			table += '<td>完成时间</td>';
			table += '<td>订单状态</td>';
			table += '<tr>'
			for (var i = 0; i < data.Orders.length; i++) {
				table += '<tr>';
				table += '<td>' + data.Orders[i].orderId + '</td>';
				table += '<td id='+ i + '>' + data.Orders[i].userId + '</td>';
				table += '<td>' + data.Orders[i].orderFoodPrice + '</td>';
				table += '<td>' + data.Orders[i].orderFoodPrice + '</td>';
				table += '<td>' + data.Orders[i].orderTime + '</td>';
				table += '<td>' + data.Orders[i].orderFinishtime + '</td>';
				if (data.Orders[i].orderStatus == 1) {
					orderStatus = "完成";
				}
				else
					orderStatus = "未完成";
				table += '<td>' + orderStatus + '</td>';
				table += '</tr>';
			}

			table += '</table>';
			document.getElementById("allOrder").innerHTML = table;
	}
	
   }
	}*/
}
