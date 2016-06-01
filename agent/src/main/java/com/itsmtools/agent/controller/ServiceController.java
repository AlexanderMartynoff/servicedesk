package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.Service;
import com.itsmtools.common.dictionary.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class ServiceController extends ApplicationController {

    @Autowired
    private ServiceService service;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public Collection<Service> list(@RequestParam MultiValueMap<String, String> multiParams) {
        return service.list(multiParams.toSingleValueMap(), multiParams);
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