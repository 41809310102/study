import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import './assets/css/global.css'
// 导入iconfront
import './assets/font/iconfont.css'
// 导入axios
import axios from 'axios'
// 挂载axios 到Vue的原型prototype的$http
Vue.prototype.$http = axios
// 设置请求的根路径
axios.defaults.baseURL = "http://localhost:9000/"
axios.interceptors.request.use(config => {
  console.log(config);
  // 请求头挂载信息
  config.headers.Authorization = window.sessionStorage.getItem("flag");
  // 在最后必须return config
  return config;
})
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
