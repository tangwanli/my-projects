

<template>
<div>
    <div class="pop-up2">
      <h1>register</h1>
      <div id="register2">
      <!-- 这里密码两次输入不相同需要提示，用户名在数据库已经存在也要提示，email格式不正确也要提示 -->
          <section class="base-box2">
          <input @change="testUser($event)" class="reg-user-name" type="text" placeholder="请输入用户名："><em v-show="isUserExist" class="user-wrg">*用户名已存在</em>
          <br>
          <input class="reg-user-pas" type="password" placeholder="请输入密码：">
          <br>
          <input @change="testPas($event)" class="reg-confirm-pas" type="password" placeholder="请再次输入密码："><em v-show="isPasNotIdentical" class="psd-wrg">*两次密码输入不相同</em>
          <br>
          <input @change="testEmail($event)" class="email-inp reg-email" type="email" placeholder="请输入email："><em v-show="isEmailNotcor" class="email-wrg">*email格式不正确</em>
          <br>
          <!-- <input class="reg-sex" type="text" placeholder="请输入性别：">
          <br> -->
          <input class="reg-location" type="text" placeholder="请输入所在地：">
        </section>
      <section class="sex-box2 dropdown">
        <button class="reg-sex reg-first-btn btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">man</button>
        <ul class="sec-drop-box2 dropdown-menu" aria-labelledby="dropdownMenu1">
          <li><a href="#" @click="changeSex($event)">woman</a></li>
        </ul>
      </section>
      </div>
      <span class="register-now register register2" @click="register()">
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
      isUserExist: false,
      isPasNotIdentical: false,
      isEmailNotcor: false
    }
  },
  methods: {
    register(ev) {
      $.post('RegisterServlet', {
        username: $('.reg-user-name').val(),
        password: $('.reg-user-pas').val(),
        email: $('.reg-email').val(),
        location: $('.reg-location').val(),
        sex: $('.reg-sex').text()
      }, (res) => {
        /* 清空信息 */
        $('.reg-user-name').val('');
        $('.reg-user-pas').val('');
        $('.reg-confirm-pas').val('');
        $('.reg-email').val('');
        $('.reg-location').val('');
        $('.reg-sex').text('man');
        console.log('注册返回的信息是', res);
        alert('注册成功');
        this.$router.push('login');
      });
      console.log(ev);
    },
    changeSex(ev) {
      if ($(ev.target).text() === 'woman') {
        $(ev.target).text('man');
        $('.reg-first-btn').text('woman');
      } else {
        $(ev.target).text('woman');
        $('.reg-first-btn').text('man');
      }
    },
    testUser(ev) {
      // 获取用户名，如果用于名已存在，改变isUserExist
      axios.get('static/user.json').then((res) => {});
      $.post('LoginServlet', {
        username: $('.reg-user-name').val(),
        password: ''
      }, (res) => {
        let data = JSON.parse(res);
        if (data.isReturn === 'false') {
          this.isUserExist = true;
        } else {
          this.isUserExist = false;
        }
      });
    },
    testPas(ev) {
      if ($(ev.target).val() === $('.reg-user-pas').val()) {
        this.$nextTick(() => {
          this.isPasNotIdentical = false;
        });
      } else {
        this.$nextTick(() => {
          this.isPasNotIdentical = true;
        });
      }
    },
    testEmail(ev) {
      let email = $(ev.target).val();
      if (/.+@\w.+\.com$/.test(email)) {
        this.$nextTick(() => {
          this.isEmailNotcor = false;
        });
      } else {
        this.$nextTick(() => {
          this.isEmailNotcor = true;
        });
      }
    }
  },
  computed: {
  }
}

</script>

<style scoped>
@import '../../common/global2'
</style>