package com.yjj.blog.web.admin;

import com.yjj.blog.po.Type;
import com.yjj.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2020/10/20
 * \* Time: 20:37
 * \
 */
@Controller
@RequestMapping("/admin")
public class TypeCont {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "/admin/types_input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "/admin/types_input";
    }

    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result,RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if (t != null){
            result.rejectValue("name","nameError","不能重复添加分类名称");
        }
        if (result.hasErrors()){
            return "/admin/types_input";
        }
        Type type1 = typeService.saveType(type);
        if (type1 == null){
            //新增失败时
            attributes.addFlashAttribute("message","新增失败了");
        }else {
            //新增成功时
            attributes.addFlashAttribute("message","新增成功了");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,@PathVariable Long id,RedirectAttributes attributes){
        Type t = typeService.getTypeByName(type.getName());
        if (t != null){
            result.rejectValue("name","nameError","不能重复添加分类名称");
        }
        if (result.hasErrors()){
            return "/admin/types_input";
        }
        Type type1 = typeService.updateType(id,type);
        if (type1 == null){
            //新增失败时
            attributes.addFlashAttribute("message","更新失败了");
        }else {
            //新增成功时
            attributes.addFlashAttribute("message","更新成功了");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";

    }
}