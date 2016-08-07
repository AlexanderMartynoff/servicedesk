package com.itsmtools.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {
    @RequestMapping("/login")
    public String index(HttpServletResponse response){
        response.setStatus(401);
        return "login";
    }
}
