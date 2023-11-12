<template>
  <el-row  justify="start">
    <!--按钮：发布新闻，根据权限隐藏-->
    <el-col :span="2"><div class="el-row-title">
      <el-button size="large" @click="add_news" v-if="show">发布新闻</el-button>
    </div></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="2"></el-col>
    <el-col :span="1"></el-col>
    <!--标题：专业新闻-->
    <el-col :span="2"><div class="el-row-title">专业新闻</div></el-col>
  </el-row>

  <!--提示：点击卡片查看详细内容-->
  <el-row justify="end">
    <span class="el-row-explain">
      <el-icon class="el-icon"><QuestionFilled /></el-icon>点击卡片查看详细内容
    </span>
  </el-row>

  <!--创建card-->
  <el-row :gutter="20" class="el-row" type="flex">
    <!--循环：3个card在一行-->
    <el-col :span="8" v-for = "(index) in list_length" :key="index" class="el-col" >
      <!--card点击事件：允许弹窗true；传递index-->
      <el-card class="el-card" :key="index"
               onclick="" @click="dialog_visible=true;method(index-1)">
        <!--card标题：新闻标题-->
        <template v-slot:header>
          <div class="clearfix"><span>{{news_list["news_name"][index-1]}}</span></div>
        </template>
<!--        card内容-->
        <div>
          <div class="text item">
            <div class="item_tag"><span>发布时间：</span></div>
            <div class="item_desr"><span>{{news_list["news_uptime"][index-1]}}</span></div>
          </div>
          <div class="text item">
            <div class="item_tag"><span>课程：</span></div>
            <div class="item_desr"><span>{{news_list["cour_name"][index-1]}}</span></div>
          </div>
          <div class="text item">
            <div class="item_tag" ><span>新闻内容：</span></div>
            <div class="item_desr"><span>{{news_list["news_info"][index-1]}}</span></div>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>

  <!--弹窗：新闻内容-->
  <el-dialog v-model="dialog_visible" title="Tips" width="30%">
    <!--标题-->
    <template #header>
      <div class="my-header"><h4>{{news_list["news_name"][index_news]}}</h4></div>
    </template>
    <!--内容-->
    <span>{{news_list["news_info"][index_news]}}</span>
  </el-dialog>
</template>

<script>
import userApi from "@/api/user";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "News",
  data(){
    return{
      show: false,
      index_news:"",
      list_length:0,
      news_list:
        {
          "news_name":[],
          "news_info":[],
          "news_uptime":[],
          "cour_name":[]
        }
    }
  },
  created() {
    const _this = this
    //获取用户Id
    let token = localStorage.getItem('Authorization');
      _this.show = true
      let pojo = {tea_id : token}
      userApi.getTeaNews(pojo).then(res => {
        _this.list_length = res.data.length
        for (let i=0; i<res.data.length; i++){
          _this.news_list["news_name"].push(res.data[i].news_name)
          _this.news_list["news_info"].push(res.data[i].news_info)
          _this.news_list["news_uptime"].push(res.data[i].news_uptime)
          _this.news_list["cour_name"].push(res.data[i].cour_name)
        }
        console.log(_this.news_list["news_name"])
      })
  },
  methods:{
    method(index){
      this.index_news = index;
    },
  }
}
</script>


<script setup>
import { ref } from 'vue'
import { QuestionFilled } from '@element-plus/icons-vue';
import { useRouter } from "vue-router";

let router = useRouter();
const add_news = ()=> {
  router.push("/add_news");
}

const dialog_visible = ref(false)
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
  min-height: 200px;
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
.el-row-title{
  margin-bottom: -80px;
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