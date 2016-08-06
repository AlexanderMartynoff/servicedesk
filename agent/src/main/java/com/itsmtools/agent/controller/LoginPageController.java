package com.itsmtools.agent.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginPageController {
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletResponse response) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return "login";
    }
}