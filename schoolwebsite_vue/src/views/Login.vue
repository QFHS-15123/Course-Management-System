<template>
  <el-container class="el-container">
    <el-header height="80px"><div></div></el-header>
    <el-main>
      <el-row>
      <el-col :span="8"></el-col>
        <el-col :span="8">
      <el-card class="box-card">
        <template #header>
          <div class="card-header">
              <!--华理logo-->
              <el-image style="width: 273px; height: 48px" margin: auto
                      :src="require('../assets/logo.png')" fit='cover' />
          </div>
        </template>

        <el-form ref="login_formRef" label-width="100px" :rules="rules" :model="loginUser"
            hide-required-asterisk size="large"  class="el-form">
<!--      输入用户名-->
          <el-form-item label="学号/工号：" prop="id_rules">
<!--            <el-col :span="20">-->
              <el-input v-model='loginUser.account'></el-input>
<!--            </el-col>-->
          </el-form-item>
<!--      输入密码-->
          <el-form-item class="clearfix" label="密码：" prop="pw_rules">
<!--            <el-col :span="20">-->
              <el-input v-model='loginUser.password' show-password></el-input>
<!--            </el-col>-->
          </el-form-item>
<!--      登录按钮-->
          <el-form-item>
            <el-button type="primary" @click="login()" class="login_btn">登录</el-button>
          </el-form-item>
        </el-form>
      </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>


<script>
import userApi from "@/api/user";
import { mapMutations } from 'vuex';
import { ElMessage } from 'element-plus';

export default {
  name: "Log_in",
  data(){
    return{
      rules:{
        // trigger = blur失去焦点触发
        id_rules:[{required: true, message: '请输入学号/工号', trigger: 'blur'}],
        pw_rules:[{required: true, message: '请输入密码', trigger: 'blur'}]
      },
      loginUser:{
        account:'',
        password:''
      }
    }
  },
  methods:{
    //调用store/index.js中的changeLogin
    ...mapMutations(['changeLogin']),
    //按钮：提交
    login(){
      let _this = this;
      //获取输入的用户名、密码（注意使用数据库中的属性名）
      let pojo = { account : _this.loginUser.account, password: _this.loginUser.password }
      //发送数据到后端'/login'
      userApi.login(pojo).then(res => {
        if (res.data.flag === "ok"){
          ElMessage.success('登录成功！')
          //写权限
          _this.changeLogin({ Authorization: _this.loginUser.account });
          //跳转页面
          this.$router.push("/home");
        } else {
          ElMessage.error('用户名或密码错误')
        }
      })
    }
  }
}
</script>

<script setup>
// import {ref} from 'vue';
//
// const loginformRef = ref(null);

  // loginformRef.value.validate((valid) => {
  //   if (valid) {
  //     ElMessage.success('login successfully !')
  //     router.push("/#/");
  //   } else {
  //     ElMessage.error('error submit !')
  //     return false
  //   }
  // })

</script>

<style scoped>
.el-container{
  background: #ecf5ff;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.el-form{
  /*设置宽度*/
  width:100%;
}
.box-card {
  width: 200px;
  height: auto;
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.el-card:hover{
  margin-top: 0;
}
</style>