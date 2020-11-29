// miniprogram/page/component/manger/manger.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    chushou_count: '',
    xiajia_count: '',
    fahuo:'',//待发货数量
    yifahuo:'',//已发货数量
  },
  xiugai_goods(){
    wx.navigateTo({
      url: '../xiugai_goods/xiugai_goods' ,
    })
  },
  goods_manger(){
    var i = 1;
    wx.navigateTo({
      url: '../chuSell/chuSell?number=' + i,
    })
  },
  daifahuo() {
    var i = 1;
    wx.navigateTo({
      url: '../order_manger/order_manger?number=' + i,
    })
  },
  yifahuo() {
    var i = 2;
    wx.navigateTo({
      url: '../order_manger/order_manger?number=' + i,
    })
  },
  tuikuan() {
    var i = 3;
    wx.navigateTo({
      url: '../order_manger/order_manger?number=' + i,
    })
  },
  pingjia() {
    var i = 4;
    wx.navigateTo({
      url: '../order_manger/order_manger?number=' + i,
    })
  },


  //获得出售和下架的数量
  getcount() {
    const db = wx.cloud.database();
    var that = this;
    const _ = db.command;
    db.collection("cosmetic_ms").where({
      xiajia: false,
      kucun: _.gte(1),
    }).count({
      success(res) {
        that.setData({
          chushou_count: res.total
        })
      }
    })
    db.collection("cosmetic_ms").where({
      xiajia: true,
    }).count({
      success(res) {
        that.setData({
          xiajia_count: res.total
        })
      }
    })
  },
//获得全部订单
  getAll_order() {
    var that = this;
    const db = wx.cloud.database();
    db.collection("orders").where({
      complete: false,
    }).get({
      success(res) {
        that.setData({
          getAll_order: res.data
        })
        var getAll_order = that.data.getAll_order;
        var fahuo = [];//待发货
        var yifahuo = [];//已发货
        for (var i = 0; i < getAll_order.length; i++) {
          if (getAll_order[i].fahuo == false) {
            fahuo.push(getAll_order[i]);
          }
          else {
            yifahuo.push(getAll_order[i]);
          }
        }
        that.setData({
          fahuo: fahuo,
          yifahuo: yifahuo,
        })
        console.log(fahuo)
      },
    })
    //判断商品是否为待fahuo

  },
  //点击出售
  chushou() {
    var i=1;
    wx.navigateTo({
      url: '../chuSell/chuSell?number='+i,
    })
  },
  //点击下架
  xiajia() {
    var i = 4;
    wx.navigateTo({
      url: '../chuSell/chuSell?number='+i,
    })
  },
  //发布商品
  fabu() {
    wx.navigateTo({
      url: '../release_goods/release_goods',
    })
  },
  //点击订单管理
  orders() {
    wx.navigateTo({
      url: '../order_manger/order_manger',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.setNavigationBarTitle({
      title: '商城管理' //修改title
    })
    this.getcount();
    this.getAll_order();
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
    this.getcount();
    this.getAll_order();
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