package com.itsmtools.context.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.dictionary.model.UaGlobal;
import com.itsmtools.service.jackson.ObjectMapperBean;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UaController {

    @Autowired
    private static Session session;

    @Autowired
    ObjectMapperBean mapper;

    @RequestMapping(value = "/ua/global")
    public String get() throws JsonProcessingException {
        List list = session.createCriteria(UaGlobal.class).list();
        return mapper.writeValueAsString(list);
    }

    @RequestMapping(value = "/ua/groups/{id}")
    public String getUserGroupsByUaId(@PathVariable("id") Integer id) throws JsonProcessingException {
        return mapper.writeValueAsString(new ArrayList<>());
    }
}
