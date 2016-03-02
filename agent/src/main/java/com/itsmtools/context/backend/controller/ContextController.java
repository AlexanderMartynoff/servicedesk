package com.itsmtools.context.backend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.dictionary.model.ContextCatalog;
import com.itsmtools.service.jackson.ObjectMapperBean;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class ContextController {

    @Autowired
    private Session session;

    @Autowired
    private ObjectMapperBean mapper;

    @RequestMapping("/context")
    public String list() throws JsonProcessingException {
        List list = session.createCriteria(ContextCatalog.class).list();
        return mapper.writeValueAsString(list);
    }
}