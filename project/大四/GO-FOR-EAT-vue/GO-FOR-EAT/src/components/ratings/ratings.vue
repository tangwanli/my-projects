

<template lang="html">
  <div class="ratingsWrapper" ref="ratingsWrapper">
    <div class="ratings-content">
      <div class="info">
        <div class="mark">
          <div class="num">{{seller.score}}</div>
          <div class="text">综合评分</div>
          <div class="contrast">高于周边商家{{seller.rankRate}}%</div>
        </div>
        <div class="stars">
          <div class="serviceScore">
            <span class="text">服务态度</span>
            <star :size="36" :score="seller.serviceScore"></star>
            <span class="num">{{seller.serviceScore}}</span>
          </div>
          <div class="foodScore">
            <span class="text">食物评价</span>
            <star :size="36" :score="seller.foodScore"></star>
            <span class="num">{{seller.foodScore}}</span>
          </div>
          <div class="deliveryTime">
            <span class="text">送达时间</span>
            <span class="time">{{seller.deliveryTime}}分钟</span>
          </div>
        </div>
      </div>
      <div class="divider"></div>
      <div class="evaluation">
        <!-- 提交评论模块 -->
        <div class="all-comments-info">
          <div class="box">
            <form>
              <textarea class="user-rating-con user-vdo-com" placeholder="觉得店铺怎么样？给大家说说把"></textarea>
              <input @click.prevent="subRatings($event)" class="sub-com" type="submit" value="SEND">
              <div class="clearfix"> </div>
            </form>
          </div>
        </div>
        <!-- //提交评论模块 -->
        <div class="switch" @click="evelflag=!evelflag">
          <span class="text">对于店铺的评价：</span>
        </div>
        <div class="evel-list">
          <ul>
            <li class="evel" v-for="evel in evelArr">
              <div class="avatar">
                <img :src="evel.avatar" width="28" height="28">
              </div>
              <div class="content">
                <div class="user">
                  <span class="name">{{evel.username}}</span>
                  <span class="rateTime">{{evel.rateTime | time}}</span>
                </div>
                <div class="star-wrapper">
                  <star :size="24" :score="evel.score"></star>
                  <span class="deliveryTime">{{evel.deliveryTime}}分钟送达</span>
                </div>
                <div class="text">
                  {{evel.text}}
                </div>
                <div class="recommend">
                  <span class="icon icon-thumb_up" v-show="evel.recommend.length"></span>
                  <span class="dish" v-for="dish in evel.recommend">{{dish}}</span>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import star from 'components/star/star'
import BScroll from 'better-scroll'

export default {
  components: {
    star: star
  },
  data() {
    return {
      ratings: [],
      seller: {
        'deliveryTime': 38,
        'score': 4.3,
        'serviceScore': 4.1,
        'foodScore': 4.4,
        'rankRate': 69.2
      },
      classifyArr: [{
        name: '全部',
        count: 0,
        active: true
      }, {
        name: '推荐',
        count: 0,
        active: false
      }, {
        name: '吐槽',
        count: 0,
        active: false
      }],
      evelflag: true
    }
  },
  created() {
    this.initData()
  },
  computed: {
    evelArr() {
      let selectIndex = 0
      this.classifyArr.forEach((data, index) => {
        if (data.active) {
          selectIndex = index
        }
      })
      if (this.scroll) {
        this.$nextTick(() => {
          this.scroll.refresh()
        })
      }
      return selectIndex ? this.ratings.filter((data) => this.evelflag ? data.rateType === selectIndex - 1 && data.text : data.rateType === selectIndex - 1) : this.ratings.filter((data) => this.evelflag ? data.text : true)
    }
  },
  methods: {
    initData() {
      /* axios.get('static/ratings.json').then((res) => {
        this.ratings = res.data.ratings;
        // this._initClassifyArr();
        this.$nextTick(() => {
          this.scroll = new BScroll(this.$refs.ratingsWrapper, {
            click: true
          })
        })
      }); */
      $.post('GetAllRatingsServlet', {}, (res) => {
        console.log('评论模块返回的信息', res);
        let data = JSON.parse(res);
        let resRatings = data.ratings;
        let len = resRatings.length;
        /* 下面这个函数，把recommend从一个字符串变为要给数组。直接用split切开 */
        this.ratings = resRatings.map(function(value, index, arr) {
          let recommend = value.recommend;
          value.recommend = recommend.split(',');
          return value;
        });
        // this._initClassifyArr();
        this.$nextTick(() => {
          this.scroll = new BScroll(this.$refs.ratingsWrapper, {
            click: true
          })
        })
      });
    },
    _initClassifyArr() {
      this.classifyArr.forEach((data, index) => {
        if (index) {
          data.count = this.ratings.filter((temp) => temp.rateType === index - 1).length
        } else {
          data.count = this.ratings.length
        }
      })
    },
    filterEvel(item) {
      this.classifyArr.forEach((data) => {
        data.active = false
      })
      item.active = true
    },
    subRatings(ev) {
      /* axios.get('static/seller.json').then((res) => {
        this.ratings = [];
        console.log('评论获取返回数据');
      }) */
      $.post('AddRatingServlet', {
        username: this.$store.state.user.username,
        rateTime: (new Date()).getTime(),
        text: $('.user-rating-con').val()
      }, (res) => {
        /* 依然要把数据清空 */
        $('.user-rating-con').val('');
        console.log('添加评论返回的信息', res);
        this.$router.push('ratings');
        alert('添加评论成功');
      });
    }
  }
}

</script>


<style lang="stylus" scoped>
.ratingsWrapper
  position: absolute
  top: 174px
  bottom: 0
  left: 0
  width: 100%
  overflow: hidden
.ratings-content
  .info
    display flex
    .mark
      flex 0 0 138px
      margin 18px 0
      border-right 1px solid rgba(7,17,27,0.1)
      text-align center
      .num
        font-size 24px
        color rgb(255,153,0)
        line-height 28px
      .text
        padding 6px 0 8px 0
        font-size 12px
        color rgb(7,17,27)
        line-height 12px
      .contrast
        font-size 10px
        color rgb(7,17,27)
        line-height 10px
        margin-bottom 6px
    .stars
      padding 18px 24px
      .serviceScore,.foodScore,.deliveryTime
        display flex
        margin-bottom 8px
        .text
          font-size 12px
          color rgb(7,17,27)
          line-height 18px
          margin-right 12px
        .num
          font-size 12px
          line-height 18px
          color rgb(255,153,0)
          padding-left 12px
      .deliveryTime
        margin-bottom 0
        .time
          font-size 12px
          color rgb(147,153,159)
          line-height 18px
  .evaluation
    padding 18px 0
    position relative
    .classify
      padding-bottom 18px
      margin 0 18px
      border-bottom 1px solid rgba(7,17,27,0.1)
      .item
        display inline-block
        font-size 12px
        padding 8px 12px
        line-height 16px
        background rgba(0,160,220,0.2)
        color rgb(77,85,95)
        margin-right 8px
        .count
          font-size 8px
          padding-left 2px
        &.active
          color white
          background rgb(0,169,220)
        &.bad
          background rgba(77,85,93,0.2)
        &.badActive
          background #4d555d
    .switch
      font-size 12px
      width 100%
      padding 12px 0 12px 18px
      color rgb(147,153,159)
      border-bottom 1px solid rgba(7,17,27,0.1)
      .icon-check_circle
        font-size 24px
        vertical-align middle
        &.on
          color #00c850
  .evel-list
    .evel
      display flex
      padding 18px 0
      margin 0 18px
      border-bottom 1px solid rgba(7,17,27,0.1)
      .avatar
        flex 0 0 28px
        margin-right 12px
        img
          border-radius 50%
      .content
        flex 1
        .user
          font-size 10px
          color rgb(7,17,27)
          line-height 12px
          .rateTime
            position absolute
            font-weight 200
            right 18px
            color rgb(147,153,159)
        .star-wrapper
          font-size 0
          padding-top 4px
          margin-bottom 6px
          .star
            display inline-block
          .deliveryTime
            font-size 10px
            padding-left 6px
            font-weight 200
            color rgb(147,153,159)
        .text
          font-size 12px
          color rgb(7,17,27)
          line-height 18px
        .recommend
          padding-top 4px
          .icon
            font-size 12px
            color rgb(0,160,220)
            line-height 16px
          .dish
            display inline-block
            font-size 9px
            color rgb(147,153,159)
            line-height 16px
            border 1px solid rgba(7,17,27,0.1)
            padding 2px 6px
            margin-right 8px
            white-space normal
            margin-top 4px
</style>
