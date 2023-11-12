import { createRouter, createWebHashHistory } from 'vue-router'
import Log_in from "@/views/Login";
import Home from "@/views/Home";
import News from "@/views/News";
import News_stu from "@/views/News_stu";
import Proj from "@/views/Proj";
import Proj_tea from "@/views/Proj_tea";
import Tea_see_stu_proj from "@/views/Tea_see_stu_proj";
import Index from "@/views/Index";
import Cour from "@/views/Cour";
import Cour_stu from "@/views/Cour_stu";
import Add_news from "@/views/Add_news";
import Add_proj from "@/views/Add_proj";
import Up_cour from "@/views/Up_cour";
import Settings from "@/views/Settings";

const routes = [
  {
    path: '/index',
    name: '主窗口',
    component: Index,
    redirect: '/home',
    children: [
      {
        path: '/home',
        name: '主页',
        component: Home
      },
      {
        path: '/news',
        name: '专业新闻-教师',
        component: News
      },
      {
        path: '/news_stu',
        name: '专业新闻-学生',
        component: News_stu
      },
      {
        path: '/cour',
        name: '课程介绍',
        component: Cour
      },
      {
        path: '/cour_stu',
        name: '课程介绍-学生',
        component: Cour_stu
      },
      {
        path: '/proj',
        name: 'Proj',
        component: Proj
      },
      {
        path: '/proj_tea',
        name: '查看大作业',
        component: Proj_tea
      },
      {
        path: '/tea_see_stu_proj',
        name: '查看班级大作业',
        component: Tea_see_stu_proj
      },
      {
        path: '/add_news',
        name: '添加新闻',
        component: Add_news
      },
      {
        path: '/add_proj',
        name: '添加大作业',
        component: Add_proj
      },
      {
        path: '/up_cour',
        name: '修改课程介绍',
        component: Up_cour
      },
      {
        path: '/settings',
        name: '账户设置',
        component: Settings
      }
    ]
  },
  {
    path: '/',
    name: '登录',
    component: Log_in
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
