package com.example.myblog.dao;


import com.example.myblog.po.Type;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByname(String username);//查

    @Query("select  t from Type t")
    List<Type> findTop(Pageable pageable);//查找topTYPE
}
