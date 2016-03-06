package com.itsmtools.agent.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.common.dictionary.dto.ComplexUa;
import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.service.spec.BaseUaMasterService;
import com.itsmtools.common.service.jackson.ObjectMapperBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
public class UaController {
    @Autowired
    ObjectMapperBean mapper;
    @Autowired
    BaseUaMasterService<UaGlobal, ComplexUa> uaGlobalService;

    @RequestMapping(value = "/ua/global", method = RequestMethod.GET)
    public String get() throws JsonProcessingException {
        return mapper.writeValueAsString(uaGlobalService.listComplex());
    }

    @RequestMapping(value = "/ua/groups/{id}")
    public String getUserGroupsByUaId(@PathVariable("id") Integer id) throws JsonProcessingException {
        return mapper.writeValueAsString(new ArrayList<>());
    }
}
