

<template>
<div>
    <div class="pop-up1">
      <h1>Login</h1>
      <div id="login2">
        <input class="loginusername" type="text" placeholder="请输入用户名：">
        <br>
        <input class="loginpassword" type="password" placeholder="请输入密码：">
        <br>
        <!-- 判断checkbox是否被选中，是看它的checked属性，默认为false -->
        <label class="checkbox-lab">是否保存用户名</label><input class="checkbox" type="checkbox" checked>
      </div>
      <span class="login" @click="login($event)" style="position: relative;">
        login
      </span>
      <span class="register register1" @click="goRegister($event)" style="position: relative;">
        register
      </span>
    </div>
</div>

</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
    }
  },
  methods: {
    login(ev) {
      console.log('进入login', $(ev.target));
      // 登陆成功之后，改变登陆状态，而且改变用户信息
      /* static/user.json */
      $.post('LoginServlet', {
        username: $('.loginusername').val(),
        password: $('.loginpassword').val()
      }, (res) => {
        console.log('登陆返回的信息是', res);
        let data = JSON.parse(res);
        let user = {
          username: $('.loginusername').val(),
          password: $('.loginpassword').val()
        };
        if (data.isReturn === 'true') {
          console.log('成功获取登陆返回结果：', res);
          this.$store.commit('changeLoginState');
          this.$store.commit('setUser', user);
          this.$store.commit('showUserRole', data.role);
          if (data.role === '1') {
            this.$router.push('goods');
          } else {
            this.$router.push('orderAdm');
          }
        } else {
          elShake.init($(ev.target));
          elShake.shake($(ev.target), 'left');
        }
        /* 登陆之后先把登陆信息清空 */
        $('.loginusername').val('');
        $('.loginpassword').val('');
      });
    },
    goRegister(ev) {
      this.$router.push('register');
    }
  },
  computed: {
  }
}

</script>

<style scoped>
@import '../../common/global2'
</style>