package com.example.myblog.dao;

import com.example.myblog.po.Blog;
import com.example.myblog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogReqository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select  b from  Blog b where b.recommend=true")
    List<Blog> findTop(Pageable pageable);//查找topTYPE

    @Query("select  b from  Blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> finfQuery(String query,Pageable pageable);//搜索文章
}
