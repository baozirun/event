<template>
  <div>
    <el-menu>
      <navigationitem v-for="(menu,i) in adminMenus" :key="i" :item="menu" />
    </el-menu>
  </div>
</template>
<script>
export default {
  data() {
    return {
      adminMenus: [
        {
          id: 1,
          path: "/admin",
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
              path: "/bgfbfbgf",
              iconCls: null,
              nameZh: "用户信息",
              parentId: 2,
              children: null
            },
            {
              id: 7,
              path: "/gbfbdb",
              iconCls: null,
              nameZh: "角色配置",
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
              path: "/dbfdbdbf",
              nameZh: "就业部类",
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
      ]
    };
  }
};
</script>
