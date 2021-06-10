package org.example;

import org.example.config.MyAppation;
import org.example.controller.LoginController;
import org.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        LoginController loginController = context.getBean(LoginController.class);
       loginController.sayHi();
        User user = (User) context.getBean("user");
        System.out.println(user);
        MyAppation myAppation = context.getBean(MyAppation.class);
        System.out.println(myAppation);

        //关闭容器
        ((ClassPathXmlApplicationContext) context).close();

    }
}
