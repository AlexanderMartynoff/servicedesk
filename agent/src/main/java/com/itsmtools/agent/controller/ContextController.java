package com.itsmtools.agent.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.common.dictionary.model.ContextCatalog;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


@RestController
public class ContextController {

    @Autowired
    private Session session;

    @RequestMapping("/context")
    public Collection<?> list() throws JsonProcessingException {

        // TODO - use enum almost ContextCatalog
        return session.createCriteria(ContextCatalog.class).list();
    }
}