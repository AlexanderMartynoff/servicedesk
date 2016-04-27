package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.UaContextBackend;
import com.itsmtools.common.dictionary.model.UaGlobal;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UaContextBackendService implements UserAccountService<UaContextBackend, UaGlobal> {

    @Autowired
    private Session session;

    public Optional<UaContextBackend> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<UaContextBackend> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaContextBackend.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    public void save(UaContextBackend entity) {
        session.save(entity);
        session.flush();
    }

    public void update(UaContextBackend entity) {
        UaContextBackend ua = (UaContextBackend) session.get(UaContextBackend.class, entity.getId());
        ua.setEnable(entity.getEnable());
        ua.setPosition(entity.getPosition());
        session.save(ua);
        session.flush();
    }

    public List<UaContextBackend> list() {
        return null;
    }
}
