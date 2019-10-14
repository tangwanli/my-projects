

<template>
  <!-- 用户信息模块 -->
  <div class="user2 sec">
    <div class="user-inf">
        <!-- 头像模块 -->
      <div class="user-pic">
            <label for="user-pho">
        <img class='u-user-pic' width="200px" height="200px" :src="user.avatar">
        </label>
        <input @change="changeUserPic($event)" id="user-pho" type="file">
        <span @click="subChangeInfo($event)" class="change-inf">修改信息</span>
      </div>
      <!-- //头像模块 -->
      <!-- 个人信息模块 -->
      <div class="user-basi-inf">
        <div id="register2" class="user-box">
            <h3>个人信息</h3>
            <section class="base-box">
            <label>username: </label><input class="u-user-name" type="text" placeholder="请输入用户名：" :value="user.username">
            <br>
            <label>email: </label><input @change="testEmail($event)" class="email-inp u-user-email" type="email" placeholder="请输入email：" :value="user.email"><em v-show="isEmailNotcor" class="per-email-wrg">*格式出错</em>
    <!--        <br>
            <label>sex: </label><input class="u-user-sex" type="text" placeholder="请输入性别："> -->
            <br>
            <label>City: </label><input class="u-user-loc" type="text" placeholder="请输入所在地：" :value="user.location">
          </section>
        <section class="sex-box dropdown">
          <button class="u-user-sex userinfo-first-btn btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" @click="initSex($event)">{{user.sex}}</button>
          <ul class="sec-drop-box dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a @click="changeSex($event)" href="#">woman</a></li>
          </ul>
        </section>
        </div>
      </div>
      <!-- //个人信息模块 -->

      <!-- 密码修改模块 -->
      <div class="change-psd">
        <div id="register2" class="psd-box">
            <h3>修改密码</h3>
          <input @change="testPas($event)" class="u-user-pas" type="password" placeholder="请输入密码："><span v-show="isPasNotCur" class="old-psd-wrg">*密码错误</span>
          <br>
          <input class="u-new-pas" type="password" placeholder="请输入新密码：">
          <br>
          <input @change="testPasIdent($event)" class="u-new-pas2" type="password" placeholder="请输入再次输入新密码："><span v-show="isPasNotIdentical" class="psd-wrg2">*输入不一致</span>
        </div>
      </div>
      <!-- //密码修改模块 -->
    </div>
  </div>
    <!-- //用户信息模块 -->

</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      user: {},
      isEmailNotcor: false,
      isPasNotCur: false, // 默认值只是让他不显示而已
      isPasNotIdentical: false
    }
  },
  created() {
    // create之后就获取用户信息
    /* axios.get('static/user.json').then((res) => {
      this.user = res.data.user
    }) */
    $.post('GetUserInfoServlet', {
      username: this.$store.state.user.username
    }, (res) => {
      console.log('用户信息模块返回的信息', res);
      let data = JSON.parse(res);
      this.user = data.user;
    });
    console.log('这里重新刷新了');
  },
  computed: {
  },
  methods: {
    changeSex(ev) {
      if ($(ev.target).text() === 'woman') {
        $(ev.target).text('man');
        $('.userinfo-first-btn').text('woman');
      } else {
        $(ev.target).text('woman');
        $('.userinfo-first-btn').text('man');
      }
    },
    initSex(ev) {
      if ($(ev.target).text() === 'woman') {
        $(ev.target).parent().find('li').find('a').text('man');
      } else {
        $(ev.target).parent().find('li').find('a').text('woman');
      }
    },
    changeUserPic(ev) {
      let files = ev.target.files;
      let reader = new FileReader();
      reader.readAsDataURL(files[0]);
      reader.onload = function(event) {
        $('.u-user-pic').attr('src', event.target.result);
        console.log(event.target.result);
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
    },
    testPas(ev) {
      // 这里就是验证密码是否正确
      if ($(ev.target).val() === this.$store.state.user.password) {
        this.isPasNotCur = false;
      } else {
        this.isPasNotCur = true;
      }
    },
    testPasIdent(ev) {
      if ($(ev.target).val() === $('.u-new-pas').val()) {
        this.isPasNotIdentical = false;
      } else {
        this.isPasNotIdentical = true;
      }
    },
    subChangeInfo(ev) {
      /* 先要判断用户是否修改了密码 */
      let password = '';
      if ($('.u-new-pas2') === '') {
        password = this.user.password;
      } else {
        password = $('.u-new-pas2').val();
      }
      $.post('SetUserInfoServlet', {
        username: this.$store.state.user.username,
        avatar: $('.u-user-pic').attr('src'),
        password: password,
        email: $('.u-user-email').val(),
        location: $('.u-user-loc').val(),
        sex: $('.u-user-sex').text()
      }, (res) => {
        $('.u-user-pas').val('');
        $('.u-new-pas').val('');
        $('.u-new-pas2').val('');
        alert('修改成功');
      });
    }
  }
}

</script>

<style scoped>
@import '../../common/global2'
</style>