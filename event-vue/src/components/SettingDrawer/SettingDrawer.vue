<template>
  <div class="setting-drawer" ref="settingDrawer">
    <a-drawer
      width="300"
      placement="right"
      @close="onClose"
      :visible="visible"
      :getContainer="() => $refs.settingDrawer"
      :style="{}"
    >
      <div class="setting-drawer-index-content">

        <div :style="{ marginBottom: '24px' }">
          <h3 class="setting-drawer-index-title">整体风格设置</h3>

          <div class="setting-drawer-index-blockChecbox">
           
            <div class="setting-drawer-index-item" @click="changeTheme('dark','dark')">
              <svg width="52px" height="45px" viewBox="0 0 52 45" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                <!-- Generator: Sketch 50.2 (55047) - http://www.bohemiancoding.com/sketch -->
                <title>整体风格设置</title>
                <desc>Created with Sketch.</desc>
                <defs>
                    <filter x="-9.4%" y="-6.2%" width="118.8%" height="122.5%" filterUnits="objectBoundingBox" id="filter-1">
                        <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                        <feGaussianBlur stdDeviation="1" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                        <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.15 0" type="matrix" in="shadowBlurOuter1" result="shadowMatrixOuter1"></feColorMatrix>
                        <feMerge>
                            <feMergeNode in="shadowMatrixOuter1"></feMergeNode>
                            <feMergeNode in="SourceGraphic"></feMergeNode>
                        </feMerge>
                    </filter>
                    <rect id="path-2" x="0" y="0" width="48" height="40" rx="4"></rect>
                    <filter x="-4.2%" y="-2.5%" width="108.3%" height="110.0%" filterUnits="objectBoundingBox" id="filter-4">
                        <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                        <feGaussianBlur stdDeviation="0.5" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                        <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.1 0" type="matrix" in="shadowBlurOuter1"></feColorMatrix>
                    </filter>
                </defs>
                <g id="配置面板" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                    <g id="setting-copy-2" transform="translate(-1190.000000, -136.000000)">
                        <g id="Group-8" transform="translate(1167.000000, 0.000000)">
                            <g id="Group-5-Copy-5" filter="url(#filter-1)" transform="translate(25.000000, 137.000000)">
                                <mask id="mask-3" fill="white">
                                    <use xlink:href="#path-2"></use>
                                </mask>
                                <g id="Rectangle-18">
                                    <use fill="black" fill-opacity="1" filter="url(#filter-4)" xlink:href="#path-2"></use>
                                    <use fill="#F0F2F5" fill-rule="evenodd" xlink:href="#path-2"></use>
                                </g>
                                <rect id="Rectangle-11" :class="['navTheme','dark']" fill="#FFFFFF" mask="url(#mask-3)" x="-1" y="0" width="49" height="10"></rect>
                                <rect id="Rectangle-18" :class="['menuTheme','dark']" fill="#303648" mask="url(#mask-3)" x="0" y="10" width="16" height="44"></rect>
                            </g>
                        </g>
                    </g>
                </g>
              </svg>
              <div class="setting-drawer-index-selectIcon" v-if="navTheme == 'dark' && menuTheme=='dark'">
                <a-icon type="check"/>
              </div>
            </div>

            <div class="setting-drawer-index-item" @click="changeTheme('dark','light')">
              <svg width="52px" height="45px" viewBox="0 0 52 45" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                <!-- Generator: Sketch 50.2 (55047) - http://www.bohemiancoding.com/sketch -->
                <title>整体风格设置</title>
                <desc>Created with Sketch.</desc>
                <defs>
                    <filter x="-9.4%" y="-6.2%" width="118.8%" height="122.5%" filterUnits="objectBoundingBox" id="filter-1">
                        <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                        <feGaussianBlur stdDeviation="1" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                        <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.15 0" type="matrix" in="shadowBlurOuter1" result="shadowMatrixOuter1"></feColorMatrix>
                        <feMerge>
                            <feMergeNode in="shadowMatrixOuter1"></feMergeNode>
                            <feMergeNode in="SourceGraphic"></feMergeNode>
                        </feMerge>
                    </filter>
                    <rect id="path-2" x="0" y="0" width="48" height="40" rx="4"></rect>
                    <filter x="-4.2%" y="-2.5%" width="108.3%" height="110.0%" filterUnits="objectBoundingBox" id="filter-4">
                        <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                        <feGaussianBlur stdDeviation="0.5" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                        <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.1 0" type="matrix" in="shadowBlurOuter1"></feColorMatrix>
                    </filter>
                </defs>
                <g id="配置面板" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                    <g id="setting-copy-2" transform="translate(-1190.000000, -136.000000)">
                        <g id="Group-8" transform="translate(1167.000000, 0.000000)">
                            <g id="Group-5-Copy-5" filter="url(#filter-1)" transform="translate(25.000000, 137.000000)">
                                <mask id="mask-3" fill="white">
                                    <use xlink:href="#path-2"></use>
                                </mask>
                                <g id="Rectangle-18">
                                    <use fill="black" fill-opacity="1" filter="url(#filter-4)" xlink:href="#path-2"></use>
                                    <use fill="#F0F2F5" fill-rule="evenodd" xlink:href="#path-2"></use>
                                </g>
                                <rect id="Rectangle-11" :class="['navTheme','dark']" fill="#FFFFFF" mask="url(#mask-3)" x="-1" y="0" width="49" height="10"></rect>
                                <rect id="Rectangle-18" :class="['menuTheme','light']" fill="#303648" mask="url(#mask-3)" x="0" y="10" width="16" height="44"></rect>
                            </g>
                        </g>
                    </g>
                </g>
              </svg>
              <div class="setting-drawer-index-selectIcon" v-if="navTheme == 'dark' && menuTheme=='light'">
                <a-icon type="check"/>
              </div>
            </div>

            <div class="setting-drawer-index-item" @click="changeTheme('light','light')">
              <svg width="52px" height="45px" viewBox="0 0 52 45" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                <!-- Generator: Sketch 50.2 (55047) - http://www.bohemiancoding.com/sketch -->
                <title>整体风格设置</title>
                <desc>Created with Sketch.</desc>
                <defs>
                    <filter x="-9.4%" y="-6.2%" width="118.8%" height="122.5%" filterUnits="objectBoundingBox" id="filter-1">
                        <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                        <feGaussianBlur stdDeviation="1" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                        <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.15 0" type="matrix" in="shadowBlurOuter1" result="shadowMatrixOuter1"></feColorMatrix>
                        <feMerge>
                            <feMergeNode in="shadowMatrixOuter1"></feMergeNode>
                            <feMergeNode in="SourceGraphic"></feMergeNode>
                        </feMerge>
                    </filter>
                    <rect id="path-2" x="0" y="0" width="48" height="40" rx="4"></rect>
                    <filter x="-4.2%" y="-2.5%" width="108.3%" height="110.0%" filterUnits="objectBoundingBox" id="filter-4">
                        <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                        <feGaussianBlur stdDeviation="0.5" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                        <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.1 0" type="matrix" in="shadowBlurOuter1"></feColorMatrix>
                    </filter>
                </defs>
                <g id="配置面板" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                    <g id="setting-copy-2" transform="translate(-1190.000000, -136.000000)">
                        <g id="Group-8" transform="translate(1167.000000, 0.000000)">
                            <g id="Group-5-Copy-5" filter="url(#filter-1)" transform="translate(25.000000, 137.000000)">
                                <mask id="mask-3" fill="white">
                                    <use xlink:href="#path-2"></use>
                                </mask>
                                <g id="Rectangle-18">
                                    <use fill="black" fill-opacity="1" filter="url(#filter-4)" xlink:href="#path-2"></use>
                                    <use fill="#F0F2F5" fill-rule="evenodd" xlink:href="#path-2"></use>
                                </g>
                                <rect id="Rectangle-11" :class="['navTheme','light']" fill="#FFFFFF" mask="url(#mask-3)" x="-1" y="0" width="49" height="10"></rect>
                                <rect id="Rectangle-18" :class="['menuTheme','light']" fill="#303648" mask="url(#mask-3)" x="0" y="10" width="16" height="44"></rect>
                            </g>
                        </g>
                    </g>
                </g>
              </svg>
              <div class="setting-drawer-index-selectIcon" v-if="navTheme == 'light' && menuTheme=='light'">
                <a-icon type="check"/>
              </div>
            </div>
 
          </div>
        </div>

        <div :style="{ marginBottom: '24px' }">
          <h3 class="setting-drawer-index-title">主题色</h3>

          <div style="height: 20px">
            <a-tooltip class="setting-drawer-theme-color-colorBlock" v-for="(item, index) in colorList" :key="index">
              <template slot="title">
                {{ item.key }}
              </template>
              <a-tag :color="item.color" @click="changeColor(item.color)">
                <a-icon type="check" v-if="item.color === primaryColor"></a-icon>
              </a-tag>
            </a-tooltip>

          </div>
        </div>
        <a-divider />

        <div :style="{ marginBottom: '24px' }">
          <h3 class="setting-drawer-index-title">导航模式</h3>

          <div class="setting-drawer-index-blockChecbox">
            <a-tooltip>
              <template slot="title">
                侧边栏导航
              </template>
              <div class="setting-drawer-index-item" @click="handleLayout('sidemenu')">
                <svg width="52px" height="45px" viewBox="0 0 52 45" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                  <!-- Generator: Sketch 50.2 (55047) - http://www.bohemiancoding.com/sketch -->
                  <title> 侧边栏导航</title>
                  <desc>Created with Sketch.</desc>
                  <defs>
                      <filter x="-9.4%" y="-6.2%" width="118.8%" height="122.5%" filterUnits="objectBoundingBox" id="filter-1">
                          <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                          <feGaussianBlur stdDeviation="1" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                          <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.15 0" type="matrix" in="shadowBlurOuter1" result="shadowMatrixOuter1"></feColorMatrix>
                          <feMerge>
                              <feMergeNode in="shadowMatrixOuter1"></feMergeNode>
                              <feMergeNode in="SourceGraphic"></feMergeNode>
                          </feMerge>
                      </filter>
                      <rect id="path-2" x="0" y="0" width="48" height="40" rx="4"></rect>
                      <filter x="-4.2%" y="-2.5%" width="108.3%" height="110.0%" filterUnits="objectBoundingBox" id="filter-4">
                          <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                          <feGaussianBlur stdDeviation="0.5" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                          <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.1 0" type="matrix" in="shadowBlurOuter1"></feColorMatrix>
                      </filter>
                  </defs>
                  <g id="配置面板" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                      <g id="setting-copy-2" transform="translate(-1190.000000, -136.000000)">
                          <g id="Group-8" transform="translate(1167.000000, 0.000000)">
                              <g id="Group-5-Copy-5" filter="url(#filter-1)" transform="translate(25.000000, 137.000000)">
                                  <mask id="mask-3" fill="white">
                                      <use xlink:href="#path-2"></use>
                                  </mask>
                                  <g id="Rectangle-18">
                                      <use fill="black" fill-opacity="1" filter="url(#filter-4)" xlink:href="#path-2"></use>
                                      <use fill="#F0F2F5" fill-rule="evenodd" xlink:href="#path-2"></use>
                                  </g>
                                  <rect id="Rectangle-11" :class="['navTheme',navTheme]" fill="#FFFFFF" mask="url(#mask-3)" x="-1" y="0" width="49" height="10"></rect>
                                  <rect id="Rectangle-18" :class="['menuTheme',menuTheme]" fill="#303648" mask="url(#mask-3)" x="0" y="10" width="16" height="44"></rect>
                              </g>
                          </g>
                      </g>
                  </g>
                </svg>
                <div class="setting-drawer-index-selectIcon" v-if="layoutMode === 'sidemenu'">
                  <a-icon type="check"/>
                </div>
              </div>
            </a-tooltip>

            <a-tooltip>
              <template slot="title">
                顶部栏导航
              </template>
              <div class="setting-drawer-index-item" @click="handleLayout('topmenu')">
                <svg width="52px" height="45px" viewBox="0 0 52 45" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                  <!-- Generator: Sketch 50.2 (55047) - http://www.bohemiancoding.com/sketch -->
                  <title>顶部栏导航</title>
                  <desc>Created with Sketch.</desc>
                  <defs>
                      <filter x="-9.4%" y="-6.2%" width="118.8%" height="122.5%" filterUnits="objectBoundingBox" id="filter-1">
                          <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                          <feGaussianBlur stdDeviation="1" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                          <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.15 0" type="matrix" in="shadowBlurOuter1" result="shadowMatrixOuter1"></feColorMatrix>
                          <feMerge>
                              <feMergeNode in="shadowMatrixOuter1"></feMergeNode>
                              <feMergeNode in="SourceGraphic"></feMergeNode>
                          </feMerge>
                      </filter>
                      <rect id="path-2" x="0" y="0" width="48" height="40" rx="4"></rect>
                      <filter x="-4.2%" y="-2.5%" width="108.3%" height="110.0%" filterUnits="objectBoundingBox" id="filter-4">
                          <feOffset dx="0" dy="1" in="SourceAlpha" result="shadowOffsetOuter1"></feOffset>
                          <feGaussianBlur stdDeviation="0.5" in="shadowOffsetOuter1" result="shadowBlurOuter1"></feGaussianBlur>
                          <feColorMatrix values="0 0 0 0 0   0 0 0 0 0   0 0 0 0 0  0 0 0 0.1 0" type="matrix" in="shadowBlurOuter1"></feColorMatrix>
                      </filter>
                  </defs>
                  <g id="配置面板" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                      <g id="setting-copy-2" transform="translate(-1254.000000, -337.000000)">
                          <g id="Group-8" transform="translate(1167.000000, 0.000000)">
                              <g id="Group-5" filter="url(#filter-1)" transform="translate(89.000000, 338.000000)">
                                  <mask id="mask-3" fill="white">
                                      <use xlink:href="#path-2"></use>
                                  </mask>
                                  <g id="Rectangle-18">
                                      <use fill="black" fill-opacity="1" filter="url(#filter-4)" xlink:href="#path-2"></use>
                                      <use fill="#F0F2F5" fill-rule="evenodd" xlink:href="#path-2"></use>
                                  </g>
                                  <rect id="Rectangle-11" :class="['navTheme',navTheme]" fill="#303648" mask="url(#mask-3)" x="-1" y="0" width="49" height="10"></rect>
                              </g>
                          </g>
                      </g>
                  </g>
              </svg>
                <div class="setting-drawer-index-selectIcon" v-if="layoutMode !== 'sidemenu'">
                  <a-icon type="check"/>
                </div>
              </div>
            </a-tooltip>
          </div>
        </div>
        <a-divider />

        <div :style="{ marginBottom: '24px' }">
          <h3 class="setting-drawer-index-title">其他设置</h3>
          <div>
            <a-list :split="false">
              <a-list-item>
                <a-switch slot="actions" size="small" :defaultChecked="multiTab" @change="onMultiTab" />
                <a-list-item-meta>
                  <div slot="title">多页签模式</div>
                </a-list-item-meta>
              </a-list-item>
            </a-list>
          </div>
        </div>

      </div>
    </a-drawer>

    <div class="seting-mask" v-if="this.drag"></div>
    <div class="setting-drawer-index-handle" :style="{top:position.top+'px',right:(position.right)+'px'}" 
      @mousedown="toDrag($event)" @mouseup="toggle">
      <a-icon type="setting"/>
    </div>

  </div>
</template>

<script>
import Vue from 'vue'
import { DescriptionList } from '@/components'
import SettingItem from './SettingItem'
import config from '@/config/defaultSettings'
import { updateTheme, updateColorWeak, colorList } from './settingConfig'
import { mixin, mixinDevice } from '@/utils/mixin'

export default {
  components: {
    DescriptionList,
    SettingItem
  },
  mixins: [mixin, mixinDevice],
  data () {
    return {
      visible: false,
      colorList,
      baseConfig: Object.assign({}, config),
      position:{
        top:240,
        right:5
      },
      drag:null
    }
  },
  watch: {

  },
  mounted () {

    // 加载设置按钮位置
    const position=Vue.ls.get('SEETING-DRAWER-POSITION');
    if(position){
      this.position={...position};
    }

    const vm = this
    setTimeout(() => {
      vm.visible = false
    }, 16)
    // 当主题色不是默认色时，才进行主题编译
    if (this.primaryColor !== config.primaryColor) {
      updateTheme(this.primaryColor)
    }
    if (this.colorWeak !== config.colorWeak) {
      updateColorWeak(this.colorWeak)
    }
  },
  methods: {
    showDrawer () {
      this.visible = true
    },
    onClose () {
      this.visible = false
    },
    toggle () {
      if(!this.drag){
        this.visible = !this.visible
      }
    },
    onColorWeak (checked) {
      this.baseConfig.colorWeak = checked
      this.$store.dispatch('ToggleWeak', checked)
      updateColorWeak(checked)
    },
    onMultiTab (checked) {
      this.baseConfig.multiTab = checked
      this.$store.dispatch('ToggleMultiTab', checked)
    },
    handleMenuTheme (theme) {
      this.baseConfig.navTheme = theme
      this.$store.dispatch('ToggleNavTheme', theme)
    },
    doCopy () {
      const text = `export default {
  primaryColor: '${this.baseConfig.primaryColor}', // primary color of ant design
  navTheme: '${this.baseConfig.navTheme}', // theme for nav menu
  layout: '${this.baseConfig.layout}', // nav menu position: sidemenu or topmenu
  contentWidth: '${this.baseConfig.contentWidth}', // layout of content: Fluid or Fixed, only works when layout is topmenu
  fixedHeader: ${this.baseConfig.fixedHeader}, // sticky header
  fixSiderbar: ${this.baseConfig.fixSiderbar}, // sticky siderbar
  autoHideHeader: ${this.baseConfig.autoHideHeader}, //  auto hide header
  colorWeak: ${this.baseConfig.colorWeak},
  multiTab: ${this.baseConfig.multiTab},
  // vue-ls options
  storageOptions: {
    namespace: 'pro__',
    name: 'ls',
    storage: 'local',
  }
}`
      this.$copyText(text).then(message => {
        console.log('copy', message)
        this.$message.success('复制完毕')
      }).catch(err => {
        console.log('copy.err', err)
        this.$message.error('复制失败')
      })
    },
    handleLayout (mode) {
      this.baseConfig.layout = mode
      this.$store.dispatch('ToggleLayoutMode', mode)
      // 因为顶部菜单不能固定左侧菜单栏，所以强制关闭
      //
      this.handleFixSiderbar(false)
    },
    handleContentWidthChange (type) {
      this.baseConfig.contentWidth = type
      this.$store.dispatch('ToggleContentWidth', type)
    },
    changeColor (color) {
      this.baseConfig.primaryColor = color
      if (this.primaryColor !== color) {
        this.$store.dispatch('ToggleColor', color)
        updateTheme(color)
      }
    },
    handleFixedHeader (fixed) {
      this.baseConfig.fixedHeader = fixed
      this.$store.dispatch('ToggleFixedHeader', fixed)
    },
    handleFixedHeaderHidden (autoHidden) {
      this.baseConfig.autoHideHeader = autoHidden
      this.$store.dispatch('ToggleFixedHeaderHidden', autoHidden)
    },
    handleFixSiderbar (fixed) {
      if (this.layoutMode === 'topmenu') {
        this.baseConfig.fixSiderbar = false
        this.$store.dispatch('ToggleFixSiderbar', false)
        return
      }
      this.baseConfig.fixSiderbar = fixed
      this.$store.dispatch('ToggleFixSiderbar', fixed)
    },
    changeNavTheme(value){
      this.$store.dispatch('ToggleNavTheme', value)
    },
    changeMenuTheme(value){
      this.$store.dispatch('ToggleMenuTheme', value)
    },
    changeTheme(navTheme,menuTheme){
      this.$store.dispatch('ToggleNavTheme', navTheme)
      this.$store.dispatch('ToggleMenuTheme', menuTheme)
    },
    /**
     * 设置按钮拖拽功能
     */
    toDrag(event){

      setTimeout(() => {
        if(this.visible){
          return;
        }
        this.drag={
          x:event.clientX,
          y:event.clientY
        }
  
        document.onmousemove = (e)=>{
          const x=e.clientX-this.drag.x,y=e.clientY-this.drag.y;
          this.position.top+=y;
          this.position.right-=x;
          if(this.position.top<0){
            this.position.top=0;
          }else if(this.position.top>(document.body.clientHeight-50)){
            this.position.top=document.body.clientHeight-50;
          }
          if(this.position.right<0){
            this.position.right=0;
          }else if(this.position.right>(document.body.clientWidth-50)){
            this.position.right=document.body.clientWidth-50;
          }
         
          this.drag={
            x:e.clientX,
            y:e.clientY
          }
        }
        document.onmouseup = (e) => {
          document.onmousemove = null;
          document.onmouseup = null;
          this.drag=null;
          Vue.ls.set('SEETING-DRAWER-POSITION',this.position);
        };
      }, 100);
    }
  }
}
</script>

<style lang="less" scoped>

  .setting-drawer-index-content {

    .setting-drawer-index-blockChecbox {
      display: flex;

      .setting-drawer-index-item {
        margin-right: 16px;
        position: relative;
        border-radius: 4px;
        cursor: pointer;

        img {
          width: 48px;
        }

        .setting-drawer-index-selectIcon {
          position: absolute;
          top: 0;
          right: 0;
          width: 100%;
          padding-top: 15px;
          padding-left: 24px;
          height: 100%;
          color: #1890ff;
          font-size: 14px;
          font-weight: 700;
        }
      }
    }
    .setting-drawer-theme-color-colorBlock {
      width: 20px;
      height: 20px;
      border-radius: 2px;
      float: left;
      cursor: pointer;
      margin-right: 8px;
      padding-left: 0px;
      padding-right: 0px;
      text-align: center;
      color: #fff;
      font-weight: 700;

      i {
        font-size: 14px;
      }
    }
  }

  .setting-drawer-index-handle {
    position: fixed;
    top: 240px;
    background: #1890ff;
    width: 48px;
    height: 48px;
    right: 300px;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    pointer-events: auto;
    z-index: 999;
    text-align: center;
    font-size: 16px;
    border-radius: 4px;

    i {
      color: rgb(255, 255, 255);
      font-size: 20px;
    }
  }

  .item-box{

    .title{
      font-size: 12px;
    }

    .value{
      /deep/ .ant-select-selection-selected-value{
        font-size: 12px;
      }
    }

  }


  .seting-mask{
    position: fixed;
    top:0px;
    left: 0px;
    bottom: 0px;
    width: 100%;
    z-index: 10;
  }



</style>
