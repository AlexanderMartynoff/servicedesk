package com.itsmtools.context.backend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.itsmtools.service.jackson.ObjectMapperBean;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.itsmtools.dictionary.model.UserGroupCatalog;


@RestController
@RequestMapping("/backend")
public class UserGroupController {

    @Autowired
    private Session session;

    @Autowired
    ObjectMapperBean mapper;

    /**
     * Return groups list
     * @return String
     */
    @RequestMapping("user-group/list")
    public String get() throws JsonProcessingException {
        return mapper.writeValueAsString(session.createCriteria(UserGroupCatalog.class).list());
    }

    @RequestMapping(value = "user-group/update", method = RequestMethod.PUT)
    public String updateUserGroup(@RequestBody UserGroupCatalog requestUserGroup) throws JsonProcessingException {

        session.merge(requestUserGroup);
        session.flush();

        return mapper.writeValueAsString(new ArrayList<>());
    }
}
