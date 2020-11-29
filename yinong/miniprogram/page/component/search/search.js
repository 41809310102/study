var app = getApp();
let timeId = null;
Page({
  data: {
    xiangguantuijie: [],
    history: [],
    hot: ['玉米种', '水稻收割机预约', '农药'],
    result: [],
    showKeywords: false,
    keywords: [],
    value: '',
    showResult: false,
    yes_result: true,
  },
  cancelSearch() {
    this.setData({
      showResult: false,
      showKeywords: false,
      value: ''
    })
  },
  cart: function(e) {
    wx.navigateTo({
      url: '../details/details?current_goods=' + JSON.stringify(e.currentTarget.dataset.url),
    })
    console.log(e.currentTarget.dataset + "1111")
  },
  enterEvent: function(e) {
    this.setData({ //每次搜索都把使yes_result为真，待搜素不到在变为假
      yes_result: true,
    })
    var all_result = app.globalData.new_product;
    this.bint_historyHandle(e.detail.value);
    var result = [];
    var that = this;
    const db = wx.cloud.database();
    var name = e.detail.value
    db.collection("cosmetic_ms").where({ //模糊搜索
      name: new db.RegExp({
        regexp: name,
        options: 'i',
      })
    }).get({
      success(res) {
        that.setData({
          result: res.data
        })
        if (res.data.length == 0) {
          that.setData({
            yes_result: false
          })
        }
      }
    })

    // for(var i=0;i<all_result.length;i++){
    //   if (e.detail.value == all_result[i].name){
    //     //keywords = keywords.concat(all_result[i]);
    //     result = result.concat(all_result[i]); 
    //   }
    // }    
    that.setData({
      result: result,
      showResult: true,
      showKeywords: false,
      keywords: []
    })
  },
  searchInput(e) {
    var keywords = this.data.keywords;
    var product = app.globalData.new_product;
    for (var i = 0; i < product.length; i++) {
      if (e.detail.value == product[i].name) {
        keywords = keywords.concat(product[i]);

      }
    }
    this.setData({
      keywords: keywords,
      value: e.detail.value
    })
    //console.log(this.data.value+"1454545")
    if (!e.detail.value) {
      this.setData({
        showKeywords: false
      })
    } else {
      if (!this.data.showKeywords) {
        timeId && clearTimeout(timeId);
        timeId = setTimeout(() => {
          this.setData({
            showKeywords: true
          })
        }, 1000)
      }
    }
  },
  keywordHandle(e) {
    const text = e.target.dataset.text;
    this.setData({
      value: text,
      showKeywords: false,
      showResult: true,
      result: [],
      yes_result: true
    })
    var that = this;
    var keywords = this.data.keywords;
    //console.log(keywords)
    //console.log(all_result)
    // for (var i = 0; i < all_result.length; i++) {
    //   if (all_result[i].name == e.target.dataset.text){
    //     result = result.concat(all_result[i])//直接用result=all_result[i]得到的是对象object
    //     //console.log(all_result[i]+"111")
    //   }
    //   for (var j = 0; j < keywords.length; j++) {
    //     if (all_result[i].name == keywords[j].name) {
    //       //console.log("115245")
    //       result = result.concat(keywords[j])
    //     }
    //   }
    // }
    const db = wx.cloud.database();
    db.collection("cosmetic_ms").where({ //模糊搜索
      name: new db.RegExp({
        regexp: text,
        options: 'i',
      })
    }).get({
      success(res) {
        console.log(res.data)
        that.setData({
          result: res.data
        })
        if (res.data.length == 0) {
          that.setData({
            yes_result: false
          })
        }
      }
    })
    this.bint_historyHandle(text);
  },
  bint_historyHandle(value) {
    let history = this.data.history;
    const idx = history.indexOf(value);
    if (idx === -1) {
      // 搜索记录只保留8个
      if (history.length > 7) {
        history.pop();
      }
    } else {
      history.splice(idx, 1);
    }
    history.unshift(value);
    wx.setStorageSync('history', JSON.stringify(history));
    this.setData({
      history
    });
  },
  historyHandle(e) {
    var that=this;
    // for (var i = 0; i < all_result.length; i++) {
    //   if (all_result[i].name == e.target.dataset.text) {
    //     result = result.concat(all_result[i]);

    //   }
    // }
    that.setData({
      showResult: true,
      result: [],
      yes_result: true,
    })
    const text = e.target.dataset.text
    const db = wx.cloud.database();
    db.collection("cosmetic_ms").where({ //模糊搜索
      name: new db.RegExp({
        regexp: text,
        options: 'i',
      })
    }).get({
      success(res) {
        that.setData({
          result: res.data
        })
        if (res.data.length == 0) {
          that.setData({
            yes_result: false
          })
        }
      }
    })
  },
  onLoad() {
    var xiangguantuijie = app.globalData.new_product
    this.setData({
      xiangguantuijie: xiangguantuijie
    })
    const history = wx.getStorageSync('history');
    console.log(history.length);
    if (history) {
      this.setData({
        history: JSON.parse(history)
      })
      //console.log(this.data.history);
    }
  }
})