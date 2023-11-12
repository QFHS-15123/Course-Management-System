<template>
  <!--标题-->
  <el-row  justify="start">
    <!--按钮：发布新闻-->
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="1"></el-col>
    <!--标题：课程介绍-->
    <el-col :span="2"><div class="el-row-title">课程介绍</div></el-col>
  </el-row>

  <el-row justify="end" class="el-row-explain">
    <span>
      <el-icon class="el-icon"><QuestionFilled /></el-icon>点击卡片查看详细内容
    </span>
  </el-row>
  <!--循环：3个card在一行-->
  <el-row :gutter="20" class="el-row" type="flex" >
    <el-col :span="8" v-for = "(index) in list_length" :key="index" class="el-col" >
      <!--card点击事件：允许弹窗true；传递index-->
      <el-card class="el-card" :key="index"
               onclick="" @click="dialog_visible=true;method(index-1)">
        <!--card标题-->
        <template v-slot:header>
          <div class="clearfix"><span>{{cour_list["cour_name"][index-1]}}</span></div>
        </template>
        <!--card内容-->
        <div>
          <div class="text item">
            <div class="item_tag" ><span>学分：</span></div>
            <div class="item_desr"><span>{{cour_list["cour_credit"][index-1]}}</span></div>
          </div>
          <div class="text item">
            <div class="item_tag" ><span>教师：</span></div>
            <div class="item_desr"><span>{{cour_list["tea_name"][index-1]}}</span></div>
          </div>
          <div class="text item">
            <div class="item_tag"><span>课程介绍：</span></div>
            <div class="item_desr"><span>{{cour_list["cour_intro"][index-1]}}</span></div>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>

  <!--弹窗-->
  <el-dialog v-model="dialog_visible" title="Tips" width="30%">
    <!--标题-->
    <template #header>
      <div class="my-header"><h4>{{cour_list["cour_name"][index_cour]}}</h4></div>
    </template>
    <!--内容-->
    <span>{{cour_list["cour_intro"][index_cour]}}</span>
  </el-dialog>
</template>

<script>
import userApi from "@/api/user";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Cour_stu",
  data(){
    return{
      index_cour:"",
      list_length:0,
      cour_list:
        {
          cour_name:[],
          tea_name:[],
          cour_credit:[],
          cour_intro:[]
        }
    }
  },
  created() {
    const _this = this
    //获取用户Id
    let token = localStorage.getItem('Authorization');
      userApi.getStuCour(token).then(res => {
        console.log(res)
        _this.list_length = res.data.length
        for (let i=0; i<res.data.length; i++){
          _this.cour_list["cour_name"].push(res.data[i].cour_name)
          _this.cour_list["tea_name"].push(res.data[i].tea_name)
          _this.cour_list["cour_intro"].push(res.data[i].cour_intro)
          _this.cour_list["cour_credit"].push(res.data[i].cour_credit)
        }
      })
  },
  methods:{
    method(index){
      this.index_cour = index;
    },
    up_cour(){
      this.$router.push("/up_cour");
    }
  },
}
</script>

<script setup>
import { QuestionFilled } from '@element-plus/icons-vue'
import { ref } from 'vue'
const dialog_visible = ref(false)
</script>


<style>.el-row-title{
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