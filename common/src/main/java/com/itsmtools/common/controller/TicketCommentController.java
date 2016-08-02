package com.itsmtools.common.controller;


import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.TicketComment;
import com.itsmtools.common.dictionary.repository.TicketCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class TicketCommentController extends ApplicationController {
    @Autowired
    TicketCommentRepository repository;

    @RequestMapping(path = "/ticket/comment", method = RequestMethod.GET)
    public Collection<TicketComment> list(@RequestParam MultiValueMap<String, String> multiParams){
        return repository.list(multiParams.toSingleValueMap(), multiParams);
    }

    @RequestMapping(path = "/ticket/comment", method = RequestMethod.POST)
    public Response create(@RequestBody TicketComment input){
        repository.create(input);
        return empty();
    }

    @RequestMapping(path = "/ticket/comment", method = RequestMethod.PUT)
    public Response update(@RequestBody TicketComment input){
        repository.update(input);
        return empty();
    }
}