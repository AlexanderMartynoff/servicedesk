package com.itsmtools.agent.controller;

import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.dictionary.model.Knowledge;
import com.itsmtools.common.dictionary.repository.KnowledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
public class KnowledgeController extends ApplicationController {

    @Autowired
    private KnowledgeRepository repository;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/knowledge", method = RequestMethod.POST)
    public void create(@RequestBody Knowledge knowledge) {
        repository.create(knowledge);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/knowledge", method = RequestMethod.PUT)
    public void update(@RequestBody Knowledge knowledge) {
        repository.update(knowledge);
    }

    @RequestMapping(value = "/knowledge", method = RequestMethod.GET)
    public Collection<?> list(@RequestParam MultiValueMap<String, String> multiParams) {
        return repository.list(multiParams.toSingleValueMap(), multiParams);
    }
}