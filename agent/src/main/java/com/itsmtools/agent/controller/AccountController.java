package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.dictionary.model.User;
import com.itsmtools.common.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
public class AccountController extends ApplicationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Collection<?> getListComplexUa() {
        return userService.list();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public void createComplexUa(@RequestBody User user) {
        userService.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public void updateComplexUa(@RequestBody User user) {
        userService.update(user);
    }

    @RequestMapping(value = "/performer", method = RequestMethod.GET)
    public Collection<User> get() {
        return userService.list()
            .stream()
            .filter(user -> user.getAgentPerformer() != null &&
                    user.getAgentPerformer().getEnable() != null &&
                    user.getAgentPerformer().getEnable())
            .collect(Collectors.toList());
    }
}
