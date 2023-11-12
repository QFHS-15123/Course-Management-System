<template>
  <!--按钮：返回-->
  <div><el-button class="el-button" size="large" @click="back">返回</el-button></div>
  <br />
<!--  <div>{{proj_stu_list.cour_name}}</div>-->
  <el-table :data="proj_list" stripe style="width: 100%">
    <el-table-column prop="stu_id" label="学号" width="180" />
    <el-table-column prop="stu_name" label="姓名" width="180" />
    <el-table-column prop="proj_stat" label="提交情况" width="180" />
    <el-table-column prop="proj_subtime" label="提交时间" width="180" />
    <el-table-column label="">
      <template #default="scope">
        <el-button size="small" :disabled="dlbtn"
                   @click="downloadProj(scope.$index, scope.row)">下载</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import userApi from "@/api/user";

export default {
  name: "Tea_see_stu_proj",
  data(){
    return{
      dlbtn:"true",
      cour_id:'',
      proj_list:[]
    }
  },
  mounted() {
    const _this = this
    _this.cour_id = this.$route.query.cour_id
    userApi.getTeaStuProj(_this.cour_id).then(res => {
      console.log(res)
      _this.proj_list = res.data
      console.log(_this.proj_list)
    })
  },
  methods:{
    back(){
      this.$router.push('/proj_tea')
    }
  }
}
</script>

<style scoped>

</style>