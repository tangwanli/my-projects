<template>
    <div>
    <div>this is my first vue-cli auto project.{{count}}{{cCount}}</div>
    <button @click='changeCount'>{{$store.state.count}}</button>
    <ul>
    	<router-link to='/hello/girl' tag='li'><a>girl</a></router-link>
    	<router-link to='/hello/friend' tag='li'><a>friend</a></router-link>
    	<router-link to='/hello/boy' tag='li'><a>boy</a></router-link>
    </ul>
    <router-view/>
    </div>
</template>
<script>
	export default {
		data() {
			return {
				msg: 'message',
				count: this.$store.state.count
			}
		},
		computed: {
			cCount() {
				return this.$store.state.count;
			}
		},
		methods: {
			changeCount() {
				this.$store.commit('updateCount');
			}
		}
	}
</script>
<style></style>