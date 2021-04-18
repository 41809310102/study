package dao;

import models.UserInfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用来操作 userinfo 表
 */
public class UserInfoDao {

    /**
     * 用户添加【注册功能】
     */
    public int add(String username, String password) throws SQLException {
        int result = 0;
        Connection connection = DBUtils.getConnection();
        String sql = "insert into userinfo(username,password) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        result = statement.executeUpdate();
        // 关闭数据库连接
        DBUtils.close(connection, statement, null);
        return result;
    }

    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    public UserInfo getUser(String username, String password) throws SQLException {
        UserInfo userInfo = new UserInfo();
        // jdbc 查询数据库
        Connection connection = DBUtils.getConnection();
        String sql = "select * from userinfo where username=? and password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        // 查询数据库
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setUsername(resultSet.getString("username"));
            userInfo.setPassword(resultSet.getString("password"));
            //..
        }
        // 关闭数据库连接
        DBUtils.close(connection, statement, resultSet);
        return userInfo;
    }

}
