package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.Service;
import com.itsmtools.common.dictionary.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    ServiceRepository repository;

    public Service item(Integer id) {
        return repository.get(id);
    }

    public void save(Service input) {
        repository.create(input);
    }

    public void update(Service input) {
        repository.update(input);
    }

    public List<Service> list(Map<String, String> filter) {
        return repository.list(filter);
    }
}
