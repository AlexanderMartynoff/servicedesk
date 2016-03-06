package com.itsmtools.context.backend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.dictionary.model.Ticket;
import com.itsmtools.dictionary.service.spec.TicketService;
import com.itsmtools.service.jackson.ObjectMapperBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TicketController {

    @Autowired
    ObjectMapperBean mapper;

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id) throws JsonProcessingException {
        return mapper.writeValueAsString(ticketService.item(id));
    }

    @RequestMapping(value="/ticket/list", method = RequestMethod.GET)
    public String list() throws JsonProcessingException {
        return mapper.writeValueAsString(ticketService.list());
    }

    @RequestMapping(value="/ticket", method = RequestMethod.POST)
    public String create(@RequestBody Ticket data) throws JsonProcessingException {
        ticketService.save(data);
        return mapper.writeValueAsString(null);
    }

    @RequestMapping(value="/ticket", method = RequestMethod.PUT)
    public String update(@RequestBody Ticket ticket) throws JsonProcessingException {
        ticketService.update(ticket);
        return mapper.writeValueAsString(null);
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id) throws JsonProcessingException {
        ticketService.delete(id);
        return mapper.writeValueAsString(null);
    }
}