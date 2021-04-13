package services;

import dao.ArticleInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/addart")
public class AddArtServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1; // succ=1 表示操作成功
        String msg = ""; // 错误说明信息
        // 1.从前端获取参数
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        // todo:非空效验
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userinfo") != null) {
            UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
            // 2.调用数据库执行相应的业务逻辑
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                succ = articleInfoDao.add(title, content, userInfo.getId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            msg = "非登录状态，请先登录。";
        }

        // 3.将上一步操作的结果返回给前端
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(resp, result);
    }
}
