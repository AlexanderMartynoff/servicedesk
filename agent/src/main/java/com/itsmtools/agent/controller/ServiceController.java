package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.Service;
import com.itsmtools.common.dictionary.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;


@RestController
public class ServiceController extends ApplicationController {

    @Autowired
    private ServiceService service;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public Collection<Service> list(@RequestParam Map<String, String> params) {
        return service.list(params);
    }

    @RequestMapping(value = "/service", method = RequestMethod.POST)
    public Response create(@RequestBody Service service) {
        this.service.save(service);
        return empty();
    }

    @RequestMapping(value = "/service", method = RequestMethod.PUT)
    public Response update(@RequestBody Service service) {
        this.service.update(service);
        return empty();
    }
}