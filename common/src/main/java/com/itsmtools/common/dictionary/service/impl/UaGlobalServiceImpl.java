package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.service.spec.BaseUaMasterService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaGlobalServiceImpl implements BaseUaMasterService<UaGlobal> {

    @Autowired
    Session session;

    @Override
    public Optional<UaGlobal> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaGlobal> getByLogin(String login) {
        return session.createCriteria(UaGlobal.class)
            .add(Restrictions.eq("login", login))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaGlobal entity) {}

    @Override
    public void update(UaGlobal entity) {}

    @Override
    public List<UaGlobal> list() {
        return null;
    }
}
