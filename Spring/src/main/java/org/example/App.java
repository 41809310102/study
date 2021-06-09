package org.example;

import org.example.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        LoginController loginController = context.getBean(LoginController.class);
        System.out.println(loginController);
        //关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}
