<template>
  <div class="user-mag-box sec">
    <!-- 用户管理模块 -->
    <div class="user-inf-mag">
          <h3>删除用户</h3>
          <!-- 这个切换的时候，是切换整个user-list中的所有内容 -->
      <div class="user-list">
            <!-- 一组12个信息 -->
        <div class="list-group user-mag-list">
          <a @click="selUser($event)" state="nopitch" v-for="(item,index) in users" :username='item' href="#" class="list-group-item users-detail-all">{{item}}</a>
        </div>
      </div>
      <!-- 三个按钮 -->
      <ul class="pager thr-btn">
          <li>当前第：<span class="user-cur-page">{{page}}</span>页，一共<span class="user-all-page">{{allPage}}</span>页</li>
        <li><a @click="upPage($event)" class="del-user-up" href="#">上一页</a></li>
        <li><a @click="nextPage($event)" class="del-user-next" href="#">下一页</a></li>
        <li><a @click="delUsers($event)" class="del-user" href="#">删除</a></li>
      </ul>
      <!-- //三个按钮 -->
    </div>
    <!-- //用户管理模块 -->
  </div>

</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      users: [],
      page: 1,
      allPage: 3,
      pos: 0,
      usernameArr: []
    }
  },
  created() {
    /* +axios.get('static/allUsers.json').then((res) => {
      this.users = res.data.users;
      this.allPage = Math.ceil(res.data.users.length / 10);
    }) */
    $.post('GetAllUsersServlet', {}, (res) => {
      console.log('获取用户返回的信息', res);
      let data = JSON.parse(res);
      this.users = data.users;
      this.allPage = Math.ceil(data.users.length / 10);
    });
  },
  userputed: {
  },
  methods: {
    nextPage(ev) {
      if (this.page < this.allPage) {
        this.pos = this.pos - 410;
        $('.user-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
        this.page++;
        console.log('执行下一页');
      }
    },
    upPage(ev) {
      if (this.page > 1) {
        this.pos = this.pos + 410;
        $('.user-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
        this.page--;
        console.log('执行上一页');
      }
    },
    selUser(ev) {
      let username = $(ev.target).attr('username');
      let index = this.usernameArr.indexOf(username);
      console.log($(ev.target).attr('state'));
      if ($(ev.target).attr('state') === 'nopitch') {
        $(ev.target).attr('state', 'pitch').css('background', 'red');
        this.usernameArr.push(username);
      } else {
        $(ev.target).attr('state', 'nopitch').css('background', '#fff');
        this.usernameArr.splice(index, 1);
      }
    },
    delUsers(ev) {
      $.post('DelUsersServlet', {
        usernameArr: this.usernameArr.join(',')
      }, (res) => {
        this.$router.push('delUsers');
        $.post('GetAllUsersServlet', {}, (res) => {
          console.log('获取用户返回的信息', res);
          let data = JSON.parse(res);
          this.$nextTick(() => {
            this.users = data.users;
            alert('成功删除用户');
            /* 清空数据 */
            this.pos = 0;
            $('.user-mag-list').css('transform', 'translateY(' + this.pos + 'px)');
            this.page = 1;
            this.usernameArr = [];
            $('.users-detail-all').attr('state', 'nopitch').css('background', '#fff');
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