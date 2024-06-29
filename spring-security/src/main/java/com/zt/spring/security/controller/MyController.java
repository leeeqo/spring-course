package com.zt.spring.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String infoForAllEmployees() {
        return "info-for-all-view";
    }

    @GetMapping("/hr_info")
    public String infoForHR() {
        return "info-for-hr-view";
    }

    @GetMapping("/managers_info")
    public String infoForManagers() {
        return "info-for-managers-view";
    }
}
