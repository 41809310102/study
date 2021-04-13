package services;

import dao.ArticleInfoDao;
import models.ArticleInfo;
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
import java.util.List;

public class MyArtListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        List<ArticleInfo> list = null;
        // 1.获取参数
        HttpSession session = request.getSession(false);
        if (session == null) {
            // 用户未登录
            msg = "非法请求，请先登录！";
        } else {
            // 用户已经登录
            UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
            // 2.查询数据库
            int uid = userInfo.getId();
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                // 查询到数据
                list = articleInfoDao.getListByUID(uid);
                succ = 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // 3.构建和返回后端结果
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        result.put("list", list);
        ResultJSONUtils.write(response, result);
    }
}
