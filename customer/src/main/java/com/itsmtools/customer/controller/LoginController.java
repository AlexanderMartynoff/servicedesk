package com.itsmtools.customer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    @RequestMapping("/login")
    public String index(){
        return "login";
    }
}
