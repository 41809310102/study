// page/component/orders/orders.js
var app = getApp();
Page({
  data: {
    address: [],
    hasAddress: false,
    totalPrice: 0,
    orders: [],
    region: {},
    remarks: '',
    showPayPwdInput: false, //是否展示密码输入层
    pwdVal: '', //输入的密码
    payFocus: false, //文本框焦点
    compelete_orders: [],
    srocll_height: '',
    openid:'',
  },

  /**
   * 显示支付密码输入层
   */
  showInputLayer: function () {
    this.setData({
      showPayPwdInput: true,
      payFocus: true
    });
  },
  hidePayLayer1() {
    this.setData({
      showPayPwdInput: false,
      payFocus: false,
      pwdVal: ''
    });
    wx.showToast({
      title: '已取消支付',
      mask: true,
      icon: "none"
    })
  },
  
  /**
   * 隐藏支付密码输入层
   */
  hidePayLayer: function () {
    var val = this.data.pwdVal;
    var that = this;
    var address = that.data.address;
    var time = app.time();
    var orders = that.data.orders;
    var compelete_orders = that.data.compelete_orders;
    var region = that.data.region;
    wx.showLoading({
      mask:true
    });
    const db = wx.cloud.database();
    var openid=app.globalData.openid;
    db.collection("register").where({
      _openid:openid
    }).get({
      success(res){
        if (that.data.pwdVal == res.data[0].password) {
          for (var i = 0; i < orders.length; i++) {
            wx.cloud.callFunction({
              name: 'update_goods',
              data: {
                url: orders[i].url,
                total: orders[i].total,
                kucun: 0 - orders[i].total - 0
              }
            })
          }
          wx.cloud.callFunction({
            name: 'delete_carts',
            data: {
              a: 2,
              compelete_orders: compelete_orders,
            },
            success(res) {
              for (var i = 0; i < orders.length; i++) {
                db.collection("orders").add({
                  data: {
                    'name': orders[i].name,
                    'address': address,
                    'order_bh': '101411' + Math.floor(Math.random() * 65415000 + 50),
                    'ago_price': orders[i].ago_price,
                    'real_price': (orders[i].ago_price * orders[i].sale).toFixed(2),
                    'complete': false,
                    'details': orders[i].details,
                    'seleted_norms': orders[i].seleted_norms,
                    'service': orders[i].service,
                    'total': orders[i].total,
                    'url': orders[i].url,
                    'sale': orders[i].sale,
                    'type': orders[i].type,
                    'region': region,
                    'start_time': time,
                    'yunfei': 0,
                    'pay_bh': '654891' + Math.floor(Math.random() * 65415000 + 50),
                    'fahuo':false,
                  },
                  success(res) {
                    console.log(res)
                  }
                })
              }
              wx.hideLoading();
              that.setData({
                showPayPwdInput: false,
                payFocus: false,
                pwdVal: ''
              }, function () {
                wx.showToast({
                  title: "支付成功",
                  duration: 1500,
                  mask: true,
                })
                // wx.showLoading({
                //   title: '正在跳转',
                //   mask: true,
                // })
              });
              setTimeout(function () {
                wx.switchTab({
                  url: '../user/user',
                })
                // wx.hideLoading();
              }, 1000)

            }
          })
        }
        else {
          wx.showModal({
            title: '',
            content: '密码输入错误',
            showCancel: false,
          })
          wx.hideLoading();
          that.setData({
            pwdVal: '',
          })
        }
      }
    })
    


  },
  /**
   * 获取焦点
   */
  getFocus: function () {
    this.setData({
      payFocus: true
    });
    // console.log(this.data.pwdVal.length)
    // console.log(this.data.payFocus);
  },
  /**
   * 输入密码监听
   */
  inputPwd: function (e) {
    this.setData({
      pwdVal: e.detail.value
    });
    if (this.data.pwdVal.length >= 6) {
      this.hidePayLayer();
    }
  },
  //订单备注
  remarks: function (e) {
    this.setData({
      remarks: e.detail.value
    })
    console.log(e.detail.value)
  },
  onLoad: function (options) {
    //this.showInputLayer();
    this.setData({
      orders: app.globalData.selected_crats,
      totalPrice: JSON.parse(options.totalPrice),
      srocll_height: app.getWidth_height(),
    })
    // this.setData({
    //   orders: options.selected,
    //   totalPrice: JSON.parse(options.totalPrice)
    // })
    // console.log(options.selected + "   " + JSON.parse(options.totalPrice) + "   " + this.data.orders.length)
  },
  onReady() {
    //this.getTotalPrice();
  },

  onShow: function () {
    const self = this;
    wx.getStorage({
      key: 'address',
      success(res) {
        self.setData({
          address: res.data,
          hasAddress: true
        })
      }
    })
    wx.getStorage({
      key: 'region',
      success: function (res) {
        self.setData({
          region: res.data
        })
      }
    })
  },

  /**
   * 计算总价
   */
  // getTotalPrice() {
  //   let orders = this.data.orders;
  //   let total = 0;
  //   for(let i = 0; i < orders.length; i++) {
  //     total += orders[i].num * orders[i].price;
  //   }
  //   this.setData({
  //     total: total
  //   })
  // },

  toPay() {
    var that = this;
    var orders = that.data.orders;
    var address = that.data.address;
    const db = wx.cloud.database();
    var compelete_orders = [];
    for (var i = 0; i < orders.length; i++) {
      compelete_orders = compelete_orders.concat(orders[i]._id);
    }
    that.setData({
      compelete_orders: compelete_orders
    })
    if (address.length == 0) {
          wx.showToast({
            title: '请完善地址资料',
            icon:'none',
            mask:true
          })
    } else {
      wx.showModal({
        title: '提示',
        content: '本系统只做演示',
        showCancel: true,
        mask: true,
        success: function (res) {
          if (res.cancel) {
            wx.showToast({
              title: '已取消支付',
              mask: true,
              icon: 'none'
            })
          } else {
            //  console.log(that.data.address)
            //   console.log(that.data.region)
            that.setData({
              showPayPwdInput: true,
              payFocus: true
            });

            //  app.globalData.selected_crats1 = app.globalData.selected_crats;
          }
          // wx.setStorageSync({
          //   key: 'deleteCart',
          //   data: JSON.stringify(deleteCart),
          // })
        },
      })
    }

    // wx.showModal({
    //   title: '提示',
    //   content: '本系统只做演示，支付系统已屏蔽',
    //   text: 'center',
    //   complete() {
    //     wx.switchTab({
    //       url: '/page/component/user/user'
    //     })
    //   }
    // })
  },
  //更新密码
  updata_password(){
    wx.showLoading({
      title: '',
    })
    setTimeout(function(){
      wx.navigateTo({
        url: '../update_password/update_password',
      })
      wx.hideLoading();
    },1500)
  }
})