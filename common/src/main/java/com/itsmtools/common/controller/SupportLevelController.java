package com.itsmtools.common.controller;


import com.itsmtools.common.dictionary.model.SupportLevel;
import com.itsmtools.common.dictionary.service.SupportLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class SupportLevelController {

    @Autowired
    SupportLevelService service;

    @RequestMapping(value = "/support-level", method = RequestMethod.GET)
    public Collection<SupportLevel> list(@RequestParam Map<String, String> params){
        return service.list(params);
    }
}
