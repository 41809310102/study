// page/component/new-pages/user/address/address.js
Page({
  data:{
    address:{
      name:'',
      phone:'',
      detail:''
    },
    region: ['请选择', '', '']
  },
  bindRegionChange(e) {
    this.setData({
      region: e.detail.value
    })
    wx.setStorage({
      key: 'region',
      data: e.detail.value,
    })
  },
  onLoad(){
    var self = this;
    wx.getStorage({
      key: 'address',
      success: function(res){
        self.setData({
          address : res.data
        })
      }
    })
    wx.getStorage({
      key: 'region',
      success: function(res) {
        self.setData({
          region:res.data
        })
      },
    })
  },
  formSubmit(e){
    const value = e.detail.value;
    var region=this.data.region;
    if (!(/^1[34578]\d{9}$/.test(e.detail.value.phone))){
      wx.showModal({
        title: '提示',
        content: '请填写正确的电话号码',
        showCancel: false
      })
    }
     else if (value.name && value.phone && value.detail && region[0] != '' && region[1] != '' && region[2]!=''){
      wx.setStorage({
        key: 'address',
        data: value,
        success(){
          wx.showToast({
            title: '保存成功',
            mask:true,
            success(res){
              setTimeout(function(){
                wx.navigateBack();
              },1500  )
              
            }
          })
         
        }
      })
    }else{
      wx.showModal({
        title:'提示',
        content:'请填写完整地址资料',
        showCancel:false
      })
    }
  }
})