const db = wx.cloud.database();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    select_arr:['全部订单','待收货','已完成'],
    select:'',
    openid:'',
    array:[],
    all:[],
    number: 1,
    kuaid_no:'EXM156346',//快递单号
    kuaid_gongsi:'顺丰',//快递公司
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

 bindinput_gongsi(e){
   this.setData({
     kuaid_gongsi: e.detail.value
   })
 },
 //键盘输入过后点击完成时触发

 faOrders: function(e) {
  var that = this;
  const db = wx.cloud.database();
  const _=db.command;
  var _id = e.currentTarget.dataset._id;//获取当前商品的_id

  if (kuaid_no==''||kuaid_gongsi==''){
    wx.showModal({
      title: '',
      content: '请填写单号或公司',
      showCancel:false,
    })
  }
  wx.showModal({
    title: '',
    content: '是否确认发货',
    mask: true,
    success(res) {
      if (res.confirm) {
        db.collection("order").doc(_id).update({
          data: {
            fahuo: true,
            kuaid_no:'EXM156346',//快递单号
            kuaid_gongsi:'顺丰', 
          },
          success(res) {
            wx.showToast({
              title: '发货成功',
              mask:true,
            })
          }
        })
      }
    }
  })

},

  // 选择子页面
  select(res){
    var that = this;
    var state = res.currentTarget.dataset.state;
    var array = [];
    console.log(state);
    that.setData({
      select:state
    })
    if(state == '全部订单'){
      that.setData({
        array:that.data.all
      })
    }else {
      for(var i = 0; i < that.data.all.length; i++){
        if(that.data.all[i].state == state){
          array.push(that.data.all[i]);
        }
      }
      that.setData({
        array:array
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */

  onLoad: function (options) {
    var that = this;
    var array = [];
    var all = [];
    var allMoney = [];
    var name = options.name;
    wx.showLoading({
      title: '加载中',
    })
    that.setData({
      select:name
    })
    console.log(that.data.select)
    wx.cloud.callFunction({
      name:'OpenId',
      success(res){
        that.setData({
          openid:res.result.openid
        })
        db.collection('order').get({
          success(res){
            wx.hideLoading({
              success: (res) => {},
            })
            for(var i = 0; i < res.data.length; i++){
              if(res.data[i]._openid == that.data.openid){
                all.push(res.data[i])
              }
            }
            that.setData({
              all:all
            })
            console.log("all",all);
            if(name == '全部订单'){
              that.setData({
                array:all
              })
            }else{
              for(var n = 0; n < all.length; n++){
                if(all[n].state == name){
                  array.push(all[n]);
                }
              }
              that.setData({
                array:array
              })
            }

            // for(var x = 0; x < array.length; x++){
            //   for(var y = 0; y < array[x].product[y].length; x++){

            //   }
            // }

          }
        })
      }
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