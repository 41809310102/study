// 云函数入口文件
const cloud = require('wx-server-sdk')
cloud.init()
const db=cloud.database();
// 云函数入口函数
exports.main = async (event, context) => {
  if(event.a==1){
    return await db.collection("cosmetic_ms").where({
      url: event.url
    }).update({
      data: {
        name: event.name,
        details: event.details,
        ago_price: event.ago_price,
        sale: event.sale,
        kucun: event.kucun,
        yunfei: event.yunfei,
        type:event.type,
      }
    })
  }
  else if(event.a==2){
    return await db.collection("cosmetic_norms").where({
      url: event.url
    }).update({
      data: {
       norms:event.norms
      }
    })
  }
  
}