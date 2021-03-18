import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //
        Class.forName("com.mysql.jdbc.Driver");

        //获取链接
        String url ="jdbc:mysql://127.0.0.1:3306/test0311?useSSL=false";//jdbc表示协议/localhost确定主机地址/3306确定一个软件的进入口/test0311是数据库
        String  username="root";
        String password="318422";
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        Connection connection = dataSource.getConnection();
        //Connection connection = DriverManager.getConnection(url,username,password);

        //MysqlDataSource不具备池的概念

        //执行sql语句
       String sql = "update  user  set name=? where id=?";

        //String sql = "select*from user where name=? and password=?";
        //  Statement statement= connection.createStatement();
        PreparedStatement preparedStatement =  connection.prepareStatement(sql);
        preparedStatement.setString(1,"张振柯");
        preparedStatement.setInt(2,2);
        System.out.println("sql:"+preparedStatement.toString());
        int ret = preparedStatement.executeUpdate();
        if(ret!=0){
            System.out.println("修改成功！");
        }

        preparedStatement.close();
        connection.close();
    }
}