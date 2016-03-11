package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.service.spec.PerformerService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PerformerServiceImpl implements PerformerService {

    @Autowired
    Session session;

    @Override
    public UaGlobal item(Integer id) {
        return null;
    }

    @Override
    public void save(UaGlobal entity) {}

    @Override
    public void update(UaGlobal entity) {}

    @Override
    public void delete(Integer id) {
        Optional.ofNullable(session.get(UaGlobal.class, id)).ifPresent((i) -> {
            session.delete(i);
            session.flush();
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UaGlobal> list() {
        return (List<UaGlobal>) session.createCriteria(UaGlobal.class).list();
    }
}