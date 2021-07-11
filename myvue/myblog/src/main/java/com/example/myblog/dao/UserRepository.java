package com.example.myblog.dao;

import com.example.myblog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsernameAndPassword(String username,String passwrod);//查
}