package com.itsmtools.customer.controller;


import com.itsmtools.common.dictionary.service.spec.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/ticket/list")
    public Collection<?> list(){
        return ticketService.list();
    }
}
