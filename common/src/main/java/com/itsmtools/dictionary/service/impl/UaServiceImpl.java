package com.itsmtools.dictionary.service.impl;


import com.itsmtools.dictionary.dto.UaComplex;
import com.itsmtools.dictionary.model.UaGlobal;
import com.itsmtools.dictionary.service.spec.UaService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaServiceImpl implements UaService{

    @Autowired
    Session session;

    @Override
    public Optional<UaGlobal> item(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaGlobal> getByUsername(String login) {
        return (Optional<UaGlobal>)session.createCriteria(UaGlobal.class)
            .add(Restrictions.eq("login", login))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaGlobal entity) {

    }

    @Override
    public void update(UaGlobal entity) {

    }

    @Override
    public List<UaGlobal> fetch() {
        return null;
    }
}
