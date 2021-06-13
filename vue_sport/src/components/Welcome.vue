<template>
  <div class="block">
    <span class="demonstration">欢迎来到网络日志检测平台</span>
    <el-carousel height="600px">
      <el-carousel-item v-for="item in Data" :key="item">
         <img :src="item.img" alt />
      </el-carousel-item>
    </el-carousel>
  </div>
</template>


<style lang="less" scoped>
  .el-carousel__item img {
   width:100%;
   height:100%;
  }

  .el-carousel__item:nth-child(2n) {
     background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
     background-color: #d3dce6;
  }
  .block{
    .demonstration{
        color: #475669;
       font-size: 28px;
      margin-left: 480px;
    }
  }
  
</style>
<script>
export default {
    data(){
        return {
            Data: [{
              id:0, img:'https://img95.699pic.com/photo/40007/2327.jpg_wh860.jpg',
          }, {
              id:2, img:'https://img95.699pic.com/photo/50051/5526.jpg_wh860.jpg',
          }, {
              id:3, img:'https://th.bing.com/th/id/R75190fde2c0ef5e99b2b3b19139013cf?rik=lZsA6vEnAGR6TA&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50046%2f3181.jpg_wh1200.jpg&ehk=Zf%2f7NmTc03hpS0gPYhSYUwYIBQDx1DvqM%2fjvibcVZQw%3d&risl=&pid=ImgRaw',
          }]
        }

        }
    }
    
</script>