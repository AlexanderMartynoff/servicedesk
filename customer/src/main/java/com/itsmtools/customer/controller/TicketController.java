package com.itsmtools.customer.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.Ticket;
import com.itsmtools.common.dictionary.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class TicketController extends ApplicationController{
    @Autowired
    TicketService service;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public Collection<?> list(@RequestParam MultiValueMap<String, String> multiParams){
        return service.list(multiParams.toSingleValueMap(), multiParams);
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public Response create(@RequestBody Ticket ticket){
        service.save(ticket);
        return empty();
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.PUT)
    public Response update(@RequestBody Ticket ticket){
        service.update(ticket);
        return empty();
    }
}
