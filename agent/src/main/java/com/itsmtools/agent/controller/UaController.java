package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.ComplexUa;
import com.itsmtools.common.dictionary.service.UaComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class UaController extends ApplicationController {
    @Autowired
    private UaComplexService service;

    @RequestMapping(value = "/ua", method = RequestMethod.GET)
    public Collection<?> getListComplexUa() {
        return service.list();
    }

    @RequestMapping(value = "/ua", method = RequestMethod.POST)
    public Response createComplexUa(@RequestBody ComplexUa complexUa) {
        service.save(complexUa);
        return jsonOk();
    }

    @RequestMapping(value = "/ua", method = RequestMethod.PUT)
    public Response updateComplexUa(@RequestBody ComplexUa complexUa) {
        return jsonOk();
    }
}
