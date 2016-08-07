package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.dictionary.model.Service;
import com.itsmtools.common.dictionary.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/service", method = RequestMethod.POST)
    public void create(@RequestBody Service service) {
        this.service.save(service);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/service", method = RequestMethod.PUT)
    public void update(@RequestBody Service service) {
        this.service.update(service);
    }
}