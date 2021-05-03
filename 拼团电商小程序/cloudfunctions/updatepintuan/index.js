const cloud = require('wx-server-sdk')
cloud.init()
const db = cloud.database()
// 云函数入口函数
exports.main = async (event, context) => {
  console.log(event);
  try {
    return await db.collection('pintuan').doc(event.id).update({
      data:{
        name:event.name,
        fenlei:event.fenlei,
        price:event.price,
        detail:event.detail,
        ago_price:event.ago_price,
        kucun:event.kucun,
        isRecommend:event.isRecommend,
        img_src:event.fileID
      }
    })
  } catch (e) {
    console.log(e)
  }
}