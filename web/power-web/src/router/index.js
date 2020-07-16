import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Index from '@/views/index'
import Login from '@/views/login'

import ar from '@/router/actionRouter'

Vue.use(Router)

export const consRouterMap=[
    {path: '/',  name: 'Login', component: Login},
    // {path: '/index',  name: 'Index', component: Index},
    {path: '/login',  name: 'Login', component: Login}
]

export const asyncRouterMap=[
    ...ar
]

const router=new Router({
    mode:'hash',
    routes: consRouterMap.concat(asyncRouterMap),
})
//挂载路由导航守卫
router.beforeEach((to, from, next) => {
    if(to.path.indexOf("/login")!=-1){
      return next();
    }
    //获取token看是否已经登陆
    let tokenStr=window.sessionStorage.getItem("token");
    next();
    if(!tokenStr){
      return next("/login")
    }else{
      next();
    }
})

//暴露对象
export default router