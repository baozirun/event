/*
 * @Description:
 * @Version: 1.0
 * @Date: 2020-08-03 11:33:25
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2021-02-20 18:04:40
 */
import Vue from 'vue'
import axios from 'axios'
import store from '@/store'
import {
  VueAxios
} from './axios'
import notification from 'ant-design-vue/es/notification'
import {
  ACCESS_TOKEN
} from '@/store/mutation-types'

import config from '@/config/defaultSettings'
// 创建 axios 实例
const service = axios.create({
  baseURL: config.context, // api base_url
  timeout: 60000 // 请求超时时间
})

const err = (error) => {
  if (error.response) {
    const data = error.response.data
    const token = Vue.ls.get(ACCESS_TOKEN)
    if (error.response.status === 403) {
      // notification.error({
      //   message: 'Forbidden',
      //   description: data.message
      // })
      console.log('error:403')
    }
    if (error.response.status === 402) {
      // notification.error({
      //   message: 'License验证失败',
      //   description: data.message
      // })
      console.log('error:402')
    }
    if (error.response.status === 401) {
      // notification.error({
      //   message: 'Unauthorized',
      //   description: 'Authorization verification failed'
      // })
      console.log('error:401')
      if (token) {
        Vue.ls.remove(ACCESS_TOKEN)
        store.dispatch('Logout').then(() => {
          setTimeout(() => {
            window.location.reload()
          }, 1500)
        })
      }
    }
  }
  return Promise.reject(error)
}

// request interceptor
service.interceptors.request.use(config => {
  const token = Vue.ss.get(ACCESS_TOKEN)
  if (token) {
    Vue.ck.set(ACCESS_TOKEN,token)
  }
  config.headers['X-Axios-With']=true
  return config
}, err)


// response interceptor
service.interceptors.response.use((response) => {
  if (response.status === 402) {
    // notification.error({
    //   message: 'License验证失败',
    //   description: data.message
    // })
    console.log('error:402')
  }
  return response.data
}, err)

const installer = {
  vm: {},
  install(Vue) {
    Vue.use(VueAxios, service)
  }
}


// 注册外部rest axios服务
Object.keys(config.extServer).forEach(key=>{

  let extService = axios.create({
    baseURL: config.extServer[key], // api base_url
    timeout: 60000 // 请求超时时间
  })

  // request interceptor
  extService.interceptors.request.use(config => {
    const token = Vue.ss.get(ACCESS_TOKEN)
    if (token) {
      Vue.ck.set(ACCESS_TOKEN,token)
    }
    config.headers['X-Axios-With']=true
    return config
  }, err)

  // response interceptor
  extService.interceptors.response.use((response) => {
    if (response.status === 402) {
      // notification.error({
      //   message: 'License验证失败',
      //   description: data.message
      // })
      console.log('error:402')
    }
    return response.data
  }, err)

  service[key]=extService
})


export {
  installer as VueAxios,
  service as axios,
}
