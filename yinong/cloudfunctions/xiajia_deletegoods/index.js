// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()
const db=cloud.database();
const _ = db.command;
// 云函数入口函数
exports.main = async (event, context) => {
  //下架的商品
  if(event.a==1){
    return await db.collection("cosmetic_ms").where({
      _id:_.in(event.id)
    }).update({
      data: {
        xiajia:true,
      }
    })
  }
  //删除的商品
  else if (event.a == 2) {
    return await db.collection("cosmetic_ms").where({
      _id: _.in(event.id)
    }).remove()
  }
  //上架的商品
  else if (event.a == 3) {
    return await db.collection("cosmetic_ms").where({
      _id: _.in(event.id)
    }).update({
      data: {
        xiajia: false,
      }
    })
  }
}