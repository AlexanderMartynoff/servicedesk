package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.User;
import com.itsmtools.common.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class AccountController extends ApplicationController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/ua", method = RequestMethod.GET)
    public Collection<?> getListComplexUa() {
        return service.list();
    }

    @RequestMapping(value = "/ua", method = RequestMethod.POST)
    public Response createComplexUa(@RequestBody User complexUa) {
        service.save(complexUa);
        return empty();
    }

    @RequestMapping(value = "/ua", method = RequestMethod.PUT)
    public Response updateComplexUa(@RequestBody User complexUa) {
        service.update(complexUa);
        return empty();
    }
}
