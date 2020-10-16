package com.yjj.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2020/10/16
 * \* Time: 20:21
 * \
 */
@Controller
@RequestMapping("/admin")
public class BlogCont {
    @GetMapping("/blog_admin")
    public String blog_admin() {
        return "admin/blog_admin";
    }
}