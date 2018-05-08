<template>
  <div id="app">
    <img src="./assets/logo.png">
    <ul>
    <router-link to="/hello" tag='li'><a>link to hello</a></router-link>
    <router-link to="/HelloWorld" tag='li'><a>link to HelloWord</a></router-link>
    </ul>
    <transition name='my' mode='out-in'>
      <router-view/>
    </transition>
  </div>
</template>

<script>
import HelloWorld from '@/components/HelloWorld'
export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
/*.v-enter {
  opacity: 0;
}
.v-enter-to {
  opacity: 1;
}
.v-enter-active {
  transition: 1s;
}
.v-leave {
  opacity: 1;
}
.v-leave-to {
  opacity: 0;
}
.v-leave-active {
  transition: 2s;
}*/

.my-enter {
  transform: translateX(100%);
}
.my-enter-to {
  transform: translateX(0);
}
.my-enter-active {
  transition: 1s;
}
.my-leave {
  transform: translateX(0);
}
.my-leave-to {
  transform: translateX(-100%);
}
.my-leave-active {
  transition: 1s;
}
</style>
