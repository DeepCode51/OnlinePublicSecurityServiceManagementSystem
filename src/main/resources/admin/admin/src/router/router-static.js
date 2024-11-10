import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import jingwurenyuan from '@/views/modules/jingwurenyuan/list'
    import leixing from '@/views/modules/leixing/list'
    import news from '@/views/modules/news/list'
    import falvfagui from '@/views/modules/falvfagui/list'
    import shijiananjian from '@/views/modules/shijiananjian/list'
    import users from '@/views/modules/users/list'
    import discussfalvfagui from '@/views/modules/discussfalvfagui/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import tongzhigonggao from '@/views/modules/tongzhigonggao/list'
    import messages from '@/views/modules/messages/list'
    import discussshijiananjian from '@/views/modules/discussshijiananjian/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/jingwurenyuan',
        name: '警务人员',
        component: jingwurenyuan
      }
      ,{
	path: '/leixing',
        name: '类型',
        component: leixing
      }
      ,{
	path: '/news',
        name: '实时新闻',
        component: news
      }
      ,{
	path: '/falvfagui',
        name: '法律法规',
        component: falvfagui
      }
      ,{
	path: '/shijiananjian',
        name: '事件案件',
        component: shijiananjian
      }
      ,{
	path: '/users',
        name: '管理员',
        component: users
      }
      ,{
	path: '/discussfalvfagui',
        name: '法律法规评论',
        component: discussfalvfagui
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/chat',
        name: '在线咨询',
        component: chat
      }
      ,{
	path: '/tongzhigonggao',
        name: '通知公告',
        component: tongzhigonggao
      }
      ,{
	path: '/messages',
        name: '留言板',
        component: messages
      }
      ,{
	path: '/discussshijiananjian',
        name: '事件案件评论',
        component: discussshijiananjian
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
