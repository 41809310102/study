package services;

import dao.ArticleInfoDao;
import models.vo.ArticleInfoVO;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/init")
public class InitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1; // succ=1 表示操作成功
        String msg = ""; // 错误说明信息
        ArticleInfoVO articleInfo = null;
        // 1.从前端获取参数
        int id = Integer.parseInt(req.getParameter("id"));
        // 2.调用数据库执行相应的业务逻辑
        if (id > 0) {
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                articleInfo = (ArticleInfoVO) articleInfoDao.getArtById(id);
                succ = 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            msg = "无效参数";
        }

        // 3.将上一步操作的结果返回给前端
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        result.put("art", articleInfo);
        ResultJSONUtils.write(resp, result);
    }
}