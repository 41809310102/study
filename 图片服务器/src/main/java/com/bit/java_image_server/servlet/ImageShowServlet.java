package com.bit.java_image_server.servlet;

import com.bit.java_image_server.model.Image;
import com.bit.java_image_server.dao.ImageDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author tangzhong
 */
@WebServlet("/imageShow")
public class ImageShowServlet extends HttpServlet {
    private static HashSet<String> whiteList = new HashSet<>();
    static {
        whiteList.add("http://localhost:8080/java_image_server/index.html");
        whiteList.add("http://localhost:8080/java_image_server/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 0. 准备工作
        resp.setContentType("application/json; charset=utf-8");
        HashMap<String, Object> data = new HashMap<>(101);
        Gson gson = new GsonBuilder().create();
        // 1. 解析请求中的参数
        String imageId = req.getParameter("imageId");
        if (imageId == null || "".equals(imageId)) {
            data.put("ok", false);
            data.put("reason", "参数不正确");
            String respData = gson.toJson(data);
            resp.getWriter().write(respData);
            return;
        }
        // 校验 refer 是否在白名单中
        String referer = req.getHeader("Referer");
        if (!whiteList.contains(referer)) {
            data.put("ok", false);
            data.put("reason", "未授权使用");
            String respData = gson.toJson(data);
            resp.getWriter().write(respData);
            return;
        }
        // 2. 查找数据库, 找到文件对应的 path
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(Integer.valueOf(imageId));
        if (image == null) {
            data.put("ok", false);
            data.put("reason", "图片不存在");
            String respData = gson.toJson(data);
            resp.getWriter().write(respData);
            return;
        }
        // 3. 设置响应的 content_type
        resp.setContentType(image.getContentType());
        // 4. 根据 path 读取文件, 并写入到响应中
        File file = new File(image.getPath());
        // 使用字节流读取图片文件内容
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        OutputStream os = resp.getOutputStream();
        while (true) {
            int len = fis.read(buffer);
            if (len == -1) {
                break;
            }
            os.write(buffer);
        }
        fis.close();
        os.close();
    }
}
