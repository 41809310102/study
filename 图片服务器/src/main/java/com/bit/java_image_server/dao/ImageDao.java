package com.bit.java_image_server.dao;

import com.bit.java_image_server.exception.AppException;
import com.bit.java_image_server.model.Image;
import com.bit.java_image_server.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author tangzhong
 */
public class ImageDao {
    public boolean insert(Image image) {
        // 1. 获取连接
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "insert into image_table values(null, ?, ?, ?, ?, ?, ?)";
        try {
            // 2. 拼装 PreparedStatement
            statement = connection.prepareStatement(sql);
            statement.setString(1, image.getImageName());
            statement.setLong(2, image.getSize());
            statement.setString(3, image.getUploadTime());
            statement.setString(4, image.getMd5());
            statement.setString(5, image.getContentType());
            statement.setString(6, image.getPath());
            System.out.println(statement);

            // 3. 执行语句, 返回值表示影响了几行表格
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (SQLException e) {
            throw new AppException("保存图片信息出错", e);
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public ArrayList<Image> selectAll() {
        // 1. 获取数据库链接
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "select * from image_table";
        ArrayList<Image> result = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            // 2. 执行 sql, 并获取结果集合
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            // 3. 遍历结果集合
            while (resultSet.next()) {
                Image image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setImageName(resultSet.getString("image_name"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime(resultSet.getString("upload_time"));
                image.setMd5(resultSet.getString("md5"));
                image.setContentType(resultSet.getString("content_type"));
                image.setPath(resultSet.getString("path"));
                result.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return result;
    }

    public Image selectOne(int imageId) {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from image_table where image_id = ?";
        try {
            // 2. 执行 SQL 语句
            statement = connection.prepareStatement(sql);
            statement.setInt(1, imageId);
            resultSet = statement.executeQuery();

            // 3. 遍历结果集合(这个结果中应该只有一个)
            if (resultSet.next()) {
                Image image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setImageName(resultSet.getString("image_name"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime(resultSet.getString("upload_time"));
                image.setMd5(resultSet.getString("md5"));
                image.setContentType(resultSet.getString("content_type"));
                image.setPath(resultSet.getString("path"));
                return image;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public boolean delete(int imageId) {
        // 1. 创建数据库连接
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "delete from image_table where image_id = ?";
        try {
            // 2. 执行 SQL 语句
            statement = connection.prepareStatement(sql);
            statement.setInt(1, imageId);
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return false;
    }

    public Image selectByMD5(String md5) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from image_table where md5 = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, md5);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Image image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setImageName(resultSet.getString("image_name"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime(resultSet.getString("upload_time"));
                image.setMd5(resultSet.getString("md5"));
                image.setContentType(resultSet.getString("content_type"));
                image.setPath(resultSet.getString("path"));
                return image;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
        // 测试 ImageDao 的代码
//        Image image = new Image("测试.png", 100, "2019/12/03", "AABBCCDD",
//                "image/png", "./data/测试.png");
        ImageDao imageDao = new ImageDao();
        boolean ret = imageDao.delete(2);
        System.out.println(ret);
    }
}
