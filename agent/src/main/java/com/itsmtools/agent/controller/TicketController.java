package com.itsmtools.agent.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.Ticket;
import com.itsmtools.common.dictionary.service.spec.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class TicketController extends ApplicationController {

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public Ticket get(@PathVariable("id") Integer id) {
        return ticketService.item(id);
    }

    @RequestMapping(value="/ticket/list", method = RequestMethod.GET)
    public Collection<?> list() {
        return ticketService.list();
    }

    @RequestMapping(value="/ticket", method = RequestMethod.POST)
    public Response create(@RequestBody Ticket data) throws JsonProcessingException {
        ticketService.save(data);
        return empty();
    }

    @RequestMapping(value="/ticket", method = RequestMethod.PUT)
    public Response update(@RequestBody Ticket ticket) {
        ticketService.update(ticket);
        return empty();
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") int id) {
        ticketService.delete(id);
        return empty();
    }
}