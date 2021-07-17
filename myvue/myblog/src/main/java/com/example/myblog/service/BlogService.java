package com.example.myblog.service;

import com.example.myblog.po.Blog;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable,Blog blog);

    Page<Blog> listBlog(Pageable pageable);

    List<Blog> listBlogTop(Integer numbers);

    Page<Blog> listBlog(String query,Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog) throws NotFoundException;

    void  deleteBlog(Long id);

    void updateBlog1(Blog blog,Long id) throws NotFoundException;

    //将文本转化为HTML
    Blog getAndConvert(Long id) throws NotFoundException;


}
