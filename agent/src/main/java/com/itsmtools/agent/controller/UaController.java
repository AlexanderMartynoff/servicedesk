package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.ComplexUa;
import com.itsmtools.common.dictionary.service.spec.UaComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class UaController extends ApplicationController {
    @Autowired
    private UaComplexService<ComplexUa> uaGlobalService;

    @RequestMapping(value = "/ua/global", method = RequestMethod.GET)
    public Collection<?> getListComplexUa() {
        return uaGlobalService.list();
    }

    @RequestMapping(value = "/ua/complex/create", method = RequestMethod.POST)
    public Response createComplexUa(@RequestBody ComplexUa complexUa) {
        uaGlobalService.save(complexUa);
        return jsonOk();
    }

    @RequestMapping(value = "/ua/complex/update", method = RequestMethod.PUT)
    public Response updateComplexUa(@RequestBody ComplexUa complexUa) {
        return jsonOk();
    }
}
