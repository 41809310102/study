const db = wx.cloud.database();
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    number: 1,
    getAll_order: [], //所有订单
    fahuo: [], //待发货
    yifahuo:[],//已发货
    _id:'',//判断是否为当前id
    kuaid_no:'',//快递单号
    kuaid_gongsi:'',//快递公司
    scrollHeight:'',
  },
  //获得屏幕高度
  getheight(){
      this.setData({
        scrollHeight: app.getWidth_height()
      })
  },
  
//核址
  hezhi(){
    wx.showModal({
      title: '',
      content: '无法发送推送消息',
      showCancel:false,
    })
  },
  //扫码发货
  saomafahuo(){
    wx.showModal({
      title: '',
      content: '无可用条码',
      showCancel: false,
    })
  },
//获取单号
  bindinput_danhao(e){
      this.setData({
        kuaid_no:e.detail.value
      })
  },
  bindinput_gongsi(e){
    this.setData({
      kuaid_gongsi: e.detail.value
    })
  },
  //键盘输入过后点击完成时触发
  bind_must(){
    var that=this;
    const db=wx.cloud.database();
    const _=db.command;
    var _id=that.data._id;//获取当前商品的_id
    var kuaid_no = that.data.kuaid_no;//获取单号
    var kuaid_gongsi=that.data.kuaid_gongsi;//获取公司
    if (kuaid_no==''||kuaid_gongsi==''){
      wx.showModal({
        title: '',
        content: '请填写单号或公司',
        showCancel:false,
      })
    }
    else{
      wx.showModal({
        title: '',
        content: '是否现在发货',
        success(res) {
          if (res.confirm) {
            wx.cloud.callFunction({
              name: 'xiugai_orders',
              data: {
                a: 2,
                _id: _id,
                kuaid_no:kuaid_no,
                kuaid_gongsi:kuaid_gongsi,
              },})
            wx.cloud.callFunction({
              name: 'xiugai_orders',
              data: {
                a: 1,
                _id: _id
              },
              success(res) {
                wx.showToast({
                  title: '发货成功',
                })
                that.getAll_order();
              }
            })
          }
        }
      })
    }
    
  },
  //点击发货触发事件
  bindtap_fahuo(e) {
    var _id = e.currentTarget.dataset._id;
    var that = this;
    that.setData({
      _id:_id
    })
    
  },
  //点击选择上面订单的状态
  bindtapEvent: function(e) {
    const index = parseInt(e.currentTarget.dataset.index);
    this.setData({
      number: index,
    })
  },
  //获得所有订单、待发货以及已发货
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
        var yifahuo=[];//已发货
        for (var i = 0; i < getAll_order.length; i++) {
          if (getAll_order[i].fahuo == false) {
            fahuo.push(getAll_order[i]);
          }
          else{
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
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.getAll_order();
    this.getheight();
    this.setData({
      number:1
    })
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
    this.getAll_order()
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