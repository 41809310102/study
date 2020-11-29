// miniprogram/page/component/release_goods/release_goods.js
var app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    type: ['种子', '农药', '工具', '农业机器', '农机租用', '割机预约'],
    norm_number: [1, 2, 3, 4, 5, 6, 7],
    url: '', //图片路径
    name: '', //商品标题
    details: '', //商品描述
    type_value: '', //商品类目的值
    norm_numbervluae: 0, //选择规格的个数
    grant_no: '', //商品编号
    brand: "", //品牌
    ago_price: '', //价格
    sale: 1, //折扣,默认不打折
    kucun: '', //库存
    yunfei: '', //运费
    baozqi: '', //保质期
    candi: '', //生产地
    be_listed: '', //生产日期
    effect: '', //效果,
    fit: '', //适应肤质
    norms: [], //商品规格
    tempFilePaths: '', //获取上传文件的路径
  },
//清空
  reset(){
    this.setData({
      tempFilePaths:'',
      norm_numbervluae:0,
      type_value:''
    })
  },
//获得时间戳
  _time(i) {
    var date = new Date();
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hour = date.getHours();
    const minute = date.getMinutes();
    const second = date.getSeconds();
    var time = year + '-' + month + '-' + day + ' ' + hour + ':' + minute +':'+ second;
    var time1= hour + ""+minute +""+ second;
    if(i==1){
      return time
    }
    else{
      return time1
    }
  },
  //发布按钮（既提交表单）
  fabu: function (e) {
    var time = this._time(2);//全局变量获得时间戳
    var time1=this._time(1);
    console.log(e.detail.value)
    var that = this;
    var tempFilePaths = that.data.tempFilePaths;//获取蹄片路径
    const db=wx.cloud.database();
    //依次赋值
    that.setData({
      name: e.detail.value.name,
      details: e.detail.value.details,
      grant_no: e.detail.value.Grant_No,
      brand: e.detail.value.summary,
      ago_price: e.detail.value.ago_price,
      sale: e.detail.value.sale,
      kucun: e.detail.value.kucun,
      yunfei: e.detail.value.yunfei,
      baozqi: e.detail.value.Baozqi,
      candi: e.detail.value.Candi,
      be_listed: e.detail.value.be_listed,
      effect: e.detail.value.effect,
      fit: e.detail.value.fit,
    })
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
    console.log(norms)
    if (that.data.name == '' || that.data.details == '' || that.data.grant_no == '' || that.data.brand == '' || that.data.ago_price == '' || that.data.kucun == '' || that.data.baozqi == '' || that.data.be_listed == ''||that.data.tempFilePaths=='') {
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
      wx.cloud.uploadFile({
        cloudPath:time,
        filePath: that.data.tempFilePaths,
        success(res) {
          that.setData({
            url: res.fileID
          })
          db.collection("cosmetic_ms").add({
            data: {
              "url": that.data.url,
              "time":time1,
              ago_price: parseFloat(that.data.ago_price),
              "details": that.data.details,
              kucun: parseFloat(that.data.kucun),
              "name": that.data.name,
              sale: parseFloat(that.data.sale),
              sales_volume:0,
              "service":"过期包退 破损包退 极速退款 过时取消",
              "summary": that.data.brand,
              "type": that.data.type_value,
              "xiajia":false,
            },
            success(res) {
              { console.log(res) }//每次添加后刷新一次获取的图片
              wx.showToast({
                title: '发布成功',
              })
            }
          })
          db.collection("cosmetic_canshu").add({
            data:{
              "Baozqi": that.data.baozqi,
              "Candi": that.data.candi,
              "Grant_No": that.data.grant_no,
              "be_listed": that.data.be_listed,
              "brand": that.data.brand,
              "effect": that.data.effect,
              "fit": that.data.fit,
              "name": that.data.name,
              "type": that.data.type_value,
              "url": that.data.url,
            },
            success(res) { console.log(res) }
          })
          db.collection("cosmetic_norms").add({
            data:{
              "url": that.data.url,
              "norms": norms
            },
            success(res){console.log(res)}
          })
        },
        fail(res){
          console.log(res)

        }
      })
    }
  },
  //上传图片获得文件路径
  shangchuan() {
    var that = this;
    wx.chooseImage({
      success: function (res) {
        that.setData({
          tempFilePaths: res.tempFilePaths[0]
        })
        console.log(that.data.tempFilePaths);
      },
    })

  },
  //选择规格数量
  bindtap_norms(e) {
    this.setData({
      norm_numbervluae: this.data.norm_number[e.detail.value]
    })
    console.log(this.data.norm_numbervluae)
  },
  //选择类型
  bindchange(e) {
    this.setData({
      type_value: this.data.type[e.detail.value]
    })
    console.log(this.data.type_value);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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