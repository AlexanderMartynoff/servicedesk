package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupAdmin;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UaGroupAdminService {

    @Autowired
    private Session session;

    public Optional<UaGroupAdmin> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<UaGroupAdmin> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupAdmin.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    public void save(UaGroupAdmin entity) {
        session.save(entity);
        session.flush();
    }

    public void update(UaGroupAdmin entity) {}

    public List<UaGroupAdmin> list() {
        return null;
    }
}
