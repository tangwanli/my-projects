import Vue from 'vue'
import Router from 'vue-router'
import hello from '@/components/hello'
import HelloWorld from '@/components/HelloWorld'
import girl from '@/components/girl'

Vue.use(Router)

export default new Router({
	mode: 'history',
  routes: [
    {
      path: '/hello',
      component: hello,
      children: [{
      	path: 'girl',
      	component: girl
      }]
    },
    {
    	path: '/HelloWorld',
    	component: HelloWorld
    },
    {
    	path: '*',
    	redirect: (to) => {
    		return '/hello'
    	}
    }
  ]
})
