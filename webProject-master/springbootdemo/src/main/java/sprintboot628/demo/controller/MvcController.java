package sprintboot628.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sprintboot628.demo.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/mvc")
@RestController
@Slf4j
public class MvcController {
    @Autowired
    private ObjectMapper objectMapper;
    @RequestMapping("/index")
    public String getIndex(){
        log.error("我操你大爷！");
        return "redirect:/index.html";
    }

    @RequestMapping("/index2")
    public String getIndex1(){
        log.error("我操你大爷的！");
        return "forward:/index.html";//临时重定向
    }
    @RequestMapping("/index3")
    public String getIndex2(HttpServletResponse response){
        response.setStatus(301);
        response.setHeader("location","/index.html");
        return null;
    }

    @RequestMapping("/index4")
    @ResponseBody
    public String getIndex3(){
        log.error("我操你大爷！");
        return "redirect:/index.html";
    }

    @RequestMapping("/index5")
    @ResponseBody
    public String getIndex4() throws JsonProcessingException {
        User user =  new User();
        user.setUsername("胡俊杰");
        user.setPassword("123456");
       String res = objectMapper.writeValueAsString(user);
     //   log.error("我操你大爷！");
        return res;
    }

    @RequestMapping("/index6")
    @ResponseBody
    public  User getIndex5(){
        User user =  new User();
        user.setUsername("罗琪");
        user.setPassword("123456");
        return user;
    }

}
