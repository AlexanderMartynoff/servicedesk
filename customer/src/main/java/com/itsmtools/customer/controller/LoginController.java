package com.itsmtools.customer.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {
    @RequestMapping("/login")
    public String index(HttpServletResponse response){
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return "login";
    }
}
