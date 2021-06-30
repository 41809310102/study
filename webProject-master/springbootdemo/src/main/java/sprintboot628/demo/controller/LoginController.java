package sprintboot628.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sprintboot628.demo.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("/login")
@RestController
public class LoginController {
    @RequestMapping("/user")
    public  Object getIndex5(String username, String password,HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        int status=-1;
        String flag = "登录失败！";
        if(username.equals("胡俊杰")&&password.equals("123456")){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            status = 0;
            flag="登录成功！";
        }else{
            status=1;
            flag="密码或用户名错误！";
        }
        map.put("status",status);
        map.put("flag",flag);
        return map;
    }
}
