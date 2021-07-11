package com.example.myblog.service;

import com.example.myblog.dao.BlogReqository;
import com.example.myblog.po.Blog;
import com.example.myblog.po.Type;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServicelmi implements  BlogService{
    @Autowired
    private BlogReqository blogReqository;
    @Override
    public Blog getBlog(Long id) {
        return blogReqository.findById(id).get();
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable,Blog blog) {

           return blogReqository.findAll(pageable);
    }

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if(blog.getId()==null){
            blog.setViews(0);//浏览记录
            blog.setCreatetime(new Date());//创建时间
            blog.setUpdatetime(new Date());//修改时间
        }else{
            blog.setUpdatetime(new Date());//修改时间
        }

        return blogReqository.save(blog);
    }
    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) throws NotFoundException {
        Blog blog1 = blogReqository.getById(id);
        if(blog1==null){
            throw new NotFoundException("没有找到该信息！");
        }
        BeanUtils.copyProperties(blog,blog1);
        return blogReqository.save(blog1);
    }
    @Transactional
    @Override
    public void  deleteBlog(Long id) {
        blogReqository.deleteById(id);
    }
}
