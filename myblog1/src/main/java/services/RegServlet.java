package services;

import dao.Userinfodao;
import models.Userinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = 0;
        String flag = "";
        // 1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("userpwd");
        // todo:非空效验 [msg="参数不全"]
        // 2.【业务逻辑处理】操作数据库添加用户
       Userinfodao userinfodao = new Userinfodao();
        try {
           succ = userinfodao.add(username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 3.返回结果
       /* HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(response, result);*/

      PrintWriter writer = response.getWriter();
        // {"succ":1,"msg":"msg"}
      writer.println(String.format("{\"succ\":%d,\"flag\":\"%s\"}",
               succ, flag));

    }


}
