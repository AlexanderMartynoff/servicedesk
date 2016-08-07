package com.itsmtools.common.controller;


import com.itsmtools.common.dictionary.model.TicketComment;
import com.itsmtools.common.dictionary.repository.TicketCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class TicketCommentController {
    @Autowired
    private TicketCommentRepository repository;

    @RequestMapping(path = "/ticket/comment", method = RequestMethod.GET)
    public Collection<TicketComment> list(@RequestParam MultiValueMap<String, String> multiParams){
        return repository.list(multiParams.toSingleValueMap(), multiParams);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/ticket/comment", method = RequestMethod.POST)
    public void create(@RequestBody TicketComment input){
        repository.create(input);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/ticket/comment", method = RequestMethod.PUT)
    public void update(@RequestBody TicketComment input){
        repository.update(input);
    }
}