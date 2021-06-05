package utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class DbUtils {
    private static MysqlDataSource dataSource = null;

    /**
     * 得到 Connection 的通用方法
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            // 第一次调用
            dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/Myblog?charactionEncoding=utf-8&useSSL=true");
            dataSource.setUser("root");
            // [设置你自己的密码]
            dataSource.setPassword("318422");
        }
        return dataSource.getConnection();
    }

    /**
     * 通用的关闭方法
     * @param connection
     * @param statement
     * @param resultSet
     * @throws SQLException
     */
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }

}
