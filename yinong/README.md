 化妆品门店是一个基于微信小程序**云开发** 商品类小程序  
    
 参考个人项目地址：https://blog.csdn.net/qq_38109594/article/details/99978597 
 ***
# 前言
这是接触第一个小程序开发项目，也是第一个云开发的项目，虽然在开发过程中遇到许多的坑，但还是一步一步走过来了，尤其是一些功能的实现，真的是绞尽脑汁，打代码的路上，总要有些坑才能让自己变得强大。
  
由于经验尚缺，项目中难免有许多不足之处，希望路过的大神能够帮忙指出。
# 一、整体效果
## 1、登陆页面：  
为什么小程序还需要登陆页面，直接微信授权不就完了吗？这里我总结的两点：  
`1：云开发能够获得用户纯天然_openid，这个过程不需要用户授权。`  
`2：这是商品类小程序，需要获取用户一些真实的信息。`  
![登陆页面](https://img-blog.csdnimg.cn/20190822092326925.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
***
## 2、首页
显示主页面整体的效果  
![首页](https://img-blog.csdnimg.cn/20190822191011516.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
***
## 3、商品详情页
作为核心的展示页面、包括商品参数、服务、规格类型、相关参数、售后保障以及可加入购物车或者立即购买等功能；  
  
![详情页](https://img-blog.csdnimg.cn/20190822164355995.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
![详情页](https://img-blog.csdnimg.cn/20190822164019777.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
***
## 4、购物车
主要功能包括：修改购物车数量、修改规格，可删除、可购买等；  
  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190821190316463.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
***
## 5、个人中心
可查看物流信息、订单详情、修改地址、删除订单  
  
![个人中心](https://img-blog.csdnimg.cn/20190821192026120.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
***
## 6、管理员
### 6.1管理员首页
前提是把自己_openid修改成自己的，可根据自己需求添加管理员。  
在user页面修改个人_openid。  
  
![修改_openid](https://img-blog.csdnimg.cn/20190822165925122.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
![管理员菜单](https://img-blog.csdnimg.cn/20190821192603429.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)  
### 6.2添加商品
包括图片上传保存到云数据库和云储存，并且显示已经出售的商品信息、可以管理商品状态。  
  
 ![添加商品](https://img-blog.csdnimg.cn/20190821192615354.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
![出售商品](https://img-blog.csdnimg.cn/20190821192646885.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
### 6.3订单管理和修改商品
![订单管理](https://img-blog.csdnimg.cn/20190821192813631.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MTA5NTk0,size_16,color_FFFFFF,t_70)
***
# 部署方法
1.`clone`项目到本地`https://github.com/weilang1212/shop.git`  
2.在`shop/cloudfunctions/`目录下 每个文件夹都需要安装一次依赖,具体安装方法[wx-server-sdk依赖安装](https://developers.weixin.qq.com/miniprogram/dev/wxcloud/guide/functions/wx-server-sdk.html) 安装成功后每个文件夹会多 `node_modules`这个文件夹  
3.此时程序能够`run`起来，然后修改`user.wxml`页面的_openid(前提先注册，才知道自己_openid),然后进入管理员页面，发布商品，发布完成后可以查看`云开发控制台`查看图片路径，最后在`index.js`中修改 `imgUrls`里面的值（原因是手动设置主页滑动商品图片）。  
4.需要在`云开发控制台云数据库中添加集合（数据库）`  
![数据库](https://img-blog.csdnimg.cn/20190822195712148.png)
***
# 教程
 我在csdn中描述一些关于云开发中一些容易犯错的点[点击进入](https://blog.csdn.net/qq_38109594/article/details/99978597)
 ***
 # 其它资料
