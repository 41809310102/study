// 云函数入口文件
const cloud = require('wx-server-sdk')

cloud.init()
const db = cloud.database();
const _ = db.command;
// 云函数入口函数
exports.main = async (event, context) => {
  if (event.a == 1) {
    return await db.collection("orders").where({
      _id: event._id
    }).update({
      data: {
        fahuo: true,
      }
    })
  }
  else if (event.a == 2) {
    await db.collection("orders").where({
      _id: event._id
    }).update({
      data: {
        kuaid_no: _.set(event.kuaid_no),
        kuaid_gongsi: _.set(event.kuaid_gongsi)
      }
    })
  }

}