package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface  UserDao {
   public User getUserByMassage(@Param("username") String username, @Param("password") String password);
}
