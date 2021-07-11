package com.example.myblog.dao;

import com.example.myblog.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogReqository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {


}
