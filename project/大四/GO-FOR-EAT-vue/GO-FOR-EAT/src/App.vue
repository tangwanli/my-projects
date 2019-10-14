

<template>
<div>
  <!-- 最上面的部分 -->
  <v-header></v-header>
  <!-- //最上面的部分 -->
  <picClock></picClock>
  <!-- 右边的一些按钮 -->
  <div class="header-top-right">
    <div class="signin">
        <!--<a href="#" v-show="!loginState" class="play-icon popup-with-zoom-anim register-btn">注册</a>-->
        <router-link to="/register" v-show="!$store.state.loginState" class="play-icon popup-with-zoom-anim register-btn">注册</router-link>
    </div>
    <div class="signin">
        <!--<a href="#" v-show="!loginState" class="play-icon popup-with-zoom-anim login-btn">登陆</a>-->
        <router-link to="/login" v-show="!$store.state.loginState" class="play-icon popup-with-zoom-anim login-btn">登陆</router-link>
    </div>
    <a href="#" v-show="$store.state.loginState" class="user-name-btn user-name play-icon popup-with-zoom-anim">{{$store.state.user.username}}</a>
    <a @click="logout()" href="#" v-show="$store.state.loginState" class="log-off-btn play-icon popup-with-zoom-anim">注销</a>
  </div>
  <!-- //右边的一些按钮 -->
  
  <!-- 中间的导航条 -->
  <div v-show="$store.state.loginState" class="tab">
      <div v-show="$store.state.isNotAdm" class="tab-item">
        <router-link to="/goods">商品</router-link>
      </div>
      <div v-show="$store.state.isNotAdm" class="tab-item">
        <router-link to="/ratings">评论</router-link>
      </div>
      <div v-show="$store.state.isNotAdm" class="tab-item">
        <router-link to="/userinfo">个人信息</router-link>
      </div>
      <!-- 前面3个为普通用户显示 -->
      <div v-show="!$store.state.isNotAdm" class="tab-item">
        <router-link to="/orderAdm">订单管理</router-link>
      </div>
      <div v-show="!$store.state.isNotAdm" class="tab-item">
        <router-link to="/addGoods">增加菜品</router-link>
      </div>
      <div v-show="!$store.state.isNotAdm" class="tab-item">
        <router-link to="/delGoods">删除菜品</router-link>
      </div>
      <div v-show="!$store.state.isNotAdm" class="tab-item">
        <router-link to="/delRatings">删除评论</router-link>
      </div>
      <div v-show="!$store.state.isNotAdm" class="tab-item">
        <router-link to="/delUsers">删除用户</router-link>
      </div>
  </div>
  <!-- //中间的导航条 -->
  <!-- 下面的主体部分 -->
  <keep-alive>
    <transition mode="out-in">
      <router-view :seller="seller"></router-view>
    </transition>
  </keep-alive>
  <!-- //下面的主体部分 -->
</div>

</template>

<script>
import header from 'components/header/header'
import picClock from 'components/picClock/picClock'
import axios from 'axios'

const ERR_OK = 0

export default {
  data() {
    return {
      seller: {}
    }
  },
  created() {
    /* axios.get('static/data.json').then((res) => {
      this.seller = res.data.seller
    }) */
  },
  components: {
    'v-header': header,
    'picClock': picClock
  },
  computed: {
  },
  methods: {
    logout() {
      this.$store.commit('changeLoginState');
      this.$store.commit('setUser', {});
      this.$router.push('login');
    }
  }
}

</script>

<style lang="stylus" rel="stylesheet/stylus">
  @import 'common/stylus/index'
  .tab
    display:flex
    width:100%
    height:40px
    line-height:40px
    border-1px(rgba(7,17,27,0.1))
    .tab-item
      flex:1
      text-align:center
      a
        display:block
        font-size:14px
        color rgb(77,85,93)
        &.active
          font-size 14px
          color rgb(240,20,20)
  .v-leave {
    opacity: 1;
  }
  .v-leave-active {
    transition: 3s;
  }
  .v-leave-to {
    opacity: 1;
    transform: translateX(-21%) rotate(180deg) scale(0);
  }
  .v-enter {
    opacity: 0;
    transform: translateX(21%) rotate(180deg) scale(0);
  }
  .v-enter-active {
    transition: 3s;
  }
  .v-enter-to {
    opacity: 1;
    transform: translateX(0) rotate(0) scale(1);
  }
</style>