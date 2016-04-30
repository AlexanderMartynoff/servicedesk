package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupAdmin;
import com.itsmtools.common.dictionary.model.UaGroupOperator;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UaGroupOperatorService implements UserAccountService<UaGroupOperator, UaGlobal> {

    @Autowired
    Session session;

    public Optional<UaGroupOperator> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<UaGroupOperator> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupOperator.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    public void save(UaGroupOperator entity) {
        session.save(entity);
        session.flush();
    }

    public void update(UaGroupOperator entity) {
        UaGroupOperator uaGroupOperator = (UaGroupOperator) session.get(UaGroupOperator.class, entity.getId());
        uaGroupOperator.setEnable(entity.getEnable());

        session.save(uaGroupOperator);
        session.flush();
    }

    public List<UaGroupOperator> list() {
        return null;
    }
}
