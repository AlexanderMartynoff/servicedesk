package com.itsmtools.common.controller;


import com.itsmtools.common.dictionary.model.TicketType;
import com.itsmtools.common.dictionary.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


@RestController
public class TicketTypeController extends ApplicationController {
    @Autowired
    TicketTypeRepository repository;

    @RequestMapping(path = "/ticket/type", method = RequestMethod.GET)
    public Collection<TicketType> list(@RequestParam MultiValueMap<String, String> multiParams){
        return repository.list(multiParams.toSingleValueMap(), multiParams);
    }
}