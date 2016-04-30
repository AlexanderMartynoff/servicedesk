package com.itsmtools.common.controller;


import com.itsmtools.common.dictionary.model.ComplexUa;
import com.itsmtools.common.service.security.Principal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggedController {

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public ComplexUa logged() {
        return ((Principal) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal()).getUa();
    }
}