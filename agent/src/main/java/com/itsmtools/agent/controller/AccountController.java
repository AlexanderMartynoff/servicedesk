package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.User;
import com.itsmtools.common.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
public class AccountController extends ApplicationController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Collection<?> getListComplexUa() {
        return service.list();
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public Response createComplexUa(@RequestBody User complexUa) {
        service.save(complexUa);
        return empty();
    }

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public Response updateComplexUa(@RequestBody User complexUa) {
        service.update(complexUa);
        return empty();
    }

    @RequestMapping(value = "/performer", method = RequestMethod.GET)
    public Collection<User> get() {
        return service.list()
            .stream()
            .filter(user -> user.getAgentPerformer() != null &&
                user.getAgentPerformer().getEnable() != null &&
                user.getAgentPerformer().getEnable())
            .collect(Collectors.toList());
    }
}
