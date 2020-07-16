// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

//引入element-ui
import ElementUI from 'element-ui';
//引入element-ui的css
import 'element-ui/lib/theme-chalk/index.css';
//引入图标
import '@/assets/icon/user/iconfont.css';

//使用element-ui
Vue.use(ElementUI)

Vue.config.productionTip = false

//引入axios
import axios from 'axios'
import qs from 'qs'
axios.interceptors.request.use(config => {
  config.headers.Authorization=window.sessionStorage.getItem("token");
  return config;
})
//使用axios
// Vue.use(VueAxios, axios)
Vue.prototype.$axios = axios
//设置默认请求路径
axios.defaults.baseURL="/power-web"

//配全局属性配置，在任意组件内可以使用this.$qs获取qs对象
Vue.prototype.$qs = qs

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
