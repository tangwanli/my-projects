

(function() {
  validateUser();
     document.querySelector('.login a').onclick = function() {
    loginJump();
   };
      let addNum = localStorage.getItem('addNum').split(','),
          aimg = localStorage.getItem('aimg').split(','),
          foodName = localStorage.getItem('foodName').split(','),
          praiseNum = localStorage.getItem('praiseNum').split(','),
          moneyPri = localStorage.getItem('moneyPri').split(',');
	console.log(addNum,aimg,foodName,praiseNum,moneyPri);
     showFood(addNum,aimg,foodName,praiseNum,moneyPri);
	function showFood(addNum,aimg,foodName,praiseNum,moneyPri) {
		for (let i=0;i<addNum.length;i++) {
			showAllFood(addNum[i],aimg[i],foodName[i],praiseNum[i],moneyPri[i]);
		}		
	}

	function showAllFood(addNum,aimg,foodName,praiseNum,moneyPri) {
		let food = `<li class='food-det'>
         <img class='aimg' src=${aimg} width="180px" height="150px">
         <div class="food-name">${foodName}</div>
         <div class="praise"><span>赞 </span><span class='praise-num'>${praiseNum}</span></div>
         <div class="food-pri"><span>$ </span><span class='money-pri'>${moneyPri}</span></div>
          <div data-id='${addNum}' class="add-btn">+</div>
        </li>`;
        $('.food-list').append(food);
        showPri();
	}

  let submit = document.querySelector('.submit');
  submit.onclick = function() {
    subOrder();
    submit.onclick = null;
    console.log('?????');
  }
  
  function showPri() {
    let allPri = document.getElementsByClassName('all-money')[0],
        siglePri = document.getElementsByClassName('money-pri'),
        count = 0;
    for (let i=0; i<siglePri.length; i++) {
      count = count + parseInt(siglePri[i].innerText);
    }
    allPri.innerText = count;
  }

  function validateUser() {
    let userName = localStorage.getItem('userName');
    if (userName) {
      $('.login a').text(userName);
    }
  }

    function loginJump() {
    let state = document.querySelector('.login a').innerText;
    if (state === '登录') {
      window.location.href = 'login.html';
    }
  }

  function subOrder() {
    $.ajax({
      url: 'addOrder',
      type: 'post',
      data: {
        userId: parseInt(localStorage.getItem('userID')),
        orderFoodId: addNum.join(','),
        orderFoodPrice: moneyPri.join(',')
      },
      dataType: 'json',
      success(data,status,xhr) {
        alert('下单成功，请耐心等待服务员呼叫');
        window.location.href= 'index.html';
      }
    });

  }

})();