var xmlhttp;


console.log("1");
getAllUsers();
function getAllUsers() {
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
	var usersURL =  "http://localhost:8080/Restaurant_ordering_system/getAllUser";

	xmlhttp.open("POST",usersURL,true);
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
					var userRole;


					table += '<tr>';
					table += '<td>用户ID</td>';
					table += '<td>用户姓名</td>';
					table += '<td>用户密码</td>';
					table += '<td>用户邮箱</td>';
					table += '<td>联系方式</td>';
					table += '<td>用户权限</td>';
					table += '<td>订单详情</td>';
					table += '<tr>'
					for (var i = 0; i < data.Users.length; i++) {
						table += '<tr>';
						table += '<td id='+ i + '>' + data.Users[i].userId + '</td>';
						table += '<td>' + data.Users[i].userName + '</td>';
						table += '<td>' + data.Users[i].userPassword + '</td>';
						table += '<td>' + data.Users[i].userEmail + '</td>';
						table += '<td>' + data.Users[i].userPhone + '</td>';
						switch (data.Users[i].userRole) {
							case 0:
								userRole = '普通用户';
								break;
								
							case 1:
								userRole = '管理员';
								break;
							
							case 2:
								userRole = '超级管理员';
								break;
								
							default:
								break;
							
						}
						table += '<td>' + userRole + '</td>';
						var btnId = "button" + data.Users[i].userId;
				 		table += '<td><a id='+ '"'+btnId+'"' +' href="#" onclick="input(this);">详情</a></td>';
						table += '</tr>';
					}

					table += '</table>';
					document.getElementById("allUsers").innerHTML = table;
    		}
    	}
    }}