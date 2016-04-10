package com.itsmtools.agent.controller;


import com.itsmtools.common.controller.ApplicationController;
import com.itsmtools.common.controller.response.Response;
import com.itsmtools.common.dictionary.model.Contractor;
import com.itsmtools.common.dictionary.service.spec.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


@RestController
public class ContractorController extends ApplicationController {

    @Autowired
    private ContractorService contractors;

    @RequestMapping("/contractor/list")
    public Collection<?> list() {
        return contractors.list();
    }

    @RequestMapping(value = "/contractor", method = RequestMethod.POST)
    public Response create(@RequestBody Contractor contractor) {
        contractors.save(contractor);
        return empty();
    }

    @RequestMapping(value = "/contractor", method = RequestMethod.PUT)
    public Response update(@RequestBody Contractor contractor) {
        contractors.update(contractor);
        return empty();
    }
}