const db=wx.cloud.database();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:"",
    showAuth:true,
    openid:"",
  },
  getUserInfo:function(e){
    wx.getUserProfile({
      desc: '用于完善会员资料', 
      success: (res) => {
        this.setData({
          userInfo: res.userInfo,
          showAuth: false
        })
      }
    })
  },
  uppage:function(e){
    var that=this;
    wx.setStorageSync('userInfo',that.data.userInfo)
    var userInfo=wx.getStorageSync('userInfo')
    console.log(userInfo)
      wx.switchTab({
        url: '../index/index',
      })
  },
  onLoad:function(){
    var that=this;
    wx.login({
      success (res) {
       // console.log(res.code)
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session',
          data:{
            appid:'wx0a4c42857a83bbb9',
            secret:'8f459e14b1e6e91e8d627e72b8ab134c',
            js_code:res.code,
            grant_type:'authorization_code'
          },
          method:"GET",
          success:function(res){
            that.setData({
              openid:res.data.openid
            })
            console.log(that.data.openid)
            wx.setStorageSync('openid',that.data.openid)
            db.collection("Users").where({
              _openid:wx.getStorageSync('openid')
            }).get().then(res=>{
              if(res.data.length){
                that.setData({
                  showAuth:false,
                  userInfo:res.data[0].userInfo
                })
              }
            })
          }
        })
        }
    })
  }

})