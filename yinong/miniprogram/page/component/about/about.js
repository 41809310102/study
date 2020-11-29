// pages/about/about.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
        des:'本程序可以发布你的信息在网上，其功能如下,使用对象主要是农民，牧民，以及需要购买农产品的消费者和需要承接农作物收割\n\n 1.帮助农民朋友解决生产方面问题。\n 2.预约一些服务。\n 3.在线购买，出售产品。\n 4.可与本APP合作推出农产品进行销售。\n\n如果要加盟请看下方联系方式'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  onReady: function () {

  },
  //复制
  copy(e) {
        wx.setClipboardData({
              data: e.currentTarget.dataset.copy,
              success: res => {
                    wx.showToast({
                          title: '复制' + e.currentTarget.dataset.name + '成功',
                          icon: 'success',
                          duration: 1000,
                    })
              }
        })
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