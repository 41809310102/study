// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()
const db = cloud.database();
// 云函数入口函数
exports.main = async (event, context) => {
  
  if(event.a==1){
    return await db.collection("shopping_cart").doc(event._id).update({
      num: event.num
    })
  }
  if(event.a==2){
    return {
      event,
      openid: wxContext.OPENID,
      appid: wxContext.APPID,
      unionid: wxContext.UNIONID,
    }
  }
  
}