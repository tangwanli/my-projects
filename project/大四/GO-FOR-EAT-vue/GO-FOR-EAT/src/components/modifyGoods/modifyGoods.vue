<template>
  <div class="food-mag-box sec">
    <!-- 修改菜品管理模块 -->
    <div class="food-inf-mag">
          <h3>修改菜品</h3>
          <!-- 这个切换的时候，是切换整个food-list中的所有内容 -->
      <div class="food-list">
            <!-- 一组12个信息 -->
        <div class="list-group food-mag-list">
          <!-- 每个大类的菜 -->
          <div v-for="foodType in goods" class="list-group-item pos-loc">
            <div @click="selfood($event)" state="nopitch" foodid='1'>菜品种类： {{foodType.name}}</div>
            <section class="state-btn dropdown">
              <button @click="initState($event)" class="reg-first-btn btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">未修改</button>
              <ul class="state-btn2 dropdown-menu" aria-labelledby="dropdownMenu1">
                <li @click="changeState($event)"><a href="#"></a></li>
              </ul>
            </section>
            <!-- 每个类的菜，点开为菜的那个修改信息 -->
            <div class="list-group all-food2">
              <div v-for="food in foodType.foods" class="list-group-item">
                <!-- 菜品基础信息 -->
                <div class="food-bas-info">{{food.name}}<span>${{food.price}} * {{food.count}}</span></div>
                <!-- //菜品基础信息 -->

                <!-- 菜品详细信息 -->
                <div class="food-detail-info">
                    <ul>
                      <li class="food-icon">
                        <div class="food-pic">
                          <label for="food-pho">
                          <img class='u-food-pic' width="200px" height="200px" src="static/img/c2.jpg">
                          </label>
                          <input @change="changefoodPic($event)" id="food-pho" type="file">
                          <span class="change-inf">修改信息</span>
                        </div>
                      </li>
                      <li class=""></li>
                      <li class=""></li>
                      <li class=""></li>
                      <li class=""></li>
                    </ul>

                    <ul class="pager">
                      <li><a class="cofirm-food" href="#">确定</a></li>
                    </ul>
                </div>
                <!-- //菜品详细信息 -->
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 三个按钮 -->
      <ul class="pager thr-btn">
        <li><a class="cofirm-food" href="#">确定</a></li>
      </ul>
      <!-- //三个按钮 -->
    </div>
    <!-- //修改菜品模块 -->
  </div>

</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      goods: []
    }
  },
  created() {
    axios.get('static/goods.json').then((res) => {
      this.goods = res.data.goods;
    })
  },
  foodputed: {
  },
  methods: {
    selfood(ev) {
      console.log(ev.target);
      if ($(ev.target).attr('state') === 'nopitch') {
        $(ev.target).attr('state', 'pitch').css('background', 'red');
        $(ev.target).parent().prevAll().hide(500);
        $(ev.target).parent().find('.all-food2').show(500);
      } else {
        $(ev.target).attr('state', 'nopitch').css('background', '#fff');
        $(ev.target).parent().prevAll().show(500);
        $(ev.target).parent().find('.all-food2').hide(500);
      }
    },
    initState(ev) {
      if ($(ev.target).text() === '未修改') {
        console.log('enter1');
        $(ev.target).parent().find('li').text('提交修改');
      } else {
        console.log('enter2');
        $(ev.target).parent().find('li').text('未修改');
      }
    },
    changeState(ev) {
      if ($(ev.target).text() === '未修改') {
        $(ev.target).text('提交修改');
        $(ev.target).parent().parent().find('button').text('未修改');
      } else {
        $(ev.target).text('未修改');
        $(ev.target).parent().parent().find('button').text('提交修改');
      }
    },
    changeFoodPic(ev) {
      let files = ev.target.files;
      let reader = new FileReader();
      reader.readAsDataURL(files[0]);
      reader.onload = function(event) {
        $('.u-food-pic').attr('src', event.target.result);
      }
    }
  }
}

</script>

<style scoped>
  @import '../../common/global2'
</style>