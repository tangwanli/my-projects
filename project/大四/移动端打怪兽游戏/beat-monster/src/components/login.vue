<template>
  <div class="login">
    <div class="user-login">
      <label>username: </label><input type="text" v-model='username' placeholder="your username"><br>
      <label>password: </label><input type="password" v-model='password' placeholder="your password">
    </div>
     <div class='btn' @click='login'><router-link to='/' event='click'>GO GO GO!</router-link></div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login(ev) {
      localStorage.setItem('username',this.username);
      localStorage.setItem('password',this.password);
      this.$store.commit('updataLogin');
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
</style>
