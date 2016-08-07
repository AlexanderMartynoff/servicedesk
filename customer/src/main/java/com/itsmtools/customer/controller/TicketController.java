package com.itsmtools.customer.controller;


import com.itsmtools.common.dictionary.model.Ticket;
import com.itsmtools.common.dictionary.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class TicketController{
    @Autowired
    private TicketService service;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public Collection<?> list(@RequestParam MultiValueMap<String, String> multiParams){
        return service.list(multiParams.toSingleValueMap(), multiParams);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public void create(@RequestBody Ticket ticket){
        service.save(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/ticket", method = RequestMethod.PUT)
    public void update(@RequestBody Ticket ticket){
        service.update(ticket);
    }
}
