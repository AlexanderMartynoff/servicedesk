package com.itsmtools.agent.controller;


import com.itsmtools.common.service.security.Principal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        Principal principal = (Principal)SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();

        return new ModelAndView("index")
            .addObject("principal", principal);
    }
}