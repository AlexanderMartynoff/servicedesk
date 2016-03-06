package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaContextBackend;
import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaContextBackendServiceImpl implements BaseUaSlaveService<UaContextBackend> {

    @Autowired
    Session session;

    @Override
    public Optional<UaContextBackend> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaContextBackend> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaContextBackend.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaContextBackend entity) {

    }

    @Override
    public void update(UaContextBackend entity) {

    }

    @Override
    public List<UaContextBackend> list() {
        return null;
    }
}
