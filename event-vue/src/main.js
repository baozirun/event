/*
 * @Description: 
 * @Version: 1.0
 * @Autor: jiajun wu
 * @Date: 2020-08-03 11:33:25
 * @LastEditors: jiajun wu
 * @LastEditTime: 2020-08-03 13:57:34
 */
// ie polyfill
import '@babel/polyfill'

import Vue from 'vue'
import App from './App.vue'

import router from './router'
import store from './store/'
import {
  VueAxios
} from './utils/request'
import vuescroll from 'vuescroll';
import bootstrap from './core/bootstrap'

import './core/use'
import './permission' // permission control
import './utils/filter' // global filter


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

/**
* 	main.js
*/

import navigationitem from "./components/submen.vue";
Vue.component("navigationitem", navigationitem);



// 引入 sessionstorage
import VueSessionStorage from 'vue-sessionstorage'
Vue.use(VueSessionStorage)
Vue.ss = Vue.prototype.$session

// 引入 cookie
import Cookies from 'js-cookie'
Vue.ck = Cookies

Vue.config.productionTip = false

// mount axios Vue.$http and this.$http
Vue.use(VueAxios)

// vuescroll config
Vue.use(vuescroll, {
  ops: {
    bar: {
      background: 'rgba(24,144,255,0.4)',
      size: '3px'
    }
  }, // 在这里设置全局默认配置
});

new Vue({
  router,
  store,
  created() {
    bootstrap()
  },
  render: h => h(App)
}).$mount('#app')