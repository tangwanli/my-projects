

<template>
<div class="clock">
    <div class="pic-clock">
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
  mounted() {
    console.log('进入页面');
    clock.init($('.pic-clock'));
    console.log('进入页面2');
  },
  methods: {
  },
  computed: {
  }
}

</script>

<style scoped>
@import '../../common/global2'
</style>