// page/component/showimg/showimg.js

const db = wx.cloud.database()
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
   shoeimg:[]
  },

  /*
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
 db.collection('showimg').get().then(res=>{
      this.setData({
        showimg:res.data
      })
  })

  },
into:function(){
  
    // 当点击图片上的事件的时候，触发这个函数
     wx.switchTab({
     //  因为是跳转到tab界面，所以使用switchTab属性
       url: '../index/index',//跳转的指定路径
     })
  

},



  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})