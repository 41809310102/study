package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.bean.User;
import com.deyunjiaoyu.sportplay.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
      int numbers =   userDao.getUserCounts("%"+queryInfo.getQuery()+"%");
       int pageStart =  (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
     List<User> users =  userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
       HashMap<String,Object> res=new HashMap<>();
       res.put("number",numbers);
       res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    @RequestMapping("/updateuser")
    public String updateUserState(@RequestParam("id") Integer id,@RequestParam("state") Boolean state){
        int i = userDao.updateState(id,state);
        String str = i==1?"success":"error";
        return str;
    }
    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return  i>0? "success":"error";

    }
    @RequestMapping("/deleteuser")
    public String deleteUser(int id){
        int i = userDao.deleteUser(id);
        return i>0? "success":"error";
    }
    @RequestMapping("/getupdate")
    public  String getUpdateUser(int id){
        User user = userDao.getUpdateUser(id);
        String  res = JSON.toJSONString(user);
        return res;
    }
    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user){
        int i = userDao.editUser(user);
        return i>0? "success":"error";
    }
}
