package com.itsmtools.agent.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.common.dictionary.dto.ComplexUa;
import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.service.spec.BaseUaMasterService;
import com.itsmtools.common.service.jackson.ObjectMapperBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UaController {
    @Autowired
    private ObjectMapperBean mapper;
    @Autowired
    private BaseUaMasterService<UaGlobal, ComplexUa> uaGlobalService;

    @RequestMapping(value = "/ua/global", method = RequestMethod.GET)
    public String getListComplexUa() throws JsonProcessingException {
        return mapper.writeValueAsString(uaGlobalService.listComplex());
    }

    @RequestMapping(value = "/ua/complex/create", method = RequestMethod.POST)
    public String createComplexUa(@RequestBody ComplexUa complexUa) throws JsonProcessingException {
        uaGlobalService.saveByComplexUa(complexUa);
        return mapper.writeValueAsString(null);
    }

    @RequestMapping(value = "/ua/complex/update", method = RequestMethod.PUT)
    public String updateComplexUa(@RequestBody ComplexUa complexUa) throws JsonProcessingException {
        uaGlobalService.updateByComplexUa(complexUa);
        return mapper.writeValueAsString(null);
    }
}
