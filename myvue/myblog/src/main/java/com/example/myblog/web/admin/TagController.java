package com.example.myblog.web.admin;

import com.example.myblog.po.Tag;

import com.example.myblog.po.Type;
import com.example.myblog.service.TagService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;
    @GetMapping("/tags")
    //分页，排序
    public String tags(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                Pageable pageable, Model model){
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/inputtags")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/inputtags";
    }


    //添加分类
    @PostMapping("/tags")
    public String post(@Valid Tag tag, RedirectAttributes attributes){// RedirectAttributes attributes
        Tag tag1 =  tagService.checck(tag.getName());//查询是否存在重复分类
        if(tag1!=null){
            attributes.addFlashAttribute("message","操作失败！当前存在该分类，请勿重复添加");
        }else{
            tagService.saveTag(tag);
            attributes.addFlashAttribute("message","操作成功！");
        }
        return "redirect:/admin/tags";
    }


    //根据id,关联输入框
    @GetMapping("/tags/{id}/input")
    public  String editinput(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/inputtags";
    }

    //更新id关联的分类
    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag,@PathVariable Long id, RedirectAttributes attributes) throws NotFoundException {// RedirectAttributes attributes
        Tag tag1 =   tagService.checck(tag.getName());//查询是否存在重复分类
        if(tag1!=null){
            attributes.addFlashAttribute("message","操作失败！当前存在该分类，请勿重复添加");
        }else{
            Tag tag2 = tagService.updateTag(id,tag);
            if(tag2 ==null){
                attributes.addFlashAttribute("message","编辑失败！");
            }
            attributes.addFlashAttribute("message","编辑成功！");
        }
        return "redirect:/admin/tags";
    }

    //删除分类
    @GetMapping("/tags/{id}/delete")
    public  String delete(@PathVariable Long id,RedirectAttributes attributes) throws NotFoundException {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/tags";
    }
}
