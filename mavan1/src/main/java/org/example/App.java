package org.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        String url ="jdbc:mysql://127.0.0.1:3306/test0311?&useSSL=false";//jdbc表示协议/localhost确定主机地址/3306确定一个软件的进入口/test0311是数据库
        String  username="root";
        String password="318422";
        Connection connection = DriverManager.getConnection(url,username,password);
        //执行sql语句

        String sql = "select*from user where id = 2";
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    }
}
