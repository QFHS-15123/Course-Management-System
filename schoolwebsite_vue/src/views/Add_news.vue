<template>
  <!--按钮：返回-->
  <div><el-button class="el-button" size="large" @click="back">返回</el-button></div>
  <br />
  <!--表单-->
  <div>
  <el-form :model="form" label-width="200px" size="large" class="el-form">
    <!--输入新闻标题-->
    <el-form-item label="新闻标题">
      <el-input v-model="form.news_name" />
    </el-form-item>
    <!--选择课程-->
    <el-form-item label="发布对象">
      <el-select v-model="form.cour_id" placeholder="选择课程">
        <!--导入课程数据-->
        <el-option v-for="(item,index) in cour_list" :key="item" :label="item" :value="courid_list[index]" />
      </el-select>
    </el-form-item>
    <!--输入新闻内容-->
    <el-form-item label="新闻内容">
      <el-input v-model="form.news_info" type="textarea" />
    </el-form-item>
    <!--按钮：发布-->
    <el-form-item>
      <el-button type="primary" @click="onSubmit">发布</el-button>
    </el-form-item>
  </el-form>
  </div>
</template>


<script>
import userApi from "@/api/user";
import { ElMessage } from "element-plus";

export default {
  name: "Add_news",
  data() {
    return {
      tea_id:'',
      nowDate: null,
      form: {
        news_name: '',
        cour_id: '',
        news_info: ''
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
      //获得当前时间
      _this.nowDate = new Date().toLocaleString();
      //获取数据（注意使用数据库中的属性名）
      let pojo = {news_name : _this.form.news_name, cour_id: _this.form.cour_id,
        news_info: _this.form.news_info, tea_id : _this.tea_id, news_uptime : _this.nowDate}
      //发送新闻数据
      userApi.add_news(pojo).then(res => {
        if (res.data === "ok"){
          ElMessage.success('提交成功！')
          this.$router.push("/#/news");
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
  router.push("/news");
}
</script>

<style>
.el-form{
  /*设置宽度*/
  width: 80%;
}
</style>


