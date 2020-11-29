// page/component/details/details.js
var app = getApp();
Page({
  data: {
    num: 1,
    totalNum: 0,
    hasCarts: false,
    curIndex: 0,
    //show: false,
    scaleCart: false,
    current_goods: '',
    crats_value: {
      image_url: '',
      total: '',
    },
    showNormsInput: false,
    goods_norms: [],
    seleted_norms: "",
    showseleted_norms: false,
    selected_color: '',
    canshu: [],
    showcanshu: false,
    goods_service: [],
    showservice: false,
    windosHeight: '',
    //showbottom:true,
    openid: '',
    sale: '',
    show_buy_now: false, //点击无论不论有没有选则规格  立即购买弹出规格
    height:'',//获取图片的高度
    index:0,//判断是否显示商品还是评论
    talkIndex:0,//判断如何显示评论中的选择
    bottonHidden:false,//底部购物车和立即购买是否显示
  },
  //修改评论部分
  talkIndex:function(e){
    const index = parseInt(e.currentTarget.dataset.index);
    this.setData({
      talkIndex: index
    })
  },
  //修改顶部商品和评价的样式
  bindshop:function(e){
    const index = parseInt(e.currentTarget.dataset.index);
    if(index==1){
      this.setData({
        bottonHidden:true,
      })
    }
    else{
      this.setData({
        bottonHidden: false,
      })
    }
    this.setData({
      index: index
    })
  },
  //获取详情页面轮播图的高度
  setContainerHeight:function(e){
    var that=this;
    var imgWidth = e.detail.width;   //图片的原始宽度
    var imgHeight = e.detail.height; //图片的原始高度
    var sysInfo = wx.getSystemInfoSync();//同步获取设备宽度
    var screenWidth = sysInfo.screenWidth; //获取屏幕的宽度
    var scale = screenWidth / imgWidth;/* 获取屏幕和原图的比例*/
    that.setData({
      height: imgHeight * scale,
    })
    console.log(that.data.height)
    console.log(imgHeight * scale)
    console.log(imgWidth + '    ' +imgHeight);
  },
  //
  norms_seleted() {
    var that = this;
    wx.showLoading({
      title: '',
      mask: true
    })
    setTimeout(function() {
      that.setData({
        showseleted_norms: true,
      })
      wx.hideLoading();
    }, 1000)
  },
  // service(){
  //   var that = this;
  //   wx.showLoading({
  //     title: '',
  //     mask: true
  //   })
  //   setTimeout(function () {
  //     that.setData({
  //       showservice: true,
  //       //showbottom:false,
  //     })
  //     wx.hideLoading();
  //   }, 1000)
  // },
  bintap_canshu() {
    var that = this;
    wx.showLoading({
      title: '',
      mask: true
    })
    setTimeout(function() {
      that.setData({
        showcanshu: true,
        //showbottom: false,
      })
      wx.hideLoading();
    }, 1000)
  },
  //获取选择的规格
  seleted_norms: function(e) {
    this.setData({
      seleted_norms: e.currentTarget.dataset.seleted_norms,
      num: 1,
      //totalNum:0,
    })
  },
  //点击×取消规格框
  cha() {
    this.setData({
      showseleted_norms: false,
      num: 1,
      show_buy_now: false,
    })
  },
  //从数据库获取售后服务保障
  getgoods_service() {
    var that = this;
    const db = wx.cloud.database();
    db.collection("cosmetic_service").get({
      success(res) {
        that.setData({
          goods_service: res.data
        })
      }
    })
  },
  //从数据库获取 url商品的参数
  getcanshu() {
    var current_goods = this.data.current_goods;
    var that = this;
    const db = wx.cloud.database();
    db.collection("cosmetic_canshu").where({
      url: current_goods.url
    }).get({
      success(res) {
        that.setData({
          canshu: res.data
        })
      }
    })
  },
  //从数据库获取获得 商品规格
  getgoods_norms() {
    var current_goods = this.data.current_goods;
    var that = this;
    const db = wx.cloud.database();
    db.collection("cosmetic_norms").where({
      url: current_goods.url
    }).get({
      success(res) {
        that.setData({
          goods_norms: res.data
        })
      },
    })
  },

  //服务完成返回
  service_save() {
    this.setData({
      showservice: false,
    })
  },
  //点击完成
  save() {
    this.setData({
      showcanshu: false,
    })
  },
  //规格 已选 购物车事件
  addCarts() {
    var that = this;
    if (that.data.seleted_norms == "") {
      wx.showToast({
        title: '请选择商品属性',
        mask: true,
        icon: "none"
      })
    } else {
      that.addToCart();
    }
  },

  addToCart() {
    const that = this;
    var time = app.time();
    const db = wx.cloud.database();
    var goods_norms = that.data.goods_norms[0].norms //获得规格
    var num = that.data.num;
    var seleted_norms = that.data.seleted_norms;
    var totalNum = that.data.totalNum;
    var current_goods = that.data.current_goods;
    that.setData({
      show: true
    })
    setTimeout(function() {
      that.setData({
        show: false,
        scaleCart: true
      })
      setTimeout(function() {
        that.setData({
          scaleCart: false,
          hasCarts: true,
          totalNum: num + that.data.totalNum
        })
        if (app.globalData.register == false) {
          wx.showLoading({
            title: '请先注册',
            mask: true,
          })
          setTimeout(function() {
            wx.navigateTo({
              url: '../login/login',
            })
            wx.hideLoading();
          }, 1000)
        } else {
          db.collection("shopping_cart").where({ //判断购物车里面的商品是否已经被添加，如果已添加则修改里面的total值即可
            url: current_goods.url,
            _openid: that.data.openid,
            seleted_norms: that.data.seleted_norms,
          }).get({
            success(res) {
              //修改里面的参数值
              if (res.data.length > 0) {
                // console.log(res.data)
                // console.log(that.data.totalNum)
                // console.log(that.data.num)
                var total = res.data[0].total;
                db.collection("shopping_cart").doc(res.data[0]._id).update({
                  data: {
                    total: num + total
                  },
                  success(res) {
                    wx.showToast({
                      title: '添加成功',
                      mask: true,
                    })
                
                  }
                })
                //没有添加新的商品
              } else {
                console.log(current_goods)
                console.log(goods_norms)
                db.collection("shopping_cart").add({
                  data: {
                    'url': current_goods.url,
                    'ago_price': current_goods.ago_price,
                    'name': current_goods.name,
                    'details': current_goods.details,
                    'goods_norms': goods_norms,
                    'seleted_norms': seleted_norms,
                    total: num,
                    'service': current_goods.service,
                    'type': current_goods.type,
                    'time': time,
                    'selected': false,
                  },
                  success(res) {
                    wx.showToast({
                      title: '添加成功',
                      mask: true,
                    })
                    setTimeout(function() {
                      wx.showLoading({
                        title: '正在跳转',
                      })
                      setTimeout(function() {
                        wx.hideLoading();
                        app.globalData.register=true;
                       wx.navigateBack({
                         
                       })
                      }, 3000)
                    }, 2000)
                  }
                })
              }
            }
          })
          
        }

      }, 200)
    }, 300)

  },

  //底部加入购物车事件
  bottom_addToCart() {
    if (this.data.seleted_norms == "") {
      this.setData({
        showseleted_norms: true,
        num: 1,
        totalNum: 0
      })
    } else {
      this.addToCart();
    }
  },
  //选择规格 完成后跳转到订单购买付款页面
  save_buy() {
    if (app.globalData.register == false) {
      {
        wx.showLoading({
          title: '请先注册',
          mask: true,
        })
        setTimeout(function() {
          wx.navigateTo({
            url: '../login/login',
          })
          wx.hideLoading();
        }, 1000)
      }
    } else {
      var that = this;
      var time = app.time();
      const db = wx.cloud.database();
      var goods_norms = that.data.goods_norms[0].norms //获得规格
      var num = that.data.num;
      var seleted_norms = that.data.seleted_norms;
      var current_goods = that.data.current_goods;
      var selected_crats = [{
        url: '',
        ago_price: '',
        name: '',
        details: '',
        goods_norms: '',
        seleted_norms: '',
        total: '',
        service: '',
        type: '',
        time: '',
        selected: '',
        sale: ''
      }];
      selected_crats[0].url = current_goods.url
      selected_crats[0].ago_price = current_goods.ago_price
      selected_crats[0].name = current_goods.name
      selected_crats[0].details = current_goods.details
      selected_crats[0].goods_norms = goods_norms
      selected_crats[0].seleted_norms = seleted_norms
      selected_crats[0].total = num
      selected_crats[0].service = current_goods.service
      selected_crats[0].type = current_goods.type
      selected_crats[0].time = time
      selected_crats[0].selected = false,
        selected_crats[0].sale = current_goods.sale
      app.globalData.selected_crats = selected_crats
      var totalPrice = selected_crats[0].ago_price * selected_crats[0].total * selected_crats[0].sale;
      console.log(selected_crats)
      wx.navigateTo({
        url: '../orders/orders?totalPrice=' + totalPrice
      })

    }


  },
  //点击立即购买进如选择规格界面
  buy_now() {
    const that = this;
      that.setData({
        show_buy_now: true,
      })
   
    // wx.showLoading({
    //   title: '',
    // })
    // setTimeout(function(){
    //   wx.switchTab({
    //     url: '../cart/cart',
    //   })
    //   wx.hideLoading();
    // },1000)
  },
  //每次访问获得该商品的折扣率
  getsale() {
    const db = wx.cloud.database();
    var that = this;
    var current_goods = that.data.current_goods;
    db.collection("cosmetic_ms").where({
      url: current_goods.url
    }).get({
      success(res) {
        that.setData({
          sale: res.data[0].sale
        })
        console.log(res.data[0].sale)
      }
    })
  },
  onLoad: function(options) {
    console.log(app.globalData.register)
    var that = this;
    that.setData({
      current_goods: JSON.parse(options.current_goods),
      windosHeight: app.getWidth_height(),
      openid: app.globalData.openid,
    })
    that.getsale(); //获得折扣
    that.getgoods_norms();
    that.getcanshu();
    that.getgoods_service();
  },


  onShow: function() {
    this.setData({
      windosHeight: app.getWidth_height(),
    })
  },
  reduceCount() {
    let num = this.data.num;
    if (num > 1) {
      num--;
      this.setData({
        num: num
      })
    }
  },
  addCount() {
    let num = this.data.num;
    num++;
    this.setData({
      num: num
    })
  },



  bindTap(e) {
    const index = parseInt(e.currentTarget.dataset.index);
    this.setData({
      curIndex: index
    })
  }

})