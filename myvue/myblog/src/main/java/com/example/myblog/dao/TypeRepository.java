package com.example.myblog.dao;


import com.example.myblog.po.Type;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByname(String username);//查
}
