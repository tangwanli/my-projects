<template>
  <div class="fod-mag-box sec">
    <!-- 菜品管理模块 -->
    <div class="fod-inf-mag">
          <h3>删除菜品</h3>
          <!-- 这个切换的时候，是切换整个fod-list中的所有内容 -->
      <div class="fod-list">
            <!-- 一组12个信息 -->
        <div class="list-group fod-mag-list">
          <div v-for="item in goods">
          <a @click="selFod($event)" state="nopitch" v-for="food in item.foods" :foodname='food.foodname' href="#" class="list-group-item goods-detail-all"><span class="fod-type">菜品分类: {{item.foodType}}</span>菜名：{{food.foodname}}<span>价格: {{food.price}}</span></a>
          </div>
        </div>
      </div>
      <!-- 三个按钮 -->
      <ul class="pager thr-btn">
          <li>当前第：<span class="fod-cur-page">{{page}}</span>页，一共<span class="fod-all-page">{{allPage}}</span>页</li>
        <li><a @click="upPage($event)" class="del-fod-up" href="#">上一页</a></li>
        <li><a @click="nextPage($event)" class="del-fod-next" href="#">下一页</a></li>
        <li><a @click="delFoods($event)" class="del-fod" href="#">删除</a></li>
      </ul>
      <!-- //三个按钮 -->
    </div>
    <!-- //评论管理模块 -->
  </div>

</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      goods: [],
      page: 1,
      allPage: 0,
      pos: 0,
      foodnameArr: []
    }
  },
  created() {
    /* axios.get('static/goods.json').then((res) => {
      this.goods = res.data.goods;
      res.data.goods.forEach((value, index, arr) => {
        this.allPage = this.allPage + value.foods.length;
      });
      this.allPage = Math.ceil(this.allPage / 10);
    }) */
    $.post('GetGoodsServlet', {}, (res) => {
      console.log('获取食物返回的信息', res);
      let data = JSON.parse(res);
      this.goods = data.goods;
      data.goods.forEach((value, index, arr) => {
        this.allPage = this.allPage + value.foods.length;
      });
      this.allPage = Math.ceil(this.allPage / 10);
    });
  },
  fodputed: {
  },
  methods: {
    nextPage(ev) {
      if (this.page < this.allPage) {
        this.pos = this.pos - 410;
        $('.fod-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
        this.page++;
        console.log('执行下一页');
      }
    },
    upPage(ev) {
      if (this.page > 1) {
        this.pos = this.pos + 410;
        $('.fod-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
        this.page--;
        console.log('执行上一页');
      }
    },
    selFod(ev) {
      let foodname = $(ev.target).attr('foodname');
      let index = this.foodnameArr.indexOf(foodname);
      console.log($(ev.target).attr('state'));
      if ($(ev.target).attr('state') === 'nopitch') {
        $(ev.target).attr('state', 'pitch').css('background', 'red');
        this.foodnameArr.push(foodname);
      } else {
        $(ev.target).attr('state', 'nopitch').css('background', '#fff');
        this.foodnameArr.splice(index, 1);
      }
    },
    delFoods(ev) {
      $.post('DelGoodsServlet', {
        foodnameArr: this.foodnameArr.join(',')
      }, (res) => {
        this.$router.push('delGoods');
        $.post('GetGoodsServlet', {}, (res) => {
          console.log('获取食物返回的信息', res);
          let data = JSON.parse(res);
          this.$nextTick(() => {
            this.goods = data.goods;
            alert('成功删除菜品');
            /* 清空数据 */
            this.pos = 0;
            $('.fod-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
            this.page = 1;
            this.foodnameArr = [];
            $('.goods-detail-all').attr('state', 'nopitch').css('background', '#fff');
          });
        });
      });
    }
  }
}

</script>

<style scoped>
  @import '../../common/global2'
</style>