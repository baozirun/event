<template>
  <a-configProvider :locale="locale">
    <div id="app">
      <router-view/>
    </div>
  </a-configProvider>
</template>

<script>
import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN'
import { AppDeviceEnquire } from '@/utils/mixin'
import '@/assets/fonts/aifa/iconfont.css';
import { mapState, mapActions } from 'vuex'
import config from '@/config/defaultSettings'
import { axios } from '@/utils/request'

export default {
  mixins: [AppDeviceEnquire],
  data () {
    return {
      locale: zhCN
    }
  },
  mounted () {
    // 监听窗口消息
    window.addEventListener('message',({data})=>{
      if(data.cmd=='authBtns'){
        this.setPermis(data.btns);
      }
    });
  },
  methods: {
    ...mapActions(['setPermis']),
  }
}
</script>
<style>
  #app {
    height: 100vh;
  }
</style>
