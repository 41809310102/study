// miniprogram/page/component/chuSell/chuSell.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    number: 1,
    chushou: [],
    scrollHeigth: '',
    selectAllStatus: false,
    num: 0,
    xiajia: [],
    shangxin: [],//上新
    chushoulength:'',//出售数量
    shouwanlength:'',//售完数量
    xiajialength:'',//下架数量
    shouwan: [],
    value: "",//存输入框中的值
  },
  //搜索框输入时获取的值
  bindinput_value(e) {
    this.setData({
      value: e.detail.value
    })
    console.log(this.data.value)
  },
  //修改库存上架
  xiugai_shangjia(){
    wx.navigateTo({
      url: '../xiugai_goods/xiugai_goods',
    })
  },
  //键盘完成时触发事件
  must() {
    var that = this;
    var input_value = that.data.value;
    var number = that.data.number;
    const db = wx.cloud.database();
    const _ = db.command;
    if (number == 1) {//判断此时搜索的是哪一类的结果
      db.collection("cosmetic_ms").where({ //模糊搜索
        xiajia: false,
        kucun: _.gt(0),
        name: new db.RegExp({
          regexp: input_value,
          options: 'i',
        })
      }).get({
        success(res) {
          if (res.data.length == 0) {
            that.setData({
              chushou: res.data
            })
            wx.showModal({
              title: '',
              content: '搜索结果为空',
              showCancel: false,
            })
          }
          else {
            that.setData({
              chushou: res.data
            })
          }
        }
      })
    }
    else if (number == 2) {
      db.collection("cosmetic_ms").where({ //模糊搜索
        kucun: _.gt(0),
        xiajia: false,
        name: new db.RegExp({
          regexp: input_value,
          options: 'i',
        })
      }).get({
        success(res) {
          if (res.data.length == 0) {
            that.setData({
              chushou: res.data
            })
            wx.showModal({
              title: '',
              content: '搜索结果为空',
              showCancel: false,
            })
          }
          else {
            that.setData({
              chushou: res.data
            })
          }
        }
      })
    }
    else if (number == 3) {
      db.collection("cosmetic_ms").where({ //模糊搜索
        kucun: _.eq(0),
        xiajia: false,
        name: new db.RegExp({
          regexp: input_value,
          options: 'i',
        })
      }).get({
        success(res) {
          if (res.data.length == 0) {
            that.setData({
              shouwan: res.data
            })
            wx.showModal({
              title: '',
              content: '搜索结果为空',
              showCancel: false,
            })
          }
          else {
            that.setData({
              shouwan: res.data
            })
          }
        }
      })
    }
    else {
      db.collection("cosmetic_ms").where({ //模糊搜索
        xiajia: false,
        name: new db.RegExp({
          regexp: input_value,
          options: 'i',
        })
      }).get({
        success(res) {
          if (res.data.length == 0) {
            that.setData({
              xiajia: res.data
            })
            wx.showModal({
              title: '',
              content: '搜索结果为空',
              showCancel: false,
            })
          }
          else {
            that.setData({
              xiajia: res.data
            })
          }
        }
      })
    }
  },
  //点击下架中的上架
  shangjia() {
    var id = [];//用来存被选择了的id
    var that = this;
    var num = that.data.num;
    var xiajia = that.data.xiajia;
    if (num == 0) {
      wx.showToast({
        title: '请选择需要上架的商品',
        icon: 'none'
      })
    }
    else {
      for (var i = 0; i < xiajia.length; i++) {
        if (xiajia[i].selected == true) {
          id.push(xiajia[i]._id)
        }
      }
      wx.showModal({
        title: '提示',
        content: '是否上架这' + num + "件商品",
        success(res) {
          if (res.confirm) {
            wx.cloud.callFunction({
              name: 'xiajia_deletegoods',
              data: {
                a: 3,
                id: id
              },
              success(res) {
                wx.showToast({
                  title: '上架成功',
                })
                that.getxiajia();
              }
            })
          }
        }
      })
    }
  },

  //点击出售中的下架
  xiajia() {
    var id = [];//用来存被选择了的id
    var that = this;
    var num = that.data.num;
    var chushou = that.data.chushou;
    if (num == 0) {
      wx.showToast({
        title: '请选择需要下架的商品',
        icon: 'none'
      })
    }
    else {
      for (var i = 0; i < chushou.length; i++) {
        if (chushou[i].selected == true) {
          id.push(chushou[i]._id)
        }
      }
      wx.showModal({
        title: '提示',
        content: '是否下架这' + num + "件商品",
        success(res) {
          if (res.confirm) {
            wx.cloud.callFunction({
              name: 'xiajia_deletegoods',
              data: {
                a: 1,
                id: id
              },
              success(res) {
                wx.showToast({
                  title: '下架成功',
                })
                that.getchushou();//下架成功调用刷新出售函数
                that.getxiajia();//下架成功调用刷新下架函数
                that.setData({
                  num: 0,
                })
              }
            })
          }
        }
      })
    }
  },
  //删除售完的商品
  shouwan_delete() {
    var id = [];//用来存被选择了的id
    var that = this;
    var num = that.data.num;//获得删除的数量
    var shouwan = that.data.shouwan;//获得出售的商品
    if (num == 0) {
      wx.showToast({
        title: '请选择需要删除的商品',
        icon: 'none'
      })
    }
    else {
      for (var i = 0; i < shouwan.length; i++) {
        if (shouwan[i].selected == true) {
          id.push(shouwan[i]._id)
        }
      }
      wx.showModal({
        title: '提示',
        content: '是否删除这' + num + "件商品",
        success(res) {
          if (res.confirm) {
            wx.cloud.callFunction({
              name: 'xiajia_deletegoods',
              data: {
                a: 2,
                id: id
              },
              success(res) {
                wx.showToast({
                  title: '删除成功',
                })
                //删除过后重置num的值为0
                that.setData({
                  num: 0,
                  selectAllStatus: false
                })
                that.getshouwan();
              }
            })
          }
        }
      })
    }
  },

  //删除商品按钮
  deletegoods() {
    var id = [];//用来存被选择了的id
    var that = this;
    var num = that.data.num;//获得删除的数量
    var chushou = that.data.chushou;//获得出售的商品
    if (num == 0) {
      wx.showToast({
        title: '请选择需要删除的商品',
        icon: 'none'
      })
    }
    else {
      for (var i = 0; i < chushou.length; i++) {
        if (chushou[i].selected == true) {
          id.push(chushou[i]._id)
        }
      }
      wx.showModal({
        title: '提示',
        content: '是否删除这' + num + "件商品",
        success(res) {
          if (res.confirm) {
            wx.cloud.callFunction({
              name: 'xiajia_deletegoods',
              data: {
                a: 2,
                id: id
              },
              success(res) {
                wx.showToast({
                  title: '删除成功',
                })
                //删除过后重置num的值为0
                that.setData({
                  num: 0,
                  selectAllStatus: false
                })
                that.getchushou();
              }
            })
          }
        }
      })
    }
  },

  //下架中的删除商品
  xiajia_delete() {
    var id = [];//用来存被选择了的id
    var that = this;
    var num = that.data.num;//获得删除的数量
    var xiajia = that.data.xiajia;//获得出售的商品
    if (num == 0) {
      wx.showToast({
        title: '请选择需要删除的商品',
        icon: 'none'
      })
    }
    else {
      for (var i = 0; i < xiajia.length; i++) {
        if (xiajia[i].selected == true) {
          id.push(xiajia[i]._id)
        }
      }
      wx.showModal({
        title: '提示',
        content: '是否删除这' + num + "件商品",
        success(res) {
          if (res.confirm) {
            wx.cloud.callFunction({
              name: 'xiajia_deletegoods',
              data: {
                a: 2,
                id: id
              },
              success(res) {
                wx.showToast({
                  title: '删除成功',
                })
                that.setData({
                  num: 0,
                  selectAllStatus: false
                })
                that.getxiajia();
              }
            })
          }
        }
      })
    }
  },
  //售完页面点击页面选中商品
  shouwan_selectList(e) {
    const index = e.currentTarget.dataset.index;
    let shouwan = this.data.shouwan;
    var num = 0;
    const selected = shouwan[index].selected;
    shouwan[index].selected = !selected;
    for (var i = 0; i < shouwan.length; i++) {
      if (shouwan[i].selected) num++;
    }
    if (num == shouwan.length) {
      this.setData({
        selectAllStatus: true
      })
    } else {
      this.setData({
        selectAllStatus: false
      })
    }
    this.setData({
      shouwan: shouwan,
      num: num
    });
  },

  //下架页面点击圈圈选择商品
  xiajia_selectList(e) {
    const index = e.currentTarget.dataset.index;
    let xiajia = this.data.xiajia;
    var num = 0;
    const selected = xiajia[index].selected;
    xiajia[index].selected = !selected;
    for (var i = 0; i < xiajia.length; i++) {
      if (xiajia[i].selected) num++;
    }
    if (num == xiajia.length) {
      this.setData({
        selectAllStatus: true
      })
    } else {
      this.setData({
        selectAllStatus: false
      })
    }
    this.setData({
      xiajia: xiajia,
      num: num
    });
    console.log(this.data.num)
  },
  //点击圆圈是否选择商品
  selectList(e) {
    const index = e.currentTarget.dataset.index;
    let chushou = this.data.chushou;
    var num = 0;
    const selected = chushou[index].selected;
    chushou[index].selected = !selected;
    for (var i = 0; i < chushou.length; i++) {
      if (chushou[i].selected) num++;
    }
    if (num == chushou.length) {
      this.setData({
        selectAllStatus: true
      })
    } else {
      this.setData({
        selectAllStatus: false
      })
    }
    this.setData({
      chushou: chushou,
      num: num
    });
    console.log(this.data.num)
  },
  //获得售完的商品
  getshouwan() {
    var that = this;
    const db = wx.cloud.database();
    const _ = db.command;
    db.collection("cosmetic_ms").where({
      xiajia: false,
      kucun: _.eq(0),
    }).orderBy("time", "desc").get({
      success(res) {
        var shouwan = res.data;
        //XsdfnjsnbdffkjsdKXrE1sqadasi00tqug
        console.log(res)
        for (var i = 0; i < shouwan.length; i++) {
          shouwan[i].selected = false;
        }
        that.setData({
          shouwan: res.data,
          shouwanlength:res.data.length,
        })
      }
    })
  },

  //获得上新商品 拿到最近添加的5件商品
  getshangxin() {//用出售中的变量来存 因为上新属于出售里面的特殊例子（按时间排取五件商品）
    var that = this;
    const db = wx.cloud.database();
    const _ = db.command;
    db.collection("cosmetic_ms").where({
      xiajia: false,
      kucun: _.gt(0),
    }).orderBy("time", "desc").limit(5).get({
      success(res) {
        var chushou = res.data;
        //XsdfnjsnbdffkjsdKXrE1sqadasi00tqug
        console.log(res)
        for (var i = 0; i < chushou.length; i++) {
          chushou[i].selected = false;
        }
        that.setData({
          chushou: res.data
        })
      }
    })
  },

  //获得下架商品
  getxiajia() {
    var that = this;
    const db = wx.cloud.database();
    const _ = db.command;
    db.collection("cosmetic_ms").where({
      xiajia: true,
    }).get({
      success(res) {
        var chushou = res.data;
        //XsdfnjsnbdffkjsdKXrE1sqadasi00tqug
        console.log(res)
        for (var i = 0; i < chushou.length; i++) {
          chushou[i].selected = false;
        }
        that.setData({
          xiajia: res.data,
          xiajialength:res.data.length,
        })
      },
      fail(res) {
        console.log(res.data)
      }
    })
  },
  //获得所有出售商品
  getchushou() {
    var that = this;
    const db = wx.cloud.database();
    const _ = db.command;
    db.collection("cosmetic_ms").where({
      xiajia: false,
      kucun: _.gt(0),
    }).get({
      success(res) {
        var chushou = res.data;
        //XsdfnjsnbdffkjsdKXrE1sqadasi00tqug
        console.log(res)
        for (var i = 0; i < chushou.length; i++) {
          chushou[i].selected = false;
        }
        that.setData({
          chushou: res.data,
          chushoulength: res.data.length
        })
      },
      fail(res) {
        console.log(res.data)
      }
    })
  },

  //售完全部事件
  shouwan_selectAll() {
    let selectAllStatus = this.data.selectAllStatus;
    if (this.data.shouwan.length == 0) {
      wx.showToast({
        title: '暂时没有商品哟！',
        mask: true,
        icon: 'none'
      })
    }
    else {
      selectAllStatus = !selectAllStatus;
      let shouwan = this.data.shouwan;
      for (let i = 0; i < shouwan.length; i++) {
        shouwan[i].selected = selectAllStatus;
      }
      this.setData({
        selectAllStatus: selectAllStatus,
        shouwan: shouwan,
      });
      if (selectAllStatus == true) {
        this.setData({
          num: shouwan.length
        })
      }
      else {
        this.setData({
          num: 0
        })
      }
    }
  },

  //下架全选事件
  xiajia_selectAll() {
    let selectAllStatus = this.data.selectAllStatus;
    if (this.data.chushou.length == 0) {
      wx.showToast({
        title: '暂时没有商品哟！',
        mask: true,
        icon: 'none'
      })
    }
    else {
      selectAllStatus = !selectAllStatus;
      let xiajia = this.data.xiajia;
      for (let i = 0; i < xiajia.length; i++) {
        xiajia[i].selected = selectAllStatus;
      }
      this.setData({
        selectAllStatus: selectAllStatus,
        xiajia: xiajia,
      });
      if (selectAllStatus == true) {
        this.setData({
          num: xiajia.length
        })
      }
      else {
        this.setData({
          num: 0
        })
      }
    }
  },
  /**
   * 出售全选事件
   */
  selectAll(e) {
    let selectAllStatus = this.data.selectAllStatus;
    if (this.data.chushou.length == 0) {
      wx.showToast({
        title: '暂时没有商品哟！',
        mask: true,
        icon: 'none'
      })
    }
    else {
      selectAllStatus = !selectAllStatus;
      let chushou = this.data.chushou;
      for (let i = 0; i < chushou.length; i++) {
        chushou[i].selected = selectAllStatus;
      }
      this.setData({
        selectAllStatus: selectAllStatus,
        chushou: chushou,
      });
      if (selectAllStatus == true) {
        this.setData({
          num: chushou.length
        })
      }
      else {
        this.setData({
          num: 0
        })
      }
    }
    console.log(this.data.num)
  },

  //点击改变导航属性
  bindtapEvent: function (e) {
    const index = parseInt(e.currentTarget.dataset.index);
    var chushou = this.data.chushou;
    var xiajia = this.data.xiajia;
    for (var i = 0; i < chushou.length; i++) {//每次点击重置已经选择的商品
      chushou[i].selected = false;
    } for (var i = 0; i < xiajia.length; i++) {//每次点击重置已经选择的商品
      xiajia[i].selected = false;
    }
    this.setData({
      number: index,
      num: 0,
      selectAllStatus: false,
      chushou: chushou,
      xiajia: xiajia,
      value:'',
    })
    //当number为n时刷新对应函数
    if (index == 4) this.getxiajia();
    else if (index == 1) this.getchushou();
    else if (index == 2) this.getshangxin();
    else this.getshouwan();
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      number: options.number
    })
    this.getchushou();
    this.getxiajia();
    //this.getshangxin();
    this.getshouwan();
    
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
    var that = this;
    that.setData({
      scrollHeigth: app.getWidth_height()
    })
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