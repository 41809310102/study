package sprintboot628.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;


@Controller
@RequestMapping("/user")
@Slf4j
public class UserController extends DispatcherServlet {
    //private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/index")
    public  String  getIndex(String name){
       if(name==null||name.equals("")){
           log.error("我的日志信息：姓名为空;级别：error");
       }
       log.warn("我的日志信息：级别：debug");
        return "你好，Springboot";
    }
}
