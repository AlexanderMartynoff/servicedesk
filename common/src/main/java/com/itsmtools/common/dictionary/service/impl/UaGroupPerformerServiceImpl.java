package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupPerformer;
import com.itsmtools.common.dictionary.service.spec.UaSlaveService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaGroupPerformerServiceImpl implements UaSlaveService<UaGroupPerformer> {

    @Autowired
    Session session;

    @Override
    public Optional<UaGroupPerformer> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaGroupPerformer> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupPerformer.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaGroupPerformer entity) {
        session.save(entity);
        session.flush();
    }

    @Override
    public void update(UaGroupPerformer entity) {}

    @Override
    public List<UaGroupPerformer> list() {
        return null;
    }
}
