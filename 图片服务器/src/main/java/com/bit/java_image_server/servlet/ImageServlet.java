package com.bit.java_image_server.servlet;

import com.bit.java_image_server.dao.ImageDao;
import com.bit.java_image_server.exception.AppException;
import com.bit.java_image_server.model.Image;
import com.bit.java_image_server.model.JSONResponse;
import com.bit.java_image_server.util.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author tangzhong
 */
@WebServlet("/image")
@MultipartConfig
public class ImageServlet extends HttpServlet {
    public static final String PATH_BASE = "E:/TMP/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这个一定要放在上面
        resp.setContentType("application/json;charset=UTF-8");

        String imageId = req.getParameter("imageId");
        if (imageId == null || imageId.equals("")) {
            // 获取所有图片信息
            doSelectAll(resp);
        } else {
            // 获取指定图片信息
            doSelectOne(Integer.valueOf(imageId), resp);
        }
    }

    private void doSelectAll(HttpServletResponse resp) throws IOException {
        // 1. 创建 ImageDao 对象并从数据库查找数据
        ImageDao imageDao = new ImageDao();
        List<Image> images = imageDao.selectAll();

        // c) 最后借助 gson 完成转换就行了. 很简单
        String respData = JSONUtil.serialize(images);
        System.out.println("selectAll:" + respData);
        // 3. 结果字符串写入到 resp 对象中
        resp.getWriter().write(respData);
    }

    private void doSelectOne(int imageId, HttpServletResponse resp) throws IOException {
        // 1. 先创建 ImageDao 对象, 并查找数据库
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(imageId);
        // 2. 将 image 对象转成 Json 格式
        if (image == null) {
            throw new AppException("未找到指定图片");
        }
        String respData = JSONUtil.serialize(image);
        // 3. 将 Json 字符串写入 resp 对象中
        resp.getWriter().write(respData);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        // 上传图片

        Part p = req.getPart("uploadImage");
        //  c) 对请求信息进行解析, 转换成 Image 对象
        //     一个请求可以上传一个文件, 也能上传多个文件
        //     当前只考虑上传一个的情况
        Image image = new Image();
        image.setImageName(p.getSubmittedFileName());
        image.setSize(p.getSize());
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        image.setUploadTime(df.format(new Date()));

        InputStream is = p.getInputStream();
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        is.close();
        image.setMd5(DigestUtils.md5Hex(bytes));
        image.setContentType(p.getContentType());
        image.setPath(PATH_BASE + image.getMd5());
        //  d) 将 Image 对象写入数据库中
        ImageDao imageDao = new ImageDao();
        // 根据 md5 查询是否已经有 Image 存在
        Image existImage = imageDao.selectByMD5(image.getMd5());
        if(existImage != null){
            throw new AppException("文件已存在");
        }
        imageDao.insert(image);

        // 2. 获取到图片内容, 写入到磁盘中. 如果图片存在就不写文件了
        p.write(image.getPath());
        // 3. 设置返回的响应结果
        // 先不使用 GSON 来构建 Json 字符串
        JSONResponse json = new JSONResponse();
        json.setOk(true);
        resp.getWriter().println(JSONUtil.serialize(json));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        Gson gson = new GsonBuilder().create();

        // 1. 先获取到请求中的 imageId
        String imageId = req.getParameter("imageId");
        if (imageId == null || imageId.equals("")) {
            data.put("ok", false);
            data.put("reason", "请求格式错误");
            String respData = gson.toJson(data);
            resp.getWriter().write(respData);
            return;
        }
        // 2. 创建 ImageDao 对象, 和对应的 image 对象
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(Integer.valueOf(imageId));
        //  a) 删除数据库
        boolean ret = imageDao.delete(Integer.valueOf(imageId));
        if (!ret) {
            data.put("ok", false);
            data.put("reason", "图片不存在");
            String respData = gson.toJson(data);
            resp.getWriter().write(respData);
            return;
        }
        //  b) 删除磁盘文件, 此时说明已经不存在相同 MD5 的图片了, 可以删除磁盘上的图片文件
        Image existImage = imageDao.selectByMD5(image.getMd5());
        if (existImage == null) {
            File file = new File(image.getPath());
            file.delete();
        }
        // 3. 构造最终响应结果
        data.put("ok", true);
        String respData = gson.toJson(data);
        resp.getWriter().write(respData);
    }
}
