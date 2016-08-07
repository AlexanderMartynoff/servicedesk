package com.itsmtools.agent.controller;


import com.itsmtools.common.dictionary.model.Ticket;
import com.itsmtools.common.dictionary.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public Ticket get(@PathVariable("id") final Integer id) {
        return ticketService.item(id);
    }

    @RequestMapping(value="/ticket", method = RequestMethod.GET)
    public Collection<?> list(@RequestParam MultiValueMap<String, String> multiParams) {
        return ticketService.list(multiParams.toSingleValueMap(), multiParams);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/ticket", method = RequestMethod.POST)
    public void create(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/ticket", method = RequestMethod.PUT)
    public void update(@RequestBody Ticket ticket) {
        ticketService.update(ticket);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") final int id) {
        ticketService.delete(id);
    }
}