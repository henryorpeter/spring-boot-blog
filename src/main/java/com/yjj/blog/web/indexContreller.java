package com.yjj.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class indexContreller {

    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id,@PathVariable String name) {
        System.out.println("--------index--------");
        int i=7/0;
        return "index";
    }
}
