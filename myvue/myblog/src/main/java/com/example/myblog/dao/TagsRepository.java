package com.example.myblog.dao;

import com.example.myblog.po.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tag, Long> {
        Tag findByname(String username);//查
}
