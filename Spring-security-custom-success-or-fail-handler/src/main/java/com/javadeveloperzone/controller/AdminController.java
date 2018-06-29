package com.javadeveloperzone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lenovo on 24-12-2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }
}
