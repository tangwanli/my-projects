<template>
  <div id="app">
  
  
  <router-view name='man'/>
  <div class="box">
    <transition name='app' mode='out-in'>
      <router-view name='home'/>
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
      console.log($('#app').css('width'));
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
