// miniprogram/page/component/orders_details/orders_datails.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    order_details: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: '订单'  //修改title
    })
    var that=this;
    console.log(111);
    console.log(JSON.parse(options.order_details));
    that.setData({
      order_details: JSON.parse(options.order_details)
      })
    // var that = this;
    // const db = wx.cloud.database();
    // db.collection("orders").get({
    //   success(res) {
    //     that.setData({
    //       order_details: res.data
    //     })
    //   }
    // })
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