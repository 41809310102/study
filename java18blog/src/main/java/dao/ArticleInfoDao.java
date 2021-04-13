package dao;

import models.ArticleInfo;
import models.vo.ArticleInfoVO;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleInfoDao {

    // 使用 uid 查询文章
    public List<ArticleInfo> getListByUID(int uid) throws SQLException {
        List<ArticleInfo> list = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        String sql = "select * from articleinfo where uid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, uid);
        // 查询数据库并返回结果
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setId(resultSet.getInt("id"));
            articleInfo.setRcount(resultSet.getInt("rcount"));
            articleInfo.setTitle(resultSet.getString("title"));
            articleInfo.setContent(resultSet.getString("Content"));
            articleInfo.setCreatetime(resultSet.getDate("createtime"));
            list.add(articleInfo);
        }
        // 数据库的关闭
        DBUtils.close(connection, statement, resultSet);
        return list;
    }

    // 文章删除
    public int del(int id) throws SQLException {
        int result = 0;
        if (id > 0) {
            Connection connection = DBUtils.getConnection();
            String sql = "delete from articleinfo where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            // 执行数据库的删除
            result = statement.executeUpdate();
            // 关闭数据库
            DBUtils.close(connection, statement, null);
        }
        return result;
    }

    // 根据文章id查询文章详情
    public ArticleInfoVO getArtById(int id) throws SQLException {
        ArticleInfoVO articleInfo = new ArticleInfoVO();
        if (id > 0) {
            Connection connection = DBUtils.getConnection();
            String sql = "select a.*,u.username from articleinfo a left join userinfo u on a.uid=u.id where a.id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                articleInfo.setId(resultSet.getInt("id"));
                articleInfo.setTitle(resultSet.getString("title"));
                articleInfo.setContent(resultSet.getString("content"));
                articleInfo.setUsername(resultSet.getString("username"));
                articleInfo.setCreatetime(resultSet.getDate("createtime"));
                articleInfo.setRcount(resultSet.getInt("rcount"));
            }
            DBUtils.close(connection, statement, resultSet);
        }
        return articleInfo;
    }

    // 文章修改
    public int upArt(int id, String title, String content) throws SQLException {
        int result = 0;
        Connection connection = DBUtils.getConnection();
        String sql = "update articleinfo set title=?,content=? where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        statement.setString(2, content);
        statement.setInt(3, id);
        result = statement.executeUpdate();
        DBUtils.close(connection, statement, null);
        return result;
    }

    // 文章新增
    public int add(String title, String content, int uid) throws SQLException {
        int result = 0;
        Connection connection = DBUtils.getConnection();
        String sql = "insert into articleinfo(title,content,uid) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        statement.setString(2, content);
        statement.setInt(3, uid);
        result = statement.executeUpdate();
        DBUtils.close(connection, statement, null);
        return result;
    }

    // 查询所有文章（没有分页）
    public List<ArticleInfoVO> getList() throws SQLException {
        List<ArticleInfoVO> list = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        String sql = "select a.*,u.username from articleinfo a left join userinfo u on a.uid=u.id";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 执行数据库查询
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ArticleInfoVO vo = new ArticleInfoVO();
            vo.setId(resultSet.getInt("id"));
            vo.setTitle(resultSet.getString("title"));
            vo.setCreatetime(resultSet.getDate("createtime"));
            vo.setRcount(resultSet.getInt("rcount"));
            vo.setUsername(resultSet.getString("username"));
            list.add(vo);
        }
        DBUtils.close(connection, statement, resultSet);
        return list;
    }

    // 分页方法
    public List<ArticleInfoVO> getListByPage(int page, int psize) throws SQLException {
        List<ArticleInfoVO> list = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        String sql = "select a.*,u.username from articleinfo a left join userinfo u on a.uid=u.id limit ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 公式：(n-1)*pagesize
        statement.setInt(1, (page - 1) * psize);
        statement.setInt(2, psize);
        // 执行数据库查询
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ArticleInfoVO vo = new ArticleInfoVO();
            vo.setId(resultSet.getInt("id"));
            vo.setTitle(resultSet.getString("title"));
            vo.setCreatetime(resultSet.getDate("createtime"));
            vo.setRcount(resultSet.getInt("rcount"));
            vo.setUsername(resultSet.getString("username"));
            list.add(vo);
        }
        DBUtils.close(connection, statement, resultSet);
        return list;
    }

    // 阅读量+1
    public int upRcount(int id) throws SQLException {
        int result = 0;
        Connection connection = DBUtils.getConnection();
        String sql = "update articleinfo set rcount=rcount+1 where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        result = statement.executeUpdate();
        return result;
    }
}