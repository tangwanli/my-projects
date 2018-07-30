import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
	state: {
		count: 1,
		user: {
			login: true,
			username: 'i\'m your god'
		}
	},
	mutations: {
		updataLogin(state) {
			state.user.login = false;
			state.user.username = localStorage.getItem('username');
		}
	}
})
