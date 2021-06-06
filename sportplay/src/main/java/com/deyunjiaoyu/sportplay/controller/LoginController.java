package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.User;
import com.deyunjiaoyu.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;
  @RequestMapping("/login")
    public  String login(@RequestBody User user){
        System.out.println("user:"+user);
        String  flag = "error";
       User us = userDao.getUserByMassage(user.getUsername(),user.getPassword());
      System.out.println("user:"+us);
     HashMap<String ,Object> res = new HashMap<>();
     if(us!=null){
         flag = "ok";
     }
     res.put("flag",flag);
     res.put("user",user);
     String res_json =  JSON.toJSONString(res);
        return res_json;
    }

}
