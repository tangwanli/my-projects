import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import home from '@/components/home'
import login from '@/components/login'
import game from '@/components/game'

Vue.use(Router)

let router = new Router({
  mode: 'history',
  routes: [
/*    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }*/
    {
      name: 'home',
      path: '/',
      component: home
    },
    {
      name: 'login',
      path: '/login',
      component: login
    },
    {
      name: 'game',
      path: '/game',
      component: game
    },
    {
    	name: 'redirect',
    	path: '*',
    	redirect: '/'
    }
  ]
});
router.beforeEach((to,from,next) => {
	if (to.path === '/game' && router.app.$store.state.user.login === true) {
		next('/login');
	} else {
		next();
	}
});
export default router;
