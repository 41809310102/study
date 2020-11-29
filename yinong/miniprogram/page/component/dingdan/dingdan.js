// page/component/new-pages/user/user.js
var app = getApp();
Page({
  data: {
    thumb: '',
    nickname: '',
    my_orders: [],
    hasAddress: false,
    address: {},
    region: [],
    curIndex: 0,
    openid: '',
    complete_orders: [],
    uncomplete_orders: [],
  },

  //提醒发货按钮

  fahuo(){
    wx.showToast({
      title: '已提醒对方发货',
    })
  },

  //跳转详情
  details: function(e) {
    console.log("11111"+JSON.stringify(e.currentTarget.dataset.item))
    wx.navigateTo({
      url: '../orders_details/orders_datails?order_details=' + JSON.stringify(e.currentTarget.dataset.item),
    })
  },
  bindTap(e) {
    var that = this;
    const index = parseInt(e.currentTarget.dataset.index);
    if (index == 1) {
      that.getcomplete();
    } else if (index == 2) {
      that.myorder();
    } else if (index == 0) {
      that.getuncomplete();
    }
    this.setData({
      curIndex: index
    })
  },
  //查看物流
  logistical: function(e) {
    var my_orders=e.currentTarget.dataset.item;
    console.log(my_orders)
    wx.showModal({
      title: my_orders.kuaid_gongsi+'单号',
      content:  my_orders.kuaid_no,
      showCancel: false,
    })
  },
  //删除订单
  delete_orders:function(e){
    const _id = e.currentTarget.dataset.id;
    const db = wx.cloud.database();
    var that=this;
    wx.showModal({
      title: '',
      content: '是否删除该订单',
      mask:true,
      success(res){
        if(res.confirm){
          db.collection("orders").doc(_id).remove({
            success(res) {
              wx.showToast({
                title: '删除成功',
                mask: true,
              })
              that.getcomplete();
              that.myorder();
            }
          });
        }
      }
    })
  },
  //获得完成的订单
  getcomplete() {
    const db = wx.cloud.database();
    var that = this;
    db.collection("orders").where({
      _openid: app.globalData.openid,
      complete: true
    }).get({
      success(res) {
        that.setData({
          complete_orders: res.data
        })
      },
    })
  },
  //获得未完成订单
  getuncomplete() {
    const db = wx.cloud.database();
    var that = this;
    db.collection("orders").where({
      _openid: app.globalData.openid,
      complete: false
    }).get({
      success(res) {
        that.setData({
          uncomplete_orders: res.data
        })
      },
    })
  },
  //获得个人全部订单
  myorder() {
    const db = wx.cloud.database();
    var that = this;
    db.collection("orders").where({
      _openid: app.globalData.openid
    }).get({
      success(res) {
        that.setData({
          my_orders: res.data
        })
      },
    })
  },

  //跳转管理员页面
  manger(){
    wx.navigateTo({
      url: '../manger/manger'
    })
  },
  onLoad: function(options) {
    var that = this;
    that.myorder();
    that.getuncomplete();
    this.setData({
      openid: app.globalData.openid
    })
    console.log(this.data.openid)
    /**
     * 获取用户信息
     */
    // wx.getUserInfo({
    //   success: function(res){
    //     self.setData({
    //       thumb: res.userInfo.avatarUrl,
    //       nickname: res.userInfo.nickName
    //     })
    //   }
    // })

    /**
     * 发起请求获取订单列表信息
     */
    // wx.request({
    //   url: 'http://www.gdfengshuo.com/api/wx/orders.txt',
    //   success(res){
    //     self.setData({
    //       orders: res.data
    //     })
    //   }
    // })
  },
  onShow() {
    var self = this;
    self.getuncomplete();
    /**
     * 获取本地缓存 地址信息
     */
    wx.getStorage({
      key: 'address',
      success: function(res) {
        self.setData({
          hasAddress: true,
          address: res.data
        })
      }
    })
    wx.getStorage({
      key: 'region',
      success: function(res) {
        self.setData({
          region: res.data
        })
      }
    })
  },
  /**
   * 发起支付请求
   */
  payOrders: function(e) {
    var that = this;
    var endtime=app.time();
    var _id = e.currentTarget.dataset.id;
    const db = wx.cloud.database();
    const _=db.command;
    wx.showModal({
      title: '',
      content: '是否确认收货',
      mask: true,
      success(res) {
        if (res.confirm) {
          db.collection("orders").doc(_id).update({
            data: {
              complete: true,
              end_time: _.push(endtime)
            },
            success(res) {
              wx.showToast({
                title: '收货成功',
                mask:true,
              })
              that.getuncomplete();
              that.myorder();
            }
          })
        }
      }
    })

  },
  //继续购买
  continue_buy(){
    wx.showLoading({
      title: '',
      mask:true,
    })
    setTimeout(function(){
      wx.switchTab({
        url: '../category/category',
      })
      wx.hideLoading();
    },1500 )
  }
  
})