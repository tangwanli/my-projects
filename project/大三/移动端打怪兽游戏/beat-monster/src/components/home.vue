<template>
  <div class="home">
    <router-link :to='path' event='click' tag='div' class='start'>{{msg}}</router-link>

    <ul class='pic'>
      <li v-for='item in pic'><img :src="item.path"></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'home',
  data () {
    return {
      msg: '开始游戏',
      path: '/login',
      pic: [{path: '../../static/monster1.png'},{path: '../../static/monster2.png'},{path: '../../static/monster3.png'},{path: '../../static/monster0.png'}]
    }
  },
  created() {
    console.log(this.$store.state.user.login);
    if (!this.$store.state.user.login) {
      this.path = '/game';
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
</style>
