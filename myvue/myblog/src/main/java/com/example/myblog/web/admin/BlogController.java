package com.example.myblog.web.admin;

import com.example.myblog.po.Blog;
import com.example.myblog.po.User;
import com.example.myblog.service.BlogService;
import com.example.myblog.service.TagService;
import com.example.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
   /* @GetMapping("/blogadmin")
    public String list(@PageableDefault(size = 8,sort = {"id"},direction = Sort.Direction.DESC)
                                   Pageable pageable,
                                   Blog blog, Model model) {
        //model.addAttribute("types",typeService.listType());
       // System.out.println(model.addAttribute("types",typeService.listType()));
       model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogadmin";
    }*/
    @GetMapping("/blogadmin")
    public String tags(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                   Blog blog,  Pageable pageable, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogadmin";
    }

    @GetMapping("/blogadmin/search")
    public String searsh(@PageableDefault(size = 8,sort = {"id"},direction = Sort.Direction.DESC)Pageable pageable,
                        Blog blog,  Model model) {
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogadmin :: blogList";
    }
//访问博客编辑页面,初始化
    @GetMapping("/inputblog")
    public String inputblog(Model model) {
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        model.addAttribute("blog",new Blog());
        return "admin/inputblog";
    }

    //访问博客编辑页面,初始化,修改博客
    @GetMapping("/blogadmin/{id}/input")
    public String list2(Model model,@PathVariable Long id) {
        Blog blog = blogService.getBlog(id);
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        blog.init();
        model.addAttribute("blog",blog);
        return "admin/inputblog";
    }


//编辑博客后提交
    @PostMapping("/inputblog")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes){
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.ListTag(blog.getTagids()));//保存标签
        blog.setUser((User) session.getAttribute("user"));
        Blog s = blogService.saveBlog(blog);
     if(s==null){
         attributes.addFlashAttribute("message","发布失败！");
     }else{
         attributes.addFlashAttribute("message","发布成功！");
     }
        return "/admin/index";
    }

}
