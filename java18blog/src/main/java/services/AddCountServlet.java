package services;

import dao.ArticleInfoDao;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/addcount")
public class AddCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        // 1.从前端获取参数
        int id = Integer.parseInt(req.getParameter("id"));
        if (id > 0) {
            // 2.操作数据库
            ArticleInfoDao dao = new ArticleInfoDao();
            try {
                succ = dao.upRcount(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            msg = "参数无效";
        }
        // 3.返回数据给前端
        HashMap<String, Object> map = new HashMap<>();
        map.put("succ", succ);
        map.put("msg", msg);
        ResultJSONUtils.write(resp, map);
    }
}