package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaContextFrontend;
import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.service.spec.UaSlaveService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaContextFrontendServiceImpl implements UaSlaveService<UaContextFrontend> {

    @Autowired
    Session session;

    @Override
    public Optional<UaContextFrontend> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaContextFrontend> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaContextFrontend.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaContextFrontend entity) {
        session.save(entity);
        session.flush();
    }

    @Override
    public void update(UaContextFrontend entity) {

    }

    @Override
    public List<UaContextFrontend> list() {
        return null;
    }
}
