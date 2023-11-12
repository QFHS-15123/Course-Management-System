<template>
<el-button :icon="PictureFilled" @click="go1">新闻</el-button>
<el-button :icon="Document" @click="go2">作业</el-button>
<el-button :icon="School" @click="go3">课程</el-button>
<el-button :icon="Setting" @click="go4">设置</el-button>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Home",
  token: "",
  created() {
    let _this = this
    _this.token = localStorage.getItem('Authorization');
  },
  methods:{
    go1(){
      let _this = this
      if (_this.token.length === 3){
        this.$router.push('/news')
      }else{
        this.$router.push('/news_stu')
      }
    },
    go2(){
      let _this = this
      if (_this.token.length === 3){
        this.$router.push('/proj_tea')
      }else{
        this.$router.push('/proj')
      }
    },
    go3(){
      let _this = this
      if (_this.token.length === 3){
        this.$router.push('/cour')
      }else{
        this.$router.push('/cour_stu')
      }
    },
    go4(){
      this.$router.push('/settings')
    },
  }
}
</script>

<script setup>
import { PictureFilled, Document, School, Setting } from '@element-plus/icons-vue'
</script>

<style scoped>
.el-button{
  width:250px;
  height:250px;
  font-size: 40px;
}
</style>