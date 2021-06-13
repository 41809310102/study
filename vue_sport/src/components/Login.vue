<template>
  <div class="login_container" >
  <h1 style="color:#fff;font-size:65px; transform: translate(17%, 20%);">网络日志异常检测平台</h1>
    <div class="login_box">
      <div class="avatar_box">
        <!--头像-->
        <img src="https://th.bing.com/th/id/R1078a63ee84a205ab42ed0e41c0250e7?rik=Jq2uRH%2fml8dOXg&riu=http%3a%2f%2fpic131.nipic.com%2ffile%2f20170530%2f23159666_122900304000_2.jpg&ehk=5azagH6NiywyR8QgiO93%2fUXp0QuPdAUy0OkN1BK70Io%3d&risl=&pid=ImgRaw" alt />
      </div>
      <!--添加表单-->
      <el-form
        ref="loginFormRef"
        :model="loginForm"
        :rules="loginRules"
        class="login_form"
        label-width="0px"
      >
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" prefix-icon="iconfont icondenglu"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" prefix-icon="iconfont iconmima" type="password"></el-input>
        </el-form-item>
        <el-form-item class="btns">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="resetLoginForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loginForm: {
        username: "admin",
        password: "123456"
      },
      loginRules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 5, max: 8, message: "长度在 5 到 8 个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, max: 8, message: "密码为 6~8 位", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    resetLoginForm() {
      this.$refs.loginFormRef.resetFields();
    },
    login() {
      this.$refs.loginFormRef.validate(async valid => {
        if (!valid) return;
        // 调用get请求
        const {data :res} = await this.$http.post("login", this.loginForm);
         if (res == "ok" ) {
           window.sessionStorage.setItem('flag','ok'); // session 放置
           this.$message.success("登陆成功！！！");
           this.$router.push({ path: "/home"});
         }else{
          this.$message.error("登录失败！！！");
         }
      });
    }
  }
};
</script>

<style lang="less" scoped>

// 跟节点样式
.login_container {
    display: flex;// 弹性布局
   width: 100%;
  height: 100%;
  background-image: url("https://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/64380cd7912397dd7bae29c85482b2b7d1a28723.jpg");
  background-size: cover;
  background-position: center;
  position: relative;
  box-shadow: 0 0 10px #ddd;// 盒子阴影

}
// 登录框
.login_box {
  width: 450px;
  height: 300px;
  background-color: rgba(244, 247, 250, 0.747);
  border-radius: 3px;// 圆角
  position: absolute;// 绝对定位
  left: 50%;
  top: 50%;
  transform: translate(20%, -50%);// 根据自己位置 以自己为长度位移
  // 头像框
  .avatar_box {
    width: 100px;
    height: 100px;
    border: 1px solid #eee;
    border-radius: 50%; // 加圆角
    padding: 10px;
    box-shadow: 0 0 10px #ddd;// 盒子阴影
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #0ee;
    img {
      width: 100%;
      height: 100%;
      border-radius: 50%; // 加圆角
      background-color: #eee;
    }
  }
  .btns {
    display: flex;// 弹性布局
    justify-content: flex-end; // 尾部对齐
  }
  .login_form {
    position: absolute;
    bottom: 0%;
    width: 100%;
    padding: 0 10px;
    box-sizing: border-box;// 设置边框
  }
}
</style>