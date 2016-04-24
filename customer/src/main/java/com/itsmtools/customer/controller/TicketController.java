package com.itsmtools.customer.controller;


import com.itsmtools.common.dictionary.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Map;


@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public Collection<?> list(@RequestParam Map<String, Object> params){
        return ticketService.list(params);
    }
}
