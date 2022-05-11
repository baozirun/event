import Vue from 'vue'
import router from './router'
import store from './store'

import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import notification from 'ant-design-vue/es/notification'
import { setDocumentTitle, domTitle } from '@/utils/domUtil'
import { ACCESS_TOKEN } from '@/store/mutation-types'
import config from '@/config/defaultSettings'

NProgress.configure({ showSpinner: false }) // NProgress Configuration
const whiteList = ['/login', '/register', '/registerResult','/home/protalHome'] // no redirect whitelist
/**
 * 跳转统一登录
 * @param {*} backurl 
 */
const gotoLogin=(backurl)=>{
  let url=config.loginUrl;
  if(url.indexOf('?')<0){
    url=url+'?';
  }
  backurl=window.location.protocol+'//'+window.location.hostname+':'+window.location.port+window.location.pathname+'#'+backurl;
  backurl=decodeURIComponent(backurl);
  window.location.href=url+'&backurl='+backurl
}


router.beforeEach((to, from, next) => {
  NProgress.start() // start progress bar

	// if (!Vue.ss.get(ACCESS_TOKEN) && to.path === '/login') {
  //   gotoLogin('/')
  //   NProgress.done()
  // }

  // token参数处理
  const token=to.query.token || from.query.token;
  if(token){
    Vue.ss.set(ACCESS_TOKEN,token);
    store.dispatch('setToken',token);
  }

  if (from.query.isIframe) {
    to.query['isIframe'] = from.query.isIframe
  }

  // 设置标题
  to.meta && (typeof to.meta.title !== 'undefined' && setDocumentTitle(`${to.meta.title} - ${domTitle}`))

  // 验证是否已登录
  // if (Vue.ss.get(ACCESS_TOKEN)) {

    // 如果已认证，并且又请求登录页面，则返回首页
    // if (to.path === '/login') {
    //   next({ path: '/' })
    //   NProgress.done()
    //   return;
    // } 

    // 判断前端是否获取到用户信息
    // if(!store.getters.userInfo){
    //   store.dispatch('isAuthed').then(() => {
    //     next({path:to.path});
    //   }).catch(() => {
    //     // 跳转到登录页面
    //     gotoLogin(to.fullPath)
    //     NProgress.done() // if current page is login will not trigger afterEach hook, so manually handle it
    //   })
    //   return;
    // }
    
    // 直接放行
    next();
  // } else {

  //   // 获取topath，对404路径特殊处理
  //   let topath=to.path
  //   if(to.path=='/404'){
  //     if(to.redirectedFrom){
  //       topath=to.redirectedFrom
  //     }
  //   }

  //   if (whiteList.includes(topath)) {
  //     // 在免登录白名单，直接进入
  //     next()
  //   } else {
  //     // 验证当前回话是否已认证
  //     store.dispatch('isAuthed').then(() => {
  //       next({path:topath})
  //     }).catch(() => {
  //       // 跳转到登录页面
  //       gotoLogin(topath)
  //       NProgress.done() // if current page is login will not trigger afterEach hook, so manually handle it
  //     })
  //   }
  // }
	
})

router.afterEach(() => {
  NProgress.done() // finish progress bar
})

/**
 * Action 权限指令
 * 指令用法：
 *  - 在需要控制 action 级别权限的组件上使用 v-action:[method] , 如下：
 *    <i-button v-action:add >添加用户</a-button>
 *    <a-button v-action:delete>删除用户</a-button>
 *    <a v-action:edit @click="edit(record)">修改</a>
 *
 *  - 当前用户没有权限时，组件上使用了该指令则会被隐藏
 *  - 当后台权限跟 pro 提供的模式不同时，只需要针对这里的权限过滤进行修改即可
 *
 *  @see https://github.com/sendya/ant-design-pro-vue/pull/53
 */
const action = Vue.directive('action', {
  bind: function (el, binding, vnode) {
    const actionName = binding.arg
    const btn = store.getters.permis[actionName];
    if(!btn){
      el.parentNode && el.parentNode.removeChild(el) || (el.style.display = 'none');
    }
  }
})

export {
  action
}
