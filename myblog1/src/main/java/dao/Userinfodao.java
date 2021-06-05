package dao;

import models.Userinfo;
import utils.DbUtils;

import java.sql.*;

public class Userinfodao {
    //添加用户

    public  int add(String username,String password) throws SQLException{
        int result = 0;
        Connection connection = DbUtils.getConnection();
        String sql = "insert into userinfo(username,password) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        result = statement.executeUpdate();
        // 关闭数据库连接
        DbUtils.close(connection,statement,null);
        return result;
    }

    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */

    public  Userinfo getUserinfo(String username,String password) throws SQLException{
        Userinfo userinfo = new Userinfo();
        Connection connection = DbUtils.getConnection();
        String sql = "select * from userinfo where username=? and password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
    // 查询数据库
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            userinfo .setId(resultSet.getInt("id"));
            userinfo .setUsername(resultSet.getString("username"));
            userinfo .setPassword(resultSet.getString("password"));
            //..
        }
        DbUtils.close(connection,statement,null);
        return userinfo ;
    }
}
