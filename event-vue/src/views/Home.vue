<template>
  <div class="view-page">
    system home
  </div>
</template>

<script>
/**
 * @组件名称 应用安装
 * 
 * @作者   Jeking Yang
 * @日期   2019-04-19
 * @版本   1.0.0
 * ..........................................
 */

import store from '@/store'
import { axios } from '@/utils/request'

const dataSource = []
for (let i = 0; i < 11; i++) {
  dataSource.push({
    title: 'Alipay',
    avatar: 'https://gw.alipayobjects.com/zos/rmsportal/WdGqmHpayyMjiEhcKoVE.png',
    content: '在中台产品的研发过程中，会出现不同的设计规范和实现方式，但其中往往存在很多类似的页面和组件，这些类似的组件会被抽离成一套标准规范。'
  })
}


export default {
  name: 'Home',
  components: {
  },
  // 1>:属性定义..............................
  props:{

  },
  data () {
    return {
      // 应用申请对象
      query:{
        keyWords:''
      },
      // 应用查询结果
      results:{
        rows:dataSource
      },
      // 应用申请组件
      apply:{
        visible:false,
        app:{}
      }
    }
  },
  computed:{
    layout:()=>{
      return store.getters.layout;
    }
  },
  // 2>:初始化.................................
	mounted(){
    // axios({
    //   url: 'http://localhost:8080/mins-system-server/books/find',
    //   method: 'post',
    //   data:{}
    // }).then(result => {
    //   console.log(result)
    // });
  },
  // 3>:实现方法...............................
  methods: {
    /**
     * 应用试用申请
     */
    toApplyApp(app){
      this.apply.app=app;
      app.name=app.title;
      this.apply.visible=true;
    },
    onApplyDialogClose(){
      this.apply.visible=false;
    }
  }
}
</script>

<style scoped>
  .query-result{
    margin-top:20px;
  }
</style>
