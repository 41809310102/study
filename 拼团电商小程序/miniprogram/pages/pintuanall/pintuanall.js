var app = getApp();
/** 
 * 需要一个目标日期，初始化时，先得出到当前时间还有剩余多少秒
 * 1.将秒数换成格式化输出为XX天XX小时XX分钟XX秒 XX
 * 2.提供一个时钟，每10ms运行一次，渲染时钟，再总ms数自减10
 * 3.剩余的秒次为零时，return，给出tips提示说，已经截止
 */
 
// 定义一个总毫秒数，以一天为例var total_micro_second = 10 * 1000;//这是10秒倒计时
 var total_micro_second = 3600 * 1000*24;//这是一天倒计时
 
/* 毫秒级秒杀倒计时 */
function countdown(that) {
   // 渲染倒计时时钟
   that.setData({
     clock:dateformat(total_micro_second)//格式化时间
   });
 
   if (total_micro_second <= 0) {
     that.setData({
       clock:"拼团结束"
     });
     // timeout则跳出递归
     return ;
   }  

   //settimeout实现倒计时效果
   setTimeout(function(){
    // 放在最后--
    total_micro_second -= 10;
    countdown(that);
  }
  ,10)//注意毫秒的步长受限于系统的时间频率，于是我们精确到0.01s即10ms
}
 
// 时间格式化输出，如1天天23时时12分分12秒秒12 。每10ms都会调用一次
function dateformat(micro_second) {
   // 总秒数
   var second = Math.floor(micro_second / 1000);
   // 天数
   var day = Math.floor(second / 3600/24);
   // 总小时
   var hr = Math.floor(second / 3600);
   // 小时位
   var hr2 = hr%24;
   // 分钟位
   var min = Math.floor((second - hr * 3600) / 60);
   // 秒位
  var sec = (second - hr * 3600 - min * 60);// equal to => var sec = second % 60;
  // 毫秒位，保留2位
  var micro_sec = Math.floor((micro_second % 1000) / 10);
  return /*day+"天"+*/hr2 + "时" + min + "分" + sec + "秒" ;//+ micro_sec;
}

Page({
  data: {
  
    new_product: [],
    clock: '',
    openid: '',
    

  },
  //获得最近新品
  getnew_goods() {
    var that = this;
    const db = wx.cloud.database();
    const _=db.command;

    db.collection("pintuan").where({
     
    }).get({
      success(res) {
     
        that.setData({
          new_product: res.data
        })
        

        console.log(res)
      },
      fail(res) {
        console.log(res.data)
      }
    })
  },
  onLoad: function(options) {
    var that = this;
    this.getnew_goods();
    countdown(this);
  },

  pintuan: function(e) {
    var that = this;
    const db = wx.cloud.database();
    const _=db.command;
     var clock = this.data.clock;
    var _id = e.currentTarget.dataset.id;//获取当前商品的_id
    var _openid=app.globalData.openid;
    console.log(_openid);
    console.log(_id);
    db.collection("pintuanok").doc(_openid&&_id).get({
      success(res) {
        if(res.data.pintuanok==false||res.data.pintuanok==''){
        db.collection('pintuanok').update({
          data:{
           pintuanok:true,
          }
        })
        //XsdfnjsnbdffkjsdKXrE1sqadasi00tqug
        console.log(res)
      }else{
        wx.showModal({
          title: '请勿重复拼团！',
          showCancel:false,
        })
        return;
      }
      },
      fail(res) {
        console.log(res.data)
      }
    })

    if (clock==0){
      wx.showModal({
        title: '',
        content: '时间已经截止',
        showCancel:false,
      })
    }

    wx.showModal({
      title: '',
      content: '是否确认拼团？',
      mask: true,
      success(res) {
        if (res.confirm) {
          console.log(_id);
          db.collection("pintuan").doc(_id).update({
            data: {
              kucun:_.inc(-1),
              people:_.inc(0-1),
            },
          
            success(res) {
              wx.showToast({
                title: '拼团成功！',
                mask:true,
              })
            }
           
          })
          db.collection('pintuanok').add({
            data:{
              pintuanok:true,
              _id :e.currentTarget.dataset.id,
            },
            success(res){
              wx.navigateTo({
                url: '../pintuanall/pintuanall',
              })
           
            }
          })
        } 
      }
    })
  },

//判断拼团是否成功
  /*pintuanok: function(e)  {
    var that = this;
    const db = wx.cloud.database();
    const _=db.command;
    var _openid=app.globalData.openid;
    var _id = e.currentTarget.dataset.id;//获取当前商品的_id
    console.log(_openid);
    console.log(_id);
    db.collection("pintuanok").doc(_openid&&_id).get({
      success(res) {
        if(res.data.pintuanok==false||res.data.pintuanok==''){
        db.collection('pintuanok').update({
          data:{
           pintuanok:true,
          }
        })
        //XsdfnjsnbdffkjsdKXrE1sqadasi00tqug
        console.log(res)
      }else{
        wx.showToast({
          title: '请勿重复拼团！',
          showCancel:false,
        })
      }
      },
      fail(res) {
        console.log(res.data)
      }
    })
  
  },*/
// 加入购物车,购买
Tobuy(res){
  var that = this;
  var id = res.currentTarget.dataset.id;
  console.log(id);
  wx.navigateTo({
    url: '../pinproduct/pinproduct?id='+id,
  })
  },

//拼团人数不够，等待购买
waittobuy(res){
  wx.showToast({

    title: '请等待拼团成功在购买',

    icon: 'none',

    duration: 2000

  })
  },

  onPullDownRefresh:function(){
    this.getnew_goods();
  },
  














  
})