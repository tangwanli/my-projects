import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
import login from 'components/login/login'
import register from 'components/register/register'
import goods from 'components/goods/goods'
import ratings from 'components/ratings/ratings'
import userinfo from 'components/userinfo/userinfo'
import seller from 'components/seller/seller'
import orderAdm from 'components/orderAdm/orderAdm'
import addGoods from 'components/addGoods/addGoods'
import modifyGoods from 'components/modifyGoods/modifyGoods'
import delGoods from 'components/delGoods/delGoods'
import delRatings from 'components/delRatings/delRatings'
import delUsers from 'components/delUsers/delUsers'
import vueTap from 'v-tap'
import fastclick from 'fastclick'
import Vuex from 'vuex'

Vue.use(vueTap)
Vue.use(VueRouter)
Vue.use(Vuex)

/* 下面这个count是商品数量 */
const store = new Vuex.Store({
  state: {
    count: 0,
    loginState: false, // 登陆状态，false为未登录
    isNotAdm: true,
    user: {
      username: 'rock',
      password: 1234
    }
  },
  // 添加的商品元素
  addCartEl: {},
  mutations: {
    increment(state) {
      state.count++
    },
    changeLoginState(state) {
      console.log('changeLoginState success');
      state.loginState = !state.loginState;
    },
    setUser(state, user) {
      console.log('setUser success');
      state.user = user;
    },
    showUserRole(state, role) {
      if (role === '0') { // 0为管理员
        state.isNotAdm = false;
      } else {
        state.isNotAdm = true;
      }
    }
  }
})
const router = new VueRouter({
  routes: [{
    path: '/login',
    component: login
  }, {
    path: '/register',
    component: register
  }, {
    path: '/goods',
    component: goods
  }, {
    path: '/ratings',
    component: ratings
  }, {
    path: '/userinfo',
    component: userinfo
  }, {
    path: '/seller',
    component: seller
  }, {
    path: '/orderAdm',
    component: orderAdm
  }, {
    path: '/addGoods',
    component: addGoods
  }, {
    path: '/modifyGoods',
    component: modifyGoods
  }, {
    path: '/delGoods',
    component: delGoods
  }, {
    path: '/delRatings',
    component: delRatings
  }, {
    path: '/delUsers',
    component: delUsers
  }],
  linkActiveClass: 'active'
})

new Vue({
  router,
  store,
  template: '<App/>',
  components: {
    App
  },
  data: {
    eventHub: new Vue()
  }
}).$mount('#app')

router.push('login')
