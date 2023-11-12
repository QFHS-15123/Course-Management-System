<template>
<el-container  class="el-container1" style="height: 100%;">
  <!--页面顶部-->
  <el-header class="el-header" height="50px">
      <div class="toolbar">
        <!--欢迎文字-->
        <span>{{ user_name }}，欢迎登录&#12288;</span>
        <!--链接：退出登录-->
        <el-link type="info" class="el-button_logout" :underline="false" @click="logout">退出登录</el-link>
      </div>
  </el-header>

    <el-container>
      <!--侧边栏-->
      <el-aside width=100px class="el-aside">
        <!--菜单-->
        <div>
          <br />
          <!--按钮：新闻-->
          <el-row justify="center">
            <!--悬浮气泡-->
            <el-tooltip effect="light" content="主页" placement="right">
              <!--按钮：主页，链接到”主页“页面-->
              <el-button @click="login0()" type="primary" plain size="large">主页</el-button>
            </el-tooltip>
          </el-row>
          <br />
          <!--按钮：新闻-->
          <el-row justify="center">
            <!--悬浮气泡-->
            <el-tooltip effect="light" content="专业新闻" placement="right">
              <!--按钮：新闻，链接到”专业新闻“页面-->
              <el-button @click="login()" type="primary" plain size="large">新闻</el-button>
            </el-tooltip>
          </el-row>
          <br />
          <!--按钮：作业-->
          <el-row justify="center">
            <el-tooltip effect="light" content="大作业提交" placement="right">
              <el-button  @click="login2()" type="primary" plain size="large">作业</el-button>
            </el-tooltip>
          </el-row>
          <br />
          <!--按钮：课程-->
          <el-row justify="center">
            <el-tooltip effect="light" content="课程介绍" placement="right">
              <el-button @click="login3()" type="primary" plain size="large">课程</el-button>
            </el-tooltip>
          </el-row>
          <br />
          <!--按钮：设置-->
          <el-row justify="center">
            <el-tooltip effect="light" content="账户设置" placement="right">
              <el-button @click="login4()" type="primary" plain size="large">设置</el-button>
            </el-tooltip>
          </el-row>
        </div>
      </el-aside>

<!--  页面主体，链接到其他页面-->
      <el-main  class="el-main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>


<script>
import userApi from "@/api/user";
import { mapMutations } from "vuex";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Index",
  data(){
    return{
      user_name : ""
    }
  },
  created() {
    const _this = this
    //获取id
    let token = localStorage.getItem('Authorization');
    //获取用户名
    let pojo = {account : token}
    //获得课程名称和id，注入下拉框中
    userApi.getName(pojo).then(res => {
      _this.user_name = res.data
    })
    },
  methods: {
    //调用store/index.js中的changeLogin
    ...mapMutations(['changeLogin']),
    logout(){
      let _this = this;
      //写权限
      _this.changeLogin({ Authorization: null });
      //跳转页面
      this.$router.push("/");
    }
  }
  }
</script>

<script setup>
import { useRouter } from "vue-router";

let router = useRouter();

const login0 = ()=> {
  router.push("/home");
}

const login = ()=> {
  let token = localStorage.getItem('Authorization');
  if (token.length === 3){
    router.push("/news");
  }else {
    router.push("/news_stu");
  }
}

const login2 = ()=> {
  let token = localStorage.getItem('Authorization');
  if (token.length === 3){
    router.push("/proj_tea");
  }else {
    router.push("/proj");
  }
}

const login3 = ()=> {
  let token = localStorage.getItem('Authorization');
  if (token.length === 3){
    router.push("/cour");
  }else {
    router.push("/cour_stu");
  }
}

const login4 = ()=> {
  router.push("/settings");
}

</script>

<style scoped>
.el-container1{
  /*铺满屏幕*/
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.el-header{
  background: #337ecc;
  text-align: right;
  color: aliceblue;
  font-size: 14px;
}
.el-aside{
  box-sizing: border-box;
  height: 100%;
}
.el-main{
  background: #ecf5ff;
  height: 100%;
}
.el-dropdown-link{
  color: aliceblue;
}
.el-icon{
  margin-right: 8px;
  vertical-align: middle;
}
.el-container .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
.el-button_logout{
  color: white;
}
.el-button_logout:hover{
  color: white;
}
</style>