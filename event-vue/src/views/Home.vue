<template>
  <div class="app">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">
          <breadcrumb></breadcrumb>
          <user-menu></user-menu>
           <el-menu
              :default-active="currentRouter"
              :collapse-transition="false"
              :default-openend="['0','1','2','3','4']"
              class="el-menu-vertical-demo"
              :collapse="isCollapse"
              @close="handleClose"
              router
              ref="menus">
              <navigationitem v-for="(menu,i) in adminMenus" :key="i" :item="menu" />
           </el-menu>

        </el-aside>
        	<el-main>
         <el-tabs

         
          v-model="activeTab"
          type="card"
          @tab-click="tabClick"
          @tab-remove="tabRemove"
        >
          <el-tab-pane
            :closable="closable"
            :key="item.route"
            v-for="item in editableTabs"
            :label="item.name"
            :name="item.route"
          >
          <transition name="fade" mode="out-in">
            <router-view :key="$route.fullPath"></router-view>
          </transition>
          </el-tab-pane>
        </el-tabs>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>

import Breadcrumb from '@/components/tools/Breadcrumb.vue'
import tipImg from '@/assets/svg/404.svg'
import UserMenu from '../components/tools/UserMenu.vue';

export default {
  components: { Breadcrumb,UserMenu},
  data () {
    return {
    	//当前路由名字
      currentRouterName: "",
      //当前激活菜单的 index
      currentRouter: this.$route.name,
      //是否折叠菜单
      isCollapse: false,
      
      adminMenus: [
        {
          id: 1,
          path: "/home/protalHome",
          nameZh: "首页",
          parentId: 0,
          iconCls: null,
          children: null
        },
        {
          id: 2,
          path: "/adminbbb",
          nameZh: "用户管理",
          iconCls: null,
          parentId: 0,
          children: [
            {
              id: 6,
              path: "/carousel",
              iconCls: null,
              nameZh: "设置",
              parentId: 2,
              children: null
            },
            {
              id: 7,
              path: "/lunbotus",
              iconCls: null,
              nameZh: "轮播图",
              parentId: 2,
              children: null
            }
          ]
        },
        {
          id: 3,
          path: "/dgbdbdb",
          nameZh: "内容管理",
          iconCls: null,
          parentId: 0,
          children: [
            {
              id: 9,
              path: "/lunbotu",
              nameZh: "轮播图",
              iconCls: null,
              parentId: 3,
              children: null
            },
            {
              id: 10,
              path: "/dfbdbdfbdfb",
              nameZh: "学生类",
              iconCls: null,
              parentId: 3,
              children: [
                {
                  id: 20,
                  path: "/dfbdbdfbd",
                  nameZh: "毕业生信息",
                  iconCls: null,
                  parentId: 10,
                  children: null
                }
              ]
            },
            {
              id: 11,
              path: "/dbfdbszbfdz",
              name: "Enterprise",
              nameZh: "企业类",
              iconCls: null,
              component: "content/enterprise",
              parentId: 3,
              children: null
            }
          ]
        },
        {
          id: 4,
          path: "/dfbhdhdfh",
          name: "System",
          nameZh: "系统管理",
          iconCls: "el-icon-s-tools",
          component: "AdminIndex",
          parentId: 0,
          children: [
            {
              id: 12,
              path: "/dfgdhbdfb",
              name: "Run",
              nameZh: "运行情况",
              iconCls: null,
              component: "system/run",
              parentId: 4,
              children: null
            },
            {
              id: 13,
              path: "/dfgbdfhbdfbd",
              name: "Data",
              nameZh: "备份恢复数据库",
              iconCls: null,
              component: "system/data",
              parentId: 4,
              children: null
            },
            {
              id: 14,
              path: "/safgbgfcbcxvbd",
              name: "Log",
              nameZh: "操作日志",
              iconCls: null,
              component: "system/log",
              parentId: 4,
              children: null
            }
          ]
        },
        {
          id: 5,
          path: "/dsgdfhgfdhb",
          name: "Link",
          nameZh: "链接",
          iconCls: null,
          component: "AdminIndex",
          parentId: 0,
          children: null
        }
      ],
      //绑定值，选中选项卡的 name
      activeTab: "2",
      //选择的标签页
      editableTabs: [
        {
          title: "Tab 1",
          name: "首页2",
          route:"/home/protalHome"
        },
        {
          title: "Tab 1",
          name: "轮播图",
          route:"/lunbotu"
        },
        {
          title: "Tab 2",
          name: "设置",
          route:"/carousel"
        },
      ],
    };
  },
  methods: {
    handleClose(key, keyPath) {
      // this.$refs.menus.open(keyPath);
    },
    //控制tab标签
    controlTabs(route) {
      let flag = false;
      this.currentRouterName = route.meta.title;//获取路由的title，放置到页眉上
      this.currentRouter = route.path;//和左侧菜单进行联动，当前菜单
      for (let item of this.editableTabs) {
        if (item.route === route.path) {
          this.activeTab = route.path;//当前标签栏
          flag = true;
          break;
        }
      }
      //没有这个路由就进行添加
      if (!flag) {
        let names = route.meta.title;
        if (names.indexOf("/", 1) != -1) {
          // 二级或多级路由时
          names = names.substring(names.indexOf("/") + 1);
        }
        let param = {
          route: route.path,
          name: names,
        };
        //添加标签栏数组
        this.editableTabs.push(param);
        this.activeTab = route.path;
      }
    },
    //点击tab标签
    tabClick() {
      this.$router.push({ path: this.activeTab });
    },
    //移除tab标签
    tabRemove(targetName) {
    //删除数组元素
      if (this.activeTab === targetName) {
        this.editableTabs.forEach((tab, index) => {
          if (tab.route === targetName) {
            let nextTab =
              this.editableTabs[index + 1] || this.editableTabs[index - 1];
            if (nextTab) {
              this.$router.push({ path: nextTab.route });
              this.editableTabs.splice(index, 1);
            }
          }
        });
      } else {
        this.editableTabs = this.editableTabs.filter((item) => {
          if (item.route != targetName) {
            return item;
          }
        });
      }
    },

  },
  computed: {
    closable() {
      if (this.editableTabs.length > 1) {
        return true;
      } else {
        return false;
      }
    },
  },
 watch: {
    $route: {
      handler(to, from) {
        console.log(to, "totototo");//跳转的路由
        console.log(from, "fromfrom");//当前的路由
        this.controlTabs(to);
      },
      immediate: true,
      deep: true,
    },
  },

  mounted(){
    // this.a = this.$store.state.user.token
    // console.log(this.$store.state,123456)
  },
  created(){
    // alert(1);
    // console.log(1111);
  }
}
</script>


<style lang="less" scoped>
.app{
  height: 100%;
}
.el-header, .el-footer {
    background-color: red;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
    height: 100%;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  /deep/.el-container{
    height: 100%;
  }

  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
