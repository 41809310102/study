package services;

import dao.UserInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1; // 1:登录成功
        String msg = "";// 错误信息
        // 1.得出前端传递的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2.去数据库验证用户名和密码【业务】
        if (username != null && !username.equals("") &&
                password != null && !password.equals("")
        ) {
            // 参数正确，执行数据库查询
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                // 查询数据库
                UserInfo userInfo = userInfoDao.getUser(username, password);
                if (userInfo.getId() > 0) {
                    // 查到用户了，也就是用户名和密码是正确
                    succ = 1;
                    // 将用户信息存放到 session
                    HttpSession session = request.getSession(); // 用来创建会话
                    // 将用户信息存放到当前session
                    session.setAttribute("userinfo", userInfo);
                } else {
                    succ = 0;
                    msg = "用户名或密码输出错误！";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            // 参数不完整，非法请求
            msg = "非法请求，参数不完整";
        }
        // 3.返回结果
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(response, result);
    }
}
