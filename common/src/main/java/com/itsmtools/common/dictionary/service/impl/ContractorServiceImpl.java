package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.Contractor;
import com.itsmtools.common.dictionary.service.spec.ContractorService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContractorServiceImpl implements ContractorService {

    @Autowired
    Session session;

    @Override
    public Contractor item(Integer id) {
        return null;
    }

    @Override
    public void save(Contractor entity) {

    }

    @Override
    public void update(Contractor entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Contractor> list() {
        return null;
    }
}