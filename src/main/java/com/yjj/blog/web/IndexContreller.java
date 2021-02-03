package com.yjj.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexContreller {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/blogs")
    public String blogs() {
        return "blogs";
    }
}