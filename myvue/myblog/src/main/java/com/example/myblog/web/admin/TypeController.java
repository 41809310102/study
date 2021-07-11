package com.example.myblog.web.admin;

import com.example.myblog.po.Type;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    //分页，排序
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }



    @GetMapping("/types/inputtype")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/inputtype";
    }

    //添加分类
    @PostMapping("/types")
    public String post(@Valid Type type, RedirectAttributes attributes){// RedirectAttributes attributes
        Type type1 =   typeService.checck(type.getName());//查询是否存在重复分类
       if(type1!=null){
           attributes.addFlashAttribute("message","操作失败！当前存在该分类，请勿重复添加");
       }else{
           typeService.saveType(type);
           attributes.addFlashAttribute("message","操作成功！");
       }
       return "redirect:/admin/types";
    }

    //根据id,关联输入框
    @GetMapping("/types/{id}/input")
    public  String editinput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/inputtype";
    }

   //更新id关联的分类
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type,@PathVariable Long id, RedirectAttributes attributes) throws NotFoundException {// RedirectAttributes attributes
        Type type1 =   typeService.checck(type.getName());//查询是否存在重复分类
        if(type1!=null){
            attributes.addFlashAttribute("message","操作失败！当前存在该分类，请勿重复添加");
        }else{
            Type type2 = typeService.updateType(id,type);
            if(type2==null){
                attributes.addFlashAttribute("message","编辑失败！");
            }
            attributes.addFlashAttribute("message","编辑成功！");
        }
        return "redirect:/admin/types";
    }

    //删除分类
    @GetMapping("/types/{id}/delete")
    public  String delete(@PathVariable Long id,RedirectAttributes attributes) throws NotFoundException {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/types";
    }

}


