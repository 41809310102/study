var app = getApp();
Page({
  data: {
    showshaixuan: true,
    fenlei: {
      zonghe: '综合',
      price: '价格范围',
      shaixuan: '筛选'
    },
    category: [{
        name: '种子',
        id: 'qinajie'
      },
      {
        name: '农药',
        id: 'hufu'
      },
      {
        name: '工具',
        id: 'meirong'
      },
      {
        name: '农业机器',
        id: 'liaoxiao'
      },
      {
        name: '农机租用',
        id: 'jichu'
      },
      {
        name: '收割机预约',
        id: 'yingyangxing'
      }
    ],
    shaixuan_name: '',
    detail: [],
    all: [],
    price_goods: [],
    shaixuan_goods:[],
    price_up: false, //判断按价格升序还是降序
    curIndex: 1,
    isScroll: false,
    toView: 'guowei',
    number: 1,
    scrollHeigth: '',
  },
  onReady() {
    var self = this;
    // wx.request({
    //   url: 'http://www.gdfengshuo.com/api/wx/cate-detail.txt',
    //   success(res) {
    //     self.setData({
    //       detail: res.data
    //     })
    //   }
    // });
  },
  getAllgoods() {
    const db = wx.cloud.database();
    var that = this;
    db.collection("cosmetic_ms").get({
      success(res) {
        that.setData({
          all: res.data,
        })
      }
    })
  },
  onShow() {
    var that = this;
    that.setData({
      scrollHeigth: app.getWidth_height()
    })
  },
  //获得价格上升或下降
  getprice_goods() {
    const db = wx.cloud.database();
    var that = this;
    if (that.data.price_up) {
      db.collection("cosmetic_ms").orderBy('ago_price', 'asc').get({
        success(res) {
          that.setData({
            price_goods: res.data
          })
        }
      })
    } else {
      db.collection("cosmetic_ms").orderBy('ago_price', 'desc').get({
        success(res) {
          that.setData({
            price_goods: res.data
          })
        }
      })
    }
  },
  //获得筛选中字段的值
  getshaixuan_goods() {
    const db = wx.cloud.database();
    var that = this;
    var shaixuan_name = that.data.shaixuan_name;
    db.collection("cosmetic_ms").where({
      type: shaixuan_name
    }).get({
      success(res){
        that.setData({
          shaixuan_goods:res.data,
        })
      }
    })
  },
  onLoad: function(options) {
    this.getAllgoods()
  },
  //跳转到详情
  details: function(e) {
    wx.navigateTo({
      url: '../details/details?current_goods=' + JSON.stringify(e.currentTarget.dataset.item),
    })
  },
  //选择化妆品类别
  selected: function(e) {
    var name = e.currentTarget.dataset.name
    this.setData({
      shaixuan_name: name,
      showshaixuan: true
    })
    this.getshaixuan_goods();
  },
  //滚动时触发
  eventHandle: function() {
    let showshaixuan = true;
    this.setData({
      showshaixuan: showshaixuan
    })
  },
  bindtapEvent: function(e) {
    let that = this;
    var price_up = that.data.price_up;
    var number = e.currentTarget.dataset.index;
    let showshaixuan = this.data.showshaixuan;
    if (number == 3) {
      showshaixuan = !showshaixuan;
      that.getAllgoods()
    } else {
      showshaixuan = true
    }
    that.setData({
      number: number,
      showshaixuan: showshaixuan,
    })
    console.log(number)
    if (number == 2) {
      price_up = !price_up;
      that.setData({
        price_up: price_up
      })
      that.getprice_goods();
    }
  },
  switchTab(e) {
    const self = this;
    this.setData({
      isScroll: true
    })
    setTimeout(function() {
      self.setData({
        toView: e.target.dataset.id,
        curIndex: e.target.dataset.index
      })
    }, 0)
    setTimeout(function() {
      self.setData({
        //isScroll: false
      })
    }, 1)
    console.log(e.target.dataset.index);
    console.log(e.target.dataset.id);
  }

})