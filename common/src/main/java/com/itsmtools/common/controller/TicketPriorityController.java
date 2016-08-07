package com.itsmtools.common.controller;


import com.itsmtools.common.dictionary.model.TicketPriority;
import com.itsmtools.common.dictionary.repository.TicketPriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


@RestController
public class TicketPriorityController {
    @Autowired
    private TicketPriorityRepository repository;

    @RequestMapping(path = "/ticket/priority", method = RequestMethod.GET)
    public Collection<TicketPriority> list(@RequestParam MultiValueMap<String, String> multiParams){
        return repository.list(multiParams.toSingleValueMap(), multiParams);
    }
}
