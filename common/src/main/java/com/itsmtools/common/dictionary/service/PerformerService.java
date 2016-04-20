package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaGlobal;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PerformerService {

    @Autowired
    Session session;

    public UaGlobal item(Integer id) {
        return null;
    }

    public void save(UaGlobal entity) {}

    public void update(UaGlobal entity) {}

    public void delete(Integer id) {
        Optional.ofNullable(session.get(UaGlobal.class, id)).ifPresent((i) -> {
            session.delete(i);
            session.flush();
        });
    }

    @SuppressWarnings("unchecked")
    public List<UaGlobal> list() {
        return (List<UaGlobal>) session.createCriteria(UaGlobal.class).list();
    }
}