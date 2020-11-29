// miniprogram/page/component/xiugai_goods/xiugai_goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    value: '', //输入框的值
    allorders: [], //获得全部商品
    type_selected: ['清洁型', '护肤型', '美容型', '疗效型', '基础型', '营养型'],
    norm_number: [1, 2, 3, 4, 5, 6, 7],
    showxiugai: false, //
    summary: '', //
    type: '',
    xiajia: '',
    url: '', //图片路径
    name: '', //商品标题
    details: '', //商品描述
    norm_numbervluae: 0, //选择规格的个数
    ago_price: '', //价格
    sale: 1, //折扣,默认不打折
    kucun: '', //库存
    yunfei: '', //运费
    norms: [], //商品规格
  },
  //提交表单
  fabu: function(e) {
    console.log(e.detail.value)
    var that = this;
    var tempFilePaths = that.data.tempFilePaths; //获取蹄片路径
    const db = wx.cloud.database();
    var norms = [];  //norms是数组 单独赋值
    norms.push(e.detail.value.norms1);//先对norms全部undifne赋值然后判断有多少norm_number探后删除多余的
    norms.push(e.detail.value.norms2);
    norms.push(e.detail.value.norms3);
    norms.push(e.detail.value.norms4);
    norms.push(e.detail.value.norms5);
    norms.push(e.detail.value.norms6);
    norms.push(e.detail.value.norms7);
    var norm_number = that.data.norm_numbervluae;//获得规格的数量
    norms.splice(norm_number, 7 - norm_number);//删除数组中对于的元素
    console.log(norms);
    //依次赋值
    that.setData({
      name: e.detail.value.name,
      details: e.detail.value.details,
      ago_price: parseFloat(e.detail.value.ago_price),
      sale: parseFloat(e.detail.value.sale),
      kucun: parseFloat(e.detail.value.kucun),
      yunfei: parseFloat(e.detail.value.yunfei),
      norms: norms,
    })
    wx.showModal({
      title: '',
      content: '是否修改',
      success(res){
        if(res.confirm){
          //判断
          if (that.data.name == '' || that.data.details == '' || that.data.ago_price == '' || that.data.kucun == '') {
            wx.showModal({
              title: '',
              content: '请完善商品(必填)信息',
              showCancel: false,
            })
          }
          else if (that.data.sale > 1 || that.data.sale <= 0) {
            wx.showModal({
              title: '',
              content: '折扣方式错误',
              showCancel: false,
            })
          }
          else if (that.data.kucun <= 0) {
            wx.showModal({
              title: '',
              content: '库存不能小于0',
              showCancel: false,
            })
          }
          else {
            wx.cloud.callFunction({
              name: 'xiugai_goods',
              data: {
                a: 1,
                url: that.data.url,
                name: that.data.name,
                details: that.data.details,
                ago_price: that.data.ago_price,
                sale: that.data.sale,
                kucun: that.data.kucun,
                yunfei: that.data.yunfei,
                type: that.data.type,
              },
              success(res){
                wx.showToast({
                  title: '修改成功',
                })
                that.setData({
                  showxiugai: false//确认修改过后隐藏
                })
                that.getnew_goods()//刷新获取的商品
              }
            })
            wx.cloud.callFunction({
              name: 'xiugai_goods',
              data: {
                a: 2,
                url: that.data.url,
                norms: that.data.norms,
              }
            })
          }
        }
      }
    })
    
  },
  //返回
  reset(){
    this.setData({
      showxiugai:false
    })
    this.getnew_goods();
  },
  //选择规格数量
  bindtap_norms(e) {
    this.setData({
      norm_numbervluae: this.data.norm_number[e.detail.value]
    })
    console.log(this.data.norm_numbervluae)
  },
  //修改商品
  xiugai(e) {
    var value = e.currentTarget.dataset.item;
    var that = this;
    this.setData({
      showxiugai: true,
      ago_price: value.ago_price,
      details: value.details,
      kucun: value.kucun,
      name: value.name,
      sale: value.sale,
      summary: value.summary,
      type: value.type,
      xiajia: value.xiajia,
      url: value.url,
      yunfei: value.yunfei,
    })
    const db = wx.cloud.database();
    db.collection("cosmetic_norms").where({
      url: that.data.url
    }).get({
      success(res) {
        //console.log(res.data[0].norms)
        that.setData({
          norms: res.data[0].norms,
          norm_numbervluae: res.data[0].norms.length
        })
      }
    })
    //console.log(e.currentTarget.dataset.item)
  },
  ////选择类型
  bindchange(e) {
    this.setData({
      type: this.data.type_selected[e.detail.value]
    })
  },
  //搜索框确定
  must() {
    var that = this;
    var input_value = that.data.value;
    var number = that.data.number;
    const db = wx.cloud.database();
    const _ = db.command;
    db.collection("cosmetic_ms").where({ //模糊搜索
      name: new db.RegExp({
        regexp: input_value,
        options: 'i',
      })
    }).get({
      success(res) {
        if (res.data.length == 0) {
          that.setData({
            allorders: res.data
          })
          wx.showModal({
            title: '',
            content: '搜索结果为空',
            showCancel: false,
          })
        } else {
          that.setData({
            allorders: res.data
          })
        }
      }
    })
  },

  ////搜索框输入时获取的值
  bindinput_value(e) {
    this.setData({
      value: e.detail.value
    })
    console.log(this.data.value)
  },
  //获得全部商品
  getnew_goods() {
    var that = this;
    const db = wx.cloud.database();
    const _ = db.command;
    db.collection("cosmetic_ms").get({
      success(res) {
        that.setData({
          allorders: res.data
        })
        console.log(res)
      },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.getnew_goods();
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
    this.getnew_goods()
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