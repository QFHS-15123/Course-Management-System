<template>
  <el-row  justify="start">
    <!--按钮：发布大作业-->
    <el-col :span="2"><div class="el-row-title">
      <el-button size="large" @click="addProj" v-if="show">发布大作业</el-button>
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
      <el-icon class="el-icon"><QuestionFilled /></el-icon>点击卡片查看详细内容
    </span>
  </el-row>

  <!--循环：3个card在一行-->
  <el-row :gutter="20" class="el-row" type="flex" >
    <el-col :span="6" v-for = "(index) in list_length" :key="index" class="el-col" >
      <!--card点击事件：允许弹窗true；传递index-->
      <el-card class="el-card" :key="index"
               onclick="" @click="dialog_visible=true;method(index-1)">
        <!--card标题-->
        <template v-slot:header>
          <div class="clearfix"><span>{{proj_list["proj_name"][index-1]}}</span>&#12288;
          <el-tag v-if="proj_list['proj_stat'][index-1]" type="success">已提交</el-tag>
          <el-tag v-if="proj_list['proj_stat'][index-1] === 0" type="danger">未提交</el-tag></div>
        </template>
        <!--card内容-->
        <div>
          <div class="text item">
            <div class="item_tag" ><span>所属课程：</span></div>
            <div class="item_desr"><span>{{proj_list["cour_name"][index-1]}}</span></div>
          </div>
          <div class="text item">
            <div class="item_tag"><span>发布时间：</span></div>
            <div class="item_desr"><span>{{proj_list["proj_uptime"][index-1]}}</span></div>
          </div>
        </div>
        <div class="text item">
          <div class="item_tag"><span>截止时间：</span></div>
          <div class="item_desr"><span>{{proj_list["proj_ddl"][index-1]}}</span></div>
        </div>
        <div class="text item">
          <div class="item_tag"><span>详细要求：</span></div>
          <div class="item_desr"><span>{{proj_list["proj_intro"][index-1]}}</span></div>
        </div>
      </el-card>
    </el-col>
  </el-row>

  <!--弹窗-->
  <el-dialog v-model="dialog_visible" title="Tips" width="70%">
    <!--标题-->
    <template #header>
      <div class="my-header"><h4>{{proj_list["proj_name"][index_proj]}}</h4></div>
      <!--内容-->
      <div class="my-header">{{proj_list["proj_intro"][index_proj]}}</div>
    </template>
    <!--上传文件-->
    <el-upload class="upload-demo" drag multiple  :on-remove="handleRemove"
               action="http://localhost:9000/uploadproj">
      <el-icon class="el-icon--upload"><upload-filled /></el-icon>
      <div class="el-upload__text">拖拽文件到这里或者<em>点击上传文件</em></div>
    </el-upload>
    <!--按钮：提交-->
    <el-row justify="center">
      <el-button type="primary" size="large" @click="submit">提交</el-button>
    </el-row>
  </el-dialog>
</template>

<script>
import userApi from "@/api/user";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Proj",
  data(){
    return{
      show: false,
      index_proj:"",
      list_length:0,
      proj_list:
        {
          proj_name:[],
          cour_name:[],
          proj_intro:[],
          proj_stat:[],
          proj_ddl:[],
          proj_uptime:[]
        },
    }
  },
  created() {
    // userApi.downLoad("新建文本文档.txt")
    //   .then(response => {
    //       console.log(response)
    //       //headers请求头的乱码数据转换为中文
    //       const fileName = decodeURI(response.headers['content-disposition'].split(';')[1].split('=')[1])
    //       //下载文件
    //       let blob = new Blob([response.data], {type: "application/vnd.ms-excel"})
    //       let objectUrl = URL.createObjectURL(blob) // 创建URL
    //       const link = document.createElement('a')
    //       link.href = objectUrl
    //       link.download = '.xlsx'// 自定义文件名
    //       //这里是获取后台传过来的文件名
    //       link.setAttribute("download",fileName)
    //       link.click() // 下载文件
    //       URL.revokeObjectURL(objectUrl) // 释放内存
    //     })
    //   .catch((error)=>{
    //     console.log(error);
    //     alert('下载失败')
    //   })


    const _this = this
    //获取用户Id
    let token = localStorage.getItem('Authorization');
    //根据id长度判断身份，获取大作业数据
    userApi.getStuProj(token).then(res => {
      console.log(res)
      _this.list_length = res.data.length
      for (let i=0; i<res.data.length; i++) {
        _this.proj_list["proj_name"].push(res.data[i].proj_name)
        _this.proj_list["cour_name"].push(res.data[i].cour_name)
        _this.proj_list["proj_intro"].push(res.data[i].proj_intro)
        if(res.data[i].proj_stat === "1"){
          _this.proj_list["proj_stat"].push(1)
        }else{
          _this.proj_list["proj_stat"].push(0)
        }
        _this.proj_list["proj_ddl"].push(res.data[i].proj_ddl)
        _this.proj_list["proj_uptime"].push(res.data[i].proj_uptime)
      }
    })
    },
  methods:{
    method(index){
      this.index_proj = index;
    },
    addProj(){
      this.$router.push("/add_proj");
    }
  },
}
</script>

<script  setup>
import { ref } from 'vue'
import { UploadFilled, QuestionFilled } from '@element-plus/icons-vue'
import { ElMessage } from 'element-plus'
import { useRouter } from "vue-router";

let router = useRouter();

//默认：提交框不弹出
const dialog_visible = ref(false)
const submit = () => {
  router.push("/");
  ElMessage({message: '提交成功！', type: 'success'})
}

//删除文件
const handleRemove = ( file, fileList) =>{
  userApi.delProj(file.name)
}
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
  height: 500px;
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