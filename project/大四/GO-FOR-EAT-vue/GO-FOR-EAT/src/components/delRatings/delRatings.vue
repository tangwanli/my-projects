<template>
  <div class="com-mag-box sec">
    <!-- 评论管理模块 -->
    <div class="com-inf-mag">
          <h3>删除评论</h3>
          <!-- 这个切换的时候，是切换整个com-list中的所有内容 -->
      <div class="com-list">
            <!-- 一组12个信息 -->
        <div class="list-group com-mag-list">
          <a @click="selCom($event)" state="nopitch" v-for="item in ratings" :text='item.text' href="#" class="list-group-item com-detail-all">{{item.text}}<span>write by: {{item.username}}</span></a>
        </div>
      </div>
      <!-- 三个按钮 -->
      <ul class="pager thr-btn">
          <li>当前第：<span class="com-cur-page">{{page}}</span>页，一共<span class="com-all-page">{{allPage}}</span>页</li>
        <li><a @click="upPage($event)" class="del-com-up" href="#">上一页</a></li>
        <li><a @click="nextPage($event)" class="del-com-next" href="#">下一页</a></li>
        <li><a @click="delRatings($event)" class="del-com" href="#">删除</a></li>
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
      ratings: [],
      page: 1,
      allPage: 3,
      pos: 0,
      textArr: []
    }
  },
  created() {
    /* axios.get('static/ratings.json').then((res) => {
      this.ratings = res.data.ratings;
      console.log(typeof res.data);
      this.allPage = Math.ceil(res.data.ratings.length / 10);
    }) */
    $.post('GetAllRatingsServlet', {}, (res) => {
      console.log('获取评论返回的信息', res);
      let data = JSON.parse(res);
      let resRatings = data.ratings;
      let len = resRatings.length;
      /* 下面这个函数，把recommend从一个字符串变为要给数组。直接用split切开 */
      this.ratings = resRatings.map(function(value, index, arr) {
        let recommend = value.recommend;
        value.recommend = recommend.split(',');
        return value;
      });
      this.allPage = Math.ceil(len / 10);
    });
  },
  computed: {
  },
  methods: {
    nextPage(ev) {
      if (this.page < this.allPage) {
        this.pos = this.pos - 410;
        $('.com-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
        this.page++;
        console.log('执行下一页');
      }
    },
    upPage(ev) {
      if (this.page > 1) {
        this.pos = this.pos + 410;
        $('.com-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
        this.page--;
        console.log('执行上一页');
      }
    },
    selCom(ev) {
      let text = $(ev.target).attr('text');
      let index = this.textArr.indexOf(text);
      console.log($(ev.target).attr('state'));
      if ($(ev.target).attr('state') === 'nopitch') {
        $(ev.target).attr('state', 'pitch').css('background', 'red');
        this.textArr.push(text);
      } else {
        $(ev.target).attr('state', 'nopitch').css('background', '#fff');
        this.textArr.splice(index, 1);
      }
    },
    delRatings(ev) {
      $.post('DelRatingsServlet', {
        textArr: this.textArr.join(';;;')
      }, (res) => {
        this.$router.push('delRatings');
        $.post('GetAllRatingsServlet', {}, (res) => {
          console.log('获取评论返回的信息', res);
          let data = JSON.parse(res);
          let resRatings = data.ratings;
          let len = resRatings.length;
          this.$nextTick(() => {
            this.ratings = resRatings.map(function(value, index, arr) {
              let recommend = value.recommend;
              value.recommend = recommend.split(',');
              return value;
            });
            alert('成功删除评论');
            /* 清空数据 */
            this.pos = 0;
            $('.com-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
            this.page = 1;
            this.textArr = [];
            $('.com-detail-all').attr('state', 'nopitch').css('background', '#fff');
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