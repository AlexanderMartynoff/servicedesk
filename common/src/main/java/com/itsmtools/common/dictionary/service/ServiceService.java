package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.ItService;
import com.itsmtools.common.dictionary.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class ServiceService {

    @Autowired
    ServiceRepository repository;

    public ItService item(Integer id) {
        return repository.get(id);
    }

    public void save(ItService input) {
        repository.create(input);
    }

    public void update(ItService input) {
        repository.update(input);
    }

    public List<ItService> list(Map<String, String> filter) {
        return repository.list(filter);
    }
}
