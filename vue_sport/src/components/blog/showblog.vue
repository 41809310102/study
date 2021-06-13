<template>
       <!-- 面包屑导航 -->
     <div class="test2" style="width:1320px;height:670px;background-color: rgb(177, 198, 223);">
          <el-breadcrumb separator-class="el-icon-arrow-right">
               <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
               <el-breadcrumb-item>网络日志</el-breadcrumb-item>
               <el-breadcrumb-item>数据可视化</el-breadcrumb-item>
             </el-breadcrumb>
         <div id="myChart" style="width:800px;height:650px;float:left;margin-left: 240px"></div>
     </div>
     
   </template>
   <script>
     import * as echarts from 'echarts'
     export default {
       name: 'test2',
       data () {
         return {
         queryInfo: {
         query: "",
         pageNum: 1,
         pageSize: 4,
       },
       queryInfof: {
         query: "",
         pageNum: 1,
         pageSize: 100,
       },
           myChart: '',
           opinionData2: [
     

           ]
         }
       },
       mounted: function () {
          this.drawLine();

       },
       created() {
         this.getdateList();
      },
       methods: {
          async  drawLine () {
              // 调用post请求
      const { data: res } = await this.$http.get("alldate", {
        params: this.queryInfo
      });
      if (res.flag != "success") {
        return this.$message.error("该数据获取失败！！！");
      }

      console.log(res.flag)
       this.opinionData2 = res.opinionData2; // 将返回数据赋值
           this.myChart = echarts.init(document.getElementById('myChart'))
           this.myChart.setOption({
             title: {
               text: '网络日志异常流量分析', // 主标题
               subtext: '', // 副标题
               x: 'left' // x轴方向对齐方式
             },
             grid: { containLabel: true },
             tooltip: {
               trigger: 'item',
               formatter: '{a} <br/>{b} : {d}%'
             },
             // color: ['#1FC48D', '#F5A60A', '#6DC8EC', '#3F8FFF'],
             color: ['#1FC48D', 'red', '#6DC8EC', '#3F8FFF'],
             // backgroundColor: '#ffffff',
             legend: {
               orient: 'vertical',
               icon: 'circle',
               align: 'left',
               x: 'right',
               y: 'bottom',
               data: ['审计url异常', '正常网络日志', '流量日志异常', '威胁攻击日志']
             },
             series: [
               {
                 name: '网络日志状态',
                 type: 'pie',
                 radius: ['50%', '70%'],
                 avoidLabelOverlap: false,
                 center: ['40%', '50%'],
                 itemStyle: {
                   emphasis: {
                     shadowBlur: 10,
                     shadowOffsetX: 0,
                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                   },
                   color: function (params) {
                     // 自定义颜色
                     var colorList = ['#1FC48D', 'red', '#6DC8EC', '#3F8FFF']
                     return colorList[params.dataIndex]
                   }
                 },
                 data: this.opinionData2
               }
             ]
           })
         },
         async getdateList() {
      // 调用post请求
      const { data: res } = await this.$http.get("getupdata", {
        params: this.queryInfof
      });
      if (res != "success") {
        return this.$message.error("该数据获取失败！！！");
      }
      console.log(res)
        },
       }
     }
     </script>
     