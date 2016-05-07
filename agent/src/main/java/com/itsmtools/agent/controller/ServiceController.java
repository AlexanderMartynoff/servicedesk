package com.itsmtools.agent.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class ServiceController {

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String list() {
        return null;
    }
}