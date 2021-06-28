package org.example.controller;

import lombok.Getter;
import org.example.model.User;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
@Getter
public class LoginController {
//1.通过（查询）注入
/*@Autowired
    private LoginService loginService;
    public void sayHi(){
        loginService.sayHi();
    }*/
    //2.通过Set的方式
  /*  private LoginService loginService;
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
*/

    //3.通过构造方法注入
    private LoginService loginService;
    @Autowired //类注解
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    public void sayHi(){
        //校验参数
        //调用方法
        loginService.sayHi();
    }

    @Bean  //方法注解
    public User user(){
        User user = new User();
        user.setName("悟空");
        user.setPassword("齐天大圣孙悟空");
        return user;
    }

    @Bean
    public User user1(){
        User user = new User();
        user.setName("猪八戒");
        user.setPassword("齐天大圣");
        return user;
    }
}
