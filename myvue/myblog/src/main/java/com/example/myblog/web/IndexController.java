package com.example.myblog.web;

import com.example.myblog.po.Blog;
import com.example.myblog.service.BlogService;
import com.example.myblog.service.TagService;
import com.example.myblog.service.TypeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @GetMapping("/")
    public String index(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model){

        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(5));
        model.addAttribute("tags",tagService. ListTagTop(5));
        model.addAttribute("recommentBlogs",blogService.listBlogTop(6));//左侧
        model.addAttribute("recommentBlogs1",blogService.listBlogTop(3));//下侧
        return "index";
    }
    //搜索文章
    @PostMapping("/search")
    public String search(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                Pageable pageable, Model model, @RequestParam String query){

        if(pageable==null){
            return "seach1";
        }else {
            model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));

            model.addAttribute("query",query);

            return "search";
        }
    }

    //跳转到详情页面blog
  /*  @GetMapping("/blog")
    public String blog(){
       // model.addAttribute("blog",blogService.getBlog(id));
        return "blog";
    }*/
 //跳转到详情页面blog
     @GetMapping("/blog/{id}")
     public String blog(@PathVariable Long id, Model model,Blog blog) throws NotFoundException {
         blogService.updateBlog1(blog,id);
         System.out.println(blogService.getBlog(id).getViews());
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "/blog";
     }

     //跳转到作者界面
    @GetMapping("/me")
    public String meDesc() {
        return "/me";
    }
    //跳转到排行界面
    @GetMapping("/class")
    public String meclass() {
        return "/class";
    }
    }
