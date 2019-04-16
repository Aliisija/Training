package com.accenture.op.task_domain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/welcome")
    public String welcome(){
        return "index";
    }
}
