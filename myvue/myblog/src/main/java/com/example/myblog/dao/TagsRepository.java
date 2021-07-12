package com.example.myblog.dao;

import com.example.myblog.po.Tag;

import com.example.myblog.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagsRepository extends JpaRepository<Tag, Long> {
        Tag findByname(String username);//查
        @Query("select  t from  Tag t")
        List<Tag> findTop(Pageable pageable);//查找topTYPE
}
