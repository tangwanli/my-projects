import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import GreenOne from '@/components/GreenOne'
import LiePush from '@/components/LiePush'
import Road from '@/components/Road'
import Study from '@/components/Study'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes: [
	{
	  path: '/',
	  name: 'Index',
	  component: Index,
	  children: [{
	  	path: '',
	  	component: GreenOne
	  }]
	},
	{
		path: '/LiePush',
		name: 'LiePush',
		component: LiePush,
		children: [{
			path: '',
			component: GreenOne
		}]
	},
	{
		path: '/Road',
		name: 'Road',
		component: Road,
		children: [{
			path: '',
			component: GreenOne
		}]
	},
	{
		path: '/Study',
		name: 'Study',
		component: Study,
		children: [{
			path: '',
			component: GreenOne
		}]
	},
	{
		path: '*',
		redirect: '/Index'
	}
	]
})
