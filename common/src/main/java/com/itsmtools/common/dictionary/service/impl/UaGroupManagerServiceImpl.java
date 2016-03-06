package com.itsmtools.common.dictionary.service.impl;


import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupManager;
import com.itsmtools.common.dictionary.service.spec.BaseUaSlaveService;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UaGroupManagerServiceImpl implements BaseUaSlaveService<UaGroupManager> {

    @Autowired
    Session session;

    @Override
    public Optional<UaGroupManager> get(Integer id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Optional<UaGroupManager> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupManager.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    @Override
    public void save(UaGroupManager entity) {}

    @Override
    public void update(UaGroupManager entity) {}

    @Override
    public List<UaGroupManager> list() {
        return null;
    }
}
