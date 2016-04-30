package com.itsmtools.common.dictionary.service;


import com.itsmtools.common.dictionary.model.SupportLevel;
import com.itsmtools.common.dictionary.model.UaGlobal;
import com.itsmtools.common.dictionary.model.UaGroupManager;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UaGroupManagerService implements UserAccountService<UaGroupManager, UaGlobal> {

    @Autowired
    Session session;

    public Optional<UaGroupManager> get(Integer id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Optional<UaGroupManager> getByUaGlobal(UaGlobal uaGlobal) {
        return session.createCriteria(UaGroupManager.class)
            .add(Restrictions.eq("uaGlobal", uaGlobal))
            .list()
            .stream()
            .findFirst();
    }

    public void save(UaGroupManager entity) {
        session.save(entity);
        session.flush();
    }

    public void update(UaGroupManager entity) {
        UaGroupManager uaGroupManager = (UaGroupManager) session.get(UaGroupManager.class, entity.getId());
        uaGroupManager.setSupportLevels(entity.getSupportLevels());
        uaGroupManager.setEnable(entity.getEnable());

        session.save(uaGroupManager);
        session.flush();
    }

    public List<UaGroupManager> list() {
        return null;
    }
}
