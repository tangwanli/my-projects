import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

// 定义store
let store = new Vuex.Store({
	state:{
		count: 10
	},
	getters: {
		addCount(state) {
			return --state.count;
		}
	},
	mutations: {
		updateCount(state) {
			state.count++;
		}
	}
});
export default store;