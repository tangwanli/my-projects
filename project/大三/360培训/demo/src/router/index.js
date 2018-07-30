import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home'
import man from '@/components/man'

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
      components: {
        man,
        home
      }
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
