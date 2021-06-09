package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface  UserDao {
   public User getUserByMassage(@Param("username") String username, @Param("password") String password);
   public List<User> getAllUser(@Param("username") String username,@Param("pageStart") int pageStart,@Param("pageSize") int pageSize);
   public int getUserCounts(@Param("username") String username);
   public int updateState(Integer id,boolean state);
   public int addUser(User user);
   public int deleteUser(int id);
   public User getUpdateUser(int id);
   public int editUser(User user);
}
