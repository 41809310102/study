// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()
const db=cloud.database();
const _ = db.command
// 云函数入口函数
exports.main = async (event, context) => {
  return await db.collection("cosmetic_ms").where({
    url:event.url
  }).update({
    data:{
      kucun: _.inc(event.kucun),
      sales_volume: _.inc(event.total)
    }
  })

}