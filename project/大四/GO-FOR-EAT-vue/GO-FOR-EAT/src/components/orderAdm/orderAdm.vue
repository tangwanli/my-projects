<template>
  <div class="order-mag-box sec">
    <!-- 订单管理模块 -->
    <div class="order-inf-mag">
          <h3>订单管理</h3>
          <!-- 这个切换的时候，是切换整个order-list中的所有内容 -->
      <div class="order-list">
            <!-- 一组12个信息 -->
        <div class="list-group order-mag-list">
          <div v-for="item in orders" class="list-group-item pos-loc">
            <div  @click="selOrder($event)" state="nopitch" orderid='1'><span>订单号： {{item.orderId}}</span>{{item.username}}</div>
            <section class="state-btn dropdown">
              <button @click="initState($event)" class="reg-first-btn btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">{{item.orderState}}</button>
              <ul class="state-btn2 dropdown-menu" aria-labelledby="dropdownMenu1">
                <li :orderid='item.orderId' @click="changeState($event)"><a href="#"></a></li>
              </ul>
            </section>
            <div class="list-group all-food">
              <a v-for="food in item.foods" href="#" class="list-group-item">{{food.foodname}}<span>${{food.price}} * {{food.count}}</span></a>
            </div>
          </div>
        </div>
      </div>
      <!-- 三个按钮 -->
      <ul class="pager thr-btn">
        <li><a @click="subStateChange($event)" class="cofirm-order" href="#">确定</a></li>
      </ul>
      <!-- //三个按钮 -->
    </div>
    <!-- //订单管理模块 -->
  </div>

</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      orders: [],
      stateArr: []
    }
  },
  created() {
    /* axios.get('static/orders.json').then((res) => {
      this.orders = res.data.orders;
    }) */
    $.post('GetAllOrdersServlet', {}, (res) => {
      console.log('获取订单模块返回的信息', res);
      let data = JSON.parse(res);
      let resOrders = data.orders;
      let len = resOrders.length;
      /* 下面这个函数，把recommend从一个字符串变为要给数组。直接用split切开 */
      this.orders = resOrders.map(function(value, index, arr) {
        let foods = value.foods.split(';');
        value.foods = foods.map(function(value2, index2, arr2) {
          let tempObj = {};
          tempObj.foodname = value2.split(',')[0];
          tempObj.count = +value2.split(',')[1];
          tempObj.price = +value2.split(',')[2];
          return tempObj;
        });
        return value;
      });
    });
  },
  orderputed: {
  },
  methods: {
    selOrder(ev) {
      console.log(ev.target);
      if ($(ev.target).attr('state') === 'nopitch') {
        $(ev.target).attr('state', 'pitch').css('background', 'red');
        $(ev.target).parent().prevAll().hide(500);
        $(ev.target).parent().find('.all-food').show(500);
      } else {
        $(ev.target).attr('state', 'nopitch').css('background', '#fff');
        $(ev.target).parent().prevAll().show(500);
        $(ev.target).parent().find('.all-food').hide(500);
      }
    },
    initState(ev) {
      if ($(ev.target).text() === '未完成') {
        console.log('enter1');
        $(ev.target).parent().find('li').text('完成');
      } else {
        console.log('enter2');
        $(ev.target).parent().find('li').text('未完成');
      }
    },
    changeState(ev) {
        /* 切换到完成状态的时候，把orderid装进数组；切换为未完成的时候，把orderid移除 */
      let orderid = $(ev.target).attr('orderid');
      let index = this.stateArr.indexOf(orderid);
      console.log('改变状态这里stateArr为', this.stateArr);
      if ($(ev.target).text() === '未完成') {
        $(ev.target).text('完成');
        $(ev.target).parent().parent().find('button').text('未完成');
        this.stateArr.splice(index, 1);
      } else {
        $(ev.target).text('未完成');
        $(ev.target).parent().parent().find('button').text('完成');
        this.stateArr.push(orderid);
      }
    },
    subStateChange(ev) {
      console.log('输出的参数stateArr为', this.stateArr);
      $.post('setOrderState', {
        orderIdArr: this.stateArr.join(',')
      }, (res) => {
        alert('订单状态修改成功');
        this.$router.push('orderAdm');
      });
    }
  }
}

</script>

<style scoped>
  @import '../../common/global2'
</style>