// miniprogram/page/component/update_password/update_password.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    codename: '获取验证码',
    registerNum: '',
    showPassword: false,
    disabled: false,
    newPassword: '',
    mustPassword: '',
    code: ''
  },
  codeInput: function(e) {
    this.setData({
      code: e.detail.value
    })
  },
  newPassword: function(e) {
    this.setData({
      newPassword: e.detail.value
    })
  },
  mustPassword: function(e) {
    this.setData({
      mustPassword: e.detail.value
    })
  },
  phoneNumber: function(e) {
    this.setData({
      registerNum: e.detail.value
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },
  must() {
    var that = this;
    var password = /^[0-9]{6}$/;
    if (that.data.code==''){
      wx.showToast({
        title: '请输入验证码',
        icon: 'none',
        duration: 1000,
        mask: true,
      })
    }
    else if (that.data.newPassword == '') {
      wx.showToast({
        title: '请输入新密码',
        icon: 'none',
        duration: 1000,
        mask: true,
      })
    } 
    else if ( !(password.test(that.data.newPassword))){
      wx.showToast({
        title: '新密码为六位数字',
        icon: 'none',
        duration: 1000,
        mask: true,
      })
    }
    else if (that.data.mustPassword == '') {
      wx.showToast({
        title: '请输入确认密码',
        icon: 'none',
        duration: 1000,
        mask: true,
      })
    } else if (that.data.mustPassword != that.data.newPassword) {
      wx.showToast({
        title: '两次密码不一样',
        icon: 'none',
        duration: 1000,
        mask: true,
      })
    } else if (that.data.code != '123456') {
      wx.showModal({
        title: '提示',
        content: '验证码不正确',
        showCancel:false,
      })
    } else {
      wx.cloud.callFunction({
        name:'update_password',
        data:{
          registerNum: that.data.registerNum,
          newPassword: that.data.newPassword,
        },
        success(res){
          wx.showToast({
            title: '修改成功',
            mask: true,
          })
          setTimeout(function(){
            wx.showLoading({
              title: '',
            })
          },1500)
          setTimeout(function(){
            wx.navigateBack({
            })
            wx.hideLoading();
          },3000)
          
        }
      })
    }
  },
  gainCode: function() {
    var a = this.data.phone;
    var _this = this;
    var code = '';
    var myreg = /^(14[0-9]|13[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$$/;
    if (this.data.registerNum == "") {
      wx.showToast({
        title: '手机号不能为空',
        icon: 'none',
        duration: 1000,
        mask: true,
      })
      return false;
    } else if (!myreg.test(this.data.registerNum)) {
      wx.showToast({
        title: '请输入正确的手机号',
        icon: 'none',
        duration: 1000,
        mask: true,
      })
      return false;
      // } else if (_this.data.registerPassword == "") {
      //   wx.showToast({
      //     title: '密码不能为空',
      //     icon: 'none',
      //     duration: 1000
      //   })
      //   return false;
    } else {

      for (var i = 0; i < 4; i++) {
        code += Math.floor(Math.random() * 10);
      }
      _this.setData({
        code: 123456
      })
      // zhenzisms.client.init('https://sms_developer.zhenzikj.com', '100495', 'OTM2ZjM0NzItNWJmMC00MDMyLTk2NWYtODIxMmUzZWU1NGZj');
      // zhenzisms.client.send(function(res) {
      // if (_this.data.code == 0) {
      var num = 60;
      var timer = setInterval(function() {
        num--;
        if (num <= 0) {
          clearInterval(timer);
          _this.setData({
            codename: '重新发送',
            disabled: false,
          })
        } else {
          _this.setData({
            codename: num + "s",
            disabled: true,
            showPassword: true,
          })
        }
      }, 1000)
      return true;
      // }
      // wx.showToast({
      //   title: "请输入验证码",
      //   icon: 'none',
      //   duration: 2000
      // })
      // }, _this.data.registerNum, '一木瑜伽注册验证码:' + _this.data.code + ",若已经注册,请忽略本条信息");

    }

  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    this.setData({
      showPassword: false,
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})