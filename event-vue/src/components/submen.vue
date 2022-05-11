<template>
  <div>
    <!--叶子级菜单-->
    <template v-if="item.children==null">
      <el-menu-item :key="item.id" :index="item.path">{{item.nameZh}}</el-menu-item>
    </template>
    <!--父级菜单-->
    <el-submenu v-else :index="item.path" style="text-align: left">
      <span slot="title" style="font-size: 17px;">
        <i :class="item.iconCls"></i>
        {{item.nameZh}}
      </span>
      <template v-for="child in item.children">
        <navigationitem
          v-if="child.children && child.children.length>0"
          :key="child.id"
          :item="child"
        />
        <el-menu-item v-else :key="child.id" :index="child.path">
          <i :class="child.icon"></i>
          {{child.nameZh}}
        </el-menu-item>
      </template>
    </el-submenu>
  </div>
</template>
 
<script>
export default {
  name: "NavigationItem",
  props: {
    item: {
      type: Object,
      required: true
    }
  }
};
</script>
