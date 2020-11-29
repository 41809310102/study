
const db = wx.cloud.database()
var app = getApp();
Page({
  data: {
    banner1: [],
    new_product: [],
    url: [],
    // new_product: [
    //   { id: 1, url: '/image/s1.jpg', price: 125, name: "DIOR化妆品", pay:1212},
    //   { id: 2, url: '/image/s2.jpg', price: 2454, name: "CPB化妆品", pay: 485 },
    //   { id: 3, url: '/image/s3.jpg', price: 44, name: "粉嫩美白养颜组合", pay:7712 },
    //   { id: 4, url: '/image/s4.jpg', price: 66, name: "水疗护肤", pay: 172 },
    //   { id: 5, url: '/image/s5.jpg', price: 45, name: "白养颜组合", pay: 172 },
    //   { id: 6, url: '/image/s6.jpg', price: 124, name: "DIOR化妆品", pay: 852 },
    //   { id: 7, url: '/image/s7.jpg', price: 66, name: "水疗护肤", pay: 172 },
    //   ],
    indicatorDots: false,
    autoplay: false,
    interval: 3000,
    duration: 800,
  },
  //获得最近新品
  search:function(){
    wx.navigateTo({
      url: '../search/search',
    })

  },

  getnew_goods() {
    var that = this;
    const db = wx.cloud.database();
    const _=db.command;
    db.collection("cosmetic_ms").where({
      xiajia:false,
      kucun:_.gte(1),
    }).get({
      success(res) {
        // for (var i = 0; i < res.data.length; i++) {
        //   if (res.data[i]._id = 'XsdfnjsnbdffkjsdKXrE1sqadasi00tqug') {
        //     res.data.splice(i, 1);
        //     break;
        //   }
        // }
        that.setData({
          new_product: res.data
        })
        //XsdfnjsnbdffkjsdKXrE1sqadasi00tqug

        console.log(res)
      },
      fail(res) {
        console.log(res.data)
      }
    })
  },
  onLoad: function(options) {
    var that = this;
    console.log(app._time());
    this.getnew_goods();

    db.collection('banner1').get().then(res=>{
      this.setData({
        banner1:res.data
      })
  })

  },
  cart: function(e) {
    var current_goods = e.currentTarget.dataset.url;
    var info = JSON.stringify(current_goods);
    wx.navigateTo({
      url: '../details/details?current_goods=' + info,
    })
  },
  details_one(e) {
    const url = e.currentTarget.dataset.item;
    const db = wx.cloud.database();
    console.log(url);
    db.collection("cosmetic_ms").where({
      url: url
    }).get({
      success(res) {
        console.log(res.data);
        var current_goods = res.data[0];
        var info = JSON.stringify(current_goods);
        console.log(info)
        wx.navigateTo({
          url: 'details/details?current_goods=' + info,
        })
      }
    })
  },
  onPullDownRefresh:function(){
    this.getnew_goods();
  }
})