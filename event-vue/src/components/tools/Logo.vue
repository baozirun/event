<template>
  <div :class="['logo',!showTitle&&'mixed']">
    <div :class="collapsed?'logo-small':'logo-big'"></div>
    <h1 v-if="showTitle">{{ title }}</h1>
  </div>
</template>

<script>

export default {
  name: 'Logo',
  components: {
  },
  props: {
    src:{
      type: String,
      // default: '/logo_icon.png',
      required: false
    },
    title: {
      type: String,
      default: '数据可视化(IDTV)',
      required: false
    },
    showTitle: {
      type: Boolean,
      default: false,
      required: false
    },
    collapsed:{
      type: Boolean,
      default: false,
    }
  }
}
</script>

<style lang="less" scoped>
.logo {
  height: 64px;
  line-height: 64px;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
  overflow: hidden;
  z-index: 9;

  &.top-nav-header{
   float:left;
  }

  .logo-big{
    // background-image:url('/logo_idtv.png');
    background-size: 100% 100%;
    width: 200px;
    height: 55px;
  }

  .logo-small{
    // background-image:url('/logo_icon.png');
    background-size: 100% 100%;
    width: 55px;
    height: 40px;
    margin-top: 13px;
    margin-left: 10px;
  }
}
</style>
