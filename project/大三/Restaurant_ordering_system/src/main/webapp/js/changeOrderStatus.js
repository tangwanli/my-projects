function input(btn) {
  	
 	var currentOrderId = btn.getAttribute("id");

 	getOrderByUserId(currentOrderId);
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
    	url: "http://localhost:8080/Restaurant_ordering_system/finishOrder",
    	method: 'post',
    	data: {
    		orderId: id
    	},
    	dataType: 'json',
    	success(data1) {
    		if(data1.code == 100) {
    			alert("订单状态修改成功");
    			location.href = "http://localhost:8080/Restaurant_ordering_system/orderList.jsp";
    		}
    	}
    });
}