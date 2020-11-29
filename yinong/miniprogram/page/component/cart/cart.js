
var app = getApp();
Page({
  data: {
    carts: [], // 购物车列表
    totalPrice: 0, // 总价，初始为0
    selectAllStatus: false, // 全选状态，默认全选
    obj: {
      name: "hello"
    },
    crats_value: [],
    goods_norms: [], //选择规格
    showseleted_norms: false,
    windosHeight: '',
    manage: false,
    seleted_norms:'',
    xiugaiseleted_norms: '',
    openid:'',
    sale:'',
    carts_null:false,
  },
  //获取选择的规格
  seleted_norms: function (e) {
    this.setData({
      xiugaiseleted_norms: e.currentTarget.dataset.seleted_norms,
    })
  },
  //管理购物车
  cart_mg() {
    var manage = this.data.manage;
    var carts = this.data.carts;
    for (var i = 0; i < carts.length; i++) { //每点击一次把购物车中所有seleted变为false
      carts[i].selected = false;
    }
    manage = !manage;
    this.setData({
      manage: manage,
      carts: carts,
      totalPrice: 0,
      index:'',
    })
  },
  //获得传过来的的url路径里面数据库记录
  // getgoods_norms() {
  //   var current_goods = this.data.current_goods;
  //   var that = this;
  //   const db = wx.cloud.database();
  //   db.collection("cosmetic_norms").where({
  //     url: current_goods.url
  //   }).get({
  //     success(res) {
  //       that.setData({
  //         goods_norms: res.data
  //       })
  //     },
  //     complete(res) {
  //       console.log(res.data)
  //     }
  //   })
  // },
  //获得加入购物车里面的缓存
  // getCarts() {
  //   var image_url;
  //   var totalNum;
  //   var that = this;
  //   var crats_value = that.data.crats_value
  //   var flag = false; //判断购物车里面是否已经存在该物品
  //   var carts = that.data.carts;
  //   image_url = crats_value.image_url
  //   totalNum = crats_value.total
  //   //console.log(res.data);
  //   for (var i = 0; i < carts.length; i++) {
  //     if (image_url == carts[i].image) {
  //       carts[i].num += totalNum;
  //       flag = true;
  //     }
  //   }
  //   //把购物车里面没有的加入carts
  //   if (flag == false && crats_value.length != 0) {
  //     var crat = {
  //       id: image_url,
  //       title: '美白养颜组合',
  //       image: image_url,
  //       num: totalNum,
  //       price: 212,
  //       selected: false
  //     }
  //     carts = carts.concat(crat);
  //   }
  //   that.setData({
  //     carts: carts
  //   })
  // wx.getStorage({
  //   key: 'carts',
  //   success: function (res) {

  //   },
  // })
  // console.log(image_url + totalNum);
  //wx.clearStorage();
  //},
  //显示“修改购物车宝贝的参数”
  xiugai_ms(e) {
    console.log(e.currentTarget.dataset.index)
    console.log(e.currentTarget.dataset.value)
    this.setData({
      showseleted_norms: true,
      seleted_norms:e.currentTarget.dataset.value,
      index: e.currentTarget.dataset.index//设置index 用addCarts()来修改购物车里面的商品规格
    })
  },
  //修改完后点击完成
  addCarts() {
    var carts=this.data.carts;
    var that=this;
    var index=this.data.index;
    carts[index].seleted_norms = this.data.xiugaiseleted_norms;
    const db=wx.cloud.database();
    db.collection("shopping_cart").doc(carts[index]._id).update({
      data:{
        seleted_norms: carts[index].seleted_norms
      },
      success(res){
        that.setData({
          showseleted_norms: false,
          carts: carts,
        })
      }
    }) 
  },
  cha() {
    this.setData({
      showseleted_norms: false,
    })
  },
  //数据库中获得购物车里面所有商品
  get_carts() {
    var that = this;
    var carts_url=[];//获得个人购物车里面所有的url作为条件获得sale
    var getsale=[];//获得折扣
    const db = wx.cloud.database();
    const _=db.command;
    db.collection("shopping_cart").where({
      login(){
        let page = this;
        wx.cloud.callFunction({
          name:'getOpenid',
          complete:res=>{
            console.log('openid--',res.result)
            var openid = res.result.openid
            page.setData({
              openid:openid
            })
          }
        })
      },
      
    }).get({
      success(res) {
        var carts = res.data
        if(res.data.length==0){
            that.setData({
              carts_null: true,
              carts: res.data,
            })
        }
        else{
          for (var i = 0; i < carts.length; i++) {
            carts_url = carts_url.concat(carts[i].url)
          }
          db.collection("cosmetic_ms").where({
            url: _.in(carts_url)
          }).get({
            success(res) {
              getsale = res.data;
              for (var i = 0; i < getsale.length; i++) {
                for (var j = 0; j < carts.length; j++) {
                  if (getsale[i].url == carts[j].url) {
                    carts[j].sale = getsale[i].sale//想carts字段添加sale，二维数组中的某一行末尾新增一个字段。做法直接命名并赋值。
                  }
                }
              }
              that.setData({
                carts: carts,
                carts_null:false
              })
            },

          })
        }
       
      }
    })
  },

  //购物车跳转到详情页面
  details:function(e){
    var current_goods = e.currentTarget.dataset.url;
    var info = JSON.stringify(current_goods);
    wx.navigateTo({
      url: '../details/details?current_goods=' + info,
    })
  },
  //获得每件商品的折扣渲染到购物车中的价格
  getsale() {
    const db = wx.cloud.database();
    var that = this;
    var carts = that.data.catrs;
    db.collection("cosmetic_ms").where({
      url: current_goods.url
    }).get({
      success(res) {
        that.setData({
          sale: res.data[0].sale
        })
      }
    })
  },
  onLoad: function(options) {
    this.setData({
      crats_value: app.globalData.crats_value,
      windosHeight: app.getWidth_height(),
      openid:app.globalData.openid
    })
    app.globalData.crats_value = "";
    //this.get_carts();
    //this.getgoods_norms();
    this.cha();
  },
  onShow() {
    var that = this;
    // var deleteCart = app.globalData.selected_crats1;
    // console.log(deleteCart.length);
    // var carts = this.data.carts;
    // for (var i = 0; i < carts.length; i++) {
    //   for (var j = 0; j < deleteCart.length; j++) {
    //     if (deleteCart[j].image == carts[i].image) carts.splice(i--, 1);
    //   }
    // }
    //console.log(app.globalData.crats_value);
    
    this.setData({
      crats_value: app.globalData.crats_value,
      windosHeight: app.getWidth_height(),
      selectAllStatus:false,
      carts_null:false,
    });
    //this.getCarts()
    app.globalData.selected_crats1 = [];
    app.globalData.crats_value = "";
    this.getTotalPrice();
    this.get_carts();
  },
  /**
   * 当前商品选中事件
   */
  selectList(e) {
    const index = e.currentTarget.dataset.index;
    let carts = this.data.carts;
    var num = 0;
    const selected = carts[index].selected;
    carts[index].selected = !selected;
    for (var i = 0; i < carts.length; i++) {
      if (carts[i].selected) num++;
    }
    if (num == carts.length) {
      this.setData({
        selectAllStatus: true
      })
    } else {
      this.setData({
        selectAllStatus: false
      })
    }
    this.setData({
      carts: carts,
    });
    this.getTotalPrice();
  },

  /**
   * 删除购物车当前商品
   */
  deleteList() {
    //const index = e.currentTarget.dataset.index;
    let carts = this.data.carts;
    let num = 0;
    var that = this;
    let flag = false;
    var delete_carts = [];
    const db = wx.cloud.database();
    //console.log(carts[index]);
    for (var i = 0; i < carts.length; i++) {
      if (carts[i].selected) {
        num++;
        flag = true;
        delete_carts = delete_carts.concat(carts[i]._id);
      }
    }
    console.log(delete_carts)
    if (!flag) {
      wx.showToast({
        title: '请选择需要删除商品',
        mask: true,
        icon: 'none'
      })
    } else {
      wx.showModal({
        title: '提示',
        content: '确认要删除这' + num + '件商品吗?',
        success: function(res) {
          if (res.confirm) {
            wx.cloud.callFunction({
                name: 'delete_carts',
                data: {
                  a: 1,
                  delete_carts: delete_carts
                }
              })
              .then(console.log)
              .catch(console.error)
            for (var i = 0; i < carts.length; i++) {
              if (carts[i].selected) {
                carts.splice(i--, 1);
              }
            }
            if(carts.length==0){
              that.setData({carts_null:true})
            }
            that.setData({
              carts: carts,
              selectAllStatus:false
            });
          }
        }
      })
    }
      that.getTotalPrice();
  },

  /**
   * 购物车全选事件
   */
  selectAll(e) {
    let selectAllStatus = this.data.selectAllStatus;
    if(this.data.carts.length==0){
      wx.showToast({
        title: '购物车是空的喔！',
        mask:true,
        icon:'none'
      })
    }
    else{
      selectAllStatus = !selectAllStatus;
      let carts = this.data.carts;
      for (let i = 0; i < carts.length; i++) {
        carts[i].selected = selectAllStatus;
      }
      this.setData({
        selectAllStatus: selectAllStatus,
        carts: carts
      });
      this.getTotalPrice();
    }
  },

  /**
   * 绑定加数量事件
   */
  addCount(e) {
    const index = e.currentTarget.dataset.index;
    let carts = this.data.carts;
    var that=this;
    let num = carts[index].total;
      const db = wx.cloud.database();
      db.collection("shopping_cart").doc(carts[index]._id).update({
        data: {
          total: num+1
        },
        success(res){
          carts[index].total = num+1;
          that.setData({
            carts: carts
          });
          that.getTotalPrice();
        }
      })  
  },

  /**
   * 绑定减数量事件
   */
  minusCount(e) {
    const index = e.currentTarget.dataset.index;
    const obj = e.currentTarget.dataset.obj;
    let carts = this.data.carts;
    var that=this;
    let num = carts[index].total;
    if (num -1<= 1) {
      return false;
    }
    const db = wx.cloud.database();
    db.collection("shopping_cart").doc(carts[index]._id).update({
      data: {
        total: num-1
      },
      success(res){
        carts[index].total = num - 1;
        that.setData({
          carts: carts
        });
        that.getTotalPrice();
      }
    })
  },

  /**
   * 计算总价
   */
  getTotalPrice() {
    let carts = this.data.carts; // 获取购物车列表
    let total = 0;
    for (let i = 0; i < carts.length; i++) { // 循环列表得到每个数据
      if (carts[i].selected) { // 判断选中才会计算价格
        total += carts[i].total * carts[i].ago_price * carts[i].sale; // 所有价格加起来
      }
    }
    this.setData({ // 最后赋值到data中渲染到页面
      carts: carts,
      totalPrice: total.toFixed(2)
    });
  },
  accounts() {
    var carts = this.data.carts;
    var selected = [];
    var totalPrice = this.data.totalPrice;
    for (var i = 0; i < carts.length; i++) {
      if (carts[i].selected == true) {
        selected = selected.concat(carts[i]);
      }
    }
    app.globalData.selected_crats = selected;
    //console.log(selected);
    if (selected.length != 0) {
      wx.navigateTo({
        // url: '../orders/orders?totalPrice=' + totalPrice + '&selected=' + JSON.stringify(selected),
        url: '../orders/orders?totalPrice=' + totalPrice
      })
    } else {
      wx.showToast({
        title: '请选择需要购买的商品',
        mask: true,
        icon: 'none'
      })
    }
  }

})