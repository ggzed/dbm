import BasicLayout from '/@/layouts/BasicLayout/index.vue';
import BlankLayout from '/@/layouts/BlankLayout.vue';
import type { RouteRecordRaw } from 'vue-router';

export const accessRoutes: RouteRecordRaw[] = [
  {
    path: '/app',
    name: 'app',
    component: BasicLayout,
    redirect: '/app/home',
    meta: { title: 'DBM管理平台' },
    children: [
      {
        path: '/app/home',
        component: () => import('/@/views/home/index.vue'),
        name: 'home',
        meta: {
          title: '仪表盘',
          icon: 'liulanqi',
          auth: ['home'],
        },
      },
      {
        path: '/app/table-demo2',
        name: 'table-demo2',
        component: () => import('/src/views/table-demo2/index.vue'),
        meta: {
          title: 'table-demo2',
          keepAlive: true,
          icon: 'jiedianguanli',
          auth: ['database'],
        },
      },
      {
        path: '/app/project',
        name: 'project',
        component: () => import('/src/views/project/index.vue'),
        meta: {
          title: '项目管理',
          keepAlive: true,
          icon: 'rili',
        },
      },
      {
        path: '/app/database',
        name: 'database',
        component: () => import('/src/views/database/index.vue'),
        meta: {
          title: 'DB管理',
          keepAlive: true,
          icon: 'rili',
        },
      },
      {
        path: '/app/table-demo',
        name: 'table-demo',
        component: () => import('/src/views/table-demo/index.vue'),
        meta: {
          title: '表格演示',
          keepAlive: true,
          icon: 'rili',
        },
      },
      {
        path: '/app/others',
        name: 'others',
        component: BlankLayout,
        redirect: '/app/others/about',
        meta: {
          title: '其他菜单',
          icon: 'shurumimadenglu',
          auth: ['others'],
        },
        children: [
          {
            path: '/app/others/about',
            name: 'about',
            component: () => import('/@/views/others/about/index.vue'),
            meta: { title: '关于', keepAlive: true, hiddenWrap: true },
          },
          {
            path: '/app/others/antdv',
            name: 'antdv',
            component: () => import('/@/views/others/antdv/index.vue'),
            meta: { title: '组件', keepAlive: true, breadcrumb: true },
          },
        ],
      },
      {
        path: '/sys/account',
        name: 'account',
        component: () => import('/@/views/account/index.vue'),
        meta: { title: '用户管理', keepAlive: true, breadcrumb: true },
      },
    ],
  },
];

const constantRoutes: RouteRecordRaw[] = [
  {
    path: '/login',
    component: () => import('/@/views/login/index.vue'),
    name: 'login',
    meta: { title: '登录' },
  },
  {
    path: '/',
    name: 'Root',
    redirect: '/app',
    meta: {
      title: 'Root',
    },
  },
  // ...accessRoutes,
];

export const publicRoutes = [
  {
    path: '/redirect',
    component: BlankLayout,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('/@/views/redirect/index'),
      },
    ],
  },
  {
    path: '/:pathMatch(.*)',
    redirect: '/404',
  },
  {
    path: '/404',
    component: () => import('/@/views/404.vue'),
  },
];

// /**
//  * 基础路由
//  * @type { *[] }
//  */
// export const constantRouterMap = [];

export default constantRoutes;
