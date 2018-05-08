<template>
  <div id="app">
  <div class="snow"></div>
  <p class='msg'>{{msg}}</p>
  <ul class='user'>
    <li class='user-bg'></li>
    <li v-if='$store.state.user.login'><router-link to='/login' event='click'><p>请登录</p></router-link></li>
    <li v-else='$store.state.user.login'>{{$store.state.user.username}}</li>
  </ul>

  <div class="box">
    <transition name='app' mode='out-in'>
      <router-view/>
    </transition>
  </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  created() {
      window.onload = function() {
        let html = document.getElementsByTagName('html')[0],
            width = document.documentElement.clientWidth;
                html.style.fontSize = width/16 + 'px';
      }
  },
  data() {
    return {
      msg: 'BEAT MONSTER! Let\'s GO!'
    }
  }
}
</script>

<style>
</style>
