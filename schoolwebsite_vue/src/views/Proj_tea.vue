<template>
  <el-row  justify="start">
    <!--按钮：发布大作业-->
    <el-col :span="2"><div class="el-row-title">
      <el-button size="large" @click="addProj">发布大作业</el-button>
    </div></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="1"></el-col>
    <!--标题：大作业-->
    <el-col :span="2"><div class="el-row-title">大作业</div></el-col>
  </el-row>

  <!--提示：点击卡片查看详细内容-->
  <el-row justify="end" class="el-row-explain">
    <span>
      <el-icon class="el-icon"><QuestionFilled /></el-icon>点击行查看详细内容
    </span>
  </el-row>

  <el-table :data="proj_list" stripe style="width: 100%" @row-click="seeDtl" size="large">
    <el-table-column prop="proj_name" label="大作业标题" width="180" />
    <el-table-column prop="cour_name" label="所属课程" width="180" />
    <el-table-column prop="stu_count" label="提交情况" />
<!--    <el-table-column prop="all_stu_count" label="学生总数" />-->
  </el-table>

</template>

<script>
import userApi from "@/api/user";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Proj_tea",
  data(){
    return{
      index_proj:"",
      proj_list:[],
    }
  },
  created() {
    const _this = this
    //获取用户Id
    let token = localStorage.getItem('Authorization');
    //根据id长度判断身份，获取大作业数据
      userApi.getTeaProj(token).then(res => {
          _this.proj_list = res.data
        console.log(_this.proj_list)
      })
    },
  methods:{
    addProj(){
      this.$router.push("/add_proj");
    },
    seeDtl(row){

      this.$router.push({
          path:"/tea_see_stu_proj",
          query:{
            cour_id: row["cour_id"],
          }
      });
    }
  },
}
</script>

<script setup>
import { QuestionFilled } from '@element-plus/icons-vue'
</script>


<style>
.el-row-title{
  font-size: 20px;
}
.all{
  margin-top: -30px;
  word-break: break-all;
  height: 100%;
}
.mid{
  margin-top: 25%;
  height: 50%;
}
.mid_item{
  justify-content: center;
  align-items: center;
}
.item {
  margin-bottom: 10px;
}
.item_tag{
  float:left;
  text-align:left;
}
.item_desr{
  margin-left: 40%;
  min-height: 30px;
  text-align: left;
  overflow:hidden; /*溢出的部分隐藏*/
  white-space: nowrap; /*文本不换行*/
  text-overflow:ellipsis;
}
.text {
  width: 100%;
  font-size: 12px;
  font-family: "Microsoft YaHei";
  color: #909399;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.el-card {
  min-width: 100%;
  height: 200px;
  margin-right: 20px;
  /*transition: all .5s;*/
}
.el-card:hover{
  margin-top: -5px;
}
.el-row {
  margin-bottom: 20px;
  display: flex;
  flex-wrap: wrap
}
.el-row-explain{
  font-size: 12px;
  color:  #79bbff;
  margin-top: -5px;
}
.el-col {
  border-radius: 4px;
  align-items: stretch;
  margin-bottom: 40px;
}
.el-icon{
  margin-right: 8px;
  vertical-align: middle;
}
.dialog-footer button:first-child {
  margin-right: 10px;
}
.my-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>