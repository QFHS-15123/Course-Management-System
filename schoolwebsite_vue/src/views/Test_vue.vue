<!--<template>-->
<!--  <div></div>-->
<!--&lt;!&ndash;  <el-button @click="clickit"></el-button>&ndash;&gt;-->
<!--</template>-->

<!--<script>-->
<!--import $axios from 'axios'-->

<!--export default {-->
<!--  name: "Test_vue",-->
<!--  data() {-->
<!--    return {-->
<!--      alist: [1],-->
<!--    };-->
<!--  },-->
<!--  async beforeRouteEnter(to, from, next) {-->
<!--    const {-->
<!--      data: {data},-->
<!--    } = await $axios.get(`http://localhost:9000/getnews`);-->
<!--    next((vm) => vm.location(data));-->
<!--    console.log(data)-->
<!--  },-->
<!--  methods: {-->
<!--    location(data) {-->
<!--      this.alist = data;-->
<!--    },-->
<!--    // clickit(){-->
<!--    //   const tabCmp = new Vue.extend({-->
<!--    //     template: "#tab",-->
<!--    //     props: ['tabname']-->
<!--    //   }).$mount()-->
<!--    }-->
<!--  }-->



<!--</script>-->

<!--<script setup>-->

<!--</script>-->

<!--<style scoped>-->

<!--</style>-->