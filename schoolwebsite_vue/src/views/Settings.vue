<template>
  <el-row justify="center"><div class="el-row-title">修改密码</div></el-row>
  <!--表单-->
    <el-row>
      <el-col :span="4"></el-col>
      <el-col :span="12">
    <el-form :model="form" label-width="200px" size="large" class="el-form">
      <!--输入新密码-->
      <el-form-item label="新密码">
        <el-input v-model="form.stu_pw_1" />
      </el-form-item>
      <!--确认密码-->
      <el-form-item label="确认密码">
        <el-input v-model="form.stu_pw_2" />
      </el-form-item>
    </el-form>
      </el-col>
    </el-row>
  <el-row>
    <el-col :span="11"></el-col>
    <el-col :span="12">
      <!--按钮：确定-->
        <el-button type="primary" @click="onSubmit" size="large">确定</el-button>
    </el-col>
  </el-row>

</template>

<script>
import userApi from "@/api/user";
// import { ElMessage } from "element-plus";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Settings",
  data() {
    return {
      form: {
        stu_pw_1: '',
        stu_pw_2: ''
      }
    }
  },
  methods:{
    //提交表单
    onSubmit(){
      const _this = this
      let token = localStorage.getItem('Authorization');
      let pojo = {account : token, password : _this.form.stu_pw_2}
      //获得课程名称和id，注入下拉框中
      userApi.setPassword(pojo).then(res => {
        console.log(res)
      })
    }
  }
}
</script>


<style scoped>
.el-row-title{
  font-size: 20px;
  margin-bottom: 15px;
}
.el-form{
  width: 100%;
}
.el-col{
  margin-bottom: 0;
}
</style>