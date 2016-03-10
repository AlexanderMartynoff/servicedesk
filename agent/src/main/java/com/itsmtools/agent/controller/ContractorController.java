package com.itsmtools.agent.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.common.dictionary.service.spec.ContractorService;
import com.itsmtools.common.service.jackson.ObjectMapperBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContractorController {

    @Autowired
    private ContractorService contractors;

    @Autowired
    private ObjectMapperBean mapper;

    @RequestMapping("/contractor/list")
    public String list() throws JsonProcessingException {
        return mapper.writeValueAsString(contractors.list());
    }
}