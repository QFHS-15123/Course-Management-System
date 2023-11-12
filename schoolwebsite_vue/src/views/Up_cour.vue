<template>
  <!--按钮：返回-->
  <div><el-button class="el-button" size="large" @click="back">返回</el-button></div>
  <br />
  <!--表单-->
  <div>
    <el-form :model="form" label-width="200px" size="large" class="el-form">
      <!--选择课程-->
      <el-form-item label="课程">
        <el-select v-model="form.cour_id" placeholder="选择课程">
          <!--导入课程数据-->
          <el-option v-for="(item,index) in cour_list" :key="item" :label="item" :value="courid_list[index]" />
        </el-select>
      </el-form-item>
      <!--输入课程介绍-->
      <el-form-item label="课程介绍">
        <el-input v-model="form.cour_intro" type="textarea" />
      </el-form-item>
      <!--按钮：发布-->
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import userApi from "@/api/user";
import { ElMessage } from "element-plus";

export default {
  name: "Up_cour",
  data() {
    return {
      nowDate: null,
      form: {
        cour_name: '',
        cour_id: '',
        cour_intro: '',
        cour_ddl:'',
      },
      //课程名
      cour_list: [],
      //课程id
      courid_list: []
    }
  },
  created() {
    //初始化下拉框：选择课程
    const _this = this
    //获取教师id
    let token = localStorage.getItem('Authorization');
    if (token.length === 3) {
      _this.tea_id = token
    }
    let pojo = {tea_id : _this.tea_id.toString()}
    //获得课程名称和id，注入下拉框中
    userApi.getCourses(pojo).then(res => {
      for (let i=0; i<res.data.courses.length; i++){
        _this.cour_list.push(res.data.courses[i].cour_name)
        _this.courid_list.push(res.data.courses[i].cour_id)
      }
    })
  },

  methods:{
    //提交表单
    onSubmit(){
      let _this = this;
      //获取数据（注意使用数据库中的属性名）
      let pojo = {cour_id: _this.form.cour_id, cour_intro: _this.form.cour_intro}
      //发送大作业数据
      userApi.upCour(pojo).then(res => {
        if (res.data === "ok"){
          ElMessage.success('提交成功！')
          this.$router.push("/#/cour");
        }else{
          ElMessage.error('提交失败，请重试')
        }
      })
    }
  }
}
</script>

<script setup>
import { useRouter } from "vue-router";

//回到上一页
let router = useRouter();
const back = ()=> {
  router.push("/cour");
}
</script>

<style scoped>

</style>