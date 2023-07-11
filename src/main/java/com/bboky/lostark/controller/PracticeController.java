package com.bboky.lostark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice")
public class PracticeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("data", "test");
        model.addAttribute("data2", "<b>Hello!!</b>");
        return "test/practice/index";
    }
}
