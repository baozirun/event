// eslint-disable-next-line
// import {
//   BasicLayout,
//   BlankLayout,
//   RouteView,
//   configLayout
// } from 'ZLayout'
import { bxAnaalyse } from '@/core/icons'
import config from '@/config/defaultSettings'

export const constantRouterMap = [

  {
    path: '/',
    redirect: '/home/protalHome',
}, {
  path: '/home',
  name: 'home',
  component: () =>
      import ('@/views/Home.vue'),
  meta: { title: '首页' },
  children: [{
          path: "/home",
          redirect: '/home/protalHome'
      },
      {
        path: 'protalHome',
        name: 'protalHome',
        component: () =>
            import ('@/views/as.vue'),
        meta: { title: '首页2', keepAlive: false },
        children: []
    }, {
      path: '/lunbotu',
      name: 'lunbotu',
      component: () =>
          import ('@/views/lunbotu/aaaa.vue'),
      meta: { title: '轮播图', keepAlive: false },
      children: []
    },
    {
      path: '/carousel',
      name: 'carousel',
      component: () =>
          import ('@/views/bb.vue'),
      meta: { title: 'Carousel', keepAlive: false },
      children: []
    },
  ]
},
  // {
  //   path: '/',
  //   name: 'index',
  //   // component: config.production ? BlankLayout : BasicLayout,
  //   // component: BasicLayout,
  //   meta: { title: '首页' },
  //   redirect: '/app/manage',
  //   children: [
  //     {
  //       path: '/home',
  //       name: 'home',
  //       component: () => import('@/views/as.vue'),
  //       meta: { title: 'home' }
  //     },
  //     {
  //       path: '/app/manage',
  //       name: 'home1',
  //       component: () => import('@/views/as.vue'),
  //       meta: { title: 'home1', keepAlive: false}
  //     },


  //     // 应用管理菜单
  //    /* {
  //       path: '/app',
  //       name: 'App',
  //       redirect: '/app/manage',
  //       component: RouteView,
  //       meta: { title: '应用管理', keepAlive: true, icon: bxAnaalyse },
  //       hideChildrenInMenu:true,
  //       children: [
  //         {
  //           path: '/app/manage',
  //           name: 'AppManage',
  //           component: () => import('@/views/app/baseinfo/manage'),
  //           meta: { title: '应用管理', keepAlive: false }
  //         },
  //         {
  //           path: '/app/modify',
  //           name: 'AppModify',
  //           hidden: true,
  //           component: () => import('@/views/app/baseinfo/modify'),
  //           meta: { title: '新增应用', keepAlive: false }
  //         },
  //         {
  //           path: '/app/menu/manage',
  //           name: 'AppMenuManage',
  //           component: () => import('@/views/app/menu/manage'),
  //           hidden: true,
  //           meta: { title: '菜单管理', keepAlive: false }
  //         },
  //         {
  //           path: '/app/api/manage',
  //           name: 'AppApiManage',
  //           component: () => import('@/views/app/api/manage'),
  //           hidden: true,
  //           meta: { title: 'API管理', keepAlive: false }
  //         },
  //       ]
  //     },


  //     // 产品管理
  //     {
  //       path: '/prod',
  //       name: 'Prod',
  //       redirect: '/prod/manage',
  //       component: RouteView,
  //       meta: { title: '产品管理', keepAlive: true, icon: bxAnaalyse },
  //       children: [
  //         {
  //           path: '/prod/manage',
  //           name: 'ProdManage',
  //           component: () => import('@/views/portal/product/baseinfo/manage'),
  //           meta: { title: '产品管理', keepAlive: false }
  //         },
  //         {
  //           path: '/prod/modify',
  //           name: 'ProdModify',
  //           hidden: true,
  //           component: () => import('@/views/portal/product/baseinfo/modify'),
  //           meta: { title: '产品维护', keepAlive: false, hidden: true }
  //         },
  //         {
  //           path: '/prod/menu/manage',
  //           name: 'ProdMenuManage',
  //           hidden: true,
  //           component: () => import('@/views/portal/product/menu/manage'),
  //           meta: { title: '菜单管理', keepAlive: false }
  //         },
  //       ]
  //     },

  //     // 机构管理
  //     {
  //       path: '/organ/manage',
  //       name: 'OrganManage',
  //       component: () => import('@/views/sys/organ/manage'),
  //       meta: { title: '机构管理', keepAlive: false }
  //     },
  //     // 用户管理
  //     {
  //       path: '/user',
  //       name: 'User',
  //       component: RouteView,
  //       redirect: '/user/manage',
  //       meta: { title: '用户管理', keepAlive: false },
  //       hideChildrenInMenu:true,
  //       children: [
  //         {
  //           path: '/user/manage',
  //           name: 'UserManage',
  //           component: () => import('@/views/sys/user/manage'),
  //           meta: { title: '用户管理', keepAlive: false },
  //         },
  //         {
  //           path: '/user/modify',
  //           name: 'UserModify',
  //           hidden: true,
  //           component: () => import('@/views/sys/user/modify'),
  //           meta: { title: '编辑用户', keepAlive: false }
  //         },
  //         {
  //           path: '/user/resetPwd',
  //           name: 'UserResetPwd',
  //           hidden: true,
  //           component: () => import('@/views/sys/user/ResetPassword'),
  //           meta: { title: '重置密码', keepAlive: false }
  //         },
  //       ]
  //     },
      
  //     // 角色管理
  //     {
  //       path: '/role/manage',
  //       name: 'RoleManage',
  //       component: () => import('@/views/sys/role/manage'),
  //       meta: { title: '角色管理', keepAlive: false, hidden: false }
  //     },

  //     // 权限管理
  //     {
  //       path: '/auth',
  //       name: 'Auth',
  //       redirect: '/auth/user',
  //       component: RouteView,
  //       meta: { title: '权限管理', keepAlive: true, icon: bxAnaalyse },
  //       children: [
  //         {
  //           path: '/auth/user',
  //           name: 'AuthUser',
  //           component: () => import('@/views/sys/auth/user'),
  //           meta: { title: '用户权限管理', keepAlive: false }
  //         },
  //         {
  //           path: '/auth/role',
  //           name: 'AuthRole',
  //           component: () => import('@/views/sys/auth/role'),
  //           meta: { title: '角色权限管理', keepAlive: false }
  //         },
  //         {
  //           path: '/auth/role/modify',
  //           name: 'AuthRoleModify',
  //           component: () => import('@/views/sys/auth/modify'),
  //           hidden: true,
  //           meta: { title: '角色权限编辑', keepAlive: false }
  //         },
  //         {
  //           path: '/auth/product',
  //           name: 'AuthProduct',
  //           component: () => import('@/views/sys/auth/product'),
  //           hidden: true,
  //           meta: { title: '角色分配', keepAlive: false }
  //         },
  //         {
  //           path: '/auth/menu',
  //           name: 'AuthMenu',
  //           component: () => import('@/views/sys/auth/menu'),
  //           hidden: true,
  //           meta: { title: '产品菜单授权', keepAlive: false }
  //         },
  //       ]
  //     },

  //      // 基础管理
  //      {
  //       path: '/base',
  //       name: 'Base',
  //       redirect: '/dict/manage',
  //       component: RouteView,
  //       meta: { title: '基础管理', keepAlive: true, icon: bxAnaalyse },
  //       children: [
  //         {
  //           path: '/dict/manage',
  //           name: 'DictManage',
  //           component: () => import('@/views/base/dict/manage'),
  //           meta: { title: '字典管理', keepAlive: false }
  //         },
  //       ]
  //     }, */

  //   ]
  // },
  {
    path: '*', redirect: '/404', hidden: true
  },
  {
    path: '/login',
    name: 'Login',
    // component: RouteView
  },
  {
    path: '/404',
    component: () => import(/* webpackChunkName: "fail" */ '@/views/404')
  }

]
