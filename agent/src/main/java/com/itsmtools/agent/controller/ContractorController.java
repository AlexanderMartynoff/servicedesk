package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.dictionary.model.Contractor;
import com.itsmtools.common.dictionary.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class ContractorController extends ApplicationController {

    @Autowired
    private ContractorService contractors;

    @RequestMapping("/contractor")
    public Collection<?> list() {
        return contractors.list();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/contractor", method = RequestMethod.POST)
    public void create(@RequestBody Contractor contractor) {
        contractors.save(contractor);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/contractor", method = RequestMethod.PUT)
    public void update(@RequestBody Contractor contractor) {
        contractors.update(contractor);
    }
}
